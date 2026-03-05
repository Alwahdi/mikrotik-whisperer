import DashboardLayout from "@/components/DashboardLayout";
import StatCard from "@/components/StatCard";
import { Wifi, Users, Activity, Cpu, HardDrive, Clock } from "lucide-react";
import { useHotspotUsers, useUserManagerUsers, useSystemResources, useSystemIdentity } from "@/hooks/useMikrotik";

export default function Index() {
  const { data: hotspotUsers, isLoading: loadingHotspot } = useHotspotUsers();
  const { data: umUsers, isLoading: loadingUM } = useUserManagerUsers();
  const { data: sysResource } = useSystemResources();
  const { data: identity } = useSystemIdentity();

  const activeCount = Array.isArray(hotspotUsers) ? hotspotUsers.length : 0;
  const totalUsers = Array.isArray(umUsers) ? umUsers.length : 0;
  const cpuLoad = sysResource?.["cpu-load"] ?? "—";
  const uptime = sysResource?.uptime ?? "—";
  const freeMemory = sysResource?.["free-memory"] ? 
    Math.round(Number(sysResource["free-memory"]) / 1048576) + " MB" : "—";
  const routerName = identity?.name ?? "MikroTik";

  return (
    <DashboardLayout>
      <div className="mb-6">
        <h2 className="text-2xl font-bold text-foreground">{routerName}</h2>
        <p className="text-muted-foreground text-sm">نظرة عامة على حالة الشبكة</p>
      </div>

      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4 mb-8">
        <StatCard
          title="المتصلين الآن"
          value={loadingHotspot ? "..." : activeCount}
          subtitle="هوتسبوت نشط"
          icon={Wifi}
          variant="primary"
        />
        <StatCard
          title="إجمالي المستخدمين"
          value={loadingUM ? "..." : totalUsers}
          subtitle="يوزر مانجر"
          icon={Users}
          variant="accent"
        />
        <StatCard
          title="حمل المعالج"
          value={`${cpuLoad}%`}
          subtitle="CPU"
          icon={Cpu}
          variant={Number(cpuLoad) > 80 ? "warning" : "default"}
        />
        <StatCard
          title="الذاكرة المتاحة"
          value={freeMemory}
          icon={HardDrive}
        />
        <StatCard
          title="وقت التشغيل"
          value={uptime}
          icon={Clock}
        />
        <StatCard
          title="حالة النظام"
          value="متصل"
          subtitle="RouterOS"
          icon={Activity}
          variant="accent"
        />
      </div>
    </DashboardLayout>
  );
}
