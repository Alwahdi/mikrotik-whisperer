'use client'
import ProtectedRoute from "@/components/ProtectedRoute"
import SettingsPage from "@/page-components/SettingsPage"
export default function SettingsRoutePage() { return <ProtectedRoute><SettingsPage /></ProtectedRoute> }
