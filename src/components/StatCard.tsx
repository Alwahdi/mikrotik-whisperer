import { LucideIcon } from "lucide-react";

interface StatCardProps {
  title: string;
  value: string | number;
  subtitle?: string;
  icon: LucideIcon;
  variant?: "default" | "primary" | "accent" | "warning";
}

const variantStyles = {
  default: {
    icon: "text-muted-foreground",
    bg: "bg-card",
    border: "border-border",
  },
  primary: {
    icon: "text-foreground",
    bg: "bg-card",
    border: "border-primary/10",
  },
  accent: {
    icon: "text-success",
    bg: "bg-card",
    border: "border-success/10",
  },
  warning: {
    icon: "text-warning",
    bg: "bg-card",
    border: "border-warning/10",
  },
};

export default function StatCard({ title, value, subtitle, icon: Icon, variant = "default" }: StatCardProps) {
  const styles = variantStyles[variant];
  return (
    <div className={`rounded-lg border ${styles.border} ${styles.bg} p-4 shadow-card hover-lift press-scale`}>
      <div className="flex items-start justify-between">
        <div className="min-w-0">
          <p className="text-[11px] text-muted-foreground mb-1 uppercase tracking-wide">{title}</p>
          <p className="text-xl font-bold text-foreground truncate animate-count">{value}</p>
          {subtitle && <p className="text-[10px] text-muted-foreground mt-0.5">{subtitle}</p>}
        </div>
        <div className={`p-1.5 rounded-md bg-muted/50`}>
          <Icon className={`h-4 w-4 shrink-0 ${styles.icon}`} />
        </div>
      </div>
    </div>
  );
}
