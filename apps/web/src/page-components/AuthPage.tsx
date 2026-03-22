"use client";

import { useState } from "react";
import { useAuth } from "@/contexts/AuthContext";
import { useRouter } from "next/navigation";
import { Router, Mail, Lock, User, Loader2, Eye, EyeOff } from "lucide-react";
import { toast } from "sonner";

export default function AuthPage() {
  const { signIn, signUp } = useAuth();
  const router = useRouter();
  const [isLogin, setIsLogin] = useState(true);
  const [loading, setLoading] = useState(false);
  const [showPass, setShowPass] = useState(false);
  const [form, setForm] = useState({ email: "", password: "", fullName: "" });

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!form.email || !form.password) {
      toast.error("يرجى تعبئة جميع الحقول");
      return;
    }
    if (!isLogin && !form.fullName) {
      toast.error("يرجى إدخال الاسم");
      return;
    }
    setLoading(true);
    try {
      if (isLogin) {
        await signIn(form.email, form.password);
        toast.success("مرحباً بك!");
      } else {
        await signUp(form.email, form.password, form.fullName);
        toast.success("تم إنشاء الحساب بنجاح!");
      }
      router.push("/routers");
    } catch (err: any) {
      toast.error(err.message || "حدث خطأ");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen bg-background flex items-center justify-center p-4" dir="rtl">
      <div className="w-full max-w-sm">
        {/* Logo */}
        <div className="text-center mb-8">
          <div className="inline-flex p-3 rounded-xl gradient-primary mb-4">
            <Router className="h-7 w-7 text-primary-foreground" />
          </div>
          <h1 className="text-xl font-bold text-foreground">MikroTik Manager</h1>
          <p className="text-muted-foreground text-xs mt-1.5">إدارة أجهزة المايكروتيك بسهولة</p>
        </div>

        {/* Form Card */}
        <div className="rounded-xl border border-border bg-card shadow-card p-6">
          {/* Toggle */}
          <div className="flex rounded-lg bg-muted p-0.5 mb-6">
            <button
              type="button"
              onClick={() => setIsLogin(true)}
              className={`flex-1 py-2 rounded-md text-sm font-medium transition-all ${
                isLogin ? "bg-primary text-primary-foreground" : "text-muted-foreground hover:text-foreground"
              }`}
            >
              تسجيل الدخول
            </button>
            <button
              type="button"
              onClick={() => setIsLogin(false)}
              className={`flex-1 py-2 rounded-md text-sm font-medium transition-all ${
                !isLogin ? "bg-primary text-primary-foreground" : "text-muted-foreground hover:text-foreground"
              }`}
            >
              حساب جديد
            </button>
          </div>

          <form onSubmit={handleSubmit} className="space-y-4">
            {!isLogin && (
              <div>
                <label className="block text-xs font-medium text-foreground mb-1.5">الاسم الكامل</label>
                <div className="relative">
                  <User className="absolute right-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground" />
                  <input
                    type="text"
                    value={form.fullName}
                    onChange={(e) => setForm(f => ({ ...f, fullName: e.target.value }))}
                    placeholder="الاسم الكامل"
                    className="w-full bg-muted border border-border rounded-lg pr-10 pl-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring transition-shadow"
                  />
                </div>
              </div>
            )}

            <div>
              <label className="block text-xs font-medium text-foreground mb-1.5">البريد الإلكتروني</label>
              <div className="relative">
                <Mail className="absolute right-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground" />
                <input
                  type="email"
                  value={form.email}
                  onChange={(e) => setForm(f => ({ ...f, email: e.target.value }))}
                  placeholder="email@example.com"
                  className="w-full bg-muted border border-border rounded-lg pr-10 pl-4 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring transition-shadow"
                  dir="ltr"
                />
              </div>
            </div>

            <div>
              <label className="block text-xs font-medium text-foreground mb-1.5">كلمة المرور</label>
              <div className="relative">
                <Lock className="absolute right-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground" />
                <input
                  type={showPass ? "text" : "password"}
                  value={form.password}
                  onChange={(e) => setForm(f => ({ ...f, password: e.target.value }))}
                  placeholder="••••••••"
                  className="w-full bg-muted border border-border rounded-lg pr-10 pl-10 py-2.5 text-sm text-foreground placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring transition-shadow"
                  dir="ltr"
                />
                <button
                  type="button"
                  onClick={() => setShowPass(!showPass)}
                  className="absolute left-3 top-1/2 -translate-y-1/2 text-muted-foreground hover:text-foreground transition-colors"
                >
                  {showPass ? <EyeOff className="h-4 w-4" /> : <Eye className="h-4 w-4" />}
                </button>
              </div>
            </div>

            <button
              type="submit"
              disabled={loading}
              className="w-full gradient-primary text-primary-foreground font-medium py-2.5 rounded-lg text-sm transition-all hover:opacity-90 disabled:opacity-50 flex items-center justify-center gap-2"
            >
              {loading ? (
                <><Loader2 className="h-4 w-4 animate-spin" />جاري المعالجة...</>
              ) : isLogin ? "تسجيل الدخول" : "إنشاء حساب"}
            </button>
          </form>
        </div>

        <p className="text-center text-[10px] text-muted-foreground mt-6">
          يدعم RouterOS v6 و v7+ • REST API و MikroTik API
        </p>
      </div>
    </div>
  );
}
