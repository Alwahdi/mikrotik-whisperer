-- Add generation settings columns to print_templates table
-- These store all card-generation parameters so the full template is cloud-synced.

ALTER TABLE public.print_templates
  ADD COLUMN IF NOT EXISTS voucher_type   text    NOT NULL DEFAULT 'hotspot',
  ADD COLUMN IF NOT EXISTS prefix         text    NOT NULL DEFAULT 'v',
  ADD COLUMN IF NOT EXISTS name_length    integer NOT NULL DEFAULT 6,
  ADD COLUMN IF NOT EXISTS pass_length    integer NOT NULL DEFAULT 6,
  ADD COLUMN IF NOT EXISTS char_type      text    NOT NULL DEFAULT 'alphanumeric',
  ADD COLUMN IF NOT EXISTS password_mode  text    NOT NULL DEFAULT 'random',
  ADD COLUMN IF NOT EXISTS unit_price     numeric NOT NULL DEFAULT 0,
  ADD COLUMN IF NOT EXISTS validity_days  integer NOT NULL DEFAULT 0,
  ADD COLUMN IF NOT EXISTS transfer_limit integer NOT NULL DEFAULT 0,
  ADD COLUMN IF NOT EXISTS package_display_name text NOT NULL DEFAULT '',
  ADD COLUMN IF NOT EXISTS hours_label    text    NOT NULL DEFAULT '',
  ADD COLUMN IF NOT EXISTS data_quota_label text  NOT NULL DEFAULT '';
