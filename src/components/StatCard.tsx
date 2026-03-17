import { LucideIcon } from "lucide-react";
import { cn } from "@/lib/utils";

interface StatCardProps {
  title: string;
  value: string | number;
  subtitle?: string;
  icon: LucideIcon;
  variant?: "default" | "primary" | "accent" | "warning" | "success" | "info";
  trend?: {
    value: number;
    isPositive: boolean;
  };
  className?: string;
}

const variantStyles = {
  default: {
    icon: "text-muted-foreground",
    iconBg: "bg-muted/50",
    border: "border-border",
    accentBar: "bg-muted-foreground/20",
  },
  primary: {
    icon: "text-primary",
    iconBg: "bg-primary/10",
    border: "border-primary/20",
    accentBar: "bg-primary",
  },
  accent: {
    icon: "text-success",
    iconBg: "bg-success/10",
    border: "border-success/20",
    accentBar: "bg-success",
  },
  warning: {
    icon: "text-warning",
    iconBg: "bg-warning/10",
    border: "border-warning/20",
    accentBar: "bg-warning",
  },
  success: {
    icon: "text-success",
    iconBg: "bg-success/10",
    border: "border-success/20",
    accentBar: "bg-success",
  },
  info: {
    icon: "text-info",
    iconBg: "bg-info/10",
    border: "border-info/20",
    accentBar: "bg-info",
  },
};

export default function StatCard({
  title,
  value,
  subtitle,
  icon: Icon,
  variant = "default",
  trend,
  className,
}: StatCardProps) {
  const styles = variantStyles[variant];

  return (
    <div
      className={cn(
        "group relative overflow-hidden rounded-lg border bg-card p-5 shadow-card transition-all hover:shadow-md hover:-translate-y-0.5",
        styles.border,
        className
      )}
    >
      {/* Accent bar */}
      <div className={cn("absolute top-0 left-0 right-0 h-0.5", styles.accentBar)} />

      <div className="flex items-start justify-between gap-3">
        <div className="min-w-0 flex-1">
          <p className="text-xs font-medium text-muted-foreground mb-2 uppercase tracking-wider">
            {title}
          </p>
          <div className="flex items-baseline gap-2">
            <p className="text-2xl font-bold text-foreground tracking-tight">
              {value}
            </p>
            {trend && (
              <span
                className={cn(
                  "text-xs font-medium",
                  trend.isPositive ? "text-success" : "text-destructive"
                )}
              >
                {trend.isPositive ? "↑" : "↓"} {Math.abs(trend.value)}%
              </span>
            )}
          </div>
          {subtitle && (
            <p className="text-xs text-muted-foreground mt-1.5">{subtitle}</p>
          )}
        </div>
        <div
          className={cn(
            "p-2.5 rounded-lg transition-transform group-hover:scale-110",
            styles.iconBg
          )}
        >
          <Icon className={cn("h-5 w-5 shrink-0", styles.icon)} />
        </div>
      </div>
    </div>
  );
}
