import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useEffect, useState } from 'react';
import { Alert } from 'react-native';
import { getMikrotikConfig, MikrotikConfig } from '@/lib/mikrotikConfig';
import { invokeMikrotik } from '@/lib/mikrotikInvoke';

// ─── Router key hook (async config) ────────────
export function useRouterKey(): string {
  const [key, setKey] = useState<string>('none');
  useEffect(() => {
    getMikrotikConfig().then((cfg) => {
      setKey(cfg ? `${cfg.host}:${cfg.port}` : 'none');
    });
  }, []);
  return key;
}

export function useCurrentConfig(): MikrotikConfig | null {
  const [config, setConfig] = useState<MikrotikConfig | null>(null);
  useEffect(() => {
    getMikrotikConfig().then(setConfig);
  }, []);
  return config;
}

function isLikelyLocalHost(host?: string): boolean {
  if (!host) return false;
  const normalized = host.trim().toLowerCase();
  return (
    /^10\.\d+\.\d+\.\d+$/.test(normalized) ||
    /^192\.168\.\d+\.\d+$/.test(normalized) ||
    /^172\.(1[6-9]|2\d|3[0-1])\.\d+\.\d+$/.test(normalized) ||
    /^(127\.0\.0\.1|localhost)$/i.test(normalized) ||
    (!normalized.includes('.') && normalized.length > 0)
  );
}

async function callMikrotikApi(
  endpoint: string,
  extraBody?: Record<string, unknown>
): Promise<unknown> {
  const config = await getMikrotikConfig();
  if (!config) throw new Error('لم يتم إعداد بيانات الاتصال بالمايكروتيك');

  const timeoutMs =
    (extraBody?.timeoutMs as number | undefined) ??
    (endpoint.endsWith('/print') ? 30000 : 15000);
  const { timeoutMs: _t, ...safeExtra } = extraBody || {};

  return invokeMikrotik({
    endpoint,
    host: config.host,
    user: config.user,
    pass: config.pass,
    port: config.port,
    protocol: config.protocol,
    mode: config.mode,
    timeoutMs,
    ...safeExtra,
  });
}

async function callMikrotikAction(
  action: string,
  extraBody?: Record<string, unknown>
): Promise<unknown> {
  const config = await getMikrotikConfig();
  if (!config) throw new Error('لم يتم إعداد بيانات الاتصال بالمايكروتيك');

  const timeoutMs =
    (extraBody?.timeoutMs as number | undefined) ?? (action === 'batch' ? 70000 : 20000);
  const { timeoutMs: _t, ...safeExtra } = extraBody || {};

  return invokeMikrotik({
    action,
    host: config.host,
    user: config.user,
    pass: config.pass,
    port: config.port,
    protocol: config.protocol,
    mode: config.mode,
    timeoutMs,
    ...safeExtra,
  });
}

function showToast(message: string, type: 'success' | 'error' | 'warning' = 'success') {
  // Using Alert for simple toast-like messages in RN
  if (type === 'error') {
    Alert.alert('خطأ', message);
  }
  // Success/warning messages can be shown via Alert or ignored silently
}

async function getEnabled(): Promise<boolean> {
  const config = await getMikrotikConfig();
  return !!config;
}

const CACHE_OPTIONS = {
  staleTime: 10000,
  gcTime: 3 * 60 * 1000,
} as const;

// ─── Health Check ───────────────────────────────
export function useRouterHealth(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'health'],
    queryFn: () => callMikrotikAction('health-check'),
    refetchInterval: 30000,
    enabled: routerKey !== 'none',
    ...CACHE_OPTIONS,
  });
}

// ─── Batch Operations ───────────────────────────
export function useBatchAction(routerKey: string) {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({
      commands,
    }: {
      commands: { command: string; args?: string[] }[];
      invalidateKeys?: string[];
    }) => callMikrotikAction('batch', { commands }),
    onSuccess: (data, variables) => {
      const keys = variables.invalidateKeys || [];
      keys.forEach((key) =>
        qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, key] })
      );
      const result = data as Record<string, unknown>;
      const errors = (result?.errors as string[])?.filter((e) => e) || [];
      const total = (result?.results as unknown[])?.length || 0;
      const failed = errors.length;
      if (failed > 0) {
        showToast(`نجح ${total - failed} من ${total} — فشل ${failed}`, 'warning');
      }
    },
    onError: (err: Error) => {
      showToast(err.message || 'فشلت العملية', 'error');
    },
  });
}

export function useRawBatchAction() {
  return useMutation({
    mutationFn: async ({
      commands,
    }: {
      commands: { command: string; args?: string[] }[];
    }) => callMikrotikAction('batch', { commands }),
  });
}

// ─── Hotspot ────────────────────────────────────
export function useHotspotUsers(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'hotspot', 'active'],
    queryFn: () => callMikrotikApi('/ip/hotspot/active/print'),
    refetchInterval: 10000,
    enabled: routerKey !== 'none',
    ...CACHE_OPTIONS,
  });
}

export function useHotspotProfiles(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'hotspot', 'profiles'],
    queryFn: () => callMikrotikApi('/ip/hotspot/user/profile/print'),
    enabled: routerKey !== 'none',
    staleTime: 60000,
    gcTime: 10 * 60 * 1000,
  });
}

export function useHotspotAllUsers(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'hotspot', 'users'],
    queryFn: () => callMikrotikApi('/ip/hotspot/user/print'),
    enabled: routerKey !== 'none',
    ...CACHE_OPTIONS,
  });
}

export function useHotspotUserAction(routerKey: string) {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({
      action,
      id,
      data,
    }: {
      action: string;
      id?: string;
      data?: Record<string, string>;
    }) => {
      const args: string[] = [];
      if (id) args.push(`=.id=${id}`);
      if (data) {
        for (const [k, v] of Object.entries(data)) args.push(`=${k}=${v}`);
      }

      const endpointMap: Record<string, string> = {
        disable: '/ip/hotspot/user/set',
        enable: '/ip/hotspot/user/set',
        remove: '/ip/hotspot/user/remove',
        add: '/ip/hotspot/user/add',
        kick: '/ip/hotspot/active/remove',
      };

      const finalArgs = [...args];
      if (action === 'disable') finalArgs.push('=disabled=true');
      if (action === 'enable') finalArgs.push('=disabled=false');

      return callMikrotikApi(endpointMap[action] || `/ip/hotspot/user/${action}`, {
        args: finalArgs,
      });
    },
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, 'hotspot'] });
    },
    onError: (err: Error) => {
      showToast(err.message || 'فشلت العملية', 'error');
    },
  });
}

// ─── User Manager ───────────────────────────────
export function useUserManagerUsers(routerKey: string, options?: { enabled?: boolean }) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'usermanager', 'users'],
    queryFn: () =>
      callMikrotikApi('/user-manager/user/print', {
        args: ['=.proplist=.id,username,name,group,actual-profile,disabled'],
        timeoutMs: 45000,
      }),
    enabled: (options?.enabled ?? true) && routerKey !== 'none',
    retry: 1,
    refetchInterval: false,
    refetchOnWindowFocus: false,
    staleTime: 5 * 60 * 1000,
    gcTime: 10 * 60 * 1000,
  });
}

export function useUserManagerCount(routerKey: string, options?: { enabled?: boolean }) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'usermanager', 'count'],
    queryFn: async () => {
      const parseCount = (payload: unknown) => {
        const list = Array.isArray(payload) ? payload : [];
        const row = (list[0] as Record<string, unknown>) || {};
        const retRaw = row.ret ?? row['=ret'];
        const count = Number(retRaw ?? 0);
        return Number.isFinite(count) && count >= 0 ? count : null;
      };

      let totalData: unknown = [];
      try {
        totalData = await callMikrotikApi('/user-manager/user/print', {
          args: ['=count-only='],
          timeoutMs: 15000,
        });
      } catch {
        return { total: 0, active: 0, disabled: 0 };
      }

      let disabledData: unknown = [];
      try {
        disabledData = await callMikrotikApi('/user-manager/user/print', {
          args: ['=count-only=', '?disabled=true'],
          timeoutMs: 15000,
        });
      } catch {
        const total = parseCount(totalData);
        if (total !== null) return { total, active: total, disabled: 0 };
        return { total: 0, active: 0, disabled: 0 };
      }

      const total = parseCount(totalData);
      const disabled = parseCount(disabledData);
      if (total !== null && disabled !== null) {
        return { total, disabled, active: Math.max(0, total - disabled) };
      }

      const list = Array.isArray(totalData) ? totalData : [];
      return {
        total: list.length,
        active: list.filter(
          (u: Record<string, unknown>) => u.disabled !== 'true' && u.disabled !== true
        ).length,
        disabled: list.filter(
          (u: Record<string, unknown>) => u.disabled === 'true' || u.disabled === true
        ).length,
      };
    },
    enabled: (options?.enabled ?? true) && routerKey !== 'none',
    retry: 1,
    refetchInterval: false,
    staleTime: 10 * 60 * 1000,
    gcTime: 10 * 60 * 1000,
  });
}

export function useUserManagerSearchUsers(
  routerKey: string,
  search: string,
  options?: { enabled?: boolean }
) {
  const hasSearch = search.trim().length >= 2;
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'usermanager', 'search', search],
    queryFn: () => {
      const args = ['=.proplist=.id,username,name,group,actual-profile,disabled'];
      if (hasSearch) {
        args.push(`?username=${search.trim()}`);
        args.push(`?name=${search.trim()}`);
        args.push('?#|');
      }
      return callMikrotikApi('/user-manager/user/print', { args, timeoutMs: 45000 });
    },
    enabled: (options?.enabled ?? true) && hasSearch && routerKey !== 'none',
    retry: 1,
    refetchInterval: false,
    staleTime: 30000,
    gcTime: 2 * 60 * 1000,
  });
}

export function useUserManagerProfiles(routerKey: string, options?: { enabled?: boolean }) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'usermanager', 'profiles'],
    queryFn: () =>
      callMikrotikApi('/user-manager/profile/print', {
        args: [
          '=.proplist=.id,name,name-for-users,validity,price,rate-limit,shared-users,override-shared-users,transfer-limit,uptime-limit',
        ],
      }),
    enabled: (options?.enabled ?? true) && routerKey !== 'none',
    retry: 2,
    staleTime: 60000,
    gcTime: 10 * 60 * 1000,
  });
}

export function useUserManagerSessions(routerKey: string, options?: { enabled?: boolean }) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'usermanager', 'sessions'],
    queryFn: () =>
      callMikrotikApi('/user-manager/session/print', {
        args: ['=.proplist=.id,user,customer,from-time,till-time,active'],
        timeoutMs: 45000,
      }),
    enabled: (options?.enabled ?? true) && routerKey !== 'none',
    retry: 1,
    refetchInterval: false,
    staleTime: 120000,
    gcTime: 10 * 60 * 1000,
  });
}

export function useUserManagerAction(routerKey: string) {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({
      action,
      id,
      data,
    }: {
      action: string;
      id?: string;
      data?: Record<string, string>;
    }) => {
      const args: string[] = [];
      if (id) args.push(`=.id=${id}`);
      if (data) {
        for (const [k, v] of Object.entries(data)) args.push(`=${k}=${v}`);
      }

      const endpointMap: Record<string, string> = {
        disable: '/user-manager/user/set',
        enable: '/user-manager/user/set',
        remove: '/user-manager/user/remove',
        add: '/user-manager/user/add',
      };

      const finalArgs = [...args];
      if (action === 'disable') finalArgs.push('=disabled=true');
      if (action === 'enable') finalArgs.push('=disabled=false');

      return callMikrotikApi(endpointMap[action] || `/user-manager/user/${action}`, {
        args: finalArgs,
      });
    },
    onSuccess: (_data, { action }) => {
      qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, 'usermanager', 'count'] });
      setTimeout(() => {
        qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, 'usermanager', 'users'] });
      }, 1200);
    },
    onError: (err: Error) => {
      showToast(err.message || 'فشلت العملية', 'error');
    },
  });
}

export function useUserManagerProfileAction(routerKey: string) {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({
      action,
      id,
      data,
    }: {
      action: string;
      id?: string;
      data?: Record<string, string>;
    }) => {
      const args: string[] = [];
      if (id) args.push(`=.id=${id}`);
      if (data) {
        for (const [k, v] of Object.entries(data)) {
          if (v !== undefined && v !== null && `${v}` !== '') args.push(`=${k}=${v}`);
        }
      }

      const endpointMap: Record<string, string> = {
        add: '/user-manager/profile/add',
        set: '/user-manager/profile/set',
        remove: '/user-manager/profile/remove',
      };

      return callMikrotikApi(endpointMap[action] || `/user-manager/profile/${action}`, {
        args,
      });
    },
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, 'usermanager', 'profiles'] });
      qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, 'usermanager', 'users'] });
    },
    onError: (err: Error) => {
      showToast(err.message || 'فشل حفظ الباقة', 'error');
    },
  });
}

export interface BatchAddUser {
  username: string;
  password: string;
  group: string;
}

export interface BatchAddResult {
  total: number;
  succeeded: number;
  failed: number;
  errors: { username: string; error: string }[];
}

export function useUserManagerBatchAdd(routerKey: string) {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({
      users,
      onProgress,
    }: {
      users: BatchAddUser[];
      onProgress?: (done: number, total: number) => void;
    }): Promise<BatchAddResult> => {
      const config = await getMikrotikConfig();
      if (!config) throw new Error('لم يتم إعداد بيانات الاتصال');

      const isRestMode = config.mode === 'rest';
      const chunkSize = isRestMode ? 6 : 40;
      const concurrency = isRestMode ? 1 : 4;

      const errors: { username: string; error: string }[] = [];
      let succeeded = 0;
      let done = 0;

      const chunks: BatchAddUser[][] = [];
      for (let i = 0; i < users.length; i += chunkSize) {
        chunks.push(users.slice(i, i + chunkSize));
      }

      let nextChunk = 0;

      const isDuplicate = (msg: string) => {
        const m = msg.toLowerCase();
        return m.includes('already') || m.includes('exists') || m.includes('same name');
      };

      const processChunk = async (chunk: BatchAddUser[]) => {
        const commands = chunk.map((u) => ({
          command: '/user-manager/user/add',
          args: [
            `=username=${u.username}`,
            `=password=${u.password}`,
            `=group=${u.group}`,
            '=owner=admin',
          ],
        }));

        try {
          const result = (await callMikrotikAction('batch', { commands })) as Record<
            string,
            unknown
          >;
          const errs = Array.isArray(result?.errors) ? result.errors : [];
          for (let j = 0; j < chunk.length; j++) {
            const msg = typeof errs[j] === 'string' ? (errs[j] as string).trim() : '';
            if (!msg || isDuplicate(msg)) {
              succeeded++;
            } else {
              errors.push({ username: chunk[j].username, error: msg });
            }
          }
        } catch (err: unknown) {
          const msg = err instanceof Error ? err.message : 'فشل التنفيذ';
          for (const u of chunk) {
            errors.push({ username: u.username, error: msg });
          }
        }

        done += chunk.length;
        onProgress?.(done, users.length);
      };

      const worker = async () => {
        while (true) {
          const idx = nextChunk++;
          if (idx >= chunks.length) break;
          await processChunk(chunks[idx]);
        }
      };

      await Promise.all(
        Array.from({ length: Math.min(concurrency, chunks.length) }, () => worker())
      );

      return { total: users.length, succeeded, failed: errors.length, errors };
    },
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, 'usermanager', 'users'] });
      qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, 'usermanager', 'count'] });
    },
    onError: (err: Error) => {
      showToast(err.message || 'فشلت عملية الإضافة', 'error');
    },
  });
}

// ─── System ─────────────────────────────────────
export function useSystemResources(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'system', 'resource'],
    queryFn: async () => {
      const data = await callMikrotikApi('/system/resource/print');
      return Array.isArray(data) ? (data[0] as Record<string, unknown>) || {} : data;
    },
    refetchInterval: 15000,
    enabled: routerKey !== 'none',
    ...CACHE_OPTIONS,
  });
}

export function useSystemIdentity(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'system', 'identity'],
    queryFn: async () => {
      const data = await callMikrotikApi('/system/identity/print');
      return Array.isArray(data) ? (data[0] as Record<string, unknown>) || {} : data;
    },
    enabled: routerKey !== 'none',
    staleTime: 120000,
  });
}

export function useRouterboard(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'system', 'routerboard'],
    queryFn: async () => {
      const data = await callMikrotikApi('/system/routerboard/print');
      return Array.isArray(data) ? (data[0] as Record<string, unknown>) || {} : data;
    },
    enabled: routerKey !== 'none',
    staleTime: 120000,
  });
}

// ─── Interfaces ──────────────────────────────────
export function useInterfaces(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'interface'],
    queryFn: () => callMikrotikApi('/interface/print'),
    refetchInterval: 10000,
    enabled: routerKey !== 'none',
    ...CACHE_OPTIONS,
  });
}

export function useDHCPLeases(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'dhcp', 'leases'],
    queryFn: () => callMikrotikApi('/ip/dhcp-server/lease/print'),
    refetchInterval: 30000,
    enabled: routerKey !== 'none',
    ...CACHE_OPTIONS,
  });
}

export function useIPAddresses(routerKey: string) {
  return useQuery({
    queryKey: ['mikrotik', routerKey, 'ip', 'address'],
    queryFn: () => callMikrotikApi('/ip/address/print'),
    enabled: routerKey !== 'none',
    ...CACHE_OPTIONS,
  });
}

export function useMikrotikCommand() {
  return useMutation({
    mutationFn: async ({
      endpoint,
      args,
    }: {
      endpoint: string;
      args?: string[];
    }) => callMikrotikApi(endpoint, args ? { args } : undefined),
  });
}
