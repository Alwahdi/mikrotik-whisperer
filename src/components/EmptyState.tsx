import { LucideIcon } from "lucide-react";
import { Button } from "@/components/ui/button";

interface EmptyStateProps {
  icon: LucideIcon;
  title: string;
  description: string;
  actionLabel?: string;
  onAction?: () => void;
}

export default function EmptyState({ icon: Icon, title, description, actionLabel, onAction }: EmptyStateProps) {
  return (
    <div className="flex flex-col items-center justify-center py-16 px-4 text-center animate-fade-in-up">
      <div className="relative mb-6">
        <div className="absolute inset-0 rounded-3xl bg-primary/8 blur-2xl scale-150" />
        <div className="relative p-5 rounded-2xl bg-gradient-to-br from-muted to-secondary/50 border border-border/70 shadow-sm">
          <Icon className="h-8 w-8 text-muted-foreground" />
        </div>
      </div>
      <h3 className="text-base font-bold text-foreground mb-2 tracking-tight">{title}</h3>
      <p className="text-sm text-muted-foreground max-w-xs leading-relaxed mb-6">{description}</p>
      {actionLabel && onAction && (
        <Button onClick={onAction} size="sm" className="press-scale shadow-sm">
          {actionLabel}
        </Button>
      )}
    </div>
  );
}
