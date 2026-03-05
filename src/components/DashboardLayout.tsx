import { ReactNode, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import { 
  LayoutDashboard, Wifi, Users, Settings, Menu, X, 
  Router, Activity 
} from "lucide-react";

const navItems = [
  { path: "/", icon: LayoutDashboard, label: "لوحة التحكم" },
  { path: "/hotspot", icon: Wifi, label: "الهوتسبوت" },
  { path: "/usermanager", icon: Users, label: "يوزر مانجر" },
  { path: "/settings", icon: Settings, label: "الإعدادات" },
];

export default function DashboardLayout({ children }: { children: ReactNode }) {
  const location = useLocation();
  const [sidebarOpen, setSidebarOpen] = useState(false);

  return (
    <div className="flex min-h-screen" dir="rtl">
      {/* Mobile overlay */}
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
        <div className="flex items-center gap-3 p-6 border-b border-sidebar-border">
          <div className="p-2 rounded-lg gradient-primary">
            <Router className="h-5 w-5 text-primary-foreground" />
          </div>
          <div>
            <h1 className="font-bold text-foreground text-lg">MikroTik</h1>
            <p className="text-xs text-muted-foreground">مدير الشبكة</p>
          </div>
          <button 
            onClick={() => setSidebarOpen(false)}
            className="mr-auto lg:hidden text-muted-foreground hover:text-foreground"
          >
            <X className="h-5 w-5" />
          </button>
        </div>

        <nav className="p-4 space-y-1">
          {navItems.map((item) => {
            const isActive = location.pathname === item.path;
            return (
              <Link
                key={item.path}
                to={item.path}
                onClick={() => setSidebarOpen(false)}
                className={`
                  flex items-center gap-3 px-4 py-3 rounded-lg text-sm font-medium
                  transition-all duration-150
                  ${isActive 
                    ? "bg-primary/10 text-primary shadow-glow" 
                    : "text-sidebar-foreground hover:bg-sidebar-accent hover:text-sidebar-accent-foreground"
                  }
                `}
              >
                <item.icon className="h-5 w-5" />
                {item.label}
                {isActive && (
                  <Activity className="h-3 w-3 mr-auto animate-pulse-glow text-primary" />
                )}
              </Link>
            );
          })}
        </nav>
      </aside>

      {/* Main */}
      <main className="flex-1 min-w-0">
        <header className="sticky top-0 z-30 glass border-b border-border px-6 py-4 flex items-center gap-4">
          <button 
            onClick={() => setSidebarOpen(true)}
            className="lg:hidden text-muted-foreground hover:text-foreground"
          >
            <Menu className="h-6 w-6" />
          </button>
          <div className="flex items-center gap-2 text-sm text-muted-foreground">
            <div className="h-2 w-2 rounded-full bg-success animate-pulse-glow" />
            جاري المزامنة مع الراوتر
          </div>
        </header>
        <div className="p-6 animate-slide-up">
          {children}
        </div>
      </main>
    </div>
  );
}
