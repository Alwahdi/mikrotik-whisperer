import * as React from "react";
import { LucideIcon } from "lucide-react";
import { cn } from "@/lib/utils";
import { Card } from "./card";
import { Button } from "./button";

interface ActionCardProps extends React.HTMLAttributes<HTMLDivElement> {
  title: string;
  description: string;
  icon?: LucideIcon;
  iconColor?: string;
  action?: {
    label: string;
    onClick: () => void;
    variant?: "default" | "outline" | "ghost";
  };
  footer?: React.ReactNode;
  variant?: "default" | "elevated" | "interactive" | "glass" | "outline";
}

export const ActionCard = React.forwardRef<HTMLDivElement, ActionCardProps>(
  (
    {
      className,
      title,
      description,
      icon: Icon,
      iconColor = "text-primary",
      action,
      footer,
      variant = "default",
      ...props
    },
    ref
  ) => {
    return (
      <Card
        ref={ref}
        variant={variant}
        className={cn("p-6 group", className)}
        {...props}
      >
        <div className="flex flex-col gap-4">
          {/* Header */}
          <div className="flex items-start gap-4">
            {Icon && (
              <div
                className={cn(
                  "p-3 rounded-lg bg-muted/50 transition-transform group-hover:scale-110",
                  iconColor
                )}
              >
                <Icon className="h-6 w-6" />
              </div>
            )}
            <div className="flex-1 min-w-0">
              <h3 className="text-lg font-semibold text-foreground mb-1.5">
                {title}
              </h3>
              <p className="text-sm text-muted-foreground leading-relaxed">
                {description}
              </p>
            </div>
          </div>

          {/* Action Button */}
          {action && (
            <div>
              <Button
                onClick={action.onClick}
                variant={action.variant || "default"}
                className="w-full sm:w-auto"
              >
                {action.label}
              </Button>
            </div>
          )}

          {/* Footer */}
          {footer && (
            <div className="pt-4 border-t border-border">{footer}</div>
          )}
        </div>
      </Card>
    );
  }
);

ActionCard.displayName = "ActionCard";
