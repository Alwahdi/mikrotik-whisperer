import { useMemo, useState } from "react";
import { Bug, ChevronDown, ChevronUp, Download, Trash2 } from "lucide-react";
import {
  clearConnectionDebugEntries,
  getConnectionDebugEntries,
  subscribeConnectionDebug,
  type ConnectionDebugEntry,
} from "@repo/mikrotik";
import { useEffect } from "react";

function statusColor(entry: ConnectionDebugEntry) {
  if (entry.status === "ok") return "text-emerald-600";
  if (entry.timeout) return "text-amber-600";
  return "text-red-600";
}

export default function ConnectionDebugDrawer() {
  const [open, setOpen] = useState(false);
  const [entries, setEntries] = useState<ConnectionDebugEntry[]>(() => getConnectionDebugEntries());
  const [routeFilter, setRouteFilter] = useState<"all" | "cloud">("all");

  useEffect(() => {
    return subscribeConnectionDebug((next) => setEntries(next));
  }, []);

  const filtered = useMemo(() => {
    if (routeFilter === "all") return entries;
    return entries.filter((e) => e.route === routeFilter);
  }, [entries, routeFilter]);

  const summary = useMemo(() => {
    const total = filtered.length;
    const ok = filtered.filter((x) => x.status === "ok").length;
    const timeout = filtered.filter((x) => x.timeout).length;
    const fail = total - ok;
    const avg = total ? Math.round(filtered.reduce((s, x) => s + x.latencyMs, 0) / total) : 0;
    return { total, ok, fail, timeout, avg };
  }, [filtered]);

  const exportLogs = () => {
    const payload = JSON.stringify(filtered, null, 2);
    const blob = new Blob([payload], { type: "application/json" });
    const url = URL.createObjectURL(blob);
    const a = document.createElement("a");
    a.href = url;
    a.download = `connection-debug-${Date.now()}.json`;
    a.click();
    URL.revokeObjectURL(url);
  };

  return (
    <div className="fixed bottom-4 left-4 z-[80] w-[min(94vw,680px)]">
      <button
        onClick={() => setOpen((v) => !v)}
        className="inline-flex items-center gap-2 rounded-full border border-border bg-card px-3 py-2 text-xs shadow-md"
      >
        <Bug className="h-3.5 w-3.5" />
        Connection Debug
        {open ? <ChevronDown className="h-3.5 w-3.5" /> : <ChevronUp className="h-3.5 w-3.5" />}
      </button>

      {open && (
        <div className="mt-2 rounded-lg border border-border bg-card shadow-xl">
          <div className="flex flex-wrap items-center gap-2 border-b border-border px-3 py-2 text-[11px]">
            <span>Total: {summary.total}</span>
            <span>OK: {summary.ok}</span>
            <span>Fail: {summary.fail}</span>
            <span>Timeout: {summary.timeout}</span>
            <span>Avg: {summary.avg}ms</span>

            <select
              value={routeFilter}
              onChange={(e) => setRouteFilter(e.target.value as any)}
              className="ml-auto rounded border border-border bg-muted px-2 py-1 text-[11px]"
            >
              <option value="all">All routes</option>
              <option value="cloud">Cloud</option>
            </select>

            <button onClick={exportLogs} className="inline-flex items-center gap-1 rounded border border-border px-2 py-1">
              <Download className="h-3 w-3" /> Export
            </button>
            <button onClick={clearConnectionDebugEntries} className="inline-flex items-center gap-1 rounded border border-border px-2 py-1">
              <Trash2 className="h-3 w-3" /> Clear
            </button>
          </div>

          <div className="max-h-[45vh] overflow-auto p-2 text-[11px]">
            {filtered.length === 0 ? (
              <p className="text-muted-foreground px-1 py-2">No requests logged yet.</p>
            ) : (
              <div className="space-y-1">
                {filtered.map((entry) => (
                  <div key={entry.id} className="rounded border border-border/70 bg-muted/40 px-2 py-1.5">
                    <div className="flex flex-wrap items-center gap-2">
                      <span className={statusColor(entry)}>{entry.status.toUpperCase()}</span>
                      <span className="font-mono">{entry.route}</span>
                      <span className="font-mono">{entry.latencyMs}ms</span>
                      {entry.timeout && <span className="text-amber-600">timeout</span>}
                      <span className="text-muted-foreground">{new Date(entry.ts).toLocaleTimeString()}</span>
                    </div>
                    <div className="mt-1 text-muted-foreground">
                      <span>{entry.endpoint || entry.action || "(unknown action)"}</span>
                      {entry.host && <span> • {entry.host}</span>}
                      {entry.mode && <span> • {entry.mode}</span>}
                      {entry.protocol && <span> • {entry.protocol}</span>}
                    </div>
                    {entry.error && !entry.error.startsWith("attempt-") && (
                      <div className="mt-1 text-red-600 break-all">{entry.error}</div>
                    )}
                  </div>
                ))}
              </div>
            )}
          </div>
        </div>
      )}
    </div>
  );
}
