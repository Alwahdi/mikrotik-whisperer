import { useQuery } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";

async function callMikrotikApi(endpoint: string) {
  const { data, error } = await supabase.functions.invoke("mikrotik-api", {
    body: { endpoint },
  });
  if (error) throw error;
  return data;
}

export function useHotspotUsers() {
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "active"],
    queryFn: () => callMikrotikApi("/ip/hotspot/active/print"),
    refetchInterval: 10000,
  });
}

export function useHotspotProfiles() {
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "profiles"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/profile/print"),
  });
}

export function useHotspotAllUsers() {
  return useQuery({
    queryKey: ["mikrotik", "hotspot", "users"],
    queryFn: () => callMikrotikApi("/ip/hotspot/user/print"),
  });
}

export function useUserManagerUsers() {
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "users"],
    queryFn: () => callMikrotikApi("/user-manager/user/print"),
    refetchInterval: 15000,
  });
}

export function useUserManagerProfiles() {
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "profiles"],
    queryFn: () => callMikrotikApi("/user-manager/profile/print"),
  });
}

export function useUserManagerSessions() {
  return useQuery({
    queryKey: ["mikrotik", "usermanager", "sessions"],
    queryFn: () => callMikrotikApi("/user-manager/session/print"),
    refetchInterval: 10000,
  });
}

export function useSystemResources() {
  return useQuery({
    queryKey: ["mikrotik", "system", "resource"],
    queryFn: () => callMikrotikApi("/system/resource/print"),
    refetchInterval: 30000,
  });
}

export function useSystemIdentity() {
  return useQuery({
    queryKey: ["mikrotik", "system", "identity"],
    queryFn: () => callMikrotikApi("/system/identity/print"),
  });
}
