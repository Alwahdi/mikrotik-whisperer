import { useQuery } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";

async function callMikrotikApi(endpoint: string) {
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
    },
  });
  if (error) throw error;
  if (data?.error) throw new Error(data.error);
  return data;
}

function useMikrotikEnabled() {
  return !!getMikrotikConfig();
}

export function useHotspotUsers() {
  const enabled = useMikrotikEnabled();
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "active"],
    queryFn: () => callMikrotikApi("/ip/hotspot/active/print"),
    refetchInterval: 10000,
    enabled,
  });
}

export function useHotspotProfiles() {
  const enabled = useMikrotikEnabled();
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "profiles"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/profile/print"),
    enabled,
  });
}

export function useHotspotAllUsers() {
  const enabled = useMikrotikEnabled();
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "users"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/print"),
    enabled,
  });
}

export function useUserManagerUsers() {
  const enabled = useMikrotikEnabled();
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "users"],
    queryFn: () => callMikrotikApi("/user-manager/user/print"),
    refetchInterval: 15000,
    enabled,
  });
}

export function useUserManagerProfiles() {
  const enabled = useMikrotikEnabled();
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "profiles"],
    queryFn: () => callMikrotikApi("/user-manager/profile/print"),
    enabled,
  });
}

export function useUserManagerSessions() {
  const enabled = useMikrotikEnabled();
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "sessions"],
    queryFn: () => callMikrotikApi("/user-manager/session/print"),
    refetchInterval: 10000,
    enabled,
  });
}

export function useSystemResources() {
  const enabled = useMikrotikEnabled();
  return useQuery({
    queryKey: ["mikrotik", "system", "resource"],
    queryFn: () => callMikrotikApi("/system/resource/print"),
    refetchInterval: 30000,
    enabled,
  });
}

export function useSystemIdentity() {
  const enabled = useMikrotikEnabled();
  return useQuery({
    queryKey: ["mikrotik", "system", "identity"],
    queryFn: () => callMikrotikApi("/system/identity/print"),
    enabled,
  });
}
