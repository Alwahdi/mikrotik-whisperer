import React, { useState, useEffect, useCallback } from 'react';
import {
  View,
  Text,
  StyleSheet,
  FlatList,
  TouchableOpacity,
  Alert,
  RefreshControl,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import { useAuth } from '@/contexts/AuthContext';
import { supabase } from '@/lib/supabase';
import { invokeMikrotik } from '@/lib/mikrotikInvoke';
import { getMikrotikConfig } from '@/lib/mikrotikConfig';
import { Badge } from '@/components/Badge';
import { Button } from '@/components/Button';
import { BottomSheet } from '@/components/BottomSheet';
import { EmptyState } from '@/components/EmptyState';
import { LoadingSpinner } from '@/components/LoadingSpinner';
import { colors, spacing, typography, radius } from '@/lib/theme';

type BackupType = 'full' | 'hotspot' | 'usermanager';

interface BackupRecord {
  id: string;
  router_label: string;
  backup_type: string;
  status: string;
  file_path: string | null;
  created_at: string;
  metadata: Record<string, unknown> | null;
}

export default function BackupsScreen() {
  const insets = useSafeAreaInsets();
  const { user } = useAuth();
  const [backups, setBackups] = useState<BackupRecord[]>([]);
  const [loading, setLoading] = useState(true);
  const [refreshing, setRefreshing] = useState(false);
  const [showCreate, setShowCreate] = useState(false);
  const [backupType, setBackupType] = useState<BackupType>('full');
  const [creating, setCreating] = useState(false);

  const fetchBackups = useCallback(async () => {
    if (!user) return;
    const { data } = await supabase
      .from('backups')
      .select('*')
      .eq('user_id', user.id)
      .order('created_at', { ascending: false });
    setBackups((data as BackupRecord[]) || []);
    setLoading(false);
  }, [user]);

  useEffect(() => { fetchBackups(); }, [fetchBackups]);

  const onRefresh = async () => {
    setRefreshing(true);
    await fetchBackups();
    setRefreshing(false);
  };

  const handleCreate = async () => {
    const config = await getMikrotikConfig();
    if (!config) {
      Alert.alert('خطأ', 'يرجى الاتصال براوتر أولاً');
      return;
    }
    setCreating(true);
    try {
      const { data: backupRow } = await supabase
        .from('backups')
        .insert({
          user_id: user?.id,
          router_id: null,
          router_label: config.label || config.host,
          backup_type: backupType,
          status: 'in_progress',
        })
        .select()
        .single();

      const endpoint =
        backupType === 'hotspot'
          ? '/ip/hotspot/user/print'
          : backupType === 'usermanager'
          ? '/user-manager/user/print'
          : '/system/backup/save';

      await invokeMikrotik({
        endpoint,
        host: config.host,
        user: config.user,
        pass: config.pass,
        port: config.port,
        protocol: config.protocol,
        mode: config.mode,
        timeoutMs: 30000,
      });

      if (backupRow) {
        await supabase
          .from('backups')
          .update({ status: 'completed' })
          .eq('id', (backupRow as BackupRecord).id);
      }

      Alert.alert('تم', 'تم إنشاء النسخة الاحتياطية بنجاح');
      setShowCreate(false);
      fetchBackups();
    } catch (err) {
      Alert.alert('خطأ', err instanceof Error ? err.message : 'فشل إنشاء النسخة الاحتياطية');
    } finally {
      setCreating(false);
    }
  };

  const handleDelete = (backup: BackupRecord) => {
    Alert.alert('حذف النسخة', 'هل تريد حذف هذه النسخة الاحتياطية؟', [
      { text: 'إلغاء', style: 'cancel' },
      {
        text: 'حذف',
        style: 'destructive',
        onPress: async () => {
          await supabase.from('backups').delete().eq('id', backup.id);
          fetchBackups();
        },
      },
    ]);
  };

  const statusVariant = (s: string): 'success' | 'warning' | 'error' | 'muted' =>
    s === 'completed' ? 'success' : s === 'in_progress' ? 'warning' : s === 'failed' ? 'error' : 'muted';

  const backupTypeLabels: Record<string, string> = {
    full: 'كامل',
    hotspot: 'هوت سبوت',
    usermanager: 'مدير المستخدمين',
  };

  if (loading) return <LoadingSpinner fullScreen />;

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <View style={styles.header}>
        <Text style={styles.title}>النسخ الاحتياطي</Text>
        <Button
          label="نسخة جديدة"
          size="sm"
          onPress={() => setShowCreate(true)}
          icon={<Ionicons name="add" size={16} color={colors.text} />}
        />
      </View>

      <FlatList
        data={backups}
        keyExtractor={(b) => b.id}
        renderItem={({ item: b }) => (
          <View style={styles.card}>
            <View style={styles.cardHeader}>
              <View style={styles.cardInfo}>
                <Text style={styles.cardTitle}>{b.router_label}</Text>
                <Text style={styles.cardMeta}>{new Date(b.created_at).toLocaleString('ar')}</Text>
              </View>
              <View style={styles.badges}>
                <Badge label={backupTypeLabels[b.backup_type] ?? b.backup_type} variant="info" />
                <Badge label={b.status === 'completed' ? 'مكتمل' : b.status} variant={statusVariant(b.status)} />
              </View>
            </View>
            <View style={styles.actions}>
              <TouchableOpacity style={styles.actionBtn} onPress={() => handleDelete(b)}>
                <Ionicons name="trash-outline" size={15} color={colors.error} />
                <Text style={[styles.actionText, { color: colors.error }]}>حذف</Text>
              </TouchableOpacity>
            </View>
          </View>
        )}
        contentContainerStyle={styles.list}
        refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={colors.primary} />}
        ListEmptyComponent={
          <EmptyState
            title="لا توجد نسخ احتياطية"
            icon={<Ionicons name="cloud-upload-outline" size={40} color={colors.textMuted} />}
          />
        }
        showsVerticalScrollIndicator={false}
      />

      <BottomSheet visible={showCreate} onClose={() => setShowCreate(false)} title="إنشاء نسخة احتياطية">
        <View style={styles.formGap}>
          <Text style={styles.sectionLabel}>نوع النسخة</Text>
          {(['full', 'hotspot', 'usermanager'] as BackupType[]).map((t) => (
            <TouchableOpacity
              key={t}
              style={[styles.typeBtn, backupType === t && styles.typeBtnActive]}
              onPress={() => setBackupType(t)}
            >
              <Text style={[styles.typeText, backupType === t && styles.typeTextActive]}>
                {backupTypeLabels[t]}
              </Text>
            </TouchableOpacity>
          ))}
          <Button label="إنشاء" onPress={handleCreate} loading={creating} />
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
  title: { color: colors.text, fontSize: typography.fontSizeXl, fontWeight: typography.fontWeightBold },
  list: { padding: spacing.lg, gap: spacing.sm, paddingBottom: spacing.xxxl },
  card: {
    backgroundColor: colors.surface, borderRadius: radius.lg,
    borderWidth: 1, borderColor: colors.border, padding: spacing.md, gap: spacing.sm,
  },
  cardHeader: { flexDirection: 'row', alignItems: 'flex-start', justifyContent: 'space-between' },
  cardInfo: { flex: 1, gap: 2 },
  cardTitle: { color: colors.text, fontSize: typography.fontSizeSm, fontWeight: typography.fontWeightSemiBold },
  cardMeta: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  badges: { flexDirection: 'row', gap: spacing.xs },
  actions: { flexDirection: 'row', gap: spacing.md },
  actionBtn: { flexDirection: 'row', alignItems: 'center', gap: 4 },
  actionText: { fontSize: typography.fontSizeXs, fontWeight: typography.fontWeightMedium },
  formGap: { gap: spacing.sm },
  sectionLabel: { color: colors.textSecondary, fontSize: typography.fontSizeSm, marginBottom: spacing.xs },
  typeBtn: {
    padding: spacing.md, borderRadius: radius.md,
    backgroundColor: colors.surface2, borderWidth: 1, borderColor: colors.border,
  },
  typeBtnActive: { borderColor: colors.primary, backgroundColor: `${colors.primary}22` },
  typeText: { color: colors.textMuted, fontSize: typography.fontSizeSm },
  typeTextActive: { color: colors.primary, fontWeight: typography.fontWeightSemiBold },
});
