# Usage

## Core flows
- **Routers dashboard**: monitor status, execute commands, and pivot to backups or vouchers.
- **Jobs queue**: live background job visibility with toasts and skeleton states for slow links.
- **Sales & vouchers**: manage vouchers, sales entries, and receipts (PDF/QR via `qrcode` + `jspdf`).
- **Backups**: trigger exports and download archives from local agent endpoints.
- **Health**: `/health` page surfaces service readiness and agent runtime diagnostics.

## Local agent behavior
- Default endpoint `http://127.0.0.1:3001` when no `NEXT_PUBLIC_MIKROTIK_AGENT_URL` is set.
- UI exposes install/start prompts if agent is unreachable and shows version/update hints using manifest files under `apps/web/public/downloads`.

## Authentication & roles
- Guarded routes enforce auth contexts; admin-only surfaces for user management and settings.
- Navigation uses Next.js app router; links and redirects rely on `next/navigation` helpers.

## UX patterns
- Skeletons and optimistic updates for router/job mutations.
- Accessible focus rings on primary/secondary actions; contrast-safe palettes via CSS variables.
- Command palette (cmdk) for power users; keyboard navigable tables and forms.

## Operations checklists
- Before hotspot changes: ensure agent connectivity, validate Supabase creds, verify router selection.
- Before backups: confirm storage target and download path; monitor job queue until completed.
- For vouchers/sales: verify printed/emailed outputs and ledger consistency.
