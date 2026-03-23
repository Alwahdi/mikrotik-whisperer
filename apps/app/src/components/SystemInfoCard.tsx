import { Card, CardHeader, CardTitle, CardContent } from "@repo/design-system/components/ui/card";
import { Separator } from "@repo/design-system/components/ui/separator";

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
    <Card>
      <CardHeader className="pb-3 p-5">
        <CardTitle className="text-xs font-semibold uppercase tracking-wide">
          معلومات النظام
        </CardTitle>
      </CardHeader>
      <CardContent className="p-5 pt-0">
        <div className="grid grid-cols-1 sm:grid-cols-2 gap-x-6">
          {items.map((item, i) => (
            <div key={i}>
              <div className="flex justify-between items-center py-2">
                <span className="text-xs text-muted-foreground">{item.label}</span>
                <span className="text-xs font-mono text-foreground">{item.value}</span>
              </div>
              {i < items.length - 1 && <Separator className="opacity-50" />}
            </div>
          ))}
        </div>
      </CardContent>
    </Card>
  );
}
