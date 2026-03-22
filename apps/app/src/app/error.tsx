'use client'

import { useEffect } from 'react'
import { AlertTriangle } from 'lucide-react'
import { Button } from '@repo/design-system/components/ui/button'

export default function Error({
  error,
  reset,
}: {
  error: Error & { digest?: string }
  reset: () => void
}) {
  useEffect(() => {
    console.error('Application error:', error)
  }, [error])

  return (
    <div className="min-h-screen bg-background flex items-center justify-center p-4" dir="rtl">
      <div className="text-center space-y-4 max-w-md">
        <AlertTriangle className="h-12 w-12 text-destructive mx-auto" />
        <h2 className="text-xl font-semibold">حدث خطأ غير متوقع</h2>
        <p className="text-muted-foreground text-sm">
          {error.message || 'حدث خطأ أثناء تحميل الصفحة. يرجى المحاولة مرة أخرى.'}
        </p>
        <Button onClick={reset} variant="outline">
          إعادة المحاولة
        </Button>
      </div>
    </div>
  )
}
