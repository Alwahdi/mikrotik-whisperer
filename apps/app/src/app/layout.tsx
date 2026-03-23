import type { Metadata, Viewport } from 'next'
import '@repo/design-system/globals.css'
import './globals.css'
import Providers from './providers'

export const viewport: Viewport = {
  width: 'device-width',
  initialScale: 1,
  maximumScale: 1,
  userScalable: false,
  viewportFit: 'cover',
  themeColor: [
    { media: '(prefers-color-scheme: light)', color: '#fafafa' },
    { media: '(prefers-color-scheme: dark)', color: '#121212' },
  ],
}

export const metadata: Metadata = {
  title: 'MikroTik Manager',
  description: 'لوحة تحكم متكاملة لإدارة أجهزة المايكروتيك',
}

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="ar" dir="rtl" suppressHydrationWarning>
      <body>
        <Providers>
          {children}
        </Providers>
      </body>
    </html>
  )
}
