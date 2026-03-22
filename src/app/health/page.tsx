'use client'
import ProtectedRoute from "@/components/ProtectedRoute"
import HealthPage from "@/page-components/HealthPage"
export default function HealthRoutePage() { return <ProtectedRoute><HealthPage /></ProtectedRoute> }
