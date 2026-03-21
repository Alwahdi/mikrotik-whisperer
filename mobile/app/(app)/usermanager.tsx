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
  useUserManagerUsers,
  useUserManagerProfiles,
  useUserManagerSessions,
  useUserManagerAction,
  useUserManagerProfileAction,
} from '@/hooks/useMikrotik';
import { TabBar } from '@/components/TabBar';
import { Badge } from '@/components/Badge';
import { Button } from '@/components/Button';
import { Input } from '@/components/Input';
import { BottomSheet } from '@/components/BottomSheet';
import { EmptyState } from '@/components/EmptyState';
import { LoadingSpinner } from '@/components/LoadingSpinner';
import { colors, spacing, typography, radius } from '@/lib/theme';

type UMTab = 'users' | 'profiles' | 'sessions';

interface UMUser {
  '.id'?: string;
  username?: string;
  name?: string;
  group?: string;
  'actual-profile'?: string;
  disabled?: string | boolean;
}

interface UMProfile {
  '.id'?: string;
  name?: string;
  'name-for-users'?: string;
  validity?: string;
  price?: string;
  'rate-limit'?: string;
  'shared-users'?: string;
}

interface UMSession {
  '.id'?: string;
  user?: string;
  customer?: string;
  'from-time'?: string;
  'till-time'?: string;
  active?: string | boolean;
}

export default function UserManagerScreen() {
  const insets = useSafeAreaInsets();
  const qc = useQueryClient();
  const routerKey = useRouterKey();
  const [tab, setTab] = useState<UMTab>('users');
  const [search, setSearch] = useState('');
  const [refreshing, setRefreshing] = useState(false);
  const [showAddUser, setShowAddUser] = useState(false);
  const [showAddProfile, setShowAddProfile] = useState(false);
  const [showEditProfile, setShowEditProfile] = useState<UMProfile | null>(null);
  const [newUser, setNewUser] = useState({ username: '', password: '', group: '' });
  const [profileForm, setProfileForm] = useState({
    name: '',
    validity: '',
    price: '',
    'rate-limit': '',
    'shared-users': '',
  });

  const usersQ = useUserManagerUsers(routerKey, { enabled: tab === 'users' });
  const profilesQ = useUserManagerProfiles(routerKey, { enabled: tab === 'profiles' });
  const sessionsQ = useUserManagerSessions(routerKey, { enabled: tab === 'sessions' });
  const userAction = useUserManagerAction(routerKey);
  const profileAction = useUserManagerProfileAction(routerKey);

  const onRefresh = useCallback(async () => {
    setRefreshing(true);
    await qc.invalidateQueries({ queryKey: ['mikrotik', routerKey, 'usermanager'] });
    setRefreshing(false);
  }, [qc, routerKey]);

  const users = Array.isArray(usersQ.data) ? (usersQ.data as UMUser[]) : [];
  const profiles = Array.isArray(profilesQ.data) ? (profilesQ.data as UMProfile[]) : [];
  const sessions = Array.isArray(sessionsQ.data) ? (sessionsQ.data as UMSession[]) : [];

  const filteredUsers = search
    ? users.filter(
        (u) =>
          (u.username || '').toLowerCase().includes(search.toLowerCase()) ||
          (u.name || '').toLowerCase().includes(search.toLowerCase())
      )
    : users;

  const handleUserAction = (u: UMUser, act: string) => {
    Alert.alert(act === 'remove' ? 'حذف' : act, `تأكيد العملية للمستخدم: ${u.username}?`, [
      { text: 'إلغاء', style: 'cancel' },
      {
        text: 'تأكيد',
        style: act === 'remove' ? 'destructive' : 'default',
        onPress: () => userAction.mutate({ action: act, id: u['.id'] }),
      },
    ]);
  };

  const handleAddUser = () => {
    if (!newUser.username.trim() || !newUser.password.trim()) {
      Alert.alert('خطأ', 'يرجى إدخال الاسم وكلمة المرور');
      return;
    }
    userAction.mutate(
      {
        action: 'add',
        data: {
          username: newUser.username.trim(),
          password: newUser.password.trim(),
          group: newUser.group || undefined,
        } as Record<string, string>,
      },
      {
        onSuccess: () => {
          setShowAddUser(false);
          setNewUser({ username: '', password: '', group: '' });
        },
      }
    );
  };

  const handleSaveProfile = () => {
    if (!profileForm.name.trim()) {
      Alert.alert('خطأ', 'اسم الباقة مطلوب');
      return;
    }
    const data = Object.fromEntries(
      Object.entries(profileForm).filter(([, v]) => v.trim() !== '')
    ) as Record<string, string>;

    if (showEditProfile) {
      profileAction.mutate(
        { action: 'set', id: showEditProfile['.id'], data },
        { onSuccess: () => setShowEditProfile(null) }
      );
    } else {
      profileAction.mutate(
        { action: 'add', data },
        {
          onSuccess: () => {
            setShowAddProfile(false);
            setProfileForm({ name: '', validity: '', price: '', 'rate-limit': '', 'shared-users': '' });
          },
        }
      );
    }
  };

  const renderUser = ({ item: u }: { item: UMUser }) => {
    const isDisabled = u.disabled === 'true' || u.disabled === true;
    return (
      <View style={styles.card}>
        <View style={styles.cardHeader}>
          <View style={styles.cardInfo}>
            <Text style={styles.cardTitle}>{u.username || '—'}</Text>
            <Text style={styles.cardMeta}>{u['actual-profile'] || u.group || ''}</Text>
          </View>
          <Badge label={isDisabled ? 'معطّل' : 'مفعّل'} variant={isDisabled ? 'error' : 'success'} />
        </View>
        <View style={styles.actions}>
          <TouchableOpacity
            style={styles.actionBtn}
            onPress={() => handleUserAction(u, isDisabled ? 'enable' : 'disable')}
          >
            <Ionicons
              name={isDisabled ? 'checkmark-circle-outline' : 'ban-outline'}
              size={15}
              color={isDisabled ? colors.success : colors.warning}
            />
            <Text style={[styles.actionText, { color: isDisabled ? colors.success : colors.warning }]}>
              {isDisabled ? 'تفعيل' : 'تعطيل'}
            </Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.actionBtn} onPress={() => handleUserAction(u, 'remove')}>
            <Ionicons name="trash-outline" size={15} color={colors.error} />
            <Text style={[styles.actionText, { color: colors.error }]}>حذف</Text>
          </TouchableOpacity>
        </View>
      </View>
    );
  };

  const renderProfile = ({ item: p }: { item: UMProfile }) => (
    <View style={styles.card}>
      <View style={styles.cardHeader}>
        <View style={styles.cardInfo}>
          <Text style={styles.cardTitle}>{p.name || '—'}</Text>
          {p['rate-limit'] && <Text style={styles.cardMeta}>{p['rate-limit']}</Text>}
        </View>
        <View style={styles.profileMeta}>
          {p.validity && <Badge label={p.validity} variant="info" />}
          {p.price && <Badge label={`${p.price} ر.س`} variant="success" />}
        </View>
      </View>
      <View style={styles.actions}>
        <TouchableOpacity
          style={styles.actionBtn}
          onPress={() => {
            setProfileForm({
              name: p.name ?? '',
              validity: p.validity ?? '',
              price: p.price ?? '',
              'rate-limit': p['rate-limit'] ?? '',
              'shared-users': p['shared-users'] ?? '',
            });
            setShowEditProfile(p);
          }}
        >
          <Ionicons name="create-outline" size={15} color={colors.primary} />
          <Text style={[styles.actionText, { color: colors.primary }]}>تعديل</Text>
        </TouchableOpacity>
        <TouchableOpacity
          style={styles.actionBtn}
          onPress={() => {
            Alert.alert('حذف الباقة', `هل تريد حذف الباقة ${p.name}؟`, [
              { text: 'إلغاء', style: 'cancel' },
              {
                text: 'حذف',
                style: 'destructive',
                onPress: () => profileAction.mutate({ action: 'remove', id: p['.id'] }),
              },
            ]);
          }}
        >
          <Ionicons name="trash-outline" size={15} color={colors.error} />
          <Text style={[styles.actionText, { color: colors.error }]}>حذف</Text>
        </TouchableOpacity>
      </View>
    </View>
  );

  const renderSession = ({ item: s }: { item: UMSession }) => {
    const isActive = s.active === 'true' || s.active === true;
    return (
      <View style={styles.card}>
        <View style={styles.cardHeader}>
          <View style={styles.cardInfo}>
            <Text style={styles.cardTitle}>{s.user || '—'}</Text>
            <Text style={styles.cardMeta}>
              {s['from-time'] ? new Date(s['from-time']).toLocaleString('ar') : ''}
            </Text>
          </View>
          <Badge label={isActive ? 'نشط' : 'منتهي'} variant={isActive ? 'success' : 'muted'} />
        </View>
      </View>
    );
  };

  const isLoading =
    (tab === 'users' && usersQ.isLoading) ||
    (tab === 'profiles' && profilesQ.isLoading) ||
    (tab === 'sessions' && sessionsQ.isLoading);

  const profileFormView = (
    <View style={styles.formGap}>
      <Input
        label="اسم الباقة"
        value={profileForm.name}
        onChangeText={(v) => setProfileForm((p) => ({ ...p, name: v }))}
        placeholder="مثال: Basic"
        autoCapitalize="none"
      />
      <Input
        label="المدة (validity)"
        value={profileForm.validity}
        onChangeText={(v) => setProfileForm((p) => ({ ...p, validity: v }))}
        placeholder="مثال: 30d"
        autoCapitalize="none"
      />
      <Input
        label="السعر"
        value={profileForm.price}
        onChangeText={(v) => setProfileForm((p) => ({ ...p, price: v }))}
        placeholder="مثال: 5"
        keyboardType="numeric"
      />
      <Input
        label="حد السرعة"
        value={profileForm['rate-limit']}
        onChangeText={(v) => setProfileForm((p) => ({ ...p, 'rate-limit': v }))}
        placeholder="مثال: 2M/2M"
        autoCapitalize="none"
      />
      <Input
        label="عدد الأجهزة المشتركة"
        value={profileForm['shared-users']}
        onChangeText={(v) => setProfileForm((p) => ({ ...p, 'shared-users': v }))}
        placeholder="مثال: 1"
        keyboardType="numeric"
      />
      <Button
        label="حفظ"
        onPress={handleSaveProfile}
        loading={profileAction.isPending}
      />
    </View>
  );

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <View style={styles.header}>
        <Text style={styles.title}>مدير المستخدمين</Text>
        {tab === 'users' && (
          <TouchableOpacity style={styles.addBtn} onPress={() => setShowAddUser(true)}>
            <Ionicons name="person-add-outline" size={20} color={colors.primary} />
          </TouchableOpacity>
        )}
        {tab === 'profiles' && (
          <TouchableOpacity style={styles.addBtn} onPress={() => setShowAddProfile(true)}>
            <Ionicons name="add" size={22} color={colors.primary} />
          </TouchableOpacity>
        )}
      </View>

      <View style={styles.tabsWrap}>
        <TabBar
          tabs={[
            { key: 'users', label: 'المستخدمون', badge: users.length },
            { key: 'profiles', label: 'الباقات', badge: profiles.length },
            { key: 'sessions', label: 'الجلسات' },
          ]}
          activeTab={tab}
          onTabChange={(k) => setTab(k as UMTab)}
        />
      </View>

      {tab === 'users' && (
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
      )}

      {isLoading ? (
        <LoadingSpinner message="جاري التحميل..." />
      ) : tab === 'users' ? (
        <FlatList
          data={filteredUsers}
          keyExtractor={(item, i) => item['.id'] ?? `u${i}`}
          renderItem={renderUser}
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
      ) : tab === 'profiles' ? (
        <FlatList
          data={profiles}
          keyExtractor={(item, i) => item['.id'] ?? `p${i}`}
          renderItem={renderProfile}
          contentContainerStyle={styles.list}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={colors.primary} />}
          ListEmptyComponent={
            <EmptyState
              title="لا توجد باقات"
              icon={<Ionicons name="list-outline" size={40} color={colors.textMuted} />}
            />
          }
          showsVerticalScrollIndicator={false}
        />
      ) : (
        <FlatList
          data={sessions}
          keyExtractor={(item, i) => item['.id'] ?? `s${i}`}
          renderItem={renderSession}
          contentContainerStyle={styles.list}
          refreshControl={<RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={colors.primary} />}
          ListEmptyComponent={
            <EmptyState
              title="لا توجد جلسات"
              icon={<Ionicons name="timer-outline" size={40} color={colors.textMuted} />}
            />
          }
          showsVerticalScrollIndicator={false}
        />
      )}

      {/* Add User Sheet */}
      <BottomSheet visible={showAddUser} onClose={() => setShowAddUser(false)} title="إضافة مستخدم">
        <View style={styles.formGap}>
          <Input
            label="اسم المستخدم"
            value={newUser.username}
            onChangeText={(v) => setNewUser((p) => ({ ...p, username: v }))}
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
          <Input
            label="المجموعة"
            value={newUser.group}
            onChangeText={(v) => setNewUser((p) => ({ ...p, group: v }))}
            placeholder="اختياري"
            autoCapitalize="none"
          />
          <Button label="إضافة" onPress={handleAddUser} loading={userAction.isPending} />
        </View>
      </BottomSheet>

      {/* Add Profile Sheet */}
      <BottomSheet
        visible={showAddProfile}
        onClose={() => setShowAddProfile(false)}
        title="إضافة باقة"
        snapHeight="tall"
      >
        {profileFormView}
      </BottomSheet>

      {/* Edit Profile Sheet */}
      <BottomSheet
        visible={!!showEditProfile}
        onClose={() => setShowEditProfile(null)}
        title="تعديل باقة"
        snapHeight="tall"
      >
        {profileFormView}
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
  card: {
    backgroundColor: colors.surface,
    borderRadius: radius.lg,
    borderWidth: 1,
    borderColor: colors.border,
    padding: spacing.md,
    gap: spacing.sm,
  },
  cardHeader: { flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' },
  cardInfo: { flex: 1, gap: 2 },
  cardTitle: { color: colors.text, fontSize: typography.fontSizeSm, fontWeight: typography.fontWeightSemiBold },
  cardMeta: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  profileMeta: { flexDirection: 'row', gap: spacing.xs },
  actions: { flexDirection: 'row', gap: spacing.md },
  actionBtn: { flexDirection: 'row', alignItems: 'center', gap: 4 },
  actionText: { fontSize: typography.fontSizeXs, fontWeight: typography.fontWeightMedium },
  formGap: { gap: spacing.md },
});
