import { serve } from "https://deno.land/std@0.168.0/http/server.ts";
import { createClient } from "https://esm.sh/@supabase/supabase-js@2";

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
    const authHeader = req.headers.get("Authorization");
    const supabaseUrl = Deno.env.get("SUPABASE_URL")!;
    const supabaseKey = Deno.env.get("SUPABASE_SERVICE_ROLE_KEY")!;
    const supabase = createClient(supabaseUrl, supabaseKey);

    // Get user from auth header
    let userId: string | null = null;
    if (authHeader) {
      const anonKey = Deno.env.get("SUPABASE_ANON_KEY")!;
      const userClient = createClient(supabaseUrl, anonKey, {
        global: { headers: { Authorization: authHeader } },
      });
      const { data: { user } } = await userClient.auth.getUser();
      userId = user?.id || null;
    }

    const body = await req.json();
    const { action, router_id, router_label, backup_id } = body;

    // ─── CREATE BACKUP ──────────────────────────────────────────
    if (action === "create") {
      if (!userId) throw new Error("Authentication required");
      if (!router_id) throw new Error("Router ID required");

      // Get router config
      const { data: router, error: routerErr } = await supabase
        .from("routers")
        .select("*")
        .eq("id", router_id)
        .eq("user_id", userId)
        .single();

      if (routerErr || !router) throw new Error("Router not found");

      // Fetch users from router via mikrotik-api
      const mikrotikUrl = `${supabaseUrl}/functions/v1/mikrotik-api`;
      const baseBody = {
        host: router.host,
        user: router.username,
        pass: router.password,
        port: router.port,
        protocol: router.protocol,
        mode: router.mode,
      };

      // Fetch hotspot users, user-manager users, and profiles
      const [hotspotRes, umUsersRes, umProfilesRes, hotspotProfilesRes] = await Promise.allSettled([
        fetch(mikrotikUrl, {
          method: "POST",
          headers: { "Content-Type": "application/json", Authorization: `Bearer ${supabaseKey}` },
          body: JSON.stringify({ ...baseBody, endpoint: "/ip/hotspot/user/print" }),
        }).then(r => r.json()),
        fetch(mikrotikUrl, {
          method: "POST",
          headers: { "Content-Type": "application/json", Authorization: `Bearer ${supabaseKey}` },
          body: JSON.stringify({ ...baseBody, endpoint: "/user-manager/user/print" }),
        }).then(r => r.json()),
        fetch(mikrotikUrl, {
          method: "POST",
          headers: { "Content-Type": "application/json", Authorization: `Bearer ${supabaseKey}` },
          body: JSON.stringify({ ...baseBody, endpoint: "/user-manager/profile/print" }),
        }).then(r => r.json()),
        fetch(mikrotikUrl, {
          method: "POST",
          headers: { "Content-Type": "application/json", Authorization: `Bearer ${supabaseKey}` },
          body: JSON.stringify({ ...baseBody, endpoint: "/ip/hotspot/user/profile/print" }),
        }).then(r => r.json()),
      ]);

      const backupData = {
        timestamp: new Date().toISOString(),
        router: { host: router.host, label: router.label },
        hotspot_users: hotspotRes.status === "fulfilled" && !hotspotRes.value?.error ? hotspotRes.value : [],
        um_users: umUsersRes.status === "fulfilled" && !umUsersRes.value?.error ? umUsersRes.value : [],
        um_profiles: umProfilesRes.status === "fulfilled" && !umProfilesRes.value?.error ? umProfilesRes.value : [],
        hotspot_profiles: hotspotProfilesRes.status === "fulfilled" && !hotspotProfilesRes.value?.error ? hotspotProfilesRes.value : [],
      };

      const fileName = `${userId}/${router_id}/${Date.now()}.json`;
      const fileContent = JSON.stringify(backupData, null, 2);

      // Upload to storage
      const { error: uploadErr } = await supabase.storage
        .from("router-backups")
        .upload(fileName, fileContent, { contentType: "application/json" });

      if (uploadErr) throw new Error(`Upload failed: ${uploadErr.message}`);

      // Record in database
      const metadata = {
        hotspot_users: Array.isArray(backupData.hotspot_users) ? backupData.hotspot_users.length : 0,
        um_users: Array.isArray(backupData.um_users) ? backupData.um_users.length : 0,
        um_profiles: Array.isArray(backupData.um_profiles) ? backupData.um_profiles.length : 0,
        hotspot_profiles: Array.isArray(backupData.hotspot_profiles) ? backupData.hotspot_profiles.length : 0,
      };

      const { data: backup, error: insertErr } = await supabase
        .from("backups")
        .insert({
          user_id: userId,
          router_id,
          router_label: router_label || router.label,
          backup_type: "users",
          status: "completed",
          file_path: fileName,
          metadata,
        })
        .select()
        .single();

      if (insertErr) throw new Error(`DB insert failed: ${insertErr.message}`);

      return new Response(JSON.stringify({ success: true, backup }), {
        headers: { ...corsHeaders, "Content-Type": "application/json" },
      });
    }

    // ─── RESTORE BACKUP ─────────────────────────────────────────
    if (action === "restore") {
      if (!userId) throw new Error("Authentication required");
      if (!backup_id) throw new Error("Backup ID required");

      // Get backup record
      const { data: backup, error: backupErr } = await supabase
        .from("backups")
        .select("*")
        .eq("id", backup_id)
        .eq("user_id", userId)
        .single();

      if (backupErr || !backup) throw new Error("Backup not found");

      // Download backup file
      const { data: fileData, error: downloadErr } = await supabase.storage
        .from("router-backups")
        .download(backup.file_path!);

      if (downloadErr || !fileData) throw new Error("Failed to download backup file");

      const backupContent = JSON.parse(await fileData.text());

      // Get router config
      const { data: router, error: routerErr } = await supabase
        .from("routers")
        .select("*")
        .eq("id", backup.router_id!)
        .eq("user_id", userId)
        .single();

      if (routerErr || !router) throw new Error("Router not found for restore");

      // Restore via batch commands
      const mikrotikUrl = `${supabaseUrl}/functions/v1/mikrotik-api`;
      const baseBody = {
        host: router.host,
        user: router.username,
        pass: router.password,
        port: router.port,
        protocol: router.protocol,
        mode: router.mode,
      };

      const commands: { command: string; args: string[] }[] = [];

      // Restore user-manager users
      if (Array.isArray(backupContent.um_users)) {
        for (const u of backupContent.um_users) {
          if (!u.name) continue;
          const args = [`=name=${u.name}`];
          if (u.password) args.push(`=password=${u.password}`);
          if (u.group) args.push(`=group=${u.group}`);
          if (u.profile) args.push(`=group=${u.profile}`);
          if (u.comment) args.push(`=comment=${u.comment}`);
          commands.push({ command: "/user-manager/user/add", args });
        }
      }

      // Restore hotspot users
      if (Array.isArray(backupContent.hotspot_users)) {
        for (const u of backupContent.hotspot_users) {
          if (!u.name) continue;
          const args = [`=name=${u.name}`];
          if (u.password) args.push(`=password=${u.password}`);
          if (u.profile) args.push(`=profile=${u.profile}`);
          if (u.comment) args.push(`=comment=${u.comment}`);
          commands.push({ command: "/ip/hotspot/user/add", args });
        }
      }

      if (commands.length === 0) {
        return new Response(JSON.stringify({ success: true, restored: 0, message: "No users to restore" }), {
          headers: { ...corsHeaders, "Content-Type": "application/json" },
        });
      }

      // Execute batch
      const batchRes = await fetch(mikrotikUrl, {
        method: "POST",
        headers: { "Content-Type": "application/json", Authorization: `Bearer ${supabaseKey}` },
        body: JSON.stringify({ ...baseBody, action: "batch", commands }),
      });
      const batchResult = await batchRes.json();

      const errors = batchResult?.errors?.filter((e: string) => e) || [];
      const total = commands.length;
      const succeeded = total - errors.length;

      return new Response(JSON.stringify({
        success: true,
        restored: succeeded,
        failed: errors.length,
        total,
        errors: errors.slice(0, 5),
      }), {
        headers: { ...corsHeaders, "Content-Type": "application/json" },
      });
    }

    // ─── DELETE BACKUP ──────────────────────────────────────────
    if (action === "delete") {
      if (!userId) throw new Error("Authentication required");
      if (!backup_id) throw new Error("Backup ID required");

      const { data: backup, error: backupErr } = await supabase
        .from("backups")
        .select("file_path")
        .eq("id", backup_id)
        .eq("user_id", userId)
        .single();

      if (backupErr || !backup) throw new Error("Backup not found");

      // Delete file from storage
      if (backup.file_path) {
        await supabase.storage.from("router-backups").remove([backup.file_path]);
      }

      // Delete record
      await supabase.from("backups").delete().eq("id", backup_id);

      return new Response(JSON.stringify({ success: true }), {
        headers: { ...corsHeaders, "Content-Type": "application/json" },
      });
    }

    throw new Error(`Unknown action: ${action}`);
  } catch (error: unknown) {
    console.error("Backup error:", error);
    const message = error instanceof Error ? error.message : "Unknown error";
    return new Response(JSON.stringify({ error: message }), {
      status: 200,
      headers: { ...corsHeaders, "Content-Type": "application/json" },
    });
  }
});
