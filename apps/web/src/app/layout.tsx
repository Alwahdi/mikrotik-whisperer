import type { Metadata } from 'next'
import '@repo/design-system/globals.css'

export const metadata: Metadata = {
  title: 'MikroTik Manager',
  description: 'لوحة تحكم متكاملة لإدارة أجهزة المايكروتيك',
}

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="ar" dir="rtl">
      <body>{children}</body>
    </html>
  )
}
