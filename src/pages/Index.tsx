import DashboardLayout from "@/components/DashboardLayout";
import StatCard from "@/components/StatCard";
import SystemInfoCard from "@/components/SystemInfoCard";
import TrafficChart from "@/components/TrafficChart";
import {
  Wifi, Users, Cpu, HardDrive, Clock, Activity, Settings,
  Network, Gauge, MemoryStick,
} from "lucide-react";
import {
  useHotspotUsers, useUserManagerUsers,
  useSystemResources, useSystemIdentity, useRouterboard,
  useInterfaces, useDHCPLeases,
} from "@/hooks/useMikrotik";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { Link } from "react-router-dom";

export default function Index() {
  const config = getMikrotikConfig();

  const { data: hotspotUsers, isLoading: loadingH } = useHotspotUsers();
  const { data: umUsers, isLoading: loadingU } = useUserManagerUsers();
  const { data: sysResource } = useSystemResources();
  const { data: identity } = useSystemIdentity();
  const { data: routerboard } = useRouterboard();
  const { data: interfaces } = useInterfaces();
  const { data: dhcpLeases } = useDHCPLeases();

  if (!config) {
    return (
      <DashboardLayout>
        <div className="flex flex-col items-center justify-center min-h-[60vh] text-center">
          <div className="p-4 rounded-2xl bg-primary/10 mb-6 animate-pulse-glow">
            <Settings className="h-12 w-12 text-primary" />
          </div>
          <h2 className="text-2xl font-bold text-foreground mb-2">مرحباً بك!</h2>
          <p className="text-muted-foreground mb-2 max-w-md">
            عشان تبدأ، لازم تدخل بيانات الاتصال بجهاز المايكروتيك.
          </p>
          <p className="text-muted-foreground text-xs mb-6 max-w-md">
            يدعم RouterOS v6 (API) و v7+ (REST API) • IP محلي أو عام أو Cloud DDNS
          </p>
          <Link
            to="/settings"
            className="gradient-primary text-primary-foreground font-medium py-3 px-8 rounded-lg text-sm hover:opacity-90 transition-opacity"
          >
            إعداد الاتصال
          </Link>
        </div>
      </DashboardLayout>
    );
  }

  const activeCount = Array.isArray(hotspotUsers) ? hotspotUsers.length : 0;
  const totalUsers = Array.isArray(umUsers) ? umUsers.length : 0;
  const totalLeases = Array.isArray(dhcpLeases) ? dhcpLeases.length : 0;
  const totalInterfaces = Array.isArray(interfaces) ? interfaces.filter((i: any) => i.running === "true" || i.running === true).length : 0;
  const cpuLoad = sysResource?.["cpu-load"] ?? "—";
  const uptime = sysResource?.uptime ?? "—";
  const totalMem = Number(sysResource?.["total-memory"] || 0);
  const freeMem = Number(sysResource?.["free-memory"] || 0);
  const memUsed = totalMem > 0 ? Math.round(((totalMem - freeMem) / totalMem) * 100) : 0;
  const totalHdd = Number(sysResource?.["total-hdd-space"] || 0);
  const freeHdd = Number(sysResource?.["free-hdd-space"] || 0);
  const hddUsed = totalHdd > 0 ? Math.round(((totalHdd - freeHdd) / totalHdd) * 100) : 0;
  const routerName = identity?.name ?? config.label ?? "MikroTik";

  return (
    <DashboardLayout>
      {/* Header */}
      <div className="mb-6">
        <h2 className="text-2xl font-bold text-foreground">{routerName}</h2>
        <p className="text-muted-foreground text-sm flex items-center gap-2">
          <span className="h-2 w-2 rounded-full bg-success inline-block animate-pulse-glow" />
          {sysResource?.version || "RouterOS"} • {config.mode === "rest" ? "REST API" : "MikroTik API"}
        </p>
      </div>

      {/* Key Metrics */}
      <div className="grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-6 gap-3 mb-6">
        <StatCard title="المتصلين" value={loadingH ? "..." : activeCount} subtitle="هوتسبوت" icon={Wifi} variant="primary" />
        <StatCard title="المستخدمين" value={loadingU ? "..." : totalUsers} subtitle="يوزر مانجر" icon={Users} variant="accent" />
        <StatCard title="CPU" value={`${cpuLoad}%`} icon={Cpu} variant={Number(cpuLoad) > 80 ? "warning" : "default"} />
        <StatCard title="الذاكرة" value={`${memUsed}%`} subtitle={formatSize(freeMem) + " متاح"} icon={MemoryStick} variant={memUsed > 85 ? "warning" : "default"} />
        <StatCard title="Interfaces" value={totalInterfaces} subtitle="نشط" icon={Network} />
        <StatCard title="DHCP" value={totalLeases} subtitle="تأجير" icon={Gauge} />
      </div>

      {/* System Info + Uptime */}
      <div className="grid grid-cols-1 lg:grid-cols-3 gap-4 mb-6">
        <div className="lg:col-span-2">
          <SystemInfoCard resource={sysResource} identity={identity} routerboard={routerboard} />
        </div>
        <div className="space-y-4">
          <StatCard title="وقت التشغيل" value={uptime} icon={Clock} variant="accent" />
          <StatCard title="التخزين" value={`${hddUsed}%`} subtitle={formatSize(freeHdd) + " متاح"} icon={HardDrive} variant={hddUsed > 90 ? "warning" : "default"} />
          <StatCard title="حالة النظام" value="متصل" icon={Activity} variant="accent" />
        </div>
      </div>

      {/* Traffic Chart */}
      <div className="mb-6">
        <TrafficChart interfaces={interfaces} />
      </div>

      {/* Active Hotspot Users Quick View */}
      {Array.isArray(hotspotUsers) && hotspotUsers.length > 0 && (
        <div className="gradient-card rounded-xl border border-border shadow-card p-5 mb-6">
          <div className="flex items-center justify-between mb-4">
            <h3 className="text-sm font-semibold text-foreground flex items-center gap-2">
              <Wifi className="h-4 w-4 text-primary" />
              المتصلين الآن ({hotspotUsers.length})
            </h3>
            <Link to="/hotspot" className="text-xs text-primary hover:underline">عرض الكل ←</Link>
          </div>
          <div className="overflow-x-auto">
            <table className="w-full text-xs">
              <thead>
                <tr className="text-muted-foreground border-b border-border">
                  <th className="text-right p-2 font-medium">المستخدم</th>
                  <th className="text-right p-2 font-medium">IP</th>
                  <th className="text-right p-2 font-medium">MAC</th>
                  <th className="text-right p-2 font-medium">مدة الاتصال</th>
                  <th className="text-right p-2 font-medium">↓ تحميل</th>
                  <th className="text-right p-2 font-medium">↑ رفع</th>
                </tr>
              </thead>
              <tbody>
                {hotspotUsers.slice(0, 10).map((u: any, i: number) => (
                  <tr key={i} className="border-b border-border/30 hover:bg-secondary/50 transition-colors">
                    <td className="p-2 font-medium text-foreground">{u.user || "—"}</td>
                    <td className="p-2 font-mono text-muted-foreground">{u.address || "—"}</td>
                    <td className="p-2 font-mono text-muted-foreground">{u["mac-address"] || "—"}</td>
                    <td className="p-2 text-muted-foreground">{u.uptime || "—"}</td>
                    <td className="p-2 text-primary">{formatSize(u["bytes-in"])}</td>
                    <td className="p-2 text-accent">{formatSize(u["bytes-out"])}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}

      {/* Interfaces Quick View */}
      {Array.isArray(interfaces) && interfaces.length > 0 && (
        <div className="gradient-card rounded-xl border border-border shadow-card p-5">
          <h3 className="text-sm font-semibold text-foreground mb-4 flex items-center gap-2">
            <Network className="h-4 w-4 text-info" />
            حالة الواجهات
          </h3>
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-3">
            {interfaces.filter((i: any) => i.type !== "loopback").slice(0, 9).map((iface: any, i: number) => {
              const running = iface.running === "true" || iface.running === true;
              return (
                <div key={i} className={`p-3 rounded-lg border ${running ? "border-success/20 bg-success/5" : "border-border bg-secondary/50"}`}>
                  <div className="flex items-center justify-between mb-1">
                    <span className="text-xs font-medium text-foreground font-mono">{iface.name}</span>
                    <span className={`h-2 w-2 rounded-full ${running ? "bg-success" : "bg-muted-foreground"}`} />
                  </div>
                  <div className="text-[10px] text-muted-foreground space-y-0.5">
                    <div>↓ {formatSize(iface["rx-byte"])} / ↑ {formatSize(iface["tx-byte"])}</div>
                    {iface.type && <div>{iface.type}</div>}
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
