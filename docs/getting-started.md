# Getting Started with Mikrotik Whisperer

This guide will help you set up Mikrotik Whisperer on your local machine and start developing.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Node.js** 20.x or higher ([Download](https://nodejs.org/))
- **npm** (comes with Node.js)
- **Git** ([Download](https://git-scm.com/))

Optional but recommended:

- **Visual Studio Code** ([Download](https://code.visualstudio.com/))
- **Supabase CLI** ([Installation](https://supabase.com/docs/guides/cli))

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Alwahdi/mikrotik-whisperer.git
cd mikrotik-whisperer
```

### 2. Install Dependencies

```bash
npm install --legacy-peer-deps
```

The `--legacy-peer-deps` flag is needed due to some peer dependency conflicts.

### 3. Set Up Environment Variables

Copy the example environment file:

```bash
cp .env.local.example .env.local
```

Edit `.env.local` with your configuration:

```env
# Supabase Configuration
NEXT_PUBLIC_SUPABASE_URL=your_supabase_url
NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY=your_supabase_anon_key

# Agent Configuration (optional)
NEXT_PUBLIC_MIKROTIK_AGENT_URL=http://127.0.0.1:3001
```

> **Note**: You can get Supabase credentials by creating a free project at [supabase.com](https://supabase.com)

### 4. Install Agent Dependencies

```bash
npm run agent:install
```

### 5. Set Up Database (Optional)

If you're using Supabase locally:

```bash
# Install Supabase CLI
npm install -g supabase

# Start local Supabase
supabase start

# Apply migrations
supabase db push
```

## Running the Application

### Option 1: Run Everything Together (Recommended)

```bash
npm run dev:all
```

This starts both the web application and the local agent simultaneously.

- **Web App**: http://localhost:8080
- **Agent API**: http://localhost:3001

### Option 2: Run Separately

#### Web Application Only

```bash
npm run dev
```

Access at: http://localhost:8080

#### Agent Only

```bash
npm run agent:dev
```

API available at: http://localhost:3001

### Mobile App (Optional)

```bash
# Install mobile dependencies
npm run mobile:install

# Start Expo development server
npm run mobile:start
```

Then use Expo Go app on your phone or an emulator to run the mobile app.

## Development Workflow

### Making Changes

1. **Create a new branch**:

   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Make your changes** using your favorite editor

3. **Test your changes**:

   ```bash
   npm run lint        # Check for linting errors
   npm test            # Run unit tests
   npm run typecheck   # Check TypeScript types
   ```

4. **Commit your changes**:

   ```bash
   git add .
   git commit -m "feat: your descriptive message"
   ```

   The pre-commit hook will automatically lint and format your code.

### Available Scripts

| Command                | Description                   |
| ---------------------- | ----------------------------- |
| `npm run dev`          | Start web development server  |
| `npm run dev:all`      | Start web + agent together    |
| `npm run build`        | Build all apps with Turbo     |
| `npm run build:web`    | Build web app only            |
| `npm test`             | Run unit tests                |
| `npm run test:watch`   | Run tests in watch mode       |
| `npm run test:e2e`     | Run e2e tests with Playwright |
| `npm run lint`         | Lint all code                 |
| `npm run lint:fix`     | Fix linting errors            |
| `npm run format`       | Format all code with Prettier |
| `npm run typecheck`    | Check TypeScript types        |
| `npm run agent:dev`    | Start agent in development    |
| `npm run agent:build`  | Build agent                   |
| `npm run mobile:start` | Start Expo dev server         |

## Project Structure Overview

```
mikrotik-whisperer/
├── src/                       # Web app source
│   ├── app/                   # Next.js pages (App Router)
│   ├── components/            # React components
│   │   └── ui/               # shadcn/ui components
│   ├── page-components/       # Page-level components
│   ├── contexts/              # React contexts
│   ├── hooks/                 # Custom React hooks
│   ├── lib/                   # Utilities & helpers
│   └── integrations/          # External integrations
├── agent/                     # Local agent service
│   └── src/
│       ├── routes/           # Express routes
│       ├── services/         # Business logic
│       └── utils/            # Agent utilities
├── mobile/                    # Expo mobile app
│   ├── app/                  # Expo Router pages
│   └── components/           # Mobile components
├── packages/                  # Shared packages
│   ├── eslint-config/        # Shared ESLint config
│   ├── typescript-config/    # Shared TS config
│   └── ui-config/            # Shared UI config
├── tests/                     # Test files
│   └── e2e/                  # E2E tests
├── docs/                      # Documentation
└── supabase/                  # Supabase config & migrations
```

## Next Steps

- 📖 Read the [Architecture Guide](./architecture.md) to understand the system design
- 🧪 Learn about [Testing](./testing-guide.md) to write tests
- 🛠️ Check [Development Guide](./development-guide.md) for advanced topics
- 🤝 See [Contributing Guide](../CONTRIBUTING.md) to contribute

## Troubleshooting

### Port Already in Use

If port 8080 or 3001 is already in use:

**Web App:**

```bash
# Edit package.json or run with different port
PORT=3000 npm run dev
```

**Agent:**
Edit `agent/src/index.ts` to change the port.

### Module Not Found Errors

Clear cache and reinstall:

```bash
rm -rf node_modules package-lock.json
npm install --legacy-peer-deps
```

### Type Errors

Rebuild TypeScript:

```bash
npm run typecheck
```

### Husky Hooks Not Working

Reinstall Husky:

```bash
npm run prepare
```

## Getting Help

- 🐛 [Report a Bug](https://github.com/Alwahdi/mikrotik-whisperer/issues/new?template=bug_report.yml)
- ✨ [Request a Feature](https://github.com/Alwahdi/mikrotik-whisperer/issues/new?template=feature_request.yml)
- 💬 [Ask a Question](https://github.com/Alwahdi/mikrotik-whisperer/discussions)

Happy coding! 🎉
