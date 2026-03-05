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
    if (saved) { setForm(saved); setConnected(true); setRouterInfo(saved.label || ""); }
  }, []);

  const handleChange = (field: keyof MikrotikConfig, value: string) => {
    setForm((prev) => {
      const updated = { ...prev, [field]: value };
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
          host: form.host, user: form.user, pass: form.pass,
          port: form.port, protocol: form.protocol, mode: form.mode,
        },
      });
      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      const name = Array.isArray(data) ? data[0]?.name : data?.name;
      saveMikrotikConfig({ ...form, label: name || "MikroTik" });
      setConnected(true);
      setRouterInfo(name || "MikroTik");
      queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
      toast.success(`تم الاتصال بنجاح! ${name || "MikroTik"}`);
    } catch (err: any) {
      setConnected(false);
      toast.error("فشل الاتصال: " + (err.message || "خطأ"));
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
        <h2 className="text-xl font-bold text-foreground flex items-center gap-2">
          <Settings className="h-5 w-5 text-muted-foreground" />
          إعدادات الاتصال
        </h2>
        <p className="text-muted-foreground text-sm">إعداد الاتصال بالمايكروتيك</p>
      </div>

      <div className="max-w-2xl space-y-4">
        {connected && (
          <div className="flex items-center gap-3 p-3 rounded-xl bg-success/10 border border-success/20">
            <CheckCircle className="h-4 w-4 text-success shrink-0" />
            <div>
              <p className="text-sm font-medium text-foreground">متصل: {routerInfo}</p>
              <p className="text-xs text-muted-foreground">{form.mode === "rest" ? "REST" : "API"} • {form.host}:{form.port}</p>
            </div>
          </div>
        )}

        <div className="rounded-xl border border-border bg-card shadow-card p-5">
          <h3 className="text-sm font-semibold text-foreground mb-4">طريقة الاتصال</h3>
          <div className="grid grid-cols-2 gap-2 mb-4">
            <button
              onClick={() => handleChange("mode", "rest")}
              className={`p-3 rounded-xl border text-right transition-all ${
                form.mode === "rest" ? "border-primary bg-primary/5" : "border-border bg-muted"
              }`}
            >
              <Server className={`h-4 w-4 mb-1 ${form.mode === "rest" ? "text-primary" : "text-muted-foreground"}`} />
              <p className="font-medium text-foreground text-sm">REST API</p>
              <p className="text-xs text-muted-foreground">v7.1+</p>
            </button>
            <button
              onClick={() => handleChange("mode", "api")}
              className={`p-3 rounded-xl border text-right transition-all ${
                form.mode === "api" ? "border-primary bg-primary/5" : "border-border bg-muted"
              }`}
            >
              <Wifi className={`h-4 w-4 mb-1 ${form.mode === "api" ? "text-primary" : "text-muted-foreground"}`} />
              <p className="font-medium text-foreground text-sm">MikroTik API</p>
              <p className="text-xs text-muted-foreground">v6 / v7</p>
            </button>
          </div>
        </div>

        <div className="rounded-xl border border-border bg-card shadow-card p-5 space-y-4">
          <h3 className="text-sm font-semibold text-foreground">بيانات الاتصال</h3>

          <div>
            <label className="block text-sm font-medium text-foreground mb-1.5">العنوان</label>
            <div className="flex gap-2">
              <select
                value={form.protocol}
                onChange={(e) => handleChange("protocol", e.target.value)}
                className="bg-muted border border-border rounded-xl px-3 py-2.5 text-sm text-foreground focus:outline-none focus:ring-2 focus:ring-ring"
              >
                {protocolOptions.map((opt) => (
                  <option key={opt.value} value={opt.value}>{opt.label}</option>
                ))}
              </select>
              <input
                type="text"
                value={form.host}
                onChange={(e) => handleChange("host", e.target.value.trim())}
                placeholder="192.168.88.1"
                className="flex-1 bg-muted border border-border rounded-xl px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring font-mono"
                dir="ltr"
              />
            </div>
          </div>

          <div>
            <label className="block text-sm font-medium text-foreground mb-1.5">البورت</label>
            <input
              type="text"
              value={form.port}
              onChange={(e) => handleChange("port", e.target.value.trim())}
              className="w-full bg-muted border border-border rounded-xl px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring"
              dir="ltr"
            />
          </div>

          <div>
            <label className="block text-sm font-medium text-foreground mb-1.5">المستخدم</label>
            <input
              type="text"
              value={form.user}
              onChange={(e) => handleChange("user", e.target.value)}
              placeholder="admin"
              className="w-full bg-muted border border-border rounded-xl px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring"
              dir="ltr"
            />
          </div>

          <div>
            <label className="block text-sm font-medium text-foreground mb-1.5">كلمة المرور</label>
            <input
              type="password"
              value={form.pass}
              onChange={(e) => handleChange("pass", e.target.value)}
              placeholder="••••••••"
              className="w-full bg-muted border border-border rounded-xl px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring"
              dir="ltr"
            />
          </div>

          <div className="flex gap-2 pt-1">
            <button
              onClick={testConnection}
              disabled={testing || !form.host || !form.user || !form.pass}
              className="flex-1 gradient-primary text-primary-foreground font-medium py-2.5 rounded-xl text-sm transition-all hover:opacity-90 disabled:opacity-50 flex items-center justify-center gap-2 shadow-glow"
            >
              {testing ? <><Loader2 className="h-4 w-4 animate-spin" />جاري...</> : "اتصال وحفظ"}
            </button>
            {connected && (
              <button
                onClick={disconnect}
                className="py-2.5 px-4 rounded-xl text-sm font-medium border border-destructive/30 text-destructive hover:bg-destructive/10 transition-colors flex items-center gap-1.5"
              >
                <WifiOff className="h-4 w-4" />قطع
              </button>
            )}
          </div>
        </div>

        <div className="rounded-xl border border-border bg-card shadow-card p-5">
          <h3 className="text-sm font-semibold text-foreground mb-3">💡 نصائح</h3>
          <ul className="space-y-1.5 text-xs text-muted-foreground">
            <li>• REST API: فعّل www أو www-ssl من IP → Services</li>
            <li>• MikroTik API: فعّل api أو api-ssl من IP → Services</li>
            <li>• Cloud: فعّل IP → Cloud واستخدم xxx.sn.mynetname.net</li>
            <li>• تأكد من فتح البورت في الفايروول</li>
          </ul>
        </div>
      </div>
    </DashboardLayout>
  );
}
