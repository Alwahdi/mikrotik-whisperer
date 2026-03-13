import React, { useState, useRef } from "react";
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
  Alert,
  KeyboardAvoidingView,
  Platform,
  TextInput,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { router } from "expo-router";
import { Ionicons } from "@expo/vector-icons";
import { LinearGradient } from "expo-linear-gradient";
import Animated, { FadeInDown, FadeInUp } from "react-native-reanimated";
import { useAuth } from "@/contexts/AuthContext";
import { Colors, Radius, Spacing } from "@/lib/theme";
import Button from "@/components/Button";
import { notifySuccess, notifyError, lightTap } from "@/lib/haptics";

export default function LoginScreen() {
  const { signIn, signUp } = useAuth();
  const [isLogin, setIsLogin] = useState(true);
  const [loading, setLoading] = useState(false);
  const [showPass, setShowPass] = useState(false);
  const [form, setForm] = useState({ email: "", password: "", fullName: "" });

  const emailRef = useRef<TextInput>(null);
  const passRef = useRef<TextInput>(null);

  const switchMode = (toLogin: boolean) => {
    lightTap();
    setIsLogin(toLogin);
  };

  const handleSubmit = async () => {
    if (!form.email.trim() || !form.password) {
      notifyError();
      Alert.alert("خطأ", "يرجى تعبئة جميع الحقول");
      return;
    }
    if (!isLogin && !form.fullName.trim()) {
      notifyError();
      Alert.alert("خطأ", "يرجى إدخال الاسم الكامل");
      return;
    }
    setLoading(true);
    try {
      if (isLogin) {
        await signIn(form.email.trim(), form.password);
      } else {
        await signUp(form.email.trim(), form.password, form.fullName.trim());
      }
      notifySuccess();
      router.replace("/routers");
    } catch (err: any) {
      notifyError();
      Alert.alert("خطأ", err.message || "حدث خطأ غير متوقع");
    } finally {
      setLoading(false);
    }
  };

  return (
    <SafeAreaView style={styles.safe}>
      <KeyboardAvoidingView
        behavior={Platform.OS === "ios" ? "padding" : "height"}
        style={{ flex: 1 }}
      >
        <ScrollView
          contentContainerStyle={styles.container}
          keyboardShouldPersistTaps="handled"
          showsVerticalScrollIndicator={false}
        >
          {/* Logo */}
          <Animated.View entering={FadeInDown.delay(0).springify()} style={styles.logoSection}>
            <LinearGradient
              colors={[Colors.gradientStart, Colors.gradientEnd]}
              style={styles.logoBox}
            >
              <Ionicons name="wifi" size={36} color="#fff" />
            </LinearGradient>
            <Text style={styles.appName}>MikroTik Manager</Text>
            <Text style={styles.appSub}>إدارة أجهزة المايكروتيك بكفاءة</Text>
          </Animated.View>

          {/* Card */}
          <Animated.View entering={FadeInUp.delay(100).springify()} style={styles.card}>
            {/* Toggle */}
            <View style={styles.toggle}>
              {[
                { key: true, label: "تسجيل الدخول" },
                { key: false, label: "حساب جديد" },
              ].map(({ key, label }) => (
                <TouchableOpacity
                  key={String(key)}
                  style={[styles.toggleBtn, isLogin === key && styles.toggleBtnActive]}
                  onPress={() => switchMode(key)}
                  activeOpacity={0.75}
                >
                  <Text style={[styles.toggleText, isLogin === key && styles.toggleTextActive]}>
                    {label}
                  </Text>
                </TouchableOpacity>
              ))}
            </View>

            {/* Full Name — only in register mode */}
            {!isLogin && (
              <Animated.View entering={FadeInDown.springify()}>
                <Text style={styles.label}>الاسم الكامل</Text>
                <TextInput
                  style={styles.input}
                  placeholder="الاسم الكامل"
                  placeholderTextColor={Colors.mutedFg}
                  value={form.fullName}
                  onChangeText={(v) => setForm((f) => ({ ...f, fullName: v }))}
                  returnKeyType="next"
                  onSubmitEditing={() => emailRef.current?.focus()}
                  textAlign="right"
                />
              </Animated.View>
            )}

            {/* Email */}
            <View>
              <Text style={styles.label}>البريد الإلكتروني</Text>
              <TextInput
                ref={emailRef}
                style={[styles.input, styles.monoInput]}
                placeholder="email@example.com"
                placeholderTextColor={Colors.mutedFg}
                value={form.email}
                onChangeText={(v) => setForm((f) => ({ ...f, email: v }))}
                keyboardType="email-address"
                autoCapitalize="none"
                textContentType="emailAddress"
                returnKeyType="next"
                onSubmitEditing={() => passRef.current?.focus()}
                textAlign="left"
              />
            </View>

            {/* Password */}
            <View>
              <Text style={styles.label}>كلمة المرور</Text>
              <View style={styles.passRow}>
                <TextInput
                  ref={passRef}
                  style={[styles.input, styles.monoInput, { flex: 1 }]}
                  placeholder="••••••••"
                  placeholderTextColor={Colors.mutedFg}
                  value={form.password}
                  onChangeText={(v) => setForm((f) => ({ ...f, password: v }))}
                  secureTextEntry={!showPass}
                  textContentType="password"
                  returnKeyType="done"
                  onSubmitEditing={handleSubmit}
                  textAlign="left"
                />
                <TouchableOpacity
                  style={styles.eyeBtn}
                  onPress={() => { lightTap(); setShowPass(!showPass); }}
                  hitSlop={{ top: 8, bottom: 8, left: 8, right: 8 }}
                >
                  <Ionicons
                    name={showPass ? "eye-off" : "eye"}
                    size={18}
                    color={Colors.mutedFg}
                  />
                </TouchableOpacity>
              </View>
            </View>

            <Button
              onPress={handleSubmit}
              label={isLogin ? "تسجيل الدخول" : "إنشاء حساب"}
              loading={loading}
              size="lg"
              style={{ marginTop: Spacing.sm }}
            />
          </Animated.View>

          <Animated.Text entering={FadeInUp.delay(200).springify()} style={styles.footer}>
            يدعم RouterOS v6 و v7+ • REST API و MikroTik API
          </Animated.Text>
        </ScrollView>
      </KeyboardAvoidingView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.background },
  container: {
    flexGrow: 1,
    padding: Spacing.xl,
    justifyContent: "center",
    gap: Spacing.xl,
  },
  logoSection: { alignItems: "center", gap: Spacing.sm },
  logoBox: {
    width: 72,
    height: 72,
    borderRadius: Radius.xxl,
    alignItems: "center",
    justifyContent: "center",
    marginBottom: Spacing.xs,
  },
  appName: { fontSize: 24, fontWeight: "800", color: Colors.foreground, letterSpacing: -0.5 },
  appSub: { fontSize: 13, color: Colors.textSecondary },
  card: {
    backgroundColor: Colors.card,
    borderRadius: Radius.xl,
    borderWidth: 1,
    borderColor: Colors.cardBorder,
    padding: Spacing.xl,
    gap: Spacing.md,
  },
  toggle: {
    flexDirection: "row",
    backgroundColor: Colors.muted,
    borderRadius: Radius.md,
    padding: 3,
    marginBottom: Spacing.xs,
  },
  toggleBtn: {
    flex: 1,
    paddingVertical: 9,
    borderRadius: Radius.sm,
    alignItems: "center",
  },
  toggleBtnActive: { backgroundColor: Colors.primary },
  toggleText: { fontSize: 13, fontWeight: "600", color: Colors.mutedFg },
  toggleTextActive: { color: "#fff" },
  label: {
    fontSize: 12,
    fontWeight: "600",
    color: Colors.foreground,
    textAlign: "right",
    marginBottom: 6,
  },
  input: {
    backgroundColor: Colors.muted,
    borderWidth: 1,
    borderColor: Colors.border,
    borderRadius: Radius.md,
    paddingHorizontal: Spacing.md,
    paddingVertical: Spacing.sm + 2,
    fontSize: 14,
    color: Colors.foreground,
  },
  monoInput: { textAlign: "left" },
  passRow: { flexDirection: "row", alignItems: "center", gap: 8 },
  eyeBtn: {
    padding: 8,
    backgroundColor: Colors.muted,
    borderRadius: Radius.md,
    borderWidth: 1,
    borderColor: Colors.border,
  },
  footer: { fontSize: 11, color: Colors.mutedFg, textAlign: "center" },
});
