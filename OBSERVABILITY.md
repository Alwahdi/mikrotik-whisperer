# 📊 Observability Guide | دليل قابلية المراقبة

> **MikroTik Whisperer** - Production Monitoring & Logging Strategy

---

## 🎯 Why Observability? | لماذا القابلية للمراقبة؟

### The Three Pillars | الأعمدة الثلاثة

1. **Logging** - What happened? (السجلات - ماذا حدث؟)
2. **Metrics** - How is the system performing? (المقاييس - كيف أداء النظام؟)
3. **Tracing** - Where is the bottleneck? (التتبع - أين الاختناق؟)

### Goals | الأهداف

- **Detect issues** before users notice
- **Debug problems** quickly in production
- **Monitor performance** and optimize
- **Track user behavior** for improvements

---

## 📝 1. Logging Strategy | استراتيجية السجلات

### Log Levels | مستويات السجلات

```typescript
enum LogLevel {
  ERROR = 'error',   // Production issues (CRITICAL)
  WARN = 'warn',     // Potential problems
  INFO = 'info',     // Important events
  DEBUG = 'debug',   // Development only
}
```

### When to Use Each Level? | متى نستخدم كل مستوى؟

#### ERROR - Production Issues

```typescript
// ✅ Log errors that affect users
logger.error('Failed to generate vouchers', {
  error: err.message,
  userId: user.id,
  routerId: router.id,
  quantity: params.quantity,
})

// ✅ Log critical system failures
logger.error('Database connection lost', {
  error: err.message,
  reconnectAttempts: attempts,
})
```

#### WARN - Potential Problems

```typescript
// ✅ Log unusual but handled situations
logger.warn('MikroTik router slow to respond', {
  routerId: router.id,
  responseTime: duration,
  threshold: MAX_RESPONSE_TIME,
})

// ✅ Log deprecated API usage
logger.warn('Using deprecated API endpoint', {
  endpoint: '/api/v1/users',
  migration: 'Use /api/v2/users instead',
})
```

#### INFO - Important Events

```typescript
// ✅ Log significant user actions
logger.info('User generated vouchers', {
  userId: user.id,
  quantity: 100,
  profileName: '1GB-24H',
})

// ✅ Log system events
logger.info('Router connection established', {
  routerId: router.id,
  host: router.host,
})
```

#### DEBUG - Development Only

```typescript
// ✅ ONLY in development
if (process.env.NODE_ENV === 'development') {
  logger.debug('Request payload', { payload })
}
```

---

## 🚫 What NOT to Log | ما لا يجب تسجيله

### NEVER Log Sensitive Data | لا تسجل البيانات الحساسة أبداً

```typescript
// ❌ BAD: Logging passwords
logger.info('User login', {
  email: user.email,
  password: user.password,  // ❌ NEVER!
})

// ❌ BAD: Logging tokens
logger.info('API call', {
  authorization: headers.authorization,  // ❌ NEVER!
})

// ❌ BAD: Logging PII without consent
logger.info('User data', {
  phoneNumber: user.phone,  // ❌ PII!
  address: user.address,    // ❌ PII!
})

// ✅ GOOD: Redacted sensitive fields
logger.info('User login', {
  email: user.email,
  password: '[REDACTED]',
})

// ✅ GOOD: Hashed IDs instead of raw data
logger.info('User action', {
  userId: hashUserId(user.id),  // Hashed for privacy
})
```

---

## 🛠️ 2. Logger Implementation | تطبيق المسجل

### Structured Logging with Winston

```typescript
// packages/logger/src/index.ts
import winston from 'winston'

const logger = winston.createLogger({
  level: process.env.LOG_LEVEL || 'info',
  format: winston.format.combine(
    winston.format.timestamp(),
    winston.format.errors({ stack: true }),
    winston.format.json()
  ),
  defaultMeta: {
    service: 'mikrotik-whisperer',
    environment: process.env.NODE_ENV,
  },
  transports: [
    // Console in development
    new winston.transports.Console({
      format: winston.format.combine(
        winston.format.colorize(),
        winston.format.simple()
      ),
    }),

    // File in production
    new winston.transports.File({
      filename: 'logs/error.log',
      level: 'error',
    }),
    new winston.transports.File({
      filename: 'logs/combined.log',
    }),
  ],
})

export { logger }
```

### Usage in Services

```typescript
import { logger } from '@repo/logger'

export class VoucherService {
  static async generateVouchers(params) {
    const startTime = Date.now()

    logger.info('Voucher generation started', {
      userId: params.userId,
      quantity: params.quantity,
      profileName: params.profileName,
    })

    try {
      const result = await this.generateVoucherCodes(params)

      logger.info('Voucher generation completed', {
        userId: params.userId,
        quantity: result.vouchers.length,
        duration: Date.now() - startTime,
        jobId: result.jobId,
      })

      return success(result)
    } catch (err) {
      logger.error('Voucher generation failed', {
        error: err.message,
        stack: err.stack,
        userId: params.userId,
        quantity: params.quantity,
        duration: Date.now() - startTime,
      })

      return error('VOUCHER_GENERATION_FAILED', err.message, err)
    }
  }
}
```

---

## 📊 3. Metrics & Performance Monitoring

### Key Metrics to Track | المقاييس الأساسية

#### Application Metrics

```typescript
// Response times
metrics.timing('api.vouchers.generate.duration', duration)

// Success/failure rates
metrics.increment('api.vouchers.generate.success')
metrics.increment('api.vouchers.generate.failure')

// Resource usage
metrics.gauge('database.connections.active', activeConnections)
metrics.gauge('memory.usage.mb', memoryUsageMB)
```

#### Business Metrics

```typescript
// Vouchers generated
metrics.increment('business.vouchers.generated', quantity)

// Revenue
metrics.increment('business.revenue.total', totalPrice)

// Active users
metrics.gauge('business.users.active', activeUserCount)
```

### Performance Monitoring

```typescript
// packages/services/src/shared/monitor.ts
export async function withMonitoring<T>(
  operation: string,
  fn: () => Promise<T>
): Promise<T> {
  const startTime = Date.now()
  const startMemory = process.memoryUsage().heapUsed

  try {
    const result = await fn()

    // Log successful operation
    const duration = Date.now() - startTime
    const memoryUsed = process.memoryUsage().heapUsed - startMemory

    logger.info(`${operation} completed`, {
      duration,
      memoryUsed: Math.round(memoryUsed / 1024 / 1024) + 'MB',
    })

    // Send metrics
    metrics.timing(`${operation}.duration`, duration)
    metrics.gauge(`${operation}.memory`, memoryUsed)

    return result
  } catch (err) {
    const duration = Date.now() - startTime

    logger.error(`${operation} failed`, {
      error: err.message,
      duration,
    })

    metrics.increment(`${operation}.error`)
    throw err
  }
}

// Usage
const result = await withMonitoring(
  'voucher.generation',
  () => VoucherService.generateVouchers(params)
)
```

---

## 🔍 4. Error Tracking with Sentry

### Setup Sentry

```typescript
// packages/observability/src/sentry.ts
import * as Sentry from '@sentry/nextjs'
import { env } from '@repo/env'

Sentry.init({
  dsn: env.SENTRY_DSN,
  environment: env.NODE_ENV,
  tracesSampleRate: env.NODE_ENV === 'production' ? 0.1 : 1.0,

  // Don't send PII
  beforeSend(event, hint) {
    // Redact sensitive fields
    if (event.request?.headers) {
      delete event.request.headers['authorization']
      delete event.request.headers['cookie']
    }

    return event
  },
})

export { Sentry }
```

### Capture Errors

```typescript
import { Sentry } from '@repo/observability'

try {
  await riskyOperation()
} catch (err) {
  // Log locally
  logger.error('Operation failed', { error: err.message })

  // Send to Sentry with context
  Sentry.captureException(err, {
    tags: {
      service: 'voucher-generation',
      severity: 'high',
    },
    extra: {
      userId: user.id,
      operation: 'generateVouchers',
    },
  })
}
```

---

## 📈 5. Dashboards & Alerts

### Metrics Dashboard (Future: Grafana)

```yaml
# Example dashboard configuration
dashboard:
  title: MikroTik Whisperer - Production Metrics

  panels:
    - title: API Response Times
      metric: api.response.duration
      visualization: line-chart

    - title: Error Rate
      metric: api.errors.rate
      visualization: gauge
      threshold:
        warning: 1%
        critical: 5%

    - title: Active Users
      metric: business.users.active
      visualization: counter
```

### Alerts

```yaml
# Alert rules
alerts:
  - name: high-error-rate
    condition: error_rate > 5%
    duration: 5m
    channels: [slack, email]

  - name: slow-api-response
    condition: p95_response_time > 2s
    duration: 3m
    channels: [slack]

  - name: database-connection-pool-exhausted
    condition: db_connections_active >= db_connections_max
    duration: 1m
    channels: [pagerduty]
```

---

## 🔧 6. Request Tracing

### Distributed Tracing (Future: OpenTelemetry)

```typescript
// Trace request across services
import { trace } from '@repo/observability'

export async function generateVouchers(params) {
  return trace('voucher.generation', async (span) => {
    span.setAttribute('user.id', params.userId)
    span.setAttribute('quantity', params.quantity)

    // This will be traced
    const vouchers = await generateVoucherCodes(params)

    // This will also be traced
    await saveToDatabase(vouchers)

    return vouchers
  })
}
```

---

## 🚨 7. Health Checks

### Endpoint Health Checks

```typescript
// apps/app/src/app/api/health/route.ts
export async function GET() {
  const checks = {
    database: await checkDatabase(),
    redis: await checkRedis(),
    mikrotik: await checkMikrotikConnectivity(),
  }

  const healthy = Object.values(checks).every(c => c.healthy)

  return Response.json({
    status: healthy ? 'healthy' : 'unhealthy',
    timestamp: new Date().toISOString(),
    checks,
  }, {
    status: healthy ? 200 : 503,
  })
}

async function checkDatabase() {
  try {
    await supabase.from('users').select('id').limit(1)
    return { healthy: true, latency: '< 100ms' }
  } catch (err) {
    return { healthy: false, error: err.message }
  }
}
```

---

## 📊 8. Production Monitoring Checklist

### Before Deployment | قبل النشر

- [ ] Sentry configured and tested
- [ ] Log levels set correctly (INFO in production)
- [ ] Sensitive data redacted from logs
- [ ] Health check endpoint working
- [ ] Metrics collection active
- [ ] Alerts configured

### After Deployment | بعد النشر

- [ ] Monitor error rates (first 24h)
- [ ] Check performance metrics
- [ ] Verify alerts are triggering
- [ ] Review log outputs
- [ ] Test health checks

---

## 🎓 9. Log Analysis Examples

### Finding Slow Operations

```bash
# Find operations taking > 2 seconds
cat logs/combined.log | jq 'select(.duration > 2000)'

# Group by operation type
cat logs/combined.log | jq -r '.operation' | sort | uniq -c
```

### Error Pattern Analysis

```bash
# Count errors by type
cat logs/error.log | jq -r '.error.code' | sort | uniq -c

# Find most common errors
cat logs/error.log | jq -r '.message' | sort | uniq -c | sort -rn | head -10
```

---

## 📚 10. Observability Stack

### Current (Sprint 1)

- ✅ Winston for logging
- ✅ Console/File transports
- ✅ Structured JSON logs

### Future (Sprint 3+)

- [ ] **Sentry** - Error tracking
- [ ] **Logtail/Datadog** - Log aggregation
- [ ] **Grafana** - Metrics dashboards
- [ ] **Prometheus** - Metrics storage
- [ ] **OpenTelemetry** - Distributed tracing
- [ ] **PagerDuty** - Incident management

---

## 🎯 Best Practices Summary

### DO ✅

- Use structured logging (JSON)
- Include context in logs (userId, routerId, etc.)
- Log at appropriate levels
- Redact sensitive data
- Monitor key metrics
- Set up health checks
- Configure alerts

### DON'T ❌

- Log passwords or tokens
- Log PII without consent
- Use console.log in production
- Ignore errors silently
- Log too verbosely (DEBUG in prod)
- Send all logs to external services (cost!)

---

## 📖 Resources | المصادر

- [Winston Documentation](https://github.com/winstonjs/winston)
- [Sentry Best Practices](https://docs.sentry.io/platforms/javascript/best-practices/)
- [Observability Engineering Book](https://www.oreilly.com/library/view/observability-engineering/9781492076438/)
- [The Twelve-Factor App - Logs](https://12factor.net/logs)

---

**Last Updated**: 2026-03-22
**Version**: 1.0
**Status**: 🚧 In Progress (Sentry pending)
