import { useState, useMemo } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { supabase } from "@/integrations/supabase/client";
import { useAuth } from "@/contexts/AuthContext";
import { useQuery } from "@tanstack/react-query";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Skeleton } from "@/components/ui/skeleton";
import { Badge } from "@/components/ui/badge";
import {
  Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList,
  BreadcrumbPage, BreadcrumbSeparator,
} from "@/components/ui/breadcrumb";
import {
  BarChart3, Home, Calendar, TrendingUp, CreditCard,
  ChevronLeft, ChevronRight, Search, Trash2, DollarSign,
} from "lucide-react";
import { Link } from "react-router-dom";
import {
  AlertDialog, AlertDialogAction, AlertDialogCancel,
  AlertDialogContent, AlertDialogDescription, AlertDialogFooter,
  AlertDialogHeader, AlertDialogTitle,
} from "@/components/ui/alert-dialog";
import { toast } from "sonner";

const PAGE_SIZE = 20;

export default function SalesPage() {
  const { user } = useAuth();
  const [search, setSearch] = useState("");
  const [page, setPage] = useState(1);
  const [deleteId, setDeleteId] = useState<string | null>(null);
  const [dateFilter, setDateFilter] = useState<"today" | "week" | "month" | "all">("today");

  const { data: sales, isLoading, refetch } = useQuery({
    queryKey: ["sales", user?.id],
    queryFn: async () => {
      if (!user?.id) return [];
      const { data, error } = await supabase
        .from("sales")
        .select("*")
        .eq("user_id", user.id)
        .order("created_at", { ascending: false })
        .limit(1000);
      if (error) throw error;
      return data || [];
    },
    enabled: !!user?.id,
  });

  const filteredSales = useMemo(() => {
    if (!sales) return [];
    let filtered = [...sales];

    // Date filter
    const now = new Date();
    if (dateFilter === "today") {
      filtered = filtered.filter(s => new Date(s.created_at).toDateString() === now.toDateString());
    } else if (dateFilter === "week") {
      const weekAgo = new Date(now.getTime() - 7 * 24 * 60 * 60 * 1000);
      filtered = filtered.filter(s => new Date(s.created_at) >= weekAgo);
    } else if (dateFilter === "month") {
      const monthAgo = new Date(now.getTime() - 30 * 24 * 60 * 60 * 1000);
      filtered = filtered.filter(s => new Date(s.created_at) >= monthAgo);
    }

    // Search
    if (search) {
      const s = search.toLowerCase();
      filtered = filtered.filter(sale =>
        (sale.profile_name || "").toLowerCase().includes(s) ||
        (sale.notes || "").toLowerCase().includes(s) ||
        (sale.router_host || "").toLowerCase().includes(s)
      );
    }

    return filtered;
  }, [sales, search, dateFilter]);

  const totalPages = Math.max(1, Math.ceil(filteredSales.length / PAGE_SIZE));
  const paginatedSales = filteredSales.slice((page - 1) * PAGE_SIZE, page * PAGE_SIZE);

  // Stats
  const totalCards = filteredSales.reduce((sum, s) => sum + (s.success_count || 0), 0);
  const totalRevenue = filteredSales.reduce((sum, s) => sum + Number(s.total_amount || 0), 0);
  const totalBatches = filteredSales.length;

  const handleDelete = async (id: string) => {
    const { error } = await supabase.from("sales").delete().eq("id", id);
    if (error) { toast.error("فشل الحذف"); return; }
    toast.success("تم الحذف");
    setDeleteId(null);
    refetch();
  };

  return (
    <DashboardLayout>
      <Breadcrumb className="mb-4">
        <BreadcrumbList>
          <BreadcrumbItem>
            <BreadcrumbLink asChild><Link to="/"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
          </BreadcrumbItem>
          <BreadcrumbSeparator />
          <BreadcrumbItem><BreadcrumbPage>المبيعات</BreadcrumbPage></BreadcrumbItem>
        </BreadcrumbList>
      </Breadcrumb>

      <div className="flex items-center justify-between mb-4 gap-2 flex-wrap">
        <div>
          <h1 className="text-lg font-bold text-foreground">نقطة البيع</h1>
          <p className="text-muted-foreground text-xs mt-0.5">تقارير المبيعات والدفعات</p>
        </div>
      </div>

      {/* Stats */}
      <div className="grid grid-cols-3 gap-2 mb-4">
        <div className="rounded-lg border border-border bg-card p-2.5">
          <div className="flex items-center gap-1.5 mb-0.5">
            <CreditCard className="h-3.5 w-3.5 text-primary" />
            <span className="text-[10px] text-muted-foreground">كروت</span>
          </div>
          {isLoading ? <Skeleton className="h-6 w-10" /> : <p className="text-lg font-bold text-foreground">{totalCards}</p>}
        </div>
        <div className="rounded-lg border border-border bg-card p-2.5">
          <div className="flex items-center gap-1.5 mb-0.5">
            <DollarSign className="h-3.5 w-3.5 text-success" />
            <span className="text-[10px] text-muted-foreground">الإيرادات</span>
          </div>
          {isLoading ? <Skeleton className="h-6 w-10" /> : <p className="text-lg font-bold text-foreground">{totalRevenue.toLocaleString()}</p>}
        </div>
        <div className="rounded-lg border border-border bg-card p-2.5">
          <div className="flex items-center gap-1.5 mb-0.5">
            <TrendingUp className="h-3.5 w-3.5 text-warning" />
            <span className="text-[10px] text-muted-foreground">دفعات</span>
          </div>
          {isLoading ? <Skeleton className="h-6 w-10" /> : <p className="text-lg font-bold text-foreground">{totalBatches}</p>}
        </div>
      </div>

      {/* Filters */}
      <div className="flex gap-2 mb-3 flex-wrap">
        {(["today", "week", "month", "all"] as const).map(f => (
          <Button
            key={f}
            size="sm"
            variant={dateFilter === f ? "default" : "outline"}
            className="text-xs h-7"
            onClick={() => { setDateFilter(f); setPage(1); }}
          >
            {f === "today" ? "اليوم" : f === "week" ? "أسبوع" : f === "month" ? "شهر" : "الكل"}
          </Button>
        ))}
      </div>

      <div className="relative mb-3">
        <Search className="absolute right-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground" />
        <Input
          placeholder="بحث بالباقة أو الملاحظات..."
          value={search}
          onChange={e => { setSearch(e.target.value); setPage(1); }}
          className="pr-10 text-sm h-9"
        />
      </div>

      {/* Sales Table */}
      <div className="rounded-lg border border-border bg-card shadow-card overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-sm">
            <thead>
              <tr className="border-b border-border bg-muted/50">
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">التاريخ</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">الباقة</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">كروت</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden sm:table-cell">المبلغ</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden sm:table-cell">النوع</th>
                <th className="text-center p-2.5 font-medium text-xs text-muted-foreground w-10"></th>
              </tr>
            </thead>
            <tbody>
              {isLoading ? (
                Array.from({ length: 5 }).map((_, i) => (
                  <tr key={i} className="border-b border-border/50">
                    <td className="p-2.5"><Skeleton className="h-4 w-20" /></td>
                    <td className="p-2.5"><Skeleton className="h-4 w-16" /></td>
                    <td className="p-2.5"><Skeleton className="h-4 w-10" /></td>
                    <td className="p-2.5 hidden sm:table-cell"><Skeleton className="h-4 w-14" /></td>
                    <td className="p-2.5 hidden sm:table-cell"><Skeleton className="h-4 w-12" /></td>
                    <td className="p-2.5"><Skeleton className="h-4 w-6 mx-auto" /></td>
                  </tr>
                ))
              ) : paginatedSales.length === 0 ? (
                <tr>
                  <td colSpan={6} className="p-8 text-center">
                    <BarChart3 className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                    <p className="text-muted-foreground text-sm">لا توجد مبيعات {dateFilter === "today" ? "اليوم" : ""}</p>
                  </td>
                </tr>
              ) : (
                paginatedSales.map((sale: any) => (
                  <tr key={sale.id} className="border-b border-border/50 hover:bg-muted/30 transition-colors group">
                    <td className="p-2.5 text-xs text-muted-foreground font-mono">
                      {new Date(sale.created_at).toLocaleString("ar", { month: "short", day: "numeric", hour: "2-digit", minute: "2-digit" })}
                    </td>
                    <td className="p-2.5 text-sm font-medium text-foreground">{sale.profile_name || "—"}</td>
                    <td className="p-2.5 text-xs">
                      <span className="text-success">{sale.success_count}</span>
                      {sale.failed_count > 0 && <span className="text-destructive mr-1">/{sale.failed_count}✗</span>}
                    </td>
                    <td className="p-2.5 text-xs font-mono text-foreground hidden sm:table-cell">
                      {Number(sale.total_amount || 0).toLocaleString()}
                    </td>
                    <td className="p-2.5 hidden sm:table-cell">
                      <Badge variant="outline" className="text-[9px]">
                        {sale.voucher_type === "hotspot" ? "هوتسبوت" : "يوزر مانجر"}
                      </Badge>
                    </td>
                    <td className="p-2.5 text-center">
                      <Button variant="ghost" size="icon" className="h-6 w-6 opacity-0 group-hover:opacity-100 text-destructive" onClick={() => setDeleteId(sale.id)}>
                        <Trash2 className="h-3 w-3" />
                      </Button>
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
        </div>
        {filteredSales.length > PAGE_SIZE && (
          <div className="flex items-center justify-between px-3 py-2 border-t border-border bg-muted/30">
            <span className="text-xs text-muted-foreground">{filteredSales.length} عملية</span>
            <div className="flex items-center gap-1">
              <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page <= 1} onClick={() => setPage(p => p - 1)}>
                <ChevronRight className="h-4 w-4" />
              </Button>
              <span className="text-xs px-2">{page}/{totalPages}</span>
              <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page >= totalPages} onClick={() => setPage(p => p + 1)}>
                <ChevronLeft className="h-4 w-4" />
              </Button>
            </div>
          </div>
        )}
      </div>

      <AlertDialog open={!!deleteId} onOpenChange={() => setDeleteId(null)}>
        <AlertDialogContent dir="rtl">
          <AlertDialogHeader>
            <AlertDialogTitle>حذف العملية</AlertDialogTitle>
            <AlertDialogDescription>هل أنت متأكد؟</AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction
              className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
              onClick={() => deleteId && handleDelete(deleteId)}
            >حذف</AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </DashboardLayout>
  );
}
