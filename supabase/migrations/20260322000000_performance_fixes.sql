-- Performance migration
-- 1. Add missing indexes on FK columns (backups, print_templates, routers)
-- 2. Replace auth.uid() with (select auth.uid()) in RLS policies to prevent per-row re-evaluation
-- 3. Merge multiple permissive SELECT policies on profiles, user_roles, user_access

-- ── Indexes ───────────────────────────────────────────────────────────────────
CREATE INDEX IF NOT EXISTS idx_backups_router_id     ON public.backups         (router_id);
CREATE INDEX IF NOT EXISTS idx_print_templates_user  ON public.print_templates (user_id);
CREATE INDEX IF NOT EXISTS idx_routers_user_id       ON public.routers         (user_id);

-- ── profiles ─────────────────────────────────────────────────────────────────
-- Merge "Users can view own profile" + "Admins can view all profiles" into one SELECT policy
DROP POLICY IF EXISTS "Users can view own profile"    ON public.profiles;
DROP POLICY IF EXISTS "Admins can view all profiles"  ON public.profiles;
DROP POLICY IF EXISTS "Users can update own profile"  ON public.profiles;
DROP POLICY IF EXISTS "Users can insert own profile"  ON public.profiles;

CREATE POLICY "profiles_select"
  ON public.profiles FOR SELECT TO authenticated
  USING (
    (select auth.uid()) = id
    OR public.has_role((select auth.uid()), 'admin')
  );

CREATE POLICY "Users can update own profile"
  ON public.profiles FOR UPDATE TO authenticated
  USING ((select auth.uid()) = id);

CREATE POLICY "Users can insert own profile"
  ON public.profiles FOR INSERT TO authenticated
  WITH CHECK ((select auth.uid()) = id);

-- ── routers ───────────────────────────────────────────────────────────────────
DROP POLICY IF EXISTS "Users can view own routers"   ON public.routers;
DROP POLICY IF EXISTS "Users can insert own routers" ON public.routers;
DROP POLICY IF EXISTS "Users can update own routers" ON public.routers;
DROP POLICY IF EXISTS "Users can delete own routers" ON public.routers;

CREATE POLICY "Users can view own routers"
  ON public.routers FOR SELECT TO authenticated
  USING ((select auth.uid()) = user_id);

CREATE POLICY "Users can insert own routers"
  ON public.routers FOR INSERT TO authenticated
  WITH CHECK ((select auth.uid()) = user_id);

CREATE POLICY "Users can update own routers"
  ON public.routers FOR UPDATE TO authenticated
  USING ((select auth.uid()) = user_id);

CREATE POLICY "Users can delete own routers"
  ON public.routers FOR DELETE TO authenticated
  USING ((select auth.uid()) = user_id);

-- ── user_roles ────────────────────────────────────────────────────────────────
-- Merge "Users can view own roles" + "Admins can manage roles" (FOR ALL) SELECT into one policy
-- Split admin writes into explicit INSERT/UPDATE/DELETE policies
DROP POLICY IF EXISTS "Users can view own roles"   ON public.user_roles;
DROP POLICY IF EXISTS "Admins can manage roles"    ON public.user_roles;

CREATE POLICY "user_roles_select"
  ON public.user_roles FOR SELECT TO authenticated
  USING (
    (select auth.uid()) = user_id
    OR public.has_role((select auth.uid()), 'admin')
  );

CREATE POLICY "user_roles_insert"
  ON public.user_roles FOR INSERT TO authenticated
  WITH CHECK (public.has_role((select auth.uid()), 'admin'));

CREATE POLICY "user_roles_update"
  ON public.user_roles FOR UPDATE TO authenticated
  USING  (public.has_role((select auth.uid()), 'admin'))
  WITH CHECK (public.has_role((select auth.uid()), 'admin'));

CREATE POLICY "user_roles_delete"
  ON public.user_roles FOR DELETE TO authenticated
  USING (public.has_role((select auth.uid()), 'admin'));

-- ── backups ───────────────────────────────────────────────────────────────────
DROP POLICY IF EXISTS "Users can view own backups"   ON public.backups;
DROP POLICY IF EXISTS "Users can insert own backups" ON public.backups;
DROP POLICY IF EXISTS "Users can delete own backups" ON public.backups;
DROP POLICY IF EXISTS "Users can update own backups" ON public.backups;

CREATE POLICY "Users can view own backups"
  ON public.backups FOR SELECT TO authenticated
  USING ((select auth.uid()) = user_id);

CREATE POLICY "Users can insert own backups"
  ON public.backups FOR INSERT TO authenticated
  WITH CHECK ((select auth.uid()) = user_id);

CREATE POLICY "Users can delete own backups"
  ON public.backups FOR DELETE TO authenticated
  USING ((select auth.uid()) = user_id);

CREATE POLICY "Users can update own backups"
  ON public.backups FOR UPDATE TO authenticated
  USING ((select auth.uid()) = user_id);

-- ── sales ─────────────────────────────────────────────────────────────────────
DROP POLICY IF EXISTS "Users can view own sales"   ON public.sales;
DROP POLICY IF EXISTS "Users can insert own sales" ON public.sales;
DROP POLICY IF EXISTS "Users can delete own sales" ON public.sales;

CREATE POLICY "Users can view own sales"
  ON public.sales FOR SELECT TO authenticated
  USING ((select auth.uid()) = user_id);

CREATE POLICY "Users can insert own sales"
  ON public.sales FOR INSERT TO authenticated
  WITH CHECK ((select auth.uid()) = user_id);

CREATE POLICY "Users can delete own sales"
  ON public.sales FOR DELETE TO authenticated
  USING ((select auth.uid()) = user_id);

-- ── user_access ───────────────────────────────────────────────────────────────
-- Merge "Users can view own access" + "Admins can manage access" (FOR ALL) SELECT into one policy
DROP POLICY IF EXISTS "Users can view own access" ON public.user_access;
DROP POLICY IF EXISTS "Admins can manage access"  ON public.user_access;

CREATE POLICY "user_access_select"
  ON public.user_access FOR SELECT TO authenticated
  USING (
    (select auth.uid()) = user_id
    OR public.has_role((select auth.uid()), 'admin')
  );

CREATE POLICY "user_access_insert"
  ON public.user_access FOR INSERT TO authenticated
  WITH CHECK (public.has_role((select auth.uid()), 'admin'));

CREATE POLICY "user_access_update"
  ON public.user_access FOR UPDATE TO authenticated
  USING  (public.has_role((select auth.uid()), 'admin'))
  WITH CHECK (public.has_role((select auth.uid()), 'admin'));

CREATE POLICY "user_access_delete"
  ON public.user_access FOR DELETE TO authenticated
  USING (public.has_role((select auth.uid()), 'admin'));

-- ── print_templates ───────────────────────────────────────────────────────────
DROP POLICY IF EXISTS "Users can view own templates"   ON public.print_templates;
DROP POLICY IF EXISTS "Users can insert own templates" ON public.print_templates;
DROP POLICY IF EXISTS "Users can update own templates" ON public.print_templates;
DROP POLICY IF EXISTS "Users can delete own templates" ON public.print_templates;

CREATE POLICY "Users can view own templates"
  ON public.print_templates FOR SELECT TO authenticated
  USING ((select auth.uid()) = user_id);

CREATE POLICY "Users can insert own templates"
  ON public.print_templates FOR INSERT TO authenticated
  WITH CHECK ((select auth.uid()) = user_id);

CREATE POLICY "Users can update own templates"
  ON public.print_templates FOR UPDATE TO authenticated
  USING ((select auth.uid()) = user_id);

CREATE POLICY "Users can delete own templates"
  ON public.print_templates FOR DELETE TO authenticated
  USING ((select auth.uid()) = user_id);
