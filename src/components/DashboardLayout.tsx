import { ReactNode, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import {
  LayoutDashboard, Wifi, Users, Settings, Menu, X,
  Router, Activity, ChevronLeft,
} from "lucide-react";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";

const navItems = [
  { path: "/", icon: LayoutDashboard, label: "لوحة التحكم" },
  { path: "/hotspot", icon: Wifi, label: "الهوتسبوت" },
  { path: "/usermanager", icon: Users, label: "يوزر مانجر" },
  { path: "/settings", icon: Settings, label: "الإعدادات" },
];

export default function DashboardLayout({ children }: { children: ReactNode }) {
  const location = useLocation();
  const [sidebarOpen, setSidebarOpen] = useState(false);
  const config = getMikrotikConfig();

  return (
    <div className="flex min-h-screen" dir="rtl">
      {sidebarOpen && (
        <div
          className="fixed inset-0 z-40 bg-background/60 backdrop-blur-sm lg:hidden"
          onClick={() => setSidebarOpen(false)}
        />
      )}

      {/* Sidebar */}
      <aside className={`
        fixed inset-y-0 right-0 z-50 w-64 bg-sidebar border-l border-sidebar-border
        transform transition-transform duration-200 ease-in-out
        lg:relative lg:translate-x-0
        ${sidebarOpen ? "translate-x-0" : "translate-x-full lg:translate-x-0"}
      `}>
        <div className="flex items-center gap-3 p-5 border-b border-sidebar-border">
          <div className="p-2 rounded-lg gradient-primary">
            <Router className="h-5 w-5 text-primary-foreground" />
          </div>
          <div className="flex-1 min-w-0">
            <h1 className="font-bold text-foreground text-base truncate">
              {config?.label || "MikroTik"}
            </h1>
            <p className="text-[10px] text-muted-foreground truncate">
              {config ? `${config.host}:${config.port}` : "غير متصل"}
            </p>
          </div>
          <button
            onClick={() => setSidebarOpen(false)}
            className="lg:hidden text-muted-foreground hover:text-foreground"
          >
            <X className="h-5 w-5" />
          </button>
        </div>

        <nav className="p-3 space-y-1">
          {navItems.map((item) => {
            const isActive = location.pathname === item.path;
            return (
              <Link
                key={item.path}
                to={item.path}
                onClick={() => setSidebarOpen(false)}
                className={`
                  flex items-center gap-3 px-4 py-2.5 rounded-lg text-sm font-medium
                  transition-all duration-150
                  ${isActive
                    ? "bg-primary/10 text-primary shadow-glow"
                    : "text-sidebar-foreground hover:bg-sidebar-accent hover:text-sidebar-accent-foreground"
                  }
                `}
              >
                <item.icon className="h-4.5 w-4.5" />
                {item.label}
                {isActive && <ChevronLeft className="h-3 w-3 mr-auto text-primary/60" />}
              </Link>
            );
          })}
        </nav>

        {/* Connection info at bottom */}
        {config && (
          <div className="absolute bottom-0 left-0 right-0 p-4 border-t border-sidebar-border">
            <div className="flex items-center gap-2 text-[10px] text-muted-foreground">
              <Activity className="h-3 w-3 text-success animate-pulse-glow" />
              <span>{config.mode === "rest" ? "REST API" : "MikroTik API"}</span>
              <span>•</span>
              <span>{config.protocol.toUpperCase()}</span>
            </div>
          </div>
        )}
      </aside>

      {/* Main */}
      <main className="flex-1 min-w-0">
        <header className="sticky top-0 z-30 glass border-b border-border px-4 sm:px-6 py-3 flex items-center gap-4">
          <button
            onClick={() => setSidebarOpen(true)}
            className="lg:hidden text-muted-foreground hover:text-foreground"
          >
            <Menu className="h-6 w-6" />
          </button>
          {config && (
            <div className="flex items-center gap-2 text-xs text-muted-foreground">
              <span className="h-2 w-2 rounded-full bg-success animate-pulse-glow" />
              متصل
            </div>
          )}
        </header>
        <div className="p-4 sm:p-6 animate-slide-up">{children}</div>
      </main>
    </div>
  );
}
