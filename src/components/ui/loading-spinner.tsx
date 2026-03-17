import { cn } from "@/lib/utils";
import { Loader2 } from "lucide-react";

interface LoadingSpinnerProps {
  size?: "sm" | "md" | "lg";
  variant?: "default" | "primary" | "success" | "warning";
  text?: string;
  className?: string;
}

const sizeClasses = {
  sm: "h-4 w-4",
  md: "h-8 w-8",
  lg: "h-12 w-12",
};

const variantClasses = {
  default: "text-muted-foreground",
  primary: "text-primary",
  success: "text-success",
  warning: "text-warning",
};

export function LoadingSpinner({
  size = "md",
  variant = "default",
  text,
  className,
}: LoadingSpinnerProps) {
  return (
    <div className={cn("flex flex-col items-center justify-center gap-3", className)}>
      <Loader2
        className={cn(
          "animate-spin",
          sizeClasses[size],
          variantClasses[variant]
        )}
      />
      {text && (
        <p className="text-sm text-muted-foreground animate-pulse">{text}</p>
      )}
    </div>
  );
}

export function LoadingView({
  text = "Loading...",
  variant = "default",
}: {
  text?: string;
  variant?: "default" | "primary" | "success" | "warning";
}) {
  return (
    <div className="flex items-center justify-center min-h-[400px] w-full animate-fade-in">
      <LoadingSpinner size="lg" variant={variant} text={text} />
    </div>
  );
}
