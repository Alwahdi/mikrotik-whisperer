export interface MikrotikConfig {
  host: string;
  user: string;
  pass: string;
  port: string;
  protocol: "https" | "http";
}

const STORAGE_KEY = "mikrotik_config";

export function getMikrotikConfig(): MikrotikConfig | null {
  try {
    const raw = localStorage.getItem(STORAGE_KEY);
    if (!raw) return null;
    const config = JSON.parse(raw);
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
