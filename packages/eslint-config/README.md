# @repo/eslint-config

Shared ESLint configurations for the entire workspace.

## Configurations

### `@repo/eslint-config/base`
Base configuration for all TypeScript projects. Includes:
- TypeScript ESLint recommended rules
- Unused variable warnings (with `_` prefix ignore)
- Consistent type imports
- General JavaScript best practices

### `@repo/eslint-config/nextjs`
Configuration for Next.js applications. Includes:
- All base rules
- React Hooks rules
- Browser + Node globals
- Next.js specific patterns

### `@repo/eslint-config/react-library`
Configuration for React library packages. Includes:
- All base rules
- React Hooks rules
- Library-specific patterns

## Usage

### Next.js Applications (apps/*)

```javascript
// eslint.config.js
import config from '@repo/eslint-config/nextjs'

export default config
```

### React Libraries (packages/design-system, etc.)

```javascript
// eslint.config.js
import config from '@repo/eslint-config/react-library'

export default config
```

### Node.js Packages (packages/database, etc.)

```javascript
// eslint.config.js
import config from '@repo/eslint-config/base'

export default config
```

## Rules Overview

### TypeScript
- `@typescript-eslint/no-explicit-any`: warn
- `@typescript-eslint/no-unused-vars`: warn (ignores `_` prefix)
- `@typescript-eslint/consistent-type-imports`: warn

### React
- `react-hooks/rules-of-hooks`: error
- `react-hooks/exhaustive-deps`: warn

### General
- `no-console`: warn (allow error/warn)
- `prefer-const`: warn
- `no-var`: error

## Benefits

- ✅ **Consistency** - Same rules across all packages
- ✅ **Maintainability** - Update rules in one place
- ✅ **Best practices** - Industry-standard configurations
- ✅ **Type safety** - TypeScript-first approach
- ✅ **React patterns** - Hooks rules and patterns

## Architecture Decision

Following Next Forge best practices:
- Flat config format (ESLint 9+)
- Composable configurations
- Project-specific customization supported
- Zero-config for most cases
