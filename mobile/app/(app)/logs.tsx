import React, { useState, useMemo, useCallback } from "react";
import {
  View,
  Text,
  StyleSheet,
  FlatList,
  TouchableOpacity,
  RefreshControl,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import Animated, { FadeInDown } from "react-native-reanimated";
import { Ionicons } from "@expo/vector-icons";
import { useSystemLogs } from "@/hooks/useMikrotik";
import { Colors, Radius, Spacing } from "@/lib/theme";
import { ListRowSkeleton } from "@/components/SkeletonLoader";
import EmptyState from "@/components/EmptyState";
import { selectionChanged } from "@/lib/haptics";

type TopicFilter = "all" | "error" | "warning" | "info" | "critical";

const TOPIC_FILTERS: { key: TopicFilter; label: string }[] = [
  { key: "all", label: "الكل" },
  { key: "critical", label: "حرج" },
  { key: "error", label: "خطأ" },
  { key: "warning", label: "تحذير" },
  { key: "info", label: "معلومات" },
];

function getLogVariant(topics: string): {
  color: string;
  bg: string;
  border: string;
  icon: keyof typeof Ionicons.glyphMap;
} {
  const t = (topics || "").toLowerCase();
  if (t.includes("critical")) {
    return {
      color: Colors.destructive,
      bg: Colors.destructiveBg,
      border: Colors.destructiveBorder,
      icon: "alert-circle-outline",
    };
  }
  if (t.includes("error")) {
    return {
      color: Colors.destructive,
      bg: Colors.destructiveBg,
      border: Colors.destructiveBorder,
      icon: "close-circle-outline",
    };
  }
  if (t.includes("warning")) {
    return {
      color: Colors.warning,
      bg: Colors.warningBg,
      border: Colors.warningBorder,
      icon: "warning-outline",
    };
  }
  return {
    color: Colors.textSecondary,
    bg: Colors.muted,
    border: Colors.border,
    icon: "information-circle-outline",
  };
}

function matchesFilter(topics: string, filter: TopicFilter): boolean {
  if (filter === "all") return true;
  const t = (topics || "").toLowerCase();
  if (filter === "critical") return t.includes("critical");
  if (filter === "error") return t.includes("error") || t.includes("critical");
  if (filter === "warning") return t.includes("warning");
  // "info" catches all remaining logs (system, script, dhcp, etc. without error/warning/critical)
  if (filter === "info") return !t.includes("error") && !t.includes("warning") && !t.includes("critical");
  return true;
}

export default function LogsScreen() {
  const [topicFilter, setTopicFilter] = useState<TopicFilter>("all");
  const [refreshing, setRefreshing] = useState(false);

  const { data: logs, isLoading, refetch } = useSystemLogs();

  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    await refetch();
    setRefreshing(false);
  }, [refetch]);

  const filteredLogs = useMemo(() => {
    const list: any[] = Array.isArray(logs) ? logs : [];
    return list.filter((entry: any) =>
      matchesFilter(entry.topics || "", topicFilter)
    );
  }, [logs, topicFilter]);

  const logCounts = useMemo(() => {
    const list: any[] = Array.isArray(logs) ? logs : [];
    return {
      critical: list.filter((e: any) => (e.topics || "").toLowerCase().includes("critical")).length,
      error: list.filter((e: any) => {
        const t = (e.topics || "").toLowerCase();
        return t.includes("error") && !t.includes("critical");
      }).length,
      warning: list.filter((e: any) => (e.topics || "").toLowerCase().includes("warning")).length,
    };
  }, [logs]);

  return (
    <SafeAreaView style={styles.safe} edges={["top"]}>
      {/* Header */}
      <View style={styles.header}>
        <Text style={styles.pageTitle}>سجل النظام</Text>
        {!isLoading && Array.isArray(logs) && (
          <View style={styles.countPill}>
            <Text style={styles.countText}>{logs.length} سطر</Text>
          </View>
        )}
      </View>

      {/* Summary badges */}
      {!isLoading && (logCounts.critical > 0 || logCounts.error > 0 || logCounts.warning > 0) && (
        <View style={styles.summaryRow}>
          {logCounts.critical > 0 && (
            <View style={[styles.summaryChip, { backgroundColor: Colors.destructiveBg, borderColor: Colors.destructiveBorder }]}>
              <Ionicons name="alert-circle-outline" size={12} color={Colors.destructive} />
              <Text style={[styles.summaryText, { color: Colors.destructive }]}>{logCounts.critical} حرج</Text>
            </View>
          )}
          {logCounts.error > 0 && (
            <View style={[styles.summaryChip, { backgroundColor: Colors.destructiveBg, borderColor: Colors.destructiveBorder }]}>
              <Ionicons name="close-circle-outline" size={12} color={Colors.destructive} />
              <Text style={[styles.summaryText, { color: Colors.destructive }]}>{logCounts.error} خطأ</Text>
            </View>
          )}
          {logCounts.warning > 0 && (
            <View style={[styles.summaryChip, { backgroundColor: Colors.warningBg, borderColor: Colors.warningBorder }]}>
              <Ionicons name="warning-outline" size={12} color={Colors.warning} />
              <Text style={[styles.summaryText, { color: Colors.warning }]}>{logCounts.warning} تحذير</Text>
            </View>
          )}
        </View>
      )}

      {/* Topic Filter */}
      <View style={styles.filterRow}>
        {TOPIC_FILTERS.map((f) => (
          <TouchableOpacity
            key={f.key}
            style={[styles.filterChip, topicFilter === f.key && styles.filterChipActive]}
            onPress={() => { selectionChanged(); setTopicFilter(f.key); }}
          >
            <Text style={[styles.filterText, topicFilter === f.key && styles.filterTextActive]}>
              {f.label}
            </Text>
          </TouchableOpacity>
        ))}
      </View>

      {isLoading ? (
        <View style={styles.skeletonList}>
          {Array.from({ length: 8 }).map((_, i) => (
            <ListRowSkeleton key={i} lines={2} />
          ))}
        </View>
      ) : (
        <FlatList
          data={filteredLogs}
          keyExtractor={(item, i) => item[".id"] || String(i)}
          refreshControl={
            <RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />
          }
          contentContainerStyle={styles.list}
          showsVerticalScrollIndicator={false}
          ListEmptyComponent={
            <EmptyState
              title="لا توجد سجلات"
              subtitle="لا توجد إدخالات تطابق الفلتر المحدد"
            />
          }
          renderItem={({ item, index }) => {
            const variant = getLogVariant(item.topics || "");
            return (
              <Animated.View
                entering={FadeInDown.delay(Math.min(index * 20, 300)).springify()}
                style={[styles.logCard, { backgroundColor: variant.bg, borderColor: variant.border }]}
              >
                <View style={styles.logHeader}>
                  <Ionicons name={variant.icon} size={14} color={variant.color} />
                  <Text style={[styles.logTopics, { color: variant.color }]}>
                    {item.topics || "system"}
                  </Text>
                  <Text style={styles.logTime}>{item.time || "—"}</Text>
                </View>
                <Text style={styles.logMessage}>{item.message || "—"}</Text>
              </Animated.View>
            );
          }}
        />
      )}
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  header: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
    paddingHorizontal: Spacing.lg,
    paddingVertical: Spacing.md,
  },
  pageTitle: { fontSize: 22, fontWeight: "800", color: Colors.foreground, letterSpacing: -0.5 },
  countPill: {
    backgroundColor: Colors.muted,
    paddingHorizontal: 10,
    paddingVertical: 4,
    borderRadius: Radius.full,
    borderWidth: 1,
    borderColor: Colors.border,
  },
  countText: { fontSize: 11, fontWeight: "700", color: Colors.textSecondary },
  summaryRow: {
    flexDirection: "row",
    flexWrap: "wrap",
    gap: Spacing.xs,
    paddingHorizontal: Spacing.lg,
    marginBottom: Spacing.xs,
  },
  summaryChip: {
    flexDirection: "row",
    alignItems: "center",
    gap: 4,
    paddingHorizontal: 8,
    paddingVertical: 3,
    borderRadius: Radius.full,
    borderWidth: 1,
  },
  summaryText: { fontSize: 11, fontWeight: "700" },
  filterRow: {
    flexDirection: "row",
    paddingHorizontal: Spacing.lg,
    gap: Spacing.xs,
    marginBottom: Spacing.sm,
    flexWrap: "wrap",
  },
  filterChip: {
    paddingHorizontal: 12,
    paddingVertical: 6,
    borderRadius: Radius.md,
    backgroundColor: Colors.muted,
  },
  filterChipActive: { backgroundColor: Colors.primary },
  filterText: { fontSize: 12, fontWeight: "600", color: Colors.mutedFg },
  filterTextActive: { color: "#fff" },
  skeletonList: { paddingHorizontal: Spacing.lg, gap: Spacing.xs },
  list: { paddingHorizontal: Spacing.lg, gap: Spacing.xs, paddingBottom: 90 },
  logCard: {
    borderRadius: Radius.md,
    borderWidth: 1,
    padding: Spacing.sm,
    gap: 4,
  },
  logHeader: { flexDirection: "row", alignItems: "center", gap: 6 },
  logTopics: {
    flex: 1,
    fontSize: 11,
    fontWeight: "700",
    textTransform: "uppercase",
    letterSpacing: 0.4,
  },
  logTime: { fontSize: 10, color: Colors.mutedFg, fontFamily: "Courier" },
  logMessage: { fontSize: 12, color: Colors.foreground, lineHeight: 17 },
});
