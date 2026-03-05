import DashboardLayout from "@/components/DashboardLayout";
import { Settings, Info } from "lucide-react";

export default function SettingsPage() {
  return (
    <DashboardLayout>
      <div className="mb-6">
        <h2 className="text-2xl font-bold text-foreground flex items-center gap-2">
          <Settings className="h-6 w-6 text-muted-foreground" />
          الإعدادات
        </h2>
        <p className="text-muted-foreground text-sm">إعدادات الاتصال بجهاز المايكروتيك</p>
      </div>

      <div className="gradient-card rounded-xl border border-border shadow-card p-6 max-w-xl">
        <div className="flex items-start gap-3 p-4 rounded-lg bg-info/10 border border-info/20 mb-6">
          <Info className="h-5 w-5 text-info mt-0.5 shrink-0" />
          <div className="text-sm text-foreground">
            <p className="font-medium mb-1">بيانات الاتصال محفوظة بشكل آمن</p>
            <p className="text-muted-foreground">
              عنوان IP واسم المستخدم وكلمة المرور لجهاز المايكروتيك محفوظة كمتغيرات سرية في الباك إند.
              لتغييرها، تواصل مع المطوّر.
            </p>
          </div>
        </div>

        <div className="space-y-4 text-sm">
          <div className="flex justify-between items-center py-3 border-b border-border">
            <span className="text-muted-foreground">البروتوكول</span>
            <span className="font-mono text-foreground">RouterOS REST API</span>
          </div>
          <div className="flex justify-between items-center py-3 border-b border-border">
            <span className="text-muted-foreground">المنفذ الافتراضي</span>
            <span className="font-mono text-foreground">443 (HTTPS) / 80 (HTTP)</span>
          </div>
          <div className="flex justify-between items-center py-3">
            <span className="text-muted-foreground">الحالة</span>
            <span className="px-2 py-1 rounded-full text-xs font-medium bg-success/20 text-success">متصل</span>
          </div>
        </div>
      </div>
    </DashboardLayout>
  );
}
