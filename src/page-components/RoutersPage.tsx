"use client";

import { useState, useEffect } from "react";
import { useRouter } from "next/navigation";
import { useAuth } from "@/contexts/AuthContext";
import { supabase } from "@/integrations/supabase/client";
import { invokeMikrotik } from "@/lib/mikrotikInvoke";
import {
  Router, Plus, Trash2, Wifi, WifiOff, Loader2, LogOut,
  Server, Search, Moon, Sun, Signal,
} from "lucide-react";
import { toast } from "sonner";
import { setActiveRouter, type ConnectionMode, type ConnectionProtocol, getDefaultPort, getProtocolOptions } from "@/lib/mikrotikConfig";
import {
  Dialog, DialogContent, DialogHeader, DialogTitle,
} from "@/components/ui/dialog";

interface RouterRow {
  id: string;
  label: string;
  host: string;
  port: string;
  username: string;
  password: string;
  protocol: string;
  mode: string;
  router_os_version: string | null;
  is_online: boolean;
  last_connected_at: string | null;
}

export default function RoutersPage() {
  const { user, signOut } = useAuth();
  const navigation = useRouter();
  const [routers, setRouters] = useState<RouterRow[]>([]);
  const [loading, setLoading] = useState(true);
  const [showAdd, setShowAdd] = useState(false);
  const [connecting, setConnecting] = useState<string | null>(null);
  const [saving, setSaving] = useState(false);
  const [scanning, setScanning] = useState(false);
  const [scanResults, setScanResults] = useState<{ port: number; open: boolean; service: string }[]>([]);
  const [isDark, setIsDark] = useState(() => document.documentElement.classList.contains("dark"));

  const [form, setForm] = useState({
    label: "", host: "", port: "443", username: "admin", password: "",
    protocol: "https" as ConnectionProtocol, mode: "rest" as ConnectionMode,
  });

  useEffect(() => {
    if (isDark) document.documentElement.classList.add("dark");
    else document.documentElement.classList.remove("dark");
    localStorage.setItem("theme", isDark ? "dark" : "light");
  }, [isDark]);

  const fetchRouters = async () => {
    const { data, error } = await supabase
      .from("routers")
      .select("*")
      .order("created_at", { ascending: false });
    if (!error && data) setRouters(data as RouterRow[]);
    setLoading(false);
  };

  useEffect(() => { fetchRouters(); }, []);

  const handleModeChange = (mode: ConnectionMode) => {
    const protocol = mode === "rest" ? "https" : "api-plain";
    setForm(f => ({ ...f, mode, protocol: protocol as ConnectionProtocol, port: getDefaultPort(mode, protocol as ConnectionProtocol) }));
    setScanResults([]);
  };

  const scanPorts = async () => {
    if (!form.host) { toast.error("أدخل عنوان الراوتر أولاً"); return; }
    setScanning(true);
    setScanResults([]);
    try {
      const portsToProbe = [80, 443, 8080, 8728, 8729];
      const checks = await Promise.all(
        portsToProbe.map(async (port) => {
          let open = false;
          try {
            await invokeMikrotik({
              endpoint: "/system/identity/print",
              host: form.host,
              user: form.username,
              pass: form.password,
              port: String(port),
              protocol: port === 8728 ? "api-plain" : port === 8729 ? "api-ssl" : port === 443 ? "https" : "http",
              mode: port === 8728 || port === 8729 ? "api" : "rest",
              timeoutMs: 1800,
            });
            open = true;
          } catch {
            open = false;
          }

          const service =
            port === 8728 ? "API" :
            port === 8729 ? "API-SSL" :
            port === 443 ? "HTTPS REST" :
            port === 8080 ? "HTTP REST (8080)" : "HTTP REST";
          return { port, open, service };
        }),
      );

      const data = checks;
      if (Array.isArray(data)) {
        setScanResults(data);
        const openPorts = data.filter((p: any) => p.open);
        toast[openPorts.length > 0 ? "success" : "warning"](
          openPorts.length > 0 ? `تم العثور على ${openPorts.length} بورت مفتوح` : "لم يتم العثور على بورتات مفتوحة"
        );
      }
    } catch (err: any) {
      toast.error("فشل الفحص: " + (err.message || "خطأ"));
    } finally { setScanning(false); }
  };

  const selectScannedPort = (port: number, service: string) => {
    let mode: ConnectionMode = "rest";
    let protocol: ConnectionProtocol = "https";
    if (port === 8728) { mode = "api"; protocol = "api-plain"; }
    else if (port === 8729) { mode = "api"; protocol = "api-ssl"; }
    else if (port === 443) { mode = "rest"; protocol = "https"; }
    else if (port === 80 || port === 8080) { mode = "rest"; protocol = "http"; }
    setForm(f => ({ ...f, mode, protocol, port: String(port) }));
    toast.info(`تم اختيار ${service} (بورت ${port})`);
  };

  const addRouter = async () => {
    if (!form.host || !form.username || !form.password) {
      toast.error("يرجى تعبئة جميع الحقول المطلوبة");
      return;
    }
    setSaving(true);
    try {
      const data = await invokeMikrotik({
        endpoint: "/system/identity/print",
        host: form.host,
        user: form.username,
        pass: form.password,
        port: form.port,
        protocol: form.protocol,
        mode: form.mode,
        timeoutMs: 7000,
      });
      const name = Array.isArray(data) ? data[0]?.name : data?.name;

      let version = null;
      try {
        const resData = await invokeMikrotik({
          endpoint: "/system/resource/print",
          host: form.host,
          user: form.username,
          pass: form.password,
          port: form.port,
          protocol: form.protocol,
          mode: form.mode,
          timeoutMs: 8000,
        });
        const res = Array.isArray(resData) ? resData[0] : resData;
        version = res?.version || null;
      } catch {}

      const { error: insertErr } = await supabase.from("routers").insert({
        user_id: user!.id,
        label: form.label || name || "MikroTik",
        host: form.host, port: form.port, username: form.username,
        password: form.password, protocol: form.protocol, mode: form.mode,
        router_os_version: version, is_online: true,
        last_connected_at: new Date().toISOString(),
      });
      if (insertErr) throw insertErr;

      toast.success(`تمت إضافة الراوتر: ${name || form.label || "MikroTik"}`);
      setShowAdd(false);
      setForm({ label: "", host: "", port: "443", username: "admin", password: "", protocol: "https", mode: "rest" });
      setScanResults([]);
      fetchRouters();
    } catch (err: any) {
      toast.error("فشل الاتصال: " + (err.message || "خطأ غير معروف"));
    } finally { setSaving(false); }
  };

  const connectToRouter = async (router: RouterRow) => {
    setConnecting(router.id);
    try {
      await invokeMikrotik({
        endpoint: "/system/identity/print",
        host: router.host,
        user: router.username,
        pass: router.password,
        port: router.port,
        protocol: router.protocol,
        mode: router.mode,
        timeoutMs: 7000,
      });

      setActiveRouter({
        routerId: router.id,
        host: router.host,
        port: router.port,
        label: router.label,
        protocol: router.protocol as ConnectionProtocol,
        mode: router.mode as ConnectionMode,
      });

      await supabase.from("routers").update({
        is_online: true, last_connected_at: new Date().toISOString(),
      }).eq("id", router.id);

      toast.success(`متصل بـ ${router.label}`);
      navigation.push("/loading");
    } catch (err: any) {
      toast.error("فشل الاتصال: " + (err.message || "خطأ"));
      await supabase.from("routers").update({ is_online: false }).eq("id", router.id);
    } finally { setConnecting(null); }
  };

  const deleteRouter = async (id: string) => {
    const { error } = await supabase.from("routers").delete().eq("id", id);
    if (!error) { setRouters(r => r.filter(x => x.id !== id)); toast.success("تم حذف الراوتر"); }
  };

  const protocolOptions = getProtocolOptions(form.mode);

  return (
    <div className="min-h-screen bg-background" dir="rtl">
      {/* Header */}
      <header className="border-b border-border bg-card/80 backdrop-blur-md sticky top-0 z-30 px-4 sm:px-6 py-3">
        <div className="max-w-4xl mx-auto flex items-center justify-between">
          <div className="flex items-center gap-3">
            <div className="p-2 rounded-lg gradient-primary">
              <Router className="h-5 w-5 text-primary-foreground" />
            </div>
            <div>
              <h1 className="font-bold text-foreground text-sm">MikroTik Manager</h1>
              <p className="text-[10px] text-muted-foreground">{user?.email}</p>
            </div>
          </div>
          <div className="flex items-center gap-1">
            <button onClick={() => setIsDark(!isDark)} className="p-2 rounded-md text-muted-foreground hover:text-foreground hover:bg-muted transition-colors">
              {isDark ? <Sun className="h-4 w-4" /> : <Moon className="h-4 w-4" />}
            </button>
            <button onClick={() => { signOut(); navigation.push("/auth"); }} className="p-2 rounded-md text-muted-foreground hover:text-foreground hover:bg-muted transition-colors">
              <LogOut className="h-4 w-4" />
            </button>
          </div>
        </div>
      </header>

      <div className="max-w-4xl mx-auto p-4 sm:p-6">
        <div className="flex items-center justify-between mb-6">
          <div>
            <h2 className="text-lg font-bold text-foreground">الراوترات</h2>
            <p className="text-xs text-muted-foreground">اختر راوتر أو أضف جديد</p>
          </div>
          <button
            onClick={() => setShowAdd(true)}
            className="gradient-primary text-primary-foreground font-medium py-2 px-4 rounded-lg text-sm hover:opacity-90 transition-opacity flex items-center gap-2"
          >
            <Plus className="h-4 w-4" />
            إضافة
          </button>
        </div>

        {/* Router List */}
        {loading ? (
          <div className="flex items-center justify-center py-20">
            <Loader2 className="h-6 w-6 animate-spin text-foreground" />
          </div>
        ) : routers.length === 0 ? (
          <div className="text-center py-20">
            <Router className="h-10 w-10 text-muted-foreground/30 mx-auto mb-4" />
            <h3 className="text-lg font-bold text-foreground mb-2">لا توجد راوترات</h3>
            <p className="text-muted-foreground mb-6 text-sm">أضف أول راوتر للبدء</p>
            <button onClick={() => setShowAdd(true)} className="gradient-primary text-primary-foreground font-medium py-2.5 px-6 rounded-lg text-sm hover:opacity-90 transition-opacity">
              إضافة راوتر
            </button>
          </div>
        ) : (
          <div className="grid gap-2">
            {routers.map((router) => (
              <div
                key={router.id}
                className="group rounded-lg border border-border bg-card shadow-card p-4 hover:border-foreground/20 transition-all cursor-pointer"
                onClick={() => connectToRouter(router)}
              >
                <div className="flex items-center justify-between">
                  <div className="flex items-center gap-3 min-w-0">
                    <div className={`p-2 rounded-md shrink-0 ${router.is_online ? "bg-success/10" : "bg-muted"}`}>
                      {router.is_online ? <Wifi className="h-4 w-4 text-success" /> : <WifiOff className="h-4 w-4 text-muted-foreground" />}
                    </div>
                    <div className="min-w-0">
                      <h3 className="font-semibold text-foreground text-sm truncate">{router.label}</h3>
                      <div className="flex items-center gap-2 text-[11px] text-muted-foreground mt-0.5">
                        <span className="font-mono">{router.host}:{router.port}</span>
                        <span>•</span>
                        <span>{router.mode === "rest" ? "REST" : "API"}</span>
                        {router.router_os_version && <><span>•</span><span>{router.router_os_version}</span></>}
                      </div>
                    </div>
                  </div>
                  <div className="flex items-center gap-1.5 shrink-0">
                    <button
                      onClick={(e) => { e.stopPropagation(); connectToRouter(router); }}
                      disabled={connecting === router.id}
                      className="gradient-primary text-primary-foreground font-medium py-1.5 px-3 rounded-md text-xs hover:opacity-90 transition-opacity disabled:opacity-50 flex items-center gap-1"
                    >
                      {connecting === router.id ? <Loader2 className="h-3 w-3 animate-spin" /> : <Signal className="h-3 w-3" />}
                      <span className="hidden sm:inline">{connecting === router.id ? "جاري..." : "اتصال"}</span>
                    </button>
                    <button
                      onClick={(e) => { e.stopPropagation(); deleteRouter(router.id); }}
                      className="p-1.5 rounded-md text-muted-foreground hover:text-destructive hover:bg-destructive/10 transition-colors opacity-0 group-hover:opacity-100"
                    >
                      <Trash2 className="h-3.5 w-3.5" />
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>

      {/* Add Router Dialog */}
      <Dialog open={showAdd} onOpenChange={setShowAdd}>
        <DialogContent className="max-w-lg max-h-[90vh] overflow-y-auto" dir="rtl">
          <DialogHeader>
            <DialogTitle className="text-sm">إضافة راوتر جديد</DialogTitle>
          </DialogHeader>

          <div className="space-y-4 mt-2">
            {/* Mode */}
            <div className="grid grid-cols-2 gap-2">
              <button onClick={() => handleModeChange("rest")} className={`p-3 rounded-lg border text-right transition-all ${form.mode === "rest" ? "border-foreground/30 bg-primary/5" : "border-border bg-muted"}`}>
                <Server className={`h-4 w-4 mb-1 ${form.mode === "rest" ? "text-foreground" : "text-muted-foreground"}`} />
                <p className="font-medium text-foreground text-sm">REST API</p>
                <p className="text-[10px] text-muted-foreground">v7.1+</p>
              </button>
              <button onClick={() => handleModeChange("api")} className={`p-3 rounded-lg border text-right transition-all ${form.mode === "api" ? "border-foreground/30 bg-primary/5" : "border-border bg-muted"}`}>
                <Wifi className={`h-4 w-4 mb-1 ${form.mode === "api" ? "text-foreground" : "text-muted-foreground"}`} />
                <p className="font-medium text-foreground text-sm">MikroTik API</p>
                <p className="text-[10px] text-muted-foreground">v6 / v7</p>
              </button>
            </div>

            <div>
              <label className="block text-xs font-medium text-foreground mb-1.5">اسم الراوتر (اختياري)</label>
              <input type="text" value={form.label} onChange={(e) => setForm(f => ({ ...f, label: e.target.value }))} placeholder="مكتب - راوتر رئيسي"
                className="w-full bg-muted border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring transition-shadow" />
            </div>

            <div>
              <label className="block text-xs font-medium text-foreground mb-1.5">العنوان</label>
              <div className="flex gap-2">
                <select value={form.protocol} onChange={(e) => { const p = e.target.value as ConnectionProtocol; setForm(f => ({ ...f, protocol: p, port: getDefaultPort(f.mode, p) })); }}
                  className="bg-muted border border-border rounded-lg px-3 py-2.5 text-sm text-foreground focus:outline-none focus:ring-2 focus:ring-ring">
                  {protocolOptions.map(o => <option key={o.value} value={o.value}>{o.label}</option>)}
                </select>
                <input type="text" value={form.host} onChange={(e) => setForm(f => ({ ...f, host: e.target.value.trim() }))} placeholder="192.168.88.1"
                  className="flex-1 bg-muted border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring font-mono" dir="ltr" />
              </div>
            </div>

            {/* Port Scan */}
            {form.host && (
              <div>
                <button onClick={scanPorts} disabled={scanning}
                  className="w-full flex items-center justify-center gap-2 py-2 rounded-lg border border-dashed border-border text-xs text-muted-foreground hover:text-foreground hover:border-foreground/20 transition-all disabled:opacity-50">
                  {scanning ? <Loader2 className="h-3 w-3 animate-spin" /> : <Search className="h-3 w-3" />}
                  {scanning ? "جاري الفحص..." : "فحص البورتات المفتوحة"}
                </button>
                {scanResults.length > 0 && (
                  <div className="mt-2 space-y-1">
                    {scanResults.filter(r => r.open).map((r) => (
                      <button key={r.port} onClick={() => selectScannedPort(r.port, r.service)}
                        className="w-full flex items-center justify-between p-2 rounded-md bg-success/5 border border-success/20 text-sm hover:bg-success/10 transition-colors">
                        <span className="flex items-center gap-2">
                          <span className="h-1.5 w-1.5 rounded-full bg-success" />
                          <span className="text-foreground text-xs font-medium">{r.service}</span>
                        </span>
                        <span className="font-mono text-[10px] text-muted-foreground">:{r.port}</span>
                      </button>
                    ))}
                  </div>
                )}
              </div>
            )}

            <div className="grid grid-cols-3 gap-2">
              <div>
                <label className="block text-xs font-medium text-foreground mb-1.5">البورت</label>
                <input type="text" value={form.port} onChange={(e) => setForm(f => ({ ...f, port: e.target.value.trim() }))}
                  className="w-full bg-muted border border-border rounded-lg px-3 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring" dir="ltr" />
              </div>
              <div>
                <label className="block text-xs font-medium text-foreground mb-1.5">المستخدم</label>
                <input type="text" value={form.username} onChange={(e) => setForm(f => ({ ...f, username: e.target.value }))}
                  className="w-full bg-muted border border-border rounded-lg px-3 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring" dir="ltr" />
              </div>
              <div>
                <label className="block text-xs font-medium text-foreground mb-1.5">كلمة المرور</label>
                <input type="password" value={form.password} onChange={(e) => setForm(f => ({ ...f, password: e.target.value }))}
                  className="w-full bg-muted border border-border rounded-lg px-3 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring" dir="ltr" />
              </div>
            </div>

            <button onClick={addRouter} disabled={saving || !form.host || !form.username || !form.password}
              className="w-full gradient-primary text-primary-foreground font-medium py-2.5 rounded-lg text-sm transition-all hover:opacity-90 disabled:opacity-50 flex items-center justify-center gap-2">
              {saving ? <><Loader2 className="h-4 w-4 animate-spin" />جاري الاختبار...</> : "اختبار وحفظ"}
            </button>
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
