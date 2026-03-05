import { useState, useEffect } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { Settings, Info, CheckCircle, Loader2, WifiOff } from "lucide-react";
import { getMikrotikConfig, saveMikrotikConfig, clearMikrotikConfig, type MikrotikConfig } from "@/lib/mikrotikConfig";
import { supabase } from "@/integrations/supabase/client";
import { useQueryClient } from "@tanstack/react-query";
import { toast } from "sonner";

export default function SettingsPage() {
  const queryClient = useQueryClient();
  const [form, setForm] = useState<MikrotikConfig>({
    host: "",
    user: "admin",
    pass: "",
    port: "443",
    protocol: "https",
  });
  const [testing, setTesting] = useState(false);
  const [connected, setConnected] = useState(false);

  useEffect(() => {
    const saved = getMikrotikConfig();
    if (saved) {
      setForm(saved);
      setConnected(true);
    }
  }, []);

  const handleChange = (field: keyof MikrotikConfig, value: string) => {
    setForm((prev) => ({ ...prev, [field]: value }));
    setConnected(false);
  };

  const testConnection = async () => {
    if (!form.host || !form.user || !form.pass) {
      toast.error("يرجى تعبئة جميع الحقول المطلوبة");
      return;
    }

    setTesting(true);
    try {
      const { data, error } = await supabase.functions.invoke("mikrotik-api", {
        body: {
          endpoint: "/system/identity/print",
          host: form.host,
          user: form.user,
          pass: form.pass,
          port: form.port,
          protocol: form.protocol,
        },
      });

      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      saveMikrotikConfig(form);
      setConnected(true);
      queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
      toast.success(`تم الاتصال بنجاح! الراوتر: ${data?.name || "MikroTik"}`);
    } catch (err: any) {
      setConnected(false);
      toast.error("فشل الاتصال: " + (err.message || "خطأ غير معروف"));
    } finally {
      setTesting(false);
    }
  };

  const disconnect = () => {
    clearMikrotikConfig();
    setConnected(false);
    setForm({ host: "", user: "admin", pass: "", port: "443", protocol: "https" });
    queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
    toast.info("تم قطع الاتصال");
  };

  return (
    <DashboardLayout>
      <div className="mb-6">
        <h2 className="text-2xl font-bold text-foreground flex items-center gap-2">
          <Settings className="h-6 w-6 text-muted-foreground" />
          الإعدادات
        </h2>
        <p className="text-muted-foreground text-sm">إعداد الاتصال بجهاز المايكروتيك</p>
      </div>

      <div className="gradient-card rounded-xl border border-border shadow-card p-6 max-w-xl">
        {/* Status */}
        {connected && (
          <div className="flex items-center gap-3 p-4 rounded-lg bg-success/10 border border-success/20 mb-6">
            <CheckCircle className="h-5 w-5 text-success shrink-0" />
            <p className="text-sm text-foreground font-medium">متصل بالراوتر</p>
          </div>
        )}

        {!connected && (
          <div className="flex items-start gap-3 p-4 rounded-lg bg-info/10 border border-info/20 mb-6">
            <Info className="h-5 w-5 text-info mt-0.5 shrink-0" />
            <p className="text-sm text-muted-foreground">
              أدخل بيانات جهاز المايكروتيك عشان يتصل البرنامج. لازم يكون RouterOS 7.1+ وال REST API مفعّل.
            </p>
          </div>
        )}

        {/* Form */}
        <div className="space-y-4">
          {/* Protocol + Host */}
          <div>
            <label className="block text-sm font-medium text-foreground mb-1.5">عنوان الراوتر (IP أو Domain)</label>
            <div className="flex gap-2">
              <select
                value={form.protocol}
                onChange={(e) => handleChange("protocol", e.target.value as "http" | "https")}
                className="bg-secondary border border-border rounded-lg px-3 py-2.5 text-sm text-foreground focus:outline-none focus:ring-2 focus:ring-ring"
              >
                <option value="https">HTTPS</option>
                <option value="http">HTTP</option>
              </select>
              <input
                type="text"
                value={form.host}
                onChange={(e) => handleChange("host", e.target.value.trim())}
                placeholder="192.168.88.1"
                className="flex-1 bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring font-mono"
                dir="ltr"
              />
            </div>
          </div>

          {/* Port */}
          <div>
            <label className="block text-sm font-medium text-foreground mb-1.5">رقم البورت</label>
            <input
              type="text"
              value={form.port}
              onChange={(e) => handleChange("port", e.target.value.trim())}
              placeholder="443"
              className="w-full bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring font-mono"
              dir="ltr"
            />
          </div>

          {/* Username */}
          <div>
            <label className="block text-sm font-medium text-foreground mb-1.5">اسم المستخدم</label>
            <input
              type="text"
              value={form.user}
              onChange={(e) => handleChange("user", e.target.value)}
              placeholder="admin"
              className="w-full bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring font-mono"
              dir="ltr"
            />
          </div>

          {/* Password */}
          <div>
            <label className="block text-sm font-medium text-foreground mb-1.5">كلمة المرور</label>
            <input
              type="password"
              value={form.pass}
              onChange={(e) => handleChange("pass", e.target.value)}
              placeholder="••••••••"
              className="w-full bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring font-mono"
              dir="ltr"
            />
          </div>

          {/* Buttons */}
          <div className="flex gap-3 pt-2">
            <button
              onClick={testConnection}
              disabled={testing || !form.host || !form.user || !form.pass}
              className="flex-1 gradient-primary text-primary-foreground font-medium py-2.5 px-4 rounded-lg text-sm transition-opacity hover:opacity-90 disabled:opacity-50 disabled:cursor-not-allowed flex items-center justify-center gap-2"
            >
              {testing ? (
                <>
                  <Loader2 className="h-4 w-4 animate-spin" />
                  جاري الاتصال...
                </>
              ) : (
                "اتصال وحفظ"
              )}
            </button>

            {connected && (
              <button
                onClick={disconnect}
                className="py-2.5 px-4 rounded-lg text-sm font-medium border border-destructive/30 text-destructive hover:bg-destructive/10 transition-colors flex items-center gap-2"
              >
                <WifiOff className="h-4 w-4" />
                قطع
              </button>
            )}
          </div>
        </div>
      </div>
    </DashboardLayout>
  );
}
