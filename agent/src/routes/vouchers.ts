import { Router } from "express";
import { z } from "zod";
import { executeBatch } from "../services/mikrotik.service.js";
import { assertLocalHost } from "../utils/ip.js";

const voucherSchema = z.object({
  host: z.string().min(1),
  user: z.string().min(1),
  pass: z.string().min(1),
  port: z.string().min(1),
  protocol: z.enum(["https", "http", "api-ssl", "api-plain"]),
  mode: z.enum(["rest", "api"]),
  commands: z.array(
    z.object({
      command: z.string().min(1),
      args: z.array(z.string()).optional(),
    }),
  ),
});

export const vouchersRouter = Router();

vouchersRouter.post("/vouchers/push", async (req, res) => {
  const parsed = voucherSchema.safeParse(req.body || {});
  if (!parsed.success) {
    return res.status(400).json({ error: parsed.error.issues[0]?.message || "Invalid payload" });
  }

  try {
    const { commands, ...config } = parsed.data;
    assertLocalHost(config.host);
    const result = await executeBatch(config, commands, 3);
    return res.json(result);
  } catch (error) {
    return res.status(500).json({ error: error instanceof Error ? error.message : "Voucher batch failed" });
  }
});
