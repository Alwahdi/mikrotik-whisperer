import React from 'react';
import { View, ViewProps, StyleSheet } from 'react-native';
import { colors, radius, spacing, shadows } from '@/lib/theme';

interface CardProps extends ViewProps {
  variant?: 'default' | 'elevated' | 'outlined';
  padding?: keyof typeof spacing | number;
}

export function Card({ variant = 'default', padding = 'lg', style, children, ...props }: CardProps) {
  const paddingValue = typeof padding === 'number' ? padding : spacing[padding];
  return (
    <View
      style={[
        styles.base,
        variant === 'elevated' && styles.elevated,
        variant === 'outlined' && styles.outlined,
        { padding: paddingValue },
        style,
      ]}
      {...props}
    >
      {children}
    </View>
  );
}

const styles = StyleSheet.create({
  base: {
    backgroundColor: colors.surface,
    borderRadius: radius.lg,
    borderWidth: 1,
    borderColor: colors.border,
  },
  elevated: {
    ...shadows.md,
    borderWidth: 0,
  },
  outlined: {
    backgroundColor: 'transparent',
    borderColor: colors.borderLight,
  },
});
