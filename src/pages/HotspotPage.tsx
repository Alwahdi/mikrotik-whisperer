import DashboardLayout from "@/components/DashboardLayout";
import { useHotspotUsers, useHotspotAllUsers, useHotspotProfiles } from "@/hooks/useMikrotik";
import { Wifi, RefreshCw, Users, UserCheck, UserX } from "lucide-react";
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
          <h2 className="text-lg font-bold text-foreground">الهوتسبوت</h2>
          <p className="text-muted-foreground text-xs mt-0.5">إدارة مستخدمي الهوتسبوت</p>
        </div>
        <button
          onClick={refresh}
          className="p-2 rounded-lg border border-border bg-card text-muted-foreground hover:text-foreground hover:border-foreground/20 transition-colors"
        >
          <RefreshCw className="h-4 w-4" />
        </button>
      </div>

      {/* Quick Stats */}
      <div className="grid grid-cols-3 gap-3 mb-5">
        <div className="rounded-lg border border-border bg-card p-3">
          <div className="flex items-center gap-2 mb-1">
            <Wifi className="h-3.5 w-3.5 text-success" />
            <span className="text-xs text-muted-foreground">متصلين</span>
          </div>
          <p className="text-xl font-bold text-foreground">{loadingActive ? "—" : (Array.isArray(activeUsers) ? activeUsers.length : 0)}</p>
        </div>
        <div className="rounded-lg border border-border bg-card p-3">
          <div className="flex items-center gap-2 mb-1">
            <Users className="h-3.5 w-3.5 text-foreground" />
            <span className="text-xs text-muted-foreground">إجمالي</span>
          </div>
          <p className="text-xl font-bold text-foreground">{loadingAll ? "—" : (Array.isArray(allUsers) ? allUsers.length : 0)}</p>
        </div>
        <div className="rounded-lg border border-border bg-card p-3">
          <div className="flex items-center gap-2 mb-1">
            <span className="text-xs text-muted-foreground">بروفايلات</span>
          </div>
          <p className="text-xl font-bold text-foreground">{Array.isArray(profiles) ? profiles.length : 0}</p>
        </div>
      </div>

      <Tabs defaultValue="active" dir="rtl">
        <TabsList className="bg-muted mb-4 w-full justify-start">
          <TabsTrigger value="active" className="text-xs">المتصلين</TabsTrigger>
          <TabsTrigger value="users" className="text-xs">المستخدمين</TabsTrigger>
          <TabsTrigger value="profiles" className="text-xs">البروفايلات</TabsTrigger>
        </TabsList>

        <TabsContent value="active">
          <div className="rounded-lg border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">IP</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">MAC</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">المدة</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">↓</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">↑</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingActive ? (
                    <tr><td colSpan={6} className="p-10 text-center text-muted-foreground text-sm">جاري التحميل...</td></tr>
                  ) : !Array.isArray(activeUsers) || activeUsers.length === 0 ? (
                    <tr>
                      <td colSpan={6} className="p-10 text-center">
                        <Wifi className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                        <p className="text-muted-foreground text-sm">لا يوجد متصلين حالياً</p>
                      </td>
                    </tr>
                  ) : (
                    activeUsers.map((user: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="p-3 font-medium text-foreground text-sm">{user.user || "—"}</td>
                        <td className="p-3 font-mono text-xs text-muted-foreground">{user.address || "—"}</td>
                        <td className="p-3 font-mono text-xs text-muted-foreground">{user["mac-address"] || "—"}</td>
                        <td className="p-3 text-muted-foreground text-xs">{user.uptime || "—"}</td>
                        <td className="p-3 font-mono text-xs text-foreground">{formatBytes(user["bytes-in"])}</td>
                        <td className="p-3 font-mono text-xs text-foreground">{formatBytes(user["bytes-out"])}</td>
                      </tr>
                    ))
                  )}
                </tbody>
              </table>
            </div>
          </div>
        </TabsContent>

        <TabsContent value="users">
          <div className="rounded-lg border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">البروفايل</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">الحد</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">الحالة</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingAll ? (
                    <tr><td colSpan={4} className="p-10 text-center text-muted-foreground text-sm">جاري التحميل...</td></tr>
                  ) : !Array.isArray(allUsers) || allUsers.length === 0 ? (
                    <tr>
                      <td colSpan={4} className="p-10 text-center">
                        <Users className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                        <p className="text-muted-foreground text-sm">لا يوجد مستخدمين</p>
                      </td>
                    </tr>
                  ) : (
                    allUsers.map((user: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="p-3 font-medium text-foreground text-sm">{user.name || "—"}</td>
                        <td className="p-3 text-muted-foreground text-xs">{user.profile || "—"}</td>
                        <td className="p-3 text-muted-foreground text-xs">{user["limit-uptime"] || "—"}</td>
                        <td className="p-3">
                          {user.disabled === "true" || user.disabled === true ? (
                            <span className="inline-flex items-center gap-1 text-xs text-destructive">
                              <UserX className="h-3 w-3" /> معطل
                            </span>
                          ) : (
                            <span className="inline-flex items-center gap-1 text-xs text-success">
                              <UserCheck className="h-3 w-3" /> نشط
                            </span>
                          )}
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
              <div key={i} className="rounded-lg border border-border bg-card shadow-card p-4">
                <h3 className="font-semibold text-foreground mb-3 text-sm">{profile.name}</h3>
                <div className="space-y-2 text-sm">
                  {profile["rate-limit"] && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground text-xs">السرعة</span>
                      <span className="font-mono text-foreground text-xs">{profile["rate-limit"]}</span>
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
              <div className="col-span-full text-center py-10">
                <p className="text-muted-foreground text-sm">لا توجد بروفايلات</p>
              </div>
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
