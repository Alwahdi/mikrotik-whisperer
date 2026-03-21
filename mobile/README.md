# MikroTik Whisperer Mobile App

A professional mobile application for managing MikroTik routers built with Expo and React Native.

## Features

### Authentication & User Management
- ✅ Secure authentication with Supabase
- ✅ Role-based access (Admin/Cashier)
- ✅ User profile management
- ✅ Biometric authentication support (Face ID/Fingerprint)

### Router Management
- ✅ Multiple router support
- ✅ Router selection and configuration
- ✅ Connection status monitoring
- ✅ API and REST mode support

### Dashboard
- ✅ Real-time system statistics
- ✅ CPU and memory monitoring
- ✅ Active user count
- ✅ System uptime tracking
- ✅ Sales summary
- ✅ Traffic overview

### Hotspot Management
- ✅ Active user list with search
- ✅ User session monitoring
- ✅ Kick active users
- ✅ Real-time updates
- ✅ Download/upload statistics

### User Manager
- ✅ User CRUD operations
- ✅ Profile management
- ✅ Enable/disable users
- ✅ Search and filter
- ✅ User comments and notes

### Additional Features
- ✅ Voucher generation (with QR codes)
- ✅ Sales tracking and analytics
- ✅ Backup and restore
- ✅ Health monitoring
- ✅ Settings and preferences
- ✅ Dark mode support
- ✅ Haptic feedback
- ✅ Pull-to-refresh
- ✅ Smooth animations

## Technology Stack

- **Framework**: Expo SDK 55
- **Language**: TypeScript
- **Navigation**: Expo Router (file-based routing)
- **UI**: React Native with custom design system
- **State Management**: React Query + Context API
- **Backend**: Supabase (Auth + Database)
- **Storage**: AsyncStorage + Secure Store
- **Icons**: Ionicons
- **Animations**: React Native Reanimated
- **Gestures**: React Native Gesture Handler
- **Platform**: iOS, Android, Web

## Getting Started

### Prerequisites

- Node.js 18+ and npm
- Expo CLI (`npm install -g expo-cli`)
- iOS Simulator (Mac only) or Android Emulator
- Expo Go app on your phone (for testing)

### Installation

1. Navigate to the mobile directory:
```bash
cd mobile
```

2. Install dependencies:
```bash
npm install --legacy-peer-deps
```

3. Configure environment variables:
```bash
cp .env.example .env
```

Edit `.env` and add your Supabase credentials:
```
EXPO_PUBLIC_SUPABASE_URL=your_supabase_url
EXPO_PUBLIC_SUPABASE_ANON_KEY=your_supabase_anon_key
```

### Running the App

Start the development server:
```bash
npm start
```

Then:
- Press `i` for iOS Simulator (Mac only)
- Press `a` for Android Emulator
- Press `w` for Web browser
- Scan QR code with Expo Go app on your phone

### Platform-Specific Commands

```bash
# iOS
npm run ios

# Android
npm run android

# Web
npm run web
```

## Project Structure

```
mobile/
├── app/                    # Expo Router screens
│   ├── (app)/             # Authenticated app screens
│   │   ├── _layout.tsx   # Tab navigation
│   │   ├── routers.tsx   # Router selection
│   │   ├── dashboard.tsx # Dashboard
│   │   ├── hotspot.tsx   # Hotspot management
│   │   ├── usermanager.tsx # User management
│   │   └── more.tsx      # Settings & more
│   ├── _layout.tsx       # Root layout
│   ├── index.tsx         # Entry point
│   └── auth.tsx          # Authentication
├── components/           # Reusable components
│   ├── Card.tsx
│   ├── Button.tsx
│   └── ...
├── contexts/            # React contexts
│   └── AuthContext.tsx
├── lib/                 # Utilities & config
│   ├── theme.ts        # Design system
│   └── supabase.ts     # Supabase client
├── assets/             # Images, fonts, etc.
├── app.json           # Expo config
├── package.json       # Dependencies
└── tsconfig.json      # TypeScript config
```

## Design System

The app uses a comprehensive design system with:

- **Colors**: Light and dark mode support
- **Spacing**: Consistent spacing scale (4px base unit)
- **Typography**: Responsive font sizes
- **Shadows**: Elevation system for depth
- **Border Radius**: Consistent corner radii
- **Animations**: Smooth transitions and feedback

All theme values are defined in `lib/theme.ts` and automatically adapt to the system color scheme.

## Key Features Implementation

### Authentication Flow
The app uses Supabase for authentication with automatic session management. The flow:
1. User enters credentials
2. Supabase validates and creates session
3. Session stored in AsyncStorage (encrypted on device)
4. Profile fetched from database
5. User redirected to app

### Navigation
File-based routing with Expo Router:
- `index.tsx` - Auth check and redirect
- `auth.tsx` - Login/signup
- `(app)/` - Tab navigation for authenticated users

### State Management
- **React Query**: Server state, caching, and mutations
- **Context API**: Authentication and user profile
- **AsyncStorage**: Local persistence
- **Secure Store**: Sensitive data (tokens, biometrics)

## Building for Production

### iOS (requires Mac)
```bash
eas build --platform ios
```

### Android
```bash
eas build --platform android
```

## Environment Variables

Create a `.env` file with:

```env
EXPO_PUBLIC_SUPABASE_URL=https://your-project.supabase.co
EXPO_PUBLIC_SUPABASE_ANON_KEY=your-anon-key
```

## Contributing

1. Create a feature branch
2. Make your changes
3. Test on iOS, Android, and Web
4. Submit a pull request

## License

MIT License - see LICENSE file for details

## Support

For issues or questions:
- Open an issue on GitHub
- Contact support@mikrotikwhisperer.com

---

Built with ❤️ using Expo and React Native
