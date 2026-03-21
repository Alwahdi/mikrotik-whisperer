import React from 'react';
import { View, ActivityIndicator, StyleSheet, Text } from 'react-native';
import { colors, spacing, typography } from '@/lib/theme';

interface LoadingSpinnerProps {
  size?: 'small' | 'large';
  message?: string;
  fullScreen?: boolean;
}

export function LoadingSpinner({ size = 'large', message, fullScreen = false }: LoadingSpinnerProps) {
  return (
    <View style={[styles.container, fullScreen && styles.fullScreen]}>
      <ActivityIndicator size={size} color={colors.primary} />
      {message && <Text style={styles.message}>{message}</Text>}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    justifyContent: 'center',
    padding: spacing.xl,
    gap: spacing.md,
  },
  fullScreen: {
    flex: 1,
    backgroundColor: colors.background,
  },
  message: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
    textAlign: 'center',
  },
});
