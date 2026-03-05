export type ConnectionMode = "rest" | "api";
export type ConnectionProtocol = "https" | "http" | "api-ssl" | "api-plain";

export interface MikrotikConfig {
  host: string;
  user: string;
  pass: string;
  port: string;
  protocol: ConnectionProtocol;
  mode: ConnectionMode;
  label?: string; // friendly name
}

const STORAGE_KEY = "mikrotik_config";

export function getMikrotikConfig(): MikrotikConfig | null {
  try {
    const raw = localStorage.getItem(STORAGE_KEY);
    if (!raw) return null;
    const config = JSON.parse(raw) as MikrotikConfig;
    if (!config.host || !config.user || !config.pass) return null;
    return config;
  } catch {
    return null;
  }
}

export function saveMikrotikConfig(config: MikrotikConfig) {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(config));
}

export function clearMikrotikConfig() {
  localStorage.removeItem(STORAGE_KEY);
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
