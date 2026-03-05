
-- 1) Access status enum
CREATE TYPE public.access_status AS ENUM ('pending', 'active', 'suspended', 'expired');

-- 2) User access table
CREATE TABLE public.user_access (
  user_id uuid PRIMARY KEY,
  status access_status NOT NULL DEFAULT 'pending',
  starts_at timestamptz,
  expires_at timestamptz,
  approved_at timestamptz,
  approved_by uuid,
  notes text DEFAULT '',
  created_at timestamptz DEFAULT now()
);

-- 3) Enable RLS
ALTER TABLE public.user_access ENABLE ROW LEVEL SECURITY;

-- 4) RLS: Users can view own access
CREATE POLICY "Users can view own access"
  ON public.user_access FOR SELECT
  TO authenticated
  USING (auth.uid() = user_id);

-- 5) RLS: Admins can manage all access
CREATE POLICY "Admins can manage access"
  ON public.user_access FOR ALL
  TO authenticated
  USING (public.has_role(auth.uid(), 'admin'));

-- 6) RLS: Allow admin to read all profiles
CREATE POLICY "Admins can view all profiles"
  ON public.profiles FOR SELECT
  TO authenticated
  USING (public.has_role(auth.uid(), 'admin'));

-- 7) Trigger: auto-create user_access on profile creation
CREATE OR REPLACE FUNCTION public.handle_new_user_access()
RETURNS trigger
LANGUAGE plpgsql
SECURITY DEFINER
SET search_path TO 'public'
AS $$
BEGIN
  INSERT INTO public.user_access (user_id) VALUES (NEW.id)
  ON CONFLICT (user_id) DO NOTHING;
  RETURN NEW;
END;
$$;

CREATE TRIGGER on_profile_created_access
  AFTER INSERT ON public.profiles
  FOR EACH ROW
  EXECUTE FUNCTION public.handle_new_user_access();

-- 8) Function to check access
CREATE OR REPLACE FUNCTION public.is_access_allowed(_user_id uuid)
RETURNS boolean
LANGUAGE sql
STABLE
SECURITY DEFINER
SET search_path TO 'public'
AS $$
  SELECT
    CASE
      WHEN EXISTS (SELECT 1 FROM public.user_roles WHERE user_id = _user_id AND role = 'admin') THEN true
      WHEN EXISTS (
        SELECT 1 FROM public.user_access
        WHERE user_id = _user_id
          AND status = 'active'
          AND (expires_at IS NULL OR expires_at > now())
      ) THEN true
      ELSE false
    END
$$;

-- 9) Backfill existing users into user_access
INSERT INTO public.user_access (user_id, status, starts_at, approved_at)
SELECT p.id, 'active', now(), now()
FROM public.profiles p
WHERE NOT EXISTS (SELECT 1 FROM public.user_access WHERE user_id = p.id)
ON CONFLICT (user_id) DO NOTHING;
