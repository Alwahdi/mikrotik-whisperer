export type ConnectionDebugStatus = "ok" | "error";

export interface ConnectionDebugEntry {
  id: string;
  ts: number;
  route: "cloud" | "server";
  host?: string;
  mode?: string;
  protocol?: string;
  endpoint?: string;
  action?: string;
  attempt?: number;
  latencyMs: number;
  status: ConnectionDebugStatus;
  timeout: boolean;
  error?: string;
}

type Listener = (entries: ConnectionDebugEntry[]) => void;

const MAX_ENTRIES = 300;
const entries: ConnectionDebugEntry[] = [];
const listeners = new Set<Listener>();

function emit() {
  const snapshot = [...entries];
  listeners.forEach((listener) => listener(snapshot));
}

export function addConnectionDebug(entry: ConnectionDebugEntry) {
  entries.unshift(entry);
  if (entries.length > MAX_ENTRIES) {
    entries.length = MAX_ENTRIES;
  }
  emit();
}

export function getConnectionDebugEntries() {
  return [...entries];
}

export function clearConnectionDebugEntries() {
  entries.length = 0;
  emit();
}

export function subscribeConnectionDebug(listener: Listener) {
  listeners.add(listener);
  listener([...entries]);
  return () => {
    listeners.delete(listener);
  };
}
