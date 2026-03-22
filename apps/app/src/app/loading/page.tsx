'use client'
import ProtectedRoute from "@/components/ProtectedRoute"
import RouterDataLoader from "@/components/RouterDataLoader"
export default function LoadingRoutePage() { return <ProtectedRoute><RouterDataLoader /></ProtectedRoute> }
