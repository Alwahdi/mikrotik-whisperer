import { useMemo, useState } from "react";
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
  Download, CalendarRange, Wallet,
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
const QUERY_PAGE_SIZE = 1000;

type DateFilter = "today" | "week" | "month" | "all";

type SaleRecord = {
  id: string;
  created_at: string;
  profile_name: string;
  notes: string | null;
  router_host: string | null;
  sales_point: string | null;
  voucher_type: string | null;
  success_count: number;
  failed_count: number;
  unit_price: number;
  total_amount: number;
  card_count: number;
};

async function fetchAllSales(userId: string) {
  const all: any[] = [];
  let from = 0;

  while (true) {
    const { data, error } = await supabase
      .from("sales")
      .select("*")
      .eq("user_id", userId)
      .order("created_at", { ascending: false })
      .range(from, from + QUERY_PAGE_SIZE - 1);

    if (error) throw error;
    const rows = data || [];
    all.push(...rows);
    if (rows.length < QUERY_PAGE_SIZE) break;
    from += QUERY_PAGE_SIZE;
  }

  return all;
}

function normalizeSale(row: any): SaleRecord {
  const successCount = Number(row.success_count || 0);
  const failedCount = Number(row.failed_count ?? row.fail_count ?? 0);
  const unitPrice = Number(row.unit_price || 0);
  const totalAmount = Number(row.total_amount || 0) || successCount * unitPrice;
  const cardCount = Number(row.card_count || 0) || successCount + failedCount;

  return {
    id: row.id,
    created_at: row.created_at,
    profile_name: row.profile_name || "غير محدد",
    notes: row.notes || "",
    router_host: row.router_host || "",
    sales_point: row.sales_point || "",
    voucher_type: row.voucher_type || "usermanager",
    success_count: successCount,
    failed_count: failedCount,
    unit_price: unitPrice,
    total_amount: totalAmount,
    card_count: cardCount,
  };
}

function getDateFilteredSales(sales: SaleRecord[], dateFilter: DateFilter) {
  const now = new Date();
  if (dateFilter === "all") return sales;
  if (dateFilter === "today") {
    return sales.filter((sale) => new Date(sale.created_at).toDateString() === now.toDateString());
  }
  if (dateFilter === "week") {
    const weekAgo = new Date(now.getTime() - 7 * 24 * 60 * 60 * 1000);
    return sales.filter((sale) => new Date(sale.created_at) >= weekAgo);
  }
  const monthAgo = new Date(now.getTime() - 30 * 24 * 60 * 60 * 1000);
  return sales.filter((sale) => new Date(sale.created_at) >= monthAgo);
}

export default function SalesPage() {
  const { user } = useAuth();
  const [search, setSearch] = useState("");
  const [page, setPage] = useState(1);
  const [deleteId, setDeleteId] = useState<string | null>(null);
  const [dateFilter, setDateFilter] = useState<DateFilter>("today");
  const [salesPointFilter, setSalesPointFilter] = useState("all");

  const { data: rawSales, isLoading, refetch } = useQuery({
    queryKey: ["sales", user?.id],
    queryFn: async () => {
      if (!user?.id) return [];
      return fetchAllSales(user.id);
    },
    enabled: !!user?.id,
  });

  const sales = useMemo(() => (rawSales || []).map(normalizeSale), [rawSales]);

  const salesPointStats = useMemo(() => {
    const map = new Map<string, { name: string; cards: number; revenue: number; batches: number }>();
    for (const sale of sales) {
      const key = sale.sales_point || "غير محدد";
      const current = map.get(key) || { name: key, cards: 0, revenue: 0, batches: 0 };
      current.cards += sale.success_count;
      current.revenue += sale.total_amount;
      current.batches += 1;
      map.set(key, current);
    }
    return Array.from(map.values()).sort((a, b) => b.cards - a.cards || b.revenue - a.revenue);
  }, [sales]);

  const salesPoints = useMemo(() => salesPointStats.map((item) => item.name), [salesPointStats]);

  const filteredSales = useMemo(() => {
    let filtered = getDateFilteredSales(sales, dateFilter);

    if (salesPointFilter !== "all") {
      filtered = filtered.filter((sale) => (sale.sales_point || "غير محدد") === salesPointFilter);
    }

    if (search.trim()) {
      const term = search.trim().toLowerCase();
      filtered = filtered.filter((sale) =>
        sale.profile_name.toLowerCase().includes(term) ||
        (sale.notes || "").toLowerCase().includes(term) ||
        (sale.router_host || "").toLowerCase().includes(term) ||
        (sale.sales_point || "").toLowerCase().includes(term)
      );
    }

    return filtered;
  }, [sales, dateFilter, salesPointFilter, search]);

  const totalPages = Math.max(1, Math.ceil(filteredSales.length / PAGE_SIZE));
  const paginatedSales = filteredSales.slice((page - 1) * PAGE_SIZE, page * PAGE_SIZE);

  const totals = useMemo(() => {
    return filteredSales.reduce(
      (acc, sale) => {
        acc.cards += sale.success_count;
        acc.failed += sale.failed_count;
        acc.revenue += sale.total_amount;
        acc.batches += 1;
        return acc;
      },
      { cards: 0, failed: 0, revenue: 0, batches: 0 }
    );
  }, [filteredSales]);

  const averageCardPrice = totals.cards > 0 ? totals.revenue / totals.cards : 0;

  const chartData = useMemo(() => {
    const dayMap: Record<string, { day: string; revenue: number; cards: number }> = {};
    for (const sale of filteredSales) {
      const date = new Date(sale.created_at);
      const key = `${date.getFullYear()}-${date.getMonth()}-${date.getDate()}`;
      if (!dayMap[key]) {
        dayMap[key] = {
          day: date.toLocaleDateString("ar", { month: "short", day: "numeric" }),
          revenue: 0,
          cards: 0,
        };
      }
      dayMap[key].revenue += sale.total_amount;
      dayMap[key].cards += sale.success_count;
    }
    return Object.values(dayMap).slice(-14);
  }, [filteredSales]);

  const topPointsChartData = useMemo(() => salesPointStats.slice(0, 6), [salesPointStats]);

  const monthlyComparison = useMemo(() => {
    if (!sales.length) return null;
    const now = new Date();
    const currentMonth = sales.filter((sale) => {
      const date = new Date(sale.created_at);
      return date.getMonth() === now.getMonth() && date.getFullYear() === now.getFullYear();
    });
    const previousMonthRef = new Date(now.getFullYear(), now.getMonth() - 1, 1);
    const previousMonth = sales.filter((sale) => {
      const date = new Date(sale.created_at);
      return date.getMonth() === previousMonthRef.getMonth() && date.getFullYear() === previousMonthRef.getFullYear();
    });

    const thisRevenue = currentMonth.reduce((sum, sale) => sum + sale.total_amount, 0);
    const lastRevenue = previousMonth.reduce((sum, sale) => sum + sale.total_amount, 0);
    const thisCards = currentMonth.reduce((sum, sale) => sum + sale.success_count, 0);
    const lastCards = previousMonth.reduce((sum, sale) => sum + sale.success_count, 0);
    const change = lastRevenue > 0 ? Math.round(((thisRevenue - lastRevenue) / lastRevenue) * 100) : 0;

    return { thisRevenue, lastRevenue, thisCards, lastCards, change };
  }, [sales]);

  const exportCSV = () => {
    if (!filteredSales.length) return;
    const headers = ["التاريخ", "الباقة", "النوع", "سعر الوحدة", "ناجح", "فاشل", "المبلغ", "نقطة البيع", "ملاحظات"];
    const rows = filteredSales.map((sale) => [
      new Date(sale.created_at).toLocaleString("ar"),
      sale.profile_name,
      sale.voucher_type === "hotspot" ? "هوتسبوت" : "يوزر مانجر",
      sale.unit_price,
      sale.success_count,
      sale.failed_count,
      sale.total_amount,
      sale.sales_point || "",
      sale.notes || "",
    ]);
    const csv = "\uFEFF" + [headers, ...rows].map((row) => row.join(",")).join("\n");
    const blob = new Blob([csv], { type: "text/csv;charset=utf-8;" });
    const url = URL.createObjectURL(blob);
    const anchor = document.createElement("a");
    anchor.href = url;
    anchor.download = `sales-${new Date().toISOString().slice(0, 10)}.csv`;
    anchor.click();
    URL.revokeObjectURL(url);
  };

  const handleDelete = async (id: string) => {
    const { error } = await supabase.from("sales").delete().eq("id", id);
    if (error) {
      toast.error("فشل حذف العملية");
      return;
    }
    toast.success("تم حذف العملية");
    setDeleteId(null);
    refetch();
  };

  const topSalesPointByCards = salesPointStats[0] || null;
  const topSalesPointByRevenue = [...salesPointStats].sort((a, b) => b.revenue - a.revenue)[0] || null;

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
          <p className="text-muted-foreground text-xs mt-0.5">قراءة صحيحة للمبيعات اليومية والشهرية ونقاط البيع</p>
        </div>
        <Button size="sm" variant="outline" className="text-xs" onClick={exportCSV} disabled={!filteredSales.length}>
          <Download className="h-3.5 w-3.5 ml-1" /> تصدير CSV
        </Button>
      </div>

      {monthlyComparison && (
        <div className="rounded-md border border-border bg-card p-3 mb-4">
          <div className="flex items-center justify-between gap-3 flex-wrap">
            <div>
              <p className="text-[11px] text-muted-foreground">هذا الشهر</p>
              <p className="text-lg font-semibold text-foreground">{monthlyComparison.thisRevenue.toLocaleString()}</p>
              <p className="text-[10px] text-muted-foreground">{monthlyComparison.thisCards} كرت</p>
            </div>
            <div className="text-center">
              {monthlyComparison.change !== 0 ? (
                <Badge variant={monthlyComparison.change > 0 ? "default" : "destructive"} className="text-[10px]">
                  {monthlyComparison.change > 0 ? "+" : ""}{monthlyComparison.change}%
                </Badge>
              ) : (
                <Badge variant="outline" className="text-[10px]">0%</Badge>
              )}
              <p className="text-[10px] text-muted-foreground mt-1">مقارنة بالشهر السابق</p>
            </div>
            <div className="text-left">
              <p className="text-[11px] text-muted-foreground">الشهر السابق</p>
              <p className="text-lg font-semibold text-muted-foreground">{monthlyComparison.lastRevenue.toLocaleString()}</p>
              <p className="text-[10px] text-muted-foreground">{monthlyComparison.lastCards} كرت</p>
            </div>
          </div>
        </div>
      )}

      <div className="grid grid-cols-2 xl:grid-cols-5 gap-2 mb-4">
        <div className="rounded-md border border-border bg-card p-3">
          <div className="flex items-center gap-1.5 mb-1"><CreditCard className="h-3.5 w-3.5 text-primary" /><span className="text-[11px] text-muted-foreground">كروت ناجحة</span></div>
          {isLoading ? <Skeleton className="h-7 w-14" /> : <p className="text-xl font-semibold text-foreground">{totals.cards}</p>}
        </div>
        <div className="rounded-md border border-border bg-card p-3">
          <div className="flex items-center gap-1.5 mb-1"><Wallet className="h-3.5 w-3.5 text-primary" /><span className="text-[11px] text-muted-foreground">متوسط السعر</span></div>
          {isLoading ? <Skeleton className="h-7 w-14" /> : <p className="text-xl font-semibold text-foreground">{averageCardPrice.toFixed(1)}</p>}
        </div>
        <div className="rounded-md border border-border bg-card p-3">
          <div className="flex items-center gap-1.5 mb-1"><DollarSign className="h-3.5 w-3.5 text-primary" /><span className="text-[11px] text-muted-foreground">الإيرادات</span></div>
          {isLoading ? <Skeleton className="h-7 w-14" /> : <p className="text-xl font-semibold text-foreground">{totals.revenue.toLocaleString()}</p>}
        </div>
        <div className="rounded-md border border-border bg-card p-3">
          <div className="flex items-center gap-1.5 mb-1"><Store className="h-3.5 w-3.5 text-primary" /><span className="text-[11px] text-muted-foreground">الأكثر استخدامًا</span></div>
          {isLoading ? <Skeleton className="h-7 w-20" /> : <p className="text-sm font-semibold text-foreground truncate">{topSalesPointByCards?.name || "—"}</p>}
        </div>
        <div className="rounded-md border border-border bg-card p-3">
          <div className="flex items-center gap-1.5 mb-1"><TrendingUp className="h-3.5 w-3.5 text-primary" /><span className="text-[11px] text-muted-foreground">الأعلى إيرادًا</span></div>
          {isLoading ? <Skeleton className="h-7 w-20" /> : <p className="text-sm font-semibold text-foreground truncate">{topSalesPointByRevenue?.name || "—"}</p>}
        </div>
      </div>

      <div className="grid grid-cols-1 xl:grid-cols-2 gap-4 mb-4">
        {chartData.length > 1 && (
          <div className="rounded-md border border-border bg-card p-3">
            <h3 className="text-xs font-medium text-muted-foreground mb-2">الإيرادات اليومية</h3>
            <ResponsiveContainer width="100%" height={180}>
              <BarChart data={chartData}>
                <CartesianGrid strokeDasharray="3 3" stroke="hsl(var(--border))" />
                <XAxis dataKey="day" tick={{ fontSize: 10, fill: "hsl(var(--muted-foreground))" }} />
                <YAxis tick={{ fontSize: 10, fill: "hsl(var(--muted-foreground))" }} width={40} />
                <Tooltip contentStyle={{ background: "hsl(var(--card))", border: "1px solid hsl(var(--border))", borderRadius: "6px", fontSize: "12px" }} />
                <Bar dataKey="revenue" fill="hsl(var(--primary))" radius={[4, 4, 0, 0]} name="الإيرادات" />
              </BarChart>
            </ResponsiveContainer>
          </div>
        )}

        {topPointsChartData.length > 0 && (
          <div className="rounded-md border border-border bg-card p-3">
            <h3 className="text-xs font-medium text-muted-foreground mb-2">ترتيب نقاط البيع حسب استخدام الكروت</h3>
            <ResponsiveContainer width="100%" height={180}>
              <BarChart data={topPointsChartData} layout="vertical" margin={{ left: 12, right: 8 }}>
                <CartesianGrid strokeDasharray="3 3" stroke="hsl(var(--border))" />
                <XAxis type="number" tick={{ fontSize: 10, fill: "hsl(var(--muted-foreground))" }} />
                <YAxis type="category" dataKey="name" tick={{ fontSize: 10, fill: "hsl(var(--muted-foreground))" }} width={90} />
                <Tooltip contentStyle={{ background: "hsl(var(--card))", border: "1px solid hsl(var(--border))", borderRadius: "6px", fontSize: "12px" }} />
                <Bar dataKey="cards" fill="hsl(var(--primary))" radius={[0, 4, 4, 0]} name="الكروت" />
              </BarChart>
            </ResponsiveContainer>
          </div>
        )}
      </div>

      <div className="flex gap-2 mb-3 flex-wrap items-center">
        {(["today", "week", "month", "all"] as const).map((filter) => (
          <Button
            key={filter}
            size="sm"
            variant={dateFilter === filter ? "default" : "outline"}
            className="text-xs h-7"
            onClick={() => { setDateFilter(filter); setPage(1); }}
          >
            {filter === "today" ? "اليوم" : filter === "week" ? "أسبوع" : filter === "month" ? "شهر" : "الكل"}
          </Button>
        ))}
        {salesPoints.length > 0 && (
          <Select value={salesPointFilter} onValueChange={(value) => { setSalesPointFilter(value); setPage(1); }}>
            <SelectTrigger className="h-7 w-40 text-xs"><Store className="h-3 w-3 ml-1" /><SelectValue placeholder="نقطة البيع" /></SelectTrigger>
            <SelectContent>
              <SelectItem value="all">الكل</SelectItem>
              {salesPoints.map((point) => <SelectItem key={point} value={point}>{point}</SelectItem>)}
            </SelectContent>
          </Select>
        )}
      </div>

      <div className="relative mb-3">
        <Search className="absolute right-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground" />
        <Input placeholder="بحث بالباقة أو نقطة البيع أو الملاحظات..." value={search} onChange={(event) => { setSearch(event.target.value); setPage(1); }} className="pr-10 text-sm h-9" />
      </div>

      {topSalesPointByCards && (
        <div className="flex items-center gap-2 mb-3 text-xs text-muted-foreground flex-wrap">
          <span className="inline-flex items-center gap-1"><CalendarRange className="h-3.5 w-3.5" />الأكثر استخدامًا:</span>
          <Badge variant="outline" className="text-[10px]">{topSalesPointByCards.name} ({topSalesPointByCards.cards} كرت)</Badge>
          {topSalesPointByRevenue ? <Badge variant="outline" className="text-[10px]">{topSalesPointByRevenue.name} ({topSalesPointByRevenue.revenue.toLocaleString()})</Badge> : null}
        </div>
      )}

      <div className="rounded-md border border-border bg-card overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-sm">
            <thead>
              <tr className="border-b border-border bg-muted/30">
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">التاريخ</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">الباقة</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">سعر الوحدة</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">النتيجة</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden sm:table-cell">المبلغ</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden sm:table-cell">نقطة البيع</th>
                <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden md:table-cell">النوع</th>
                <th className="text-center p-2.5 font-medium text-xs text-muted-foreground w-10"></th>
              </tr>
            </thead>
            <tbody>
              {isLoading ? (
                Array.from({ length: 5 }).map((_, index) => (
                  <tr key={index} className="border-b border-border/50">
                    <td className="p-2.5"><Skeleton className="h-4 w-20" /></td>
                    <td className="p-2.5"><Skeleton className="h-4 w-16" /></td>
                    <td className="p-2.5"><Skeleton className="h-4 w-10" /></td>
                    <td className="p-2.5"><Skeleton className="h-4 w-14" /></td>
                    <td className="p-2.5 hidden sm:table-cell"><Skeleton className="h-4 w-14" /></td>
                    <td className="p-2.5 hidden sm:table-cell"><Skeleton className="h-4 w-12" /></td>
                    <td className="p-2.5 hidden md:table-cell"><Skeleton className="h-4 w-12" /></td>
                    <td className="p-2.5"><Skeleton className="h-4 w-6 mx-auto" /></td>
                  </tr>
                ))
              ) : paginatedSales.length === 0 ? (
                <tr>
                  <td colSpan={8} className="p-8 text-center">
                    <BarChart3 className="h-8 w-8 text-muted-foreground/20 mx-auto mb-2" />
                    <p className="text-muted-foreground text-sm">لا توجد مبيعات مطابقة للفلاتر الحالية</p>
                  </td>
                </tr>
              ) : (
                paginatedSales.map((sale) => (
                  <tr key={sale.id} className="border-b border-border/50 hover:bg-muted/20 transition-colors group">
                    <td className="p-2.5 text-xs text-muted-foreground font-mono">{new Date(sale.created_at).toLocaleString("ar", { month: "short", day: "numeric", hour: "2-digit", minute: "2-digit" })}</td>
                    <td className="p-2.5 text-sm font-medium text-foreground">{sale.profile_name}</td>
                    <td className="p-2.5 text-xs font-mono text-foreground">{sale.unit_price.toLocaleString()}</td>
                    <td className="p-2.5 text-xs">
                      <span className="text-primary">{sale.success_count}</span>
                      {sale.failed_count > 0 && <span className="text-destructive mr-1">/{sale.failed_count}✗</span>}
                    </td>
                    <td className="p-2.5 text-xs font-mono text-foreground hidden sm:table-cell">{sale.total_amount.toLocaleString()}</td>
                    <td className="p-2.5 text-xs text-muted-foreground hidden sm:table-cell">{sale.sales_point || "—"}</td>
                    <td className="p-2.5 hidden md:table-cell">
                      <Badge variant="outline" className="text-[9px]">{sale.voucher_type === "hotspot" ? "هوتسبوت" : "يوزر مانجر"}</Badge>
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
              <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page <= 1} onClick={() => setPage((prev) => prev - 1)}>
                <ChevronRight className="h-4 w-4" />
              </Button>
              <span className="text-xs px-2">{page}/{totalPages}</span>
              <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page >= totalPages} onClick={() => setPage((prev) => prev + 1)}>
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
            <AlertDialogDescription>هل أنت متأكد من حذف سجل هذه العملية؟</AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction className="bg-destructive text-destructive-foreground hover:bg-destructive/90" onClick={() => deleteId && handleDelete(deleteId)}>
              حذف
            </AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </DashboardLayout>
  );
}
