# Getting Started

This guide walks you through setting up MikroTik Whisperer locally for development or self-hosting.

## Prerequisites

| Tool    | Minimum Version | Notes                                                       |
| ------- | --------------- | ----------------------------------------------------------- |
| Node.js | 20 LTS          | Use [nvm](https://github.com/nvm-sh/nvm) to manage versions |
| npm     | 10+             | Comes bundled with Node.js 20                               |
| Git     | 2.40+           | —                                                           |

## 1. Clone the repository

```bash
git clone https://github.com/Alwahdi/mikrotik-whisperer.git
cd mikrotik-whisperer
```

## 2. Install dependencies

```bash
# Web app
npm install --legacy-peer-deps

# Local agent (optional — needed for LAN router management)
npm run agent:install
```

## 3. Configure environment variables

```bash
cp .env.local.example .env.local
```

Open `.env.local` and fill in your values:

| Variable                               | Description                                        | Required |
| -------------------------------------- | -------------------------------------------------- | -------- |
| `NEXT_PUBLIC_SUPABASE_URL`             | Your Supabase project URL                          | ✅       |
| `NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY` | Your Supabase anon key                             | ✅       |
| `NEXT_PUBLIC_MIKROTIK_AGENT_URL`       | Local agent URL (default: `http://127.0.0.1:3001`) | ❌       |

## 4. Start the development server

```bash
# Web app only
npm run dev

# Web app + local agent together
npm run dev:all
```

The web app is available at **http://localhost:8080**.  
The local agent is available at **http://localhost:3001**.

## 5. Mobile app (optional)

```bash
cd mobile
npm install --legacy-peer-deps
npx expo start
```

Scan the QR code with [Expo Go](https://expo.dev/go) to run on your device.

## Next Steps

- Read the [Architecture](./architecture.md) to understand the system design.
- Read the [Usage Guide](./usage.md) to learn about platform features.
- Read [Contributing](../CONTRIBUTING.md) to start contributing.
