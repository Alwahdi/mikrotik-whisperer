# 🤖 Coding Guidelines for AI Agents | دليل البرمجة للوكلاء الذكيين

> **MikroTik Whisperer** - Engineering Excellence Standards

This document contains **mandatory guidelines** for all code contributions, especially for AI coding agents. These are **not suggestions** - they are **requirements**.

---

## 🎯 Core Philosophy | الفلسفة الأساسية

### Write Code For Humans, Not Machines

```typescript
// ❌ BAD: Machine-readable
const x = (a, b) => a > 3 && b

// ✅ GOOD: Human-readable
const MIN_PASSWORD_LENGTH = 3
const isPasswordValid = (password, confirmPassword) =>
  password.length > MIN_PASSWORD_LENGTH && password === confirmPassword
```

### The Golden Rule | القاعدة الذهبية

> **"Write code as if the next person to maintain it is a violent psychopath who knows where you live"** 😅
>
> اكتب الكود كأن الشخص اللي بعدك شخص عصبي ويعرف فين تسكن

---

## 📏 1. Function Size & Modularity | حجم الدوال والتقسيم

### Rule: One Function = One Responsibility

```typescript
// ❌ BAD: God function doing everything
async function createUserAndSendEmailAndLogAndNotify() {
  const user = await db.createUser()
  await sendEmail(user)
  await logger.log(user)
  await notifySlack(user)
  return user
}

// ✅ GOOD: Each function does one thing
async function createUser(data) {
  return await db.createUser(data)
}

async function sendWelcomeEmail(user) {
  return await emailService.send(user.email, 'welcome')
}

async function logUserCreation(user) {
  return await logger.info('User created', { userId: user.id })
}
```

### Maximum Lines Per Function | الحد الأقصى للأسطر

- **Maximum**: 50 lines (including comments)
- **Ideal**: 10-20 lines
- **If more**: Split into smaller functions

```typescript
// ⚠️ WARNING: If you need to scroll → function is too long
```

---

## 🏗️ 2. Single Responsibility Principle (SRP)

### Each Module Has ONE Job

```typescript
// ❌ BAD: userService.ts doing auth, emails, logging
export const userService = {
  create() {},
  sendEmail() {},      // ❌ Not user service responsibility
  logActivity() {},    // ❌ Not user service responsibility
  authenticate() {},   // ❌ Not user service responsibility
}

// ✅ GOOD: Separate services
export const userService = {
  create() {},
  update() {},
  delete() {},
}

export const emailService = {
  sendWelcome() {},
  sendReset() {},
}

export const authService = {
  authenticate() {},
  authorize() {},
}
```

---

## 📛 3. Naming Conventions | اصطلاحات التسمية

### Rule: Names Must Be Self-Documenting

```typescript
// ❌ BAD: Cryptic names
const d = new Date()
const u = fetchUser()
const x = data.map(i => i.v)

// ✅ GOOD: Self-explanatory
const currentDate = new Date()
const authenticatedUser = fetchUser()
const voucherCodes = vouchers.map(voucher => voucher.code)
```

### Naming Patterns | أنماط التسمية

```typescript
// Boolean: is*, has*, can*, should*
const isValid = true
const hasPermission = false
const canEdit = true
const shouldRetry = false

// Functions: verb + noun
function getUserProfile() {}
function createVoucher() {}
function deleteRouter() {}

// Arrays: plural nouns
const users = []
const vouchers = []
const routers = []

// Constants: UPPER_SNAKE_CASE
const MAX_RETRIES = 3
const API_TIMEOUT_MS = 5000
const DEFAULT_PAGE_SIZE = 20
```

### Arabic Naming Support | دعم التسمية بالعربية

```typescript
// ✅ OK: Arabic in comments
const vouchers = [] // الكوبونات

// ✅ OK: Arabic in UI strings
const title = "لوحة التحكم"

// ❌ AVOID: Arabic in code identifiers
const الكوبونات = [] // ❌ Use English in code
```

---

## 🧼 4. DRY vs WET | لا تكرر نفسك

### DRY: Don't Repeat Yourself

```typescript
// ❌ BAD: Repetition (WET = Write Everything Twice)
function validateEmail(email: string) {
  return email.includes('@') && email.length > 5
}

function validateUserEmail(email: string) {
  return email.includes('@') && email.length > 5  // ❌ Duplicate!
}

// ✅ GOOD: Single source of truth
const EMAIL_REGEX = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

function isValidEmail(email: string): boolean {
  return EMAIL_REGEX.test(email)
}

// Reuse everywhere
validateEmail(user.email)
validateEmail(signup.email)
```

### When NOT to DRY? | متى نكرر؟

```typescript
// ✅ OK: Accidental duplication (different concerns)
function formatUserDate(date) {
  return date.toLocaleDateString('ar-SA')
}

function formatInvoiceDate(date) {
  return date.toLocaleDateString('ar-SA')  // Same now, might diverge
}
```

---

## 🎨 5. KISS: Keep It Simple, Stupid

### Simple > Clever

```typescript
// ❌ BAD: Too clever
const result = arr.reduce((acc, val) =>
  [...acc, ...(val > 0 ? [val * 2] : [])], [])

// ✅ GOOD: Simple and clear
const result = arr
  .filter(val => val > 0)
  .map(val => val * 2)
```

---

## 🔗 6. Loose Coupling | تقليل الترابط

### Dependencies Should Be Injected

```typescript
// ❌ BAD: Tight coupling
class UserService {
  constructor() {
    this.db = new PostgresDB()  // ❌ Hard-coded dependency
  }
}

// ✅ GOOD: Dependency injection
class UserService {
  constructor(private db: DatabaseInterface) {}
}

const userService = new UserService(new PostgresDB())
```

---

## 🛡️ 7. Defensive Programming | البرمجة الدفاعية

### Never Trust Input

```typescript
// ❌ BAD: Trusting input
function getUser(id) {
  return db.users.find(id)  // What if id is null?
}

// ✅ GOOD: Validate everything
function getUser(id: string): ServiceResult<User> {
  if (!id || typeof id !== 'string') {
    return error('INVALID_ID', 'User ID must be a non-empty string')
  }

  const user = db.users.find(id)
  if (!user) {
    return error('USER_NOT_FOUND', 'User does not exist')
  }

  return success(user)
}
```

### Handle ALL Cases | تعامل مع كل الحالات

```typescript
// ❌ BAD: Assuming happy path
async function fetchData() {
  const response = await fetch(url)
  return response.json()  // What if fetch fails?
}

// ✅ GOOD: Handle edge cases
async function fetchData(): Promise<ServiceResult<Data>> {
  try {
    const response = await fetch(url)

    if (!response.ok) {
      return error('FETCH_FAILED', `HTTP ${response.status}`)
    }

    const data = await response.json()
    return success(data)
  } catch (err) {
    return error('NETWORK_ERROR', 'Failed to fetch data', err, true)
  }
}
```

---

## 🧠 8. Think About Edge Cases | فكر في الحالات الحدّية

### Always Ask "What If...?" | دائماً اسأل "ماذا لو...؟"

```typescript
// What if array is empty?
const first = arr[0]  // ❌ undefined!

// What if user is null?
const name = user.name  // ❌ Cannot read property!

// What if API fails?
const data = await fetch()  // ❌ Exception!

// ✅ GOOD: Handle edge cases
const first = arr.length > 0 ? arr[0] : null
const name = user?.name ?? 'Anonymous'
const result = await safeFetch()
if (!result.success) {
  handleError(result.error)
}
```

---

## 📦 9. Configuration Management | إدارة الإعدادات

### NO Magic Numbers/Strings | لا للأرقام السحرية

```typescript
// ❌ BAD: Magic values
if (user.age > 18) {}
setTimeout(() => {}, 5000)
if (status === 'active') {}

// ✅ GOOD: Named constants
const MIN_LEGAL_AGE = 18
const API_TIMEOUT_MS = 5000
const USER_STATUS_ACTIVE = 'active' as const

if (user.age > MIN_LEGAL_AGE) {}
setTimeout(() => {}, API_TIMEOUT_MS)
if (status === USER_STATUS_ACTIVE) {}
```

### Use Environment Variables

```typescript
// ❌ BAD: Hardcoded values
const API_URL = 'https://api.example.com'

// ✅ GOOD: From @repo/env
import { env } from '@repo/env'
const API_URL = env.NEXT_PUBLIC_API_URL
```

---

## 🔄 10. Error Handling | معالجة الأخطاء

### Use ServiceResult Pattern (MANDATORY) | نمط إلزامي

```typescript
// ❌ BAD: Throwing exceptions
async function getUser(id: string): Promise<User> {
  const user = await db.find(id)
  if (!user) throw new Error('Not found')  // ❌ Exception!
  return user
}

// ✅ GOOD: Explicit error handling
async function getUser(id: string): Promise<ServiceResult<User>> {
  const user = await db.find(id)
  if (!user) {
    return { success: false, error: {
      code: 'USER_NOT_FOUND',
      message: 'User does not exist',
      retryable: false
    }}
  }
  return { success: true, data: user }
}

// Usage
const result = await getUser('123')
if (result.success) {
  console.log(result.data)  // TypeScript knows data exists
} else {
  console.error(result.error.code)  // TypeScript knows error exists
}
```

---

## 🧪 11. Testing Requirements | متطلبات الاختبار

### Write Tests FIRST (TDD) | اكتب الاختبارات أولاً

```typescript
// 1. Write test first
test('should validate email correctly', () => {
  expect(isValidEmail('test@example.com')).toBe(true)
  expect(isValidEmail('invalid')).toBe(false)
})

// 2. Then implement
function isValidEmail(email: string): boolean {
  return EMAIL_REGEX.test(email)
}
```

### Test Coverage Requirements | متطلبات التغطية

- **Services**: **> 80%** coverage (MANDATORY)
- **Utilities**: **> 90%** coverage
- **Components**: **> 60%** coverage
- **Integration**: Critical paths only

---

## 🔐 12. Security Practices | الممارسات الأمنية

### Input Validation (MANDATORY) | التحقق من المدخلات

```typescript
// ❌ BAD: No validation
function createUser(data: any) {
  return db.insert(data)  // SQL Injection risk!
}

// ✅ GOOD: Zod validation
import { z } from 'zod'

const userSchema = z.object({
  email: z.string().email(),
  age: z.number().min(18).max(120),
})

function createUser(data: unknown) {
  const validated = userSchema.parse(data)  // Throws if invalid
  return db.insert(validated)
}
```

### Never Log Secrets | لا تسجل الأسرار

```typescript
// ❌ BAD: Logging sensitive data
logger.info('User login', { email, password })  // ❌ Password!

// ✅ GOOD: Redact sensitive fields
logger.info('User login', { email, password: '[REDACTED]' })
```

---

## 📝 13. Comments & Documentation | التعليقات والتوثيق

### Code Should Be Self-Documenting | الكود يشرح نفسه

```typescript
// ❌ BAD: Commenting obvious things
// Increment i
i++

// ✅ GOOD: Explain WHY, not WHAT
// Retry with exponential backoff to handle temporary network issues
await withRetry(fn, { backoffMultiplier: 2 })
```

### When to Comment? | متى نضع تعليقات؟

```typescript
// ✅ Explain complex algorithms
// Fisher-Yates shuffle for unbiased randomization
function shuffle(array) { /* ... */ }

// ✅ Explain business rules
// GDPR requires 30-day retention period
const RETENTION_DAYS = 30

// ✅ Explain workarounds
// TODO: Remove after React 19 stable release
// Workaround for hydration mismatch in dev mode
```

### JSDoc for Public APIs | JSDoc للواجهات العامة

```typescript
/**
 * Generates random voucher codes
 * @param quantity - Number of vouchers to generate
 * @param prefix - Prefix for voucher codes (default: 'VCH')
 * @returns Array of unique voucher codes
 * @example
 * ```ts
 * const codes = generateVouchers(10, 'SALE')
 * // ['SALE-A1B2C3', 'SALE-D4E5F6', ...]
 * ```
 */
export function generateVouchers(
  quantity: number,
  prefix = 'VCH'
): string[] {
  // Implementation
}
```

---

## ⚡ 14. Performance Considerations | اعتبارات الأداء

### Avoid Premature Optimization | لا تحسّن مبكراً

```typescript
// ❌ BAD: Optimizing before measuring
const cached = useMemo(() => expensiveCalc(), [])  // Is it really expensive?

// ✅ GOOD: Measure first, then optimize
// Profile shows this is 90% of render time
const cached = useMemo(() => complexCalculation(), [deps])
```

### But DO Consider Big O | لكن فكر في Big O

```typescript
// ❌ BAD: O(n²) when O(n) exists
const duplicates = arr.filter(item =>
  arr.indexOf(item) !== arr.lastIndexOf(item)
)

// ✅ GOOD: O(n) with Set
const seen = new Set()
const duplicates = arr.filter(item => {
  if (seen.has(item)) return true
  seen.add(item)
  return false
})
```

---

## 🔄 15. Async/Await Best Practices

### Always Handle Errors | دائماً تعامل مع الأخطاء

```typescript
// ❌ BAD: Unhandled promise rejection
async function fetchData() {
  const data = await fetch(url)  // What if this fails?
  return data
}

// ✅ GOOD: Wrapped in try/catch
async function fetchData(): Promise<ServiceResult<Data>> {
  try {
    const data = await fetch(url)
    return success(data)
  } catch (err) {
    return error('FETCH_FAILED', 'Failed to fetch', err, true)
  }
}
```

### Parallel When Possible | التوازي عند الإمكان

```typescript
// ❌ BAD: Sequential (slow)
const user = await fetchUser()
const posts = await fetchPosts()
const comments = await fetchComments()

// ✅ GOOD: Parallel (fast)
const [user, posts, comments] = await Promise.all([
  fetchUser(),
  fetchPosts(),
  fetchComments(),
])
```

---

## 🎯 16. TypeScript Guidelines | إرشادات TypeScript

### Use Strict Mode | استخدم الوضع الصارم

```json
// tsconfig.json
{
  "compilerOptions": {
    "strict": true,
    "noImplicitAny": true,
    "strictNullChecks": true
  }
}
```

### Avoid `any` | تجنب any

```typescript
// ❌ BAD: Disabling type safety
function process(data: any) {}

// ✅ GOOD: Proper types
function process(data: User | null) {}

// ✅ GOOD: Unknown for truly unknown data
function process(data: unknown) {
  if (isUser(data)) {
    // Type narrowing
  }
}
```

---

## 🏷️ 17. Import Organization | تنظيم الاستيرادات

### Order: External → Internal → Relative

```typescript
// 1. External packages
import React from 'react'
import { z } from 'zod'

// 2. Internal packages (@repo/*)
import { env } from '@repo/env'
import { MikrotikService } from '@repo/services/mikrotik'

// 3. Relative imports
import { Button } from './Button'
import { utils } from '../utils'

// 4. Types (last)
import type { User } from './types'
```

---

## 🚫 18. Forbidden Patterns | أنماط ممنوعة

### NEVER Do These | لا تفعل هذا أبداً

```typescript
// ❌ console.log in production
console.log('Debug info')  // Use logger instead

// ❌ Ignoring errors
try { } catch (e) {}  // Must handle!

// ❌ Any type
function process(data: any) {}

// ❌ Mutating props
function Component({ data }) {
  data.x = 1  // ❌ Props are immutable
}

// ❌ Committing secrets
const API_KEY = 'sk_live_abc123'  // ❌ Use env vars

// ❌ Disabling linter without reason
// eslint-disable-next-line  // ❌ Why?

// ❌ Using var
var x = 1  // ❌ Use const/let
```

---

## ✅ 19. Pre-Commit Checklist | قائمة ما قبل الالتزام

Before committing, ensure:

- [ ] **Code compiles** - `pnpm turbo build`
- [ ] **Tests pass** - `pnpm turbo test`
- [ ] **Linter passes** - `pnpm turbo lint`
- [ ] **Types check** - `pnpm turbo type-check`
- [ ] **No console.log** - Remove debug logs
- [ ] **No commented code** - Remove or explain
- [ ] **Functions < 50 lines** - Split if needed
- [ ] **Tests written** - For new features
- [ ] **Error handling** - ServiceResult pattern
- [ ] **Input validation** - Zod schemas

---

## 🤖 20. AI Agent Specific Guidelines

### When Writing Code As AI Agent

1. **Read first** - Always read existing code patterns
2. **Match style** - Follow existing conventions
3. **Small changes** - Incremental, not massive refactors
4. **Test immediately** - Run tests after each change
5. **Ask if unsure** - Better to ask than break things

### Example Workflow

```bash
# 1. Read related files
cat src/services/userService.ts

# 2. Make small change
# ... edit file ...

# 3. Test immediately
pnpm turbo test --filter=@repo/services

# 4. If passes, proceed. If fails, fix immediately
```

---

## 📚 References | المراجع

- [ARCHITECTURE.md](./ARCHITECTURE.md) - System architecture
- [TESTING_STRATEGY.md](./TESTING_STRATEGY.md) - Testing guidelines
- [CONTRIBUTING.md](./CONTRIBUTING.md) - Contribution process
- [packages/services/README.md](./packages/services/README.md) - Service layer patterns

---

## 🎓 Learning Resources | مصادر التعلم

- **Clean Code** by Robert C. Martin
- **The Pragmatic Programmer** by Hunt & Thomas
- **SOLID Principles** - OOP best practices
- **TypeScript Best Practices** - Official docs

---

**Last Updated**: 2026-03-22
**Version**: 1.0
**Compliance**: ✅ MANDATORY for all contributions

---

## ⚠️ Final Warning | تحذير نهائي

> These guidelines are **not optional**. Pull requests that violate these guidelines will be **rejected**.
>
> هذه الإرشادات **ليست اختيارية**. الطلبات التي تخالف هذه الإرشادات سيتم **رفضها**.

**Quality > Speed** | **الجودة > السرعة**
