import { Router } from "express";
import { z } from "zod";
import { executeBatch, executeCommand } from "../services/mikrotik.service.js";
import { assertLocalHost } from "../utils/ip.js";

const invokeSchema = z.object({
  endpoint: z.string().optional(),
  action: z.string().optional(),
  host: z.string().min(1),
  user: z.string().min(1),
  pass: z.string().min(1),
  port: z.string().min(1),
  protocol: z.enum(["https", "http", "api-ssl", "api-plain"]),
  mode: z.enum(["rest", "api"]),
  args: z.array(z.string()).optional(),
  commands: z
    .array(
      z.object({
        command: z.string().min(1),
        args: z.array(z.string()).optional(),
      }),
    )
    .optional(),
});

export const mikrotikRouter = Router();

mikrotikRouter.post("/mikrotik", async (req, res) => {
  const parsed = invokeSchema.safeParse(req.body || {});
  if (!parsed.success) {
    return res.status(400).json({ error: parsed.error.issues[0]?.message || "Invalid payload" });
  }

  const body = parsed.data;

  try {
    assertLocalHost(body.host);

    const config = {
      host: body.host,
      user: body.user,
      pass: body.pass,
      port: body.port,
      protocol: body.protocol,
      mode: body.mode,
    } as const;

    if (body.action === "batch") {
      const commands = body.commands || [];
      const data = await executeBatch(config, commands, 2);
      return res.json(data);
    }

    if (body.action === "health-check") {
      const data = await executeCommand(config, "/system/identity/print");
      return res.json(data);
    }

    if (body.endpoint) {
      const data = await executeCommand(config, body.endpoint, body.args);
      return res.json(data);
    }

    return res.status(400).json({ error: "Missing action or endpoint" });
  } catch (error) {
    const message = error instanceof Error ? error.message : "Agent execution failed";
    return res.status(500).json({ error: message });
  }
});
