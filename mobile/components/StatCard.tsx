import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import { colors, radius, spacing, typography, shadows } from '@/lib/theme';

interface StatCardProps {
  label: string;
  value: string | number;
  unit?: string;
  color?: string;
  icon?: React.ReactNode;
  trend?: 'up' | 'down' | 'neutral';
}

export function StatCard({ label, value, unit, color = colors.primary, icon, trend }: StatCardProps) {
  return (
    <View style={styles.card}>
      <View style={styles.header}>
        {icon && <View style={[styles.iconWrapper, { backgroundColor: `${color}22` }]}>{icon}</View>}
        <Text style={styles.label}>{label}</Text>
      </View>
      <View style={styles.valueRow}>
        <Text style={[styles.value, { color }]}>{value}</Text>
        {unit && <Text style={styles.unit}>{unit}</Text>}
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  card: {
    backgroundColor: colors.surface,
    borderRadius: radius.lg,
    padding: spacing.lg,
    borderWidth: 1,
    borderColor: colors.border,
    flex: 1,
    ...shadows.sm,
  },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: spacing.sm,
    marginBottom: spacing.sm,
  },
  iconWrapper: {
    width: 32,
    height: 32,
    borderRadius: radius.md,
    alignItems: 'center',
    justifyContent: 'center',
  },
  label: {
    color: colors.textMuted,
    fontSize: typography.fontSizeXs,
    fontWeight: typography.fontWeightMedium,
    flex: 1,
  },
  valueRow: {
    flexDirection: 'row',
    alignItems: 'baseline',
    gap: spacing.xs,
  },
  value: {
    fontSize: typography.fontSize2xl,
    fontWeight: typography.fontWeightBold,
  },
  unit: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
  },
});
