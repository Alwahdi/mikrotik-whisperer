# Mobile App Quick Start Guide

Get the MikroTik Whisperer mobile app up and running in minutes.

## Prerequisites

- Node.js 18+ and pnpm installed
- Expo CLI: `npm install -g expo-cli`
- A smartphone with Expo Go app installed (iOS/Android)
- Supabase project with MikroTik Whisperer backend

## Step 1: Install Dependencies

```bash
cd apps/mobile
pnpm install
```

## Step 2: Configure Environment

Create `.env` file in `apps/mobile/`:

```env
SUPABASE_URL=https://your-project.supabase.co
SUPABASE_ANON_KEY=your-anon-key-here
```

Get these values from your Supabase project settings.

## Step 3: Start Development Server

```bash
pnpm start
```

This will:
1. Start the Metro bundler
2. Show a QR code in your terminal
3. Provide URLs for web and device testing

## Step 4: Run on Your Device

### Option A: Physical Device (Recommended)

1. Install **Expo Go** app:
   - [iOS App Store](https://apps.apple.com/app/expo-go/id982107779)
   - [Google Play Store](https://play.google.com/store/apps/details?id=host.exp.exponent)

2. Open Expo Go

3. Scan the QR code:
   - **iOS**: Use Camera app → point at QR code → tap notification
   - **Android**: In Expo Go → tap "Scan QR Code"

4. App will load on your device!

### Option B: Simulator/Emulator

**iOS Simulator** (macOS only):
```bash
pnpm ios
```

**Android Emulator**:
```bash
pnpm android
```

**Web Browser**:
```bash
pnpm web
```

## Step 5: Sign In or Create Account

1. App opens to authentication screen
2. Enter your email and password
3. For new accounts:
   - Tap "Sign Up"
   - Check email for verification link
   - Sign in after verification

## Step 6: Add Your First Router

1. Navigate to **Routers** tab
2. Tap **Add Router**
3. Fill in details:
   ```
   Label: My Router
   Host: 192.168.88.1 (or your IP)
   Port: 8728
   Username: admin
   Password: your-password
   ```
4. Tap **Save Router**
5. Tap the router card to activate it

### For Local Network
- Use local IP (e.g., `192.168.88.1`)
- Ensure phone is on same WiFi
- See badge: "Local Network"

### For Remote Access
- Use public IP or domain
- Ensure port forwarding is configured
- See badge: "Public/Remote"
- **Read NETWORK_CONFIGURATION.md for security!**

## Step 7: Start Managing

You're ready! Navigate through:

- **Dashboard**: View system stats and quick metrics
- **Routers**: Manage and switch between routers
- **Hotspot**: View and manage hotspot users
- **Vouchers**: Generate voucher codes
- **Settings**: Configure app and sign out

## Common Issues

### "Cannot connect to development server"

**Solution 1**: Ensure phone and computer on same WiFi
```bash
# Check your computer's IP
ipconfig getifaddr en0  # macOS
ip addr show | grep inet  # Linux
ipconfig  # Windows
```

**Solution 2**: Use tunnel mode
```bash
pnpm start --tunnel
```

**Solution 3**: Clear cache
```bash
pnpm start -c
```

### "Module not found" errors

```bash
# Clean and reinstall
rm -rf node_modules
pnpm install
pnpm start -c
```

### "Unable to resolve module"

```bash
# Reset Metro bundler
watchman watch-del-all  # if watchman installed
rm -rf $TMPDIR/metro-*
pnpm start -c
```

### App crashes on device

1. Check Expo Go is updated
2. Check compatibility with Expo SDK 54
3. View error logs in terminal
4. Try on different device/simulator

## Development Tips

### Hot Reload

- **Shake device** or press `Ctrl+M` (Android) / `Cmd+D` (iOS)
- Select "Reload" to refresh app
- Changes auto-reload in most cases

### Debug Menu

Access via shake or `Cmd+D`/`Ctrl+M`:
- **Reload**: Refresh app
- **Debug**: Open Chrome DevTools
- **Performance Monitor**: Show FPS and memory
- **Element Inspector**: Inspect UI elements

### Logs

View logs in terminal where `pnpm start` is running.

For more detailed logs:
```bash
npx react-native log-android  # Android
npx react-native log-ios      # iOS
```

## Building for Production

### Setup EAS (One-time)

```bash
# Install EAS CLI
npm install -g eas-cli

# Login to Expo
eas login

# Configure project
eas build:configure
```

### Build APK (Android)

```bash
# Preview build (APK)
pnpm build:android --profile preview

# Production build (AAB for Play Store)
pnpm build:android --profile production
```

### Build IPA (iOS)

```bash
# Development build
pnpm build:ios --profile development

# Production build (for App Store)
pnpm build:ios --profile production
```

Builds run on Expo's servers. Download from provided URL when complete.

## Project Structure

```
apps/mobile/
├── app/                    # Expo Router pages
│   ├── (app)/             # Authenticated app screens
│   │   ├── dashboard.tsx  # Main dashboard
│   │   ├── routers.tsx    # Router management
│   │   ├── hotspot.tsx    # Hotspot users
│   │   ├── vouchers.tsx   # Voucher generation
│   │   └── settings.tsx   # App settings
│   ├── _layout.tsx        # Root layout + providers
│   ├── auth.tsx           # Login/signup
│   └── index.tsx          # Entry redirect
├── components/            # Reusable components
├── lib/                   # Utilities and config
├── assets/               # Images and fonts
└── package.json
```

## Next Steps

1. **Customize**: Modify colors in `tailwind.config.js`
2. **Add Features**: Extend screens in `app/(app)/`
3. **Configure**: Update `app.json` with your branding
4. **Deploy**: Build and submit to app stores

## Learn More

- [Expo Documentation](https://docs.expo.dev/)
- [Expo Router](https://docs.expo.dev/router/introduction/)
- [NativeWind](https://www.nativewind.dev/)
- [React Native](https://reactnative.dev/)
- [Supabase React Native](https://supabase.com/docs/guides/getting-started/tutorials/with-expo-react-native)

## Getting Help

- Check `README.md` for detailed documentation
- Review `NETWORK_CONFIGURATION.md` for network setup
- Open issues on GitHub
- Join MikroTik community forums

---

**Happy coding! 🚀**
