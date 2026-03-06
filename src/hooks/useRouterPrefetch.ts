import { useCallback, useState } from "react";
import { useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { cacheGet, cacheSet } from "@/lib/indexedDBCache";

interface PrefetchStep {
  label: string;
  key: string;
  command: string;
  proplist?: string; // limit fields for large datasets
}

// Phase 1: Light commands (small data, fast)
const LIGHT_STEPS: PrefetchStep[] = [
  { label: "معلومات النظام", key: "system", command: "/system/resource/print" },
  { label: "هوية الراوتر", key: "identity", command: "/system/identity/print" },
  { label: "معلومات الجهاز", key: "routerboard", command: "/system/routerboard/print" },
  { label: "الواجهات", key: "interfaces", command: "/interface/print" },
  { label: "المتصلين بالهوتسبوت", key: "hotspot-active", command: "/ip/hotspot/active/print" },
  { label: "بروفايلات الهوتسبوت", key: "hotspot-profiles", command: "/ip/hotspot/user/profile/print" },
  { label: "باقات يوزر مانجر", key: "um-profiles", command: "/user-manager/profile/print" },
  { label: "تأجيرات DHCP", key: "dhcp", command: "/ip/dhcp-server/lease/print" },
  { label: "عناوين IP", key: "ip-address", command: "/ip/address/print" },
];

// Phase 2: Heavy commands (large data, fetched with proplist to reduce size)
const HEAVY_STEPS: PrefetchStep[] = [
  {
    label: "مستخدمي الهوتسبوت",
    key: "hotspot-users",
    command: "/ip/hotspot/user/print",
    proplist: ".id,name,profile,disabled,comment,limit-uptime,limit-bytes-total",
  },
  {
    label: "مستخدمي يوزر مانجر",
    key: "um-users",
    command: "/user-manager/user/print",
    proplist: ".id,name,group,disabled,comment,shared-users,actual-profile",
  },
  {
    label: "جلسات يوزر مانجر",
    key: "um-sessions",
    command: "/user-manager/session/print",
    proplist: ".id,user,acct-session-id,from-time,till-time,calling-station-id,download,upload",
  },
];

const ALL_STEPS = [...LIGHT_STEPS, ...HEAVY_STEPS];

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
    setProgress(2);
    setCurrentStep("جاري تحميل البيانات المحفوظة...");

    const routerKey = `${config.host}:${config.port}`;
    const totalSteps = ALL_STEPS.length;

    // Phase 0: Load cached data from IndexedDB instantly
    let cachedCount = 0;
    for (const step of ALL_STEPS) {
      const cacheK = getCacheKey(routerKey, step);
      if (cacheK.length > 0) {
        const cached = await cacheGet(`${routerKey}:${step.key}`, 10 * 60 * 1000); // 10 min cache
        if (cached != null) {
          queryClient.setQueryData(cacheK, cached);
          cachedCount++;
        }
      }
    }

    if (cachedCount > 0) {
      setProgress(5);
      setCurrentStep(`تم تحميل ${cachedCount} عنصر من الذاكرة المحلية`);
    }

    try {
      // Phase 1: Light batch (system info, profiles, etc.)
      setProgress(8);
      setCurrentStep("جاري جلب المعلومات الأساسية...");

      const lightCommands = LIGHT_STEPS.map(s => ({
        command: s.command,
        args: s.proplist ? [`=.proplist=${s.proplist}`] : [] as string[],
      }));

      const { data: lightData, error: lightErr } = await supabase.functions.invoke("mikrotik-api", {
        body: {
          action: "batch",
          host: config.host, user: config.user, pass: config.pass,
          port: config.port, protocol: config.protocol, mode: config.mode,
          commands: lightCommands,
        },
      });

      if (lightErr) throw lightErr;
      if (lightData?.error) throw new Error(lightData.error);

      const lightResults = lightData?.results || [];
      const lightErrors = lightData?.errors || [];

      for (let i = 0; i < LIGHT_STEPS.length; i++) {
        const step = LIGHT_STEPS[i];
        const cacheK = getCacheKey(routerKey, step);
        setCurrentStep(step.label);
        setProgress(8 + Math.round(((i + 1) / totalSteps) * 45));

        if (cacheK.length > 0 && lightResults[i] != null && (!lightErrors[i] || lightErrors[i] === "")) {
          const processed = processResult(step.key, lightResults[i]);
          queryClient.setQueryData(cacheK, processed);
          cacheSet(`${routerKey}:${step.key}`, processed); // persist to IndexedDB
        }
      }

      // Phase 2: Heavy data — each command separately to avoid CPU timeout
      const heavyStartProgress = 55;
      const heavyProgressPerStep = 40 / HEAVY_STEPS.length;

      for (let i = 0; i < HEAVY_STEPS.length; i++) {
        const step = HEAVY_STEPS[i];
        setCurrentStep(step.label);
        setProgress(Math.round(heavyStartProgress + i * heavyProgressPerStep));

        try {
          const args = step.proplist ? [`=.proplist=${step.proplist}`] : [];
          const { data: hData, error: hErr } = await supabase.functions.invoke("mikrotik-api", {
            body: {
              endpoint: step.command,
              host: config.host, user: config.user, pass: config.pass,
              port: config.port, protocol: config.protocol, mode: config.mode,
              args,
            },
          });

          if (hErr) throw hErr;
          if (hData?.error) throw new Error(hData.error);

          const cacheK = getCacheKey(routerKey, step);
          if (cacheK.length > 0 && hData != null) {
            const processed = processResult(step.key, hData);
            queryClient.setQueryData(cacheK, processed);
            cacheSet(`${routerKey}:${step.key}`, processed);
          }
        } catch (err: any) {
          console.warn(`Prefetch ${step.key} failed:`, err.message);
          // Non-fatal — cached data or lazy load will handle it
        }

        setProgress(Math.round(heavyStartProgress + (i + 1) * heavyProgressPerStep));
      }

      setProgress(100);
      setCurrentStep("اكتمل التحميل!");
      setLoading(false);
      return true;
    } catch (err: any) {
      // If we have cached data, still allow navigation
      if (cachedCount >= LIGHT_STEPS.length) {
        setProgress(100);
        setCurrentStep("تم التحميل من الذاكرة المحلية");
        setLoading(false);
        return true;
      }
      setError(err.message || "فشل التحميل");
      setLoading(false);
      return false;
    }
  }, [queryClient]);

  return { prefetch, progress, currentStep, loading, error };
}
