'use client'
import ProtectedRoute from "@/components/ProtectedRoute"
import Index from "@/page-components/Index"
export default function DashboardPage() { return <ProtectedRoute><Index /></ProtectedRoute> }
