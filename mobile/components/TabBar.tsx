import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet, ScrollView } from 'react-native';
import { colors, radius, spacing, typography } from '@/lib/theme';

interface TabItem {
  key: string;
  label: string;
  badge?: number;
}

interface TabBarProps {
  tabs: TabItem[];
  activeTab: string;
  onTabChange: (key: string) => void;
}

export function TabBar({ tabs, activeTab, onTabChange }: TabBarProps) {
  return (
    <ScrollView
      horizontal
      showsHorizontalScrollIndicator={false}
      style={styles.scrollView}
      contentContainerStyle={styles.container}
    >
      {tabs.map((tab) => {
        const isActive = tab.key === activeTab;
        return (
          <TouchableOpacity
            key={tab.key}
            style={[styles.tab, isActive && styles.activeTab]}
            onPress={() => onTabChange(tab.key)}
            activeOpacity={0.75}
          >
            <Text style={[styles.label, isActive && styles.activeLabel]}>{tab.label}</Text>
            {tab.badge !== undefined && tab.badge > 0 && (
              <View style={[styles.badge, isActive && styles.activeBadge]}>
                <Text style={styles.badgeText}>{tab.badge > 99 ? '99+' : tab.badge}</Text>
              </View>
            )}
          </TouchableOpacity>
        );
      })}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  scrollView: {
    flexGrow: 0,
  },
  container: {
    flexDirection: 'row',
    backgroundColor: colors.surface,
    borderRadius: radius.md,
    padding: 4,
    gap: 4,
  },
  tab: {
    flexDirection: 'row',
    alignItems: 'center',
    paddingVertical: spacing.sm,
    paddingHorizontal: spacing.md,
    borderRadius: radius.sm,
    gap: spacing.xs,
  },
  activeTab: {
    backgroundColor: colors.primary,
  },
  label: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
    fontWeight: typography.fontWeightMedium,
  },
  activeLabel: {
    color: colors.text,
    fontWeight: typography.fontWeightSemiBold,
  },
  badge: {
    backgroundColor: colors.surface2,
    borderRadius: radius.full,
    paddingHorizontal: 6,
    paddingVertical: 1,
    minWidth: 20,
    alignItems: 'center',
  },
  activeBadge: {
    backgroundColor: 'rgba(255,255,255,0.2)',
  },
  badgeText: {
    color: colors.text,
    fontSize: 10,
    fontWeight: typography.fontWeightBold,
  },
});
