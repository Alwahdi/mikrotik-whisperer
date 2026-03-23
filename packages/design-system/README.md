# @repo/design-system

> World-class design system for MikroTik Whisperer with premium UI/UX features

A comprehensive design system built on [shadcn/ui](https://ui.shadcn.com/) with enhanced components, animations, and utilities for creating beautiful, accessible, and performant user interfaces.

## Features

- 🎨 **Premium Components** - Enhanced with variants, states, and micro-interactions
- ✨ **Smooth Animations** - Carefully crafted animations and transitions
- 🎯 **Type-Safe** - Full TypeScript support with CVA for variant management
- 🌗 **Dark Mode Ready** - Complete dark mode support out of the box
- ♿ **Accessible** - Built on Radix UI primitives
- 🎭 **Themeable** - CSS variables for easy customization
- 📱 **Responsive** - Mobile-first approach

## Installation

This package is part of the monorepo and is automatically available to all apps:

```tsx
// Import components
import { Button, Card, Input } from "@repo/design-system";

// Import styles (in your root layout/app)
import "@repo/design-system/globals.css";
```

## Components

### Button

Enhanced button component with loading states and premium effects.

```tsx
import { Button } from "@repo/design-system";

// Variants
<Button variant="default">Primary</Button>
<Button variant="secondary">Secondary</Button>
<Button variant="destructive">Delete</Button>
<Button variant="success">Success</Button>
<Button variant="warning">Warning</Button>
<Button variant="outline">Outline</Button>
<Button variant="ghost">Ghost</Button>
<Button variant="link">Link</Button>

// Sizes
<Button size="sm">Small</Button>
<Button size="default">Default</Button>
<Button size="lg">Large</Button>
<Button size="icon">Icon</Button>
<Button size="icon-sm">Small Icon</Button>
<Button size="icon-lg">Large Icon</Button>

// Loading state
<Button loading>Processing...</Button>
<Button loading loadingText="Please wait...">Submit</Button>
```

**Features:**
- 8 variants with distinct visual hierarchy
- 6 size options including icon variants
- Built-in loading state with spinner
- Hover and active micro-interactions
- Shadow effects on hover

### Card

Flexible card component with premium variants and interactions.

```tsx
import { Card, CardHeader, CardTitle, CardDescription, CardContent, CardFooter } from "@repo/design-system";

// Variants
<Card variant="default">Default Card</Card>
<Card variant="elevated">Elevated with shadow</Card>
<Card variant="glass">Glassmorphism effect</Card>
<Card variant="interactive">Clickable with hover scale</Card>
<Card variant="outline">Outlined card</Card>

// Padding variants
<Card padding="none">No padding</Card>
<Card padding="sm">Small padding</Card>
<Card padding="md">Medium padding</Card>
<Card padding="lg">Large padding</Card>

// Full example
<Card variant="elevated">
  <CardHeader>
    <CardTitle>Card Title</CardTitle>
    <CardDescription>Card description goes here</CardDescription>
  </CardHeader>
  <CardContent>
    Main content
  </CardContent>
  <CardFooter>
    <Button>Action</Button>
  </CardFooter>
</Card>
```

**Features:**
- 5 visual variants
- 5 padding options
- Smooth hover transitions
- Interactive variant with scale effect
- Glassmorphism support

### Input

Enhanced input with validation state variants.

```tsx
import { Input } from "@repo/design-system";

// Variants
<Input variant="default" placeholder="Enter text..." />
<Input variant="error" placeholder="Error state" />
<Input variant="success" placeholder="Success state" />
<Input variant="warning" placeholder="Warning state" />

// With validation
<div>
  <Input
    variant={error ? "error" : "default"}
    placeholder="Email"
  />
  {error && <p className="text-sm text-destructive">{error}</p>}
</div>
```

**Features:**
- 4 validation state variants
- Color-coded focus rings
- Smooth transitions
- File input styling
- Disabled state handling

## Animations

### Built-in Animations

```tsx
// Fade animations
<div className="animate-fade-in">Fade in</div>
<div className="animate-fade-out">Fade out</div>

// Slide animations
<div className="animate-slide-up">Slide up</div>
<div className="animate-slide-down">Slide down</div>
<div className="animate-slide-left">Slide left</div>
<div className="animate-slide-right">Slide right</div>

// Scale animations
<div className="animate-scale-in">Scale in</div>
<div className="animate-scale-out">Scale out</div>

// Special effects
<div className="animate-bounce-in">Bounce in</div>
<div className="animate-shimmer">Shimmer effect</div>
<div className="animate-spin-slow">Slow spin</div>
<div className="animate-pulse-glow">Pulsing glow</div>

// Stagger children animation
<div className="stagger-children">
  <div>Item 1</div>
  <div>Item 2</div>
  <div>Item 3</div>
</div>
```

### Timing Functions

```tsx
// Custom easing
<div className="transition-all duration-300 ease-bounce-in">Bounce in</div>
<div className="transition-all duration-300 ease-bounce-out">Bounce out</div>
```

## Utility Classes

### Glass Effects

```tsx
// Standard glassmorphism
<div className="glass">Standard glass effect</div>

// Strong blur
<div className="glass-strong">Enhanced glass effect</div>
```

### Gradients

```tsx
<div className="gradient-primary">Primary gradient</div>
<div className="gradient-accent">Accent gradient</div>
<div className="gradient-mesh">Subtle mesh gradient</div>
```

### Hover Effects

```tsx
// Lift on hover
<div className="hover-lift">Lifts up with shadow</div>

// Glow on hover
<div className="hover-glow">Glows on hover</div>
```

### Shadows

```tsx
<div className="shadow-card">Card shadow</div>
<div className="shadow-glow">Primary glow</div>
<div className="shadow-glow-lg">Large glow</div>
<div className="shadow-inner-glow">Inner glow</div>
```

### Focus Ring

```tsx
<button className="focus-ring">Consistent focus ring</button>
```

### Text Balance

```tsx
<p className="text-balance">Balanced text wrapping</p>
```

## Theming

### CSS Variables

All colors are defined as CSS variables and support dark mode:

```css
:root {
  --background: 210 20% 98%;
  --foreground: 224 71% 4%;
  --primary: 221 83% 53%;
  --secondary: 220 14% 96%;
  --accent: 160 84% 39%;
  --destructive: 0 72% 51%;
  --warning: 38 92% 50%;
  --success: 160 84% 39%;
  --info: 221 83% 53%;
  /* ... and more */
}
```

### Customization

To customize the theme, update the CSS variables in your app's global CSS:

```css
:root {
  --primary: 270 80% 60%; /* Purple instead of blue */
  --radius: 0.75rem; /* Larger border radius */
}
```

## Tailwind Configuration

The design system extends Tailwind with custom values:

```js
// Spacing
spacing: {
  '128': '32rem',
  '144': '36rem',
}

// Shadows
boxShadow: {
  'glow': '0 0 20px -5px hsl(var(--primary) / 0.3)',
  'glow-lg': '0 0 30px -5px hsl(var(--primary) / 0.4)',
  'inner-glow': 'inset 0 0 20px -5px hsl(var(--primary) / 0.2)',
}

// Durations
transitionDuration: {
  '400': '400ms',
  '600': '600ms',
  '800': '800ms',
}

// Timing functions
transitionTimingFunction: {
  'bounce-in': 'cubic-bezier(0.68, -0.55, 0.265, 1.55)',
  'bounce-out': 'cubic-bezier(0.34, 1.56, 0.64, 1)',
}
```

## Best Practices

### Performance

1. Use `transition-all` sparingly - prefer specific properties:
   ```tsx
   // ❌ Avoid
   <div className="transition-all duration-300">

   // ✅ Better
   <div className="transition-[transform,box-shadow] duration-300">
   ```

2. Prefer CSS animations over JavaScript for better performance

3. Use `will-change` for animated elements:
   ```tsx
   <div className="hover-lift [will-change:transform]">
   ```

### Accessibility

1. Always provide focus states:
   ```tsx
   <button className="focus-ring">Button</button>
   ```

2. Use semantic variants:
   ```tsx
   <Input variant="error" aria-invalid="true" />
   ```

3. Ensure sufficient color contrast in custom themes

### Composition

Compose utilities for custom effects:

```tsx
// Premium card
<Card
  variant="elevated"
  className="hover-lift glass-strong border-0 animate-fade-in"
>
  Content
</Card>

// Interactive button
<Button
  variant="default"
  className="shadow-glow hover:shadow-glow-lg transition-all duration-300"
>
  Premium Action
</Button>
```

## Migration Guide

### From Basic shadcn/ui

If migrating from basic shadcn components:

1. **Button with loading:**
   ```tsx
   // Before
   <Button disabled={isLoading}>
     {isLoading && <Spinner />}
     Submit
   </Button>

   // After
   <Button loading={isLoading}>Submit</Button>
   ```

2. **Card variants:**
   ```tsx
   // Before
   <Card className="shadow-lg hover:shadow-xl transition-shadow">

   // After
   <Card variant="elevated">
   ```

3. **Input validation:**
   ```tsx
   // Before
   <Input className={error ? "border-red-500" : ""} />

   // After
   <Input variant={error ? "error" : "default"} />
   ```

## Contributing

When adding new components or utilities:

1. Use CVA for variant management
2. Export both component and variants
3. Support dark mode
4. Add TypeScript types
5. Include usage examples
6. Test accessibility
7. Document in this README

## Related Packages

- `@repo/ui` - Application-specific UI components
- `@repo/auth` - Authentication components
- `tailwindcss` - Utility-first CSS framework
- `class-variance-authority` - Type-safe variant management

---

**Built with ❤️ for the MikroTik Whisperer project**
