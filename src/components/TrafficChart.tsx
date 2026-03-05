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

const COLORS = [
  "hsl(196, 100%, 50%)",
  "hsl(160, 84%, 40%)",
  "hsl(38, 92%, 50%)",
  "hsl(280, 70%, 55%)",
  "hsl(350, 80%, 55%)",
  "hsl(210, 70%, 55%)",
];

export default function TrafficChart({ interfaces }: TrafficChartProps) {
  if (!Array.isArray(interfaces) || interfaces.length === 0) {
    return (
      <div className="gradient-card rounded-xl border border-border shadow-card p-5">
        <h3 className="text-sm font-semibold text-foreground mb-4">📊 حركة البيانات (Interfaces)</h3>
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
      rxLabel: formatTraffic(iface["rx-byte"]),
      txLabel: formatTraffic(iface["tx-byte"]),
      running: iface.running === "true" || iface.running === true,
    }));

  return (
    <div className="gradient-card rounded-xl border border-border shadow-card p-5">
      <h3 className="text-sm font-semibold text-foreground mb-4">📊 حركة البيانات (MB)</h3>
      <div className="h-64" dir="ltr">
        <ResponsiveContainer width="100%" height="100%">
          <BarChart data={data} barGap={2}>
            <XAxis
              dataKey="name"
              tick={{ fill: "hsl(215, 12%, 55%)", fontSize: 11 }}
              axisLine={{ stroke: "hsl(220, 14%, 20%)" }}
              tickLine={false}
            />
            <YAxis
              tick={{ fill: "hsl(215, 12%, 55%)", fontSize: 10 }}
              axisLine={false}
              tickLine={false}
              tickFormatter={(v) => `${v.toFixed(0)}`}
            />
            <Tooltip
              contentStyle={{
                background: "hsl(220, 18%, 13%)",
                border: "1px solid hsl(220, 14%, 20%)",
                borderRadius: "8px",
                color: "hsl(210, 20%, 92%)",
                fontSize: 12,
              }}
              formatter={(value: number, name: string) => [
                formatTraffic(value * 1048576),
                name === "rx" ? "تحميل ↓" : "رفع ↑",
              ]}
            />
            <Bar dataKey="rx" name="rx" radius={[4, 4, 0, 0]} maxBarSize={32}>
              {data.map((_: any, i: number) => (
                <Cell key={i} fill={COLORS[0]} fillOpacity={0.85} />
              ))}
            </Bar>
            <Bar dataKey="tx" name="tx" radius={[4, 4, 0, 0]} maxBarSize={32}>
              {data.map((_: any, i: number) => (
                <Cell key={i} fill={COLORS[1]} fillOpacity={0.85} />
              ))}
            </Bar>
          </BarChart>
        </ResponsiveContainer>
      </div>
      <div className="flex gap-4 mt-3 justify-center text-xs text-muted-foreground">
        <span className="flex items-center gap-1.5">
          <span className="w-3 h-3 rounded-sm" style={{ background: COLORS[0] }} /> تحميل (RX)
        </span>
        <span className="flex items-center gap-1.5">
          <span className="w-3 h-3 rounded-sm" style={{ background: COLORS[1] }} /> رفع (TX)
        </span>
      </div>
    </div>
  );
}
