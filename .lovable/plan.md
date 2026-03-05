

# خطة التحسين الشاملة

## المشاكل الحالية المطلوب إصلاحها

1. **حذف الدفعة من الراوتر في السجل لا يعمل** - الدالة `deleteBatchFromRouter` تستخدم `print` + `remove` بشكل متسلسل لكن الـ REST API يحتاج معالجة مختلفة للبحث عن المستخدمين
2. **المبيعات تسجل فقط عند push الكروت** - المطلوب تسجيل تلقائي عند أول جلسة (first session) لكل كرت
3. **نقاط البيع غير موجودة** - لا يوجد حقل `sales_point` في نظام الكروت أو المبيعات

## الخطة التفصيلية

### 1. إصلاح حذف الدفعة من الراوتر
- تعديل `deleteBatchFromRouter` لاستخدام batch commands بدل طلب واحد لكل كرت
- استخدام concurrency pool (مثل push) للتسريع
- إضافة شريط تقدم أثناء الحذف

### 2. نظام نقاط البيع (Sales Points)
- إضافة عمود `sales_point` لجدول `sales` في قاعدة البيانات
- إضافة حقل اختيار نقطة البيع عند توليد/طباعة الكروت في `VouchersPage`
- إدارة نقاط البيع (إضافة/حذف) في الإعدادات أو حفظها في localStorage
- فلترة المبيعات حسب نقطة البيع في `SalesPage`

### 3. تحسين صفحة المبيعات
- إضافة رسم بياني للمبيعات اليومية باستخدام Recharts
- فلترة حسب نقطة البيع
- إحصائيات أكثر تفصيلاً (أفضل نقطة بيع، أفضل باقة)
- تسجيل المبيعات تلقائياً عند أول جلسة: سنضيف Edge Function تتحقق دورياً من الجلسات الجديدة (أو نربطها بزر "تحديث المبيعات" يدوي يقارن الجلسات الحالية بالكروت المضافة)

### 4. تجديد نظام التصميم (Vercel-style)
- **الخط**: تغيير من Cairo إلى `Inter` (الخط الأساسي لـ Vercel) مع الحفاظ على Cairo كـ fallback للعربية
- **الألوان**: تطبيق نظام Vercel الأبيض والأسود النظيف:
  - Light: background `#FFFFFF`, foreground `#000000`, border `#EAEAEA`, muted `#666666`
  - Dark: background `#000000`, foreground `#EDEDED`, border `#333333`
  - Primary يبقى `#2563EB`، Accent يبقى `#10B981`
- **Radius**: تقليل إلى `6px` (أنظف مثل Vercel)
- **Shadows**: خفيفة جداً مثل Vercel: `0 1px 2px rgba(0,0,0,0.04)`
- **Spacing**: نظام 8px grid
- **الحركة**: سريعة وخفيفة (150ms-250ms)

### 5. تحسين طباعة الكروت
- تحسين مصمم القوالب: إضافة حقل "السعر" كحقل قابل للسحب
- تحسين touch support للسحب والإفلات على الجوال
- حفظ القوالب مرتبطة بالباقة تلقائياً
- معاينة أفضل مع zoom

## التغييرات التقنية

### Database Migration
```sql
ALTER TABLE public.sales ADD COLUMN IF NOT EXISTS sales_point text DEFAULT '';
```

### الملفات المتأثرة
1. **`src/index.css`** - تجديد Design Tokens بالكامل (Vercel-style)
2. **`tailwind.config.ts`** - تحديث الخطوط والـ radius
3. **`src/pages/VouchersPage.tsx`** - إضافة حقل نقطة البيع، إصلاح حذف الدفعة، تحسين القوالب
4. **`src/pages/SalesPage.tsx`** - إعادة بناء بالكامل مع رسم بياني وفلترة نقاط البيع
5. **`src/components/DashboardLayout.tsx`** - تحسين التصميم Vercel-style
6. **`src/integrations/supabase/types.ts`** - سيتحدث تلقائياً بعد migration
7. **`index.html`** - إضافة خط Inter من Google Fonts

