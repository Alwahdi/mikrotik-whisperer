import { useCallback, useState } from "react";
import { useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";

interface PrefetchStep {
  label: string;
  key: string;
  command: string;
}

const PREFETCH_STEPS: PrefetchStep[] = [
  { label: "معلومات النظام", key: "system", command: "/system/resource/print" },
  { label: "هوية الراوتر", key: "identity", command: "/system/identity/print" },
  { label: "معلومات الجهاز", key: "routerboard", command: "/system/routerboard/print" },
  { label: "الواجهات", key: "interfaces", command: "/interface/print" },
  { label: "المتصلين بالهوتسبوت", key: "hotspot-active", command: "/ip/hotspot/active/print" },
  { label: "مستخدمي الهوتسبوت", key: "hotspot-users", command: "/ip/hotspot/user/print" },
  { label: "بروفايلات الهوتسبوت", key: "hotspot-profiles", command: "/ip/hotspot/user/profile/print" },
  { label: "مستخدمي يوزر مانجر", key: "um-users", command: "/user-manager/user/print" },
  { label: "باقات يوزر مانجر", key: "um-profiles", command: "/user-manager/profile/print" },
  { label: "جلسات يوزر مانجر", key: "um-sessions", command: "/user-manager/session/print" },
  { label: "تأجيرات DHCP", key: "dhcp", command: "/ip/dhcp-server/lease/print" },
  { label: "عناوين IP", key: "ip-address", command: "/ip/address/print" },
];

// Maps batch result index to React Query cache keys
function getCacheKey(routerKey: string, step: PrefetchStep): string[] {
  const map: Record<string, string[]> = {
    "system": ["mikrotik", routerKey, "system", "resource"],
    "identity": ["mikrotik", routerKey, "system", "identity"],
    "routerboard": ["mikrotik", routerKey, "system", "routerboard"],
    "interfaces": ["mikrotik", routerKey, "interface"],
    "hotspot-active": ["mikrotik", routerKey, "hotspot", "active"],
    "hotspot-users": ["mikrotik", routerKey, "hotspot", "users"],
    "hotspot-profiles": ["mikrotik", routerKey, "hotspot", "profiles"],
    "um-users": ["mikrotik", routerKey, "usermanager", "users"],
    "um-profiles": ["mikrotik", routerKey, "usermanager", "profiles"],
    "um-sessions": ["mikrotik", routerKey, "usermanager", "sessions"],
    "dhcp": ["mikrotik", routerKey, "dhcp", "leases"],
    "ip-address": ["mikrotik", routerKey, "ip", "address"],
  };
  return map[step.key] || [];
}

// Some results need unwrapping (single object from array)
function processResult(key: string, data: any): any {
  if (["system", "identity", "routerboard"].includes(key)) {
    return Array.isArray(data) ? data[0] || {} : data;
  }
  return data;
}

export function useRouterPrefetch() {
  const queryClient = useQueryClient();
  const [progress, setProgress] = useState(0);
  const [currentStep, setCurrentStep] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const prefetch = useCallback(async () => {
    const config = getMikrotikConfig();
    if (!config) {
      setError("لم يتم إعداد الاتصال بالراوتر");
      return false;
    }

    setLoading(true);
    setError(null);
    setProgress(5);
    setCurrentStep("جاري الاتصال بالراوتر...");

    const routerKey = `${config.host}:${config.port}`;

    try {
      // Send ALL commands in ONE batch request — single connection, maximum speed
      const commands = PREFETCH_STEPS.map(s => ({ command: s.command, args: [] as string[] }));

      setProgress(10);
      setCurrentStep("جاري جلب جميع البيانات...");

      const { data, error: fnError } = await supabase.functions.invoke("mikrotik-api", {
        body: {
          action: "batch",
          host: config.host,
          user: config.user,
          pass: config.pass,
          port: config.port,
          protocol: config.protocol,
          mode: config.mode,
          commands,
        },
      });

      if (fnError) throw fnError;
      if (data?.error) throw new Error(data.error);

      const results = data?.results || [];
      const errors = data?.errors || [];

      // Populate React Query cache with all results
      for (let i = 0; i < PREFETCH_STEPS.length; i++) {
        const step = PREFETCH_STEPS[i];
        const cacheKey = getCacheKey(routerKey, step);
        
        setCurrentStep(step.label);
        setProgress(10 + Math.round(((i + 1) / PREFETCH_STEPS.length) * 85));

        if (cacheKey.length > 0 && results[i] != null && (!errors[i] || errors[i] === "")) {
          const processed = processResult(step.key, results[i]);
          queryClient.setQueryData(cacheKey, processed);
        }
      }

      setProgress(100);
      setCurrentStep("اكتمل التحميل!");
      setLoading(false);
      return true;
    } catch (err: any) {
      setError(err.message || "فشل التحميل");
      setLoading(false);
      return false;
    }
  }, [queryClient]);

  return { prefetch, progress, currentStep, loading, error };
}
