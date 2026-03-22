# Testing Guide

This document explains the testing strategy, tooling, and conventions used in Mikrotik Whisperer.

## Testing Stack

| Tool                          | Purpose                        |
| ----------------------------- | ------------------------------ |
| **Vitest**                    | Unit and integration tests     |
| **@testing-library/react**    | React component testing        |
| **@testing-library/jest-dom** | Extended DOM matchers          |
| **jsdom**                     | Browser environment simulation |
| **Playwright** (planned)      | End-to-end UI tests            |

## Running Tests

```bash
# Run all tests once
npm test

# Run in watch mode (re-runs on file changes)
npm run test:watch
```

## Test File Locations

Tests can be placed in two ways:

1. **Co-located** — alongside the source file:

   ```
   src/components/MyComponent.tsx
   src/components/MyComponent.test.tsx
   ```

2. **Centralized** — under `src/test/`:
   ```
   src/test/example.test.ts
   ```

The Vitest config includes all `src/**/*.{test,spec}.{ts,tsx}` files.

## Test Setup

Global setup is in `src/test/setup.ts`. It:

- Imports `@testing-library/jest-dom` matchers
- Mocks `window.matchMedia` (not available in jsdom)

## Writing Tests

### Unit Test Example

```typescript
import { describe, it, expect } from "vitest";
import { myUtil } from "@/lib/myUtil";

describe("myUtil", () => {
  it("returns expected value", () => {
    expect(myUtil("input")).toBe("expected output");
  });
});
```

### Component Test Example

```typescript
import { render, screen } from "@testing-library/react";
import { describe, it, expect } from "vitest";
import { MyComponent } from "@/components/MyComponent";

describe("MyComponent", () => {
  it("renders the title", () => {
    render(<MyComponent title="Hello" />);
    expect(screen.getByText("Hello")).toBeInTheDocument();
  });
});
```

## Coverage

Run tests with coverage:

```bash
npx vitest run --coverage
```

Coverage reports are generated in `coverage/`.

## Guidelines

- Every new feature **must** include tests.
- Every bug fix **must** include a regression test.
- Aim for meaningful tests — test behaviour, not implementation details.
- Mock external services (Supabase, agent API) in tests.
- Keep tests fast; avoid real network calls.

## Planned: End-to-End Tests (Playwright)

E2E tests will be added under `e2e/` using Playwright. They will:

- Test critical user flows (login, router connection, dashboard)
- Run in CI on PRs targeting `main`
