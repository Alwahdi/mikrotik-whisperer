import { LucideIcon } from "lucide-react";
import { Card, CardContent } from "@repo/design-system/components/ui/card";
import { cn } from "@repo/design-system";

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
    iconBg: "bg-muted/50",
    border: "",
  },
  primary: {
    icon: "text-primary",
    iconBg: "bg-primary/10",
    border: "border-primary/10",
  },
  accent: {
    icon: "text-success",
    iconBg: "bg-success/10",
    border: "border-success/10",
  },
  warning: {
    icon: "text-warning",
    iconBg: "bg-warning/10",
    border: "border-warning/10",
  },
};

export default function StatCard({ title, value, subtitle, icon: Icon, variant = "default" }: StatCardProps) {
  const styles = variantStyles[variant];
  return (
    <Card className={cn("transition-all duration-200 hover:-translate-y-0.5", styles.border)}>
      <CardContent className="p-4">
        <div className="flex items-start justify-between">
          <div className="min-w-0 flex-1">
            <p className="text-[11px] text-muted-foreground mb-1.5 font-medium">{title}</p>
            <p className="text-xl font-bold text-foreground truncate tabular-nums">{value}</p>
            {subtitle && <p className="text-[10px] text-muted-foreground mt-1">{subtitle}</p>}
          </div>
          <div className={cn("p-2 rounded-lg shrink-0", styles.iconBg)}>
            <Icon className={cn("h-4 w-4", styles.icon)} />
          </div>
        </div>
      </CardContent>
    </Card>
  );
}
