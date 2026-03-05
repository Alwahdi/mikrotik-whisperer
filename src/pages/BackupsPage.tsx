import { useState, useEffect } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { supabase } from "@/integrations/supabase/client";
import { useAuth } from "@/contexts/AuthContext";
import { Button } from "@/components/ui/button";
import {
  Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList,
  BreadcrumbPage, BreadcrumbSeparator,
} from "@/components/ui/breadcrumb";
import {
  AlertDialog, AlertDialogAction, AlertDialogCancel,
  AlertDialogContent, AlertDialogDescription, AlertDialogFooter,
  AlertDialogHeader, AlertDialogTitle,
} from "@/components/ui/alert-dialog";
import { Skeleton } from "@/components/ui/skeleton";
import {
  Home, Database, Plus, Trash2, RotateCcw, Loader2, Clock,
  CheckCircle, AlertTriangle, HardDrive, Users, Wifi,
} from "lucide-react";
import { Link } from "react-router-dom";
import { toast } from "sonner";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";

interface BackupRecord {
  id: string;
  router_id: string;
  router_label: string;
  backup_type: string;
  status: string;
  file_path: string | null;
  metadata: any;
  created_at: string;
}

export default function BackupsPage() {
  const { user } = useAuth();
  const config = getMikrotikConfig();
  const [backups, setBackups] = useState<BackupRecord[]>([]);
  const [loading, setLoading] = useState(true);
  const [creating, setCreating] = useState(false);
  const [restoring, setRestoring] = useState<string | null>(null);
  const [deleteTarget, setDeleteTarget] = useState<string | null>(null);

  const fetchBackups = async () => {
    if (!user) return;
    setLoading(true);
    const { data, error } = await supabase
      .from("backups")
      .select("*")
      .eq("user_id", user.id)
      .order("created_at", { ascending: false });
    if (!error && data) setBackups(data as unknown as BackupRecord[]);
    setLoading(false);
  };

  useEffect(() => { fetchBackups(); }, [user]);

  const createBackup = async () => {
    if (!config || !user) {
      toast.error("يجب أن يكون هناك راوتر متصل");
      return;
    }

    setCreating(true);
    try {
      // Get router_id from config
      const { data: routers } = await supabase
        .from("routers")
        .select("id, label")
        .eq("user_id", user.id)
        .eq("host", config.host)
        .limit(1);

      const router = routers?.[0];
      if (!router) throw new Error("لم يتم العثور على الراوتر");

      const { data, error } = await supabase.functions.invoke("backup-scheduler", {
        body: {
          action: "create",
          router_id: router.id,
          router_label: router.label,
        },
      });

      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      toast.success("تم إنشاء النسخة الاحتياطية بنجاح");
      fetchBackups();
    } catch (err: any) {
      toast.error(err.message || "فشل إنشاء النسخة الاحتياطية");
    } finally {
      setCreating(false);
    }
  };

  const restoreBackup = async (backupId: string) => {
    setRestoring(backupId);
    try {
      const { data, error } = await supabase.functions.invoke("backup-scheduler", {
        body: { action: "restore", backup_id: backupId },
      });

      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      if (data.failed > 0) {
        toast.warning(`تمت استعادة ${data.restored} من ${data.total} — فشل ${data.failed}`);
      } else {
        toast.success(`تمت استعادة ${data.restored} مستخدم بنجاح`);
      }
    } catch (err: any) {
      toast.error(err.message || "فشلت الاستعادة");
    } finally {
      setRestoring(null);
    }
  };

  const deleteBackup = async (backupId: string) => {
    try {
      const { data, error } = await supabase.functions.invoke("backup-scheduler", {
        body: { action: "delete", backup_id: backupId },
      });

      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      toast.success("تم حذف النسخة الاحتياطية");
      setBackups(prev => prev.filter(b => b.id !== backupId));
    } catch (err: any) {
      toast.error(err.message || "فشل الحذف");
    }
    setDeleteTarget(null);
  };

  return (
    <DashboardLayout>
      <Breadcrumb className="mb-4">
        <BreadcrumbList>
          <BreadcrumbItem>
            <BreadcrumbLink asChild><Link to="/dashboard"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
          </BreadcrumbItem>
          <BreadcrumbSeparator />
          <BreadcrumbItem>
            <BreadcrumbPage>النسخ الاحتياطي</BreadcrumbPage>
          </BreadcrumbItem>
        </BreadcrumbList>
      </Breadcrumb>

      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-lg font-bold text-foreground">النسخ الاحتياطي</h1>
          <p className="text-muted-foreground text-xs mt-0.5">حفظ واستعادة بيانات المستخدمين والباقات</p>
        </div>
        <Button size="sm" onClick={createBackup} disabled={creating || !config}>
          {creating ? (
            <><Loader2 className="h-3.5 w-3.5 ml-1 animate-spin" /> جاري النسخ...</>
          ) : (
            <><Plus className="h-3.5 w-3.5 ml-1" /> نسخة جديدة</>
          )}
        </Button>
      </div>

      {!config && (
        <div className="mb-5 p-4 rounded-lg bg-warning/5 border border-warning/20">
          <div className="flex items-center gap-2 text-sm">
            <AlertTriangle className="h-4 w-4 text-warning" />
            <span className="text-foreground">يجب الاتصال براوتر أولاً لإنشاء نسخة احتياطية</span>
          </div>
        </div>
      )}

      {/* Backup List */}
      <div className="space-y-3">
        {loading ? (
          Array.from({ length: 3 }).map((_, i) => (
            <div key={i} className="rounded-lg border border-border bg-card p-4">
              <Skeleton className="h-5 w-40 mb-2" />
              <Skeleton className="h-4 w-64 mb-3" />
              <Skeleton className="h-8 w-48" />
            </div>
          ))
        ) : backups.length === 0 ? (
          <div className="rounded-lg border border-border bg-card p-10 text-center">
            <Database className="h-10 w-10 text-muted-foreground/20 mx-auto mb-3" />
            <p className="text-muted-foreground text-sm mb-1">لا توجد نسخ احتياطية</p>
            <p className="text-muted-foreground text-xs">اضغط "نسخة جديدة" لحفظ بيانات المستخدمين</p>
          </div>
        ) : (
          backups.map(backup => {
            const meta = backup.metadata || {};
            const isRestoring = restoring === backup.id;

            return (
              <div key={backup.id} className="rounded-lg border border-border bg-card p-4 hover:border-foreground/10 transition-colors">
                <div className="flex items-start justify-between mb-3">
                  <div className="flex items-center gap-2">
                    <div className="p-1.5 rounded-md bg-primary/10">
                      <HardDrive className="h-3.5 w-3.5 text-primary" />
                    </div>
                    <div>
                      <h3 className="font-semibold text-foreground text-sm">{backup.router_label}</h3>
                      <div className="flex items-center gap-1 text-[10px] text-muted-foreground mt-0.5">
                        <Clock className="h-2.5 w-2.5" />
                        {new Date(backup.created_at).toLocaleString("ar")}
                      </div>
                    </div>
                  </div>
                  <span className={`inline-flex items-center gap-1 text-[10px] px-2 py-0.5 rounded ${
                    backup.status === "completed"
                      ? "bg-primary/10 text-primary"
                      : "bg-warning/10 text-warning"
                  }`}>
                    {backup.status === "completed" ? <CheckCircle className="h-2.5 w-2.5" /> : <Loader2 className="h-2.5 w-2.5" />}
                    {backup.status === "completed" ? "مكتملة" : "جارية"}
                  </span>
                </div>

                {/* Stats */}
                <div className="grid grid-cols-2 sm:grid-cols-4 gap-2 mb-3">
                  <div className="flex items-center gap-1.5 text-xs text-muted-foreground">
                    <Users className="h-3 w-3" />
                    <span>{meta.um_users || 0} يوزر مانجر</span>
                  </div>
                  <div className="flex items-center gap-1.5 text-xs text-muted-foreground">
                    <Wifi className="h-3 w-3" />
                    <span>{meta.hotspot_users || 0} هوتسبوت</span>
                  </div>
                  <div className="flex items-center gap-1.5 text-xs text-muted-foreground">
                    <Database className="h-3 w-3" />
                    <span>{meta.um_profiles || 0} باقة UM</span>
                  </div>
                  <div className="flex items-center gap-1.5 text-xs text-muted-foreground">
                    <Database className="h-3 w-3" />
                    <span>{meta.hotspot_profiles || 0} باقة HS</span>
                  </div>
                </div>

                {/* Actions */}
                <div className="flex gap-2">
                  <Button
                    size="sm"
                    variant="outline"
                    className="text-xs"
                    disabled={isRestoring || backup.status !== "completed"}
                    onClick={() => restoreBackup(backup.id)}
                  >
                    {isRestoring ? (
                      <><Loader2 className="h-3 w-3 ml-1 animate-spin" /> جاري الاستعادة...</>
                    ) : (
                      <><RotateCcw className="h-3 w-3 ml-1" /> استعادة</>
                    )}
                  </Button>
                  <Button
                    size="sm"
                    variant="ghost"
                    className="text-xs text-destructive"
                    onClick={() => setDeleteTarget(backup.id)}
                  >
                    <Trash2 className="h-3 w-3 ml-1" />
                    حذف
                  </Button>
                </div>
              </div>
            );
          })
        )}
      </div>

      {/* Delete Confirmation */}
      <AlertDialog open={!!deleteTarget} onOpenChange={() => setDeleteTarget(null)}>
        <AlertDialogContent dir="rtl">
          <AlertDialogHeader>
            <AlertDialogTitle>حذف النسخة الاحتياطية</AlertDialogTitle>
            <AlertDialogDescription>
              هل أنت متأكد؟ سيتم حذف النسخة الاحتياطية نهائياً ولا يمكن استعادتها.
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction
              className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
              onClick={() => deleteTarget && deleteBackup(deleteTarget)}
            >
              حذف
            </AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </DashboardLayout>
  );
}
