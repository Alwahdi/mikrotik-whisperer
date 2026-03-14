import React from "react";
import {
  TextInput,
  Text,
  View,
  StyleSheet,
  TextInputProps,
} from "react-native";
import { Colors, Radius, Spacing } from "@/lib/theme";

interface InputProps extends TextInputProps {
  label?: string;
  error?: string;
}

export default function Input({ label, error, style, ...props }: InputProps) {
  return (
    <View style={styles.wrapper}>
      {label ? <Text style={styles.label}>{label}</Text> : null}
      <TextInput
        placeholderTextColor={Colors.mutedFg}
        style={[styles.input, error ? styles.inputError : {}, style]}
        {...props}
      />
      {error ? <Text style={styles.error}>{error}</Text> : null}
    </View>
  );
}

const styles = StyleSheet.create({
  wrapper: { gap: 5 },
  label: {
    fontSize: 12,
    fontWeight: "500",
    color: Colors.foreground,
    textAlign: "right",
  },
  input: {
    backgroundColor: Colors.muted,
    borderWidth: 1,
    borderColor: Colors.border,
    borderRadius: Radius.md,
    paddingHorizontal: Spacing.md,
    paddingVertical: Spacing.sm + 2,
    fontSize: 14,
    color: Colors.foreground,
    textAlign: "right",
  },
  inputError: { borderColor: Colors.destructive },
  error: { fontSize: 11, color: Colors.destructive, textAlign: "right" },
});
