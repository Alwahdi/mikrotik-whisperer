import AsyncStorage from "@react-native-async-storage/async-storage";

export type ConnectionMode = "rest" | "api";
export type ConnectionProtocol = "https" | "http" | "api-ssl" | "api-plain";

export interface MikrotikConfig {
  host: string;
  user: string;
  pass: string;
  port: string;
  protocol: ConnectionProtocol;
  mode: ConnectionMode;
  label?: string;
}

const STORAGE_KEY = "mikrotik_config";

// In-memory cache so synchronous reads work after first load
let _cache: MikrotikConfig | null = null;

export function getMikrotikConfigSync(): MikrotikConfig | null {
  return _cache;
}

export async function getMikrotikConfig(): Promise<MikrotikConfig | null> {
  try {
    const raw = await AsyncStorage.getItem(STORAGE_KEY);
    if (!raw) { _cache = null; return null; }
    const config = JSON.parse(raw) as MikrotikConfig;
    if (!config.host || !config.user || !config.pass) { _cache = null; return null; }
    _cache = config;
    return config;
  } catch {
    _cache = null;
    return null;
  }
}

export async function saveMikrotikConfig(config: MikrotikConfig): Promise<void> {
  _cache = config;
  await AsyncStorage.setItem(STORAGE_KEY, JSON.stringify(config));
}

export async function clearMikrotikConfig(): Promise<void> {
  _cache = null;
  await AsyncStorage.removeItem(STORAGE_KEY);
}

export function getDefaultPort(mode: ConnectionMode, protocol: ConnectionProtocol): string {
  if (mode === "rest") return protocol === "https" ? "443" : "80";
  return protocol === "api-ssl" ? "8729" : "8728";
}

export function getProtocolOptions(
  mode: ConnectionMode
): { value: ConnectionProtocol; label: string }[] {
  if (mode === "rest") {
    return [
      { value: "https", label: "HTTPS" },
      { value: "http", label: "HTTP" },
    ];
  }
  return [
    { value: "api-plain", label: "API" },
    { value: "api-ssl", label: "API-SSL" },
  ];
}
