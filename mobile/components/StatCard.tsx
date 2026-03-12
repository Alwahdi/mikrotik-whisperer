import React from "react";
import {
  View,
  Text,
  StyleSheet,
  ViewStyle,
} from "react-native";
import { Colors, Radius, Spacing } from "@/lib/theme";

type Variant = "default" | "primary" | "accent" | "warning" | "success";

interface StatCardProps {
  title: string;
  value: string | number;
  subtitle?: string;
  variant?: Variant;
  style?: ViewStyle;
}

const variantStyles: Record<
  Variant,
  { bg: string; border: string; valueFg: string }
> = {
  default: {
    bg: Colors.card,
    border: Colors.cardBorder,
    valueFg: Colors.foreground,
  },
  primary: {
    bg: "rgba(124,58,237,0.08)",
    border: "rgba(124,58,237,0.25)",
    valueFg: Colors.primaryLight,
  },
  accent: {
    bg: "rgba(16,185,129,0.08)",
    border: "rgba(16,185,129,0.25)",
    valueFg: "#10b981",
  },
  warning: {
    bg: Colors.warningBg,
    border: "rgba(245,158,11,0.25)",
    valueFg: Colors.warning,
  },
  success: {
    bg: Colors.successBg,
    border: "rgba(34,197,94,0.25)",
    valueFg: Colors.success,
  },
};

export default function StatCard({
  title,
  value,
  subtitle,
  variant = "default",
  style,
}: StatCardProps) {
  const vs = variantStyles[variant];

  return (
    <View
      style={[
        styles.card,
        { backgroundColor: vs.bg, borderColor: vs.border },
        style,
      ]}
    >
      <Text style={styles.title}>{title}</Text>
      <Text style={[styles.value, { color: vs.valueFg }]}>
        {value}
      </Text>
      {subtitle ? (
        <Text style={styles.subtitle}>{subtitle}</Text>
      ) : null}
    </View>
  );
}

const styles = StyleSheet.create({
  card: {
    borderRadius: Radius.md,
    borderWidth: 1,
    padding: Spacing.md,
    flex: 1,
  },
  title: {
    fontSize: 10,
    color: Colors.textSecondary,
    marginBottom: 4,
    textAlign: "right",
  },
  value: {
    fontSize: 20,
    fontWeight: "700",
    textAlign: "right",
  },
  subtitle: {
    fontSize: 10,
    color: Colors.mutedFg,
    marginTop: 2,
    textAlign: "right",
  },
});
