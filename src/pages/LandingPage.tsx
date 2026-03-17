import { Link } from "react-router-dom";
import { Router, Wifi, Users, CreditCard, BarChart3, Shield, ArrowLeft, Zap, CheckCircle2 } from "lucide-react";
import { Button } from "@/components/ui/button";

const features = [
  { icon: Wifi, title: "إدارة الهوتسبوت", desc: "تحكم كامل بمستخدمي الهوتسبوت وإضافة وحذف وتعديل الباقات", color: "primary" },
  { icon: Users, title: "يوزر مانجر", desc: "إدارة مستخدمي يوزر مانجر والجلسات والباقات بكل سهولة", color: "accent" },
  { icon: CreditCard, title: "توليد الكروت", desc: "توليد كروت مخصصة وطباعتها بقوالب احترافية ورفعها للراوتر", color: "primary" },
  { icon: BarChart3, title: "تقارير المبيعات", desc: "تتبع المبيعات والإيرادات مع رسوم بيانية وفلاتر متقدمة", color: "accent" },
  { icon: Shield, title: "نسخ احتياطي", desc: "حفظ واستعادة إعدادات المستخدمين تلقائياً", color: "primary" },
  { icon: Router, title: "أجهزة متعددة", desc: "إدارة أكثر من راوتر مايكروتيك من لوحة تحكم واحدة", color: "accent" },
];

const steps = [
  { num: "١", title: "سجّل حسابك", desc: "أنشئ حسابك وانتظر التفعيل من المدير" },
  { num: "٢", title: "أضف الراوتر", desc: "أدخل بيانات جهاز المايكروتيك الخاص بك" },
  { num: "٣", title: "ابدأ الإدارة", desc: "تحكم بالمستخدمين والكروت والمبيعات من مكان واحد" },
];

const highlights = [
  "واجهة عربية كاملة",
  "دعم الوضع الليلي",
  "متعدد المستخدمين",
  "سريع وآمن",
];

export default function LandingPage() {
  return (
    <div className="min-h-dvh bg-background" dir="rtl">
      {/* Header */}
      <header className="sticky top-0 z-40 glass border-b border-border/70">
        <div className="max-w-5xl mx-auto px-4 py-3 flex items-center justify-between">
          <div className="flex items-center gap-2.5">
            <div className="p-2 rounded-xl gradient-primary shadow-sm">
              <Router className="h-4 w-4 text-primary-foreground" />
            </div>
            <span className="font-bold text-foreground text-sm tracking-tight">MikroTik Manager</span>
          </div>
          <Link to="/auth">
            <Button size="sm" className="gap-1.5 shadow-primary/20 shadow-sm">
              <ArrowLeft className="h-3.5 w-3.5" />
              تسجيل الدخول
            </Button>
          </Link>
        </div>
      </header>

      {/* Hero */}
      <section className="relative py-20 sm:py-28 overflow-hidden">
        {/* Background decoration */}
        <div className="absolute inset-0 pointer-events-none overflow-hidden">
          <div className="absolute -top-24 -right-24 h-96 w-96 rounded-full bg-primary/6 blur-3xl" />
          <div className="absolute -bottom-24 -left-24 h-96 w-96 rounded-full bg-accent/5 blur-3xl" />
        </div>
        <div className="relative max-w-3xl mx-auto px-4 text-center">
          <div className="inline-flex items-center gap-2 bg-primary/8 text-primary border border-primary/20 rounded-full px-4 py-1.5 text-xs font-medium mb-6 animate-fade-in-up">
            <Zap className="h-3 w-3" />
            إدارة ذكية وسريعة للمايكروتيك
          </div>
          <h1 className="text-3xl sm:text-5xl font-extrabold text-foreground tracking-tight leading-[1.15] mb-5 animate-fade-in-up" style={{ animationDelay: "50ms" }}>
            أدر أجهزة المايكروتيك
            <br />
            <span className="text-gradient-primary">بسهولة تامة</span>
          </h1>
          <p className="text-muted-foreground text-base sm:text-lg max-w-xl mx-auto mb-8 leading-relaxed animate-fade-in-up" style={{ animationDelay: "100ms" }}>
            لوحة تحكم متكاملة لإدارة الهوتسبوت واليوزر مانجر وتوليد الكروت وتتبع المبيعات — من أي مكان.
          </p>
          {/* Highlights */}
          <div className="flex flex-wrap items-center justify-center gap-3 mb-8 animate-fade-in-up" style={{ animationDelay: "150ms" }}>
            {highlights.map((h, i) => (
              <span key={i} className="flex items-center gap-1.5 text-xs text-muted-foreground">
                <CheckCircle2 className="h-3.5 w-3.5 text-accent" />
                {h}
              </span>
            ))}
          </div>
          <div className="flex items-center justify-center gap-3 animate-fade-in-up" style={{ animationDelay: "200ms" }}>
            <Link to="/auth">
              <Button size="lg" className="gap-2 text-sm shadow-primary/25 shadow-md px-8">
                ابدأ الآن مجاناً
                <ArrowLeft className="h-4 w-4" />
              </Button>
            </Link>
          </div>
        </div>
      </section>

      {/* Features */}
      <section className="py-16 border-t border-border bg-muted/20">
        <div className="max-w-5xl mx-auto px-4">
          <div className="text-center mb-10">
            <h2 className="text-2xl font-bold text-foreground tracking-tight mb-2">المميزات الأساسية</h2>
            <p className="text-muted-foreground text-sm">كل ما تحتاجه لإدارة شبكتك في مكان واحد</p>
          </div>
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4 stagger-children">
            {features.map((f, i) => (
              <div
                key={i}
                className="group rounded-xl border border-border bg-card p-5 card-hover"
              >
                <div className={`w-10 h-10 rounded-xl flex items-center justify-center mb-4 transition-transform group-hover:scale-110 ${
                  f.color === "primary" ? "gradient-primary" : "gradient-accent"
                }`}>
                  <f.icon className="h-5 w-5 text-white" />
                </div>
                <h3 className="font-semibold text-foreground text-sm mb-1.5 tracking-tight">{f.title}</h3>
                <p className="text-muted-foreground text-xs leading-relaxed">{f.desc}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* How it works */}
      <section className="py-16 border-t border-border">
        <div className="max-w-3xl mx-auto px-4 text-center">
          <h2 className="text-2xl font-bold text-foreground tracking-tight mb-2">كيف تبدأ؟</h2>
          <p className="text-muted-foreground text-sm mb-10">ثلاث خطوات بسيطة للبدء</p>
          <div className="grid grid-cols-1 sm:grid-cols-3 gap-8">
            {steps.map((s, i) => (
              <div key={i} className="flex flex-col items-center gap-3 animate-fade-in-up" style={{ animationDelay: `${i * 100}ms` }}>
                <div className="h-12 w-12 rounded-2xl gradient-primary flex items-center justify-center text-primary-foreground font-bold text-lg shadow-primary/20 shadow-md">
                  {s.num}
                </div>
                <h3 className="font-semibold text-foreground text-sm tracking-tight">{s.title}</h3>
                <p className="text-muted-foreground text-xs leading-relaxed max-w-[180px]">{s.desc}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* CTA */}
      <section className="py-14 border-t border-border bg-muted/20">
        <div className="max-w-xl mx-auto px-4 text-center">
          <h2 className="text-xl font-bold text-foreground mb-3 tracking-tight">جاهز للبدء؟</h2>
          <p className="text-muted-foreground text-sm mb-6">انضم الآن وابدأ إدارة شبكتك بطريقة أسهل</p>
          <Link to="/auth">
            <Button size="lg" className="gap-2 shadow-primary/20 shadow-md px-8">
              إنشاء حساب
              <ArrowLeft className="h-4 w-4" />
            </Button>
          </Link>
        </div>
      </section>

      {/* Footer */}
      <footer className="border-t border-border py-6">
        <div className="max-w-5xl mx-auto px-4 flex items-center justify-between gap-4 flex-wrap">
          <div className="flex items-center gap-2">
            <div className="p-1.5 rounded-lg gradient-primary">
              <Router className="h-3 w-3 text-primary-foreground" />
            </div>
            <span className="text-xs font-semibold text-foreground">MikroTik Manager</span>
          </div>
          <p className="text-xs text-muted-foreground">© {new Date().getFullYear()} — جميع الحقوق محفوظة</p>
        </div>
      </footer>
    </div>
  );
}
