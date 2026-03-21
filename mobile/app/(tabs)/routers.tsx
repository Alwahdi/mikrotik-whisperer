import { Ionicons } from '@expo/vector-icons';
import { useState } from 'react';
import {
  ActivityIndicator,
  Alert,
  FlatList,
  Modal,
  Pressable,
  SafeAreaView,
  StyleSheet,
  Text,
  TextInput,
  TouchableOpacity,
  View,
} from 'react-native';

import Colors from '@/constants/Colors';
import { invokeMikrotik } from '@/lib/mikrotik';
import { supabase } from '@/lib/supabase';
import { useAuth } from '@/providers/AuthProvider';
import { useRouters } from '@/providers/RouterProvider';

const protocols = [
  { label: 'HTTPS (REST)', value: 'https', mode: 'rest', port: '443' },
  { label: 'HTTP (REST)', value: 'http', mode: 'rest', port: '80' },
  { label: 'API SSL', value: 'api-ssl', mode: 'api', port: '8729' },
  { label: 'API Plain', value: 'api-plain', mode: 'api', port: '8728' },
];

export default function RoutersScreen() {
  const { user } = useAuth();
  const { routers, selectedRouter, loadingRouters, selectRouter, refreshRouters } = useRouters();
  const [open, setOpen] = useState(false);
  const [saving, setSaving] = useState(false);
  const [form, setForm] = useState({
    label: '',
    host: '',
    port: '443',
    username: 'admin',
    password: '',
    protocol: 'https',
    mode: 'rest',
  });

  const handleAdd = async () => {
    if (!user) return;
    if (!form.host || !form.password || !form.username) {
      Alert.alert('بيانات مطلوبة', 'أدخل العنوان واسم المستخدم وكلمة المرور');
      return;
    }
    setSaving(true);
    try {
      const probe = await invokeMikrotik({
        ...form,
        host: form.host.trim(),
        label: form.label || form.host,
      });
      const identity = Array.isArray(probe) ? probe[0]?.name : (probe as any)?.name;

      const { error, data } = await supabase.from('routers').insert({
        user_id: user.id,
        label: form.label || identity || 'MikroTik',
        host: form.host,
        port: form.port,
        username: form.username,
        password: form.password,
        protocol: form.protocol,
        mode: form.mode,
        last_connected_at: new Date().toISOString(),
      }).select().single();
      if (error) throw error;

      await refreshRouters();
      await selectRouter((data as any).id);
      setOpen(false);
      setForm({ label: '', host: '', port: form.port, username: 'admin', password: '', protocol: form.protocol, mode: form.mode });
    } catch (err: any) {
      Alert.alert('فشل الإضافة', err?.message || 'تعذر الاتصال بالراوتر');
    } finally {
      setSaving(false);
    }
  };

  const handleProtocolChange = (value: string) => {
    const selected = protocols.find((p) => p.value === value);
    if (selected) {
      setForm((prev) => ({ ...prev, protocol: selected.value, mode: selected.mode, port: selected.port }));
    }
  };

  return (
    <SafeAreaView style={styles.safe}>
      <View style={styles.header}>
        <View>
          <Text style={styles.title}>الراوترات</Text>
          <Text style={styles.subtitle}>إدارة الراوترات والاتصال السريع</Text>
        </View>
        <TouchableOpacity style={styles.addBtn} onPress={() => setOpen(true)}>
          <Ionicons name="add" size={20} color="#fff" />
          <Text style={styles.addText}>إضافة</Text>
        </TouchableOpacity>
      </View>

      <FlatList
        data={routers}
        refreshing={loadingRouters}
        onRefresh={refreshRouters}
        keyExtractor={(item) => item.id || item.host}
        ListEmptyComponent={
          <View style={styles.empty}>
            <Ionicons name="server-outline" size={40} color="#94a3b8" />
            <Text style={styles.emptyText}>لا يوجد راوترات بعد</Text>
            <Text style={styles.emptySub}>أضف راوتر جديد لبدء الإدارة</Text>
          </View>
        }
        renderItem={({ item }) => {
          const active = selectedRouter?.id === item.id;
          return (
            <Pressable style={[styles.card, active && styles.cardActive]} onPress={() => selectRouter(item.id || null)}>
              <View style={styles.cardHeader}>
                <Ionicons name="server-outline" size={20} color={active ? Colors.light.primaryForeground : Colors.light.primary} />
                <View style={{ flex: 1 }}>
                  <Text style={[styles.cardTitle, active && styles.cardTitleActive]}>{item.label || item.host}</Text>
                  <Text style={[styles.cardSub, active && styles.cardSubActive]}>{item.host}:{item.port} · {item.protocol}</Text>
                </View>
                {active ? (
                  <View style={styles.badge}>
                    <Text style={styles.badgeText}>نشط</Text>
                  </View>
                ) : null}
              </View>
              <View style={styles.cardFooter}>
                <Text style={styles.footerText}>المستخدم: {item.username}</Text>
                {item.router_os_version ? <Text style={styles.footerText}>الإصدارة {item.router_os_version}</Text> : null}
              </View>
            </Pressable>
          );
        }}
        contentContainerStyle={{ padding: 16, gap: 12 }}
      />

      <Modal visible={open} transparent animationType="slide">
        <View style={styles.modalBackdrop}>
          <View style={styles.modalCard}>
            <View style={styles.modalHeader}>
              <Text style={styles.modalTitle}>إضافة راوتر</Text>
              <TouchableOpacity onPress={() => setOpen(false)}>
                <Ionicons name="close" size={22} color="#0f172a" />
              </TouchableOpacity>
            </View>

            <View style={styles.form}>
              <Label text="اسم الراوتر" />
              <TextInput
                value={form.label}
                onChangeText={(val) => setForm((prev) => ({ ...prev, label: val }))}
                style={styles.input}
                placeholder="فرع الرياض"
                placeholderTextColor="#94a3b8"
              />

              <Label text="العنوان" />
              <TextInput
                value={form.host}
                onChangeText={(val) => setForm((prev) => ({ ...prev, host: val }))}
                style={styles.input}
                placeholder="192.168.88.1"
                placeholderTextColor="#94a3b8"
                autoCapitalize="none"
              />

              <Label text="المستخدم" />
              <TextInput
                value={form.username}
                onChangeText={(val) => setForm((prev) => ({ ...prev, username: val }))}
                style={styles.input}
                placeholder="admin"
                placeholderTextColor="#94a3b8"
              />

              <Label text="كلمة المرور" />
              <TextInput
                value={form.password}
                onChangeText={(val) => setForm((prev) => ({ ...prev, password: val }))}
                style={styles.input}
                placeholder="••••••••"
                placeholderTextColor="#94a3b8"
                secureTextEntry
              />

              <Label text="البروتوكول" />
              <View style={styles.segmentRow}>
                {protocols.map((p) => (
                  <TouchableOpacity
                    key={p.value}
                    onPress={() => handleProtocolChange(p.value)}
                    style={[styles.segment, form.protocol === p.value && styles.segmentActive]}
                  >
                    <Text style={[styles.segmentText, form.protocol === p.value && styles.segmentTextActive]}>
                      {p.label}
                    </Text>
                  </TouchableOpacity>
                ))}
              </View>
            </View>

            <TouchableOpacity style={styles.saveBtn} onPress={handleAdd} disabled={saving}>
              {saving ? <ActivityIndicator color="#fff" /> : <Text style={styles.saveText}>حفظ و اختبار</Text>}
            </TouchableOpacity>
          </View>
        </View>
      </Modal>
    </SafeAreaView>
  );
}

function Label({ text }: { text: string }) {
  return <Text style={styles.label}>{text}</Text>;
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.light.surface },
  header: {
    paddingHorizontal: 16,
    paddingVertical: 12,
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  title: { fontSize: 22, fontWeight: '800', color: Colors.light.text },
  subtitle: { color: '#64748b', marginTop: 4 },
  addBtn: {
    backgroundColor: Colors.light.primary,
    paddingHorizontal: 14,
    paddingVertical: 10,
    borderRadius: 12,
    flexDirection: 'row',
    alignItems: 'center',
    gap: 6,
    shadowColor: Colors.light.primary,
    shadowOpacity: 0.2,
    shadowRadius: 8,
    shadowOffset: { width: 0, height: 4 },
  },
  addText: { color: '#fff', fontWeight: '700' },
  card: {
    backgroundColor: '#fff',
    borderRadius: 14,
    padding: 14,
    borderWidth: 1,
    borderColor: '#e2e8f0',
    gap: 8,
  },
  cardActive: {
    backgroundColor: Colors.light.primary,
    borderColor: Colors.light.primary,
  },
  cardHeader: { flexDirection: 'row', alignItems: 'center', gap: 10 },
  cardTitle: { fontSize: 16, fontWeight: '800', color: Colors.light.text },
  cardTitleActive: { color: Colors.light.primaryForeground },
  cardSub: { color: '#475569' },
  cardSubActive: { color: Colors.light.primaryForeground },
  cardFooter: { flexDirection: 'row', justifyContent: 'space-between' },
  footerText: { color: '#475569', fontWeight: '600' },
  badge: {
    backgroundColor: Colors.light.primaryForeground,
    paddingHorizontal: 10,
    paddingVertical: 4,
    borderRadius: 999,
  },
  badgeText: { color: Colors.light.primary, fontWeight: '700' },
  empty: { alignItems: 'center', marginTop: 80, gap: 8 },
  emptyText: { fontWeight: '800', fontSize: 16, color: Colors.light.text },
  emptySub: { color: '#64748b' },
  modalBackdrop: {
    flex: 1,
    backgroundColor: 'rgba(0,0,0,0.3)',
    justifyContent: 'flex-end',
  },
  modalCard: {
    backgroundColor: '#fff',
    padding: 18,
    borderTopLeftRadius: 20,
    borderTopRightRadius: 20,
    gap: 14,
  },
  modalHeader: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  modalTitle: { fontSize: 18, fontWeight: '800', color: Colors.light.text },
  form: { gap: 10 },
  label: { fontWeight: '700', color: Colors.light.text },
  input: {
    borderWidth: 1,
    borderColor: '#e2e8f0',
    borderRadius: 12,
    paddingHorizontal: 12,
    paddingVertical: 10,
    color: Colors.light.text,
  },
  segmentRow: { flexDirection: 'row', flexWrap: 'wrap', gap: 8 },
  segment: {
    borderWidth: 1,
    borderColor: '#e2e8f0',
    borderRadius: 10,
    paddingHorizontal: 10,
    paddingVertical: 8,
  },
  segmentActive: {
    backgroundColor: Colors.light.primary,
    borderColor: Colors.light.primary,
  },
  segmentText: { color: '#475569', fontWeight: '600' },
  segmentTextActive: { color: Colors.light.primaryForeground },
  saveBtn: {
    backgroundColor: Colors.light.primary,
    paddingVertical: 14,
    borderRadius: 14,
    alignItems: 'center',
  },
  saveText: { color: '#fff', fontWeight: '800', fontSize: 16 },
});
