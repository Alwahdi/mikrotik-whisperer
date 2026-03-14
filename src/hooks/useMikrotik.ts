import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { toast } from "sonner";

// Router-scoped cache key prefix to prevent cross-router data leaks
function getRouterKey(): string {
  const config = getMikrotikConfig();
  return config ? `${config.host}:${config.port}` : "none";
}

async function callMikrotikApi(endpoint: string, extraBody?: Record<string, any>) {
  const config = getMikrotikConfig();
  if (!config) throw new Error("لم يتم إعداد بيانات الاتصال بالمايكروتيك");

  const timeoutMs = extraBody?.timeoutMs ?? (endpoint.endsWith("/print") ? 30000 : 15000);
  const { timeoutMs: _timeoutMs, ...safeExtraBody } = extraBody || {};

  const request = supabase.functions.invoke("mikrotik-api", {
    body: {
      endpoint,
      host: config.host,
      user: config.user,
      pass: config.pass,
      port: config.port,
      protocol: config.protocol,
      mode: config.mode,
      ...safeExtraBody,
    },
  });

  const response = await Promise.race([
    request,
    new Promise<never>((_, reject) => {
      setTimeout(() => reject(new Error(`انتهت مهلة الطلب: ${endpoint}`)), timeoutMs);
    }),
  ]) as any;

  const { data, error } = response;
  if (error) throw error;
  if (data?.error) throw new Error(data.error);
  return data;
}

async function callMikrotikAction(action: string, extraBody?: Record<string, any>) {
  const config = getMikrotikConfig();
  if (!config) throw new Error("لم يتم إعداد بيانات الاتصال بالمايكروتيك");

  const timeoutMs = extraBody?.timeoutMs ?? (action === "batch" ? 70000 : 20000);
  const { timeoutMs: _timeoutMs, ...safeExtraBody } = extraBody || {};

  const request = supabase.functions.invoke("mikrotik-api", {
    body: {
      action,
      host: config.host,
      user: config.user,
      pass: config.pass,
      port: config.port,
      protocol: config.protocol,
      mode: config.mode,
      ...safeExtraBody,
    },
  });

  const response = await Promise.race([
    request,
    new Promise<never>((_, reject) => {
      setTimeout(() => reject(new Error(`انتهت مهلة العملية: ${action}`)), timeoutMs);
    }),
  ]) as any;

  const { data, error } = response;
  if (error) throw error;
  if (data?.error) throw new Error(data.error);
  return data;
}

function useEnabled() {
  return !!getMikrotikConfig();
}

const CACHE_OPTIONS = {
  staleTime: 10000,
  gcTime: 3 * 60 * 1000,
};

// ─── Health Check ──────────────────────────────
export function useRouterHealth() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "health"],
    queryFn: () => callMikrotikAction("health-check"),
    refetchInterval: 30000,
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}

// ─── Batch Operations ──────────────────────────
export function useBatchAction() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({ commands, invalidateKeys }: {
      commands: { command: string; args?: string[] }[];
      invalidateKeys?: string[];
    }) => {
      return callMikrotikAction("batch", { commands });
    },
    onSuccess: (data, variables) => {
      const routerKey = getRouterKey();
      const keys = variables.invalidateKeys || [];
      keys.forEach(key => qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, key] }));
      const errors = data?.errors?.filter((e: string) => e) || [];
      const total = data?.results?.length || 0;
      const failed = errors.length;
      if (failed === 0) {
        toast.success(`تم تنفيذ ${total} عملية بنجاح`);
      } else {
        toast.warning(`نجح ${total - failed} من ${total} — فشل ${failed}`);
      }
    },
    onError: (err: any) => {
      toast.error(err.message || "فشلت العملية");
    },
  });
}

// ─── Raw batch without toast (for voucher page) ─────
export function useRawBatchAction() {
  return useMutation({
    mutationFn: async ({ commands }: {
      commands: { command: string; args?: string[] }[];
    }) => {
      return callMikrotikAction("batch", { commands });
    },
  });
}

// ─── Hotspot ───────────────────────────────
export function useHotspotUsers() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "hotspot", "active"],
    queryFn: () => callMikrotikApi("/ip/hotspot/active/print"),
    refetchInterval: 10000,
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}
export function useHotspotProfiles() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "hotspot", "profiles"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/profile/print"),
    enabled: useEnabled(),
    staleTime: 60000,
    gcTime: 10 * 60 * 1000,
  });
}
export function useHotspotAllUsers() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "hotspot", "users"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/print"),
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}

// ─── Hotspot Mutations ─────────────────────
export function useHotspotUserAction() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({ action, id, data }: { action: string; id?: string; data?: Record<string, any> }) => {
      const args: string[] = [];
      if (id) args.push(`=.id=${id}`);
      if (data) {
        for (const [k, v] of Object.entries(data)) args.push(`=${k}=${v}`);
      }
      
      const endpointMap: Record<string, string> = {
        disable: "/ip/hotspot/user/set",
        enable: "/ip/hotspot/user/set",
        remove: "/ip/hotspot/user/remove",
        add: "/ip/hotspot/user/add",
        kick: "/ip/hotspot/active/remove",
      };
      
      const finalArgs = [...args];
      if (action === "disable") finalArgs.push("=disabled=true");
      if (action === "enable") finalArgs.push("=disabled=false");
      
      return callMikrotikApi(endpointMap[action] || `/ip/hotspot/user/${action}`, { args: finalArgs });
    },
    onSuccess: () => {
      const routerKey = getRouterKey();
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "hotspot"] });
      toast.success("تم تنفيذ العملية بنجاح");
    },
    onError: (err: any) => {
      toast.error(err.message || "فشلت العملية");
    },
  });
}

// ─── User Manager ──────────────────────────
export function useUserManagerUsers(options?: { enabled?: boolean }) {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "usermanager", "users"],
    queryFn: () => callMikrotikApi("/user-manager/user/print", {
      args: ["=.proplist=.id,username,name,group,actual-profile,disabled"],
    }),
    enabled: (options?.enabled ?? true) && useEnabled(),
    retry: 1,
    refetchInterval: false,
    refetchOnWindowFocus: false,
    staleTime: 5 * 60 * 1000,
    gcTime: 10 * 60 * 1000,
  });
}

// Count-only query for dashboard stats (fast, minimal payload)
export function useUserManagerCount(options?: { enabled?: boolean }) {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "usermanager", "count"],
    queryFn: async () => {
      const data = await callMikrotikApi("/user-manager/user/print", {
        args: ["=.proplist=.id,disabled"],
      });
      const list = Array.isArray(data) ? data : [];
      return {
        total: list.length,
        active: list.filter((u: any) => u.disabled !== "true" && u.disabled !== true).length,
        disabled: list.filter((u: any) => u.disabled === "true" || u.disabled === true).length,
      };
    },
    enabled: (options?.enabled ?? true) && useEnabled(),
    retry: 1,
    refetchInterval: false,
    refetchOnWindowFocus: false,
    staleTime: 3 * 60 * 1000,
    gcTime: 10 * 60 * 1000,
  });
}

// Server-side filtered query via .query
export function useUserManagerSearchUsers(search: string, options?: { enabled?: boolean }) {
  const routerKey = getRouterKey();
  const hasSearch = search.trim().length >= 2;
  return useQuery({
    queryKey: ["mikrotik", routerKey, "usermanager", "search", search],
    queryFn: () => {
      const args = ["=.proplist=.id,username,name,group,actual-profile,disabled"];
      if (hasSearch) {
        // MikroTik API query: search by username containing the term
        args.push(`?username=${search.trim()}`);
        args.push(`?name=${search.trim()}`);
        args.push("?#|");
      }
      return callMikrotikApi("/user-manager/user/print", { args });
    },
    enabled: (options?.enabled ?? true) && hasSearch && useEnabled(),
    retry: 1,
    refetchInterval: false,
    refetchOnWindowFocus: false,
    staleTime: 30000,
    gcTime: 2 * 60 * 1000,
  });
}
export function useUserManagerProfiles(options?: { enabled?: boolean }) {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "usermanager", "profiles"],
    queryFn: () => callMikrotikApi("/user-manager/profile/print", {
      args: ["=.proplist=.id,name,name-for-users,validity,price,rate-limit,shared-users,override-shared-users,transfer-limit,uptime-limit"],
    }),
    enabled: (options?.enabled ?? true) && useEnabled(),
    retry: 1,
    staleTime: 60000,
    gcTime: 10 * 60 * 1000,
  });
}
export function useUserManagerSessions(options?: { enabled?: boolean }) {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "usermanager", "sessions"],
    queryFn: () => callMikrotikApi("/user-manager/session/print", {
      args: ["=.proplist=.id,user,customer,from-time,till-time,active"],
    }),
    enabled: (options?.enabled ?? true) && useEnabled(),
    retry: 1,
    refetchInterval: false,
    refetchOnWindowFocus: false,
    staleTime: 120000,
    gcTime: 10 * 60 * 1000,
  });
}

// ─── User Manager Mutations ────────────────
export function useUserManagerAction() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({ action, id, data }: { action: string; id?: string; data?: Record<string, any> }) => {
      const args: string[] = [];
      if (id) args.push(`=.id=${id}`);
      if (data) {
        for (const [k, v] of Object.entries(data)) args.push(`=${k}=${v}`);
      }

      const endpointMap: Record<string, string> = {
        disable: "/user-manager/user/set",
        enable: "/user-manager/user/set",
        remove: "/user-manager/user/remove",
        add: "/user-manager/user/add",
      };

      const finalArgs = [...args];
      if (action === "disable") finalArgs.push("=disabled=true");
      if (action === "enable") finalArgs.push("=disabled=false");

      return callMikrotikApi(endpointMap[action] || `/user-manager/user/${action}`, { args: finalArgs });
    },
    onMutate: async ({ action, id, data }) => {
      const routerKey = getRouterKey();
      const usersKey = ["mikrotik", routerKey, "usermanager", "users"];
      const countKey = ["mikrotik", routerKey, "usermanager", "count"];

      // Cancel in-flight queries to prevent race conditions
      await qc.cancelQueries({ queryKey: usersKey });

      const previousUsers = qc.getQueryData(usersKey);
      const previousCount = qc.getQueryData(countKey);

      // Optimistically update the users list for instant UI feedback
      if (action === "add" && data) {
        const optimisticUser = {
          ".id": `__optimistic__${Date.now()}`,
          username: data.username ?? "",
          name: data.username ?? "",
          group: data.group ?? "",
          "actual-profile": data.group ?? "",
          disabled: "false",
        };
        qc.setQueryData(usersKey, (old: any) =>
          Array.isArray(old) ? [optimisticUser, ...old] : [optimisticUser]
        );
        qc.setQueryData(countKey, (old: any) =>
          old ? { ...old, total: (old.total ?? 0) + 1, active: (old.active ?? 0) + 1 } : old
        );
      } else if (action === "remove" && id) {
        qc.setQueryData(usersKey, (old: any) =>
          Array.isArray(old) ? old.filter((u: any) => (u[".id"] || u.id) !== id) : old
        );
        qc.setQueryData(countKey, (old: any) => {
          if (!old) return old;
          const removedUser = Array.isArray(previousUsers)
            ? (previousUsers as any[]).find((u: any) => (u[".id"] || u.id) === id)
            : null;
          const wasActive = removedUser && removedUser.disabled !== "true" && removedUser.disabled !== true;
          return {
            ...old,
            total: Math.max(0, (old.total ?? 1) - 1),
            active: wasActive ? Math.max(0, (old.active ?? 1) - 1) : old.active,
            disabled: !wasActive ? Math.max(0, (old.disabled ?? 1) - 1) : old.disabled,
          };
        });
      } else if (action === "disable" && id) {
        qc.setQueryData(usersKey, (old: any) =>
          Array.isArray(old)
            ? old.map((u: any) => (u[".id"] || u.id) === id ? { ...u, disabled: "true" } : u)
            : old
        );
        qc.setQueryData(countKey, (old: any) =>
          old ? { ...old, active: Math.max(0, (old.active ?? 1) - 1), disabled: (old.disabled ?? 0) + 1 } : old
        );
      } else if (action === "enable" && id) {
        qc.setQueryData(usersKey, (old: any) =>
          Array.isArray(old)
            ? old.map((u: any) => (u[".id"] || u.id) === id ? { ...u, disabled: "false" } : u)
            : old
        );
        qc.setQueryData(countKey, (old: any) =>
          old ? { ...old, active: (old.active ?? 0) + 1, disabled: Math.max(0, (old.disabled ?? 1) - 1) } : old
        );
      }

      return { previousUsers, previousCount };
    },
    onError: (err: any, _variables, context) => {
      // Roll back optimistic updates on failure
      const routerKey = getRouterKey();
      if (context?.previousUsers !== undefined) {
        qc.setQueryData(["mikrotik", routerKey, "usermanager", "users"], context.previousUsers);
      }
      if (context?.previousCount !== undefined) {
        qc.setQueryData(["mikrotik", routerKey, "usermanager", "count"], context.previousCount);
      }
      toast.error(err.message || "فشلت العملية");
    },
    onSuccess: (_data, { action }) => {
      const routerKey = getRouterKey();
      // Only invalidate changed queries — avoid full cache bust
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "usermanager", "users"] });
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "usermanager", "count"] });
      const actionLabels: Record<string, string> = {
        add: "تمت الإضافة بنجاح",
        remove: "تم الحذف بنجاح",
        disable: "تم التعطيل",
        enable: "تم التفعيل",
      };
      toast.success(actionLabels[action] ?? "تم تنفيذ العملية بنجاح");
    },
  });
}

// ─── User Manager Profiles Mutations ────────────────
export function useUserManagerProfileAction() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({ action, id, data }: { action: string; id?: string; data?: Record<string, any> }) => {
      const args: string[] = [];
      if (id) args.push(`=.id=${id}`);
      if (data) {
        for (const [k, v] of Object.entries(data)) {
          if (v !== undefined && v !== null && `${v}` !== "") args.push(`=${k}=${v}`);
        }
      }

      const endpointMap: Record<string, string> = {
        add: "/user-manager/profile/add",
        set: "/user-manager/profile/set",
        remove: "/user-manager/profile/remove",
      };

      return callMikrotikApi(endpointMap[action] || `/user-manager/profile/${action}`, { args });
    },
    onSuccess: () => {
      const routerKey = getRouterKey();
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "usermanager", "profiles"] });
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "usermanager", "users"] });
      toast.success("تم حفظ الباقة بنجاح");
    },
    onError: (err: any) => {
      toast.error(err.message || "فشل حفظ الباقة");
    },
  });
}

// ─── User Manager Batch Add (high-throughput parallel creation) ─────────────
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

export function useUserManagerBatchAdd() {
  const qc = useQueryClient();

  return useMutation({
    mutationFn: async ({
      users,
      onProgress,
    }: {
      users: BatchAddUser[];
      onProgress?: (done: number, total: number) => void;
    }): Promise<BatchAddResult> => {
      const config = getMikrotikConfig();
      if (!config) throw new Error("لم يتم إعداد بيانات الاتصال");

      const isRestMode = config.mode === "rest";
      // Adaptive chunk sizes based on protocol
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

      const processChunk = async (chunk: BatchAddUser[]) => {
        const commands = chunk.map((u) => ({
          command: "/user-manager/user/add",
          args: [
            `=username=${u.username}`,
            `=password=${u.password}`,
            `=group=${u.group}`,
            `=owner=admin`,
          ],
        }));

        try {
          const result = await callMikrotikAction("batch", { commands });
          const errs = Array.isArray(result?.errors) ? result.errors : [];
          for (let j = 0; j < chunk.length; j++) {
            const msg = typeof errs[j] === "string" ? errs[j].trim() : "";
            if (!msg || msg.toLowerCase().includes("already") || msg.toLowerCase().includes("exists")) {
              succeeded++;
            } else {
              errors.push({ username: chunk[j].username, error: msg });
            }
          }
        } catch (err: any) {
          const msg = err?.message || "فشل التنفيذ";
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
    onSuccess: (result) => {
      const routerKey = getRouterKey();
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "usermanager", "users"] });
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "usermanager", "count"] });
      if (result.failed === 0) {
        toast.success(`تمت إضافة ${result.succeeded} مستخدم بنجاح`);
      } else {
        toast.warning(`نجح ${result.succeeded} — فشل ${result.failed}`);
      }
    },
    onError: (err: any) => {
      toast.error(err.message || "فشلت عملية الإضافة");
    },
  });
}

// ─── System ────────────────────────────────
export function useSystemResources() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "system", "resource"],
    queryFn: async () => {
      const data = await callMikrotikApi("/system/resource/print");
      return Array.isArray(data) ? data[0] || {} : data;
    },
    refetchInterval: 15000,
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}
export function useSystemIdentity() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "system", "identity"],
    queryFn: async () => {
      const data = await callMikrotikApi("/system/identity/print");
      return Array.isArray(data) ? data[0] || {} : data;
    },
    enabled: useEnabled(),
    staleTime: 120000,
  });
}
export function useRouterboard() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "system", "routerboard"],
    queryFn: async () => {
      const data = await callMikrotikApi("/system/routerboard/print");
      return Array.isArray(data) ? data[0] || {} : data;
    },
    enabled: useEnabled(),
    staleTime: 120000,
  });
}

// ─── Interfaces ────────────────────────────
export function useInterfaces() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "interface"],
    queryFn: () => callMikrotikApi("/interface/print"),
    refetchInterval: 10000,
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}

// ─── DHCP ──────────────────────────────────
export function useDHCPLeases() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "dhcp", "leases"],
    queryFn: () => callMikrotikApi("/ip/dhcp-server/lease/print"),
    refetchInterval: 30000,
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}

// ─── IP Addresses ──────────────────────────
export function useIPAddresses() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "ip", "address"],
    queryFn: () => callMikrotikApi("/ip/address/print"),
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}

// ─── Generic command executor ──────────────
export function useMikrotikCommand() {
  return useMutation({
    mutationFn: async ({ endpoint, args }: { endpoint: string; args?: string[] }) => {
      return callMikrotikApi(endpoint, args ? { args } : undefined);
    },
  });
}
