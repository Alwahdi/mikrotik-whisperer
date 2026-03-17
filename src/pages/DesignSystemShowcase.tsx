import { Button } from "@/components/ui/button";
import { Card, CardHeader, CardTitle, CardDescription, CardContent } from "@/components/ui/card";
import { Alert, AlertTitle, AlertDescription } from "@/components/ui/alert";
import { Input } from "@/components/ui/input";
import { ActionCard } from "@/components/ui/action-card";
import { DataCard } from "@/components/ui/data-card";
import StatCard from "@/components/StatCard";
import EmptyState from "@/components/EmptyState";
import { LoadingSpinner, LoadingView } from "@/components/ui/loading-spinner";
import { Skeleton } from "@/components/ui/skeleton";
import {
  Users,
  Activity,
  TrendingUp,
  Server,
  Cpu,
  HardDrive,
  Zap,
  Wifi,
  Plus,
  Inbox,
  AlertCircle,
  CheckCircle,
} from "lucide-react";

/**
 * Design System Showcase
 *
 * This page demonstrates all the enhanced UI components
 * with their variants and usage patterns.
 *
 * Use this as a reference for implementing consistent
 * UI patterns across the application.
 */
export default function DesignSystemShowcase() {
  return (
    <div className="min-h-screen bg-background p-8 space-y-12">
      {/* Header */}
      <div className="max-w-7xl mx-auto">
        <h1 className="text-4xl font-bold text-foreground mb-2 gradient-text">
          Design System Showcase
        </h1>
        <p className="text-muted-foreground">
          Premium UI/UX components with world-class design standards
        </p>
      </div>

      {/* Color Palette */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Color Palette</h2>
        <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
          <div className="space-y-2">
            <div className="h-24 rounded-lg bg-primary shadow-md" />
            <p className="text-sm font-medium">Primary</p>
          </div>
          <div className="space-y-2">
            <div className="h-24 rounded-lg bg-success shadow-md" />
            <p className="text-sm font-medium">Success</p>
          </div>
          <div className="space-y-2">
            <div className="h-24 rounded-lg bg-warning shadow-md" />
            <p className="text-sm font-medium">Warning</p>
          </div>
          <div className="space-y-2">
            <div className="h-24 rounded-lg bg-destructive shadow-md" />
            <p className="text-sm font-medium">Destructive</p>
          </div>
          <div className="space-y-2">
            <div className="h-24 rounded-lg bg-info shadow-md" />
            <p className="text-sm font-medium">Info</p>
          </div>
          <div className="space-y-2">
            <div className="h-24 rounded-lg bg-muted border shadow-sm" />
            <p className="text-sm font-medium">Muted</p>
          </div>
          <div className="space-y-2">
            <div className="h-24 rounded-lg glass shadow-md" />
            <p className="text-sm font-medium">Glass</p>
          </div>
          <div className="space-y-2">
            <div className="h-24 rounded-lg gradient-primary shadow-md" />
            <p className="text-sm font-medium">Gradient</p>
          </div>
        </div>
      </section>

      {/* Buttons */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Buttons</h2>
        <div className="space-y-4">
          <div className="flex flex-wrap gap-3">
            <Button variant="default">Default</Button>
            <Button variant="destructive">Destructive</Button>
            <Button variant="outline">Outline</Button>
            <Button variant="secondary">Secondary</Button>
            <Button variant="ghost">Ghost</Button>
            <Button variant="link">Link</Button>
          </div>
          <div className="flex flex-wrap gap-3">
            <Button variant="success">Success</Button>
            <Button variant="warning">Warning</Button>
            <Button variant="info">Info</Button>
            <Button variant="gradient">Gradient</Button>
          </div>
          <div className="flex flex-wrap gap-3 items-center">
            <Button size="sm">Small</Button>
            <Button size="default">Default</Button>
            <Button size="lg">Large</Button>
            <Button size="icon">
              <Plus className="h-4 w-4" />
            </Button>
          </div>
        </div>
      </section>

      {/* Cards */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Card Variants</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
          <Card variant="default">
            <CardHeader>
              <CardTitle>Default Card</CardTitle>
              <CardDescription>Standard elevation and styling</CardDescription>
            </CardHeader>
            <CardContent>
              <p className="text-sm text-muted-foreground">
                This is the default card variant with subtle shadows.
              </p>
            </CardContent>
          </Card>

          <Card variant="elevated">
            <CardHeader>
              <CardTitle>Elevated Card</CardTitle>
              <CardDescription>Enhanced shadow depth</CardDescription>
            </CardHeader>
            <CardContent>
              <p className="text-sm text-muted-foreground">
                This card has increased elevation for emphasis.
              </p>
            </CardContent>
          </Card>

          <Card variant="interactive">
            <CardHeader>
              <CardTitle>Interactive Card</CardTitle>
              <CardDescription>Hover to see effect</CardDescription>
            </CardHeader>
            <CardContent>
              <p className="text-sm text-muted-foreground">
                This card responds to hover with lift animation.
              </p>
            </CardContent>
          </Card>

          <Card variant="glass">
            <CardHeader>
              <CardTitle>Glass Card</CardTitle>
              <CardDescription>Glassmorphism effect</CardDescription>
            </CardHeader>
            <CardContent>
              <p className="text-sm text-muted-foreground">
                Backdrop blur creates a premium glass effect.
              </p>
            </CardContent>
          </Card>

          <Card variant="outline">
            <CardHeader>
              <CardTitle>Outline Card</CardTitle>
              <CardDescription>Border emphasis</CardDescription>
            </CardHeader>
            <CardContent>
              <p className="text-sm text-muted-foreground">
                No shadow, border highlight on hover.
              </p>
            </CardContent>
          </Card>
        </div>
      </section>

      {/* StatCards */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Statistics Cards</h2>
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
            title="Error Rate"
            value="2.1%"
            subtitle="Increased from 1.8%"
            icon={Server}
            variant="warning"
            trend={{ value: 0.3, isPositive: false }}
          />
        </div>
      </section>

      {/* ActionCards */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Action Cards</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          <ActionCard
            title="Add New Router"
            description="Connect a new MikroTik router to your dashboard and start monitoring its performance."
            icon={Plus}
            iconColor="text-primary"
            variant="elevated"
            action={{
              label: "Add Router",
              onClick: () => alert("Add router clicked"),
              variant: "default",
            }}
          />
          <ActionCard
            title="System Health Check"
            description="Run a comprehensive diagnostic to ensure all routers are operating optimally."
            icon={Activity}
            iconColor="text-success"
            variant="interactive"
            action={{
              label: "Run Diagnostics",
              onClick: () => alert("Diagnostics clicked"),
              variant: "success",
            }}
          />
        </div>
      </section>

      {/* DataCards */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Data Cards</h2>
        <div className="grid grid-cols-1 lg:grid-cols-2 gap-4">
          <DataCard
            title="Router Performance"
            subtitle="Real-time system metrics"
            variant="elevated"
            layout="grid"
            data={[
              {
                label: "CPU Load",
                value: "34%",
                icon: Cpu,
                trend: { value: 5, isPositive: false },
              },
              {
                label: "Memory Usage",
                value: "2.1 GB",
                icon: HardDrive,
              },
              {
                label: "Power Draw",
                value: "12.5W",
                icon: Zap,
              },
              {
                label: "Signal Strength",
                value: "-65 dBm",
                icon: Wifi,
                trend: { value: 2, isPositive: true },
              },
            ]}
          />

          <DataCard
            title="Network Overview"
            subtitle="Current statistics"
            variant="default"
            layout="list"
            data={[
              { label: "Active Clients", value: "234", icon: Users },
              { label: "Throughput", value: "1.2 Gbps", icon: Activity },
              { label: "Packets/sec", value: "45.2K", icon: TrendingUp },
            ]}
          />
        </div>
      </section>

      {/* Alerts */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Alerts</h2>
        <div className="space-y-4 max-w-2xl">
          <Alert variant="info" dismissible>
            <AlertTitle>Information</AlertTitle>
            <AlertDescription>
              This is an informational message with dismissible functionality.
            </AlertDescription>
          </Alert>

          <Alert variant="success">
            <AlertTitle>Success!</AlertTitle>
            <AlertDescription>
              Your router configuration has been saved successfully.
            </AlertDescription>
          </Alert>

          <Alert variant="warning">
            <AlertTitle>Warning</AlertTitle>
            <AlertDescription>
              CPU usage is approaching 80%. Consider reviewing active processes.
            </AlertDescription>
          </Alert>

          <Alert variant="destructive">
            <AlertTitle>Error</AlertTitle>
            <AlertDescription>
              Failed to connect to router. Please check your network connection.
            </AlertDescription>
          </Alert>
        </div>
      </section>

      {/* Inputs */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Input Fields</h2>
        <div className="space-y-4 max-w-md">
          <div>
            <label className="text-sm font-medium mb-2 block">Default Input</label>
            <Input placeholder="Enter text..." variant="default" />
          </div>
          <div>
            <label className="text-sm font-medium mb-2 block text-success">
              Valid Input
            </label>
            <Input placeholder="valid@email.com" variant="success" />
          </div>
          <div>
            <label className="text-sm font-medium mb-2 block text-destructive">
              Error Input
            </label>
            <Input placeholder="invalid input" variant="error" />
          </div>
        </div>
      </section>

      {/* Empty States */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Empty States</h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
          <Card>
            <CardContent className="p-0">
              <EmptyState
                icon={Inbox}
                title="No messages"
                description="You don't have any messages yet"
                actionLabel="Compose"
                onAction={() => alert("Compose clicked")}
                variant="default"
              />
            </CardContent>
          </Card>

          <Card>
            <CardContent className="p-0">
              <EmptyState
                icon={AlertCircle}
                title="Error Loading"
                description="Unable to fetch data"
                variant="error"
              />
            </CardContent>
          </Card>

          <Card>
            <CardContent className="p-0">
              <EmptyState
                icon={CheckCircle}
                title="All Clear"
                description="Everything is working perfectly"
                variant="compact"
              />
            </CardContent>
          </Card>
        </div>
      </section>

      {/* Loading States */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Loading States</h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
          <Card>
            <CardHeader>
              <CardTitle>Loading Spinner</CardTitle>
            </CardHeader>
            <CardContent className="flex justify-center">
              <LoadingSpinner size="md" variant="primary" text="Loading..." />
            </CardContent>
          </Card>

          <Card>
            <CardHeader>
              <CardTitle>Skeleton Loader</CardTitle>
            </CardHeader>
            <CardContent className="space-y-3">
              <Skeleton className="h-4 w-full" />
              <Skeleton className="h-4 w-3/4" />
              <Skeleton className="h-4 w-1/2" />
            </CardContent>
          </Card>

          <Card>
            <CardHeader>
              <CardTitle>Success Spinner</CardTitle>
            </CardHeader>
            <CardContent className="flex justify-center">
              <LoadingSpinner size="lg" variant="success" />
            </CardContent>
          </Card>
        </div>
      </section>

      {/* Utility Classes */}
      <section className="max-w-7xl mx-auto">
        <h2 className="text-2xl font-bold mb-6">Utility Classes</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
          <Card className="hover-lift">
            <CardContent className="p-6">
              <p className="text-sm font-medium">hover-lift</p>
              <p className="text-xs text-muted-foreground mt-2">
                Hover to see lift effect
              </p>
            </CardContent>
          </Card>

          <Card className="hover-glow">
            <CardContent className="p-6">
              <p className="text-sm font-medium">hover-glow</p>
              <p className="text-xs text-muted-foreground mt-2">
                Hover to see glow effect
              </p>
            </CardContent>
          </Card>

          <Card className="hover-scale">
            <CardContent className="p-6">
              <p className="text-sm font-medium">hover-scale</p>
              <p className="text-xs text-muted-foreground mt-2">
                Hover to see scale effect
              </p>
            </CardContent>
          </Card>

          <div className="glass p-6 rounded-lg">
            <p className="text-sm font-medium">glass</p>
            <p className="text-xs text-muted-foreground mt-2">
              Glassmorphism effect
            </p>
          </div>

          <div className="gradient-primary p-6 rounded-lg text-white">
            <p className="text-sm font-medium">gradient-primary</p>
            <p className="text-xs opacity-90 mt-2">Primary gradient</p>
          </div>

          <div className="gradient-mesh p-6 rounded-lg border">
            <p className="text-sm font-medium">gradient-mesh</p>
            <p className="text-xs text-muted-foreground mt-2">Mesh background</p>
          </div>
        </div>
      </section>

      {/* Animations */}
      <section className="max-w-7xl mx-auto pb-12">
        <h2 className="text-2xl font-bold mb-6">Animations</h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4 stagger-children">
          <Card className="animate-fade-in">
            <CardContent className="p-6">
              <p className="text-sm font-medium">fade-in</p>
              <p className="text-xs text-muted-foreground mt-2">
                Gentle fade animation
              </p>
            </CardContent>
          </Card>

          <Card className="animate-slide-up">
            <CardContent className="p-6">
              <p className="text-sm font-medium">slide-up</p>
              <p className="text-xs text-muted-foreground mt-2">
                Slide from bottom
              </p>
            </CardContent>
          </Card>

          <Card className="animate-scale-in">
            <CardContent className="p-6">
              <p className="text-sm font-medium">scale-in</p>
              <p className="text-xs text-muted-foreground mt-2">
                Scale with fade
              </p>
            </CardContent>
          </Card>
        </div>
      </section>
    </div>
  );
}
