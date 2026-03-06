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

  const { data, error } = await supabase.functions.invoke("mikrotik-api", {
    body: {
      endpoint,
      host: config.host,
      user: config.user,
      pass: config.pass,
      port: config.port,
      protocol: config.protocol,
      mode: config.mode,
      ...extraBody,
    },
  });
  if (error) throw error;
  if (data?.error) throw new Error(data.error);
  return data;
}

async function callMikrotikAction(action: string, extraBody?: Record<string, any>) {
  const config = getMikrotikConfig();
  if (!config) throw new Error("لم يتم إعداد بيانات الاتصال بالمايكروتيك");

  const { data, error } = await supabase.functions.invoke("mikrotik-api", {
    body: {
      action,
      host: config.host,
      user: config.user,
      pass: config.pass,
      port: config.port,
      protocol: config.protocol,
      mode: config.mode,
      ...extraBody,
    },
  });
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
      args: ["=.proplist=.id,username,name,group,actual-profile,disabled,comment,last-seen"],
    }),
    enabled: (options?.enabled ?? true) && useEnabled(),
    retry: 2,
    refetchInterval: false,
    staleTime: 180000,
    gcTime: 10 * 60 * 1000,
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
    retry: 2,
    staleTime: 60000,
    gcTime: 10 * 60 * 1000,
  });
}
export function useUserManagerSessions(options?: { enabled?: boolean }) {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "usermanager", "sessions"],
    queryFn: () => callMikrotikApi("/user-manager/session/print", {
      args: ["=.proplist=.id,user,customer,from-time,till-time,download,upload,active,calling-station-id,user-ip"],
    }),
    enabled: (options?.enabled ?? true) && useEnabled(),
    retry: 2,
    refetchInterval: false,
    staleTime: 45000,
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
    onSuccess: () => {
      const routerKey = getRouterKey();
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "usermanager"] });
      toast.success("تم تنفيذ العملية بنجاح");
    },
    onError: (err: any) => {
      toast.error(err.message || "فشلت العملية");
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
