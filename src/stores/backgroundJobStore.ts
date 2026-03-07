// ─── Global Background Job Store ──────────────────────────
// A simple pub/sub store for tracking background operations across pages.

export type JobStatus = "running" | "success" | "error" | "retrying";

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
  failedItems?: { index: number; error: string }[];
  retryFn?: () => Promise<void>;
}

type Listener = () => void;

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
}

export function updateJob(id: string, patch: Partial<BackgroundJob>): void {
  jobs = jobs.map((j) => (j.id === id ? { ...j, ...patch } : j));
  notify();
}

export function removeJob(id: string): void {
  jobs = jobs.filter((j) => j.id !== id);
  notify();
}

export function clearFinished(): void {
  jobs = jobs.filter((j) => j.status === "running" || j.status === "retrying");
  notify();
}
