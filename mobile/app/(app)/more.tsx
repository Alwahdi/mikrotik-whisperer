import React from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
} from 'react-native';
import { useRouter } from 'expo-router';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import { useAuth } from '@/contexts/AuthContext';
import { colors, spacing, typography, radius } from '@/lib/theme';

interface MenuItem {
  icon: keyof typeof Ionicons.glyphMap;
  label: string;
  description: string;
  route: string;
  adminOnly?: boolean;
  color: string;
}

const MENU_ITEMS: MenuItem[] = [
  {
    icon: 'hardware-chip-outline',
    label: 'الراوترات',
    description: 'إدارة الراوترات والاتصالات',
    route: '/(app)/routers',
    color: colors.primary,
  },
  {
    icon: 'bar-chart-outline',
    label: 'المبيعات',
    description: 'تقارير الإيرادات',
    route: '/(app)/sales',
    color: colors.success,
  },
  {
    icon: 'cloud-upload-outline',
    label: 'النسخ الاحتياطي',
    description: 'إنشاء واستعادة النسخ',
    route: '/(app)/backups',
    color: colors.warning,
  },
  {
    icon: 'pulse-outline',
    label: 'الصحة',
    description: 'فحص حالة الخدمات',
    route: '/(app)/health',
    color: colors.info,
  },
  {
    icon: 'shield-checkmark-outline',
    label: 'لوحة الإدارة',
    description: 'إدارة صلاحيات المستخدمين',
    route: '/(app)/admin',
    adminOnly: true,
    color: colors.error,
  },
  {
    icon: 'settings-outline',
    label: 'الإعدادات',
    description: 'إعدادات الاتصال والتطبيق',
    route: '/(app)/settings',
    color: colors.textMuted,
  },
];

export default function MoreScreen() {
  const insets = useSafeAreaInsets();
  const router = useRouter();
  const { isAdmin, user, signOut } = useAuth();

  const handleSignOut = async () => {
    await signOut();
    router.replace('/auth');
  };

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <ScrollView contentContainerStyle={styles.content} showsVerticalScrollIndicator={false}>
        <Text style={styles.title}>المزيد</Text>

        {/* User Info */}
        {user && (
          <View style={styles.userCard}>
            <View style={styles.avatar}>
              <Ionicons name="person" size={24} color={colors.primary} />
            </View>
            <View style={styles.userInfo}>
              <Text style={styles.userEmail}>{user.email}</Text>
              {isAdmin && <Text style={styles.userRole}>مشرف</Text>}
            </View>
          </View>
        )}

        {/* Menu Items */}
        <View style={styles.menuList}>
          {MENU_ITEMS.filter((item) => !item.adminOnly || isAdmin).map((item) => (
            <TouchableOpacity
              key={item.route}
              style={styles.menuItem}
              onPress={() => router.push(item.route as Parameters<typeof router.push>[0])}
              activeOpacity={0.75}
            >
              <View style={[styles.menuIcon, { backgroundColor: `${item.color}22` }]}>
                <Ionicons name={item.icon} size={22} color={item.color} />
              </View>
              <View style={styles.menuText}>
                <Text style={styles.menuLabel}>{item.label}</Text>
                <Text style={styles.menuDesc}>{item.description}</Text>
              </View>
              <Ionicons name="chevron-forward" size={16} color={colors.textMuted} />
            </TouchableOpacity>
          ))}
        </View>

        {/* Sign Out */}
        <TouchableOpacity style={styles.signOutBtn} onPress={handleSignOut}>
          <Ionicons name="log-out-outline" size={20} color={colors.error} />
          <Text style={styles.signOutText}>تسجيل الخروج</Text>
        </TouchableOpacity>
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  root: { flex: 1, backgroundColor: colors.background },
  content: { padding: spacing.lg, gap: spacing.lg, paddingBottom: spacing.xxxl },
  title: { color: colors.text, fontSize: typography.fontSizeXl, fontWeight: typography.fontWeightBold },
  userCard: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: colors.surface,
    borderRadius: radius.lg,
    borderWidth: 1,
    borderColor: colors.border,
    padding: spacing.lg,
    gap: spacing.md,
  },
  avatar: {
    width: 48, height: 48, borderRadius: 24,
    backgroundColor: `${colors.primary}22`,
    alignItems: 'center', justifyContent: 'center',
  },
  userInfo: { flex: 1 },
  userEmail: { color: colors.text, fontSize: typography.fontSizeMd, fontWeight: typography.fontWeightMedium },
  userRole: { color: colors.primary, fontSize: typography.fontSizeSm },
  menuList: {
    backgroundColor: colors.surface,
    borderRadius: radius.lg,
    borderWidth: 1,
    borderColor: colors.border,
    overflow: 'hidden',
  },
  menuItem: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: spacing.lg,
    gap: spacing.md,
    borderBottomWidth: 1,
    borderBottomColor: colors.border,
  },
  menuIcon: {
    width: 42, height: 42, borderRadius: radius.md,
    alignItems: 'center', justifyContent: 'center',
  },
  menuText: { flex: 1 },
  menuLabel: { color: colors.text, fontSize: typography.fontSizeMd, fontWeight: typography.fontWeightMedium },
  menuDesc: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  signOutBtn: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    gap: spacing.sm,
    padding: spacing.lg,
    backgroundColor: `${colors.error}11`,
    borderRadius: radius.lg,
    borderWidth: 1,
    borderColor: `${colors.error}33`,
  },
  signOutText: { color: colors.error, fontSize: typography.fontSizeMd, fontWeight: typography.fontWeightSemiBold },
});
