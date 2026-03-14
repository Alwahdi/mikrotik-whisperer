import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/lib/supabase";
import { getMikrotikConfigSync } from "@/lib/mikrotikConfig";
import { Alert } from "react-native";

function getRouterKey(): string {
  const config = getMikrotikConfigSync();
  return config ? `${config.host}:${config.port}` : "none";
}

async function callMikrotikApi(
  endpoint: string,
  extraBody?: Record<string, any>
) {
  const config = getMikrotikConfigSync();
  if (!config) throw new Error("لم يتم إعداد بيانات الاتصال");

  const timeoutMs =
    extraBody?.timeoutMs ?? (endpoint.endsWith("/print") ? 30000 : 15000);
  const { timeoutMs: _t, ...safeExtra } = extraBody || {};

  const request = supabase.functions.invoke("mikrotik-api", {
    body: {
      endpoint,
      host: config.host,
      user: config.user,
      pass: config.pass,
      port: config.port,
      protocol: config.protocol,
      mode: config.mode,
      ...safeExtra,
    },
  });

  const response = (await Promise.race([
    request,
    new Promise<never>((_, reject) =>
      setTimeout(
        () => reject(new Error(`انتهت المهلة: ${endpoint}`)),
        timeoutMs
      )
    ),
  ])) as any;

  const { data, error } = response;
  if (error) throw error;
  if (data?.error) throw new Error(data.error);
  return data;
}

async function callMikrotikAction(
  action: string,
  extraBody?: Record<string, any>
) {
  const config = getMikrotikConfigSync();
  if (!config) throw new Error("لم يتم إعداد بيانات الاتصال");

  const timeoutMs =
    extraBody?.timeoutMs ?? (action === "batch" ? 70000 : 20000);
  const { timeoutMs: _t, ...safeExtra } = extraBody || {};

  const request = supabase.functions.invoke("mikrotik-api", {
    body: {
      action,
      host: config.host,
      user: config.user,
      pass: config.pass,
      port: config.port,
      protocol: config.protocol,
      mode: config.mode,
      ...safeExtra,
    },
  });

  const response = (await Promise.race([
    request,
    new Promise<never>((_, reject) =>
      setTimeout(
        () => reject(new Error(`انتهت المهلة: ${action}`)),
        timeoutMs
      )
    ),
  ])) as any;

  const { data, error } = response;
  if (error) throw error;
  if (data?.error) throw new Error(data.error);
  return data;
}

function useEnabled() {
  return !!getMikrotikConfigSync();
}

const CACHE_OPTIONS = {
  staleTime: 10000,
  gcTime: 3 * 60 * 1000,
};

// ─── Health ──────────────────────────────────────
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

// ─── Hotspot ─────────────────────────────────────
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

export function useHotspotAllUsers() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "hotspot", "users"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/print"),
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
  });
}

export function useHotspotUserAction() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({
      action,
      id,
      data,
    }: {
      action: string;
      id?: string;
      data?: Record<string, any>;
    }) => {
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
      return callMikrotikApi(
        endpointMap[action] || `/ip/hotspot/user/${action}`,
        { args: finalArgs }
      );
    },
    onSuccess: () => {
      const routerKey = getRouterKey();
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "hotspot"] });
    },
    onError: (err: any) => {
      Alert.alert("خطأ", err.message || "فشلت العملية");
    },
  });
}

// ─── User Manager ────────────────────────────────
export function useUserManagerUsers(options?: { enabled?: boolean }) {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "usermanager", "users"],
    queryFn: () =>
      callMikrotikApi("/user-manager/user/print", {
        args: ["=.proplist=.id,username,name,group,actual-profile,disabled"],
      }),
    enabled: (options?.enabled ?? true) && useEnabled(),
    retry: 1,
    staleTime: 5 * 60 * 1000,
    gcTime: 10 * 60 * 1000,
  });
}

export function useUserManagerProfiles(options?: { enabled?: boolean }) {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "usermanager", "profiles"],
    queryFn: () =>
      callMikrotikApi("/user-manager/profile/print", {
        args: [
          "=.proplist=.id,name,name-for-users,validity,price,rate-limit,shared-users",
        ],
      }),
    enabled: (options?.enabled ?? true) && useEnabled(),
    retry: 1,
    staleTime: 60000,
  });
}

export function useUserManagerSessions(options?: { enabled?: boolean }) {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "usermanager", "sessions"],
    queryFn: () =>
      callMikrotikApi("/user-manager/session/print", {
        args: [
          "=.proplist=.id,user,customer,from-time,till-time,active",
        ],
      }),
    enabled: (options?.enabled ?? true) && useEnabled(),
    retry: 1,
    staleTime: 120000,
  });
}

export function useUserManagerAction() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({
      action,
      id,
      data,
    }: {
      action: string;
      id?: string;
      data?: Record<string, any>;
    }) => {
      const args: string[] = [];
      if (id) args.push(`=.id=${id}`);
      if (data) {
        for (const [k, v] of Object.entries(data)) args.push(`=${k}=${v}`);
      }
      const endpointMap: Record<string, string> = {
        disable: "/user-manager/user/set",
        enable: "/user-manager/user/set",
        set: "/user-manager/user/set",
        remove: "/user-manager/user/remove",
        add: "/user-manager/user/add",
      };
      const finalArgs = [...args];
      if (action === "disable") finalArgs.push("=disabled=true");
      if (action === "enable") finalArgs.push("=disabled=false");
      return callMikrotikApi(
        endpointMap[action] || `/user-manager/user/${action}`,
        { args: finalArgs }
      );
    },
    onSuccess: () => {
      const routerKey = getRouterKey();
      qc.invalidateQueries({
        queryKey: ["mikrotik", routerKey, "usermanager"],
      });
    },
    onError: (err: any) => {
      Alert.alert("خطأ", err.message || "فشلت العملية");
    },
  });
}

// ─── System ──────────────────────────────────────
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

// ─── Interfaces ──────────────────────────────────
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

// ─── DHCP ────────────────────────────────────────
export function useDHCPLeases() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "dhcp"],
    queryFn: () => callMikrotikApi("/ip/dhcp-server/lease/print"),
    refetchInterval: 30000,
    enabled: useEnabled(),
    ...CACHE_OPTIONS,
  });
}

// ─── Batch ───────────────────────────────────────
export function useRawBatchAction() {
  return useMutation({
    mutationFn: async ({
      commands,
    }: {
      commands: { command: string; args?: string[] }[];
    }) => callMikrotikAction("batch", { commands }),
  });
}

export function useHotspotBatchAdd() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({
      commands,
    }: {
      commands: { command: string; args: string[] }[];
    }) => callMikrotikAction("batch", { commands }),
    onSuccess: () => {
      const routerKey = getRouterKey();
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "hotspot"] });
    },
    onError: (err: any) => {
      Alert.alert("خطأ", err.message || "فشلت العملية");
    },
  });
}

export function useUserManagerBatchAdd() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: async ({
      commands,
    }: {
      commands: { command: string; args: string[] }[];
    }) => callMikrotikAction("batch", { commands }),
    onSuccess: () => {
      const routerKey = getRouterKey();
      qc.invalidateQueries({ queryKey: ["mikrotik", routerKey, "usermanager"] });
    },
    onError: (err: any) => {
      Alert.alert("خطأ", err.message || "فشلت العملية");
    },
  });
}

// ─── System Logs ─────────────────────────────────
export function useSystemLogs() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "system", "logs"],
    queryFn: () =>
      callMikrotikApi("/log/print", {
        args: ["=.proplist=.id,time,topics,message"],
      }),
    refetchInterval: 30000,
    enabled: useEnabled(),
    staleTime: 15000,
    gcTime: 3 * 60 * 1000,
  });
}

// ─── IP Addresses ────────────────────────────────
export function useIPAddresses() {
  const routerKey = getRouterKey();
  return useQuery({
    queryKey: ["mikrotik", routerKey, "ip", "address"],
    queryFn: () => callMikrotikApi("/ip/address/print"),
    refetchInterval: 60000,
    enabled: useEnabled(),
    staleTime: 30000,
    gcTime: 5 * 60 * 1000,
  });
}
