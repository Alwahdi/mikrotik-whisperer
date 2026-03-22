/**
 * Business logic services package
 * Provides service layer between Edge Functions and integrations
 *
 * Architecture:
 * Edge Functions → Services → Integrations (MikroTik, Database)
 *
 * @example
 * ```ts
 * import { MikrotikService } from '@repo/services/mikrotik'
 * import { VoucherService } from '@repo/services/voucher'
 * import { SalesService } from '@repo/services/sales'
 *
 * // MikroTik operations with retry & timeout
 * const result = await MikrotikService.executeCommand(connection, '/system/resource')
 *
 * // Voucher generation with background jobs
 * const { vouchers, jobId } = await VoucherService.generateVouchers({
 *   profileName: '1GB',
 *   quantity: 100,
 *   routerId: 'uuid',
 *   userId: 'uuid'
 * })
 *
 * // Sales tracking
 * const stats = await SalesService.getSalesStats({ startDate, endDate })
 * ```
 */

export { MikrotikService, type MikrotikConnection, type MikrotikCommand } from './mikrotik'
export { VoucherService, type VoucherGenerationParams } from './voucher'
export { SalesService, type SalesRecordParams, type SalesStatsParams } from './sales'
export { type ServiceResult, type ServiceError, success, error } from './shared'
