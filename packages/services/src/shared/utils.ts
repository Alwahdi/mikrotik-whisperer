/**
 * Shared types and utilities for all services
 */

/**
 * Standard service response type
 */
export type ServiceResult<T> =
  | { success: true; data: T }
  | { success: false; error: ServiceError }

/**
 * Service error with context
 */
export interface ServiceError {
  code: string
  message: string
  details?: unknown
  retryable?: boolean
}

/**
 * Retry configuration
 */
export interface RetryConfig {
  maxAttempts: number
  delayMs: number
  backoffMultiplier?: number
}

/**
 * Create a success result
 */
export function success<T>(data: T): ServiceResult<T> {
  return { success: true, data }
}

/**
 * Create an error result
 */
export function error(
  code: string,
  message: string,
  details?: unknown,
  retryable = false
): ServiceResult<never> {
  return {
    success: false,
    error: { code, message, details, retryable },
  }
}

/**
 * Retry a function with exponential backoff
 */
export async function withRetry<T>(
  fn: () => Promise<T>,
  config: RetryConfig
): Promise<T> {
  let lastError: Error | undefined
  let delay = config.delayMs

  for (let attempt = 1; attempt <= config.maxAttempts; attempt++) {
    try {
      return await fn()
    } catch (err) {
      lastError = err as Error

      if (attempt === config.maxAttempts) {
        break
      }

      // Wait before retry
      await new Promise((resolve) => setTimeout(resolve, delay))

      // Exponential backoff
      if (config.backoffMultiplier) {
        delay *= config.backoffMultiplier
      }
    }
  }

  throw lastError
}

/**
 * Timeout wrapper for async functions
 */
export async function withTimeout<T>(
  fn: () => Promise<T>,
  timeoutMs: number
): Promise<T> {
  return Promise.race([
    fn(),
    new Promise<T>((_, reject) =>
      setTimeout(() => reject(new Error('Operation timed out')), timeoutMs)
    ),
  ])
}
