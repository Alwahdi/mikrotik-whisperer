import { View, ViewProps } from "react-native";
import { cn } from "../lib/utils";

interface CardProps extends ViewProps {
  variant?: "default" | "elevated" | "glass";
}

export function Card({ variant = "default", className, ...props }: CardProps) {
  return (
    <View
      className={cn(
        "rounded-xl p-4",
        variant === "default" && "bg-background-light",
        variant === "elevated" && "bg-background-light shadow-lg",
        variant === "glass" && "bg-background-light/50 backdrop-blur-lg",
        className
      )}
      {...props}
    />
  );
}
