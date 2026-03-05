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

// ─── v6/v7 command mapping ──────────────────────────────────────────────
function getV6FallbackCommand(command: string): string | null {
  if (command.startsWith("/user-manager/")) {
    return "/tool" + command;
  }
  return null;
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
  method: string = "GET", body?: any
): Promise<any> {
  const path = command.replace(/\/print$/, "").replace(/\/set$/, "").replace(/\/add$/, "").replace(/\/remove$/, "");
  const url = `${protocol}://${host}:${port}/rest${path}`;
  const credentials = btoa(`${user}:${pass}`);
  const controller = new AbortController();
  const timeout = setTimeout(() => controller.abort(), 15000);
  try {
    const fetchOpts: RequestInit = {
      method,
      headers: {
        Authorization: `Basic ${credentials}`,
        "Content-Type": "application/json",
      },
      signal: controller.signal,
    };
    if (body && method !== "GET") {
      fetchOpts.body = JSON.stringify(body);
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

// ─── API Protocol Handler (v6/v7) with FRESH connection for fallback ───
async function handleApi(
  host: string, port: string, useTls: boolean,
  user: string, pass: string, command: string,
  args?: string[]
): Promise<any> {
  // First try: v7 command
  const client1 = await createApiClient(host, port, useTls, user, pass);
  try {
    const result = await client1.execute(command, args);
    return result;
  } catch (err: any) {
    const fallback = getV6FallbackCommand(command);
    const isNoSuchCommand = err.message?.includes("no such command") || err.message?.includes("unknown command");
    
    if (!fallback || !isNoSuchCommand) {
      throw err;
    }
    
    console.log(`v7 failed, trying v6 fallback with NEW connection: ${fallback}`);
  } finally {
    client1.close();
  }

  // Second try: v6 fallback with a FRESH connection
  const fallbackCmd = getV6FallbackCommand(command)!;
  const client2 = await createApiClient(host, port, useTls, user, pass);
  try {
    return await client2.execute(fallbackCmd, args);
  } catch (e2: any) {
    if (e2.message?.includes("no such command")) {
      throw new Error("User Manager غير مثبّت على هذا الراوتر. يرجى تثبيت حزمة user-manager وإعادة التشغيل.");
    }
    throw e2;
  } finally {
    client2.close();
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
      const method = body.method || "GET";
      data = await handleRest(host, actualPort, actualProtocol, user, pass, endpoint, method, body.body);
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
