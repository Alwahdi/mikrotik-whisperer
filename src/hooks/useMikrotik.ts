import { useQuery } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";

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

function useEnabled() {
  return !!getMikrotikConfig();
}

// ─── Hotspot ───────────────────────────────
export function useHotspotUsers() {
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "active"],
    queryFn: () => callMikrotikApi("/ip/hotspot/active/print"),
    refetchInterval: 10000,
    enabled: useEnabled(),
  });
}
export function useHotspotProfiles() {
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "profiles"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/profile/print"),
    enabled: useEnabled(),
  });
}
export function useHotspotAllUsers() {
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "users"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/print"),
    enabled: useEnabled(),
  });
}

// ─── User Manager ──────────────────────────
// v7 uses /user-manager/*, v6 uses /tool/user-manager/*
// The edge function automatically falls back to v6 paths
export function useUserManagerUsers() {
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "users"],
    queryFn: () => callMikrotikApi("/user-manager/user/print"),
    refetchInterval: 15000,
    enabled: useEnabled(),
    retry: 1,
  });
}
export function useUserManagerProfiles() {
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "profiles"],
    queryFn: () => callMikrotikApi("/user-manager/profile/print"),
    enabled: useEnabled(),
    retry: 1,
  });
}
export function useUserManagerSessions() {
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "sessions"],
    queryFn: () => callMikrotikApi("/user-manager/session/print"),
    refetchInterval: 10000,
    enabled: useEnabled(),
    retry: 1,
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
  });
}

// ─── Interfaces ────────────────────────────
export function useInterfaces() {
  return useQuery({
    queryKey: ["mikrotik", "interface"],
    queryFn: () => callMikrotikApi("/interface/print"),
    refetchInterval: 10000,
    enabled: useEnabled(),
  });
}

// ─── DHCP ──────────────────────────────────
export function useDHCPLeases() {
  return useQuery({
    queryKey: ["mikrotik", "dhcp", "leases"],
    queryFn: () => callMikrotikApi("/ip/dhcp-server/lease/print"),
    refetchInterval: 30000,
    enabled: useEnabled(),
  });
}

// ─── IP Addresses ──────────────────────────
export function useIPAddresses() {
  return useQuery({
    queryKey: ["mikrotik", "ip", "address"],
    queryFn: () => callMikrotikApi("/ip/address/print"),
    enabled: useEnabled(),
  });
}
