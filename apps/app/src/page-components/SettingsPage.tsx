import { useState } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { CheckCircle, WifiOff, Server, Wifi, Router } from "lucide-react";
import {
  getActiveRouter, clearActiveRouter,
} from "@repo/mikrotik";
import { useQueryClient } from "@tanstack/react-query";
import { useRouter } from "next/navigation";
import { toast } from "sonner";
import { Card, CardHeader, CardTitle, CardContent } from "@repo/design-system/components/ui/card";
import { Alert, AlertDescription } from "@repo/design-system/components/ui/alert";
import { Button } from "@repo/design-system/components/ui/button";

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
          <Alert className="border-success/20 bg-success/5 [&>svg]:text-success">
            <CheckCircle className="h-4 w-4" />
            <AlertDescription>
              <p className="text-sm font-medium text-foreground">متصل: {config.label}</p>
              <p className="text-[10px] text-muted-foreground font-mono">{config.mode === "rest" ? "REST" : "API"} • {config.host}:{config.port}</p>
            </AlertDescription>
          </Alert>
        ) : (
          <Alert>
            <WifiOff className="h-4 w-4" />
            <AlertDescription className="text-sm text-muted-foreground">غير متصل بأي راوتر</AlertDescription>
          </Alert>
        )}

        {config && (
          <Card>
            <CardHeader className="p-5 pb-3">
              <CardTitle className="text-xs font-semibold uppercase tracking-wide">معلومات الاتصال</CardTitle>
            </CardHeader>
            <CardContent className="p-5 pt-0 space-y-3">
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
                <Button onClick={() => navigation.push("/routers")} className="flex-1">
                  <Router className="h-4 w-4" />
                  إدارة الراوترات
                </Button>
                <Button variant="destructive" onClick={disconnect}>
                  <WifiOff className="h-4 w-4" />قطع
                </Button>
              </div>
            </CardContent>
          </Card>
        )}

        {!config && (
          <Button onClick={() => navigation.push("/routers")} className="w-full">
            <Router className="h-4 w-4" />
            اختيار راوتر
          </Button>
        )}

        <Card>
          <CardHeader className="p-5 pb-3">
            <CardTitle className="text-xs font-semibold uppercase tracking-wide">نصائح</CardTitle>
          </CardHeader>
          <CardContent className="p-5 pt-0">
            <ul className="space-y-1.5 text-[11px] text-muted-foreground leading-relaxed">
              <li>• REST API: فعّل www أو www-ssl من IP → Services</li>
              <li>• MikroTik API: فعّل api أو api-ssl من IP → Services</li>
              <li>• تأكد من فتح البورت في الفايروول</li>
              <li>• بيانات الاتصال محمية ولا تُخزَّن في المتصفح</li>
            </ul>
          </CardContent>
        </Card>
      </div>
    </DashboardLayout>
  );
}
