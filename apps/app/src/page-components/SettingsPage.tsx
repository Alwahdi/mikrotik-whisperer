import { useState } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { CheckCircle, WifiOff, Server, Wifi, Router } from "lucide-react";
import {
  getActiveRouter, clearActiveRouter,
} from "@repo/mikrotik";
import { useQueryClient } from "@tanstack/react-query";
import { useRouter } from "next/navigation";
import { toast } from "sonner";

export default function SettingsPage() {
  const queryClient = useQueryClient();
  const navigation = useRouter();
  const [config] = useState(() => getActiveRouter());

  const disconnect = () => {
    clearActiveRouter();
    queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
    toast.info("تم قطع الاتصال");
    navigation.push("/routers");
  };

  return (
    <DashboardLayout>
      <div className="mb-6">
        <h2 className="text-lg font-bold text-foreground">الإعدادات</h2>
        <p className="text-muted-foreground text-xs mt-0.5">إعداد الاتصال بالمايكروتيك</p>
      </div>

      <div className="max-w-xl space-y-4">
        {config ? (
          <div className="flex items-center gap-3 p-3 rounded-lg bg-success/5 border border-success/20">
            <CheckCircle className="h-4 w-4 text-success shrink-0" />
            <div>
              <p className="text-sm font-medium text-foreground">متصل: {config.label}</p>
              <p className="text-[10px] text-muted-foreground font-mono">{config.mode === "rest" ? "REST" : "API"} • {config.host}:{config.port}</p>
            </div>
          </div>
        ) : (
          <div className="flex items-center gap-3 p-3 rounded-lg bg-muted border border-border">
            <WifiOff className="h-4 w-4 text-muted-foreground shrink-0" />
            <p className="text-sm text-muted-foreground">غير متصل بأي راوتر</p>
          </div>
        )}

        {config && (
          <div className="rounded-lg border border-border bg-card shadow-card p-5 space-y-3">
            <h3 className="text-xs font-semibold text-foreground uppercase tracking-wide">معلومات الاتصال</h3>
            <div className="space-y-2 text-sm">
              <div className="flex items-center gap-2">
                {config.mode === "rest"
                  ? <Server className="h-4 w-4 text-muted-foreground" />
                  : <Wifi className="h-4 w-4 text-muted-foreground" />}
                <span className="text-foreground font-medium">{config.mode === "rest" ? "REST API" : "MikroTik API"}</span>
                <span className="text-muted-foreground text-xs">({config.protocol})</span>
              </div>
              <p className="text-muted-foreground font-mono text-xs" dir="ltr">{config.host}:{config.port}</p>
            </div>
            <div className="flex gap-2 pt-2">
              <button
                onClick={() => navigation.push("/routers")}
                className="flex-1 gradient-primary text-primary-foreground font-medium py-2.5 rounded-lg text-sm transition-all hover:opacity-90 flex items-center justify-center gap-2"
              >
                <Router className="h-4 w-4" />
                إدارة الراوترات
              </button>
              <button onClick={disconnect} className="py-2.5 px-4 rounded-lg text-sm font-medium border border-destructive/30 text-destructive hover:bg-destructive/10 transition-colors flex items-center gap-1.5">
                <WifiOff className="h-4 w-4" />قطع
              </button>
            </div>
          </div>
        )}

        {!config && (
          <button
            onClick={() => navigation.push("/routers")}
            className="w-full gradient-primary text-primary-foreground font-medium py-3 rounded-lg text-sm transition-all hover:opacity-90 flex items-center justify-center gap-2"
          >
            <Router className="h-4 w-4" />
            اختيار راوتر
          </button>
        )}

        <div className="rounded-lg border border-border bg-card shadow-card p-5">
          <h3 className="text-xs font-semibold text-foreground mb-3 uppercase tracking-wide">نصائح</h3>
          <ul className="space-y-1.5 text-[11px] text-muted-foreground leading-relaxed">
            <li>• REST API: فعّل www أو www-ssl من IP → Services</li>
            <li>• MikroTik API: فعّل api أو api-ssl من IP → Services</li>
            <li>• تأكد من فتح البورت في الفايروول</li>
            <li>• بيانات الاتصال محمية ولا تُخزَّن في المتصفح</li>
          </ul>
        </div>
      </div>
    </DashboardLayout>
  );
}
