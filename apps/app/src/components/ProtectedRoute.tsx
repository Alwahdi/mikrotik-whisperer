'use client'
import { useAuth } from "@repo/auth";
import { useRouter } from "next/navigation";
import { useEffect } from "react";
import { Loader2 } from "lucide-react";
import { supabase } from "@repo/database";
import { useQuery } from "@tanstack/react-query";

interface Props {
  children: React.ReactNode;
  requireAdmin?: boolean;
}

export default function ProtectedRoute({ children, requireAdmin }: Props) {
  const { user, loading, isAdmin } = useAuth();
  const router = useRouter();

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

  useEffect(() => {
    if (!loading && !user) {
      router.replace('/auth');
    }
  }, [loading, user, router]);

  useEffect(() => {
    if (!loading && !accessLoading && user && !isAdmin && access) {
      const status = access.status;
      const expired = status === "active" && access.expires_at && new Date(access.expires_at) < new Date();
      if (status === "pending" || status === "suspended" || status === "expired" || expired) {
        router.replace('/access');
      }
    }
  }, [loading, accessLoading, user, isAdmin, access, router]);

  useEffect(() => {
    if (!loading && user && requireAdmin && !isAdmin) {
      router.replace('/dashboard');
    }
  }, [loading, user, requireAdmin, isAdmin, router]);

  if (loading || accessLoading) {
    return (
      <div className="min-h-screen bg-background flex items-center justify-center">
        <Loader2 className="h-8 w-8 animate-spin text-primary" />
      </div>
    );
  }

  if (!user) return null;

  if (!isAdmin && access) {
    const status = access.status;
    const expired = status === "active" && access.expires_at && new Date(access.expires_at) < new Date();
    if (status === "pending" || status === "suspended" || status === "expired" || expired) {
      return null;
    }
  }

  if (requireAdmin && !isAdmin) return null;

  return <>{children}</>;
}
