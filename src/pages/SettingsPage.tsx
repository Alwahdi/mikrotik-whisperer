import { useState, useEffect } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { Settings, CheckCircle, Loader2, WifiOff, Info, Router, Wifi, Server } from "lucide-react";
import {
  getMikrotikConfig, saveMikrotikConfig, clearMikrotikConfig,
  getDefaultPort, getProtocolOptions,
  type MikrotikConfig, type ConnectionMode, type ConnectionProtocol,
} from "@/lib/mikrotikConfig";
import { supabase } from "@/integrations/supabase/client";
import { useQueryClient } from "@tanstack/react-query";
import { toast } from "sonner";

export default function SettingsPage() {
  const queryClient = useQueryClient();
  const [form, setForm] = useState<MikrotikConfig>({
    host: "", user: "admin", pass: "", port: "443", protocol: "https", mode: "rest",
  });
  const [testing, setTesting] = useState(false);
  const [connected, setConnected] = useState(false);
  const [routerInfo, setRouterInfo] = useState<string>("");

  useEffect(() => {
    const saved = getMikrotikConfig();
    if (saved) { setForm(saved); setConnected(true); }
  }, []);

  const handleChange = (field: keyof MikrotikConfig, value: string) => {
    setForm((prev) => {
      const updated = { ...prev, [field]: value };

      // Auto-update port and protocol when mode changes
      if (field === "mode") {
        const mode = value as ConnectionMode;
        const newProtocol = mode === "rest" ? "https" : "api-plain";
        updated.protocol = newProtocol as ConnectionProtocol;
        updated.port = getDefaultPort(mode, newProtocol as ConnectionProtocol);
      }
      if (field === "protocol") {
        updated.port = getDefaultPort(updated.mode, value as ConnectionProtocol);
      }
      return updated;
    });
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
          mode: form.mode,
        },
      });
      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      const name = Array.isArray(data) ? data[0]?.name : data?.name;
      saveMikrotikConfig({ ...form, label: name || "MikroTik" });
      setConnected(true);
      setRouterInfo(name || "MikroTik");
      queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
      toast.success(`تم الاتصال بنجاح! الراوتر: ${name || "MikroTik"}`);
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
    setRouterInfo("");
    setForm({ host: "", user: "admin", pass: "", port: "443", protocol: "https", mode: "rest" });
    queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
    toast.info("تم قطع الاتصال");
  };

  const protocolOptions = getProtocolOptions(form.mode);

  return (
    <DashboardLayout>
      <div className="mb-6">
        <h2 className="text-2xl font-bold text-foreground flex items-center gap-2">
          <Settings className="h-6 w-6 text-muted-foreground" />
          إعدادات الاتصال
        </h2>
        <p className="text-muted-foreground text-sm">إعداد الاتصال بجهاز المايكروتيك (يدعم RouterOS v6 و v7)</p>
      </div>

      <div className="max-w-2xl space-y-6">
        {/* Connection Status */}
        {connected && (
          <div className="flex items-center gap-3 p-4 rounded-xl bg-success/10 border border-success/20">
            <CheckCircle className="h-5 w-5 text-success shrink-0" />
            <div>
              <p className="text-sm font-medium text-foreground">متصل بالراوتر: {routerInfo}</p>
              <p className="text-xs text-muted-foreground">
                {form.mode === "rest" ? "REST API" : "MikroTik API"} • {form.host}:{form.port}
              </p>
            </div>
          </div>
        )}

        {/* Connection Method */}
        <div className="gradient-card rounded-xl border border-border shadow-card p-6">
          <h3 className="text-sm font-semibold text-foreground mb-4 flex items-center gap-2">
            <Router className="h-4 w-4 text-primary" />
            طريقة الاتصال
          </h3>

          <div className="grid grid-cols-2 gap-3 mb-4">
            <button
              onClick={() => handleChange("mode", "rest")}
              className={`p-4 rounded-lg border text-right transition-all ${
                form.mode === "rest"
                  ? "border-primary bg-primary/10 shadow-glow"
                  : "border-border bg-secondary hover:border-muted-foreground"
              }`}
            >
              <Server className={`h-5 w-5 mb-2 ${form.mode === "rest" ? "text-primary" : "text-muted-foreground"}`} />
              <p className="font-medium text-foreground text-sm">REST API</p>
              <p className="text-xs text-muted-foreground mt-1">RouterOS v7.1+</p>
              <p className="text-xs text-muted-foreground">HTTP/HTTPS</p>
            </button>

            <button
              onClick={() => handleChange("mode", "api")}
              className={`p-4 rounded-lg border text-right transition-all ${
                form.mode === "api"
                  ? "border-primary bg-primary/10 shadow-glow"
                  : "border-border bg-secondary hover:border-muted-foreground"
              }`}
            >
              <Wifi className={`h-5 w-5 mb-2 ${form.mode === "api" ? "text-primary" : "text-muted-foreground"}`} />
              <p className="font-medium text-foreground text-sm">MikroTik API</p>
              <p className="text-xs text-muted-foreground mt-1">RouterOS v6 / v7</p>
              <p className="text-xs text-muted-foreground">TCP 8728/8729</p>
            </button>
          </div>

          {form.mode === "api" && (
            <div className="p-3 rounded-lg bg-info/10 border border-info/20 text-xs text-muted-foreground flex items-start gap-2">
              <Info className="h-4 w-4 text-info shrink-0 mt-0.5" />
              <span>يدعم RouterOS v6 (بما في ذلك تسجيل الدخول بالتحقق MD5) و v7. تأكد من تفعيل خدمة API في الراوتر.</span>
            </div>
          )}
        </div>

        {/* Connection Details */}
        <div className="gradient-card rounded-xl border border-border shadow-card p-6">
          <h3 className="text-sm font-semibold text-foreground mb-4">بيانات الاتصال</h3>

          <div className="space-y-4">
            {/* Protocol + Host */}
            <div>
              <label className="block text-sm font-medium text-foreground mb-1.5">
                العنوان (IP / Domain / Cloud DDNS)
              </label>
              <div className="flex gap-2">
                <select
                  value={form.protocol}
                  onChange={(e) => handleChange("protocol", e.target.value)}
                  className="bg-secondary border border-border rounded-lg px-3 py-2.5 text-sm text-foreground focus:outline-none focus:ring-2 focus:ring-ring"
                >
                  {protocolOptions.map((opt) => (
                    <option key={opt.value} value={opt.value}>{opt.label}</option>
                  ))}
                </select>
                <input
                  type="text"
                  value={form.host}
                  onChange={(e) => handleChange("host", e.target.value.trim())}
                  placeholder="192.168.88.1 أو xxxx.sn.mynetname.net"
                  className="flex-1 bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring font-mono"
                  dir="ltr"
                />
              </div>
              <p className="text-xs text-muted-foreground mt-1">يدعم IP محلي، IP عام، أو MikroTik Cloud DDNS</p>
            </div>

            {/* Port */}
            <div>
              <label className="block text-sm font-medium text-foreground mb-1.5">رقم البورت</label>
              <input
                type="text"
                value={form.port}
                onChange={(e) => handleChange("port", e.target.value.trim())}
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
                className="flex-1 gradient-primary text-primary-foreground font-medium py-3 px-4 rounded-lg text-sm transition-opacity hover:opacity-90 disabled:opacity-50 disabled:cursor-not-allowed flex items-center justify-center gap-2"
              >
                {testing ? (
                  <><Loader2 className="h-4 w-4 animate-spin" />جاري الاتصال...</>
                ) : (
                  "🔌 اتصال وحفظ"
                )}
              </button>
              {connected && (
                <button
                  onClick={disconnect}
                  className="py-3 px-4 rounded-lg text-sm font-medium border border-destructive/30 text-destructive hover:bg-destructive/10 transition-colors flex items-center gap-2"
                >
                  <WifiOff className="h-4 w-4" />قطع
                </button>
              )}
            </div>
          </div>
        </div>

        {/* Help */}
        <div className="gradient-card rounded-xl border border-border shadow-card p-6">
          <h3 className="text-sm font-semibold text-foreground mb-3">💡 نصائح مهمة</h3>
          <ul className="space-y-2 text-xs text-muted-foreground">
            <li>• <strong className="text-foreground">REST API (v7+):</strong> فعّل خدمة www أو www-ssl من IP → Services</li>
            <li>• <strong className="text-foreground">MikroTik API (v6/v7):</strong> فعّل خدمة api أو api-ssl من IP → Services</li>
            <li>• <strong className="text-foreground">Cloud DDNS:</strong> فعّل IP → Cloud في الراوتر واستخدم العنوان xxx.sn.mynetname.net</li>
            <li>• <strong className="text-foreground">الوصول عن بعد:</strong> تأكد من فتح البورت المطلوب في الفايروول أو NAT</li>
            <li>• <strong className="text-foreground">الأمان:</strong> يُنصح باستخدام HTTPS/API-SSL واسم مستخدم بصلاحيات قراءة فقط</li>
          </ul>
        </div>
      </div>
    </DashboardLayout>
  );
}
