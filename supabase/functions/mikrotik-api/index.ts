import { serve } from "https://deno.land/std@0.168.0/http/server.ts";

const corsHeaders = {
  "Access-Control-Allow-Origin": "*",
  "Access-Control-Allow-Headers":
    "authorization, x-client-info, apikey, content-type, x-supabase-client-platform, x-supabase-client-platform-version, x-supabase-client-runtime, x-supabase-client-runtime-version",
};

// ─── MikroTik API Protocol Client (v6/v7 TCP) ───────────────────────────
class MikroTikApiClient {
  private conn!: Deno.Conn;
  private buf = new Uint8Array(0);

  async connect(host: string, port: number, useTls: boolean) {
    const timeout = 10000;
    const connectPromise = useTls
      ? (Deno as any).connectTls({ hostname: host, port })
      : Deno.connect({ hostname: host, port });
    const timer = new Promise((_, reject) =>
      setTimeout(() => reject(new Error(`Connection timeout after ${timeout}ms`)), timeout)
    );
    this.conn = await Promise.race([connectPromise, timer]) as Deno.Conn;
  }

  async close() {
    try { this.conn.close(); } catch { /* ignore */ }
  }

  private async readExact(n: number): Promise<Uint8Array> {
    while (this.buf.length < n) {
      const chunk = new Uint8Array(8192);
      const read = await this.conn.read(chunk);
      if (read === null) throw new Error("Connection closed by router");
      const merged = new Uint8Array(this.buf.length + read);
      merged.set(this.buf);
      merged.set(chunk.subarray(0, read), this.buf.length);
      this.buf = merged;
    }
    const out = this.buf.slice(0, n);
    this.buf = this.buf.slice(n);
    return out;
  }

  private async readLength(): Promise<number> {
    const b = (await this.readExact(1))[0];
    if (b < 0x80) return b;
    if ((b & 0xC0) === 0x80) {
      const b2 = (await this.readExact(1))[0];
      return ((b & 0x3F) << 8) | b2;
    }
    if ((b & 0xE0) === 0xC0) {
      const rest = await this.readExact(2);
      return ((b & 0x1F) << 16) | (rest[0] << 8) | rest[1];
    }
    if ((b & 0xF0) === 0xE0) {
      const rest = await this.readExact(3);
      return ((b & 0x0F) << 24) | (rest[0] << 16) | (rest[1] << 8) | rest[2];
    }
    const rest = await this.readExact(4);
    return (rest[0] << 24) | (rest[1] << 16) | (rest[2] << 8) | rest[3];
  }

  private async readWord(): Promise<string> {
    const len = await this.readLength();
    if (len === 0) return "";
    const data = await this.readExact(len);
    return new TextDecoder().decode(data);
  }

  private encodeLength(len: number): Uint8Array {
    if (len < 0x80) return new Uint8Array([len]);
    if (len < 0x4000) return new Uint8Array([((len >> 8) & 0x3F) | 0x80, len & 0xFF]);
    if (len < 0x200000) return new Uint8Array([((len >> 16) & 0x1F) | 0xC0, (len >> 8) & 0xFF, len & 0xFF]);
    if (len < 0x10000000) return new Uint8Array([((len >> 24) & 0x0F) | 0xE0, (len >> 16) & 0xFF, (len >> 8) & 0xFF, len & 0xFF]);
    return new Uint8Array([0xF0, (len >> 24) & 0xFF, (len >> 16) & 0xFF, (len >> 8) & 0xFF, len & 0xFF]);
  }

  private async writeWord(word: string) {
    const encoded = new TextEncoder().encode(word);
    const lenBytes = this.encodeLength(encoded.length);
    const combined = new Uint8Array(lenBytes.length + encoded.length);
    combined.set(lenBytes);
    combined.set(encoded, lenBytes.length);
    await this.conn.write(combined);
  }

  private async readSentence(): Promise<string[]> {
    const words: string[] = [];
    while (true) {
      const w = await this.readWord();
      if (w === "") break;
      words.push(w);
    }
    return words;
  }

  private async writeSentence(words: string[]) {
    for (const w of words) await this.writeWord(w);
    await this.conn.write(new Uint8Array([0]));
  }

  async login(user: string, pass: string): Promise<void> {
    await this.writeSentence(["/login", `=name=${user}`, `=password=${pass}`]);
    const sentence = await this.readSentence();
    if (sentence.length === 0) throw new Error("Empty login response");
    const type = sentence[0];
    if (type === "!trap") {
      await this.readSentence();
      throw new Error(parseAttrs(sentence).message || "Authentication failed");
    }
    if (type === "!done") {
      const attrs = parseAttrs(sentence);
      if (attrs.ret) {
        const response = await computeChallengeResponse(pass, attrs.ret);
        await this.writeSentence(["/login", `=name=${user}`, `=response=${response}`]);
        const s2 = await this.readSentence();
        if (s2[0] === "!trap") {
          await this.readSentence();
          throw new Error(parseAttrs(s2).message || "Authentication failed");
        }
      }
      return;
    }
    throw new Error(`Unexpected login response: ${type}`);
  }

  async execute(command: string, args?: string[]): Promise<Record<string, string>[]> {
    const words = [command, ...(args || [])];
    await this.writeSentence(words);
    const results: Record<string, string>[] = [];
    let trapError: string | null = null;
    while (true) {
      const sentence = await this.readSentence();
      if (sentence.length === 0) continue;
      const type = sentence[0];
      const attrs = parseAttrs(sentence);
      if (type === "!re") {
        results.push(attrs);
      } else if (type === "!trap") {
        trapError = attrs.message || "Command failed";
      } else if (type === "!done") {
        if (trapError) throw new Error(trapError);
        break;
      } else if (type === "!fatal") {
        throw new Error(attrs.message || "Fatal error");
      }
    }
    return results;
  }
}

function parseAttrs(sentence: string[]): Record<string, string> {
  const attrs: Record<string, string> = {};
  for (const w of sentence) {
    if (w.startsWith("=")) {
      const idx = w.indexOf("=", 1);
      if (idx > 0) attrs[w.substring(1, idx)] = w.substring(idx + 1);
    }
  }
  return attrs;
}

function hexToBytes(hex: string): Uint8Array {
  const bytes = new Uint8Array(hex.length / 2);
  for (let i = 0; i < hex.length; i += 2) bytes[i / 2] = parseInt(hex.substr(i, 2), 16);
  return bytes;
}

function bytesToHex(bytes: Uint8Array): string {
  return Array.from(bytes).map((b) => b.toString(16).padStart(2, "0")).join("");
}

async function computeChallengeResponse(password: string, challengeHex: string): Promise<string> {
  const challenge = hexToBytes(challengeHex);
  const passBytes = new TextEncoder().encode(password);
  const toHash = new Uint8Array(1 + passBytes.length + challenge.length);
  toHash[0] = 0;
  toHash.set(passBytes, 1);
  toHash.set(challenge, 1 + passBytes.length);
  const hash = new Uint8Array(await crypto.subtle.digest("MD5", toHash));
  return "00" + bytesToHex(hash);
}

// ─── Convert API-style args to REST body object ─────────────────────────
function argsToRestBody(args?: string[]): Record<string, string> | undefined {
  if (!args || args.length === 0) return undefined;
  const body: Record<string, string> = {};
  for (const arg of args) {
    if (arg.startsWith("=")) {
      const idx = arg.indexOf("=", 1);
      if (idx > 0) {
        body[arg.substring(1, idx)] = arg.substring(idx + 1);
      }
    }
  }
  return Object.keys(body).length > 0 ? body : undefined;
}

// ─── Determine REST method from command ─────────────────────────────────
function getRestMethod(command: string): string {
  if (command.endsWith("/add")) return "PUT";
  if (command.endsWith("/set")) return "PATCH";
  if (command.endsWith("/remove")) return "DELETE";
  return "GET";
}

// ─── v6/v7 command mapping ──────────────────────────────────────────────
function getV6FallbackCommand(command: string): string | null {
  if (command.startsWith("/user-manager/")) {
    return "/tool" + command;
  }
  return null;
}

// ─── v6/v7 parameter compatibility for user-manager ─────────────────────
function argsListToObject(args?: string[]): Record<string, string> {
  const out: Record<string, string> = {};
  if (!args) return out;

  for (const arg of args) {
    if (!arg.startsWith("=")) continue;
    const idx = arg.indexOf("=", 1);
    if (idx <= 0) continue;
    out[arg.substring(1, idx)] = arg.substring(idx + 1);
  }

  return out;
}

function objectToArgsList(obj: Record<string, any>): string[] {
  return Object.entries(obj)
    .filter(([, v]) => v !== undefined && v !== null && `${v}` !== "")
    .map(([k, v]) => `=${k}=${v}`);
}

function omitArgsKeys(args: string[] | undefined, keys: string[]): string[] | undefined {
  if (!args || args.length === 0) return args;
  const keySet = new Set(keys);
  return args.filter((arg) => {
    if (!arg.startsWith("=")) return true;
    const idx = arg.indexOf("=", 1);
    if (idx <= 0) return true;
    const key = arg.substring(1, idx);
    return !keySet.has(key);
  });
}

function remapArgs(args: string[] | undefined, map: Record<string, string>): string[] | undefined {
  if (!args) return args;
  return args.map((arg) => {
    if (!arg.startsWith("=")) return arg;
    const idx = arg.indexOf("=", 1);
    if (idx <= 0) return arg;
    const key = arg.substring(1, idx);
    const value = arg.substring(idx + 1);
    const mappedKey = map[key] || key;
    return `=${mappedKey}=${value}`;
  });
}

function uniqueArgVariants(variants: (string[] | undefined)[]): (string[] | undefined)[] {
  const seen = new Set<string>();
  const out: (string[] | undefined)[] = [];
  for (const v of variants) {
    const key = (v || []).join("\u0001");
    if (seen.has(key)) continue;
    seen.add(key);
    out.push(v);
  }
  return out;
}

function isUserManagerUserAddCommand(command: string): boolean {
  return /(?:\/tool)?\/user-manager\/user\/add$/.test(command);
}

function isUserManagerProfileCommand(command: string): boolean {
  return /\/user-manager\/profile\/(add|set)$/.test(command) ||
         /\/tool\/user-manager\/profile\/(add|set)$/.test(command);
}

function getUserManagerRoots(command: string): string[] {
  const fromTool = command.startsWith("/tool/user-manager/");
  const roots = fromTool
    ? ["/tool/user-manager", "/user-manager"]
    : ["/user-manager", "/tool/user-manager"];

  return Array.from(new Set(roots));
}

function buildUserManagerArgVariants(command: string, args?: string[]): (string[] | undefined)[] {
  if (!args || args.length === 0) return [args];

  const baseVariants: (string[] | undefined)[] = [
    args,
    remapArgs(args, { group: "profile" }),
    remapArgs(args, { profile: "group" }),
    remapArgs(args, { name: "username" }),
    remapArgs(args, { username: "name" }),
    remapArgs(args, { user: "username" }),
    remapArgs(args, { username: "user" }),
    remapArgs(args, { ".id": "numbers" }),
    remapArgs(args, { numbers: ".id" }),
    remapArgs(args, { owner: "customer" }),
    remapArgs(args, { customer: "owner" }),
    remapArgs(remapArgs(args, { group: "profile" }), { name: "username" }),
    remapArgs(remapArgs(args, { profile: "group" }), { username: "name" }),
  ];

  if (isUserManagerProfileCommand(command)) {
    const parsed = argsListToObject(args);
    const owner = parsed.owner || parsed.customer || "admin";
    baseVariants.unshift(
      objectToArgsList({ ...parsed, owner }),
      objectToArgsList({ ...parsed, customer: owner }),
    );

    const optionalKeys = ["name-for-users", "override-shared-users", "transfer-limit", "uptime-limit", "price"];
    for (const key of optionalKeys) {
      if (parsed[key] !== undefined && parsed[key] !== "") {
        baseVariants.push(omitArgsKeys(args, [key]));
      }
    }
    baseVariants.push(omitArgsKeys(args, optionalKeys));
  }

  if (isUserManagerUserAddCommand(command)) {
    const parsed = argsListToObject(args);
    const username = parsed.username || parsed.name || parsed.user;
    const hasPassword = Object.prototype.hasOwnProperty.call(parsed, "password");
    const password = hasPassword ? parsed.password : "";
    const profile = parsed.profile || parsed.group;
    const customer = parsed.customer || parsed.owner || "admin";

    if (username && hasPassword) {
      baseVariants.unshift(
        objectToArgsList({ username, password, profile, owner: customer }),
        objectToArgsList({ username, password, group: profile, owner: customer }),
        objectToArgsList({ username, password, profile, customer }),
        objectToArgsList({ username, password, group: profile, customer }),
        objectToArgsList({ username, password, owner: customer }),
        objectToArgsList({ username, password, customer }),
        objectToArgsList({ username, password }),
        objectToArgsList({ name: username, password, profile, owner: customer }),
        objectToArgsList({ name: username, password, group: profile, owner: customer }),
        objectToArgsList({ name: username, password, profile, customer }),
        objectToArgsList({ name: username, password, group: profile, customer }),
        objectToArgsList({ name: username, password, owner: customer }),
        objectToArgsList({ name: username, password, customer }),
        objectToArgsList({ name: username, password }),
      );
    }
  }

  return uniqueArgVariants(baseVariants);
}

function mapArgsForV6(command: string, args?: string[]): string[] | undefined {
  if (!args || !command.includes("user-manager")) return args;
  return remapArgs(args, {
    group: "profile",
    name: "username",
    ".id": "numbers",
    owner: "customer",
    user: "username",
  });
}

function isCompatibilityError(message: string): boolean {
  const m = (message || "").toLowerCase();
  return (
    m.includes("unknown parameter") ||
    m.includes("no such command") ||
    m.includes("unknown command") ||
    m.includes("input does not match")
  );
}

function buildUserManagerCommandAttempts(
  command: string,
  args?: string[],
): { command: string; args?: string[] }[] {
  const attempts: { command: string; args?: string[] }[] = [];

  for (const variant of buildUserManagerArgVariants(command, args)) {
    attempts.push({ command, args: variant });
  }

  const fallback = getV6FallbackCommand(command);
  if (fallback) {
    const v6Base = mapArgsForV6(fallback, args);
    for (const variant of buildUserManagerArgVariants(fallback, v6Base)) {
      attempts.push({ command: fallback, args: variant });
    }
  }

  return attempts;
}

async function executeCompatibilityAttempts(
  client: MikroTikApiClient,
  attempts: { command: string; args?: string[] }[],
): Promise<Record<string, string>[]> {
  const seen = new Set<string>();
  let lastError: Error | null = null;

  for (const attempt of attempts) {
    const key = `${attempt.command}|${(attempt.args || []).join("\u0001")}`;
    if (seen.has(key)) continue;
    seen.add(key);

    try {
      return await client.execute(attempt.command, attempt.args);
    } catch (err: any) {
      const errorObj = err instanceof Error ? err : new Error(String(err));
      lastError = errorObj;
      if (!isCompatibilityError(errorObj.message)) {
        throw errorObj;
      }
    }
  }

  throw lastError || new Error("User Manager command failed");
}

async function findUserManagerUserId(
  client: MikroTikApiClient,
  command: string,
  username: string,
): Promise<string | null> {
  const roots = getUserManagerRoots(command);

  for (const root of roots) {
    try {
      const rows = await client.execute(`${root}/user/print`);
      const hit = rows.find((row) =>
        row.username === username ||
        row.name === username ||
        row.user === username,
      );
      const id = hit?.[".id"] || hit?.id;
      if (id) return id;
    } catch {
      // ignore compatibility failures here
    }
  }

  return null;
}

function buildProfileActivationAttempts(
  command: string,
  username: string,
  profile: string,
  customer: string,
  userId: string | null,
): { command: string; args?: string[] }[] {
  const attempts: { command: string; args?: string[] }[] = [];

  for (const root of getUserManagerRoots(command)) {
    const activateCommand = `${root}/user/create-and-activate-profile`;
    const setCommand = `${root}/user/set`;

    if (userId) {
      attempts.push({ command: activateCommand, args: objectToArgsList({ profile, customer, numbers: userId }) });
      attempts.push({ command: activateCommand, args: objectToArgsList({ profile, customer, ".id": userId }) });
      attempts.push({ command: setCommand, args: objectToArgsList({ ".id": userId, profile }) });
      attempts.push({ command: setCommand, args: objectToArgsList({ ".id": userId, group: profile }) });
      attempts.push({ command: setCommand, args: objectToArgsList({ numbers: userId, profile }) });
      attempts.push({ command: setCommand, args: objectToArgsList({ numbers: userId, group: profile }) });
    }

    attempts.push({ command: activateCommand, args: objectToArgsList({ profile, customer, username }) });
    attempts.push({ command: activateCommand, args: objectToArgsList({ profile, customer, name: username }) });
    attempts.push({ command: activateCommand, args: objectToArgsList({ profile, customer, user: username }) });
    attempts.push({ command: setCommand, args: objectToArgsList({ username, profile }) });
    attempts.push({ command: setCommand, args: objectToArgsList({ username, group: profile }) });
    attempts.push({ command: setCommand, args: objectToArgsList({ name: username, profile }) });
  }

  return attempts;
}

async function activateUserManagerProfileCompatible(
  client: MikroTikApiClient,
  command: string,
  username: string,
  profile: string,
  customer: string,
): Promise<void> {
  const userId = await findUserManagerUserId(client, command, username);
  const attempts = buildProfileActivationAttempts(command, username, profile, customer, userId);
  await executeCompatibilityAttempts(client, attempts);
}

async function executeUserManagerCompatible(
  client: MikroTikApiClient,
  command: string,
  args?: string[],
): Promise<Record<string, string>[]> {
  if (isUserManagerUserAddCommand(command)) {
    const parsed = argsListToObject(args);
    const username = parsed.username || parsed.name || parsed.user;
    const profile = parsed.profile || parsed.group;
    const customer = parsed.customer || parsed.owner || "admin";

    // Fast path: try creating user with profile/group directly first (faster for most routers)
    try {
      const directAttempts = buildUserManagerCommandAttempts(command, args);
      return await executeCompatibilityAttempts(client, directAttempts);
    } catch (err: any) {
      const errorObj = err instanceof Error ? err : new Error(String(err));
      if (!isCompatibilityError(errorObj.message)) throw errorObj;
    }

    // Fallback path: create user first then attach profile
    const addArgs = omitArgsKeys(args, ["profile", "group"]);
    const addAttempts = buildUserManagerCommandAttempts(command, addArgs);
    const addResult = await executeCompatibilityAttempts(client, addAttempts);

    if (username && profile) {
      await activateUserManagerProfileCompatible(client, command, username, profile, customer);
    }

    return addResult;
  }

  const attempts = buildUserManagerCommandAttempts(command, args);
  return executeCompatibilityAttempts(client, attempts);
}

// ─── Port Scanner ───────────────────────────────────────────────────────
async function scanPorts(host: string, ports: number[]): Promise<{ port: number; open: boolean; service: string }[]> {
  const portServices: Record<number, string> = {
    21: "FTP", 22: "SSH", 23: "Telnet", 53: "DNS",
    80: "HTTP (www)", 443: "HTTPS (www-ssl)",
    8291: "Winbox", 8728: "API", 8729: "API-SSL",
    8080: "HTTP Proxy", 161: "SNMP", 179: "BGP",
    1723: "PPTP", 500: "IKE/IPSec",
  };
  const results = await Promise.allSettled(
    ports.map(async (port) => {
      try {
        const conn = await Promise.race([
          Deno.connect({ hostname: host, port }),
          new Promise((_, reject) => setTimeout(() => reject(new Error("timeout")), 3000)),
        ]) as Deno.Conn;
        conn.close();
        return { port, open: true, service: portServices[port] || `Port ${port}` };
      } catch {
        return { port, open: false, service: portServices[port] || `Port ${port}` };
      }
    })
  );
  return results
    .filter((r): r is PromiseFulfilledResult<{ port: number; open: boolean; service: string }> => r.status === "fulfilled")
    .map((r) => r.value);
}

// ─── Create a fresh API connection ──────────────────────────────────────
async function createApiClient(host: string, port: string, useTls: boolean, user: string, pass: string): Promise<MikroTikApiClient> {
  const client = new MikroTikApiClient();
  await client.connect(host, parseInt(port), useTls);
  await client.login(user, pass);
  return client;
}

// ─── REST API Handler (v7+) ─────────────────────────────────────────────
async function handleRest(
  host: string, port: string, protocol: string,
  user: string, pass: string, command: string,
  method?: string, restBody?: Record<string, any>
): Promise<any> {
  const effectiveMethod = method || getRestMethod(command);
  let path = command.replace(/\/print$/, "").replace(/\/set$/, "").replace(/\/add$/, "").replace(/\/remove$/, "");
  const credentials = btoa(`${user}:${pass}`);
  const controller = new AbortController();
  const timeout = setTimeout(() => controller.abort(), 15000);

  // For DELETE requests, append .id to URL path (MikroTik REST requires it)
  let effectiveBody = restBody;
  if (effectiveMethod === "DELETE" && restBody?.[".id"]) {
    path = `${path}/${restBody[".id"]}`;
    const { ".id": _, ...rest } = restBody;
    effectiveBody = Object.keys(rest).length > 0 ? rest : undefined;
  }

  const url = `${protocol}://${host}:${port}/rest${path}`;
  try {
    const fetchOpts: RequestInit = {
      method: effectiveMethod,
      headers: {
        Authorization: `Basic ${credentials}`,
        "Content-Type": "application/json",
      },
      signal: controller.signal,
    };
    if (effectiveBody && effectiveMethod !== "GET") {
      fetchOpts.body = JSON.stringify(effectiveBody);
    }
    const response = await fetch(url, fetchOpts);
    if (!response.ok) {
      const text = await response.text();
      throw new Error(`REST API [${response.status}]: ${text.substring(0, 200)}`);
    }
    return response.json();
  } finally {
    clearTimeout(timeout);
  }
}

function omitBodyKeys(body: Record<string, any> | undefined, keys: string[]): Record<string, any> | undefined {
  if (!body) return body;
  const keySet = new Set(keys);
  return Object.fromEntries(Object.entries(body).filter(([k]) => !keySet.has(k)));
}

function buildRestBodyVariants(command: string, body?: Record<string, any>): (Record<string, any> | undefined)[] {
  if (!body || Object.keys(body).length === 0) return [body];

  const remapBody = (obj: Record<string, any>, map: Record<string, string>) => {
    const out: Record<string, any> = {};
    for (const [key, value] of Object.entries(obj)) {
      out[map[key] || key] = value;
    }
    return out;
  };

  const variants = [
    body,
    remapBody(body, { group: "profile" }),
    remapBody(body, { profile: "group" }),
    remapBody(body, { name: "username" }),
    remapBody(body, { username: "name" }),
    remapBody(body, { user: "username" }),
    remapBody(body, { username: "user" }),
    remapBody(body, { owner: "customer" }),
    remapBody(body, { customer: "owner" }),
    remapBody(body, { ".id": "numbers" }),
    remapBody(body, { numbers: ".id" }),
    remapBody(remapBody(body, { group: "profile" }), { name: "username" }),
  ];

  if (isUserManagerProfileCommand(command)) {
    const owner = body.owner || body.customer || "admin";
    variants.unshift(
      { ...body, owner },
      { ...body, customer: owner },
    );

    const optionalKeys = ["name-for-users", "override-shared-users", "transfer-limit", "uptime-limit", "price"];
    for (const key of optionalKeys) {
      if (body[key] !== undefined) {
        variants.push(omitBodyKeys(body, [key]));
      }
    }
    variants.push(omitBodyKeys(body, optionalKeys)!);
  }

  if (isUserManagerUserAddCommand(command)) {
    const username = body.username || body.name || body.user;
    const hasPassword = Object.prototype.hasOwnProperty.call(body, "password");
    const password = hasPassword ? body.password : "";
    const profile = body.profile || body.group;
    const customer = body.customer || body.owner || "admin";

    if (username && hasPassword) {
      variants.unshift(
        { username, password, profile, owner: customer },
        { username, password, group: profile, owner: customer },
        { username, password, profile, customer },
        { username, password, group: profile, customer },
        { username, password, owner: customer },
        { username, password, customer },
        { username, password },
        { name: username, password, profile, owner: customer },
        { name: username, password, group: profile, owner: customer },
        { name: username, password, profile, customer },
        { name: username, password, group: profile, customer },
        { name: username, password, owner: customer },
        { name: username, password, customer },
        { name: username, password },
      );
    }
  }

  const seen = new Set<string>();
  const out: (Record<string, any> | undefined)[] = [];
  for (const item of variants) {
    const key = JSON.stringify(item || {});
    if (seen.has(key)) continue;
    seen.add(key);
    out.push(item);
  }

  return out;
}

async function activateUserManagerProfileRest(
  host: string,
  port: string,
  protocol: string,
  user: string,
  pass: string,
  command: string,
  username: string,
  profile: string,
  customer: string,
): Promise<void> {
  const attempts: Array<{ command: string; method: string; body: Record<string, any> }> = [];

  for (const root of getUserManagerRoots(command)) {
    const activateCommand = `${root}/user/create-and-activate-profile`;
    const setCommand = `${root}/user/set`;

    attempts.push(
      { command: activateCommand, method: "POST", body: { profile, customer, username } },
      { command: activateCommand, method: "POST", body: { profile, customer, name: username } },
      { command: activateCommand, method: "POST", body: { profile, customer, user: username } },
      { command: setCommand, method: "PATCH", body: { username, profile } },
      { command: setCommand, method: "PATCH", body: { username, group: profile } },
      { command: setCommand, method: "PATCH", body: { name: username, profile } },
    );
  }

  let lastError: Error | null = null;
  for (const attempt of attempts) {
    for (const bodyVariant of buildRestBodyVariants(attempt.command, attempt.body)) {
      try {
        await handleRest(host, port, protocol, user, pass, attempt.command, attempt.method, bodyVariant);
        return;
      } catch (err: any) {
        const errorObj = err instanceof Error ? err : new Error(String(err));
        lastError = errorObj;
        if (!isCompatibilityError(errorObj.message)) throw errorObj;
      }
    }
  }

  throw lastError || new Error("Failed to activate user-manager profile in REST mode");
}

async function handleRestWithCompat(
  host: string,
  port: string,
  protocol: string,
  user: string,
  pass: string,
  command: string,
  method?: string,
  restBody?: Record<string, any>,
): Promise<any> {
  if (!command.includes("user-manager")) {
    return handleRest(host, port, protocol, user, pass, command, method, restBody);
  }

  if (isUserManagerUserAddCommand(command)) {
    const username = restBody?.username || restBody?.name || restBody?.user;
    const profile = restBody?.profile || restBody?.group;
    const customer = restBody?.customer || restBody?.owner || "admin";

    // Fast path: try direct add with profile/group first
    let directError: Error | null = null;
    for (const bodyVariant of buildRestBodyVariants(command, restBody)) {
      try {
        return await handleRest(host, port, protocol, user, pass, command, method, bodyVariant);
      } catch (err: any) {
        const errorObj = err instanceof Error ? err : new Error(String(err));
        directError = errorObj;
        if (!isCompatibilityError(errorObj.message)) throw errorObj;
      }
    }

    // Fallback path: add user then activate profile
    const addBody = omitBodyKeys(restBody, ["profile", "group"]);

    let addResult: any;
    let addError: Error | null = directError;

    for (const bodyVariant of buildRestBodyVariants(command, addBody)) {
      try {
        addResult = await handleRest(host, port, protocol, user, pass, command, method, bodyVariant);
        addError = null;
        break;
      } catch (err: any) {
        const errorObj = err instanceof Error ? err : new Error(String(err));
        addError = errorObj;
        if (!isCompatibilityError(errorObj.message)) throw errorObj;
      }
    }

    if (addError) throw addError;

    if (username && profile) {
      await activateUserManagerProfileRest(host, port, protocol, user, pass, command, username, profile, customer);
    }

    return addResult;
  }

  // Try primary command with all body variants
  let lastError: Error | null = null;
  for (const bodyVariant of buildRestBodyVariants(command, restBody)) {
    try {
      return await handleRest(host, port, protocol, user, pass, command, method, bodyVariant);
    } catch (err: any) {
      const errorObj = err instanceof Error ? err : new Error(String(err));
      lastError = errorObj;
      if (!isCompatibilityError(errorObj.message)) throw errorObj;
    }
  }

  // Try v6 fallback path (/tool/user-manager/...)
  const fallbackCmd = getV6FallbackCommand(command);
  if (fallbackCmd) {
    for (const bodyVariant of buildRestBodyVariants(fallbackCmd, restBody)) {
      try {
        return await handleRest(host, port, protocol, user, pass, fallbackCmd, method, bodyVariant);
      } catch (err: any) {
        const errorObj = err instanceof Error ? err : new Error(String(err));
        lastError = errorObj;
        if (!isCompatibilityError(errorObj.message)) throw errorObj;
      }
    }
  }

  throw lastError || new Error("REST user-manager command failed");
}

// ─── API Protocol Handler (v6/v7) with compatibility mapping ────────────
async function handleApi(
  host: string, port: string, useTls: boolean,
  user: string, pass: string, command: string,
  args?: string[]
): Promise<any> {
  const client = await createApiClient(host, port, useTls, user, pass);
  try {
    if (command.includes("user-manager")) {
      return await executeUserManagerCompatible(client, command, args);
    }
    return await client.execute(command, args);
  } catch (err: any) {
    if (command.includes("user-manager") && err?.message?.includes("no such command")) {
      throw new Error("User Manager غير مثبّت على هذا الراوتر. يرجى تثبيت حزمة user-manager وإعادة التشغيل.");
    }
    throw err;
  } finally {
    client.close();
  }
}

// ─── Batch Handler: execute multiple commands over ONE connection ────────
async function handleBatch(
  host: string, port: string, useTls: boolean,
  user: string, pass: string,
  commands: { command: string; args?: string[] }[]
): Promise<{ results: any[]; errors: string[] }> {
  const client = await createApiClient(host, port, useTls, user, pass);
  const results: any[] = [];
  const errors: string[] = [];

  try {
    for (const cmd of commands) {
      try {
        const result = cmd.command.includes("user-manager")
          ? await executeUserManagerCompatible(client, cmd.command, cmd.args)
          : await client.execute(cmd.command, cmd.args);
        results.push(result);
        errors.push("");
      } catch (err: any) {
        errors.push(err.message || "Command failed");
        results.push(null);
      }
    }
  } finally {
    client.close();
  }

  return { results, errors };
}

// ─── Batch Handler for REST mode ────────────────────────────────────────
async function handleBatchRest(
  host: string, port: string, protocol: string,
  user: string, pass: string,
  commands: { command: string; args?: string[] }[]
): Promise<{ results: any[]; errors: string[] }> {
  const results: any[] = [];
  const errors: string[] = [];

  for (const cmd of commands) {
    try {
      const restBody = argsToRestBody(cmd.args);
      const method = getRestMethod(cmd.command);
      const r = await handleRestWithCompat(host, port, protocol, user, pass, cmd.command, method, restBody);
      results.push(r);
      errors.push("");
    } catch (e: any) {
      errors.push(e.message);
      results.push(null);
    }
  }

  return { results, errors };
}

// ─── Health Check ───────────────────────────────────────────────────────
async function handleHealthCheck(
  host: string, port: string, useTls: boolean,
  user: string, pass: string
): Promise<{ status: string; latency: number; version?: string }> {
  const start = Date.now();
  const client = await createApiClient(host, port, useTls, user, pass);
  try {
    const res = await client.execute("/system/resource/print");
    const latency = Date.now() - start;
    const version = res[0]?.version || "unknown";
    return { status: "online", latency, version };
  } finally {
    client.close();
  }
}

// ─── Main Handler ───────────────────────────────────────────────────────
serve(async (req) => {
  if (req.method === "OPTIONS") {
    return new Response(null, { headers: corsHeaders });
  }

  try {
    const body = await req.json();
    const { endpoint, host, user, pass, port, protocol, mode, action, args } = body;

    // ─── Port Scan Action ─────────────────────────────────────────
    if (action === "scan-ports") {
      if (!host) throw new Error("Missing host for port scan");
      const defaultPorts = [21, 22, 23, 53, 80, 443, 8080, 8291, 8728, 8729];
      const portsToScan = body.ports || defaultPorts;
      const results = await scanPorts(host, portsToScan);
      return new Response(JSON.stringify(results), {
        headers: { ...corsHeaders, "Content-Type": "application/json" },
      });
    }

    // ─── Health Check Action ──────────────────────────────────────
    if (action === "health-check") {
      if (!host || !user || !pass) throw new Error("Missing credentials for health check");
      const actualPort = port || "8728";
      const useTls = protocol === "api-ssl";
      
      if (mode === "api") {
        const result = await handleHealthCheck(host, actualPort, useTls, user, pass);
        return new Response(JSON.stringify(result), {
          headers: { ...corsHeaders, "Content-Type": "application/json" },
        });
      } else {
        const start = Date.now();
        const actualPort2 = port || (protocol === "https" ? "443" : "80");
        const actualProtocol = protocol || "https";
        const data = await handleRest(host, actualPort2, actualProtocol, user, pass, "/system/resource/print");
        const latency = Date.now() - start;
        const version = Array.isArray(data) ? data[0]?.version : data?.version;
        return new Response(JSON.stringify({ status: "online", latency, version }), {
          headers: { ...corsHeaders, "Content-Type": "application/json" },
        });
      }
    }

    // ─── Batch Action ─────────────────────────────────────────────
    if (action === "batch") {
      if (!host || !user || !pass) throw new Error("Missing credentials");
      const commands = body.commands as { command: string; args?: string[] }[];
      if (!Array.isArray(commands) || commands.length === 0) throw new Error("Missing commands array");
      
      if (mode === "api") {
        const actualPort = port || "8728";
        const useTls = protocol === "api-ssl";
        const result = await handleBatch(host, actualPort, useTls, user, pass, commands);
        return new Response(JSON.stringify(result), {
          headers: { ...corsHeaders, "Content-Type": "application/json" },
        });
      } else {
        const actualPort = port || (protocol === "https" ? "443" : "80");
        const actualProtocol = protocol || "https";
        const result = await handleBatchRest(host, actualPort, actualProtocol, user, pass, commands);
        return new Response(JSON.stringify(result), {
          headers: { ...corsHeaders, "Content-Type": "application/json" },
        });
      }
    }

    if (!host) throw new Error("Missing router address");
    if (!user) throw new Error("Missing username");
    if (!pass) throw new Error("Missing password");
    if (!endpoint) throw new Error("Missing endpoint/command");

    let data: any;

    if (mode === "api") {
      const actualPort = port || "8728";
      const useTls = protocol === "api-ssl";
      data = await handleApi(host, actualPort, useTls, user, pass, endpoint, args);
    } else {
      const actualPort = port || (protocol === "https" ? "443" : "80");
      const actualProtocol = protocol || "https";
      // Convert args to REST body for non-GET requests with compatibility remapping
      const restBody = argsToRestBody(args) || body.body;
      const method = body.method || getRestMethod(endpoint);
      data = await handleRestWithCompat(host, actualPort, actualProtocol, user, pass, endpoint, method, restBody);
    }

    return new Response(JSON.stringify(data), {
      headers: { ...corsHeaders, "Content-Type": "application/json" },
    });
  } catch (error: unknown) {
    console.error("MikroTik error:", error);
    const message = error instanceof Error ? error.message : "Unknown error";
    return new Response(JSON.stringify({ error: message }), {
      status: 200,
      headers: { ...corsHeaders, "Content-Type": "application/json" },
    });
  }
});
