# API Reference

This document describes the local agent API and Supabase edge function interfaces.

## CoreRoute Local Agent

The local agent runs at `http://127.0.0.1:3001` by default. It acts as a proxy between the browser and LAN-accessible MikroTik routers.

### Base URL

```
http://127.0.0.1:3001
```

Override with `NEXT_PUBLIC_MIKROTIK_AGENT_URL` environment variable or from the Settings page.

### Endpoints

#### `GET /health`

Returns agent health status and version.

**Response**

```json
{
  "status": "ok",
  "version": "0.1.0"
}
```

---

#### `POST /api/invoke`

Invokes a RouterOS API command on the target router.

**Request Body**

```json
{
  "host": "192.168.1.1",
  "port": 8728,
  "username": "admin",
  "password": "secret",
  "path": "/ip/address/print",
  "command": "print",
  "params": {}
}
```

**Response**

```json
{
  "success": true,
  "data": [ ... ]
}
```

**Error Response**

```json
{
  "success": false,
  "error": "Connection refused"
}
```

---

## Supabase Edge Functions

Edge functions handle cloud-bridged router access for WAN-reachable routers.

> Detailed edge function documentation is maintained in the `supabase/functions/` directory alongside each function's source code.

---

## Client — `mikrotikInvoke()`

The client-side function that routes calls to either the local agent or the Supabase edge function.

**Source:** `src/lib/mikrotikInvoke.ts`

```typescript
import { mikrotikInvoke } from "@/lib/mikrotikInvoke";

const result = await mikrotikInvoke({
  host: "192.168.1.1",
  port: 8728,
  username: "admin",
  password: "secret",
  path: "/ip/address/print",
  command: "print",
});
```

The function automatically selects the local agent for LAN IPs and the cloud bridge for public IPs.
