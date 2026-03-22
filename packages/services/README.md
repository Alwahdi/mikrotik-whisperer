# @repo/services

Business logic layer for MikroTik Whisperer. Provides service classes that abstract business operations from Edge Functions and API routes.

## Architecture

```
Edge Functions / API Routes
         ↓
    @repo/services (this package)
         ↓
Integrations (MikroTik API, Supabase, etc.)
```

## Services

### MikrotikService

Handles all MikroTik router operations with built-in retry logic, timeout handling, and error management.

```typescript
import { MikrotikService } from '@repo/services/mikrotik'

// Execute command with retry & timeout
const result = await MikrotikService.executeCommand(
  {
    host: '192.168.88.1',
    user: 'admin',
    pass: 'password',
    protocol: 'https',
  },
  '/system/resource',
  {
    timeoutMs: 10000,
    retryAttempts: 3,
  }
)

if (result.success) {
  console.log('Data:', result.data)
} else {
  console.error('Error:', result.error)
}
```

**Features:**
- ✅ Automatic retry with exponential backoff
- ✅ Configurable timeouts
- ✅ Connection testing
- ✅ Batch command execution
- ✅ Typed error responses

---

### VoucherService

Manages voucher generation and lifecycle with background job support.

```typescript
import { VoucherService } from '@repo/services/voucher'

// Generate vouchers in bulk
const result = await VoucherService.generateVouchers({
  profileName: '1GB-24H',
  quantity: 100,
  prefix: 'VCH',
  length: 8,
  routerId: 'uuid',
  userId: 'uuid',
  salesPoint: 'Point A',
  unitPrice: 5,
})

if (result.success) {
  const { vouchers, jobId } = result.data
  console.log(`Generated ${vouchers.length} vouchers`)
  console.log(`Job ID: ${jobId}`)
}
```

**Features:**
- ✅ Bulk voucher generation
- ✅ Background job processing
- ✅ Customizable voucher format
- ✅ Input validation with Zod
- ✅ Job status tracking

---

### SalesService

Tracks sales and provides analytics for revenue tracking.

```typescript
import { SalesService } from '@repo/services/sales'

// Record a sale
await SalesService.recordSale({
  voucherCode: 'VCH-A1B2C3D4',
  profileName: '1GB-24H',
  unitPrice: 5,
  quantity: 1,
  totalPrice: 5,
  salesPoint: 'Point A',
  userId: 'uuid',
  routerId: 'uuid',
})

// Get sales statistics
const stats = await SalesService.getSalesStats({
  startDate: new Date('2026-03-01'),
  endDate: new Date('2026-03-22'),
  salesPoint: 'Point A',
})

if (stats.success) {
  console.log('Total Revenue:', stats.data.totalRevenue)
  console.log('Sales by Profile:', stats.data.salesByProfile)
}
```

**Features:**
- ✅ Sales recording with validation
- ✅ Revenue analytics
- ✅ Filtering by date, sales point, router
- ✅ Daily/weekly/monthly summaries
- ✅ Grouping by profile and sales point

---

## Service Result Pattern

All services return a standardized `ServiceResult<T>` type:

```typescript
type ServiceResult<T> =
  | { success: true; data: T }
  | { success: false; error: ServiceError }

interface ServiceError {
  code: string
  message: string
  details?: unknown
  retryable?: boolean
}
```

### Benefits

- ✅ **Type-safe** - No exceptions, explicit error handling
- ✅ **Consistent** - Same pattern across all services
- ✅ **Informative** - Error codes and context
- ✅ **Retry hints** - `retryable` flag for automatic retry

### Usage Pattern

```typescript
const result = await SomeService.someMethod()

if (result.success) {
  // TypeScript knows result.data exists
  console.log(result.data)
} else {
  // TypeScript knows result.error exists
  console.error(result.error.code, result.error.message)

  if (result.error.retryable) {
    // Retry logic
  }
}
```

---

## Shared Utilities

### Retry with Backoff

```typescript
import { withRetry } from '@repo/services'

const result = await withRetry(
  async () => fetchSomeData(),
  {
    maxAttempts: 3,
    delayMs: 1000,
    backoffMultiplier: 2, // 1s, 2s, 4s
  }
)
```

### Timeout Wrapper

```typescript
import { withTimeout } from '@repo/services'

const result = await withTimeout(
  async () => longRunningOperation(),
  5000 // 5 seconds
)
```

---

## Error Codes

### MikrotikService
- `MIKROTIK_COMMAND_FAILED` - Command execution failed (retryable)
- `MIKROTIK_BATCH_FAILED` - Batch operation failed (retryable)
- `MIKROTIK_CONNECTION_FAILED` - Connection test failed (retryable)

### VoucherService
- `VALIDATION_ERROR` - Invalid input parameters
- `DATABASE_ERROR` - Database operation failed
- `VOUCHER_GENERATION_FAILED` - Voucher generation failed
- `VOUCHER_DELETION_FAILED` - Voucher deletion failed

### SalesService
- `VALIDATION_ERROR` - Invalid input parameters
- `DATABASE_ERROR` - Database operation failed
- `SALES_RECORD_FAILED` - Sales recording failed
- `SALES_STATS_FAILED` - Statistics query failed

---

## Architecture Decisions

Following the architect's decisions:

1. **Service Layer Pattern** - Business logic separated from API handlers
2. **Retry & Timeout** - Built into critical operations (MikroTik)
3. **Background Jobs** - For long-running operations (voucher generation)
4. **Type Safety** - Zod validation + TypeScript
5. **Error Handling** - Standardized error responses
6. **Scalability** - Services can be called from Edge Functions, API routes, or workers

---

## Testing Priority

Per architect's decision, testing priority:

1. **MikroTik integration tests** (CRITICAL) ✅
   - Connection handling
   - Retry scenarios
   - Timeout handling
   - Different router configs

2. **Service layer tests** (HIGH)
   - Voucher generation validation
   - Sales calculation logic
   - Error handling paths

---

## Future Enhancements

- [ ] Rate limiting per router
- [ ] Caching for frequently accessed data
- [ ] Circuit breaker pattern for failing routers
- [ ] Event streaming for real-time updates
- [ ] Observability (tracing, metrics)
