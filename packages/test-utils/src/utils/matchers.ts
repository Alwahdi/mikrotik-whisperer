/**
 * Custom Vitest matchers for common assertions
 */
import { expect } from 'vitest'

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

interface CustomMatchers<R = unknown> {
  toBeSuccessResult(): R
  toBeErrorResult(): R
  toHaveErrorCode(code: string): R
  toBeRetryable(): R
}

declare module 'vitest' {
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  interface Assertion<T = any> extends CustomMatchers<T> {}
  interface AsymmetricMatchersContaining extends CustomMatchers {}
}

/**
 * Extend Vitest matchers with custom assertions
 */
expect.extend({
  toBeSuccessResult(received: ServiceResult<unknown>) {
    const { isNot } = this
    const pass = received.success === true

    return {
      pass,
      message: () =>
        isNot
          ? `Expected result not to be a success result, but it was`
          : `Expected result to be a success result, but got: ${JSON.stringify(received)}`,
    }
  },

  toBeErrorResult(received: ServiceResult<unknown>) {
    const { isNot } = this
    const pass = received.success === false

    return {
      pass,
      message: () =>
        isNot
          ? `Expected result not to be an error result, but it was`
          : `Expected result to be an error result, but got: ${JSON.stringify(received)}`,
    }
  },

  toHaveErrorCode(received: ServiceResult<unknown>, expected: string) {
    const { isNot } = this
    const pass =
      received.success === false && received.error.code === expected

    return {
      pass,
      message: () =>
        isNot
          ? `Expected result not to have error code "${expected}", but it did`
          : `Expected result to have error code "${expected}", but got: ${
              received.success === false
                ? received.error.code
                : 'success result'
            }`,
    }
  },

  toBeRetryable(received: ServiceResult<unknown>) {
    const { isNot } = this
    const pass =
      received.success === false && received.error.retryable === true

    return {
      pass,
      message: () =>
        isNot
          ? `Expected error not to be retryable, but it was`
          : `Expected error to be retryable, but got: ${
              received.success === false
                ? `retryable=${received.error.retryable}`
                : 'success result'
            }`,
    }
  },
})

/**
 * Helper function to assert ServiceResult success
 */
export function assertSuccess<T>(
  result: ServiceResult<T>
): asserts result is { success: true; data: T } {
  if (!result.success) {
    throw new Error(
      `Expected success result, but got error: ${JSON.stringify(result.error)}`
    )
  }
}

/**
 * Helper function to assert ServiceResult error
 */
export function assertError(
  result: ServiceResult<unknown>
): asserts result is { success: false; error: ServiceError } {
  if (result.success) {
    throw new Error(`Expected error result, but got success`)
  }
}
