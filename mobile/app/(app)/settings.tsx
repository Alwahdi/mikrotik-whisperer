import React, { useState, useEffect } from "react";
import {
  View, Text, StyleSheet, ScrollView, TouchableOpacity,
  TextInput, Alert,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { router } from "expo-router";
import { Ionicons } from "@expo/vector-icons";
import { useQueryClient } from "@tanstack/react-query";
import { useAuth } from "@/contexts/AuthContext";
import {
  getMikrotikConfig,
  saveMikrotikConfig,
  clearMikrotikConfig,
  getDefaultPort,
  getProtocolOptions,
  type MikrotikConfig,
  type ConnectionMode,
  type ConnectionProtocol,
} from "@/lib/mikrotikConfig";
import { supabase } from "@/lib/supabase";
import { Colors, Radius, Spacing } from "@/lib/theme";
import Button from "@/components/Button";

export default function SettingsScreen() {
  const { user, signOut, role, isAdmin } = useAuth();
  const queryClient = useQueryClient();
  const [form, setForm] = useState<MikrotikConfig>({
    host: "", user: "admin", pass: "", port: "443", protocol: "https", mode: "rest",
  });
  const [connected, setConnected] = useState(false);
  const [testing, setTesting] = useState(false);
  const [routerInfo, setRouterInfo] = useState("");

  useEffect(() => {
    getMikrotikConfig().then((saved) => {
      if (saved) {
        setForm(saved);
        setConnected(true);
        setRouterInfo(saved.label || "");
      }
    });
  }, []);

  const handleFieldChange = (field: keyof MikrotikConfig, value: string) => {
    setForm((prev) => {
      const updated = { ...prev, [field]: value };
      if (field === "mode") {
        const mode = value as ConnectionMode;
        const proto = mode === "rest" ? "https" : "api-plain";
        updated.protocol = proto as ConnectionProtocol;
        updated.port = getDefaultPort(mode, proto as ConnectionProtocol);
      }
      if (field === "protocol") {
        updated.port = getDefaultPort(updated.mode, value as ConnectionProtocol);
      }
      return updated;
    });
    setConnected(false);
  };

  const testConnection = async () => {
    if (!form.host || !form.user || !form.pass) {
      Alert.alert("خطأ", "يرجى تعبئة جميع الحقول");
      return;
    }
    setTesting(true);
    try {
      const { data, error } = await supabase.functions.invoke("mikrotik-api", {
        body: {
          endpoint: "/system/identity/print",
          host: form.host, user: form.user, pass: form.pass,
          port: form.port, protocol: form.protocol, mode: form.mode,
        },
      });
      if (error) throw error;
      if (data?.error) throw new Error(data.error);
      const name = Array.isArray(data) ? data[0]?.name : data?.name;
      await saveMikrotikConfig({ ...form, label: name || "MikroTik" });
      setConnected(true);
      setRouterInfo(name || "MikroTik");
      queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
      Alert.alert("تم الاتصال", `متصل بـ: ${name || "MikroTik"}`);
    } catch (err: any) {
      setConnected(false);
      Alert.alert("فشل", err.message || "خطأ في الاتصال");
    } finally {
      setTesting(false);
    }
  };

  const disconnect = async () => {
    await clearMikrotikConfig();
    setConnected(false);
    setRouterInfo("");
    setForm({ host: "", user: "admin", pass: "", port: "443", protocol: "https", mode: "rest" });
    queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
  };

  const protocolOptions = getProtocolOptions(form.mode);

  return (
    <SafeAreaView style={styles.safe}>
      <ScrollView contentContainerStyle={styles.scroll}>
        {/* Header */}
        <View style={styles.header}>
          <Text style={styles.pageTitle}>الإعدادات</Text>
        </View>

        {/* Account Info */}
        <View style={styles.card}>
          <Text style={styles.cardTitle}>الحساب</Text>
          <View style={styles.accountRow}>
            <View style={styles.avatar}>
              <Ionicons name="person" size={20} color={Colors.primaryLight} />
            </View>
            <View style={styles.accountInfo}>
              <Text style={styles.accountEmail}>{user?.email}</Text>
              <Text style={styles.accountRole}>
                {role === "admin" ? "مدير" : role === "cashier" ? "كاشير" : "مستخدم"}
              </Text>
            </View>
          </View>
        </View>

        {/* Connection Status */}
        {connected && (
          <View style={styles.connectedBanner}>
            <Ionicons name="checkmark-circle" size={18} color={Colors.success} />
            <View style={{ flex: 1 }}>
              <Text style={styles.connectedTitle}>متصل: {routerInfo}</Text>
              <Text style={styles.connectedMeta}>
                {form.mode === "rest" ? "REST" : "API"} • {form.host}:{form.port}
              </Text>
            </View>
            <TouchableOpacity onPress={disconnect}>
              <Ionicons name="power-outline" size={20} color={Colors.destructive} />
            </TouchableOpacity>
          </View>
        )}

        {/* Connection Mode */}
        <View style={styles.card}>
          <Text style={styles.cardTitle}>طريقة الاتصال</Text>
          <View style={styles.modeRow}>
            {(["rest", "api"] as ConnectionMode[]).map((m) => (
              <TouchableOpacity
                key={m}
                style={[styles.modeBtn, form.mode === m && styles.modeBtnActive]}
                onPress={() => handleFieldChange("mode", m)}
              >
                <Ionicons
                  name={m === "rest" ? "server-outline" : "wifi"}
                  size={18}
                  color={form.mode === m ? Colors.foreground : Colors.mutedFg}
                />
                <Text style={[styles.modeBtnText, form.mode === m && { color: Colors.foreground }]}>
                  {m === "rest" ? "REST API" : "MikroTik API"}
                </Text>
                <Text style={styles.modeSubText}>{m === "rest" ? "v7.1+" : "v6 / v7"}</Text>
              </TouchableOpacity>
            ))}
          </View>
        </View>

        {/* Connection Details */}
        <View style={styles.card}>
          <Text style={styles.cardTitle}>بيانات الاتصال</Text>

          <View>
            <Text style={styles.fieldLabel}>البروتوكول</Text>
            <View style={styles.protoRow}>
              {protocolOptions.map((opt) => (
                <TouchableOpacity
                  key={opt.value}
                  style={[styles.protoChip, form.protocol === opt.value && styles.protoChipActive]}
                  onPress={() => handleFieldChange("protocol", opt.value)}
                >
                  <Text style={[styles.protoText, form.protocol === opt.value && { color: Colors.foreground }]}>
                    {opt.label}
                  </Text>
                </TouchableOpacity>
              ))}
            </View>
          </View>

          <View>
            <Text style={styles.fieldLabel}>العنوان (Host)</Text>
            <TextInput
              style={[styles.input, styles.monoInput]}
              value={form.host}
              onChangeText={(v) => handleFieldChange("host", v.trim())}
              placeholder="192.168.88.1"
              placeholderTextColor={Colors.mutedFg}
              keyboardType="url"
              autoCapitalize="none"
              textAlign="left"
            />
          </View>

          <View style={styles.rowGroup}>
            <View style={{ flex: 1 }}>
              <Text style={styles.fieldLabel}>البورت</Text>
              <TextInput
                style={[styles.input, styles.monoInput]}
                value={form.port}
                onChangeText={(v) => handleFieldChange("port", v.trim())}
                keyboardType="numeric"
                textAlign="left"
              />
            </View>
            <View style={{ flex: 1 }}>
              <Text style={styles.fieldLabel}>المستخدم</Text>
              <TextInput
                style={[styles.input, styles.monoInput]}
                value={form.user}
                onChangeText={(v) => handleFieldChange("user", v)}
                autoCapitalize="none"
                textAlign="left"
              />
            </View>
          </View>

          <View>
            <Text style={styles.fieldLabel}>كلمة المرور</Text>
            <TextInput
              style={[styles.input, styles.monoInput]}
              value={form.pass}
              onChangeText={(v) => handleFieldChange("pass", v)}
              secureTextEntry
              placeholder="••••••••"
              placeholderTextColor={Colors.mutedFg}
              textAlign="left"
            />
          </View>

          <Button
            onPress={testConnection}
            label="اتصال وحفظ"
            loading={testing}
            disabled={!form.host || !form.user || !form.pass}
          />
        </View>

        {/* Tips */}
        <View style={styles.card}>
          <Text style={styles.cardTitle}>نصائح</Text>
          {[
            "REST API: فعّل www أو www-ssl من IP → Services",
            "MikroTik API: فعّل api أو api-ssl من IP → Services",
            "Cloud: فعّل IP → Cloud واستخدم xxx.sn.mynetname.net",
            "تأكد من فتح البورت في الفايروول",
          ].map((tip, i) => (
            <Text key={i} style={styles.tipText}>• {tip}</Text>
          ))}
        </View>

        {/* Navigation shortcuts */}
        <View style={styles.card}>
          <Text style={styles.cardTitle}>روابط سريعة</Text>
          {[
            { label: "إدارة الراوترات", icon: "hardware-chip-outline" as const, path: "/routers" },
            { label: "النسخ الاحتياطي", icon: "cloud-download-outline" as const, path: "/(app)/backups" },
          ].map((item) => (
            <TouchableOpacity
              key={item.path}
              style={styles.linkRow}
              onPress={() => router.push(item.path as any)}
            >
              <Ionicons name={item.icon} size={18} color={Colors.textSecondary} />
              <Text style={styles.linkText}>{item.label}</Text>
              <Ionicons name="chevron-back-outline" size={14} color={Colors.mutedFg} />
            </TouchableOpacity>
          ))}
        </View>

        {/* Sign Out */}
        <TouchableOpacity
          style={styles.signOutBtn}
          onPress={() => {
            Alert.alert("تسجيل الخروج", "هل تريد الخروج؟", [
              { text: "إلغاء", style: "cancel" },
              {
                text: "خروج",
                style: "destructive",
                onPress: async () => {
                  await signOut();
                  router.replace("/(auth)/login");
                },
              },
            ]);
          }}
        >
          <Ionicons name="log-out-outline" size={18} color={Colors.destructive} />
          <Text style={styles.signOutText}>تسجيل الخروج</Text>
        </TouchableOpacity>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  scroll: { padding: Spacing.lg, gap: Spacing.md, paddingBottom: 40 },
  header: { marginBottom: Spacing.xs },
  pageTitle: { fontSize: 20, fontWeight: "800", color: Colors.foreground },
  card: {
    backgroundColor: Colors.card, borderRadius: Radius.lg,
    borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: Spacing.sm,
  },
  cardTitle: { fontSize: 12, fontWeight: "700", color: Colors.textSecondary, textTransform: "uppercase", letterSpacing: 0.5 },
  accountRow: { flexDirection: "row", alignItems: "center", gap: Spacing.sm },
  avatar: {
    width: 40, height: 40, borderRadius: 20,
    backgroundColor: "rgba(124,58,237,0.12)", alignItems: "center", justifyContent: "center",
  },
  accountInfo: { flex: 1 },
  accountEmail: { fontSize: 14, fontWeight: "600", color: Colors.foreground },
  accountRole: { fontSize: 11, color: Colors.mutedFg },
  connectedBanner: {
    flexDirection: "row", alignItems: "center", gap: Spacing.sm,
    backgroundColor: Colors.successBg, borderWidth: 1, borderColor: "rgba(34,197,94,0.25)",
    borderRadius: Radius.md, padding: Spacing.md,
  },
  connectedTitle: { fontSize: 13, fontWeight: "600", color: Colors.foreground },
  connectedMeta: { fontSize: 10, color: Colors.mutedFg, fontFamily: "Courier" },
  modeRow: { flexDirection: "row", gap: Spacing.sm },
  modeBtn: {
    flex: 1, padding: Spacing.sm, borderRadius: Radius.md,
    borderWidth: 1, borderColor: Colors.border, backgroundColor: Colors.muted,
    alignItems: "flex-start", gap: 4,
  },
  modeBtnActive: { borderColor: "rgba(124,58,237,0.4)", backgroundColor: "rgba(124,58,237,0.08)" },
  modeBtnText: { fontSize: 13, fontWeight: "600", color: Colors.mutedFg },
  modeSubText: { fontSize: 10, color: Colors.mutedFg },
  fieldLabel: { fontSize: 12, fontWeight: "500", color: Colors.foreground, textAlign: "right", marginBottom: 5 },
  protoRow: { flexDirection: "row", gap: 8, flexWrap: "wrap" },
  protoChip: {
    paddingHorizontal: 12, paddingVertical: 6, borderRadius: Radius.sm,
    borderWidth: 1, borderColor: Colors.border, backgroundColor: Colors.muted,
  },
  protoChipActive: { borderColor: Colors.primary, backgroundColor: "rgba(124,58,237,0.12)" },
  protoText: { fontSize: 12, fontWeight: "500", color: Colors.mutedFg },
  input: {
    backgroundColor: Colors.muted, borderWidth: 1, borderColor: Colors.border,
    borderRadius: Radius.md, paddingHorizontal: Spacing.md, paddingVertical: Spacing.sm + 2,
    fontSize: 14, color: Colors.foreground,
  },
  monoInput: { textAlign: "left", fontFamily: "Courier" },
  rowGroup: { flexDirection: "row", gap: Spacing.sm },
  tipText: { fontSize: 11, color: Colors.mutedFg, lineHeight: 18 },
  linkRow: {
    flexDirection: "row", alignItems: "center", gap: Spacing.sm,
    paddingVertical: 6,
  },
  linkText: { flex: 1, fontSize: 13, color: Colors.foreground },
  signOutBtn: {
    flexDirection: "row", alignItems: "center", justifyContent: "center", gap: 8,
    backgroundColor: Colors.destructiveBg, borderWidth: 1, borderColor: "rgba(239,68,68,0.25)",
    borderRadius: Radius.md, paddingVertical: 12,
  },
  signOutText: { fontSize: 14, fontWeight: "600", color: Colors.destructive },
});
