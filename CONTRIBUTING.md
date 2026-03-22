# Contributing to MikroTik Whisperer

Thank you for your interest in contributing! This document outlines the development workflow, branch strategy, code standards, and review process for this project.

---

## Table of Contents

- [Branch Strategy](#branch-strategy)
- [Commit Convention](#commit-convention)
- [Pull Request Process](#pull-request-process)
- [Code Style](#code-style)
- [Testing](#testing)
- [Development Setup](#development-setup)

---

## Branch Strategy

We follow a simplified **Git Flow** model:

| Branch      | Purpose                                          | Protected |
| ----------- | ------------------------------------------------ | --------- |
| `main`      | Production-ready code. Deployed to production.   | ✅ Yes    |
| `develop`   | Integration branch. Deployed to staging/preview. | ✅ Yes    |
| `feature/*` | New features (e.g. `feature/router-dashboard`)   | ❌ No     |
| `bugfix/*`  | Bug fixes (e.g. `bugfix/login-redirect`)         | ❌ No     |
| `release/*` | Release preparation (e.g. `release/v1.2.0`)      | ❌ No     |
| `hotfix/*`  | Urgent production fixes (branched from `main`)   | ❌ No     |
| `docs/*`    | Documentation-only changes                       | ❌ No     |
| `chore/*`   | Maintenance tasks (deps, configs, refactors)     | ❌ No     |

### Rules

- **Never commit directly to `main` or `develop`** — always use pull requests.
- Branch off `develop` for features, bugfixes, and chores.
- Branch off `main` for hotfixes only, then merge back into both `main` and `develop`.
- Keep branches short-lived and focused on a single concern.
- Delete branches after merging.

---

## Commit Convention

We use [Conventional Commits](https://www.conventionalcommits.org/). Commits are linted automatically via `commitlint` on pre-commit.

### Format

```
<type>(<scope>): <short summary>
```

### Types

| Type       | When to use                                      |
| ---------- | ------------------------------------------------ |
| `feat`     | A new feature                                    |
| `fix`      | A bug fix                                        |
| `docs`     | Documentation changes only                       |
| `style`    | Formatting, missing semicolons (no logic change) |
| `refactor` | Code restructuring without feature/fix           |
| `perf`     | Performance improvements                         |
| `test`     | Adding or updating tests                         |
| `build`    | Build system or dependency changes               |
| `ci`       | CI/CD configuration changes                      |
| `chore`    | Maintenance tasks                                |
| `revert`   | Reverting a previous commit                      |

### Examples

```
feat(router): add bandwidth monitoring chart
fix(auth): resolve redirect loop on token expiry
docs(contributing): add branch strategy section
chore(deps): upgrade tailwindcss to v4
```

---

## Pull Request Process

1. **Create a branch** from `develop` (or `main` for hotfixes):

   ```bash
   git checkout develop
   git pull origin develop
   git checkout -b feature/my-awesome-feature
   ```

2. **Implement your changes** following the code style and testing guidelines below.

3. **Push and open a PR** targeting `develop` (or `main` for hotfixes).

4. **Fill out the PR template** — describe the change, link the issue, tick the checklist.

5. **CI must pass** — all lint, type-check, test, and build checks are required before merging.

6. **At least one review required** — a maintainer must approve the PR before merging.

7. **Squash or rebase merge** preferred to keep a clean commit history.

### PR Checklist (summary)

- Tests added/updated and passing
- Docs updated if applicable
- No unrelated changes
- Screenshots attached for UI changes

---

## Code Style

We use the following tools to enforce consistent code quality. They run automatically via Husky pre-commit hooks.

### TypeScript / JavaScript

- **ESLint** — `npm run lint` or `npx eslint .`
- **Prettier** — `npx prettier --write .`
- Config files: `eslint.config.js`, `.prettierrc`

### CSS / Tailwind

- We use **Tailwind CSS** with class ordering enforced by `prettier-plugin-tailwindcss`.

### Rules

- No `any` types unless absolutely necessary and commented.
- Prefer `const` over `let`; avoid `var`.
- Use named exports for components; avoid default exports except for page components.
- Keep components small and focused; extract hooks and utilities.

---

## Testing

We use **Vitest** for unit and integration tests and plan to add **Playwright** for end-to-end tests.

### Running Tests

```bash
# Run tests once
npm test

# Run in watch mode
npm run test:watch
```

### Writing Tests

- Place test files alongside source files as `*.test.ts` / `*.test.tsx`, or under `src/test/`.
- Each new feature or bug fix **must** include tests.
- Test edge cases, not just the happy path.
- Use `@testing-library/react` for component tests.

### Test Structure

```
src/
  test/
    setup.ts          # Global test setup (jest-dom, mocks)
    example.test.ts   # Example test
  components/
    MyComponent.tsx
    MyComponent.test.tsx  # Co-located component test
```

---

## Development Setup

### Prerequisites

- Node.js 20+ (LTS)
- npm 10+

### Quick Start

```bash
# Clone the repository
git clone https://github.com/Alwahdi/mikrotik-whisperer.git
cd mikrotik-whisperer

# Install web dependencies
npm install --legacy-peer-deps

# Install agent dependencies
npm run agent:install

# Copy env template and fill in values
cp .env.local.example .env.local

# Run web app + local agent together
npm run dev:all
```

The web app runs at `http://localhost:8080` and the local agent at `http://localhost:3001`.

### Mobile App

```bash
cd mobile
npm install --legacy-peer-deps
npx expo start
```

### Environment Variables

See `.env.local.example` for required variables:

- `NEXT_PUBLIC_SUPABASE_URL` — Your Supabase project URL
- `NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY` — Your Supabase anon/publishable key
- `NEXT_PUBLIC_MIKROTIK_AGENT_URL` — Local agent URL (defaults to `http://127.0.0.1:3001`)

---

## Questions?

Open a [GitHub Discussion](https://github.com/Alwahdi/mikrotik-whisperer/discussions) or file an [issue](https://github.com/Alwahdi/mikrotik-whisperer/issues).
