import { supabase } from "@/integrations/supabase/client";
import { addConnectionDebug } from "@/lib/connectionDebug";

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
    // UserManager is not consistently available via REST on many RouterOS builds.
    return toApiTransportFromRest(body);
  }
  return body;
}

async function invokeCloud(body: MikrotikInvokeBody) {
  const started = performance.now();
  const { data, error } = await supabase.functions.invoke("mikrotik-api", { body });
  if (error) {
    addConnectionDebug({
      id: crypto.randomUUID(),
      ts: Date.now(),
      route: "cloud",
      host: body.host,
      mode: body.mode,
      protocol: body.protocol,
      endpoint: body.endpoint,
      action: body.action,
      latencyMs: Math.round(performance.now() - started),
      status: "error",
      timeout: false,
      error: error.message,
    });
    throw error;
  }
  if ((data as Record<string, unknown>)?.error) {
    const msg = (data as Record<string, unknown>).error as string;
    addConnectionDebug({
      id: crypto.randomUUID(),
      ts: Date.now(),
      route: "cloud",
      host: body.host,
      mode: body.mode,
      protocol: body.protocol,
      endpoint: body.endpoint,
      action: body.action,
      latencyMs: Math.round(performance.now() - started),
      status: "error",
      timeout: false,
      error: msg,
    });
    throw new Error(msg);
  }
  addConnectionDebug({
    id: crypto.randomUUID(),
    ts: Date.now(),
    route: "cloud",
    host: body.host,
    mode: body.mode,
    protocol: body.protocol,
    endpoint: body.endpoint,
    action: body.action,
    latencyMs: Math.round(performance.now() - started),
    status: "ok",
    timeout: false,
  });
  return data;
}

export async function invokeMikrotik(body: MikrotikInvokeBody) {
  const normalizedBody = normalizeForUserManager(body);
  // When using routerId, the Edge Function resolves host/user/pass from the DB
  if (!normalizedBody.routerId) {
    const host = normalizedBody.host?.trim();
    if (!host) throw new Error("عنوان الراوتر مطلوب");
  }
  return invokeCloud(normalizedBody);
}
