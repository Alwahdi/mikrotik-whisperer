# MikroTik Next.js API Integration

This document explains the new Next.js API-based architecture for MikroTik router management, which replaces the Supabase Edge Function approach.

## Architecture Overview

### Old Architecture (Supabase Edge Functions)
```
Frontend Hooks → invokeMikrotik() → Supabase Edge Function → Deno TCP Client → MikroTik Router
```

### New Architecture (Next.js API Routes)
```
Frontend Hooks → apiClient → Next.js API Routes → node-routeros → MikroTik Router
```

## Benefits

1. **Direct Connection**: No dependency on Supabase infrastructure
2. **Simplified Auth**: Uses iron-session cookies instead of Supabase auth
3. **Better Performance**: Eliminates extra network hop through Supabase
4. **Easier Development**: Standard Next.js API routes are easier to debug
5. **Mobile App Compatibility**: Commands match the mobile app's proven patterns exactly

## Getting Started

### 1. Set Environment Variable

Add to your `.env` file:

```bash
# Required in production for session encryption
ROUTER_SESSION_SECRET=your-secret-key-at-least-32-characters-long
```

### 2. Connect to Router

```tsx
import { useRouterConnection } from '@repo/mikrotik';

function LoginPage() {
  const { connect, disconnect, status } = useRouterConnection();

  const handleConnect = async () => {
    await connect.mutateAsync({
      host: '192.168.88.1',
      port: 8728,
      user: 'admin',
      password: 'password',
    });
  };

  return (
    <div>
      {status.data?.connected ? (
        <button onClick={() => disconnect.mutate()}>Disconnect</button>
      ) : (
        <button onClick={handleConnect}>Connect</button>
      )}
    </div>
  );
}
```

### 3. Use MikroTik Operations

```tsx
import {
  useApiUserManagerUsers,
  useUserManagerUserActions,
  useApiUserManagerProfiles,
} from '@repo/mikrotik';

function UsersPage() {
  const { data: users } = useApiUserManagerUsers();
  const { add, enable, disable, remove } = useUserManagerUserActions();

  const handleAddUser = async () => {
    await add.mutateAsync({
      username: 'user123',
      password: 'pass123',
      profile: '1day-1gb',
      customer: 'admin',
    });
  };

  return (
    <div>
      {users?.active.map(user => (
        <div key={user.id}>
          {user.username}
          <button onClick={() => enable.mutate(user.id)}>Enable</button>
          <button onClick={() => disable.mutate(user.id)}>Disable</button>
          <button onClick={() => remove.mutate(user.id)}>Delete</button>
        </div>
      ))}
    </div>
  );
}
```

## Available Hooks

### Connection Management

- `useRouterConnection()` - Connect, disconnect, and check connection status

### User Manager

#### Users
- `useApiUserManagerUsers()` - Get all users (active and inactive)
- `useUserManagerUserActions()` - Add, enable, disable, remove users
- `useBatchAddUsers()` - Bulk add users with SSE progress
- `useExpiredUsers()` - Get expired/inactive users
- `useRemoveExpiredUsers()` - Bulk remove expired users

#### Profiles
- `useApiUserManagerProfiles()` - Get all User Manager profiles
- `useUserManagerProfileActions()` - Add, remove profiles

#### Sessions & Data
- `useUserSessions(username)` - Get sessions for specific user
- `useAllSessions()` - Get all active sessions
- `useCustomers()` - Get customer/reseller list (v6 only)
- `usePayments()` - Get payment history

### Hotspot

- `useApiHotspotUsers()` - Get all hotspot users
- `useHotspotUserActions()` - Add, enable, disable, remove hotspot users
- `useApiHotspotProfiles()` - Get hotspot profiles
- `useActiveConnections()` - Get currently active hotspot connections

## API Routes

All routes are under `/api/mikrotik/`:

| Endpoint | Methods | Description |
|----------|---------|-------------|
| `/connect` | GET, POST, DELETE | Connection management |
| `/users` | GET, POST | List and add users |
| `/users/[id]` | PATCH, DELETE | Enable/disable/remove specific user |
| `/users/batch` | POST | Bulk add users with SSE |
| `/users/expired` | GET, DELETE | Get and remove expired users |
| `/profiles` | GET, POST, DELETE | Profile management |
| `/hotspot` | GET, POST | Hotspot user management |
| `/hotspot/[id]` | PATCH, DELETE | Hotspot user actions |
| `/active` | GET | Active connections |
| `/sessions` | GET | User sessions |
| `/sessions/all` | GET | All sessions |
| `/customers` | GET | Customer list (v6) |
| `/payments` | GET | Payment history |

## Migration Guide

### Step 1: Update Imports

**Before (Supabase):**
```tsx
import { useUserManagerUsers } from '@repo/mikrotik';
```

**After (Next.js API):**
```tsx
import { useApiUserManagerUsers } from '@repo/mikrotik';
```

### Step 2: Update Connection Logic

**Before:**
```tsx
// Connection state stored in localStorage
// Credentials stored in Supabase database
setActiveRouter({ routerId, host, port, ... });
```

**After:**
```tsx
// Connection via API, credentials stored in encrypted cookie
const { connect } = useRouterConnection();
await connect.mutateAsync({ host, port, user, password });
```

### Step 3: Update Operation Calls

The new hooks return structured objects with named mutations:

**Before:**
```tsx
const { mutate: addUser } = useUserManagerAction();
addUser({ action: 'add', args: [...] });
```

**After:**
```tsx
const { add } = useUserManagerUserActions();
add.mutate({ username, password, profile });
```

## Command Compatibility

All commands are verified against the mobile app implementation to ensure compatibility:

### User Manager (v6 vs v7)

**v7:**
```
/user-manager/user/add name=X password=Y shared-users=0
/user-manager/user-profile/add user=ID profile=P
/user-manager/user/enable numbers=ID
/user-manager/user/disable numbers=ID
```

**v6:**
```
/tool/user-manager/user/add username=X password=Y customer=admin
/tool/user-manager/user/create-and-activate-profile numbers=ID profile=P customer=admin
/tool/user-manager/user/enable numbers=ID
/tool/user-manager/user/disable numbers=ID
```

### Hotspot

```
/ip/hotspot/user/add name=X password=Y profile=P
/ip/hotspot/user/enable numbers=ID
/ip/hotspot/user/disable numbers=ID
/ip/hotspot/user/remove numbers=ID
```

## Session Management

The system uses `iron-session` to store router credentials in encrypted HTTP-only cookies:

```typescript
interface RouterSessionData {
  isLoggedIn: boolean;
  username?: string;
  router?: {
    host: string;
    port: number;
    user: string;
    password: string;
  };
  routerVersion?: number;
}
```

### Security Features

1. **Encrypted Cookies**: Credentials encrypted with `ROUTER_SESSION_SECRET`
2. **HTTP-Only**: Cookies not accessible via JavaScript
3. **Secure Flag**: HTTPS-only in production
4. **No Client Storage**: Credentials never stored in localStorage or client-side

## Error Handling

All hooks include automatic toast notifications:

```tsx
const { add } = useUserManagerUserActions();

// Success: Shows success toast automatically
await add.mutateAsync({ username: 'test', ... });

// Error: Shows error toast automatically
try {
  await add.mutateAsync({ username: 'test', ... });
} catch (error) {
  // Error already shown to user
  // Handle additional error logic here
}
```

## Advanced Usage

### Custom Timeout

```tsx
import { apiPost } from '@repo/mikrotik';

const result = await apiPost('/users/batch', {
  users: [...],
  profile: 'default',
}, {
  timeoutMs: 120000, // 2 minutes
});
```

### Direct API Calls

```tsx
import { apiGet, apiPost, apiPatch, apiDelete } from '@repo/mikrotik';

// GET request
const users = await apiGet('/users');

// POST request
const result = await apiPost('/users', { username: 'test', password: 'test' });

// PATCH request
await apiPatch('/users/123', { action: 'enable' });

// DELETE request
await apiDelete('/users/123');
```

## Troubleshooting

### "Not connected" Error

Make sure you've called `connect()` first:

```tsx
const { connect, status } = useRouterConnection();

// Check connection status
if (!status.data?.connected) {
  await connect.mutateAsync({ host, port, user, password });
}
```

### "ROUTER_SESSION_SECRET environment variable must be set"

Add the environment variable to your `.env` file:

```bash
ROUTER_SESSION_SECRET=your-secret-key-at-least-32-characters-long
```

### Session Expires

Sessions expire when:
- User explicitly disconnects
- Browser closes (session cookie)
- Server restarts (in-memory session store)

To persist sessions across server restarts, implement a session store (Redis, database, etc.).

## Performance Optimization

### Query Caching

All queries are cached using TanStack Query:

- User lists: 10s stale time
- Profiles: 30s stale time
- Sessions: 30s stale time
- Active connections: Auto-refresh every 10s

### Invalidation

Mutations automatically invalidate related queries:

```tsx
const { add } = useUserManagerUserActions();

// Adding a user automatically refetches user lists
await add.mutateAsync({ ... });
```

## Contributing

When adding new operations:

1. Add server function in `packages/mikrotik/src/server/index.ts`
2. Add API route in `apps/app/src/app/api/mikrotik/`
3. Add hook in `packages/mikrotik/src/hooks/useMikrotikApi.ts`
4. Export from `packages/mikrotik/src/index.ts`
5. Update this documentation

## References

- [MikroTik API Documentation](https://help.mikrotik.com/docs/display/ROS/API)
- [node-routeros](https://github.com/aluisiora/node-routeros)
- [iron-session](https://github.com/vvo/iron-session)
- [TanStack Query](https://tanstack.com/query/latest)
