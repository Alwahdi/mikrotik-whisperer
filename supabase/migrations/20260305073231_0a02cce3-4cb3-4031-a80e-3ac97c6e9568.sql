
CREATE TABLE public.sales (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id uuid NOT NULL,
  router_host text NOT NULL DEFAULT '',
  batch_id text NOT NULL,
  profile_name text NOT NULL DEFAULT '',
  card_count integer NOT NULL DEFAULT 0,
  success_count integer NOT NULL DEFAULT 0,
  failed_count integer NOT NULL DEFAULT 0,
  unit_price numeric DEFAULT 0,
  total_amount numeric DEFAULT 0,
  voucher_type text NOT NULL DEFAULT 'usermanager',
  created_at timestamp with time zone DEFAULT now(),
  notes text DEFAULT ''
);

ALTER TABLE public.sales ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Users can view own sales"
  ON public.sales FOR SELECT
  TO authenticated
  USING (auth.uid() = user_id);

CREATE POLICY "Users can insert own sales"
  ON public.sales FOR INSERT
  TO authenticated
  WITH CHECK (auth.uid() = user_id);

CREATE POLICY "Users can delete own sales"
  ON public.sales FOR DELETE
  TO authenticated
  USING (auth.uid() = user_id);
