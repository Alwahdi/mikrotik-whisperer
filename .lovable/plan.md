

# خطة التنفيذ

## المشاكل المكتشفة

### 1. لا توجد Triggers في قاعدة البيانات
الدوال `auto_assign_role` و `handle_new_user` و `handle_new_user_access` موجودة لكن **لا يوجد أي trigger مربوط بها**. لهذا السبب:
- حساب `abdullahalwahdi@icloud.com` ليس له دور (لا admin ولا cashier)
- لا يوجد سجل وصول (user_access) مربوط بأي مستخدم بشكل تلقائي

### 2. حذف الدفعة من الراوتر يفشل (REST mode)
في REST API الخاص بـ MikroTik، أمر `DELETE` يتطلب `.id` في **مسار URL** (مثل `/rest/ip/hotspot/user/*1A`) وليس في body JSON. الكود الحالي في `handleRest` يزيل `/remove` من المسار لكن لا يضيف `.id` للـ URL.

### 3. النسخ الاحتياطي والاستعادة
الكود يعمل من حيث المبدأ لكن يحتاج تحسينات:
- إضافة progress أثناء الاستعادة
- تقرير أوضح بعد الاستعادة
- مقارنة النسخ (عدد المستخدمين الحاليين vs النسخة)

---

## خطة التنفيذ

### 1. إصلاح قاعدة البيانات (Migration)
```sql
-- إنشاء Triggers المفقودة
CREATE TRIGGER on_auth_user_created
  AFTER INSERT ON auth.users
  FOR EACH ROW EXECUTE FUNCTION public.handle_new_user();

CREATE TRIGGER on_profile_created_assign_role
  AFTER INSERT ON public.profiles
  FOR EACH ROW EXECUTE FUNCTION public.auto_assign_role();

CREATE TRIGGER on_profile_created_access
  AFTER INSERT ON public.profiles
  FOR EACH ROW EXECUTE FUNCTION public.handle_new_user_access();

-- تعيين abdullahalwahdi@icloud.com كـ admin
INSERT INTO public.user_roles (user_id, role)
VALUES ('13903faa-fc64-4242-a1de-f6ddb1fc99fc', 'admin')
ON CONFLICT (user_id, role) DO NOTHING;

-- تعيين الحساب الآخر كـ cashier
INSERT INTO public.user_roles (user_id, role)
VALUES ('629639db-c7d5-424e-80fc-8a0acc765f35', 'cashier')
ON CONFLICT (user_id, role) DO NOTHING;

-- ضمان وجود سجلات وصول
INSERT INTO public.user_access (user_id, status)
VALUES ('13903faa-fc64-4242-a1de-f6ddb1fc99fc', 'active'),
       ('629639db-c7d5-424e-80fc-8a0acc765f35', 'active')
ON CONFLICT (user_id) DO NOTHING;
```

### 2. إصلاح حذف الدفعة من الراوتر
**ملف:** `supabase/functions/mikrotik-api/index.ts`

تعديل دالة `handleRest` لتدعم DELETE مع `.id` في URL:
- عند method = DELETE وفي الـ body يوجد `.id`، يتم إضافته للـ URL path بدلاً من إرساله في body
- مثال: `/rest/ip/hotspot/user/*1A` بدل `/rest/ip/hotspot/user` + body `{".id":"*1A"}`

### 3. تحسين صفحة النسخ الاحتياطي
**ملف:** `src/pages/BackupsPage.tsx`
- إضافة مقارنة سريعة: عدد المستخدمين الحاليين vs النسخة الاحتياطية
- شريط تقدم أثناء الاستعادة (progress)
- خيار "استعادة انتقائية" (فقط يوزر مانجر / فقط هوتسبوت)
- عرض تفاصيل النسخة بشكل أوضح (أسماء الباقات المحفوظة)
- تقرير نتائج الاستعادة مفصل

### 4. تقارير مفيدة في الداشبورد
**ملف:** `src/pages/Index.tsx`
إضافة بطاقات إحصائية جديدة:
- إجمالي المبيعات اليوم (من جدول sales)
- عدد الكروت المضافة اليوم
- أفضل باقة مبيعاً
- رابط سريع لصفحة المبيعات

### 5. تحسين صفحة المبيعات
**ملف:** `src/pages/SalesPage.tsx`
- إضافة إحصائية "أفضل نقطة بيع" 
- تصدير المبيعات كـ CSV
- ملخص شهري مقارن

### الملفات المتأثرة
1. Migration SQL (triggers + roles + access)
2. `supabase/functions/mikrotik-api/index.ts` — إصلاح DELETE REST
3. `src/pages/BackupsPage.tsx` — تحسينات الباك اب
4. `src/pages/Index.tsx` — إحصائيات المبيعات
5. `src/pages/SalesPage.tsx` — تقارير محسنة

