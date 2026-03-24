import { Text, TouchableOpacity, TouchableOpacityProps, ActivityIndicator } from "react-native";
import { cn } from "../lib/utils";

interface ButtonProps extends TouchableOpacityProps {
  variant?: "default" | "outline" | "ghost";
  size?: "sm" | "md" | "lg";
  loading?: boolean;
  children: React.ReactNode;
}

export function Button({
  variant = "default",
  size = "md",
  loading = false,
  disabled,
  className,
  children,
  ...props
}: ButtonProps) {
  const isDisabled = disabled || loading;

  return (
    <TouchableOpacity
      disabled={isDisabled}
      className={cn(
        "items-center justify-center rounded-lg",
        // Variants
        variant === "default" && "bg-primary-500",
        variant === "outline" && "border-2 border-primary-500",
        variant === "ghost" && "bg-transparent",
        // Sizes
        size === "sm" && "px-3 py-2",
        size === "md" && "px-4 py-3",
        size === "lg" && "px-6 py-4",
        // States
        isDisabled && "opacity-50",
        className
      )}
      {...props}
    >
      {loading ? (
        <ActivityIndicator color={variant === "default" ? "white" : "#3b82f6"} />
      ) : (
        <Text
          className={cn(
            "font-semibold",
            variant === "default" && "text-white",
            variant === "outline" && "text-primary-500",
            variant === "ghost" && "text-white",
            size === "sm" && "text-sm",
            size === "md" && "text-base",
            size === "lg" && "text-lg"
          )}
        >
          {children}
        </Text>
      )}
    </TouchableOpacity>
  );
}
