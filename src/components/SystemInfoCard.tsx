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
      <h3 className="text-sm font-semibold text-foreground mb-4 flex items-center gap-2">
        <span className="inline-block w-1.5 h-1.5 rounded-full bg-primary" />
        معلومات النظام
      </h3>
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-x-6 gap-y-2.5">
        {items.map((item, i) => (
          <div key={i} className="flex justify-between items-center py-1.5 border-b border-border/50 last:border-0">
            <span className="text-xs text-muted-foreground">{item.label}</span>
            <span className="text-xs font-mono text-foreground font-medium">{item.value}</span>
          </div>
        ))}
      </div>
    </div>
  );
}
