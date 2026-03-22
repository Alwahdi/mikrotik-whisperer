# Mikrotik Whisperer Monorepo

Nextforge-aligned monorepo for managing Mikrotik networks with a web control plane, local agent, Expo mobile client, and docs site. Tooling is opinionated for speed, safety, and low friction.

## Structure
- `apps/web` — Next.js 16 app router UI (shadcn/ui, Tailwind, Vitest).
- `apps/agent` — Express-based local agent for LAN-first router access.
- `apps/mobile` — Expo Router client aligned to the web design system.
- `apps/docs` — Next.js docs site describing workflows and policies.
- `docs` — Markdown knowledge base surfaced in the docs app.
- `tsconfig.base.json` / `turbo.json` — shared compiler + pipeline configs.

## Quick start
```bash
npm install

# web (8080)
npm run dev -- --filter=@mikrotik-whisperer/web

# local agent
npm run dev -- --filter=@mikrotik-whisperer/agent

# docs site
npm run dev -- --filter=@mikrotik-whisperer/docs

# mobile (Expo)
cd apps/mobile && npm run start
```

## Environment
- `NEXT_PUBLIC_SUPABASE_URL`
- `NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY`
- `NEXT_PUBLIC_MIKROTIK_AGENT_URL` (defaults to `http://127.0.0.1:3001` when absent)

## Quality gates
- Lint: `npm run lint`
- Tests: `npm run test`
- Build: `npm run build`
- Pre-commit: Husky runs lint-staged + targeted tests; commitlint enforces conventional commits.

## Branching
- `main` (prod), `develop` (integration), `feature/*`, `bugfix/*`, `release/*`.
- Protected branches require PR + green CI. Conventional commits are mandatory.
- See `docs/branching-strategy.md` and `CONTRIBUTING.md` for rules.

## Tooling & UX
- Shadcn/ui + CVA variants, Tailwind tokens, skeletons, and premium hover/motion utilities.
- Turborepo orchestrates workspace tasks; skills.sh recommended to bootstrap dev tools quickly.
- VS Code recommendations live in `.vscode/extensions.json`.

## Docs
- Markdown in `/docs` (Getting Started, Architecture, Usage, Extending, Testing, API).
- Live docs app in `apps/docs` with summaries and links back to source Markdown.
