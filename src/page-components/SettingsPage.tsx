import { useState, useEffect } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { Settings, CheckCircle, Loader2, WifiOff, Server, Wifi, Zap } from "lucide-react";
import {
  getMikrotikConfig, saveMikrotikConfig, clearMikrotikConfig,
  getDefaultPort, getProtocolOptions,
  type MikrotikConfig, type ConnectionMode, type ConnectionProtocol,
} from "@/lib/mikrotikConfig";
import {
  invokeMikrotik,
  isLocalHostTarget,
  getMikrotikAgentUrl,
  saveMikrotikAgentUrl,
} from "@/lib/mikrotikInvoke";
import { useQueryClient } from "@tanstack/react-query";
import { toast } from "sonner";

export default function SettingsPage() {
  const queryClient = useQueryClient();
  const [form, setForm] = useState<MikrotikConfig>({
    host: "", user: "admin", pass: "", port: "443", protocol: "https", mode: "rest",
  });
  const [testing, setTesting] = useState(false);
  const [connected, setConnected] = useState(false);
  const [routerInfo, setRouterInfo] = useState("");
  const [agentUrl, setAgentUrl] = useState(getMikrotikAgentUrl());

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
      if (field === "protocol") updated.port = getDefaultPort(updated.mode, value as ConnectionProtocol);
      return updated;
    });
    setConnected(false);
  };

  const isLocal = isLocalHostTarget(form.host || "");

  const testConnection = async () => {
    if (!form.host || !form.user || !form.pass) { toast.error("يرجى تعبئة جميع الحقول"); return; }
    setTesting(true);
    try {
      const data = await invokeMikrotik({
        endpoint: "/system/identity/print",
        host: form.host,
        user: form.user,
        pass: form.pass,
        port: form.port,
        protocol: form.protocol,
        mode: form.mode,
        timeoutMs: 7000,
      });
      const name = Array.isArray(data) ? data[0]?.name : data?.name;
      saveMikrotikConfig({ ...form, label: name || "MikroTik" });
      setConnected(true);
      setRouterInfo(name || "MikroTik");
      queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
      const modeLabel = isLocalHostTarget(form.host) ? "⚡ عبر CoreRoute Local Agent" : "☁️ عبر Cloud Bridge";
      toast.success(`تم الاتصال! ${name || ""} — ${modeLabel}`);
    } catch (err: any) {
      setConnected(false);
      toast.error("فشل: " + (err.message || "خطأ"));
    } finally { setTesting(false); }
  };

  const disconnect = () => {
    clearMikrotikConfig();
    setConnected(false); setRouterInfo("");
    setForm({ host: "", user: "admin", pass: "", port: "443", protocol: "https", mode: "rest" });
    queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
    toast.info("تم قطع الاتصال");
  };

  const saveAgentUrl = () => {
    const normalized = agentUrl.trim();
    if (!normalized) {
      toast.error("عنوان الوكيل لا يمكن أن يكون فارغاً");
      return;
    }
    saveMikrotikAgentUrl(normalized);
    setAgentUrl(getMikrotikAgentUrl());
    toast.success("تم حفظ عنوان الوكيل المحلي");
  };

  const resetAgentUrl = () => {
    saveMikrotikAgentUrl("http://127.0.0.1:3001");
    setAgentUrl(getMikrotikAgentUrl());
    toast.success("تمت إعادة العنوان الافتراضي للوكيل");
  };

  const protocolOptions = getProtocolOptions(form.mode);

  return (
    <DashboardLayout>
      <div className="mb-6">
        <h2 className="text-lg font-bold text-foreground">الإعدادات</h2>
        <p className="text-muted-foreground text-xs mt-0.5">إعداد الاتصال بالمايكروتيك</p>
      </div>

      <div className="max-w-xl space-y-4">
        {connected && (
          <div className="flex items-center gap-3 p-3 rounded-lg bg-success/5 border border-success/20">
            <CheckCircle className="h-4 w-4 text-success shrink-0" />
            <div>
              <p className="text-sm font-medium text-foreground">متصل: {routerInfo}</p>
              <p className="text-[10px] text-muted-foreground font-mono">{form.mode === "rest" ? "REST" : "API"} • {form.host}:{form.port}</p>
            </div>
            {isLocal && (
              <span className="mr-auto inline-flex items-center gap-1 px-2 py-0.5 rounded-full bg-primary/10 text-primary text-[10px] font-semibold">
                <Zap className="h-3 w-3" /> محلي مباشر
              </span>
            )}
          </div>
        )}

        <div className="rounded-lg border border-border bg-card shadow-card p-5">
          <h3 className="text-xs font-semibold text-foreground mb-4 uppercase tracking-wide">طريقة الاتصال</h3>
          <div className="grid grid-cols-2 gap-2 mb-4">
            <button onClick={() => handleChange("mode", "rest")} className={`p-3 rounded-lg border text-right transition-all ${form.mode === "rest" ? "border-foreground/30 bg-primary/5" : "border-border bg-muted"}`}>
              <Server className={`h-4 w-4 mb-1 ${form.mode === "rest" ? "text-foreground" : "text-muted-foreground"}`} />
              <p className="font-medium text-foreground text-sm">REST API</p>
              <p className="text-[10px] text-muted-foreground">v7.1+</p>
            </button>
            <button onClick={() => handleChange("mode", "api")} className={`p-3 rounded-lg border text-right transition-all ${form.mode === "api" ? "border-foreground/30 bg-primary/5" : "border-border bg-muted"}`}>
              <Wifi className={`h-4 w-4 mb-1 ${form.mode === "api" ? "text-foreground" : "text-muted-foreground"}`} />
              <p className="font-medium text-foreground text-sm">MikroTik API</p>
              <p className="text-[10px] text-muted-foreground">v6 / v7</p>
            </button>
          </div>
        </div>

        <div className="rounded-lg border border-border bg-card shadow-card p-5 space-y-4">
          <h3 className="text-xs font-semibold text-foreground uppercase tracking-wide">بيانات الاتصال</h3>
          <div>
            <label className="block text-xs font-medium text-foreground mb-1.5">العنوان</label>
            <div className="flex gap-2">
              <select value={form.protocol} onChange={(e) => handleChange("protocol", e.target.value)}
                className="bg-muted border border-border rounded-lg px-3 py-2.5 text-sm text-foreground focus:outline-none focus:ring-2 focus:ring-ring">
                {protocolOptions.map((opt) => <option key={opt.value} value={opt.value}>{opt.label}</option>)}
              </select>
              <input type="text" value={form.host} onChange={(e) => handleChange("host", e.target.value.trim())} placeholder="192.168.88.1"
                className="flex-1 bg-muted border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring font-mono" dir="ltr" />
            </div>
          </div>
          <div>
            <label className="block text-xs font-medium text-foreground mb-1.5">البورت</label>
            <input type="text" value={form.port} onChange={(e) => handleChange("port", e.target.value.trim())}
              className="w-full bg-muted border border-border rounded-lg px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring" dir="ltr" />
          </div>
          <div>
            <label className="block text-xs font-medium text-foreground mb-1.5">المستخدم</label>
            <input type="text" value={form.user} onChange={(e) => handleChange("user", e.target.value)} placeholder="admin"
              className="w-full bg-muted border border-border rounded-lg px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring" dir="ltr" />
          </div>
          <div>
            <label className="block text-xs font-medium text-foreground mb-1.5">كلمة المرور</label>
            <input type="password" value={form.pass} onChange={(e) => handleChange("pass", e.target.value)} placeholder="••••••••"
              className="w-full bg-muted border border-border rounded-lg px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring" dir="ltr" />
          </div>
          <div className="flex gap-2 pt-1">
            <button onClick={testConnection} disabled={testing || !form.host || !form.user || !form.pass}
              className="flex-1 gradient-primary text-primary-foreground font-medium py-2.5 rounded-lg text-sm transition-all hover:opacity-90 disabled:opacity-50 flex items-center justify-center gap-2">
              {testing ? <><Loader2 className="h-4 w-4 animate-spin" />جاري...</> : "اتصال وحفظ"}
            </button>
            {connected && (
              <button onClick={disconnect} className="py-2.5 px-4 rounded-lg text-sm font-medium border border-destructive/30 text-destructive hover:bg-destructive/10 transition-colors flex items-center gap-1.5">
                <WifiOff className="h-4 w-4" />قطع
              </button>
            )}
          </div>
        </div>

        <div className="rounded-lg border border-border bg-card shadow-card p-5 space-y-3">
          <h3 className="text-xs font-semibold text-foreground uppercase tracking-wide">CoreRoute Local Agent</h3>
          <p className="text-[11px] text-muted-foreground">
            يستخدم هذا العنوان عند الاتصال براوتر محلي (LAN). يمكنك تغييره إذا كان الوكيل يعمل على جهاز/بورت مختلف.
          </p>

          <div>
            <label className="block text-xs font-medium text-foreground mb-1.5">Agent URL</label>
            <input
              type="text"
              value={agentUrl}
              onChange={(e) => setAgentUrl(e.target.value)}
              placeholder="http://127.0.0.1:3001"
              className="w-full bg-muted border border-border rounded-lg px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring"
              dir="ltr"
            />
          </div>

          <div className="flex gap-2">
            <button
              onClick={saveAgentUrl}
              className="py-2 px-3 rounded-md text-xs font-medium border border-border hover:bg-muted transition-colors"
            >
              حفظ العنوان
            </button>
            <button
              onClick={resetAgentUrl}
              className="py-2 px-3 rounded-md text-xs font-medium border border-border hover:bg-muted transition-colors"
            >
              افتراضي 127.0.0.1:3001
            </button>
          </div>

          <div className="grid grid-cols-1 sm:grid-cols-2 gap-2 pt-1">
            <a
              href="/downloads/install-coreroute-agent-macos.command"
              download
              className="py-2 px-3 rounded-md text-xs font-medium border border-border hover:bg-muted transition-colors text-center"
            >
              تنزيل macOS Installer
            </a>
            <a
              href="/downloads/install-coreroute-agent-windows.bat"
              download
              className="py-2 px-3 rounded-md text-xs font-medium border border-border hover:bg-muted transition-colors text-center"
            >
              تنزيل Windows Installer
            </a>
            <a
              href="/downloads/build-coreroute-agent-macos-pkg.sh"
              download
              className="py-2 px-3 rounded-md text-xs font-medium border border-border hover:bg-muted transition-colors text-center"
            >
              build macOS PKG
            </a>
            <a
              href="/downloads/build-coreroute-agent-windows-installer.ps1"
              download
              className="py-2 px-3 rounded-md text-xs font-medium border border-border hover:bg-muted transition-colors text-center"
            >
              build Windows Setup ZIP
            </a>
            <a
              href="/downloads/install-coreroute-agent-service-macos.sh"
              download
              className="py-2 px-3 rounded-md text-xs font-medium border border-border hover:bg-muted transition-colors text-center"
            >
              macOS Auto-Start Service
            </a>
            <a
              href="/downloads/install-coreroute-agent-service-windows.bat"
              download
              className="py-2 px-3 rounded-md text-xs font-medium border border-border hover:bg-muted transition-colors text-center"
            >
              Windows Auto-Start Service
            </a>
          </div>

          <p className="text-[10px] text-muted-foreground font-mono">npm run agent:install && npm run agent:dev</p>
        </div>

        <div className="rounded-lg border border-border bg-card shadow-card p-5">
          <h3 className="text-xs font-semibold text-foreground mb-3 uppercase tracking-wide">نصائح</h3>
          <ul className="space-y-1.5 text-[11px] text-muted-foreground leading-relaxed">
            <li>• REST API: فعّل www أو www-ssl من IP → Services</li>
            <li>• MikroTik API: فعّل api أو api-ssl من IP → Services</li>
            <li>• LAN: شغّل CoreRoute Local Agent محليًا على نفس الشبكة</li>
            <li>• Public DNS/IP: يستخدم Cloud Bridge تلقائيًا</li>
            <li>• تأكد من فتح البورت في الفايروول</li>
          </ul>
        </div>
      </div>
    </DashboardLayout>
  );
}
