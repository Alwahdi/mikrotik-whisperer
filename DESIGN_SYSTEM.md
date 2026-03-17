# Design System Documentation

## Premium UI/UX Design System - MikroTik Whisperer

This document outlines the world-class design system implemented for both web and mobile applications.

---

## Table of Contents

1. [Design Tokens](#design-tokens)
2. [Color System](#color-system)
3. [Typography](#typography)
4. [Spacing & Layout](#spacing--layout)
5. [Elevation & Shadows](#elevation--shadows)
6. [Components](#components)
7. [Animations](#animations)
8. [Usage Examples](#usage-examples)

---

## Design Tokens

### Web (CSS Variables)

#### Colors
```css
/* Primary with states */
--primary: 221 83% 53%;
--primary-hover: 221 83% 48%;
--primary-active: 221 83% 43%;

/* Semantic colors */
--success: 160 84% 39%;
--warning: 38 92% 50%;
--destructive: 0 72% 51%;
--info: 221 83% 53%;
```

#### Shadows (7-level system)
```css
--shadow-xs: Minimal elevation
--shadow-sm: Small components
--shadow-md: Cards, buttons
--shadow-lg: Modals, dropdowns
--shadow-xl: Large overlays
--shadow-2xl: Maximum depth
--shadow-card: Optimized for card components
--shadow-inner: Inset effects
```

#### Glow Effects
```css
--glow-primary: Premium primary glow
--glow-success: Success state glow
--glow-warning: Warning state glow
```

#### Animation Durations
```css
--duration-instant: 100ms
--duration-fast: 150ms
--duration-normal: 200ms
--duration-slow: 300ms
--duration-slower: 500ms
```

#### Easing Functions
```css
--ease-default: cubic-bezier(0.4, 0, 0.2, 1)
--ease-in: cubic-bezier(0.4, 0, 1, 1)
--ease-out: cubic-bezier(0, 0, 0.2, 1)
--ease-in-out: cubic-bezier(0.4, 0, 0.2, 1)
--ease-bounce: cubic-bezier(0.68, -0.55, 0.265, 1.55)
--ease-spring: cubic-bezier(0.175, 0.885, 0.32, 1.275)
```

### Mobile (Theme Constants)

```typescript
import { Colors, Shadows, Spacing, Radius, Animations } from '@/lib/theme';

// Colors
Colors.primary        // Primary brand color
Colors.success        // Success green
Colors.warning        // Warning amber
Colors.destructive    // Destructive red
Colors.info           // Info blue

// Spacing scale
Spacing.xs  // 4px
Spacing.sm  // 8px
Spacing.md  // 12px
Spacing.lg  // 16px
Spacing.xl  // 20px
Spacing['2xl'] // 24px
Spacing['3xl'] // 32px
Spacing['4xl'] // 40px
Spacing['5xl'] // 48px

// Shadow elevation
Shadows.xs   // Minimal
Shadows.sm   // Small
Shadows.md   // Medium
Shadows.lg   // Large (with primary glow)
Shadows.xl   // Extra large
Shadows['2xl'] // Maximum

// Animation
Animations.duration.fast    // 150ms
Animations.duration.normal  // 200ms
Animations.spring           // Spring config
Animations.springBounce     // Bouncy spring
```

---

## Color System

### Light Mode
- **Background**: Clean white (#FFFFFF)
- **Foreground**: Dark text (HSL 220 15% 10%)
- **Card**: Pure white with subtle shadows
- **Muted**: Light gray (HSL 220 14% 96%)

### Dark Mode
- **Background**: Deep dark (HSL 224 71% 4%)
- **Foreground**: Light text (HSL 210 20% 98%)
- **Card**: Elevated dark (HSL 222 47% 11%)
- **Muted**: Subtle dark (HSL 215 28% 17%)

### Semantic Colors

#### Success (Green)
- Light: HSL 160 84% 39%
- Dark: HSL 160 84% 45%
- Use for: Confirmations, success messages, positive actions

#### Warning (Amber)
- Light: HSL 38 92% 50%
- Dark: HSL 38 92% 58%
- Use for: Warnings, cautions, important notices

#### Destructive (Red)
- Light: HSL 0 72% 51%
- Dark: HSL 0 72% 58%
- Use for: Errors, deletions, critical actions

#### Info (Blue)
- Light: HSL 221 83% 53%
- Dark: HSL 221 83% 65%
- Use for: Informational messages, tips, neutral actions

---

## Typography

### Font Families
- **Sans**: Inter, Cairo (RTL support)
- **Mono**: JetBrains Mono

### Font Scale (Web - Tailwind)
```tsx
text-xs   // 0.75rem (12px)
text-sm   // 0.875rem (14px)
text-base // 1rem (16px)
text-lg   // 1.125rem (18px)
text-xl   // 1.25rem (20px)
text-2xl  // 1.5rem (24px)
text-3xl  // 1.875rem (30px)
```

### Font Scale (Mobile)
```typescript
FontSizes.xs   // 11px
FontSizes.sm   // 13px
FontSizes.base // 15px
FontSizes.lg   // 17px
FontSizes.xl   // 19px
FontSizes['2xl'] // 23px
FontSizes['3xl'] // 27px
FontSizes['4xl'] // 31px
```

### Font Weights
- **Light**: 300
- **Regular**: 400
- **Medium**: 500
- **Semibold**: 600
- **Bold**: 700
- **Extrabold**: 800

---

## Spacing & Layout

### Spacing Scale
```
xs:  4px   (0.25rem)
sm:  8px   (0.5rem)
md:  12px  (0.75rem)
lg:  16px  (1rem)
xl:  20px  (1.25rem)
2xl: 24px  (1.5rem)
3xl: 32px  (2rem)
4xl: 40px  (2.5rem)
5xl: 48px  (3rem)
```

### Border Radius
```
sm:  0.375rem (6px)
md:  0.5rem   (8px)
lg:  0.75rem  (12px)
xl:  1rem     (16px)
2xl: 1.5rem   (24px)
full: 9999px  (pill shape)
```

---

## Elevation & Shadows

### Shadow System

#### Extra Small (xs)
- Use for: Subtle elevation, dividers
- Example: Form inputs, subtle cards

#### Small (sm)
- Use for: Small components, chips, badges
- Example: Tags, small cards

#### Medium (md)
- Use for: Standard cards, buttons
- Example: Content cards, raised buttons

#### Large (lg)
- Use for: Modals, dropdowns, popovers
- Example: Dialog boxes, menu panels

#### Extra Large (xl)
- Use for: Large overlays, sheets
- Example: Bottom sheets, large modals

#### 2XL
- Use for: Maximum elevation effects
- Example: Full-screen overlays

### Glow Effects

Apply to interactive elements for premium feel:
```tsx
<Button className="hover:shadow-glow-primary">
  Premium Action
</Button>
```

---

## Components

### Button

#### Variants
```tsx
<Button variant="default">Default</Button>
<Button variant="destructive">Delete</Button>
<Button variant="outline">Outline</Button>
<Button variant="secondary">Secondary</Button>
<Button variant="ghost">Ghost</Button>
<Button variant="link">Link</Button>
<Button variant="success">Success</Button>
<Button variant="warning">Warning</Button>
<Button variant="info">Info</Button>
<Button variant="gradient">Gradient</Button>
```

#### Sizes
```tsx
<Button size="sm">Small</Button>
<Button size="default">Default</Button>
<Button size="lg">Large</Button>
<Button size="icon"><Icon /></Button>
```

### Card

#### Variants
```tsx
<Card variant="default">Standard card</Card>
<Card variant="elevated">Elevated card</Card>
<Card variant="interactive">Clickable card</Card>
<Card variant="glass">Glassmorphism</Card>
<Card variant="outline">Outlined card</Card>
```

### StatCard

Enhanced statistics display with trend indicators:

```tsx
<StatCard
  title="Active Users"
  value="1,234"
  subtitle="Last 24 hours"
  icon={Users}
  variant="primary"
  trend={{ value: 12.5, isPositive: true }}
/>
```

Variants: `default`, `primary`, `accent`, `warning`, `success`, `info`

### ActionCard

Call-to-action focused cards:

```tsx
<ActionCard
  title="Connect Router"
  description="Add a new MikroTik router to your dashboard"
  icon={Plus}
  iconColor="text-primary"
  variant="elevated"
  action={{
    label: "Add Router",
    onClick: handleAdd,
    variant: "default"
  }}
/>
```

### DataCard

Display multiple data points in organized layouts:

```tsx
<DataCard
  title="System Overview"
  subtitle="Real-time metrics"
  variant="default"
  layout="grid"
  data={[
    { label: "CPU Usage", value: "45%", icon: Cpu, trend: { value: 5, isPositive: false } },
    { label: "Memory", value: "2.1 GB", icon: HardDrive },
    { label: "Uptime", value: "15d 4h", icon: Clock },
    { label: "Clients", value: "234", icon: Users, trend: { value: 12, isPositive: true } }
  ]}
/>
```

### Input

Enhanced with validation states:

```tsx
<Input placeholder="Email" variant="default" />
<Input placeholder="Valid input" variant="success" />
<Input placeholder="Invalid input" variant="error" />
```

### Alert

Rich feedback with icons and dismissible option:

```tsx
<Alert variant="info" dismissible onDismiss={handleDismiss}>
  <AlertTitle>Information</AlertTitle>
  <AlertDescription>
    This is an informational message.
  </AlertDescription>
</Alert>

<Alert variant="success">
  <AlertTitle>Success!</AlertTitle>
  <AlertDescription>Your changes have been saved.</AlertDescription>
</Alert>

<Alert variant="warning">
  <AlertTitle>Warning</AlertTitle>
  <AlertDescription>Please review before proceeding.</AlertDescription>
</Alert>

<Alert variant="destructive">
  <AlertTitle>Error</AlertTitle>
  <AlertDescription>Something went wrong.</AlertDescription>
</Alert>
```

### EmptyState

Enhanced empty state component:

```tsx
<EmptyState
  icon={Inbox}
  title="No messages"
  description="You don't have any messages yet"
  actionLabel="Compose Message"
  onAction={handleCompose}
  variant="default"
/>

<EmptyState
  icon={AlertCircle}
  title="Error Loading Data"
  description="Unable to fetch data from the server"
  variant="error"
/>

<EmptyState
  icon={Search}
  title="No results"
  description="Try adjusting your search"
  variant="compact"
/>
```

### Loading States

#### Skeleton (with shimmer)
```tsx
<Skeleton className="h-24 w-full rounded-lg" />
```

#### Loading Spinner
```tsx
<LoadingSpinner size="md" variant="primary" text="Loading..." />
```

#### Loading View
```tsx
<LoadingView text="Fetching data..." variant="primary" />
```

---

## Animations

### Keyframes

#### fade-in-up
Gentle upward fade animation
```tsx
<div className="animate-fade-in-up">Content</div>
```

#### slide-up
Slide from bottom with fade
```tsx
<div className="animate-slide-up">Content</div>
```

#### scale-in
Scale from 95% to 100% with fade
```tsx
<div className="animate-scale-in">Content</div>
```

#### shimmer
Shimmer effect for skeletons
```tsx
<div className="before:animate-shimmer">Content</div>
```

### Utility Classes

#### Glassmorphism
```tsx
<div className="glass">Standard glass</div>
<div className="glass-strong">Strong blur</div>
<div className="glass-light">Light blur</div>
```

#### Gradients
```tsx
<div className="gradient-primary">Primary gradient</div>
<div className="gradient-accent">Accent gradient</div>
<div className="gradient-mesh">Mesh gradient background</div>
<span className="gradient-text">Gradient text</span>
```

#### Hover Effects
```tsx
<div className="hover-lift">Lifts on hover</div>
<div className="hover-glow">Glows on hover</div>
<div className="hover-scale">Scales on hover</div>
```

#### Press Effects
```tsx
<button className="press-scale">Scales down on click</button>
```

---

## Usage Examples

### Premium Card with Stats

```tsx
import { Card } from "@/components/ui/card";
import StatCard from "@/components/StatCard";
import { Users, Activity, TrendingUp, Server } from "lucide-react";

function Dashboard() {
  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4 stagger-children">
      <StatCard
        title="Total Users"
        value="2,543"
        subtitle="+12% from last month"
        icon={Users}
        variant="primary"
        trend={{ value: 12, isPositive: true }}
      />
      <StatCard
        title="Active Sessions"
        value="184"
        subtitle="Currently online"
        icon={Activity}
        variant="success"
        trend={{ value: 8, isPositive: true }}
      />
      <StatCard
        title="Bandwidth"
        value="45.2 GB"
        subtitle="This month"
        icon={TrendingUp}
        variant="info"
      />
      <StatCard
        title="Uptime"
        value="99.9%"
        subtitle="Last 30 days"
        icon={Server}
        variant="default"
      />
    </div>
  );
}
```

### Interactive Data Card

```tsx
import { DataCard } from "@/components/ui/data-card";
import { Cpu, HardDrive, Zap, Wifi } from "lucide-react";

<DataCard
  title="Router Performance"
  subtitle="Real-time system metrics"
  variant="elevated"
  layout="grid"
  headerAction={
    <Button variant="ghost" size="sm">
      Refresh
    </Button>
  }
  data={[
    {
      label: "CPU Load",
      value: "34%",
      icon: Cpu,
      trend: { value: 5, isPositive: false }
    },
    {
      label: "Memory Usage",
      value: "2.1 GB",
      icon: HardDrive,
    },
    {
      label: "Power",
      value: "12.5W",
      icon: Zap,
    },
    {
      label: "Signal",
      value: "-65 dBm",
      icon: Wifi,
      trend: { value: 2, isPositive: true }
    }
  ]}
/>
```

### Loading State Pattern

```tsx
import { LoadingView } from "@/components/ui/loading-spinner";
import { EmptyState } from "@/components/EmptyState";
import { Alert, AlertTitle, AlertDescription } from "@/components/ui/alert";

function DataList() {
  const { data, isLoading, error } = useQuery();

  if (isLoading) {
    return <LoadingView text="Fetching routers..." variant="primary" />;
  }

  if (error) {
    return (
      <Alert variant="destructive" dismissible>
        <AlertTitle>Error</AlertTitle>
        <AlertDescription>{error.message}</AlertDescription>
      </Alert>
    );
  }

  if (!data?.length) {
    return (
      <EmptyState
        icon={Router}
        title="No routers found"
        description="Add your first MikroTik router to get started"
        actionLabel="Add Router"
        onAction={() => navigate("/add")}
      />
    );
  }

  return <div>{/* Render data */}</div>;
}
```

---

## Accessibility

### Color Contrast
All color combinations meet WCAG AA standards:
- Light mode: 4.5:1 for normal text, 3:1 for large text
- Dark mode: Enhanced contrast ratios for better readability

### Focus States
All interactive elements have visible focus indicators:
```tsx
focus-visible:outline-none
focus-visible:ring-2
focus-visible:ring-ring
focus-visible:ring-offset-2
```

### Keyboard Navigation
All components support full keyboard navigation:
- Tab/Shift+Tab for focus
- Enter/Space for activation
- Escape for dismissing modals/alerts
- Arrow keys for navigation where applicable

### Screen Readers
- Proper ARIA labels and roles
- Semantic HTML structure
- Live regions for dynamic updates

---

## Performance

### Optimizations
- CSS variables for runtime theme switching
- Minimal JavaScript for animations (CSS-based)
- Tree-shakeable component imports
- Optimized shadow and blur effects
- Hardware-accelerated transforms

### Best Practices
1. Use `transition-all` sparingly, prefer specific properties
2. Leverage `will-change` for expensive animations
3. Use `backdrop-filter` with fallbacks
4. Implement skeleton loaders for perceived performance
5. Lazy load heavy components

---

## Mobile-Specific Guidelines

### Touch Targets
Minimum touch target size: 44x44 px
```typescript
// Button sizes already optimized
<Button size="sm">  // 36px height (9 * 4)
<Button size="default">  // 40px height (10 * 4)
<Button size="lg">  // 44px height (11 * 4)
```

### Gestures
- Swipe gestures for navigation
- Pull-to-refresh patterns
- Long-press for context menus
- Haptic feedback on interactions

### Safe Areas
All mobile components respect safe area insets:
```typescript
import { useSafeAreaInsets } from 'react-native-safe-area-context';

const insets = useSafeAreaInsets();
paddingTop: insets.top
```

---

## Future Enhancements

### Planned Features
- [ ] Color theme generator
- [ ] Component playground/Storybook
- [ ] High contrast mode
- [ ] Motion reduction preferences
- [ ] Custom font loading optimization
- [ ] Component composition patterns
- [ ] Advanced micro-interactions library

---

**Version**: 1.0.0
**Last Updated**: 2026-03-17
**Maintained by**: Development Team
