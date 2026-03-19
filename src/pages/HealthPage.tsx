import { useCallback, useEffect, useMemo, useState } from "react";
import { Activity, AlertTriangle, CheckCircle2, RefreshCcw, Server, ShieldCheck, Timer, XCircle } from "lucide-react";
import DashboardLayout from "@/components/DashboardLayout";
import { Button } from "@/components/ui/button";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import {
  getAgentHealth,
  getAgentReleaseManifest,
  invokeMikrotik,
  isLocalHostTarget,
  type AgentHealthInfo,
  type AgentReleaseManifest,
} from "@/lib/mikrotikInvoke";

type ServiceCheck = {
  key: string;
  label: string;
  endpoint: string;
  args?: string[];
};

type CheckResult = {
  key: string;
  label: string;
  ok: boolean;
  latencyMs: number;
  error?: string;
};

const CHECKS: ServiceCheck[] = [
  { key: "identity", label: "System Identity", endpoint: "/system/identity/print" },
  { key: "resource", label: "System Resource", endpoint: "/system/resource/print" },
  { key: "interfaces", label: "Interfaces", endpoint: "/interface/print" },
  { key: "hotspot", label: "Hotspot Profiles", endpoint: "/ip/hotspot/user/profile/print" },
  {
    key: "usermanager",
    label: "UserManager Profiles",
    endpoint: "/user-manager/profile/print",
    args: ["=.proplist=.id,name"],
  },
];

function compareSemver(a: string, b: string): number {
  const pa = a.split(".").map((x) => parseInt(x, 10) || 0);
  const pb = b.split(".").map((x) => parseInt(x, 10) || 0);
  for (let i = 0; i < 3; i++) {
    if ((pa[i] || 0) > (pb[i] || 0)) return 1;
    if ((pa[i] || 0) < (pb[i] || 0)) return -1;
  }
  return 0;
}

export default function HealthPage() {
  const config = getMikrotikConfig();
  const isLocal = !!config?.host && isLocalHostTarget(config.host);

  const [running, setRunning] = useState(false);
  const [results, setResults] = useState<CheckResult[]>([]);
  const [agentInfo, setAgentInfo] = useState<AgentHealthInfo | null>(null);
  const [manifest, setManifest] = useState<AgentReleaseManifest | null>(null);
  const [checkedAt, setCheckedAt] = useState<number>(0);

  const loadAgentData = useCallback(async () => {
    const [health, releaseManifest] = await Promise.all([
      getAgentHealth(),
      getAgentReleaseManifest(),
    ]);
    setAgentInfo(health);
    setManifest(releaseManifest);
  }, []);

  const runDiagnostics = useCallback(async () => {
    if (!config) return;
    setRunning(true);

    const out: CheckResult[] = [];
    for (const check of CHECKS) {
      const start = performance.now();
      try {
        await invokeMikrotik({
          endpoint: check.endpoint,
          host: config.host,
          user: config.user,
          pass: config.pass,
          port: config.port,
          protocol: config.protocol,
          mode: config.mode,
          args: check.args,
        });

        out.push({
          key: check.key,
          label: check.label,
          ok: true,
          latencyMs: Math.round(performance.now() - start),
        });
      } catch (error) {
        out.push({
          key: check.key,
          label: check.label,
          ok: false,
          latencyMs: Math.round(performance.now() - start),
          error: error instanceof Error ? error.message : "Request failed",
        });
      }
    }

    setResults(out);
    setCheckedAt(Date.now());
    setRunning(false);
  }, [config]);

  useEffect(() => {
    void loadAgentData();
  }, [loadAgentData]);

  useEffect(() => {
    if (!config) return;
    void runDiagnostics();
  }, [config?.host, config?.port, runDiagnostics]);

  const summary = useMemo(() => {
    const ok = results.filter((r) => r.ok).length;
    const failed = results.length - ok;
    const avg = results.length > 0 ? Math.round(results.reduce((s, r) => s + r.latencyMs, 0) / results.length) : 0;
    return { ok, failed, avg };
  }, [results]);

  const agentVersion = agentInfo?.version || "unknown";
  const updateAvailable = manifest?.latestVersion
    ? compareSemver(agentVersion, manifest.latestVersion) < 0
    : false;

  return (
    <DashboardLayout>
      <div className="space-y-4">
        <div className="flex items-center justify-between gap-2">
          <div>
            <h2 className="text-lg font-bold text-foreground">Health & Readiness</h2>
            <p className="text-xs text-muted-foreground">Latency, service readiness, and local agent runtime diagnostics.</p>
          </div>
          <div className="flex items-center gap-2">
            <Button size="sm" variant="outline" onClick={() => void loadAgentData()}>
              <Server className="h-3.5 w-3.5 ml-1" /> Agent Check
            </Button>
            <Button size="sm" onClick={() => void runDiagnostics()} disabled={running || !config}>
              <RefreshCcw className="h-3.5 w-3.5 ml-1" /> {running ? "Running..." : "Run Diagnostics"}
            </Button>
          </div>
        </div>

        {!config && (
          <div className="rounded-lg border border-border bg-card p-4 text-sm text-muted-foreground">
            اختر راوتر أولاً من صفحة الراوترات لبدء فحوصات الصحة.
          </div>
        )}

        {config && (
          <>
            <div className="grid grid-cols-1 md:grid-cols-4 gap-3">
              <div className="rounded-lg border border-border bg-card p-4">
                <p className="text-[11px] text-muted-foreground">Connection Mode</p>
                <p className="text-sm font-semibold mt-1">{isLocal ? "Local Agent" : "Cloud Bridge"}</p>
              </div>
              <div className="rounded-lg border border-border bg-card p-4">
                <p className="text-[11px] text-muted-foreground">Services OK</p>
                <p className="text-sm font-semibold mt-1">{summary.ok} / {results.length || CHECKS.length}</p>
              </div>
              <div className="rounded-lg border border-border bg-card p-4">
                <p className="text-[11px] text-muted-foreground">Failed</p>
                <p className="text-sm font-semibold mt-1">{summary.failed}</p>
              </div>
              <div className="rounded-lg border border-border bg-card p-4">
                <p className="text-[11px] text-muted-foreground">Avg Latency</p>
                <p className="text-sm font-semibold mt-1">{summary.avg} ms</p>
              </div>
            </div>

            <div className="rounded-lg border border-border bg-card p-4">
              <div className="flex items-center gap-2 mb-3">
                <ShieldCheck className="h-4 w-4 text-primary" />
                <h3 className="text-sm font-semibold">Agent Runtime</h3>
              </div>

              {!isLocal && (
                <p className="text-sm text-muted-foreground">Public/DNS router selected. Local agent is optional for this router.</p>
              )}

              {isLocal && (
                <div className="space-y-2 text-sm">
                  <div className="flex items-center gap-2">
                    {agentInfo?.ok ? <CheckCircle2 className="h-4 w-4 text-emerald-600" /> : <XCircle className="h-4 w-4 text-red-600" />}
                    <span>{agentInfo?.ok ? "Running" : "Not reachable"}</span>
                  </div>
                  <p className="text-muted-foreground">Version: {agentVersion}</p>
                  <p className="text-muted-foreground">Platform: {agentInfo?.platform || "-"} / {agentInfo?.arch || "-"}</p>
                  <p className="text-muted-foreground">Uptime: {agentInfo?.uptimeSec ?? 0}s</p>

                  {updateAvailable && (
                    <div className="rounded-md border border-amber-300/40 bg-amber-500/10 p-2 text-amber-800 dark:text-amber-300 flex items-center gap-2">
                      <AlertTriangle className="h-4 w-4" />
                      Update available: {agentVersion} → {manifest?.latestVersion}
                    </div>
                  )}
                </div>
              )}
            </div>

            <div className="rounded-lg border border-border bg-card p-4 overflow-x-auto">
              <div className="flex items-center justify-between mb-3">
                <h3 className="text-sm font-semibold flex items-center gap-2"><Activity className="h-4 w-4" /> Service Readiness</h3>
                <span className="text-[11px] text-muted-foreground flex items-center gap-1"><Timer className="h-3 w-3" /> {checkedAt ? new Date(checkedAt).toLocaleTimeString() : "not checked yet"}</span>
              </div>

              <table className="w-full text-xs">
                <thead>
                  <tr className="border-b border-border text-muted-foreground">
                    <th className="text-right p-2">Service</th>
                    <th className="text-right p-2">Status</th>
                    <th className="text-right p-2">Latency</th>
                    <th className="text-right p-2">Details</th>
                  </tr>
                </thead>
                <tbody>
                  {(results.length > 0 ? results : CHECKS.map((c) => ({ key: c.key, label: c.label, ok: false, latencyMs: 0, error: "pending" }))).map((row) => (
                    <tr key={row.key} className="border-b border-border/40">
                      <td className="p-2 font-medium">{row.label}</td>
                      <td className="p-2">
                        {row.ok ? (
                          <span className="inline-flex items-center gap-1 text-emerald-600"><CheckCircle2 className="h-3.5 w-3.5" /> Ready</span>
                        ) : (
                          <span className="inline-flex items-center gap-1 text-red-600"><XCircle className="h-3.5 w-3.5" /> Failed</span>
                        )}
                      </td>
                      <td className="p-2 font-mono">{row.latencyMs} ms</td>
                      <td className="p-2 text-muted-foreground truncate max-w-[380px]">{row.error || "OK"}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </>
        )}
      </div>
    </DashboardLayout>
  );
}
