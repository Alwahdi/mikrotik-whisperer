import React, { useMemo } from "react";
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
  RefreshControl,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { router } from "expo-router";
import { Ionicons } from "@expo/vector-icons";
import { useQuery } from "@tanstack/react-query";
import { useAuth } from "@/contexts/AuthContext";
import { getMikrotikConfigSync } from "@/lib/mikrotikConfig";
import { supabase } from "@/lib/supabase";
import { Colors, Radius, Spacing } from "@/lib/theme";
import { formatSize } from "@/lib/utils";
import StatCard from "@/components/StatCard";
import LoadingView from "@/components/LoadingView";
import {
  useHotspotUsers,
  useUserManagerUsers,
  useSystemResources,
  useSystemIdentity,
  useInterfaces,
  useDHCPLeases,
  useRouterHealth,
  useUserManagerSessions,
} from "@/hooks/useMikrotik";

export default function DashboardScreen() {
  const { user } = useAuth();
  const config = getMikrotikConfigSync();

  const { data: hotspotUsers, isLoading: loadingH, refetch: refetchH } = useHotspotUsers();
  const { data: umUsers, isLoading: loadingU, refetch: refetchU } = useUserManagerUsers();
  const { data: umSessions, refetch: refetchS } = useUserManagerSessions();
  const { data: sysResource, refetch: refetchR } = useSystemResources();
  const { data: identity } = useSystemIdentity();
  const { data: interfaces, refetch: refetchI } = useInterfaces();
  const { data: dhcpLeases, refetch: refetchD } = useDHCPLeases();
  const { data: health } = useRouterHealth();

  const { data: todaySales, refetch: refetchSales } = useQuery({
    queryKey: ["today-sales", user?.id],
    queryFn: async () => {
      if (!user?.id) return [];
      const today = new Date();
      today.setHours(0, 0, 0, 0);
      const { data } = await supabase
        .from("sales")
        .select("success_count, total_amount, profile_name")
        .eq("user_id", user.id)
        .gte("created_at", today.toISOString());
      return data || [];
    },
    enabled: !!user?.id,
  });

  const [refreshing, setRefreshing] = React.useState(false);
  const onRefresh = async () => {
    setRefreshing(true);
    await Promise.all([refetchH(), refetchU(), refetchS(), refetchR(), refetchI(), refetchD(), refetchSales()]);
    setRefreshing(false);
  };

  const todayRevenue = useMemo(
    () => (todaySales || []).reduce((s: number, r: any) => s + Number(r.total_amount || 0), 0),
    [todaySales]
  );
  const todayCardsCount = useMemo(
    () => (todaySales || []).reduce((s: number, r: any) => s + (r.success_count || 0), 0),
    [todaySales]
  );

  const cpuLoad = sysResource?.["cpu-load"] ?? "—";
  const totalMem = Number(sysResource?.["total-memory"] || 0);
  const freeMem = Number(sysResource?.["free-memory"] || 0);
  const memUsed = totalMem > 0 ? Math.round(((totalMem - freeMem) / totalMem) * 100) : 0;
  const totalHdd = Number(sysResource?.["total-hdd-space"] || 0);
  const freeHdd = Number(sysResource?.["free-hdd-space"] || 0);
  const hddUsed = totalHdd > 0 ? Math.round(((totalHdd - freeHdd) / totalHdd) * 100) : 0;

  const alerts = useMemo(() => {
    const a: { type: "warning" | "error"; msg: string }[] = [];
    if (Number(cpuLoad) > 80) a.push({ type: "warning", msg: `CPU عالي: ${cpuLoad}%` });
    if (memUsed > 85) a.push({ type: "warning", msg: `الذاكرة ممتلئة: ${memUsed}%` });
    if (hddUsed > 90) a.push({ type: "error", msg: `التخزين ممتلئ: ${hddUsed}%` });
    return a;
  }, [cpuLoad, memUsed, hddUsed]);

  if (!config) {
    return (
      <SafeAreaView style={styles.safe}>
        <View style={styles.noConfig}>
          <Ionicons name="settings-outline" size={48} color={Colors.mutedFg} />
          <Text style={styles.noConfigTitle}>مرحباً بك</Text>
          <Text style={styles.noConfigSub}>اذهب لصفحة الراوترات لإضافة جهاز والبدء</Text>
          <TouchableOpacity style={styles.gotoBtn} onPress={() => router.push("/routers")}>
            <Text style={styles.gotoBtnText}>إدارة الراوترات</Text>
          </TouchableOpacity>
        </View>
      </SafeAreaView>
    );
  }

  const activeCount = Array.isArray(hotspotUsers) ? hotspotUsers.length : 0;
  const totalUsers = Array.isArray(umUsers) ? umUsers.length : 0;
  const totalLeases = Array.isArray(dhcpLeases) ? dhcpLeases.length : 0;
  const activeSessions = Array.isArray(umSessions) ? umSessions.length : 0;
  const activeInterfaces = Array.isArray(interfaces)
    ? interfaces.filter((i: any) => i.running === "true" || i.running === true).length
    : 0;
  const routerName = identity?.name ?? config.label ?? "MikroTik";
  const latency = health?.latency;

  return (
    <SafeAreaView style={styles.safe}>
      <ScrollView
        contentContainerStyle={styles.scroll}
        refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
      >
        {/* Header */}
        <View style={styles.header}>
          <View>
            <Text style={styles.routerName}>{routerName}</Text>
            <View style={styles.statusRow}>
              <View style={styles.dot} />
              <Text style={styles.statusText}>
                {sysResource?.version || "RouterOS"} • {config.mode === "rest" ? "REST" : "API"}
                {latency != null ? ` • ${latency}ms` : ""}
              </Text>
            </View>
          </View>
          <TouchableOpacity style={styles.settingsBtn} onPress={() => router.push("/(app)/settings")}>
            <Ionicons name="settings-outline" size={20} color={Colors.mutedFg} />
          </TouchableOpacity>
        </View>

        {/* Quick Actions */}
        <View style={styles.quickActions}>
          {[
            { label: "كروت", icon: "card-outline" as const, path: "/(app)/vouchers" },
            { label: "مستخدمين", icon: "people-outline" as const, path: "/(app)/usermanager" },
            { label: "هوتسبوت", icon: "wifi-outline" as const, path: "/(app)/hotspot" },
            { label: "مبيعات", icon: "bar-chart-outline" as const, path: "/(app)/sales" },
          ].map((a) => (
            <TouchableOpacity
              key={a.path}
              style={styles.quickBtn}
              onPress={() => router.push(a.path as any)}
            >
              <Ionicons name={a.icon} size={20} color={Colors.primaryLight} />
              <Text style={styles.quickBtnText}>{a.label}</Text>
            </TouchableOpacity>
          ))}
        </View>

        {/* Alerts */}
        {alerts.map((al, i) => (
          <View
            key={i}
            style={[
              styles.alert,
              al.type === "error"
                ? { backgroundColor: Colors.destructiveBg, borderColor: "rgba(239,68,68,0.25)" }
                : { backgroundColor: Colors.warningBg, borderColor: "rgba(245,158,11,0.25)" },
            ]}
          >
            <Ionicons
              name="warning-outline"
              size={14}
              color={al.type === "error" ? Colors.destructive : Colors.warning}
            />
            <Text
              style={[
                styles.alertText,
                { color: al.type === "error" ? Colors.destructive : Colors.warning },
              ]}
            >
              {al.msg}
            </Text>
          </View>
        ))}

        {/* System Stats */}
        <Text style={styles.sectionTitle}>إحصائيات النظام</Text>
        <View style={styles.statsGrid}>
          <StatCard title="هوتسبوت" value={loadingH ? "..." : activeCount} subtitle="متصل" variant="primary" />
          <StatCard title="يوزر مانجر" value={loadingU ? "..." : totalUsers} subtitle="مستخدم" variant="accent" />
        </View>
        <View style={styles.statsGrid}>
          <StatCard
            title="CPU"
            value={`${cpuLoad}%`}
            variant={Number(cpuLoad) > 80 ? "warning" : "default"}
          />
          <StatCard
            title="الذاكرة"
            value={`${memUsed}%`}
            subtitle={formatSize(freeMem) + " متاح"}
            variant={memUsed > 85 ? "warning" : "default"}
          />
        </View>
        <View style={styles.statsGrid}>
          <StatCard title="DHCP" value={totalLeases} subtitle="تأجير" />
          <StatCard title="جلسات" value={activeSessions} subtitle="نشطة" />
          <StatCard title="واجهات" value={activeInterfaces} subtitle="نشط" />
        </View>

        {/* Today's Sales */}
        <Text style={styles.sectionTitle}>مبيعات اليوم</Text>
        <View style={styles.statsGrid}>
          <StatCard title="الإيرادات" value={todayRevenue.toLocaleString()} subtitle="ريال" variant="accent" />
          <StatCard title="الكروت" value={todayCardsCount} subtitle="كرت" />
        </View>

        {/* Active Hotspot Users */}
        {Array.isArray(hotspotUsers) && hotspotUsers.length > 0 && (
          <View style={styles.tableCard}>
            <View style={styles.tableHeader}>
              <Text style={styles.tableSectionTitle}>المتصلين ({hotspotUsers.length})</Text>
              <TouchableOpacity onPress={() => router.push("/(app)/hotspot")}>
                <Text style={styles.tableLink}>عرض الكل</Text>
              </TouchableOpacity>
            </View>
            {hotspotUsers.slice(0, 5).map((u: any, i: number) => (
              <View key={i} style={styles.tableRow}>
                <View style={styles.tableRowDot}>
                  <View style={styles.onlineDot} />
                </View>
                <View style={styles.tableRowInfo}>
                  <Text style={styles.tableRowName}>{u.user || "—"}</Text>
                  <Text style={styles.tableRowMeta}>{u.address || "—"} • {u.uptime || "—"}</Text>
                </View>
                <Text style={styles.tableRowBytes}>
                  ↓{formatSize(u["bytes-in"])} ↑{formatSize(u["bytes-out"])}
                </Text>
              </View>
            ))}
          </View>
        )}

        {/* Interfaces */}
        {Array.isArray(interfaces) && interfaces.length > 0 && (
          <View style={styles.tableCard}>
            <Text style={styles.tableSectionTitle}>الواجهات</Text>
            {interfaces
              .filter((i: any) => i.type !== "loopback")
              .slice(0, 6)
              .map((iface: any, i: number) => {
                const running = iface.running === "true" || iface.running === true;
                return (
                  <View key={i} style={[styles.ifaceRow, running ? styles.ifaceRowActive : {}]}>
                    <View style={[styles.ifaceDot, { backgroundColor: running ? Colors.success : Colors.mutedFg }]} />
                    <Text style={styles.ifaceName}>{iface.name}</Text>
                    <Text style={styles.ifaceBytes}>
                      ↓{formatSize(iface["rx-byte"])} ↑{formatSize(iface["tx-byte"])}
                    </Text>
                  </View>
                );
              })}
          </View>
        )}

        {/* System Info */}
        <View style={styles.sysInfoCard}>
          <Text style={styles.tableSectionTitle}>معلومات النظام</Text>
          {[
            ["الجهاز", identity?.name],
            ["النموذج", sysResource?.["board-name"]],
            ["الإصدار", sysResource?.version],
            ["وقت التشغيل", sysResource?.uptime],
            ["التخزين", `${hddUsed}% مستخدم • ${formatSize(freeHdd)} متاح`],
          ].map(([k, v]) => v ? (
            <View key={k} style={styles.sysInfoRow}>
              <Text style={styles.sysInfoKey}>{k}</Text>
              <Text style={styles.sysInfoVal}>{v}</Text>
            </View>
          ) : null)}
        </View>

        {/* More options */}
        <View style={styles.moreRow}>
          {[
            { label: "النسخ الاحتياطي", icon: "cloud-download-outline" as const, path: "/(app)/backups" },
            { label: "الإعدادات", icon: "settings-outline" as const, path: "/(app)/settings" },
            { label: "تغيير الراوتر", icon: "swap-horizontal-outline" as const, path: "/routers" },
          ].map((item) => (
            <TouchableOpacity
              key={item.path}
              style={styles.moreBtn}
              onPress={() => router.push(item.path as any)}
            >
              <Ionicons name={item.icon} size={18} color={Colors.textSecondary} />
              <Text style={styles.moreBtnText}>{item.label}</Text>
              <Ionicons name="chevron-back-outline" size={14} color={Colors.mutedFg} />
            </TouchableOpacity>
          ))}
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  scroll: { padding: Spacing.lg, gap: Spacing.md, paddingBottom: 40 },
  noConfig: {
    flex: 1, alignItems: "center", justifyContent: "center",
    gap: Spacing.sm, paddingHorizontal: Spacing.xxxl,
  },
  noConfigTitle: { fontSize: 18, fontWeight: "700", color: Colors.foreground },
  noConfigSub: { fontSize: 13, color: Colors.textSecondary, textAlign: "center" },
  gotoBtn: {
    backgroundColor: Colors.primary, paddingHorizontal: 20, paddingVertical: 10,
    borderRadius: Radius.md, marginTop: Spacing.sm,
  },
  gotoBtnText: { color: "#fff", fontWeight: "600" },
  header: {
    flexDirection: "row", alignItems: "flex-start",
    justifyContent: "space-between", marginBottom: Spacing.xs,
  },
  routerName: { fontSize: 20, fontWeight: "800", color: Colors.foreground },
  statusRow: { flexDirection: "row", alignItems: "center", gap: 5, marginTop: 3 },
  dot: { width: 6, height: 6, borderRadius: 3, backgroundColor: Colors.success },
  statusText: { fontSize: 11, color: Colors.mutedFg, fontFamily: "Courier" },
  settingsBtn: { padding: 6 },
  quickActions: {
    flexDirection: "row", gap: Spacing.sm, flexWrap: "wrap",
  },
  quickBtn: {
    flex: 1, minWidth: 70,
    backgroundColor: Colors.card, borderWidth: 1, borderColor: Colors.cardBorder,
    borderRadius: Radius.md, padding: Spacing.sm,
    alignItems: "center", gap: 5,
  },
  quickBtnText: { fontSize: 10, color: Colors.textSecondary, fontWeight: "500" },
  alert: {
    flexDirection: "row", alignItems: "center", gap: 8,
    padding: Spacing.sm, borderRadius: Radius.md, borderWidth: 1,
  },
  alertText: { fontSize: 12, flex: 1 },
  sectionTitle: {
    fontSize: 12, fontWeight: "600", color: Colors.textSecondary,
    textTransform: "uppercase", letterSpacing: 0.5,
    marginTop: Spacing.xs,
  },
  statsGrid: { flexDirection: "row", gap: Spacing.sm },
  tableCard: {
    backgroundColor: Colors.card, borderRadius: Radius.lg,
    borderWidth: 1, borderColor: Colors.cardBorder,
    padding: Spacing.md, gap: Spacing.sm,
  },
  tableHeader: { flexDirection: "row", justifyContent: "space-between", alignItems: "center" },
  tableSectionTitle: { fontSize: 12, fontWeight: "600", color: Colors.foreground },
  tableLink: { fontSize: 11, color: Colors.primaryLight },
  tableRow: {
    flexDirection: "row", alignItems: "center", gap: Spacing.sm,
    paddingVertical: 5, borderTopWidth: 1, borderTopColor: Colors.border,
  },
  tableRowDot: { alignItems: "center", justifyContent: "center" },
  onlineDot: { width: 6, height: 6, borderRadius: 3, backgroundColor: Colors.success },
  tableRowInfo: { flex: 1 },
  tableRowName: { fontSize: 12, fontWeight: "600", color: Colors.foreground },
  tableRowMeta: { fontSize: 10, color: Colors.mutedFg, fontFamily: "Courier" },
  tableRowBytes: { fontSize: 10, color: Colors.textSecondary, fontFamily: "Courier" },
  ifaceRow: {
    flexDirection: "row", alignItems: "center", gap: 8,
    paddingVertical: 6, borderTopWidth: 1, borderTopColor: Colors.border,
  },
  ifaceRowActive: {},
  ifaceDot: { width: 6, height: 6, borderRadius: 3 },
  ifaceName: { flex: 1, fontSize: 12, fontFamily: "Courier", color: Colors.foreground },
  ifaceBytes: { fontSize: 10, color: Colors.mutedFg, fontFamily: "Courier" },
  sysInfoCard: {
    backgroundColor: Colors.card, borderRadius: Radius.lg,
    borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: Spacing.xs,
  },
  sysInfoRow: { flexDirection: "row", justifyContent: "space-between", paddingVertical: 4 },
  sysInfoKey: { fontSize: 12, color: Colors.mutedFg },
  sysInfoVal: { fontSize: 12, color: Colors.foreground, fontWeight: "500" },
  moreRow: { gap: 2 },
  moreBtn: {
    flexDirection: "row", alignItems: "center", gap: Spacing.sm,
    backgroundColor: Colors.card, borderRadius: Radius.md,
    borderWidth: 1, borderColor: Colors.cardBorder,
    paddingHorizontal: Spacing.md, paddingVertical: Spacing.sm + 2,
  },
  moreBtnText: { flex: 1, fontSize: 13, color: Colors.foreground },
});
