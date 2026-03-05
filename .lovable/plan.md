
## الأهداف (حسب طلبك)
1) إصلاح نهائي لمشكلة **حذف الدفعة من الراوتر من داخل السجل** (الزر يعطي “فشل الحذف”).  
2) عمل **Landing Page محترمة** (تعريف + زر تسجيل دخول) وتصبح هي الصفحة العامة الافتراضية.  
3) **تحسين ترتيب وتجربة الموبايل** (خصوصًا صفحات: السجل/الكروت/المبيعات + الجداول).  
4) **إرجاع الألوان الأولى** (Primary/Background/Card/Text/Border/Accent مثل ما أعطيتنا سابقًا).  
5) تجهيز **Admin Panel** لإدارة مستخدمي المنصة باشتراكات “موافقة يدوية + مدة اشتراك” + “منع دخول كامل عند الانتهاء”.

---

## 1) إصلاح “حذف الدفعة من الراوتر” في السجل (Root cause + الحل)
### المشكلة المحتملة الآن
المنطق الحالي في `VouchersPage.tsx` يحاول لكل كرت:
- يعمل `print` مع فلتر args (`=?username=...`) ثم يقرأ أول نتيجة ويعمل `remove`.
هذا الأسلوب:
- بطيء جدًا على دفعات كبيرة.
- قابل للفشل لأن صيغة الفلترة تختلف بين المسارات/الإصدارات، وأحيانًا لا ترجع نتائج.

### الحل الأفضل (سريع + ثابت)
تغيير حذف الدفعة ليكون “Map ثم حذف جماعي”:
1. **طلب واحد فقط** لجلب كل المستخدمين من الراوتر (حسب النوع):
   - Hotspot: `/ip/hotspot/user/print`
   - User Manager: `/user-manager/user/print` (ومع طبقة التوافق الموجودة أصلًا لو احتجنا)
2. بناء **خريطة** `username -> .id` محليًا.
3. توليد أوامر حذف جماعية `remove` لكل الكروت التابعة للدفعة التي لها `.id`.
4. إرسال أوامر الحذف عبر `batch` على **دفعات (chunks)** (مثل 25–75 أمر في كل batch) لسرعة أعلى + تقليل فشل الشبكة.
5. تحسين الـ UI:
   - Progress bar فعلي مبني على عدد الأوامر المنفذة.
   - تقرير نهائي: deleted / not-found / failed مع خيار “إعادة محاولة للفاشل فقط”.

**ملفات سيتم تعديلها**
- `src/pages/VouchersPage.tsx` (منطق الحذف + تقدم الحذف + رسائل الخطأ)

---

## 2) إرجاع “الألوان الأولى” (Design Tokens)
سنرجّع الـ tokens الأساسية إلى نظامك السابق (مع الحفاظ على البنية الحالية):
- Primary: `#2563EB` + Hover `#1D4ED8`
- Background: `#F9FAFB`
- Surface/Cards: `#FFFFFF`
- Text Primary: `#111827`
- Text Secondary: `#6B7280`
- Border: `#E5E7EB`
- Accent/Success: `#10B981`

**تنفيذ**
- تحديث `src/index.css` (متغيرات `--background --foreground --muted-foreground --border ...` إلخ)
- ضبط ألوان الـ sidebar tokens لتتماشى
- التأكد أن الـ dark mode ما ينكسر (نخليه قريب من السابق/متوازن)

**ملفات**
- `src/index.css` (أساسي)
- (اختياري) `tailwind.config.ts` فقط إذا احتجنا تعديل mapping أو radius

---

## 3) Landing Page (تعريف + تسجيل دخول) + إعادة تنظيم الراوتات
### المطلوب
أنت اخترت: **“تعريف + تسجيل دخول”**، وبالتالي:
- الصفحة العامة الافتراضية للزائر/غير المسجل تكون Landing.
- بعد تسجيل الدخول يذهب لتدفق اختيار الراوتر ثم لوحة التحكم.

### التعديل المعماري المقترح (بدون كسر التطبيق)
1. إنشاء صفحة جديدة: `src/pages/LandingPage.tsx`
   - Hero بسيط (اسم المنتج + وصف + زر “تسجيل الدخول”)
   - قسم “المميزات الأساسية” (كروت، UM/Hotspot، تقارير…)
   - قسم “كيف تبدأ” (3 خطوات)
   - زر CTA واضح “تسجيل الدخول”
2. تغيير الراوتات في `src/App.tsx`:
   - `/` => LandingPage (Public)
   - نقل لوحة التحكم الحالية `Index.tsx` إلى `/dashboard` (Protected)
3. تحديث كل الروابط التي كانت تذهب لـ`/` على أنها “Home” لتصبح `/dashboard`:
   - Breadcrumbs في: `VouchersPage`, `SalesPage`, `UserManagerPage`, `HotspotPage`…
   - `DashboardLayout` nav item لوحة التحكم
   - `RoutersPage` بعد الاتصال بالراوتر (الآن يوجّه `/`، سنحوّله `/dashboard`)

**ملفات**
- `src/pages/LandingPage.tsx` (جديد)
- `src/App.tsx`
- `src/components/DashboardLayout.tsx`
- صفحات متعددة لتحديث Breadcrumb links

---

## 4) Admin Panel: موافقة يدوية + اشتراك + منع دخول كامل
أنت اخترت:
- “موافقة يدوية + مدة اشتراك”
- “منع دخول كامل”

### قاعدة البيانات (Lovable Cloud)
سنضيف نظام اشتراكات/صلاحية منفصل عن profiles و user_roles (آمن + قابل للتوسع):

**جداول/Enums**
1. Enum `public.access_status`: `pending | active | suspended | expired`
2. جدول `public.user_access`:
   - `user_id uuid primary key` (يرتبط بالمستخدم)
   - `status access_status not null default 'pending'`
   - `starts_at timestamptz`
   - `expires_at timestamptz`
   - `approved_at timestamptz`
   - `approved_by uuid` (اختياري)
   - `notes text default ''`
   - `created_at timestamptz default now()`

**Triggers**
- Trigger بعد إنشاء profile (أو بعد signup) يقوم تلقائيًا بإنشاء سجل `user_access` بحالة `pending`.
- (موجود عندكم) auto_assign_role يبقى كما هو.

**RLS Policies (مهمة جدًا)**
- المستخدم يرى سجل وصوله فقط (select على `user_access` حيث `auth.uid() = user_id`)
- الأدمن يستطيع select/insert/update/delete للجميع باستخدام `public.has_role(auth.uid(),'admin')`
- إضافة policy على `profiles` تسمح للأدمن بقراءة كل profiles (حاليًا الأدمن ممنوع بسبب RLS)

**دوال للتحقق**
- `public.is_access_allowed(_user_id uuid)` (SECURITY DEFINER):
  - ترجع `true` لو المستخدم admin
  - أو لو status = active و (expires_at is null أو expires_at > now())
  - غير ذلك false

### تطبيق المنع فعليًا
1) **على الواجهة (Client)**
- تعديل `ProtectedRoute.tsx` ليضيف شرط:
  - لو user موجود لكن access = pending/suspended/expired => redirect إلى صفحة عامة `/access` تشرح الحالة وزر “تواصل مع الأدمن”.
- إنشاء صفحة `src/pages/AccessGatePage.tsx` (Public) تعرض:
  - “حسابك قيد المراجعة” أو “انتهى اشتراكك” أو “موقوف”
  - معلومات بسيطة + طريقة التواصل

2) **على البيانات (Server-side)**
- (اختياري لكن أقوى) تعديل RLS لجدول `routers/sales/backups` ليشترط `public.is_access_allowed(auth.uid())` في SELECT/INSERT/UPDATE/DELETE.
  - هذا يمنع أي تحايل من طرف العميل حتى لو حاول استدعاء API مباشرة.

### صفحة الأدمن لإدارة المستخدمين
إنشاء:
- `src/pages/AdminUsersPage.tsx` (Protected + Admin only)
Features:
- قائمة المستخدمين (من `profiles` + `user_roles` + `user_access`)
- فلاتر: pending / active / expired / suspended
- Actions:
  - Approve (1 شهر / 3 شهور / تاريخ مخصص)
  - Extend (إضافة شهر/3 شهور)
  - Suspend / Reactivate
  - ملاحظات داخلية
  - تغيير دور المستخدم (admin/cashier) (مع حماية شديدة)
- مؤشرات:
  - عدد pending
  - المنتهية خلال 7 أيام القادمة

**Routing + حماية**
- Route: `/admin/users`
- إنشاء `AdminRoute` component أو توسيع ProtectedRoute ليدعم `requireAdmin`
- إضافة عنصر Nav للأدمن فقط في `DashboardLayout`

**ملفات**
- DB migration جديدة (SQL)
- `src/components/ProtectedRoute.tsx`
- `src/pages/AccessGatePage.tsx` (جديد)
- `src/pages/AdminUsersPage.tsx` (جديد)
- `src/App.tsx`, `src/components/DashboardLayout.tsx`

---

## 5) تحسين الموبايل (الترتيب + UX) — تغييرات مركّزة
بدون إعادة كتابة كل الصفحات، سنركز على أكبر نقاط ألم:
1) **صفحة الكروت / السجل (`VouchersPage`)**
- تحويل أزرار السجل على الموبايل إلى:
  - صف أزرار أقل + Dropdown للأوامر الثانوية
  - إبراز حالة: (مرفوع/غير مرفوع + نتائج)
  - progress للحذف ظاهر داخل بطاقة الدفعة
2) **صفحة المبيعات (`SalesPage`)**
- على الموبايل: تحويل الجدول إلى “Cards list” أو جعل الأعمدة الثانوية قابلة للطي، لتفادي التمرير الأفقي المزعج.
3) **DashboardLayout**
- تحسين bottom nav: تباعد/أحجام نصوص/التفاف labels
- ضمان safe-area iOS وارتفاع الـ header ثابت

---

## 6) اختبار الـ Flow (End-to-End) — سيناريوهات واضحة
بعد التنفيذ سنختبر (يدويًا) هذه المسارات:
1) تسجيل مستخدم جديد => يظهر Pending => يُمنع من الدخول ويشاهد صفحة AccessGate.
2) تسجيل دخول أدمن => دخول Admin Panel => اعتماد المستخدم لمدة شهر/3 شهور => المستخدم يستطيع الدخول.
3) انتهاء/تعليق الاشتراك => منع دخول كامل.
4) توليد دفعة + رفعها => ثم من السجل “حذف من الراوتر”:
   - تأكيد حذف فعلي (deleted count)
   - التعامل مع not-found
   - progress شغال
5) التأكد أن الروابط الجديدة:
   - `/` Landing عامة
   - `/dashboard` لوحة تحكم
   - Breadcrumb Home يذهب `/dashboard`

---

## تقسيم التنفيذ (لتقليل المخاطر)
1) إصلاح حذف الدفعة (الأكثر إلحاحًا) + تحسين progress/نتائج الحذف.  
2) إرجاع الألوان الأولى (tokens) + مراجعة سريع للـ contrast.  
3) Landing + نقل اللوحة إلى `/dashboard` + تحديث الروابط.  
4) نظام الأدمن والاشتراكات (DB + RLS + صفحات + حماية).  
5) تحسينات الموبايل النهائية بعد استقرار كل شيء.

