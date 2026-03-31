import { supabase } from "@repo/database";
import { addConnectionDebug } from "./connectionDebug";

type MikrotikInvokeBody = {
  action?: string;
  endpoint?: string;
  routerId?: string;
  host?: string;
  user?: string;
  pass?: string;
  port?: string;
  protocol?: string;
  mode?: string;
  method?: string;
  timeoutMs?: number;
  args?: string[];
  commands?: { command: string; args?: string[] }[];
  jobKey?: string;
  userId?: string;
  label?: string;
  profileName?: string;
  salesPoint?: string;
  voucherType?: string;
  unitPrice?: number;
};

function hasUserManagerBatch(commands?: { command: string; args?: string[] }[]) {
  return !!commands?.some((c) => c.command?.startsWith("/user-manager/") || c.command?.startsWith("/tool/user-manager/"));
}

function toApiTransportFromRest(body: MikrotikInvokeBody): MikrotikInvokeBody {
  const isHttps = body.protocol === "https";
  return {
    ...body,
    mode: "api",
    protocol: isHttps ? "api-ssl" : "api-plain",
    port: isHttps ? "8729" : "8728",
  };
}

function normalizeForUserManager(body: MikrotikInvokeBody): MikrotikInvokeBody {
  const isRest = body.mode === "rest";
  const endpointIsUserManager = body.endpoint?.startsWith("/user-manager/") || body.endpoint?.startsWith("/tool/user-manager/");
  const batchHasUserManager = body.action === "batch" && hasUserManagerBatch(body.commands);
  if (!isRest) return body;
  if (endpointIsUserManager || batchHasUserManager) {
    return toApiTransportFromRest(body);
  }
  return body;
}

function logDebug(
  route: "server" | "cloud",
  body: MikrotikInvokeBody,
  latencyMs: number,
  status: "ok" | "error",
  error?: string,
) {
  addConnectionDebug({
    id: crypto.randomUUID(),
    ts: Date.now(),
    route,
    host: body.host,
    mode: body.mode,
    protocol: body.protocol,
    endpoint: body.endpoint,
    action: body.action,
    latencyMs,
    status,
    timeout: false,
    error,
  });
}

/**
 * Invoke via Next.js API route (server-side proxy).
 * This is faster because the server→Supabase call happens on the internal network.
 */
async function invokeViaServer(body: MikrotikInvokeBody, signal?: AbortSignal) {
  const started = performance.now();
  const response = await fetch("/api/mikrotik", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body),
    signal,
  });

  const latencyMs = Math.round(performance.now() - started);

  if (!response.ok) {
    const errorData = await response.json().catch(() => ({ error: "Server error" }));
    const msg = (errorData as Record<string, unknown>).error as string || `HTTP ${response.status}`;
    logDebug("server", body, latencyMs, "error", msg);
    throw new Error(msg);
  }

  const data = await response.json();

  if (data && typeof data === "object" && "error" in data) {
    const msg = (data as Record<string, unknown>).error as string;
    logDebug("server", body, latencyMs, "error", msg);
    throw new Error(msg);
  }

  logDebug("server", body, latencyMs, "ok");
  return data;
}

/**
 * Invoke via direct Supabase Edge Function (client-side fallback).
 */
async function invokeCloud(body: MikrotikInvokeBody, signal?: AbortSignal) {
  const started = performance.now();
  const { data, error } = await supabase.functions.invoke("mikrotik-api", { body, signal });
  const latencyMs = Math.round(performance.now() - started);

  if (error) {
    logDebug("cloud", body, latencyMs, "error", error.message);
    throw error;
  }
  if ((data as Record<string, unknown>)?.error) {
    const msg = (data as Record<string, unknown>).error as string;
    logDebug("cloud", body, latencyMs, "error", msg);
    throw new Error(msg);
  }
  logDebug("cloud", body, latencyMs, "ok");
  return data;
}

export async function invokeMikrotik(body: MikrotikInvokeBody, signal?: AbortSignal) {
  const normalizedBody = normalizeForUserManager(body);
  if (!normalizedBody.routerId) {
    const host = normalizedBody.host?.trim();
    if (!host) throw new Error("عنوان الراوتر مطلوب");
  }

  // Try server-side API route first (faster), fall back to direct Supabase client
  try {
    return await invokeViaServer(normalizedBody, signal);
  } catch {
    // If the API route is unavailable (e.g. dev mode, network issue),
    // fall back to the direct Supabase Edge Function call
    return await invokeCloud(normalizedBody, signal);
  }
}
