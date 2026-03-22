import { useCallback, useEffect, useMemo, useState } from "react";
import { Activity, CheckCircle2, RefreshCcw, Timer, XCircle } from "lucide-react";
import DashboardLayout from "@/components/DashboardLayout";
import { Button } from "@repo/design-system/components/ui/button";
import { getActiveRouter } from "@repo/mikrotik";
import { invokeMikrotik } from "@repo/mikrotik";

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

export default function HealthPage() {
  const config = getActiveRouter();

  const [running, setRunning] = useState(false);
  const [results, setResults] = useState<CheckResult[]>([]);
  const [checkedAt, setCheckedAt] = useState<number>(0);

  const runDiagnostics = useCallback(async () => {
    if (!config) return;
    setRunning(true);

    const out: CheckResult[] = [];
    for (const check of CHECKS) {
      const start = performance.now();
      try {
        await invokeMikrotik({
          endpoint: check.endpoint,
          routerId: config.routerId,
          host: config.host,
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
    if (!config) return;
    void runDiagnostics();
  }, [config?.host, config?.port, runDiagnostics]);

  const summary = useMemo(() => {
    const ok = results.filter((r) => r.ok).length;
    const failed = results.length - ok;
    const avg = results.length > 0 ? Math.round(results.reduce((s, r) => s + r.latencyMs, 0) / results.length) : 0;
    return { ok, failed, avg };
  }, [results]);

  return (
    <DashboardLayout>
      <div className="space-y-4">
        <div className="flex items-center justify-between gap-2">
          <div>
            <h2 className="text-lg font-bold text-foreground">Health & Readiness</h2>
            <p className="text-xs text-muted-foreground">Latency and service readiness diagnostics.</p>
          </div>
          <div className="flex items-center gap-2">
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
            <div className="grid grid-cols-1 md:grid-cols-3 gap-3">
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
