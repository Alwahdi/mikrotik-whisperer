# CoreRoute Local Agent

Node.js local service that talks directly to MikroTik RouterOS (REST/API) and exposes HTTP endpoints for the Vite app.

## Why this exists

- Browser must never connect directly to RouterOS.
- Router credentials stay in the local trusted environment.
- The agent keeps API connections alive for better performance.
- Batch operations are queued with controlled concurrency.

## Run

```bash
cd agent
npm install
npm run dev
```

Default URL: `http://127.0.0.1:3001`

## Endpoints

- `GET /api/health`
- `POST /api/mikrotik` (generic compatible bridge)
- `POST /api/interfaces`
- `POST /api/users`
- `POST /api/vouchers/push`

## Local-only policy

The agent rejects non-private targets and only allows local addresses:

- `192.168.x.x`
- `10.x.x.x`
- `172.16-31.x.x`
- `localhost`

## Environment

- `AGENT_HOST` (default `127.0.0.1`)
- `AGENT_PORT` (default `3001`)
