import { Router } from "express";

export const healthRouter = Router();
const startedAt = Date.now();
const version = process.env.COREROUTE_AGENT_VERSION || process.env.npm_package_version || "0.1.0";

healthRouter.get("/health", (_req, res) => {
  res.json({
    ok: true,
    service: "coreroute-local-agent",
    version,
    ts: Date.now(),
    startedAt,
    uptimeSec: Math.round(process.uptime()),
    platform: process.platform,
    arch: process.arch,
    node: process.version,
  });
});
