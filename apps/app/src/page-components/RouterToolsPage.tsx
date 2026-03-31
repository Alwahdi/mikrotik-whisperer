"use client";

import { useState, useMemo } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import {
  useNeighbors,
  useSchedulers,
  useSchedulerAction,
  useScripts,
  useScriptAction,
  useSystemReboot,
} from "@repo/mikrotik";
import {
  Network, Clock, FileCode, Home, RefreshCw,
  Trash2, Play, Plus, AlertTriangle, Loader2, Power,
} from "lucide-react";
import { useQueryClient } from "@tanstack/react-query";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@repo/design-system/components/ui/tabs";
import { Button } from "@repo/design-system/components/ui/button";
import { Input } from "@repo/design-system/components/ui/input";
import { Skeleton } from "@repo/design-system/components/ui/skeleton";
import { Card, CardContent } from "@repo/design-system/components/ui/card";
import { Badge } from "@repo/design-system/components/ui/badge";
import {
  Table, TableHeader, TableBody, TableRow, TableHead, TableCell,
} from "@repo/design-system/components/ui/table";
import {
  AlertDialog, AlertDialogAction, AlertDialogCancel,
  AlertDialogContent, AlertDialogDescription, AlertDialogFooter,
  AlertDialogHeader, AlertDialogTitle,
} from "@repo/design-system/components/ui/alert-dialog";
import {
  Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList,
  BreadcrumbPage, BreadcrumbSeparator,
} from "@repo/design-system/components/ui/breadcrumb";
import Link from "next/link";
import { toast } from "sonner";

// Auto-expiry script source matching mobile app exactly
const AUTO_EXPIRY_SCRIPT_SOURCE = `:local date [/system clock get date]
:local currentMonth [:pick \$date 0 3]
:local months "jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec"
:local monthNum 0
:for i from=0 to=11 step=1 do={
  :if ([:pick \$months (i*4) (i*4+3)] = \$currentMonth) do={ :set monthNum (i+1) }
}
:local currentDay [:tonum [:pick \$date 4 6]]
:local currentYear [:tonum [:pick \$date 7 11]]

:foreach i in=[/ip hotspot user find where comment!=""] do={
  :local comment [/ip hotspot user get \$i comment]
  :if ([:find \$comment "mums-"] = 0) do={
    :local mdate [:pick \$comment 5 [:len \$comment]]
    :local mMonth [:pick \$mdate 0 3]
    :local mMonthNum 0
    :for j from=0 to=11 step=1 do={
      :if ([:pick \$months (j*4) (j*4+3)] = \$mMonth) do={ :set mMonthNum (j+1) }
    }
    :local mDay [:tonum [:pick \$mdate 4 6]]
    :local mYear [:tonum [:pick \$mdate 7 11]]
    :local profile [/ip hotspot user get \$i profile]
    :local validity ""
    :do { :set validity [/ip hotspot user profile get [find name=\$profile] validity] } on-error={}
    :if (\$validity != "") do={
      :local vDays 0
      :if ([:find \$validity "d"] >= 0) do={ :set vDays [:tonum [:pick \$validity 0 [:find \$validity "d"]]] }
      :local totalDays ((\$mYear * 365) + (\$mMonthNum * 30) + \$mDay + \$vDays)
      :local currentTotalDays ((\$currentYear * 365) + (\$monthNum * 30) + \$currentDay)
      :if (\$currentTotalDays > \$totalDays) do={
        /ip hotspot user disable [find where comment=\$comment]
      }
    }
  }
}`;

// On-login script for hotspot profile (stamps first login date)
const ON_LOGIN_SCRIPT = `{:local date [/system clock get date];:if ([/ip hotspot user get $user comment]="") do={[/ip hotspot user set $user comment="mums-$date"]}}`;

export default function RouterToolsPage() {
  const { data: neighbors, isLoading: loadingNeighbors } = useNeighbors();
  const { data: schedulers, isLoading: loadingSchedulers } = useSchedulers();
  const { data: scripts, isLoading: loadingScripts } = useScripts();
  const queryClient = useQueryClient();
  const schedulerAction = useSchedulerAction();
  const scriptAction = useScriptAction();
  const rebootMutation = useSystemReboot();

  const [rebootConfirm, setRebootConfirm] = useState(false);

  const neighborsList = useMemo(() => Array.isArray(neighbors) ? neighbors : [], [neighbors]);
  const schedulersList = useMemo(() => Array.isArray(schedulers) ? schedulers : [], [schedulers]);
  const scriptsList = useMemo(() => Array.isArray(scripts) ? scripts : [], [scripts]);

  const hasExpiryScript = scriptsList.some((s: any) => s.name === "ex_dis_user_new");
  const hasExpiryScheduler = schedulersList.some((s: any) => s.name === "ex_dis_new");
  const isAutoExpiryActive = hasExpiryScript && hasExpiryScheduler;

  const refresh = () => {
    queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
    toast.success("جاري تحديث البيانات...");
  };

  const setupAutoExpiry = async () => {
    try {
      // Step 1: Create the expiry script (matching mobile: /system/script/add)
      if (!hasExpiryScript) {
        await scriptAction.mutateAsync({
          action: "add",
          data: {
            name: "ex_dis_user_new",
            policy: "read,write,policy,test",
            source: AUTO_EXPIRY_SCRIPT_SOURCE,
          },
        });
      }

      // Step 2: Create the scheduler (matching mobile: /system/scheduler/add)
      if (!hasExpiryScheduler) {
        await schedulerAction.mutateAsync({
          action: "add",
          data: {
            name: "ex_dis_new",
            interval: "12:00:00",
            "on-event": "/system script run ex_dis_user_new",
            policy: "ftp,reboot,read,write,policy,test,password,sniff,sensitive,romon",
            "start-time": "startup",
          },
        });
      }

      toast.success("تم إعداد نظام انتهاء الصلاحية التلقائي بنجاح");
    } catch (err: unknown) {
      const msg = err instanceof Error ? err.message : "فشل الإعداد";
      toast.error(msg);
    }
  };

  const removeAutoExpiry = async () => {
    try {
      // Remove scheduler
      const sched = schedulersList.find((s: any) => s.name === "ex_dis_new");
      if (sched) {
        await schedulerAction.mutateAsync({ action: "remove", id: sched[".id"] || sched.id });
      }
      // Remove script
      const script = scriptsList.find((s: any) => s.name === "ex_dis_user_new");
      if (script) {
        await scriptAction.mutateAsync({ action: "remove", id: script[".id"] || script.id });
      }
      toast.success("تم إزالة نظام انتهاء الصلاحية التلقائي");
    } catch (err: unknown) {
      const msg = err instanceof Error ? err.message : "فشلت الإزالة";
      toast.error(msg);
    }
  };

  return (
    <DashboardLayout>
      {/* Breadcrumb */}
      <Breadcrumb className="mb-4">
        <BreadcrumbList>
          <BreadcrumbItem>
            <BreadcrumbLink asChild><Link href="/dashboard"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
          </BreadcrumbItem>
          <BreadcrumbSeparator />
          <BreadcrumbItem>
            <BreadcrumbPage>أدوات RouterOS</BreadcrumbPage>
          </BreadcrumbItem>
        </BreadcrumbList>
      </Breadcrumb>

      {/* Header */}
      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-lg font-bold text-foreground">أدوات RouterOS</h1>
          <p className="text-muted-foreground text-xs mt-0.5">الجيران، المجدول، السكريبتات، وإعادة التشغيل</p>
        </div>
        <div className="flex items-center gap-2">
          <Button size="sm" variant="destructive" onClick={() => setRebootConfirm(true)}>
            <Power className="h-3.5 w-3.5 ml-1" />
            إعادة التشغيل
          </Button>
          <Button size="icon" variant="outline" onClick={refresh}>
            <RefreshCw className="h-4 w-4" />
          </Button>
        </div>
      </div>

      {/* Auto-Expiry Setup Section */}
      <Card className="mb-6">
        <CardContent className="p-4">
          <div className="flex items-center justify-between mb-3">
            <div className="flex items-center gap-2">
              <Clock className="h-4 w-4 text-primary" />
              <h3 className="text-sm font-semibold text-foreground">نظام انتهاء الصلاحية التلقائي</h3>
              {isAutoExpiryActive ? (
                <Badge variant="secondary" className="text-[10px]">نشط</Badge>
              ) : (
                <Badge variant="outline" className="text-[10px]">غير مفعّل</Badge>
              )}
            </div>
          </div>
          <p className="text-xs text-muted-foreground mb-3">
            يقوم هذا النظام بفحص مستخدمي الهوتسبوت كل 12 ساعة وتعطيل المستخدمين منتهيي الصلاحية تلقائياً
            (نفس وظيفة تطبيق الموبايل)
          </p>
          <div className="flex gap-2">
            {!isAutoExpiryActive ? (
              <Button
                size="sm"
                onClick={setupAutoExpiry}
                disabled={schedulerAction.isPending || scriptAction.isPending}
              >
                {(schedulerAction.isPending || scriptAction.isPending) ? (
                  <Loader2 className="h-3.5 w-3.5 ml-1 animate-spin" />
                ) : (
                  <Plus className="h-3.5 w-3.5 ml-1" />
                )}
                تفعيل النظام
              </Button>
            ) : (
              <Button
                size="sm"
                variant="destructive"
                onClick={removeAutoExpiry}
                disabled={schedulerAction.isPending || scriptAction.isPending}
              >
                <Trash2 className="h-3.5 w-3.5 ml-1" />
                إزالة النظام
              </Button>
            )}
          </div>
        </CardContent>
      </Card>

      <Tabs defaultValue="neighbors" dir="rtl">
        <TabsList className="bg-muted mb-4 w-full justify-start">
          <TabsTrigger value="neighbors" className="text-xs"><Network className="h-3 w-3 ml-1" />الجيران {!loadingNeighbors && `(${neighborsList.length})`}</TabsTrigger>
          <TabsTrigger value="schedulers" className="text-xs"><Clock className="h-3 w-3 ml-1" />المجدول {!loadingSchedulers && `(${schedulersList.length})`}</TabsTrigger>
          <TabsTrigger value="scripts" className="text-xs"><FileCode className="h-3 w-3 ml-1" />السكريبتات {!loadingScripts && `(${scriptsList.length})`}</TabsTrigger>
        </TabsList>

        {/* Neighbors - Mobile: /ip/neighbor/print */}
        <TabsContent value="neighbors">
          <Card className="overflow-hidden">
            <CardContent className="p-0">
              <Table>
                <TableHeader>
                  <TableRow>
                    <TableHead className="text-right text-xs">الاسم</TableHead>
                    <TableHead className="text-right text-xs">الواجهة</TableHead>
                    <TableHead className="text-right text-xs">MAC</TableHead>
                    <TableHead className="text-right text-xs">IP</TableHead>
                    <TableHead className="text-right text-xs hidden sm:table-cell">المنصة</TableHead>
                    <TableHead className="text-right text-xs hidden sm:table-cell">البورد</TableHead>
                  </TableRow>
                </TableHeader>
                <TableBody>
                  {loadingNeighbors ? Array.from({ length: 3 }).map((_, i) => (
                    <TableRow key={i}><TableCell colSpan={6}><Skeleton className="h-6 w-full" /></TableCell></TableRow>
                  )) : neighborsList.length === 0 ? (
                    <TableRow><TableCell colSpan={6} className="text-center text-muted-foreground text-xs py-6">لا يوجد جيران مكتشفين</TableCell></TableRow>
                  ) : neighborsList.map((n: any, i: number) => (
                    <TableRow key={i}>
                      <TableCell className="text-sm font-medium text-foreground">{n.identity || "—"}</TableCell>
                      <TableCell className="text-xs text-muted-foreground">{n.interface || "—"}</TableCell>
                      <TableCell className="text-xs font-mono" dir="ltr">{n["mac-address"] || "—"}</TableCell>
                      <TableCell className="text-xs font-mono" dir="ltr">{n.address4 || n.address || "—"}</TableCell>
                      <TableCell className="text-xs text-muted-foreground hidden sm:table-cell">{n.platform || "—"}</TableCell>
                      <TableCell className="text-xs text-muted-foreground hidden sm:table-cell">{n.board || "—"}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </CardContent>
          </Card>
        </TabsContent>

        {/* Schedulers - Mobile: /system/scheduler */}
        <TabsContent value="schedulers">
          <Card className="overflow-hidden">
            <CardContent className="p-0">
              <Table>
                <TableHeader>
                  <TableRow>
                    <TableHead className="text-right text-xs">الاسم</TableHead>
                    <TableHead className="text-right text-xs">الفاصل</TableHead>
                    <TableHead className="text-right text-xs hidden sm:table-cell">التشغيل التالي</TableHead>
                    <TableHead className="text-right text-xs hidden sm:table-cell">مرات التشغيل</TableHead>
                    <TableHead className="text-right text-xs">الحالة</TableHead>
                    <TableHead className="text-right text-xs w-[60px]"></TableHead>
                  </TableRow>
                </TableHeader>
                <TableBody>
                  {loadingSchedulers ? Array.from({ length: 3 }).map((_, i) => (
                    <TableRow key={i}><TableCell colSpan={6}><Skeleton className="h-6 w-full" /></TableCell></TableRow>
                  )) : schedulersList.length === 0 ? (
                    <TableRow><TableCell colSpan={6} className="text-center text-muted-foreground text-xs py-6">لا توجد مهام مجدولة</TableCell></TableRow>
                  ) : schedulersList.map((s: any, i: number) => (
                    <TableRow key={i}>
                      <TableCell className="text-sm font-medium text-foreground">{s.name || "—"}</TableCell>
                      <TableCell className="text-xs font-mono text-muted-foreground">{s.interval || "—"}</TableCell>
                      <TableCell className="text-xs font-mono text-muted-foreground hidden sm:table-cell">{s["next-run"] || "—"}</TableCell>
                      <TableCell className="text-xs text-center hidden sm:table-cell">{s["run-count"] || "0"}</TableCell>
                      <TableCell>
                        <Badge variant={s.disabled === "true" ? "destructive" : "secondary"} className="text-[10px]">
                          {s.disabled === "true" ? "معطل" : "نشط"}
                        </Badge>
                      </TableCell>
                      <TableCell>
                        <Button variant="ghost" size="icon" className="h-7 w-7" onClick={() => schedulerAction.mutate({ action: "remove", id: s[".id"] || s.id })}>
                          <Trash2 className="h-3.5 w-3.5 text-destructive" />
                        </Button>
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </CardContent>
          </Card>
        </TabsContent>

        {/* Scripts - Mobile: /system/script */}
        <TabsContent value="scripts">
          <Card className="overflow-hidden">
            <CardContent className="p-0">
              <Table>
                <TableHeader>
                  <TableRow>
                    <TableHead className="text-right text-xs">الاسم</TableHead>
                    <TableHead className="text-right text-xs hidden sm:table-cell">الصلاحيات</TableHead>
                    <TableHead className="text-right text-xs hidden sm:table-cell">آخر تشغيل</TableHead>
                    <TableHead className="text-right text-xs">مرات التشغيل</TableHead>
                    <TableHead className="text-right text-xs w-[100px]"></TableHead>
                  </TableRow>
                </TableHeader>
                <TableBody>
                  {loadingScripts ? Array.from({ length: 3 }).map((_, i) => (
                    <TableRow key={i}><TableCell colSpan={5}><Skeleton className="h-6 w-full" /></TableCell></TableRow>
                  )) : scriptsList.length === 0 ? (
                    <TableRow><TableCell colSpan={5} className="text-center text-muted-foreground text-xs py-6">لا توجد سكريبتات</TableCell></TableRow>
                  ) : scriptsList.map((s: any, i: number) => (
                    <TableRow key={i}>
                      <TableCell className="text-sm font-medium text-foreground">{s.name || "—"}</TableCell>
                      <TableCell className="text-xs text-muted-foreground hidden sm:table-cell">{s.policy || "—"}</TableCell>
                      <TableCell className="text-xs font-mono text-muted-foreground hidden sm:table-cell">{s["last-started"] || "—"}</TableCell>
                      <TableCell className="text-xs text-center">{s["run-count"] || "0"}</TableCell>
                      <TableCell>
                        <div className="flex items-center gap-1">
                          <Button variant="ghost" size="icon" className="h-7 w-7" onClick={() => scriptAction.mutate({ action: "run", id: s[".id"] || s.id })} title="تشغيل">
                            <Play className="h-3.5 w-3.5 text-primary" />
                          </Button>
                          <Button variant="ghost" size="icon" className="h-7 w-7" onClick={() => scriptAction.mutate({ action: "remove", id: s[".id"] || s.id })} title="حذف">
                            <Trash2 className="h-3.5 w-3.5 text-destructive" />
                          </Button>
                        </div>
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </CardContent>
          </Card>
        </TabsContent>
      </Tabs>

      {/* Reboot Confirmation Dialog */}
      <AlertDialog open={rebootConfirm} onOpenChange={setRebootConfirm}>
        <AlertDialogContent dir="rtl">
          <AlertDialogHeader>
            <AlertDialogTitle className="flex items-center gap-2">
              <AlertTriangle className="h-5 w-5 text-destructive" />
              تأكيد إعادة التشغيل
            </AlertDialogTitle>
            <AlertDialogDescription>
              هل أنت متأكد من إعادة تشغيل الراوتر؟ سيتم قطع جميع الاتصالات مؤقتاً.
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter className="flex-row-reverse gap-2">
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction
              onClick={() => rebootMutation.mutate()}
              className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
            >
              إعادة التشغيل
            </AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </DashboardLayout>
  );
}
