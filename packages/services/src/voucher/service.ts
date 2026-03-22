import { supabase } from '@repo/database'
import type { ServiceResult } from '../shared/utils'
import { success, error } from '../shared/utils'
import { z } from 'zod'

/**
 * Voucher generation parameters
 */
export interface VoucherGenerationParams {
  profileName: string
  quantity: number
  prefix?: string
  length?: number
  routerId: string
  userId: string
  salesPoint?: string
  unitPrice?: number
}

/**
 * Voucher schema for validation
 */
const voucherGenerationSchema = z.object({
  profileName: z.string().min(1),
  quantity: z.number().int().min(1).max(1000),
  prefix: z.string().optional(),
  length: z.number().int().min(4).max(20).optional(),
  routerId: z.string().uuid(),
  userId: z.string().uuid(),
  salesPoint: z.string().optional(),
  unitPrice: z.number().min(0).optional(),
})

/**
 * Voucher service - handles voucher generation and management
 */
export class VoucherService {
  /**
   * Generate vouchers in bulk
   */
  static async generateVouchers(
    params: VoucherGenerationParams
  ): Promise<ServiceResult<{ vouchers: string[]; jobId: string }>> {
    try {
      // Validate input
      const validated = voucherGenerationSchema.parse(params)

      // Generate unique voucher codes
      const vouchers = this.generateVoucherCodes(
        validated.quantity,
        validated.prefix || 'VCH',
        validated.length || 8
      )

      // Create background job for processing
      const jobId = crypto.randomUUID()

      // Store job in database
      const { error: dbError } = await supabase.from('background_jobs').insert({
        id: jobId,
        type: 'voucher_generation',
        status: 'pending',
        payload: {
          vouchers,
          profileName: validated.profileName,
          routerId: validated.routerId,
          userId: validated.userId,
          salesPoint: validated.salesPoint,
          unitPrice: validated.unitPrice,
        },
        created_by: validated.userId,
      })

      if (dbError) {
        return error('DATABASE_ERROR', 'Failed to create voucher generation job', dbError)
      }

      return success({ vouchers, jobId })
    } catch (err) {
      if (err instanceof z.ZodError) {
        return error('VALIDATION_ERROR', 'Invalid voucher generation parameters', err.errors)
      }
      return error('VOUCHER_GENERATION_FAILED', 'Failed to generate vouchers', err)
    }
  }

  /**
   * Generate unique voucher codes
   */
  private static generateVoucherCodes(
    quantity: number,
    prefix: string,
    length: number
  ): string[] {
    const vouchers: string[] = []
    const characters = 'ABCDEFGHJKLMNPQRSTUVWXYZ23456789' // Exclude confusing chars

    for (let i = 0; i < quantity; i++) {
      let code = prefix + '-'
      for (let j = 0; j < length; j++) {
        code += characters.charAt(Math.floor(Math.random() * characters.length))
      }
      vouchers.push(code)
    }

    return vouchers
  }

  /**
   * Get voucher generation job status
   */
  static async getJobStatus(jobId: string): Promise<ServiceResult<unknown>> {
    try {
      const { data, error: dbError } = await supabase
        .from('background_jobs')
        .select('*')
        .eq('id', jobId)
        .single()

      if (dbError) {
        return error('DATABASE_ERROR', 'Failed to fetch job status', dbError)
      }

      return success(data)
    } catch (err) {
      return error('JOB_STATUS_FAILED', 'Failed to get job status', err)
    }
  }

  /**
   * Delete vouchers
   */
  static async deleteVouchers(
    voucherIds: string[],
    routerId: string,
    userId: string
  ): Promise<ServiceResult<{ deleted: number }>> {
    try {
      // Create background job for deletion
      const jobId = crypto.randomUUID()

      const { error: dbError } = await supabase.from('background_jobs').insert({
        id: jobId,
        type: 'voucher_deletion',
        status: 'pending',
        payload: {
          voucherIds,
          routerId,
        },
        created_by: userId,
      })

      if (dbError) {
        return error('DATABASE_ERROR', 'Failed to create voucher deletion job', dbError)
      }

      return success({ deleted: voucherIds.length })
    } catch (err) {
      return error('VOUCHER_DELETION_FAILED', 'Failed to delete vouchers', err)
    }
  }
}
