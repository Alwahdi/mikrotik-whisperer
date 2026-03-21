import React, { useState, useCallback } from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  RefreshControl,
  TouchableOpacity,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { useQueryClient } from '@tanstack/react-query';
import { Ionicons } from '@expo/vector-icons';
import {
  useRouterKey,
  useSystemResources,
  useSystemIdentity,
  useHotspotUsers,
  useInterfaces,
  useUserManagerCount,
} from '@/hooks/useMikrotik';
import { useAuth } from '@/contexts/AuthContext';
import { supabase } from '@/lib/supabase';
import { StatCard } from '@/components/StatCard';
import { Card } from '@/components/Card';
import { SectionHeader } from '@/components/SectionHeader';
import { Badge } from '@/components/Badge';
import { LoadingSpinner } from '@/components/LoadingSpinner';
import { colors, spacing, typography, radius } from '@/lib/theme';

interface SalesRecord {
  total_amount: number;
  card_count: number;
  created_at: string;
}

function useTodaySales(userId: string | undefined) {
  const [sales, setSales] = React.useState<{ total: number; cards: number } | null>(null);
  React.useEffect(() => {
    if (!userId) return;
    const today = new Date();
    today.setHours(0, 0, 0, 0);
    supabase
      .from('sales')
      .select('total_amount, card_count')
      .eq('user_id', userId)
      .gte('created_at', today.toISOString())
      .then(({ data }) => {
        if (!data) return;
        const records = data as SalesRecord[];
        setSales({
          total: records.reduce((s, r) => s + (r.total_amount || 0), 0),
          cards: records.reduce((s, r) => s + (r.card_count || 0), 0),
        });
      });
  }, [userId]);
  return sales;
}

export default function DashboardScreen() {
  const insets = useSafeAreaInsets();
  const qc = useQueryClient();
  const { user } = useAuth();
  const routerKey = useRouterKey();
  const [refreshing, setRefreshing] = useState(false);

  const resources = useSystemResources(routerKey);
  const identity = useSystemIdentity(routerKey);
  const hotspotUsers = useHotspotUsers(routerKey);
  const interfaces = useInterfaces(routerKey);
  const umCount = useUserManagerCount(routerKey);
  const todaySales = useTodaySales(user?.id);

  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    await qc.invalidateQueries({ queryKey: ['mikrotik', routerKey] });
    setRefreshing(false);
  }, [qc, routerKey]);

  const res = resources.data as Record<string, string> | undefined;
  const cpuLoad = res ? parseInt(res['cpu-load'] ?? '0') : 0;
  const totalMem = res ? parseInt(res['total-memory'] ?? '0') : 0;
  const freeMem = res ? parseInt(res['free-memory'] ?? '0') : 0;
  const totalHdd = res ? parseInt(res['total-hdd-space'] ?? '0') : 0;
  const freeHdd = res ? parseInt(res['free-hdd-space'] ?? '0') : 0;
  const memPct = totalMem > 0 ? Math.round(((totalMem - freeMem) / totalMem) * 100) : 0;
  const hddPct = totalHdd > 0 ? Math.round(((totalHdd - freeHdd) / totalHdd) * 100) : 0;

  const activeUsers = Array.isArray(hotspotUsers.data) ? hotspotUsers.data.length : 0;
  const ifaces = Array.isArray(interfaces.data) ? interfaces.data as Record<string, string>[] : [];
  const routerName = (identity.data as Record<string, string> | undefined)?.name ?? 'غير متصل';

  const alerts: { msg: string; level: 'warning' | 'error' }[] = [];
  if (cpuLoad > 80) alerts.push({ msg: `استخدام CPU مرتفع: ${cpuLoad}%`, level: 'error' });
  if (memPct > 85) alerts.push({ msg: `الذاكرة ممتلئة: ${memPct}%`, level: 'error' });
  if (hddPct > 90) alerts.push({ msg: `القرص الصلب ممتلئ: ${hddPct}%`, level: 'error' });

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <ScrollView
        contentContainerStyle={styles.content}
        refreshControl={
          <RefreshControl
            refreshing={refreshing}
            onRefresh={onRefresh}
            tintColor={colors.primary}
          />
        }
        showsVerticalScrollIndicator={false}
      >
        {/* Header */}
        <View style={styles.header}>
          <View>
            <Text style={styles.greeting}>لوحة التحكم</Text>
            <Text style={styles.routerName}>
              <Ionicons name="wifi" size={14} color={colors.primary} /> {routerName}
            </Text>
          </View>
          {resources.isLoading && <LoadingSpinner size="small" />}
        </View>

        {/* Alerts */}
        {alerts.length > 0 && (
          <View style={styles.section}>
            <SectionHeader title="تنبيهات النظام" />
            {alerts.map((a, i) => (
              <View key={i} style={[styles.alertRow, a.level === 'error' && styles.alertError]}>
                <Ionicons
                  name="warning-outline"
                  size={16}
                  color={a.level === 'error' ? colors.error : colors.warning}
                />
                <Text style={[styles.alertText, { color: a.level === 'error' ? colors.error : colors.warning }]}>
                  {a.msg}
                </Text>
              </View>
            ))}
          </View>
        )}

        {/* Stats Grid */}
        <View style={styles.section}>
          <SectionHeader title="إحصائيات النظام" />
          <View style={styles.statsGrid}>
            <StatCard
              label="مستخدمو هوت سبوت"
              value={activeUsers}
              color={colors.primary}
              icon={<Ionicons name="wifi" size={16} color={colors.primary} />}
            />
            <StatCard
              label="مستخدمو UM"
              value={umCount.data?.total ?? '—'}
              color={colors.info}
              icon={<Ionicons name="people" size={16} color={colors.info} />}
            />
          </View>
          <View style={styles.statsGrid}>
            <StatCard
              label="استخدام CPU"
              value={cpuLoad}
              unit="%"
              color={cpuLoad > 80 ? colors.error : colors.success}
              icon={<Ionicons name="pulse" size={16} color={cpuLoad > 80 ? colors.error : colors.success} />}
            />
            <StatCard
              label="الذاكرة"
              value={memPct}
              unit="%"
              color={memPct > 85 ? colors.error : colors.warning}
              icon={<Ionicons name="hardware-chip" size={16} color={memPct > 85 ? colors.error : colors.warning} />}
            />
          </View>
          <View style={styles.statsGrid}>
            <StatCard
              label="القرص الصلب"
              value={hddPct}
              unit="%"
              color={hddPct > 90 ? colors.error : colors.primary}
              icon={<Ionicons name="server" size={16} color={colors.primary} />}
            />
            {todaySales && (
              <StatCard
                label="مبيعات اليوم"
                value={todaySales.total.toFixed(2)}
                unit="ر.س"
                color={colors.success}
                icon={<Ionicons name="cash" size={16} color={colors.success} />}
              />
            )}
          </View>
        </View>

        {/* Active Hotspot Users */}
        {activeUsers > 0 && (
          <View style={styles.section}>
            <SectionHeader title={`المستخدمون النشطون (${activeUsers})`} />
            <Card padding="sm">
              {(hotspotUsers.data as Record<string, string>[]).slice(0, 10).map((u, i) => (
                <View key={i} style={[styles.userRow, i > 0 && styles.userRowBorder]}>
                  <View style={styles.userInfo}>
                    <Text style={styles.userName}>{u.user || u.name || '—'}</Text>
                    <Text style={styles.userMeta}>{u.address ?? u['mac-address'] ?? ''}</Text>
                  </View>
                  <Badge label={u.uptime ?? '—'} variant="info" />
                </View>
              ))}
            </Card>
          </View>
        )}

        {/* Interfaces */}
        {ifaces.length > 0 && (
          <View style={styles.section}>
            <SectionHeader title="واجهات الشبكة" />
            <Card padding="sm">
              {ifaces.slice(0, 8).map((iface, i) => (
                <View key={i} style={[styles.ifaceRow, i > 0 && styles.userRowBorder]}>
                  <View style={[styles.ifaceStatus, { backgroundColor: iface.running === 'true' ? colors.success : colors.error }]} />
                  <Text style={styles.ifaceName}>{iface.name ?? '—'}</Text>
                  <Text style={styles.ifaceType}>{iface.type ?? ''}</Text>
                </View>
              ))}
            </Card>
          </View>
        )}
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  root: { flex: 1, backgroundColor: colors.background },
  content: { padding: spacing.lg, gap: spacing.lg, paddingBottom: spacing.xxxl },
  header: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  greeting: {
    color: colors.textMuted,
    fontSize: typography.fontSizeSm,
    fontWeight: typography.fontWeightMedium,
  },
  routerName: {
    color: colors.text,
    fontSize: typography.fontSizeXl,
    fontWeight: typography.fontWeightBold,
  },
  section: { gap: spacing.sm },
  statsGrid: {
    flexDirection: 'row',
    gap: spacing.sm,
  },
  alertRow: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: spacing.sm,
    backgroundColor: colors.warningBg,
    borderRadius: radius.md,
    padding: spacing.md,
    borderWidth: 1,
    borderColor: colors.warning + '44',
  },
  alertError: {
    backgroundColor: colors.errorBg,
    borderColor: colors.error + '44',
  },
  alertText: {
    fontSize: typography.fontSizeSm,
    flex: 1,
  },
  userRow: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingVertical: spacing.sm,
    paddingHorizontal: spacing.md,
  },
  userRowBorder: {
    borderTopWidth: 1,
    borderTopColor: colors.border,
  },
  userInfo: { flex: 1, gap: 2 },
  userName: { color: colors.text, fontSize: typography.fontSizeSm, fontWeight: typography.fontWeightMedium },
  userMeta: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  ifaceRow: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: spacing.sm,
    paddingVertical: spacing.sm,
    paddingHorizontal: spacing.md,
  },
  ifaceStatus: { width: 8, height: 8, borderRadius: 4 },
  ifaceName: { color: colors.text, fontSize: typography.fontSizeSm, flex: 1 },
  ifaceType: { color: colors.textMuted, fontSize: typography.fontSizeXs },
});
