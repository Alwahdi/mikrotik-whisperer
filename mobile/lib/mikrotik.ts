import { supabase } from './supabase';

export type RouterCredentials = {
  id?: string;
  label?: string;
  host: string;
  port: string;
  username: string;
  password: string;
  protocol: string;
  mode: string;
};

type MikrotikInvokeBody = {
  action?: string;
  endpoint?: string;
  args?: string[];
  commands?: { command: string; args?: string[] }[];
  timeoutMs?: number;
} & RouterCredentials;

export async function invokeMikrotik(body: MikrotikInvokeBody) {
  const timeoutMs = Math.max(3000, Math.min(body.timeoutMs ?? 12000, 60000));
  const controller = new AbortController();
  const timer = setTimeout(() => controller.abort(), timeoutMs);

  try {
    const { data, error } = await supabase.functions.invoke('mikrotik-api', { body });
    if (error) {
      throw error;
    }

    if ((data as any)?.error) {
      throw new Error((data as any).error);
    }

    return data;
  } catch (err: any) {
    if (err?.name === 'AbortError') {
      throw new Error(`انتهت المهلة بعد ${timeoutMs}ms`);
    }
    throw err;
  } finally {
    clearTimeout(timer);
  }
}
