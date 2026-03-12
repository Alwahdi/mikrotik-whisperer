import React from "react";
import {
  View,
  Text,
  TouchableOpacity,
  StyleSheet,
  ActivityIndicator,
  ViewStyle,
  TextStyle,
} from "react-native";
import { Colors, Radius, Spacing } from "@/lib/theme";

interface ButtonProps {
  onPress: () => void;
  label: string;
  loading?: boolean;
  disabled?: boolean;
  variant?: "primary" | "outline" | "destructive" | "ghost";
  size?: "sm" | "md" | "lg";
  style?: ViewStyle;
  textStyle?: TextStyle;
  icon?: React.ReactNode;
}

export default function Button({
  onPress,
  label,
  loading,
  disabled,
  variant = "primary",
  size = "md",
  style,
  textStyle,
  icon,
}: ButtonProps) {
  const isDisabled = disabled || loading;

  const containerStyle: ViewStyle[] = [
    styles.base,
    styles[size],
    styles[variant],
    isDisabled ? styles.disabled : {},
    style ?? {},
  ];

  const tStyle: TextStyle[] = [
    styles.text,
    styles[`text_${size}`] as TextStyle,
    styles[`text_${variant}`] as TextStyle,
    textStyle ?? {},
  ];

  return (
    <TouchableOpacity
      onPress={onPress}
      disabled={isDisabled}
      style={containerStyle}
      activeOpacity={0.75}
    >
      {loading ? (
        <ActivityIndicator
          size="small"
          color={variant === "primary" ? "#fff" : Colors.primary}
        />
      ) : (
        <>
          {icon}
          <Text style={tStyle}>{label}</Text>
        </>
      )}
    </TouchableOpacity>
  );
}

const styles = StyleSheet.create({
  base: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    gap: 6,
    borderRadius: Radius.md,
  },
  // Sizes
  sm: { paddingVertical: 6, paddingHorizontal: 12 },
  md: { paddingVertical: 10, paddingHorizontal: 18 },
  lg: { paddingVertical: 14, paddingHorizontal: 24 },
  // Variants
  primary: {
    backgroundColor: Colors.primary,
  },
  outline: {
    backgroundColor: "transparent",
    borderWidth: 1,
    borderColor: Colors.border,
  },
  destructive: {
    backgroundColor: Colors.destructiveBg,
    borderWidth: 1,
    borderColor: "rgba(239,68,68,0.3)",
  },
  ghost: {
    backgroundColor: "transparent",
  },
  disabled: { opacity: 0.5 },
  // Text
  text: { fontWeight: "600", textAlign: "center" },
  text_sm: { fontSize: 12 },
  text_md: { fontSize: 14 },
  text_lg: { fontSize: 16 },
  text_primary: { color: "#fff" },
  text_outline: { color: Colors.foreground },
  text_destructive: { color: Colors.destructive },
  text_ghost: { color: Colors.textSecondary },
});
