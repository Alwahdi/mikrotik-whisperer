import AsyncStorage from '@react-native-async-storage/async-storage';

export type ConnectionMode = 'rest' | 'api';
export type ConnectionProtocol = 'https' | 'http' | 'api-ssl' | 'api-plain';

export interface MikrotikConfig {
  host: string;
  user: string;
  pass: string;
  port: string;
  protocol: ConnectionProtocol;
  mode: ConnectionMode;
  label?: string;
}

const STORAGE_KEY = 'mikrotik_config';

export async function getMikrotikConfig(): Promise<MikrotikConfig | null> {
  try {
    const raw = await AsyncStorage.getItem(STORAGE_KEY);
    if (!raw) return null;
    const config = JSON.parse(raw) as MikrotikConfig;
    if (!config.host || !config.user || !config.pass) return null;
    return config;
  } catch {
    return null;
  }
}

export async function saveMikrotikConfig(config: MikrotikConfig): Promise<void> {
  await AsyncStorage.setItem(STORAGE_KEY, JSON.stringify(config));
}

export async function clearMikrotikConfig(): Promise<void> {
  await AsyncStorage.removeItem(STORAGE_KEY);
}

export function getDefaultPort(mode: ConnectionMode, protocol: ConnectionProtocol): string {
  if (mode === 'rest') return protocol === 'https' ? '443' : '80';
  return protocol === 'api-ssl' ? '8729' : '8728';
}

export function getProtocolOptions(
  mode: ConnectionMode
): { value: ConnectionProtocol; label: string }[] {
  if (mode === 'rest') {
    return [
      { value: 'https', label: 'HTTPS (آمن)' },
      { value: 'http', label: 'HTTP' },
    ];
  }
  return [
    { value: 'api-plain', label: 'API (بدون تشفير)' },
    { value: 'api-ssl', label: 'API-SSL (مشفّر)' },
  ];
}
