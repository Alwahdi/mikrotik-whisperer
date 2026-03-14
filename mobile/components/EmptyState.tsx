import React from "react";
import { View, Text, StyleSheet } from "react-native";
import { Colors, Spacing } from "@/lib/theme";

interface Props {
  title: string;
  subtitle?: string;
  icon?: React.ReactNode;
}

export default function EmptyState({ title, subtitle, icon }: Props) {
  return (
    <View style={styles.container}>
      {icon ? <View style={styles.iconWrapper}>{icon}</View> : null}
      <Text style={styles.title}>{title}</Text>
      {subtitle ? <Text style={styles.subtitle}>{subtitle}</Text> : null}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
    paddingVertical: 60,
    paddingHorizontal: Spacing.xl,
  },
  iconWrapper: { marginBottom: 16, opacity: 0.4 },
  title: {
    fontSize: 16,
    fontWeight: "700",
    color: Colors.foreground,
    textAlign: "center",
    marginBottom: 6,
  },
  subtitle: {
    fontSize: 13,
    color: Colors.textSecondary,
    textAlign: "center",
    lineHeight: 20,
  },
});
