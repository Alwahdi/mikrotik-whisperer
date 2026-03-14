import { createClient } from "@supabase/supabase-js";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { Platform } from "react-native";

// These are the Supabase project URL and anonymous (publishable) key.
// The anon key is safe to expose in client apps — Row Level Security (RLS)
// on the database enforces access control. This matches the web app's approach.
const SUPABASE_URL = "https://chcobxsntmsyfqhtqezq.supabase.co";
const SUPABASE_ANON_KEY =
  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNoY29ieHNudG1zeWZxaHRxZXpxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzI2NzE0MDcsImV4cCI6MjA4ODI0NzQwN30.4CWAAg7cgPJStlmzB7ctrv0iK4qUAWiqp05Q6zzTAVM";

// On web with static/SSR output, `window` is unavailable in Node.js during
// pre-rendering. Using a guard here prevents the "window is not defined" crash
// while still persisting sessions via localStorage in the browser.
const webStorage = {
  getItem: async (key: string): Promise<string | null> => {
    if (typeof window === "undefined") return null;
    return window.localStorage.getItem(key);
  },
  setItem: async (key: string, value: string): Promise<void> => {
    if (typeof window === "undefined") return;
    window.localStorage.setItem(key, value);
  },
  removeItem: async (key: string): Promise<void> => {
    if (typeof window === "undefined") return;
    window.localStorage.removeItem(key);
  },
};

// Use platform-native AsyncStorage on iOS/Android; SSR-safe localStorage on web.
const authStorage = Platform.OS === "web" ? webStorage : AsyncStorage;

export const supabase = createClient(SUPABASE_URL, SUPABASE_ANON_KEY, {
  auth: {
    storage: authStorage,
    autoRefreshToken: true,
    persistSession: true,
    detectSessionInUrl: false,
  },
});
