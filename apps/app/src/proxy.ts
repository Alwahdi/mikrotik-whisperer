export { proxy } from '@repo/auth/middleware'

export const config = {
  matcher: [
    '/((?!_next/static|_next/image|favicon.ico|robots.txt|downloads).*)',
  ],
}
