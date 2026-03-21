import { useState } from "react";
import { useBackgroundJobs } from "@/hooks/useBackgroundJobs";
import { clearFinished, removeJob, type BackgroundJob } from "@/stores/backgroundJobStore";
import { Progress } from "@/components/ui/progress";
import { Button } from "@/components/ui/button";
import {
  Loader2, CheckCircle, XCircle, RefreshCw, X, ChevronUp, ChevronDown, Activity, Trash2,
} from "lucide-react";
import { Badge } from "@/components/ui/badge";

function statusIcon(status: BackgroundJob["status"]) {
  switch (status) {
    case "running":
      return <Loader2 className="h-3.5 w-3.5 animate-spin text-primary" />;
    case "retrying":
      return <RefreshCw className="h-3.5 w-3.5 animate-spin text-warning" />;
    case "success":
      return <CheckCircle className="h-3.5 w-3.5 text-accent" />;
    case "error":
      return <XCircle className="h-3.5 w-3.5 text-destructive" />;
  }
}

function statusBadge(status: BackgroundJob["status"]) {
  const map: Record<string, { label: string; variant: "default" | "outline" | "secondary" | "destructive" }> = {
    running: { label: "قيد التنفيذ", variant: "default" },
    retrying: { label: "إعادة محاولة", variant: "secondary" },
    success: { label: "نجح", variant: "outline" },
    error: { label: "فشل جزئي", variant: "destructive" },
  };
  const { label, variant } = map[status] || map.running;
  return <Badge variant={variant} className="text-[9px] px-1.5 py-0">{label}</Badge>;
}

function formatDuration(ms: number): string {
  const sec = Math.round(ms / 1000);
  if (sec < 60) return `${sec}ث`;
  const min = Math.floor(sec / 60);
  const remainSec = sec % 60;
  return `${min}د ${remainSec}ث`;
}

function JobRow({ job }: { job: BackgroundJob }) {
  const pct = job.total > 0 ? Math.round((job.completed / job.total) * 100) : 0;
  const elapsed = (job.finishedAt || Date.now()) - job.startedAt;
  const isActive = job.status === "running" || job.status === "retrying";

  return (
    <div className="p-2.5 border border-border rounded-lg space-y-1.5 bg-card/50">
      <div className="flex items-center justify-between gap-2">
        <div className="flex items-center gap-1.5 min-w-0">
          {statusIcon(job.status)}
          <span className="text-xs font-medium truncate">{job.label}</span>
        </div>
        <div className="flex items-center gap-1.5 shrink-0">
          {statusBadge(job.status)}
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

      {job.routerHost && (
        <div className="text-[10px] text-muted-foreground truncate">
          📡 {job.routerHost}
        </div>
      )}

      <Progress value={pct} className="h-1.5" />

      <div className="flex items-center justify-between text-[10px] text-muted-foreground">
        <span>{job.completed}/{job.total} ({pct}%)</span>
        <div className="flex items-center gap-2">
          {isActive && job.rate > 0 && (
            <span className="text-primary font-medium">{job.rate} عنصر/ث</span>
          )}
          <span>{formatDuration(elapsed)}</span>
        </div>
      </div>

      {(job.succeeded > 0 || job.failed > 0) && (
        <div className="flex items-center gap-2 text-[10px]">
          {job.succeeded > 0 && (
            <span className="text-accent">✓ {job.succeeded}</span>
          )}
          {job.failed > 0 && (
            <span className="text-destructive">✗ {job.failed}</span>
          )}
        </div>
      )}

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

  if (jobs.length === 0) return null;

  const activeCount = jobs.filter((j) => j.status === "running" || j.status === "retrying").length;
  const finishedCount = jobs.filter((j) => j.status === "success" || j.status === "error").length;

  return (
    <div
      className="fixed bottom-4 left-4 z-50 w-80 max-h-[70vh] flex flex-col bg-popover border border-border rounded-xl shadow-lg overflow-hidden"
      dir="rtl"
    >
      {/* Header */}
      <div
        className="flex items-center justify-between px-3 py-2 border-b border-border bg-muted/40 cursor-pointer select-none"
        onClick={() => setCollapsed((c) => !c)}
      >
        <div className="flex items-center gap-1.5">
          <Activity className="h-3.5 w-3.5 text-primary" />
          <span className="text-xs font-semibold">العمليات الخلفية</span>
          {activeCount > 0 && (
            <Badge variant="default" className="text-[9px] px-1.5 py-0 animate-pulse">
              {activeCount} نشط
            </Badge>
          )}
        </div>
        <div className="flex items-center gap-1">
          {finishedCount > 0 && (
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
        <div className="overflow-y-auto p-2 space-y-2 max-h-[55vh]">
          {jobs.map((job) => (
            <JobRow key={job.id} job={job} />
          ))}
        </div>
      )}
    </div>
  );
}
