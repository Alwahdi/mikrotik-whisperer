import { supabase } from "@/lib/supabase";
import type { MikrotikConfig } from "@/lib/mikrotikConfig";

function isIpv4Private(host: string) {
  return (
    /^10\.\d+\.\d+\.\d+$/.test(host) ||
    /^192\.168\.\d+\.\d+$/.test(host) ||
    /^172\.(1[6-9]|2\d|3[0-1])\.\d+\.\d+$/.test(host) ||
    /^(127\.0\.0\.1|localhost)$/i.test(host)
  );
}

export function isLocalHostTarget(host: string) {
  const normalized = host.trim().toLowerCase();
  if (!normalized) return false;
  return isIpv4Private(normalized) || (!normalized.includes(".") && normalized.length > 0);
}

export function shouldUseDirectLocalRest(config: MikrotikConfig | null) {
  if (!config) return false;
  return config.mode === "rest" && isLocalHostTarget(config.host);
}

function getRestMethod(command: string): "GET" | "PUT" | "PATCH" | "DELETE" {
  if (command.endsWith("/add")) return "PUT";
  if (command.endsWith("/set")) return "PATCH";
  if (command.endsWith("/remove")) return "DELETE";
  return "GET";
}

function argsToRestBody(args?: string[]) {
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

function toBasicAuth(user: string, pass: string) {
  return `Basic ${btoa(`${user}:${pass}`)}`;
}

async function readResponse(response: Response) {
  const text = await response.text();
  if (!text) return null;
  try {
    return JSON.parse(text);
  } catch {
    return text;
  }
}

export async function executeLocalRestCommand(
  config: MikrotikConfig,
  command: string,
  args?: string[],
) {
  const method = getRestMethod(command);
  let path = command.replace(/\/print$/, "").replace(/\/set$/, "").replace(/\/add$/, "").replace(/\/remove$/, "");
  let body = argsToRestBody(args);

  if (method === "DELETE" && body?.[".id"]) {
    path = `${path}/${body[".id"]}`;
    const { [".id"]: _id, ...rest } = body;
    body = Object.keys(rest).length > 0 ? rest : undefined;
  }

  const controller = new AbortController();
  const timeout = setTimeout(() => controller.abort(), method === "GET" ? 12000 : 20000);

  try {
    const response = await fetch(`${config.protocol}://${config.host}:${config.port}/rest${path}`, {
      method,
      headers: {
        Authorization: toBasicAuth(config.user, config.pass),
        "Content-Type": "application/json",
      },
      body: body && method !== "GET" ? JSON.stringify(body) : undefined,
      signal: controller.signal,
    });

    const data = await readResponse(response);
    if (!response.ok) {
      const message = typeof data === "string" ? data : JSON.stringify(data || {});
      throw new Error(`REST API [${response.status}] ${message.slice(0, 220)}`);
    }

    return data;
  } finally {
    clearTimeout(timeout);
  }
}

export async function runLocalRestBatch(
  config: MikrotikConfig,
  commands: { command: string; args?: string[] }[],
  options?: { concurrency?: number },
) {
  const concurrency = Math.max(1, Math.min(options?.concurrency ?? 2, 4));
  const results: any[] = new Array(commands.length);
  const errors: string[] = new Array(commands.length).fill("");
  let nextIndex = 0;

  const worker = async () => {
    while (nextIndex < commands.length) {
      const current = nextIndex++;
      const item = commands[current];
      try {
        results[current] = await executeLocalRestCommand(config, item.command, item.args);
      } catch (err: any) {
        errors[current] = err?.message || "Command failed";
      }
    }
  };

  await Promise.all(Array.from({ length: Math.min(concurrency, commands.length || 1) }, worker));
  return { results, errors };
}

export async function testMikrotikConnection(config: MikrotikConfig) {
  if (shouldUseDirectLocalRest(config)) {
    return executeLocalRestCommand(config, "/system/identity/print");
  }

  const { data, error } = await supabase.functions.invoke("mikrotik-api", {
    body: {
      endpoint: "/system/identity/print",
      host: config.host,
      user: config.user,
      pass: config.pass,
      port: config.port,
      protocol: config.protocol,
      mode: config.mode,
    },
  });

  if (error) throw error;
  if ((data as any)?.error) throw new Error((data as any).error);
  return data;
}
