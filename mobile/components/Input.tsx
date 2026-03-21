import React, { forwardRef } from 'react';
import {
  TextInput,
  TextInputProps,
  View,
  Text,
  StyleSheet,
} from 'react-native';
import { colors, radius, spacing, typography } from '@/lib/theme';

interface InputProps extends TextInputProps {
  label?: string;
  error?: string;
  leftIcon?: React.ReactNode;
  rightIcon?: React.ReactNode;
}

export const Input = forwardRef<TextInput, InputProps>(
  ({ label, error, leftIcon, rightIcon, style, ...props }, ref) => {
    return (
      <View style={styles.container}>
        {label && <Text style={styles.label}>{label}</Text>}
        <View style={[styles.inputWrapper, error ? styles.inputError : undefined]}>
          {leftIcon && <View style={styles.icon}>{leftIcon}</View>}
          <TextInput
            ref={ref}
            style={[styles.input, leftIcon ? styles.inputWithLeft : undefined, style]}
            placeholderTextColor={colors.textMuted}
            {...props}
          />
          {rightIcon && <View style={styles.iconRight}>{rightIcon}</View>}
        </View>
        {error && <Text style={styles.errorText}>{error}</Text>}
      </View>
    );
  }
);

Input.displayName = 'Input';

const styles = StyleSheet.create({
  container: {
    gap: spacing.xs,
  },
  label: {
    color: colors.textSecondary,
    fontSize: typography.fontSizeSm,
    fontWeight: typography.fontWeightMedium,
  },
  inputWrapper: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: colors.surface2,
    borderRadius: radius.md,
    borderWidth: 1,
    borderColor: colors.border,
    minHeight: 44,
  },
  inputError: {
    borderColor: colors.error,
  },
  icon: {
    paddingLeft: spacing.md,
    paddingRight: spacing.xs,
  },
  iconRight: {
    paddingRight: spacing.md,
    paddingLeft: spacing.xs,
  },
  input: {
    flex: 1,
    color: colors.text,
    fontSize: typography.fontSizeMd,
    paddingHorizontal: spacing.md,
    paddingVertical: spacing.sm,
  },
  inputWithLeft: {
    paddingLeft: spacing.xs,
  },
  errorText: {
    color: colors.error,
    fontSize: typography.fontSizeXs,
  },
});
