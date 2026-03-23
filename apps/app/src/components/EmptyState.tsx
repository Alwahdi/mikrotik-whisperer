import { LucideIcon } from "lucide-react";
import { Button } from "@repo/design-system/components/ui/button";

interface EmptyStateProps {
  icon: LucideIcon;
  title: string;
  description: string;
  actionLabel?: string;
  onAction?: () => void;
}

export default function EmptyState({ icon: Icon, title, description, actionLabel, onAction }: EmptyStateProps) {
  return (
    <div className="flex flex-col items-center justify-center py-16 sm:py-20 px-4 text-center animate-fade-in-up">
      <div className="relative mb-6">
        <div className="absolute inset-0 rounded-2xl bg-primary/5 blur-xl scale-150" />
        <div className="relative p-5 rounded-2xl bg-muted/50 border border-border">
          <Icon className="h-8 w-8 text-muted-foreground" />
        </div>
      </div>
      <h3 className="text-base font-semibold text-foreground mb-2">{title}</h3>
      <p className="text-sm text-muted-foreground max-w-sm leading-relaxed mb-6">{description}</p>
      {actionLabel && onAction && (
        <Button onClick={onAction} size="sm" className="press-scale">
          {actionLabel}
        </Button>
      )}
    </div>
  );
}
