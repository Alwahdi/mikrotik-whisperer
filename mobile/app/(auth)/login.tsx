import React, { useState } from "react";
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
  Alert,
  KeyboardAvoidingView,
  Platform,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import { router } from "expo-router";
import { Ionicons } from "@expo/vector-icons";
import { useAuth } from "@/contexts/AuthContext";
import { Colors, Radius, Spacing } from "@/lib/theme";
import Input from "@/components/Input";
import Button from "@/components/Button";

export default function LoginScreen() {
  const { signIn, signUp } = useAuth();
  const [isLogin, setIsLogin] = useState(true);
  const [loading, setLoading] = useState(false);
  const [showPass, setShowPass] = useState(false);
  const [form, setForm] = useState({
    email: "",
    password: "",
    fullName: "",
  });

  const handleSubmit = async () => {
    if (!form.email.trim() || !form.password) {
      Alert.alert("خطأ", "يرجى تعبئة جميع الحقول");
      return;
    }
    if (!isLogin && !form.fullName.trim()) {
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
      router.replace("/routers");
    } catch (err: any) {
      Alert.alert(
        "خطأ",
        err.message || "حدث خطأ غير متوقع"
      );
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
        >
          {/* Logo */}
          <View style={styles.logoSection}>
            <View style={styles.logoBox}>
              <Ionicons name="wifi" size={32} color="#fff" />
            </View>
            <Text style={styles.appName}>MikroTik Manager</Text>
            <Text style={styles.appSub}>إدارة أجهزة المايكروتيك بسهولة</Text>
          </View>

          {/* Card */}
          <View style={styles.card}>
            {/* Toggle */}
            <View style={styles.toggle}>
              <TouchableOpacity
                style={[
                  styles.toggleBtn,
                  isLogin && styles.toggleBtnActive,
                ]}
                onPress={() => setIsLogin(true)}
              >
                <Text
                  style={[
                    styles.toggleText,
                    isLogin && styles.toggleTextActive,
                  ]}
                >
                  تسجيل الدخول
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                style={[
                  styles.toggleBtn,
                  !isLogin && styles.toggleBtnActive,
                ]}
                onPress={() => setIsLogin(false)}
              >
                <Text
                  style={[
                    styles.toggleText,
                    !isLogin && styles.toggleTextActive,
                  ]}
                >
                  حساب جديد
                </Text>
              </TouchableOpacity>
            </View>

            {/* Fields */}
            {!isLogin && (
              <Input
                label="الاسم الكامل"
                placeholder="الاسم الكامل"
                value={form.fullName}
                onChangeText={(v) => setForm((f) => ({ ...f, fullName: v }))}
                textAlign="right"
              />
            )}

            <Input
              label="البريد الإلكتروني"
              placeholder="email@example.com"
              value={form.email}
              onChangeText={(v) => setForm((f) => ({ ...f, email: v }))}
              keyboardType="email-address"
              autoCapitalize="none"
              textContentType="emailAddress"
              textAlign="left"
              style={styles.ltrInput}
            />

            <View>
              <Input
                label="كلمة المرور"
                placeholder="••••••••"
                value={form.password}
                onChangeText={(v) => setForm((f) => ({ ...f, password: v }))}
                secureTextEntry={!showPass}
                textContentType="password"
                textAlign="left"
                style={styles.ltrInput}
              />
              <TouchableOpacity
                style={styles.eyeBtn}
                onPress={() => setShowPass(!showPass)}
              >
                <Ionicons
                  name={showPass ? "eye-off" : "eye"}
                  size={18}
                  color={Colors.mutedFg}
                />
              </TouchableOpacity>
            </View>

            <Button
              onPress={handleSubmit}
              label={isLogin ? "تسجيل الدخول" : "إنشاء حساب"}
              loading={loading}
              style={{ marginTop: Spacing.sm }}
            />
          </View>

          <Text style={styles.footer}>
            يدعم RouterOS v6 و v7+ • REST API و MikroTik API
          </Text>
        </ScrollView>
      </KeyboardAvoidingView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: {
    flex: 1,
    backgroundColor: Colors.background,
  },
  container: {
    flexGrow: 1,
    padding: Spacing.xl,
    justifyContent: "center",
    gap: Spacing.xl,
  },
  logoSection: {
    alignItems: "center",
    gap: Spacing.sm,
  },
  logoBox: {
    width: 64,
    height: 64,
    borderRadius: Radius.xl,
    backgroundColor: Colors.primary,
    alignItems: "center",
    justifyContent: "center",
    marginBottom: 4,
  },
  appName: {
    fontSize: 22,
    fontWeight: "800",
    color: Colors.foreground,
  },
  appSub: {
    fontSize: 13,
    color: Colors.textSecondary,
  },
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
    paddingVertical: 8,
    borderRadius: Radius.sm,
    alignItems: "center",
  },
  toggleBtnActive: {
    backgroundColor: Colors.primary,
  },
  toggleText: {
    fontSize: 13,
    fontWeight: "500",
    color: Colors.mutedFg,
  },
  toggleTextActive: {
    color: "#fff",
  },
  ltrInput: {
    textAlign: "left",
    fontFamily: "Courier",
  },
  eyeBtn: {
    position: "absolute",
    right: 12,
    bottom: 10,
    padding: 4,
  },
  footer: {
    fontSize: 11,
    color: Colors.mutedFg,
    textAlign: "center",
  },
});
