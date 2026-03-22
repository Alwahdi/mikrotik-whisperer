# Architecture

This document describes the high-level architecture of MikroTik Whisperer.

## Overview

MikroTik Whisperer is a web-based management platform for MikroTik routers. It supports two runtime modes depending on the router's network accessibility:

```
┌─────────────────────────────────────────────────────────┐
│                   Browser (Next.js App)                  │
│  src/app/  ─────  src/page-components/  ─── src/lib/    │
└────────────────────────┬────────────────────────────────┘
                         │
         ┌───────────────┴───────────────┐
         ▼                               ▼
┌─────────────────┐           ┌──────────────────────┐
│  CoreRoute      │           │  Supabase Cloud       │
│  Local Agent    │           │  Edge Functions       │
│  (LAN routers)  │           │  (public IP routers)  │
│  :3001          │           │                       │
└────────┬────────┘           └──────────┬────────────┘
         │                               │
         ▼                               ▼
    MikroTik Router (LAN)        MikroTik Router (WAN)
```

## Components

### Web App (`/src`)

Built with **Next.js 16 App Router**. Key directories:

| Path                   | Purpose                                     |
| ---------------------- | ------------------------------------------- |
| `src/app/`             | Next.js route definitions (thin wrappers)   |
| `src/page-components/` | Full page component implementations         |
| `src/components/`      | Reusable UI components (shadcn/ui + custom) |
| `src/lib/`             | Utilities, MikroTik API client, helpers     |
| `src/hooks/`           | React custom hooks                          |
| `src/integrations/`    | Third-party integration clients (Supabase)  |
| `src/stores/`          | Global state (Zustand or Context)           |

### Local Agent (`/agent`)

A lightweight **Express.js** server that runs on the user's machine. It proxies RouterOS API calls from the browser to LAN-accessible MikroTik routers, bypassing CORS restrictions.

- Default URL: `http://127.0.0.1:3001`
- Overridable via `NEXT_PUBLIC_MIKROTIK_AGENT_URL` env var or the Settings page.

### Mobile App (`/mobile`)

Built with **Expo SDK 54 + React Native**. Uses Expo Router for navigation. Shares design tokens (colors, typography, spacing) with the web app.

### Supabase Backend

Used for:

- Authentication (Supabase Auth)
- Router metadata storage (PostgreSQL via Supabase)
- Cloud bridge edge functions for WAN router access

## Runtime Mode Detection

When a user connects to a router, the app determines which path to use:

1. **Local LAN** (192.168.x.x, 10.x.x.x, 172.16-31.x.x, localhost) → CoreRoute Local Agent
2. **Public IP / DNS** → Supabase Edge Function cloud bridge

If the Local Agent is not running when a LAN router is selected, the UI shows installation instructions.

## Data Flow

```
User selects router
      │
      ▼
mikrotikInvoke() in src/lib/mikrotikInvoke.ts
      │
      ├─── LAN target? ──► POST http://127.0.0.1:3001/api/invoke
      │                              │
      │                              ▼
      │                    Agent proxies to RouterOS API
      │
      └─── WAN target? ──► Supabase Edge Function
                                    │
                                    ▼
                           RouterOS API (via cloud)
```

## Tech Stack

| Layer       | Technology                                     |
| ----------- | ---------------------------------------------- |
| Web UI      | Next.js 16, React 19, TypeScript, Tailwind CSS |
| Components  | shadcn/ui, Radix UI                            |
| State       | TanStack Query, React Context                  |
| Mobile      | Expo SDK 54, React Native, Expo Router         |
| Backend     | Supabase (Auth, PostgreSQL, Edge Functions)    |
| Local Agent | Node.js, Express, TypeScript                   |
| CI/CD       | GitHub Actions, Vercel, EAS Build              |
| Testing     | Vitest, Testing Library                        |
