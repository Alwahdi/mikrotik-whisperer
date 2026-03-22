/**
 * Environment variables package
 * Provides type-safe, validated environment variables for the entire workspace
 *
 * @example
 * ```ts
 * // Client-side usage (browser-safe)
 * import { env } from '@repo/env/client'
 * console.log(env.NEXT_PUBLIC_SUPABASE_URL)
 *
 * // Server-side usage (Node.js only)
 * import { serverEnv } from '@repo/env/server'
 * console.log(serverEnv.SUPABASE_SERVICE_ROLE_KEY)
 * ```
 */

export { env, type ClientEnv } from './client'
export { serverEnv, type ServerEnv } from './server'
