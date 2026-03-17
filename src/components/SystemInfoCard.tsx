interface SystemInfoProps {
  resource: Record<string, any> | undefined;
  identity: Record<string, any> | undefined;
  routerboard: Record<string, any> | undefined;
}

export default function SystemInfoCard({ resource, identity, routerboard }: SystemInfoProps) {
  const items = [
    { label: "اسم الراوتر", value: identity?.name },
    { label: "إصدار RouterOS", value: resource?.version },
    { label: "المعمارية", value: resource?.["architecture-name"] },
    { label: "اسم اللوحة", value: resource?.["board-name"] || routerboard?.model },
    { label: "الرقم التسلسلي", value: routerboard?.["serial-number"] },
    { label: "الفيرم وير", value: routerboard?.["current-firmware"] || routerboard?.firmware },
    { label: "وقت التشغيل", value: resource?.uptime },
    { label: "آخر تحديث", value: routerboard?.["upgrade-firmware"] },
  ].filter((item) => item.value);

  return (
    <div className="rounded-xl border border-border bg-card shadow-card p-5">
      <h3 className="text-xs font-semibold text-foreground mb-4 uppercase tracking-widest flex items-center gap-2">
        <span className="h-3.5 w-0.5 rounded-full bg-primary" />
        معلومات النظام
      </h3>
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-x-6 gap-y-0">
        {items.map((item, i) => (
          <div key={i} className="flex justify-between items-center py-2.5 border-b border-border/40 last:border-0">
            <span className="text-xs text-muted-foreground">{item.label}</span>
            <span className="text-xs font-mono text-foreground font-medium">{item.value}</span>
          </div>
        ))}
      </div>
    </div>
  );
}
