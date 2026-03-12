import React, { useState, useEffect } from "react";
import {
  View,
  Text,
  StyleSheet,
  FlatList,
  TouchableOpacity,
  Alert,
  Modal,
  ScrollView,
  TextInput,
  ActivityIndicator,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { router } from "expo-router";
import { Ionicons } from "@expo/vector-icons";
import { useAuth } from "@/contexts/AuthContext";
import { supabase } from "@/lib/supabase";
import {
  saveMikrotikConfig,
  getDefaultPort,
  getProtocolOptions,
  type ConnectionMode,
  type ConnectionProtocol,
} from "@/lib/mikrotikConfig";
import { Colors, Radius, Spacing } from "@/lib/theme";
import Button from "@/components/Button";
import LoadingView from "@/components/LoadingView";

interface RouterRow {
  id: string;
  label: string;
  host: string;
  port: string;
  username: string;
  password: string;
  protocol: string;
  mode: string;
  router_os_version: string | null;
  is_online: boolean;
  last_connected_at: string | null;
}

export default function RoutersScreen() {
  const { user, signOut } = useAuth();
  const [routers, setRouters] = useState<RouterRow[]>([]);
  const [pageLoading, setPageLoading] = useState(true);
  const [connecting, setConnecting] = useState<string | null>(null);
  const [showAdd, setShowAdd] = useState(false);
  const [saving, setSaving] = useState(false);

  const [form, setForm] = useState({
    label: "",
    host: "",
    port: "443",
    username: "admin",
    password: "",
    protocol: "https" as ConnectionProtocol,
    mode: "rest" as ConnectionMode,
  });

  const fetchRouters = async () => {
    const { data, error } = await supabase
      .from("routers")
      .select("*")
      .order("created_at", { ascending: false });
    if (!error && data) setRouters(data as RouterRow[]);
    setPageLoading(false);
  };

  useEffect(() => {
    fetchRouters();
  }, []);

  const handleModeChange = (mode: ConnectionMode) => {
    const protocol: ConnectionProtocol = mode === "rest" ? "https" : "api-plain";
    setForm((f) => ({
      ...f,
      mode,
      protocol,
      port: getDefaultPort(mode, protocol),
    }));
  };

  const addRouter = async () => {
    if (!form.host.trim() || !form.username || !form.password) {
      Alert.alert("خطأ", "يرجى تعبئة جميع الحقول المطلوبة");
      return;
    }
    setSaving(true);
    try {
      const { data, error } = await supabase.functions.invoke("mikrotik-api", {
        body: {
          endpoint: "/system/identity/print",
          host: form.host.trim(),
          user: form.username,
          pass: form.password,
          port: form.port,
          protocol: form.protocol,
          mode: form.mode,
        },
      });
      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      const name = Array.isArray(data) ? data[0]?.name : data?.name;

      let version: string | null = null;
      try {
        const { data: resData } = await supabase.functions.invoke(
          "mikrotik-api",
          {
            body: {
              endpoint: "/system/resource/print",
              host: form.host.trim(),
              user: form.username,
              pass: form.password,
              port: form.port,
              protocol: form.protocol,
              mode: form.mode,
            },
          }
        );
        const res = Array.isArray(resData) ? resData[0] : resData;
        version = res?.version || null;
      } catch {}

      const { error: insertError } = await supabase.from("routers").insert({
        user_id: user!.id,
        label: form.label || name || "MikroTik",
        host: form.host.trim(),
        port: form.port,
        username: form.username,
        password: form.password,
        protocol: form.protocol,
        mode: form.mode,
        router_os_version: version,
        is_online: true,
        last_connected_at: new Date().toISOString(),
      });
      if (insertError) throw insertError;

      Alert.alert("تم", `تمت إضافة الراوتر: ${name || form.label || "MikroTik"}`);
      setShowAdd(false);
      setForm({
        label: "",
        host: "",
        port: "443",
        username: "admin",
        password: "",
        protocol: "https",
        mode: "rest",
      });
      fetchRouters();
    } catch (err: any) {
      Alert.alert("فشل الاتصال", err.message || "خطأ غير معروف");
    } finally {
      setSaving(false);
    }
  };

  const connectToRouter = async (r: RouterRow) => {
    setConnecting(r.id);
    try {
      const { data, error } = await supabase.functions.invoke("mikrotik-api", {
        body: {
          endpoint: "/system/identity/print",
          host: r.host,
          user: r.username,
          pass: r.password,
          port: r.port,
          protocol: r.protocol,
          mode: r.mode,
        },
      });
      if (error) throw error;
      if (data?.error) throw new Error(data.error);

      await saveMikrotikConfig({
        host: r.host,
        user: r.username,
        pass: r.password,
        port: r.port,
        protocol: r.protocol as ConnectionProtocol,
        mode: r.mode as ConnectionMode,
        label: r.label,
      });

      await supabase
        .from("routers")
        .update({ is_online: true, last_connected_at: new Date().toISOString() })
        .eq("id", r.id);

      router.replace("/(app)");
    } catch (err: any) {
      Alert.alert("فشل الاتصال", err.message || "خطأ");
      await supabase.from("routers").update({ is_online: false }).eq("id", r.id);
    } finally {
      setConnecting(null);
    }
  };

  const deleteRouter = (id: string) => {
    Alert.alert("حذف الراوتر", "هل أنت متأكد؟", [
      { text: "إلغاء", style: "cancel" },
      {
        text: "حذف",
        style: "destructive",
        onPress: async () => {
          await supabase.from("routers").delete().eq("id", id);
          setRouters((prev) => prev.filter((x) => x.id !== id));
        },
      },
    ]);
  };

  const protocolOptions = getProtocolOptions(form.mode);

  if (pageLoading) return <LoadingView />;

  return (
    <SafeAreaView style={styles.safe}>
      {/* Header */}
      <View style={styles.header}>
        <View style={styles.headerLeft}>
          <View style={styles.logoBox}>
            <Ionicons name="wifi" size={20} color="#fff" />
          </View>
          <View>
            <Text style={styles.headerTitle}>MikroTik Manager</Text>
            <Text style={styles.headerSub}>{user?.email}</Text>
          </View>
        </View>
        <TouchableOpacity
          onPress={() => {
            Alert.alert("تسجيل الخروج", "هل تريد الخروج؟", [
              { text: "إلغاء", style: "cancel" },
              {
                text: "خروج",
                onPress: async () => {
                  await signOut();
                  router.replace("/(auth)/login");
                },
              },
            ]);
          }}
          style={styles.iconBtn}
        >
          <Ionicons name="log-out-outline" size={22} color={Colors.mutedFg} />
        </TouchableOpacity>
      </View>

      {/* Title */}
      <View style={styles.titleRow}>
        <View>
          <Text style={styles.pageTitle}>الراوترات</Text>
          <Text style={styles.pageSub}>اختر راوتر أو أضف جديد</Text>
        </View>
        <TouchableOpacity
          style={styles.addBtn}
          onPress={() => setShowAdd(true)}
        >
          <Ionicons name="add" size={18} color="#fff" />
          <Text style={styles.addBtnText}>إضافة</Text>
        </TouchableOpacity>
      </View>

      {/* List */}
      {routers.length === 0 ? (
        <View style={styles.emptyState}>
          <Ionicons name="hardware-chip-outline" size={48} color={Colors.mutedFg} />
          <Text style={styles.emptyTitle}>لا توجد راوترات</Text>
          <Text style={styles.emptySub}>أضف أول راوتر للبدء</Text>
          <TouchableOpacity
            style={styles.addBtn}
            onPress={() => setShowAdd(true)}
          >
            <Text style={styles.addBtnText}>إضافة راوتر</Text>
          </TouchableOpacity>
        </View>
      ) : (
        <FlatList
          data={routers}
          keyExtractor={(item) => item.id}
          contentContainerStyle={styles.list}
          renderItem={({ item }) => (
            <View style={styles.routerCard}>
              <View style={styles.routerLeft}>
                <View
                  style={[
                    styles.statusIcon,
                    {
                      backgroundColor: item.is_online
                        ? Colors.successBg
                        : Colors.muted,
                    },
                  ]}
                >
                  <Ionicons
                    name={item.is_online ? "wifi" : "wifi-outline"}
                    size={18}
                    color={item.is_online ? Colors.success : Colors.mutedFg}
                  />
                </View>
                <View style={styles.routerInfo}>
                  <Text style={styles.routerLabel}>{item.label}</Text>
                  <Text style={styles.routerMeta}>
                    {item.host}:{item.port} • {item.mode === "rest" ? "REST" : "API"}
                    {item.router_os_version ? ` • ${item.router_os_version}` : ""}
                  </Text>
                </View>
              </View>
              <View style={styles.routerActions}>
                <TouchableOpacity
                  style={styles.connectBtn}
                  onPress={() => connectToRouter(item)}
                  disabled={connecting === item.id}
                >
                  {connecting === item.id ? (
                    <ActivityIndicator size="small" color="#fff" />
                  ) : (
                    <Ionicons name="radio-outline" size={14} color="#fff" />
                  )}
                  <Text style={styles.connectBtnText}>
                    {connecting === item.id ? "..." : "اتصال"}
                  </Text>
                </TouchableOpacity>
                <TouchableOpacity
                  style={styles.deleteBtn}
                  onPress={() => deleteRouter(item.id)}
                >
                  <Ionicons name="trash-outline" size={16} color={Colors.destructive} />
                </TouchableOpacity>
              </View>
            </View>
          )}
        />
      )}

      {/* Add Router Modal */}
      <Modal
        visible={showAdd}
        animationType="slide"
        presentationStyle="pageSheet"
        onRequestClose={() => setShowAdd(false)}
      >
        <SafeAreaView style={styles.modalSafe}>
          <View style={styles.modalHeader}>
            <Text style={styles.modalTitle}>إضافة راوتر جديد</Text>
            <TouchableOpacity onPress={() => setShowAdd(false)}>
              <Ionicons name="close" size={24} color={Colors.foreground} />
            </TouchableOpacity>
          </View>

          <ScrollView
            style={styles.modalContent}
            keyboardShouldPersistTaps="handled"
          >
            {/* Mode selection */}
            <Text style={styles.fieldLabel}>طريقة الاتصال</Text>
            <View style={styles.modeRow}>
              {(["rest", "api"] as ConnectionMode[]).map((m) => (
                <TouchableOpacity
                  key={m}
                  style={[
                    styles.modeBtn,
                    form.mode === m && styles.modeBtnActive,
                  ]}
                  onPress={() => handleModeChange(m)}
                >
                  <Ionicons
                    name={m === "rest" ? "server-outline" : "wifi"}
                    size={20}
                    color={
                      form.mode === m ? Colors.foreground : Colors.mutedFg
                    }
                  />
                  <Text
                    style={[
                      styles.modeBtnText,
                      form.mode === m && styles.modeBtnTextActive,
                    ]}
                  >
                    {m === "rest" ? "REST API" : "MikroTik API"}
                  </Text>
                  <Text style={styles.modeSubText}>
                    {m === "rest" ? "v7.1+" : "v6 / v7"}
                  </Text>
                </TouchableOpacity>
              ))}
            </View>

            {/* Label */}
            <Text style={styles.fieldLabel}>اسم الراوتر (اختياري)</Text>
            <TextInput
              style={styles.textInput}
              placeholder="مكتب - راوتر رئيسي"
              placeholderTextColor={Colors.mutedFg}
              value={form.label}
              onChangeText={(v) => setForm((f) => ({ ...f, label: v }))}
              textAlign="right"
            />

            {/* Protocol + Host */}
            <Text style={styles.fieldLabel}>العنوان</Text>
            <View style={styles.protocolRow}>
              <View style={styles.protocolPicker}>
                {protocolOptions.map((opt) => (
                  <TouchableOpacity
                    key={opt.value}
                    style={[
                      styles.protoOpt,
                      form.protocol === opt.value && styles.protoOptActive,
                    ]}
                    onPress={() => {
                      const p = opt.value as ConnectionProtocol;
                      setForm((f) => ({
                        ...f,
                        protocol: p,
                        port: getDefaultPort(f.mode, p),
                      }));
                    }}
                  >
                    <Text
                      style={[
                        styles.protoText,
                        form.protocol === opt.value && styles.protoTextActive,
                      ]}
                    >
                      {opt.label}
                    </Text>
                  </TouchableOpacity>
                ))}
              </View>
            </View>
            <TextInput
              style={[styles.textInput, styles.monoInput]}
              placeholder="192.168.88.1"
              placeholderTextColor={Colors.mutedFg}
              value={form.host}
              onChangeText={(v) => setForm((f) => ({ ...f, host: v.trim() }))}
              keyboardType="url"
              autoCapitalize="none"
              textAlign="left"
            />

            {/* Port / User / Pass */}
            <View style={styles.gridRow}>
              <View style={styles.gridItem}>
                <Text style={styles.fieldLabel}>البورت</Text>
                <TextInput
                  style={[styles.textInput, styles.monoInput]}
                  value={form.port}
                  onChangeText={(v) => setForm((f) => ({ ...f, port: v.trim() }))}
                  keyboardType="numeric"
                  textAlign="left"
                />
              </View>
              <View style={styles.gridItem}>
                <Text style={styles.fieldLabel}>المستخدم</Text>
                <TextInput
                  style={[styles.textInput, styles.monoInput]}
                  value={form.username}
                  onChangeText={(v) => setForm((f) => ({ ...f, username: v }))}
                  autoCapitalize="none"
                  textAlign="left"
                />
              </View>
            </View>

            <Text style={styles.fieldLabel}>كلمة المرور</Text>
            <TextInput
              style={[styles.textInput, styles.monoInput]}
              value={form.password}
              onChangeText={(v) => setForm((f) => ({ ...f, password: v }))}
              secureTextEntry
              placeholder="••••••••"
              placeholderTextColor={Colors.mutedFg}
              textAlign="left"
            />

            <Button
              onPress={addRouter}
              label="اختبار وحفظ"
              loading={saving}
              disabled={!form.host || !form.username || !form.password}
              style={{ marginTop: Spacing.md, marginBottom: Spacing.xxxl }}
            />
          </ScrollView>
        </SafeAreaView>
      </Modal>
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
    borderBottomWidth: 1,
    borderBottomColor: Colors.border,
  },
  headerLeft: { flexDirection: "row", alignItems: "center", gap: Spacing.sm },
  logoBox: {
    width: 36,
    height: 36,
    borderRadius: Radius.md,
    backgroundColor: Colors.primary,
    alignItems: "center",
    justifyContent: "center",
  },
  headerTitle: { fontSize: 14, fontWeight: "700", color: Colors.foreground },
  headerSub: { fontSize: 10, color: Colors.mutedFg },
  iconBtn: { padding: 6 },
  titleRow: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
    paddingHorizontal: Spacing.lg,
    paddingVertical: Spacing.md,
  },
  pageTitle: { fontSize: 18, fontWeight: "800", color: Colors.foreground },
  pageSub: { fontSize: 12, color: Colors.mutedFg, marginTop: 2 },
  addBtn: {
    flexDirection: "row",
    alignItems: "center",
    gap: 5,
    backgroundColor: Colors.primary,
    paddingHorizontal: 14,
    paddingVertical: 8,
    borderRadius: Radius.md,
  },
  addBtnText: { color: "#fff", fontSize: 13, fontWeight: "600" },
  list: { paddingHorizontal: Spacing.lg, gap: Spacing.sm, paddingBottom: 24 },
  routerCard: {
    backgroundColor: Colors.card,
    borderRadius: Radius.lg,
    borderWidth: 1,
    borderColor: Colors.cardBorder,
    padding: Spacing.md,
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
  },
  routerLeft: { flexDirection: "row", alignItems: "center", gap: Spacing.sm, flex: 1 },
  statusIcon: {
    width: 36,
    height: 36,
    borderRadius: Radius.md,
    alignItems: "center",
    justifyContent: "center",
  },
  routerInfo: { flex: 1 },
  routerLabel: {
    fontSize: 14,
    fontWeight: "600",
    color: Colors.foreground,
  },
  routerMeta: {
    fontSize: 10,
    color: Colors.mutedFg,
    fontFamily: "Courier",
    marginTop: 2,
  },
  routerActions: { flexDirection: "row", gap: Spacing.xs, alignItems: "center" },
  connectBtn: {
    flexDirection: "row",
    alignItems: "center",
    gap: 4,
    backgroundColor: Colors.primary,
    paddingHorizontal: 10,
    paddingVertical: 6,
    borderRadius: Radius.sm,
  },
  connectBtnText: { color: "#fff", fontSize: 11, fontWeight: "600" },
  deleteBtn: {
    padding: 6,
    borderRadius: Radius.sm,
    backgroundColor: Colors.destructiveBg,
  },
  emptyState: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
    gap: Spacing.sm,
    paddingHorizontal: Spacing.xxxl,
  },
  emptyTitle: {
    fontSize: 18,
    fontWeight: "700",
    color: Colors.foreground,
    marginTop: Spacing.sm,
  },
  emptySub: { fontSize: 13, color: Colors.mutedFg },
  // Modal
  modalSafe: { flex: 1, backgroundColor: Colors.background },
  modalHeader: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
    paddingHorizontal: Spacing.lg,
    paddingVertical: Spacing.md,
    borderBottomWidth: 1,
    borderBottomColor: Colors.border,
  },
  modalTitle: { fontSize: 16, fontWeight: "700", color: Colors.foreground },
  modalContent: { flex: 1, paddingHorizontal: Spacing.lg, paddingTop: Spacing.lg },
  fieldLabel: {
    fontSize: 12,
    fontWeight: "500",
    color: Colors.foreground,
    textAlign: "right",
    marginBottom: 6,
    marginTop: Spacing.sm,
  },
  textInput: {
    backgroundColor: Colors.muted,
    borderWidth: 1,
    borderColor: Colors.border,
    borderRadius: Radius.md,
    paddingHorizontal: Spacing.md,
    paddingVertical: Spacing.sm + 2,
    fontSize: 14,
    color: Colors.foreground,
    textAlign: "right",
  },
  monoInput: { textAlign: "left", fontFamily: "Courier" },
  modeRow: {
    flexDirection: "row",
    gap: Spacing.sm,
    marginBottom: Spacing.xs,
  },
  modeBtn: {
    flex: 1,
    padding: Spacing.md,
    borderRadius: Radius.md,
    borderWidth: 1,
    borderColor: Colors.border,
    backgroundColor: Colors.muted,
    alignItems: "flex-start",
    gap: 4,
  },
  modeBtnActive: {
    borderColor: "rgba(124,58,237,0.4)",
    backgroundColor: "rgba(124,58,237,0.08)",
  },
  modeBtnText: {
    fontSize: 13,
    fontWeight: "600",
    color: Colors.mutedFg,
  },
  modeBtnTextActive: { color: Colors.foreground },
  modeSubText: { fontSize: 10, color: Colors.mutedFg },
  protocolRow: { marginBottom: Spacing.xs },
  protocolPicker: { flexDirection: "row", gap: Spacing.xs, marginBottom: 6 },
  protoOpt: {
    paddingHorizontal: 12,
    paddingVertical: 6,
    borderRadius: Radius.sm,
    borderWidth: 1,
    borderColor: Colors.border,
    backgroundColor: Colors.muted,
  },
  protoOptActive: {
    borderColor: Colors.primary,
    backgroundColor: "rgba(124,58,237,0.12)",
  },
  protoText: { fontSize: 12, color: Colors.mutedFg, fontWeight: "500" },
  protoTextActive: { color: Colors.foreground },
  gridRow: { flexDirection: "row", gap: Spacing.sm },
  gridItem: { flex: 1 },
});
