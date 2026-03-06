import { useCallback, useState } from "react";
import { useQueryClient } from "@tanstack/react-query";
import { supabase } from "@/integrations/supabase/client";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";

interface PrefetchStep {
  label: string;
  key: string;
  command: string;
  proplist?: string;
}

type RouterConfig = NonNullable<ReturnType<typeof getMikrotikConfig>>;

// تحميل أساسي سريع فقط قبل الدخول
const LIGHT_STEPS: PrefetchStep[] = [
  { label: "معلومات النظام", key: "system", command: "/system/resource/print" },
  { label: "هوية الراوتر", key: "identity", command: "/system/identity/print" },
  { label: "معلومات الجهاز", key: "routerboard", command: "/system/routerboard/print" },
  { label: "الواجهات", key: "interfaces", command: "/interface/print" },
  { label: "باقات يوزر مانجر", key: "um-profiles", command: "/user-manager/profile/print" },
  { label: "بروفايلات الهوتسبوت", key: "hotspot-profiles", command: "/ip/hotspot/user/profile/print" },
];

// البيانات الثقيلة تُحمّل بالخلفية لتجنب تعليق شاشة التحميل
const HEAVY_BACKGROUND_STEPS: PrefetchStep[] = [
  {
    label: "مستخدمي يوزر مانجر",
    key: "um-users",
    command: "/user-manager/user/print",
    proplist: ".id,username,name,group,actual-profile,disabled,comment,last-seen",
  },
  {
    label: "جلسات يوزر مانجر",
    key: "um-sessions",
    command: "/user-manager/session/print",
    proplist: ".id,user,from-time,till-time,download,upload,active",
  },
  {
    label: "مستخدمي الهوتسبوت",
    key: "hotspot-users",
    command: "/ip/hotspot/user/print",
    proplist: ".id,name,profile,disabled,comment,limit-uptime,limit-bytes-total",
  },
];

function getCacheKey(routerKey: string, step: PrefetchStep): string[] {
  const map: Record<string, string[]> = {
    system: ["mikrotik", routerKey, "system", "resource"],
    identity: ["mikrotik", routerKey, "system", "identity"],
    routerboard: ["mikrotik", routerKey, "system", "routerboard"],
    interfaces: ["mikrotik", routerKey, "interface"],
    "hotspot-users": ["mikrotik", routerKey, "hotspot", "users"],
    "hotspot-profiles": ["mikrotik", routerKey, "hotspot", "profiles"],
    "um-users": ["mikrotik", routerKey, "usermanager", "users"],
    "um-profiles": ["mikrotik", routerKey, "usermanager", "profiles"],
    "um-sessions": ["mikrotik", routerKey, "usermanager", "sessions"],
  };
  return map[step.key] || [];
}

function processResult(key: string, data: any): any {
  if (["system", "identity", "routerboard"].includes(key)) {
    return Array.isArray(data) ? data[0] || {} : data;
  }
  return data;
}

async function warmHeavyDataInBackground(config: RouterConfig, routerKey: string, queryClient: ReturnType<typeof useQueryClient>) {
  for (const step of HEAVY_BACKGROUND_STEPS) {
    try {
      const args = step.proplist ? [`=.proplist=${step.proplist}`] : [];
      const { data, error } = await supabase.functions.invoke("mikrotik-api", {
        body: {
          endpoint: step.command,
          host: config.host,
          user: config.user,
          pass: config.pass,
          port: config.port,
          protocol: config.protocol,
          mode: config.mode,
          args,
        },
      });

      if (error || data?.error) continue;

      const cacheK = getCacheKey(routerKey, step);
      if (cacheK.length > 0 && data != null) {
        queryClient.setQueryData(cacheK, processResult(step.key, data));
      }
    } catch {
      // الخلفية فقط — لا نكسر تدفق الواجهة
    }
  }
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
    setProgress(3);
    setCurrentStep("جاري تهيئة الاتصال...");

    const routerKey = `${config.host}:${config.port}`;
    const totalSteps = LIGHT_STEPS.length;
    let pulseTimer: ReturnType<typeof setInterval> | null = null;

    try {
      setCurrentStep("جاري جلب البيانات الأساسية...");
      pulseTimer = setInterval(() => {
        setProgress((prev) => (prev < 70 ? prev + 2 : prev));
      }, 220);

      const commands = LIGHT_STEPS.map((s) => ({
        command: s.command,
        args: s.proplist ? [`=.proplist=${s.proplist}`] : ([] as string[]),
      }));

      const { data, error: batchErr } = await supabase.functions.invoke("mikrotik-api", {
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

      if (pulseTimer) {
        clearInterval(pulseTimer);
        pulseTimer = null;
      }

      if (batchErr) throw batchErr;
      if (data?.error) throw new Error(data.error);

      const results = data?.results || [];
      const errors = data?.errors || [];

      for (let i = 0; i < LIGHT_STEPS.length; i++) {
        const step = LIGHT_STEPS[i];
        const cacheK = getCacheKey(routerKey, step);
        setCurrentStep(step.label);
        setProgress(72 + Math.round(((i + 1) / totalSteps) * 28));

        if (cacheK.length > 0 && results[i] != null && (!errors[i] || errors[i] === "")) {
          queryClient.setQueryData(cacheK, processResult(step.key, results[i]));
        }
      }

      setProgress(100);
      setCurrentStep("تم تجهيز البيانات الأساسية");
      setLoading(false);

      void warmHeavyDataInBackground(config as RouterConfig, routerKey, queryClient);
      return true;
    } catch (err: any) {
      if (pulseTimer) clearInterval(pulseTimer);
      setError(err.message || "فشل التحميل");
      setLoading(false);
      return false;
    }
  }, [queryClient]);

  return { prefetch, progress, currentStep, loading, error };
}

