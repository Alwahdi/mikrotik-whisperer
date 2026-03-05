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
    if (useTls) {
      this.conn = await (Deno as any).connectTls({ hostname: host, port });
    } else {
      this.conn = await Deno.connect({ hostname: host, port });
    }
  }

  async close() {
    try { this.conn.close(); } catch { /* ignore */ }
  }

  // ── Read helpers ──
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

  // ── Write helpers ──
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

  // ── Sentence I/O ──
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
    await this.conn.write(new Uint8Array([0])); // end of sentence
  }

  // ── Login (supports v6 challenge + v6.43+ / v7 plain) ──
  async login(user: string, pass: string): Promise<void> {
    // Try new-style login (v6.43+, v7)
    await this.writeSentence(["/login", `=name=${user}`, `=password=${pass}`]);
    const sentence = await this.readSentence();

    if (sentence.length === 0) throw new Error("Empty login response");
    const type = sentence[0];

    if (type === "!trap") {
      const msg = parseAttrs(sentence).message || "Authentication failed";
      throw new Error(msg);
    }

    if (type === "!done") {
      // Check for old-style challenge
      const attrs = parseAttrs(sentence);
      if (attrs.ret) {
        // Old v6 challenge-response
        const response = await computeChallengeResponse(pass, attrs.ret);
        await this.writeSentence(["/login", `=name=${user}`, `=response=${response}`]);
        const s2 = await this.readSentence();
        if (s2[0] === "!trap") {
          throw new Error(parseAttrs(s2).message || "Authentication failed");
        }
      }
      return;
    }

    throw new Error(`Unexpected login response: ${type}`);
  }

  // ── Execute command ──
  async execute(command: string): Promise<Record<string, string>[]> {
    await this.writeSentence([command]);
    const results: Record<string, string>[] = [];

    while (true) {
      const sentence = await this.readSentence();
      if (sentence.length === 0) continue;
      const type = sentence[0];
      const attrs = parseAttrs(sentence);

      if (type === "!re") {
        results.push(attrs);
      } else if (type === "!done") {
        break;
      } else if (type === "!trap") {
        throw new Error(attrs.message || "Command failed");
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

// ─── REST API Handler (v7+) ─────────────────────────────────────────────
async function handleRest(
  host: string, port: string, protocol: string,
  user: string, pass: string, command: string
): Promise<any> {
  const path = command.replace(/\/print$/, "");
  const url = `${protocol}://${host}:${port}/rest${path}`;
  const credentials = btoa(`${user}:${pass}`);

  const response = await fetch(url, {
    method: "GET",
    headers: {
      Authorization: `Basic ${credentials}`,
      "Content-Type": "application/json",
    },
  });

  if (!response.ok) {
    const text = await response.text();
    throw new Error(`REST API [${response.status}]: ${text.substring(0, 200)}`);
  }

  return response.json();
}

// ─── API Protocol Handler (v6/v7) ───────────────────────────────────────
async function handleApi(
  host: string, port: string, useTls: boolean,
  user: string, pass: string, command: string
): Promise<any> {
  const client = new MikroTikApiClient();
  try {
    await client.connect(host, parseInt(port), useTls);
    await client.login(user, pass);
    const results = await client.execute(command);
    return results;
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
    const { endpoint, host, user, pass, port, protocol, mode } = body;

    if (!host) throw new Error("Missing router address");
    if (!user) throw new Error("Missing username");
    if (!pass) throw new Error("Missing password");
    if (!endpoint) throw new Error("Missing endpoint/command");

    let data: any;

    if (mode === "api") {
      // MikroTik API protocol (TCP port 8728/8729)
      const actualPort = port || "8728";
      const useTls = protocol === "api-ssl";
      data = await handleApi(host, actualPort, useTls, user, pass, endpoint);
    } else {
      // REST API (HTTP/HTTPS)
      const actualPort = port || (protocol === "https" ? "443" : "80");
      const actualProtocol = protocol || "https";
      data = await handleRest(host, actualPort, actualProtocol, user, pass, endpoint);
    }

    return new Response(JSON.stringify(data), {
      headers: { ...corsHeaders, "Content-Type": "application/json" },
    });
  } catch (error: unknown) {
    console.error("MikroTik error:", error);
    const message = error instanceof Error ? error.message : "Unknown error";
    return new Response(JSON.stringify({ error: message }), {
      status: 500,
      headers: { ...corsHeaders, "Content-Type": "application/json" },
    });
  }
});
