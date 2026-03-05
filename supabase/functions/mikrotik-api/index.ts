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
    const { endpoint, host, user, pass, port, protocol } = await req.json();

    if (!host) throw new Error("Missing 'host'");
    if (!user) throw new Error("Missing 'user'");
    if (!pass) throw new Error("Missing 'pass'");
    if (!endpoint) throw new Error("Missing 'endpoint'");

    const actualPort = port || "443";
    const actualProtocol = protocol || "https";

    const baseUrl = `${actualProtocol}://${host}:${actualPort}/rest`;
    const url = `${baseUrl}${endpoint}`;

    const credentials = btoa(`${user}:${pass}`);

    const response = await fetch(url, {
      method: "GET",
      headers: {
        Authorization: `Basic ${credentials}`,
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      const errorText = await response.text();
      throw new Error(`MikroTik API error [${response.status}]: ${errorText}`);
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
