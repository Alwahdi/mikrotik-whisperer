import * as React from "react";
import { LucideIcon } from "lucide-react";
import { cn } from "@/lib/utils";
import { Card } from "./card";

interface DataPoint {
  label: string;
  value: string | number;
  icon?: LucideIcon;
  trend?: {
    value: number;
    isPositive: boolean;
  };
}

interface DataCardProps extends React.HTMLAttributes<HTMLDivElement> {
  title: string;
  subtitle?: string;
  data: DataPoint[];
  variant?: "default" | "elevated" | "interactive" | "glass" | "outline";
  layout?: "grid" | "list";
  headerAction?: React.ReactNode;
}

export const DataCard = React.forwardRef<HTMLDivElement, DataCardProps>(
  (
    {
      className,
      title,
      subtitle,
      data,
      variant = "default",
      layout = "grid",
      headerAction,
      ...props
    },
    ref
  ) => {
    return (
      <Card
        ref={ref}
        variant={variant}
        className={cn("p-6", className)}
        {...props}
      >
        {/* Header */}
        <div className="flex items-start justify-between mb-6">
          <div>
            <h3 className="text-lg font-semibold text-foreground mb-1">
              {title}
            </h3>
            {subtitle && (
              <p className="text-sm text-muted-foreground">{subtitle}</p>
            )}
          </div>
          {headerAction && <div>{headerAction}</div>}
        </div>

        {/* Data Points */}
        <div
          className={cn(
            layout === "grid"
              ? "grid grid-cols-2 gap-4"
              : "flex flex-col gap-3"
          )}
        >
          {data.map((point, index) => (
            <div
              key={index}
              className={cn(
                "flex items-start gap-3 p-3 rounded-lg bg-muted/30 transition-colors hover:bg-muted/50",
                layout === "list" && "border-l-2 border-primary/20 hover:border-primary/50"
              )}
            >
              {point.icon && (
                <div className="p-2 rounded-md bg-background/80">
                  <point.icon className="h-4 w-4 text-muted-foreground" />
                </div>
              )}
              <div className="flex-1 min-w-0">
                <p className="text-xs font-medium text-muted-foreground mb-1">
                  {point.label}
                </p>
                <div className="flex items-baseline gap-2">
                  <p className="text-lg font-bold text-foreground">
                    {point.value}
                  </p>
                  {point.trend && (
                    <span
                      className={cn(
                        "text-xs font-medium",
                        point.trend.isPositive ? "text-success" : "text-destructive"
                      )}
                    >
                      {point.trend.isPositive ? "↑" : "↓"}{" "}
                      {Math.abs(point.trend.value)}%
                    </span>
                  )}
                </div>
              </div>
            </div>
          ))}
        </div>
      </Card>
    );
  }
);

DataCard.displayName = "DataCard";
