import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { toast } from "sonner";

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
  staleTime: 30000, // 30s before data is considered stale
  gcTime: 5 * 60 * 1000, // 5 min garbage collection
};

// ─── Health Check ──────────────────────────────
export function useRouterHealth() {
  return useQuery({
    queryKey: ["mikrotik", "health"],
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
      const keys = variables.invalidateKeys || [];
      keys.forEach(key => qc.invalidateQueries({ queryKey: ["mikrotik", key] }));
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

// ─── Hotspot ───────────────────────────────
export function useHotspotUsers() {
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "active"],
    queryFn: () => callMikrotikApi("/ip/hotspot/active/print"),
    refetchInterval: 10000,
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}
export function useHotspotProfiles() {
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "profiles"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/profile/print"),
    enabled: useEnabled(),
    staleTime: 60000,
    gcTime: 10 * 60 * 1000,
  });
}
export function useHotspotAllUsers() {
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "users"],
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
      qc.invalidateQueries({ queryKey: ["mikrotik", "hotspot"] });
      toast.success("تم تنفيذ العملية بنجاح");
    },
    onError: (err: any) => {
      toast.error(err.message || "فشلت العملية");
    },
  });
}

// ─── User Manager ──────────────────────────
export function useUserManagerUsers() {
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "users"],
    queryFn: () => callMikrotikApi("/user-manager/user/print"),
    refetchInterval: 15000,
    enabled: useEnabled(),
    retry: 2,
    ...CACHE_OPTIONS,
  });
}
export function useUserManagerProfiles() {
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "profiles"],
    queryFn: () => callMikrotikApi("/user-manager/profile/print"),
    enabled: useEnabled(),
    retry: 2,
    staleTime: 60000,
    gcTime: 10 * 60 * 1000,
  });
}
export function useUserManagerSessions() {
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "sessions"],
    queryFn: () => callMikrotikApi("/user-manager/session/print"),
    refetchInterval: 10000,
    enabled: useEnabled(),
    retry: 2,
    ...CACHE_OPTIONS,
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
      qc.invalidateQueries({ queryKey: ["mikrotik", "usermanager"] });
      toast.success("تم تنفيذ العملية بنجاح");
    },
    onError: (err: any) => {
      toast.error(err.message || "فشلت العملية");
    },
  });
}

// ─── System ────────────────────────────────
export function useSystemResources() {
  return useQuery({
    queryKey: ["mikrotik", "system", "resource"],
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
  return useQuery({
    queryKey: ["mikrotik", "system", "identity"],
    queryFn: async () => {
      const data = await callMikrotikApi("/system/identity/print");
      return Array.isArray(data) ? data[0] || {} : data;
    },
    enabled: useEnabled(),
    staleTime: 120000,
  });
}
export function useRouterboard() {
  return useQuery({
    queryKey: ["mikrotik", "system", "routerboard"],
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
  return useQuery({
    queryKey: ["mikrotik", "interface"],
    queryFn: () => callMikrotikApi("/interface/print"),
    refetchInterval: 10000,
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}

// ─── DHCP ──────────────────────────────────
export function useDHCPLeases() {
  return useQuery({
    queryKey: ["mikrotik", "dhcp", "leases"],
    queryFn: () => callMikrotikApi("/ip/dhcp-server/lease/print"),
    refetchInterval: 30000,
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}

// ─── IP Addresses ──────────────────────────
export function useIPAddresses() {
  return useQuery({
    queryKey: ["mikrotik", "ip", "address"],
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
