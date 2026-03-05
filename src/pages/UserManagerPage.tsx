import DashboardLayout from "@/components/DashboardLayout";
import { useUserManagerUsers, useUserManagerProfiles, useUserManagerSessions } from "@/hooks/useMikrotik";
import { Users, RefreshCw } from "lucide-react";
import { useQueryClient } from "@tanstack/react-query";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";

export default function UserManagerPage() {
  const { data: users, isLoading: loadingUsers } = useUserManagerUsers();
  const { data: profiles } = useUserManagerProfiles();
  const { data: sessions, isLoading: loadingSessions } = useUserManagerSessions();
  const queryClient = useQueryClient();

  const refresh = () => {
    queryClient.invalidateQueries({ queryKey: ["mikrotik", "usermanager"] });
  };

  return (
    <DashboardLayout>
      <div className="flex items-center justify-between mb-6">
        <div>
          <h2 className="text-2xl font-bold text-foreground flex items-center gap-2">
            <Users className="h-6 w-6 text-accent" />
            يوزر مانجر
          </h2>
          <p className="text-muted-foreground text-sm">إدارة المستخدمين والباقات والجلسات</p>
        </div>
        <button
          onClick={refresh}
          className="p-2 rounded-lg bg-secondary hover:bg-secondary/80 text-secondary-foreground transition-colors"
        >
          <RefreshCw className="h-5 w-5" />
        </button>
      </div>

      <Tabs defaultValue="users" dir="rtl">
        <TabsList className="bg-secondary mb-4">
          <TabsTrigger value="users">المستخدمين ({Array.isArray(users) ? users.length : 0})</TabsTrigger>
          <TabsTrigger value="profiles">الباقات ({Array.isArray(profiles) ? profiles.length : 0})</TabsTrigger>
          <TabsTrigger value="sessions">الجلسات ({Array.isArray(sessions) ? sessions.length : 0})</TabsTrigger>
        </TabsList>

        <TabsContent value="users">
          <div className="gradient-card rounded-xl border border-border shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border text-muted-foreground">
                    <th className="text-right p-4 font-medium">اسم المستخدم</th>
                    <th className="text-right p-4 font-medium">الباقة</th>
                    <th className="text-right p-4 font-medium">معطل</th>
                    <th className="text-right p-4 font-medium">التعليق</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingUsers ? (
                    <tr><td colSpan={4} className="p-8 text-center text-muted-foreground">جاري التحميل...</td></tr>
                  ) : !Array.isArray(users) || users.length === 0 ? (
                    <tr><td colSpan={4} className="p-8 text-center text-muted-foreground">لا يوجد مستخدمين</td></tr>
                  ) : (
                    users.map((user: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-secondary/50 transition-colors">
                        <td className="p-4 font-medium text-foreground">{user.name || user.username || "—"}</td>
                        <td className="p-4 text-muted-foreground">{user.group || user.profile || "—"}</td>
                        <td className="p-4">
                          <span className={`px-2 py-1 rounded-full text-xs font-medium ${
                            user.disabled === "true" || user.disabled === true
                              ? "bg-destructive/20 text-destructive" 
                              : "bg-success/20 text-success"
                          }`}>
                            {user.disabled === "true" || user.disabled === true ? "معطل" : "نشط"}
                          </span>
                        </td>
                        <td className="p-4 text-muted-foreground text-xs max-w-[200px] truncate">{user.comment || "—"}</td>
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
                  {profile["name-for-users"] && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground">الاسم</span>
                      <span className="text-foreground">{profile["name-for-users"]}</span>
                    </div>
                  )}
                  {profile.validity && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground">الصلاحية</span>
                      <span className="text-foreground">{profile.validity}</span>
                    </div>
                  )}
                  {profile.price && (
                    <div className="flex justify-between">
                      <span className="text-muted-foreground">السعر</span>
                      <span className="text-primary font-bold">{profile.price}</span>
                    </div>
                  )}
                </div>
              </div>
            ))}
            {(!Array.isArray(profiles) || profiles.length === 0) && (
              <p className="text-muted-foreground col-span-full text-center py-8">لا توجد باقات</p>
            )}
          </div>
        </TabsContent>

        <TabsContent value="sessions">
          <div className="gradient-card rounded-xl border border-border shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border text-muted-foreground">
                    <th className="text-right p-4 font-medium">المستخدم</th>
                    <th className="text-right p-4 font-medium">بداية الجلسة</th>
                    <th className="text-right p-4 font-medium">نهاية الجلسة</th>
                    <th className="text-right p-4 font-medium">التحميل</th>
                    <th className="text-right p-4 font-medium">الرفع</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingSessions ? (
                    <tr><td colSpan={5} className="p-8 text-center text-muted-foreground">جاري التحميل...</td></tr>
                  ) : !Array.isArray(sessions) || sessions.length === 0 ? (
                    <tr><td colSpan={5} className="p-8 text-center text-muted-foreground">لا توجد جلسات</td></tr>
                  ) : (
                    sessions.map((s: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-secondary/50 transition-colors">
                        <td className="p-4 font-medium text-foreground">{s.user || s["customer"] || "—"}</td>
                        <td className="p-4 text-muted-foreground">{s["from-time"] || s["started"] || "—"}</td>
                        <td className="p-4 text-muted-foreground">{s["till-time"] || s["ended"] || "—"}</td>
                        <td className="p-4 text-primary">{formatBytes(s.download || s["bytes-in"])}</td>
                        <td className="p-4 text-accent">{formatBytes(s.upload || s["bytes-out"])}</td>
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
