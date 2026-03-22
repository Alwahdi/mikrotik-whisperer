# UI/UX Standards

## Principles
- Shadcn/ui + CVA variants as the base for all primitives.
- Strong defaults: accessible focus states, high-contrast palettes, responsive layouts.
- Motion used sparingly: bounce/spring easing for feedback; skeletons for perceived performance.
- Fast iteration: small PRs, feature flags when risky, weekly UI reviews with operators.

## Layout & navigation
- App Router (Next) with server-first rendering where possible; client hooks only when needed.
- Command palette for power tasks; keyboard-friendly tables, forms, and dialogs.
- Sidebar navigation with clear hierarchy; contextual breadcrumbs for nested pages.

## Components
- Buttons: use `apps/web/src/components/ui/button.tsx` variants; no ad-hoc styles.
- Cards & stats: prefer `StatCard`, `SystemInfoCard`, and `LiveQueuePanel` patterns.
- Forms: `react-hook-form` + zod schemas; inline validation + helper text.
- Loading: `LoadingSkeleton`, shimmer placeholders, and toasts for long-running jobs.

## Theming
- CSS variables defined in `apps/web/src/index.css`; keep new colors within the palette.
- Tailwind utilities with merge helpers (`tailwind-merge`) to avoid class collisions.
- Dark mode supported via `next-themes`; test contrast in both modes.

## Feedback loops
- Collect operator feedback on router actions, voucher issuance, and hotspot flows.
- Track latency hotspots and reduce surface friction (prefetch links, optimistic updates).
- File UX issues with screenshots + steps; add acceptance criteria and success metrics.
