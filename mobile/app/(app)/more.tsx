import React from 'react';
import {
  View,
  Text,
  ScrollView,
  StyleSheet,
  useColorScheme,
  TouchableOpacity,
  Alert,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { router } from 'expo-router';
import { useAuth } from '@/contexts/AuthContext';
import { Colors, Spacing, FontSizes, BorderRadius } from '@/lib/theme';
import { Card } from '@/components/Card';
import { Ionicons } from '@expo/vector-icons';

interface MenuItem {
  icon: string;
  title: string;
  subtitle: string;
  onPress: () => void;
  color?: string;
  badge?: string;
}

export default function MoreScreen() {
  const { profile, signOut } = useAuth();
  const colorScheme = useColorScheme();
  const colors = colorScheme === 'dark' ? Colors.dark : Colors.light;

  const menuSections: { title: string; items: MenuItem[] }[] = [
    {
      title: 'Management',
      items: [
        {
          icon: 'ticket-outline',
          title: 'Vouchers',
          subtitle: 'Generate and manage vouchers',
          onPress: () => Alert.alert('Vouchers', 'Voucher generation screen'),
        },
        {
          icon: 'bar-chart-outline',
          title: 'Sales',
          subtitle: 'View sales and analytics',
          onPress: () => Alert.alert('Sales', 'Sales analytics screen'),
        },
        {
          icon: 'cloud-download-outline',
          title: 'Backups',
          subtitle: 'Backup and restore data',
          onPress: () => Alert.alert('Backups', 'Backup management screen'),
        },
        {
          icon: 'pulse-outline',
          title: 'Health',
          subtitle: 'System health monitoring',
          onPress: () => Alert.alert('Health', 'Health monitoring screen'),
        },
      ],
    },
    {
      title: 'Settings',
      items: [
        {
          icon: 'settings-outline',
          title: 'Preferences',
          subtitle: 'App and router settings',
          onPress: () => Alert.alert('Settings', 'Settings screen'),
        },
        {
          icon: 'shield-checkmark-outline',
          title: 'Security',
          subtitle: 'Biometrics and security',
          onPress: () => Alert.alert('Security', 'Security settings'),
        },
        {
          icon: 'moon-outline',
          title: 'Appearance',
          subtitle: `Current: ${colorScheme === 'dark' ? 'Dark' : 'Light'} mode`,
          onPress: () => Alert.alert('Appearance', 'Theme settings'),
        },
      ],
    },
  ];

  if (profile?.role === 'admin') {
    menuSections[0].items.push({
      icon: 'people-circle-outline',
      title: 'Admin Users',
      subtitle: 'Manage system users',
      onPress: () => Alert.alert('Admin', 'Admin user management'),
      color: colors.warning,
    });
  }

  const handleSignOut = () => {
    Alert.alert('Sign Out', 'Are you sure you want to sign out?', [
      { text: 'Cancel', style: 'cancel' },
      {
        text: 'Sign Out',
        style: 'destructive',
        onPress: async () => {
          await signOut();
          router.replace('/auth');
        },
      },
    ]);
  };

  const renderMenuItem = (item: MenuItem) => (
    <TouchableOpacity
      key={item.title}
      style={[styles.menuItem, { borderBottomColor: colors.border }]}
      onPress={item.onPress}
      activeOpacity={0.7}
    >
      <View style={styles.menuItemLeft}>
        <View style={[styles.iconContainer, {
          backgroundColor: (item.color || colors.primary) + '20'
        }]}>
          <Ionicons
            name={item.icon as any}
            size={24}
            color={item.color || colors.primary}
          />
        </View>
        <View style={styles.menuItemText}>
          <Text style={[styles.menuTitle, { color: colors.foreground }]}>
            {item.title}
          </Text>
          <Text style={[styles.menuSubtitle, { color: colors.mutedForeground }]}>
            {item.subtitle}
          </Text>
        </View>
      </View>
      <Ionicons name="chevron-forward" size={20} color={colors.mutedForeground} />
    </TouchableOpacity>
  );

  return (
    <SafeAreaView style={[styles.container, { backgroundColor: colors.background }]} edges={['top']}>
      <View style={styles.header}>
        <Text style={[styles.title, { color: colors.foreground }]}>More</Text>
      </View>

      <ScrollView style={styles.content} contentContainerStyle={styles.scrollContent}>
        {/* Profile Card */}
        <Card>
          <View style={styles.profileHeader}>
            <View style={[styles.avatar, { backgroundColor: colors.primary }]}>
              <Text style={styles.avatarText}>
                {profile?.full_name?.charAt(0).toUpperCase() || 'U'}
              </Text>
            </View>
            <View style={styles.profileInfo}>
              <Text style={[styles.profileName, { color: colors.foreground }]}>
                {profile?.full_name || 'User'}
              </Text>
              <Text style={[styles.profileEmail, { color: colors.mutedForeground }]}>
                {profile?.email}
              </Text>
              <View style={[styles.roleBadge, {
                backgroundColor: profile?.role === 'admin' ? colors.primary : colors.secondary
              }]}>
                <Text style={styles.roleText}>
                  {profile?.role === 'admin' ? 'Administrator' : 'Cashier'}
                </Text>
              </View>
            </View>
          </View>
        </Card>

        {/* Menu Sections */}
        {menuSections.map((section) => (
          <Card key={section.title}>
            <Text style={[styles.sectionTitle, { color: colors.mutedForeground }]}>
              {section.title}
            </Text>
            {section.items.map(renderMenuItem)}
          </Card>
        ))}

        {/* About Section */}
        <Card>
          <Text style={[styles.sectionTitle, { color: colors.mutedForeground }]}>
            About
          </Text>
          <View style={styles.aboutItem}>
            <Text style={[styles.aboutLabel, { color: colors.foreground }]}>Version</Text>
            <Text style={[styles.aboutValue, { color: colors.mutedForeground }]}>1.0.0</Text>
          </View>
          <View style={[styles.divider, { backgroundColor: colors.border }]} />
          <View style={styles.aboutItem}>
            <Text style={[styles.aboutLabel, { color: colors.foreground }]}>Build</Text>
            <Text style={[styles.aboutValue, { color: colors.mutedForeground }]}>2026.03.21</Text>
          </View>
        </Card>

        {/* Sign Out Button */}
        <TouchableOpacity
          style={[styles.signOutButton, { backgroundColor: colors.destructive }]}
          onPress={handleSignOut}
        >
          <Ionicons name="log-out-outline" size={20} color="#FFF" />
          <Text style={styles.signOutText}>Sign Out</Text>
        </TouchableOpacity>

        <View style={styles.footer}>
          <Text style={[styles.footerText, { color: colors.mutedForeground }]}>
            MikroTik Whisperer © 2026
          </Text>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  header: {
    padding: Spacing.lg,
  },
  title: {
    fontSize: FontSizes['2xl'],
    fontWeight: 'bold',
  },
  content: {
    flex: 1,
  },
  scrollContent: {
    padding: Spacing.lg,
    paddingTop: 0,
  },
  profileHeader: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: Spacing.md,
  },
  avatar: {
    width: 64,
    height: 64,
    borderRadius: 32,
    justifyContent: 'center',
    alignItems: 'center',
  },
  avatarText: {
    fontSize: FontSizes['2xl'],
    fontWeight: 'bold',
    color: '#FFF',
  },
  profileInfo: {
    flex: 1,
  },
  profileName: {
    fontSize: FontSizes.lg,
    fontWeight: 'bold',
    marginBottom: Spacing.xs,
  },
  profileEmail: {
    fontSize: FontSizes.sm,
    marginBottom: Spacing.sm,
  },
  roleBadge: {
    alignSelf: 'flex-start',
    paddingHorizontal: Spacing.sm,
    paddingVertical: 4,
    borderRadius: BorderRadius.xs,
  },
  roleText: {
    color: '#FFF',
    fontSize: FontSizes.xs,
    fontWeight: '600',
  },
  sectionTitle: {
    fontSize: FontSizes.sm,
    fontWeight: '600',
    textTransform: 'uppercase',
    marginBottom: Spacing.md,
  },
  menuItem: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingVertical: Spacing.md,
    borderBottomWidth: 1,
  },
  menuItemLeft: {
    flexDirection: 'row',
    alignItems: 'center',
    flex: 1,
    gap: Spacing.md,
  },
  iconContainer: {
    width: 48,
    height: 48,
    borderRadius: BorderRadius.md,
    justifyContent: 'center',
    alignItems: 'center',
  },
  menuItemText: {
    flex: 1,
  },
  menuTitle: {
    fontSize: FontSizes.base,
    fontWeight: '600',
    marginBottom: Spacing.xs,
  },
  menuSubtitle: {
    fontSize: FontSizes.sm,
  },
  aboutItem: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    paddingVertical: Spacing.sm,
  },
  aboutLabel: {
    fontSize: FontSizes.base,
  },
  aboutValue: {
    fontSize: FontSizes.base,
  },
  divider: {
    height: 1,
  },
  signOutButton: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    gap: Spacing.sm,
    padding: Spacing.md,
    borderRadius: BorderRadius.lg,
    marginTop: Spacing.lg,
  },
  signOutText: {
    color: '#FFF',
    fontSize: FontSizes.base,
    fontWeight: '600',
  },
  footer: {
    alignItems: 'center',
    paddingVertical: Spacing.xl,
  },
  footerText: {
    fontSize: FontSizes.sm,
  },
});
