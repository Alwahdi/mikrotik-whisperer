'use client'

import { Toaster } from "@/components/ui/toaster"
import { Toaster as Sonner } from "@/components/ui/sonner"
import { TooltipProvider } from "@/components/ui/tooltip"
import { QueryClient, QueryClientProvider } from "@tanstack/react-query"
import { AuthProvider } from "@/contexts/AuthContext"
import LiveQueuePanel from "@/components/LiveQueuePanel"
import ConnectionDebugDrawer from "@/components/ConnectionDebugDrawer"
import AgentRuntimeBanner from "@/components/AgentRuntimeBanner"
import { Analytics } from "@vercel/analytics/react"
import { useState } from "react"

export default function Providers({ children }: { children: React.ReactNode }) {
  const [queryClient] = useState(() => new QueryClient())
  
  return (
    <QueryClientProvider client={queryClient}>
      <TooltipProvider>
        <Toaster />
        <Sonner />
        <LiveQueuePanel />
        <ConnectionDebugDrawer />
        <AuthProvider>
          <AgentRuntimeBanner />
          {children}
        </AuthProvider>
        <Analytics />
      </TooltipProvider>
    </QueryClientProvider>
  )
}
