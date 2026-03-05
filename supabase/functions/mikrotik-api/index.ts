import { serve } from "https://deno.land/std@0.168.0/http/server.ts";

const corsHeaders = {
  "Access-Control-Allow-Origin": "*",
  "Access-Control-Allow-Headers":
    "authorization, x-client-info, apikey, content-type, x-supabase-client-platform, x-supabase-client-platform-version, x-supabase-client-runtime, x-supabase-client-runtime-version",
};

serve(async (req) => {
  if (req.method === "OPTIONS") {
    return new Response(null, { headers: corsHeaders });
  }

  try {
    const MIKROTIK_HOST = Deno.env.get("MIKROTIK_HOST");
    const MIKROTIK_USER = Deno.env.get("MIKROTIK_USER");
    const MIKROTIK_PASS = Deno.env.get("MIKROTIK_PASS");
    const MIKROTIK_PORT = Deno.env.get("MIKROTIK_PORT") || "443";
    const MIKROTIK_PROTOCOL = Deno.env.get("MIKROTIK_PROTOCOL") || "https";

    if (!MIKROTIK_HOST) {
      throw new Error("MIKROTIK_HOST is not configured");
    }
    if (!MIKROTIK_USER) {
      throw new Error("MIKROTIK_USER is not configured");
    }
    if (!MIKROTIK_PASS) {
      throw new Error("MIKROTIK_PASS is not configured");
    }

    const { endpoint } = await req.json();
    if (!endpoint) {
      throw new Error("Missing 'endpoint' in request body");
    }

    const baseUrl = `${MIKROTIK_PROTOCOL}://${MIKROTIK_HOST}:${MIKROTIK_PORT}/rest`;
    const url = `${baseUrl}${endpoint}`;

    const credentials = btoa(`${MIKROTIK_USER}:${MIKROTIK_PASS}`);

    const response = await fetch(url, {
      method: "GET",
      headers: {
        Authorization: `Basic ${credentials}`,
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      const errorText = await response.text();
      throw new Error(
        `MikroTik API error [${response.status}]: ${errorText}`
      );
    }

    const data = await response.json();

    return new Response(JSON.stringify(data), {
      headers: { ...corsHeaders, "Content-Type": "application/json" },
    });
  } catch (error: unknown) {
    console.error("MikroTik API error:", error);
    const message = error instanceof Error ? error.message : "Unknown error";
    return new Response(JSON.stringify({ error: message }), {
      status: 500,
      headers: { ...corsHeaders, "Content-Type": "application/json" },
    });
  }
});
