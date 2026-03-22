# Branching & Release Strategy

## Branches
- `main`: production-ready; protected; merges only from release branches.
- `develop`: integration branch for daily work; protected; requires reviews + green CI.
- `feature/*`: new features; branch from `develop`; rebase frequently.
- `bugfix/*`: hotfixes or defect work; branch from `develop` (or `main` for emergencies).
- `release/*`: stabilization branches cut from `develop`; tag releases and merge to `main` + back to `develop`.

## Pull requests
- Always open PRs into `develop` unless promoting a release branch.
- Require at least one approval and passing CI (lint, test, build).
- Keep PRs small and focused; link issues; update docs and tests.
- Use the PR template checklist; describe risk and rollback.

## Commit conventions
- Conventional commits enforced via commitlint (e.g., `feat: add router watchdog`).
- Pre-commit hooks run lint-staged + targeted tests; fix findings before pushing.

## Releases
- Cut `release/x.y.z` from `develop`; run regression + e2e.
- Tag installers and deployments; update change notes in `/docs`.
- Merge `release/x.y.z` → `main`, then back-merge into `develop`.
