import Link from "next/link";

const sections = [
  {
    title: "Getting Started",
    description: "Spin up the monorepo with turbo, skills.sh, and env parity across web, agent, and mobile.",
    items: [
      "Install prerequisites with skills.sh (Node 20+, npm 11, turbo)",
      "npm install at repo root to hydrate all workspaces",
      "turbo dev --filter=@mikrotik-whisperer/web to launch the web app on :8080",
      "turbo dev --filter=@mikrotik-whisperer/agent to run the local agent API",
      "expo start --config apps/mobile/app.json for the Expo client"
    ],
    link: "https://github.com/Alwahdi/mikrotik-whisperer/tree/main/docs/getting-started.md"
  },
  {
    title: "Architecture",
    description: "Next.js app router for the control plane, Express agent for on-prem devices, Expo mobile, all orchestrated by Turborepo.",
    items: [
      "Apps: web (Next 16), agent (Node/Express), mobile (Expo Router), docs (Next 16)",
      "Shared foundations via tsconfig.base.json and eslint presets",
      "Shadcn UI + Tailwind tokens for consistent Mikrotik UX",
      "Supabase bridge for cloud brokerage; local agent for LAN reachability"
    ],
    link: "https://github.com/Alwahdi/mikrotik-whisperer/tree/main/docs/architecture.md"
  },
  {
    title: "Usage",
    description: "Operate routers, vouchers, jobs, and backups through opinionated flows optimized for speed and safety.",
    items: [
      "Primary dashboards for routers, jobs, sales, and system health",
      "Local agent fallback when NEXT_PUBLIC_MIKROTIK_AGENT_URL is absent",
      "Live queue visibility with toasts + skeleton states for latency tolerance",
      "Role-aware navigation and guarded routes for admin-only surfaces"
    ],
    link: "https://github.com/Alwahdi/mikrotik-whisperer/tree/main/docs/usage.md"
  },
  {
    title: "Extending",
    description: "Add packages, pipelines, or UI surfaces with safe defaults and automated checks.",
    items: [
      "Create packages under packages/* or new apps via turbo generators",
      "Add API surfaces in agent/src/routes with zod validation",
      "Extend UI with CVA-based components (shadcn/ui compatible)",
      "Document new features in docs site + /docs markdown"
    ],
    link: "https://github.com/Alwahdi/mikrotik-whisperer/tree/main/docs/extending.md"
  },
  {
    title: "Testing",
    description: "Vitest + Testing Library for web, tsc type gates for the agent, Expo linting for mobile.",
    items: [
      "turbo test --filter=@mikrotik-whisperer/web for app-layer unit tests",
      "tsc --noEmit in the agent workspace as a fast static check",
      "Plan Playwright/Cypress for e2e; add stories for UI variants",
      "CI enforces lint > test > build on PRs"
    ],
    link: "https://github.com/Alwahdi/mikrotik-whisperer/tree/main/docs/testing-strategy.md"
  },
  {
    title: "API Reference",
    description: "Documented endpoints, env contracts, and eventing so integrations stay predictable.",
    items: [
      "Local Agent REST: /health, /routers, /vouchers, /users, /backups",
      "Supabase edge for public reachability; respect NEXT_PUBLIC_* envs",
      "Job queue stream events for background tasks",
      "Versioned changelog per release branch"
    ],
    link: "https://github.com/Alwahdi/mikrotik-whisperer/tree/main/docs/api-reference.md"
  }
];

export default function Home() {
  return (
    <div className="min-h-screen bg-gradient-to-b from-slate-950 via-slate-900 to-slate-950 text-slate-100">
      <div className="mx-auto flex max-w-6xl flex-col gap-12 px-6 py-14">
        <header className="space-y-6">
          <div className="flex flex-wrap gap-3 text-xs font-semibold uppercase tracking-wide text-slate-300">
            <span className="rounded-full bg-slate-800 px-3 py-1 text-amber-200 ring-1 ring-amber-400/40">
              Fast
            </span>
            <span className="rounded-full bg-slate-800 px-3 py-1 text-emerald-200 ring-1 ring-emerald-400/40">
              Cheap
            </span>
            <span className="rounded-full bg-slate-800 px-3 py-1 text-sky-200 ring-1 ring-sky-400/40">
              Opinionated
            </span>
            <span className="rounded-full bg-slate-800 px-3 py-1 text-indigo-200 ring-1 ring-indigo-400/40">
              Modern
            </span>
            <span className="rounded-full bg-slate-800 px-3 py-1 text-rose-200 ring-1 ring-rose-400/40">
              Safe
            </span>
          </div>
          <div className="space-y-2">
            <p className="text-sm font-semibold text-slate-300">Mikrotik Whisperer</p>
            <h1 className="text-4xl font-semibold leading-tight text-white">
              Operational playbook, guardrails, and UX standards for the Mikrotik management platform.
            </h1>
            <p className="text-lg text-slate-300">
              Built on Nextforge principles with shadcn/ui components, Turborepo orchestration, and a clear branch
              strategy so teams can move quickly without sacrificing safety.
            </p>
          </div>
          <div className="grid gap-3 text-sm text-slate-200 sm:grid-cols-2 md:grid-cols-4">
            <div className="rounded-xl border border-slate-800 bg-slate-900/60 p-4 shadow-lg shadow-slate-950/40">
              <p className="text-xs uppercase text-slate-400">Apps</p>
              <p className="mt-2 font-semibold text-white">web · agent · mobile · docs</p>
            </div>
            <div className="rounded-xl border border-slate-800 bg-slate-900/60 p-4 shadow-lg shadow-slate-950/40">
              <p className="text-xs uppercase text-slate-400">CI/CD</p>
              <p className="mt-2 font-semibold text-white">Lint → Test → Build on PR</p>
            </div>
            <div className="rounded-xl border border-slate-800 bg-slate-900/60 p-4 shadow-lg shadow-slate-950/40">
              <p className="text-xs uppercase text-slate-400">Branches</p>
              <p className="mt-2 font-semibold text-white">main / develop / feature-* / bugfix-* / release-*</p>
            </div>
            <div className="rounded-xl border border-slate-800 bg-slate-900/60 p-4 shadow-lg shadow-slate-950/40">
              <p className="text-xs uppercase text-slate-400">Tooling</p>
              <p className="mt-2 font-semibold text-white">skills.sh, husky, commitlint, lint-staged</p>
            </div>
          </div>
        </header>

        <section className="grid gap-6 md:grid-cols-2">
          {sections.map((section) => (
            <article
              key={section.title}
              className="group rounded-2xl border border-slate-800 bg-slate-900/70 p-6 shadow-xl shadow-slate-950/40 transition hover:-translate-y-1 hover:border-sky-400/60 hover:shadow-sky-900/50"
            >
              <div className="flex items-start justify-between gap-3">
                <div>
                  <h2 className="text-xl font-semibold text-white">{section.title}</h2>
                  <p className="mt-2 text-sm text-slate-300">{section.description}</p>
                </div>
                <span className="rounded-full bg-slate-800 px-3 py-1 text-xs font-semibold text-slate-200">
                  Pillar
                </span>
              </div>
              <ul className="mt-4 space-y-2 text-sm text-slate-200">
                {section.items.map((item) => (
                  <li key={item} className="flex gap-2">
                    <span className="mt-1 h-2 w-2 rounded-full bg-sky-300" aria-hidden />
                    <span>{item}</span>
                  </li>
                ))}
              </ul>
              <div className="mt-5">
                <Link
                  href={section.link}
                  className="inline-flex items-center gap-2 text-sm font-semibold text-sky-200 transition hover:text-white"
                >
                  View living doc
                  <span aria-hidden>↗</span>
                </Link>
              </div>
            </article>
          ))}
        </section>

        <section className="grid gap-6 md:grid-cols-3">
          <div className="rounded-2xl border border-slate-800 bg-slate-900/70 p-6 shadow-xl shadow-slate-950/40">
            <h3 className="text-lg font-semibold text-white">Feedback & UX loops</h3>
            <p className="mt-2 text-sm text-slate-300">
              Run weekly UI reviews, ship shadcn-based components, and collect operator feedback on navigation, latency,
              and hotspot provisioning flows.
            </p>
            <ul className="mt-3 space-y-2 text-sm text-slate-200">
              <li>• Use skeletons + optimistic updates for router actions</li>
              <li>• Audit accessibility (focus rings, color contrast)</li>
              <li>• Track task success time for MVP/PMF agility</li>
            </ul>
          </div>
          <div className="rounded-2xl border border-slate-800 bg-slate-900/70 p-6 shadow-xl shadow-slate-950/40">
            <h3 className="text-lg font-semibold text-white">Security & safety</h3>
            <p className="mt-2 text-sm text-slate-300">
              Respect principle of least privilege; protect main/develop branches and require CI green + reviews.
            </p>
            <ul className="mt-3 space-y-2 text-sm text-slate-200">
              <li>• Commitlint for conventional history</li>
              <li>• Branch protections: reviews + status checks</li>
              <li>• Secrets via NEXT_PUBLIC_* only when safe for client use</li>
            </ul>
          </div>
          <div className="rounded-2xl border border-slate-800 bg-slate-900/70 p-6 shadow-xl shadow-slate-950/40">
            <h3 className="text-lg font-semibold text-white">Delivery cadence</h3>
            <p className="mt-2 text-sm text-slate-300">
              Feature branches merge into develop behind reviews. Release branches cut from develop and promote to main
              after soak and regression runs.
            </p>
            <ul className="mt-3 space-y-2 text-sm text-slate-200">
              <li>• Use turbo for fast local + CI pipelines</li>
              <li>• Add tests + docs per PR template requirements</li>
              <li>• Tag releases for agent installers + web deploys</li>
            </ul>
          </div>
        </section>
      </div>
    </div>
  );
}
