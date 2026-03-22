# @repo/test-utils

Shared testing utilities, mocks, and fixtures for MikroTik Whisperer testing infrastructure.

## 📦 What's Inside

This package provides a comprehensive testing toolkit:

- **Mock Clients** - Supabase & MikroTik API mocks
- **Test Fixtures** - Factories for consistent test data
- **Custom Matchers** - Vitest extensions for ServiceResult assertions
- **Render Utilities** - React Testing Library with providers

---

## 🚀 Installation

This package is used internally across the monorepo. Add it to your `package.json`:

```json
{
  "devDependencies": {
    "@repo/test-utils": "workspace:*"
  }
}
```

---

## 📖 Usage

### Mock Supabase Client

```typescript
import { createMockSupabaseClient } from '@repo/test-utils/mocks/supabase'

describe('VoucherService', () => {
  it('should fetch vouchers from database', async () => {
    const mockClient = createMockSupabaseClient({
      mockData: {
        vouchers: [
          { id: '1', code: 'VCH-TEST1234', status: 'active' },
        ],
      },
    })

    const result = await fetchVouchers(mockClient)
    expect(result).toHaveLength(1)
  })

  it('should handle database errors', async () => {
    const mockClient = createMockSupabaseClient({
      mockErrors: {
        vouchers: new Error('Connection failed'),
      },
    })

    const result = await fetchVouchers(mockClient)
    expect(result).toBeErrorResult()
  })
})
```

### Mock MikroTik API

```typescript
import { createMockMikrotikAPI, createFailingMikrotikAPI } from '@repo/test-utils/mocks/mikrotik'

describe('MikrotikService', () => {
  it('should execute commands successfully', async () => {
    const mockAPI = createMockMikrotikAPI({
      '/system/resource': { uptime: '1w2d', version: '7.14' },
    })

    const result = await mockAPI.execute('/system/resource')
    expect(result.success).toBe(true)
    expect(result.data).toHaveProperty('uptime', '1w2d')
  })

  it('should retry on network failures', async () => {
    const mockAPI = createFailingMikrotikAPI('intermittent')

    const result = await withRetry(() => mockAPI.execute('/system/resource'), {
      maxAttempts: 3,
      delayMs: 100,
    })

    // Second attempt should succeed
    expect(result).toBeDefined()
  })
})
```

### Test Fixtures

```typescript
import { createTestUser, createTestRouter, createTestVouchers } from '@repo/test-utils/fixtures'

describe('Integration Tests', () => {
  it('should generate vouchers for a router', async () => {
    const user = createTestUser({ role: 'admin' })
    const router = createTestRouter({ user_id: user.id })
    const vouchers = createTestVouchers(10, router.id, user.id)

    expect(vouchers).toHaveLength(10)
    expect(vouchers[0].router_id).toBe(router.id)
  })
})
```

### Custom Matchers

```typescript
import { assertSuccess, assertError } from '@repo/test-utils/matchers'

describe('ServiceResult Assertions', () => {
  it('should assert success results', async () => {
    const result = await someService.doWork()

    // Custom matcher
    expect(result).toBeSuccessResult()

    // Type assertion
    assertSuccess(result)
    console.log(result.data) // TypeScript knows this exists
  })

  it('should assert error results', async () => {
    const result = await someService.doWork()

    // Custom matchers
    expect(result).toBeErrorResult()
    expect(result).toHaveErrorCode('VALIDATION_ERROR')
    expect(result).not.toBeRetryable()

    // Type assertion
    assertError(result)
    console.log(result.error.code) // TypeScript knows this exists
  })
})
```

### Render with Providers

```typescript
import { render, screen } from '@repo/test-utils/render'

describe('VoucherCard Component', () => {
  it('should render voucher information', () => {
    const voucher = createTestVoucher()

    render(<VoucherCard voucher={voucher} />)

    expect(screen.getByText(voucher.code)).toBeInTheDocument()
    expect(screen.getByText(voucher.profile_name)).toBeInTheDocument()
  })
})
```

---

## 🔧 API Reference

### Supabase Mocks

#### `createMockSupabaseClient(options)`

Creates a mock Supabase client with configurable behavior.

**Options:**
- `authUser` - Mock authenticated user
- `mockData` - Data to return from queries (keyed by table name)
- `mockErrors` - Errors to return from queries (keyed by table name)

**Returns:** `SupabaseClient`

#### `createFailingSupabaseClient(errorMessage)`

Creates a Supabase client that always returns errors.

**Parameters:**
- `errorMessage` - Error message to return (default: "Database error")

**Returns:** `SupabaseClient`

---

### MikroTik Mocks

#### `createMockMikrotikAPI(responses)`

Creates a mock MikroTik API that returns successful responses.

**Parameters:**
- `responses` - Map of commands to responses

**Returns:** Mock API with `execute()`, `connect()`, `disconnect()`

#### `createFailingMikrotikAPI(failurePattern)`

Creates a mock MikroTik API that simulates failures.

**Parameters:**
- `failurePattern` - `'always'` | `'intermittent'` | `'timeout'`

**Returns:** Mock API that fails according to the pattern

#### `createTrackingMikrotikAPI()`

Creates a mock MikroTik API that tracks all calls.

**Returns:** Mock API with `getCallHistory()` and `clearCallHistory()`

#### `MOCK_CONNECTIONS`

Pre-defined connection objects for testing:
- `MOCK_CONNECTIONS.valid` - Valid connection
- `MOCK_CONNECTIONS.invalid` - Invalid credentials
- `MOCK_CONNECTIONS.slow` - Slow response times

---

### Test Fixtures

#### Factory Functions

- `createTestUser(overrides?)` - Create a test user
- `createTestRouter(overrides?)` - Create a test router
- `createTestVoucher(overrides?)` - Create a test voucher
- `createTestSale(overrides?)` - Create a test sale

#### Bulk Factory Functions

- `createTestUsers(count)` - Create multiple users
- `createTestRouters(count, userId)` - Create multiple routers
- `createTestVouchers(count, routerId, userId)` - Create multiple vouchers
- `createTestSales(count, userId, routerId)` - Create multiple sales

**Example:**
```typescript
const users = createTestUsers(5)
// Returns: [{ id: 'user-0', email: 'user0@example.com', ... }, ...]
```

---

### Custom Matchers

#### `.toBeSuccessResult()`

Asserts that a ServiceResult is successful.

```typescript
expect(result).toBeSuccessResult()
```

#### `.toBeErrorResult()`

Asserts that a ServiceResult is an error.

```typescript
expect(result).toBeErrorResult()
```

#### `.toHaveErrorCode(code)`

Asserts that a ServiceResult error has a specific code.

```typescript
expect(result).toHaveErrorCode('VALIDATION_ERROR')
```

#### `.toBeRetryable()`

Asserts that a ServiceResult error is retryable.

```typescript
expect(result).toBeRetryable()
```

#### Type Assertion Helpers

```typescript
import { assertSuccess, assertError } from '@repo/test-utils/matchers'

// Throws if result is not success
assertSuccess(result)
// TypeScript now knows: result = { success: true, data: T }

// Throws if result is not error
assertError(result)
// TypeScript now knows: result = { success: false, error: ServiceError }
```

---

## 🧪 Testing Patterns

### Pattern 1: Service Layer Tests

```typescript
import { createMockSupabaseClient } from '@repo/test-utils/mocks/supabase'
import { createTestRouter } from '@repo/test-utils/fixtures'
import { assertSuccess } from '@repo/test-utils/matchers'

describe('VoucherService.generateVouchers', () => {
  it('should generate vouchers successfully', async () => {
    const router = createTestRouter()
    const mockClient = createMockSupabaseClient({
      mockData: { vouchers: [] },
    })

    const result = await VoucherService.generateVouchers({
      profileName: '1GB-24H',
      quantity: 10,
      routerId: router.id,
    })

    assertSuccess(result)
    expect(result.data.vouchers).toHaveLength(10)
  })
})
```

### Pattern 2: MikroTik Integration Tests

```typescript
import { createMockMikrotikAPI } from '@repo/test-utils/mocks/mikrotik'

describe('MikrotikService.executeCommand', () => {
  it('should retry on network failure', async () => {
    let attempts = 0
    const mockAPI = createMockMikrotikAPI()
    mockAPI.execute = vi.fn(async () => {
      attempts++
      if (attempts < 3) throw new Error('Network error')
      return { success: true, data: {} }
    })

    const result = await MikrotikService.executeCommand(
      connection,
      '/system/resource',
      { retryAttempts: 3 }
    )

    expect(attempts).toBe(3)
    expect(result).toBeSuccessResult()
  })
})
```

### Pattern 3: Component Tests

```typescript
import { render, screen } from '@repo/test-utils/render'
import { createTestVoucher } from '@repo/test-utils/fixtures'

describe('VoucherCard', () => {
  it('should display voucher code and status', () => {
    const voucher = createTestVoucher({ status: 'active' })

    render(<VoucherCard voucher={voucher} />)

    expect(screen.getByText(voucher.code)).toBeInTheDocument()
    expect(screen.getByText('active')).toBeInTheDocument()
  })
})
```

---

## 📚 Best Practices

### ✅ DO

- Use factory functions for test data (consistent, readable)
- Use custom matchers for ServiceResult assertions
- Mock external dependencies (Supabase, MikroTik)
- Test both success and error paths
- Use `assertSuccess()` / `assertError()` for type safety

### ❌ DON'T

- Create test data manually (use fixtures)
- Test implementation details
- Share mutable state between tests
- Use real API calls in unit tests
- Ignore TypeScript errors in tests

---

## 🔗 Related Documentation

- [TESTING_STRATEGY.md](../../TESTING_STRATEGY.md) - Testing approach
- [CODING_GUIDELINES.md](../../CODING_GUIDELINES.md) - Coding standards
- [@repo/services README](../services/README.md) - Service layer architecture

---

**Last Updated**: 2026-03-22
**Version**: 1.0.0
**Status**: ✅ Production-Ready
