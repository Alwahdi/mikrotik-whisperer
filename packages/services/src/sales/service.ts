import { supabase } from '@repo/database'
import type { ServiceResult } from '../shared/utils'
import { success, error } from '../shared/utils'
import { z } from 'zod'

/**
 * Sales record parameters
 */
export interface SalesRecordParams {
  voucherCode: string
  profileName: string
  unitPrice: number
  quantity: number
  totalPrice: number
  salesPoint?: string
  userId: string
  routerId: string
}

/**
 * Sales statistics query parameters
 */
export interface SalesStatsParams {
  startDate?: Date
  endDate?: Date
  salesPoint?: string
  routerId?: string
}

/**
 * Sales schema for validation
 */
const salesRecordSchema = z.object({
  voucherCode: z.string().min(1),
  profileName: z.string().min(1),
  unitPrice: z.number().min(0),
  quantity: z.number().int().min(1),
  totalPrice: z.number().min(0),
  salesPoint: z.string().optional(),
  userId: z.string().uuid(),
  routerId: z.string().uuid(),
})

/**
 * Sales service - handles sales tracking and analytics
 */
export class SalesService {
  /**
   * Record a voucher sale
   */
  static async recordSale(params: SalesRecordParams): Promise<ServiceResult<{ saleId: string }>> {
    try {
      // Validate input
      const validated = salesRecordSchema.parse(params)

      // Insert sale record
      const { data, error: dbError } = await supabase
        .from('voucher_sales')
        .insert({
          voucher_code: validated.voucherCode,
          profile_name: validated.profileName,
          unit_price: validated.unitPrice,
          quantity: validated.quantity,
          total_price: validated.totalPrice,
          sales_point: validated.salesPoint,
          sold_by: validated.userId,
          router_id: validated.routerId,
        })
        .select('id')
        .single()

      if (dbError) {
        return error('DATABASE_ERROR', 'Failed to record sale', dbError)
      }

      return success({ saleId: data.id })
    } catch (err) {
      if (err instanceof z.ZodError) {
        return error('VALIDATION_ERROR', 'Invalid sales record parameters', err.errors)
      }
      return error('SALES_RECORD_FAILED', 'Failed to record sale', err)
    }
  }

  /**
   * Get sales statistics
   */
  static async getSalesStats(params: SalesStatsParams = {}): Promise<ServiceResult<unknown>> {
    try {
      let query = supabase.from('voucher_sales').select('*')

      // Apply filters
      if (params.startDate) {
        query = query.gte('created_at', params.startDate.toISOString())
      }
      if (params.endDate) {
        query = query.lte('created_at', params.endDate.toISOString())
      }
      if (params.salesPoint) {
        query = query.eq('sales_point', params.salesPoint)
      }
      if (params.routerId) {
        query = query.eq('router_id', params.routerId)
      }

      const { data, error: dbError } = await query

      if (dbError) {
        return error('DATABASE_ERROR', 'Failed to fetch sales statistics', dbError)
      }

      // Calculate aggregated stats
      const stats = {
        totalSales: data.length,
        totalRevenue: data.reduce((sum, sale) => sum + (sale.total_price || 0), 0),
        averageSale: data.length > 0
          ? data.reduce((sum, sale) => sum + (sale.total_price || 0), 0) / data.length
          : 0,
        salesByProfile: this.groupByProfile(data),
        salesBySalesPoint: this.groupBySalesPoint(data),
      }

      return success(stats)
    } catch (err) {
      return error('SALES_STATS_FAILED', 'Failed to get sales statistics', err)
    }
  }

  /**
   * Get daily sales summary
   */
  static async getDailySales(
    date: Date,
    routerId?: string
  ): Promise<ServiceResult<unknown>> {
    try {
      const startOfDay = new Date(date)
      startOfDay.setHours(0, 0, 0, 0)

      const endOfDay = new Date(date)
      endOfDay.setHours(23, 59, 59, 999)

      return this.getSalesStats({
        startDate: startOfDay,
        endDate: endOfDay,
        routerId,
      })
    } catch (err) {
      return error('DAILY_SALES_FAILED', 'Failed to get daily sales', err)
    }
  }

  /**
   * Group sales by profile
   */
  private static groupByProfile(sales: any[]) {
    const grouped = sales.reduce((acc, sale) => {
      const profile = sale.profile_name || 'Unknown'
      if (!acc[profile]) {
        acc[profile] = { count: 0, revenue: 0 }
      }
      acc[profile].count += sale.quantity || 1
      acc[profile].revenue += sale.total_price || 0
      return acc
    }, {} as Record<string, { count: number; revenue: number }>)

    return Object.entries(grouped).map(([profile, stats]) => ({
      profile,
      ...stats,
    }))
  }

  /**
   * Group sales by sales point
   */
  private static groupBySalesPoint(sales: any[]) {
    const grouped = sales.reduce((acc, sale) => {
      const point = sale.sales_point || 'Default'
      if (!acc[point]) {
        acc[point] = { count: 0, revenue: 0 }
      }
      acc[point].count += sale.quantity || 1
      acc[point].revenue += sale.total_price || 0
      return acc
    }, {} as Record<string, { count: number; revenue: number }>)

    return Object.entries(grouped).map(([salesPoint, stats]) => ({
      salesPoint,
      ...stats,
    }))
  }
}
