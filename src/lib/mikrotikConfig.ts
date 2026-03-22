export type ConnectionMode = "rest" | "api";
export type ConnectionProtocol = "https" | "http" | "api-ssl" | "api-plain";

/**
 * Display-only active router reference stored in localStorage.
 * Credentials are NEVER stored client-side — the Edge Function resolves
 * them from the Supabase `routers` table using routerId + auth token.
 */
export interface ActiveRouter {
  routerId: string;
  host: string;
  port: string;
  label: string;
  mode: ConnectionMode;
  protocol: ConnectionProtocol;
}

const STORAGE_KEY = "mikrotik_active_router";
const LEGACY_KEY = "mikrotik_config";

export function getActiveRouter(): ActiveRouter | null {
  try {
    const raw = localStorage.getItem(STORAGE_KEY);
    if (!raw) return null;
    const router = JSON.parse(raw) as ActiveRouter;
    if (!router.routerId || !router.host) return null;
    return router;
  } catch {
    return null;
  }
}

export function setActiveRouter(router: ActiveRouter) {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(router));
  // Remove legacy credential storage if present
  localStorage.removeItem(LEGACY_KEY);
}

export function clearActiveRouter() {
  localStorage.removeItem(STORAGE_KEY);
  localStorage.removeItem(LEGACY_KEY);
}

export function getDefaultPort(mode: ConnectionMode, protocol: ConnectionProtocol): string {
  if (mode === "rest") return protocol === "https" ? "443" : "80";
  return protocol === "api-ssl" ? "8729" : "8728";
}

export function getProtocolOptions(mode: ConnectionMode): { value: ConnectionProtocol; label: string }[] {
  if (mode === "rest") {
    return [
      { value: "https", label: "HTTPS (آمن)" },
      { value: "http", label: "HTTP" },
    ];
  }
  return [
    { value: "api-plain", label: "API (بدون تشفير)" },
    { value: "api-ssl", label: "API-SSL (مشفّر)" },
  ];
}
