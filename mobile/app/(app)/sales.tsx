import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  FlatList,
  TouchableOpacity,
  RefreshControl,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import { useAuth } from '@/contexts/AuthContext';
import { supabase } from '@/lib/supabase';
import { Card } from '@/components/Card';
import { StatCard } from '@/components/StatCard';
import { SectionHeader } from '@/components/SectionHeader';
import { Badge } from '@/components/Badge';
import { LoadingSpinner } from '@/components/LoadingSpinner';
import { EmptyState } from '@/components/EmptyState';
import { colors, spacing, typography, radius } from '@/lib/theme';

type DateFilter = 'today' | 'week' | 'month' | 'all';

interface SaleRecord {
  id: string;
  profile_name: string | null;
  success_count: number;
  card_count: number;
  unit_price: number;
  total_amount: number;
  voucher_type: string | null;
  sales_point: string | null;
  notes: string | null;
  created_at: string;
}

function getDateRange(filter: DateFilter): { from: string | null } {
  const now = new Date();
  if (filter === 'today') {
    const d = new Date(now);
    d.setHours(0, 0, 0, 0);
    return { from: d.toISOString() };
  }
  if (filter === 'week') {
    const d = new Date(now);
    d.setDate(d.getDate() - 7);
    return { from: d.toISOString() };
  }
  if (filter === 'month') {
    const d = new Date(now);
    d.setDate(d.getDate() - 30);
    return { from: d.toISOString() };
  }
  return { from: null };
}

export default function SalesScreen() {
  const insets = useSafeAreaInsets();
  const { user } = useAuth();
  const [filter, setFilter] = useState<DateFilter>('today');
  const [sales, setSales] = useState<SaleRecord[]>([]);
  const [loading, setLoading] = useState(true);
  const [refreshing, setRefreshing] = useState(false);

  const fetchSales = async () => {
    if (!user) return;
    const { from } = getDateRange(filter);
    let query = supabase
      .from('sales')
      .select('*')
      .eq('user_id', user.id)
      .order('created_at', { ascending: false });
    if (from) query = query.gte('created_at', from);
    const { data } = await query;
    setSales((data as SaleRecord[]) || []);
    setLoading(false);
  };

  useEffect(() => {
    setLoading(true);
    fetchSales();
  }, [filter, user]);

  const onRefresh = async () => {
    setRefreshing(true);
    await fetchSales();
    setRefreshing(false);
  };

  const totalRevenue = sales.reduce((s, r) => s + (r.total_amount || 0), 0);
  const totalCards = sales.reduce((s, r) => s + (r.card_count || 0), 0);
  const totalSuccess = sales.reduce((s, r) => s + (r.success_count || 0), 0);

  const filterLabels: Record<DateFilter, string> = {
    today: 'اليوم',
    week: 'الأسبوع',
    month: 'الشهر',
    all: 'الكل',
  };

  if (loading) return <LoadingSpinner fullScreen />;

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <FlatList
        data={sales}
        keyExtractor={(r) => r.id}
        ListHeaderComponent={
          <>
            <View style={styles.header}>
              <Text style={styles.title}>المبيعات</Text>
            </View>

            {/* Filters */}
            <View style={styles.filtersRow}>
              {(Object.keys(filterLabels) as DateFilter[]).map((f) => (
                <TouchableOpacity
                  key={f}
                  style={[styles.filterChip, filter === f && styles.filterChipActive]}
                  onPress={() => setFilter(f)}
                >
                  <Text style={[styles.filterText, filter === f && styles.filterTextActive]}>
                    {filterLabels[f]}
                  </Text>
                </TouchableOpacity>
              ))}
            </View>

            {/* Summary Cards */}
            <View style={styles.statsRow}>
              <StatCard
                label="الإيراد"
                value={totalRevenue.toFixed(2)}
                unit="ر.س"
                color={colors.success}
                icon={<Ionicons name="cash-outline" size={16} color={colors.success} />}
              />
              <StatCard
                label="الكروت"
                value={totalCards}
                color={colors.primary}
                icon={<Ionicons name="card-outline" size={16} color={colors.primary} />}
              />
            </View>

            <View style={styles.sectionWrap}>
              <SectionHeader title={`السجلات (${sales.length})`} />
            </View>
          </>
        }
        renderItem={({ item: s }) => (
          <View style={styles.saleCard}>
            <View style={styles.saleHeader}>
              <View style={styles.saleInfo}>
                <Text style={styles.saleName}>{s.profile_name || 'غير محدد'}</Text>
                <Text style={styles.saleDate}>
                  {new Date(s.created_at).toLocaleString('ar')}
                </Text>
              </View>
              <Text style={styles.saleAmount}>{s.total_amount?.toFixed(2) || '0'} ر.س</Text>
            </View>
            <View style={styles.saleMeta}>
              <Badge label={`${s.card_count} كرت`} variant="info" />
              <Badge label={`${s.success_count} نجح`} variant="success" />
              {s.voucher_type && <Badge label={s.voucher_type} variant="muted" />}
            </View>
          </View>
        )}
        contentContainerStyle={styles.list}
        refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={colors.primary} />}
        ListEmptyComponent={
          <EmptyState
            title="لا توجد مبيعات"
            description="لم يتم تسجيل أي مبيعات في هذه الفترة"
            icon={<Ionicons name="bar-chart-outline" size={40} color={colors.textMuted} />}
          />
        }
        showsVerticalScrollIndicator={false}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  root: { flex: 1, backgroundColor: colors.background },
  header: {
    flexDirection: 'row', alignItems: 'center',
    paddingHorizontal: spacing.lg, paddingTop: spacing.md, paddingBottom: spacing.sm,
  },
  title: { color: colors.text, fontSize: typography.fontSizeXl, fontWeight: typography.fontWeightBold },
  filtersRow: {
    flexDirection: 'row',
    paddingHorizontal: spacing.lg,
    gap: spacing.sm,
    marginBottom: spacing.md,
  },
  filterChip: {
    paddingVertical: spacing.xs,
    paddingHorizontal: spacing.md,
    borderRadius: radius.full,
    backgroundColor: colors.surface2,
    borderWidth: 1,
    borderColor: colors.border,
  },
  filterChipActive: { backgroundColor: colors.primary, borderColor: colors.primary },
  filterText: { color: colors.textMuted, fontSize: typography.fontSizeSm },
  filterTextActive: { color: colors.text, fontWeight: typography.fontWeightSemiBold },
  statsRow: {
    flexDirection: 'row',
    paddingHorizontal: spacing.lg,
    gap: spacing.sm,
    marginBottom: spacing.md,
  },
  sectionWrap: { paddingHorizontal: spacing.lg },
  list: { paddingHorizontal: spacing.lg, paddingBottom: spacing.xxxl, gap: spacing.sm },
  saleCard: {
    backgroundColor: colors.surface,
    borderRadius: radius.lg,
    borderWidth: 1,
    borderColor: colors.border,
    padding: spacing.md,
    gap: spacing.sm,
  },
  saleHeader: { flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' },
  saleInfo: { flex: 1 },
  saleName: { color: colors.text, fontSize: typography.fontSizeSm, fontWeight: typography.fontWeightSemiBold },
  saleDate: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  saleAmount: { color: colors.success, fontSize: typography.fontSizeLg, fontWeight: typography.fontWeightBold },
  saleMeta: { flexDirection: 'row', gap: spacing.xs, flexWrap: 'wrap' },
});
