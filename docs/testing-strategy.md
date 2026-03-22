# Testing Strategy

## Unit & integration
- **Web**: Vitest + Testing Library (`apps/web/vitest.config.ts`). Target hooks, helpers, and UI interactions.
- **Agent**: Type-level linting via `npm run lint -w @mikrotik-whisperer/agent` (`tsc --noEmit`).
- **Docs**: `next lint` to keep content and routes healthy.
- **Mobile**: `expo lint` and TypeScript checks (`cd apps/mobile && npm run lint`).

## End-to-end (planned)
- Playwright/Cypress for router management flows (connectivity, vouchers, backups, auth).
- Contract tests for agent endpoints (health, jobs, vouchers) using Supertest.
- Synthetic checks against Supabase edge functions.

## CI gates
- Workflow runs `npm run lint`, `npm run test`, `npm run build` with turbo fan-out across workspaces.
- Branch protection requires green checks + review before merging to `main`/`develop`.

## Local commands
- `npm run lint -- --filter=@mikrotik-whisperer/web`
- `npm run test -- --filter=@mikrotik-whisperer/web`
- `npm run lint -- --filter=@mikrotik-whisperer/agent`
- `npm run lint -- --filter=@mikrotik-whisperer/docs`

## Writing tests
- Prefer deterministic data; stub network requests when possible.
- Cover happy path + key failure states (agent offline, Supabase errors, validation).
- For UI, assert visible outcomes (text, aria attributes) rather than implementation details.
