import React, { useEffect } from "react";
import { Text, StyleSheet, ViewStyle } from "react-native";
import Animated, {
  useSharedValue,
  useAnimatedStyle,
  withSpring,
  withDelay,
} from "react-native-reanimated";
import { Colors, Radius, Spacing } from "@/lib/theme";

type Variant = "default" | "primary" | "accent" | "warning" | "success";

interface StatCardProps {
  title: string;
  value: string | number;
  subtitle?: string;
  variant?: Variant;
  style?: ViewStyle;
  delay?: number;
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
    border: Colors.warningBorder,
    valueFg: Colors.warning,
  },
  success: {
    bg: Colors.successBg,
    border: Colors.successBorder,
    valueFg: Colors.success,
  },
};

const SPRING_CFG = { damping: 20, stiffness: 200 } as const;

export default function StatCard({
  title,
  value,
  subtitle,
  variant = "default",
  style,
  delay = 0,
}: StatCardProps) {
  const vs = variantStyles[variant];
  const opacity = useSharedValue(0);
  const translateY = useSharedValue(12);

  useEffect(() => {
    opacity.value = withDelay(delay, withSpring(1, SPRING_CFG));
    translateY.value = withDelay(delay, withSpring(0, SPRING_CFG));
  }, []);

  const animStyle = useAnimatedStyle(() => ({
    opacity: opacity.value,
    transform: [{ translateY: translateY.value }],
  }));

  return (
    <Animated.View
      style={[
        styles.card,
        { backgroundColor: vs.bg, borderColor: vs.border },
        animStyle,
        style,
      ]}
    >
      <Text style={styles.title}>{title}</Text>
      <Text style={[styles.value, { color: vs.valueFg }]}>{value}</Text>
      {subtitle ? <Text style={styles.subtitle}>{subtitle}</Text> : null}
    </Animated.View>
  );
}

const styles = StyleSheet.create({
  card: {
    borderRadius: Radius.md,
    borderWidth: 1,
    padding: Spacing.md,
    flex: 1,
    gap: 2,
  },
  title: {
    fontSize: 10,
    color: Colors.textSecondary,
    marginBottom: 2,
    textAlign: "right",
    fontWeight: "500",
  },
  value: {
    fontSize: 22,
    fontWeight: "700",
    textAlign: "right",
    letterSpacing: -0.5,
  },
  subtitle: {
    fontSize: 10,
    color: Colors.mutedFg,
    marginTop: 1,
    textAlign: "right",
  },
});
