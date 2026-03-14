import React, { useState, useMemo, useCallback } from "react";
import {
  View, Text, StyleSheet, FlatList, TouchableOpacity,
  TextInput, Alert, RefreshControl, Modal, ScrollView,
  KeyboardAvoidingView, Platform, Pressable,
  ActivityIndicator, Share,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import Animated, { FadeInDown } from "react-native-reanimated";
import { Ionicons } from "@expo/vector-icons";
import * as Print from "expo-print";
import * as Sharing from "expo-sharing";
import {
  useUserManagerUsers, useUserManagerProfiles, useUserManagerSessions,
  useUserManagerAction, useUserManagerBatchAdd, useRawBatchAction,
} from "@/hooks/useMikrotik";
import { Colors, Radius, Spacing } from "@/lib/theme";
import { ListRowSkeleton } from "@/components/SkeletonLoader";
import EmptyState from "@/components/EmptyState";
import Badge from "@/components/Badge";
import AnimatedPressable from "@/components/AnimatedPressable";
import { lightTap, notifySuccess, notifyError } from "@/lib/haptics";

const MONO_FONT = Platform.select({ ios: "Courier", android: "monospace", default: "monospace" });

type Tab = "users" | "profiles" | "sessions";
/** How credentials appear on the printed card / are generated */
type CredentialMode =
  | "usernameAndPassword"   // separate username & password (different values)
  | "sameCredentials"       // same value used for both username and password
  | "usernameOnly"          // card shows only username (password stored = username)
  | "passwordOnly";         // card shows only password (username stored = password)
type CharMode = "alphanumeric" | "lettersOnly" | "numbersOnly";

interface GeneratedUser {
  username: string;
  password: string;
  profile: string;
  /** what to display as the primary credential on a printed card */
  cardDisplay: "both" | "usernameOnly" | "passwordOnly" | "same";
}

interface AddResult {
  user: GeneratedUser;
  ok: boolean;
  error?: string;
}

function genChars(mode: CharMode, length: number): string {
  const pool =
    mode === "numbersOnly"
      ? "0123456789"
      : mode === "lettersOnly"
        ? "abcdefghjkmnpqrstuvwxyz"
        : "abcdefghjkmnpqrstuvwxyz23456789";
  let out = "";
  if (typeof crypto !== "undefined" && crypto.getRandomValues) {
    const buf = new Uint8Array(length);
    crypto.getRandomValues(buf);
    for (let i = 0; i < length; i++) out += pool[buf[i] % pool.length];
  } else {
    out = Array.from({ length }, () => pool[Math.floor(Math.random() * pool.length)]).join("");
  }
  return out;
}

function OptionChips({
  options, value, onChange,
}: {
  options: { label: string; value: string; icon?: string }[];
  value: string;
  onChange: (v: string) => void;
}) {
  return (
    <View style={chipGroupStyles.row}>
      {options.map((opt) => {
        const active = value === opt.value;
        return (
          <TouchableOpacity
            key={opt.value}
            style={[chipGroupStyles.chip, active && chipGroupStyles.chipActive]}
            onPress={() => { lightTap(); onChange(opt.value); }}
            activeOpacity={0.75}
          >
            {opt.icon ? (
              <Ionicons
                name={opt.icon as any}
                size={13}
                color={active ? Colors.primaryFg : Colors.mutedFg}
              />
            ) : null}
            <Text style={[chipGroupStyles.label, active && chipGroupStyles.labelActive]}>
              {opt.label}
            </Text>
          </TouchableOpacity>
        );
      })}
    </View>
  );
}

const chipGroupStyles = StyleSheet.create({
  row: { flexDirection: "row", flexWrap: "wrap", gap: 6 },
  chip: {
    flexDirection: "row", alignItems: "center", gap: 4,
    paddingHorizontal: 12, paddingVertical: 7,
    borderRadius: Radius.full,
    backgroundColor: Colors.muted,
    borderWidth: 1, borderColor: Colors.border,
  },
  chipActive: { backgroundColor: Colors.primary, borderColor: Colors.primary },
  label: { fontSize: 12, fontWeight: "600", color: Colors.mutedFg },
  labelActive: { color: Colors.primaryFg },
});

// ─── User Context Menu Sheet ──────────────────────
function UserContextSheet({ user, visible, onClose, profiles, action, onViewSessions }: {
  user: any;
  visible: boolean;
  onClose: () => void;
  profiles: any[];
  action: ReturnType<typeof useUserManagerAction>;
  onViewSessions: (username: string) => void;
}) {
  const [view, setView] = useState<"menu" | "assign-profile">("menu");

  const handleClose = useCallback(() => { setView("menu"); onClose(); }, [onClose]);

  const handleDelete = useCallback(() => {
    const name = user?.username || user?.name || "المستخدم";
    lightTap();
    Alert.alert("حذف الكرت", `حذف ${name}؟`, [
      { text: "إلغاء", style: "cancel" },
      {
        text: "حذف", style: "destructive",
        onPress: () => action.mutate(
          { action: "remove", id: user?.[".id"] },
          { onSuccess: () => { notifySuccess(); handleClose(); }, onError: () => notifyError() }
        ),
      },
    ]);
  }, [user, action, handleClose]);

  const handleToggleDisable = useCallback(() => {
    const disabled = user?.disabled === "true" || user?.disabled === true;
    lightTap();
    action.mutate(
      { action: disabled ? "enable" : "disable", id: user?.[".id"] },
      { onSuccess: () => { notifySuccess(); handleClose(); }, onError: () => notifyError() }
    );
  }, [user, action, handleClose]);

  const handleAssignProfile = useCallback((profileName: string) => {
    lightTap();
    action.mutate(
      { action: "set", id: user?.[".id"], data: { group: profileName } },
      { onSuccess: () => { notifySuccess(); handleClose(); }, onError: () => notifyError() }
    );
  }, [user, action, handleClose]);

  const disabled = user?.disabled === "true" || user?.disabled === true;
  const username = user?.username || user?.name || "—";
  const currentGroup = user?.group || user?.["actual-profile"] || "";

  return (
    <Modal visible={visible} animationType="slide" transparent onRequestClose={handleClose}>
      <Pressable style={ctx.backdrop} onPress={handleClose} />
      <View style={ctx.container}>
        <View style={ctx.handle} />

        {view === "menu" ? (
          <>
            {/* Title row */}
            <View style={ctx.titleRow}>
              <View style={ctx.titleAvatar}>
                <Ionicons name="person" size={16} color={Colors.primaryLight} />
              </View>
              <View style={{ flex: 1 }}>
                <Text style={ctx.titleName}>{username}</Text>
                {currentGroup ? <Text style={ctx.titleSub}>{currentGroup}</Text> : null}
              </View>
              <TouchableOpacity onPress={handleClose} style={ctx.closeBtn}>
                <Ionicons name="close" size={18} color={Colors.mutedFg} />
              </TouchableOpacity>
            </View>

            {/* Menu items */}
            <View style={ctx.menuList}>
              <TouchableOpacity style={ctx.menuItem} onPress={handleDelete}>
                <View style={[ctx.menuIconWrap, ctx.menuIconDestructive]}>
                  <Ionicons name="trash-outline" size={16} color={Colors.destructive} />
                </View>
                <Text style={[ctx.menuItemText, { color: Colors.destructive }]}>حذف الكرت</Text>
                <Ionicons name="chevron-back-outline" size={14} color={Colors.mutedFg} />
              </TouchableOpacity>

              <View style={ctx.menuDivider} />

              <TouchableOpacity style={ctx.menuItem} onPress={() => { lightTap(); setView("assign-profile"); }}>
                <View style={[ctx.menuIconWrap, ctx.menuIconPrimary]}>
                  <Ionicons name="layers-outline" size={16} color={Colors.primaryLight} />
                </View>
                <Text style={ctx.menuItemText}>اضافة باقة للكرت</Text>
                <Ionicons name="chevron-back-outline" size={14} color={Colors.mutedFg} />
              </TouchableOpacity>

              <TouchableOpacity style={ctx.menuItem} onPress={() => { onViewSessions(username); handleClose(); }}>
                <View style={[ctx.menuIconWrap, ctx.menuIconDefault]}>
                  <Ionicons name="time-outline" size={16} color={Colors.textSecondary} />
                </View>
                <Text style={ctx.menuItemText}>عرض الجلسات</Text>
                <Ionicons name="chevron-back-outline" size={14} color={Colors.mutedFg} />
              </TouchableOpacity>

              <View style={ctx.menuDivider} />

              <TouchableOpacity style={ctx.menuItem} onPress={handleToggleDisable}>
                <View style={[ctx.menuIconWrap, disabled ? ctx.menuIconSuccess : ctx.menuIconWarning]}>
                  <Ionicons
                    name={disabled ? "checkmark-circle-outline" : "ban-outline"}
                    size={16}
                    color={disabled ? Colors.success : Colors.warning}
                  />
                </View>
                <Text style={[ctx.menuItemText, { color: disabled ? Colors.success : Colors.warning }]}>
                  {disabled ? "تفعيل الكرت" : "تعطيل الكرت"}
                </Text>
                <Ionicons name="chevron-back-outline" size={14} color={Colors.mutedFg} />
              </TouchableOpacity>
            </View>
          </>
        ) : (
          <>
            {/* Assign profile view */}
            <View style={ctx.titleRow}>
              <TouchableOpacity onPress={() => setView("menu")} style={ctx.backBtn}>
                <Ionicons name="arrow-forward-outline" size={20} color={Colors.mutedFg} />
              </TouchableOpacity>
              <Text style={ctx.titleName}>اختر الباقة لـ {username}</Text>
            </View>
            <ScrollView style={{ maxHeight: 300 }} showsVerticalScrollIndicator={false}>
              {profiles.length === 0 ? (
                <Text style={ctx.emptyProfiles}>لا توجد باقات</Text>
              ) : profiles.map((p) => (
                <TouchableOpacity
                  key={p[".id"] || p.name}
                  style={[ctx.menuItem, currentGroup === p.name && ctx.menuItemActive]}
                  onPress={() => handleAssignProfile(p.name)}
                >
                  <View style={[ctx.menuIconWrap, ctx.menuIconPrimary]}>
                    <Ionicons name="layers-outline" size={16} color={Colors.primaryLight} />
                  </View>
                  <View style={{ flex: 1 }}>
                    <Text style={[ctx.menuItemText, currentGroup === p.name && { color: Colors.primaryLight }]}>
                      {p.name}
                    </Text>
                    {p["rate-limit"] && (
                      <Text style={ctx.menuItemSub}>{p["rate-limit"]}</Text>
                    )}
                  </View>
                  {currentGroup === p.name && (
                    <Ionicons name="checkmark" size={16} color={Colors.primaryLight} />
                  )}
                </TouchableOpacity>
              ))}
            </ScrollView>
          </>
        )}

        {action.isPending && (
          <View style={ctx.loadingOverlay}>
            <ActivityIndicator size="small" color={Colors.primaryLight} />
          </View>
        )}
      </View>
    </Modal>
  );
}

const ctx = StyleSheet.create({
  backdrop: { flex: 1, backgroundColor: Colors.overlay },
  container: { backgroundColor: Colors.card, borderTopLeftRadius: Radius.xxl, borderTopRightRadius: Radius.xxl, padding: Spacing.lg, paddingBottom: Platform.OS === "ios" ? 36 : Spacing.xl },
  handle: { width: 40, height: 4, borderRadius: 2, backgroundColor: Colors.border, alignSelf: "center", marginBottom: Spacing.md },
  titleRow: { flexDirection: "row", alignItems: "center", gap: Spacing.sm, marginBottom: Spacing.sm, paddingBottom: Spacing.sm, borderBottomWidth: StyleSheet.hairlineWidth, borderBottomColor: Colors.border },
  titleAvatar: { width: 32, height: 32, borderRadius: 16, backgroundColor: "rgba(124,58,237,0.12)", alignItems: "center", justifyContent: "center" },
  titleName: { fontSize: 15, fontWeight: "800", color: Colors.foreground },
  titleSub: { fontSize: 11, color: Colors.mutedFg, marginTop: 1 },
  closeBtn: { padding: 4, borderRadius: Radius.sm, backgroundColor: Colors.muted },
  backBtn: { padding: 4, borderRadius: Radius.sm, backgroundColor: Colors.muted },
  menuList: { gap: 2 },
  menuDivider: { height: StyleSheet.hairlineWidth, backgroundColor: Colors.border, marginVertical: 2, marginHorizontal: Spacing.sm },
  menuItem: { flexDirection: "row", alignItems: "center", gap: Spacing.sm, paddingVertical: 11, paddingHorizontal: Spacing.sm, borderRadius: Radius.md },
  menuItemActive: { backgroundColor: "rgba(124,58,237,0.08)" },
  menuItemText: { flex: 1, fontSize: 14, color: Colors.foreground, fontWeight: "500" },
  menuItemSub: { fontSize: 10, color: Colors.mutedFg, marginTop: 1 },
  menuIconWrap: { width: 30, height: 30, borderRadius: 8, alignItems: "center", justifyContent: "center" },
  menuIconDestructive: { backgroundColor: Colors.destructiveBg },
  menuIconPrimary: { backgroundColor: "rgba(124,58,237,0.12)" },
  menuIconDefault: { backgroundColor: Colors.muted },
  menuIconSuccess: { backgroundColor: Colors.successBg },
  menuIconWarning: { backgroundColor: Colors.warningBg },
  emptyProfiles: { fontSize: 13, color: Colors.mutedFg, textAlign: "center", padding: Spacing.xl },
  loadingOverlay: { ...StyleSheet.absoluteFillObject, backgroundColor: "rgba(0,0,0,0.25)", alignItems: "center", justifyContent: "center", borderRadius: Radius.xxl },
});

// ─── Add Users Sheet ──────────────────────────────
/** Build HTML for printing cards */
function buildPrintHtml(users: GeneratedUser[], profileName: string): string {
  const cardHtml = users.map((u) => {
    const showBoth = u.cardDisplay === "both" || u.cardDisplay === "same";
    const showUser = u.cardDisplay === "usernameOnly" || showBoth;
    const showPass = u.cardDisplay === "passwordOnly" || showBoth;
    const rows = [
      showUser ? `<div class="row"><span class="lbl">اسم المستخدم:</span><span class="val">${u.username}</span></div>` : "",
      showPass ? `<div class="row"><span class="lbl">كلمة المرور:</span><span class="val">${u.password}</span></div>` : "",
    ].join("");
    return `<div class="card"><div class="profile">${profileName}</div>${rows}</div>`;
  }).join("");

  return `<!DOCTYPE html><html dir="rtl"><head><meta charset="UTF-8"/>
<style>
  body { font-family: Arial, sans-serif; direction: rtl; margin: 0; padding: 12px; background: #fff; }
  .grid { display: grid; grid-template-columns: repeat(3, 1fr); gap: 10px; }
  .card { border: 1.5px solid #7c3aed; border-radius: 10px; padding: 10px 12px; background: #faf9ff; page-break-inside: avoid; }
  .profile { font-size: 11px; font-weight: 700; color: #7c3aed; margin-bottom: 6px; border-bottom: 1px dashed #d1c4e9; padding-bottom: 4px; }
  .row { display: flex; justify-content: space-between; align-items: center; margin-top: 3px; }
  .lbl { font-size: 10px; color: #666; }
  .val { font-size: 13px; font-weight: 700; color: #111; font-family: monospace; letter-spacing: 1px; }
</style></head><body><div class="grid">${cardHtml}</div></body></html>`;
}

/** How many users to send to the router per network request when adding in bulk. */
const CHUNK_SIZE = 10;
/** Error label used when a whole chunk fails due to a network/connection error. */
const ERR_NETWORK = "فشل الاتصال";

function AddUsersSheet({
  visible, onClose, profiles,
}: {
  visible: boolean;
  onClose: () => void;
  profiles: any[];
}) {
  const batchAdd = useUserManagerBatchAdd();

  const [credentialMode, setCredentialMode] = useState<CredentialMode>("usernameAndPassword");
  const [charMode, setCharMode] = useState<CharMode>("alphanumeric");
  const [profile, setProfile] = useState(profiles[0]?.name ?? "");
  const [count, setCount] = useState("5");
  const [codeLen, setCodeLen] = useState("6");
  const [passwordLen, setPasswordLen] = useState("6");
  const [prefix, setPrefix] = useState("");
  const [preview, setPreview] = useState<GeneratedUser[]>([]);
  const [addResults, setAddResults] = useState<AddResult[] | null>(null);
  const [printing, setPrinting] = useState(false);
  /** Non-null while a chunked add is running: tracks how many users have been sent so far. */
  const [addProgress, setAddProgress] = useState<{ done: number; total: number } | null>(null);

  // sync first profile when sheet opens
  React.useEffect(() => {
    if (visible && profiles.length && !profile) setProfile(profiles[0].name);
  }, [visible, profiles]);

  const handleGenerate = useCallback(() => {
    if (!profile) { Alert.alert("خطأ", "اختر باقة أولاً"); return; }
    const n = Math.min(Math.max(parseInt(count) || 5, 1), 500);
    const uLen = Math.min(Math.max(parseInt(codeLen) || 6, 2), 16);
    const pLen = Math.min(Math.max(parseInt(passwordLen) || 6, 2), 16);
    const safePrefix = prefix.length < uLen ? prefix : prefix.slice(0, uLen - 1);

    const users: GeneratedUser[] = [];
    for (let i = 0; i < n; i++) {
      const baseCode = safePrefix
        ? `${safePrefix}${genChars(charMode, uLen - safePrefix.length)}`
        : genChars(charMode, uLen);

      let username: string;
      let password: string;
      let cardDisplay: GeneratedUser["cardDisplay"];

      switch (credentialMode) {
        case "usernameAndPassword":
          username = baseCode;
          password = genChars(charMode, pLen);
          cardDisplay = "both";
          break;
        case "sameCredentials":
          username = baseCode;
          password = baseCode;
          cardDisplay = "same";
          break;
        case "usernameOnly":
          username = baseCode;
          password = baseCode;          // stored password = username
          cardDisplay = "usernameOnly";
          break;
        case "passwordOnly":
          password = baseCode;
          username = baseCode;          // stored username = password code
          cardDisplay = "passwordOnly";
          break;
        default:
          username = baseCode;
          password = genChars(charMode, pLen);
          cardDisplay = "both";
      }
      users.push({ username, password, profile, cardDisplay });
    }
    setPreview(users);
    setAddResults(null);
    notifySuccess();
  }, [profile, count, codeLen, passwordLen, prefix, charMode, credentialMode]);

  const handleAddToServer = useCallback(async () => {
    if (!preview.length) return;

    const total = preview.length;
    // Accumulate per-user error strings across all chunks (undefined = success).
    const allErrors: (string | undefined)[] = new Array(total).fill(undefined);
    const chunkCount = Math.ceil(total / CHUNK_SIZE);

    setAddProgress({ done: 0, total });

    for (let c = 0; c < chunkCount; c++) {
      const start = c * CHUNK_SIZE;
      const end = Math.min(start + CHUNK_SIZE, total);
      const commands = preview.slice(start, end).map((u) => ({
        command: "/user-manager/user/add",
        args: [`=username=${u.username}`, `=password=${u.password}`, `=group=${u.profile}`],
      }));

      try {
        const result: any = await batchAdd.mutateAsync({ commands });
        const chunkErrors: string[] = result?.errors ?? [];
        for (let i = 0; i < end - start; i++) {
          allErrors[start + i] = i < chunkErrors.length ? (chunkErrors[i] || undefined) : undefined;
        }
      } catch {
        // Network failure for this chunk — mark every user in it as failed.
        // The mutation's onError handler already shows an alert to the user.
        for (let i = start; i < end; i++) {
          allErrors[i] = ERR_NETWORK;
        }
      }

      setAddProgress({ done: end, total });
    }

    setAddProgress(null);

    const results: AddResult[] = preview.map((u, i) => ({
      user: u,
      ok: !allErrors[i],
      error: allErrors[i],
    }));
    setAddResults(results);

    const failCount = results.filter((r) => !r.ok).length;
    const okCount = results.filter((r) => r.ok).length;
    if (failCount === 0) notifySuccess(); else notifyError();
    if (okCount > 0 && failCount === 0) {
      // all success — close after short delay
      setTimeout(() => { setPreview([]); setAddResults(null); onClose(); }, 1200);
    }
  }, [preview, batchAdd, onClose]);

  const handlePrint = useCallback(async () => {
    if (!preview.length) return;
    setPrinting(true);
    try {
      const html = buildPrintHtml(preview, profile);
      const canShare = await Sharing.isAvailableAsync();
      if (canShare) {
        const { uri } = await Print.printToFileAsync({ html });
        await Sharing.shareAsync(uri, { mimeType: "application/pdf", UTI: ".pdf" });
      } else {
        await Print.printAsync({ html });
      }
    } catch (err) {
      notifyError();
      if (__DEV__) console.warn("[Print]", err);
    } finally {
      setPrinting(false);
    }
  }, [preview, profile]);

  const handleShareText = useCallback(async () => {
    if (!preview.length) return;
    const lines = preview.map((u, i) => {
      if (u.cardDisplay === "usernameOnly") return `${i + 1}. ${u.username}`;
      if (u.cardDisplay === "passwordOnly") return `${i + 1}. ${u.password}`;
      return `${i + 1}. ${u.username} / ${u.password}`;
    });
    await Share.share({ message: `باقة: ${profile}\n\n${lines.join("\n")}` });
  }, [preview, profile]);

  const handleClose = useCallback(() => {
    if (addProgress) return; // prevent closing while an add operation is in flight
    setPreview([]);
    setAddResults(null);
    onClose();
  }, [onClose, addProgress]);

  const credentialOptions = [
    { value: "usernameAndPassword", label: "مختلفان", icon: "shuffle-outline" },
    { value: "sameCredentials",     label: "متطابقان", icon: "copy-outline" },
    { value: "usernameOnly",        label: "مستخدم فقط", icon: "person-outline" },
    { value: "passwordOnly",        label: "كلمة مرور فقط", icon: "key-outline" },
  ];

  const charOptions = [
    { value: "alphanumeric", label: "أرقام+حروف", icon: "grid-outline" },
    { value: "lettersOnly",  label: "حروف فقط",   icon: "text-outline" },
    { value: "numbersOnly",  label: "أرقام فقط",  icon: "keypad-outline" },
  ];

  const showPasswordLen = credentialMode === "usernameAndPassword";

  const successCount = addResults ? addResults.filter((r) => r.ok).length : 0;
  const failCount    = addResults ? addResults.filter((r) => !r.ok).length : 0;

  return (
    <Modal
      visible={visible}
      animationType="slide"
      transparent
      onRequestClose={handleClose}
    >
      <Pressable style={sheet.backdrop} onPress={handleClose} />
      <KeyboardAvoidingView
        behavior={Platform.OS === "ios" ? "padding" : "height"}
        style={sheet.kvWrapper}
      >
        <View style={sheet.container}>
          {/* Handle */}
          <View style={sheet.handle} />
          <View style={sheet.headerRow}>
            <View style={sheet.headerTitleWrap}>
              <Ionicons name="person-add-outline" size={16} color={Colors.primaryLight} />
              <Text style={sheet.title}>إضافة كروت — يوزر مانجر</Text>
            </View>
            <TouchableOpacity
              onPress={handleClose}
              style={sheet.closeBtn}
              accessibilityRole="button"
              accessibilityLabel="إغلاق"
            >
              <Ionicons name="close" size={20} color={Colors.mutedFg} />
            </TouchableOpacity>
          </View>

          <ScrollView showsVerticalScrollIndicator={false} keyboardShouldPersistTaps="handled">

            {/* ── Section: Credential mode ── */}
            <Text style={sheet.sectionLabel}>نوع بيانات الكرت</Text>
            <OptionChips
              value={credentialMode}
              onChange={(v) => setCredentialMode(v as CredentialMode)}
              options={credentialOptions}
            />

            {/* ── Section: Character type ── */}
            <Text style={[sheet.sectionLabel, { marginTop: Spacing.md }]}>نوع الرمز</Text>
            <OptionChips
              value={charMode}
              onChange={(v) => setCharMode(v as CharMode)}
              options={charOptions}
            />

            {/* ── Section: Profile + Count ── */}
            <View style={sheet.row2}>
              <View style={sheet.col}>
                <Text style={sheet.sectionLabel}>الباقة</Text>
                <ScrollView horizontal showsHorizontalScrollIndicator={false} style={{ maxHeight: 36 }}>
                  <View style={sheet.chipRow}>
                    {profiles.map((p) => (
                      <TouchableOpacity
                        key={p[".id"] || p.name}
                        style={[sheet.profileChip, profile === p.name && sheet.profileChipActive]}
                        onPress={() => { lightTap(); setProfile(p.name); }}
                      >
                        <Text style={[sheet.profileChipText, profile === p.name && sheet.profileChipTextActive]}>
                          {p.name}
                        </Text>
                      </TouchableOpacity>
                    ))}
                  </View>
                </ScrollView>
              </View>
              <View style={sheet.colFixed}>
                <Text style={sheet.sectionLabel}>العدد</Text>
                <TextInput
                  style={sheet.input}
                  value={count}
                  onChangeText={setCount}
                  keyboardType="numeric"
                  textAlign="center"
                  maxLength={3}
                />
              </View>
            </View>

            {/* ── Section: Lengths + Prefix ── */}
            <View style={sheet.row3}>
              <View style={sheet.col3}>
                <Text style={sheet.sectionLabel}>
                  {credentialMode === "passwordOnly" ? "طول كلمة المرور" : "طول الرمز"}
                </Text>
                <TextInput
                  style={sheet.input}
                  value={codeLen}
                  onChangeText={setCodeLen}
                  keyboardType="numeric"
                  textAlign="center"
                  maxLength={2}
                />
              </View>
              {showPasswordLen && (
                <View style={sheet.col3}>
                  <Text style={sheet.sectionLabel}>طول كلمة المرور</Text>
                  <TextInput
                    style={sheet.input}
                    value={passwordLen}
                    onChangeText={setPasswordLen}
                    keyboardType="numeric"
                    textAlign="center"
                    maxLength={2}
                  />
                </View>
              )}
              <View style={sheet.col3}>
                <Text style={sheet.sectionLabel}>بادئة (اختياري)</Text>
                <TextInput
                  style={sheet.input}
                  value={prefix}
                  onChangeText={setPrefix}
                  placeholder="مثال: usr"
                  placeholderTextColor={Colors.mutedFg}
                  textAlign="right"
                  autoCapitalize="none"
                  maxLength={8}
                />
              </View>
            </View>

            {/* ── Generate button ── */}
            <TouchableOpacity
              style={sheet.generateBtn}
              onPress={handleGenerate}
              accessibilityRole="button"
              accessibilityLabel="توليد الكروت"
            >
              <Ionicons name="flash-outline" size={16} color={Colors.primaryFg} />
              <Text style={sheet.generateBtnText}>توليد الكروت</Text>
            </TouchableOpacity>

            {/* ── Preview ── */}
            {preview.length > 0 && (
              <View style={sheet.previewBox}>
                <View style={sheet.previewTitleRow}>
                  <Ionicons name="list-outline" size={13} color={Colors.textSecondary} />
                  <Text style={sheet.previewTitle}>معاينة — {preview.length} كرت | باقة: {profile}</Text>
                </View>
                <View style={sheet.previewHeader}>
                  {credentialMode !== "passwordOnly" && (
                    <Text style={sheet.previewCol}>اسم المستخدم</Text>
                  )}
                  {credentialMode !== "usernameOnly" && (
                    <Text style={sheet.previewCol}>كلمة المرور</Text>
                  )}
                  {(credentialMode === "usernameAndPassword" || credentialMode === "sameCredentials") && (
                    <Text style={[sheet.previewCol, { flex: 0.6 }]}>الباقة</Text>
                  )}
                </View>
                {preview.slice(0, 8).map((u, i) => {
                  const res = addResults?.[i];
                  return (
                    <View key={i} style={[sheet.previewRow, i % 2 === 0 && sheet.previewRowAlt]}>
                      {credentialMode !== "passwordOnly" && (
                        <Text style={sheet.previewCellMono} numberOfLines={1}>{u.username}</Text>
                      )}
                      {credentialMode !== "usernameOnly" && (
                        <Text style={sheet.previewCellMono} numberOfLines={1}>{u.password}</Text>
                      )}
                      {res ? (
                        <View style={[sheet.resultDot, res.ok ? sheet.resultDotOk : sheet.resultDotFail]}>
                          <Ionicons
                            name={res.ok ? "checkmark" : "close"}
                            size={10}
                            color="#fff"
                          />
                        </View>
                      ) : null}
                    </View>
                  );
                })}
                {preview.length > 8 && (
                  <Text style={sheet.previewMore}>... و {preview.length - 8} آخرون</Text>
                )}
              </View>
            )}

            {/* ── Add results summary ── */}
            {addResults && (
              <View style={[sheet.resultSummary, failCount > 0 ? sheet.resultSummaryWarn : sheet.resultSummaryOk]}>
                <Ionicons
                  name={failCount === 0 ? "checkmark-circle" : "alert-circle"}
                  size={18}
                  color={failCount === 0 ? Colors.success : Colors.warning}
                />
                <Text style={[sheet.resultSummaryText, { color: failCount === 0 ? Colors.success : Colors.warning }]}>
                  {failCount === 0
                    ? `تمت إضافة ${successCount} كرت بنجاح ✓`
                    : `تمت إضافة ${successCount} | فشل ${failCount}`}
                </Text>
              </View>
            )}

            {/* ── Action buttons ── */}
            {preview.length > 0 && (
              <View style={sheet.actionRow}>
                <TouchableOpacity
                  style={[sheet.uploadBtn, addProgress !== null && sheet.btnDisabled]}
                  onPress={handleAddToServer}
                  disabled={addProgress !== null}
                  accessibilityRole="button"
                  accessibilityLabel={addResults ? "إعادة الإضافة إلى السيرفر" : "إضافة إلى السيرفر"}
                  accessibilityState={{ disabled: addProgress !== null }}
                >
                  {addProgress ? (
                    <>
                      <ActivityIndicator size="small" color={Colors.primaryFg} />
                      <Text style={sheet.uploadBtnText}>
                        جاري الإضافة... {addProgress.done}/{addProgress.total}
                      </Text>
                    </>
                  ) : (
                    <>
                      <Ionicons name="cloud-upload-outline" size={16} color={Colors.primaryFg} />
                      <Text style={sheet.uploadBtnText}>
                        {addResults ? "إعادة الإضافة" : "إضافة إلى السيرفر"}
                      </Text>
                    </>
                  )}
                </TouchableOpacity>
                {addProgress && (
                  <View style={sheet.progressBar}>
                    <View
                      style={[
                        sheet.progressFill,
                        { width: `${Math.round((addProgress.done / addProgress.total) * 100)}%` },
                      ]}
                    />
                  </View>
                )}
              </View>
            )}

            {/* ── Print / Share buttons ── */}
            {preview.length > 0 && (
              <View style={sheet.shareRow}>
                <TouchableOpacity
                  style={[sheet.shareBtn, printing && sheet.btnDisabled]}
                  onPress={handlePrint}
                  disabled={printing}
                  accessibilityRole="button"
                  accessibilityLabel="طباعة PDF"
                  accessibilityState={{ disabled: printing }}
                >
                  {printing
                    ? <ActivityIndicator size="small" color={Colors.primaryFg} />
                    : <Ionicons name="print-outline" size={15} color={Colors.primaryFg} />}
                  <Text style={sheet.shareBtnText}>طباعة PDF</Text>
                </TouchableOpacity>
                <TouchableOpacity
                  style={sheet.shareBtn}
                  onPress={handleShareText}
                  accessibilityRole="button"
                  accessibilityLabel="مشاركة الكروت كنص"
                >
                  <Ionicons name="share-outline" size={15} color={Colors.primaryFg} />
                  <Text style={sheet.shareBtnText}>مشاركة نص</Text>
                </TouchableOpacity>
              </View>
            )}

            <View style={{ height: Spacing.xl }} />
          </ScrollView>
        </View>
      </KeyboardAvoidingView>
    </Modal>
  );
}

const sheet = StyleSheet.create({
  backdrop: { flex: 1, backgroundColor: Colors.overlay },
  kvWrapper: { justifyContent: "flex-end" },
  container: {
    backgroundColor: Colors.card,
    borderTopLeftRadius: Radius.xxl,
    borderTopRightRadius: Radius.xxl,
    padding: Spacing.lg,
    paddingBottom: Platform.OS === "ios" ? 36 : Spacing.xl,
    maxHeight: "92%",
  },
  handle: { width: 40, height: 4, borderRadius: 2, backgroundColor: Colors.border, alignSelf: "center", marginBottom: Spacing.md },
  headerRow: { flexDirection: "row", alignItems: "center", justifyContent: "space-between", marginBottom: Spacing.md },
  headerTitleWrap: { flexDirection: "row", alignItems: "center", gap: 7 },
  title: { fontSize: 15, fontWeight: "800", color: Colors.foreground },
  closeBtn: { padding: 6, borderRadius: Radius.sm, backgroundColor: Colors.muted },
  sectionLabel: { fontSize: 11, fontWeight: "700", color: Colors.textSecondary, marginBottom: 7, textAlign: "right" },
  row2: { flexDirection: "row", gap: Spacing.sm, marginTop: Spacing.md, alignItems: "flex-start" },
  row3: { flexDirection: "row", gap: Spacing.sm, marginTop: Spacing.md },
  col: { flex: 1 },
  colFixed: { width: 72 },
  col3: { flex: 1 },
  input: {
    backgroundColor: Colors.muted,
    borderWidth: 1,
    borderColor: Colors.border,
    borderRadius: Radius.md,
    paddingHorizontal: Spacing.sm,
    paddingVertical: 9,
    fontSize: 13,
    color: Colors.foreground,
  },
  chipRow: { flexDirection: "row", gap: 6 },
  profileChip: {
    paddingHorizontal: 11,
    paddingVertical: 6,
    borderRadius: Radius.full,
    backgroundColor: Colors.muted,
    borderWidth: 1,
    borderColor: Colors.border,
  },
  profileChipActive: { backgroundColor: Colors.primary, borderColor: Colors.primary },
  profileChipText: { fontSize: 11, color: Colors.mutedFg, fontWeight: "600" },
  profileChipTextActive: { color: Colors.primaryFg },
  // Generate button
  generateBtn: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    gap: 7,
    backgroundColor: Colors.primary,
    borderRadius: Radius.md,
    paddingVertical: 13,
    marginTop: Spacing.md,
  },
  generateBtnText: { fontSize: 14, fontWeight: "700", color: Colors.primaryFg },
  // Preview
  previewBox: { marginTop: Spacing.md, backgroundColor: Colors.muted, borderRadius: Radius.md, overflow: "hidden", borderWidth: 1, borderColor: Colors.border },
  previewTitleRow: { flexDirection: "row", alignItems: "center", gap: 5, padding: Spacing.sm, borderBottomWidth: StyleSheet.hairlineWidth, borderBottomColor: Colors.border },
  previewTitle: { fontSize: 11, fontWeight: "700", color: Colors.textSecondary, flex: 1, textAlign: "right" },
  previewHeader: { flexDirection: "row", backgroundColor: Colors.sidebar, paddingHorizontal: Spacing.sm, paddingVertical: 4 },
  previewRow: { flexDirection: "row", paddingHorizontal: Spacing.sm, paddingVertical: 5, alignItems: "center" },
  previewRowAlt: { backgroundColor: "rgba(255,255,255,0.02)" },
  previewCol: { flex: 1, fontSize: 10, fontWeight: "700", color: Colors.mutedFg, textAlign: "center" },
  previewCellMono: { flex: 1, fontSize: 11, color: Colors.foreground, textAlign: "center", fontFamily: MONO_FONT },
  previewMore: { fontSize: 10, color: Colors.mutedFg, textAlign: "center", padding: Spacing.sm },
  // Result indicators
  resultDot: { width: 18, height: 18, borderRadius: 9, alignItems: "center", justifyContent: "center" },
  resultDotOk: { backgroundColor: Colors.success },
  resultDotFail: { backgroundColor: Colors.destructive },
  resultSummary: { flexDirection: "row", alignItems: "center", gap: 8, padding: Spacing.sm, borderRadius: Radius.md, marginTop: Spacing.sm, borderWidth: 1 },
  resultSummaryOk: { backgroundColor: Colors.successBg, borderColor: Colors.successBorder },
  resultSummaryWarn: { backgroundColor: Colors.warningBg, borderColor: Colors.warningBorder },
  resultSummaryText: { fontSize: 13, fontWeight: "700" },
  // Action buttons
  actionRow: { marginTop: Spacing.md },
  uploadBtn: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    gap: 7,
    backgroundColor: Colors.success,
    borderRadius: Radius.md,
    paddingVertical: 13,
  },
  uploadBtnText: { fontSize: 14, fontWeight: "700", color: "#fff" },
  btnDisabled: { opacity: 0.5 },
  progressBar: {
    height: 4,
    backgroundColor: Colors.border,
    borderRadius: 2,
    marginTop: Spacing.sm,
    overflow: "hidden",
  },
  progressFill: {
    height: 4,
    backgroundColor: Colors.success,
    borderRadius: 2,
  },
  // Share / Print
  shareRow: { flexDirection: "row", gap: Spacing.sm, marginTop: Spacing.sm },
  shareBtn: {
    flex: 1,
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    gap: 6,
    backgroundColor: "rgba(124,58,237,0.18)",
    borderRadius: Radius.md,
    paddingVertical: 10,
    borderWidth: 1,
    borderColor: Colors.primary,
  },
  shareBtnText: { fontSize: 12, fontWeight: "700", color: Colors.primaryLight },
});

export default function UserManagerScreen() {
  const [tab, setTab] = useState<Tab>("users");
  const [search, setSearch] = useState("");
  const [refreshing, setRefreshing] = useState(false);
  const [addSheetVisible, setAddSheetVisible] = useState(false);

  // Multi-select state
  const [selectMode, setSelectMode] = useState(false);
  const [selectedIds, setSelectedIds] = useState<Set<string>>(new Set());

  // Context menu state
  const [contextUser, setContextUser] = useState<any | null>(null);

  const { data: users, isLoading: loadingUsers, refetch: refetchUsers } = useUserManagerUsers({ enabled: tab === "users" || selectMode });
  const { data: profiles, isLoading: loadingProfiles, refetch: refetchProfiles } = useUserManagerProfiles({ enabled: tab === "profiles" || addSheetVisible || !!contextUser });
  const { data: sessions, isLoading: loadingSessions, refetch: refetchSessions } = useUserManagerSessions({ enabled: tab === "sessions" });
  const action = useUserManagerAction();
  const bulkAction = useRawBatchAction();

  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    if (tab === "users") await refetchUsers();
    if (tab === "profiles") await refetchProfiles();
    if (tab === "sessions") await refetchSessions();
    setRefreshing(false);
  }, [tab]);

  const userList = Array.isArray(users) ? users : [];
  const profileList = Array.isArray(profiles) ? profiles : [];
  const sessionList = Array.isArray(sessions) ? sessions : [];

  const filteredUsers = useMemo(() => {
    if (!search.trim()) return userList;
    const q = search.toLowerCase();
    return userList.filter((u: any) => (u.username || u.name || "").toLowerCase().includes(q));
  }, [userList, search]);

  const filteredSessions = useMemo(() => {
    if (!search.trim()) return sessionList;
    const q = search.toLowerCase();
    return sessionList.filter((s: any) => (s.user || "").toLowerCase().includes(q));
  }, [sessionList, search]);

  const filteredProfiles = useMemo(() => {
    if (!search.trim()) return profileList;
    const q = search.toLowerCase();
    return profileList.filter((p: any) => (p.name || "").toLowerCase().includes(q));
  }, [profileList, search]);

  // ── Multi-select helpers ──
  const toggleSelect = useCallback((id: string) => {
    lightTap();
    setSelectedIds((prev) => {
      const next = new Set(prev);
      if (next.has(id)) next.delete(id); else next.add(id);
      return next;
    });
  }, []);

  const toggleSelectMode = useCallback(() => {
    lightTap();
    setSelectMode((prev) => { if (prev) setSelectedIds(new Set()); return !prev; });
  }, []);

  const selectAll = useCallback(() => {
    lightTap();
    setSelectedIds(new Set(filteredUsers.map((u: any) => u[".id"]).filter(Boolean)));
  }, [filteredUsers]);

  const handleBulkDelete = useCallback(() => {
    if (!selectedIds.size) return;
    lightTap();
    Alert.alert("حذف المحدد", `حذف ${selectedIds.size} مستخدم؟`, [
      { text: "إلغاء", style: "cancel" },
      {
        text: "حذف", style: "destructive",
        onPress: () => {
          const commands = Array.from(selectedIds)
            .filter(Boolean)
            .map((id) => ({ command: "/user-manager/user/remove", args: [`=.id=${id}`] }));
          bulkAction.mutate({ commands }, {
            onSuccess: () => {
              notifySuccess();
              setSelectedIds(new Set());
              setSelectMode(false);
              refetchUsers();
            },
            onError: () => notifyError(),
          });
        },
      },
    ]);
  }, [selectedIds, bulkAction, refetchUsers]);

  // ── Context menu ──
  const handleViewSessions = useCallback((username: string) => {
    setSearch(username);
    setTab("sessions");
  }, []);

  const handleUserAction = useCallback((user: any, act: string) => {
    const name = user.username || user.name || "المستخدم";
    const labels: Record<string, string> = { disable: "تعطيل", enable: "تفعيل", remove: "حذف" };
    lightTap();
    Alert.alert(labels[act], `${labels[act]} ${name}؟`, [
      { text: "إلغاء", style: "cancel" },
      {
        text: labels[act],
        style: act === "remove" ? "destructive" : "default",
        onPress: () => action.mutate(
          { action: act, id: user[".id"] },
          { onSuccess: () => notifySuccess(), onError: () => notifyError() }
        ),
      },
    ]);
  }, [action]);

  const isLoading =
    (tab === "users" && loadingUsers) ||
    (tab === "profiles" && loadingProfiles) ||
    (tab === "sessions" && loadingSessions);

  const activeCount = useMemo(() =>
    userList.filter((u: any) => u.disabled !== "true" && u.disabled !== true).length,
    [userList]
  );
  const disabledCount = useMemo(() =>
    userList.filter((u: any) => u.disabled === "true" || u.disabled === true).length,
    [userList]
  );

  const allSelected = selectedIds.size > 0 && selectedIds.size === filteredUsers.filter((u: any) => u[".id"]).length;

  return (
    <SafeAreaView style={styles.safe} edges={["top"]}>
      {/* Header */}
      <View style={styles.header}>
        <View style={styles.headerLeft}>
          <Text style={styles.pageTitle}>يوزر مانجر</Text>
          {userList.length > 0 && (
            <View style={styles.statsRow}>
              <View style={styles.statPill}>
                <View style={styles.statDot} />
                <Text style={styles.statPillText}>{activeCount} نشط</Text>
              </View>
              {disabledCount > 0 && (
                <View style={styles.statPillWarn}>
                  <Text style={styles.statPillWarnText}>{disabledCount} معطل</Text>
                </View>
              )}
              <View style={styles.statPillMuted}>
                <Text style={styles.statPillMutedText}>{userList.length} إجمالي</Text>
              </View>
            </View>
          )}
        </View>
        <View style={styles.headerActions}>
          {tab === "users" && (
            <AnimatedPressable
              style={[styles.selectToggleBtn, selectMode ? styles.selectToggleBtnActive : undefined] as any}
              onPress={toggleSelectMode}
            >
              <Ionicons
                name={selectMode ? "close" : "checkmark-circle-outline"}
                size={16}
                color={selectMode ? Colors.primaryFg : Colors.textSecondary}
              />
              <Text style={[styles.selectToggleText, selectMode && styles.selectToggleTextActive]}>
                {selectMode ? "إلغاء" : "تحديد"}
              </Text>
            </AnimatedPressable>
          )}
          {!selectMode && (
            <AnimatedPressable
              style={styles.addFab}
              onPress={() => { lightTap(); setAddSheetVisible(true); }}
            >
              <Ionicons name="person-add-outline" size={18} color={Colors.primaryFg} />
              <Text style={styles.addFabText}>إضافة</Text>
            </AnimatedPressable>
          )}
        </View>
      </View>

      {/* Bulk action bar (select mode) */}
      {tab === "users" && selectMode && (
        <View style={styles.bulkBar}>
          <TouchableOpacity style={styles.selectAllRow} onPress={allSelected ? () => setSelectedIds(new Set()) : selectAll}>
            <View style={[styles.checkbox, allSelected && styles.checkboxChecked]}>
              {allSelected && <Ionicons name="checkmark" size={10} color="#fff" />}
            </View>
            <Text style={styles.selectAllText}>
              {allSelected ? "إلغاء تحديد الكل" : "تحديد الكل"}
              {selectedIds.size > 0 ? ` (${selectedIds.size})` : ""}
            </Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={[styles.bulkDeleteBtn, !selectedIds.size && styles.bulkDeleteBtnDisabled]}
            onPress={handleBulkDelete}
            disabled={!selectedIds.size || bulkAction.isPending}
          >
            {bulkAction.isPending ? (
              <ActivityIndicator size="small" color="#fff" />
            ) : (
              <>
                <Ionicons name="trash-outline" size={14} color="#fff" />
                <Text style={styles.bulkDeleteText}>حذف المحدد</Text>
              </>
            )}
          </TouchableOpacity>
        </View>
      )}

      {/* Tabs */}
      <View style={styles.tabs}>
        {(["users", "profiles", "sessions"] as Tab[]).map((t) => {
          const counts = t === "users" ? userList.length : t === "profiles" ? profileList.length : sessionList.length;
          return (
            <TouchableOpacity
              key={t}
              style={[styles.tab, tab === t && styles.tabActive]}
              onPress={() => { lightTap(); setTab(t); if (selectMode) { setSelectMode(false); setSelectedIds(new Set()); } }}
            >
              <Text style={[styles.tabText, tab === t && styles.tabTextActive]}>
                {t === "users" ? "المستخدمون" : t === "profiles" ? "الباقات" : "الجلسات"}
              </Text>
              {counts > 0 && (
                <View style={[styles.tabBadge, tab === t && styles.tabBadgeActive]}>
                  <Text style={[styles.tabBadgeText, tab === t && styles.tabBadgeTextActive]}>{counts}</Text>
                </View>
              )}
            </TouchableOpacity>
          );
        })}
      </View>

      {/* Search */}
      <View style={styles.searchRow}>
        <Ionicons name="search-outline" size={16} color={Colors.mutedFg} />
        <TextInput
          style={styles.searchInput}
          placeholder={tab === "sessions" ? "بحث باسم المستخدم..." : tab === "profiles" ? "بحث بالباقة..." : "بحث باسم المستخدم..."}
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
          {Array.from({ length: 6 }).map((_, i) => <ListRowSkeleton key={i} lines={2} />)}
        </View>
      ) : tab === "users" ? (
        <FlatList
          data={filteredUsers}
          keyExtractor={(item, i) => item[".id"] || String(i)}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
          contentContainerStyle={styles.list}
          showsVerticalScrollIndicator={false}
          ListEmptyComponent={<EmptyState title="لا يوجد مستخدمون" subtitle="اضغط إضافة لإنشاء مستخدمين جدد" />}
          renderItem={({ item, index }) => {
            const disabled = item.disabled === "true" || item.disabled === true;
            const isSelected = selectedIds.has(item[".id"]);
            return (
              <Animated.View
                entering={FadeInDown.delay(index * 25).springify()}
                style={[styles.userCard, isSelected && styles.userCardSelected]}
              >
                <View style={styles.userHeader}>
                  {/* Checkbox in select mode */}
                  {selectMode && (
                    <TouchableOpacity onPress={() => toggleSelect(item[".id"])} style={styles.checkboxWrapper}>
                      <View style={[styles.checkbox, isSelected && styles.checkboxChecked]}>
                        {isSelected && <Ionicons name="checkmark" size={10} color="#fff" />}
                      </View>
                    </TouchableOpacity>
                  )}
                  <View style={[styles.userAvatar, disabled && styles.userAvatarDisabled]}>
                    <Ionicons name="person" size={16} color={disabled ? Colors.mutedFg : Colors.primaryLight} />
                  </View>
                  <View style={styles.userInfo}>
                    <Text style={styles.userName}>{item.username || item.name || "—"}</Text>
                    <Text style={styles.userMeta}>{item["actual-profile"] || item.group || "—"}</Text>
                  </View>
                  <Badge label={disabled ? "معطل" : "نشط"} variant={disabled ? "destructive" : "success"} />
                  {/* More button */}
                  {!selectMode && (
                    <TouchableOpacity
                      style={styles.moreBtn}
                      onPress={() => { lightTap(); setContextUser(item); }}
                    >
                      <Ionicons name="ellipsis-vertical" size={16} color={Colors.mutedFg} />
                    </TouchableOpacity>
                  )}
                </View>
                {!selectMode && (
                  <View style={styles.actionRow}>
                    {disabled ? (
                      <AnimatedPressable style={[styles.btn, styles.enableBtn]} onPress={() => handleUserAction(item, "enable")}>
                        <Ionicons name="checkmark-circle-outline" size={14} color={Colors.success} />
                        <Text style={[styles.btnText, { color: Colors.success }]}>تفعيل</Text>
                      </AnimatedPressable>
                    ) : (
                      <AnimatedPressable style={[styles.btn, styles.disableBtn]} onPress={() => handleUserAction(item, "disable")}>
                        <Ionicons name="ban-outline" size={14} color={Colors.warning} />
                        <Text style={[styles.btnText, { color: Colors.warning }]}>تعطيل</Text>
                      </AnimatedPressable>
                    )}
                    <AnimatedPressable style={[styles.btn, styles.deleteBtn]} onPress={() => handleUserAction(item, "remove")}>
                      <Ionicons name="trash-outline" size={14} color={Colors.destructive} />
                      <Text style={[styles.btnText, { color: Colors.destructive }]}>حذف</Text>
                    </AnimatedPressable>
                  </View>
                )}
              </Animated.View>
            );
          }}
        />
      ) : tab === "profiles" ? (
        <FlatList
          data={filteredProfiles}
          keyExtractor={(item, i) => item[".id"] || String(i)}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
          contentContainerStyle={styles.list}
          showsVerticalScrollIndicator={false}
          ListEmptyComponent={<EmptyState title="لا توجد باقات" />}
          renderItem={({ item, index }) => (
            <Animated.View entering={FadeInDown.delay(index * 25).springify()} style={styles.profileCard}>
              <View style={styles.profileTopRow}>
                <View style={styles.profileIcon}>
                  <Ionicons name="layers-outline" size={16} color={Colors.primaryLight} />
                </View>
                <Text style={styles.profileName}>{item.name}</Text>
                {item.price ? (
                  <View style={styles.pricePill}>
                    <Text style={styles.priceText}>{item.price}</Text>
                  </View>
                ) : null}
              </View>
              <View style={styles.profileMetaGrid}>
                {item.validity && (
                  <View style={styles.metaItem}>
                    <Ionicons name="time-outline" size={12} color={Colors.mutedFg} />
                    <Text style={styles.metaValue}>{item.validity}</Text>
                  </View>
                )}
                {item["rate-limit"] && (
                  <View style={styles.metaItem}>
                    <Ionicons name="speedometer-outline" size={12} color={Colors.mutedFg} />
                    <Text style={styles.metaValue}>{item["rate-limit"]}</Text>
                  </View>
                )}
                {item["shared-users"] && (
                  <View style={styles.metaItem}>
                    <Ionicons name="people-outline" size={12} color={Colors.mutedFg} />
                    <Text style={styles.metaValue}>مشاركة: {item["shared-users"]}</Text>
                  </View>
                )}
                {item["name-for-users"] && item["name-for-users"] !== item.name && (
                  <View style={styles.metaItem}>
                    <Ionicons name="pricetag-outline" size={12} color={Colors.mutedFg} />
                    <Text style={styles.metaValue}>{item["name-for-users"]}</Text>
                  </View>
                )}
              </View>
            </Animated.View>
          )}
        />
      ) : (
        <FlatList
          data={filteredSessions}
          keyExtractor={(item, i) => item[".id"] || String(i)}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={Colors.primary} />}
          contentContainerStyle={styles.list}
          showsVerticalScrollIndicator={false}
          ListEmptyComponent={<EmptyState title="لا توجد جلسات" />}
          renderItem={({ item, index }) => {
            const isActive = item.active === "true" || item.active === true;
            return (
              <Animated.View entering={FadeInDown.delay(index * 25).springify()} style={styles.sessionCard}>
                <View style={styles.userHeader}>
                  <View style={[styles.userAvatar, isActive && styles.userAvatarActive]}>
                    <Ionicons name="time-outline" size={16} color={isActive ? Colors.success : Colors.mutedFg} />
                  </View>
                  <View style={styles.userInfo}>
                    <Text style={styles.userName}>{item.user || "—"}</Text>
                    {item.customer ? <Text style={styles.userMeta}>العميل: {item.customer}</Text> : null}
                  </View>
                  <Badge
                    label={isActive ? "نشطة" : "منتهية"}
                    variant={isActive ? "success" : "default"}
                  />
                </View>
                {(item["from-time"] || item["till-time"]) && (
                  <View style={styles.sessionTimeRow}>
                    {item["from-time"] && (
                      <View style={styles.sessionTimeItem}>
                        <Ionicons name="play-outline" size={11} color={Colors.mutedFg} />
                        <Text style={styles.sessionTimeText}>{item["from-time"]}</Text>
                      </View>
                    )}
                    {item["till-time"] && (
                      <View style={styles.sessionTimeItem}>
                        <Ionicons name="stop-outline" size={11} color={Colors.mutedFg} />
                        <Text style={styles.sessionTimeText}>{item["till-time"]}</Text>
                      </View>
                    )}
                  </View>
                )}
              </Animated.View>
            );
          }}
        />
      )}

      {/* Add Users Sheet */}
      <AddUsersSheet
        visible={addSheetVisible}
        onClose={() => setAddSheetVisible(false)}
        profiles={profileList}
      />

      {/* User Context Menu */}
      <UserContextSheet
        user={contextUser}
        visible={!!contextUser}
        onClose={() => setContextUser(null)}
        profiles={profileList}
        action={action}
        onViewSessions={handleViewSessions}
      />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },

  // Header
  header: { flexDirection: "row", alignItems: "center", justifyContent: "space-between", paddingHorizontal: Spacing.lg, paddingTop: Spacing.sm, paddingBottom: Spacing.xs },
  headerLeft: { flex: 1 },
  headerActions: { flexDirection: "row", alignItems: "center", gap: Spacing.xs },
  pageTitle: { fontSize: 22, fontWeight: "800", color: Colors.foreground, letterSpacing: -0.5 },
  statsRow: { flexDirection: "row", alignItems: "center", gap: 5, marginTop: 3, flexWrap: "wrap" },
  statPill: { flexDirection: "row", alignItems: "center", gap: 4, backgroundColor: Colors.successBg, paddingHorizontal: 8, paddingVertical: 3, borderRadius: Radius.full, borderWidth: 1, borderColor: Colors.successBorder },
  statDot: { width: 5, height: 5, borderRadius: 3, backgroundColor: Colors.success },
  statPillText: { fontSize: 10, fontWeight: "700", color: Colors.success },
  statPillWarn: { backgroundColor: Colors.warningBg, paddingHorizontal: 8, paddingVertical: 3, borderRadius: Radius.full, borderWidth: 1, borderColor: Colors.warningBorder },
  statPillWarnText: { fontSize: 10, fontWeight: "700", color: Colors.warning },
  statPillMuted: { backgroundColor: Colors.muted, paddingHorizontal: 8, paddingVertical: 3, borderRadius: Radius.full, borderWidth: 1, borderColor: Colors.border },
  statPillMutedText: { fontSize: 10, fontWeight: "600", color: Colors.textSecondary },

  // Buttons
  addFab: { flexDirection: "row", alignItems: "center", gap: 5, backgroundColor: Colors.primary, paddingHorizontal: 14, paddingVertical: 8, borderRadius: Radius.full },
  addFabText: { fontSize: 13, fontWeight: "700", color: Colors.primaryFg },
  selectToggleBtn: { flexDirection: "row", alignItems: "center", gap: 5, backgroundColor: Colors.muted, paddingHorizontal: 12, paddingVertical: 7, borderRadius: Radius.full, borderWidth: 1, borderColor: Colors.border },
  selectToggleBtnActive: { backgroundColor: Colors.primary, borderColor: Colors.primary },
  selectToggleText: { fontSize: 12, fontWeight: "700", color: Colors.textSecondary },
  selectToggleTextActive: { color: Colors.primaryFg },

  // Bulk action bar
  bulkBar: { flexDirection: "row", alignItems: "center", justifyContent: "space-between", paddingHorizontal: Spacing.lg, paddingVertical: Spacing.sm, backgroundColor: Colors.card, borderBottomWidth: 1, borderBottomColor: Colors.border, gap: Spacing.sm },
  selectAllRow: { flexDirection: "row", alignItems: "center", gap: 8, flex: 1 },
  selectAllText: { fontSize: 12, color: Colors.foreground, fontWeight: "600" },
  checkbox: { width: 20, height: 20, borderRadius: 5, borderWidth: 2, borderColor: Colors.border, alignItems: "center", justifyContent: "center", backgroundColor: Colors.muted },
  checkboxChecked: { backgroundColor: Colors.primary, borderColor: Colors.primary },
  checkboxWrapper: { marginRight: 4 },
  bulkDeleteBtn: { flexDirection: "row", alignItems: "center", gap: 5, backgroundColor: Colors.destructive, paddingHorizontal: 12, paddingVertical: 7, borderRadius: Radius.md },
  bulkDeleteBtnDisabled: { opacity: 0.45 },
  bulkDeleteText: { fontSize: 12, fontWeight: "700", color: "#fff" },

  // Tabs
  tabs: { flexDirection: "row", paddingHorizontal: Spacing.lg, gap: Spacing.xs, marginBottom: Spacing.sm, marginTop: Spacing.xs },
  tab: { flex: 1, flexDirection: "row", alignItems: "center", justifyContent: "center", gap: 5, paddingVertical: 8, borderRadius: Radius.md, backgroundColor: Colors.muted },
  tabActive: { backgroundColor: Colors.primary },
  tabText: { fontSize: 11, fontWeight: "600", color: Colors.mutedFg },
  tabTextActive: { color: "#fff" },
  tabBadge: { backgroundColor: Colors.border, borderRadius: Radius.full, paddingHorizontal: 5, paddingVertical: 1, minWidth: 18, alignItems: "center" },
  tabBadgeActive: { backgroundColor: "rgba(255,255,255,0.25)" },
  tabBadgeText: { fontSize: 9, fontWeight: "700", color: Colors.mutedFg },
  tabBadgeTextActive: { color: "#fff" },

  // Search
  searchRow: { flexDirection: "row", alignItems: "center", marginHorizontal: Spacing.lg, marginBottom: Spacing.sm, backgroundColor: Colors.card, borderWidth: 1, borderColor: Colors.border, borderRadius: Radius.md, paddingHorizontal: Spacing.sm, paddingVertical: 8, gap: 8 },
  searchInput: { flex: 1, fontSize: 13, color: Colors.foreground },

  skeletonList: { paddingHorizontal: Spacing.lg, gap: Spacing.sm },
  list: { paddingHorizontal: Spacing.lg, gap: Spacing.sm, paddingBottom: 100 },

  // User card
  userCard: { backgroundColor: Colors.card, borderRadius: Radius.lg, borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: 8 },
  userCardSelected: { borderColor: Colors.primary, backgroundColor: "rgba(124,58,237,0.06)" },
  userHeader: { flexDirection: "row", alignItems: "center", gap: Spacing.sm },
  userAvatar: { width: 34, height: 34, borderRadius: 17, backgroundColor: "rgba(124,58,237,0.12)", alignItems: "center", justifyContent: "center" },
  userAvatarDisabled: { backgroundColor: "rgba(107,114,128,0.12)" },
  userAvatarActive: { backgroundColor: "rgba(34,197,94,0.12)" },
  userInfo: { flex: 1 },
  userName: { fontSize: 13, fontWeight: "700", color: Colors.foreground },
  userMeta: { fontSize: 10, color: Colors.mutedFg, marginTop: 1 },
  moreBtn: { padding: 6, borderRadius: Radius.sm, backgroundColor: Colors.muted },
  actionRow: { flexDirection: "row", gap: 8 },
  btn: { flexDirection: "row", alignItems: "center", gap: 4, paddingHorizontal: 10, paddingVertical: 5, borderRadius: Radius.sm, borderWidth: 1 },
  btnText: { fontSize: 11, fontWeight: "600" },
  enableBtn: { borderColor: Colors.successBorder, backgroundColor: Colors.successBg },
  disableBtn: { borderColor: Colors.warningBorder, backgroundColor: Colors.warningBg },
  deleteBtn: { borderColor: Colors.destructiveBorder, backgroundColor: Colors.destructiveBg },

  // Profile card
  profileCard: { backgroundColor: Colors.card, borderRadius: Radius.lg, borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: 8 },
  profileTopRow: { flexDirection: "row", alignItems: "center", gap: Spacing.sm },
  profileIcon: { width: 30, height: 30, borderRadius: 15, backgroundColor: "rgba(124,58,237,0.12)", alignItems: "center", justifyContent: "center" },
  profileName: { flex: 1, fontSize: 14, fontWeight: "700", color: Colors.foreground },
  pricePill: { backgroundColor: "rgba(124,58,237,0.15)", paddingHorizontal: 8, paddingVertical: 3, borderRadius: Radius.full },
  priceText: { fontSize: 11, fontWeight: "700", color: Colors.primaryLight },
  profileMetaGrid: { flexDirection: "row", flexWrap: "wrap", gap: 8 },
  metaItem: { flexDirection: "row", alignItems: "center", gap: 4 },
  metaValue: { fontSize: 11, color: Colors.textSecondary },

  // Session card
  sessionCard: { backgroundColor: Colors.card, borderRadius: Radius.lg, borderWidth: 1, borderColor: Colors.cardBorder, padding: Spacing.md, gap: 8 },
  sessionTimeRow: { flexDirection: "row", gap: Spacing.md, paddingTop: 4, borderTopWidth: StyleSheet.hairlineWidth, borderTopColor: Colors.border },
  sessionTimeItem: { flexDirection: "row", alignItems: "center", gap: 4 },
  sessionTimeText: { fontSize: 10, color: Colors.mutedFg },
});
