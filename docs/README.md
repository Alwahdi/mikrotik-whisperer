# Mikrotik Whisperer - Documentation

Welcome to the Mikrotik Whisperer documentation! This guide will help you get started with the platform and understand its architecture.

## Table of Contents

- [Getting Started](./getting-started.md)
- [Architecture](./architecture.md)
- [Development Guide](./development-guide.md)
- [Testing Guide](./testing-guide.md)
- [API Reference](./api-reference.md)
- [Contributing](../CONTRIBUTING.md)
- [Agent Signing](./agent-signing.md)

## Quick Links

- [Installation](#installation)
- [Running Locally](#running-locally)
- [Building for Production](#building-for-production)

## Installation

```bash
# Clone the repository
git clone https://github.com/Alwahdi/mikrotik-whisperer.git
cd mikrotik-whisperer

# Install dependencies
npm install --legacy-peer-deps

# Set up environment variables
cp .env.local.example .env.local
# Edit .env.local with your configuration

# Install agent dependencies
npm run agent:install
```

## Running Locally

```bash
# Run web app and agent together
npm run dev:all

# Or run separately
npm run dev        # Web app only
npm run agent:dev  # Agent only
```

Access the application at `http://localhost:8080`

## Building for Production

```bash
# Build all apps
npm run build

# Build specific apps
npm run build:web
npm run agent:build
```

## Project Structure

```
mikrotik-whisperer/
├── src/                    # Web app source code
│   ├── app/               # Next.js app directory
│   ├── components/        # React components
│   ├── page-components/   # Page-level components
│   ├── contexts/          # React contexts
│   ├── hooks/             # Custom hooks
│   └── lib/               # Utilities
├── agent/                 # Local agent service
│   └── src/
├── mobile/                # Expo mobile app
│   ├── app/
│   └── components/
├── packages/              # Shared packages
│   ├── eslint-config/
│   ├── typescript-config/
│   └── ui-config/
├── docs/                  # Documentation
└── supabase/             # Database migrations
```

## Technology Stack

### Web Application

- **Framework**: Next.js 16.x (App Router)
- **UI Library**: React 18.x
- **Styling**: Tailwind CSS + shadcn/ui
- **State Management**: React Query + Zustand
- **Form Handling**: React Hook Form + Zod
- **Backend**: Supabase (PostgreSQL + Edge Functions)

### Local Agent

- **Runtime**: Node.js
- **Framework**: Express.js
- **Language**: TypeScript
- **API**: RouterOS API Client

### Mobile App

- **Framework**: Expo (React Native)
- **Router**: Expo Router
- **Language**: TypeScript

### Development Tools

- **Monorepo**: Turborepo
- **Linting**: ESLint
- **Formatting**: Prettier
- **Testing**: Vitest (unit) + Playwright (e2e)
- **Git Hooks**: Husky
- **CI/CD**: GitHub Actions

## Key Features

- 🚀 **Fast & Modern**: Built with Next.js 16 and React 18
- 🎨 **Beautiful UI**: shadcn/ui components with dark mode support
- 📱 **Mobile-Ready**: Expo mobile app for iOS and Android
- 🔒 **Secure**: End-to-end type safety with TypeScript
- 🧪 **Well-Tested**: Unit and e2e tests with high coverage
- 📦 **Monorepo**: Turborepo for efficient builds
- 🌍 **i18n Ready**: RTL support for Arabic and other languages

## Support

- **Issues**: [GitHub Issues](https://github.com/Alwahdi/mikrotik-whisperer/issues)
- **Discussions**: [GitHub Discussions](https://github.com/Alwahdi/mikrotik-whisperer/discussions)
- **Contributing**: See [CONTRIBUTING.md](../CONTRIBUTING.md)

## License

See [LICENSE](../LICENSE) file for details.
