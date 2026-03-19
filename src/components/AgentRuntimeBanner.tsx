import { useEffect, useMemo, useState } from "react";
import { AlertTriangle, CheckCircle2, Download, PlayCircle, RefreshCcw, TerminalSquare } from "lucide-react";
import { Link } from "react-router-dom";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import {
  getAgentHealth,
  getAgentReleaseManifest,
  getMikrotikAgentUrl,
  isLocalHostTarget,
  type AgentHealthInfo,
  type AgentReleaseManifest,
} from "@/lib/mikrotikInvoke";

type HealthState = "idle" | "checking" | "ok" | "down";
const AGENT_SEEN_OK_KEY = "coreroute_agent_seen_ok";

function sleep(ms: number) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

function compareSemver(a: string, b: string): number {
  const pa = a.split(".").map((x) => parseInt(x, 10) || 0);
  const pb = b.split(".").map((x) => parseInt(x, 10) || 0);
  for (let i = 0; i < 3; i++) {
    if ((pa[i] || 0) > (pb[i] || 0)) return 1;
    if ((pa[i] || 0) < (pb[i] || 0)) return -1;
  }
  return 0;
}

function getPlatformDownload(manifest: AgentReleaseManifest | null): string {
  if (!manifest) return "/downloads/install-coreroute-agent-macos.command";
  const platform = typeof navigator !== "undefined" ? navigator.platform.toLowerCase() : "";
  if (platform.includes("win")) return manifest.downloads.windowsScript;
  if (platform.includes("mac")) return manifest.downloads.macosScript;
  return "/downloads/install-coreroute-agent.sh";
}

export default function AgentRuntimeBanner() {
  const [state, setState] = useState<HealthState>("idle");
  const [agentUrl, setAgentUrl] = useState<string>(getMikrotikAgentUrl());
  const [lastCheckAt, setLastCheckAt] = useState<number>(0);
  const [healthInfo, setHealthInfo] = useState<AgentHealthInfo | null>(null);
  const [manifest, setManifest] = useState<AgentReleaseManifest | null>(null);

  const config = getMikrotikConfig();
  const needsAgent = useMemo(() => {
    if (!config?.host) return false;
    return isLocalHostTarget(config.host);
  }, [config?.host]);

  useEffect(() => {
    setAgentUrl(getMikrotikAgentUrl());

    if (!needsAgent) {
      setState("idle");
      return;
    }

    let active = true;

    const run = async () => {
      setState((prev) => (prev === "ok" ? "ok" : "checking"));
      // Exponential backoff check sequence to reduce false negatives on startup.
      const delays = [0, 400, 900, 1800];
      let ok = false;
      let info: AgentHealthInfo | null = null;
      for (const delay of delays) {
        if (delay > 0) await sleep(delay);
        info = await getAgentHealth();
        ok = info.ok;
        if (ok) break;
      }
      if (!active) return;

      if (ok) {
        localStorage.setItem(AGENT_SEEN_OK_KEY, "1");
      }

      setHealthInfo(info);
      setLastCheckAt(Date.now());
      setState(ok ? "ok" : "down");
    };

    run();
    const timer = setInterval(run, 12000);

    return () => {
      active = false;
      clearInterval(timer);
    };
  }, [needsAgent, config?.host, config?.port]);

  useEffect(() => {
    let active = true;
    const load = async () => {
      const m = await getAgentReleaseManifest();
      if (!active) return;
      setManifest(m);
    };
    load();
    return () => {
      active = false;
    };
  }, []);

  if (!config?.host) {
    return null;
  }

  if (!needsAgent) {
    return (
      <div className="fixed top-2 left-1/2 z-[70] -translate-x-1/2 rounded-full border border-primary/20 bg-primary/10 px-3 py-1 text-[11px] text-primary backdrop-blur-sm">
        Public DNS/IP mode: Cloud Bridge active
      </div>
    );
  }

  if (state === "ok") {
    const version = healthInfo?.version || "unknown";
    const latest = manifest?.latestVersion;
    const needsUpdate = latest ? compareSemver(version, latest) < 0 : false;

    return (
      <div className="fixed top-2 left-1/2 z-[70] -translate-x-1/2 rounded-full border border-emerald-400/30 bg-emerald-500/10 px-3 py-1 text-[11px] text-emerald-700 backdrop-blur-sm dark:text-emerald-300 flex items-center gap-2">
        <CheckCircle2 className="h-3.5 w-3.5" />
        <span>Local Agent running</span>
        <span className="opacity-80 font-mono">v{version}</span>
        {needsUpdate && (
          <a
            href={getPlatformDownload(manifest)}
            download
            className="rounded-full border border-emerald-600/30 px-2 py-0.5 text-[10px] font-semibold hover:bg-emerald-600/10"
          >
            Update {latest}
          </a>
        )}
      </div>
    );
  }

  if (state === "checking") {
    return (
      <div className="fixed top-2 left-1/2 z-[70] -translate-x-1/2 rounded-full border border-amber-300/40 bg-amber-500/10 px-3 py-1 text-[11px] text-amber-700 backdrop-blur-sm dark:text-amber-300">
        Checking CoreRoute Local Agent...
      </div>
    );
  }

  const hadWorkedBefore = localStorage.getItem(AGENT_SEEN_OK_KEY) === "1";
  const checkedAgoSec = Math.max(0, Math.round((Date.now() - lastCheckAt) / 1000));

  return (
    <div className="fixed top-2 left-1/2 z-[70] w-[min(94vw,760px)] -translate-x-1/2 rounded-lg border border-red-300/40 bg-red-500/10 p-3 text-[12px] text-red-800 shadow-lg backdrop-blur-sm dark:text-red-200">
      <div className="flex items-start gap-2">
        <AlertTriangle className="mt-0.5 h-4 w-4 shrink-0" />
        <div className="space-y-2 w-full">
          {hadWorkedBefore ? (
            <p className="font-semibold">الوكيل المحلي مثبت سابقًا لكنه متوقف الآن. يرجى تشغيله.</p>
          ) : (
            <p className="font-semibold">الوكيل المحلي غير متاح. يمكنك تنزيله ثم تشغيله.</p>
          )}

          <p>العنوان المتوقع: {agentUrl}</p>

          <div className="flex flex-wrap items-center gap-2">
            {!hadWorkedBefore && (
              <a
                href={getPlatformDownload(manifest)}
                download
                className="inline-flex items-center gap-1.5 rounded-md border border-red-500/40 bg-white/70 px-2.5 py-1.5 font-medium hover:bg-white"
              >
                <Download className="h-3.5 w-3.5" />
                تنزيل الوكيل
              </a>
            )}

            <button
              onClick={() => window.location.reload()}
              className="inline-flex items-center gap-1.5 rounded-md border border-red-500/40 bg-white/70 px-2.5 py-1.5 font-medium hover:bg-white"
            >
              <RefreshCcw className="h-3.5 w-3.5" />
              إعادة الفحص
            </button>

            <Link
              to="/settings"
              className="inline-flex items-center gap-1.5 rounded-md border border-red-500/40 bg-white/70 px-2.5 py-1.5 font-medium hover:bg-white"
            >
              <PlayCircle className="h-3.5 w-3.5" />
              ضبط عنوان الوكيل
            </Link>
          </div>

          <p className="flex items-center gap-1.5 font-mono text-[11px]">
            <TerminalSquare className="h-3.5 w-3.5" /> npm run agent:install && npm run agent:dev
          </p>

          {manifest?.latestVersion && (
            <p className="text-[10px] opacity-90 font-mono">latest: v{manifest.latestVersion} • min supported: v{manifest.minSupportedVersion}</p>
          )}

          <p className="text-[10px] opacity-80">آخر فحص قبل {checkedAgoSec}s</p>
        </div>
      </div>
    </div>
  );
}
