import { describe, it, expect, beforeEach, vi } from "vitest";

// Mock localStorage
const store: Record<string, string> = {};
const localStorageMock = {
  getItem: vi.fn((key: string) => store[key] ?? null),
  setItem: vi.fn((key: string, value: string) => { store[key] = value; }),
  removeItem: vi.fn((key: string) => { delete store[key]; }),
  clear: vi.fn(() => { for (const k of Object.keys(store)) delete store[k]; }),
  length: 0,
  key: vi.fn(() => null),
};
Object.defineProperty(globalThis, "localStorage", { value: localStorageMock });

import {
  getActiveRouter,
  setActiveRouter,
  clearActiveRouter,
  getDefaultPort,
  getProtocolOptions,
  type ActiveRouter,
} from "../lib/config";

describe("mikrotikConfig", () => {
  beforeEach(() => {
    localStorageMock.clear();
    vi.clearAllMocks();
  });

  const validRouter: ActiveRouter = {
    routerId: "abc-123",
    host: "192.168.88.1",
    port: "443",
    label: "Office Router",
    mode: "rest",
    protocol: "https",
  };

  // ── Security: No credentials stored ──────────────────────
  describe("credential security", () => {
    it("should NOT store user or pass in localStorage", () => {
      setActiveRouter(validRouter);
      const storedRaw = store["mikrotik_active_router"];
      expect(storedRaw).toBeDefined();
      expect(storedRaw).not.toContain("user");
      expect(storedRaw).not.toContain("pass");
      expect(storedRaw).not.toContain("password");
      expect(storedRaw).not.toContain("admin");
    });

    it("returned ActiveRouter should have no credential fields", () => {
      setActiveRouter(validRouter);
      const result = getActiveRouter();
      expect(result).toBeDefined();
      // Type system prevents this, but verify at runtime
      expect("user" in result!).toBe(false);
      expect("pass" in result!).toBe(false);
      expect("password" in result!).toBe(false);
    });

    it("should clear legacy credential storage on setActiveRouter", () => {
      store["mikrotik_config"] = JSON.stringify({ host: "x", user: "admin", pass: "secret" });
      setActiveRouter(validRouter);
      expect(localStorageMock.removeItem).toHaveBeenCalledWith("mikrotik_config");
    });
  });

  // ── getActiveRouter ──────────────────────────────────────
  describe("getActiveRouter", () => {
    it("returns null when nothing is stored", () => {
      expect(getActiveRouter()).toBeNull();
    });

    it("returns the stored router", () => {
      setActiveRouter(validRouter);
      expect(getActiveRouter()).toEqual(validRouter);
    });

    it("returns null for invalid JSON", () => {
      store["mikrotik_active_router"] = "not json";
      expect(getActiveRouter()).toBeNull();
    });

    it("returns null when routerId is missing", () => {
      store["mikrotik_active_router"] = JSON.stringify({ host: "x" });
      expect(getActiveRouter()).toBeNull();
    });

    it("returns null when host is missing", () => {
      store["mikrotik_active_router"] = JSON.stringify({ routerId: "123" });
      expect(getActiveRouter()).toBeNull();
    });
  });

  // ── clearActiveRouter ────────────────────────────────────
  describe("clearActiveRouter", () => {
    it("removes active router key", () => {
      setActiveRouter(validRouter);
      clearActiveRouter();
      expect(getActiveRouter()).toBeNull();
    });

    it("also removes legacy key", () => {
      store["mikrotik_config"] = "legacy";
      clearActiveRouter();
      expect(localStorageMock.removeItem).toHaveBeenCalledWith("mikrotik_config");
    });
  });

  // ── Utility functions ────────────────────────────────────
  describe("getDefaultPort", () => {
    it("returns 443 for rest + https", () => {
      expect(getDefaultPort("rest", "https")).toBe("443");
    });

    it("returns 80 for rest + http", () => {
      expect(getDefaultPort("rest", "http")).toBe("80");
    });

    it("returns 8729 for api + api-ssl", () => {
      expect(getDefaultPort("api", "api-ssl")).toBe("8729");
    });

    it("returns 8728 for api + api-plain", () => {
      expect(getDefaultPort("api", "api-plain")).toBe("8728");
    });
  });

  describe("getProtocolOptions", () => {
    it("returns REST options for rest mode", () => {
      const opts = getProtocolOptions("rest");
      expect(opts).toHaveLength(2);
      expect(opts.map(o => o.value)).toEqual(["https", "http"]);
    });

    it("returns API options for api mode", () => {
      const opts = getProtocolOptions("api");
      expect(opts).toHaveLength(2);
      expect(opts.map(o => o.value)).toEqual(["api-plain", "api-ssl"]);
    });
  });
});
