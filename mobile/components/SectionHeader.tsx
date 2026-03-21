import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import { colors, spacing, typography } from '@/lib/theme';

interface SectionHeaderProps {
  title: string;
  subtitle?: string;
  right?: React.ReactNode;
}

export function SectionHeader({ title, subtitle, right }: SectionHeaderProps) {
  return (
    <View style={styles.container}>
      <View style={styles.left}>
        <Text style={styles.title}>{title}</Text>
        {subtitle && <Text style={styles.subtitle}>{subtitle}</Text>}
      </View>
      {right && <View>{right}</View>}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginBottom: spacing.md,
  },
  left: {
    flex: 1,
    gap: 2,
  },
  title: {
    color: colors.text,
    fontSize: typography.fontSizeMd,
    fontWeight: typography.fontWeightSemiBold,
  },
  subtitle: {
    color: colors.textMuted,
    fontSize: typography.fontSizeXs,
  },
});
