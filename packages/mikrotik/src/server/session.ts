import { getIronSession, type SessionOptions } from "iron-session";
import { cookies } from "next/headers";
import type { RouterSessionData } from "./types";

function getSessionPassword(): string {
  if (process.env.ROUTER_SESSION_SECRET) {
    return process.env.ROUTER_SESSION_SECRET;
  }

  if (process.env.NODE_ENV === "production") {
    throw new Error("ROUTER_SESSION_SECRET environment variable must be set in production");
  }

  return "mums-router-session-key-must-be-at-least-32-characters-long";
}

export const routerSessionOptions: SessionOptions = {
  get password() {
    return getSessionPassword();
  },
  cookieName: "mums-router-session",
  cookieOptions: {
    secure: process.env.NODE_ENV === "production",
    httpOnly: true,
    sameSite: "lax" as const,
  },
};

export async function getRouterSession() {
  const cookieStore = await cookies();
  return getIronSession<RouterSessionData>(cookieStore, routerSessionOptions);
}
