# خطة التطوير الشاملة - MikroTik Manager Pro

## الوضع الحالي

التطبيق يعمل بشكل أساسي مع: تسجيل دخول، إدارة راوترات، هوتسبوت، يوزر مانجر، كروت، إعدادات. لكن هناك مشاكل في الأداء والتكامل والتصميم تحتاج حل جذري.

## المشاكل المكتشفة

1. **Edge Function**: الاتصال بالـ API يعمل لكن v6 fallback يحتاج تحسين - كل طلب ينشئ اتصال TCP جديد (بطيء)
2. **الكروت**: إضافة الكروت للراوتر تتم واحد واحد (sequential) - بطيء جداً مع 100+ كرت
3. **User Manager**: قراءة المستخدمين والجلسات تعمل لكن بدون caching ذكي
4. **UI**: التصميم جيد لكن ينقصه مكونات متقدمة (Quick Actions, Real-time monitors)
5. **لا يوجد نظام نسخ احتياطي**
6. **لا يوجد نظام صلاحيات** (Admin / Cashier)

---

## الخطة المقسمة على مراحل

### المرحلة 1: محرك الاتصال المحسّن (Core Engine)

**Edge Function (`mikrotik-api/index.ts`)**:

- إضافة `batch` action يقبل مصفوفة أوامر وينفذها عبر اتصال TCP واحد (بدل فتح اتصال لكل كرت)
- تحسين timeout handling مع أخطاء واضحة
- إضافة `health-check` action سريع للتأكد من حالة الراوتر
- تحسين v6/v7 detection: تخزين الإصدار مع أول اتصال وإعادة استخدامه

`**useMikrotik.ts**`:

- إضافة `useBatchAction` hook للعمليات الجماعية (إضافة 100 كرت بضغطة واحدة)
- تحسين `staleTime` و `cacheTime` لمنع الطلبات المتكررة
- إضافة `useRouterHealth` hook للمراقبة اللحظية

### المرحلة 2: Dashboard ذكي وسلس

`**Index.tsx` - إعادة بناء كاملة**:

- Quick Actions bar (أزرار سريعة: إضافة مستخدم، توليد كروت، فصل الكل)
- إحصائيات لحظية مع أنيميشن للأرقام
- تقسيم واضح: Overview → Users → Traffic → Alerts
- عرض آخر العمليات (Activity Log)
- تنبيهات ذكية (CPU عالي، ذاكرة ممتلئة، كروت منتهية)

### المرحلة 3: User Manager + Hotspot محسّن

`**UserManagerPage.tsx**`:

- إصلاح تعليق الصفحة: استخدام `Suspense` و lazy loading للجداول
- فلترة متقدمة: حسب الحالة (نشط/معطل/منتهي)، الباقة، تاريخ الإنشاء
- عرض إحصائيات كل مستخدم (الاستهلاك، الجلسات، آخر اتصال)
- تعديل الباقات مباشرة من الواجهة
- عداد الكروت المنتهية والجلسات المنتهية

`**HotspotPage.tsx**`:

- نفس التحسينات + عرض bandwidth لكل مستخدم نشط
- Bulk actions (تعطيل/حذف متعدد)

### المرحلة 4: نظام الكروت الاحترافي

`**VouchersPage.tsx` - إعادة بناء**:

- Bulk generation عبر `batch` API (1000 كرت بضغطة واحدة)
- قوالب جاهزة (3-4 تصاميم احترافية)
- تخصيص كامل: شعار، اسم الشبكة، السعر، السرعة، QR Code
- Preview حي مع drag & drop لتحريك العناصر
- تحكم كامل بالطباعة: أعمدة، صفوف، هوامش، حجم الكرت
- تصدير PDF

### المرحلة 5: النسخ الاحتياطي

**Database**: جدول `backups` لتخزين metadata
**Storage**: bucket `router-backups` لحفظ ملفات النسخ
**Edge Function** جديدة `backup-scheduler`:

- نسخ احتياطي لبيانات User Manager و Hotspot users
- جدولة يومية عبر `pg_cron`
- استعادة النسخة بضغطة زر

### المرحلة 6: UI/UX النهائي

**التصميم**:

- تحسين الثيم الحالي (warm neutrals) مع micro-interactions
- أنيميشن ناعمة للانتقالات والتحميل
- Optimistic UI: التحديث الفوري قبل استجابة السيرفر
- Empty states جذابة مع illustrations
- Loading skeletons محسّنة
- شعار MikroTik في الـ sidebar والـ login

**Navigation**:

- Sidebar محسّن مع badges (عدد المتصلين، تنبيهات)
- Mobile-first: bottom navigation للجوال
- Keyboard shortcuts للعمليات السريعة

---

## التفاصيل التقنية

### Batch API (الأهم للأداء)

```
// بدل 100 طلب منفصل، طلب واحد:
POST mikrotik-api { action: "batch", commands: [...] }
// ينفذ كل الأوامر عبر اتصال TCP واحد
```

### Database Changes

```sql
-- جدول النسخ الاحتياطية
CREATE TABLE backups (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id uuid NOT NULL,
  router_id uuid REFERENCES routers(id),
  backup_type text NOT NULL, -- 'users' | 'full'
  file_path text,
  created_at timestamptz DEFAULT now()
);

-- Storage bucket
INSERT INTO storage.buckets (id, name, public) 
VALUES ('router-backups', 'router-backups', false);
```

### الملفات التي ستتأثر


| الملف                                          | نوع التغيير                      |
| ---------------------------------------------- | -------------------------------- |
| `supabase/functions/mikrotik-api/index.ts`     | تحديث كبير (batch, health-check) |
| `src/hooks/useMikrotik.ts`                     | إضافة hooks جديدة                |
| `src/pages/Index.tsx`                          | إعادة بناء كاملة                 |
| `src/pages/UserManagerPage.tsx`                | تحسين كبير                       |
| `src/pages/HotspotPage.tsx`                    | تحسين كبير                       |
| `src/pages/VouchersPage.tsx`                   | إعادة بناء كاملة                 |
| `src/components/DashboardLayout.tsx`           | تحسين الـ sidebar                |
| `src/index.css`                                | micro-interactions               |
| `supabase/functions/backup-scheduler/index.ts` | ملف جديد                         |
| `src/pages/BackupsPage.tsx`                    | صفحة جديدة                       |


### الأولوية المقترحة

بسبب حجم التغييرات الكبير، أقترح التنفيذ على **3 دفعات**:

**الدفعة 1** (الأهم): محرك الاتصال + Dashboard + تحسين User Manager + Hotspot
**الدفعة 2**: نظام الكروت الاحترافي + النسخ الاحتياطي  
**الدفعة 3**: UI/UX النهائي + الصلاحيات + التنبيهات

هل تريد البدء بالدفعة الأولى؟  اوك تمام بس زيد شوف لي موضوع اضافة الكروت عند تبويب اليوزر مانجر وايضا عند تبويب  طباعة الكروت يطلع unkown parameter