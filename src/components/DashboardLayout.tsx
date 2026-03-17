import { ReactNode, useState, useEffect } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import {
  LayoutDashboard, Wifi, Users, Settings, Menu, X,
  Router, Moon, Sun, LogOut, Activity, CreditCard,
  Database, Shield, ChevronRight,
} from "lucide-react";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { useAuth } from "@/contexts/AuthContext";
import { useHotspotUsers, useUserManagerUsers } from "@/hooks/useMikrotik";

const navItems = [
  { path: "/dashboard", icon: LayoutDashboard, label: "لوحة التحكم", roles: ["admin", "cashier"] },
  { path: "/hotspot", icon: Wifi, label: "الهوتسبوت", roles: ["admin", "cashier"] },
  { path: "/usermanager", icon: Users, label: "يوزر مانجر", roles: ["admin", "cashier"] },
  { path: "/vouchers", icon: CreditCard, label: "الكروت", roles: ["admin", "cashier"] },
  { path: "/sales", icon: Activity, label: "المبيعات", roles: ["admin", "cashier"] },
  { path: "/backups", icon: Database, label: "النسخ الاحتياطي", roles: ["admin"] },
  { path: "/admin/users", icon: Shield, label: "إدارة المستخدمين", roles: ["admin"] },
  { path: "/settings", icon: Settings, label: "الإعدادات", roles: ["admin"] },
];

export default function DashboardLayout({ children }: { children: ReactNode }) {
  const location = useLocation();
  const navigate = useNavigate();
  const { signOut, role, isAdmin } = useAuth();
  const [sidebarOpen, setSidebarOpen] = useState(false);
  const [isDark, setIsDark] = useState(() => document.documentElement.classList.contains("dark"));
  const config = getMikrotikConfig();

  // Live badge counts
  const { data: hotspotUsers } = useHotspotUsers();
  const { data: umUsers } = useUserManagerUsers();
  const hotspotCount = Array.isArray(hotspotUsers) ? hotspotUsers.length : 0;
  const umCount = Array.isArray(umUsers) ? umUsers.length : 0;

  useEffect(() => {
    if (isDark) document.documentElement.classList.add("dark");
    else document.documentElement.classList.remove("dark");
    localStorage.setItem("theme", isDark ? "dark" : "light");
  }, [isDark]);

  const filteredNav = navItems.filter(item => {
    if (!role) return item.roles.includes("cashier");
    return item.roles.includes(role);
  });

  const getBadge = (path: string): number | null => {
    if (path === "/hotspot" && hotspotCount > 0) return hotspotCount;
    if (path === "/usermanager" && umCount > 0) return umCount;
    return null;
  };

  return (
    <div className="flex min-h-dvh bg-background" dir="rtl">
      {sidebarOpen && (
        <div
          className="fixed inset-0 z-40 bg-background/60 backdrop-blur-md lg:hidden"
          onClick={() => setSidebarOpen(false)}
        />
      )}

      {/* Sidebar */}
      <aside className={`
        fixed inset-y-0 right-0 z-50 w-60 bg-sidebar border-l border-sidebar-border
        flex flex-col
        transform transition-transform duration-250 ease-out
        lg:relative lg:translate-x-0
        ${sidebarOpen ? "translate-x-0" : "translate-x-full lg:translate-x-0"}
      `}>
        {/* Logo */}
        <div className="flex items-center gap-3 px-4 py-5 border-b border-sidebar-border">
          <div className="p-2 rounded-xl gradient-primary shadow-primary/30 shadow-sm">
            <Router className="h-4 w-4 text-primary-foreground" />
          </div>
          <div className="flex-1 min-w-0">
            <h1 className="font-bold text-sidebar-foreground text-sm truncate leading-tight">
              {config?.label || "MikroTik"}
            </h1>
            <p className="text-[10px] text-muted-foreground truncate font-mono mt-0.5">
              {config ? `${config.host}:${config.port}` : "غير متصل"}
            </p>
          </div>
          <button
            onClick={() => setSidebarOpen(false)}
            className="lg:hidden p-1 rounded-md text-muted-foreground hover:text-foreground hover:bg-muted transition-colors"
          >
            <X className="h-4 w-4" />
          </button>
        </div>

        {/* Nav */}
        <nav className="flex-1 p-2 mt-1 space-y-0.5 overflow-y-auto">
          {filteredNav.map((item) => {
            const isActive = location.pathname === item.path;
            const badge = getBadge(item.path);
            return (
              <Link
                key={item.path}
                to={item.path}
                onClick={() => setSidebarOpen(false)}
                className={`
                  group flex items-center gap-3 px-3 py-2.5 rounded-lg text-sm transition-all relative
                  ${isActive
                    ? "bg-primary text-primary-foreground font-medium shadow-sm"
                    : "text-sidebar-foreground hover:bg-sidebar-accent hover:text-sidebar-accent-foreground font-normal"
                  }
                `}
              >
                <item.icon className={`h-4 w-4 shrink-0 transition-transform group-hover:scale-110 ${isActive ? "" : ""}`} />
                <span className="flex-1 truncate">{item.label}</span>
                {badge !== null && (
                  <span className={`text-[10px] font-mono font-bold px-1.5 py-0.5 rounded-full min-w-[20px] text-center ${
                    isActive
                      ? "bg-primary-foreground/20 text-primary-foreground"
                      : "bg-primary/12 text-primary"
                  }`}>
                    {badge}
                  </span>
                )}
                {isActive && (
                  <ChevronRight className="h-3 w-3 opacity-60" />
                )}
              </Link>
            );
          })}
        </nav>

        {/* Bottom */}
        <div className="p-3 border-t border-sidebar-border space-y-2">
          {/* Role Badge */}
          {role && (
            <div className="flex items-center justify-center gap-1.5 py-1.5 px-3 rounded-lg bg-muted/50 text-[10px] text-muted-foreground">
              <Shield className="h-2.5 w-2.5" />
              <span>{role === "admin" ? "مدير النظام" : "كاشير"}</span>
            </div>
          )}
          <div className="flex items-center justify-between gap-2">
            <button
              onClick={() => setIsDark(!isDark)}
              className="flex items-center gap-1.5 text-xs text-muted-foreground hover:text-foreground transition-colors px-2 py-1.5 rounded-md hover:bg-muted"
            >
              {isDark ? <Sun className="h-3.5 w-3.5" /> : <Moon className="h-3.5 w-3.5" />}
              {isDark ? "نهاري" : "ليلي"}
            </button>
            <Link
              to="/routers"
              className="text-xs text-muted-foreground hover:text-foreground transition-colors px-2 py-1.5 rounded-md hover:bg-muted"
            >
              تغيير الراوتر
            </Link>
          </div>
          <button
            onClick={() => { signOut(); navigate("/auth"); }}
            className="w-full flex items-center justify-center gap-2 text-xs text-muted-foreground hover:text-destructive transition-colors py-2 rounded-lg hover:bg-destructive/8 border border-transparent hover:border-destructive/15"
          >
            <LogOut className="h-3.5 w-3.5" />
            تسجيل خروج
          </button>
          {config && (
            <div className="flex items-center gap-1.5 text-[10px] text-muted-foreground justify-center">
              <span className="h-1.5 w-1.5 rounded-full bg-accent animate-pulse-glow" />
              {config.mode === "rest" ? "REST" : "API"} • {config.protocol.toUpperCase()}
            </div>
          )}
        </div>
      </aside>

      {/* Main */}
      <main className="flex-1 min-w-0 pb-[calc(4.5rem+env(safe-area-inset-bottom))] lg:pb-0">
        <header className="sticky top-0 z-30 glass border-b border-border/80 px-3 sm:px-6 py-2.5 pt-[max(env(safe-area-inset-top),0.625rem)] flex items-center gap-3">
          <button
            onClick={() => setSidebarOpen(true)}
            className="lg:hidden p-1.5 rounded-md text-muted-foreground hover:text-foreground hover:bg-muted transition-colors"
          >
            <Menu className="h-5 w-5" />
          </button>
          {config && (
            <div className="flex items-center gap-2 text-xs">
              <span className="flex items-center gap-1.5 text-muted-foreground">
                <span className="h-1.5 w-1.5 rounded-full bg-accent animate-pulse-glow" />
                متصل
              </span>
            </div>
          )}
          <div className="mr-auto flex items-center gap-2">
            <button
              onClick={() => setIsDark(!isDark)}
              className="p-2 rounded-lg text-muted-foreground hover:text-foreground hover:bg-muted transition-all duration-200"
              aria-label="تبديل الوضع"
            >
              {isDark ? <Sun className="h-4 w-4" /> : <Moon className="h-4 w-4" />}
            </button>
          </div>
        </header>
        <div className="p-3 sm:p-6 max-w-6xl mx-auto w-full animate-slide-up">{children}</div>
      </main>

      {/* Mobile Bottom Nav */}
      <nav className="fixed bottom-0 left-0 right-0 z-40 lg:hidden glass border-t border-border/80 pb-[max(env(safe-area-inset-bottom),0.35rem)]">
        <div className="flex items-center justify-around py-2 px-2">
          {filteredNav.slice(0, 5).map(item => {
            const isActive = location.pathname === item.path;
            const badge = getBadge(item.path);
            return (
              <Link
                key={item.path}
                to={item.path}
                className={`flex flex-col items-center gap-0.5 px-3 py-1.5 rounded-xl transition-all relative ${
                  isActive
                    ? "text-primary bg-primary/8"
                    : "text-muted-foreground hover:text-foreground"
                }`}
              >
                <item.icon className={`h-[18px] w-[18px] transition-transform ${isActive ? "scale-110" : ""}`} />
                <span className="text-[9px] font-medium">{item.label}</span>
                {badge !== null && (
                  <span className="absolute -top-0.5 -left-0.5 h-4 min-w-[16px] flex items-center justify-center text-[8px] font-bold bg-primary text-primary-foreground rounded-full px-1">
                    {badge}
                  </span>
                )}
              </Link>
            );
          })}
        </div>
      </nav>
    </div>
  );
}
