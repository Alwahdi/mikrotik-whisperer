# Architecture Overview

## System Architecture

MikroTik Whisperer is built using a modern monorepo architecture with clear separation of concerns.

### High-Level Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                        Client Layer                          │
├──────────────────────────┬──────────────────────────────────┤
│   Web App (Next.js)     │    Mobile App (Expo)             │
│   - Server Components   │    - React Native                 │
│   - Client Components   │    - Native Features              │
│   - API Routes          │    - Offline Support              │
└──────────────────────────┴──────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                    Shared Packages Layer                     │
├──────────────────────────┬──────────────────────────────────┤
│   @mikrotik-whisperer/ui │ @mikrotik-whisperer/utils        │
│   @mikrotik-whisperer/   │ @mikrotik-whisperer/tsconfig     │
│   eslint-config          │                                   │
└──────────────────────────┴──────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                      Backend Services                        │
├──────────────────────────┬──────────────────────────────────┤
│   Supabase (Database)   │    MikroTik API                   │
│   - PostgreSQL          │    - RouterOS API                 │
│   - Auth                │    - Real-time Updates            │
│   - Storage             │                                   │
└──────────────────────────┴──────────────────────────────────┘
```

## Monorepo Structure

### Apps

#### `/apps/web` - Next.js Application

- **Framework**: Next.js 16 with App Router
- **Rendering**: Server-side + Client-side
- **Features**:
  - Server Components for optimal performance
  - Server Actions for mutations
  - Streaming and Suspense
  - Edge runtime support
  - Built-in API routes

#### `/apps/mobile` - Expo Application (Existing)

- **Framework**: Expo/React Native
- **Features**:
  - Native mobile experience
  - Offline-first architecture
  - Push notifications
  - Native device features

### Packages

#### `@mikrotik-whisperer/ui`

Design system and reusable UI components.

**Key Features**:

- Built on Radix UI primitives
- Full TypeScript support
- Tailwind CSS styling
- Dark/Light mode support
- Accessibility built-in

**Components**:

- Buttons, Inputs, Forms
- Cards, Modals, Dialogs
- Navigation components
- Data display components

#### `@mikrotik-whisperer/utils`

Shared utility functions.

**Features**:

- Date/time formatting
- Currency formatting
- Data transformation
- Debouncing/throttling
- Type-safe helpers

#### `@mikrotik-whisperer/eslint-config`

Shared ESLint configurations.

**Configs**:

- `eslint-next.js` - For Next.js apps
- `eslint-react.js` - For React libraries

#### `@mikrotik-whisperer/tsconfig`

Shared TypeScript configurations.

**Configs**:

- `base.json` - Base config
- `nextjs.json` - Next.js specific
- `react-library.json` - React libraries

## Data Flow

### Server Components (Next.js)

```
User Request → Next.js Server → Data Fetch → RSC Payload → Browser
                                     ↓
                                 Supabase
                                 MikroTik API
```

### Client Components

```
User Interaction → React Query → API Route → External API
                        ↓
                    Cache Layer
                        ↓
                   Local State
```

## State Management

### Server State

- **TanStack Query** (React Query)
  - Data fetching
  - Caching
  - Background updates
  - Optimistic updates

### Client State

- **React Hooks** (useState, useContext)
  - UI state
  - Form state
  - Local preferences

### URL State

- **Next.js Router**
  - Navigation state
  - Search params
  - Route params

## Performance Strategy

### Server-Side

- Server Components for static content
- Streaming for progressive rendering
- Edge runtime for low latency
- Incremental Static Regeneration

### Client-Side

- Code splitting by route
- Dynamic imports for heavy components
- Image optimization with next/image
- Font optimization

### Caching Strategy

- Server cache (Next.js)
- CDN cache (Vercel Edge)
- Browser cache
- React Query cache

## Security

### Authentication

- Supabase Auth
- JWT tokens
- Row Level Security (RLS)
- Protected routes

### Data Protection

- Environment variables
- Secure headers
- CORS configuration
- Input validation (Zod)

## Deployment

### Production Environment

- **Platform**: Vercel
- **Database**: Supabase (PostgreSQL)
- **CDN**: Vercel Edge Network
- **Analytics**: Vercel Analytics

### Build Process

```
Code Push → GitHub Actions → Tests → Build → Deploy → Edge Network
                ↓              ↓        ↓
           Lint Check    Type Check  Bundle
```

## Scalability

### Horizontal Scaling

- Serverless functions (auto-scale)
- Edge network distribution
- Database connection pooling

### Vertical Optimization

- Bundle size optimization
- Tree shaking
- Code splitting
- Lazy loading

## Monitoring & Observability

### Metrics

- Core Web Vitals
- Error tracking
- Performance monitoring
- User analytics

### Logging

- Server logs
- Client errors
- API calls
- Database queries

## Future Enhancements

1. **Microservices**: Extract complex business logic
2. **GraphQL**: Unified API layer
3. **WebSockets**: Real-time updates
4. **Service Workers**: Offline support
5. **E2E Testing**: Playwright/Cypress
