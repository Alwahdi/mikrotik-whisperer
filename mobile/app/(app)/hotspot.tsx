import React, { useState, useMemo } from "react";
import {
  View, Text, StyleSheet, FlatList, TouchableOpacity,
  TextInput, Alert, RefreshControl,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { Ionicons } from "@expo/vector-icons";
import { useHotspotUsers, useHotspotAllUsers, useHotspotProfiles, useHotspotUserAction } from "@/hooks/useMikrotik";
import { Colors, Radius, Spacing } from "@/lib/theme";
import { formatSize } from "@/lib/utils";
import LoadingView from "@/components/LoadingView";
import EmptyState from "@/components/EmptyState";
import Badge from "@/components/Badge";

type Tab = "active" | "all";

export default function HotspotScreen() {
  const [tab, setTab] = useState<Tab>("active");
  const [search, setSearch] = useState("");
  const [refreshing, setRefreshing] = useState(false);

  const { data: activeUsers, isLoading: loadingActive, refetch: refetchActive } = useHotspotUsers();
  const { data: allUsers, isLoading: loadingAll, refetch: refetchAll } = useHotspotAllUsers();
  const { data: profiles } = useHotspotProfiles();
  const action = useHotspotUserAction();

  const onRefresh = async () => {
    setRefreshing(true);
    await Promise.all([refetchActive(), refetchAll()]);
    setRefreshing(false);
  };

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

  const handleAction = (user: any, act: string) => {
    const name = user.user || user.name || "المستخدم";
    const labels: Record<string, string> = {
      kick: "طرد",
      disable: "تعطيل",
      enable: "تفعيل",
      remove: "حذف",
    };
    Alert.alert(labels[act] || act, `هل تريد ${labels[act]} ${name}؟`, [
      { text: "إلغاء", style: "cancel" },
      {
        text: labels[act],
        style: act === "remove" ? "destructive" : "default",
        onPress: () => {
          action.mutate(
            { action: act, id: user[".id"] || user.id },
            {
              onSuccess: () => Alert.alert("تم", `تم ${labels[act]} ${name}`),
            }
          );
        },
      },
    ]);
  };

  return (
    <SafeAreaView style={styles.safe}>
      {/* Header */}
      <View style={styles.header}>
        <Text style={styles.pageTitle}>الهوتسبوت</Text>
        <View style={styles.counters}>
          {activeUsers && (
            <View style={styles.countBadge}>
              <View style={styles.countDot} />
              <Text style={styles.countText}>{Array.isArray(activeUsers) ? activeUsers.length : 0} متصل</Text>
            </View>
          )}
        </View>
      </View>

      {/* Tabs */}
      <View style={styles.tabs}>
        {(["active", "all"] as Tab[]).map((t) => (
          <TouchableOpacity
            key={t}
            style={[styles.tab, tab === t && styles.tabActive]}
            onPress={() => setTab(t)}
          >
            <Text style={[styles.tabText, tab === t && styles.tabTextActive]}>
              {t === "active" ? "المتصلون" : "كل المستخدمين"}
            </Text>
          </TouchableOpacity>
        ))}
      </View>

      {/* Search */}
      <View style={styles.searchRow}>
        <Ionicons name="search-outline" size={16} color={Colors.mutedFg} style={styles.searchIcon} />
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
        <LoadingView />
      ) : (
        <FlatList
          data={displayList}
          keyExtractor={(item, i) => item[".id"] || item.id || String(i)}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
          contentContainerStyle={styles.list}
          ListEmptyComponent={
            <EmptyState
              title="لا يوجد مستخدمون"
              subtitle={tab === "active" ? "لا يوجد مستخدمون متصلون حالياً" : "لا يوجد مستخدمون مضافون"}
            />
          }
          renderItem={({ item }) => (
            <View style={styles.userCard}>
              <View style={styles.userHeader}>
                <View style={styles.userAvatar}>
                  <Ionicons name="person" size={16} color={Colors.primaryLight} />
                </View>
                <View style={styles.userInfo}>
                  <Text style={styles.userName}>{item.user || item.name || "—"}</Text>
                  <Text style={styles.userMeta}>
                    {item.address || "—"}
                    {item["mac-address"] ? ` • ${item["mac-address"]}` : ""}
                  </Text>
                </View>
                {item.disabled === "true" || item.disabled === true ? (
                  <Badge label="معطل" variant="destructive" />
                ) : tab === "active" ? (
                  <Badge label="متصل" variant="success" />
                ) : (
                  <Badge label="نشط" variant="success" />
                )}
              </View>

              {tab === "active" && (
                <View style={styles.statsRow}>
                  <Text style={styles.statItem}>⏱ {item.uptime || "—"}</Text>
                  <Text style={styles.statItem}>↓ {formatSize(item["bytes-in"])}</Text>
                  <Text style={styles.statItem}>↑ {formatSize(item["bytes-out"])}</Text>
                </View>
              )}

              {item["actual-profile"] || item.profile ? (
                <Text style={styles.profileText}>
                  باقة: {item["actual-profile"] || item.profile}
                </Text>
              ) : null}

              <View style={styles.actionRow}>
                {tab === "active" && (
                  <TouchableOpacity
                    style={[styles.actionBtn, styles.kickBtn]}
                    onPress={() => handleAction(item, "kick")}
                  >
                    <Ionicons name="exit-outline" size={14} color={Colors.warning} />
                    <Text style={[styles.actionBtnText, { color: Colors.warning }]}>طرد</Text>
                  </TouchableOpacity>
                )}
                {item.disabled === "true" || item.disabled === true ? (
                  <TouchableOpacity
                    style={[styles.actionBtn, styles.enableBtn]}
                    onPress={() => handleAction(item, "enable")}
                  >
                    <Ionicons name="checkmark-circle-outline" size={14} color={Colors.success} />
                    <Text style={[styles.actionBtnText, { color: Colors.success }]}>تفعيل</Text>
                  </TouchableOpacity>
                ) : (
                  tab === "all" && (
                    <TouchableOpacity
                      style={[styles.actionBtn, styles.disableBtn]}
                      onPress={() => handleAction(item, "disable")}
                    >
                      <Ionicons name="ban-outline" size={14} color={Colors.warning} />
                      <Text style={[styles.actionBtnText, { color: Colors.warning }]}>تعطيل</Text>
                    </TouchableOpacity>
                  )
                )}
                {tab === "all" && (
                  <TouchableOpacity
                    style={[styles.actionBtn, styles.deleteBtn]}
                    onPress={() => handleAction(item, "remove")}
                  >
                    <Ionicons name="trash-outline" size={14} color={Colors.destructive} />
                    <Text style={[styles.actionBtnText, { color: Colors.destructive }]}>حذف</Text>
                  </TouchableOpacity>
                )}
              </View>
            </View>
          )}
        />
      )}
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  header: {
    flexDirection: "row", alignItems: "center", justifyContent: "space-between",
    paddingHorizontal: Spacing.lg, paddingVertical: Spacing.md,
  },
  pageTitle: { fontSize: 20, fontWeight: "800", color: Colors.foreground },
  counters: { flexDirection: "row", gap: 8 },
  countBadge: {
    flexDirection: "row", alignItems: "center", gap: 5,
    backgroundColor: Colors.successBg, paddingHorizontal: 10, paddingVertical: 4,
    borderRadius: Radius.full,
  },
  countDot: { width: 6, height: 6, borderRadius: 3, backgroundColor: Colors.success },
  countText: { fontSize: 11, fontWeight: "600", color: Colors.success },
  tabs: {
    flexDirection: "row", paddingHorizontal: Spacing.lg, gap: Spacing.xs, marginBottom: Spacing.sm,
  },
  tab: {
    flex: 1, paddingVertical: 8, borderRadius: Radius.md,
    backgroundColor: Colors.muted, alignItems: "center",
  },
  tabActive: { backgroundColor: Colors.primary },
  tabText: { fontSize: 13, fontWeight: "500", color: Colors.mutedFg },
  tabTextActive: { color: "#fff" },
  searchRow: {
    flexDirection: "row", alignItems: "center",
    marginHorizontal: Spacing.lg, marginBottom: Spacing.sm,
    backgroundColor: Colors.card, borderWidth: 1, borderColor: Colors.border,
    borderRadius: Radius.md, paddingHorizontal: Spacing.sm, paddingVertical: 8,
    gap: 8,
  },
  searchIcon: {},
  searchInput: { flex: 1, fontSize: 13, color: Colors.foreground },
  list: { paddingHorizontal: Spacing.lg, gap: Spacing.sm, paddingBottom: 24 },
  userCard: {
    backgroundColor: Colors.card, borderRadius: Radius.lg,
    borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: 8,
  },
  userHeader: { flexDirection: "row", alignItems: "center", gap: Spacing.sm },
  userAvatar: {
    width: 32, height: 32, borderRadius: 16,
    backgroundColor: "rgba(124,58,237,0.12)", alignItems: "center", justifyContent: "center",
  },
  userInfo: { flex: 1 },
  userName: { fontSize: 13, fontWeight: "600", color: Colors.foreground },
  userMeta: { fontSize: 10, color: Colors.mutedFg, fontFamily: "Courier" },
  statsRow: { flexDirection: "row", gap: Spacing.sm, flexWrap: "wrap" },
  statItem: { fontSize: 11, color: Colors.textSecondary, fontFamily: "Courier" },
  profileText: { fontSize: 11, color: Colors.mutedFg },
  actionRow: { flexDirection: "row", gap: 8, flexWrap: "wrap" },
  actionBtn: {
    flexDirection: "row", alignItems: "center", gap: 4,
    paddingHorizontal: 10, paddingVertical: 5, borderRadius: Radius.sm,
    borderWidth: 1,
  },
  actionBtnText: { fontSize: 11, fontWeight: "500" },
  kickBtn: { borderColor: "rgba(245,158,11,0.3)", backgroundColor: Colors.warningBg },
  enableBtn: { borderColor: "rgba(34,197,94,0.3)", backgroundColor: Colors.successBg },
  disableBtn: { borderColor: "rgba(245,158,11,0.3)", backgroundColor: Colors.warningBg },
  deleteBtn: { borderColor: "rgba(239,68,68,0.3)", backgroundColor: Colors.destructiveBg },
});
