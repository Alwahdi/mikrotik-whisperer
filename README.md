# MikroTik Whisperer - Enterprise-Grade Network Management Platform

A world-class, production-ready network management application built with modern technologies and best practices.

## 🏗️ Architecture

This project uses a **monorepo architecture** powered by TurboRepo, ensuring scalability, maintainability, and optimal developer experience.

### Tech Stack

- **Framework**: Next.js 16 with App Router
- **Build Tool**: TurboRepo for monorepo management
- **UI Library**: React 19
- **Styling**: Tailwind CSS v4 + ShadCN UI (customized)
- **Type Safety**: TypeScript with strict mode
- **Backend**: Supabase
- **State Management**: TanStack Query
- **Forms**: React Hook Form + Zod
- **Analytics**: Vercel Analytics
- **Testing**: Vitest
- **CI/CD**: GitHub Actions
- **Git Hooks**: Husky + lint-staged
- **Code Quality**: ESLint + Prettier

## 📁 Project Structure

```
mikrotik-whisperer/
├── apps/
│   ├── web/                 # Next.js web application
│   └── mobile/              # Expo mobile app (existing)
├── packages/
│   ├── ui/                  # Shared React components (design system)
│   ├── config/              # Shared ESLint configs
│   ├── tsconfig/            # Shared TypeScript configs
│   └── utils/               # Shared utility functions
├── .github/
│   └── workflows/           # CI/CD pipelines
├── .husky/                  # Git hooks
├── turbo.json               # TurboRepo configuration
└── package.json             # Root package.json with workspace config
```

## 🚀 Getting Started

### Prerequisites

- Node.js 20.x or higher
- npm 10.x or higher

### Installation

```bash
# Clone the repository
git clone <YOUR_GIT_URL>
cd mikrotik-whisperer

# Install dependencies for all workspaces
npm install

# Start development server
npm run dev

# Or start only the web app
npm run dev:web
```

### Development

```bash
# Run all apps in development mode
npm run dev

# Run linting
npm run lint

# Run type checking
npm run type-check

# Run tests
npm run test

# Format code
npm run format

# Build all apps
npm run build

# Build only web app
npm run build:web
```

## 🎨 Design System

Our design system is built on top of Tailwind CSS and ShadCN UI with heavy customizations to ensure:

- **Consistency**: All components follow a unified design language
- **Accessibility**: WCAG 2.1 AA compliant
- **Theming**: Built-in dark/light mode support
- **Performance**: Optimized for Core Web Vitals
- **Scalability**: Easily extendable component library

### Using Components

```tsx
import { Button } from "@mikrotik-whisperer/ui";

export default function Page() {
  return (
    <Button variant="default" size="lg">
      Click me
    </Button>
  );
}
```

## 🔐 Code Quality & Standards

### TypeScript

All packages use strict TypeScript configuration:

- `strict: true`
- `noImplicitAny: true`
- `strictNullChecks: true`
- `noUnusedLocals: true`
- `noUnusedParameters: true`

### ESLint

Enforced rules:

- No explicit `any` types
- Unused variables detection
- React hooks rules
- Consistent code style

### Git Workflow

#### Commit Convention

This project follows [Conventional Commits](https://www.conventionalcommits.org/):

```
feat: add new dashboard widget
fix: resolve authentication bug
docs: update README
chore: upgrade dependencies
refactor: improve query performance
test: add unit tests for auth flow
```

#### Git Hooks

- **pre-commit**: Runs lint-staged (lint + format modified files)
- **commit-msg**: Validates commit message format
- **pre-push**: Runs type-check and tests

## 🧪 Testing

```bash
# Run all tests
npm run test

# Run tests in watch mode
npm run test:watch

# Run tests for specific package
npm run test --filter=web
```

## 📦 Building

```bash
# Build all apps and packages
npm run build

# Build specific app
npm run build --filter=web
```

## 🚢 Deployment

### Vercel (Recommended)

The project is optimized for Vercel deployment:

1. Connect your repository to Vercel
2. Set environment variables:
   - `NEXT_PUBLIC_SUPABASE_URL`
   - `NEXT_PUBLIC_SUPABASE_ANON_KEY`
3. Deploy automatically on push to `main`

### Manual Deployment

```bash
# Build the project
npm run build

# Start production server
cd apps/web && npm start
```

## 🔄 CI/CD

GitHub Actions workflows:

- **CI**: Runs on every PR and push
  - Lint check
  - Type check
  - Tests
  - Build verification

- **Deploy**: Auto-deploys to production on merge to `main`

## 🌐 Environment Variables

Create `.env.local` in `apps/web`:

```env
# Supabase
NEXT_PUBLIC_SUPABASE_URL=your_supabase_url
NEXT_PUBLIC_SUPABASE_ANON_KEY=your_supabase_anon_key

# Analytics (optional)
NEXT_PUBLIC_VERCEL_ANALYTICS_ID=your_analytics_id
```

## 📚 Documentation

- [Next.js Documentation](https://nextjs.org/docs)
- [TurboRepo Documentation](https://turbo.build/repo/docs)
- [ShadCN UI Documentation](https://ui.shadcn.com)
- [Tailwind CSS Documentation](https://tailwindcss.com/docs)

## 🤝 Contributing

### Development Workflow

1. Create a feature branch: `git checkout -b feature/my-feature`
2. Make your changes
3. Commit using conventional commits
4. Push and create a pull request
5. Wait for CI checks to pass
6. Request review from team members

### Pull Request Template

```markdown
## Description

Brief description of changes

## Type of Change

- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Testing

- [ ] Tested locally
- [ ] Added/updated tests
- [ ] All tests passing

## Screenshots (if applicable)

Add screenshots here
```

## 📊 Performance

This project is optimized for:

- **Lighthouse Score**: 90+ across all metrics
- **Core Web Vitals**: All metrics in "Good" range
- **Bundle Size**: Optimized with code splitting and tree shaking
- **Loading**: Server-side rendering and streaming
- **Caching**: Aggressive caching strategies

## 🔒 Security

- Environment variables properly scoped
- No secrets in codebase
- Regular dependency updates
- Security scanning in CI/CD

## 📄 License

[Your License Here]

## 🆘 Support

For issues and questions:

- Open an issue on GitHub
- Check existing documentation
- Contact the development team

---

**Built with ❤️ using modern web technologies**
