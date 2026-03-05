import { useState, useMemo } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { supabase } from "@/integrations/supabase/client";
import { useAuth } from "@/contexts/AuthContext";
import { useQuery, useQueryClient } from "@tanstack/react-query";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Badge } from "@/components/ui/badge";
import { Textarea } from "@/components/ui/textarea";
import {
  Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList,
  BreadcrumbPage, BreadcrumbSeparator,
} from "@/components/ui/breadcrumb";
import {
  Select, SelectContent, SelectItem, SelectTrigger, SelectValue,
} from "@/components/ui/select";
import {
  Dialog, DialogContent, DialogHeader, DialogTitle, DialogFooter, DialogDescription,
} from "@/components/ui/dialog";
import {
  AlertDialog, AlertDialogAction, AlertDialogCancel,
  AlertDialogContent, AlertDialogDescription, AlertDialogFooter,
  AlertDialogHeader, AlertDialogTitle,
} from "@/components/ui/alert-dialog";
import {
  Home, Users, Search, Check, X, Clock, Ban, Shield,
  ChevronLeft, ChevronRight, CalendarPlus, RotateCcw,
} from "lucide-react";
import { Link } from "react-router-dom";
import { toast } from "sonner";
import { Skeleton } from "@/components/ui/skeleton";

type AccessStatus = "pending" | "active" | "suspended" | "expired";

interface UserRow {
  id: string;
  email: string | null;
  full_name: string | null;
  created_at: string | null;
  role: string | null;
  access_status: AccessStatus | null;
  starts_at: string | null;
  expires_at: string | null;
  notes: string | null;
}

const statusBadge: Record<string, { label: string; variant: "default" | "secondary" | "destructive" | "outline" }> = {
  pending: { label: "قيد المراجعة", variant: "outline" },
  active: { label: "فعال", variant: "default" },
  suspended: { label: "موقوف", variant: "destructive" },
  expired: { label: "منتهي", variant: "secondary" },
};

const PAGE_SIZE = 10;

export default function AdminUsersPage() {
  const { user } = useAuth();
  const qc = useQueryClient();

  const [search, setSearch] = useState("");
  const [filter, setFilter] = useState<"all" | AccessStatus>("all");
  const [page, setPage] = useState(1);

  // Action dialog
  const [actionUser, setActionUser] = useState<UserRow | null>(null);
  const [actionType, setActionType] = useState<"approve" | "extend" | "suspend" | "reactivate" | "role" | null>(null);
  const [duration, setDuration] = useState<"1" | "3" | "6" | "12">("1");
  const [notes, setNotes] = useState("");
  const [newRole, setNewRole] = useState<"admin" | "cashier">("cashier");
  const [confirmRoleChange, setConfirmRoleChange] = useState(false);
  const [saving, setSaving] = useState(false);

  // Fetch all users with access info
  const { data: users = [], isLoading, refetch } = useQuery({
    queryKey: ["admin-users"],
    queryFn: async () => {
      const { data: profiles } = await supabase.from("profiles").select("id, email, full_name, created_at");
      if (!profiles) return [];

      const { data: roles } = await supabase.from("user_roles").select("user_id, role");
      const { data: accesses } = await supabase.from("user_access").select("user_id, status, starts_at, expires_at, notes");

      const roleMap = new Map((roles || []).map(r => [r.user_id, r.role]));
      const accessMap = new Map((accesses || []).map(a => [a.user_id, a]));

      return profiles.map(p => {
        const acc = accessMap.get(p.id);
        return {
          id: p.id,
          email: p.email,
          full_name: p.full_name,
          created_at: p.created_at,
          role: roleMap.get(p.id) || null,
          access_status: (acc?.status as AccessStatus) || null,
          starts_at: acc?.starts_at || null,
          expires_at: acc?.expires_at || null,
          notes: acc?.notes || null,
        } as UserRow;
      });
    },
  });

  const filtered = useMemo(() => {
    let list = users;
    if (filter !== "all") list = list.filter(u => u.access_status === filter);
    if (search.trim()) {
      const s = search.toLowerCase();
      list = list.filter(u => (u.email || "").toLowerCase().includes(s) || (u.full_name || "").toLowerCase().includes(s));
    }
    return list;
  }, [users, filter, search]);

  const paginated = filtered.slice((page - 1) * PAGE_SIZE, page * PAGE_SIZE);
  const totalPages = Math.max(1, Math.ceil(filtered.length / PAGE_SIZE));

  const pendingCount = users.filter(u => u.access_status === "pending").length;
  const expiringCount = users.filter(u => {
    if (u.access_status !== "active" || !u.expires_at) return false;
    const diff = new Date(u.expires_at).getTime() - Date.now();
    return diff > 0 && diff < 7 * 24 * 60 * 60 * 1000;
  }).length;

  const openAction = (u: UserRow, type: typeof actionType) => {
    setActionUser(u);
    setActionType(type);
    setNotes(u.notes || "");
    if (type === "role") setNewRole(u.role === "admin" ? "cashier" : "admin");
  };

  const executeAction = async () => {
    if (!actionUser || !actionType) return;
    setSaving(true);
    try {
      const now = new Date().toISOString();
      const months = parseInt(duration);
      const expiresAt = new Date(Date.now() + months * 30 * 24 * 60 * 60 * 1000).toISOString();

      if (actionType === "approve") {
        await supabase.from("user_access").upsert({
          user_id: actionUser.id,
          status: "active",
          starts_at: now,
          expires_at: expiresAt,
          approved_at: now,
          approved_by: user?.id,
          notes,
        } as any, { onConflict: "user_id" });
        toast.success(`تم تفعيل ${actionUser.full_name || actionUser.email} لمدة ${months} شهر`);
      } else if (actionType === "extend") {
        const currentExpiry = actionUser.expires_at ? new Date(actionUser.expires_at) : new Date();
        const base = currentExpiry > new Date() ? currentExpiry : new Date();
        const newExpiry = new Date(base.getTime() + months * 30 * 24 * 60 * 60 * 1000).toISOString();
        await supabase.from("user_access").update({
          status: "active",
          expires_at: newExpiry,
          notes,
        } as any).eq("user_id", actionUser.id);
        toast.success(`تم تمديد الاشتراك لـ ${actionUser.full_name || actionUser.email}`);
      } else if (actionType === "suspend") {
        await supabase.from("user_access").update({ status: "suspended", notes } as any).eq("user_id", actionUser.id);
        toast.success("تم إيقاف الحساب");
      } else if (actionType === "reactivate") {
        await supabase.from("user_access").update({
          status: "active",
          starts_at: now,
          expires_at: expiresAt,
          notes,
        } as any).eq("user_id", actionUser.id);
        toast.success("تم إعادة تفعيل الحساب");
      } else if (actionType === "role") {
        // Delete existing role, insert new
        await supabase.from("user_roles").delete().eq("user_id", actionUser.id);
        await supabase.from("user_roles").insert({ user_id: actionUser.id, role: newRole });
        toast.success(`تم تغيير الدور إلى ${newRole === "admin" ? "مدير" : "كاشير"}`);
      }

      setActionUser(null);
      setActionType(null);
      setConfirmRoleChange(false);
      refetch();
    } catch (err: any) {
      toast.error(err.message || "حدث خطأ");
    }
    setSaving(false);
  };

  return (
    <DashboardLayout>
      <Breadcrumb className="mb-4">
        <BreadcrumbList>
          <BreadcrumbItem>
            <BreadcrumbLink asChild><Link to="/dashboard"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
          </BreadcrumbItem>
          <BreadcrumbSeparator />
          <BreadcrumbItem><BreadcrumbPage>إدارة المستخدمين</BreadcrumbPage></BreadcrumbItem>
        </BreadcrumbList>
      </Breadcrumb>

      <div className="flex items-center justify-between mb-4 gap-2 flex-wrap">
        <div>
          <h1 className="text-lg font-semibold text-foreground tracking-tight">إدارة المستخدمين</h1>
          <p className="text-muted-foreground text-xs mt-0.5">الموافقة على الحسابات وإدارة الاشتراكات</p>
        </div>
        <div className="flex items-center gap-2">
          {pendingCount > 0 && (
            <Badge variant="destructive" className="gap-1 text-xs">
              <Clock className="h-3 w-3" /> {pendingCount} بانتظار الموافقة
            </Badge>
          )}
          {expiringCount > 0 && (
            <Badge variant="outline" className="gap-1 text-xs text-warning border-warning/30">
              ينتهي قريباً: {expiringCount}
            </Badge>
          )}
        </div>
      </div>

      {/* Filters */}
      <div className="flex items-center gap-2 mb-4 flex-wrap">
        <div className="relative flex-1 min-w-[200px] max-w-sm">
          <Search className="absolute right-3 top-1/2 -translate-y-1/2 h-3.5 w-3.5 text-muted-foreground" />
          <Input placeholder="بحث بالاسم أو الإيميل..." value={search} onChange={e => { setSearch(e.target.value); setPage(1); }} className="pr-9 h-9 text-sm" />
        </div>
        <Select value={filter} onValueChange={(v) => { setFilter(v as any); setPage(1); }}>
          <SelectTrigger className="w-36 h-9 text-xs"><SelectValue /></SelectTrigger>
          <SelectContent>
            <SelectItem value="all">الكل ({users.length})</SelectItem>
            <SelectItem value="pending">قيد المراجعة</SelectItem>
            <SelectItem value="active">فعال</SelectItem>
            <SelectItem value="expired">منتهي</SelectItem>
            <SelectItem value="suspended">موقوف</SelectItem>
          </SelectContent>
        </Select>
      </div>

      {/* Users List */}
      {isLoading ? (
        <div className="space-y-2">{[1,2,3].map(i => <Skeleton key={i} className="h-16 w-full" />)}</div>
      ) : filtered.length === 0 ? (
        <div className="rounded-md border border-border bg-card p-10 text-center">
          <Users className="h-10 w-10 text-muted-foreground/20 mx-auto mb-3" />
          <p className="text-muted-foreground text-sm">لا يوجد مستخدمين</p>
        </div>
      ) : (
        <div className="space-y-2">
          {paginated.map(u => {
            const sb = statusBadge[u.access_status || "pending"] || statusBadge.pending;
            const isExpiringSoon = u.access_status === "active" && u.expires_at && (new Date(u.expires_at).getTime() - Date.now()) < 7 * 24 * 60 * 60 * 1000 && (new Date(u.expires_at).getTime() - Date.now()) > 0;
            return (
              <div key={u.id} className="rounded-md border border-border bg-card p-3 sm:p-4">
                <div className="flex items-start justify-between gap-2 flex-wrap">
                  <div className="min-w-0 flex-1">
                    <div className="flex items-center gap-2 flex-wrap mb-1">
                      <span className="text-sm font-medium text-foreground truncate">{u.full_name || "بدون اسم"}</span>
                      <Badge variant={sb.variant} className="text-[10px]">{sb.label}</Badge>
                      {u.role && (
                        <Badge variant="outline" className="text-[10px] gap-1">
                          <Shield className="h-2.5 w-2.5" />
                          {u.role === "admin" ? "مدير" : "كاشير"}
                        </Badge>
                      )}
                      {isExpiringSoon && <Badge variant="outline" className="text-[10px] text-warning border-warning/30">ينتهي قريباً</Badge>}
                    </div>
                    <p className="text-xs text-muted-foreground font-mono truncate">{u.email}</p>
                    <div className="flex items-center gap-3 mt-1 text-[10px] text-muted-foreground flex-wrap">
                      {u.starts_at && <span>بداية: {new Date(u.starts_at).toLocaleDateString("ar")}</span>}
                      {u.expires_at && <span>انتهاء: {new Date(u.expires_at).toLocaleDateString("ar")}</span>}
                      <span>تسجيل: {u.created_at ? new Date(u.created_at).toLocaleDateString("ar") : "—"}</span>
                    </div>
                  </div>
                  <div className="flex items-center gap-1 flex-wrap">
                    {u.access_status === "pending" && (
                      <Button size="sm" className="text-xs h-7 gap-1" onClick={() => openAction(u, "approve")}>
                        <Check className="h-3 w-3" /> تفعيل
                      </Button>
                    )}
                    {u.access_status === "active" && (
                      <>
                        <Button size="sm" variant="outline" className="text-xs h-7 gap-1" onClick={() => openAction(u, "extend")}>
                          <CalendarPlus className="h-3 w-3" /> تمديد
                        </Button>
                        <Button size="sm" variant="outline" className="text-xs h-7 gap-1 text-destructive" onClick={() => openAction(u, "suspend")}>
                          <Ban className="h-3 w-3" /> إيقاف
                        </Button>
                      </>
                    )}
                    {(u.access_status === "suspended" || u.access_status === "expired") && (
                      <Button size="sm" variant="outline" className="text-xs h-7 gap-1" onClick={() => openAction(u, "reactivate")}>
                        <RotateCcw className="h-3 w-3" /> إعادة تفعيل
                      </Button>
                    )}
                    {u.id !== user?.id && (
                      <Button size="sm" variant="ghost" className="text-xs h-7 gap-1" onClick={() => openAction(u, "role")}>
                        <Shield className="h-3 w-3" /> الدور
                      </Button>
                    )}
                  </div>
                </div>
              </div>
            );
          })}

          {filtered.length > PAGE_SIZE && (
            <div className="flex items-center justify-between px-2 py-2">
              <span className="text-xs text-muted-foreground">{filtered.length} مستخدم</span>
              <div className="flex items-center gap-1">
                <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page <= 1} onClick={() => setPage(p => p - 1)}>
                  <ChevronRight className="h-4 w-4" />
                </Button>
                <span className="text-xs px-2">{page} / {totalPages}</span>
                <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page >= totalPages} onClick={() => setPage(p => p + 1)}>
                  <ChevronLeft className="h-4 w-4" />
                </Button>
              </div>
            </div>
          )}
        </div>
      )}

      {/* Action Dialog */}
      <Dialog open={!!actionUser && actionType !== "role"} onOpenChange={() => { setActionUser(null); setActionType(null); }}>
        <DialogContent className="max-w-sm" dir="rtl">
          <DialogHeader>
            <DialogTitle className="text-sm">
              {actionType === "approve" && "تفعيل الحساب"}
              {actionType === "extend" && "تمديد الاشتراك"}
              {actionType === "suspend" && "إيقاف الحساب"}
              {actionType === "reactivate" && "إعادة التفعيل"}
            </DialogTitle>
            <DialogDescription className="text-xs">
              {actionUser?.full_name || actionUser?.email}
            </DialogDescription>
          </DialogHeader>
          <div className="space-y-3 py-2">
            {(actionType === "approve" || actionType === "extend" || actionType === "reactivate") && (
              <div>
                <label className="text-xs text-muted-foreground mb-1 block">المدة</label>
                <Select value={duration} onValueChange={(v) => setDuration(v as any)}>
                  <SelectTrigger className="h-9 text-sm"><SelectValue /></SelectTrigger>
                  <SelectContent>
                    <SelectItem value="1">شهر واحد</SelectItem>
                    <SelectItem value="3">3 أشهر</SelectItem>
                    <SelectItem value="6">6 أشهر</SelectItem>
                    <SelectItem value="12">سنة</SelectItem>
                  </SelectContent>
                </Select>
              </div>
            )}
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">ملاحظات (اختياري)</label>
              <Textarea value={notes} onChange={e => setNotes(e.target.value)} className="h-20 text-sm" placeholder="ملاحظات داخلية..." />
            </div>
          </div>
          <DialogFooter>
            <Button variant="outline" onClick={() => { setActionUser(null); setActionType(null); }}>إلغاء</Button>
            <Button onClick={executeAction} disabled={saving}>
              {actionType === "suspend" ? "إيقاف" : "تأكيد"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {/* Role Change Confirmation */}
      <AlertDialog open={actionType === "role" && !!actionUser} onOpenChange={() => { setActionUser(null); setActionType(null); }}>
        <AlertDialogContent dir="rtl">
          <AlertDialogHeader>
            <AlertDialogTitle className="text-sm">تغيير دور المستخدم</AlertDialogTitle>
            <AlertDialogDescription className="text-xs">
              هل تريد تغيير دور <strong>{actionUser?.full_name || actionUser?.email}</strong> من{" "}
              <strong>{actionUser?.role === "admin" ? "مدير" : "كاشير"}</strong> إلى{" "}
              <strong>{newRole === "admin" ? "مدير" : "كاشير"}</strong>؟
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction onClick={executeAction} disabled={saving}>تأكيد التغيير</AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </DashboardLayout>
  );
}
