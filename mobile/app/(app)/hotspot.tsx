import React, { useState, useCallback } from 'react';
import {
  View,
  Text,
  StyleSheet,
  FlatList,
  RefreshControl,
  TouchableOpacity,
  Alert,
  TextInput,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { useQueryClient } from '@tanstack/react-query';
import { Ionicons } from '@expo/vector-icons';
import {
  useRouterKey,
  useHotspotUsers,
  useHotspotAllUsers,
  useHotspotProfiles,
  useHotspotUserAction,
} from '@/hooks/useMikrotik';
import { TabBar } from '@/components/TabBar';
import { Badge } from '@/components/Badge';
import { Button } from '@/components/Button';
import { Input } from '@/components/Input';
import { BottomSheet } from '@/components/BottomSheet';
import { EmptyState } from '@/components/EmptyState';
import { LoadingSpinner } from '@/components/LoadingSpinner';
import { colors, spacing, typography, radius } from '@/lib/theme';

type HotspotTab = 'active' | 'all';

interface HotspotUser {
  '.id'?: string;
  user?: string;
  name?: string;
  address?: string;
  'mac-address'?: string;
  uptime?: string;
  'tx-rate'?: string;
  'rx-rate'?: string;
  disabled?: string | boolean;
  profile?: string;
  comment?: string;
}

export default function HotspotScreen() {
  const insets = useSafeAreaInsets();
  const qc = useQueryClient();
  const routerKey = useRouterKey();
  const [tab, setTab] = useState<HotspotTab>('active');
  const [search, setSearch] = useState('');
  const [refreshing, setRefreshing] = useState(false);
  const [showAdd, setShowAdd] = useState(false);
  const [newUser, setNewUser] = useState({ name: '', password: '', profile: '' });

  const activeQ = useHotspotUsers(routerKey);
  const allQ = useHotspotAllUsers(routerKey);
  const profilesQ = useHotspotProfiles(routerKey);
  const action = useHotspotUserAction(routerKey);

  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    await qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, 'hotspot'] });
    setRefreshing(false);
  }, [qc, routerKey]);

  const activeUsers = Array.isArray(activeQ.data) ? (activeQ.data as HotspotUser[]) : [];
  const allUsers = Array.isArray(allQ.data) ? (allQ.data as HotspotUser[]) : [];
  const profiles = Array.isArray(profilesQ.data)
    ? (profilesQ.data as { name: string }[]).map((p) => p.name)
    : [];

  const currentData = tab === 'active' ? activeUsers : allUsers;
  const filtered = search
    ? currentData.filter((u) =>
        (u.user || u.name || '').toLowerCase().includes(search.toLowerCase()) ||
        (u.address || '').includes(search) ||
        (u['mac-address'] || '').toLowerCase().includes(search.toLowerCase())
      )
    : currentData;

  const handleAction = (u: HotspotUser, act: string) => {
    const id = u['.id'];
    const name = u.user || u.name || '—';
    const labels: Record<string, string> = {
      kick: 'قطع الاتصال',
      remove: 'حذف',
      disable: 'تعطيل',
      enable: 'تفعيل',
    };
    Alert.alert(labels[act] ?? act, `هل تريد ${labels[act] ?? act} المستخدم ${name}؟`, [
      { text: 'إلغاء', style: 'cancel' },
      {
        text: 'تأكيد',
        style: act === 'remove' ? 'destructive' : 'default',
        onPress: () => action.mutate({ action: act, id }),
      },
    ]);
  };

  const handleAddUser = () => {
    if (!newUser.name.trim() || !newUser.password.trim()) {
      Alert.alert('خطأ', 'يرجى إدخال الاسم وكلمة المرور');
      return;
    }
    action.mutate(
      {
        action: 'add',
        data: {
          name: newUser.name.trim(),
          password: newUser.password.trim(),
          profile: newUser.profile || undefined,
        } as Record<string, string>,
      },
      {
        onSuccess: () => {
          setShowAdd(false);
          setNewUser({ name: '', password: '', profile: '' });
        },
      }
    );
  };

  const renderUser = ({ item: u }: { item: HotspotUser }) => {
    const isDisabled = u.disabled === 'true' || u.disabled === true;
    return (
      <View style={styles.userCard}>
        <View style={styles.userHeader}>
          <View style={styles.userInfo}>
            <Text style={styles.userName}>{u.user || u.name || '—'}</Text>
            <Text style={styles.userMeta}>{u.address ?? u['mac-address'] ?? ''}</Text>
          </View>
          {tab === 'active' && u.uptime && <Badge label={u.uptime} variant="info" />}
          {tab === 'all' && (
            <Badge label={isDisabled ? 'معطّل' : 'مفعّل'} variant={isDisabled ? 'error' : 'success'} />
          )}
        </View>
        {tab === 'active' && (u['tx-rate'] || u['rx-rate']) && (
          <Text style={styles.bandwidthText}>
            ↑ {u['tx-rate'] ?? '—'} / ↓ {u['rx-rate'] ?? '—'}
          </Text>
        )}
        <View style={styles.actions}>
          {tab === 'active' && (
            <TouchableOpacity style={styles.actionBtn} onPress={() => handleAction(u, 'kick')}>
              <Ionicons name="log-out-outline" size={16} color={colors.warning} />
              <Text style={[styles.actionText, { color: colors.warning }]}>قطع</Text>
            </TouchableOpacity>
          )}
          {tab === 'all' && (
            <TouchableOpacity
              style={styles.actionBtn}
              onPress={() => handleAction(u, isDisabled ? 'enable' : 'disable')}
            >
              <Ionicons
                name={isDisabled ? 'checkmark-circle-outline' : 'ban-outline'}
                size={16}
                color={isDisabled ? colors.success : colors.warning}
              />
              <Text style={[styles.actionText, { color: isDisabled ? colors.success : colors.warning }]}>
                {isDisabled ? 'تفعيل' : 'تعطيل'}
              </Text>
            </TouchableOpacity>
          )}
          <TouchableOpacity style={styles.actionBtn} onPress={() => handleAction(u, 'remove')}>
            <Ionicons name="trash-outline" size={16} color={colors.error} />
            <Text style={[styles.actionText, { color: colors.error }]}>حذف</Text>
          </TouchableOpacity>
        </View>
      </View>
    );
  };

  const isLoading = tab === 'active' ? activeQ.isLoading : allQ.isLoading;

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      {/* Header */}
      <View style={styles.header}>
        <Text style={styles.title}>هوت سبوت</Text>
        <TouchableOpacity style={styles.addBtn} onPress={() => setShowAdd(true)}>
          <Ionicons name="add" size={22} color={colors.primary} />
        </TouchableOpacity>
      </View>

      {/* Tabs */}
      <View style={styles.tabsWrap}>
        <TabBar
          tabs={[
            { key: 'active', label: 'النشطون', badge: activeUsers.length },
            { key: 'all', label: 'الكل', badge: allUsers.length },
          ]}
          activeTab={tab}
          onTabChange={(k) => setTab(k as HotspotTab)}
        />
      </View>

      {/* Search */}
      <View style={styles.searchWrap}>
        <View style={styles.searchRow}>
          <Ionicons name="search" size={18} color={colors.textMuted} />
          <TextInput
            style={styles.searchInput}
            value={search}
            onChangeText={setSearch}
            placeholder="بحث..."
            placeholderTextColor={colors.textMuted}
          />
          {search.length > 0 && (
            <TouchableOpacity onPress={() => setSearch('')}>
              <Ionicons name="close-circle" size={18} color={colors.textMuted} />
            </TouchableOpacity>
          )}
        </View>
      </View>

      {isLoading ? (
        <LoadingSpinner message="جاري التحميل..." />
      ) : (
        <FlatList
          data={filtered}
          keyExtractor={(item, i) => item['.id'] ?? `${i}`}
          renderItem={renderUser}
          contentContainerStyle={styles.list}
          refreshControl={
            <RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={colors.primary} />
          }
          ListEmptyComponent={
            <EmptyState
              title="لا يوجد مستخدمون"
              description={routerKey === 'none' ? 'اتصل براوتر أولاً' : 'لم يتم العثور على مستخدمين'}
              icon={<Ionicons name="wifi-outline" size={40} color={colors.textMuted} />}
            />
          }
          showsVerticalScrollIndicator={false}
        />
      )}

      {/* Add User Sheet */}
      <BottomSheet visible={showAdd} onClose={() => setShowAdd(false)} title="إضافة مستخدم">
        <View style={styles.formGap}>
          <Input
            label="اسم المستخدم"
            value={newUser.name}
            onChangeText={(v) => setNewUser((p) => ({ ...p, name: v }))}
            placeholder="username"
            autoCapitalize="none"
          />
          <Input
            label="كلمة المرور"
            value={newUser.password}
            onChangeText={(v) => setNewUser((p) => ({ ...p, password: v }))}
            placeholder="password"
            secureTextEntry
          />
          {profiles.length > 0 && (
            <View>
              <Text style={styles.profileLabel}>الباقة</Text>
              <View style={styles.profilesRow}>
                {profiles.map((p) => (
                  <TouchableOpacity
                    key={p}
                    style={[styles.profileChip, newUser.profile === p && styles.profileChipActive]}
                    onPress={() => setNewUser((prev) => ({ ...prev, profile: p }))}
                  >
                    <Text
                      style={[styles.profileChipText, newUser.profile === p && styles.profileChipTextActive]}
                    >
                      {p}
                    </Text>
                  </TouchableOpacity>
                ))}
              </View>
            </View>
          )}
          <Button
            label="إضافة"
            onPress={handleAddUser}
            loading={action.isPending}
          />
        </View>
      </BottomSheet>
    </View>
  );
}

const styles = StyleSheet.create({
  root: { flex: 1, backgroundColor: colors.background },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingHorizontal: spacing.lg,
    paddingVertical: spacing.md,
  },
  title: { color: colors.text, fontSize: typography.fontSizeXl, fontWeight: typography.fontWeightBold },
  addBtn: {
    width: 40, height: 40, borderRadius: 20,
    backgroundColor: colors.surface,
    borderWidth: 1, borderColor: colors.border,
    alignItems: 'center', justifyContent: 'center',
  },
  tabsWrap: { paddingHorizontal: spacing.lg, marginBottom: spacing.sm },
  searchWrap: { paddingHorizontal: spacing.lg, marginBottom: spacing.sm },
  searchRow: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: colors.surface2,
    borderRadius: radius.md,
    borderWidth: 1,
    borderColor: colors.border,
    paddingHorizontal: spacing.md,
    height: 44,
    gap: spacing.sm,
  },
  searchInput: { flex: 1, color: colors.text, fontSize: typography.fontSizeSm },
  list: { padding: spacing.lg, gap: spacing.sm, paddingBottom: spacing.xxxl },
  userCard: {
    backgroundColor: colors.surface,
    borderRadius: radius.lg,
    borderWidth: 1,
    borderColor: colors.border,
    padding: spacing.md,
    gap: spacing.sm,
  },
  userHeader: { flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' },
  userInfo: { flex: 1, gap: 2 },
  userName: { color: colors.text, fontSize: typography.fontSizeSm, fontWeight: typography.fontWeightSemiBold },
  userMeta: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  bandwidthText: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  actions: { flexDirection: 'row', gap: spacing.md },
  actionBtn: { flexDirection: 'row', alignItems: 'center', gap: 4 },
  actionText: { fontSize: typography.fontSizeXs, fontWeight: typography.fontWeightMedium },
  formGap: { gap: spacing.md },
  profileLabel: { color: colors.textSecondary, fontSize: typography.fontSizeSm, marginBottom: spacing.xs },
  profilesRow: { flexDirection: 'row', flexWrap: 'wrap', gap: spacing.sm },
  profileChip: {
    paddingVertical: spacing.xs,
    paddingHorizontal: spacing.sm,
    borderRadius: radius.full,
    backgroundColor: colors.surface2,
    borderWidth: 1,
    borderColor: colors.border,
  },
  profileChipActive: { backgroundColor: colors.primary, borderColor: colors.primary },
  profileChipText: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  profileChipTextActive: { color: colors.text, fontWeight: typography.fontWeightSemiBold },
});
