import React, { useState, useEffect, useCallback } from 'react';
import {
  View,
  Text,
  StyleSheet,
  FlatList,
  RefreshControl,
  TouchableOpacity,
  Alert,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import { useAuth } from '@/contexts/AuthContext';
import { supabase } from '@/lib/supabase';
import { saveMikrotikConfig, getMikrotikConfig } from '@/lib/mikrotikConfig';
import { Input } from '@/components/Input';
import { Button } from '@/components/Button';
import { Badge } from '@/components/Badge';
import { BottomSheet } from '@/components/BottomSheet';
import { EmptyState } from '@/components/EmptyState';
import { LoadingSpinner } from '@/components/LoadingSpinner';
import { colors, spacing, typography, radius } from '@/lib/theme';

interface Router {
  id: string;
  label: string;
  host: string;
  port: string;
  username: string;
  password: string;
  protocol: string;
  mode: string;
  router_os_version: string | null;
  is_online: boolean | null;
}

interface RouterForm {
  label: string;
  host: string;
  port: string;
  username: string;
  password: string;
  protocol: string;
  mode: string;
}

export default function RoutersScreen() {
  const insets = useSafeAreaInsets();
  const { user } = useAuth();
  const [routers, setRouters] = useState<Router[]>([]);
  const [loading, setLoading] = useState(true);
  const [refreshing, setRefreshing] = useState(false);
  const [showAdd, setShowAdd] = useState(false);
  const [connectedHost, setConnectedHost] = useState<string | null>(null);
  const [form, setForm] = useState<RouterForm>({
    label: '',
    host: '',
    port: '80',
    username: 'admin',
    password: '',
    protocol: 'http',
    mode: 'rest',
  });
  const [saving, setSaving] = useState(false);

  const fetchRouters = useCallback(async () => {
    if (!user) return;
    const { data } = await supabase
      .from('routers')
      .select('*')
      .eq('user_id', user.id)
      .order('created_at', { ascending: false });
    setRouters((data as Router[]) || []);
    setLoading(false);
  }, [user]);

  const loadConnected = useCallback(async () => {
    const cfg = await getMikrotikConfig();
    setConnectedHost(cfg?.host ?? null);
  }, []);

  useEffect(() => {
    fetchRouters();
    loadConnected();
  }, [fetchRouters, loadConnected]);

  const onRefresh = async () => {
    setRefreshing(true);
    await fetchRouters();
    setRefreshing(false);
  };

  const handleConnect = async (router: Router) => {
    await saveMikrotikConfig({
      host: router.host,
      user: router.username,
      pass: router.password,
      port: router.port,
      protocol: router.protocol as 'https' | 'http' | 'api-ssl' | 'api-plain',
      mode: router.mode as 'rest' | 'api',
      label: router.label,
    });
    setConnectedHost(router.host);
    Alert.alert('متصل', `تم الاتصال بـ ${router.label}`);
  };

  const handleDelete = (router: Router) => {
    Alert.alert('حذف الراوتر', `هل تريد حذف ${router.label}؟`, [
      { text: 'إلغاء', style: 'cancel' },
      {
        text: 'حذف',
        style: 'destructive',
        onPress: async () => {
          await supabase.from('routers').delete().eq('id', router.id);
          fetchRouters();
        },
      },
    ]);
  };

  const handleAdd = async () => {
    if (!form.host.trim() || !form.label.trim()) {
      Alert.alert('خطأ', 'العنوان والاسم مطلوبان');
      return;
    }
    setSaving(true);
    try {
      await supabase.from('routers').insert({
        user_id: user?.id,
        label: form.label.trim(),
        host: form.host.trim(),
        port: form.port,
        username: form.username,
        password: form.password,
        protocol: form.protocol,
        mode: form.mode,
      });
      setShowAdd(false);
      setForm({ label: '', host: '', port: '80', username: 'admin', password: '', protocol: 'http', mode: 'rest' });
      fetchRouters();
    } catch (err) {
      Alert.alert('خطأ', err instanceof Error ? err.message : 'فشل الحفظ');
    } finally {
      setSaving(false);
    }
  };

  const renderRouter = ({ item: r }: { item: Router }) => {
    const isConnected = connectedHost === r.host;
    return (
      <View style={[styles.card, isConnected && styles.connectedCard]}>
        <View style={styles.cardHeader}>
          <View style={styles.cardInfo}>
            <Text style={styles.label}>{r.label}</Text>
            <Text style={styles.host}>{r.host}:{r.port}</Text>
            {r.router_os_version && <Text style={styles.version}>ROS {r.router_os_version}</Text>}
          </View>
          <View style={styles.badges}>
            {isConnected && <Badge label="متصل" variant="success" />}
            {r.is_online !== null && (
              <Badge label={r.is_online ? 'اونلاين' : 'أوفلاين'} variant={r.is_online ? 'success' : 'error'} />
            )}
          </View>
        </View>
        <View style={styles.actions}>
          {!isConnected && (
            <TouchableOpacity style={styles.actionBtn} onPress={() => handleConnect(r)}>
              <Ionicons name="link-outline" size={16} color={colors.primary} />
              <Text style={[styles.actionText, { color: colors.primary }]}>اتصال</Text>
            </TouchableOpacity>
          )}
          <TouchableOpacity style={styles.actionBtn} onPress={() => handleDelete(r)}>
            <Ionicons name="trash-outline" size={16} color={colors.error} />
            <Text style={[styles.actionText, { color: colors.error }]}>حذف</Text>
          </TouchableOpacity>
        </View>
      </View>
    );
  };

  if (loading) return <LoadingSpinner fullScreen />;

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <View style={styles.header}>
        <TouchableOpacity onPress={() => {}} style={styles.backBtn}>
          <Ionicons name="arrow-back" size={22} color={colors.text} />
        </TouchableOpacity>
        <Text style={styles.title}>الراوترات</Text>
        <TouchableOpacity style={styles.addBtn} onPress={() => setShowAdd(true)}>
          <Ionicons name="add" size={22} color={colors.primary} />
        </TouchableOpacity>
      </View>

      <FlatList
        data={routers}
        keyExtractor={(r) => r.id}
        renderItem={renderRouter}
        contentContainerStyle={styles.list}
        refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={colors.primary} />}
        ListEmptyComponent={
          <EmptyState
            title="لا توجد راوترات"
            description="أضف راوتر للبدء"
            icon={<Ionicons name="hardware-chip-outline" size={40} color={colors.textMuted} />}
          />
        }
        showsVerticalScrollIndicator={false}
      />

      <BottomSheet visible={showAdd} onClose={() => setShowAdd(false)} title="إضافة راوتر" snapHeight="tall">
        <View style={styles.formGap}>
          <Input label="الاسم" value={form.label} onChangeText={(v) => setForm((p) => ({ ...p, label: v }))} placeholder="راوتر المنزل" />
          <Input label="العنوان (IP/Host)" value={form.host} onChangeText={(v) => setForm((p) => ({ ...p, host: v }))} placeholder="192.168.1.1" autoCapitalize="none" keyboardType="url" />
          <Input label="المنفذ" value={form.port} onChangeText={(v) => setForm((p) => ({ ...p, port: v }))} keyboardType="numeric" />
          <Input label="المستخدم" value={form.username} onChangeText={(v) => setForm((p) => ({ ...p, username: v }))} autoCapitalize="none" />
          <Input label="كلمة المرور" value={form.password} onChangeText={(v) => setForm((p) => ({ ...p, password: v }))} secureTextEntry />
          <Button label="حفظ" onPress={handleAdd} loading={saving} />
        </View>
      </BottomSheet>
    </View>
  );
}

const styles = StyleSheet.create({
  root: { flex: 1, backgroundColor: colors.background },
  header: {
    flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between',
    paddingHorizontal: spacing.lg, paddingVertical: spacing.md,
  },
  backBtn: { padding: 4 },
  title: { color: colors.text, fontSize: typography.fontSizeXl, fontWeight: typography.fontWeightBold },
  addBtn: {
    width: 40, height: 40, borderRadius: 20,
    backgroundColor: colors.surface, borderWidth: 1, borderColor: colors.border,
    alignItems: 'center', justifyContent: 'center',
  },
  list: { padding: spacing.lg, gap: spacing.sm, paddingBottom: spacing.xxxl },
  card: {
    backgroundColor: colors.surface, borderRadius: radius.lg,
    borderWidth: 1, borderColor: colors.border, padding: spacing.md, gap: spacing.sm,
  },
  connectedCard: { borderColor: colors.primary },
  cardHeader: { flexDirection: 'row', alignItems: 'flex-start', justifyContent: 'space-between' },
  cardInfo: { flex: 1, gap: 2 },
  label: { color: colors.text, fontSize: typography.fontSizeMd, fontWeight: typography.fontWeightSemiBold },
  host: { color: colors.textMuted, fontSize: typography.fontSizeSm },
  version: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  badges: { flexDirection: 'row', gap: spacing.xs },
  actions: { flexDirection: 'row', gap: spacing.md },
  actionBtn: { flexDirection: 'row', alignItems: 'center', gap: 4 },
  actionText: { fontSize: typography.fontSizeXs, fontWeight: typography.fontWeightMedium },
  formGap: { gap: spacing.md },
});
