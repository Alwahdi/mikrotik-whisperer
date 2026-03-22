import { test, expect } from "@playwright/test";

test.describe("Landing Page", () => {
  test("should load the landing page", async ({ page }) => {
    await page.goto("/");

    // Wait for the page to load
    await page.waitForLoadState("networkidle");

    // Check if the page is accessible
    await expect(page).toHaveTitle(/Mikrotik Whisperer|CoreRoute/);
  });

  test("should be responsive on mobile", async ({ page }) => {
    await page.setViewportSize({ width: 375, height: 667 });
    await page.goto("/");

    // Verify mobile layout
    await page.waitForLoadState("networkidle");
    await expect(page).toHaveURL("/");
  });
});
