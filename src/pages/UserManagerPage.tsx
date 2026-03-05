import DashboardLayout from "@/components/DashboardLayout";
import { useUserManagerUsers, useUserManagerProfiles, useUserManagerSessions } from "@/hooks/useMikrotik";
import { Users, RefreshCw, AlertCircle } from "lucide-react";
import { useQueryClient } from "@tanstack/react-query";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";

export default function UserManagerPage() {
  const { data: users, isLoading: loadingUsers, error: usersError } = useUserManagerUsers();
  const { data: profiles, error: profilesError } = useUserManagerProfiles();
  const { data: sessions, isLoading: loadingSessions } = useUserManagerSessions();
  const queryClient = useQueryClient();

  const refresh = () => {
    queryClient.invalidateQueries({ queryKey: ["mikrotik", "usermanager"] });
  };

  const hasError = usersError || profilesError;

  return (
    <DashboardLayout>
      <div className="flex items-center justify-between mb-6">
        <div>
          <h2 className="text-xl font-bold text-foreground flex items-center gap-2">
            <Users className="h-5 w-5 text-accent" />
            يوزر مانجر
          </h2>
          <p className="text-muted-foreground text-sm">إدارة المستخدمين والباقات</p>
        </div>
        <button
          onClick={refresh}
          className="p-2 rounded-lg bg-muted hover:bg-muted/80 text-muted-foreground hover:text-foreground transition-colors"
        >
          <RefreshCw className="h-4 w-4" />
        </button>
      </div>

      {hasError && (
        <div className="mb-4 p-3 rounded-xl bg-warning/10 border border-warning/20 flex items-start gap-2">
          <AlertCircle className="h-4 w-4 text-warning shrink-0 mt-0.5" />
          <div className="text-xs text-muted-foreground">
            <p className="font-medium text-foreground mb-0.5">ملاحظة</p>
            <p>قد لا يكون User Manager مفعّل على هذا الراوتر. تأكد من تثبيت حزمة user-manager وإعادة تشغيل الراوتر.</p>
            <p className="mt-1">v6: يستخدم المسار /tool/user-manager/ • v7: يستخدم /user-manager/</p>
          </div>
        </div>
      )}

      <Tabs defaultValue="users" dir="rtl">
        <TabsList className="bg-muted mb-4">
          <TabsTrigger value="users">المستخدمين ({Array.isArray(users) ? users.length : 0})</TabsTrigger>
          <TabsTrigger value="profiles">الباقات ({Array.isArray(profiles) ? profiles.length : 0})</TabsTrigger>
          <TabsTrigger value="sessions">الجلسات ({Array.isArray(sessions) ? sessions.length : 0})</TabsTrigger>
        </TabsList>

        <TabsContent value="users">
          <div className="rounded-xl border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border text-muted-foreground bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs">الباقة</th>
                    <th className="text-right p-3 font-medium text-xs">الحالة</th>
                    <th className="text-right p-3 font-medium text-xs">التعليق</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingUsers ? (
                    <tr><td colSpan={4} className="p-8 text-center text-muted-foreground text-sm">جاري التحميل...</td></tr>
                  ) : !Array.isArray(users) || users.length === 0 ? (
                    <tr><td colSpan={4} className="p-8 text-center text-muted-foreground text-sm">لا يوجد مستخدمين</td></tr>
                  ) : (
                    users.map((user: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="p-3 font-medium text-foreground text-sm">{user.name || user.username || "—"}</td>
                        <td className="p-3 text-muted-foreground text-sm">{user.group || user.profile || user.actual_profile || "—"}</td>
                        <td className="p-3">
                          <span className={`px-2 py-0.5 rounded-full text-xs font-medium ${
                            user.disabled === "true" || user.disabled === true
                              ? "bg-destructive/10 text-destructive" 
                              : "bg-success/10 text-success"
                          }`}>
                            {user.disabled === "true" || user.disabled === true ? "معطل" : "نشط"}
                          </span>
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
              <div key={i} className="rounded-xl border border-border bg-card shadow-card p-4">
                <h3 className="font-semibold text-foreground mb-3 text-sm">{profile.name}</h3>
                <div className="space-y-2">
                  {profile["name-for-users"] && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground text-xs">الاسم</span>
                      <span className="text-foreground text-xs">{profile["name-for-users"]}</span>
                    </div>
                  )}
                  {profile.validity && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground text-xs">الصلاحية</span>
                      <span className="text-foreground text-xs">{profile.validity}</span>
                    </div>
                  )}
                  {profile.price && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground text-xs">السعر</span>
                      <span className="text-primary font-semibold text-xs">{profile.price}</span>
                    </div>
                  )}
                </div>
              </div>
            ))}
            {(!Array.isArray(profiles) || profiles.length === 0) && (
              <p className="text-muted-foreground col-span-full text-center py-8 text-sm">لا توجد باقات</p>
            )}
          </div>
        </TabsContent>

        <TabsContent value="sessions">
          <div className="rounded-xl border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border text-muted-foreground bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs">البداية</th>
                    <th className="text-right p-3 font-medium text-xs">النهاية</th>
                    <th className="text-right p-3 font-medium text-xs">↓</th>
                    <th className="text-right p-3 font-medium text-xs">↑</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingSessions ? (
                    <tr><td colSpan={5} className="p-8 text-center text-muted-foreground text-sm">جاري التحميل...</td></tr>
                  ) : !Array.isArray(sessions) || sessions.length === 0 ? (
                    <tr><td colSpan={5} className="p-8 text-center text-muted-foreground text-sm">لا توجد جلسات</td></tr>
                  ) : (
                    sessions.map((s: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="p-3 font-medium text-foreground text-sm">{s.user || s.customer || "—"}</td>
                        <td className="p-3 text-muted-foreground text-xs">{s["from-time"] || s.started || "—"}</td>
                        <td className="p-3 text-muted-foreground text-xs">{s["till-time"] || s.ended || "—"}</td>
                        <td className="p-3 text-primary text-sm">{formatBytes(s.download || s["bytes-in"])}</td>
                        <td className="p-3 text-accent text-sm">{formatBytes(s.upload || s["bytes-out"])}</td>
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

function formatBytes(bytes: string | number | undefined): string {
  if (!bytes) return "0 B";
  const b = Number(bytes);
  if (b < 1024) return b + " B";
  if (b < 1048576) return (b / 1024).toFixed(1) + " KB";
  if (b < 1073741824) return (b / 1048576).toFixed(1) + " MB";
  return (b / 1073741824).toFixed(2) + " GB";
}
