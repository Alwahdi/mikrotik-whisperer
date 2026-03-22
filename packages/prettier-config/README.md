# @repo/prettier-config

Shared Prettier configuration for consistent code formatting across the workspace.

## Features

- ✅ **Consistent formatting** - Same style everywhere
- ✅ **Tailwind CSS support** - Automatic class sorting
- ✅ **TypeScript friendly** - Works with all TS/TSX files
- ✅ **Markdown support** - Proper prose wrapping
- ✅ **JSON formatting** - Clean config files

## Configuration

### Settings

```javascript
{
  semi: false,                    // No semicolons
  singleQuote: true,              // Single quotes for strings
  tabWidth: 2,                    // 2 spaces for indentation
  trailingComma: 'es5',           // Trailing commas where valid
  printWidth: 100,                // 100 characters per line
  arrowParens: 'always',          // Always parentheses in arrow functions
  plugins: ['prettier-plugin-tailwindcss']  // Auto-sort Tailwind classes
}
```

## Usage

### In package.json

```json
{
  "prettier": "@repo/prettier-config"
}
```

### In .prettierrc.js (if you need to extend)

```javascript
import config from '@repo/prettier-config'

export default {
  ...config,
  // Your custom overrides
  printWidth: 120,
}
```

## Editor Integration

### VSCode

Install the Prettier extension and add to `.vscode/settings.json`:

```json
{
  "editor.defaultFormatter": "esbenp.prettier-vscode",
  "editor.formatOnSave": true,
  "[javascript]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  },
  "[typescript]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  },
  "[typescriptreact]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  }
}
```

## Scripts

Add to your package.json:

```json
{
  "scripts": {
    "format": "prettier --write \"**/*.{js,jsx,ts,tsx,json,md}\"",
    "format:check": "prettier --check \"**/*.{js,jsx,ts,tsx,json,md}\""
  }
}
```

## Tailwind CSS Class Sorting

The config automatically sorts Tailwind CSS classes according to the official Tailwind CSS class order:

### Before
```tsx
<div className="px-4 bg-blue-500 text-white py-2 rounded">
```

### After
```tsx
<div className="rounded bg-blue-500 px-4 py-2 text-white">
```

## Benefits

- ✅ **No bike-shedding** - Formatting is automated
- ✅ **Consistent PRs** - No formatting diffs
- ✅ **Developer experience** - Format on save
- ✅ **Tailwind optimization** - Clean class ordering

## Architecture Decision

Following Next Forge best practices:
- Single source of truth for formatting
- Tailwind CSS plugin for class ordering
- Sensible defaults for TypeScript/React
- Easy to override when needed
