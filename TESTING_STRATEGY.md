# 🧪 Testing Strategy | استراتيجية الاختبار

> **MikroTik Whisperer** - Comprehensive Testing Guide

---

## 🎯 Testing Philosophy | فلسفة الاختبار

### Core Principle | المبدأ الأساسي

> **"Code without tests is legacy code"** - Michael Feathers
>
> الكود بدون اختبارات هو كود قديم

### Testing Goals | أهداف الاختبار

1. **Prevent bugs** - منع الأخطاء قبل Production
2. **Enable refactoring** - السماح بإعادة الهيكلة بأمان
3. **Document behavior** - توثيق سلوك النظام
4. **Build confidence** - بناء الثقة في النظام

---

## 📊 Testing Pyramid | هرم الاختبارات

```
           E2E Tests (Few, Slow)
            /                \
        Integration Tests (Some, Medium)
          /                      \
      Unit Tests (Many, Fast)
```

### Distribution | التوزيع

- **70%** - Unit Tests (Fast, many)
- **20%** - Integration Tests (Medium, some)
- **10%** - E2E Tests (Slow, few)

---

## 🔥 Testing Priority | أولوية الاختبار

### Critical (MUST TEST) | حرج (يجب اختباره)

1. **MikroTik Integration** 🔥
   - Connection handling
   - Retry logic
   - Timeout scenarios
   - Command execution

2. **Authentication Flows**
   - Login/logout
   - Multi-router access
   - Permissions

3. **Service Layer**
   - Business logic
   - Error handling
   - Validation

### High Priority | أولوية عالية

4. **API Endpoints**
5. **Database Operations**
6. **Critical User Journeys**

### Medium Priority | أولوية متوسطة

7. **UI Components**
8. **Utilities**
9. **Edge cases**

---

## 🧩 1. Unit Testing | اختبار الوحدات

### What to Test? | ماذا نختبر؟

- ✅ Pure functions
- ✅ Business logic
- ✅ Utilities
- ✅ Validators
- ✅ Error handling

### Tools | الأدوات

- **Framework**: Vitest
- **Assertions**: expect
- **Mocking**: vi.mock

### Example: Testing a Utility

```typescript
// src/utils/voucher.ts
export function generateVoucherCode(prefix: string, length: number): string {
  const characters = 'ABCDEFGHJKLMNPQRSTUVWXYZ23456789'
  let code = prefix + '-'
  for (let i = 0; i < length; i++) {
    code += characters.charAt(Math.floor(Math.random() * characters.length))
  }
  return code
}

// src/utils/voucher.test.ts
import { describe, it, expect } from 'vitest'
import { generateVoucherCode } from './voucher'

describe('generateVoucherCode', () => {
  it('should generate code with correct prefix', () => {
    const code = generateVoucherCode('VCH', 8)
    expect(code).toMatch(/^VCH-[A-Z0-9]{8}$/)
  })

  it('should generate code with correct length', () => {
    const code = generateVoucherCode('TEST', 12)
    const codeWithoutPrefix = code.replace('TEST-', '')
    expect(codeWithoutPrefix).toHaveLength(12)
  })

  it('should generate unique codes', () => {
    const codes = Array.from({ length: 100 }, () =>
      generateVoucherCode('VCH', 8)
    )
    const uniqueCodes = new Set(codes)
    expect(uniqueCodes.size).toBe(100)
  })

  it('should only use valid characters', () => {
    const code = generateVoucherCode('VCH', 8)
    expect(code).not.toMatch(/[IiOo01]/)  // Ambiguous characters excluded
  })
})
```

---

## 🔗 2. Integration Testing | اختبار التكامل

### What to Test? | ماذا نختبر؟

- ✅ Service layer with database
- ✅ API endpoints
- ✅ External integrations
- ✅ Multi-component interactions

### MikroTik Integration Tests (CRITICAL) 🔥

```typescript
// packages/services/src/mikrotik/service.test.ts
import { describe, it, expect, beforeAll } from 'vitest'
import { MikrotikService } from './service'

describe('MikrotikService Integration', () => {
  const testConnection = {
    host: 'test.mikrotik.local',
    user: 'admin',
    pass: 'test123',
    protocol: 'https' as const,
  }

  describe('Connection Handling', () => {
    it('should successfully connect to router', async () => {
      const result = await MikrotikService.testConnection(testConnection)
      expect(result.success).toBe(true)
    })

    it('should fail with invalid credentials', async () => {
      const result = await MikrotikService.testConnection({
        ...testConnection,
        pass: 'wrong',
      })
      expect(result.success).toBe(false)
      expect(result.error?.code).toBe('MIKROTIK_CONNECTION_FAILED')
    })

    it('should timeout after configured time', async () => {
      const start = Date.now()
      const result = await MikrotikService.executeCommand(
        testConnection,
        '/system/resource',
        { timeoutMs: 1000 }
      )
      const duration = Date.now() - start
      expect(duration).toBeLessThan(1500)  // Should timeout ~1000ms
    })
  })

  describe('Retry Logic', () => {
    it('should retry on network failure', async () => {
      let attempts = 0
      const mockFetch = vi.fn(() => {
        attempts++
        if (attempts < 3) throw new Error('Network error')
        return Promise.resolve({ ok: true })
      })

      const result = await MikrotikService.executeCommand(
        testConnection,
        '/system/resource',
        { retryAttempts: 3 }
      )

      expect(attempts).toBe(3)
      expect(result.success).toBe(true)
    })

    it('should use exponential backoff', async () => {
      const delays: number[] = []
      let lastTime = Date.now()

      const mockFetch = vi.fn(() => {
        const now = Date.now()
        delays.push(now - lastTime)
        lastTime = now
        throw new Error('Always fail')
      })

      await MikrotikService.executeCommand(
        testConnection,
        '/system/resource',
        { retryAttempts: 3 }
      )

      // Delays should increase: ~1s, ~2s, ~4s
      expect(delays[1]).toBeGreaterThan(delays[0])
      expect(delays[2]).toBeGreaterThan(delays[1])
    })
  })

  describe('Command Execution', () => {
    it('should execute valid command', async () => {
      const result = await MikrotikService.executeCommand(
        testConnection,
        '/system/resource/print'
      )
      expect(result.success).toBe(true)
      expect(result.data).toHaveProperty('cpu-load')
    })

    it('should handle batch commands', async () => {
      const commands = [
        '/system/resource/print',
        '/interface/print',
        '/ip/address/print',
      ]
      const result = await MikrotikService.executeBatch(testConnection, commands)
      expect(result.success).toBe(true)
      expect(result.data).toHaveLength(3)
    })
  })
})
```

---

## 🎭 3. Mocking Strategies | استراتيجيات المحاكاة

### Mock External Dependencies | محاكاة الاعتماديات الخارجية

```typescript
// Test utilities package
// packages/test-utils/src/mocks/supabase.ts
export function createMockSupabaseClient() {
  return {
    from: vi.fn((table: string) => ({
      select: vi.fn().mockReturnThis(),
      insert: vi.fn().mockResolvedValue({ data: [], error: null }),
      update: vi.fn().mockResolvedValue({ data: [], error: null }),
      delete: vi.fn().mockResolvedValue({ data: [], error: null }),
    })),
    auth: {
      getUser: vi.fn().mockResolvedValue({
        data: { user: { id: 'test-user-id' } },
        error: null,
      }),
    },
  }
}

// Usage in tests
import { createMockSupabaseClient } from '@repo/test-utils/mocks/supabase'

it('should create user', async () => {
  const supabase = createMockSupabaseClient()
  const result = await userService.create({ email: 'test@example.com' })
  expect(supabase.from).toHaveBeenCalledWith('users')
})
```

### Mock MikroTik API

```typescript
// packages/test-utils/src/mocks/mikrotik.ts
export function createMockMikrotikAPI() {
  return {
    execute: vi.fn().mockResolvedValue({
      success: true,
      data: {
        'cpu-load': '5%',
        'free-memory': '100MB',
      },
    }),
    testConnection: vi.fn().mockResolvedValue({ success: true }),
  }
}
```

---

## 🌐 4. E2E Testing | اختبار شامل

### Tools | الأدوات

- **Framework**: Playwright
- **Coverage**: Critical user journeys only

### Critical Journeys | الرحلات الحرجة

1. **User Registration & Login**
2. **Dashboard → View Router Stats**
3. **Hotspot → Create User**
4. **Vouchers → Generate Batch**
5. **Sales → View Reports**

### Example E2E Test

```typescript
// e2e/voucher-generation.spec.ts
import { test, expect } from '@playwright/test'

test.describe('Voucher Generation Journey', () => {
  test.beforeEach(async ({ page }) => {
    // Login
    await page.goto('/auth')
    await page.fill('[name="email"]', 'test@example.com')
    await page.fill('[name="password"]', 'password123')
    await page.click('button[type="submit"]')
    await page.waitForURL('/dashboard')
  })

  test('should generate vouchers successfully', async ({ page }) => {
    // Navigate to vouchers page
    await page.click('text=Vouchers')
    await page.waitForURL('/vouchers')

    // Open generation modal
    await page.click('button:has-text("Generate")')

    // Fill form
    await page.fill('[name="quantity"]', '10')
    await page.fill('[name="profileName"]', '1GB-24H')
    await page.fill('[name="prefix"]', 'TEST')

    // Submit
    await page.click('button:has-text("Generate Vouchers")')

    // Wait for success
    await expect(page.locator('text=Successfully generated 10 vouchers')).toBeVisible()

    // Verify vouchers in table
    const rows = page.locator('table tbody tr')
    await expect(rows).toHaveCount(10)

    // Verify voucher format
    const firstCode = await rows.first().locator('td:first-child').textContent()
    expect(firstCode).toMatch(/^TEST-[A-Z0-9]{8}$/)
  })

  test('should handle validation errors', async ({ page }) => {
    await page.click('text=Vouchers')
    await page.click('button:has-text("Generate")')

    // Submit without filling
    await page.click('button:has-text("Generate Vouchers")')

    // Should show validation errors
    await expect(page.locator('text=Quantity is required')).toBeVisible()
    await expect(page.locator('text=Profile is required')).toBeVisible()
  })
})
```

---

## 📏 5. Coverage Requirements | متطلبات التغطية

### Minimum Coverage | الحد الأدنى للتغطية

- **Services**: **> 80%** 🔥
- **Utilities**: **> 90%**
- **Components**: **> 60%**
- **Overall**: **> 75%**

### Coverage Report

```bash
# Run with coverage
pnpm turbo test -- --coverage

# View report
open coverage/index.html
```

---

## 🎯 6. Test Organization | تنظيم الاختبارات

### File Structure | هيكل الملفات

```
src/
├── services/
│   ├── userService.ts
│   └── userService.test.ts      # ✅ Co-located
├── utils/
│   ├── validation.ts
│   └── validation.test.ts       # ✅ Co-located
└── __tests__/
    ├── integration/
    │   └── user-flow.test.ts
    └── e2e/
        └── voucher-journey.spec.ts
```

### Naming Conventions | اصطلاحات التسمية

- Unit: `*.test.ts` or `*.spec.ts`
- Integration: `*.integration.test.ts`
- E2E: `*.spec.ts` (Playwright)

---

## ✅ 7. Test Best Practices | أفضل الممارسات

### AAA Pattern: Arrange, Act, Assert

```typescript
test('should create user with valid data', async () => {
  // Arrange (Setup)
  const userData = {
    email: 'test@example.com',
    password: 'secure123',
  }

  // Act (Execute)
  const result = await userService.create(userData)

  // Assert (Verify)
  expect(result.success).toBe(true)
  expect(result.data.email).toBe(userData.email)
})
```

### One Assertion Per Test (When Possible)

```typescript
// ✅ GOOD: Focused test
test('should return user email', () => {
  expect(user.email).toBe('test@example.com')
})

// ⚠️ OK: Related assertions
test('should validate user data', () => {
  expect(user.email).toBeDefined()
  expect(user.email).toContain('@')
  expect(user.id).toMatch(/^[0-9a-f-]+$/)
})
```

### Test Names Should Be Descriptive

```typescript
// ❌ BAD: Vague
test('user test', () => {})

// ✅ GOOD: Specific
test('should create user with valid email and password', () => {})
test('should reject user creation with invalid email', () => {})
test('should hash password before storing', () => {})
```

---

## 🔄 8. Testing Async Code | اختبار الكود غير المتزامن

### Always Use async/await

```typescript
// ❌ BAD: Callback hell
test('should fetch data', (done) => {
  fetchData().then(result => {
    expect(result).toBeDefined()
    done()
  })
})

// ✅ GOOD: async/await
test('should fetch data', async () => {
  const result = await fetchData()
  expect(result).toBeDefined()
})
```

### Test Both Success and Failure

```typescript
describe('fetchUserData', () => {
  it('should return user on success', async () => {
    const result = await fetchUserData('valid-id')
    expect(result.success).toBe(true)
  })

  it('should return error on network failure', async () => {
    mockFetch.mockRejectedValue(new Error('Network error'))
    const result = await fetchUserData('valid-id')
    expect(result.success).toBe(false)
    expect(result.error.retryable).toBe(true)
  })
})
```

---

## 🚀 9. CI/CD Integration | التكامل مع CI/CD

### GitHub Actions Workflow

```yaml
# .github/workflows/ci.yml
name: CI
on: [pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: pnpm/action-setup@v2
        with:
          version: 10.12.1

      - name: Install dependencies
        run: pnpm install --frozen-lockfile

      - name: Run tests
        run: pnpm turbo test --coverage

      - name: Upload coverage
        uses: codecov/codecov-action@v3
        with:
          files: ./coverage/coverage-final.json
```

---

## 🎓 10. Testing Checklist | قائمة التحقق

Before merging PR:

- [ ] All tests pass locally
- [ ] New features have tests
- [ ] Coverage meets requirements (>80% services)
- [ ] No skipped tests without reason
- [ ] No console.log in tests
- [ ] Test names are descriptive
- [ ] Mock external dependencies
- [ ] Handle async properly
- [ ] Test both success and failure paths
- [ ] E2E tests for critical journeys

---

## 📚 Resources | المصادر

- [Vitest Documentation](https://vitest.dev/)
- [Playwright Documentation](https://playwright.dev/)
- [Testing Best Practices](https://testingjavascript.com/)
- [Kent C. Dodds - Testing Trophy](https://kentcdodds.com/blog/the-testing-trophy-and-testing-classifications)

---

**Last Updated**: 2026-03-22
**Version**: 1.0
**Status**: ✅ Active
