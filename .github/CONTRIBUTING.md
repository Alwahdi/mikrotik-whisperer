# Contributing to MikroTik Whisperer

Thank you for your interest in contributing! This guide will help you get started.

## Table of Contents

- [Development Setup](#development-setup)
- [Project Structure](#project-structure)
- [Coding Standards](#coding-standards)
- [Commit Convention](#commit-convention)
- [Pull Request Process](#pull-request-process)
- [Reporting Issues](#reporting-issues)

## Development Setup

```bash
# Install dependencies
npm install

# Start development server
npm run dev

# Run tests
npm test

# Type check
npm run typecheck

# Lint
npm run lint
```

## Coding Standards

### TypeScript

- **Strict mode is enabled** — all code must pass `tsc --noEmit` without errors
- Prefer explicit types over `any`
- Use type inference where it is obvious (e.g. `const x = 42`)
- Use interfaces for object shapes that represent data, type aliases for unions/intersections

### React

- Use functional components with hooks — no class components
- Keep components small and focused on a single responsibility
- Extract reusable logic into custom hooks (`src/hooks/`)
- Co-locate styles with components using Tailwind utility classes
- Use ShadCN UI components from `src/components/ui/` as building blocks

### File Naming

| Type       | Convention                    | Example           |
| ---------- | ----------------------------- | ----------------- |
| Components | PascalCase                    | `UserCard.tsx`    |
| Hooks      | camelCase with `use` prefix   | `useRouters.ts`   |
| Utilities  | camelCase                     | `formatBytes.ts`  |
| Pages      | PascalCase with `Page` suffix | `HotspotPage.tsx` |

### Imports

Use the `@/` path alias for imports from `src/`:

```ts
// ✅ Good
import { Button } from "@/components/ui/button";

// ❌ Bad
import { Button } from "../../components/ui/button";
```

## Commit Convention

This project follows [Conventional Commits](https://www.conventionalcommits.org/). Commit messages are automatically validated by `commitlint`.

### Format

```
<type>(<optional scope>): <subject>

<optional body>

<optional footer>
```

### Types

| Type       | When to use                                            |
| ---------- | ------------------------------------------------------ |
| `feat`     | A new feature                                          |
| `fix`      | A bug fix                                              |
| `docs`     | Documentation only changes                             |
| `style`    | Formatting, missing semicolons, etc. (no logic change) |
| `refactor` | Code refactoring (no feature/fix)                      |
| `perf`     | Performance improvements                               |
| `test`     | Adding or updating tests                               |
| `build`    | Build system or dependency changes                     |
| `ci`       | CI configuration changes                               |
| `chore`    | Other changes that don't modify src or test files      |
| `revert`   | Reverts a previous commit                              |

### Examples

```
feat(hotspot): add bulk user disconnect action
fix(auth): redirect to login on session expiry
docs(contributing): add commit convention section
refactor(vouchers): extract print logic into hook
test(dashboard): add unit test for stat card
```

## Pull Request Process

1. **Branch naming**: `<type>/<short-description>` (e.g. `feat/bulk-disconnect`, `fix/session-expiry`)
2. **Keep PRs small** — one feature or fix per PR
3. **Fill in the PR template** completely
4. **Include screenshots** for any UI changes
5. **All CI checks must pass** before requesting review
6. **Get at least one approval** before merging
7. **Squash commits** when merging if the PR has many small fixup commits

## Reporting Issues

Use the GitHub Issue templates:

- **Bug Report** — for unexpected behavior or errors
- **Feature Request** — for ideas and enhancements

Please search existing issues before opening a new one.
