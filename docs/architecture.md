# Architecture

## Monorepo layout
- `apps/web` — Next.js 16 App Router control plane using shadcn/ui + Tailwind tokens.
- `apps/agent` — Node/Express gateway for LAN-first MikroTik access (zod-validated routes).
- `apps/mobile` — Expo Router client aligned to the web design system.
- `apps/docs` — Documentation site (Next) describing workflows and policies.
- `packages/*` — reserved for shared UI/config packages.
- `tsconfig.base.json` — shared compiler defaults; workspaces extend it.
- `turbo.json` — orchestrates lint/test/build pipelines.

## Platform tenets (Nextforge)
- **Fast**: turbo fan-out, lint-staged, local agent fallback to reduce latency.
- **Cheap**: open-source stack (Next, Expo, shadcn/ui, Supabase, Express).
- **Opinionated**: branch strategy, commitlint, Husky hooks, and PR template required.
- **Modern**: Next 16, React 18, Tailwind, CVA component variants, Vitest.
- **Safe**: CI-enforced lint/test/build, conventional commits, branch protections, secrets scoped to `NEXT_PUBLIC_*` only when intended for the client.

## Data flows
- Web UI calls either Supabase Edge (public) or local agent (LAN) via `NEXT_PUBLIC_MIKROTIK_AGENT_URL`.
- Agent exposes REST for routers, vouchers, users, jobs, backups; it can stream queue events.
- Supabase used as cloud broker for public IP/DNS reachability.

## UI/UX system
- shadcn/ui primitives extended with CVA variants in `apps/web/src/components/ui`.
- Theming with CSS variables (`src/index.css`) and Tailwind tokens; motion defined in `tailwind.config.ts`.
- Premium affordances: hover-lift/glow utilities, skeleton loaders, and bounce/spring easing presets.

## Deployment notes
- `apps/web/vercel.json` configured for monorepo-aware builds via turbo filters.
- CI workflow runs lint → test → build on push/PR; main/develop must stay protected.
- Release branches tag agent installers; web/docs deploy after green pipelines.
