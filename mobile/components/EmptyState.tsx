import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import { colors, spacing, typography } from '@/lib/theme';

interface EmptyStateProps {
  title: string;
  description?: string;
  icon?: React.ReactNode;
}

export function EmptyState({ title, description, icon }: EmptyStateProps) {
  return (
    <View style={styles.container}>
      {icon && <View style={styles.icon}>{icon}</View>}
      <Text style={styles.title}>{title}</Text>
      {description && <Text style={styles.description}>{description}</Text>}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    justifyContent: 'center',
    padding: spacing.xxxl,
    gap: spacing.sm,
  },
  icon: {
    marginBottom: spacing.sm,
    opacity: 0.5,
  },
  title: {
    color: colors.textMuted,
    fontSize: typography.fontSizeMd,
    fontWeight: typography.fontWeightSemiBold,
    textAlign: 'center',
  },
  description: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
    textAlign: 'center',
    opacity: 0.8,
  },
});
