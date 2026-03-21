# MikroTik Whisperer

Professional MikroTik router management platform with both **Web** and **Mobile** applications.

## 🚀 Features

- **Multi-Platform**: Web application + Native mobile apps (iOS & Android)
- **Real-time Monitoring**: Dashboard with live statistics, CPU/memory usage, active users
- **Hotspot Management**: Active user monitoring, kick users, session tracking
- **User Manager**: Full CRUD operations, profiles, bulk operations
- **Voucher Generation**: Create vouchers with QR codes and PDF export
- **Sales Tracking**: Analytics and reporting with charts
- **Backup & Restore**: Full data backup and selective restore
- **Health Monitoring**: System health checks and diagnostics
- **Multi-Router Support**: Manage multiple MikroTik routers
- **Role-Based Access**: Admin and Cashier roles with different permissions
- **Dark Mode**: Full dark mode support on both platforms
- **Responsive Design**: Mobile-optimized web interface

## 📱 Mobile Application

The mobile app is built with **Expo** and **React Native**, providing a native experience on iOS and Android.

### Key Mobile Features
- ✅ Native iOS and Android apps
- ✅ Biometric authentication (Face ID/Fingerprint)
- ✅ Haptic feedback
- ✅ Pull-to-refresh
- ✅ Smooth animations with Reanimated
- ✅ Offline support (coming soon)
- ✅ Push notifications (coming soon)

### Mobile Quick Start

```sh
cd mobile
npm install --legacy-peer-deps
npm start
```

Then scan the QR code with Expo Go app, or:
- Press `i` for iOS Simulator (Mac only)
- Press `a` for Android Emulator
- Press `w` for Web browser

See [mobile/README.md](mobile/README.md) for detailed instructions.

## 🌐 Web Application

The web application is built with **React**, **TypeScript**, and **Vite**.

## CoreRoute Runtime Modes

This project now supports two MikroTik runtime paths automatically:

- Local LAN target (192.168.x.x / 10.x.x.x / 172.16-31.x.x / localhost): uses CoreRoute Local Agent
- Public IP or DNS target: uses cloud bridge via Supabase Edge Function

At app startup, when the selected router is local LAN, the UI checks if the agent is running:

- If running: shows Local Agent running
- If down: shows install/start instructions in-app with one-click installer download
- Shows current agent version and update availability (from release manifest)

### Web Quick Start

```sh
# install web deps
npm install

# install agent deps
npm run agent:install

# run web + agent together
npm run dev:all
```

Agent default URL: http://127.0.0.1:3001

You can override it with:

- VITE_MIKROTIK_AGENT_URL
- Or from Settings page (CoreRoute Local Agent section)

Advanced operations page:

- /health (service readiness, per-service latency, agent runtime diagnostics)

## 🏗️ Project Structure

```
mikrotik-whisperer/
├── mobile/              # Expo/React Native mobile app
│   ├── app/            # Expo Router screens
│   ├── components/     # Reusable components
│   ├── contexts/       # React contexts
│   └── lib/           # Utilities and config
├── src/                # Web application
│   ├── components/     # React components
│   ├── pages/         # Page components
│   ├── hooks/         # Custom hooks
│   └── integrations/  # Supabase integration
├── agent/             # Local agent for LAN routers
└── supabase/          # Supabase backend
```

## 🛠️ Technology Stack

### Web
- React 18 + TypeScript
- Vite
- Shadcn/ui + Radix UI
- Tailwind CSS
- React Query (TanStack Query)
- React Router v6
- Supabase (Auth + Database)

### Mobile
- Expo SDK 55
- React Native
- TypeScript
- Expo Router (file-based routing)
- React Query
- React Native Reanimated
- React Native Gesture Handler
- Supabase

### Backend
- Supabase (PostgreSQL + Auth + Edge Functions)
- Local Node.js agent for LAN connectivity

## 📦 Installation

### Prerequisites
- Node.js 18+ and npm
- Expo CLI (for mobile): `npm install -g expo-cli`
- iOS Simulator (Mac only) or Android Emulator (for mobile testing)

### Web Setup
```sh
# Clone the repository
git clone <YOUR_GIT_URL>
cd mikrotik-whisperer

# Install dependencies
npm install

# Set up environment variables
cp .env.example .env
# Edit .env with your Supabase credentials

# Run the development server
npm run dev
```

### Mobile Setup
```sh
cd mobile

# Install dependencies
npm install --legacy-peer-deps

# Set up environment variables
cp .env.example .env
# Edit .env with your Supabase credentials

# Start the development server
npm start
```

## 🔐 Environment Variables

Create `.env` files in both root and mobile directories:

```env
VITE_SUPABASE_URL=your_supabase_url
VITE_SUPABASE_ANON_KEY=your_supabase_anon_key
```

For mobile (`mobile/.env`):
```env
EXPO_PUBLIC_SUPABASE_URL=your_supabase_url
EXPO_PUBLIC_SUPABASE_ANON_KEY=your_supabase_anon_key
```

## 🚢 Deployment

### Web Deployment
Simply open [Lovable](https://lovable.dev/projects/REPLACE_WITH_PROJECT_ID) and click on Share -> Publish.

Or deploy manually to Vercel, Netlify, or any static hosting service:
```sh
npm run build
# Upload dist/ directory to your hosting service
```

### Mobile Deployment

#### iOS (requires Mac)
```sh
cd mobile
eas build --platform ios
```

#### Android
```sh
cd mobile
eas build --platform android
```

## 📖 Documentation

- [Mobile App Documentation](mobile/README.md)
- [Agent Signing Setup](docs/agent-signing.md)
- [Supabase Setup](supabase/README.md)

## 🎨 Design System

Both platforms share a consistent design language:
- **Colors**: Primary (Sky Blue), Secondary (Purple), Success (Green), Destructive (Red)
- **Spacing**: 4px base unit (xs: 4, sm: 8, md: 16, lg: 24, xl: 32)
- **Typography**: Responsive font sizes with clear hierarchy
- **Dark Mode**: Full support with automatic system detection
- **Animations**: Smooth transitions with haptic feedback on mobile

## 🤝 Contributing

1. Create a feature branch
2. Make your changes
3. Test on both web and mobile
4. Submit a pull request

## 📄 License

MIT License - see LICENSE file for details

## 💬 Support

For issues or questions:
- Open an issue on GitHub
- Contact support@mikrotikwhisperer.com

---

Built with ❤️ using React, Expo, and Supabase
