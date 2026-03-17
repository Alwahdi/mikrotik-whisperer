import * as React from "react";
import { cva, type VariantProps } from "class-variance-authority";

import { cn } from "@/lib/utils";

const badgeVariants = cva(
  "inline-flex items-center rounded-full border px-2.5 py-0.5 text-xs font-medium transition-colors focus:outline-none focus:ring-2 focus:ring-ring focus:ring-offset-2",
  {
    variants: {
      variant: {
        default: "border-transparent bg-primary text-primary-foreground hover:bg-primary/85",
        secondary: "border-transparent bg-secondary text-secondary-foreground hover:bg-secondary/70",
        destructive: "border-transparent bg-destructive/12 text-destructive border-destructive/20 hover:bg-destructive/20",
        outline: "text-foreground border-border/70",
        success: "border-transparent bg-success/12 text-success border-success/20",
        warning: "border-transparent bg-warning/12 text-warning border-warning/20",
      },
    },
    defaultVariants: {
      variant: "default",
    },
  },
);

export interface BadgeProps extends React.HTMLAttributes<HTMLDivElement>, VariantProps<typeof badgeVariants> {}

function Badge({ className, variant, ...props }: BadgeProps) {
  return <div className={cn(badgeVariants({ variant }), className)} {...props} />;
}

export { Badge, badgeVariants };
