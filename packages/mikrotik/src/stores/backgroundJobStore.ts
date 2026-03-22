// ─── Global Background Job Store ──────────────────────────
// A simple pub/sub store for tracking background operations across pages.
// Job state is kept in memory and synced to Supabase via injected callbacks.

export type JobStatus = "running" | "success" | "error" | "retrying" | "interrupted";

export interface BackgroundJob {
  id: string;
  label: string;
  type: "add" | "delete" | "bulk";
  status: JobStatus;
  total: number;
  completed: number;
  succeeded: number;
  failed: number;
  rate: number; // items/sec
  startedAt: number;
  finishedAt?: number;
  routerHost?: string;
  failedItems?: { index: number; error: string }[];
  retryFn?: () => Promise<void>;
  logs?: JobLogEntry[];
}

export interface JobLogEntry {
  ts: number;   // unix ms
  msg: string;
}

type Listener = () => void;

// ─── Sync callbacks (injected from outside, e.g. useJobHistory hook) ──────
type SyncCallbacks = {
  onJobAdded?: (job: BackgroundJob) => void;
  onJobUpdated?: (id: string, patch: Partial<BackgroundJob>) => void;
  onJobFinished?: (job: BackgroundJob) => void;
};
let syncCallbacks: SyncCallbacks = {};

export function setSyncCallbacks(callbacks: SyncCallbacks) {
  syncCallbacks = callbacks;
}

let jobs: BackgroundJob[] = [];
const listeners = new Set<Listener>();

function notify() {
  listeners.forEach((fn) => fn());
}

export function getJobs(): BackgroundJob[] {
  return jobs;
}

export function subscribe(fn: Listener): () => void {
  listeners.add(fn);
  return () => listeners.delete(fn);
}

export function addJob(job: BackgroundJob): void {
  jobs = [job, ...jobs.filter((j) => j.id !== job.id)];
  notify();
  syncCallbacks.onJobAdded?.(job);
}

export function updateJob(id: string, patch: Partial<BackgroundJob>): void {
  jobs = jobs.map((j) => (j.id === id ? { ...j, ...patch } : j));
  notify();
  const updated = jobs.find((j) => j.id === id);
  if (updated) {
    syncCallbacks.onJobUpdated?.(id, patch);
    if (patch.status && patch.status !== "running" && patch.status !== "retrying") {
      syncCallbacks.onJobFinished?.(updated);
    }
  }
}

export function removeJob(id: string): void {
  jobs = jobs.filter((j) => j.id !== id);
  notify();
}

export function clearFinished(): void {
  jobs = jobs.filter((j) => j.status === "running" || j.status === "retrying");
  notify();
}

// ─── Helpers ────────────────────────────────────────────────────────────────
export function addJobLog(id: string, msg: string): void {
  const entry: JobLogEntry = { ts: Date.now(), msg };
  jobs = jobs.map((j) =>
    j.id === id ? { ...j, logs: [...(j.logs || []), entry] } : j
  );
  notify();
}

/** Restore jobs loaded from Supabase (history). Does NOT trigger sync callbacks. */
export function restoreJobs(restoredJobs: BackgroundJob[]): void {
  // Only add jobs that are not already in memory (by id)
  const existingIds = new Set(jobs.map((j) => j.id));
  const newJobs = restoredJobs.filter((j) => !existingIds.has(j.id));
  if (newJobs.length === 0) return;
  jobs = [...jobs, ...newJobs];
  notify();
}

/** Upsert one job from remote source (DB/realtime). */
export function upsertRemoteJob(job: BackgroundJob): void {
  const idx = jobs.findIndex((j) => j.id === job.id);
  if (idx === -1) {
    jobs = [job, ...jobs];
  } else {
    jobs = jobs.map((j) => (j.id === job.id ? { ...j, ...job } : j));
  }
  notify();
}
