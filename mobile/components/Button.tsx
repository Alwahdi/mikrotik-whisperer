import React from 'react';
import {
  TouchableOpacity,
  TouchableOpacityProps,
  Text,
  StyleSheet,
  ActivityIndicator,
  View,
} from 'react-native';
import { colors, radius, spacing, typography } from '@/lib/theme';

interface ButtonProps extends TouchableOpacityProps {
  variant?: 'primary' | 'secondary' | 'danger' | 'ghost' | 'success';
  size?: 'sm' | 'md' | 'lg';
  loading?: boolean;
  label: string;
  icon?: React.ReactNode;
}

export function Button({
  variant = 'primary',
  size = 'md',
  loading = false,
  label,
  icon,
  style,
  disabled,
  ...props
}: ButtonProps) {
  return (
    <TouchableOpacity
      style={[
        styles.base,
        styles[variant],
        styles[`size_${size}`],
        (disabled || loading) && styles.disabled,
        style,
      ]}
      disabled={disabled || loading}
      activeOpacity={0.75}
      {...props}
    >
      {loading ? (
        <ActivityIndicator
          size="small"
          color={variant === 'ghost' ? colors.primary : colors.text}
        />
      ) : (
        <View style={styles.content}>
          {icon && <View style={styles.iconWrap}>{icon}</View>}
          <Text style={[styles.label, styles[`label_${variant}`], styles[`labelSize_${size}`]]}>
            {label}
          </Text>
        </View>
      )}
    </TouchableOpacity>
  );
}

const styles = StyleSheet.create({
  base: {
    borderRadius: radius.md,
    alignItems: 'center',
    justifyContent: 'center',
  },
  content: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: spacing.sm,
  },
  iconWrap: {
    marginRight: 2,
  },
  label: {
    fontWeight: typography.fontWeightSemiBold,
    color: colors.text,
  },
  // Variants
  primary: {
    backgroundColor: colors.primary,
  },
  secondary: {
    backgroundColor: colors.surface2,
    borderWidth: 1,
    borderColor: colors.border,
  },
  danger: {
    backgroundColor: colors.error,
  },
  ghost: {
    backgroundColor: 'transparent',
    borderWidth: 1,
    borderColor: colors.border,
  },
  success: {
    backgroundColor: colors.success,
  },
  disabled: {
    opacity: 0.5,
  },
  // Sizes
  size_sm: {
    paddingVertical: spacing.xs,
    paddingHorizontal: spacing.md,
    minHeight: 34,
  },
  size_md: {
    paddingVertical: spacing.sm + 2,
    paddingHorizontal: spacing.lg,
    minHeight: 44,
  },
  size_lg: {
    paddingVertical: spacing.md,
    paddingHorizontal: spacing.xl,
    minHeight: 52,
  },
  // Label colors
  label_primary: { color: colors.text },
  label_secondary: { color: colors.text },
  label_danger: { color: colors.text },
  label_ghost: { color: colors.textSecondary },
  label_success: { color: colors.text },
  // Label sizes
  labelSize_sm: { fontSize: typography.fontSizeSm },
  labelSize_md: { fontSize: typography.fontSizeMd },
  labelSize_lg: { fontSize: typography.fontSizeLg },
});
