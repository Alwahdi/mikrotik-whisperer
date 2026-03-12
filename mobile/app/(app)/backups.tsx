import React, { useState, useEffect } from "react";
import {
  View, Text, StyleSheet, FlatList, TouchableOpacity,
  Alert, RefreshControl,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { Ionicons } from "@expo/vector-icons";
import { useAuth } from "@/contexts/AuthContext";
import { supabase } from "@/lib/supabase";
import { getMikrotikConfigSync } from "@/lib/mikrotikConfig";
import { useHotspotAllUsers, useUserManagerUsers } from "@/hooks/useMikrotik";
import { Colors, Radius, Spacing } from "@/lib/theme";
import { formatDateTime } from "@/lib/utils";
import LoadingView from "@/components/LoadingView";
import EmptyState from "@/components/EmptyState";
import Button from "@/components/Button";
import Badge from "@/components/Badge";

interface BackupRecord {
  id: string;
  router_id: string;
  router_label: string;
  backup_type: string;
  status: string;
  metadata: any;
  created_at: string;
}

export default function BackupsScreen() {
  const { user } = useAuth();
  const config = getMikrotikConfigSync();
  const [backups, setBackups] = useState<BackupRecord[]>([]);
  const [loading, setLoading] = useState(true);
  const [creating, setCreating] = useState(false);
  const [refreshing, setRefreshing] = useState(false);

  const { data: hotspotUsers } = useHotspotAllUsers();
  const { data: umUsers } = useUserManagerUsers();

  const fetchBackups = async () => {
    if (!user) return;
    const { data, error } = await supabase
      .from("backups")
      .select("*")
      .eq("user_id", user.id)
      .order("created_at", { ascending: false });
    if (!error && data) setBackups(data as unknown as BackupRecord[]);
    setLoading(false);
  };

  useEffect(() => { fetchBackups(); }, [user]);

  const onRefresh = async () => {
    setRefreshing(true);
    await fetchBackups();
    setRefreshing(false);
  };

  const createBackup = async (type: "hotspot" | "usermanager" | "all") => {
    if (!config) { Alert.alert("خطأ", "لا يوجد اتصال بالراوتر"); return; }
    if (!user?.id) return;

    const labels: Record<string, string> = {
      hotspot: "الهوتسبوت",
      usermanager: "يوزر مانجر",
      all: "الكل",
    };

    setCreating(true);
    try {
      const metadata: any = {};

      if (type === "hotspot" || type === "all") {
        const { data } = await supabase.functions.invoke("mikrotik-api", {
          body: {
            endpoint: "/ip/hotspot/user/print",
            host: config.host, user: config.user, pass: config.pass,
            port: config.port, protocol: config.protocol, mode: config.mode,
          },
        });
        metadata.hotspot_users = data;
        metadata.hotspot_count = Array.isArray(data) ? data.length : 0;
      }

      if (type === "usermanager" || type === "all") {
        const { data } = await supabase.functions.invoke("mikrotik-api", {
          body: {
            endpoint: "/user-manager/user/print",
            host: config.host, user: config.user, pass: config.pass,
            port: config.port, protocol: config.protocol, mode: config.mode,
          },
        });
        metadata.um_users = data;
        metadata.um_count = Array.isArray(data) ? data.length : 0;
      }

      const { error } = await supabase.from("backups").insert({
        user_id: user.id,
        router_id: null,
        router_label: config.label || config.host,
        backup_type: type,
        status: "completed",
        metadata,
      });

      if (error) throw error;
      Alert.alert("تم", `تم إنشاء نسخة احتياطية لـ ${labels[type]}`);
      fetchBackups();
    } catch (err: any) {
      Alert.alert("خطأ", err.message || "فشل إنشاء النسخة الاحتياطية");
    } finally {
      setCreating(false);
    }
  };

  const deleteBackup = (id: string) => {
    Alert.alert("حذف النسخة", "هل أنت متأكد؟", [
      { text: "إلغاء", style: "cancel" },
      {
        text: "حذف",
        style: "destructive",
        onPress: async () => {
          await supabase.from("backups").delete().eq("id", id);
          setBackups((prev) => prev.filter((b) => b.id !== id));
        },
      },
    ]);
  };

  const typeLabels: Record<string, string> = {
    hotspot: "هوتسبوت",
    usermanager: "يوزر مانجر",
    all: "الكل",
  };

  if (loading) return <LoadingView />;

  return (
    <SafeAreaView style={styles.safe}>
      <View style={styles.header}>
        <Text style={styles.pageTitle}>النسخ الاحتياطي</Text>
      </View>

      {/* Create Backup */}
      <View style={styles.createSection}>
        <Text style={styles.sectionTitle}>إنشاء نسخة جديدة</Text>
        <View style={styles.btnRow}>
          <TouchableOpacity
            style={styles.createBtn}
            onPress={() => createBackup("hotspot")}
            disabled={creating}
          >
            <Ionicons name="wifi-outline" size={18} color={Colors.primaryLight} />
            <Text style={styles.createBtnText}>هوتسبوت</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={styles.createBtn}
            onPress={() => createBackup("usermanager")}
            disabled={creating}
          >
            <Ionicons name="people-outline" size={18} color={Colors.primaryLight} />
            <Text style={styles.createBtnText}>يوزر مانجر</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={[styles.createBtn, styles.createBtnAll]}
            onPress={() => createBackup("all")}
            disabled={creating}
          >
            <Ionicons name="cloud-upload-outline" size={18} color="#fff" />
            <Text style={[styles.createBtnText, { color: "#fff" }]}>
              {creating ? "جاري..." : "نسخ الكل"}
            </Text>
          </TouchableOpacity>
        </View>
      </View>

      {/* Current stats */}
      {config && (
        <View style={styles.statsRow}>
          <View style={styles.statChip}>
            <Ionicons name="wifi-outline" size={14} color={Colors.textSecondary} />
            <Text style={styles.statChipText}>
              {Array.isArray(hotspotUsers) ? hotspotUsers.length : "—"} هوتسبوت
            </Text>
          </View>
          <View style={styles.statChip}>
            <Ionicons name="people-outline" size={14} color={Colors.textSecondary} />
            <Text style={styles.statChipText}>
              {Array.isArray(umUsers) ? umUsers.length : "—"} يوزر مانجر
            </Text>
          </View>
        </View>
      )}

      {/* Backup List */}
      <Text style={styles.listTitle}>السجل ({backups.length})</Text>
      <FlatList
        data={backups}
        keyExtractor={(item) => item.id}
        refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
        contentContainerStyle={styles.list}
        ListEmptyComponent={
          <EmptyState
            title="لا توجد نسخ احتياطية"
            subtitle="أنشئ نسخة احتياطية من البيانات أعلاه"
          />
        }
        renderItem={({ item }) => (
          <View style={styles.backupCard}>
            <View style={styles.backupHeader}>
              <View style={styles.backupInfo}>
                <Text style={styles.backupLabel}>{item.router_label}</Text>
                <Text style={styles.backupDate}>{formatDateTime(item.created_at)}</Text>
              </View>
              <View style={styles.backupMeta}>
                <Badge
                  label={typeLabels[item.backup_type] || item.backup_type}
                  variant="primary"
                />
                <TouchableOpacity onPress={() => deleteBackup(item.id)} style={styles.deleteBtn}>
                  <Ionicons name="trash-outline" size={16} color={Colors.destructive} />
                </TouchableOpacity>
              </View>
            </View>
            {item.metadata && (
              <View style={styles.backupStats}>
                {item.metadata.hotspot_count != null && (
                  <Text style={styles.backupStat}>هوتسبوت: {item.metadata.hotspot_count}</Text>
                )}
                {item.metadata.um_count != null && (
                  <Text style={styles.backupStat}>يوزر مانجر: {item.metadata.um_count}</Text>
                )}
              </View>
            )}
          </View>
        )}
      />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  header: { paddingHorizontal: Spacing.lg, paddingVertical: Spacing.md },
  pageTitle: { fontSize: 20, fontWeight: "800", color: Colors.foreground },
  createSection: {
    paddingHorizontal: Spacing.lg, marginBottom: Spacing.sm, gap: Spacing.sm,
  },
  sectionTitle: { fontSize: 12, fontWeight: "600", color: Colors.textSecondary, textAlign: "right" },
  btnRow: { flexDirection: "row", gap: Spacing.sm },
  createBtn: {
    flex: 1, flexDirection: "row", alignItems: "center", justifyContent: "center",
    gap: 6, paddingVertical: 10, borderRadius: Radius.md,
    backgroundColor: Colors.card, borderWidth: 1, borderColor: Colors.cardBorder,
  },
  createBtnAll: {
    backgroundColor: Colors.primary, borderColor: Colors.primary,
  },
  createBtnText: { fontSize: 12, fontWeight: "600", color: Colors.textSecondary },
  statsRow: {
    flexDirection: "row", paddingHorizontal: Spacing.lg, gap: Spacing.sm, marginBottom: Spacing.sm,
  },
  statChip: {
    flexDirection: "row", alignItems: "center", gap: 5,
    backgroundColor: Colors.card, borderWidth: 1, borderColor: Colors.cardBorder,
    paddingHorizontal: 12, paddingVertical: 6, borderRadius: Radius.full,
  },
  statChipText: { fontSize: 11, color: Colors.textSecondary },
  listTitle: {
    fontSize: 12, fontWeight: "600", color: Colors.textSecondary,
    paddingHorizontal: Spacing.lg, marginBottom: Spacing.xs,
  },
  list: { paddingHorizontal: Spacing.lg, gap: Spacing.sm, paddingBottom: 24 },
  backupCard: {
    backgroundColor: Colors.card, borderRadius: Radius.lg,
    borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: 8,
  },
  backupHeader: { flexDirection: "row", alignItems: "flex-start", justifyContent: "space-between" },
  backupInfo: { flex: 1, gap: 3 },
  backupLabel: { fontSize: 13, fontWeight: "600", color: Colors.foreground },
  backupDate: { fontSize: 10, color: Colors.mutedFg },
  backupMeta: { flexDirection: "row", alignItems: "center", gap: 8 },
  deleteBtn: {
    padding: 4, borderRadius: Radius.sm,
    backgroundColor: Colors.destructiveBg,
  },
  backupStats: { flexDirection: "row", gap: Spacing.md },
  backupStat: { fontSize: 11, color: Colors.textSecondary },
});
