import { createBrowserClient } from '@supabase/ssr';
import type { Database } from './types';

// Lazy singleton — avoids crashing during SSG/build when env vars
// are not yet available.
let _supabase: ReturnType<typeof createBrowserClient<Database>> | null = null;

export const supabase = new Proxy({} as ReturnType<typeof createBrowserClient<Database>>, {
  get(_target, prop, receiver) {
    if (!_supabase) {
      _supabase = createBrowserClient<Database>(
        process.env.NEXT_PUBLIC_SUPABASE_URL!,
        process.env.NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY!,
      );
    }
    return Reflect.get(_supabase, prop, receiver);
  },
});