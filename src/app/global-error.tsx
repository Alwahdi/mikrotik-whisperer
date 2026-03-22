'use client'

export default function GlobalError({
  error,
  reset,
}: {
  error: Error & { digest?: string }
  reset: () => void
}) {
  return (
    <html lang="ar" dir="rtl">
      <body>
        <div style={{ minHeight: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center', fontFamily: 'system-ui, sans-serif' }}>
          <div style={{ textAlign: 'center', maxWidth: 400, padding: 24 }}>
            <h2 style={{ fontSize: 20, marginBottom: 8 }}>حدث خطأ في التطبيق</h2>
            <p style={{ color: '#666', fontSize: 14, marginBottom: 16 }}>
              {error.message || 'يرجى تحديث الصفحة أو المحاولة لاحقاً.'}
            </p>
            <button
              onClick={reset}
              style={{ padding: '8px 16px', border: '1px solid #ccc', borderRadius: 6, cursor: 'pointer', background: 'white' }}
            >
              إعادة المحاولة
            </button>
          </div>
        </div>
      </body>
    </html>
  )
}
