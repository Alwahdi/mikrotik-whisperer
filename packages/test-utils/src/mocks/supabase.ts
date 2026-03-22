/**
 * Mock Supabase client for testing
 */
import type { SupabaseClient } from '@supabase/supabase-js'
import { vi } from 'vitest'

export interface MockSupabaseOptions {
  authUser?: {
    id: string
    email: string
    role?: string
  }
  mockData?: Record<string, unknown[]>
  mockErrors?: Record<string, Error>
}

/**
 * Create a mock Supabase client with customizable behavior
 */
export function createMockSupabaseClient(
  options: MockSupabaseOptions = {}
): SupabaseClient {
  const { authUser, mockData = {}, mockErrors = {} } = options

  const mockFrom = vi.fn((table: string) => ({
    select: vi.fn((_columns?: string) => ({
      eq: vi.fn(() => ({
        single: vi.fn(() => {
          if (mockErrors[table]) {
            return Promise.resolve({
              data: null,
              error: mockErrors[table],
            })
          }
          const data = mockData[table]?.[0] || null
          return Promise.resolve({ data, error: null })
        }),
        data: mockData[table] || [],
        error: mockErrors[table] || null,
      })),
      data: mockData[table] || [],
      error: mockErrors[table] || null,
    })),
    insert: vi.fn((data: unknown) => ({
      select: vi.fn(() => ({
        single: vi.fn(() =>
          Promise.resolve({
            data: Array.isArray(data) ? data[0] : data,
            error: mockErrors[table] || null,
          })
        ),
        data: Array.isArray(data) ? data : [data],
        error: mockErrors[table] || null,
      })),
    })),
    update: vi.fn(() => ({
      eq: vi.fn(() => ({
        select: vi.fn(() => ({
          single: vi.fn(() =>
            Promise.resolve({
              data: mockData[table]?.[0] || null,
              error: mockErrors[table] || null,
            })
          ),
        })),
      })),
    })),
    delete: vi.fn(() => ({
      eq: vi.fn(() =>
        Promise.resolve({
          data: null,
          error: mockErrors[table] || null,
        })
      ),
    })),
  }))

  const mockAuth = {
    getUser: vi.fn(() =>
      Promise.resolve({
        data: {
          user: authUser
            ? {
                id: authUser.id,
                email: authUser.email,
                role: authUser.role || 'authenticated',
              }
            : null,
        },
        error: null,
      })
    ),
    signInWithPassword: vi.fn(() =>
      Promise.resolve({
        data: {
          user: authUser || null,
          session: authUser
            ? {
                access_token: 'mock-access-token',
                refresh_token: 'mock-refresh-token',
              }
            : null,
        },
        error: null,
      })
    ),
    signOut: vi.fn(() => Promise.resolve({ error: null })),
    onAuthStateChange: vi.fn(() => ({
      data: { subscription: { unsubscribe: vi.fn() } },
    })),
  }

  return {
    from: mockFrom,
    auth: mockAuth,
  } as unknown as SupabaseClient
}

/**
 * Create a mock Supabase client that always returns errors
 */
export function createFailingSupabaseClient(
  errorMessage = 'Database error'
): SupabaseClient {
  const error = new Error(errorMessage)

  return {
    from: vi.fn(() => ({
      select: vi.fn(() => Promise.resolve({ data: null, error })),
      insert: vi.fn(() => Promise.resolve({ data: null, error })),
      update: vi.fn(() => Promise.resolve({ data: null, error })),
      delete: vi.fn(() => Promise.resolve({ data: null, error })),
    })),
    auth: {
      getUser: vi.fn(() => Promise.resolve({ data: { user: null }, error })),
      signInWithPassword: vi.fn(() =>
        Promise.resolve({ data: { user: null, session: null }, error })
      ),
      signOut: vi.fn(() => Promise.resolve({ error })),
      onAuthStateChange: vi.fn(() => ({
        data: { subscription: { unsubscribe: vi.fn() } },
      })),
    },
  } as unknown as SupabaseClient
}
