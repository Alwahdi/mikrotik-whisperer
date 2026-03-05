import DashboardLayout from "@/components/DashboardLayout";
import { useUserManagerUsers, useUserManagerProfiles, useUserManagerSessions } from "@/hooks/useMikrotik";
import { Users, RefreshCw, AlertTriangle, Package, Clock, UserCheck, UserX } from "lucide-react";
import { useQueryClient } from "@tanstack/react-query";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";

export default function UserManagerPage() {
  const { data: users, isLoading: loadingUsers, error: usersError } = useUserManagerUsers();
  const { data: profiles, isLoading: loadingProfiles, error: profilesError } = useUserManagerProfiles();
  const { data: sessions, isLoading: loadingSessions, error: sessionsError } = useUserManagerSessions();
  const queryClient = useQueryClient();

  const refresh = () => {
    queryClient.invalidateQueries({ queryKey: ["mikrotik", "usermanager"] });
  };

  const hasError = usersError || profilesError || sessionsError;
  const isNotInstalled = hasError && (
    (usersError as any)?.message?.includes("غير مثبّت") ||
    (usersError as any)?.message?.includes("no such command")
  );

  const activeUsers = Array.isArray(users) ? users.filter((u: any) => u.disabled !== "true" && u.disabled !== true) : [];
  const disabledUsers = Array.isArray(users) ? users.filter((u: any) => u.disabled === "true" || u.disabled === true) : [];

  return (
    <DashboardLayout>
      {/* Header */}
      <div className="flex items-center justify-between mb-6">
        <div>
          <h2 className="text-lg font-bold text-foreground">يوزر مانجر</h2>
          <p className="text-muted-foreground text-xs mt-0.5">إدارة المستخدمين والباقات والجلسات</p>
        </div>
        <button
          onClick={refresh}
          className="p-2 rounded-lg border border-border bg-card text-muted-foreground hover:text-foreground hover:border-foreground/20 transition-colors"
        >
          <RefreshCw className="h-4 w-4" />
        </button>
      </div>

      {/* Not installed warning */}
      {isNotInstalled && (
        <div className="mb-5 p-4 rounded-lg bg-warning/5 border border-warning/20">
          <div className="flex items-start gap-3">
            <AlertTriangle className="h-5 w-5 text-warning shrink-0 mt-0.5" />
            <div>
              <p className="font-semibold text-foreground text-sm">User Manager غير مثبّت</p>
              <p className="text-muted-foreground text-xs mt-1 leading-relaxed">
                حزمة User Manager غير مثبّتة أو غير مفعّلة على هذا الراوتر.
                لتفعيلها، حمّل الحزمة من موقع MikroTik المناسبة لإصدار نظامك ثم أعد تشغيل الراوتر.
              </p>
              <div className="flex gap-4 mt-3 text-xs text-muted-foreground">
                <span>v7: <code className="font-mono text-foreground">/user-manager/</code></span>
                <span>v6: <code className="font-mono text-foreground">/tool/user-manager/</code></span>
              </div>
            </div>
          </div>
        </div>
      )}

      {/* Error but not "not installed" */}
      {hasError && !isNotInstalled && (
        <div className="mb-5 p-4 rounded-lg bg-destructive/5 border border-destructive/20">
          <div className="flex items-start gap-3">
            <AlertTriangle className="h-5 w-5 text-destructive shrink-0 mt-0.5" />
            <div>
              <p className="font-semibold text-foreground text-sm">خطأ في الاتصال</p>
              <p className="text-muted-foreground text-xs mt-1">
                {(usersError as any)?.message || (profilesError as any)?.message || "حدث خطأ أثناء جلب البيانات"}
              </p>
            </div>
          </div>
        </div>
      )}

      {/* Quick Stats */}
      {!isNotInstalled && (
        <div className="grid grid-cols-3 gap-3 mb-5">
          <div className="rounded-lg border border-border bg-card p-3">
            <div className="flex items-center gap-2 mb-1">
              <UserCheck className="h-3.5 w-3.5 text-success" />
              <span className="text-xs text-muted-foreground">نشط</span>
            </div>
            <p className="text-xl font-bold text-foreground">{loadingUsers ? "—" : activeUsers.length}</p>
          </div>
          <div className="rounded-lg border border-border bg-card p-3">
            <div className="flex items-center gap-2 mb-1">
              <Package className="h-3.5 w-3.5 text-primary" />
              <span className="text-xs text-muted-foreground">باقات</span>
            </div>
            <p className="text-xl font-bold text-foreground">{loadingProfiles ? "—" : (Array.isArray(profiles) ? profiles.length : 0)}</p>
          </div>
          <div className="rounded-lg border border-border bg-card p-3">
            <div className="flex items-center gap-2 mb-1">
              <Clock className="h-3.5 w-3.5 text-info" />
              <span className="text-xs text-muted-foreground">جلسات</span>
            </div>
            <p className="text-xl font-bold text-foreground">{loadingSessions ? "—" : (Array.isArray(sessions) ? sessions.length : 0)}</p>
          </div>
        </div>
      )}

      {/* Tabs */}
      <Tabs defaultValue="users" dir="rtl">
        <TabsList className="bg-muted mb-4 w-full justify-start">
          <TabsTrigger value="users" className="text-xs">المستخدمين</TabsTrigger>
          <TabsTrigger value="profiles" className="text-xs">الباقات</TabsTrigger>
          <TabsTrigger value="sessions" className="text-xs">الجلسات</TabsTrigger>
        </TabsList>

        <TabsContent value="users">
          <div className="rounded-lg border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">الباقة</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">الحالة</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">التعليق</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingUsers ? (
                    <tr><td colSpan={4} className="p-10 text-center text-muted-foreground text-sm">جاري التحميل...</td></tr>
                  ) : !Array.isArray(users) || users.length === 0 ? (
                    <tr>
                      <td colSpan={4} className="p-10 text-center">
                        <Users className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                        <p className="text-muted-foreground text-sm">لا يوجد مستخدمين</p>
                        <p className="text-muted-foreground/60 text-xs mt-1">تأكد من تثبيت User Manager على الراوتر</p>
                      </td>
                    </tr>
                  ) : (
                    users.map((user: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="p-3 font-medium text-foreground text-sm">{user.name || user.username || "—"}</td>
                        <td className="p-3 text-muted-foreground text-xs">{user.group || user.profile || user.actual_profile || "—"}</td>
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
                        <td className="p-3 text-muted-foreground text-xs max-w-[200px] truncate">{user.comment || "—"}</td>
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
                <div className="flex items-center gap-2 mb-3">
                  <Package className="h-4 w-4 text-primary" />
                  <h3 className="font-semibold text-foreground text-sm">{profile.name}</h3>
                </div>
                <div className="space-y-2">
                  {profile["name-for-users"] && (
                    <Row label="الاسم" value={profile["name-for-users"]} />
                  )}
                  {profile.validity && (
                    <Row label="الصلاحية" value={profile.validity} />
                  )}
                  {profile.price && (
                    <Row label="السعر" value={profile.price} highlight />
                  )}
                  {profile["rate-limit"] && (
                    <Row label="السرعة" value={profile["rate-limit"]} />
                  )}
                </div>
              </div>
            ))}
            {(!Array.isArray(profiles) || profiles.length === 0) && (
              <div className="col-span-full text-center py-10">
                <Package className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                <p className="text-muted-foreground text-sm">لا توجد باقات</p>
              </div>
            )}
          </div>
        </TabsContent>

        <TabsContent value="sessions">
          <div className="rounded-lg border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">البداية</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">النهاية</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">↓ تحميل</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">↑ رفع</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingSessions ? (
                    <tr><td colSpan={5} className="p-10 text-center text-muted-foreground text-sm">جاري التحميل...</td></tr>
                  ) : !Array.isArray(sessions) || sessions.length === 0 ? (
                    <tr>
                      <td colSpan={5} className="p-10 text-center">
                        <Clock className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                        <p className="text-muted-foreground text-sm">لا توجد جلسات</p>
                      </td>
                    </tr>
                  ) : (
                    sessions.map((s: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="p-3 font-medium text-foreground text-sm">{s.user || s.customer || "—"}</td>
                        <td className="p-3 text-muted-foreground text-xs font-mono">{s["from-time"] || s.started || "—"}</td>
                        <td className="p-3 text-muted-foreground text-xs font-mono">{s["till-time"] || s.ended || "—"}</td>
                        <td className="p-3 text-foreground text-xs font-mono">{formatBytes(s.download || s["bytes-in"])}</td>
                        <td className="p-3 text-foreground text-xs font-mono">{formatBytes(s.upload || s["bytes-out"])}</td>
                      </tr>
                    ))
                  )}
                </tbody>
              </table>
            </div>
          </div>
        </TabsContent>
      </Tabs>
    </DashboardLayout>
  );
}

function Row({ label, value, highlight }: { label: string; value: string; highlight?: boolean }) {
  return (
    <div className="flex justify-between items-center">
      <span className="text-muted-foreground text-xs">{label}</span>
      <span className={`text-xs font-mono ${highlight ? "text-foreground font-semibold" : "text-foreground"}`}>{value}</span>
    </div>
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
