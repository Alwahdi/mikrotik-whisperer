// Example: Premium Design System Showcase
// This file demonstrates all the premium UI/UX features available in @repo/design-system
// Copy these examples to your pages as needed

import { Button } from "@repo/design-system";
import { Card, CardHeader, CardTitle, CardDescription, CardContent, CardFooter } from "@repo/design-system";
import { Input } from "@repo/design-system";

// ============================================================================
// BUTTON EXAMPLES
// ============================================================================

export function ButtonShowcase() {
  return (
    <div className="space-y-8">
      {/* Variants */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Button Variants</h3>
        <div className="flex flex-wrap gap-3">
          <Button variant="default">Primary</Button>
          <Button variant="secondary">Secondary</Button>
          <Button variant="destructive">Destructive</Button>
          <Button variant="success">Success</Button>
          <Button variant="warning">Warning</Button>
          <Button variant="outline">Outline</Button>
          <Button variant="ghost">Ghost</Button>
          <Button variant="link">Link</Button>
        </div>
      </section>

      {/* Sizes */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Button Sizes</h3>
        <div className="flex items-center flex-wrap gap-3">
          <Button size="sm">Small</Button>
          <Button size="default">Default</Button>
          <Button size="lg">Large</Button>
        </div>
      </section>

      {/* Loading States */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Loading States</h3>
        <div className="flex flex-wrap gap-3">
          <Button loading>Loading...</Button>
          <Button loading variant="secondary">Processing</Button>
          <Button loading variant="success" loadingText="Saving...">Save</Button>
        </div>
      </section>

      {/* Icons */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Icon Buttons</h3>
        <div className="flex items-center flex-wrap gap-3">
          <Button size="icon-sm" variant="outline">
            <span className="sr-only">Small</span>
            ✓
          </Button>
          <Button size="icon" variant="default">
            <span className="sr-only">Default</span>
            +
          </Button>
          <Button size="icon-lg" variant="success">
            <span className="sr-only">Large</span>
            ✓
          </Button>
        </div>
      </section>
    </div>
  );
}

// ============================================================================
// CARD EXAMPLES
// ============================================================================

export function CardShowcase() {
  return (
    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
      {/* Default Card */}
      <Card variant="default">
        <CardHeader>
          <CardTitle>Default Card</CardTitle>
          <CardDescription>Standard card with subtle shadow</CardDescription>
        </CardHeader>
        <CardContent>
          <p className="text-sm text-muted-foreground">
            This is the default card variant with basic styling.
          </p>
        </CardContent>
        <CardFooter>
          <Button size="sm">Action</Button>
        </CardFooter>
      </Card>

      {/* Elevated Card */}
      <Card variant="elevated">
        <CardHeader>
          <CardTitle>Elevated Card</CardTitle>
          <CardDescription>Enhanced shadow on hover</CardDescription>
        </CardHeader>
        <CardContent>
          <p className="text-sm text-muted-foreground">
            Elevated cards have stronger shadows for emphasis.
          </p>
        </CardContent>
        <CardFooter>
          <Button variant="secondary" size="sm">Learn More</Button>
        </CardFooter>
      </Card>

      {/* Glass Card */}
      <Card variant="glass">
        <CardHeader>
          <CardTitle>Glass Card</CardTitle>
          <CardDescription>Glassmorphism effect</CardDescription>
        </CardHeader>
        <CardContent>
          <p className="text-sm text-muted-foreground">
            Modern glass effect with backdrop blur.
          </p>
        </CardContent>
        <CardFooter>
          <Button variant="outline" size="sm">Explore</Button>
        </CardFooter>
      </Card>

      {/* Interactive Card */}
      <Card variant="interactive" className="cursor-pointer">
        <CardHeader>
          <CardTitle>Interactive Card</CardTitle>
          <CardDescription>Clickable with hover effects</CardDescription>
        </CardHeader>
        <CardContent>
          <p className="text-sm text-muted-foreground">
            Scales on hover - perfect for clickable items.
          </p>
        </CardContent>
      </Card>

      {/* Outline Card */}
      <Card variant="outline">
        <CardHeader>
          <CardTitle>Outline Card</CardTitle>
          <CardDescription>Minimal with border focus</CardDescription>
        </CardHeader>
        <CardContent>
          <p className="text-sm text-muted-foreground">
            Clean outline style without shadows.
          </p>
        </CardContent>
      </Card>

      {/* Custom Padding */}
      <Card variant="default" padding="lg">
        <CardHeader>
          <CardTitle>Large Padding</CardTitle>
          <CardDescription>Spacious layout</CardDescription>
        </CardHeader>
        <CardContent>
          <p className="text-sm text-muted-foreground">
            Use padding variants for different layouts.
          </p>
        </CardContent>
      </Card>
    </div>
  );
}

// ============================================================================
// INPUT EXAMPLES
// ============================================================================

export function InputShowcase() {
  return (
    <div className="space-y-6 max-w-md">
      {/* Default Input */}
      <div>
        <label className="text-sm font-medium mb-2 block">Default Input</label>
        <Input variant="default" placeholder="Enter your email..." />
      </div>

      {/* Error State */}
      <div>
        <label className="text-sm font-medium mb-2 block">Error State</label>
        <Input variant="error" placeholder="Invalid email" />
        <p className="text-sm text-destructive mt-1">Please enter a valid email address</p>
      </div>

      {/* Success State */}
      <div>
        <label className="text-sm font-medium mb-2 block">Success State</label>
        <Input variant="success" placeholder="Valid email" />
        <p className="text-sm text-success mt-1">Email is valid!</p>
      </div>

      {/* Warning State */}
      <div>
        <label className="text-sm font-medium mb-2 block">Warning State</label>
        <Input variant="warning" placeholder="Temporary email detected" />
        <p className="text-sm text-warning mt-1">Consider using a permanent email</p>
      </div>

      {/* Disabled */}
      <div>
        <label className="text-sm font-medium mb-2 block">Disabled Input</label>
        <Input disabled placeholder="Disabled input" />
      </div>
    </div>
  );
}

// ============================================================================
// ANIMATION EXAMPLES
// ============================================================================

export function AnimationShowcase() {
  return (
    <div className="space-y-8">
      {/* Fade Animations */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Fade Animations</h3>
        <div className="flex gap-4">
          <div className="animate-fade-in p-4 bg-secondary rounded-lg">
            Fade In
          </div>
        </div>
      </section>

      {/* Slide Animations */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Slide Animations</h3>
        <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
          <div className="animate-slide-up p-4 bg-secondary rounded-lg text-center">
            Slide Up
          </div>
          <div className="animate-slide-down p-4 bg-secondary rounded-lg text-center">
            Slide Down
          </div>
          <div className="animate-slide-left p-4 bg-secondary rounded-lg text-center">
            Slide Left
          </div>
          <div className="animate-slide-right p-4 bg-secondary rounded-lg text-center">
            Slide Right
          </div>
        </div>
      </section>

      {/* Scale Animations */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Scale Animations</h3>
        <div className="flex gap-4">
          <div className="animate-scale-in p-4 bg-secondary rounded-lg">
            Scale In
          </div>
          <div className="animate-bounce-in p-4 bg-secondary rounded-lg">
            Bounce In
          </div>
        </div>
      </section>

      {/* Stagger Children */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Stagger Children</h3>
        <div className="stagger-children space-y-2">
          <div className="p-3 bg-secondary rounded-lg">Item 1</div>
          <div className="p-3 bg-secondary rounded-lg">Item 2</div>
          <div className="p-3 bg-secondary rounded-lg">Item 3</div>
          <div className="p-3 bg-secondary rounded-lg">Item 4</div>
        </div>
      </section>

      {/* Special Effects */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Special Effects</h3>
        <div className="grid grid-cols-2 gap-4">
          <div className="animate-pulse-glow p-6 bg-secondary rounded-lg text-center">
            Pulse Glow
          </div>
          <div className="animate-shimmer p-6 bg-secondary rounded-lg text-center">
            Shimmer
          </div>
        </div>
      </section>
    </div>
  );
}

// ============================================================================
// UTILITY CLASS EXAMPLES
// ============================================================================

export function UtilityShowcase() {
  return (
    <div className="space-y-8">
      {/* Glass Effects */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Glass Effects</h3>
        <div className="relative h-48 bg-gradient-to-br from-primary/20 to-accent/20 rounded-lg overflow-hidden">
          <div className="absolute inset-4">
            <div className="glass p-6 rounded-lg h-full">
              <h4 className="font-semibold mb-2">Standard Glass</h4>
              <p className="text-sm text-muted-foreground">
                Subtle glassmorphism effect
              </p>
            </div>
          </div>
        </div>
        <div className="relative h-48 bg-gradient-to-br from-primary/20 to-accent/20 rounded-lg overflow-hidden mt-4">
          <div className="absolute inset-4">
            <div className="glass-strong p-6 rounded-lg h-full">
              <h4 className="font-semibold mb-2">Strong Glass</h4>
              <p className="text-sm text-muted-foreground">
                Enhanced blur effect
              </p>
            </div>
          </div>
        </div>
      </section>

      {/* Gradients */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Gradients</h3>
        <div className="grid grid-cols-3 gap-4">
          <div className="gradient-primary p-6 rounded-lg text-primary-foreground text-center">
            Primary Gradient
          </div>
          <div className="gradient-accent p-6 rounded-lg text-accent-foreground text-center">
            Accent Gradient
          </div>
          <div className="gradient-mesh p-6 rounded-lg text-center border">
            Mesh Gradient
          </div>
        </div>
      </section>

      {/* Hover Effects */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Hover Effects</h3>
        <div className="grid grid-cols-2 gap-4">
          <Card variant="default" className="hover-lift">
            <CardContent className="pt-6">
              <p className="text-center">Hover Lift</p>
            </CardContent>
          </Card>
          <Card variant="default" className="hover-glow">
            <CardContent className="pt-6">
              <p className="text-center">Hover Glow</p>
            </CardContent>
          </Card>
        </div>
      </section>

      {/* Shadows */}
      <section>
        <h3 className="text-lg font-semibold mb-4">Custom Shadows</h3>
        <div className="grid grid-cols-3 gap-4">
          <div className="shadow-glow p-6 rounded-lg bg-card text-center">
            Glow Shadow
          </div>
          <div className="shadow-glow-lg p-6 rounded-lg bg-card text-center">
            Large Glow
          </div>
          <div className="shadow-inner-glow p-6 rounded-lg bg-card text-center">
            Inner Glow
          </div>
        </div>
      </section>
    </div>
  );
}

// ============================================================================
// COMPLETE PAGE EXAMPLE
// ============================================================================

export function PremiumPageExample() {
  return (
    <div className="container mx-auto p-6 space-y-12">
      {/* Hero Section with Glass Effect */}
      <section className="relative overflow-hidden rounded-2xl">
        <div className="absolute inset-0 gradient-mesh" />
        <div className="relative glass-strong p-12">
          <h1 className="text-4xl font-bold mb-4 animate-fade-in">
            Premium UI Components
          </h1>
          <p className="text-lg text-muted-foreground mb-6 animate-fade-in [animation-delay:100ms]">
            World-class design system with beautiful components and smooth animations
          </p>
          <div className="flex gap-3 animate-fade-in [animation-delay:200ms]">
            <Button size="lg">Get Started</Button>
            <Button size="lg" variant="outline">Learn More</Button>
          </div>
        </div>
      </section>

      {/* Feature Cards */}
      <section>
        <h2 className="text-2xl font-bold mb-6">Features</h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6 stagger-children">
          <Card variant="elevated" className="hover-lift">
            <CardHeader>
              <CardTitle>⚡ Fast</CardTitle>
              <CardDescription>Optimized for performance</CardDescription>
            </CardHeader>
            <CardContent>
              <p className="text-sm text-muted-foreground">
                Smooth animations and transitions with minimal overhead
              </p>
            </CardContent>
          </Card>

          <Card variant="elevated" className="hover-lift">
            <CardHeader>
              <CardTitle>🎨 Beautiful</CardTitle>
              <CardDescription>Premium design language</CardDescription>
            </CardHeader>
            <CardContent>
              <p className="text-sm text-muted-foreground">
                Carefully crafted components with attention to detail
              </p>
            </CardContent>
          </Card>

          <Card variant="elevated" className="hover-lift">
            <CardHeader>
              <CardTitle>♿ Accessible</CardTitle>
              <CardDescription>Built for everyone</CardDescription>
            </CardHeader>
            <CardContent>
              <p className="text-sm text-muted-foreground">
                WCAG compliant with keyboard navigation support
              </p>
            </CardContent>
          </Card>
        </div>
      </section>

      {/* Interactive Demo */}
      <section>
        <h2 className="text-2xl font-bold mb-6">Try It Out</h2>
        <Card variant="glass" className="max-w-2xl">
          <CardHeader>
            <CardTitle>Contact Form</CardTitle>
            <CardDescription>See the components in action</CardDescription>
          </CardHeader>
          <CardContent className="space-y-4">
            <div>
              <label className="text-sm font-medium mb-2 block">Name</label>
              <Input placeholder="Enter your name" />
            </div>
            <div>
              <label className="text-sm font-medium mb-2 block">Email</label>
              <Input type="email" placeholder="your@email.com" />
            </div>
            <div>
              <label className="text-sm font-medium mb-2 block">Message</label>
              <textarea
                className="flex min-h-[120px] w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 transition-all duration-200"
                placeholder="Your message..."
              />
            </div>
          </CardContent>
          <CardFooter className="gap-3">
            <Button className="flex-1">Send Message</Button>
            <Button variant="outline">Cancel</Button>
          </CardFooter>
        </Card>
      </section>
    </div>
  );
}
