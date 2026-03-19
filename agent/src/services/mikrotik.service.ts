import crypto from "node:crypto";
import net from "node:net";
import tls from "node:tls";
import { TaskQueue } from "./jobQueue.js";
import type { MikrotikCommand, RouterConfig } from "../types.js";

type ApiResult = Record<string, string>;

function parseAttrs(sentence: string[]): Record<string, string> {
  const attrs: Record<string, string> = {};
  for (const word of sentence) {
    if (!word.startsWith("=")) continue;
    const idx = word.indexOf("=", 1);
    if (idx <= 0) continue;
    attrs[word.substring(1, idx)] = word.substring(idx + 1);
  }
  return attrs;
}

function argsToRestBody(args?: string[]): Record<string, string> | undefined {
  if (!args || args.length === 0) return undefined;
  const body: Record<string, string> = {};
  for (const arg of args) {
    if (!arg.startsWith("=")) continue;
    const idx = arg.indexOf("=", 1);
    if (idx <= 0) continue;
    body[arg.substring(1, idx)] = arg.substring(idx + 1);
  }
  return Object.keys(body).length > 0 ? body : undefined;
}

function restMethod(command: string): "GET" | "PUT" | "PATCH" | "DELETE" {
  if (command.endsWith("/add")) return "PUT";
  if (command.endsWith("/set")) return "PATCH";
  if (command.endsWith("/remove")) return "DELETE";
  return "GET";
}

class RouterApiConnection {
  private socket: net.Socket | tls.TLSSocket | null = null;
  private readBuffer = Buffer.alloc(0);

  constructor(private readonly config: RouterConfig) {}

  private encodeLength(length: number): Buffer {
    if (length < 0x80) return Buffer.from([length]);
    if (length < 0x4000) return Buffer.from([((length >> 8) & 0x3f) | 0x80, length & 0xff]);
    if (length < 0x200000) return Buffer.from([((length >> 16) & 0x1f) | 0xc0, (length >> 8) & 0xff, length & 0xff]);
    if (length < 0x10000000) {
      return Buffer.from([((length >> 24) & 0x0f) | 0xe0, (length >> 16) & 0xff, (length >> 8) & 0xff, length & 0xff]);
    }
    return Buffer.from([0xf0, (length >> 24) & 0xff, (length >> 16) & 0xff, (length >> 8) & 0xff, length & 0xff]);
  }

  private async readLength(): Promise<number> {
    const b = (await this.readExact(1))[0];
    if (b < 0x80) return b;
    if ((b & 0xc0) === 0x80) {
      const b2 = (await this.readExact(1))[0];
      return ((b & 0x3f) << 8) | b2;
    }
    if ((b & 0xe0) === 0xc0) {
      const rest = await this.readExact(2);
      return ((b & 0x1f) << 16) | (rest[0] << 8) | rest[1];
    }
    if ((b & 0xf0) === 0xe0) {
      const rest = await this.readExact(3);
      return ((b & 0x0f) << 24) | (rest[0] << 16) | (rest[1] << 8) | rest[2];
    }
    const rest = await this.readExact(4);
    return (rest[0] << 24) | (rest[1] << 16) | (rest[2] << 8) | rest[3];
  }

  private async readExact(bytes: number): Promise<Buffer> {
    while (this.readBuffer.length < bytes) {
      if (!this.socket || this.socket.destroyed) {
        throw new Error("تم إغلاق اتصال RouterOS");
      }
      const socket = this.socket;
      const chunk = await new Promise<Buffer>((resolve, reject) => {
        const onData = (data: Buffer) => {
          cleanup();
          resolve(data);
        };
        const onErr = (error: Error) => {
          cleanup();
          reject(error);
        };
        const onClose = () => {
          cleanup();
          reject(new Error("تم إغلاق اتصال RouterOS أثناء القراءة"));
        };
        const cleanup = () => {
          socket.off("data", onData);
          socket.off("error", onErr);
          socket.off("close", onClose);
        };
        socket.once("data", onData);
        socket.once("error", onErr);
        socket.once("close", onClose);
      });
      this.readBuffer = Buffer.concat([this.readBuffer, chunk]);
    }

    const out = this.readBuffer.subarray(0, bytes);
    this.readBuffer = this.readBuffer.subarray(bytes);
    return out;
  }

  private async readWord(): Promise<string> {
    const len = await this.readLength();
    if (len === 0) return "";
    const data = await this.readExact(len);
    return data.toString("utf8");
  }

  private async readSentence(): Promise<string[]> {
    const words: string[] = [];
    while (true) {
      const word = await this.readWord();
      if (!word) break;
      words.push(word);
    }
    return words;
  }

  private async writeWord(word: string) {
    if (!this.socket || this.socket.destroyed) throw new Error("لا يوجد اتصال نشط");
    const payload = Buffer.from(word, "utf8");
    const encoded = Buffer.concat([this.encodeLength(payload.length), payload]);
    await new Promise<void>((resolve, reject) => {
      this.socket!.write(encoded, (err) => {
        if (err) reject(err);
        else resolve();
      });
    });
  }

  private async writeSentence(words: string[]) {
    for (const word of words) await this.writeWord(word);
    if (!this.socket || this.socket.destroyed) throw new Error("لا يوجد اتصال نشط");
    await new Promise<void>((resolve, reject) => {
      this.socket!.write(Buffer.from([0]), (err) => {
        if (err) reject(err);
        else resolve();
      });
    });
  }

  private async connectSocket() {
    const useTls = this.config.protocol === "api-ssl";
    const port = Number(this.config.port || (useTls ? "8729" : "8728"));

    this.socket = await new Promise<net.Socket | tls.TLSSocket>((resolve, reject) => {
      const onConnect = () => resolve(socket as net.Socket | tls.TLSSocket);
      const onError = (error: Error) => reject(error);

      const socket = useTls
        ? tls.connect({ host: this.config.host, port, rejectUnauthorized: false }, onConnect)
        : net.connect({ host: this.config.host, port }, onConnect);

      socket.once("error", onError);
      // Connect-stage timeout only. Command-stage timeouts are handled per request.
      socket.setTimeout(20000, () => {
        socket.destroy(new Error("انتهت مهلة اتصال API"));
      });
    });

    // Disable generic inactivity timeout after connect to avoid killing long UM reads.
    this.socket.setTimeout(0);
    this.socket.setKeepAlive(true, 30000);
    this.readBuffer = Buffer.alloc(0);
  }

  private static computeMd5Response(password: string, challengeHex: string) {
    const challenge = Buffer.from(challengeHex, "hex");
    const preimage = Buffer.concat([Buffer.from([0]), Buffer.from(password, "utf8"), challenge]);
    const digest = crypto.createHash("md5").update(preimage).digest("hex");
    return `00${digest}`;
  }

  async login() {
    await this.connectSocket();

    await this.writeSentence(["/login", `=name=${this.config.user}`, `=password=${this.config.pass}`]);
    const first = await this.readSentence();
    if (first.length === 0) throw new Error("استجابة تسجيل دخول فارغة");

    if (first[0] === "!trap") {
      throw new Error(parseAttrs(first).message || "فشل تسجيل الدخول");
    }

    if (first[0] !== "!done") {
      throw new Error(`استجابة غير متوقعة: ${first[0]}`);
    }

    const attrs = parseAttrs(first);
    if (!attrs.ret) return;

    const response = RouterApiConnection.computeMd5Response(this.config.pass, attrs.ret);
    await this.writeSentence(["/login", `=name=${this.config.user}`, `=response=${response}`]);
    const second = await this.readSentence();
    if (second[0] === "!trap") {
      throw new Error(parseAttrs(second).message || "فشل تسجيل الدخول");
    }
  }

  async execute(command: string, args: string[] = []): Promise<ApiResult[]> {
    await this.writeSentence([command, ...args]);

    const results: ApiResult[] = [];
    let trapMessage = "";

    while (true) {
      const sentence = await this.readSentence();
      if (sentence.length === 0) continue;

      const type = sentence[0];
      const attrs = parseAttrs(sentence);

      if (type === "!re") {
        results.push(attrs);
        continue;
      }

      if (type === "!trap") {
        trapMessage = attrs.message || "فشل تنفيذ الأمر";
        continue;
      }

      if (type === "!done") {
        if (trapMessage) throw new Error(trapMessage);
        // Some commands (e.g. =count-only=) return data only on !done.
        if (results.length === 0 && Object.keys(attrs).length > 0) {
          return [attrs];
        }
        return results;
      }

      if (type === "!fatal") {
        throw new Error(attrs.message || "RouterOS fatal error");
      }
    }
  }

  close() {
    if (!this.socket || this.socket.destroyed) return;
    this.socket.destroy();
    this.socket = null;
    this.readBuffer = Buffer.alloc(0);
  }
}

class ApiConnectionPool {
  private readonly entries = new Map<string, { conn: RouterApiConnection; queue: TaskQueue; lastUsed: number }>();
  private readonly maxIdleMs = 90_000;

  constructor() {
    setInterval(() => this.cleanupIdle(), 30_000).unref();
  }

  private key(config: RouterConfig, lane = "default"): string {
    return [config.host, config.port, config.user, config.mode, config.protocol, lane].join("|");
  }

  private cleanupIdle() {
    const now = Date.now();
    for (const [key, entry] of this.entries) {
      if (now - entry.lastUsed > this.maxIdleMs) {
        entry.conn.close();
        this.entries.delete(key);
      }
    }
  }

  private async ensureConnection(config: RouterConfig, lane: string) {
    const key = this.key(config, lane);
    let entry = this.entries.get(key);
    if (!entry) {
      const conn = new RouterApiConnection(config);
      await conn.login();
      entry = { conn, queue: new TaskQueue(1), lastUsed: Date.now() };
      this.entries.set(key, entry);
    }
    entry.lastUsed = Date.now();
    return entry;
  }

  async execute(config: RouterConfig, command: string, args?: string[]) {
    const lane = isUserManagerCommand(command) ? "um" : "default";
    const entry = await this.ensureConnection(config, lane);

    return entry.queue.run(async () => {
      try {
        const out = await entry!.conn.execute(command, args || []);
        entry!.lastUsed = Date.now();
        return out;
      } catch (error) {
        // Reconnect once for stale sockets
        entry!.conn.close();
        this.entries.delete(this.key(config, lane));
        const refreshed = await this.ensureConnection(config, lane);
        return refreshed.queue.run(() => refreshed.conn.execute(command, args || []));
      }
    });
  }

  invalidate(config: RouterConfig, command: string) {
    const lane = isUserManagerCommand(command) ? "um" : "default";
    const key = this.key(config, lane);
    const entry = this.entries.get(key);
    if (!entry) return;
    entry.conn.close();
    this.entries.delete(key);
  }
}

const apiPool = new ApiConnectionPool();
const readCache = new Map<string, { expiresAt: number; value: unknown }>();
const inFlightReads = new Map<string, Promise<unknown>>();
const userManagerNamespacePref = new Map<string, "tool" | "root">();

function argsKey(args?: string[]) {
  if (!args || args.length === 0) return "";
  return args.join("\u001f");
}

function commandKey(config: RouterConfig, command: string, args?: string[]) {
  return [config.host, config.port, config.user, config.mode, config.protocol, command, argsKey(args)].join("|");
}

function routerPrefKey(config: RouterConfig) {
  return [config.host, config.port, config.user, config.mode, config.protocol].join("|");
}

function isReadOnlyPrintCommand(command: string) {
  return command.endsWith("/print");
}

function isUserManagerCommand(command: string) {
  return command.startsWith("/user-manager/") || command.startsWith("/tool/user-manager/");
}

function readTtlMs(command: string) {
  if (isUserManagerCommand(command)) return 15_000;
  if (command.startsWith("/ip/hotspot/active/print")) return 3_000;
  return 5_000;
}

function isUmLegacyArgsAuthError(error: unknown, command: string, args?: string[]) {
  if (!isUserManagerCommand(command)) return false;
  if (!command.endsWith("/print")) return false;
  if (!args || args.length === 0) return false;
  const msg = error instanceof Error ? error.message.toLowerCase() : "";
  return msg.includes("invalid user name or password (6)");
}

function isUnknownParameterError(error: unknown) {
  const msg = error instanceof Error ? error.message.toLowerCase() : "";
  return msg.includes("unknown parameter");
}

function parseArgValue(args: string[] | undefined, key: string): string | null {
  if (!args || args.length === 0) return null;
  const prefix = `=${key}=`;
  const found = args.find((a) => a.startsWith(prefix));
  if (!found) return null;
  return found.substring(prefix.length);
}

function toRos6UserManagerAddArgs(args: string[] | undefined): string[] | null {
  const username = parseArgValue(args, "username") ?? parseArgValue(args, "name");
  const password = parseArgValue(args, "password") ?? "";
  const customer = parseArgValue(args, "customer") ?? parseArgValue(args, "owner") ?? "admin";
  if (!username) return null;

  const fallback: string[] = [`=customer=${customer}`, `=username=${username}`];
  if (password) fallback.push(`=password=${password}`);
  return fallback;
}

function clearReadCacheForRouter(config: RouterConfig) {
  const prefix = [config.host, config.port, config.user, config.mode, config.protocol].join("|");
  for (const key of readCache.keys()) {
    if (key.startsWith(prefix)) readCache.delete(key);
  }
  for (const key of inFlightReads.keys()) {
    if (key.startsWith(prefix)) inFlightReads.delete(key);
  }
}

function withTimeout<T>(promise: Promise<T>, timeoutMs: number, message: string): Promise<T> {
  let timer: ReturnType<typeof setTimeout> | null = null;
  return Promise.race([
    promise,
    new Promise<T>((_, reject) => {
      timer = setTimeout(() => reject(new Error(message)), timeoutMs);
    }),
  ]).finally(() => {
    if (timer) clearTimeout(timer);
  });
}

async function callRest(config: RouterConfig, command: string, args?: string[]) {
  const method = restMethod(command);
  let path = command
    .replace(/\/print$/, "")
    .replace(/\/set$/, "")
    .replace(/\/add$/, "")
    .replace(/\/remove$/, "");

  let body = argsToRestBody(args);

  if (method === "DELETE" && body?.[".id"]) {
    path = `${path}/${body[".id"]}`;
    const { [".id"]: _id, ...rest } = body;
    body = Object.keys(rest).length > 0 ? rest : undefined;
  }

  const scheme = config.protocol === "https" ? "https" : "http";
  const url = `${scheme}://${config.host}:${config.port}/rest${path}`;
  const controller = new AbortController();
  const timeout = setTimeout(() => controller.abort(), method === "GET" ? 15_000 : 25_000);

  try {
    const response = await fetch(url, {
      method,
      headers: {
        Authorization: `Basic ${Buffer.from(`${config.user}:${config.pass}`).toString("base64")}`,
        "Content-Type": "application/json",
      },
      body: body && method !== "GET" ? JSON.stringify(body) : undefined,
      signal: controller.signal,
    });

    const text = await response.text();
    let payload: unknown = null;
    if (text) {
      try {
        payload = JSON.parse(text);
      } catch {
        payload = text;
      }
    }

    if (!response.ok) {
      const message = typeof payload === "string" ? payload : JSON.stringify(payload || {});
      throw new Error(`REST [${response.status}] ${message.slice(0, 250)}`);
    }

    return payload;
  } finally {
    clearTimeout(timeout);
  }
}

function normalizeApiCommand(command: string): string[] {
  // Caller uses v7-style path.
  if (command.startsWith("/user-manager/")) {
    return [command, `/tool${command}`];
  }
  // Caller uses v6-style path.
  if (command.startsWith("/tool/user-manager/")) {
    const root = command.replace("/tool", "");
    return [command, root];
  }
  return [command];
}

function orderedUserManagerVariants(config: RouterConfig, command: string) {
  const variants = normalizeApiCommand(command);
  if (!isUserManagerCommand(command) || variants.length <= 1) return variants;

  const pref = userManagerNamespacePref.get(routerPrefKey(config));
  if (!pref) {
    // Start with /tool first for ROS6 compatibility, then try /user-manager for ROS7.
    return [...variants].sort((a, b) => {
      const aTool = a.startsWith("/tool/user-manager/") ? 0 : 1;
      const bTool = b.startsWith("/tool/user-manager/") ? 0 : 1;
      return aTool - bTool;
    });
  }

  return [...variants].sort((a, b) => {
    const aPref = pref === "tool" ? a.startsWith("/tool/user-manager/") : a.startsWith("/user-manager/");
    const bPref = pref === "tool" ? b.startsWith("/tool/user-manager/") : b.startsWith("/user-manager/");
    if (aPref === bPref) return 0;
    return aPref ? -1 : 1;
  });
}

function shouldTryAlternateVariant(error: unknown) {
  const msg = error instanceof Error ? error.message.toLowerCase() : "";
  if (!msg) return false;
  return (
    msg.includes("no such command") ||
    msg.includes("unknown command") ||
    msg.includes("not recognized") ||
    msg.includes("bad command")
  );
}

export async function executeCommand(config: RouterConfig, command: string, args?: string[]) {
  if (config.mode === "rest") {
    return callRest(config, command, args);
  }

  const readonly = isReadOnlyPrintCommand(command);
  const cacheKey = readonly ? commandKey(config, command, args) : "";
  if (readonly) {
    const cached = readCache.get(cacheKey);
    if (cached && cached.expiresAt > Date.now()) {
      return cached.value;
    }
    const existing = inFlightReads.get(cacheKey);
    if (existing) return existing;
  }

  const variants = orderedUserManagerVariants(config, command);
  const run = (async () => {
    let lastError: unknown = null;

    for (let index = 0; index < variants.length; index += 1) {
      const variant = variants[index];
      try {
        const timeoutMs = isUserManagerCommand(variant) ? 60_000 : 22_000;
        const result = await withTimeout(
          apiPool.execute(config, variant, args),
          timeoutMs,
          `انتهت مهلة أمر API: ${variant}`,
        );
        if (readonly) {
          readCache.set(cacheKey, { expiresAt: Date.now() + readTtlMs(variant), value: result });
        }
        if (isUserManagerCommand(variant)) {
          const pref: "tool" | "root" = variant.startsWith("/tool/user-manager/") ? "tool" : "root";
          userManagerNamespacePref.set(routerPrefKey(config), pref);
        }
        return result;
      } catch (error) {
        if (isUmLegacyArgsAuthError(error, variant, args)) {
          try {
            const fallbackResult = await withTimeout(
              apiPool.execute(config, variant, []),
              60_000,
              `انتهت مهلة أمر API: ${variant}`,
            );
            if (readonly) {
              readCache.set(cacheKey, { expiresAt: Date.now() + readTtlMs(variant), value: fallbackResult });
            }
            return fallbackResult;
          } catch (fallbackError) {
            apiPool.invalidate(config, variant);
            lastError = fallbackError;
            const hasAlternate = index < variants.length - 1;
            if (!hasAlternate || !shouldTryAlternateVariant(fallbackError)) {
              break;
            }
            continue;
          }
        }

        // RouterOS v6 User Manager often rejects newer args like group/owner.
        if (isUnknownParameterError(error) && variant.endsWith("/user/add") && isUserManagerCommand(variant)) {
          const fallbackArgs = toRos6UserManagerAddArgs(args);
          if (fallbackArgs) {
            try {
              const fallbackResult = await withTimeout(
                apiPool.execute(config, variant, fallbackArgs),
                60_000,
                `انتهت مهلة أمر API: ${variant}`,
              );
              if (readonly) {
                readCache.set(cacheKey, { expiresAt: Date.now() + readTtlMs(variant), value: fallbackResult });
              }
              return fallbackResult;
            } catch (fallbackError) {
              apiPool.invalidate(config, variant);
              lastError = fallbackError;
              const hasAlternate = index < variants.length - 1;
              if (!hasAlternate || !shouldTryAlternateVariant(fallbackError)) {
                break;
              }
              continue;
            }
          }
        }

        apiPool.invalidate(config, variant);
        lastError = error;
        const hasAlternate = index < variants.length - 1;
        if (!hasAlternate || !shouldTryAlternateVariant(error)) {
          break;
        }
      }
    }

    throw lastError instanceof Error ? lastError : new Error("فشل تنفيذ أمر API");
  })();

  if (!readonly) {
    clearReadCacheForRouter(config);
    return run;
  }

  inFlightReads.set(cacheKey, run);
  try {
    return await run;
  } catch (error) {
    const stale = readCache.get(cacheKey);
    if (stale?.value != null) {
      return stale.value;
    }
    throw error;
  } finally {
    inFlightReads.delete(cacheKey);
  }
}

export async function executeBatch(config: RouterConfig, commands: MikrotikCommand[], concurrency = 2) {
  const queue = new TaskQueue(Math.max(1, Math.min(concurrency, 6)));
  const results: unknown[] = new Array(commands.length);
  const errors: string[] = new Array(commands.length).fill("");

  await Promise.all(
    commands.map((cmd, idx) =>
      queue.run(async () => {
        try {
          results[idx] = await executeCommand(config, cmd.command, cmd.args);
        } catch (error) {
          errors[idx] = error instanceof Error ? error.message : "فشل تنفيذ الأمر";
        }
      }),
    ),
  );

  return { results, errors };
}
