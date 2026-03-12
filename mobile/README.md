# MikroTik Manager — Mobile App (Expo)

Native iOS & Android application for managing MikroTik routers, built with **Expo SDK 51** and **Expo Router** (file-based routing).

## Features

| Screen | Description |
|---|---|
| **Login / Register** | Supabase auth with email/password |
| **Routers** | Add, connect, delete MikroTik routers (REST API & API modes) |
| **Dashboard** | Live system stats: CPU, memory, storage, DHCP, interfaces, hotspot users |
| **Hotspot** | View active & all hotspot users, kick/disable/enable/delete |
| **User Manager** | Browse users, profiles, sessions; disable/enable/delete users |
| **Vouchers** | Generate voucher batches, upload to router, record sales |
| **Sales** | Sales history with date filters (today/week/month/all), revenue summary |
| **Backups** | Backup hotspot & user-manager data to Supabase, view backup history |
| **Settings** | Configure router connection (host/port/user/pass/mode/protocol), sign out |

## Tech Stack

- **Expo SDK 51** + **Expo Router v3** (file-based navigation)
- **React Native** with TypeScript
- **@tanstack/react-query** — server state management
- **@supabase/supabase-js** — auth + database + edge functions
- **@react-native-async-storage/async-storage** — session persistence
- **expo-secure-store** — secure credential storage
- **@expo/vector-icons** (Ionicons) — icons
- **react-native-safe-area-context** — safe area handling

## Project Structure

```
mobile/
├── app/
│   ├── _layout.tsx          # Root layout (providers)
│   ├── index.tsx            # Auth redirect
│   ├── routers.tsx          # Router selection screen
│   ├── (auth)/
│   │   ├── _layout.tsx
│   │   └── login.tsx        # Login / Register
│   └── (app)/
│       ├── _layout.tsx      # Protected tab navigator
│       ├── index.tsx        # Dashboard
│       ├── hotspot.tsx      # Hotspot management
│       ├── usermanager.tsx  # User Manager
│       ├── vouchers.tsx     # Voucher generation
│       ├── sales.tsx        # Sales reports
│       ├── backups.tsx      # Backup / Restore
│       └── settings.tsx     # Settings
├── components/              # Shared UI components
│   ├── Badge.tsx
│   ├── Button.tsx
│   ├── EmptyState.tsx
│   ├── Input.tsx
│   ├── LoadingView.tsx
│   └── StatCard.tsx
├── contexts/
│   └── AuthContext.tsx      # Auth state (Supabase)
├── hooks/
│   └── useMikrotik.ts       # All MikroTik API hooks
├── lib/
│   ├── mikrotikConfig.ts    # Config storage (AsyncStorage)
│   ├── supabase.ts          # Supabase client
│   ├── theme.ts             # Design tokens
│   └── utils.ts             # Formatting helpers
└── assets/images/
```

## Getting Started

```bash
cd mobile

# Install dependencies
npm install

# Start Expo dev server
npm start

# Or run directly on a platform
npm run ios
npm run android
```

> **Note:** Requires [Expo Go](https://expo.dev/go) or a development build to run on device.

## Environment

The Supabase project URL and anon key are embedded in `lib/supabase.ts` (same project as the web app).
All MikroTik API calls go through the `mikrotik-api` Supabase Edge Function.
