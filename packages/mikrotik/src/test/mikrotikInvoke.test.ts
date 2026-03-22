import { describe, it, expect, vi, beforeEach } from "vitest";

// Mock the supabase client
vi.mock("@repo/database", () => ({
  supabase: {
    functions: {
      invoke: vi.fn(),
    },
  },
}));

// Mock the connectionDebug module
vi.mock("../lib/connectionDebug", () => ({
  addConnectionDebug: vi.fn(),
}));

import { invokeMikrotik } from "../lib/invoke";
import { supabase } from "@repo/database";

const mockInvoke = supabase.functions.invoke as ReturnType<typeof vi.fn>;

describe("mikrotikInvoke", () => {
  beforeEach(() => {
    vi.clearAllMocks();
  });

  it("sends routerId to the Edge Function when provided", async () => {
    mockInvoke.mockResolvedValue({ data: { name: "Router1" }, error: null });

    await invokeMikrotik({
      endpoint: "/system/identity/print",
      routerId: "abc-123",
      host: "192.168.88.1",
      port: "443",
      protocol: "https",
      mode: "rest",
    });

    expect(mockInvoke).toHaveBeenCalledWith("mikrotik-api", {
      body: expect.objectContaining({ routerId: "abc-123" }),
    });
  });

  it("does NOT require host when routerId is provided", async () => {
    mockInvoke.mockResolvedValue({ data: {}, error: null });

    // Should not throw even without host
    await expect(
      invokeMikrotik({
        endpoint: "/system/identity/print",
        routerId: "abc-123",
      }),
    ).resolves.toBeDefined();
  });

  it("requires host when routerId is NOT provided", async () => {
    await expect(
      invokeMikrotik({
        endpoint: "/system/identity/print",
        host: "",
      }),
    ).rejects.toThrow();
  });

  it("passes direct credentials for add-router flow (no routerId)", async () => {
    mockInvoke.mockResolvedValue({ data: { name: "NewRouter" }, error: null });

    await invokeMikrotik({
      endpoint: "/system/identity/print",
      host: "10.0.0.1",
      user: "admin",
      pass: "test123",
      port: "8728",
      protocol: "api-plain",
      mode: "api",
    });

    expect(mockInvoke).toHaveBeenCalledWith("mikrotik-api", {
      body: expect.objectContaining({
        host: "10.0.0.1",
        user: "admin",
        pass: "test123",
      }),
    });

    // routerId should NOT be in the call
    const callBody = mockInvoke.mock.calls[0][1].body;
    expect(callBody.routerId).toBeUndefined();
  });

  it("throws on Edge Function error response", async () => {
    mockInvoke.mockResolvedValue({ data: null, error: { message: "Timeout" } });

    await expect(
      invokeMikrotik({
        endpoint: "/system/identity/print",
        routerId: "abc-123",
        host: "192.168.88.1",
      }),
    ).rejects.toThrow();
  });

  it("throws on data.error from Edge Function", async () => {
    mockInvoke.mockResolvedValue({ data: { error: "Auth failed" }, error: null });

    await expect(
      invokeMikrotik({
        endpoint: "/system/identity/print",
        routerId: "abc-123",
        host: "192.168.88.1",
      }),
    ).rejects.toThrow("Auth failed");
  });
});
