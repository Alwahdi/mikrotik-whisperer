import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import { colors, radius, spacing, typography } from '@/lib/theme';

type BadgeVariant = 'success' | 'warning' | 'error' | 'info' | 'default' | 'muted';

interface BadgeProps {
  label: string;
  variant?: BadgeVariant;
  size?: 'sm' | 'md';
}

const variantColors: Record<BadgeVariant, { bg: string; text: string }> = {
  success: { bg: colors.successBg, text: colors.success },
  warning: { bg: colors.warningBg, text: colors.warning },
  error: { bg: colors.errorBg, text: colors.error },
  info: { bg: colors.infoBg, text: colors.info },
  default: { bg: colors.surface2, text: colors.text },
  muted: { bg: colors.surface, text: colors.textMuted },
};

export function Badge({ label, variant = 'default', size = 'sm' }: BadgeProps) {
  const { bg, text } = variantColors[variant];
  return (
    <View style={[styles.base, { backgroundColor: bg }, size === 'md' && styles.md]}>
      <Text style={[styles.label, { color: text }, size === 'md' && styles.labelMd]}>
        {label}
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  base: {
    borderRadius: radius.full,
    paddingVertical: 2,
    paddingHorizontal: spacing.sm,
    alignSelf: 'flex-start',
  },
  md: {
    paddingVertical: spacing.xs,
    paddingHorizontal: spacing.md,
  },
  label: {
    fontSize: typography.fontSizeXs,
    fontWeight: typography.fontWeightSemiBold,
  },
  labelMd: {
    fontSize: typography.fontSizeSm,
  },
});
