import * as React from "react";
import { cva, type VariantProps } from "class-variance-authority";

import { cn } from "@/lib/utils";

const inputVariants = cva(
  "flex h-10 w-full rounded-md border bg-background px-3 py-2 text-base transition-all ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground placeholder:text-muted-foreground focus-visible:outline-none disabled:cursor-not-allowed disabled:opacity-50 md:text-sm",
  {
    variants: {
      variant: {
        default:
          "border-input focus-visible:border-input-focus focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2",
        error:
          "border-destructive focus-visible:border-destructive focus-visible:ring-2 focus-visible:ring-destructive focus-visible:ring-offset-2",
        success:
          "border-success focus-visible:border-success focus-visible:ring-2 focus-visible:ring-success focus-visible:ring-offset-2",
      },
    },
    defaultVariants: {
      variant: "default",
    },
  }
);

export interface InputProps
  extends React.ComponentProps<"input">,
    VariantProps<typeof inputVariants> {}

const Input = React.forwardRef<HTMLInputElement, InputProps>(
  ({ className, type, variant, ...props }, ref) => {
    return (
      <input
        type={type}
        className={cn(inputVariants({ variant }), className)}
        ref={ref}
        {...props}
      />
    );
  }
);
Input.displayName = "Input";

export { Input, inputVariants };
