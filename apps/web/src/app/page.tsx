import Link from "next/link";
import { Router, Wifi, Users, CreditCard, BarChart3, Shield, ArrowLeft } from "lucide-react";
import { Button } from "@repo/design-system/components/ui/button";

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

const APP_URL = process.env.NEXT_PUBLIC_APP_URL ?? "http://localhost:3000";

export default function LandingPage() {
  return (
    <div className="min-h-dvh bg-background" dir="rtl">
      <header className="border-b border-border">
        <div className="max-w-5xl mx-auto px-4 py-3 flex items-center justify-between">
          <div className="flex items-center gap-2.5">
            <div className="p-1.5 rounded-md gradient-primary">
              <Router className="h-4 w-4 text-primary-foreground" />
            </div>
            <span className="font-bold text-foreground text-sm">MikroTik Manager</span>
          </div>
          <Link href={`${APP_URL}/auth`}>
            <Button size="sm" className="gap-1.5">
              <ArrowLeft className="h-3.5 w-3.5" />
              تسجيل الدخول
            </Button>
          </Link>
        </div>
      </header>

      <main className="max-w-5xl mx-auto px-4 py-16">
        <div className="text-center mb-16">
          <h1 className="text-3xl md:text-4xl font-bold mb-4 text-foreground">
            إدارة أجهزة المايكروتيك بكل سهولة
          </h1>
          <p className="text-muted-foreground text-lg max-w-2xl mx-auto">
            لوحة تحكم متكاملة لإدارة الهوتسبوت ويوزر مانجر والكروت والمبيعات
          </p>
        </div>

        <div className="grid md:grid-cols-3 gap-6 mb-20">
          {features.map((f) => (
            <div key={f.title} className="rounded-lg border border-border bg-card p-6">
              <f.icon className="h-8 w-8 text-primary mb-3" />
              <h3 className="font-semibold mb-1 text-foreground">{f.title}</h3>
              <p className="text-sm text-muted-foreground">{f.desc}</p>
            </div>
          ))}
        </div>

        <div className="text-center mb-10">
          <h2 className="text-2xl font-bold text-foreground mb-8">كيف تبدأ؟</h2>
          <div className="flex flex-col md:flex-row gap-8 justify-center">
            {steps.map((s) => (
              <div key={s.num} className="flex-1 max-w-xs mx-auto">
                <div className="w-10 h-10 rounded-full bg-primary text-primary-foreground flex items-center justify-center font-bold text-lg mx-auto mb-3">
                  {s.num}
                </div>
                <h3 className="font-semibold mb-1 text-foreground">{s.title}</h3>
                <p className="text-sm text-muted-foreground">{s.desc}</p>
              </div>
            ))}
          </div>
        </div>
      </main>
    </div>
  );
}
