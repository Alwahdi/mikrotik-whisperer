# Contributing Guide

## Branching
- `main`: production; protected.
- `develop`: integration; protected; feature work merges here.
- `feature/*`: new capabilities.
- `bugfix/*`: defect fixes.
- `release/*`: stabilization branches cut from `develop` before promoting to `main`.

## Pull Requests
- Always open PRs against `develop` unless promoting a release branch.
- Require: ✅ green CI (lint → test → build) and ✅ at least one review.
- Keep PRs scoped and linked to issues; include risk/rollback notes.
- Use the PR template checklist (tests, docs, screenshots if UI).

## Commits & Hooks
- Conventional commits enforced via commitlint (e.g., `feat: add hotspot quota limits`).
- Husky pre-commit runs lint-staged + targeted tests; fix findings before pushing.
- Install hooks automatically via `npm install` (prepare script). If skipped, run `npm run prepare`.

## Dev Environment
- Bootstrap with [skills.sh](https://skills.sh) for Node/npm/turbo and platform utilities.
- Install dependencies once at repo root: `npm install`.
- Run apps with turbo filters:
  - `npm run dev -- --filter=@mikrotik-whisperer/web`
  - `npm run dev -- --filter=@mikrotik-whisperer/agent`
  - `npm run dev -- --filter=@mikrotik-whisperer/docs`
  - Mobile: `cd apps/mobile && npm run start`

## Testing & Quality
- Lint: `npm run lint`
- Tests: `npm run test`
- Build: `npm run build`
- Agent types: `npm run lint -- --filter=@mikrotik-whisperer/agent`
- Add or update tests for any new feature or bugfix. Document new env vars and user-facing changes.

## Documentation
- Update relevant docs in `/docs` and surface summaries in `apps/docs`.
- New features must note: purpose, entry points, configuration, and failure modes.

## Security & Safety
- Do not commit secrets. Only expose client-safe values via `NEXT_PUBLIC_*`.
- Branch protections: require reviews and passing checks before merging to `main`/`develop`.
- Prefer least-privilege API changes; validate payloads with zod on the agent.
