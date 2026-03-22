"use client";

import Link from "next/link";
import { Router, Wifi, Users, CreditCard, BarChart3, Shield, ArrowLeft } from "lucide-react";
import { Button } from "@/components/ui/button";

const features = [
  { icon: Wifi, title: "إدارة الهوتسبوت", desc: "تحكم كامل بمستخدمي الهوتسبوت وإضافة وحذف وتعديل الباقات" },
  { icon: Users, title: "يوزر مانجر", desc: "إدارة مستخدمي يوزر مانجر والجلسات والباقات بكل سهولة" },
  { icon: CreditCard, title: "توليد الكروت", desc: "توليد كروت مخصصة وطباعتها بقوالب احترافية ورفعها للراوتر" },
  { icon: BarChart3, title: "تقارير المبيعات", desc: "تتبع المبيعات والإيرادات مع رسوم بيانية وفلاتر متقدمة" },
  { icon: Shield, title: "نسخ احتياطي", desc: "حفظ واستعادة إعدادات المستخدمين تلقائياً" },
  { icon: Router, title: "أجهزة متعددة", desc: "إدارة أكثر من راوتر مايكروتيك من لوحة تحكم واحدة" },
];

const steps = [
  { num: "1", title: "سجّل حسابك", desc: "أنشئ حسابك وانتظر التفعيل من المدير" },
  { num: "2", title: "أضف الراوتر", desc: "أدخل بيانات جهاز المايكروتيك الخاص بك" },
  { num: "3", title: "ابدأ الإدارة", desc: "تحكم بالمستخدمين والكروت والمبيعات من مكان واحد" },
];

export default function LandingPage() {
  return (
    <div className="min-h-dvh bg-background" dir="rtl">
      {/* Header */}
      <header className="border-b border-border">
        <div className="max-w-5xl mx-auto px-4 py-3 flex items-center justify-between">
          <div className="flex items-center gap-2.5">
            <div className="p-1.5 rounded-md gradient-primary">
              <Router className="h-4 w-4 text-primary-foreground" />
            </div>
            <span className="font-bold text-foreground text-sm">MikroTik Manager</span>
          </div>
          <Link href="/auth">
            <Button size="sm" className="gap-1.5">
              <ArrowLeft className="h-3.5 w-3.5" />
              تسجيل الدخول
            </Button>
          </Link>
        </div>
      </header>

      {/* Hero */}
      <section className="py-16 sm:py-24">
        <div className="max-w-3xl mx-auto px-4 text-center">
          <h1 className="text-3xl sm:text-4xl font-extrabold text-foreground tracking-tight leading-tight mb-4">
            أدر أجهزة المايكروتيك
            <br />
            <span className="text-primary">بسهولة تامة</span>
          </h1>
          <p className="text-muted-foreground text-base sm:text-lg max-w-xl mx-auto mb-8 leading-relaxed">
            لوحة تحكم متكاملة لإدارة الهوتسبوت واليوزر مانجر وتوليد الكروت وتتبع المبيعات — من أي مكان.
          </p>
          <div className="flex items-center justify-center gap-3">
            <Link href="/auth">
              <Button size="lg" className="gap-2 text-sm">
                ابدأ الآن
                <ArrowLeft className="h-4 w-4" />
              </Button>
            </Link>
          </div>
        </div>
      </section>

      {/* Features */}
      <section className="py-12 border-t border-border bg-muted/30">
        <div className="max-w-5xl mx-auto px-4">
          <h2 className="text-xl font-bold text-foreground text-center mb-8">المميزات الأساسية</h2>
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
            {features.map((f, i) => (
              <div key={i} className="rounded-lg border border-border bg-card p-5 hover:shadow-md transition-shadow">
                <f.icon className="h-5 w-5 text-primary mb-3" />
                <h3 className="font-semibold text-foreground text-sm mb-1">{f.title}</h3>
                <p className="text-muted-foreground text-xs leading-relaxed">{f.desc}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* How it works */}
      <section className="py-12 border-t border-border">
        <div className="max-w-3xl mx-auto px-4 text-center">
          <h2 className="text-xl font-bold text-foreground mb-8">كيف تبدأ؟</h2>
          <div className="grid grid-cols-1 sm:grid-cols-3 gap-6">
            {steps.map((s, i) => (
              <div key={i} className="flex flex-col items-center gap-2">
                <div className="h-10 w-10 rounded-full gradient-primary flex items-center justify-center text-primary-foreground font-bold text-sm">
                  {s.num}
                </div>
                <h3 className="font-semibold text-foreground text-sm">{s.title}</h3>
                <p className="text-muted-foreground text-xs">{s.desc}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="border-t border-border py-6 text-center">
        <p className="text-xs text-muted-foreground">© {new Date().getFullYear()} MikroTik Manager — جميع الحقوق محفوظة</p>
      </footer>
    </div>
  );
}
