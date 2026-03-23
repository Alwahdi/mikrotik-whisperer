import { BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer } from "recharts";
import { Card, CardHeader, CardTitle, CardContent } from "@repo/design-system/components/ui/card";

interface TrafficChartProps {
  interfaces: any[] | undefined;
}

function formatTraffic(bytes: string | number | undefined): string {
  if (!bytes) return "0";
  const b = Number(bytes);
  if (b < 1024) return b + " B";
  if (b < 1048576) return (b / 1024).toFixed(1) + " KB";
  if (b < 1073741824) return (b / 1048576).toFixed(1) + " MB";
  return (b / 1073741824).toFixed(2) + " GB";
}

export default function TrafficChart({ interfaces }: TrafficChartProps) {
  if (!Array.isArray(interfaces) || interfaces.length === 0) {
    return (
      <Card>
        <CardHeader className="p-5 pb-3">
          <CardTitle className="text-xs font-semibold uppercase tracking-wide">حركة البيانات</CardTitle>
        </CardHeader>
        <CardContent className="p-5 pt-0">
          <p className="text-muted-foreground text-xs text-center py-8">لا توجد بيانات</p>
        </CardContent>
      </Card>
    );
  }

  const data = interfaces
    .filter((iface: any) => {
      const rx = Number(iface["rx-byte"] || 0);
      const tx = Number(iface["tx-byte"] || 0);
      return (rx + tx) > 0 && iface.type !== "loopback";
    })
    .slice(0, 8)
    .map((iface: any) => ({
      name: iface.name || "—",
      rx: Number(iface["rx-byte"] || 0) / 1048576,
      tx: Number(iface["tx-byte"] || 0) / 1048576,
    }));

  return (
    <Card>
      <CardHeader className="p-5 pb-3">
        <CardTitle className="text-xs font-semibold uppercase tracking-wide">حركة البيانات (MB)</CardTitle>
      </CardHeader>
      <CardContent className="p-5 pt-0">
        <div className="h-52" dir="ltr">
          <ResponsiveContainer width="100%" height="100%">
            <BarChart data={data} barGap={2}>
              <XAxis dataKey="name" tick={{ fontSize: 10 }} tickLine={false} stroke="hsl(var(--muted-foreground))" />
              <YAxis tick={{ fontSize: 10 }} axisLine={false} tickLine={false} tickFormatter={(v) => `${v.toFixed(0)}`} stroke="hsl(var(--muted-foreground))" />
              <Tooltip
                formatter={(value: number, name: string) => [
                  formatTraffic(value * 1048576),
                  name === "rx" ? "تحميل ↓" : "رفع ↑",
                ]}
                contentStyle={{
                  fontSize: 12,
                  borderRadius: 8,
                  border: "1px solid hsl(var(--border))",
                  background: "hsl(var(--card))",
                }}
              />
              <Bar dataKey="rx" name="rx" radius={[3, 3, 0, 0]} maxBarSize={24} fill="hsl(var(--primary))" fillOpacity={0.7} />
              <Bar dataKey="tx" name="tx" radius={[3, 3, 0, 0]} maxBarSize={24} fill="hsl(var(--muted-foreground))" fillOpacity={0.5} />
            </BarChart>
          </ResponsiveContainer>
        </div>
        <div className="flex gap-5 mt-3 justify-center text-[11px] text-muted-foreground">
          <span className="flex items-center gap-1.5">
            <span className="w-2 h-2 rounded-sm bg-primary/70" /> تحميل (RX)
          </span>
          <span className="flex items-center gap-1.5">
            <span className="w-2 h-2 rounded-sm bg-muted-foreground/50" /> رفع (TX)
          </span>
        </div>
      </CardContent>
    </Card>
  );
}
