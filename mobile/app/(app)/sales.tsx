import React, { useState, useMemo, useCallback } from "react";
import {
  View, Text, StyleSheet, FlatList, TouchableOpacity,
  RefreshControl,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import Animated, { FadeInDown } from "react-native-reanimated";
import { useQuery } from "@tanstack/react-query";
import { useAuth } from "@/contexts/AuthContext";
import { supabase } from "@/lib/supabase";
import { Colors, Radius, Spacing } from "@/lib/theme";
import { formatDateTime } from "@/lib/utils";
import { ListRowSkeleton } from "@/components/SkeletonLoader";
import EmptyState from "@/components/EmptyState";
import StatCard from "@/components/StatCard";
import { lightTap, selectionChanged } from "@/lib/haptics";

type DateFilter = "today" | "week" | "month" | "all";

export default function SalesScreen() {
  const { user } = useAuth();
  const [dateFilter, setDateFilter] = useState<DateFilter>("today");
  const [refreshing, setRefreshing] = useState(false);

  const { data: sales, isLoading, refetch } = useQuery({
    queryKey: ["sales", user?.id],
    queryFn: async () => {
      if (!user?.id) return [];
      const { data, error } = await supabase
        .from("sales").select("*").eq("user_id", user.id)
        .order("created_at", { ascending: false }).limit(500);
      if (error) throw error;
      return data || [];
    },
    enabled: !!user?.id,
  });

  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    await refetch();
    setRefreshing(false);
  }, []);

  const filteredSales = useMemo(() => {
    if (!sales) return [];
    const now = new Date();
    let filtered = [...(sales as any[])];
    if (dateFilter === "today") filtered = filtered.filter((s) => new Date(s.created_at).toDateString() === now.toDateString());
    else if (dateFilter === "week") { const w = new Date(now.getTime() - 7 * 86400000); filtered = filtered.filter((s) => new Date(s.created_at) >= w); }
    else if (dateFilter === "month") { const m = new Date(now.getTime() - 30 * 86400000); filtered = filtered.filter((s) => new Date(s.created_at) >= m); }
    return filtered;
  }, [sales, dateFilter]);

  const totalRevenue = useMemo(() => filteredSales.reduce((s: number, r: any) => s + Number(r.total_amount || 0), 0), [filteredSales]);
  const totalCards = useMemo(() => filteredSales.reduce((s: number, r: any) => s + (r.success_count || 0), 0), [filteredSales]);
  const filterLabels: Record<DateFilter, string> = { today: "اليوم", week: "الأسبوع", month: "الشهر", all: "الكل" };

  return (
    <SafeAreaView style={styles.safe} edges={["top"]}>
      <View style={styles.header}>
        <Text style={styles.pageTitle}>المبيعات</Text>
      </View>

      {/* Date Filter */}
      <View style={styles.filterRow}>
        {(["today", "week", "month", "all"] as DateFilter[]).map((f) => (
          <TouchableOpacity
            key={f}
            style={[styles.filterChip, dateFilter === f && styles.filterChipActive]}
            onPress={() => { selectionChanged(); setDateFilter(f); }}
          >
            <Text style={[styles.filterText, dateFilter === f && styles.filterTextActive]}>
              {filterLabels[f]}
            </Text>
          </TouchableOpacity>
        ))}
      </View>

      {/* Summary Stats */}
      {isLoading ? (
        <View style={styles.summary}>
          {Array.from({ length: 3 }).map((_, i) => <View key={i} style={{ flex: 1, height: 62, backgroundColor: Colors.card, borderRadius: Radius.md, borderWidth: 1, borderColor: Colors.cardBorder }} />)}
        </View>
      ) : (
        <View style={styles.summary}>
          <StatCard title="الإيرادات" value={totalRevenue.toLocaleString()} subtitle="ريال" variant="accent" delay={0} />
          <StatCard title="الكروت" value={totalCards} subtitle="كرت" delay={60} />
          <StatCard title="العمليات" value={filteredSales.length} delay={120} />
        </View>
      )}

      {/* List */}
      {isLoading ? (
        <View style={styles.list}>
          {Array.from({ length: 5 }).map((_, i) => <ListRowSkeleton key={i} lines={2} />)}
        </View>
      ) : (
        <FlatList
          data={filteredSales}
          keyExtractor={(item) => item.id}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
          contentContainerStyle={styles.list}
          showsVerticalScrollIndicator={false}
          ListEmptyComponent={<EmptyState title="لا توجد مبيعات" subtitle="لا توجد مبيعات في هذه الفترة" />}
          renderItem={({ item, index }) => (
            <Animated.View entering={FadeInDown.delay(index * 25).springify()} style={styles.saleCard}>
              <View style={styles.saleTop}>
                <View style={styles.saleInfo}>
                  <Text style={styles.saleName}>{item.profile_name || "—"}</Text>
                  <Text style={styles.saleDate}>{formatDateTime(item.created_at)}</Text>
                  {item.sales_point ? <Text style={styles.saleMeta}>📍 {item.sales_point}</Text> : null}
                </View>
                <View style={styles.saleStats}>
                  <Text style={styles.saleRevenue}>{Number(item.total_amount || 0).toLocaleString()} ر</Text>
                  <View style={styles.saleCountRow}>
                    <View style={styles.successBadge}>
                      <Text style={styles.successText}>✓ {item.success_count || 0}</Text>
                    </View>
                    {item.fail_count > 0 ? (
                      <View style={styles.failBadge}>
                        <Text style={styles.failText}>✗ {item.fail_count}</Text>
                      </View>
                    ) : null}
                  </View>
                </View>
              </View>
            </Animated.View>
          )}
        />
      )}
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  header: { paddingHorizontal: Spacing.lg, paddingVertical: Spacing.md },
  pageTitle: { fontSize: 22, fontWeight: "800", color: Colors.foreground, letterSpacing: -0.5 },
  filterRow: { flexDirection: "row", paddingHorizontal: Spacing.lg, gap: Spacing.xs, marginBottom: Spacing.sm },
  filterChip: { flex: 1, paddingVertical: 8, borderRadius: Radius.md, backgroundColor: Colors.muted, alignItems: "center" },
  filterChipActive: { backgroundColor: Colors.primary },
  filterText: { fontSize: 12, fontWeight: "600", color: Colors.mutedFg },
  filterTextActive: { color: "#fff" },
  summary: { flexDirection: "row", gap: Spacing.sm, paddingHorizontal: Spacing.lg, marginBottom: Spacing.sm },
  list: { paddingHorizontal: Spacing.lg, gap: Spacing.sm, paddingBottom: 90 },
  saleCard: { backgroundColor: Colors.card, borderRadius: Radius.lg, borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md },
  saleTop: { flexDirection: "row", gap: Spacing.sm },
  saleInfo: { flex: 1, gap: 3 },
  saleName: { fontSize: 14, fontWeight: "700", color: Colors.foreground },
  saleDate: { fontSize: 10, color: Colors.mutedFg },
  saleMeta: { fontSize: 11, color: Colors.textSecondary },
  saleStats: { alignItems: "flex-end", gap: 4 },
  saleRevenue: { fontSize: 16, fontWeight: "700", color: Colors.foreground },
  saleCountRow: { flexDirection: "row", gap: 4 },
  successBadge: { backgroundColor: Colors.successBg, paddingHorizontal: 7, paddingVertical: 2, borderRadius: Radius.full },
  successText: { fontSize: 10, fontWeight: "700", color: Colors.success },
  failBadge: { backgroundColor: Colors.destructiveBg, paddingHorizontal: 7, paddingVertical: 2, borderRadius: Radius.full },
  failText: { fontSize: 10, fontWeight: "700", color: Colors.destructive },
});
