import DashboardLayout from "@/components/DashboardLayout";
import { useHotspotUsers, useHotspotAllUsers, useHotspotProfiles } from "@/hooks/useMikrotik";
import { Wifi, RefreshCw } from "lucide-react";
import { useQueryClient } from "@tanstack/react-query";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";

export default function HotspotPage() {
  const { data: activeUsers, isLoading: loadingActive } = useHotspotUsers();
  const { data: allUsers, isLoading: loadingAll } = useHotspotAllUsers();
  const { data: profiles } = useHotspotProfiles();
  const queryClient = useQueryClient();

  const refresh = () => {
    queryClient.invalidateQueries({ queryKey: ["mikrotik", "hotspot"] });
  };

  return (
    <DashboardLayout>
      <div className="flex items-center justify-between mb-6">
        <div>
          <h2 className="text-xl font-bold text-foreground flex items-center gap-2">
            <Wifi className="h-5 w-5 text-primary" />
            الهوتسبوت
          </h2>
          <p className="text-muted-foreground text-sm">إدارة مستخدمي الهوتسبوت</p>
        </div>
        <button
          onClick={refresh}
          className="p-2 rounded-lg bg-muted hover:bg-muted/80 text-muted-foreground hover:text-foreground transition-colors"
        >
          <RefreshCw className="h-4 w-4" />
        </button>
      </div>

      <Tabs defaultValue="active" dir="rtl">
        <TabsList className="bg-muted mb-4">
          <TabsTrigger value="active">المتصلين ({Array.isArray(activeUsers) ? activeUsers.length : 0})</TabsTrigger>
          <TabsTrigger value="users">المستخدمين ({Array.isArray(allUsers) ? allUsers.length : 0})</TabsTrigger>
          <TabsTrigger value="profiles">البروفايلات ({Array.isArray(profiles) ? profiles.length : 0})</TabsTrigger>
        </TabsList>

        <TabsContent value="active">
          <div className="rounded-xl border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border text-muted-foreground bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs">IP</th>
                    <th className="text-right p-3 font-medium text-xs">MAC</th>
                    <th className="text-right p-3 font-medium text-xs">المدة</th>
                    <th className="text-right p-3 font-medium text-xs">↓ تحميل</th>
                    <th className="text-right p-3 font-medium text-xs">↑ رفع</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingActive ? (
                    <tr><td colSpan={6} className="p-8 text-center text-muted-foreground text-sm">جاري التحميل...</td></tr>
                  ) : !Array.isArray(activeUsers) || activeUsers.length === 0 ? (
                    <tr><td colSpan={6} className="p-8 text-center text-muted-foreground text-sm">لا يوجد متصلين حالياً</td></tr>
                  ) : (
                    activeUsers.map((user: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="p-3 font-medium text-foreground text-sm">{user.user || "—"}</td>
                        <td className="p-3 font-mono text-xs text-muted-foreground">{user.address || "—"}</td>
                        <td className="p-3 font-mono text-xs text-muted-foreground">{user["mac-address"] || "—"}</td>
                        <td className="p-3 text-muted-foreground text-sm">{user.uptime || "—"}</td>
                        <td className="p-3 text-primary text-sm">{formatBytes(user["bytes-in"])}</td>
                        <td className="p-3 text-accent text-sm">{formatBytes(user["bytes-out"])}</td>
                      </tr>
                    ))
                  )}
                </tbody>
              </table>
            </div>
          </div>
        </TabsContent>

        <TabsContent value="users">
          <div className="rounded-xl border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border text-muted-foreground bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs">البروفايل</th>
                    <th className="text-right p-3 font-medium text-xs">الحد</th>
                    <th className="text-right p-3 font-medium text-xs">الحالة</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingAll ? (
                    <tr><td colSpan={4} className="p-8 text-center text-muted-foreground text-sm">جاري التحميل...</td></tr>
                  ) : !Array.isArray(allUsers) || allUsers.length === 0 ? (
                    <tr><td colSpan={4} className="p-8 text-center text-muted-foreground text-sm">لا يوجد مستخدمين</td></tr>
                  ) : (
                    allUsers.map((user: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="p-3 font-medium text-foreground text-sm">{user.name || "—"}</td>
                        <td className="p-3 text-muted-foreground text-sm">{user.profile || "—"}</td>
                        <td className="p-3 text-muted-foreground text-sm">{user["limit-uptime"] || "—"}</td>
                        <td className="p-3">
                          <span className={`px-2 py-0.5 rounded-full text-xs font-medium ${
                            user.disabled === "true" || user.disabled === true
                              ? "bg-destructive/10 text-destructive" 
                              : "bg-success/10 text-success"
                          }`}>
                            {user.disabled === "true" || user.disabled === true ? "معطل" : "نشط"}
                          </span>
                        </td>
                      </tr>
                    ))
                  )}
                </tbody>
              </table>
            </div>
          </div>
        </TabsContent>

        <TabsContent value="profiles">
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-3">
            {Array.isArray(profiles) && profiles.map((profile: any, i: number) => (
              <div key={i} className="rounded-xl border border-border bg-card shadow-card p-4">
                <h3 className="font-semibold text-foreground mb-3 text-sm">{profile.name}</h3>
                <div className="space-y-2 text-sm">
                  {profile["rate-limit"] && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground text-xs">السرعة</span>
                      <span className="font-mono text-primary text-xs">{profile["rate-limit"]}</span>
                    </div>
                  )}
                  {profile["shared-users"] && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground text-xs">مشاركة</span>
                      <span className="text-foreground text-xs">{profile["shared-users"]}</span>
                    </div>
                  )}
                  {profile["session-timeout"] && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground text-xs">المدة</span>
                      <span className="text-foreground text-xs">{profile["session-timeout"]}</span>
                    </div>
                  )}
                </div>
              </div>
            ))}
            {(!Array.isArray(profiles) || profiles.length === 0) && (
              <p className="text-muted-foreground col-span-full text-center py-8 text-sm">لا توجد بروفايلات</p>
            )}
          </div>
        </TabsContent>
      </Tabs>
    </DashboardLayout>
  );
}

function formatBytes(bytes: string | number | undefined): string {
  if (!bytes) return "0 B";
  const b = Number(bytes);
  if (b < 1024) return b + " B";
  if (b < 1048576) return (b / 1024).toFixed(1) + " KB";
  if (b < 1073741824) return (b / 1048576).toFixed(1) + " MB";
  return (b / 1073741824).toFixed(2) + " GB";
}
