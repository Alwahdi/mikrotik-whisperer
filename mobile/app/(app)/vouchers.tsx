import React, { useState } from "react";
import {
  View, Text, StyleSheet, ScrollView, TouchableOpacity,
  TextInput, Alert, ActivityIndicator, Image, Dimensions,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { Ionicons } from "@expo/vector-icons";
import Animated, { FadeInDown } from "react-native-reanimated";
import { LinearGradient } from "expo-linear-gradient";
import * as ImagePicker from "expo-image-picker";
import * as Print from "expo-print";
import * as Sharing from "expo-sharing";
import { supabase } from "@/lib/supabase";
import { useAuth } from "@/contexts/AuthContext";
import { useHotspotProfiles, useUserManagerProfiles, useRawBatchAction } from "@/hooks/useMikrotik";
import { Colors, Radius, Spacing } from "@/lib/theme";
import Button from "@/components/Button";
import LoadingView from "@/components/LoadingView";
import AnimatedPressable from "@/components/AnimatedPressable";
import { lightTap, notifySuccess, notifyError } from "@/lib/haptics";

const { width: SCREEN_WIDTH } = Dimensions.get("window");
const CARD_WIDTH = (SCREEN_WIDTH - Spacing.lg * 2 - Spacing.sm) / 2;
const CARD_HEIGHT = CARD_WIDTH * 0.62;

type VoucherType = "hotspot" | "usermanager";
type CardTemplateId = "dark" | "gradient" | "minimal" | "custom";

interface CardTemplate {
  id: CardTemplateId;
  label: string;
  icon: string;
}

const CARD_TEMPLATES: CardTemplate[] = [
  { id: "dark", label: "داكن", icon: "moon-outline" },
  { id: "gradient", label: "متدرج", icon: "color-palette-outline" },
  { id: "minimal", label: "بسيط", icon: "square-outline" },
  { id: "custom", label: "صورة مخصصة", icon: "image-outline" },
];

function generatePassword(length = 8): string {
  const chars = "abcdefghjkmnpqrstuvwxyz23456789";
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

interface VoucherCard {
  username: string;
  password: string;
  profile: string;
}

function CardPreview({
  card,
  template,
  bgImage,
  networkName,
  logoText,
}: {
  card: VoucherCard;
  template: CardTemplateId;
  bgImage: string | null;
  networkName: string;
  logoText: string;
}) {
  if (template === "custom" && bgImage) {
    return (
      <View style={[cardStyles.card, { width: CARD_WIDTH, height: CARD_HEIGHT }]}>
        <Image source={{ uri: bgImage }} style={StyleSheet.absoluteFillObject} resizeMode="cover" />
        <View style={cardStyles.customOverlay}>
          <Text style={cardStyles.customNet} numberOfLines={1}>{networkName || "Wi-Fi"}</Text>
          <View style={cardStyles.credRow}>
            <Text style={cardStyles.customLabel}>👤</Text>
            <Text style={cardStyles.customCred}>{card.username}</Text>
          </View>
          <View style={cardStyles.credRow}>
            <Text style={cardStyles.customLabel}>🔑</Text>
            <Text style={cardStyles.customCred}>{card.password}</Text>
          </View>
          <Text style={cardStyles.customProfile}>{card.profile}</Text>
        </View>
      </View>
    );
  }

  if (template === "gradient") {
    return (
      <LinearGradient
        colors={["#7c3aed", "#3b82f6"]}
        start={{ x: 0, y: 0 }}
        end={{ x: 1, y: 1 }}
        style={[cardStyles.card, { width: CARD_WIDTH, height: CARD_HEIGHT }]}
      >
        <View style={cardStyles.gradientTop}>
          <Text style={cardStyles.gradientNet} numberOfLines={1}>{networkName || "Wi-Fi"}</Text>
          <View style={cardStyles.gradientBadge}><Text style={cardStyles.gradientBadgeText}>{card.profile}</Text></View>
        </View>
        <View style={cardStyles.gradientBody}>
          <Text style={cardStyles.gradientLabel}>اسم المستخدم</Text>
          <Text style={cardStyles.gradientValue}>{card.username}</Text>
          <Text style={[cardStyles.gradientLabel, { marginTop: 3 }]}>كلمة المرور</Text>
          <Text style={cardStyles.gradientValue}>{card.password}</Text>
        </View>
      </LinearGradient>
    );
  }

  if (template === "minimal") {
    return (
      <View style={[cardStyles.card, cardStyles.minimalCard, { width: CARD_WIDTH, height: CARD_HEIGHT }]}>
        <Text style={cardStyles.minimalNet} numberOfLines={1}>{networkName || "Wi-Fi"}</Text>
        <View style={cardStyles.minimalDivider} />
        <Text style={cardStyles.minimalLabel}>👤 {card.username}</Text>
        <Text style={cardStyles.minimalLabel}>🔑 {card.password}</Text>
        <Text style={cardStyles.minimalProfile}>{card.profile}</Text>
      </View>
    );
  }

  // Dark (default)
  return (
    <View style={[cardStyles.card, cardStyles.darkCard, { width: CARD_WIDTH, height: CARD_HEIGHT }]}>
      <View style={cardStyles.darkTop}>
        <Text style={cardStyles.darkNet} numberOfLines={1}>{networkName || "Wi-Fi"}</Text>
        <View style={cardStyles.darkDot} />
      </View>
      <Text style={cardStyles.darkLabel}>اسم المستخدم</Text>
      <Text style={cardStyles.darkValue}>{card.username}</Text>
      <Text style={[cardStyles.darkLabel, { marginTop: 4 }]}>كلمة المرور</Text>
      <Text style={cardStyles.darkValue}>{card.password}</Text>
      <Text style={cardStyles.darkProfile}>{card.profile}</Text>
    </View>
  );
}

function buildPrintHtml(
  vouchers: VoucherCard[],
  template: CardTemplateId,
  bgImage: string | null,
  networkName: string,
  logoText: string
): string {
  const bgStyle = template === "custom" && bgImage
    ? `background-image: url('${bgImage}'); background-size: cover; background-position: center;`
    : template === "gradient"
    ? "background: linear-gradient(135deg, #7c3aed, #3b82f6);"
    : template === "minimal"
    ? "background: #fff; border: 1px solid #e2e8f0;"
    : "background: #1a1a2e;";

  const textColor = template === "minimal" ? "#0f172a" : "#ffffff";
  const subColor = template === "minimal" ? "#64748b" : "rgba(255,255,255,0.7)";

  const cardsHtml = vouchers.map((v) => `
    <div style="
      ${bgStyle}
      width: 8.5cm; height: 5.4cm;
      border-radius: 10px;
      padding: 14px;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      box-sizing: border-box;
      position: relative;
      overflow: hidden;
    ">
      ${(template === "custom" && bgImage) ? `<div style="position:absolute;inset:0;background:rgba(0,0,0,0.45);border-radius:10px;"></div>` : ""}
      <div style="position:relative;">
        <div style="font-size:11px; font-weight:700; color:${textColor}; margin-bottom:2px;">${networkName || "Wi-Fi Network"}</div>
        <div style="font-size:9px; color:${subColor};">${v.profile}</div>
      </div>
      <div style="position:relative;">
        <div style="font-size:9px; color:${subColor}; margin-bottom:2px;">اسم المستخدم / Username</div>
        <div style="font-size:13px; font-weight:800; color:${textColor}; font-family:monospace; letter-spacing:1px;">${v.username}</div>
        <div style="font-size:9px; color:${subColor}; margin-top:6px; margin-bottom:2px;">كلمة المرور / Password</div>
        <div style="font-size:13px; font-weight:800; color:${textColor}; font-family:monospace; letter-spacing:1px;">${v.password}</div>
      </div>
      ${logoText ? `<div style="position:relative; font-size:8px; color:${subColor}; text-align:right;">${logoText}</div>` : ""}
    </div>
  `).join("");

  return `<!DOCTYPE html>
<html dir="rtl">
<head>
<meta charset="UTF-8">
<style>
  * { margin: 0; padding: 0; box-sizing: border-box; }
  body { background: #f8fafc; padding: 20px; font-family: Arial, sans-serif; }
  h2 { font-size: 16px; color: #0f172a; margin-bottom: 16px; direction: rtl; }
  .grid { display: flex; flex-wrap: wrap; gap: 12px; }
</style>
</head>
<body>
  <h2>${networkName || "كروت الإنترنت"} — ${vouchers.length} كرت</h2>
  <div class="grid">${cardsHtml}</div>
</body>
</html>`;
}

export default function VouchersScreen() {
  const { user } = useAuth();
  const [voucherType, setVoucherType] = useState<VoucherType>("hotspot");
  const { data: hotspotProfilesData, isLoading: loadingHotspotProfiles } = useHotspotProfiles();
  const { data: umProfilesData, isLoading: loadingUmProfiles } = useUserManagerProfiles();
  const batchAction = useRawBatchAction();

  const [selectedProfile, setSelectedProfile] = useState<string>("");
  const [count, setCount] = useState("10");
  const [prefix, setPrefix] = useState("");
  const [salesPoint, setSalesPoint] = useState("");
  const [networkName, setNetworkName] = useState("");
  const [logoText, setLogoText] = useState("");
  const [cardTemplate, setCardTemplate] = useState<CardTemplateId>("gradient");
  const [bgImage, setBgImage] = useState<string | null>(null);
  const [generatedVouchers, setGeneratedVouchers] = useState<VoucherCard[]>([]);
  const [uploading, setUploading] = useState(false);
  const [printing, setPrinting] = useState(false);
  const [previewMode, setPreviewMode] = useState(false);

  const isLoading = voucherType === "hotspot" ? loadingHotspotProfiles : loadingUmProfiles;
  const profilesData = voucherType === "hotspot" ? hotspotProfilesData : umProfilesData;
  const profileList = Array.isArray(profilesData) ? profilesData : [];

  const pickImage = async () => {
    const { status } = await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (status !== "granted") {
      Alert.alert("إذن مطلوب", "يرجى السماح للتطبيق بالوصول لمكتبة الصور");
      return;
    }
    const result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsEditing: true,
      aspect: [85, 54],
      quality: 0.8,
      base64: true,
    });
    if (!result.canceled && result.assets[0]) {
      const asset = result.assets[0];
      const uri = asset.base64
        ? `data:image/jpeg;base64,${asset.base64}`
        : asset.uri;
      setBgImage(uri);
      setCardTemplate("custom");
      lightTap();
    }
  };

  const generate = () => {
    if (!selectedProfile) { Alert.alert("خطأ", "اختر باقة أولاً"); return; }
    const n = parseInt(count) || 10;
    if (n < 1 || n > 500) { Alert.alert("خطأ", "عدد الكروت يجب أن يكون بين 1 و 500"); return; }
    lightTap();
    const vouchers: VoucherCard[] = [];
    for (let i = 0; i < n; i++) {
      const uname = prefix ? `${prefix}${generatePassword(6)}` : generatePassword(8);
      vouchers.push({ username: uname, password: uname, profile: selectedProfile });
    }
    setGeneratedVouchers(vouchers);
    setPreviewMode(true);
    notifySuccess();
  };

  const uploadToRouter = async () => {
    if (!generatedVouchers.length) return;
    setUploading(true);
    try {
      const baseEndpoint = voucherType === "hotspot"
        ? "/ip/hotspot/user/add"
        : "/user-manager/user/add";

      const commands = generatedVouchers.map((v) => ({
        command: baseEndpoint,
        args: [
          `=name=${v.username}`,
          `=password=${v.password}`,
          ...(voucherType === "hotspot" ? [`=profile=${v.profile}`] : [`=group=${v.profile}`]),
        ],
      }));

      const result = await batchAction.mutateAsync({ commands });
      const failed = (result?.errors || []).filter((e: any) => e).length;
      const total = generatedVouchers.length;
      const success = total - failed;

      if (success > 0 && user?.id) {
        const price = profileList.find((p: any) => p.name === selectedProfile)?.price;
        await supabase.from("sales").insert({
          user_id: user.id,
          profile_name: selectedProfile,
          success_count: success,
          fail_count: failed,
          total_amount: Number(price || 0) * success,
          sales_point: salesPoint || null,
        });
      }

      notifySuccess();
      Alert.alert("النتيجة", `تم رفع ${success} كرت من ${total}\nفشل: ${failed}`);
    } catch (err: any) {
      notifyError();
      Alert.alert("خطأ", err.message || "فشل الرفع");
    } finally {
      setUploading(false);
    }
  };

  const printCards = async () => {
    if (!generatedVouchers.length) return;
    setPrinting(true);
    try {
      const html = buildPrintHtml(generatedVouchers, cardTemplate, bgImage, networkName, logoText);
      const { uri } = await Print.printToFileAsync({ html, base64: false });
      const canShare = await Sharing.isAvailableAsync();
      if (canShare) {
        await Sharing.shareAsync(uri, { mimeType: "application/pdf", dialogTitle: "مشاركة الكروت" });
      } else {
        await Print.printAsync({ uri });
      }
    } catch (err: any) {
      Alert.alert("خطأ", err.message || "فشل الطباعة");
    } finally {
      setPrinting(false);
    }
  };

  if (isLoading) return <LoadingView />;

  return (
    <SafeAreaView style={styles.safe} edges={["top"]}>
      <ScrollView contentContainerStyle={styles.scroll} showsVerticalScrollIndicator={false}>
        <Animated.View entering={FadeInDown.delay(0).springify()}>
          <Text style={styles.pageTitle}>توليد الكروت</Text>
          <Text style={styles.pageSubtitle}>أنشئ كروت احترافية للهوتسبوت أو يوزر مانجر</Text>
        </Animated.View>

        {/* Voucher Type */}
        <Animated.View entering={FadeInDown.delay(40).springify()} style={styles.card}>
          <Text style={styles.cardTitle}>نوع الكروت</Text>
          <View style={styles.typeRow}>
            <AnimatedPressable
              style={[styles.typeBtn, voucherType === "hotspot" && styles.typeBtnActive] as any}
              onPress={() => { lightTap(); setVoucherType("hotspot"); setSelectedProfile(""); setGeneratedVouchers([]); }}
            >
              <Ionicons name="wifi-outline" size={20} color={voucherType === "hotspot" ? Colors.primaryLight : Colors.mutedFg} />
              <Text style={[styles.typeBtnText, voucherType === "hotspot" && { color: Colors.foreground }]}>هوتسبوت</Text>
              <Text style={styles.typeSubText}>Hotspot Users</Text>
            </AnimatedPressable>
            <AnimatedPressable
              style={[styles.typeBtn, voucherType === "usermanager" && styles.typeBtnActive] as any}
              onPress={() => { lightTap(); setVoucherType("usermanager"); setSelectedProfile(""); setGeneratedVouchers([]); }}
            >
              <Ionicons name="people-outline" size={20} color={voucherType === "usermanager" ? Colors.primaryLight : Colors.mutedFg} />
              <Text style={[styles.typeBtnText, voucherType === "usermanager" && { color: Colors.foreground }]}>يوزر مانجر</Text>
              <Text style={styles.typeSubText}>User Manager</Text>
            </AnimatedPressable>
          </View>
        </Animated.View>

        {/* Profile Selection */}
        <Animated.View entering={FadeInDown.delay(80).springify()} style={styles.card}>
          <Text style={styles.cardTitle}>اختر الباقة</Text>
          {profileList.length === 0 ? (
            <Text style={styles.emptyText}>لا توجد باقات متاحة</Text>
          ) : (
            <ScrollView horizontal showsHorizontalScrollIndicator={false}>
              <View style={styles.profileRow}>
                {profileList.map((p: any) => (
                  <TouchableOpacity
                    key={p[".id"] || p.name}
                    style={[styles.profileChip, selectedProfile === p.name && styles.profileChipActive]}
                    onPress={() => { lightTap(); setSelectedProfile(p.name); }}
                  >
                    <Text style={[styles.profileChipText, selectedProfile === p.name && styles.profileChipTextActive]}>
                      {p.name}
                    </Text>
                    {p.price ? <Text style={styles.profilePrice}>{p.price} ر.س</Text> : null}
                    {p.validity ? <Text style={styles.profileValidity}>{p.validity}</Text> : null}
                  </TouchableOpacity>
                ))}
              </View>
            </ScrollView>
          )}
        </Animated.View>

        {/* Generation Options */}
        <Animated.View entering={FadeInDown.delay(120).springify()} style={styles.card}>
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
                maxLength={3}
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
                autoCapitalize="none"
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
        </Animated.View>

        {/* Card Design */}
        <Animated.View entering={FadeInDown.delay(160).springify()} style={styles.card}>
          <Text style={styles.cardTitle}>تصميم الكرت</Text>

          {/* Network Name & Logo */}
          <View style={styles.optionRow}>
            <View style={styles.optionItem}>
              <Text style={styles.optionLabel}>اسم الشبكة</Text>
              <TextInput
                style={styles.optionInput}
                value={networkName}
                onChangeText={setNetworkName}
                placeholder="Wi-Fi"
                placeholderTextColor={Colors.mutedFg}
                textAlign="right"
              />
            </View>
            <View style={styles.optionItem}>
              <Text style={styles.optionLabel}>نص الشعار</Text>
              <TextInput
                style={styles.optionInput}
                value={logoText}
                onChangeText={setLogoText}
                placeholder="شركتك"
                placeholderTextColor={Colors.mutedFg}
                textAlign="right"
              />
            </View>
          </View>

          {/* Template Selector */}
          <Text style={[styles.optionLabel, { marginBottom: 6, marginTop: 4 }]}>قالب الكرت</Text>
          <View style={styles.templateRow}>
            {CARD_TEMPLATES.map((t) => (
              <TouchableOpacity
                key={t.id}
                style={[styles.templateChip, cardTemplate === t.id && styles.templateChipActive]}
                onPress={() => {
                  lightTap();
                  if (t.id === "custom") {
                    pickImage();
                  } else {
                    setCardTemplate(t.id);
                  }
                }}
              >
                <Ionicons
                  name={t.icon as any}
                  size={18}
                  color={cardTemplate === t.id ? Colors.primaryLight : Colors.mutedFg}
                />
                <Text style={[styles.templateChipText, cardTemplate === t.id && { color: Colors.foreground }]}>
                  {t.label}
                </Text>
              </TouchableOpacity>
            ))}
          </View>

          {/* Custom BG upload button */}
          {cardTemplate === "custom" && (
            <TouchableOpacity style={styles.uploadBtn} onPress={pickImage}>
              <Ionicons name="cloud-upload-outline" size={18} color={Colors.primaryLight} />
              <Text style={styles.uploadBtnText}>
                {bgImage ? "تغيير الصورة الخلفية" : "رفع صورة خلفية"}
              </Text>
            </TouchableOpacity>
          )}

          {/* Live Preview */}
          {selectedProfile && (
            <View>
              <Text style={[styles.optionLabel, { marginTop: 8, marginBottom: 6 }]}>معاينة الكرت</Text>
              <View style={styles.previewContainer}>
                <CardPreview
                  card={{ username: prefix ? `${prefix}xxxxxx` : "xxxxxxxx", password: prefix ? `${prefix}xxxxxx` : "xxxxxxxx", profile: selectedProfile }}
                  template={cardTemplate}
                  bgImage={bgImage}
                  networkName={networkName}
                  logoText={logoText}
                />
              </View>
            </View>
          )}
        </Animated.View>

        {/* Generate Button */}
        <Animated.View entering={FadeInDown.delay(200).springify()}>
          <Button
            onPress={generate}
            label={`توليد ${count || "10"} كرت`}
            disabled={!selectedProfile}
            size="lg"
          />
        </Animated.View>

        {/* Generated Cards Grid */}
        {generatedVouchers.length > 0 && (
          <Animated.View entering={FadeInDown.delay(0).springify()} style={styles.card}>
            <View style={styles.voucherHeader}>
              <Text style={styles.cardTitle}>الكروت المولّدة ({generatedVouchers.length})</Text>
              <TouchableOpacity onPress={() => { lightTap(); setGeneratedVouchers([]); setPreviewMode(false); }}>
                <Ionicons name="trash-outline" size={18} color={Colors.destructive} />
              </TouchableOpacity>
            </View>

            {/* Card Grid Preview */}
            <View style={styles.cardGrid}>
              {generatedVouchers.slice(0, previewMode ? 6 : generatedVouchers.length).map((v, i) => (
                <CardPreview
                  key={i}
                  card={v}
                  template={cardTemplate}
                  bgImage={bgImage}
                  networkName={networkName}
                  logoText={logoText}
                />
              ))}
            </View>
            {generatedVouchers.length > 6 && (
              <Text style={styles.moreCardsText}>+{generatedVouchers.length - 6} كرت إضافي</Text>
            )}

            {/* Action Buttons */}
            <View style={styles.actionButtons}>
              <Button
                onPress={uploadToRouter}
                loading={uploading}
                label={`رفع للراوتر (${generatedVouchers.length})`}
                variant="primary"
                style={{ flex: 1 }}
              />
              <TouchableOpacity
                style={[styles.printBtn, printing && styles.printBtnDisabled]}
                onPress={printCards}
                disabled={printing}
              >
                {printing ? (
                  <ActivityIndicator size="small" color={Colors.primaryLight} />
                ) : (
                  <Ionicons name="print-outline" size={20} color={Colors.primaryLight} />
                )}
                <Text style={styles.printBtnText}>{printing ? "..." : "طباعة"}</Text>
              </TouchableOpacity>
            </View>
          </Animated.View>
        )}
      </ScrollView>
    </SafeAreaView>
  );
}

const cardStyles = StyleSheet.create({
  card: { borderRadius: Radius.md, overflow: "hidden" },
  // Dark template
  darkCard: { backgroundColor: "#1a1a2e", borderWidth: 1, borderColor: "#2a2a3e", padding: 10, justifyContent: "space-between" },
  darkTop: { flexDirection: "row", alignItems: "center", justifyContent: "space-between" },
  darkNet: { fontSize: 9, fontWeight: "700", color: Colors.primaryLight, flex: 1 },
  darkDot: { width: 5, height: 5, borderRadius: 3, backgroundColor: Colors.success },
  darkLabel: { fontSize: 7, color: Colors.mutedFg },
  darkValue: { fontSize: 10, fontWeight: "800", color: Colors.foreground, fontFamily: "Courier", letterSpacing: 0.5 },
  darkProfile: { fontSize: 7, color: Colors.mutedFg, marginTop: 3 },
  // Gradient template
  gradientTop: { flexDirection: "row", justifyContent: "space-between", alignItems: "flex-start" },
  gradientNet: { fontSize: 9, fontWeight: "700", color: "#fff", flex: 1 },
  gradientBadge: { backgroundColor: "rgba(255,255,255,0.2)", paddingHorizontal: 5, paddingVertical: 2, borderRadius: 4 },
  gradientBadgeText: { fontSize: 7, color: "#fff", fontWeight: "600" },
  gradientBody: { flex: 1, justifyContent: "flex-end" },
  gradientLabel: { fontSize: 7, color: "rgba(255,255,255,0.7)" },
  gradientValue: { fontSize: 10, fontWeight: "800", color: "#fff", fontFamily: "Courier", letterSpacing: 0.5 },
  // Minimal template
  minimalCard: { backgroundColor: "#fff", borderWidth: 1, borderColor: "#e2e8f0", padding: 10, justifyContent: "space-between" },
  minimalNet: { fontSize: 10, fontWeight: "800", color: "#0f172a" },
  minimalDivider: { height: 1, backgroundColor: "#e2e8f0", marginVertical: 4 },
  minimalLabel: { fontSize: 9, color: "#334155", fontFamily: "Courier" },
  minimalProfile: { fontSize: 7, color: "#94a3b8", marginTop: 2 },
  // Custom template
  customOverlay: { ...StyleSheet.absoluteFillObject, backgroundColor: "rgba(0,0,0,0.5)", padding: 10, justifyContent: "space-between" },
  customNet: { fontSize: 9, fontWeight: "700", color: "#fff" },
  credRow: { flexDirection: "row", alignItems: "center", gap: 4 },
  customLabel: { fontSize: 9 },
  customCred: { fontSize: 9, fontWeight: "800", color: "#fff", fontFamily: "Courier" },
  customProfile: { fontSize: 7, color: "rgba(255,255,255,0.7)" },
});

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  scroll: { padding: Spacing.lg, gap: Spacing.md, paddingBottom: 40 },
  pageTitle: { fontSize: 22, fontWeight: "800", color: Colors.foreground, letterSpacing: -0.5 },
  pageSubtitle: { fontSize: 12, color: Colors.textSecondary, marginTop: 3 },
  card: {
    backgroundColor: Colors.card, borderRadius: Radius.lg,
    borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: Spacing.sm,
  },
  cardTitle: { fontSize: 11, fontWeight: "700", color: Colors.textSecondary, textTransform: "uppercase", letterSpacing: 0.8 },
  typeRow: { flexDirection: "row", gap: Spacing.sm },
  typeBtn: {
    flex: 1, padding: Spacing.sm, borderRadius: Radius.md, borderWidth: 1,
    borderColor: Colors.border, backgroundColor: Colors.muted, alignItems: "flex-start", gap: 4,
  },
  typeBtnActive: { borderColor: "rgba(124,58,237,0.4)", backgroundColor: "rgba(124,58,237,0.08)" },
  typeBtnText: { fontSize: 13, fontWeight: "600", color: Colors.mutedFg },
  typeSubText: { fontSize: 10, color: Colors.mutedFg },
  emptyText: { fontSize: 12, color: Colors.mutedFg, textAlign: "center", paddingVertical: Spacing.sm },
  profileRow: { flexDirection: "row", gap: 8, paddingBottom: 4 },
  profileChip: {
    paddingHorizontal: 14, paddingVertical: 8, borderRadius: Radius.full,
    borderWidth: 1, borderColor: Colors.border, backgroundColor: Colors.muted, alignItems: "center",
  },
  profileChipActive: { borderColor: Colors.primary, backgroundColor: "rgba(124,58,237,0.12)" },
  profileChipText: { fontSize: 13, fontWeight: "500", color: Colors.mutedFg },
  profileChipTextActive: { color: Colors.foreground, fontWeight: "700" },
  profilePrice: { fontSize: 10, color: Colors.success, marginTop: 2, fontWeight: "600" },
  profileValidity: { fontSize: 9, color: Colors.mutedFg, marginTop: 1 },
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
  templateRow: { flexDirection: "row", flexWrap: "wrap", gap: 8 },
  templateChip: {
    flexDirection: "row", alignItems: "center", gap: 5,
    paddingHorizontal: 10, paddingVertical: 6, borderRadius: Radius.sm,
    borderWidth: 1, borderColor: Colors.border, backgroundColor: Colors.muted,
  },
  templateChipActive: { borderColor: Colors.primary, backgroundColor: "rgba(124,58,237,0.12)" },
  templateChipText: { fontSize: 11, fontWeight: "600", color: Colors.mutedFg },
  uploadBtn: {
    flexDirection: "row", alignItems: "center", gap: 8, justifyContent: "center",
    borderWidth: 1, borderStyle: "dashed", borderColor: Colors.primary,
    borderRadius: Radius.md, paddingVertical: 10, marginTop: 4,
    backgroundColor: "rgba(124,58,237,0.05)",
  },
  uploadBtnText: { fontSize: 13, color: Colors.primaryLight, fontWeight: "600" },
  previewContainer: { alignItems: "flex-start" },
  voucherHeader: { flexDirection: "row", alignItems: "center", justifyContent: "space-between" },
  cardGrid: { flexDirection: "row", flexWrap: "wrap", gap: Spacing.sm },
  moreCardsText: { fontSize: 11, color: Colors.mutedFg, textAlign: "center" },
  actionButtons: { flexDirection: "row", gap: Spacing.sm, alignItems: "center", marginTop: Spacing.xs },
  printBtn: {
    flexDirection: "row", alignItems: "center", gap: 6,
    backgroundColor: "rgba(124,58,237,0.1)", borderWidth: 1, borderColor: "rgba(124,58,237,0.3)",
    borderRadius: Radius.md, paddingHorizontal: Spacing.md, paddingVertical: 11,
  },
  printBtnDisabled: { opacity: 0.5 },
  printBtnText: { fontSize: 13, color: Colors.primaryLight, fontWeight: "600" },
});
