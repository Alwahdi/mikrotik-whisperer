import { useState } from "react";
import { useBackgroundJobs } from "@/hooks/useBackgroundJobs";
import { clearFinished, removeJob, type BackgroundJob } from "@/stores/backgroundJobStore";
import { Progress } from "@/components/ui/progress";
import { Button } from "@/components/ui/button";
import {
  Loader2, CheckCircle, XCircle, RefreshCw, X, ChevronUp, ChevronDown,
  Activity, Trash2, ChevronRight, Clock, WifiOff, ScrollText,
} from "lucide-react";
import { Badge } from "@/components/ui/badge";

function statusIcon(status: BackgroundJob["status"]) {
  switch (status) {
    case "running":
      return <Loader2 className="h-3.5 w-3.5 animate-spin text-primary" />;
    case "retrying":
      return <RefreshCw className="h-3.5 w-3.5 animate-spin text-yellow-400" />;
    case "success":
      return <CheckCircle className="h-3.5 w-3.5 text-green-500" />;
    case "error":
      return <XCircle className="h-3.5 w-3.5 text-destructive" />;
    case "interrupted":
      return <WifiOff className="h-3.5 w-3.5 text-orange-400" />;
  }
}

function statusBadge(status: BackgroundJob["status"]) {
  const map: Record<string, { label: string; cls: string }> = {
    running:     { label: "قيد التنفيذ",      cls: "bg-primary/20 text-primary border-primary/30" },
    retrying:    { label: "إعادة محاولة",     cls: "bg-yellow-500/20 text-yellow-400 border-yellow-500/30" },
    success:     { label: "نجح",              cls: "bg-green-500/20 text-green-400 border-green-500/30" },
    error:       { label: "فشل جزئي",         cls: "bg-destructive/20 text-destructive border-destructive/30" },
    interrupted: { label: "توقفت — أغلق المتصفح", cls: "bg-orange-500/20 text-orange-400 border-orange-500/30" },
  };
  const { label, cls } = map[status] || map.running;
  return (
    <span className={`text-[9px] px-1.5 py-0.5 rounded border font-medium ${cls}`}>
      {label}
    </span>
  );
}

function formatDuration(ms: number): string {
  const sec = Math.round(ms / 1000);
  if (sec < 60) return `${sec}ث`;
  const min = Math.floor(sec / 60);
  const remainSec = sec % 60;
  return `${min}د ${remainSec}ث`;
}

function formatTs(ts: number): string {
  const d = new Date(ts);
  const now = new Date();
  const isToday = d.toDateString() === now.toDateString();
  const time = d.toLocaleTimeString("ar-SA", { hour: "2-digit", minute: "2-digit" });
  if (isToday) return time;
  return `${d.toLocaleDateString("ar-SA", { month: "short", day: "numeric" })} ${time}`;
}

function JobRow({ job }: { job: BackgroundJob }) {
  const [showLogs, setShowLogs] = useState(false);
  const pct = job.total > 0 ? Math.min(100, Math.round((job.completed / job.total) * 100)) : 0;
  const elapsed = (job.finishedAt || Date.now()) - job.startedAt;
  const isActive = job.status === "running" || job.status === "retrying";
  const hasLogs = Array.isArray(job.logs) && job.logs.length > 0;

  return (
    <div className="p-2.5 border border-border rounded-lg space-y-1.5 bg-card/50">
      {/* Header row */}
      <div className="flex items-center justify-between gap-2">
        <div className="flex items-center gap-1.5 min-w-0">
          {statusIcon(job.status)}
          <span className="text-xs font-medium truncate">{job.label}</span>
        </div>
        <div className="flex items-center gap-1.5 shrink-0">
          {!isActive && hasLogs && (
            <button
              onClick={() => setShowLogs((v) => !v)}
              className="text-muted-foreground hover:text-primary transition-colors"
              title="عرض السجل"
            >
              <ScrollText className="h-3 w-3" />
            </button>
          )}
          {!isActive && (
            <button
              onClick={() => removeJob(job.id)}
              className="text-muted-foreground hover:text-destructive transition-colors"
            >
              <X className="h-3 w-3" />
            </button>
          )}
        </div>
      </div>

      {/* Badge + host row */}
      <div className="flex items-center gap-2 flex-wrap">
        {statusBadge(job.status)}
        {job.routerHost && (
          <span className="text-[10px] text-muted-foreground truncate">📡 {job.routerHost}</span>
        )}
      </div>

      {/* Progress bar */}
      <Progress value={pct} className="h-1.5" />

      {/* Stats row */}
      <div className="flex items-center justify-between text-[10px] text-muted-foreground">
        <span>{job.completed}/{job.total} ({pct}%)</span>
        <div className="flex items-center gap-2">
          {isActive && job.rate > 0 && (
            <span className="text-primary font-medium">{job.rate} عنصر/ث</span>
          )}
          <span className="flex items-center gap-0.5">
            <Clock className="h-2.5 w-2.5" />
            {formatDuration(elapsed)}
          </span>
        </div>
      </div>

      {/* Success/fail counts */}
      {(job.succeeded > 0 || job.failed > 0) && (
        <div className="flex items-center gap-3 text-[10px]">
          {job.succeeded > 0 && (
            <span className="text-green-400 font-medium">✓ نجح {job.succeeded}</span>
          )}
          {job.failed > 0 && (
            <span className="text-destructive font-medium">✗ فشل {job.failed}</span>
          )}
        </div>
      )}

      {/* Started at */}
      <div className="text-[10px] text-muted-foreground/70">
        بدأت: {formatTs(job.startedAt)}
        {job.finishedAt && (
          <span> • انتهت: {formatTs(job.finishedAt)}</span>
        )}
      </div>

      {/* Log entries */}
      {showLogs && hasLogs && (
        <div className="mt-1 rounded bg-muted/30 border border-border/50 p-1.5 space-y-0.5 max-h-28 overflow-y-auto">
          {job.logs!.map((entry, i) => (
            <div key={i} className="text-[9px] text-muted-foreground leading-relaxed">
              <span className="text-muted-foreground/50 ml-1">{formatTs(entry.ts)}</span>
              {entry.msg}
            </div>
          ))}
        </div>
      )}

      {/* Retry button */}
      {!isActive && job.failed > 0 && job.retryFn && (
        <Button
          size="sm"
          variant="outline"
          className="w-full h-7 text-[10px] mt-1"
          onClick={() => job.retryFn?.()}
        >
          <RefreshCw className="h-3 w-3 ml-1" />
          إعادة محاولة {job.failed} فاشل
        </Button>
      )}
    </div>
  );
}

export default function LiveQueuePanel() {
  const jobs = useBackgroundJobs();
  const [collapsed, setCollapsed] = useState(false);
  const [showAll, setShowAll] = useState(false);

  if (jobs.length === 0) return null;

  const activeJobs = jobs.filter((j) => j.status === "running" || j.status === "retrying");
  const finishedJobs = jobs.filter((j) => j.status !== "running" && j.status !== "retrying");
  const visibleJobs = showAll ? jobs : jobs.slice(0, 5);

  return (
    <div
      className="fixed bottom-4 left-4 z-50 w-80 max-h-[80vh] flex flex-col bg-popover border border-border rounded-xl shadow-lg overflow-hidden"
      dir="rtl"
    >
      {/* Header */}
      <div
        className="flex items-center justify-between px-3 py-2 border-b border-border bg-muted/40 cursor-pointer select-none"
        onClick={() => setCollapsed((c) => !c)}
      >
        <div className="flex items-center gap-1.5">
          <Activity className="h-3.5 w-3.5 text-primary" />
          <span className="text-xs font-semibold">العمليات والسجل</span>
          {activeJobs.length > 0 && (
            <span className="text-[9px] px-1.5 py-0.5 rounded bg-primary/20 text-primary border border-primary/30 font-medium animate-pulse">
              {activeJobs.length} نشط
            </span>
          )}
        </div>
        <div className="flex items-center gap-1">
          {finishedJobs.length > 0 && (
            <button
              onClick={(e) => {
                e.stopPropagation();
                clearFinished();
              }}
              className="text-muted-foreground hover:text-destructive transition-colors p-0.5"
              title="مسح المنتهية"
            >
              <Trash2 className="h-3 w-3" />
            </button>
          )}
          {collapsed ? (
            <ChevronUp className="h-3.5 w-3.5 text-muted-foreground" />
          ) : (
            <ChevronDown className="h-3.5 w-3.5 text-muted-foreground" />
          )}
        </div>
      </div>

      {/* Jobs list */}
      {!collapsed && (
        <div className="overflow-y-auto p-2 space-y-2">
          {visibleJobs.map((job) => (
            <JobRow key={job.id} job={job} />
          ))}
          {jobs.length > 5 && (
            <button
              onClick={() => setShowAll((v) => !v)}
              className="w-full text-[10px] text-muted-foreground hover:text-primary flex items-center justify-center gap-1 py-1 transition-colors"
            >
              <ChevronRight className={`h-3 w-3 transition-transform ${showAll ? "rotate-90" : ""}`} />
              {showAll ? "عرض أقل" : `عرض ${jobs.length - 5} أخرى`}
            </button>
          )}
        </div>
      )}
    </div>
  );
}
