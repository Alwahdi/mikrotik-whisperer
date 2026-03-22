# Getting Started

## Prerequisites
- Node.js >= 18.18 and npm 11+ (install quickly with [skills.sh](https://skills.sh))
- Turbo CLI (installed via `npm install` in the repo)
- Git + configured SSH access

> Tip: run `curl -fsSL https://skills.sh/install.sh | bash` to bootstrap the recommended local toolchain (node, npm, turbo, and platform utilities).

## Install
```bash
# from repo root
npm install
```

## Run
- Web (Next 16): `npm run dev -- --filter=@mikrotik-whisperer/web` (served on port 8080)
- Local agent (Express): `npm run dev -- --filter=@mikrotik-whisperer/agent`
- Docs (Next): `npm run dev -- --filter=@mikrotik-whisperer/docs`
- Mobile (Expo): `npm run dev -- --filter=@mikrotik-whisperer/mobile` or `cd apps/mobile && npm run start`

## Environment
- `NEXT_PUBLIC_SUPABASE_URL` / `NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY`
- `NEXT_PUBLIC_MIKROTIK_AGENT_URL` (defaults to `http://127.0.0.1:3001` via local agent fallback)

## Quality Gates
- Lint: `npm run lint` (turbo fan-out to workspaces)
- Tests: `npm run test`
- Build: `npm run build`

## Hotkeys
- Filtered turbo runs: `npm run lint -- --filter=@mikrotik-whisperer/web`
- Add a new workspace: place it under `apps/*` or `packages/*` and register scripts (`dev`, `lint`, `test`, `build`).
