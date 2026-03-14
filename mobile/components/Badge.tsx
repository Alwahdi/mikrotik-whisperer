import React from "react";
import { View, Text, StyleSheet, ViewStyle } from "react-native";
import { Colors, Radius, Spacing } from "@/lib/theme";

interface BadgeProps {
  label: string;
  variant?: "default" | "success" | "warning" | "destructive" | "primary";
  style?: ViewStyle;
}

const variantMap = {
  default: {
    bg: Colors.muted,
    fg: Colors.textSecondary,
  },
  success: {
    bg: Colors.successBg,
    fg: Colors.success,
  },
  warning: {
    bg: Colors.warningBg,
    fg: Colors.warning,
  },
  destructive: {
    bg: Colors.destructiveBg,
    fg: Colors.destructive,
  },
  primary: {
    bg: "rgba(124,58,237,0.12)",
    fg: Colors.primaryLight,
  },
};

export default function Badge({
  label,
  variant = "default",
  style,
}: BadgeProps) {
  const vs = variantMap[variant];
  return (
    <View
      style={[
        styles.badge,
        { backgroundColor: vs.bg },
        style,
      ]}
    >
      <Text style={[styles.text, { color: vs.fg }]}>{label}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  badge: {
    paddingHorizontal: 8,
    paddingVertical: 3,
    borderRadius: Radius.full,
    alignSelf: "flex-start",
  },
  text: {
    fontSize: 10,
    fontWeight: "600",
  },
});
