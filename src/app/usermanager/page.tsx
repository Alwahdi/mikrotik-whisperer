'use client'
import ProtectedRoute from "@/components/ProtectedRoute"
import UserManagerPage from "@/page-components/UserManagerPage"
export default function UserManagerRoutePage() { return <ProtectedRoute><UserManagerPage /></ProtectedRoute> }
