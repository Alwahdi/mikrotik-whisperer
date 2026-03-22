# 🏗️ Architecture Documentation | التوثيق المعماري

> **MikroTik Whisperer** - Enterprise-grade MikroTik Management Platform

---

## 📐 System Overview | نظرة عامة

MikroTik Whisperer is built as a **scalable, maintainable, and testable** system following modern software engineering principles.

### Core Principles | المبادئ الأساسية

1. **Separation of Concerns** - فصل المسؤوليات
2. **Modular Design** - تصميم معياري
3. **Type Safety** - الأمان النوعي
4. **Scalability** - قابلية التوسع
5. **Observability** - قابلية المراقبة

---

## 🎯 Architecture Layers | الطبقات المعمارية

```
┌─────────────────────────────────────────────────┐
│          UI Layer (Presentation)                │
│  - Next.js App Router (Web)                     │
│  - Expo (Mobile)                                │
│  - React Components + shadcn/ui                 │
└────────────────┬────────────────────────────────┘
                 │
┌────────────────▼────────────────────────────────┐
│         API Layer (Interface)                   │
│  - Supabase Edge Functions                      │
│  - Next.js API Routes                           │
│  - Type-safe with Zod validation                │
└────────────────┬────────────────────────────────┘
                 │
┌────────────────▼────────────────────────────────┐
│      Business Logic Layer (@repo/services)      │
│  - MikrotikService (router operations)          │
│  - VoucherService (voucher management)          │
│  - SalesService (revenue tracking)              │
│  - Retry + Timeout + Error handling             │
└────────────────┬────────────────────────────────┘
                 │
┌────────────────▼────────────────────────────────┐
│      Integration Layer (External Systems)       │
│  - MikroTik RouterOS API (@repo/mikrotik)       │
│  - Supabase (Auth + Database)                   │
│  - External services                            │
└─────────────────────────────────────────────────┘
```

---

## 📦 Monorepo Structure | هيكل المشروع

```
mikrotik-whisperer/
├── apps/
│   ├── app/              # Main Next.js app (port 3000)
│   ├── web/              # Marketing site (port 3001)
│   ├── agent/            # MikroTik local agent (Express)
│   └── mobile/           # Expo mobile app
│
├── packages/
│   ├── env/              # Type-safe env validation (Zod)
│   ├── services/         # Business logic layer ⭐
│   ├── auth/             # Authentication utilities
│   ├── database/         # Supabase types & utilities
│   ├── design-system/    # Shared UI components
│   ├── mikrotik/         # MikroTik API client
│   ├── eslint-config/    # Shared ESLint config
│   ├── prettier-config/  # Shared Prettier config
│   └── typescript-config/# Shared TypeScript config
│
└── docs/                 # Architecture & guides
```

### Why Turborepo? | لماذا Turborepo؟

- ✅ **Shared packages** - إعادة استخدام الكود
- ✅ **Fast builds** - بناء سريع مع caching
- ✅ **Task orchestration** - تنظيم المهام
- ✅ **Type safety** - أمان نوعي عبر المشروع

---

## 🔄 Data Flow | تدفق البيانات

### Example: Generate Vouchers | مثال: توليد الكوبونات

```typescript
// 1. UI Layer (React Component)
const handleGenerate = async () => {
  const result = await generateVouchers(params)
  if (result.success) {
    showSuccess(result.data)
  } else {
    showError(result.error)
  }
}

// 2. API Layer (Edge Function)
export async function POST(request: Request) {
  const params = await request.json()

  // Validate with Zod
  const validated = voucherSchema.parse(params)

  // Call service layer
  const result = await VoucherService.generateVouchers(validated)

  return Response.json(result)
}

// 3. Business Logic (@repo/services)
export class VoucherService {
  static async generateVouchers(params) {
    // Validate inputs
    const validated = voucherGenerationSchema.parse(params)

    // Generate voucher codes
    const vouchers = this.generateVoucherCodes(...)

    // Save to database
    await supabase.from('vouchers').insert(vouchers)

    // Return result
    return success({ vouchers, jobId })
  }
}

// 4. Integration Layer (@repo/database)
// Supabase client handles database operations
```

---

## 🎨 Service Layer Pattern | نمط طبقة الخدمات

### Why Service Layer? | لماذا طبقة الخدمات؟

**❌ Without Service Layer:**
```typescript
// API handler has everything (BAD)
export async function POST(req) {
  // Business logic mixed with API handling
  // Hard to test
  // Hard to reuse
  // Hard to maintain
}
```

**✅ With Service Layer:**
```typescript
// API handler is thin (GOOD)
export async function POST(req) {
  const params = await req.json()
  return VoucherService.generateVouchers(params)
}

// Business logic is separate, testable, reusable
class VoucherService {
  static async generateVouchers(params) {
    // All logic here
  }
}
```

### Benefits | الفوائد

1. **Testability** - سهولة الاختبار
2. **Reusability** - إعادة الاستخدام
3. **Maintainability** - سهولة الصيانة
4. **Scalability** - قابلية التوسع

---

## 🔐 Type Safety Strategy | استراتيجية الأمان النوعي

### 1. Environment Variables

```typescript
// ❌ BAD: No validation
const url = process.env.NEXT_PUBLIC_SUPABASE_URL

// ✅ GOOD: Zod validation at build time
import { env } from '@repo/env'
const url = env.NEXT_PUBLIC_SUPABASE_URL // Type-safe!
```

### 2. API Responses

```typescript
// ❌ BAD: Throwing exceptions
async function getData() {
  const data = await fetch(...)
  if (!data.ok) throw new Error('Failed') // Exception!
}

// ✅ GOOD: Discriminated unions
async function getData(): ServiceResult<Data> {
  const data = await fetch(...)
  if (!data.ok) {
    return { success: false, error: { code: 'FETCH_FAILED', message: '...' } }
  }
  return { success: true, data }
}
```

### 3. Database Types

```typescript
// ✅ Generated from Supabase schema
import { Database } from '@repo/database/types'

type Voucher = Database['public']['Tables']['vouchers']['Row']
```

---

## ⚡ Performance Strategy | استراتيجية الأداء

### 1. Caching | التخزين المؤقت

- **Turborepo cache** - Build artifacts
- **Next.js cache** - Pages & data
- **React Query cache** - API responses

### 2. Code Splitting | تقسيم الكود

```typescript
// ✅ Dynamic imports for large components
const Dashboard = dynamic(() => import('./Dashboard'))
```

### 3. Bundle Size Targets | أهداف حجم الحزمة

- Initial JS: **< 200KB**
- First Contentful Paint: **< 1.5s**
- Time to Interactive: **< 3s**

---

## 🔄 Error Handling Strategy | استراتيجية معالجة الأخطاء

### ServiceResult Pattern

```typescript
type ServiceResult<T> =
  | { success: true; data: T }
  | { success: false; error: ServiceError }
```

### Error Categories | أنواع الأخطاء

1. **Validation Errors** - أخطاء التحقق
   - User input issues
   - Schema violations
   - Not retryable

2. **Network Errors** - أخطاء الشبكة
   - Connection failures
   - Timeouts
   - **Retryable** ✅

3. **Business Logic Errors** - أخطاء منطق العمل
   - Insufficient permissions
   - Resource not found
   - Not retryable

4. **System Errors** - أخطاء النظام
   - Database failures
   - Service unavailable
   - **Retryable** ✅

---

## 🔁 Retry & Timeout Strategy | استراتيجية إعادة المحاولة

### Exponential Backoff

```typescript
await withRetry(
  async () => MikrotikAPI.execute(command),
  {
    maxAttempts: 3,
    delayMs: 1000,
    backoffMultiplier: 2  // 1s, 2s, 4s
  }
)
```

### When to Retry? | متى نعيد المحاولة؟

- ✅ Network timeouts
- ✅ Temporary service unavailable (503)
- ✅ Rate limiting (429)
- ❌ Validation errors (400)
- ❌ Authentication errors (401)
- ❌ Authorization errors (403)

---

## 🧪 Testing Strategy | استراتيجية الاختبار

### Testing Pyramid | هرم الاختبارات

```
         E2E Tests (Few)
           /        \
      Integration Tests (Some)
         /              \
    Unit Tests (Many)
```

### Priority Order | ترتيب الأولوية

1. **MikroTik Integration Tests** (CRITICAL) 🔥
2. **Auth Flow Tests** (HIGH)
3. **Service Layer Tests** (MEDIUM)
4. **E2E Journey Tests** (MEDIUM)
5. **UI Component Tests** (LOW)

See [TESTING_STRATEGY.md](./TESTING_STRATEGY.md) for details.

---

## 📊 Observability | القابلية للمراقبة

### Logging Levels

- `ERROR` - Production issues
- `WARN` - Potential problems
- `INFO` - Important events
- `DEBUG` - Development only

### What to Log? | ماذا نسجل؟

- ✅ Service errors with context
- ✅ Performance metrics
- ✅ User actions (audit trail)
- ❌ Sensitive data (passwords, tokens)
- ❌ PII without consent

See [OBSERVABILITY.md](./OBSERVABILITY.md) for details.

---

## 🔒 Security Architecture | الهندسة الأمنية

### Authentication Flow

```
User → Supabase Auth → JWT Token → Protected Routes
```

### Authorization Levels

1. **Public** - Landing pages
2. **Authenticated** - Dashboard access
3. **Router Owner** - Manage own routers
4. **Admin** - System administration

### Security Practices

- ✅ JWT-based authentication
- ✅ Row Level Security (RLS) in Supabase
- ✅ Input validation (Zod)
- ✅ No secrets in code (env vars)
- ✅ HTTPS only
- ✅ CORS configuration

---

## 🚀 Scalability Considerations | اعتبارات قابلية التوسع

### Current Scale | الحجم الحالي

- **Users**: 1-1000
- **Routers**: 1-100 per user
- **Requests**: < 10 req/sec

### Future Scale | الحجم المستقبلي

- **Users**: 10,000+
- **Routers**: 10,000+
- **Requests**: 1000+ req/sec

### Scalability Plan | خطة التوسع

1. **Database**
   - Connection pooling ✅
   - Read replicas (future)
   - Sharding by user_id (future)

2. **API Layer**
   - Edge Functions (Vercel) ✅
   - Rate limiting (future)
   - Caching (Redis) (future)

3. **MikroTik Operations**
   - Queue system for bulk operations ✅
   - Circuit breaker for failing routers (future)
   - Connection pooling per router (future)

---

## 🔄 Deployment Strategy | استراتيجية النشر

### Environments | البيئات

1. **Development** - Local dev servers
2. **Preview** - Vercel preview deployments (per PR)
3. **Production** - Vercel production

### CI/CD Pipeline | خط الأنابيب

```
PR → Lint → Type-check → Build → Test → Lighthouse → Preview Deploy
                                               ↓
                                           Merge to main
                                               ↓
                                       Production Deploy
```

### Zero-Downtime Deployment

- ✅ Rolling deployments (Vercel)
- ✅ Health checks
- ✅ Automatic rollback on errors

---

## 📝 Architecture Decisions | القرارات المعمارية

### Why Next.js? | لماذا Next.js؟

- ✅ App Router (RSC)
- ✅ Edge Functions
- ✅ Built-in optimization
- ✅ Vercel deployment

### Why Supabase? | لماذا Supabase؟

- ✅ Auth + Database + Edge Functions
- ✅ Real-time subscriptions
- ✅ Row Level Security
- ✅ Type generation

### Why Turborepo? | لماذا Turborepo؟

- ✅ Monorepo management
- ✅ Fast builds with caching
- ✅ Shared packages
- ✅ Task orchestration

### Why Service Layer? | لماذا طبقة الخدمات؟

- ✅ Testability
- ✅ Reusability
- ✅ Clear boundaries
- ✅ Scalability

---

## 🎯 Future Enhancements | التحسينات المستقبلية

### Phase 2 (Q2 2026)

- [ ] Testing infrastructure
- [ ] E2E test suite
- [ ] Performance monitoring
- [ ] Error tracking (Sentry)

### Phase 3 (Q3 2026)

- [ ] Redis caching
- [ ] Background job queue
- [ ] Rate limiting
- [ ] Audit logging

### Phase 4 (Q4 2026)

- [ ] Multi-tenancy
- [ ] Advanced analytics
- [ ] API versioning
- [ ] GraphQL API

---

## 📚 Related Documentation | الوثائق ذات الصلة

- [CODING_GUIDELINES.md](./CODING_GUIDELINES.md) - Coding standards
- [TESTING_STRATEGY.md](./TESTING_STRATEGY.md) - Testing approach
- [OBSERVABILITY.md](./OBSERVABILITY.md) - Monitoring & logging
- [CONTRIBUTING.md](./CONTRIBUTING.md) - Contribution guidelines
- [SPRINT_1_SUMMARY.md](./SPRINT_1_SUMMARY.md) - Sprint 1 results

---

## 🤝 Contributing | المساهمة

See [CONTRIBUTING.md](./CONTRIBUTING.md) for guidelines on:

- Code style & conventions
- Branch strategy
- Pull request process
- Testing requirements

---

**Last Updated**: 2026-03-22
**Version**: 1.0
**Status**: ✅ Production-Ready
