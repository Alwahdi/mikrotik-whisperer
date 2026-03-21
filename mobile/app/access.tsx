import React, { useEffect, useState } from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
  Alert,
} from 'react-native';
import { useRouter } from 'expo-router';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import { useAuth } from '@/contexts/AuthContext';
import { supabase } from '@/lib/supabase';
import { colors, spacing, typography, radius } from '@/lib/theme';
import { Button } from '@/components/Button';
import { LoadingSpinner } from '@/components/LoadingSpinner';

type AccessStatus = 'pending' | 'active' | 'suspended' | 'expired' | null;

interface AccessRecord {
  status: AccessStatus;
  starts_at: string | null;
  expires_at: string | null;
  notes: string | null;
}

export default function AccessScreen() {
  const { user, signOut } = useAuth();
  const router = useRouter();
  const insets = useSafeAreaInsets();
  const [access, setAccess] = useState<AccessRecord | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (!user) return;
    const fetchAccess = async () => {
      const { data } = await supabase
        .from('user_access')
        .select('status, starts_at, expires_at, notes')
        .eq('user_id', user.id)
        .single();
      setAccess(data as AccessRecord | null);
      setLoading(false);
      if ((data as AccessRecord | null)?.status === 'active') {
        router.replace('/(app)/dashboard');
      }
    };
    fetchAccess();
  }, [user, router]);

  const handleSignOut = async () => {
    await signOut();
    router.replace('/auth');
  };

  if (loading) return <LoadingSpinner fullScreen />;

  const status = access?.status ?? 'pending';

  const statusConfig: Record<
    string,
    { icon: keyof typeof Ionicons.glyphMap; color: string; title: string; description: string }
  > = {
    pending: {
      icon: 'time-outline',
      color: colors.warning,
      title: 'في انتظار الموافقة',
      description:
        'تم إنشاء حسابك بنجاح. يرجى الانتظار حتى يتم مراجعة طلبك والموافقة عليه من قبل المشرف.',
    },
    suspended: {
      icon: 'ban-outline',
      color: colors.error,
      title: 'تم تعليق الحساب',
      description: 'تم تعليق حسابك. يرجى التواصل مع المشرف لمعرفة السبب وإعادة التفعيل.',
    },
    expired: {
      icon: 'calendar-outline',
      color: colors.error,
      title: 'انتهت صلاحية الحساب',
      description: 'انتهت مدة اشتراكك. يرجى تجديد الاشتراك للاستمرار في استخدام الخدمة.',
    },
  };

  const cfg = statusConfig[status] ?? statusConfig.pending;

  return (
    <View style={[styles.root, { paddingTop: insets.top, paddingBottom: insets.bottom }]}>
      <ScrollView contentContainerStyle={styles.content}>
        <View style={[styles.iconCircle, { backgroundColor: `${cfg.color}22`, borderColor: `${cfg.color}44` }]}>
          <Ionicons name={cfg.icon} size={56} color={cfg.color} />
        </View>

        <Text style={[styles.title, { color: cfg.color }]}>{cfg.title}</Text>
        <Text style={styles.description}>{cfg.description}</Text>

        {access?.notes && (
          <View style={styles.notesCard}>
            <Text style={styles.notesLabel}>ملاحظة:</Text>
            <Text style={styles.notesText}>{access.notes}</Text>
          </View>
        )}

        {access?.expires_at && (
          <Text style={styles.dateText}>
            تاريخ الانتهاء: {new Date(access.expires_at).toLocaleDateString('ar')}
          </Text>
        )}

        <Button
          label="تسجيل الخروج"
          variant="ghost"
          onPress={handleSignOut}
          icon={<Ionicons name="log-out-outline" size={18} color={colors.textMuted} />}
          style={styles.signOutBtn}
        />
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  root: {
    flex: 1,
    backgroundColor: colors.background,
  },
  content: {
    flexGrow: 1,
    alignItems: 'center',
    justifyContent: 'center',
    padding: spacing.xl,
    gap: spacing.lg,
  },
  iconCircle: {
    width: 120,
    height: 120,
    borderRadius: 60,
    borderWidth: 2,
    alignItems: 'center',
    justifyContent: 'center',
    marginBottom: spacing.md,
  },
  title: {
    fontSize: typography.fontSize2xl,
    fontWeight: typography.fontWeightBold,
    textAlign: 'center',
  },
  description: {
    color: colors.textMuted,
    fontSize: typography.fontSizeMd,
    textAlign: 'center',
    lineHeight: 24,
    maxWidth: 320,
  },
  notesCard: {
    backgroundColor: colors.surface,
    borderRadius: radius.md,
    borderWidth: 1,
    borderColor: colors.border,
    padding: spacing.lg,
    width: '100%',
    gap: spacing.xs,
  },
  notesLabel: {
    color: colors.textSecondary,
    fontSize: typography.fontSizeSm,
    fontWeight: typography.fontWeightSemiBold,
  },
  notesText: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
  },
  dateText: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
  },
  signOutBtn: {
    marginTop: spacing.xl,
  },
});
