import React, { useState, useCallback } from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
  Alert,
  TextInput,
  FlatList,
  Share,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import * as Clipboard from 'expo-clipboard';
import { useRouterKey, useHotspotProfiles, useUserManagerProfiles, useRawBatchAction } from '@/hooks/useMikrotik';
import { useAuth } from '@/contexts/AuthContext';
import { supabase } from '@/lib/supabase';
import { Button } from '@/components/Button';
import { Input } from '@/components/Input';
import { Card } from '@/components/Card';
import { Badge } from '@/components/Badge';
import { LoadingSpinner } from '@/components/LoadingSpinner';
import { SectionHeader } from '@/components/SectionHeader';
import { colors, spacing, typography, radius } from '@/lib/theme';

type VoucherType = 'hotspot' | 'usermanager';
type CharType = 'mixed' | 'alpha' | 'numeric' | 'hex';

interface Voucher {
  username: string;
  password: string;
}

function generateChar(charType: CharType): string {
  const alpha = 'abcdefghjkmnpqrstuvwxyz';
  const numeric = '23456789';
  const hex = '0123456789abcdef';
  const mixed = alpha + numeric;
  const charset =
    charType === 'alpha' ? alpha : charType === 'numeric' ? numeric : charType === 'hex' ? hex : mixed;
  return charset[Math.floor(Math.random() * charset.length)];
}

function generateCode(length: number, charType: CharType): string {
  return Array.from({ length }, () => generateChar(charType)).join('');
}

export default function VouchersScreen() {
  const insets = useSafeAreaInsets();
  const routerKey = useRouterKey();
  const { user } = useAuth();

  const [voucherType, setVoucherType] = useState<VoucherType>('hotspot');
  const [selectedProfile, setSelectedProfile] = useState('');
  const [quantity, setQuantity] = useState('10');
  const [charType, setCharType] = useState<CharType>('mixed');
  const [vouchers, setVouchers] = useState<Voucher[]>([]);
  const [pushing, setPushing] = useState(false);
  const [savingSales, setSavingSales] = useState(false);

  const hotspotProfilesQ = useHotspotProfiles(routerKey);
  const umProfilesQ = useUserManagerProfiles(routerKey);
  const batchAction = useRawBatchAction();

  const profiles = voucherType === 'hotspot'
    ? (Array.isArray(hotspotProfilesQ.data) ? (hotspotProfilesQ.data as { name: string }[]).map((p) => p.name) : [])
    : (Array.isArray(umProfilesQ.data) ? (umProfilesQ.data as { name: string }[]).map((p) => p.name) : []);

  const generate = useCallback(() => {
    const qty = Math.min(Math.max(parseInt(quantity) || 10, 1), 500);
    const generated: Voucher[] = Array.from({ length: qty }, () => ({
      username: generateCode(8, charType),
      password: generateCode(8, charType),
    }));
    setVouchers(generated);
  }, [quantity, charType]);

  const pushToRouter = async () => {
    if (vouchers.length === 0) return;
    setPushing(true);
    try {
      const endpoint =
        voucherType === 'hotspot' ? '/ip/hotspot/user/add' : '/user-manager/user/add';
      const commands = vouchers.map((v) => ({
        command: endpoint,
        args: [
          `=name=${v.username}`,
          `=password=${v.password}`,
          ...(selectedProfile ? [`=profile=${selectedProfile}`] : []),
        ],
      }));

      const result = await batchAction.mutateAsync({ commands });
      const resData = result as Record<string, unknown>;
      const errors = (resData?.errors as string[])?.filter((e) => e) || [];
      const total = vouchers.length;
      const failed = errors.length;
      const succeeded = total - failed;

      Alert.alert(
        'اكتمل',
        `تم رفع ${succeeded} كرت بنجاح${failed > 0 ? `، فشل ${failed}` : ''}`,
      );

      if (user && succeeded > 0) {
        setSavingSales(true);
        await supabase.from('sales').insert({
          user_id: user.id,
          voucher_type: voucherType,
          profile_name: selectedProfile || null,
          success_count: succeeded,
          failed_count: failed,
          card_count: total,
          unit_price: 0,
          total_amount: 0,
        });
        setSavingSales(false);
      }
    } catch (err) {
      Alert.alert('خطأ', err instanceof Error ? err.message : 'فشل الرفع');
    } finally {
      setPushing(false);
    }
  };

  const exportCSV = async () => {
    const csv = ['username,password', ...vouchers.map((v) => `${v.username},${v.password}`)].join('\n');
    await Share.share({ message: csv, title: 'vouchers.csv' });
  };

  const copyAll = async () => {
    const text = vouchers.map((v) => `${v.username} / ${v.password}`).join('\n');
    await Clipboard.setStringAsync(text);
    Alert.alert('تم', 'تم نسخ الكروت');
  };

  const charTypes: { key: CharType; label: string }[] = [
    { key: 'mixed', label: 'مختلط' },
    { key: 'alpha', label: 'حروف' },
    { key: 'numeric', label: 'أرقام' },
    { key: 'hex', label: 'هكس' },
  ];

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <ScrollView contentContainerStyle={styles.scroll} showsVerticalScrollIndicator={false}>
        <Text style={styles.title}>توليد كروت</Text>

        {/* Type Toggle */}
        <Card padding="md">
          <View style={styles.toggleRow}>
            {(['hotspot', 'usermanager'] as VoucherType[]).map((t) => (
              <TouchableOpacity
                key={t}
                style={[styles.toggleBtn, voucherType === t && styles.toggleBtnActive]}
                onPress={() => setVoucherType(t)}
              >
                <Text style={[styles.toggleText, voucherType === t && styles.toggleTextActive]}>
                  {t === 'hotspot' ? 'هوت سبوت' : 'مدير المستخدمين'}
                </Text>
              </TouchableOpacity>
            ))}
          </View>
        </Card>

        {/* Settings */}
        <Card padding="lg">
          <View style={styles.formGap}>
            {/* Profile */}
            <View>
              <Text style={styles.label}>الباقة</Text>
              <ScrollView horizontal showsHorizontalScrollIndicator={false}>
                <View style={styles.chipsRow}>
                  <TouchableOpacity
                    style={[styles.chip, selectedProfile === '' && styles.chipActive]}
                    onPress={() => setSelectedProfile('')}
                  >
                    <Text style={[styles.chipText, selectedProfile === '' && styles.chipTextActive]}>
                      الافتراضية
                    </Text>
                  </TouchableOpacity>
                  {profiles.map((p) => (
                    <TouchableOpacity
                      key={p}
                      style={[styles.chip, selectedProfile === p && styles.chipActive]}
                      onPress={() => setSelectedProfile(p)}
                    >
                      <Text style={[styles.chipText, selectedProfile === p && styles.chipTextActive]}>
                        {p}
                      </Text>
                    </TouchableOpacity>
                  ))}
                </View>
              </ScrollView>
            </View>

            {/* Quantity */}
            <Input
              label="الكمية"
              value={quantity}
              onChangeText={setQuantity}
              keyboardType="numeric"
              placeholder="10"
            />

            {/* Char type */}
            <View>
              <Text style={styles.label}>نوع الأحرف</Text>
              <View style={styles.chipsRow}>
                {charTypes.map((ct) => (
                  <TouchableOpacity
                    key={ct.key}
                    style={[styles.chip, charType === ct.key && styles.chipActive]}
                    onPress={() => setCharType(ct.key)}
                  >
                    <Text style={[styles.chipText, charType === ct.key && styles.chipTextActive]}>
                      {ct.label}
                    </Text>
                  </TouchableOpacity>
                ))}
              </View>
            </View>

            <Button label="توليد الكروت" onPress={generate} />
          </View>
        </Card>

        {/* Vouchers List */}
        {vouchers.length > 0 && (
          <View style={styles.vouchersSection}>
            <SectionHeader
              title={`الكروت (${vouchers.length})`}
              right={
                <View style={styles.actionsRow}>
                  <TouchableOpacity style={styles.iconBtn} onPress={copyAll}>
                    <Ionicons name="copy-outline" size={18} color={colors.primary} />
                  </TouchableOpacity>
                  <TouchableOpacity style={styles.iconBtn} onPress={exportCSV}>
                    <Ionicons name="share-outline" size={18} color={colors.primary} />
                  </TouchableOpacity>
                </View>
              }
            />

            <Button
              label={pushing ? 'جاري الرفع...' : 'رفع للراوتر'}
              variant="success"
              onPress={pushToRouter}
              loading={pushing || savingSales}
              icon={<Ionicons name="cloud-upload-outline" size={18} color={colors.text} />}
            />

            <FlatList
              data={vouchers.slice(0, 50)}
              keyExtractor={(_, i) => `v${i}`}
              scrollEnabled={false}
              renderItem={({ item: v, index }) => (
                <View style={[styles.voucherRow, index > 0 && styles.voucherBorder]}>
                  <Text style={styles.voucherIndex}>{index + 1}</Text>
                  <View style={styles.voucherInfo}>
                    <Text style={styles.voucherUser}>{v.username}</Text>
                    <Text style={styles.voucherPass}>{v.password}</Text>
                  </View>
                  <TouchableOpacity
                    onPress={() => Clipboard.setStringAsync(`${v.username}\n${v.password}`)}
                  >
                    <Ionicons name="copy-outline" size={16} color={colors.textMuted} />
                  </TouchableOpacity>
                </View>
              )}
              ItemSeparatorComponent={null}
            />
            {vouchers.length > 50 && (
              <Text style={styles.moreText}>...و {vouchers.length - 50} كرت إضافي</Text>
            )}
          </View>
        )}
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  root: { flex: 1, backgroundColor: colors.background },
  scroll: { padding: spacing.lg, gap: spacing.lg, paddingBottom: spacing.xxxl },
  title: { color: colors.text, fontSize: typography.fontSizeXl, fontWeight: typography.fontWeightBold },
  toggleRow: {
    flexDirection: 'row',
    backgroundColor: colors.surface2,
    borderRadius: radius.md,
    padding: 3,
  },
  toggleBtn: {
    flex: 1,
    paddingVertical: spacing.sm,
    alignItems: 'center',
    borderRadius: radius.sm,
  },
  toggleBtnActive: { backgroundColor: colors.primary },
  toggleText: { color: colors.textMuted, fontSize: typography.fontSizeSm, fontWeight: typography.fontWeightMedium },
  toggleTextActive: { color: colors.text, fontWeight: typography.fontWeightSemiBold },
  formGap: { gap: spacing.md },
  label: { color: colors.textSecondary, fontSize: typography.fontSizeSm, marginBottom: spacing.xs },
  chipsRow: { flexDirection: 'row', flexWrap: 'wrap', gap: spacing.sm },
  chip: {
    paddingVertical: spacing.xs,
    paddingHorizontal: spacing.sm,
    borderRadius: radius.full,
    backgroundColor: colors.surface2,
    borderWidth: 1,
    borderColor: colors.border,
  },
  chipActive: { backgroundColor: colors.primary, borderColor: colors.primary },
  chipText: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  chipTextActive: { color: colors.text, fontWeight: typography.fontWeightSemiBold },
  vouchersSection: { gap: spacing.sm },
  actionsRow: { flexDirection: 'row', gap: spacing.sm },
  iconBtn: {
    width: 36, height: 36,
    borderRadius: radius.md,
    backgroundColor: colors.surface,
    borderWidth: 1, borderColor: colors.border,
    alignItems: 'center', justifyContent: 'center',
  },
  voucherRow: {
    flexDirection: 'row',
    alignItems: 'center',
    paddingVertical: spacing.sm,
    paddingHorizontal: spacing.md,
    gap: spacing.sm,
    backgroundColor: colors.surface,
  },
  voucherBorder: { borderTopWidth: 1, borderTopColor: colors.border },
  voucherIndex: { color: colors.textMuted, fontSize: typography.fontSizeXs, width: 24, textAlign: 'right' },
  voucherInfo: { flex: 1 },
  voucherUser: { color: colors.text, fontSize: typography.fontSizeSm, fontWeight: typography.fontWeightMedium },
  voucherPass: { color: colors.textMuted, fontSize: typography.fontSizeXs },
  moreText: { color: colors.textMuted, fontSize: typography.fontSizeSm, textAlign: 'center', padding: spacing.md },
});
