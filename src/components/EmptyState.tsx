import { LucideIcon } from "lucide-react";
import { Button } from "@/components/ui/button";
import { cn } from "@/lib/utils";

interface EmptyStateProps {
  icon: LucideIcon;
  title: string;
  description: string;
  actionLabel?: string;
  onAction?: () => void;
  variant?: "default" | "compact" | "error";
  className?: string;
}

export default function EmptyState({
  icon: Icon,
  title,
  description,
  actionLabel,
  onAction,
  variant = "default",
  className,
}: EmptyStateProps) {
  const isCompact = variant === "compact";
  const isError = variant === "error";

  return (
    <div
      className={cn(
        "flex flex-col items-center justify-center text-center animate-fade-in",
        isCompact ? "py-8 px-4" : "py-16 px-4",
        className
      )}
    >
      <div className="relative mb-6">
        {/* Glow effect */}
        <div
          className={cn(
            "absolute inset-0 rounded-2xl blur-xl scale-150",
            isError ? "bg-destructive/10" : "bg-primary/10"
          )}
        />
        {/* Icon container */}
        <div
          className={cn(
            "relative rounded-2xl border transition-all",
            isCompact ? "p-4" : "p-6",
            isError
              ? "bg-destructive/5 border-destructive/20"
              : "bg-muted/50 border-border"
          )}
        >
          <Icon
            className={cn(
              isCompact ? "h-8 w-8" : "h-10 w-10",
              isError ? "text-destructive" : "text-muted-foreground"
            )}
          />
        </div>
      </div>

      {/* Content */}
      <h3
        className={cn(
          "font-bold text-foreground mb-2",
          isCompact ? "text-base" : "text-lg"
        )}
      >
        {title}
      </h3>
      <p
        className={cn(
          "text-muted-foreground max-w-sm leading-relaxed",
          isCompact ? "text-sm mb-4" : "text-sm mb-6"
        )}
      >
        {description}
      </p>

      {/* Action button */}
      {actionLabel && onAction && (
        <Button
          onClick={onAction}
          size={isCompact ? "sm" : "default"}
          variant={isError ? "destructive" : "default"}
          className="transition-all hover:scale-105"
        >
          {actionLabel}
        </Button>
      )}
    </div>
  );
}
