'use client'

import { Toaster } from "@repo/design-system/components/ui/toaster"
import { Toaster as Sonner } from "@repo/design-system/components/ui/sonner"
import { TooltipProvider } from "@repo/design-system/components/ui/tooltip"
import { QueryClient, QueryClientProvider } from "@tanstack/react-query"
import { AuthProvider } from "@repo/auth"
import { clearActiveRouter, clearConnectionDebugEntries } from "@repo/mikrotik"
import LiveQueuePanel from "@/components/LiveQueuePanel"
import ConnectionDebugDrawer from "@/components/ConnectionDebugDrawer"
import { Analytics } from "@vercel/analytics/react"
import { useState, useCallback } from "react"

export default function Providers({ children }: { children: React.ReactNode }) {
  const [queryClient] = useState(() => new QueryClient())
  const handleSignOut = useCallback(() => {
    clearActiveRouter();
    clearConnectionDebugEntries();
  }, []);
  
  return (
    <QueryClientProvider client={queryClient}>
      <TooltipProvider>
        <Toaster />
        <Sonner />
        <LiveQueuePanel />
        <ConnectionDebugDrawer />
        <AuthProvider onSignOut={handleSignOut}>
          {children}
        </AuthProvider>
        <Analytics />
      </TooltipProvider>
    </QueryClientProvider>
  )
}
