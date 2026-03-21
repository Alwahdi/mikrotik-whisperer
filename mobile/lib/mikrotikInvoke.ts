import AsyncStorage from '@react-native-async-storage/async-storage';
import { supabase } from './supabase';

type MikrotikInvokeBody = {
  action?: string;
  endpoint?: string;
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
};

export type AgentHealthInfo = {
  ok: boolean;
  service?: string;
  version?: string;
  ts?: number;
  startedAt?: number;
  uptimeSec?: number;
  platform?: string;
  arch?: string;
  node?: string;
  error?: string;
};

const AGENT_URL_STORAGE_KEY = 'mikrotik_agent_url';
const inFlightLocalReads = new Map<string, Promise<unknown>>();

function delay(ms: number) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

function isPrivateIpv4(host: string) {
  return (
    /^10\.\d+\.\d+\.\d+$/.test(host) ||
    /^192\.168\.\d+\.\d+$/.test(host) ||
    /^172\.(1[6-9]|2\d|3[0-1])\.\d+\.\d+$/.test(host) ||
    /^(127\.0\.0\.1|localhost)$/i.test(host)
  );
}

export function isLocalHostTarget(host: string): boolean {
  const normalized = host.trim().toLowerCase();
  if (!normalized) return false;
  return isPrivateIpv4(normalized) || (!normalized.includes('.') && normalized.length > 0);
}

function normalizeAgentUrl(value?: string | null): string {
  if (!value) return '';
  return value.trim().replace(/\/+$/, '');
}

function getAgentEndpoint(agentUrl: string): string {
  try {
    const parsed = new URL(agentUrl);
    if (parsed.pathname && parsed.pathname !== '/') {
      return agentUrl;
    }
  } catch {
    return agentUrl;
  }
  return `${agentUrl}/api/mikrotik`;
}

let cachedAgentUrl: string | null = null;

export async function getMikrotikAgentUrl(): Promise<string> {
  if (cachedAgentUrl !== null) return cachedAgentUrl;
  try {
    const stored = await AsyncStorage.getItem(AGENT_URL_STORAGE_KEY);
    cachedAgentUrl = normalizeAgentUrl(stored) || 'http://127.0.0.1:3001';
    return cachedAgentUrl;
  } catch {
    return 'http://127.0.0.1:3001';
  }
}

export async function saveMikrotikAgentUrl(url: string): Promise<void> {
  const normalized = normalizeAgentUrl(url);
  cachedAgentUrl = normalized || 'http://127.0.0.1:3001';
  if (!normalized) {
    await AsyncStorage.removeItem(AGENT_URL_STORAGE_KEY);
    return;
  }
  await AsyncStorage.setItem(AGENT_URL_STORAGE_KEY, normalized);
}

async function invokeAgent(body: MikrotikInvokeBody, agentBaseUrl: string) {
  const timeoutMs = Math.max(3000, Math.min(body.timeoutMs ?? 20000, 70000));
  const controller = new AbortController();
  const timer = setTimeout(() => controller.abort(), timeoutMs);
  try {
    const response = await fetch(getAgentEndpoint(agentBaseUrl), {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(body),
      signal: controller.signal,
    });

    const payload = await response.json().catch(() => ({}));
    if (!response.ok) {
      throw new Error(payload?.error || 'Local agent request failed');
    }
    if (payload?.error) {
      throw new Error(payload.error);
    }
    return payload;
  } catch (error) {
    if (error instanceof Error && error.name === 'AbortError') {
      throw new Error(`Agent request timed out after ${timeoutMs}ms`);
    }
    throw error;
  } finally {
    clearTimeout(timer);
  }
}

async function invokeAgentWithRetry(body: MikrotikInvokeBody, agentBaseUrl: string) {
  const backoff = [0, 250, 700, 1500];
  let lastError: unknown = null;

  const isRetryable = (error: unknown) => {
    const msg = error instanceof Error ? error.message : '';
    if (!msg) return true;
    if (msg.includes('انتهت مهلة أمر API') || msg.includes('فشل تنفيذ أمر API')) return false;
    if (msg.includes('no such command') || msg.includes('unknown command')) return false;
    return true;
  };

  for (let i = 0; i < backoff.length; i++) {
    const waitMs = backoff[i];
    if (waitMs > 0) await delay(waitMs);
    try {
      return await invokeAgent(body, agentBaseUrl);
    } catch (error) {
      lastError = error;
      if (!isRetryable(error)) break;
    }
  }

  throw lastError instanceof Error ? lastError : new Error('Local agent request failed');
}

function hasUserManagerBatch(commands?: { command: string; args?: string[] }[]) {
  return !!commands?.some(
    (c) =>
      c.command?.startsWith('/user-manager/') || c.command?.startsWith('/tool/user-manager/')
  );
}

function toApiTransportFromRest(body: MikrotikInvokeBody): MikrotikInvokeBody {
  const isHttps = body.protocol === 'https';
  return {
    ...body,
    mode: 'api',
    protocol: isHttps ? 'api-ssl' : 'api-plain',
    port: isHttps ? '8729' : '8728',
  };
}

function normalizeForUserManager(body: MikrotikInvokeBody): MikrotikInvokeBody {
  const isRest = body.mode === 'rest';
  const endpointIsUserManager =
    body.endpoint?.startsWith('/user-manager/') ||
    body.endpoint?.startsWith('/tool/user-manager/');
  const batchHasUserManager = body.action === 'batch' && hasUserManagerBatch(body.commands);
  if (!isRest) return body;
  if (endpointIsUserManager || batchHasUserManager) {
    return toApiTransportFromRest(body);
  }
  return body;
}

function isReadOnlyInvoke(body: MikrotikInvokeBody) {
  if (body.action === 'health-check') return true;
  if (body.endpoint?.endsWith('/print')) return true;
  return false;
}

function localReadKey(agentUrl: string, body: MikrotikInvokeBody) {
  return `${agentUrl}|${JSON.stringify(body)}`;
}

async function invokeCloud(body: MikrotikInvokeBody) {
  const { data, error } = await supabase.functions.invoke('mikrotik-api', { body });
  if (error) throw error;
  if ((data as Record<string, unknown>)?.error) {
    const msg = (data as Record<string, unknown>).error as string;
    throw new Error(msg);
  }
  return data;
}

export async function getAgentHealth(baseUrl?: string): Promise<AgentHealthInfo> {
  const agentUrl = normalizeAgentUrl(baseUrl) || (await getMikrotikAgentUrl());
  if (!agentUrl) return { ok: false, error: 'Agent URL is empty' };

  const controller = new AbortController();
  const timer = setTimeout(() => controller.abort(), 4000);
  try {
    const response = await fetch(`${agentUrl}/api/health`, {
      method: 'GET',
      signal: controller.signal,
    });
    const payload = (await response.json().catch(() => ({}))) as AgentHealthInfo;
    if (!response.ok) {
      return { ok: false, error: payload?.error || `HTTP ${response.status}` };
    }
    return { ...payload, ok: !!payload?.ok };
  } catch (error) {
    return {
      ok: false,
      error: error instanceof Error ? error.message : 'Agent health check failed',
    };
  } finally {
    clearTimeout(timer);
  }
}

export async function checkAgentHealth(baseUrl?: string): Promise<boolean> {
  const info = await getAgentHealth(baseUrl);
  return info.ok;
}

export async function invokeMikrotik(body: MikrotikInvokeBody) {
  const normalizedBody = normalizeForUserManager(body);
  const host = normalizedBody.host?.trim();
  if (!host) throw new Error('عنوان الراوتر مطلوب');

  if (isLocalHostTarget(host)) {
    const agentUrl = await getMikrotikAgentUrl();
    const readonly = isReadOnlyInvoke(normalizedBody);
    const key = readonly ? localReadKey(agentUrl, normalizedBody) : '';
    try {
      if (!readonly) {
        return await invokeAgentWithRetry(normalizedBody, agentUrl);
      }

      const existing = inFlightLocalReads.get(key);
      if (existing) return existing;

      const promise = invokeAgentWithRetry(normalizedBody, agentUrl);
      inFlightLocalReads.set(key, promise);
      try {
        return await promise;
      } finally {
        inFlightLocalReads.delete(key);
      }
    } catch (error) {
      const msg = error instanceof Error ? error.message : 'Local agent request failed';
      throw new Error(`تعذر الوصول إلى CoreRoute Local Agent (${agentUrl}). ${msg}`);
    }
  }

  return invokeCloud(normalizedBody);
}

export const getMikrotikApiBridgeUrl = getMikrotikAgentUrl;
export const saveMikrotikApiBridgeUrl = saveMikrotikAgentUrl;
