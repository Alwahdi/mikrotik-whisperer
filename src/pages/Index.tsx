import DashboardLayout from "@/components/DashboardLayout";
import StatCard from "@/components/StatCard";
import { Wifi, Users, Activity, Cpu, HardDrive, Clock, Settings } from "lucide-react";
import { useHotspotUsers, useUserManagerUsers, useSystemResources, useSystemIdentity } from "@/hooks/useMikrotik";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { Link } from "react-router-dom";

export default function Index() {
  const config = getMikrotikConfig();
  const { data: hotspotUsers, isLoading: loadingHotspot } = useHotspotUsers();
  const { data: umUsers, isLoading: loadingUM } = useUserManagerUsers();
  const { data: sysResource } = useSystemResources();
  const { data: identity } = useSystemIdentity();

  if (!config) {
    return (
      <DashboardLayout>
        <div className="flex flex-col items-center justify-center min-h-[60vh] text-center">
          <div className="p-4 rounded-2xl bg-primary/10 mb-6">
            <Settings className="h-12 w-12 text-primary" />
          </div>
          <h2 className="text-2xl font-bold text-foreground mb-2">مرحباً بك!</h2>
          <p className="text-muted-foreground mb-6 max-w-md">
            عشان تبدأ تستخدم البرنامج، لازم تدخل بيانات الاتصال بجهاز المايكروتيك أولاً.
          </p>
          <Link
            to="/settings"
            className="gradient-primary text-primary-foreground font-medium py-3 px-6 rounded-lg text-sm hover:opacity-90 transition-opacity"
          >
            إعداد الاتصال
          </Link>
        </div>
      </DashboardLayout>
    );
  }

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
        <StatCard title="المتصلين الآن" value={loadingHotspot ? "..." : activeCount} subtitle="هوتسبوت نشط" icon={Wifi} variant="primary" />
        <StatCard title="إجمالي المستخدمين" value={loadingUM ? "..." : totalUsers} subtitle="يوزر مانجر" icon={Users} variant="accent" />
        <StatCard title="حمل المعالج" value={`${cpuLoad}%`} subtitle="CPU" icon={Cpu} variant={Number(cpuLoad) > 80 ? "warning" : "default"} />
        <StatCard title="الذاكرة المتاحة" value={freeMemory} icon={HardDrive} />
        <StatCard title="وقت التشغيل" value={uptime} icon={Clock} />
        <StatCard title="حالة النظام" value="متصل" subtitle="RouterOS" icon={Activity} variant="accent" />
      </div>
    </DashboardLayout>
  );
}
