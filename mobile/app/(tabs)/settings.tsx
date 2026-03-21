import { Ionicons } from '@expo/vector-icons';
import { useEffect, useState } from 'react';
import { Alert, SafeAreaView, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';

import Colors from '@/constants/Colors';
import { useAuth } from '@/providers/AuthProvider';
import { useRouters } from '@/providers/RouterProvider';

export default function SettingsScreen() {
  const { user, signOut } = useAuth();
  const { webAppUrl, setWebAppUrl, refreshRouters } = useRouters();
  const [urlInput, setUrlInput] = useState(webAppUrl);

  useEffect(() => {
    setUrlInput(webAppUrl);
  }, [webAppUrl]);

  const handleSaveUrl = async () => {
    await setWebAppUrl(urlInput);
    Alert.alert('تم الحفظ', 'سيتم استخدام العنوان الجديد في تبويب الويب');
  };

  return (
    <SafeAreaView style={styles.safe}>
      <View style={styles.section}>
        <Text style={styles.title}>الحساب</Text>
        <View style={styles.card}>
          <Text style={styles.cardLabel}>البريد</Text>
          <Text style={styles.cardValue}>{user?.email}</Text>
        </View>
        <TouchableOpacity style={styles.dangerBtn} onPress={signOut}>
          <Ionicons name="log-out-outline" size={18} color="#fff" />
          <Text style={styles.dangerText}>تسجيل الخروج</Text>
        </TouchableOpacity>
      </View>

      <View style={styles.section}>
        <Text style={styles.title}>منصة الويب</Text>
        <Text style={styles.helper}>حدد رابط منصة الويب التي تود تحميلها داخل التطبيق</Text>
        <TextInput
          value={urlInput}
          onChangeText={setUrlInput}
          placeholder="https://example.com"
          style={styles.input}
          placeholderTextColor="#94a3b8"
          autoCapitalize="none"
        />
        <View style={styles.row}>
          <TouchableOpacity style={styles.secondaryBtn} onPress={() => refreshRouters()}>
            <Ionicons name="refresh" size={16} color={Colors.light.text} />
            <Text style={styles.secondaryText}>تحديث الراوترات</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.primaryBtn} onPress={handleSaveUrl}>
            <Ionicons name="save-outline" size={16} color="#fff" />
            <Text style={styles.primaryText}>حفظ الرابط</Text>
          </TouchableOpacity>
        </View>
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.light.surface, padding: 16, gap: 18 },
  section: { gap: 12 },
  title: { fontSize: 18, fontWeight: '800', color: Colors.light.text },
  helper: { color: '#475569' },
  card: {
    backgroundColor: '#fff',
    borderRadius: 14,
    padding: 14,
    borderWidth: 1,
    borderColor: '#e2e8f0',
    gap: 4,
  },
  cardLabel: { color: '#475569' },
  cardValue: { fontWeight: '800', color: Colors.light.text },
  dangerBtn: {
    marginTop: 4,
    backgroundColor: Colors.light.destructive,
    paddingVertical: 12,
    borderRadius: 12,
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
    gap: 8,
  },
  dangerText: { color: '#fff', fontWeight: '700' },
  input: {
    borderWidth: 1,
    borderColor: '#e2e8f0',
    borderRadius: 12,
    paddingHorizontal: 12,
    paddingVertical: 10,
    color: Colors.light.text,
    backgroundColor: '#fff',
  },
  row: { flexDirection: 'row', gap: 10 },
  secondaryBtn: {
    flex: 1,
    borderWidth: 1,
    borderColor: '#e2e8f0',
    borderRadius: 12,
    paddingVertical: 12,
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
    gap: 8,
    backgroundColor: '#fff',
  },
  secondaryText: { color: Colors.light.text, fontWeight: '700' },
  primaryBtn: {
    flex: 1,
    backgroundColor: Colors.light.primary,
    borderRadius: 12,
    paddingVertical: 12,
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
    gap: 8,
  },
  primaryText: { color: '#fff', fontWeight: '700' },
});
