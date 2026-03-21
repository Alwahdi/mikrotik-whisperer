-- Create print_templates table for cloud-saved card print templates
CREATE TABLE public.print_templates (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id uuid NOT NULL REFERENCES auth.users(id) ON DELETE CASCADE,
  router_host text NOT NULL DEFAULT '',
  name text NOT NULL,
  profile_name text,
  bg_image text,
  fields jsonb NOT NULL DEFAULT '[]',
  print_cols integer NOT NULL DEFAULT 3,
  print_rows integer NOT NULL DEFAULT 4,
  card_title text NOT NULL DEFAULT 'WiFi Card',
  card_subtitle text NOT NULL DEFAULT '',
  created_at timestamptz DEFAULT now(),
  updated_at timestamptz DEFAULT now()
);

ALTER TABLE public.print_templates ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Users can view own templates"
  ON public.print_templates FOR SELECT
  TO authenticated
  USING (auth.uid() = user_id);

CREATE POLICY "Users can insert own templates"
  ON public.print_templates FOR INSERT
  TO authenticated
  WITH CHECK (auth.uid() = user_id);

CREATE POLICY "Users can update own templates"
  ON public.print_templates FOR UPDATE
  TO authenticated
  USING (auth.uid() = user_id);

CREATE POLICY "Users can delete own templates"
  ON public.print_templates FOR DELETE
  TO authenticated
  USING (auth.uid() = user_id);
