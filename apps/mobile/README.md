# MikroTik Whisperer Mobile App

Mobile application for MikroTik Whisperer built with Expo SDK 54 and React Native.

## Features

- **Authentication**: Secure login with Supabase Auth
- **Router Management**: Add and switch between multiple routers (local and remote)
- **Dashboard**: Real-time system stats and monitoring
- **Hotspot Management**: View and disconnect active hotspot users
- **Voucher Generation**: Create and manage vouchers with QR codes
- **Network Flexibility**: Supports both local IP and public IP/domain connections

## Network Configuration

### Local IP Addresses
When using a local IP address (e.g., 192.168.1.1, 10.0.0.1):
- ✅ Full functionality when connected to the same network
- ✅ Fast response times
- ❌ Won't work from outside the local network

### Public IP/Domain
When using a public IP or domain name:
- ✅ Works from anywhere with internet connection
- ✅ Remote access to your MikroTik system
- ⚠️ Ensure your router has proper port forwarding configured
- ⚠️ Consider security implications (use strong passwords, enable firewall rules)

## Prerequisites

- Node.js 18+ and pnpm
- Expo CLI: `npm install -g expo-cli`
- For iOS: Xcode and iOS Simulator (macOS only)
- For Android: Android Studio and Android Emulator
- Expo Go app on your physical device (for testing)

## Setup

1. **Install dependencies**:
   ```bash
   cd apps/mobile
   pnpm install
   ```

2. **Configure environment**:
   Create `.env` file in `apps/mobile/`:
   ```env
   SUPABASE_URL=https://your-project.supabase.co
   SUPABASE_ANON_KEY=your-anon-key-here
   ```

3. **Update app.json**:
   - Set your EAS project ID in `app.json` under `extra.eas.projectId`

## Development

### Start the development server:
```bash
pnpm start
```

### Run on specific platform:
```bash
pnpm android  # Run on Android
pnpm ios      # Run on iOS (macOS only)
pnpm web      # Run on web browser
```

### Scan QR code:
Open Expo Go app on your phone and scan the QR code from the terminal.

## Building

### Prerequisites for EAS Build:
1. Install EAS CLI: `npm install -g eas-cli`
2. Login to your Expo account: `eas login`
3. Configure your project: `eas build:configure`

### Build for Android:
```bash
pnpm build:android
```

### Build for iOS:
```bash
pnpm build:ios
```

## Project Structure

```
apps/mobile/
├── app/                    # Expo Router pages
│   ├── (app)/             # Authenticated screens
│   │   ├── dashboard.tsx  # Dashboard screen
│   │   ├── routers.tsx    # Router management
│   │   ├── hotspot.tsx    # Hotspot users
│   │   ├── vouchers.tsx   # Voucher generation
│   │   └── settings.tsx   # App settings
│   ├── _layout.tsx        # Root layout
│   ├── auth.tsx           # Authentication screen
│   └── index.tsx          # Entry point
├── components/            # Reusable UI components
│   ├── Button.tsx
│   ├── Card.tsx
│   └── Input.tsx
├── lib/                   # Utilities and configurations
│   ├── env.ts            # Environment variables
│   ├── supabase.ts       # Supabase client
│   ├── storage.ts        # AsyncStorage helpers
│   └── utils.ts          # Utility functions
├── assets/               # Images, fonts, etc.
├── app.json              # Expo configuration
├── eas.json              # EAS Build configuration
└── package.json
```

## Technologies

- **Expo SDK 54**: Framework for React Native apps
- **Expo Router 4**: File-based routing for React Native
- **NativeWind**: Tailwind CSS for React Native
- **TanStack Query**: Data fetching and caching
- **Supabase**: Backend and authentication
- **AsyncStorage**: Local data persistence
- **Expo SecureStore**: Secure token storage

## Shared Packages

The mobile app reuses packages from the monorepo:
- `@repo/auth`: Authentication logic
- `@repo/database`: Supabase client and types
- `@repo/mikrotik`: MikroTik API hooks and utilities

## Security Considerations

### For Local Networks:
- Use strong router passwords
- Enable WPA2/WPA3 encryption
- Keep router firmware updated

### For Public Access:
- **Never** expose your router directly to the internet without proper security
- Use VPN when possible
- Enable firewall rules to restrict access
- Use strong, unique passwords
- Enable two-factor authentication where possible
- Monitor access logs regularly
- Consider using Supabase Row Level Security (RLS) for additional protection

## Troubleshooting

### Can't connect to router:
1. Verify the router is accessible (ping the IP)
2. Check port forwarding for public IPs
3. Verify MikroTik API is enabled on the router
4. Check firewall rules on both router and network

### Authentication issues:
1. Verify Supabase URL and anon key in `.env`
2. Check Supabase project is active
3. Clear app data and try again

### Build errors:
1. Clear cache: `expo start -c`
2. Reinstall dependencies: `rm -rf node_modules && pnpm install`
3. Check EAS build logs for specific errors

## Contributing

See the main repository [CONTRIBUTING.md](../../CONTRIBUTING.md) for contribution guidelines.

## License

See the main repository for license information.
