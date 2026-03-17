import { useMemo } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import StatCard from "@/components/StatCard";
import SystemInfoCard from "@/components/SystemInfoCard";
import TrafficChart from "@/components/TrafficChart";
import {
  Wifi, Users, Cpu, HardDrive, Clock, Activity, Settings,
  Network, Gauge, MemoryStick, CreditCard, UserPlus, AlertTriangle,
  Zap, ArrowRight, DollarSign, TrendingUp,
} from "lucide-react";
import {
  useHotspotUsers, useUserManagerUsers,
  useSystemResources, useSystemIdentity, useRouterboard,
  useInterfaces, useDHCPLeases, useRouterHealth,
  useUserManagerSessions,
} from "@/hooks/useMikrotik";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { Link } from "react-router-dom";
import { Button } from "@/components/ui/button";
import { supabase } from "@/integrations/supabase/client";
import { useAuth } from "@/contexts/AuthContext";
import { useQuery } from "@tanstack/react-query";

export default function Index() {
  const { user } = useAuth();
  const config = getMikrotikConfig();
  const enabled = !!config;

  const { data: hotspotUsers, isLoading: loadingH } = useHotspotUsers();
  const { data: umUsers, isLoading: loadingU } = useUserManagerUsers();
  const { data: umSessions } = useUserManagerSessions();
  const { data: sysResource } = useSystemResources();
  const { data: identity } = useSystemIdentity();
  const { data: routerboard } = useRouterboard();
  const { data: interfaces } = useInterfaces();
  const { data: dhcpLeases } = useDHCPLeases();
  const { data: health } = useRouterHealth();

  // Today's sales from DB
  const { data: todaySales } = useQuery({
    queryKey: ["today-sales", user?.id],
    queryFn: async () => {
      if (!user?.id) return [];
      const today = new Date();
      today.setHours(0, 0, 0, 0);
      const { data } = await supabase
        .from("sales")
        .select("success_count, total_amount, profile_name")
        .eq("user_id", user.id)
        .gte("created_at", today.toISOString());
      return data || [];
    },
    enabled: !!user?.id,
  });

  const todayCardsCount = useMemo(() => (todaySales || []).reduce((s, r) => s + (r.success_count || 0), 0), [todaySales]);
  const todayRevenue = useMemo(() => (todaySales || []).reduce((s, r) => s + Number(r.total_amount || 0), 0), [todaySales]);
  const topPackageToday = useMemo(() => {
    if (!todaySales || todaySales.length === 0) return null;
    const map: Record<string, number> = {};
    todaySales.forEach(s => { map[s.profile_name || ""] = (map[s.profile_name || ""] || 0) + (s.success_count || 0); });
    const entries = Object.entries(map).sort((a, b) => b[1] - a[1]);
    return entries[0] ? entries[0][0] : null;
  }, [todaySales]);

  // Alerts - must be before conditional returns
  const cpuLoad = sysResource?.["cpu-load"] ?? "—";
  const totalMem = Number(sysResource?.["total-memory"] || 0);
  const freeMem = Number(sysResource?.["free-memory"] || 0);
  const memUsed = totalMem > 0 ? Math.round(((totalMem - freeMem) / totalMem) * 100) : 0;
  const totalHdd = Number(sysResource?.["total-hdd-space"] || 0);
  const freeHdd = Number(sysResource?.["free-hdd-space"] || 0);
  const hddUsed = totalHdd > 0 ? Math.round(((totalHdd - freeHdd) / totalHdd) * 100) : 0;

  const alerts = useMemo(() => {
    const a: { type: "warning" | "error"; msg: string }[] = [];
    if (Number(cpuLoad) > 80) a.push({ type: "warning", msg: `CPU عالي: ${cpuLoad}%` });
    if (memUsed > 85) a.push({ type: "warning", msg: `الذاكرة ممتلئة: ${memUsed}%` });
    if (hddUsed > 90) a.push({ type: "error", msg: `التخزين ممتلئ: ${hddUsed}%` });
    if (Array.isArray(umUsers)) {
      const expired = umUsers.filter((u: any) => u.disabled === "true" || u.disabled === true).length;
      if (expired > 0) a.push({ type: "warning", msg: `${expired} مستخدم معطل في يوزر مانجر` });
    }
    return a;
  }, [cpuLoad, memUsed, hddUsed, umUsers]);

  if (!config) {
    return (
      <DashboardLayout>
        <div className="flex flex-col items-center justify-center min-h-[60vh] text-center">
          <div className="p-4 rounded-xl gradient-primary mb-6">
            <Settings className="h-8 w-8 text-primary-foreground" />
          </div>
          <h2 className="text-lg font-bold text-foreground mb-2">مرحباً بك</h2>
          <p className="text-muted-foreground mb-6 text-sm max-w-xs">
            اذهب لصفحة الراوترات لإضافة جهاز والبدء
          </p>
          <Link
            to="/routers"
            className="gradient-primary text-primary-foreground font-medium py-2.5 px-6 rounded-lg text-sm hover:opacity-90 transition-opacity"
          >
            إدارة الراوترات
          </Link>
        </div>
      </DashboardLayout>
    );
  }

  const activeCount = Array.isArray(hotspotUsers) ? hotspotUsers.length : 0;
  const totalUsers = Array.isArray(umUsers) ? umUsers.length : 0;
  const totalLeases = Array.isArray(dhcpLeases) ? dhcpLeases.length : 0;
  const totalInterfaces = Array.isArray(interfaces) ? interfaces.filter((i: any) => i.running === "true" || i.running === true).length : 0;
  const uptime = sysResource?.uptime ?? "—";
  const routerName = identity?.name ?? config.label ?? "MikroTik";
  const latency = health?.latency;
  const activeSessions = Array.isArray(umSessions) ? umSessions.length : 0;

  return (
    <DashboardLayout>
      {/* Header */}
      <div className="flex items-center justify-between mb-6">
        <div>
          <h2 className="text-xl font-bold text-foreground tracking-tight">{routerName}</h2>
          <p className="text-muted-foreground text-xs flex items-center gap-2 mt-1">
            <span className="h-1.5 w-1.5 rounded-full bg-success inline-block" />
            <span>{sysResource?.version || "RouterOS"} • {config.mode === "rest" ? "REST" : "API"}</span>
            {latency != null && <span className="font-mono text-muted-foreground/70">• {latency}ms</span>}
          </p>
        </div>
      </div>

      {/* Quick Actions */}
      <div className="flex items-center gap-2 mb-6 overflow-x-auto pb-1">
        <Link to="/vouchers">
          <Button size="sm" variant="outline" className="text-xs whitespace-nowrap gap-1.5">
            <CreditCard className="h-3.5 w-3.5" />
            توليد كروت
          </Button>
        </Link>
        <Link to="/usermanager">
          <Button size="sm" variant="outline" className="text-xs whitespace-nowrap gap-1.5">
            <UserPlus className="h-3.5 w-3.5" />
            يوزر مانجر
          </Button>
        </Link>
        <Link to="/hotspot">
          <Button size="sm" variant="outline" className="text-xs whitespace-nowrap gap-1.5">
            <Wifi className="h-3.5 w-3.5" />
            الهوتسبوت
          </Button>
        </Link>
      </div>

      {/* Alerts */}
      {alerts.length > 0 && (
        <div className="mb-5 space-y-2">
          {alerts.map((a, i) => (
            <div key={i} className={`flex items-center gap-2.5 p-3 rounded-xl border text-xs font-medium ${
              a.type === "error"
                ? "bg-destructive/6 border-destructive/20 text-destructive"
                : "bg-warning/6 border-warning/20 text-warning"
            }`}>
              <AlertTriangle className="h-3.5 w-3.5 shrink-0" />
              {a.msg}
            </div>
          ))}
        </div>
      )}

      {/* Key Metrics */}
      <div className="grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-6 gap-3 mb-6 stagger-children">
        <StatCard title="المتصلين" value={loadingH ? "..." : activeCount} subtitle="هوتسبوت" icon={Wifi} variant="primary" />
        <StatCard title="المستخدمين" value={loadingU ? "..." : totalUsers} subtitle="يوزر مانجر" icon={Users} variant="accent" />
        <StatCard title="CPU" value={`${cpuLoad}%`} icon={Cpu} variant={Number(cpuLoad) > 80 ? "warning" : "default"} />
        <StatCard title="الذاكرة" value={`${memUsed}%`} subtitle={formatSize(freeMem) + " متاح"} icon={MemoryStick} variant={memUsed > 85 ? "warning" : "default"} />
        <StatCard title="Interfaces" value={totalInterfaces} subtitle="نشط" icon={Network} />
        <StatCard title="جلسات UM" value={activeSessions} subtitle="نشطة" icon={Zap} />
      </div>

      {/* Today's Sales Summary */}
      <div className="grid grid-cols-2 sm:grid-cols-3 gap-3 mb-6">
        <StatCard title="مبيعات اليوم" value={todayRevenue.toLocaleString()} icon={DollarSign} variant="accent" />
        <StatCard title="كروت اليوم" value={todayCardsCount} icon={CreditCard} />
        <Link to="/sales" className="col-span-2 sm:col-span-1">
          <div className="rounded-xl border border-border bg-card p-4 hover:border-primary/30 card-hover h-full flex flex-col justify-center shadow-card">
            <div className="flex items-center gap-2 text-xs text-muted-foreground mb-1.5">
              <TrendingUp className="h-3.5 w-3.5" />
              أفضل باقة اليوم
            </div>
            <p className="text-sm font-semibold text-foreground truncate">{topPackageToday || "—"}</p>
            <p className="text-[10px] text-primary mt-1.5 flex items-center gap-1 font-medium">عرض التقارير <ArrowRight className="h-2.5 w-2.5" /></p>
          </div>
        </Link>
      </div>

      {/* System Info + Uptime */}
      <div className="grid grid-cols-1 lg:grid-cols-3 gap-3 mb-6">
        <div className="lg:col-span-2">
          <SystemInfoCard resource={sysResource} identity={identity} routerboard={routerboard} />
        </div>
        <div className="space-y-3">
          <StatCard title="وقت التشغيل" value={uptime} icon={Clock} variant="accent" />
          <StatCard title="التخزين" value={`${hddUsed}%`} subtitle={formatSize(freeHdd) + " متاح"} icon={HardDrive} variant={hddUsed > 90 ? "warning" : "default"} />
          <StatCard title="DHCP" value={totalLeases} subtitle="تأجير" icon={Gauge} />
        </div>
      </div>

      {/* Traffic Chart */}
      <div className="mb-6">
        <TrafficChart interfaces={interfaces} />
      </div>

      {/* Active Hotspot Users */}
      {Array.isArray(hotspotUsers) && hotspotUsers.length > 0 && (
        <div className="rounded-xl border border-border bg-card shadow-card p-5 mb-6">
          <div className="flex items-center justify-between mb-4">
            <h3 className="text-xs font-semibold text-foreground uppercase tracking-widest flex items-center gap-2">
              <span className="h-3.5 w-0.5 rounded-full bg-accent" />
              <Wifi className="h-3.5 w-3.5" />
              المتصلين ({hotspotUsers.length})
            </h3>
            <Link to="/hotspot" className="text-xs text-muted-foreground hover:text-primary transition-colors flex items-center gap-1 font-medium">
              عرض الكل <ArrowRight className="h-3 w-3" />
            </Link>
          </div>
          <div className="overflow-x-auto">
            <table className="w-full text-xs">
              <thead>
                <tr className="text-muted-foreground border-b border-border">
                  <th className="text-right pb-2.5 pt-0.5 font-medium">المستخدم</th>
                  <th className="text-right pb-2.5 pt-0.5 font-medium">IP</th>
                  <th className="text-right pb-2.5 pt-0.5 font-medium hidden sm:table-cell">MAC</th>
                  <th className="text-right pb-2.5 pt-0.5 font-medium">المدة</th>
                  <th className="text-right pb-2.5 pt-0.5 font-medium">↓</th>
                  <th className="text-right pb-2.5 pt-0.5 font-medium">↑</th>
                </tr>
              </thead>
              <tbody>
                {hotspotUsers.slice(0, 8).map((u: any, i: number) => (
                  <tr key={i} className="border-b border-border/30 hover:bg-muted/40 transition-colors">
                    <td className="py-2.5 font-semibold text-foreground">{u.user || "—"}</td>
                    <td className="py-2.5 font-mono text-muted-foreground">{u.address || "—"}</td>
                    <td className="py-2.5 font-mono text-muted-foreground hidden sm:table-cell">{u["mac-address"] || "—"}</td>
                    <td className="py-2.5 text-muted-foreground">{u.uptime || "—"}</td>
                    <td className="py-2.5 font-mono text-foreground">{formatSize(u["bytes-in"])}</td>
                    <td className="py-2.5 font-mono text-foreground">{formatSize(u["bytes-out"])}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}

      {/* Interfaces */}
      {Array.isArray(interfaces) && interfaces.length > 0 && (
        <div className="rounded-xl border border-border bg-card shadow-card p-5">
          <h3 className="text-xs font-semibold text-foreground mb-4 uppercase tracking-widest flex items-center gap-2">
            <span className="h-3.5 w-0.5 rounded-full bg-primary" />
            <Network className="h-3.5 w-3.5" />
            الواجهات
          </h3>
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-2.5">
            {interfaces.filter((i: any) => i.type !== "loopback").slice(0, 9).map((iface: any, i: number) => {
              const running = iface.running === "true" || iface.running === true;
              return (
                <div key={i} className={`p-3 rounded-lg border transition-all ${running ? "border-accent/25 bg-accent/5" : "border-border bg-muted/30"}`}>
                  <div className="flex items-center justify-between mb-1.5">
                    <span className="text-xs font-semibold text-foreground font-mono">{iface.name}</span>
                    <span className={`h-2 w-2 rounded-full ${running ? "bg-accent animate-pulse-glow" : "bg-muted-foreground/25"}`} />
                  </div>
                  <div className="text-[10px] text-muted-foreground font-mono">
                    ↓ {formatSize(iface["rx-byte"])} / ↑ {formatSize(iface["tx-byte"])}
                  </div>
                </div>
              );
            })}
          </div>
        </div>
      )}
    </DashboardLayout>
  );
}

function formatSize(bytes: string | number | undefined): string {
  if (!bytes) return "0 B";
  const b = Number(bytes);
  if (b < 1024) return b + " B";
  if (b < 1048576) return (b / 1024).toFixed(1) + " KB";
  if (b < 1073741824) return (b / 1048576).toFixed(1) + " MB";
  return (b / 1073741824).toFixed(2) + " GB";
}
