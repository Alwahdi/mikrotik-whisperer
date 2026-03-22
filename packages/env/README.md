# @repo/env

Type-safe, validated environment variables for the entire workspace.

## Features

- ✅ **Build-time validation** - Catches missing/invalid env vars before deployment
- ✅ **Type-safe access** - Full TypeScript autocomplete and type checking
- ✅ **Client/Server separation** - Clear distinction between public and private vars
- ✅ **Zod schemas** - Runtime validation with detailed error messages
- ✅ **Zero-config** - Works out of the box with Next.js

## Usage

### Client-side (Browser)

```typescript
import { env } from '@repo/env/client'

// Type-safe access with autocomplete
const supabaseUrl = env.NEXT_PUBLIC_SUPABASE_URL
const agentUrl = env.NEXT_PUBLIC_MIKROTIK_AGENT_URL
```

### Server-side (Node.js)

```typescript
import { serverEnv } from '@repo/env/server'

// Access server-only variables
const serviceRoleKey = serverEnv.SUPABASE_SERVICE_ROLE_KEY
const postgresUrl = serverEnv.POSTGRES_URL
```

## Required Environment Variables

### Client (NEXT_PUBLIC_*)
- `NEXT_PUBLIC_SUPABASE_URL` - Supabase project URL
- `NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY` - Supabase anonymous key
- `NEXT_PUBLIC_MIKROTIK_AGENT_URL` (optional) - MikroTik agent URL

### Server
All server variables are optional but validated if present:
- Supabase: `SUPABASE_SERVICE_ROLE_KEY`, etc.
- PostgreSQL: `POSTGRES_URL`, `POSTGRES_HOST`, etc.
- Redis: `REDIS_URL`
- Sentry: `SENTRY_AUTH_TOKEN`, etc.

## Benefits

### Before
```typescript
// ❌ No type safety
const url = process.env.NEXT_PUBLIC_SUPABASE_URL // string | undefined
// ❌ No validation
// ❌ Runtime errors in production
```

### After
```typescript
// ✅ Type-safe
const url = env.NEXT_PUBLIC_SUPABASE_URL // string
// ✅ Validated at build time
// ✅ Catches errors before deployment
```

## Error Handling

If environment variables are missing or invalid, you'll get a clear error at build time:

```
❌ Invalid client environment variables:
{
  "NEXT_PUBLIC_SUPABASE_URL": {
    "_errors": ["NEXT_PUBLIC_SUPABASE_URL must be a valid URL"]
  }
}
```

## Architecture Decision

Following the architect's decision, this package provides:
- **Build-time safety** - No runtime surprises
- **Clear separation** - Client vs server variables
- **Scalability** - Easy to add new variables
- **Type safety** - Full TypeScript support
