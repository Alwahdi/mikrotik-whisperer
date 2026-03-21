import React from 'react';
import { Tabs } from 'expo-router';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import { colors, spacing, typography } from '@/lib/theme';

type IoniconName = keyof typeof Ionicons.glyphMap;

interface TabConfig {
  name: string;
  title: string;
  icon: IoniconName;
  activeIcon: IoniconName;
}

const TABS: TabConfig[] = [
  { name: 'dashboard', title: 'الرئيسية', icon: 'home-outline', activeIcon: 'home' },
  { name: 'hotspot', title: 'هوت سبوت', icon: 'wifi-outline', activeIcon: 'wifi' },
  { name: 'usermanager', title: 'المستخدمون', icon: 'people-outline', activeIcon: 'people' },
  { name: 'vouchers', title: 'الكروت', icon: 'card-outline', activeIcon: 'card' },
  { name: 'more', title: 'المزيد', icon: 'menu-outline', activeIcon: 'menu' },
];

export default function AppLayout() {
  const insets = useSafeAreaInsets();

  return (
    <Tabs
      screenOptions={{
        headerShown: false,
        tabBarStyle: {
          backgroundColor: colors.surface,
          borderTopColor: colors.border,
          borderTopWidth: 1,
          height: 60 + insets.bottom,
          paddingBottom: insets.bottom,
          paddingTop: spacing.xs,
        },
        tabBarActiveTintColor: colors.primary,
        tabBarInactiveTintColor: colors.textMuted,
        tabBarLabelStyle: {
          fontSize: typography.fontSizeXs,
          fontWeight: typography.fontWeightMedium as '500',
        },
      }}
    >
      {TABS.map((tab) => (
        <Tabs.Screen
          key={tab.name}
          name={tab.name}
          options={{
            title: tab.title,
            tabBarIcon: ({ focused, color, size }) => (
              <Ionicons
                name={focused ? tab.activeIcon : tab.icon}
                size={size}
                color={color}
              />
            ),
          }}
        />
      ))}
      <Tabs.Screen name="routers" options={{ href: null }} />
      <Tabs.Screen name="sales" options={{ href: null }} />
      <Tabs.Screen name="backups" options={{ href: null }} />
      <Tabs.Screen name="health" options={{ href: null }} />
      <Tabs.Screen name="admin" options={{ href: null }} />
      <Tabs.Screen name="settings" options={{ href: null }} />
    </Tabs>
  );
}
