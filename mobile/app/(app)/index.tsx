import React, { useMemo, useCallback } from "react";
import {
  View, Text, StyleSheet, ScrollView,
  TouchableOpacity, RefreshControl,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { router } from "expo-router";
import { Ionicons } from "@expo/vector-icons";
import Animated, { FadeInDown } from "react-native-reanimated";
import { useQuery } from "@tanstack/react-query";
import { useAuth } from "@/contexts/AuthContext";
import { getMikrotikConfigSync } from "@/lib/mikrotikConfig";
import { supabase } from "@/lib/supabase";
import { Colors, Radius, Spacing } from "@/lib/theme";
import { formatSize } from "@/lib/utils";
import StatCard from "@/components/StatCard";
import { ListRowSkeleton, StatCardSkeleton } from "@/components/SkeletonLoader";
import AnimatedPressable from "@/components/AnimatedPressable";
import { lightTap } from "@/lib/haptics";
import {
  useHotspotUsers, useUserManagerUsers, useSystemResources,
  useSystemIdentity, useInterfaces, useDHCPLeases, useRouterHealth,
  useUserManagerSessions,
} from "@/hooks/useMikrotik";

export default function DashboardScreen() {
  const { user } = useAuth();
  const config = getMikrotikConfigSync();

  const { data: hotspotUsers, isLoading: loadingH, refetch: refetchH } = useHotspotUsers();
  const { data: umUsers, isLoading: loadingU, refetch: refetchU } = useUserManagerUsers();
  const { data: umSessions, refetch: refetchS } = useUserManagerSessions();
  const { data: sysRes, isLoading: loadingSys, refetch: refetchR } = useSystemResources();
  const { data: identity } = useSystemIdentity();
  const { data: interfaces, refetch: refetchI } = useInterfaces();
  const { data: dhcpLeases, refetch: refetchD } = useDHCPLeases();
  const { data: health } = useRouterHealth();

  const { data: todaySales, refetch: refetchSales } = useQuery({
    queryKey: ["today-sales", user?.id],
    queryFn: async () => {
      if (!user?.id) return [];
      const today = new Date(); today.setHours(0, 0, 0, 0);
      const { data } = await supabase
        .from("sales").select("success_count, total_amount")
        .eq("user_id", user.id).gte("created_at", today.toISOString());
      return data || [];
    },
    enabled: !!user?.id,
  });

  const [refreshing, setRefreshing] = React.useState(false);
  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    await Promise.all([refetchH(), refetchU(), refetchS(), refetchR(), refetchI(), refetchD(), refetchSales()]);
    setRefreshing(false);
  }, []);

  const todayRevenue = useMemo(() => (todaySales || []).reduce((s: number, r: any) => s + Number(r.total_amount || 0), 0), [todaySales]);
  const todayCards = useMemo(() => (todaySales || []).reduce((s: number, r: any) => s + (r.success_count || 0), 0), [todaySales]);

  const cpuLoad = parseInt(String(sysRes?.["cpu-load"] ?? "0"), 10) || 0;
  const totalMem = Number(sysRes?.["total-memory"] || 0);
  const freeMem = Number(sysRes?.["free-memory"] || 0);
  const memUsed = totalMem > 0 ? Math.round(((totalMem - freeMem) / totalMem) * 100) : 0;
  const totalHdd = Number(sysRes?.["total-hdd-space"] || 0);
  const freeHdd = Number(sysRes?.["free-hdd-space"] || 0);
  const hddUsed = totalHdd > 0 ? Math.round(((totalHdd - freeHdd) / totalHdd) * 100) : 0;

  const alerts = useMemo(() => {
    const a: { type: "warning" | "error"; msg: string }[] = [];
    if (cpuLoad > 80) a.push({ type: "warning", msg: `CPU مرتفع: ${cpuLoad}%` });
    if (memUsed > 85) a.push({ type: "warning", msg: `الذاكرة ممتلئة: ${memUsed}%` });
    if (hddUsed > 90) a.push({ type: "error", msg: `التخزين ممتلئ: ${hddUsed}%` });
    return a;
  }, [cpuLoad, memUsed, hddUsed]);

  if (!config) {
    return (
      <SafeAreaView style={styles.safe}>
        <View style={styles.noConfig}>
          <Ionicons name="hardware-chip-outline" size={52} color={Colors.mutedFg} />
          <Text style={styles.noConfigTitle}>لا يوجد راوتر متصل</Text>
          <Text style={styles.noConfigSub}>أضف راوتر للبدء في استخدام التطبيق</Text>
          <AnimatedPressable style={styles.gotoBtn} onPress={() => router.push("/routers")}>
            <Ionicons name="add" size={18} color="#fff" />
            <Text style={styles.gotoBtnText}>إضافة راوتر</Text>
          </AnimatedPressable>
        </View>
      </SafeAreaView>
    );
  }

  const activeCount = Array.isArray(hotspotUsers) ? hotspotUsers.length : 0;
  const totalUm = Array.isArray(umUsers) ? umUsers.length : 0;
  const totalLeases = Array.isArray(dhcpLeases) ? dhcpLeases.length : 0;
  const activeSessions = Array.isArray(umSessions) ? umSessions.length : 0;
  const activeIfaces = Array.isArray(interfaces)
    ? interfaces.filter((i: any) => i.running === "true" || i.running === true).length
    : 0;
  const routerName = identity?.name ?? config.label ?? "MikroTik";
  const latency = health?.latency;

  const QuickAction = ({ label, icon, path }: { label: string; icon: any; path: string }) => (
    <AnimatedPressable style={styles.quickBtn} onPress={() => router.push(path)}>
      <View style={styles.quickIcon}>
        <Ionicons name={icon} size={20} color={Colors.primaryLight} />
      </View>
      <Text style={styles.quickBtnText}>{label}</Text>
    </AnimatedPressable>
  );

  return (
    <SafeAreaView style={styles.safe} edges={["top"]}>
      <ScrollView
        contentContainerStyle={styles.scroll}
        refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
        showsVerticalScrollIndicator={false}
      >
        {/* Header */}
        <Animated.View entering={FadeInDown.delay(0).springify()} style={styles.header}>
          <View style={styles.headerLeft}>
            <Text style={styles.routerName}>{routerName}</Text>
            <View style={styles.statusRow}>
              <View style={styles.dot} />
              <Text style={styles.statusText}>
                {sysRes?.version ?? "RouterOS"} • {config.mode === "rest" ? "REST" : "API"}
                {latency != null ? ` • ${latency}ms` : ""}
              </Text>
            </View>
          </View>
          <AnimatedPressable style={styles.settingsBtn} onPress={() => router.push("/(app)/settings")} haptic>
            <Ionicons name="settings-outline" size={20} color={Colors.mutedFg} />
          </AnimatedPressable>
        </Animated.View>

        {/* Quick Actions */}
        <Animated.View entering={FadeInDown.delay(60).springify()} style={styles.quickActions}>
          <QuickAction label="كروت" icon="card-outline" path="/(app)/vouchers" />
          <QuickAction label="مستخدمين" icon="people-outline" path="/(app)/usermanager" />
          <QuickAction label="هوتسبوت" icon="wifi-outline" path="/(app)/hotspot" />
          <QuickAction label="مبيعات" icon="bar-chart-outline" path="/(app)/sales" />
        </Animated.View>

        {/* Alerts */}
        {alerts.map((al, i) => (
          <Animated.View
            key={i}
            entering={FadeInDown.delay(100 + i * 50).springify()}
            style={[styles.alert, al.type === "error"
              ? { backgroundColor: Colors.destructiveBg, borderColor: Colors.destructiveBorder }
              : { backgroundColor: Colors.warningBg, borderColor: Colors.warningBorder }]}
          >
            <Ionicons name="warning-outline" size={14} color={al.type === "error" ? Colors.destructive : Colors.warning} />
            <Text style={[styles.alertText, { color: al.type === "error" ? Colors.destructive : Colors.warning }]}>
              {al.msg}
            </Text>
          </Animated.View>
        ))}

        {/* System Stats */}
        <Text style={styles.sectionTitle}>إحصائيات النظام</Text>
        {loadingH || loadingU ? (
          <View style={styles.statsGrid}><StatCardSkeleton /><StatCardSkeleton /></View>
        ) : (
          <View style={styles.statsGrid}>
            <StatCard title="هوتسبوت" value={activeCount} subtitle="متصل" variant="primary" delay={0} />
            <StatCard title="يوزر مانجر" value={totalUm} subtitle="مستخدم" variant="accent" delay={60} />
          </View>
        )}

        {loadingSys ? (
          <View style={styles.statsGrid}><StatCardSkeleton /><StatCardSkeleton /></View>
        ) : (
          <View style={styles.statsGrid}>
            <StatCard title="CPU" value={`${cpuLoad}%`} variant={cpuLoad > 80 ? "warning" : "default"} delay={120} />
            <StatCard title="الذاكرة" value={`${memUsed}%`} subtitle={`${formatSize(freeMem)} متاح`} variant={memUsed > 85 ? "warning" : "default"} delay={180} />
          </View>
        )}

        <View style={styles.statsGrid}>
          <StatCard title="DHCP" value={totalLeases} subtitle="تأجير" delay={240} />
          <StatCard title="جلسات" value={activeSessions} subtitle="نشطة" delay={300} />
          <StatCard title="واجهات" value={activeIfaces} subtitle="نشط" delay={360} />
        </View>

        {/* Today Sales */}
        <Text style={styles.sectionTitle}>مبيعات اليوم</Text>
        <View style={styles.statsGrid}>
          <StatCard title="الإيرادات" value={todayRevenue.toLocaleString()} subtitle="ريال" variant="accent" delay={0} />
          <StatCard title="الكروت" value={todayCards} subtitle="كرت" delay={60} />
        </View>

        {/* Active Hotspot Users */}
        {Array.isArray(hotspotUsers) && hotspotUsers.length > 0 && (
          <Animated.View entering={FadeInDown.delay(100).springify()} style={styles.tableCard}>
            <View style={styles.tableHeader}>
              <Text style={styles.tableSectionTitle}>المتصلون ({hotspotUsers.length})</Text>
              <TouchableOpacity onPress={() => { lightTap(); router.push("/(app)/hotspot"); }}>
                <Text style={styles.tableLink}>عرض الكل</Text>
              </TouchableOpacity>
            </View>
            {hotspotUsers.slice(0, 5).map((u: any, i: number) => (
              <View key={i} style={styles.tableRow}>
                <View style={styles.onlineDot} />
                <View style={styles.tableRowInfo}>
                  <Text style={styles.tableRowName}>{u.user || "—"}</Text>
                  <Text style={styles.tableRowMeta}>{u.address || "—"} • {u.uptime || "—"}</Text>
                </View>
                <Text style={styles.tableRowBytes}>
                  ↓{formatSize(u["bytes-in"])} ↑{formatSize(u["bytes-out"])}
                </Text>
              </View>
            ))}
          </Animated.View>
        )}

        {/* Interfaces */}
        {Array.isArray(interfaces) && interfaces.length > 0 && (
          <Animated.View entering={FadeInDown.delay(150).springify()} style={styles.tableCard}>
            <Text style={styles.tableSectionTitle}>الواجهات</Text>
            {interfaces.filter((i: any) => i.type !== "loopback").slice(0, 6).map((iface: any, i: number) => {
              const running = iface.running === "true" || iface.running === true;
              return (
                <View key={i} style={styles.ifaceRow}>
                  <View style={[styles.ifaceDot, { backgroundColor: running ? Colors.success : Colors.mutedFg }]} />
                  <Text style={styles.ifaceName}>{iface.name}</Text>
                  <Text style={styles.ifaceBytes}>↓{formatSize(iface["rx-byte"])} ↑{formatSize(iface["tx-byte"])}</Text>
                </View>
              );
            })}
          </Animated.View>
        )}

        {/* System Info */}
        <Animated.View entering={FadeInDown.delay(200).springify()} style={styles.sysInfoCard}>
          <Text style={styles.tableSectionTitle}>معلومات النظام</Text>
          {[
            ["الجهاز", identity?.name],
            ["النموذج", sysRes?.["board-name"]],
            ["الإصدار", sysRes?.version],
            ["وقت التشغيل", sysRes?.uptime],
            ["التخزين", totalHdd > 0 ? `${hddUsed}% • ${formatSize(freeHdd)} متاح` : null],
          ].filter(([, v]) => v).map(([k, v]) => (
            <View key={String(k)} style={styles.sysInfoRow}>
              <Text style={styles.sysInfoKey}>{k}</Text>
              <Text style={styles.sysInfoVal}>{v}</Text>
            </View>
          ))}
        </Animated.View>

        {/* More Options */}
        <View style={styles.moreRow}>
          {[
            { label: "النسخ الاحتياطي", icon: "cloud-download-outline" as const, path: "/(app)/backups" },
            { label: "الإعدادات", icon: "settings-outline" as const, path: "/(app)/settings" },
            { label: "تغيير الراوتر", icon: "swap-horizontal-outline" as const, path: "/routers" },
          ].map((item) => (
            <AnimatedPressable
              key={item.path}
              style={styles.moreBtn}
              onPress={() => router.push(item.path as any)}
            >
              <Ionicons name={item.icon} size={18} color={Colors.textSecondary} />
              <Text style={styles.moreBtnText}>{item.label}</Text>
              <Ionicons name="chevron-back-outline" size={14} color={Colors.mutedFg} />
            </AnimatedPressable>
          ))}
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  scroll: { padding: Spacing.lg, gap: Spacing.md, paddingBottom: 90 },
  noConfig: { flex: 1, alignItems: "center", justifyContent: "center", gap: Spacing.sm, padding: Spacing.xxxl },
  noConfigTitle: { fontSize: 20, fontWeight: "700", color: Colors.foreground },
  noConfigSub: { fontSize: 13, color: Colors.textSecondary, textAlign: "center" },
  gotoBtn: { flexDirection: "row", alignItems: "center", gap: 6, backgroundColor: Colors.primary, paddingHorizontal: 20, paddingVertical: 10, borderRadius: Radius.md, marginTop: Spacing.sm },
  gotoBtnText: { color: "#fff", fontWeight: "600" },
  header: { flexDirection: "row", alignItems: "flex-start", justifyContent: "space-between", marginBottom: Spacing.xs },
  headerLeft: { flex: 1 },
  routerName: { fontSize: 22, fontWeight: "800", color: Colors.foreground, letterSpacing: -0.5 },
  statusRow: { flexDirection: "row", alignItems: "center", gap: 5, marginTop: 3 },
  dot: { width: 6, height: 6, borderRadius: 3, backgroundColor: Colors.success },
  statusText: { fontSize: 11, color: Colors.mutedFg },
  settingsBtn: { padding: 6, backgroundColor: Colors.card, borderRadius: Radius.md, borderWidth: 1, borderColor: Colors.border },
  quickActions: { flexDirection: "row", gap: Spacing.sm },
  quickBtn: { flex: 1, backgroundColor: Colors.card, borderWidth: 1, borderColor: Colors.cardBorder, borderRadius: Radius.lg, padding: Spacing.sm, alignItems: "center", gap: 6 },
  quickIcon: { width: 36, height: 36, borderRadius: 10, backgroundColor: "rgba(124,58,237,0.1)", alignItems: "center", justifyContent: "center" },
  quickBtnText: { fontSize: 10, color: Colors.textSecondary, fontWeight: "600" },
  alert: { flexDirection: "row", alignItems: "center", gap: 8, padding: Spacing.sm, borderRadius: Radius.md, borderWidth: 1 },
  alertText: { fontSize: 12, flex: 1, fontWeight: "500" },
  sectionTitle: { fontSize: 11, fontWeight: "700", color: Colors.textSecondary, textTransform: "uppercase", letterSpacing: 0.8, marginTop: Spacing.xs },
  statsGrid: { flexDirection: "row", gap: Spacing.sm },
  tableCard: { backgroundColor: Colors.card, borderRadius: Radius.lg, borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: Spacing.sm },
  tableHeader: { flexDirection: "row", justifyContent: "space-between", alignItems: "center" },
  tableSectionTitle: { fontSize: 12, fontWeight: "700", color: Colors.foreground },
  tableLink: { fontSize: 11, color: Colors.primaryLight, fontWeight: "600" },
  tableRow: { flexDirection: "row", alignItems: "center", gap: Spacing.sm, paddingVertical: 5, borderTopWidth: 1, borderTopColor: Colors.border },
  onlineDot: { width: 6, height: 6, borderRadius: 3, backgroundColor: Colors.success },
  tableRowInfo: { flex: 1 },
  tableRowName: { fontSize: 12, fontWeight: "600", color: Colors.foreground },
  tableRowMeta: { fontSize: 10, color: Colors.mutedFg },
  tableRowBytes: { fontSize: 10, color: Colors.textSecondary },
  ifaceRow: { flexDirection: "row", alignItems: "center", gap: 8, paddingVertical: 5, borderTopWidth: 1, borderTopColor: Colors.border },
  ifaceDot: { width: 6, height: 6, borderRadius: 3 },
  ifaceName: { flex: 1, fontSize: 12, color: Colors.foreground },
  ifaceBytes: { fontSize: 10, color: Colors.mutedFg },
  sysInfoCard: { backgroundColor: Colors.card, borderRadius: Radius.lg, borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: Spacing.xs },
  sysInfoRow: { flexDirection: "row", justifyContent: "space-between", paddingVertical: 4, borderTopWidth: 1, borderTopColor: Colors.border },
  sysInfoKey: { fontSize: 12, color: Colors.mutedFg },
  sysInfoVal: { fontSize: 12, color: Colors.foreground, fontWeight: "500" },
  moreRow: { gap: Spacing.xs },
  moreBtn: { flexDirection: "row", alignItems: "center", gap: Spacing.sm, backgroundColor: Colors.card, borderRadius: Radius.md, borderWidth: 1, borderColor: Colors.cardBorder, paddingHorizontal: Spacing.md, paddingVertical: Spacing.sm + 2 },
  moreBtnText: { flex: 1, fontSize: 13, color: Colors.foreground },
});
