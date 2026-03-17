# MikroTik Whisperer

A modern web application for managing MikroTik routers — hotspot management, user management, vouchers, backups, and more.

## ✨ Features

- 🔐 **Authentication** — Secure sign-in/sign-up powered by Supabase
- 🌐 **Router Management** — Connect and manage multiple MikroTik routers
- 📡 **Hotspot Management** — Monitor and control hotspot users in real time
- 👥 **User Manager** — Full PPPoE/hotspot user lifecycle management
- 🎫 **Vouchers** — Generate, print, and manage hotspot vouchers
- 💾 **Backups** — Scheduled and on-demand router configuration backups
- 📊 **Dashboard** — Live traffic charts and system health cards
- 💰 **Sales** — Revenue tracking and reporting
- 🌙 **Dark/Light mode** — Full theme support with system preference detection

## 🛠 Tech Stack

| Layer          | Technology               |
| -------------- | ------------------------ |
| Framework      | React 18 + Vite          |
| Language       | TypeScript (strict mode) |
| Styling        | Tailwind CSS + ShadCN UI |
| Data fetching  | TanStack Query v5        |
| Backend / Auth | Supabase                 |
| Forms          | React Hook Form + Zod    |
| Charts         | Recharts                 |
| Routing        | React Router DOM v6      |
| Testing        | Vitest + Testing Library |

## 🚀 Getting Started

### Prerequisites

- Node.js 20+
- npm 10+

### Installation

```bash
# Clone the repository
git clone https://github.com/Alwahdi/mikrotik-whisperer.git
cd mikrotik-whisperer

# Install dependencies
npm install

# Copy environment variables
cp .env.example .env
# Edit .env with your Supabase credentials

# Start the development server
npm run dev
```

The app will be available at [http://localhost:8080](http://localhost:8080).

### Environment Variables

| Variable                 | Description                 |
| ------------------------ | --------------------------- |
| `VITE_SUPABASE_URL`      | Your Supabase project URL   |
| `VITE_SUPABASE_ANON_KEY` | Your Supabase anonymous key |

## 📜 Available Scripts

| Command                | Description                 |
| ---------------------- | --------------------------- |
| `npm run dev`          | Start development server    |
| `npm run build`        | Build for production        |
| `npm run preview`      | Preview production build    |
| `npm run lint`         | Run ESLint                  |
| `npm run lint:fix`     | Run ESLint with auto-fix    |
| `npm run format`       | Format code with Prettier   |
| `npm run format:check` | Check code formatting       |
| `npm run typecheck`    | Run TypeScript type checker |
| `npm test`             | Run tests once              |
| `npm run test:watch`   | Run tests in watch mode     |

## 🏗 Project Structure

```
src/
├── components/       # Reusable UI components
│   └── ui/           # ShadCN base components
├── contexts/         # React contexts (AuthContext)
├── hooks/            # Custom React hooks
├── integrations/     # Third-party integrations (Supabase)
├── lib/              # Utility functions
├── pages/            # Page-level components
├── stores/           # Zustand / state stores
└── test/             # Test setup and utilities
```

## 🔄 CI/CD Pipeline

The project uses GitHub Actions for continuous integration:

| Job            | Trigger                     | What it does                            |
| -------------- | --------------------------- | --------------------------------------- |
| **Lint**       | Every PR / push             | Runs ESLint across all TypeScript files |
| **Type Check** | Every PR / push             | Verifies TypeScript types (strict mode) |
| **Build**      | After lint + typecheck pass | Produces production bundle              |
| **Test**       | After lint + typecheck pass | Runs Vitest test suite                  |

Merges to `main` or `develop` are blocked unless all CI jobs pass.

## 🐶 Git Hooks (Husky)

| Hook         | Command                                        |
| ------------ | ---------------------------------------------- |
| `pre-commit` | `lint-staged` — lints and formats staged files |
| `commit-msg` | `commitlint` — enforces Conventional Commits   |
| `pre-push`   | `tsc --noEmit` — TypeScript type check         |

## 📝 Commit Convention

This project follows [Conventional Commits](https://www.conventionalcommits.org/):

```
<type>(<scope>): <subject>

Examples:
feat(hotspot): add bulk user disconnect
fix(auth): handle expired session redirect
docs(readme): add environment variables table
```

**Allowed types:** `feat`, `fix`, `docs`, `style`, `refactor`, `perf`, `test`, `build`, `ci`, `chore`, `revert`

## 🤝 Contributing

Please read [CONTRIBUTING.md](.github/CONTRIBUTING.md) for guidelines on how to contribute.

1. Fork the repository
2. Create your feature branch: `git checkout -b feat/amazing-feature`
3. Commit your changes following Conventional Commits
4. Push to the branch: `git push origin feat/amazing-feature`
5. Open a Pull Request using the provided template

## 📄 License

This project is private and proprietary.
