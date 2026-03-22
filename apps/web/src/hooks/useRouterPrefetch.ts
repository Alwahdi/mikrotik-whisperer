import { useCallback, useState } from "react";
import { useQueryClient } from "@tanstack/react-query";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { invokeMikrotik } from "@/lib/mikrotikInvoke";

interface PrefetchStep {
  label: string;
  key: string;
  command: string;
  proplist?: string;
  timeoutMs?: number;
}

type RouterConfig = NonNullable<ReturnType<typeof getMikrotikConfig>>;

// خطوات حرجة فقط قبل الدخول (سريعة جدًا)
const CRITICAL_STEPS: PrefetchStep[] = [
  { label: "هوية الراوتر", key: "identity", command: "/system/identity/print", timeoutMs: 9000 },
  { label: "معلومات النظام", key: "system", command: "/system/resource/print", timeoutMs: 9000 },
];

// بقية البيانات الخفيفة تُحمّل بالخلفية بدون حجب الانتقال
const BACKGROUND_STEPS: PrefetchStep[] = [
  { label: "معلومات الجهاز", key: "routerboard", command: "/system/routerboard/print", timeoutMs: 12000 },
  { label: "الواجهات", key: "interfaces", command: "/interface/print", timeoutMs: 15000 },
  { label: "باقات يوزر مانجر", key: "um-profiles", command: "/user-manager/profile/print", timeoutMs: 12000 },
  { label: "بروفايلات الهوتسبوت", key: "hotspot-profiles", command: "/ip/hotspot/user/profile/print", timeoutMs: 12000 },
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

async function invokeStep(config: RouterConfig, step: PrefetchStep) {
  const args = step.proplist ? [`=.proplist=${step.proplist}`] : [];
  const request = invokeMikrotik({
      endpoint: step.command,
      host: config.host,
      user: config.user,
      pass: config.pass,
      port: config.port,
      protocol: config.protocol,
      mode: config.mode,
      args,
  });

  const timeoutMs = step.timeoutMs ?? 15000;
  const timeoutPromise = new Promise<never>((_, reject) => {
    setTimeout(() => reject(new Error(`انتهت مهلة ${step.label}`)), timeoutMs);
  });

  return Promise.race([request, timeoutPromise]);
}

async function warmDataInBackground(
  config: RouterConfig,
  routerKey: string,
  queryClient: ReturnType<typeof useQueryClient>,
) {
  const CONCURRENCY = 1;
  let index = 0;

  const worker = async () => {
    while (index < BACKGROUND_STEPS.length) {
      const current = index;
      index += 1;
      const step = BACKGROUND_STEPS[current];

      try {
        const data = await invokeStep(config, step);
        const cacheK = getCacheKey(routerKey, step);
        if (cacheK.length > 0 && data != null) {
          queryClient.setQueryData(cacheK, processResult(step.key, data));
        }
      } catch {
        // تجاهل فشل الخلفية حتى لا ينعكس على تجربة الدخول
      }
    }
  };

  await Promise.all(Array.from({ length: CONCURRENCY }, () => worker()));
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
    setCurrentStep("جاري التحقق السريع من الاتصال...");

    const routerKey = `${config.host}:${config.port}`;
    let pulseTimer: ReturnType<typeof setInterval> | null = null;

    try {
      pulseTimer = setInterval(() => {
        setProgress((prev) => (prev < 55 ? prev + 3 : prev));
      }, 180);

      const criticalResults = await Promise.allSettled(
        CRITICAL_STEPS.map(async (step) => {
          const data = await invokeStep(config, step);
          return { step, data };
        }),
      );

      if (pulseTimer) {
        clearInterval(pulseTimer);
        pulseTimer = null;
      }

      let successCount = 0;

      for (const item of criticalResults) {
        if (item.status !== "fulfilled") continue;
        const { step, data } = item.value;
        const cacheK = getCacheKey(routerKey, step);
        if (cacheK.length > 0 && data != null) {
          queryClient.setQueryData(cacheK, processResult(step.key, data));
        }
        successCount += 1;
      }

      if (successCount === 0) {
        throw new Error("تعذر الحصول على أي بيانات أساسية من الراوتر");
      }

      setProgress(85);
      setCurrentStep("تم الدخول — استكمال باقي البيانات بالخلفية...");

      void warmDataInBackground(config as RouterConfig, routerKey, queryClient);

      setProgress(100);
      setLoading(false);
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
