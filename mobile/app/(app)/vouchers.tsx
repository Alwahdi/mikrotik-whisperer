import React, { useState, useMemo } from "react";
import {
  View, Text, StyleSheet, ScrollView, TouchableOpacity,
  TextInput, Alert, ActivityIndicator,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { Ionicons } from "@expo/vector-icons";
import { useQuery, useMutation } from "@tanstack/react-query";
import { supabase } from "@/lib/supabase";
import { useAuth } from "@/contexts/AuthContext";
import { useHotspotProfiles, useRawBatchAction } from "@/hooks/useMikrotik";
import { Colors, Radius, Spacing } from "@/lib/theme";
import Button from "@/components/Button";
import LoadingView from "@/components/LoadingView";

function generatePassword(length = 8): string {
  const chars = "abcdefghjkmnpqrstuvwxyz23456789";
  // Use crypto.getRandomValues when available (React Native / Hermes),
  // falling back to Math.random only as last resort.
  let result = "";
  if (typeof crypto !== "undefined" && crypto.getRandomValues) {
    const buf = new Uint8Array(length);
    crypto.getRandomValues(buf);
    for (let i = 0; i < length; i++) {
      result += chars[buf[i] % chars.length];
    }
  } else {
    result = Array.from({ length }, () =>
      chars[Math.floor(Math.random() * chars.length)]
    ).join("");
  }
  return result;
}

export default function VouchersScreen() {
  const { user } = useAuth();
  const { data: profiles, isLoading: loadingProfiles } = useHotspotProfiles();
  const batchAction = useRawBatchAction();

  const [selectedProfile, setSelectedProfile] = useState<string>("");
  const [count, setCount] = useState("10");
  const [prefix, setPrefix] = useState("");
  const [generatedVouchers, setGeneratedVouchers] = useState<string[]>([]);
  const [uploading, setUploading] = useState(false);
  const [salesPoint, setSalesPoint] = useState("");

  const profileList = Array.isArray(profiles) ? profiles : [];

  const generate = () => {
    if (!selectedProfile) { Alert.alert("خطأ", "اختر باقة أولاً"); return; }
    const n = parseInt(count) || 10;
    if (n < 1 || n > 200) { Alert.alert("خطأ", "عدد الكروت يجب أن يكون بين 1 و 200"); return; }
    const vouchers: string[] = [];
    for (let i = 0; i < n; i++) {
      const user = prefix ? `${prefix}${generatePassword(6)}` : generatePassword(8);
      vouchers.push(user);
    }
    setGeneratedVouchers(vouchers);
  };

  const uploadToRouter = async () => {
    if (!generatedVouchers.length) return;
    setUploading(true);
    try {
      const commands = generatedVouchers.map((v) => ({
        command: "/ip/hotspot/user/add",
        args: [
          `=name=${v}`,
          `=password=${v}`,
          `=profile=${selectedProfile}`,
        ],
      }));

      const result = await batchAction.mutateAsync({ commands });
      const failed = (result?.errors || []).filter((e: any) => e).length;
      const total = generatedVouchers.length;
      const success = total - failed;

      // Save sale record
      if (success > 0 && user?.id) {
        const profile = profileList.find((p: any) => p.name === selectedProfile);
        const price = Number(profile?.price || 0);
        await supabase.from("sales").insert({
          user_id: user.id,
          profile_name: selectedProfile,
          success_count: success,
          fail_count: failed,
          total_amount: price * success,
          sales_point: salesPoint || null,
        });
      }

      Alert.alert(
        "النتيجة",
        `تم رفع ${success} كرت من ${total}\nفشل: ${failed}`
      );
    } catch (err: any) {
      Alert.alert("خطأ", err.message || "فشل الرفع");
    } finally {
      setUploading(false);
    }
  };

  if (loadingProfiles) return <LoadingView />;

  return (
    <SafeAreaView style={styles.safe}>
      <ScrollView contentContainerStyle={styles.scroll}>
        <Text style={styles.pageTitle}>توليد الكروت</Text>

        {/* Profile Selection */}
        <View style={styles.card}>
          <Text style={styles.cardTitle}>اختر الباقة</Text>
          <ScrollView horizontal showsHorizontalScrollIndicator={false} style={styles.profileScroll}>
            {profileList.map((p: any) => (
              <TouchableOpacity
                key={p[".id"] || p.name}
                style={[styles.profileChip, selectedProfile === p.name && styles.profileChipActive]}
                onPress={() => setSelectedProfile(p.name)}
              >
                <Text style={[styles.profileChipText, selectedProfile === p.name && styles.profileChipTextActive]}>
                  {p.name}
                </Text>
                {p.price ? (
                  <Text style={styles.profilePrice}>{p.price}</Text>
                ) : null}
              </TouchableOpacity>
            ))}
          </ScrollView>
        </View>

        {/* Options */}
        <View style={styles.card}>
          <Text style={styles.cardTitle}>خيارات التوليد</Text>
          <View style={styles.optionRow}>
            <View style={styles.optionItem}>
              <Text style={styles.optionLabel}>عدد الكروت</Text>
              <TextInput
                style={styles.optionInput}
                value={count}
                onChangeText={setCount}
                keyboardType="numeric"
                textAlign="center"
              />
            </View>
            <View style={styles.optionItem}>
              <Text style={styles.optionLabel}>بادئة (اختياري)</Text>
              <TextInput
                style={styles.optionInput}
                value={prefix}
                onChangeText={setPrefix}
                placeholder="card_"
                placeholderTextColor={Colors.mutedFg}
                textAlign="left"
              />
            </View>
          </View>
          <View>
            <Text style={styles.optionLabel}>نقطة البيع (اختياري)</Text>
            <TextInput
              style={styles.optionInputFull}
              value={salesPoint}
              onChangeText={setSalesPoint}
              placeholder="مثال: مكتب - شبكة رئيسية"
              placeholderTextColor={Colors.mutedFg}
              textAlign="right"
            />
          </View>
        </View>

        {/* Generate Button */}
        <Button
          onPress={generate}
          label={`توليد ${count || "10"} كرت`}
          disabled={!selectedProfile}
        />

        {/* Generated Vouchers */}
        {generatedVouchers.length > 0 && (
          <View style={styles.card}>
            <View style={styles.voucherHeader}>
              <Text style={styles.cardTitle}>الكروت ({generatedVouchers.length})</Text>
              <TouchableOpacity onPress={() => setGeneratedVouchers([])}>
                <Ionicons name="trash-outline" size={18} color={Colors.destructive} />
              </TouchableOpacity>
            </View>
            <View style={styles.voucherGrid}>
              {generatedVouchers.map((v, i) => (
                <View key={i} style={styles.voucherChip}>
                  <Text style={styles.voucherText}>{v}</Text>
                </View>
              ))}
            </View>

            <Button
              onPress={uploadToRouter}
              loading={uploading}
              label={`رفع ${generatedVouchers.length} كرت للراوتر`}
              style={{ marginTop: Spacing.md }}
              variant="primary"
            />
          </View>
        )}
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  scroll: { padding: Spacing.lg, gap: Spacing.md, paddingBottom: 40 },
  pageTitle: { fontSize: 20, fontWeight: "800", color: Colors.foreground, textAlign: "right" },
  card: {
    backgroundColor: Colors.card, borderRadius: Radius.lg,
    borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: Spacing.sm,
  },
  cardTitle: { fontSize: 13, fontWeight: "600", color: Colors.foreground, textAlign: "right" },
  profileScroll: { flexGrow: 0 },
  profileChip: {
    paddingHorizontal: 14, paddingVertical: 8, borderRadius: Radius.full,
    borderWidth: 1, borderColor: Colors.border, backgroundColor: Colors.muted,
    marginLeft: 8, alignItems: "center",
  },
  profileChipActive: { borderColor: Colors.primary, backgroundColor: "rgba(124,58,237,0.12)" },
  profileChipText: { fontSize: 13, fontWeight: "500", color: Colors.mutedFg },
  profileChipTextActive: { color: Colors.foreground },
  profilePrice: { fontSize: 10, color: Colors.mutedFg, marginTop: 2 },
  optionRow: { flexDirection: "row", gap: Spacing.sm },
  optionItem: { flex: 1, gap: 4 },
  optionLabel: { fontSize: 12, fontWeight: "500", color: Colors.textSecondary, textAlign: "right" },
  optionInput: {
    backgroundColor: Colors.muted, borderWidth: 1, borderColor: Colors.border,
    borderRadius: Radius.md, paddingHorizontal: 12, paddingVertical: 8,
    fontSize: 14, color: Colors.foreground, fontFamily: "Courier",
  },
  optionInputFull: {
    backgroundColor: Colors.muted, borderWidth: 1, borderColor: Colors.border,
    borderRadius: Radius.md, paddingHorizontal: 12, paddingVertical: 8,
    fontSize: 13, color: Colors.foreground, marginTop: 4,
  },
  voucherHeader: { flexDirection: "row", alignItems: "center", justifyContent: "space-between" },
  voucherGrid: { flexDirection: "row", flexWrap: "wrap", gap: 6 },
  voucherChip: {
    backgroundColor: "rgba(124,58,237,0.08)", borderWidth: 1,
    borderColor: "rgba(124,58,237,0.2)", borderRadius: Radius.sm,
    paddingHorizontal: 10, paddingVertical: 5,
  },
  voucherText: { fontFamily: "Courier", fontSize: 12, color: Colors.foreground },
});
