
-- Create app_role enum
CREATE TYPE public.app_role AS ENUM ('admin', 'cashier');

-- Create user_roles table
CREATE TABLE public.user_roles (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id uuid REFERENCES auth.users(id) ON DELETE CASCADE NOT NULL,
  role app_role NOT NULL,
  created_at timestamptz DEFAULT now(),
  UNIQUE (user_id, role)
);

ALTER TABLE public.user_roles ENABLE ROW LEVEL SECURITY;

-- Security definer function to check roles
CREATE OR REPLACE FUNCTION public.has_role(_user_id uuid, _role app_role)
RETURNS boolean
LANGUAGE sql
STABLE
SECURITY DEFINER
SET search_path = public
AS $$
  SELECT EXISTS (
    SELECT 1 FROM public.user_roles
    WHERE user_id = _user_id AND role = _role
  )
$$;

-- Function to get user role
CREATE OR REPLACE FUNCTION public.get_user_role(_user_id uuid)
RETURNS text
LANGUAGE sql
STABLE
SECURITY DEFINER
SET search_path = public
AS $$
  SELECT role::text FROM public.user_roles
  WHERE user_id = _user_id
  LIMIT 1
$$;

-- RLS: users can view their own roles
CREATE POLICY "Users can view own roles"
ON public.user_roles FOR SELECT
TO authenticated
USING (auth.uid() = user_id);

-- RLS: admins can manage all roles
CREATE POLICY "Admins can manage roles"
ON public.user_roles FOR ALL
TO authenticated
USING (public.has_role(auth.uid(), 'admin'));

-- Auto-assign admin role to first user (trigger)
CREATE OR REPLACE FUNCTION public.auto_assign_role()
RETURNS trigger
LANGUAGE plpgsql
SECURITY DEFINER
SET search_path = public
AS $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM public.user_roles LIMIT 1) THEN
    INSERT INTO public.user_roles (user_id, role) VALUES (NEW.id, 'admin');
  ELSE
    INSERT INTO public.user_roles (user_id, role) VALUES (NEW.id, 'cashier');
  END IF;
  RETURN NEW;
END;
$$;

CREATE TRIGGER on_profile_created_assign_role
AFTER INSERT ON public.profiles
FOR EACH ROW EXECUTE FUNCTION public.auto_assign_role();

-- Create backups table
CREATE TABLE public.backups (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id uuid NOT NULL,
  router_id uuid REFERENCES public.routers(id) ON DELETE CASCADE,
  router_label text NOT NULL DEFAULT 'MikroTik',
  backup_type text NOT NULL DEFAULT 'users',
  status text NOT NULL DEFAULT 'pending',
  file_path text,
  metadata jsonb DEFAULT '{}',
  created_at timestamptz DEFAULT now()
);

ALTER TABLE public.backups ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Users can view own backups"
ON public.backups FOR SELECT
TO authenticated
USING (auth.uid() = user_id);

CREATE POLICY "Users can insert own backups"
ON public.backups FOR INSERT
TO authenticated
WITH CHECK (auth.uid() = user_id);

CREATE POLICY "Users can delete own backups"
ON public.backups FOR DELETE
TO authenticated
USING (auth.uid() = user_id);

CREATE POLICY "Users can update own backups"
ON public.backups FOR UPDATE
TO authenticated
USING (auth.uid() = user_id);

-- Create storage bucket for backups
INSERT INTO storage.buckets (id, name, public) VALUES ('router-backups', 'router-backups', false);

-- Storage RLS
CREATE POLICY "Users can upload own backups"
ON storage.objects FOR INSERT
TO authenticated
WITH CHECK (bucket_id = 'router-backups' AND (storage.foldername(name))[1] = auth.uid()::text);

CREATE POLICY "Users can view own backups"
ON storage.objects FOR SELECT
TO authenticated
USING (bucket_id = 'router-backups' AND (storage.foldername(name))[1] = auth.uid()::text);

CREATE POLICY "Users can delete own backups"
ON storage.objects FOR DELETE
TO authenticated
USING (bucket_id = 'router-backups' AND (storage.foldername(name))[1] = auth.uid()::text);
