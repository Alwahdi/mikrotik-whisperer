import { z } from 'zod'

/**
 * Server-side environment variables schema
 * These are NOT exposed to the browser
 */
const serverSchema = z.object({
  // Supabase
  SUPABASE_URL: z.string().url().optional(),
  SUPABASE_ANON_KEY: z.string().optional(),
  SUPABASE_PUBLISHABLE_KEY: z.string().optional(),
  SUPABASE_JWT_SECRET: z.string().optional(),
  SUPABASE_SECRET_KEY: z.string().optional(),
  SUPABASE_SERVICE_ROLE_KEY: z.string().optional(),

  // PostgreSQL
  POSTGRES_URL: z.string().optional(),
  POSTGRES_URL_NON_POOLING: z.string().optional(),
  POSTGRES_PRISMA_URL: z.string().optional(),
  POSTGRES_HOST: z.string().optional(),
  POSTGRES_USER: z.string().optional(),
  POSTGRES_PASSWORD: z.string().optional(),
  POSTGRES_DATABASE: z.string().optional(),

  // Redis
  REDIS_URL: z.string().url().optional(),

  // Sentry
  SENTRY_PROJECT: z.string().optional(),
  SENTRY_ORG: z.string().optional(),
  SENTRY_AUTH_TOKEN: z.string().optional(),
  SENTRY_PUBLIC_KEY: z.string().optional(),
  SENTRY_OTLP_TRACES_URL: z.string().url().optional(),
  SENTRY_VERCEL_LOG_DRAIN_URL: z.string().url().optional(),

  // Node environment
  NODE_ENV: z.enum(['development', 'production', 'test']).default('development'),
})

/**
 * Validate and parse server environment variables
 * Only validates in server context
 */
function validateServerEnv() {
  // Skip validation on client side
  if (typeof window !== 'undefined') {
    return {} as z.infer<typeof serverSchema>
  }

  const parsed = serverSchema.safeParse(process.env)

  if (!parsed.success) {
    console.error('❌ Invalid server environment variables:')
    console.error(JSON.stringify(parsed.error.format(), null, 2))
    throw new Error('Invalid server environment variables')
  }

  return parsed.data
}

/**
 * Type-safe server environment variables
 * Access via: serverEnv.SUPABASE_SERVICE_ROLE_KEY
 * Only available on server side
 */
export const serverEnv = validateServerEnv()

/**
 * Type for server environment variables
 */
export type ServerEnv = z.infer<typeof serverSchema>
