'use client'
import { ReactNode, useState, useEffect } from "react";
import Link from "next/link";
import { usePathname, useRouter } from "next/navigation";
import {
  LayoutDashboard, Wifi, Users, Settings, Menu,
  Router, Moon, Sun, LogOut, Activity, CreditCard,
  Database, Shield, HeartPulse,
} from "lucide-react";
import { getActiveRouter } from "@repo/mikrotik";
import { useAuth } from "@repo/auth";
import { useHotspotUsers, useUserManagerCount } from "@repo/mikrotik";
import { useJobHistory } from "@repo/mikrotik";
import {
  Sidebar,
  SidebarContent,
  SidebarFooter,
  SidebarGroup,
  SidebarGroupContent,
  SidebarGroupLabel,
  SidebarHeader,
  SidebarInset,
  SidebarMenu,
  SidebarMenuBadge,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarProvider,
  SidebarSeparator,
  SidebarTrigger,
  useSidebar,
} from "@repo/design-system/components/ui/sidebar";
import { Button } from "@repo/design-system/components/ui/button";
import { Separator } from "@repo/design-system/components/ui/separator";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@repo/design-system/components/ui/dropdown-menu";

interface NavItem {
  path: string;
  icon: React.ComponentType<{ className?: string }>;
  label: string;
  roles: string[];
}

const mainNavItems: NavItem[] = [
  { path: "/dashboard", icon: LayoutDashboard, label: "لوحة التحكم", roles: ["admin", "cashier"] },
  { path: "/hotspot", icon: Wifi, label: "الهوتسبوت", roles: ["admin", "cashier"] },
  { path: "/usermanager", icon: Users, label: "يوزر مانجر", roles: ["admin", "cashier"] },
  { path: "/vouchers", icon: CreditCard, label: "الكروت", roles: ["admin", "cashier"] },
  { path: "/sales", icon: Activity, label: "المبيعات", roles: ["admin", "cashier"] },
  { path: "/health", icon: HeartPulse, label: "الصحة", roles: ["admin", "cashier"] },
];

const adminNavItems: NavItem[] = [
  { path: "/backups", icon: Database, label: "النسخ الاحتياطي", roles: ["admin"] },
  { path: "/admin/users", icon: Shield, label: "إدارة المستخدمين", roles: ["admin"] },
  { path: "/settings", icon: Settings, label: "الإعدادات", roles: ["admin"] },
];

function SidebarNav() {
  const pathname = usePathname();
  const router = useRouter();
  const { signOut, role } = useAuth();
  const config = getActiveRouter();
  const [isDark, setIsDark] = useState(() => document.documentElement.classList.contains("dark"));

  const { data: hotspotUsers } = useHotspotUsers();
  const { data: umCountData } = useUserManagerCount({ enabled: pathname.startsWith("/usermanager") });
  const hotspotCount = Array.isArray(hotspotUsers) ? hotspotUsers.length : 0;
  const umCount = umCountData?.total ?? 0;

  useEffect(() => {
    if (isDark) document.documentElement.classList.add("dark");
    else document.documentElement.classList.remove("dark");
    localStorage.setItem("theme", isDark ? "dark" : "light");
  }, [isDark]);

  const filterNav = (items: NavItem[]) =>
    items.filter(item => {
      if (!role) return item.roles.includes("cashier");
      return item.roles.includes(role);
    });

  const filteredMain = filterNav(mainNavItems);
  const filteredAdmin = filterNav(adminNavItems);

  const getBadge = (path: string): number | null => {
    if (path === "/hotspot" && hotspotCount > 0) return hotspotCount;
    if (path === "/usermanager" && umCount > 0) return umCount;
    return null;
  };

  return (
    <Sidebar side="right" collapsible="icon">
      <SidebarHeader>
        <SidebarMenu>
          <SidebarMenuItem>
            <SidebarMenuButton size="lg" asChild>
              <Link href="/dashboard">
                <div className="flex aspect-square size-8 items-center justify-center rounded-lg bg-primary/10">
                  <Router className="size-4 text-primary" />
                </div>
                <div className="flex flex-col gap-0.5 leading-none">
                  <span className="font-semibold text-sm">
                    {config?.label || "MikroTik"}
                  </span>
                  <span className="text-[10px] text-muted-foreground font-mono">
                    {config ? `${config.host}:${config.port}` : "غير متصل"}
                  </span>
                </div>
              </Link>
            </SidebarMenuButton>
          </SidebarMenuItem>
        </SidebarMenu>
      </SidebarHeader>

      <SidebarContent>
        {/* Main Nav */}
        <SidebarGroup>
          <SidebarGroupLabel>الرئيسية</SidebarGroupLabel>
          <SidebarGroupContent>
            <SidebarMenu>
              {filteredMain.map(item => {
                const isActive = pathname === item.path;
                const badge = getBadge(item.path);
                return (
                  <SidebarMenuItem key={item.path}>
                    <SidebarMenuButton
                      asChild
                      isActive={isActive}
                      tooltip={item.label}
                    >
                      <Link href={item.path}>
                        <item.icon />
                        <span>{item.label}</span>
                      </Link>
                    </SidebarMenuButton>
                    {badge !== null && (
                      <SidebarMenuBadge>{badge}</SidebarMenuBadge>
                    )}
                  </SidebarMenuItem>
                );
              })}
            </SidebarMenu>
          </SidebarGroupContent>
        </SidebarGroup>

        {/* Admin Nav */}
        {filteredAdmin.length > 0 && (
          <SidebarGroup>
            <SidebarGroupLabel>الإدارة</SidebarGroupLabel>
            <SidebarGroupContent>
              <SidebarMenu>
                {filteredAdmin.map(item => {
                  const isActive = pathname === item.path;
                  return (
                    <SidebarMenuItem key={item.path}>
                      <SidebarMenuButton
                        asChild
                        isActive={isActive}
                        tooltip={item.label}
                      >
                        <Link href={item.path}>
                          <item.icon />
                          <span>{item.label}</span>
                        </Link>
                      </SidebarMenuButton>
                    </SidebarMenuItem>
                  );
                })}
              </SidebarMenu>
            </SidebarGroupContent>
          </SidebarGroup>
        )}
      </SidebarContent>

      <SidebarFooter>
        <SidebarMenu>
          <SidebarMenuItem>
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <SidebarMenuButton tooltip="الحساب">
                  <Shield />
                  <span>{role === "admin" ? "مدير النظام" : "كاشير"}</span>
                </SidebarMenuButton>
              </DropdownMenuTrigger>
              <DropdownMenuContent
                side="top"
                align="end"
                className="w-48"
              >
                <DropdownMenuItem onClick={() => setIsDark(!isDark)}>
                  {isDark ? <Sun className="size-4" /> : <Moon className="size-4" />}
                  <span>{isDark ? "الوضع النهاري" : "الوضع الليلي"}</span>
                </DropdownMenuItem>
                <DropdownMenuItem asChild>
                  <Link href="/routers">
                    <Router className="size-4" />
                    <span>تغيير الراوتر</span>
                  </Link>
                </DropdownMenuItem>
                <DropdownMenuSeparator />
                <DropdownMenuItem onClick={() => { signOut(); router.push("/auth"); }}>
                  <LogOut className="size-4" />
                  <span>تسجيل خروج</span>
                </DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>
          </SidebarMenuItem>
          {config && (
            <SidebarMenuItem>
              <SidebarMenuButton size="sm" className="pointer-events-none text-muted-foreground">
                <span className="h-1.5 w-1.5 rounded-full bg-success animate-pulse" />
                <span className="text-[10px] font-mono">
                  {config.mode === "rest" ? "REST" : "API"} • {config.protocol.toUpperCase()}
                </span>
              </SidebarMenuButton>
            </SidebarMenuItem>
          )}
        </SidebarMenu>
      </SidebarFooter>
    </Sidebar>
  );
}

function DashboardHeader() {
  const pathname = usePathname();
  const config = getActiveRouter();
  const allItems = [...mainNavItems, ...adminNavItems];
  const currentPage = allItems.find(item => pathname === item.path);

  return (
    <header className="flex h-10 sm:h-12 shrink-0 items-center gap-2 border-b px-3 sm:px-4">
      <SidebarTrigger className="-mr-1" />
      <Separator orientation="vertical" className="ml-2 h-4" />
      {currentPage && (
        <h2 className="text-sm font-medium text-foreground">
          {currentPage.label}
        </h2>
      )}
      {config && (
        <div className="flex items-center gap-1.5 text-xs text-muted-foreground mr-auto">
          <span className="h-1.5 w-1.5 rounded-full bg-success animate-pulse" />
          <span className="hidden sm:inline">متصل</span>
        </div>
      )}
    </header>
  );
}

function MobileBottomNav() {
  const pathname = usePathname();
  const { role } = useAuth();
  const { data: hotspotUsers } = useHotspotUsers();
  const { data: umCountData } = useUserManagerCount({ enabled: pathname.startsWith("/usermanager") });
  const hotspotCount = Array.isArray(hotspotUsers) ? hotspotUsers.length : 0;
  const umCount = umCountData?.total ?? 0;

  const filterNav = (items: NavItem[]) =>
    items.filter(item => {
      if (!role) return item.roles.includes("cashier");
      return item.roles.includes(role);
    });

  const allFiltered = [...filterNav(mainNavItems), ...filterNav(adminNavItems)];

  const getBadge = (path: string): number | null => {
    if (path === "/hotspot" && hotspotCount > 0) return hotspotCount;
    if (path === "/usermanager" && umCount > 0) return umCount;
    return null;
  };

  return (
    <nav className="fixed bottom-0 left-0 right-0 z-40 md:hidden border-t bg-background/95 backdrop-blur supports-[backdrop-filter]:bg-background/60 pb-[max(env(safe-area-inset-bottom),0.125rem)]">
      <div className="flex items-center justify-around py-1 px-1">
        {allFiltered.slice(0, 5).map(item => {
          const isActive = pathname === item.path;
          const badge = getBadge(item.path);
          return (
            <Link
              key={item.path}
              href={item.path}
              className={`relative flex flex-col items-center gap-0.5 px-2.5 py-1 rounded-lg transition-colors ${
                isActive ? "text-primary" : "text-muted-foreground"
              }`}
            >
              <item.icon className="h-[18px] w-[18px]" />
              <span className="text-[9px] font-medium">{item.label}</span>
              {badge !== null && (
                <span className="absolute -top-0.5 -left-0.5 h-3.5 min-w-[14px] flex items-center justify-center text-[8px] font-bold bg-primary text-primary-foreground rounded-full px-0.5">
                  {badge}
                </span>
              )}
            </Link>
          );
        })}
      </div>
    </nav>
  );
}

export default function DashboardLayout({ children }: { children: ReactNode }) {
  useJobHistory();

  return (
    <SidebarProvider>
      <div className="flex min-h-dvh w-full" dir="rtl">
        <SidebarNav />
        <SidebarInset>
          <DashboardHeader />
          <div className="flex-1 p-3 sm:p-4 md:p-6 pb-[calc(3.5rem+max(env(safe-area-inset-bottom),0.25rem))] md:pb-6">
            <div className="max-w-7xl mx-auto w-full">
              {children}
            </div>
          </div>
        </SidebarInset>
        <MobileBottomNav />
      </div>
    </SidebarProvider>
  );
}
