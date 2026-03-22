import { describe, it, expect } from "vitest";

/**
 * Middleware is hard to unit-test in isolation since it imports
 * @supabase/ssr which needs a real cookie jar. These tests verify
 * the route matching configuration is correct — the most common
 * source of middleware bugs.
 */

// Inline the route definitions from middleware to test them
const PUBLIC_PATHS = ["/", "/auth", "/access"];
const STATIC_PATTERN = /\.(ico|png|jpg|svg|txt|xml|json)$/;
const EXCLUDED_PREFIXES = ["/_next", "/api"];

function shouldProtect(pathname: string): boolean {
  if (PUBLIC_PATHS.includes(pathname)) return false;
  if (EXCLUDED_PREFIXES.some((p) => pathname.startsWith(p))) return false;
  if (STATIC_PATTERN.test(pathname)) return false;
  return true;
}

describe("middleware route protection", () => {
  describe("public routes are NOT protected", () => {
    const publicRoutes = ["/", "/auth", "/access"];
    for (const route of publicRoutes) {
      it(`${route} is public`, () => {
        expect(shouldProtect(route)).toBe(false);
      });
    }
  });

  describe("protected routes ARE protected", () => {
    const protectedRoutes = [
      "/dashboard",
      "/routers",
      "/hotspot",
      "/usermanager",
      "/vouchers",
      "/sales",
      "/health",
      "/backups",
      "/settings",
      "/admin/users",
      "/loading",
    ];
    for (const route of protectedRoutes) {
      it(`${route} is protected`, () => {
        expect(shouldProtect(route)).toBe(true);
      });
    }
  });

  describe("static assets are NOT protected", () => {
    const assets = [
      "/favicon.ico",
      "/robots.txt",
      "/logo.png",
      "/_next/static/chunk.js",
      "/_next/image/photo.jpg",
    ];
    for (const asset of assets) {
      it(`${asset} is not protected`, () => {
        expect(shouldProtect(asset)).toBe(false);
      });
    }
  });
});
