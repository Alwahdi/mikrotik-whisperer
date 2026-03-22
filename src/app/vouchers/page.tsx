'use client'
import ProtectedRoute from "@/components/ProtectedRoute"
import VouchersPage from "@/page-components/VouchersPage"
export default function VouchersRoutePage() { return <ProtectedRoute><VouchersPage /></ProtectedRoute> }
