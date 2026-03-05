import { BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer, Cell } from "recharts";

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
      <div className="rounded-xl border border-border bg-card shadow-card p-5">
        <h3 className="text-sm font-semibold text-foreground mb-4">📊 حركة البيانات</h3>
        <p className="text-muted-foreground text-xs text-center py-8">لا توجد بيانات</p>
      </div>
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
    <div className="rounded-xl border border-border bg-card shadow-card p-5">
      <h3 className="text-sm font-semibold text-foreground mb-4">📊 حركة البيانات (MB)</h3>
      <div className="h-56" dir="ltr">
        <ResponsiveContainer width="100%" height="100%">
          <BarChart data={data} barGap={2}>
            <XAxis dataKey="name" tick={{ fontSize: 11 }} tickLine={false} className="text-muted-foreground" />
            <YAxis tick={{ fontSize: 10 }} axisLine={false} tickLine={false} tickFormatter={(v) => `${v.toFixed(0)}`} />
            <Tooltip
              formatter={(value: number, name: string) => [
                formatTraffic(value * 1048576),
                name === "rx" ? "تحميل ↓" : "رفع ↑",
              ]}
            />
            <Bar dataKey="rx" name="rx" radius={[4, 4, 0, 0]} maxBarSize={28} fill="hsl(217, 91%, 60%)" fillOpacity={0.8} />
            <Bar dataKey="tx" name="tx" radius={[4, 4, 0, 0]} maxBarSize={28} fill="hsl(172, 66%, 50%)" fillOpacity={0.8} />
          </BarChart>
        </ResponsiveContainer>
      </div>
      <div className="flex gap-4 mt-3 justify-center text-xs text-muted-foreground">
        <span className="flex items-center gap-1.5">
          <span className="w-2.5 h-2.5 rounded-sm bg-primary" /> تحميل (RX)
        </span>
        <span className="flex items-center gap-1.5">
          <span className="w-2.5 h-2.5 rounded-sm bg-accent" /> رفع (TX)
        </span>
      </div>
    </div>
  );
}
