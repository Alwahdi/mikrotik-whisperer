# Contributing to Mikrotik Whisperer

Thank you for your interest in contributing to Mikrotik Whisperer! This document provides guidelines and instructions for contributing to the project.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Workflow](#development-workflow)
- [Branch Strategy](#branch-strategy)
- [Commit Convention](#commit-convention)
- [Pull Request Process](#pull-request-process)
- [Coding Standards](#coding-standards)
- [Testing](#testing)
- [Documentation](#documentation)

## Code of Conduct

We are committed to providing a welcoming and inclusive environment. Please be respectful and constructive in all interactions.

## Getting Started

### Prerequisites

- Node.js 20.x or higher
- npm (comes with Node.js)
- Git

### Initial Setup

1. Fork the repository on GitHub
2. Clone your fork locally:

   ```bash
   git clone https://github.com/YOUR-USERNAME/mikrotik-whisperer.git
   cd mikrotik-whisperer
   ```

3. Install dependencies:

   ```bash
   npm install --legacy-peer-deps
   ```

4. Set up environment variables:

   ```bash
   cp .env.local.example .env.local
   # Edit .env.local with your configuration
   ```

5. Run the development server:
   ```bash
   npm run dev:all  # Runs web + agent together
   ```

## Development Workflow

### Monorepo Structure

This project uses Turborepo for monorepo management:

```
mikrotik-whisperer/
├── apps/
│   ├── web/          # Next.js web application (root)
│   ├── mobile/       # Expo mobile application
│   └── agent/        # Node.js local agent
├── packages/
│   ├── eslint-config/      # Shared ESLint configuration
│   ├── typescript-config/  # Shared TypeScript configuration
│   └── ui-config/          # Shared UI configuration
└── docs/             # Documentation
```

### Available Scripts

#### Root Level

- `npm run dev` - Start web development server
- `npm run dev:all` - Start both web and agent
- `npm run build` - Build web application
- `npm test` - Run tests
- `npm run lint` - Run ESLint
- `npm run format` - Format code with Prettier

#### Agent

- `npm run agent:dev` - Start agent in development mode
- `npm run agent:build` - Build agent
- `npm run agent:start` - Start built agent

#### Mobile

- `npm --prefix mobile start` - Start Expo development server
- `npm --prefix mobile run ios` - Run on iOS simulator
- `npm --prefix mobile run android` - Run on Android emulator

## Branch Strategy

We follow a structured branching model:

### Branch Types

1. **`main`** - Production-ready code
   - Always stable and deployable
   - Protected branch (requires PR + review + passing CI)
   - Auto-deploys to production

2. **`develop`** - Integration branch for features
   - Latest development changes
   - Protected branch (requires PR + review + passing CI)
   - Auto-deploys to staging

3. **`feature/*`** - New features
   - Branch from: `develop`
   - Merge to: `develop`
   - Naming: `feature/description-of-feature`
   - Example: `feature/add-user-authentication`

4. **`bugfix/*`** - Bug fixes
   - Branch from: `develop`
   - Merge to: `develop`
   - Naming: `bugfix/description-of-bug`
   - Example: `bugfix/fix-login-redirect`

5. **`hotfix/*`** - Critical production fixes
   - Branch from: `main`
   - Merge to: `main` and `develop`
   - Naming: `hotfix/description-of-fix`
   - Example: `hotfix/fix-security-vulnerability`

6. **`release/*`** - Release preparation
   - Branch from: `develop`
   - Merge to: `main` and `develop`
   - Naming: `release/v1.2.3`
   - Example: `release/v1.0.0`

### Branch Naming Convention

Format: `<type>/<short-description>`

- Use lowercase and hyphens
- Keep it short but descriptive
- Use present tense

Good examples:

- `feature/add-router-monitoring`
- `bugfix/fix-voucher-generation`
- `docs/update-api-reference`

Bad examples:

- `feature/AddRouterMonitoring` (use lowercase)
- `fix` (too vague)
- `feature/add-router-monitoring-with-real-time-updates-and-notifications` (too long)

## Commit Convention

We use [Conventional Commits](https://www.conventionalcommits.org/) for clear commit history:

### Format

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types

- **feat**: New feature
- **fix**: Bug fix
- **docs**: Documentation changes
- **style**: Code style changes (formatting, no logic change)
- **refactor**: Code refactoring (no feature or bug fix)
- **perf**: Performance improvements
- **test**: Adding or updating tests
- **build**: Build system or dependency changes
- **ci**: CI/CD configuration changes
- **chore**: Other changes (tooling, configs, etc.)
- **revert**: Revert a previous commit

### Examples

```bash
feat(auth): add OAuth2 authentication

Implement OAuth2 authentication flow with Google and GitHub providers.
Includes login, logout, and token refresh functionality.

Closes #123

---

fix(router): resolve connection timeout issue

The RouterOS API connection was timing out after 30 seconds.
Increased timeout to 60 seconds and added retry logic.

Fixes #456

---

docs(readme): update installation instructions

Added troubleshooting section and clarified environment setup steps.
```

### Commit Message Rules

- Use imperative mood ("add" not "added" or "adds")
- First line should be ≤ 72 characters
- Body should wrap at 72 characters
- Separate subject from body with blank line
- Reference issues and PRs in footer

## Pull Request Process

### Before Creating a PR

1. **Ensure your branch is up to date:**

   ```bash
   git checkout develop
   git pull origin develop
   git checkout your-feature-branch
   git rebase develop
   ```

2. **Run all checks locally:**

   ```bash
   npm run lint           # Lint your code
   npm test               # Run tests
   npm run build          # Ensure build succeeds
   ```

3. **Update documentation** if needed

4. **Add/update tests** for your changes

### Creating a PR

1. Push your branch to your fork:

   ```bash
   git push origin feature/your-feature
   ```

2. Open a Pull Request on GitHub

3. Fill out the PR template completely

4. Link related issues using keywords:
   - `Closes #123`
   - `Fixes #456`
   - `Relates to #789`

### PR Requirements

✅ **Required for merge:**

- [ ] All CI checks passing
- [ ] At least one approving review
- [ ] No merge conflicts
- [ ] Branch is up to date with target branch
- [ ] Tests added/updated for changes
- [ ] Documentation updated (if needed)
- [ ] Commit messages follow convention
- [ ] Code follows style guidelines

### PR Review Process

1. **Automated checks run** (lint, test, build)
2. **Code review** by maintainer(s)
3. **Changes requested** (if needed)
4. **Approval** from reviewer(s)
5. **Merge** by maintainer

### After PR is Merged

1. Delete your feature branch (GitHub does this automatically)
2. Update your local repository:
   ```bash
   git checkout develop
   git pull origin develop
   ```

## Coding Standards

### TypeScript/JavaScript

- Use TypeScript for all new code
- Follow ESLint configuration
- Use functional components and hooks
- Prefer const over let
- Use meaningful variable names
- Add JSDoc comments for complex functions

### React Best Practices

- Use functional components
- Leverage React hooks appropriately
- Keep components small and focused
- Extract reusable logic into custom hooks
- Use proper TypeScript types (avoid `any`)

### Styling

- Use Tailwind CSS utility classes
- Follow existing component patterns
- Use shadcn/ui components when available
- Maintain dark mode compatibility
- Use CSS variables for theming

### File Naming

- React components: `PascalCase.tsx`
- Utilities/helpers: `camelCase.ts`
- Hooks: `useCamelCase.ts`
- Types: `PascalCase.types.ts`

### Code Organization

```typescript
// 1. Imports (external first, then internal)
import { useState } from "react";
import { Button } from "@/components/ui/button";

// 2. Types/Interfaces
interface Props {
  title: string;
}

// 3. Component
export function MyComponent({ title }: Props) {
  // 4. Hooks
  const [state, setState] = useState();

  // 5. Functions
  const handleClick = () => {
    // ...
  };

  // 6. Effects
  useEffect(() => {
    // ...
  }, []);

  // 7. Render
  return <div>{title}</div>;
}
```

## Testing

### Test Strategy

We use multiple testing approaches:

1. **Unit Tests** - Test individual functions/components
2. **Integration Tests** - Test component interactions
3. **E2E Tests** - Test complete user workflows

### Running Tests

```bash
# Run all tests
npm test

# Run tests in watch mode
npm run test:watch

# Run tests with coverage
npm test -- --coverage

# Run specific test file
npm test -- path/to/test.test.ts
```

### Writing Tests

- Place tests next to the code they test (e.g., `component.tsx` → `component.test.tsx`)
- Use descriptive test names
- Follow AAA pattern: Arrange, Act, Assert
- Mock external dependencies
- Aim for high coverage on critical paths

Example:

```typescript
import { describe, it, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import { MyComponent } from "./MyComponent";

describe("MyComponent", () => {
  it("should render the title", () => {
    // Arrange
    const title = "Test Title";

    // Act
    render(<MyComponent title={title} />);

    // Assert
    expect(screen.getByText(title)).toBeInTheDocument();
  });
});
```

## Documentation

### When to Update Docs

Update documentation when you:

- Add a new feature
- Change existing functionality
- Add new API endpoints
- Update configuration options
- Fix bugs that affect usage

### Documentation Structure

- **README.md** - Project overview and quick start
- **docs/** - Detailed documentation
  - **getting-started.md** - Installation and setup
  - **architecture.md** - System architecture
  - **api-reference.md** - API documentation
  - **contributing.md** - This file

### Documentation Style

- Use clear, concise language
- Include code examples
- Add screenshots for UI features
- Keep it up to date
- Use proper markdown formatting

## Questions?

If you have questions:

1. Check existing documentation
2. Search closed issues/PRs
3. Ask in GitHub Discussions
4. Open a new issue with the `question` label

## License

By contributing, you agree that your contributions will be licensed under the same license as the project (check LICENSE file).

---

Thank you for contributing to Mikrotik Whisperer! 🎉
