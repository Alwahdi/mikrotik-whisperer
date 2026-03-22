# API Reference (snapshot)

## Local Agent (Express)
- `GET /health` — readiness and version info.
- `GET /routers` — list MikroTik routers.
- `POST /routers/:id/actions` — execute router actions (payload validated with zod).
- `GET /vouchers` / `POST /vouchers` / `DELETE /vouchers/:id` — voucher lifecycle.
- `GET /users` / `POST /users` — user admin.
- `GET /jobs` — background job queue + history.
- `GET /backups` / `POST /backups` — retrieve or trigger backups.

## Cloud (Supabase)
- Edge functions proxy router actions when public IP/DNS targets are used.
- Auth handled via Supabase client in `apps/web/src/integrations/supabase`.

## Environment contracts
- `NEXT_PUBLIC_SUPABASE_URL` — Supabase project URL (public).
- `NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY` — Supabase anon key (public).
- `NEXT_PUBLIC_MIKROTIK_AGENT_URL` — Overrides agent endpoint (defaults to `http://127.0.0.1:3001`).

## Eventing & telemetry
- Job queue events stream from the agent for UI hydration.
- UI surfaces loading skeletons, toasts, and status badges tied to agent/cloud calls.

## Versioning
- Release branches tagged per deploy; agent installers read manifest at `apps/web/public/downloads/agent-manifest.json`.
- Keep breaking changes behind release branches; document request/response shape changes in PRs and `/docs`.
