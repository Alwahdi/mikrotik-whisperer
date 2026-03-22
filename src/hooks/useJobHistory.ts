// ─── useJobHistory ────────────────────────────────────────────────────────────
// Loads background job history from Supabase and syncs finished jobs back.
// Mount this once in DashboardLayout.

import { useEffect, useRef } from "react";
import { supabase } from "@/integrations/supabase/client";
import { useAuth } from "@/contexts/AuthContext";
import { toast } from "sonner";
import {
  setSyncCallbacks,
  restoreJobs,
  updateJob,
  type BackgroundJob,
  type JobLogEntry,
} from "@/stores/backgroundJobStore";

// ─── DB row → BackgroundJob ──────────────────────────────────────────────────
function rowToJob(row: any): BackgroundJob {
  return {
    id: row.job_key,
    label: row.label,
    type: row.type as BackgroundJob["type"],
    status: row.status as BackgroundJob["status"],
    total: row.total ?? 0,
    completed: row.completed ?? 0,
    succeeded: row.succeeded ?? 0,
    failed: row.failed ?? 0,
    rate: row.rate ?? 0,
    startedAt: new Date(row.started_at).getTime(),
    finishedAt: row.finished_at ? new Date(row.finished_at).getTime() : undefined,
    routerHost: row.router_host ?? undefined,
    logs: Array.isArray(row.logs) ? (row.logs as JobLogEntry[]) : [],
  };
}

// ─── BackgroundJob → DB upsert payload ───────────────────────────────────────
function jobToRow(job: BackgroundJob, userId: string) {
  return {
    user_id: userId,
    job_key: job.id,
    label: job.label,
    type: job.type,
    status: job.status,
    total: job.total,
    completed: job.completed,
    succeeded: job.succeeded,
    failed: job.failed,
    rate: job.rate,
    router_host: job.routerHost ?? null,
    started_at: new Date(job.startedAt).toISOString(),
    finished_at: job.finishedAt ? new Date(job.finishedAt).toISOString() : null,
    logs: (job.logs ?? []) as any,
  };
}

export function useJobHistory() {
  const { user } = useAuth();
  const userId = user?.id;
  const pendingWrites = useRef<Map<string, ReturnType<typeof setTimeout>>>(new Map());

  // ─── Load history from Supabase on mount ────────────────────────────────
  useEffect(() => {
    if (!userId) return;

    const load = async () => {
      const { data, error } = await supabase
        .from("background_jobs")
        .select("*")
        .eq("user_id", userId)
        .order("started_at", { ascending: false })
        .limit(50);

      if (error || !data) return;

      const jobs = data.map(rowToJob);

      // Mark any lingering "running" jobs as interrupted (they didn't finish)
      const interrupted = jobs.filter(
        (j) => j.status === "running" || j.status === "retrying"
      );

      if (interrupted.length > 0) {
        // Update DB
        await supabase
          .from("background_jobs")
          .update({ status: "interrupted", finished_at: new Date().toISOString() })
          .eq("user_id", userId)
          .in("status", ["running", "retrying"]);

        // Fix status in loaded jobs
        const fixed = jobs.map((j) =>
          j.status === "running" || j.status === "retrying"
            ? {
                ...j,
                status: "interrupted" as const,
                finishedAt: Date.now(),
                logs: [
                  ...(j.logs ?? []),
                  { ts: Date.now(), msg: "توقفت العملية بسبب إغلاق المتصفح" },
                ],
              }
            : j
        );

        restoreJobs(fixed);

        toast.warning(
          `${interrupted.length} عملية توقفت بسبب إغلاق المتصفح. يمكنك إعادة تشغيلها من لوحة العمليات.`,
          { duration: 8000 }
        );
      } else {
        restoreJobs(jobs);
      }
    };

    load();
  }, [userId]);

  // ─── Register sync callbacks ─────────────────────────────────────────────
  useEffect(() => {
    if (!userId) return;

    const upsertLater = (job: BackgroundJob) => {
      const existing = pendingWrites.current.get(job.id);
      if (existing) clearTimeout(existing);
      const timer = setTimeout(async () => {
        pendingWrites.current.delete(job.id);
        await supabase.from("background_jobs").upsert(jobToRow(job, userId));
      }, 300);
      pendingWrites.current.set(job.id, timer);
    };

    setSyncCallbacks({
      onJobAdded: (job) => upsertLater(job),

      onJobUpdated: (_id, _patch) => {
        // We'll write on finish only to reduce writes
      },

      onJobFinished: async (job) => {
        // Cancel any pending debounced write and write immediately
        const existing = pendingWrites.current.get(job.id);
        if (existing) {
          clearTimeout(existing);
          pendingWrites.current.delete(job.id);
        }
        const { error } = await supabase
          .from("background_jobs")
          .upsert(jobToRow(job, userId));

        if (error) {
          console.error("Failed to persist job to DB:", error);
        }
      },
    });

    return () => {
      setSyncCallbacks({});
      // Flush all pending writes on unmount
      pendingWrites.current.forEach((timer) => clearTimeout(timer));
      pendingWrites.current.clear();
    };
  }, [userId]);
}
