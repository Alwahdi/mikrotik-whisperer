import { createClient } from '@supabase/supabase-js';
import AsyncStorage from '@react-native-async-storage/async-storage';

const SUPABASE_URL = 'https://chcobxsntmsyfqhtqezq.supabase.co';
const SUPABASE_ANON_KEY =
  'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNoY29ieHNudG1zeWZxaHRxZXpxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzI2NzE0MDcsImV4cCI6MjA4ODI0NzQwN30.4CWAAg7cgPJStlmzB7ctrv0iK4qUAWiqp05Q6zzTAVM';

export const supabase = createClient(SUPABASE_URL, SUPABASE_ANON_KEY, {
  auth: {
    storage: AsyncStorage,
    autoRefreshToken: true,
    persistSession: true,
    detectSessionInUrl: false,
  },
});
