import React, { useState, useMemo } from "react";
import {
  View, Text, StyleSheet, FlatList, TouchableOpacity,
  TextInput, Alert, RefreshControl, Modal, ScrollView,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { Ionicons } from "@expo/vector-icons";
import {
  useUserManagerUsers, useUserManagerProfiles, useUserManagerSessions,
  useUserManagerAction,
} from "@/hooks/useMikrotik";
import { Colors, Radius, Spacing } from "@/lib/theme";
import LoadingView from "@/components/LoadingView";
import EmptyState from "@/components/EmptyState";
import Badge from "@/components/Badge";

type Tab = "users" | "profiles" | "sessions";

export default function UserManagerScreen() {
  const [tab, setTab] = useState<Tab>("users");
  const [search, setSearch] = useState("");
  const [refreshing, setRefreshing] = useState(false);

  const { data: users, isLoading: loadingUsers, refetch: refetchUsers } = useUserManagerUsers({ enabled: tab === "users" });
  const { data: profiles, isLoading: loadingProfiles, refetch: refetchProfiles } = useUserManagerProfiles({ enabled: tab === "profiles" });
  const { data: sessions, isLoading: loadingSessions, refetch: refetchSessions } = useUserManagerSessions({ enabled: tab === "sessions" });
  const action = useUserManagerAction();

  const onRefresh = async () => {
    setRefreshing(true);
    if (tab === "users") await refetchUsers();
    if (tab === "profiles") await refetchProfiles();
    if (tab === "sessions") await refetchSessions();
    setRefreshing(false);
  };

  const filteredUsers = useMemo(() => {
    const list: any[] = (users as any[]) || [];
    if (!search.trim()) return list;
    const q = search.toLowerCase();
    return list.filter((u: any) =>
      (u.username || u.name || "").toLowerCase().includes(q)
    );
  }, [users, search]);

  const userList = Array.isArray(users) ? users : [];
  const profileList = Array.isArray(profiles) ? profiles : [];
  const sessionList = Array.isArray(sessions) ? sessions : [];

  const handleUserAction = (user: any, act: string) => {
    const name = user.username || user.name || "المستخدم";
    const labels: Record<string, string> = { disable: "تعطيل", enable: "تفعيل", remove: "حذف" };
    Alert.alert(labels[act] || act, `${labels[act]} ${name}؟`, [
      { text: "إلغاء", style: "cancel" },
      {
        text: labels[act],
        style: act === "remove" ? "destructive" : "default",
        onPress: () => action.mutate(
          { action: act, id: user[".id"] },
          { onSuccess: () => { refetchUsers(); Alert.alert("تم", `تم ${labels[act]} ${name}`); } }
        ),
      },
    ]);
  };

  const isLoading =
    (tab === "users" && loadingUsers) ||
    (tab === "profiles" && loadingProfiles) ||
    (tab === "sessions" && loadingSessions);

  return (
    <SafeAreaView style={styles.safe}>
      <View style={styles.header}>
        <Text style={styles.pageTitle}>يوزر مانجر</Text>
        {users && (
          <Text style={styles.counter}>{userList.length} مستخدم</Text>
        )}
      </View>

      {/* Tabs */}
      <View style={styles.tabs}>
        {(["users", "profiles", "sessions"] as Tab[]).map((t) => (
          <TouchableOpacity
            key={t}
            style={[styles.tab, tab === t && styles.tabActive]}
            onPress={() => setTab(t)}
          >
            <Text style={[styles.tabText, tab === t && styles.tabTextActive]}>
              {t === "users" ? "المستخدمون" : t === "profiles" ? "الباقات" : "الجلسات"}
            </Text>
          </TouchableOpacity>
        ))}
      </View>

      {tab === "users" && (
        <View style={styles.searchRow}>
          <Ionicons name="search-outline" size={16} color={Colors.mutedFg} />
          <TextInput
            style={styles.searchInput}
            placeholder="بحث باسم المستخدم..."
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
      )}

      {isLoading ? (
        <LoadingView />
      ) : tab === "users" ? (
        <FlatList
          data={filteredUsers}
          keyExtractor={(item, i) => item[".id"] || String(i)}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
          contentContainerStyle={styles.list}
          ListEmptyComponent={<EmptyState title="لا يوجد مستخدمون" />}
          renderItem={({ item }) => {
            const disabled = item.disabled === "true" || item.disabled === true;
            return (
              <View style={styles.userCard}>
                <View style={styles.userHeader}>
                  <View style={styles.userAvatar}>
                    <Ionicons name="person" size={16} color={Colors.primaryLight} />
                  </View>
                  <View style={styles.userInfo}>
                    <Text style={styles.userName}>{item.username || item.name || "—"}</Text>
                    <Text style={styles.userMeta}>
                      {item["actual-profile"] || item.group || "—"}
                    </Text>
                  </View>
                  <Badge
                    label={disabled ? "معطل" : "نشط"}
                    variant={disabled ? "destructive" : "success"}
                  />
                </View>
                <View style={styles.actionRow}>
                  {disabled ? (
                    <TouchableOpacity style={[styles.btn, styles.enableBtn]} onPress={() => handleUserAction(item, "enable")}>
                      <Ionicons name="checkmark-circle-outline" size={14} color={Colors.success} />
                      <Text style={[styles.btnText, { color: Colors.success }]}>تفعيل</Text>
                    </TouchableOpacity>
                  ) : (
                    <TouchableOpacity style={[styles.btn, styles.disableBtn]} onPress={() => handleUserAction(item, "disable")}>
                      <Ionicons name="ban-outline" size={14} color={Colors.warning} />
                      <Text style={[styles.btnText, { color: Colors.warning }]}>تعطيل</Text>
                    </TouchableOpacity>
                  )}
                  <TouchableOpacity style={[styles.btn, styles.deleteBtn]} onPress={() => handleUserAction(item, "remove")}>
                    <Ionicons name="trash-outline" size={14} color={Colors.destructive} />
                    <Text style={[styles.btnText, { color: Colors.destructive }]}>حذف</Text>
                  </TouchableOpacity>
                </View>
              </View>
            );
          }}
        />
      ) : tab === "profiles" ? (
        <FlatList
          data={profileList}
          keyExtractor={(item, i) => item[".id"] || String(i)}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
          contentContainerStyle={styles.list}
          ListEmptyComponent={<EmptyState title="لا توجد باقات" />}
          renderItem={({ item }) => (
            <View style={styles.profileCard}>
              <Text style={styles.profileName}>{item.name}</Text>
              {item.price ? <Text style={styles.profileMeta}>السعر: {item.price}</Text> : null}
              {item.validity ? <Text style={styles.profileMeta}>الصلاحية: {item.validity}</Text> : null}
              {item["rate-limit"] ? <Text style={styles.profileMeta}>السرعة: {item["rate-limit"]}</Text> : null}
              {item["shared-users"] ? <Text style={styles.profileMeta}>مشاركة: {item["shared-users"]}</Text> : null}
            </View>
          )}
        />
      ) : (
        <FlatList
          data={sessionList}
          keyExtractor={(item, i) => item[".id"] || String(i)}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
          contentContainerStyle={styles.list}
          ListEmptyComponent={<EmptyState title="لا توجد جلسات" />}
          renderItem={({ item }) => (
            <View style={styles.sessionCard}>
              <View style={styles.userHeader}>
                <View style={styles.userAvatar}>
                  <Ionicons name="time-outline" size={16} color={Colors.primaryLight} />
                </View>
                <View style={styles.userInfo}>
                  <Text style={styles.userName}>{item.user || "—"}</Text>
                  <Text style={styles.userMeta}>{item["from-time"] || "—"}</Text>
                </View>
                <Badge
                  label={item.active === "true" || item.active === true ? "نشطة" : "منتهية"}
                  variant={item.active === "true" || item.active === true ? "success" : "default"}
                />
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
  counter: { fontSize: 12, color: Colors.mutedFg },
  tabs: { flexDirection: "row", paddingHorizontal: Spacing.lg, gap: Spacing.xs, marginBottom: Spacing.sm },
  tab: { flex: 1, paddingVertical: 8, borderRadius: Radius.md, backgroundColor: Colors.muted, alignItems: "center" },
  tabActive: { backgroundColor: Colors.primary },
  tabText: { fontSize: 11, fontWeight: "500", color: Colors.mutedFg },
  tabTextActive: { color: "#fff" },
  searchRow: {
    flexDirection: "row", alignItems: "center",
    marginHorizontal: Spacing.lg, marginBottom: Spacing.sm,
    backgroundColor: Colors.card, borderWidth: 1, borderColor: Colors.border,
    borderRadius: Radius.md, paddingHorizontal: Spacing.sm, paddingVertical: 8, gap: 8,
  },
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
  userMeta: { fontSize: 10, color: Colors.mutedFg },
  actionRow: { flexDirection: "row", gap: 8 },
  btn: {
    flexDirection: "row", alignItems: "center", gap: 4,
    paddingHorizontal: 10, paddingVertical: 5, borderRadius: Radius.sm, borderWidth: 1,
  },
  btnText: { fontSize: 11, fontWeight: "500" },
  enableBtn: { borderColor: "rgba(34,197,94,0.3)", backgroundColor: Colors.successBg },
  disableBtn: { borderColor: "rgba(245,158,11,0.3)", backgroundColor: Colors.warningBg },
  deleteBtn: { borderColor: "rgba(239,68,68,0.3)", backgroundColor: Colors.destructiveBg },
  profileCard: {
    backgroundColor: Colors.card, borderRadius: Radius.lg,
    borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: 4,
  },
  profileName: { fontSize: 14, fontWeight: "600", color: Colors.foreground },
  profileMeta: { fontSize: 11, color: Colors.mutedFg },
  sessionCard: {
    backgroundColor: Colors.card, borderRadius: Radius.lg,
    borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md,
  },
});
