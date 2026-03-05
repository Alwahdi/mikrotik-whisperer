import { useState, useMemo } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import {
  useHotspotUsers, useHotspotAllUsers, useHotspotProfiles, useHotspotUserAction,
} from "@/hooks/useMikrotik";
import {
  Wifi, RefreshCw, Users, Search,
  MoreHorizontal, UserPlus, Ban, Trash2, CheckCircle,
  XCircle, Eye, LogOut, Home, ChevronLeft, ChevronRight,
} from "lucide-react";
import { useQueryClient } from "@tanstack/react-query";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Skeleton } from "@/components/ui/skeleton";
import {
  DropdownMenu, DropdownMenuContent, DropdownMenuItem,
  DropdownMenuTrigger, DropdownMenuSeparator,
} from "@/components/ui/dropdown-menu";
import {
  Dialog, DialogContent, DialogHeader, DialogTitle,
  DialogFooter, DialogDescription,
} from "@/components/ui/dialog";
import {
  AlertDialog, AlertDialogAction, AlertDialogCancel,
  AlertDialogContent, AlertDialogDescription, AlertDialogFooter,
  AlertDialogHeader, AlertDialogTitle,
} from "@/components/ui/alert-dialog";
import {
  Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList,
  BreadcrumbPage, BreadcrumbSeparator,
} from "@/components/ui/breadcrumb";
import { Link } from "react-router-dom";
import { toast } from "sonner";

const PAGE_SIZE = 20;

export default function HotspotPage() {
  const { data: activeUsers, isLoading: loadingActive } = useHotspotUsers();
  const { data: allUsers, isLoading: loadingAll } = useHotspotAllUsers();
  const { data: profiles } = useHotspotProfiles();
  const queryClient = useQueryClient();
  const action = useHotspotUserAction();

  const [search, setSearch] = useState("");
  const [addOpen, setAddOpen] = useState(false);
  const [deleteTarget, setDeleteTarget] = useState<any>(null);
  const [detailUser, setDetailUser] = useState<any>(null);
  const [newUser, setNewUser] = useState({ name: "", password: "", profile: "default" });
  const [activePage, setActivePage] = useState(1);
  const [usersPage, setUsersPage] = useState(1);

  const refresh = () => {
    queryClient.invalidateQueries({ queryKey: ["mikrotik", "hotspot"] });
    toast.success("جاري تحديث البيانات...");
  };

  const allUsersList = useMemo(() => Array.isArray(allUsers) ? allUsers : [], [allUsers]);
  const activeList = useMemo(() => Array.isArray(activeUsers) ? activeUsers : [], [activeUsers]);

  const filteredAll = useMemo(() => {
    if (!search) return allUsersList;
    const s = search.toLowerCase();
    return allUsersList.filter((u: any) =>
      (u.name || "").toLowerCase().includes(s) || (u.profile || "").toLowerCase().includes(s)
    );
  }, [allUsersList, search]);

  const filteredActive = useMemo(() => {
    if (!search) return activeList;
    const s = search.toLowerCase();
    return activeList.filter((u: any) =>
      (u.user || "").toLowerCase().includes(s) || (u.address || "").includes(s)
    );
  }, [activeList, search]);

  const activeTotalPages = Math.max(1, Math.ceil(filteredActive.length / PAGE_SIZE));
  const usersTotalPages = Math.max(1, Math.ceil(filteredAll.length / PAGE_SIZE));
  const paginatedActive = filteredActive.slice((activePage - 1) * PAGE_SIZE, activePage * PAGE_SIZE);
  const paginatedAll = filteredAll.slice((usersPage - 1) * PAGE_SIZE, usersPage * PAGE_SIZE);

  const handleAction = (userAction: string, user: any) => {
    const id = user[".id"] || user.id;
    if (!id) { toast.error("لا يمكن تحديد المستخدم"); return; }
    action.mutate({ action: userAction, id });
  };

  const handleAddUser = () => {
    if (!newUser.name || !newUser.password) {
      toast.error("اسم المستخدم وكلمة المرور مطلوبان");
      return;
    }
    action.mutate({
      action: "add",
      data: { name: newUser.name, password: newUser.password, profile: newUser.profile },
    }, {
      onSuccess: () => {
        setAddOpen(false);
        setNewUser({ name: "", password: "", profile: "default" });
      }
    });
  };

  const handleSearch = (val: string) => {
    setSearch(val);
    setActivePage(1);
    setUsersPage(1);
  };

  return (
    <DashboardLayout>
      {/* Breadcrumb */}
      <Breadcrumb className="mb-4">
        <BreadcrumbList>
          <BreadcrumbItem>
            <BreadcrumbLink asChild><Link to="/dashboard"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
          </BreadcrumbItem>
          <BreadcrumbSeparator />
          <BreadcrumbItem>
            <BreadcrumbPage>الهوتسبوت</BreadcrumbPage>
          </BreadcrumbItem>
        </BreadcrumbList>
      </Breadcrumb>

      {/* Header */}
      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-lg font-bold text-foreground">الهوتسبوت</h1>
          <p className="text-muted-foreground text-xs mt-0.5">إدارة مستخدمي الهوتسبوت</p>
        </div>
        <div className="flex items-center gap-2">
          <Button size="sm" variant="outline" onClick={() => setAddOpen(true)}>
            <UserPlus className="h-3.5 w-3.5 ml-1" />
            إضافة
          </Button>
          <Button size="icon" variant="outline" onClick={refresh}>
            <RefreshCw className="h-4 w-4" />
          </Button>
        </div>
      </div>

      {/* Quick Stats */}
      <div className="grid grid-cols-3 gap-3 mb-5">
        <div className="rounded-lg border border-border bg-card p-3">
          <div className="flex items-center gap-2 mb-1">
            <Wifi className="h-3.5 w-3.5 text-success" />
            <span className="text-xs text-muted-foreground">متصلين</span>
          </div>
          {loadingActive ? <Skeleton className="h-7 w-12" /> : <p className="text-xl font-bold text-foreground">{activeList.length}</p>}
        </div>
        <div className="rounded-lg border border-border bg-card p-3">
          <div className="flex items-center gap-2 mb-1">
            <Users className="h-3.5 w-3.5 text-foreground" />
            <span className="text-xs text-muted-foreground">إجمالي</span>
          </div>
          {loadingAll ? <Skeleton className="h-7 w-12" /> : <p className="text-xl font-bold text-foreground">{allUsersList.length}</p>}
        </div>
        <div className="rounded-lg border border-border bg-card p-3">
          <div className="flex items-center gap-2 mb-1">
            <span className="text-xs text-muted-foreground">بروفايلات</span>
          </div>
          <p className="text-xl font-bold text-foreground">{Array.isArray(profiles) ? profiles.length : 0}</p>
        </div>
      </div>

      {/* Search */}
      <div className="relative mb-4">
        <Search className="absolute right-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground" />
        <Input placeholder="بحث عن مستخدم أو IP..." value={search} onChange={(e) => handleSearch(e.target.value)} className="pr-10 text-sm" />
      </div>

      <Tabs defaultValue="active" dir="rtl">
        <TabsList className="bg-muted mb-4 w-full justify-start">
          <TabsTrigger value="active" className="text-xs">المتصلين {!loadingActive && `(${activeList.length})`}</TabsTrigger>
          <TabsTrigger value="users" className="text-xs">المستخدمين {!loadingAll && `(${allUsersList.length})`}</TabsTrigger>
          <TabsTrigger value="profiles" className="text-xs">البروفايلات</TabsTrigger>
        </TabsList>

        {/* Active Users */}
        <TabsContent value="active">
          <div className="rounded-lg border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">IP</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground hidden sm:table-cell">MAC</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">المدة</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">↓</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">↑</th>
                    <th className="text-center p-3 w-12"></th>
                  </tr>
                </thead>
                <tbody>
                  {loadingActive ? (
                    Array.from({ length: 5 }).map((_, i) => (
                      <tr key={i} className="border-b border-border/50">
                        {Array.from({ length: 7 }).map((_, j) => (
                          <td key={j} className="p-3"><Skeleton className="h-4 w-16" /></td>
                        ))}
                      </tr>
                    ))
                  ) : paginatedActive.length === 0 ? (
                    <tr>
                      <td colSpan={7} className="p-10 text-center">
                        <Wifi className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                        <p className="text-muted-foreground text-sm">{search ? "لا توجد نتائج" : "لا يوجد متصلين حالياً"}</p>
                      </td>
                    </tr>
                  ) : (
                    paginatedActive.map((user: any, i: number) => (
                      <tr key={user[".id"] || i} className="border-b border-border/50 hover:bg-muted/30 transition-colors group">
                        <td className="p-3 font-medium text-foreground text-sm">{user.user || "—"}</td>
                        <td className="p-3 font-mono text-xs text-muted-foreground">{user.address || "—"}</td>
                        <td className="p-3 font-mono text-xs text-muted-foreground hidden sm:table-cell">{user["mac-address"] || "—"}</td>
                        <td className="p-3 text-muted-foreground text-xs">{user.uptime || "—"}</td>
                        <td className="p-3 font-mono text-xs text-foreground">{formatBytes(user["bytes-in"])}</td>
                        <td className="p-3 font-mono text-xs text-foreground">{formatBytes(user["bytes-out"])}</td>
                        <td className="p-3 text-center">
                          <Button variant="ghost" size="icon" className="h-7 w-7 opacity-0 group-hover:opacity-100 text-destructive" onClick={() => handleAction("kick", user)} title="فصل">
                            <LogOut className="h-3.5 w-3.5" />
                          </Button>
                        </td>
                      </tr>
                    ))
                  )}
                </tbody>
              </table>
            </div>
            {!loadingActive && filteredActive.length > PAGE_SIZE && (
              <PaginationBar page={activePage} totalPages={activeTotalPages} onPageChange={setActivePage} total={filteredActive.length} />
            )}
          </div>
        </TabsContent>

        {/* All Users */}
        <TabsContent value="users">
          <div className="rounded-lg border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border bg-muted/50">
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">المستخدم</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">البروفايل</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground hidden sm:table-cell">الحد</th>
                    <th className="text-right p-3 font-medium text-xs text-muted-foreground">الحالة</th>
                    <th className="text-center p-3 w-12"></th>
                  </tr>
                </thead>
                <tbody>
                  {loadingAll ? (
                    Array.from({ length: 5 }).map((_, i) => (
                      <tr key={i} className="border-b border-border/50">
                        {Array.from({ length: 5 }).map((_, j) => (
                          <td key={j} className="p-3"><Skeleton className="h-4 w-16" /></td>
                        ))}
                      </tr>
                    ))
                  ) : paginatedAll.length === 0 ? (
                    <tr>
                      <td colSpan={5} className="p-10 text-center">
                        <Users className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                        <p className="text-muted-foreground text-sm">{search ? "لا توجد نتائج" : "لا يوجد مستخدمين"}</p>
                      </td>
                    </tr>
                  ) : (
                    paginatedAll.map((user: any, i: number) => {
                      const isDisabled = user.disabled === "true" || user.disabled === true;
                      return (
                        <tr key={user[".id"] || i} className="border-b border-border/50 hover:bg-muted/30 transition-colors group">
                          <td className="p-3 font-medium text-foreground text-sm">{user.name || "—"}</td>
                          <td className="p-3 text-muted-foreground text-xs">{user.profile || "—"}</td>
                          <td className="p-3 text-muted-foreground text-xs hidden sm:table-cell">{user["limit-uptime"] || "—"}</td>
                          <td className="p-3">
                            <span className={`inline-flex items-center gap-1 text-xs ${isDisabled ? "text-destructive" : "text-success"}`}>
                              {isDisabled ? <XCircle className="h-3 w-3" /> : <CheckCircle className="h-3 w-3" />}
                              {isDisabled ? "معطل" : "نشط"}
                            </span>
                          </td>
                          <td className="p-3 text-center">
                            <DropdownMenu>
                              <DropdownMenuTrigger asChild>
                                <Button variant="ghost" size="icon" className="h-7 w-7 opacity-0 group-hover:opacity-100 transition-opacity">
                                  <MoreHorizontal className="h-4 w-4" />
                                </Button>
                              </DropdownMenuTrigger>
                              <DropdownMenuContent align="end" className="w-40">
                                <DropdownMenuItem onClick={() => setDetailUser(user)}>
                                  <Eye className="h-3.5 w-3.5 ml-2" /> تفاصيل
                                </DropdownMenuItem>
                                <DropdownMenuSeparator />
                                {isDisabled ? (
                                  <DropdownMenuItem onClick={() => handleAction("enable", user)}>
                                    <CheckCircle className="h-3.5 w-3.5 ml-2" /> تفعيل
                                  </DropdownMenuItem>
                                ) : (
                                  <DropdownMenuItem onClick={() => handleAction("disable", user)}>
                                    <Ban className="h-3.5 w-3.5 ml-2" /> تعطيل
                                  </DropdownMenuItem>
                                )}
                                <DropdownMenuSeparator />
                                <DropdownMenuItem onClick={() => setDeleteTarget(user)} className="text-destructive">
                                  <Trash2 className="h-3.5 w-3.5 ml-2" /> حذف
                                </DropdownMenuItem>
                              </DropdownMenuContent>
                            </DropdownMenu>
                          </td>
                        </tr>
                      );
                    })
                  )}
                </tbody>
              </table>
            </div>
            {!loadingAll && filteredAll.length > PAGE_SIZE && (
              <PaginationBar page={usersPage} totalPages={usersTotalPages} onPageChange={setUsersPage} total={filteredAll.length} />
            )}
          </div>
        </TabsContent>

        {/* Profiles */}
        <TabsContent value="profiles">
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-3">
            {Array.isArray(profiles) && profiles.map((profile: any, i: number) => (
              <div key={i} className="rounded-lg border border-border bg-card shadow-card p-4 hover:border-foreground/10 transition-colors">
                <h3 className="font-semibold text-foreground mb-3 text-sm">{profile.name}</h3>
                <div className="space-y-2 text-sm">
                  {profile["rate-limit"] && <InfoRow label="السرعة" value={profile["rate-limit"]} />}
                  {profile["shared-users"] && <InfoRow label="مشاركة" value={profile["shared-users"]} />}
                  {profile["session-timeout"] && <InfoRow label="المدة" value={profile["session-timeout"]} />}
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

      {/* Add User Dialog */}
      <Dialog open={addOpen} onOpenChange={setAddOpen}>
        <DialogContent className="sm:max-w-md" dir="rtl">
          <DialogHeader>
            <DialogTitle>إضافة مستخدم هوتسبوت</DialogTitle>
            <DialogDescription>أدخل بيانات المستخدم الجديد</DialogDescription>
          </DialogHeader>
          <div className="space-y-3 py-2">
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">اسم المستخدم</label>
              <Input value={newUser.name} onChange={e => setNewUser(p => ({ ...p, name: e.target.value }))} placeholder="user01" />
            </div>
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">كلمة المرور</label>
              <Input value={newUser.password} onChange={e => setNewUser(p => ({ ...p, password: e.target.value }))} placeholder="****" />
            </div>
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">البروفايل</label>
              <select
                value={newUser.profile}
                onChange={e => setNewUser(p => ({ ...p, profile: e.target.value }))}
                className="w-full h-10 rounded-md border border-input bg-background px-3 text-sm"
              >
                <option value="default">default</option>
                {Array.isArray(profiles) && profiles.map((p: any, i: number) => (
                  <option key={i} value={p.name}>{p.name}</option>
                ))}
              </select>
            </div>
          </div>
          <DialogFooter>
            <Button variant="outline" onClick={() => setAddOpen(false)}>إلغاء</Button>
            <Button onClick={handleAddUser} disabled={action.isPending}>
              {action.isPending ? "جاري الإضافة..." : "إضافة"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {/* Delete Confirmation */}
      <AlertDialog open={!!deleteTarget} onOpenChange={() => setDeleteTarget(null)}>
        <AlertDialogContent dir="rtl">
          <AlertDialogHeader>
            <AlertDialogTitle>حذف المستخدم</AlertDialogTitle>
            <AlertDialogDescription>
              هل أنت متأكد من حذف "{deleteTarget?.name}"؟ لا يمكن التراجع عن هذا الإجراء.
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction
              className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
              onClick={() => { handleAction("remove", deleteTarget); setDeleteTarget(null); }}
            >
              حذف
            </AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>

      {/* Detail Dialog */}
      <Dialog open={!!detailUser} onOpenChange={() => setDetailUser(null)}>
        <DialogContent className="sm:max-w-md" dir="rtl">
          <DialogHeader>
            <DialogTitle>تفاصيل المستخدم</DialogTitle>
          </DialogHeader>
          {detailUser && (
            <div className="space-y-2 py-2 max-h-80 overflow-y-auto">
              {Object.entries(detailUser).filter(([k]) => !k.startsWith(".")).map(([key, val]) => (
                <div key={key} className="flex justify-between items-center py-1 border-b border-border/50">
                  <span className="text-xs text-muted-foreground">{key}</span>
                  <span className="text-xs font-mono text-foreground max-w-[200px] truncate">{String(val || "—")}</span>
                </div>
              ))}
            </div>
          )}
        </DialogContent>
      </Dialog>
    </DashboardLayout>
  );
}

function PaginationBar({ page, totalPages, onPageChange, total }: { page: number; totalPages: number; onPageChange: (p: number) => void; total: number }) {
  return (
    <div className="flex items-center justify-between px-4 py-3 border-t border-border bg-muted/30">
      <span className="text-xs text-muted-foreground">{total} عنصر</span>
      <div className="flex items-center gap-1">
        <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page <= 1} onClick={() => onPageChange(page - 1)}>
          <ChevronRight className="h-4 w-4" />
        </Button>
        <span className="text-xs text-foreground px-2 min-w-[60px] text-center">{page} / {totalPages}</span>
        <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page >= totalPages} onClick={() => onPageChange(page + 1)}>
          <ChevronLeft className="h-4 w-4" />
        </Button>
      </div>
    </div>
  );
}

function InfoRow({ label, value }: { label: string; value: string }) {
  return (
    <div className="flex justify-between">
      <span className="text-muted-foreground text-xs">{label}</span>
      <span className="font-mono text-foreground text-xs">{value}</span>
    </div>
  );
}

function formatBytes(bytes: string | number | undefined): string {
  if (!bytes) return "0 B";
  const b = Number(bytes);
  if (isNaN(b)) return "0 B";
  if (b < 1024) return b + " B";
  if (b < 1048576) return (b / 1024).toFixed(1) + " KB";
  if (b < 1073741824) return (b / 1048576).toFixed(1) + " MB";
  return (b / 1073741824).toFixed(2) + " GB";
}
