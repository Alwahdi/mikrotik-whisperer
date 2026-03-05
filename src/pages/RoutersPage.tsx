import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "@/contexts/AuthContext";
import { supabase } from "@/integrations/supabase/client";
import {
  Router, Plus, Trash2, Wifi, WifiOff, Loader2, LogOut,
  Server, Edit2, RefreshCw, Settings,
} from "lucide-react";
import { toast } from "sonner";
import { saveMikrotikConfig, type MikrotikConfig, type ConnectionMode, type ConnectionProtocol, getDefaultPort, getProtocolOptions } from "@/lib/mikrotikConfig";
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
  const navigate = useNavigate();
  const [routers, setRouters] = useState<RouterRow[]>([]);
  const [loading, setLoading] = useState(true);
  const [showAdd, setShowAdd] = useState(false);
  const [connecting, setConnecting] = useState<string | null>(null);
  const [saving, setSaving] = useState(false);

  const [form, setForm] = useState({
    label: "", host: "", port: "443", username: "admin", password: "",
    protocol: "https" as ConnectionProtocol, mode: "rest" as ConnectionMode,
  });

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
  };

  const addRouter = async () => {
    if (!form.host || !form.username || !form.password) {
      toast.error("يرجى تعبئة جميع الحقول المطلوبة");
      return;
    }
    setSaving(true);
    try {
      // Test connection first
      const { data, error } = await supabase.functions.invoke("mikrotik-api", {
        body: {
          endpoint: "/system/identity/print",
          host: form.host, user: form.username, pass: form.password,
          port: form.port, protocol: form.protocol, mode: form.mode,
        },
      });
      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      const name = Array.isArray(data) ? data[0]?.name : data?.name;
      
      // Get version info
      let version = null;
      try {
        const { data: resData } = await supabase.functions.invoke("mikrotik-api", {
          body: {
            endpoint: "/system/resource/print",
            host: form.host, user: form.username, pass: form.password,
            port: form.port, protocol: form.protocol, mode: form.mode,
          },
        });
        const res = Array.isArray(resData) ? resData[0] : resData;
        version = res?.version || null;
      } catch {}

      const { error: insertErr } = await supabase.from("routers").insert({
        user_id: user!.id,
        label: form.label || name || "MikroTik",
        host: form.host,
        port: form.port,
        username: form.username,
        password: form.password,
        protocol: form.protocol,
        mode: form.mode,
        router_os_version: version,
        is_online: true,
        last_connected_at: new Date().toISOString(),
      });
      if (insertErr) throw insertErr;

      toast.success(`تمت إضافة الراوتر: ${name || form.label || "MikroTik"}`);
      setShowAdd(false);
      setForm({ label: "", host: "", port: "443", username: "admin", password: "", protocol: "https", mode: "rest" });
      fetchRouters();
    } catch (err: any) {
      toast.error("فشل الاتصال: " + (err.message || "خطأ غير معروف"));
    } finally {
      setSaving(false);
    }
  };

  const connectToRouter = async (router: RouterRow) => {
    setConnecting(router.id);
    try {
      const { data, error } = await supabase.functions.invoke("mikrotik-api", {
        body: {
          endpoint: "/system/identity/print",
          host: router.host, user: router.username, pass: router.password,
          port: router.port, protocol: router.protocol, mode: router.mode,
        },
      });
      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      // Save to localStorage for hooks
      saveMikrotikConfig({
        host: router.host,
        user: router.username,
        pass: router.password,
        port: router.port,
        protocol: router.protocol as ConnectionProtocol,
        mode: router.mode as ConnectionMode,
        label: router.label,
      });

      // Update last connected
      await supabase.from("routers").update({
        is_online: true,
        last_connected_at: new Date().toISOString(),
      }).eq("id", router.id);

      toast.success(`متصل بـ ${router.label}`);
      navigate("/");
    } catch (err: any) {
      toast.error("فشل الاتصال: " + (err.message || "خطأ"));
      await supabase.from("routers").update({ is_online: false }).eq("id", router.id);
    } finally {
      setConnecting(null);
    }
  };

  const deleteRouter = async (id: string) => {
    const { error } = await supabase.from("routers").delete().eq("id", id);
    if (!error) {
      setRouters(r => r.filter(x => x.id !== id));
      toast.success("تم حذف الراوتر");
    }
  };

  const protocolOptions = getProtocolOptions(form.mode);

  return (
    <div className="min-h-screen bg-background" dir="rtl">
      {/* Header */}
      <header className="border-b border-border px-6 py-4 flex items-center justify-between">
        <div className="flex items-center gap-3">
          <div className="p-2 rounded-lg gradient-primary">
            <Router className="h-5 w-5 text-primary-foreground" />
          </div>
          <div>
            <h1 className="font-bold text-foreground text-lg">MikroTik Manager</h1>
            <p className="text-xs text-muted-foreground">{user?.email}</p>
          </div>
        </div>
        <button
          onClick={() => { signOut(); navigate("/auth"); }}
          className="flex items-center gap-2 text-sm text-muted-foreground hover:text-foreground transition-colors"
        >
          <LogOut className="h-4 w-4" />
          خروج
        </button>
      </header>

      <div className="max-w-4xl mx-auto p-6">
        <div className="flex items-center justify-between mb-6">
          <div>
            <h2 className="text-2xl font-bold text-foreground">الراوترات</h2>
            <p className="text-sm text-muted-foreground">اختر راوتر للاتصال أو أضف واحد جديد</p>
          </div>
          <button
            onClick={() => setShowAdd(true)}
            className="gradient-primary text-primary-foreground font-medium py-2.5 px-5 rounded-lg text-sm hover:opacity-90 transition-opacity flex items-center gap-2"
          >
            <Plus className="h-4 w-4" />
            إضافة راوتر
          </button>
        </div>

        {/* Router List */}
        {loading ? (
          <div className="flex items-center justify-center py-20">
            <Loader2 className="h-8 w-8 animate-spin text-primary" />
          </div>
        ) : routers.length === 0 ? (
          <div className="text-center py-20">
            <div className="p-4 rounded-2xl bg-primary/10 inline-block mb-4">
              <Router className="h-12 w-12 text-primary" />
            </div>
            <h3 className="text-xl font-bold text-foreground mb-2">لا توجد راوترات</h3>
            <p className="text-muted-foreground mb-6">أضف أول راوتر مايكروتيك للبدء</p>
            <button
              onClick={() => setShowAdd(true)}
              className="gradient-primary text-primary-foreground font-medium py-3 px-8 rounded-lg text-sm hover:opacity-90 transition-opacity"
            >
              إضافة راوتر
            </button>
          </div>
        ) : (
          <div className="grid gap-4">
            {routers.map((router) => (
              <div
                key={router.id}
                className="gradient-card rounded-xl border border-border shadow-card p-5 hover:border-primary/30 transition-colors"
              >
                <div className="flex items-center justify-between">
                  <div className="flex items-center gap-4">
                    <div className={`p-3 rounded-xl ${router.is_online ? "bg-success/10" : "bg-secondary"}`}>
                      {router.is_online ? (
                        <Wifi className="h-6 w-6 text-success" />
                      ) : (
                        <WifiOff className="h-6 w-6 text-muted-foreground" />
                      )}
                    </div>
                    <div>
                      <h3 className="font-bold text-foreground text-lg">{router.label}</h3>
                      <div className="flex items-center gap-3 text-xs text-muted-foreground mt-1">
                        <span className="font-mono">{router.host}:{router.port}</span>
                        <span>•</span>
                        <span>{router.mode === "rest" ? "REST API" : "MikroTik API"}</span>
                        {router.router_os_version && (
                          <>
                            <span>•</span>
                            <span>{router.router_os_version}</span>
                          </>
                        )}
                      </div>
                    </div>
                  </div>

                  <div className="flex items-center gap-2">
                    <button
                      onClick={() => connectToRouter(router)}
                      disabled={connecting === router.id}
                      className="gradient-primary text-primary-foreground font-medium py-2 px-5 rounded-lg text-sm hover:opacity-90 transition-opacity disabled:opacity-50 flex items-center gap-2"
                    >
                      {connecting === router.id ? (
                        <><Loader2 className="h-4 w-4 animate-spin" />جاري الاتصال</>
                      ) : "اتصال"}
                    </button>
                    <button
                      onClick={() => deleteRouter(router.id)}
                      className="p-2 rounded-lg text-muted-foreground hover:text-destructive hover:bg-destructive/10 transition-colors"
                    >
                      <Trash2 className="h-4 w-4" />
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
        <DialogContent className="max-w-lg" dir="rtl">
          <DialogHeader>
            <DialogTitle className="flex items-center gap-2">
              <Plus className="h-5 w-5 text-primary" />
              إضافة راوتر جديد
            </DialogTitle>
          </DialogHeader>

          <div className="space-y-4 mt-4">
            {/* Mode selection */}
            <div className="grid grid-cols-2 gap-3">
              <button
                onClick={() => handleModeChange("rest")}
                className={`p-3 rounded-lg border text-right transition-all ${
                  form.mode === "rest"
                    ? "border-primary bg-primary/10"
                    : "border-border bg-secondary hover:border-muted-foreground"
                }`}
              >
                <Server className={`h-4 w-4 mb-1 ${form.mode === "rest" ? "text-primary" : "text-muted-foreground"}`} />
                <p className="font-medium text-foreground text-sm">REST API</p>
                <p className="text-xs text-muted-foreground">RouterOS v7.1+</p>
              </button>
              <button
                onClick={() => handleModeChange("api")}
                className={`p-3 rounded-lg border text-right transition-all ${
                  form.mode === "api"
                    ? "border-primary bg-primary/10"
                    : "border-border bg-secondary hover:border-muted-foreground"
                }`}
              >
                <Wifi className={`h-4 w-4 mb-1 ${form.mode === "api" ? "text-primary" : "text-muted-foreground"}`} />
                <p className="font-medium text-foreground text-sm">MikroTik API</p>
                <p className="text-xs text-muted-foreground">RouterOS v6/v7</p>
              </button>
            </div>

            <div>
              <label className="block text-sm font-medium text-foreground mb-1.5">اسم الراوتر (اختياري)</label>
              <input
                type="text"
                value={form.label}
                onChange={(e) => setForm(f => ({ ...f, label: e.target.value }))}
                placeholder="مكتب - راوتر رئيسي"
                className="w-full bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring"
              />
            </div>

            <div>
              <label className="block text-sm font-medium text-foreground mb-1.5">العنوان (IP / Domain / Cloud)</label>
              <div className="flex gap-2">
                <select
                  value={form.protocol}
                  onChange={(e) => {
                    const p = e.target.value as ConnectionProtocol;
                    setForm(f => ({ ...f, protocol: p, port: getDefaultPort(f.mode, p) }));
                  }}
                  className="bg-secondary border border-border rounded-lg px-3 py-2.5 text-sm text-foreground focus:outline-none focus:ring-2 focus:ring-ring"
                >
                  {protocolOptions.map(o => <option key={o.value} value={o.value}>{o.label}</option>)}
                </select>
                <input
                  type="text"
                  value={form.host}
                  onChange={(e) => setForm(f => ({ ...f, host: e.target.value.trim() }))}
                  placeholder="192.168.88.1"
                  className="flex-1 bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring font-mono"
                  dir="ltr"
                />
              </div>
            </div>

            <div className="grid grid-cols-3 gap-3">
              <div>
                <label className="block text-sm font-medium text-foreground mb-1.5">البورت</label>
                <input
                  type="text"
                  value={form.port}
                  onChange={(e) => setForm(f => ({ ...f, port: e.target.value.trim() }))}
                  className="w-full bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring"
                  dir="ltr"
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-foreground mb-1.5">المستخدم</label>
                <input
                  type="text"
                  value={form.username}
                  onChange={(e) => setForm(f => ({ ...f, username: e.target.value }))}
                  className="w-full bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring"
                  dir="ltr"
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-foreground mb-1.5">كلمة المرور</label>
                <input
                  type="password"
                  value={form.password}
                  onChange={(e) => setForm(f => ({ ...f, password: e.target.value }))}
                  className="w-full bg-secondary border border-border rounded-lg px-4 py-2.5 text-sm text-foreground font-mono focus:outline-none focus:ring-2 focus:ring-ring"
                  dir="ltr"
                />
              </div>
            </div>

            <button
              onClick={addRouter}
              disabled={saving || !form.host || !form.username || !form.password}
              className="w-full gradient-primary text-primary-foreground font-medium py-3 rounded-lg text-sm transition-opacity hover:opacity-90 disabled:opacity-50 flex items-center justify-center gap-2"
            >
              {saving ? (
                <><Loader2 className="h-4 w-4 animate-spin" />جاري الاختبار والحفظ...</>
              ) : "🔌 اختبار واتصال وحفظ"}
            </button>
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
