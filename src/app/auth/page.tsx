'use client'
import { useAuth } from "@/contexts/AuthContext"
import { useRouter } from "next/navigation"
import { useEffect } from "react"
import AuthPage from "@/page-components/AuthPage"
import { Loader2 } from "lucide-react"

export default function AuthRoutePage() {
  const { user, loading } = useAuth()
  const router = useRouter()

  useEffect(() => {
    if (!loading && user) {
      router.replace('/routers')
    }
  }, [user, loading, router])

  if (loading) return <div className="min-h-screen bg-background flex items-center justify-center"><Loader2 className="h-8 w-8 animate-spin text-primary" /></div>
  if (user) return null

  return <AuthPage />
}
