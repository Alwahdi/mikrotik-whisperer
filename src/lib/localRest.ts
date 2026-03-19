/**
 * Direct local REST client for MikroTik routers.
 * When the browser is on the same LAN as the router (private IP),
 * we can skip the Supabase edge function and talk directly via REST API.
 */
import type { MikrotikConfig } from "./mikrotikConfig";

function isPrivateIp(host: string): boolean {
  const h = host.trim().toLowerCase();
  if (!h) return false;
  return (
    /^10\.\d+\.\d+\.\d+$/.test(h) ||
    /^192\.168\.\d+\.\d+$/.test(h) ||
    /^172\.(1[6-9]|2\d|3[0-1])\.\d+\.\d+$/.test(h) ||
    /^(127\.0\.0\.1|localhost)$/i.test(h) ||
    (!h.includes(".") && h.length > 0) // bare hostname like "mikrotik"
  );
}

export function shouldUseLocalRest(config: MikrotikConfig | null): boolean {
  if (!config) return false;
  return config.mode === "rest" && isPrivateIp(config.host);
}

function restMethod(command: string): "GET" | "PUT" | "PATCH" | "DELETE" {
  if (command.endsWith("/add")) return "PUT";
  if (command.endsWith("/set")) return "PATCH";
  if (command.endsWith("/remove")) return "DELETE";
  return "GET";
}

function argsToBody(args?: string[]): Record<string, string> | undefined {
  if (!args?.length) return undefined;
  const body: Record<string, string> = {};
  for (const arg of args) {
    if (!arg.startsWith("=")) continue;
    const idx = arg.indexOf("=", 1);
    if (idx <= 0) continue;
    body[arg.substring(1, idx)] = arg.substring(idx + 1);
  }
  return Object.keys(body).length > 0 ? body : undefined;
}

export async function localRestCall(
  config: MikrotikConfig,
  command: string,
  args?: string[],
): Promise<any> {
  const method = restMethod(command);
  let path = command
    .replace(/\/print$/, "")
    .replace(/\/set$/, "")
    .replace(/\/add$/, "")
    .replace(/\/remove$/, "");
  let body = argsToBody(args);

  if (method === "DELETE" && body?.[".id"]) {
    path = `${path}/${body[".id"]}`;
    const { ".id": _id, ...rest } = body;
    body = Object.keys(rest).length > 0 ? rest : undefined;
  }

  const controller = new AbortController();
  const timeout = setTimeout(() => controller.abort(), method === "GET" ? 15000 : 25000);

  try {
    const url = `${config.protocol}://${config.host}:${config.port}/rest${path}`;
    const response = await fetch(url, {
      method,
      headers: {
        Authorization: `Basic ${btoa(`${config.user}:${config.pass}`)}`,
        "Content-Type": "application/json",
      },
      body: body && method !== "GET" ? JSON.stringify(body) : undefined,
      signal: controller.signal,
    });

    const text = await response.text();
    let data: any = null;
    if (text) {
      try { data = JSON.parse(text); } catch { data = text; }
    }

    if (!response.ok) {
      const msg = typeof data === "string" ? data : JSON.stringify(data || {});
      throw new Error(`REST [${response.status}] ${msg.slice(0, 250)}`);
    }
    return data;
  } finally {
    clearTimeout(timeout);
  }
}

/** Execute a batch of commands locally with controlled concurrency */
export async function localRestBatch(
  config: MikrotikConfig,
  commands: { command: string; args?: string[] }[],
  concurrency = 2,
): Promise<{ results: any[]; errors: string[] }> {
  const conc = Math.max(1, Math.min(concurrency, 4));
  const results: any[] = new Array(commands.length);
  const errors: string[] = new Array(commands.length).fill("");
  let next = 0;

  const worker = async () => {
    while (next < commands.length) {
      const i = next++;
      try {
        results[i] = await localRestCall(config, commands[i].command, commands[i].args);
      } catch (err: any) {
        errors[i] = err?.message || "Command failed";
      }
    }
  };

  await Promise.all(Array.from({ length: Math.min(conc, commands.length || 1) }, worker));
  return { results, errors };
}
