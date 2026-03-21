import React from 'react';
import { Text, TextProps, StyleSheet } from 'react-native';
import { colors, typography } from '@/lib/theme';

interface StyledTextProps extends TextProps {
  variant?: 'default' | 'muted' | 'secondary' | 'heading' | 'title' | 'caption';
  weight?: 'normal' | 'medium' | 'semibold' | 'bold';
}

export function StyledText({
  variant = 'default',
  weight = 'normal',
  style,
  ...props
}: StyledTextProps) {
  return (
    <Text
      style={[
        styles.base,
        styles[variant],
        weight !== 'normal' && styles[`weight_${weight}`],
        style,
      ]}
      {...props}
    />
  );
}

const styles = StyleSheet.create({
  base: {
    color: colors.text,
    fontSize: typography.fontSizeMd,
  },
  default: {
    color: colors.text,
  },
  muted: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
  },
  secondary: {
    color: colors.textSecondary,
  },
  heading: {
    color: colors.text,
    fontSize: typography.fontSizeXl,
    fontWeight: typography.fontWeightBold,
  },
  title: {
    color: colors.text,
    fontSize: typography.fontSizeLg,
    fontWeight: typography.fontWeightSemiBold,
  },
  caption: {
    color: colors.textMuted,
    fontSize: typography.fontSizeXs,
  },
  weight_medium: { fontWeight: typography.fontWeightMedium },
  weight_semibold: { fontWeight: typography.fontWeightSemiBold },
  weight_bold: { fontWeight: typography.fontWeightBold },
});
