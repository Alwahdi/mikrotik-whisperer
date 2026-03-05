
-- Drop and recreate triggers to ensure they're properly attached
DROP TRIGGER IF EXISTS on_profile_created_assign_role ON public.profiles;
DROP TRIGGER IF EXISTS on_profile_created_access ON public.profiles;

CREATE TRIGGER on_profile_created_assign_role
  AFTER INSERT ON public.profiles
  FOR EACH ROW EXECUTE FUNCTION public.auto_assign_role();

CREATE TRIGGER on_profile_created_access
  AFTER INSERT ON public.profiles
  FOR EACH ROW EXECUTE FUNCTION public.handle_new_user_access();
