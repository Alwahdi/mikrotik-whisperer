/**
 * Mock MikroTik API responses for testing
 */
import { vi } from 'vitest'

export interface MockMikrotikConnection {
  host: string
  user: string
  pass: string
  protocol?: 'http' | 'https'
  port?: number
}

export interface MockMikrotikResponse {
  success: boolean
  data?: unknown
  error?: string
}

/**
 * Create a mock MikroTik API that returns successful responses
 */
export function createMockMikrotikAPI(
  responses: Record<string, unknown> = {}
) {
  return {
    execute: vi.fn(async (command: string) => {
      // Simulate network delay
      await new Promise((resolve) => setTimeout(resolve, 10))

      if (responses[command]) {
        return {
          success: true,
          data: responses[command],
        }
      }

      // Default responses for common commands
      const defaultResponses: Record<string, unknown> = {
        '/system/resource': {
          uptime: '1w2d3h4m5s',
          version: '7.14',
          'cpu-load': 5,
          'free-memory': 1024000000,
          'total-memory': 2048000000,
        },
        '/interface/print': [
          { name: 'ether1', type: 'ether', 'running': true },
          { name: 'ether2', type: 'ether', 'running': true },
          { name: 'wlan1', type: 'wlan', 'running': true },
        ],
        '/ip/hotspot/user/print': [],
        '/ip/address/print': [
          { address: '192.168.88.1/24', interface: 'ether1' },
        ],
      }

      return {
        success: true,
        data: defaultResponses[command] || {},
      }
    }),
    connect: vi.fn(async () => {
      await new Promise((resolve) => setTimeout(resolve, 10))
      return { success: true }
    }),
    disconnect: vi.fn(() => Promise.resolve()),
  }
}

/**
 * Create a mock MikroTik API that simulates network failures
 */
export function createFailingMikrotikAPI(
  failurePattern: 'always' | 'intermittent' | 'timeout' = 'always'
) {
  let attemptCount = 0

  return {
    execute: vi.fn(async (_command: string) => {
      attemptCount++

      if (failurePattern === 'timeout') {
        // Simulate timeout
        await new Promise((resolve) => setTimeout(resolve, 15000))
        throw new Error('Operation timed out')
      }

      if (failurePattern === 'intermittent') {
        // Fail on odd attempts, succeed on even
        if (attemptCount % 2 === 1) {
          throw new Error('Network error')
        }
        return { success: true, data: {} }
      }

      // Always fail
      throw new Error('Connection refused')
    }),
    connect: vi.fn(async () => {
      if (failurePattern === 'always' || attemptCount % 2 === 1) {
        throw new Error('Connection failed')
      }
      return { success: true }
    }),
    disconnect: vi.fn(() => Promise.resolve()),
  }
}

/**
 * Create a mock MikroTik API that tracks call history
 */
export function createTrackingMikrotikAPI() {
  const callHistory: Array<{
    command: string
    timestamp: number
    response: unknown
  }> = []

  return {
    execute: vi.fn(async (command: string) => {
      await new Promise((resolve) => setTimeout(resolve, 10))

      const response = { success: true, data: {} }
      callHistory.push({
        command,
        timestamp: Date.now(),
        response,
      })

      return response
    }),
    connect: vi.fn(async () => {
      callHistory.push({
        command: 'connect',
        timestamp: Date.now(),
        response: { success: true },
      })
      return { success: true }
    }),
    disconnect: vi.fn(() => {
      callHistory.push({
        command: 'disconnect',
        timestamp: Date.now(),
        response: undefined,
      })
      return Promise.resolve()
    }),
    getCallHistory: () => callHistory,
    clearCallHistory: () => {
      callHistory.length = 0
    },
  }
}

/**
 * Mock connection objects for testing
 */
export const MOCK_CONNECTIONS = {
  valid: {
    host: '192.168.88.1',
    user: 'admin',
    pass: 'password',
    protocol: 'https' as const,
    port: 443,
  },
  invalid: {
    host: 'invalid-host',
    user: 'wrong',
    pass: 'wrong',
    protocol: 'https' as const,
    port: 443,
  },
  slow: {
    host: '192.168.88.2',
    user: 'admin',
    pass: 'password',
    protocol: 'https' as const,
    port: 443,
  },
} as const
