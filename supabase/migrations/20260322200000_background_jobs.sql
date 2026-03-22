-- ─── Background Jobs Table ─────────────────────────────────────────────────
create table background_jobs (
  id uuid default gen_random_uuid() primary key,
  user_id uuid references auth.users(id) on delete cascade not null,
  job_key text not null,
  label text not null,
  type text not null default 'add',
  status text not null default 'running'
    check (status in ('running','retrying','success','error','interrupted')),
  total integer not null default 0,
  completed integer not null default 0,
  succeeded integer not null default 0,
  failed integer not null default 0,
  rate integer not null default 0,
  router_host text,
  started_at timestamptz not null default now(),
  finished_at timestamptz,
  logs jsonb not null default '[]'::jsonb,
  created_at timestamptz not null default now()
);

alter table background_jobs enable row level security;

create policy "users can manage own jobs"
  on background_jobs for all
  using ((select auth.uid()) = user_id)
  with check ((select auth.uid()) = user_id);

create index background_jobs_user_id_idx on background_jobs (user_id);
create index background_jobs_started_at_idx on background_jobs (started_at desc);
create index background_jobs_status_idx on background_jobs (status);
