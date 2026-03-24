import Constants from "expo-constants";

const getEnvVar = (key: string, fallback?: string): string => {
  const value = Constants.expoConfig?.extra?.[key] || process.env[key] || fallback;
  if (!value) {
    throw new Error(`Missing environment variable: ${key}`);
  }
  return value;
};

export const ENV = {
  SUPABASE_URL: getEnvVar("SUPABASE_URL"),
  SUPABASE_ANON_KEY: getEnvVar("SUPABASE_ANON_KEY"),
} as const;
