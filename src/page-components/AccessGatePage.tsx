"use client";

import { useAuth } from "@/contexts/AuthContext";
import { supabase } from "@/integrations/supabase/client";
import { useQuery } from "@tanstack/react-query";
import { ShieldAlert, Clock, Ban, LogOut, Loader2 } from "lucide-react";
import { Button } from "@/components/ui/button";
import { useRouter } from "next/navigation";

type AccessStatus = "pending" | "active" | "suspended" | "expired" | null;

const statusConfig: Record<string, { icon: typeof Clock; title: string; desc: string; color: string }> = {
  pending: { icon: Clock, title: "حسابك قيد المراجعة", desc: "سيتم تفعيل حسابك بعد موافقة المدير. يرجى التواصل مع الإدارة لتسريع التفعيل.", color: "text-warning" },
  suspended: { icon: Ban, title: "حسابك موقوف", desc: "تم إيقاف حسابك مؤقتاً. يرجى التواصل مع المدير لمعرفة السبب.", color: "text-destructive" },
  expired: { icon: ShieldAlert, title: "انتهى اشتراكك", desc: "انتهت مدة اشتراكك. يرجى التواصل مع المدير لتجديد الاشتراك.", color: "text-destructive" },
};

export default function AccessGatePage() {
  const { user, signOut } = useAuth();
  const router = useRouter();

  const { data: access, isLoading } = useQuery({
    queryKey: ["user-access", user?.id],
    enabled: !!user?.id,
    queryFn: async () => {
      const { data } = await supabase
        .from("user_access")
        .select("status, expires_at")
        .eq("user_id", user!.id)
        .single();
      return data;
    },
  });

  const status: AccessStatus = access?.status as AccessStatus || "pending";
  const cfg = statusConfig[status] || statusConfig.pending;
  const Icon = cfg.icon;

  if (isLoading) {
    return (
      <div className="min-h-dvh bg-background flex items-center justify-center">
        <Loader2 className="h-8 w-8 animate-spin text-primary" />
      </div>
    );
  }

  return (
    <div className="min-h-dvh bg-background flex items-center justify-center p-4" dir="rtl">
      <div className="max-w-sm w-full text-center space-y-6">
        <div className={`mx-auto h-16 w-16 rounded-full bg-muted flex items-center justify-center ${cfg.color}`}>
          <Icon className="h-8 w-8" />
        </div>
        <div>
          <h1 className="text-xl font-bold text-foreground mb-2">{cfg.title}</h1>
          <p className="text-sm text-muted-foreground leading-relaxed">{cfg.desc}</p>
          {access?.expires_at && status === "expired" && (
            <p className="text-xs text-muted-foreground mt-2 font-mono">
              انتهى في: {new Date(access.expires_at).toLocaleDateString("ar")}
            </p>
          )}
        </div>
        <Button variant="outline" className="gap-2" onClick={() => { signOut(); router.push("/auth"); }}>
          <LogOut className="h-4 w-4" />
          تسجيل خروج
        </Button>
      </div>
    </div>
  );
}
