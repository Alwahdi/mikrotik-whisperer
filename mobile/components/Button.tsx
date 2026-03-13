import React from "react";
import {
  Text,
  StyleSheet,
  ActivityIndicator,
  ViewStyle,
  TextStyle,
} from "react-native";
import { LinearGradient } from "expo-linear-gradient";
import AnimatedPressable from "@/components/AnimatedPressable";
import { Colors, Radius } from "@/lib/theme";

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

  const containerStyle = [styles.base, styles[size], isDisabled && styles.disabled, style] as ViewStyle[];

  const tStyle = [styles.text, styles[`text_${size}` as keyof typeof styles], styles[`text_${variant}` as keyof typeof styles], textStyle] as TextStyle[];

  if (variant === "primary") {
    return (
      <AnimatedPressable
        onPress={onPress}
        disabled={isDisabled}
        style={[styles.base, styles[size], isDisabled ? styles.disabled : undefined, { overflow: "hidden" }, style ?? undefined] as ViewStyle[]}
      >
        <LinearGradient
          colors={[Colors.gradientStart, Colors.gradientEnd]}
          start={{ x: 0, y: 0 }}
          end={{ x: 1, y: 0 }}
          style={StyleSheet.absoluteFill}
        />
        {loading ? (
          <ActivityIndicator size="small" color="#fff" />
        ) : (
          <>
            {icon}
            <Text style={[styles.text, styles[`text_${size}` as keyof typeof styles], { color: "#fff" }, textStyle]}>
              {label}
            </Text>
          </>
        )}
      </AnimatedPressable>
    );
  }

  const variantStyle: Record<string, ViewStyle> = {
    outline: { backgroundColor: "transparent", borderWidth: 1, borderColor: Colors.border },
    destructive: { backgroundColor: Colors.destructiveBg, borderWidth: 1, borderColor: Colors.destructiveBorder },
    ghost: { backgroundColor: "transparent" },
  };

  return (
    <AnimatedPressable
      onPress={onPress}
      disabled={isDisabled}
      style={[...containerStyle, variantStyle[variant] ?? {}]}
    >
      {loading ? (
        <ActivityIndicator size="small" color={Colors.primary} />
      ) : (
        <>
          {icon}
          <Text style={tStyle}>{label}</Text>
        </>
      )}
    </AnimatedPressable>
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
  sm: { paddingVertical: 6, paddingHorizontal: 12 },
  md: { paddingVertical: 10, paddingHorizontal: 18 },
  lg: { paddingVertical: 14, paddingHorizontal: 24 },
  disabled: { opacity: 0.5 },
  text: { fontWeight: "600", textAlign: "center" },
  text_sm: { fontSize: 12 },
  text_md: { fontSize: 14 },
  text_lg: { fontSize: 16 },
  text_primary: { color: "#fff" },
  text_outline: { color: Colors.foreground },
  text_destructive: { color: Colors.destructive },
  text_ghost: { color: Colors.textSecondary },
});
