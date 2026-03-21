import React, { useState, useEffect, useCallback } from 'react';
import {
  View,
  Text,
  StyleSheet,
  FlatList,
  TouchableOpacity,
  Alert,
  RefreshControl,
  TextInput,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import { useAuth } from '@/contexts/AuthContext';
import { supabase } from '@/lib/supabase';
import { Badge } from '@/components/Badge';
import { BottomSheet } from '@/components/BottomSheet';
import { LoadingSpinner } from '@/components/LoadingSpinner';
import { EmptyState } from '@/components/EmptyState';
import { Button } from '@/components/Button';
import { Input } from '@/components/Input';
import { colors, spacing, typography, radius } from '@/lib/theme';

interface UserAccessRecord {
  user_id: string;
  status: string;
  starts_at: string | null;
  expires_at: string | null;
  notes: string | null;
  profiles?: { email: string; full_name: string | null };
}

type AccessStatus = 'pending' | 'active' | 'suspended' | 'expired';

export default function AdminScreen() {
  const insets = useSafeAreaInsets();
  const { isAdmin, user } = useAuth();
  const [users, setUsers] = useState<UserAccessRecord[]>([]);
  const [loading, setLoading] = useState(true);
  const [refreshing, setRefreshing] = useState(false);
  const [selectedUser, setSelectedUser] = useState<UserAccessRecord | null>(null);
  const [showEdit, setShowEdit] = useState(false);
  const [editForm, setEditForm] = useState({ status: 'active' as AccessStatus, notes: '' });
  const [saving, setSaving] = useState(false);

  const fetchUsers = useCallback(async () => {
    const { data } = await supabase
      .from('user_access')
      .select('*, profiles(email, full_name)')
      .order('starts_at', { ascending: false });
    setUsers((data as UserAccessRecord[]) || []);
    setLoading(false);
  }, []);

  useEffect(() => { fetchUsers(); }, [fetchUsers]);

  const onRefresh = async () => {
    setRefreshing(true);
    await fetchUsers();
    setRefreshing(false);
  };

  const openEdit = (u: UserAccessRecord) => {
    setSelectedUser(u);
    setEditForm({ status: u.status as AccessStatus, notes: u.notes || '' });
    setShowEdit(true);
  };

  const handleSave = async () => {
    if (!selectedUser) return;
    setSaving(true);
    try {
      await supabase
        .from('user_access')
        .update({ status: editForm.status, notes: editForm.notes })
        .eq('user_id', selectedUser.user_id);
      setShowEdit(false);
      fetchUsers();
    } catch (err) {
      Alert.alert('خطأ', err instanceof Error ? err.message : 'فشل الحفظ');
    } finally {
      setSaving(false);
    }
  };

  const statusVariant = (s: string): 'success' | 'warning' | 'error' | 'muted' =>
    s === 'active' ? 'success' : s === 'pending' ? 'warning' : s === 'suspended' ? 'error' : 'muted';

  const statusLabel = (s: string) =>
    ({ active: 'مفعّل', pending: 'انتظار', suspended: 'موقوف', expired: 'منتهي' })[s] ?? s;

  if (!isAdmin) {
    return (
      <View style={[styles.root, { paddingTop: insets.top }]}>
        <EmptyState
          title="غير مصرح"
          description="هذه الصفحة للمشرفين فقط"
          icon={<Ionicons name="lock-closed-outline" size={40} color={colors.textMuted} />}
        />
      </View>
    );
  }

  if (loading) return <LoadingSpinner fullScreen />;

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <View style={styles.header}>
        <Text style={styles.title}>لوحة الإدارة</Text>
      </View>

      <FlatList
        data={users}
        keyExtractor={(u) => u.user_id}
        renderItem={({ item: u }) => {
          const email = u.profiles?.email ?? u.user_id.slice(0, 8);
          const name = u.profiles?.full_name;
          return (
            <View style={styles.card}>
              <View style={styles.cardHeader}>
                <View style={styles.cardInfo}>
                  <Text style={styles.cardName}>{name || email}</Text>
                  {name && <Text style={styles.cardEmail}>{email}</Text>}
                  {u.expires_at && (
                    <Text style={styles.cardMeta}>
                      ينتهي: {new Date(u.expires_at).toLocaleDateString('ar')}
                    </Text>
                  )}
                </View>
                <Badge label={statusLabel(u.status)} variant={statusVariant(u.status)} size="md" />
              </View>
              {u.notes && <Text style={styles.notes}>{u.notes}</Text>}
              <TouchableOpacity style={styles.editBtn} onPress={() => openEdit(u)}>
                <Ionicons name="create-outline" size={15} color={colors.primary} />
                <Text style={styles.editText}>تعديل الصلاحية</Text>
              </TouchableOpacity>
            </View>
          );
        }}
        contentContainerStyle={styles.list}
        refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={colors.primary} />}
        ListEmptyComponent={
          <EmptyState
            title="لا يوجد مستخدمون"
            icon={<Ionicons name="people-outline" size={40} color={colors.textMuted} />}
          />
        }
        showsVerticalScrollIndicator={false}
      />

      <BottomSheet visible={showEdit} onClose={() => setShowEdit(false)} title="تعديل الصلاحية">
        <View style={styles.formGap}>
          <Text style={styles.formLabel}>الحالة</Text>
          {(['active', 'pending', 'suspended', 'expired'] as AccessStatus[]).map((s) => (
            <TouchableOpacity
              key={s}
              style={[styles.statusBtn, editForm.status === s && styles.statusBtnActive]}
              onPress={() => setEditForm((p) => ({ ...p, status: s }))}
            >
              <Text style={[styles.statusText, editForm.status === s && styles.statusTextActive]}>
                {statusLabel(s)}
              </Text>
            </TouchableOpacity>
          ))}
          <Input
            label="ملاحظات"
            value={editForm.notes}
            onChangeText={(v) => setEditForm((p) => ({ ...p, notes: v }))}
            placeholder="اختياري"
            multiline
            numberOfLines={3}
          />
          <Button label="حفظ" onPress={handleSave} loading={saving} />
        </View>
      </BottomSheet>
    </View>
  );
}

const styles = StyleSheet.create({
  root: { flex: 1, backgroundColor: colors.background },
  header: {
    paddingHorizontal: spacing.lg, paddingVertical: spacing.md,
  },
  title: { color: colors.text, fontSize: typography.fontSizeXl, fontWeight: typography.fontWeightBold },
  list: { padding: spacing.lg, gap: spacing.sm, paddingBottom: spacing.xxxl },
  card: {
    backgroundColor: colors.surface, borderRadius: radius.lg,
    borderWidth: 1, borderColor: colors.border, padding: spacing.md, gap: spacing.sm,
  },
  cardHeader: { flexDirection: 'row', alignItems: 'flex-start', justifyContent: 'space-between' },
  cardInfo: { flex: 1, gap: 2 },
  cardName: { color: colors.text, fontSize: typography.fontSizeMd, fontWeight: typography.fontWeightSemiBold },
  cardEmail: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  cardMeta: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  notes: { color: colors.textMuted, fontSize: typography.fontSizeXs, fontStyle: 'italic' },
  editBtn: { flexDirection: 'row', alignItems: 'center', gap: 4, alignSelf: 'flex-start' },
  editText: { color: colors.primary, fontSize: typography.fontSizeXs, fontWeight: typography.fontWeightMedium },
  formGap: { gap: spacing.sm },
  formLabel: { color: colors.textSecondary, fontSize: typography.fontSizeSm, marginBottom: spacing.xs },
  statusBtn: {
    padding: spacing.md, borderRadius: radius.md,
    backgroundColor: colors.surface2, borderWidth: 1, borderColor: colors.border,
  },
  statusBtnActive: { borderColor: colors.primary, backgroundColor: `${colors.primary}22` },
  statusText: { color: colors.textMuted, fontSize: typography.fontSizeSm },
  statusTextActive: { color: colors.primary, fontWeight: typography.fontWeightSemiBold },
});
