import { Router } from "express";
import { z } from "zod";
import { executeCommand } from "../services/mikrotik.service.js";
import { assertLocalHost } from "../utils/ip.js";

const configSchema = z.object({
  host: z.string().min(1),
  user: z.string().min(1),
  pass: z.string().min(1),
  port: z.string().min(1),
  protocol: z.enum(["https", "http", "api-ssl", "api-plain"]),
  mode: z.enum(["rest", "api"]),
});

export const interfacesRouter = Router();

interfacesRouter.post("/interfaces", async (req, res) => {
  const parsed = configSchema.safeParse(req.body || {});
  if (!parsed.success) {
    return res.status(400).json({ error: parsed.error.issues[0]?.message || "Invalid payload" });
  }

  try {
    const config = parsed.data;
    assertLocalHost(config.host);
    const data = await executeCommand(config, "/interface/print");
    return res.json(data);
  } catch (error) {
    return res.status(500).json({ error: error instanceof Error ? error.message : "Failed to list interfaces" });
  }
});
