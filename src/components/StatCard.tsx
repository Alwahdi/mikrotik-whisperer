import { LucideIcon } from "lucide-react";

interface StatCardProps {
  title: string;
  value: string | number;
  subtitle?: string;
  icon: LucideIcon;
  variant?: "default" | "primary" | "accent" | "warning" | "destructive";
  trend?: { value: number; label?: string };
}

const variantStyles = {
  default: {
    iconBg: "bg-muted",
    iconColor: "text-muted-foreground",
    borderAccent: "border-border",
    topBar: "",
  },
  primary: {
    iconBg: "gradient-primary",
    iconColor: "text-primary-foreground",
    borderAccent: "border-primary/20",
    topBar: "bg-primary",
  },
  accent: {
    iconBg: "gradient-accent",
    iconColor: "text-accent-foreground",
    borderAccent: "border-accent/20",
    topBar: "bg-accent",
  },
  warning: {
    iconBg: "gradient-warning",
    iconColor: "text-white",
    borderAccent: "border-warning/20",
    topBar: "bg-warning",
  },
  destructive: {
    iconBg: "gradient-destructive",
    iconColor: "text-white",
    borderAccent: "border-destructive/20",
    topBar: "bg-destructive",
  },
};

export default function StatCard({ title, value, subtitle, icon: Icon, variant = "default", trend }: StatCardProps) {
  const styles = variantStyles[variant];
  const isColored = variant !== "default";

  return (
    <div className={`relative rounded-xl border ${styles.borderAccent} bg-card shadow-card hover-lift press-scale overflow-hidden`}>
      {/* Top accent bar */}
      {isColored && (
        <div className={`absolute top-0 left-0 right-0 h-0.5 ${styles.topBar} opacity-70`} />
      )}
      <div className="p-4">
        <div className="flex items-start justify-between gap-3">
          <div className="min-w-0 flex-1">
            <p className="text-[10px] font-medium text-muted-foreground uppercase tracking-widest mb-2 truncate">{title}</p>
            <p className="text-2xl font-bold text-foreground truncate animate-count leading-none">{value}</p>
            {subtitle && (
              <p className="text-[10px] text-muted-foreground mt-1.5 truncate">{subtitle}</p>
            )}
            {trend && (
              <div className={`flex items-center gap-0.5 mt-1.5 text-[10px] font-medium ${trend.value >= 0 ? "text-accent" : "text-destructive"}`}>
                <span>{trend.value >= 0 ? "↑" : "↓"} {Math.abs(trend.value)}%</span>
                {trend.label && <span className="text-muted-foreground font-normal ml-0.5">{trend.label}</span>}
              </div>
            )}
          </div>
          <div className={`p-2 rounded-lg shrink-0 ${isColored ? styles.iconBg : "bg-muted/70"}`}>
            <Icon className={`h-4 w-4 ${isColored ? styles.iconColor : "text-muted-foreground"}`} />
          </div>
        </div>
      </div>
    </div>
  );
}
