/**
 * Test data factories for consistent test data generation
 */

export interface TestUser {
  id: string
  email: string
  name: string
  role: 'admin' | 'user'
  created_at: string
}

export interface TestRouter {
  id: string
  name: string
  host: string
  user: string
  protocol: 'http' | 'https'
  port: number
  user_id: string
  created_at: string
}

export interface TestVoucher {
  id: string
  code: string
  profile_name: string
  router_id: string
  user_id: string
  status: 'active' | 'used' | 'expired'
  created_at: string
  expires_at: string | null
}

export interface TestSale {
  id: string
  voucher_code: string
  profile_name: string
  unit_price: number
  quantity: number
  total_price: number
  sales_point: string
  user_id: string
  router_id: string
  created_at: string
}

/**
 * Create a test user with optional overrides
 */
export function createTestUser(overrides: Partial<TestUser> = {}): TestUser {
  return {
    id: overrides.id || `user-${Date.now()}`,
    email: overrides.email || 'test@example.com',
    name: overrides.name || 'Test User',
    role: overrides.role || 'user',
    created_at: overrides.created_at || new Date().toISOString(),
  }
}

/**
 * Create a test router with optional overrides
 */
export function createTestRouter(
  overrides: Partial<TestRouter> = {}
): TestRouter {
  return {
    id: overrides.id || `router-${Date.now()}`,
    name: overrides.name || 'Test Router',
    host: overrides.host || '192.168.88.1',
    user: overrides.user || 'admin',
    protocol: overrides.protocol || 'https',
    port: overrides.port || 443,
    user_id: overrides.user_id || 'user-123',
    created_at: overrides.created_at || new Date().toISOString(),
  }
}

/**
 * Create a test voucher with optional overrides
 */
export function createTestVoucher(
  overrides: Partial<TestVoucher> = {}
): TestVoucher {
  return {
    id: overrides.id || `voucher-${Date.now()}`,
    code: overrides.code || `VCH-${Math.random().toString(36).slice(2, 10).toUpperCase()}`,
    profile_name: overrides.profile_name || '1GB-24H',
    router_id: overrides.router_id || 'router-123',
    user_id: overrides.user_id || 'user-123',
    status: overrides.status || 'active',
    created_at: overrides.created_at || new Date().toISOString(),
    expires_at: overrides.expires_at || null,
  }
}

/**
 * Create a test sale with optional overrides
 */
export function createTestSale(overrides: Partial<TestSale> = {}): TestSale {
  return {
    id: overrides.id || `sale-${Date.now()}`,
    voucher_code: overrides.voucher_code || 'VCH-TEST1234',
    profile_name: overrides.profile_name || '1GB-24H',
    unit_price: overrides.unit_price || 5,
    quantity: overrides.quantity || 1,
    total_price: overrides.total_price || 5,
    sales_point: overrides.sales_point || 'Point A',
    user_id: overrides.user_id || 'user-123',
    router_id: overrides.router_id || 'router-123',
    created_at: overrides.created_at || new Date().toISOString(),
  }
}

/**
 * Create multiple test users
 */
export function createTestUsers(count: number): TestUser[] {
  return Array.from({ length: count }, (_, i) =>
    createTestUser({
      id: `user-${i}`,
      email: `user${i}@example.com`,
      name: `User ${i}`,
    })
  )
}

/**
 * Create multiple test routers
 */
export function createTestRouters(count: number, userId: string): TestRouter[] {
  return Array.from({ length: count }, (_, i) =>
    createTestRouter({
      id: `router-${i}`,
      name: `Router ${i}`,
      host: `192.168.${i + 1}.1`,
      user_id: userId,
    })
  )
}

/**
 * Create multiple test vouchers
 */
export function createTestVouchers(
  count: number,
  routerId: string,
  userId: string
): TestVoucher[] {
  return Array.from({ length: count }, (_, i) =>
    createTestVoucher({
      id: `voucher-${i}`,
      code: `VCH-TEST${i.toString().padStart(4, '0')}`,
      router_id: routerId,
      user_id: userId,
    })
  )
}

/**
 * Create multiple test sales
 */
export function createTestSales(
  count: number,
  userId: string,
  routerId: string
): TestSale[] {
  return Array.from({ length: count }, (_, i) =>
    createTestSale({
      id: `sale-${i}`,
      voucher_code: `VCH-TEST${i.toString().padStart(4, '0')}`,
      user_id: userId,
      router_id: routerId,
    })
  )
}
