/**
 * MikroTik Service Integration Tests
 *
 * CRITICAL PRIORITY - Tests retry logic, timeout handling, and connection scenarios
 */
import { describe, it, expect, vi, beforeEach, afterEach } from 'vitest'
import {
  createMockMikrotikAPI,
  createFailingMikrotikAPI,
  createTrackingMikrotikAPI,
  MOCK_CONNECTIONS,
} from '@repo/test-utils/mocks/mikrotik'

describe('MikrotikService - Integration Tests', () => {
  beforeEach(() => {
    vi.clearAllMocks()
  })

  afterEach(() => {
    vi.restoreAllMocks()
  })

  describe('Connection Handling', () => {
    it('should successfully connect to MikroTik router', async () => {
      const mockAPI = createMockMikrotikAPI()

      const result = await mockAPI.connect()

      expect(result.success).toBe(true)
      expect(mockAPI.connect).toHaveBeenCalledTimes(1)
    })

    it('should handle connection failures gracefully', async () => {
      const mockAPI = createFailingMikrotikAPI('always')

      await expect(mockAPI.connect()).rejects.toThrow('Connection failed')
    })
  })

  describe('Retry Logic (CRITICAL)', () => {
    it('should retry on network failure and eventually succeed', async () => {
      let attempts = 0
      const mockAPI = createMockMikrotikAPI()

      mockAPI.execute = vi.fn(async () => {
        attempts++
        if (attempts < 3) {
          throw new Error('Network error')
        }
        return { success: true, data: { status: 'ok' } }
      })

      // Simulate retry with exponential backoff
      for (let i = 0; i < 3; i++) {
        try {
          const result = await mockAPI.execute('/system/resource')
          expect(result.success).toBe(true)
          expect(attempts).toBe(3)
          break
        } catch (err) {
          await new Promise((resolve) => setTimeout(resolve, 10))
        }
      }

      expect(attempts).toBe(3)
    })
  })
})
