import { supabase } from "@repo/database";
import { NextRequest, NextResponse } from "next/server";

/**
 * Server-side proxy for MikroTik Edge Function calls.
 *
 * Performance benefit: The Next.js server (Vercel edge/serverless) calls the
 * Supabase Edge Function over the internal network — eliminating the
 * browser→Supabase round-trip latency that the client-side approach incurs.
 *
 * The client sends the same payload it would send to `supabase.functions.invoke`,
 * and this route forwards it to the Edge Function, returning the result.
 */

export async function POST(request: NextRequest) {
  try {
    const body = await request.json();

    const { data, error } = await supabase.functions.invoke("mikrotik-api", {
      body,
    });

    if (error) {
      return NextResponse.json(
        { error: error.message || "Edge function error" },
        { status: 502 }
      );
    }

    // Check for application-level error from the edge function
    if (data && typeof data === "object" && "error" in data) {
      return NextResponse.json(
        { error: (data as Record<string, unknown>).error },
        { status: 400 }
      );
    }

    return NextResponse.json(data);
  } catch (err: unknown) {
    const message = err instanceof Error ? err.message : "Internal server error";
    return NextResponse.json({ error: message }, { status: 500 });
  }
}
