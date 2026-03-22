import { z } from 'zod'

/**
 * Client-side environment variables schema
 * These are exposed to the browser and must be prefixed with NEXT_PUBLIC_
 */
const clientSchema = z.object({
  NEXT_PUBLIC_SUPABASE_URL: z.string().url({
    message: 'NEXT_PUBLIC_SUPABASE_URL must be a valid URL'
  }),
  NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY: z.string().min(1, {
    message: 'NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY is required'
  }),
  NEXT_PUBLIC_MIKROTIK_AGENT_URL: z.string().url().optional(),
})

/**
 * Validate and parse client environment variables
 * Throws an error at build time if validation fails
 */
function validateClientEnv() {
  const parsed = clientSchema.safeParse({
    NEXT_PUBLIC_SUPABASE_URL: process.env.NEXT_PUBLIC_SUPABASE_URL,
    NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY: process.env.NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY,
    NEXT_PUBLIC_MIKROTIK_AGENT_URL: process.env.NEXT_PUBLIC_MIKROTIK_AGENT_URL,
  })

  if (!parsed.success) {
    console.error('❌ Invalid client environment variables:')
    console.error(JSON.stringify(parsed.error.format(), null, 2))
    throw new Error('Invalid client environment variables')
  }

  return parsed.data
}

/**
 * Type-safe client environment variables
 * Access via: env.NEXT_PUBLIC_SUPABASE_URL
 */
export const env = validateClientEnv()

/**
 * Type for client environment variables
 */
export type ClientEnv = z.infer<typeof clientSchema>
