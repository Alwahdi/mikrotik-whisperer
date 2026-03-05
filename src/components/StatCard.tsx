import { LucideIcon } from "lucide-react";

interface StatCardProps {
  title: string;
  value: string | number;
  subtitle?: string;
  icon: LucideIcon;
  variant?: "default" | "primary" | "accent" | "warning";
}

const variantStyles = {
  default: "border-border",
  primary: "border-primary/20",
  accent: "border-accent/20",
  warning: "border-warning/20",
};

const iconStyles = {
  default: "bg-muted text-muted-foreground",
  primary: "bg-primary/10 text-primary",
  accent: "bg-accent/10 text-accent",
  warning: "bg-warning/10 text-warning",
};

export default function StatCard({ title, value, subtitle, icon: Icon, variant = "default" }: StatCardProps) {
  return (
    <div className={`rounded-xl border bg-card p-4 shadow-card ${variantStyles[variant]}`}>
      <div className="flex items-start justify-between">
        <div className="min-w-0">
          <p className="text-xs text-muted-foreground mb-1">{title}</p>
          <p className="text-xl font-bold text-foreground truncate">{value}</p>
          {subtitle && <p className="text-[10px] text-muted-foreground mt-0.5">{subtitle}</p>}
        </div>
        <div className={`p-2 rounded-lg shrink-0 ${iconStyles[variant]}`}>
          <Icon className="h-4 w-4" />
        </div>
      </div>
    </div>
  );
}
