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
  Select, SelectContent, SelectItem, SelectTrigger, SelectValue,
} from "@/components/ui/select";
import {
  BarChart3, Home, TrendingUp, CreditCard,
  ChevronLeft, ChevronRight, Search, Trash2, DollarSign, Store,
  Download,
} from "lucide-react";
import { Link } from "react-router-dom";
import {
  AlertDialog, AlertDialogAction, AlertDialogCancel,
  AlertDialogContent, AlertDialogDescription, AlertDialogFooter,
  AlertDialogHeader, AlertDialogTitle,
} from "@/components/ui/alert-dialog";
import { toast } from "sonner";
import {
  BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer, CartesianGrid,
} from "recharts";

const PAGE_SIZE = 20;

export default function SalesPage() {
  const { user } = useAuth();
  const [search, setSearch] = useState("");
  const [page, setPage] = useState(1);
  const [deleteId, setDeleteId] = useState<string | null>(null);
  const [dateFilter, setDateFilter] = useState<"today" | "week" | "month" | "all">("today");
  const [salesPointFilter, setSalesPointFilter] = useState("all");

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

  // Get unique sales points
  const salesPoints = useMemo(() => {
    if (!sales) return [];
    const points = new Set<string>();
    sales.forEach((s: any) => {
      if (s.sales_point) points.add(s.sales_point);
    });
    return Array.from(points);
  }, [sales]);

  const filteredSales = useMemo(() => {
    if (!sales) return [];
    let filtered = [...sales];

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

    // Sales point filter
    if (salesPointFilter !== "all") {
      filtered = filtered.filter((s: any) => s.sales_point === salesPointFilter);
    }

    if (search) {
      const s = search.toLowerCase();
      filtered = filtered.filter(sale =>
        (sale.profile_name || "").toLowerCase().includes(s) ||
        (sale.notes || "").toLowerCase().includes(s) ||
        (sale.router_host || "").toLowerCase().includes(s)
      );
    }

    return filtered;
  }, [sales, search, dateFilter, salesPointFilter]);

  const totalPages = Math.max(1, Math.ceil(filteredSales.length / PAGE_SIZE));
  const paginatedSales = filteredSales.slice((page - 1) * PAGE_SIZE, page * PAGE_SIZE);

  const totalCards = filteredSales.reduce((sum, s) => sum + (s.success_count || 0), 0);
  const totalRevenue = filteredSales.reduce((sum, s) => sum + Number(s.total_amount || 0), 0);
  const totalBatches = filteredSales.length;

  // Daily chart data
  const chartData = useMemo(() => {
    if (!filteredSales.length) return [];
    const dayMap: Record<string, { day: string; revenue: number; cards: number }> = {};
    filteredSales.forEach(s => {
      const day = new Date(s.created_at).toLocaleDateString("ar", { month: "short", day: "numeric" });
      if (!dayMap[day]) dayMap[day] = { day, revenue: 0, cards: 0 };
      dayMap[day].revenue += Number(s.total_amount || 0);
      dayMap[day].cards += s.success_count || 0;
    });
    return Object.values(dayMap).reverse().slice(-14);
  }, [filteredSales]);

  // Top sales point
  const topSalesPoint = useMemo(() => {
    if (!filteredSales.length) return null;
    const map: Record<string, number> = {};
    filteredSales.forEach((s: any) => {
      const sp = s.sales_point || "غير محدد";
      map[sp] = (map[sp] || 0) + Number(s.total_amount || 0);
    });
    const entries = Object.entries(map).sort((a, b) => b[1] - a[1]);
    return entries[0] ? { name: entries[0][0], amount: entries[0][1] } : null;
  }, [filteredSales]);

  // Top profile
  const topProfile = useMemo(() => {
    if (!filteredSales.length) return null;
    const map: Record<string, number> = {};
    filteredSales.forEach(s => {
      const p = s.profile_name || "غير محدد";
      map[p] = (map[p] || 0) + (s.success_count || 0);
    });
    const entries = Object.entries(map).sort((a, b) => b[1] - a[1]);
    return entries[0] ? { name: entries[0][0], count: entries[0][1] } : null;
  }, [filteredSales]);

  // Monthly comparison
  const monthlyComparison = useMemo(() => {
    if (!sales || sales.length === 0) return null;
    const now = new Date();
    const thisMonth = sales.filter(s => {
      const d = new Date(s.created_at);
      return d.getMonth() === now.getMonth() && d.getFullYear() === now.getFullYear();
    });
    const lastMonth = sales.filter(s => {
      const d = new Date(s.created_at);
      const lm = new Date(now.getFullYear(), now.getMonth() - 1, 1);
      return d.getMonth() === lm.getMonth() && d.getFullYear() === lm.getFullYear();
    });
    const thisRevenue = thisMonth.reduce((s, r) => s + Number(r.total_amount || 0), 0);
    const lastRevenue = lastMonth.reduce((s, r) => s + Number(r.total_amount || 0), 0);
    const change = lastRevenue > 0 ? Math.round(((thisRevenue - lastRevenue) / lastRevenue) * 100) : 0;
    return { thisRevenue, lastRevenue, change, thisCards: thisMonth.reduce((s, r) => s + (r.success_count || 0), 0) };
  }, [sales]);

  const exportCSV = () => {
    if (!filteredSales.length) return;
    const headers = ["التاريخ", "الباقة", "النوع", "كروت ناجحة", "كروت فاشلة", "المبلغ", "نقطة البيع", "ملاحظات"];
    const rows = filteredSales.map((s: any) => [
      new Date(s.created_at).toLocaleString("ar"),
      s.profile_name || "",
      s.voucher_type === "hotspot" ? "هوتسبوت" : "يوزر مانجر",
      s.success_count || 0,
      s.failed_count || 0,
      s.total_amount || 0,
      s.sales_point || "",
      s.notes || "",
    ]);
    const csv = "\uFEFF" + [headers, ...rows].map(r => r.join(",")).join("\n");
    const blob = new Blob([csv], { type: "text/csv;charset=utf-8;" });
    const url = URL.createObjectURL(blob);
    const a = document.createElement("a");
    a.href = url;
    a.download = `sales-${new Date().toISOString().slice(0, 10)}.csv`;
    a.click();
    URL.revokeObjectURL(url);
  };

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
            <BreadcrumbLink asChild><Link to="/dashboard"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
          </BreadcrumbItem>
          <BreadcrumbSeparator />
          <BreadcrumbItem><BreadcrumbPage>المبيعات</BreadcrumbPage></BreadcrumbItem>
        </BreadcrumbList>
      </Breadcrumb>

      <div className="flex items-center justify-between mb-4 gap-2 flex-wrap">
        <div>
          <h1 className="text-lg font-semibold text-foreground tracking-tight">المبيعات</h1>
          <p className="text-muted-foreground text-xs mt-0.5">تقارير المبيعات ونقاط البيع</p>
        </div>
        <Button size="sm" variant="outline" className="text-xs" onClick={exportCSV} disabled={!filteredSales.length}>
          <Download className="h-3.5 w-3.5 ml-1" />
          تصدير CSV
        </Button>
      </div>

      {/* Monthly Comparison */}
      {monthlyComparison && (
        <div className="rounded-md border border-border bg-card p-3 mb-4">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-[11px] text-muted-foreground">هذا الشهر</p>
              <p className="text-lg font-semibold text-foreground">{monthlyComparison.thisRevenue.toLocaleString()}</p>
              <p className="text-[10px] text-muted-foreground">{monthlyComparison.thisCards} كرت</p>
            </div>
            <div className="text-center">
              {monthlyComparison.change !== 0 && (
                <Badge variant={monthlyComparison.change > 0 ? "default" : "destructive"} className="text-[10px]">
                  {monthlyComparison.change > 0 ? "+" : ""}{monthlyComparison.change}%
                </Badge>
              )}
              <p className="text-[10px] text-muted-foreground mt-1">مقارنة بالشهر السابق</p>
            </div>
            <div className="text-left">
              <p className="text-[11px] text-muted-foreground">الشهر السابق</p>
              <p className="text-lg font-semibold text-muted-foreground">{monthlyComparison.lastRevenue.toLocaleString()}</p>
            </div>
          </div>
        </div>
      )}

      {/* Stats */}
      <div className="grid grid-cols-2 sm:grid-cols-4 gap-2 mb-4">
        <div className="rounded-md border border-border bg-card p-3">
          <div className="flex items-center gap-1.5 mb-1">
            <CreditCard className="h-3.5 w-3.5 text-primary" />
            <span className="text-[11px] text-muted-foreground">كروت مباعة</span>
          </div>
          {isLoading ? <Skeleton className="h-7 w-12" /> : <p className="text-xl font-semibold text-foreground">{totalCards}</p>}
        </div>
        <div className="rounded-md border border-border bg-card p-3">
          <div className="flex items-center gap-1.5 mb-1">
            <DollarSign className="h-3.5 w-3.5 text-success" />
            <span className="text-[11px] text-muted-foreground">الإيرادات</span>
          </div>
          {isLoading ? <Skeleton className="h-7 w-12" /> : <p className="text-xl font-semibold text-foreground">{totalRevenue.toLocaleString()}</p>}
        </div>
        <div className="rounded-md border border-border bg-card p-3">
          <div className="flex items-center gap-1.5 mb-1">
            <TrendingUp className="h-3.5 w-3.5 text-primary" />
            <span className="text-[11px] text-muted-foreground">دفعات</span>
          </div>
          {isLoading ? <Skeleton className="h-7 w-12" /> : <p className="text-xl font-semibold text-foreground">{totalBatches}</p>}
        </div>
        <div className="rounded-md border border-border bg-card p-3">
          <div className="flex items-center gap-1.5 mb-1">
            <Store className="h-3.5 w-3.5 text-accent" />
            <span className="text-[11px] text-muted-foreground">أفضل نقطة بيع</span>
          </div>
          {isLoading ? <Skeleton className="h-7 w-12" /> : (
            <p className="text-sm font-semibold text-foreground truncate">{topSalesPoint?.name || "—"}</p>
          )}
        </div>
      </div>

      {/* Chart */}
      {chartData.length > 1 && (
        <div className="rounded-md border border-border bg-card p-3 mb-4">
          <h3 className="text-xs font-medium text-muted-foreground mb-2">الإيرادات اليومية</h3>
          <ResponsiveContainer width="100%" height={160}>
            <BarChart data={chartData}>
              <CartesianGrid strokeDasharray="3 3" stroke="hsl(var(--border))" />
              <XAxis dataKey="day" tick={{ fontSize: 10, fill: "hsl(var(--muted-foreground))" }} />
              <YAxis tick={{ fontSize: 10, fill: "hsl(var(--muted-foreground))" }} width={40} />
              <Tooltip
                contentStyle={{
                  background: "hsl(var(--card))",
                  border: "1px solid hsl(var(--border))",
                  borderRadius: "6px",
                  fontSize: "12px",
                }}
                labelStyle={{ color: "hsl(var(--foreground))" }}
              />
              <Bar dataKey="revenue" fill="hsl(var(--primary))" radius={[3, 3, 0, 0]} name="الإيرادات" />
            </BarChart>
          </ResponsiveContainer>
        </div>
      )}

      {/* Filters */}
      <div className="flex gap-2 mb-3 flex-wrap items-center">
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
        {salesPoints.length > 0 && (
          <Select value={salesPointFilter} onValueChange={v => { setSalesPointFilter(v); setPage(1); }}>
            <SelectTrigger className="h-7 w-32 text-xs">
              <Store className="h-3 w-3 ml-1" />
              <SelectValue placeholder="نقطة البيع" />
            </SelectTrigger>
            <SelectContent>
              <SelectItem value="all">الكل</SelectItem>
              {salesPoints.map(sp => (
                <SelectItem key={sp} value={sp}>{sp}</SelectItem>
              ))}
            </SelectContent>
          </Select>
        )}
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

      {/* Top Profile info */}
      {topProfile && (
        <div className="flex items-center gap-2 mb-3 text-xs text-muted-foreground">
          <span>أكثر باقة مباعة:</span>
          <Badge variant="outline" className="text-[10px]">{topProfile.name} ({topProfile.count} كرت)</Badge>
        </div>
      )}

      {/* Sales Table */}
      <div className="rounded-md border border-border bg-card overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-sm">
            <thead>
              <tr className="border-b border-border bg-muted/30">
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">التاريخ</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">الباقة</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">كروت</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden sm:table-cell">المبلغ</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden sm:table-cell">نقطة البيع</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden md:table-cell">النوع</th>
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
                    <td className="p-2.5 hidden md:table-cell"><Skeleton className="h-4 w-12" /></td>
                    <td className="p-2.5"><Skeleton className="h-4 w-6 mx-auto" /></td>
                  </tr>
                ))
              ) : paginatedSales.length === 0 ? (
                <tr>
                  <td colSpan={7} className="p-8 text-center">
                    <BarChart3 className="h-8 w-8 text-muted-foreground/20 mx-auto mb-2" />
                    <p className="text-muted-foreground text-sm">لا توجد مبيعات {dateFilter === "today" ? "اليوم" : ""}</p>
                  </td>
                </tr>
              ) : (
                paginatedSales.map((sale: any) => (
                  <tr key={sale.id} className="border-b border-border/50 hover:bg-muted/20 transition-colors group">
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
                    <td className="p-2.5 text-xs text-muted-foreground hidden sm:table-cell">
                      {sale.sales_point || "—"}
                    </td>
                    <td className="p-2.5 hidden md:table-cell">
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
          <div className="flex items-center justify-between px-3 py-2 border-t border-border bg-muted/20">
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
