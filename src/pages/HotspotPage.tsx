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
          <h2 className="text-2xl font-bold text-foreground flex items-center gap-2">
            <Wifi className="h-6 w-6 text-primary" />
            الهوتسبوت
          </h2>
          <p className="text-muted-foreground text-sm">إدارة مستخدمي الهوتسبوت والكروت</p>
        </div>
        <button
          onClick={refresh}
          className="p-2 rounded-lg bg-secondary hover:bg-secondary/80 text-secondary-foreground transition-colors"
        >
          <RefreshCw className="h-5 w-5" />
        </button>
      </div>

      <Tabs defaultValue="active" dir="rtl">
        <TabsList className="bg-secondary mb-4">
          <TabsTrigger value="active">المتصلين ({Array.isArray(activeUsers) ? activeUsers.length : 0})</TabsTrigger>
          <TabsTrigger value="users">جميع المستخدمين ({Array.isArray(allUsers) ? allUsers.length : 0})</TabsTrigger>
          <TabsTrigger value="profiles">البروفايلات ({Array.isArray(profiles) ? profiles.length : 0})</TabsTrigger>
        </TabsList>

        <TabsContent value="active">
          <div className="gradient-card rounded-xl border border-border shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border text-muted-foreground">
                    <th className="text-right p-4 font-medium">المستخدم</th>
                    <th className="text-right p-4 font-medium">IP</th>
                    <th className="text-right p-4 font-medium">MAC</th>
                    <th className="text-right p-4 font-medium">وقت الاتصال</th>
                    <th className="text-right p-4 font-medium">التحميل</th>
                    <th className="text-right p-4 font-medium">الرفع</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingActive ? (
                    <tr><td colSpan={6} className="p-8 text-center text-muted-foreground">جاري التحميل...</td></tr>
                  ) : !Array.isArray(activeUsers) || activeUsers.length === 0 ? (
                    <tr><td colSpan={6} className="p-8 text-center text-muted-foreground">لا يوجد متصلين حالياً</td></tr>
                  ) : (
                    activeUsers.map((user: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-secondary/50 transition-colors">
                        <td className="p-4 font-medium text-foreground">{user.user || "—"}</td>
                        <td className="p-4 font-mono text-sm text-muted-foreground">{user.address || "—"}</td>
                        <td className="p-4 font-mono text-sm text-muted-foreground">{user["mac-address"] || "—"}</td>
                        <td className="p-4 text-muted-foreground">{user.uptime || "—"}</td>
                        <td className="p-4 text-primary">{formatBytes(user["bytes-in"])}</td>
                        <td className="p-4 text-accent">{formatBytes(user["bytes-out"])}</td>
                      </tr>
                    ))
                  )}
                </tbody>
              </table>
            </div>
          </div>
        </TabsContent>

        <TabsContent value="users">
          <div className="gradient-card rounded-xl border border-border shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border text-muted-foreground">
                    <th className="text-right p-4 font-medium">اسم المستخدم</th>
                    <th className="text-right p-4 font-medium">البروفايل</th>
                    <th className="text-right p-4 font-medium">الحد</th>
                    <th className="text-right p-4 font-medium">معطل</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingAll ? (
                    <tr><td colSpan={4} className="p-8 text-center text-muted-foreground">جاري التحميل...</td></tr>
                  ) : !Array.isArray(allUsers) || allUsers.length === 0 ? (
                    <tr><td colSpan={4} className="p-8 text-center text-muted-foreground">لا يوجد مستخدمين</td></tr>
                  ) : (
                    allUsers.map((user: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-secondary/50 transition-colors">
                        <td className="p-4 font-medium text-foreground">{user.name || "—"}</td>
                        <td className="p-4 text-muted-foreground">{user.profile || "—"}</td>
                        <td className="p-4 text-muted-foreground">{user["limit-uptime"] || "—"}</td>
                        <td className="p-4">
                          <span className={`px-2 py-1 rounded-full text-xs font-medium ${
                            user.disabled === "true" || user.disabled === true
                              ? "bg-destructive/20 text-destructive" 
                              : "bg-success/20 text-success"
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
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
            {Array.isArray(profiles) && profiles.map((profile: any, i: number) => (
              <div key={i} className="gradient-card rounded-xl border border-border shadow-card p-5">
                <h3 className="font-bold text-foreground mb-3">{profile.name}</h3>
                <div className="space-y-2 text-sm">
                  {profile["rate-limit"] && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground">السرعة</span>
                      <span className="font-mono text-primary">{profile["rate-limit"]}</span>
                    </div>
                  )}
                  {profile["shared-users"] && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground">مشاركة</span>
                      <span className="text-foreground">{profile["shared-users"]}</span>
                    </div>
                  )}
                  {profile["session-timeout"] && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground">المدة</span>
                      <span className="text-foreground">{profile["session-timeout"]}</span>
                    </div>
                  )}
                </div>
              </div>
            ))}
            {(!Array.isArray(profiles) || profiles.length === 0) && (
              <p className="text-muted-foreground col-span-full text-center py-8">لا توجد بروفايلات</p>
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
