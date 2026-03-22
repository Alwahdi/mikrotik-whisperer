import cors from "cors";
import express from "express";
import { healthRouter } from "./routes/health.js";
import { interfacesRouter } from "./routes/interfaces.js";
import { mikrotikRouter } from "./routes/mikrotik.js";
import { usersRouter } from "./routes/users.js";
import { vouchersRouter } from "./routes/vouchers.js";

const app = express();
const port = Number(process.env.AGENT_PORT || "3001");
const host = process.env.AGENT_HOST || "127.0.0.1";

app.use(cors({ origin: true, credentials: false }));
app.use(express.json({ limit: "2mb" }));

app.use("/api", healthRouter);
app.use("/api", mikrotikRouter);
app.use("/api", interfacesRouter);
app.use("/api", usersRouter);
app.use("/api", vouchersRouter);

app.use(
  (err: unknown, _req: express.Request, res: express.Response, _next: express.NextFunction) => {
    const message = err instanceof Error ? err.message : "Agent internal error";
    res.status(500).json({ error: message });
  }
);

const server = app.listen(port, host, () => {
  console.log(`[agent] CoreRoute Local Agent running on http://${host}:${port}`);
});

server.on("error", (error: NodeJS.ErrnoException) => {
  if (error.code === "EADDRINUSE") {
    console.log(`[agent] Port ${port} already in use. Assuming agent is already running.`);
    process.exit(0);
  }
  throw error;
});
