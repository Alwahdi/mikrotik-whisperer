import { Toaster } from "@/components/ui/toaster";
import { Toaster as Sonner } from "@/components/ui/sonner";
import { TooltipProvider } from "@/components/ui/tooltip";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import { AuthProvider, useAuth } from "@/contexts/AuthContext";
import ProtectedRoute from "@/components/ProtectedRoute";
import PWAInstallBanner from "@/components/PWAInstallBanner";
import RouterDataLoader from "@/components/RouterDataLoader";
import LandingPage from "./pages/LandingPage";
import AuthPage from "./pages/AuthPage";
import AccessGatePage from "./pages/AccessGatePage";
import RoutersPage from "./pages/RoutersPage";
import Index from "./pages/Index";
import HotspotPage from "./pages/HotspotPage";
import UserManagerPage from "./pages/UserManagerPage";
import SettingsPage from "./pages/SettingsPage";
import VouchersPage from "./pages/VouchersPage";
import BackupsPage from "./pages/BackupsPage";
import SalesPage from "./pages/SalesPage";
import AdminUsersPage from "./pages/AdminUsersPage";
import NotFound from "./pages/NotFound";

const queryClient = new QueryClient();

function AuthRedirect({ children }: { children: React.ReactNode }) {
  const { user, loading } = useAuth();
  if (loading) return null;
  if (user) return <Navigate to="/routers" replace />;
  return <>{children}</>;
}

function PublicRedirect({ children }: { children: React.ReactNode }) {
  const { user, loading } = useAuth();
  if (loading) return null;
  if (user) return <Navigate to="/routers" replace />;
  return <>{children}</>;
}

const App = () => (
  <QueryClientProvider client={queryClient}>
    <TooltipProvider>
      <Toaster />
      <Sonner />
      <BrowserRouter>
        <AuthProvider>
          <Routes>
            <Route path="/" element={<PublicRedirect><LandingPage /></PublicRedirect>} />
            <Route path="/auth" element={<AuthRedirect><AuthPage /></AuthRedirect>} />
            <Route path="/access" element={<AccessGatePage />} />
            <Route path="/routers" element={<ProtectedRoute><RoutersPage /></ProtectedRoute>} />
            <Route path="/loading" element={<ProtectedRoute><RouterDataLoader /></ProtectedRoute>} />
            <Route path="/dashboard" element={<ProtectedRoute><Index /></ProtectedRoute>} />
            <Route path="/hotspot" element={<ProtectedRoute><HotspotPage /></ProtectedRoute>} />
            <Route path="/usermanager" element={<ProtectedRoute><UserManagerPage /></ProtectedRoute>} />
            <Route path="/vouchers" element={<ProtectedRoute><VouchersPage /></ProtectedRoute>} />
            <Route path="/backups" element={<ProtectedRoute><BackupsPage /></ProtectedRoute>} />
            <Route path="/sales" element={<ProtectedRoute><SalesPage /></ProtectedRoute>} />
            <Route path="/settings" element={<ProtectedRoute><SettingsPage /></ProtectedRoute>} />
            <Route path="/admin/users" element={<ProtectedRoute requireAdmin><AdminUsersPage /></ProtectedRoute>} />
            <Route path="*" element={<NotFound />} />
          </Routes>
          <PWAInstallBanner />
        </AuthProvider>
      </BrowserRouter>
    </TooltipProvider>
  </QueryClientProvider>
);

export default App;
