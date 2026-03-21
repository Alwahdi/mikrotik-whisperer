import React, { useState } from 'react';
import {
  View,
  Text,
  StyleSheet,
  KeyboardAvoidingView,
  Platform,
  ScrollView,
  TouchableOpacity,
  Alert,
} from 'react-native';
import { useRouter } from 'expo-router';
import { LinearGradient } from 'expo-linear-gradient';
import { Ionicons } from '@expo/vector-icons';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { useAuth } from '@/contexts/AuthContext';
import { Input } from '@/components/Input';
import { Button } from '@/components/Button';
import { colors, spacing, typography, radius } from '@/lib/theme';

export default function AuthScreen() {
  const [mode, setMode] = useState<'login' | 'signup'>('login');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [fullName, setFullName] = useState('');
  const [loading, setLoading] = useState(false);
  const { signIn, signUp } = useAuth();
  const router = useRouter();
  const insets = useSafeAreaInsets();

  const handleSubmit = async () => {
    if (!email.trim() || !password.trim()) {
      Alert.alert('خطأ', 'يرجى ملء جميع الحقول');
      return;
    }
    if (mode === 'signup' && !fullName.trim()) {
      Alert.alert('خطأ', 'يرجى إدخال الاسم الكامل');
      return;
    }
    setLoading(true);
    try {
      if (mode === 'login') {
        await signIn(email.trim(), password);
        router.replace('/(app)/dashboard');
      } else {
        await signUp(email.trim(), password, fullName.trim());
        router.replace('/access');
      }
    } catch (err) {
      const msg = err instanceof Error ? err.message : 'حدث خطأ غير متوقع';
      Alert.alert('خطأ', msg);
    } finally {
      setLoading(false);
    }
  };

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <LinearGradient
        colors={[colors.primaryDark, colors.background]}
        style={styles.gradient}
        start={{ x: 0, y: 0 }}
        end={{ x: 0, y: 1 }}
      />
      <KeyboardAvoidingView
        behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
        style={styles.kav}
      >
        <ScrollView
          contentContainerStyle={styles.scroll}
          keyboardShouldPersistTaps="handled"
          showsVerticalScrollIndicator={false}
        >
          {/* Logo / Header */}
          <View style={styles.header}>
            <View style={styles.logoRing}>
              <Ionicons name="wifi" size={36} color={colors.primary} />
            </View>
            <Text style={styles.appName}>MikroTik Whisperer</Text>
            <Text style={styles.tagline}>إدارة راوترات MikroTik بذكاء</Text>
          </View>

          {/* Form Card */}
          <View style={styles.card}>
            {/* Mode Toggle */}
            <View style={styles.modeRow}>
              <TouchableOpacity
                style={[styles.modeBtn, mode === 'login' && styles.modeBtnActive]}
                onPress={() => setMode('login')}
              >
                <Text style={[styles.modeBtnText, mode === 'login' && styles.modeBtnTextActive]}>
                  تسجيل الدخول
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                style={[styles.modeBtn, mode === 'signup' && styles.modeBtnActive]}
                onPress={() => setMode('signup')}
              >
                <Text style={[styles.modeBtnText, mode === 'signup' && styles.modeBtnTextActive]}>
                  إنشاء حساب
                </Text>
              </TouchableOpacity>
            </View>

            <View style={styles.form}>
              {mode === 'signup' && (
                <Input
                  label="الاسم الكامل"
                  value={fullName}
                  onChangeText={setFullName}
                  placeholder="أدخل اسمك الكامل"
                  autoCapitalize="words"
                  leftIcon={<Ionicons name="person-outline" size={18} color={colors.textMuted} />}
                />
              )}
              <Input
                label="البريد الإلكتروني"
                value={email}
                onChangeText={setEmail}
                placeholder="example@email.com"
                keyboardType="email-address"
                autoCapitalize="none"
                autoCorrect={false}
                leftIcon={<Ionicons name="mail-outline" size={18} color={colors.textMuted} />}
              />
              <Input
                label="كلمة المرور"
                value={password}
                onChangeText={setPassword}
                placeholder="أدخل كلمة المرور"
                secureTextEntry
                leftIcon={<Ionicons name="lock-closed-outline" size={18} color={colors.textMuted} />}
              />
              <Button
                label={mode === 'login' ? 'تسجيل الدخول' : 'إنشاء الحساب'}
                onPress={handleSubmit}
                loading={loading}
                size="lg"
                style={styles.submitBtn}
              />
            </View>
          </View>
        </ScrollView>
      </KeyboardAvoidingView>
    </View>
  );
}

const styles = StyleSheet.create({
  root: {
    flex: 1,
    backgroundColor: colors.background,
  },
  gradient: {
    ...StyleSheet.absoluteFillObject,
    height: 300,
  },
  kav: {
    flex: 1,
  },
  scroll: {
    flexGrow: 1,
    padding: spacing.lg,
    gap: spacing.xl,
    justifyContent: 'center',
  },
  header: {
    alignItems: 'center',
    gap: spacing.sm,
    paddingVertical: spacing.xl,
  },
  logoRing: {
    width: 80,
    height: 80,
    borderRadius: 40,
    backgroundColor: `${colors.primary}22`,
    borderWidth: 2,
    borderColor: `${colors.primary}44`,
    alignItems: 'center',
    justifyContent: 'center',
    marginBottom: spacing.sm,
  },
  appName: {
    color: colors.text,
    fontSize: typography.fontSize2xl,
    fontWeight: typography.fontWeightBold,
    textAlign: 'center',
  },
  tagline: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
    textAlign: 'center',
  },
  card: {
    backgroundColor: colors.surface,
    borderRadius: radius.xl,
    borderWidth: 1,
    borderColor: colors.border,
    padding: spacing.xl,
    gap: spacing.lg,
  },
  modeRow: {
    flexDirection: 'row',
    backgroundColor: colors.surface2,
    borderRadius: radius.md,
    padding: 4,
  },
  modeBtn: {
    flex: 1,
    paddingVertical: spacing.sm,
    alignItems: 'center',
    borderRadius: radius.sm,
  },
  modeBtnActive: {
    backgroundColor: colors.primary,
  },
  modeBtnText: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
    fontWeight: typography.fontWeightMedium,
  },
  modeBtnTextActive: {
    color: colors.text,
    fontWeight: typography.fontWeightSemiBold,
  },
  form: {
    gap: spacing.md,
  },
  submitBtn: {
    marginTop: spacing.sm,
  },
});
