# Extending

## Add a new package or app
- Place new workspaces under `apps/*` or `packages/*`.
- Include `dev`, `lint`, `test`, `build` scripts so `turbo` can orchestrate them.
- Use `npm install <dep> -w <workspace>` to scope dependencies.

## Web app extensions
- Add UI components under `apps/web/src/components/ui` following the CVA pattern and shadcn conventions.
- Register new pages in `apps/web/src/app` (App Router); prefer server components except where client hooks are required.
- Use `@/lib/mikrotikInvoke` for router calls to honor agent/cloud routing.
- Keep styling within `src/index.css` tokens and Tailwind utility classes; avoid ad-hoc colors.

## Agent API
- Add routes in `apps/agent/src/routes/*` with zod validation and proper HTTP status codes.
- Share types in `apps/agent/src/types.ts`; keep business logic in `services/*`.
- Run `npm run lint -- --filter=@mikrotik-whisperer/agent` before committing.

## Mobile
- Align colors/spacing/typography with `apps/mobile/constants/theme.ts`.
- Use bottom-sheet modal pattern for forms; keep navigation in Expo Router files under `app/`.

## Docs
- Author Markdown in `/docs` and surface summaries in `apps/docs` landing cards.
- Keep diagrams and architecture notes close to the code they describe.

## Guardrails
- Add tests for new features (Vitest or future Playwright/Cypress).
- Update docs and PR checklist; new env vars must be documented.
- Prefer small, reviewable PRs; follow branch naming (`feature/*`, `bugfix/*`, `release/*`).
