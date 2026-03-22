'use client'
import ProtectedRoute from "@/components/ProtectedRoute"
import AdminUsersPage from "@/page-components/AdminUsersPage"
export default function AdminUsersRoutePage() { return <ProtectedRoute requireAdmin><AdminUsersPage /></ProtectedRoute> }
