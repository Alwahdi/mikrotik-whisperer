import { LucideIcon } from "lucide-react";

interface StatCardProps {
  title: string;
  value: string | number;
  subtitle?: string;
  icon: LucideIcon;
  variant?: "default" | "primary" | "accent" | "warning";
}

const iconStyles = {
  default: "text-muted-foreground",
  primary: "text-foreground",
  accent: "text-success",
  warning: "text-warning",
};

export default function StatCard({ title, value, subtitle, icon: Icon, variant = "default" }: StatCardProps) {
  return (
    <div className="rounded-lg border border-border bg-card p-4 shadow-card">
      <div className="flex items-start justify-between">
        <div className="min-w-0">
          <p className="text-[11px] text-muted-foreground mb-1 uppercase tracking-wide">{title}</p>
          <p className="text-xl font-bold text-foreground truncate">{value}</p>
          {subtitle && <p className="text-[10px] text-muted-foreground mt-0.5">{subtitle}</p>}
        </div>
        <Icon className={`h-4 w-4 shrink-0 mt-0.5 ${iconStyles[variant]}`} />
      </div>
    </div>
  );
}
