# MikroTik Whisperer

A professional, web-based management platform for **MikroTik RouterOS** devices (v6 & v7). Built with React, TypeScript, and Supabase, it provides a modern Arabic RTL interface for managing hotspot users, vouchers, sales, backups, and more — all from a single dashboard.

---

## ✨ Features

| Feature | Description |
|---|---|
| 🌐 **Hotspot Management** | Add, edit, disable, enable, and kick hotspot users; manage profiles |
| 👥 **User Manager** | Full user-manager: users, profiles, sessions with search & filtering |
| 🎫 **Voucher / Card Generation** | Create and batch-generate prepaid cards; customise and print; push directly to router |
| 📊 **Sales Tracking** | Revenue dashboard, top packages, detailed reports with date & profile filters |
| 💾 **Automated Backups** | Schedule backups, view history, and restore router configurations |
| 🔐 **Multi-Router Support** | Connect and switch between multiple MikroTik devices |
| 👨‍💼 **Admin Panel** | User management, role-based access (admin / cashier), access approval workflow |
| 🎨 **Dark / Light Theme** | System-aware theme switching |
| 📱 **PWA Ready** | Installable, mobile-friendly progressive web app |
| 🌍 **Arabic RTL** | Full Arabic language support with proper right-to-left layout |

---

## 🛠 Tech Stack

### Frontend
- **React 18** + **TypeScript 5** — UI framework
- **Vite 5** — ultra-fast build tool (dev server on port 8080)
- **Tailwind CSS 3** + **shadcn/ui** — styling and component library
- **React Router 6** — client-side routing
- **TanStack React Query 5** — server-state management and caching
- **React Hook Form** + **Zod** — forms and validation
- **Recharts** — charts and data visualisation
- **Lucide React** — icon set

### Backend
- **Supabase** — authentication, PostgreSQL database, row-level security
- **Supabase Edge Functions (Deno)** — serverless API bridge to MikroTik devices
  - `mikrotik-api` — REST + native RouterOS API wrapper
  - `backup-scheduler` — automated backup service

---

## 📁 Project Structure

```
mikrotik-whisperer/
├── public/                  # Static assets & PWA icons
├── src/
│   ├── pages/               # 13 page components (Dashboard, Hotspot, Vouchers, …)
│   ├── components/          # Reusable UI components (+ shadcn/ui)
│   ├── hooks/               # Custom hooks (useMikrotik, useRouterPrefetch, …)
│   ├── contexts/            # AuthContext
│   ├── integrations/        # Supabase client & generated types
│   ├── lib/                 # Utilities and router config helpers
│   ├── stores/              # Background job pub/sub store
│   ├── App.tsx              # Root router & providers
│   └── main.tsx             # Entry point
└── supabase/
    ├── functions/           # Edge Functions (Deno)
    └── migrations/          # SQL schema migrations
```

### Page Routes

| Route | Page | Access |
|---|---|---|
| `/` | Landing page | Public |
| `/auth` | Sign in / Sign up | Public |
| `/access` | Access approval gateway | Authenticated |
| `/routers` | Router connection management | Authenticated |
| `/dashboard` | Main dashboard | Protected |
| `/hotspot` | Hotspot user management | Protected |
| `/usermanager` | User Manager | Protected |
| `/vouchers` | Card / voucher generation | Protected |
| `/backups` | Backup & restore | Admin only |
| `/sales` | Sales analytics | Protected |
| `/settings` | Application settings | Admin only |
| `/admin/users` | User administration | Admin only |

---

## 🚀 Getting Started

### Prerequisites

- **Node.js** ≥ 18 and **npm** (or [Bun](https://bun.sh/))
- A [Supabase](https://supabase.com/) project with the schema applied (see `supabase/migrations/`)

### Installation

```sh
# 1. Clone the repository
git clone https://github.com/Alwahdi/mikrotik-whisperer.git
cd mikrotik-whisperer

# 2. Install dependencies
npm install          # or: bun install

# 3. Set up environment variables
#    Copy the example and fill in your Supabase credentials
cp .env.example .env
```

Your `.env` file needs (see `.env.example`):

```env
VITE_SUPABASE_URL=https://<project-id>.supabase.co
VITE_SUPABASE_PUBLISHABLE_KEY=<your-anon-key>
VITE_SUPABASE_PROJECT_ID=<your-project-id>
```

Find these values in your Supabase project under **Settings → API**.

### Development

```sh
npm run dev          # Start dev server on http://localhost:8080
```

### Production Build

```sh
npm run build        # Optimised build → dist/
npm run preview      # Preview the production build locally
```

### Testing

```sh
npm run test         # Run tests once (Vitest)
npm run test:watch   # Watch mode
```

### Linting

```sh
npm run lint         # ESLint
```

---

## 🗄 Database

The Supabase database schema is managed via migrations in `supabase/migrations/`. Key tables:

- **profiles** — user profiles and metadata
- **user_roles** — role-based access control (`admin`, `cashier`)
- **user_access** — access status (`pending`, `active`, `suspended`, `expired`)
- **routers** — saved MikroTik connection configurations
- **sales** — sales transaction history
- **vouchers** — generated prepaid cards

All tables are protected by Row-Level Security (RLS) policies.

---

## 🏗 Architecture Overview

```
Browser (React SPA)
    │
    ├─ React Query ──► Supabase Client ──► Supabase Auth / DB
    │
    └─ useMikrotik hook ──► Supabase Edge Function (Deno)
                                │
                                └──► MikroTik RouterOS API
```

- **Authentication** is handled by Supabase Auth (email/password).
- **Router communication** goes through the `mikrotik-api` Edge Function which proxies commands to the target RouterOS device.
- **State management** combines React Query (server state), React Context (auth), and a lightweight pub/sub store (background jobs).

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/my-feature`
3. Commit your changes: `git commit -m 'feat: add my feature'`
4. Push to the branch: `git push origin feature/my-feature`
5. Open a Pull Request

---

## 📄 License

This project is open source. See the repository for license details.
