import React from 'react';
import {
  Modal,
  View,
  Text,
  TouchableOpacity,
  StyleSheet,
  KeyboardAvoidingView,
  Platform,
  ScrollView,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { colors, radius, spacing, typography } from '@/lib/theme';

interface BottomSheetProps {
  visible: boolean;
  onClose: () => void;
  title?: string;
  children: React.ReactNode;
  snapHeight?: 'half' | 'tall' | 'auto';
}

export function BottomSheet({
  visible,
  onClose,
  title,
  children,
  snapHeight = 'auto',
}: BottomSheetProps) {
  const insets = useSafeAreaInsets();

  return (
    <Modal
      visible={visible}
      transparent
      animationType="slide"
      onRequestClose={onClose}
      statusBarTranslucent
    >
      <TouchableOpacity style={styles.backdrop} activeOpacity={1} onPress={onClose} />
      <KeyboardAvoidingView
        behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
        style={styles.kavWrapper}
        pointerEvents="box-none"
      >
        <View
          style={[
            styles.sheet,
            snapHeight === 'tall' && styles.sheetTall,
            { paddingBottom: insets.bottom + spacing.lg },
          ]}
        >
          <View style={styles.handle} />
          {title && (
            <View style={styles.header}>
              <Text style={styles.title}>{title}</Text>
              <TouchableOpacity onPress={onClose} style={styles.closeBtn}>
                <Text style={styles.closeText}>✕</Text>
              </TouchableOpacity>
            </View>
          )}
          <ScrollView
            contentContainerStyle={styles.content}
            keyboardShouldPersistTaps="handled"
            showsVerticalScrollIndicator={false}
          >
            {children}
          </ScrollView>
        </View>
      </KeyboardAvoidingView>
    </Modal>
  );
}

const styles = StyleSheet.create({
  backdrop: {
    ...StyleSheet.absoluteFillObject,
    backgroundColor: 'rgba(0,0,0,0.6)',
  },
  kavWrapper: {
    flex: 1,
    justifyContent: 'flex-end',
  },
  sheet: {
    backgroundColor: colors.surface,
    borderTopLeftRadius: radius.xl,
    borderTopRightRadius: radius.xl,
    borderWidth: 1,
    borderBottomWidth: 0,
    borderColor: colors.border,
    maxHeight: '90%',
  },
  sheetTall: {
    maxHeight: '90%',
    minHeight: '60%',
  },
  handle: {
    width: 40,
    height: 4,
    backgroundColor: colors.surface2,
    borderRadius: radius.full,
    alignSelf: 'center',
    marginTop: spacing.md,
    marginBottom: spacing.sm,
  },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingHorizontal: spacing.lg,
    paddingBottom: spacing.md,
    borderBottomWidth: 1,
    borderBottomColor: colors.border,
    marginBottom: spacing.sm,
  },
  title: {
    color: colors.text,
    fontSize: typography.fontSizeLg,
    fontWeight: typography.fontWeightSemiBold,
  },
  closeBtn: {
    padding: spacing.xs,
  },
  closeText: {
    color: colors.textMuted,
    fontSize: typography.fontSizeMd,
  },
  content: {
    padding: spacing.lg,
    gap: spacing.md,
  },
});
