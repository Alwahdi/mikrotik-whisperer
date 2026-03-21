import { useState } from 'react';
import { ActivityIndicator, Alert, KeyboardAvoidingView, Platform, SafeAreaView, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';
import { router } from 'expo-router';

import { useAuth } from '@/providers/AuthProvider';
import Colors from '@/constants/Colors';

export default function SignInScreen() {
  const { signIn } = useAuth();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSubmit = async () => {
    if (!email || !password) {
      Alert.alert('بيانات مطلوبة', 'يرجى إدخال البريد الإلكتروني وكلمة المرور');
      return;
    }
    setLoading(true);
    try {
      await signIn(email.trim(), password);
      router.replace('/');
    } catch {
      // signIn already shows the alert
    } finally {
      setLoading(false);
    }
  };

  return (
    <SafeAreaView style={styles.safe}>
      <KeyboardAvoidingView
        style={styles.container}
        behavior={Platform.OS === 'ios' ? 'padding' : undefined}
      >
        <View style={styles.header}>
          <Text style={styles.title}>تسجيل الدخول</Text>
          <Text style={styles.subtitle}>ادخل على حسابك للوصول لكل مزايا MikroTik Whisperer</Text>
        </View>

        <View style={styles.form}>
          <Text style={styles.label}>البريد الإلكتروني</Text>
          <TextInput
            value={email}
            onChangeText={setEmail}
            placeholder="name@example.com"
            keyboardType="email-address"
            autoCapitalize="none"
            style={styles.input}
            placeholderTextColor="#94a3b8"
          />

          <Text style={styles.label}>كلمة المرور</Text>
          <TextInput
            value={password}
            onChangeText={setPassword}
            placeholder="••••••••"
            secureTextEntry
            style={styles.input}
            placeholderTextColor="#94a3b8"
          />

          <TouchableOpacity style={styles.button} onPress={handleSubmit} disabled={loading}>
            {loading ? <ActivityIndicator color="#fff" /> : <Text style={styles.buttonText}>دخول</Text>}
          </TouchableOpacity>
        </View>
      </KeyboardAvoidingView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.light.background },
  container: {
    flex: 1,
    paddingHorizontal: 20,
    paddingTop: 40,
    gap: 24,
  },
  header: { gap: 8 },
  title: { fontSize: 28, fontWeight: '800', color: Colors.light.text },
  subtitle: { color: '#64748b', lineHeight: 20 },
  form: { gap: 12 },
  label: { fontWeight: '600', color: Colors.light.text },
  input: {
    height: 48,
    borderRadius: 12,
    borderWidth: 1,
    borderColor: '#e2e8f0',
    paddingHorizontal: 14,
    backgroundColor: '#fff',
    color: Colors.light.text,
  },
  button: {
    marginTop: 8,
    backgroundColor: Colors.light.primary,
    height: 52,
    borderRadius: 14,
    alignItems: 'center',
    justifyContent: 'center',
    shadowColor: '#0ea5e9',
    shadowOpacity: 0.2,
    shadowRadius: 8,
    shadowOffset: { width: 0, height: 4 },
  },
  buttonText: { color: '#fff', fontWeight: '700', fontSize: 16 },
});
