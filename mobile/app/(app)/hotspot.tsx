import React, { useState, useMemo, useCallback } from "react";
import {
  View, Text, StyleSheet, FlatList, TouchableOpacity,
  TextInput, Alert, RefreshControl,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import Animated, { FadeInDown } from "react-native-reanimated";
import { Ionicons } from "@expo/vector-icons";
import { useHotspotUsers, useHotspotAllUsers, useHotspotUserAction } from "@/hooks/useMikrotik";
import { Colors, Radius, Spacing } from "@/lib/theme";
import { formatSize } from "@/lib/utils";
import { ListRowSkeleton } from "@/components/SkeletonLoader";
import EmptyState from "@/components/EmptyState";
import Badge from "@/components/Badge";
import AnimatedPressable from "@/components/AnimatedPressable";
import { lightTap, notifySuccess, notifyError } from "@/lib/haptics";

type Tab = "active" | "all";

export default function HotspotScreen() {
  const [tab, setTab] = useState<Tab>("active");
  const [search, setSearch] = useState("");
  const [refreshing, setRefreshing] = useState(false);

  const { data: activeUsers, isLoading: loadingActive, refetch: refetchActive } = useHotspotUsers();
  const { data: allUsers, isLoading: loadingAll, refetch: refetchAll } = useHotspotAllUsers();
  const action = useHotspotUserAction();

  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    await Promise.all([refetchActive(), refetchAll()]);
    setRefreshing(false);
  }, []);

  const displayList = useMemo(() => {
    const list: any[] = (tab === "active" ? activeUsers : allUsers) || [];
    if (!search.trim()) return list;
    const q = search.trim().toLowerCase();
    return list.filter((u: any) =>
      (u.user || u.name || "").toLowerCase().includes(q) ||
      (u.address || "").toLowerCase().includes(q)
    );
  }, [tab, activeUsers, allUsers, search]);

  const isLoading = tab === "active" ? loadingActive : loadingAll;

  const handleAction = useCallback((user: any, act: string) => {
    const name = user.user || user.name || "المستخدم";
    const labels: Record<string, string> = { kick: "طرد", disable: "تعطيل", enable: "تفعيل", remove: "حذف" };
    Alert.alert(labels[act], `${labels[act]} ${name}؟`, [
      { text: "إلغاء", style: "cancel" },
      {
        text: labels[act],
        style: act === "remove" ? "destructive" : "default",
        onPress: () => action.mutate(
          { action: act, id: user[".id"] || user.id },
          { onSuccess: () => notifySuccess(), onError: () => notifyError() }
        ),
      },
    ]);
    lightTap();
  }, [action]);

  return (
    <SafeAreaView style={styles.safe} edges={["top"]}>
      {/* Header */}
      <View style={styles.header}>
        <Text style={styles.pageTitle}>الهوتسبوت</Text>
        {activeUsers && (
          <View style={styles.countBadge}>
            <View style={styles.countDot} />
            <Text style={styles.countText}>{Array.isArray(activeUsers) ? activeUsers.length : 0} متصل</Text>
          </View>
        )}
      </View>

      {/* Tabs */}
      <View style={styles.tabs}>
        {(["active", "all"] as Tab[]).map((t) => (
          <TouchableOpacity
            key={t}
            style={[styles.tab, tab === t && styles.tabActive]}
            onPress={() => { lightTap(); setTab(t); }}
          >
            <Text style={[styles.tabText, tab === t && styles.tabTextActive]}>
              {t === "active" ? "المتصلون" : "كل المستخدمين"}
            </Text>
          </TouchableOpacity>
        ))}
      </View>

      {/* Search */}
      <View style={styles.searchRow}>
        <Ionicons name="search-outline" size={16} color={Colors.mutedFg} />
        <TextInput
          style={styles.searchInput}
          placeholder="بحث باسم المستخدم أو IP..."
          placeholderTextColor={Colors.mutedFg}
          value={search}
          onChangeText={setSearch}
          textAlign="right"
        />
        {search ? (
          <TouchableOpacity onPress={() => setSearch("")}>
            <Ionicons name="close-circle" size={16} color={Colors.mutedFg} />
          </TouchableOpacity>
        ) : null}
      </View>

      {isLoading ? (
        <View style={styles.skeletonList}>
          {Array.from({ length: 5 }).map((_, i) => (
            <ListRowSkeleton key={i} lines={2} />
          ))}
        </View>
      ) : (
        <FlatList
          data={displayList}
          keyExtractor={(item, i) => item[".id"] || item.id || String(i)}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
          contentContainerStyle={styles.list}
          showsVerticalScrollIndicator={false}
          ListEmptyComponent={
            <EmptyState
              title="لا يوجد مستخدمون"
              subtitle={tab === "active" ? "لا يوجد مستخدمون متصلون حالياً" : "لا يوجد مستخدمون مضافون"}
            />
          }
          renderItem={({ item, index }) => {
            const disabled = item.disabled === "true" || item.disabled === true;
            return (
              <Animated.View entering={FadeInDown.delay(index * 30).springify()} style={styles.userCard}>
                <View style={styles.userHeader}>
                  <View style={styles.userAvatar}>
                    <Ionicons name="person" size={16} color={Colors.primaryLight} />
                  </View>
                  <View style={styles.userInfo}>
                    <Text style={styles.userName}>{item.user || item.name || "—"}</Text>
                    <Text style={styles.userMeta}>
                      {item.address || "—"}{item["mac-address"] ? ` • ${item["mac-address"]}` : ""}
                    </Text>
                  </View>
                  <Badge
                    label={disabled ? "معطل" : tab === "active" ? "متصل" : "نشط"}
                    variant={disabled ? "destructive" : "success"}
                  />
                </View>

                {tab === "active" && (
                  <View style={styles.statsRow}>
                    <Text style={styles.statItem}>⏱ {item.uptime || "—"}</Text>
                    <Text style={styles.statItem}>↓ {formatSize(item["bytes-in"])}</Text>
                    <Text style={styles.statItem}>↑ {formatSize(item["bytes-out"])}</Text>
                  </View>
                )}

                {(item["actual-profile"] || item.profile) && (
                  <Text style={styles.profileText}>باقة: {item["actual-profile"] || item.profile}</Text>
                )}

                <View style={styles.actionRow}>
                  {tab === "active" && (
                    <AnimatedPressable style={[styles.actionBtn, styles.kickBtn]} onPress={() => handleAction(item, "kick")}>
                      <Ionicons name="exit-outline" size={13} color={Colors.warning} />
                      <Text style={[styles.actionBtnText, { color: Colors.warning }]}>طرد</Text>
                    </AnimatedPressable>
                  )}
                  {disabled ? (
                    <AnimatedPressable style={[styles.actionBtn, styles.enableBtn]} onPress={() => handleAction(item, "enable")}>
                      <Ionicons name="checkmark-circle-outline" size={13} color={Colors.success} />
                      <Text style={[styles.actionBtnText, { color: Colors.success }]}>تفعيل</Text>
                    </AnimatedPressable>
                  ) : tab === "all" && (
                    <AnimatedPressable style={[styles.actionBtn, styles.disableBtn]} onPress={() => handleAction(item, "disable")}>
                      <Ionicons name="ban-outline" size={13} color={Colors.warning} />
                      <Text style={[styles.actionBtnText, { color: Colors.warning }]}>تعطيل</Text>
                    </AnimatedPressable>
                  )}
                  {tab === "all" && (
                    <AnimatedPressable style={[styles.actionBtn, styles.deleteBtn]} onPress={() => handleAction(item, "remove")}>
                      <Ionicons name="trash-outline" size={13} color={Colors.destructive} />
                      <Text style={[styles.actionBtnText, { color: Colors.destructive }]}>حذف</Text>
                    </AnimatedPressable>
                  )}
                </View>
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
  header: { flexDirection: "row", alignItems: "center", justifyContent: "space-between", paddingHorizontal: Spacing.lg, paddingVertical: Spacing.md },
  pageTitle: { fontSize: 22, fontWeight: "800", color: Colors.foreground, letterSpacing: -0.5 },
  countBadge: { flexDirection: "row", alignItems: "center", gap: 5, backgroundColor: Colors.successBg, paddingHorizontal: 10, paddingVertical: 4, borderRadius: Radius.full, borderWidth: 1, borderColor: Colors.successBorder },
  countDot: { width: 6, height: 6, borderRadius: 3, backgroundColor: Colors.success },
  countText: { fontSize: 11, fontWeight: "700", color: Colors.success },
  tabs: { flexDirection: "row", paddingHorizontal: Spacing.lg, gap: Spacing.xs, marginBottom: Spacing.sm },
  tab: { flex: 1, paddingVertical: 8, borderRadius: Radius.md, backgroundColor: Colors.muted, alignItems: "center" },
  tabActive: { backgroundColor: Colors.primary },
  tabText: { fontSize: 13, fontWeight: "600", color: Colors.mutedFg },
  tabTextActive: { color: "#fff" },
  searchRow: { flexDirection: "row", alignItems: "center", marginHorizontal: Spacing.lg, marginBottom: Spacing.sm, backgroundColor: Colors.card, borderWidth: 1, borderColor: Colors.border, borderRadius: Radius.md, paddingHorizontal: Spacing.sm, paddingVertical: 8, gap: 8 },
  searchInput: { flex: 1, fontSize: 13, color: Colors.foreground },
  skeletonList: { paddingHorizontal: Spacing.lg, gap: Spacing.sm },
  list: { paddingHorizontal: Spacing.lg, gap: Spacing.sm, paddingBottom: 90 },
  userCard: { backgroundColor: Colors.card, borderRadius: Radius.lg, borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: 8 },
  userHeader: { flexDirection: "row", alignItems: "center", gap: Spacing.sm },
  userAvatar: { width: 34, height: 34, borderRadius: 17, backgroundColor: "rgba(124,58,237,0.12)", alignItems: "center", justifyContent: "center" },
  userInfo: { flex: 1 },
  userName: { fontSize: 13, fontWeight: "700", color: Colors.foreground },
  userMeta: { fontSize: 10, color: Colors.mutedFg },
  statsRow: { flexDirection: "row", gap: Spacing.md, flexWrap: "wrap" },
  statItem: { fontSize: 11, color: Colors.textSecondary },
  profileText: { fontSize: 11, color: Colors.mutedFg, fontStyle: "italic" },
  actionRow: { flexDirection: "row", gap: 8, flexWrap: "wrap" },
  actionBtn: { flexDirection: "row", alignItems: "center", gap: 4, paddingHorizontal: 10, paddingVertical: 5, borderRadius: Radius.sm, borderWidth: 1 },
  actionBtnText: { fontSize: 11, fontWeight: "600" },
  kickBtn: { borderColor: Colors.warningBorder, backgroundColor: Colors.warningBg },
  enableBtn: { borderColor: Colors.successBorder, backgroundColor: Colors.successBg },
  disableBtn: { borderColor: Colors.warningBorder, backgroundColor: Colors.warningBg },
  deleteBtn: { borderColor: Colors.destructiveBorder, backgroundColor: Colors.destructiveBg },
});
