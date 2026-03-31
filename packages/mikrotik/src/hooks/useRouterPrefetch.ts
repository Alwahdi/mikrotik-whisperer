import { useCallback, useState } from "react";
import { useQueryClient } from "@tanstack/react-query";
import { getActiveRouter } from "../lib/config";
import { invokeMikrotik } from "../lib/invoke";

interface PrefetchStep {
  label: string;
  key: string;
  command: string;
  proplist?: string;
  timeoutMs?: number;
  args?: string[];
}

type RouterConfig = NonNullable<ReturnType<typeof getActiveRouter>>;

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
  const args = step.args
    ? [...step.args]
    : step.proplist
      ? [`=.proplist=${step.proplist}`]
      : [];
  const timeoutMs = step.timeoutMs ?? 15000;
  const controller = new AbortController();
  const timer = setTimeout(() => controller.abort(), timeoutMs);

  try {
    return await invokeMikrotik({
      endpoint: step.command,
      routerId: config.routerId,
      host: config.host,
      port: config.port,
      protocol: config.protocol,
      mode: config.mode,
      args,
    }, controller.signal);
  } catch (err) {
    if (controller.signal.aborted) throw new Error(`انتهت مهلة ${step.label}`);
    throw err;
  } finally {
    clearTimeout(timer);
  }
}

// Generate a backup timestamp like the mobile app: MUMS-dd-MM-yyyy_HH-mm-ss
function getBackupTimestamp(): string {
  const now = new Date();
  const pad = (n: number) => String(n).padStart(2, "0");
  return `MUMS-${pad(now.getDate())}-${pad(now.getMonth() + 1)}-${now.getFullYear()}_${pad(now.getHours())}-${pad(now.getMinutes())}-${pad(now.getSeconds())}`;
}

// Run backup operations during login (blocks transition to dashboard)
// Mobile does: /tool/user-manager/database/save and /export
async function runLoginBackups(
  config: RouterConfig,
  onStep: (label: string) => void,
): Promise<void> {
  const timestamp = getBackupTimestamp();

  // Step 1: User Manager database backup
  // Mobile: /tool/user-manager/database/save name='MUMS-dd-MM-yyyy HH:mm:ss'
  // v7: /user-manager/database/save  |  v6: /tool/user-manager/database/save
  onStep("نسخ احتياطي لقاعدة بيانات يوزر مانجر...");
  try {
    await invokeStep(config, {
      label: "نسخ قاعدة بيانات يوزر مانجر",
      key: "um-db-save",
      command: "/user-manager/database/save",
      args: [`=name=${timestamp}`],
      timeoutMs: 20000,
    });
  } catch {
    // User Manager may not be installed; don't block login
  }

  // Step 2: Router configuration export
  // Mobile: /export file='<filename>'
  onStep("نسخ احتياطي لإعدادات الراوتر...");
  try {
    await invokeStep(config, {
      label: "نسخ إعدادات الراوتر",
      key: "config-export",
      command: "/export",
      args: [`=file=${timestamp}`],
      timeoutMs: 25000,
    });
  } catch {
    // Export may fail on some configurations; don't block login
  }
}

async function warmDataInBackground(
  config: RouterConfig,
  routerKey: string,
  queryClient: ReturnType<typeof useQueryClient>,
) {
  const CONCURRENCY = 3;
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
    const config = getActiveRouter();
    if (!config) {
      setError("لم يتم إعداد الاتصال بالراوتر");
      return false;
    }

    setLoading(true);
    setError(null);
    setProgress(5);
    setCurrentStep("جاري التحقق السريع من الاتصال...");

    const routerKey = config.routerId;
    let pulseTimer: ReturnType<typeof setInterval> | null = null;

    try {
      pulseTimer = setInterval(() => {
        setProgress((prev: number) => (prev < 40 ? prev + 3 : prev));
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

      // ─── Backup phase: runs BEFORE dashboard access ───────────
      // Mobile app creates backups on every login:
      // 1. User Manager database save
      // 2. Router configuration export
      setProgress(50);
      await runLoginBackups(config as RouterConfig, (label) => {
        setCurrentStep(label);
        setProgress((prev: number) => Math.min(prev + 10, 80));
      });

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
