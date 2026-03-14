import { Redirect } from "expo-router";
import { useAuth } from "@/contexts/AuthContext";
import LoadingView from "@/components/LoadingView";

export default function Index() {
  const { user, loading } = useAuth();

  if (loading) return <LoadingView />;
  if (user) return <Redirect href="/routers" />;
  return <Redirect href="/(auth)/login" />;
}
