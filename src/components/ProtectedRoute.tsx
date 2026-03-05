import { useAuth } from "@/contexts/AuthContext";
import { Navigate } from "react-router-dom";
import { Loader2 } from "lucide-react";
import { supabase } from "@/integrations/supabase/client";
import { useQuery } from "@tanstack/react-query";

interface Props {
  children: React.ReactNode;
  requireAdmin?: boolean;
}

export default function ProtectedRoute({ children, requireAdmin }: Props) {
  const { user, loading, isAdmin } = useAuth();

  const { data: access, isLoading: accessLoading } = useQuery({
    queryKey: ["user-access-check", user?.id],
    enabled: !!user?.id,
    staleTime: 30_000,
    queryFn: async () => {
      const { data } = await supabase
        .from("user_access")
        .select("status, expires_at")
        .eq("user_id", user!.id)
        .single();
      return data;
    },
  });

  if (loading || accessLoading) {
    return (
      <div className="min-h-screen bg-background flex items-center justify-center">
        <Loader2 className="h-8 w-8 animate-spin text-primary" />
      </div>
    );
  }

  if (!user) return <Navigate to="/auth" replace />;

  // Admin always has access
  if (!isAdmin && access) {
    const status = access.status;
    const expired = status === "active" && access.expires_at && new Date(access.expires_at) < new Date();
    if (status === "pending" || status === "suspended" || status === "expired" || expired) {
      return <Navigate to="/access" replace />;
    }
  }

  if (requireAdmin && !isAdmin) {
    return <Navigate to="/dashboard" replace />;
  }

  return <>{children}</>;
}
