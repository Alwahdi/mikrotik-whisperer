import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  ScrollView,
  StyleSheet,
  useColorScheme,
  RefreshControl,
  Dimensions,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { Colors, Spacing, FontSizes, BorderRadius } from '@/lib/theme';
import { Card, CardHeader } from '@/components/Card';
import { Ionicons } from '@expo/vector-icons';

const { width } = Dimensions.get('window');

interface SystemInfo {
  cpu: number;
  memory: number;
  uptime: string;
  activeUsers: number;
}

export default function DashboardScreen() {
  const colorScheme = useColorScheme();
  const colors = colorScheme === 'dark' ? Colors.dark : Colors.light;
  const [refreshing, setRefreshing] = useState(false);
  const [systemInfo, setSystemInfo] = useState<SystemInfo>({
    cpu: 45,
    memory: 62,
    uptime: '15d 8h 32m',
    activeUsers: 127,
  });

  const handleRefresh = async () => {
    setRefreshing(true);
    // Simulate API call
    setTimeout(() => {
      setSystemInfo({
        cpu: Math.floor(Math.random() * 100),
        memory: Math.floor(Math.random() * 100),
        uptime: '15d 8h 32m',
        activeUsers: Math.floor(Math.random() * 200),
      });
      setRefreshing(false);
    }, 1000);
  };

  const getStatusColor = (value: number) => {
    if (value < 50) return colors.success;
    if (value < 80) return colors.warning;
    return colors.destructive;
  };

  return (
    <SafeAreaView style={[styles.container, { backgroundColor: colors.background }]} edges={['top']}>
      <View style={styles.header}>
        <Text style={[styles.title, { color: colors.foreground }]}>Dashboard</Text>
      </View>

      <ScrollView
        style={styles.content}
        contentContainerStyle={styles.scrollContent}
        refreshControl={
          <RefreshControl refreshing={refreshing} onRefresh={handleRefresh} tintColor={colors.primary} />
        }
      >
        {/* System Statistics */}
        <View style={styles.statsGrid}>
          <View style={[styles.statCard, { backgroundColor: colors.card, borderColor: colors.border }]}>
            <View style={[styles.iconCircle, { backgroundColor: colors.primary + '20' }]}>
              <Ionicons name="speedometer-outline" size={24} color={colors.primary} />
            </View>
            <Text style={[styles.statValue, { color: getStatusColor(systemInfo.cpu) }]}>
              {systemInfo.cpu}%
            </Text>
            <Text style={[styles.statLabel, { color: colors.mutedForeground }]}>CPU Usage</Text>
          </View>

          <View style={[styles.statCard, { backgroundColor: colors.card, borderColor: colors.border }]}>
            <View style={[styles.iconCircle, { backgroundColor: colors.secondary + '20' }]}>
              <Ionicons name="hardware-chip-outline" size={24} color={colors.secondary} />
            </View>
            <Text style={[styles.statValue, { color: getStatusColor(systemInfo.memory) }]}>
              {systemInfo.memory}%
            </Text>
            <Text style={[styles.statLabel, { color: colors.mutedForeground }]}>Memory</Text>
          </View>

          <View style={[styles.statCard, { backgroundColor: colors.card, borderColor: colors.border }]}>
            <View style={[styles.iconCircle, { backgroundColor: colors.accent + '20' }]}>
              <Ionicons name="people-outline" size={24} color={colors.accent} />
            </View>
            <Text style={[styles.statValue, { color: colors.foreground }]}>
              {systemInfo.activeUsers}
            </Text>
            <Text style={[styles.statLabel, { color: colors.mutedForeground }]}>Active Users</Text>
          </View>

          <View style={[styles.statCard, { backgroundColor: colors.card, borderColor: colors.border }]}>
            <View style={[styles.iconCircle, { backgroundColor: colors.info + '20' }]}>
              <Ionicons name="time-outline" size={24} color={colors.info} />
            </View>
            <Text style={[styles.statValue, { color: colors.foreground }]}>
              {systemInfo.uptime}
            </Text>
            <Text style={[styles.statLabel, { color: colors.mutedForeground }]}>Uptime</Text>
          </View>
        </View>

        {/* Today's Sales */}
        <Card>
          <CardHeader title="Today's Sales" subtitle="Revenue and transactions" />
          <View style={styles.salesGrid}>
            <View style={styles.salesItem}>
              <Text style={[styles.salesValue, { color: colors.success }]}>$1,245</Text>
              <Text style={[styles.salesLabel, { color: colors.mutedForeground }]}>Revenue</Text>
            </View>
            <View style={[styles.divider, { backgroundColor: colors.border }]} />
            <View style={styles.salesItem}>
              <Text style={[styles.salesValue, { color: colors.primary }]}>89</Text>
              <Text style={[styles.salesLabel, { color: colors.mutedForeground }]}>Transactions</Text>
            </View>
          </View>
        </Card>

        {/* Traffic Overview */}
        <Card>
          <CardHeader title="Traffic Overview" subtitle="Last 24 hours" />
          <View style={styles.trafficInfo}>
            <View style={styles.trafficItem}>
              <Ionicons name="arrow-down-outline" size={20} color={colors.success} />
              <View style={styles.trafficDetails}>
                <Text style={[styles.trafficValue, { color: colors.foreground }]}>2.4 GB</Text>
                <Text style={[styles.trafficLabel, { color: colors.mutedForeground }]}>Download</Text>
              </View>
            </View>
            <View style={styles.trafficItem}>
              <Ionicons name="arrow-up-outline" size={20} color={colors.warning} />
              <View style={styles.trafficDetails}>
                <Text style={[styles.trafficValue, { color: colors.foreground }]}>1.8 GB</Text>
                <Text style={[styles.trafficLabel, { color: colors.mutedForeground }]}>Upload</Text>
              </View>
            </View>
          </View>
        </Card>

        {/* System Health */}
        <Card>
          <CardHeader title="System Health" subtitle="All systems operational" />
          <View style={styles.healthItem}>
            <View style={styles.healthInfo}>
              <Ionicons name="checkmark-circle" size={24} color={colors.success} />
              <Text style={[styles.healthText, { color: colors.foreground }]}>Router Connection</Text>
            </View>
            <Text style={[styles.healthStatus, { color: colors.success }]}>Online</Text>
          </View>
          <View style={[styles.healthDivider, { backgroundColor: colors.border }]} />
          <View style={styles.healthItem}>
            <View style={styles.healthInfo}>
              <Ionicons name="checkmark-circle" size={24} color={colors.success} />
              <Text style={[styles.healthText, { color: colors.foreground }]}>Database</Text>
            </View>
            <Text style={[styles.healthStatus, { color: colors.success }]}>Connected</Text>
          </View>
        </Card>
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
  statsGrid: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    marginBottom: Spacing.md,
    gap: Spacing.md,
  },
  statCard: {
    width: (width - Spacing.lg * 2 - Spacing.md) / 2,
    padding: Spacing.md,
    borderRadius: BorderRadius.lg,
    borderWidth: 1,
    alignItems: 'center',
  },
  iconCircle: {
    width: 48,
    height: 48,
    borderRadius: 24,
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: Spacing.sm,
  },
  statValue: {
    fontSize: FontSizes['2xl'],
    fontWeight: 'bold',
    marginBottom: Spacing.xs,
  },
  statLabel: {
    fontSize: FontSizes.sm,
  },
  salesGrid: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  salesItem: {
    flex: 1,
    alignItems: 'center',
  },
  salesValue: {
    fontSize: FontSizes['2xl'],
    fontWeight: 'bold',
    marginBottom: Spacing.xs,
  },
  salesLabel: {
    fontSize: FontSizes.sm,
  },
  divider: {
    width: 1,
    height: 40,
  },
  trafficInfo: {
    gap: Spacing.md,
  },
  trafficItem: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: Spacing.md,
  },
  trafficDetails: {
    flex: 1,
  },
  trafficValue: {
    fontSize: FontSizes.lg,
    fontWeight: '600',
    marginBottom: Spacing.xs,
  },
  trafficLabel: {
    fontSize: FontSizes.sm,
  },
  healthItem: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingVertical: Spacing.sm,
  },
  healthInfo: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: Spacing.md,
  },
  healthText: {
    fontSize: FontSizes.base,
    fontWeight: '500',
  },
  healthStatus: {
    fontSize: FontSizes.sm,
    fontWeight: '600',
  },
  healthDivider: {
    height: 1,
    marginVertical: Spacing.xs,
  },
});
