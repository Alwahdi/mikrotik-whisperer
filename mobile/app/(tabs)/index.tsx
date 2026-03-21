import { Ionicons } from '@expo/vector-icons';
import { useCallback, useEffect, useState } from 'react';
import { ActivityIndicator, RefreshControl, ScrollView, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { router } from 'expo-router';

import Colors from '@/constants/Colors';
import { invokeMikrotik } from '@/lib/mikrotik';
import { useRouters } from '@/providers/RouterProvider';

type ResourceInfo = {
  uptime?: string;
  cpu_load?: string;
  free_memory?: string;
  total_memory?: string;
  version?: string;
  board_name?: string;
};

type IdentityInfo = { name?: string };

export default function DashboardScreen() {
  const { selectedRouter } = useRouters();
  const [resource, setResource] = useState<ResourceInfo | null>(null);
  const [identity, setIdentity] = useState<IdentityInfo | null>(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const load = useCallback(async () => {
    if (!selectedRouter) return;
    setLoading(true);
    setError(null);
    try {
      const [resourceRes, identityRes] = await Promise.all([
        invokeMikrotik({
          ...selectedRouter,
          endpoint: '/system/resource/print',
          mode: selectedRouter.mode,
          protocol: selectedRouter.protocol,
          port: selectedRouter.port,
        }),
        invokeMikrotik({
          ...selectedRouter,
          endpoint: '/system/identity/print',
          mode: selectedRouter.mode,
          protocol: selectedRouter.protocol,
          port: selectedRouter.port,
        }),
      ]);

      const resourceData = Array.isArray(resourceRes) ? resourceRes[0] : resourceRes;
      const identityData = Array.isArray(identityRes) ? identityRes[0] : identityRes;
      setResource(resourceData || {});
      setIdentity(identityData || {});
    } catch (err: any) {
      setError(err?.message || 'تعذر جلب بيانات الراوتر');
    } finally {
      setLoading(false);
    }
  }, [selectedRouter]);

  useEffect(() => {
    if (selectedRouter) load();
  }, [selectedRouter, load]);

  if (!selectedRouter) {
    return (
      <View style={styles.empty}>
        <Ionicons name="server-outline" size={48} color="#94a3b8" />
        <Text style={styles.emptyTitle}>اختر راوتر للعمل عليه</Text>
        <Text style={styles.emptySubtitle}>من فضلك أضف أو اختر راوتر من تبويب الراوترات</Text>
        <TouchableOpacity style={styles.primaryBtn} onPress={() => router.push('/routers')}>
          <Text style={styles.primaryBtnText}>اذهب للراوترات</Text>
        </TouchableOpacity>
      </View>
    );
  }

  return (
    <ScrollView
      style={styles.container}
      contentContainerStyle={styles.content}
      refreshControl={<RefreshControl refreshing={loading} onRefresh={load} tintColor={Colors.light.primary} />}
    >
      <View style={styles.header}>
        <View>
          <Text style={styles.title}>{identity?.name || selectedRouter.label || 'راوتر'}</Text>
          <Text style={styles.subtitle}>{selectedRouter.host}</Text>
        </View>
        <TouchableOpacity onPress={load} style={styles.refreshBtn}>
          <Ionicons name="refresh" size={18} color={Colors.light.primary} />
        </TouchableOpacity>
      </View>

      {error ? (
        <View style={styles.errorBox}>
          <Ionicons name="alert-circle" size={20} color={Colors.light.destructive} />
          <Text style={styles.errorText}>{error}</Text>
        </View>
      ) : null}

      {loading ? (
        <View style={styles.loadingBox}>
          <ActivityIndicator color={Colors.light.primary} />
          <Text style={styles.loadingText}>جاري تحديث البيانات...</Text>
        </View>
      ) : (
        <View style={styles.cards}>
          <StatCard
            label="إصدارة النظام"
            value={resource?.version || 'غير متوفر'}
            icon="hardware-chip"
          />
          <StatCard
            label="استهلاك المعالج"
            value={resource?.cpu_load ? `${resource.cpu_load}%` : '—'}
            icon="speedometer"
          />
          <StatCard
            label="الذاكرة المتاحة"
            value={formatBytes(resource?.free_memory, resource?.total_memory)}
            icon="server-outline"
          />
          <StatCard
            label="مدة التشغيل"
            value={resource?.uptime || '—'}
            icon="time"
          />
        </View>
      )}
    </ScrollView>
  );
}

function StatCard({ label, value, icon }: { label: string; value: string; icon: any }) {
  return (
    <View style={styles.card}>
      <View style={styles.cardHeader}>
        <Ionicons name={icon} size={18} color={Colors.light.primary} />
        <Text style={styles.cardLabel}>{label}</Text>
      </View>
      <Text style={styles.cardValue}>{value}</Text>
    </View>
  );
}

function formatBytes(free?: string, total?: string) {
  const freeNum = Number(free || 0);
  const totalNum = Number(total || 0);
  if (!totalNum) return '—';
  const used = totalNum - freeNum;
  const percent = Math.round((used / totalNum) * 100);
  const mbFree = Math.round(freeNum / (1024 * 1024));
  const mbTotal = Math.round(totalNum / (1024 * 1024));
  return `${mbFree}/${mbTotal} MB (استهلاك ${percent}%)`;
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: Colors.light.surface },
  content: { padding: 18, gap: 12 },
  header: { flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' },
  title: { fontSize: 22, fontWeight: '800', color: Colors.light.text },
  subtitle: { color: '#64748b', marginTop: 2 },
  cards: { flexDirection: 'row', flexWrap: 'wrap', gap: 12 },
  card: {
    width: '47%',
    borderRadius: 16,
    padding: 14,
    backgroundColor: '#fff',
    borderWidth: 1,
    borderColor: '#e2e8f0',
    shadowColor: '#0f172a',
    shadowOpacity: 0.06,
    shadowRadius: 8,
    shadowOffset: { width: 0, height: 4 },
  },
  cardHeader: { flexDirection: 'row', alignItems: 'center', gap: 8 },
  cardLabel: { color: '#475569', fontWeight: '600' },
  cardValue: { marginTop: 10, fontSize: 18, fontWeight: '800', color: Colors.light.text },
  loadingBox: {
    backgroundColor: '#fff',
    borderRadius: 14,
    borderWidth: 1,
    borderColor: '#e2e8f0',
    padding: 16,
    flexDirection: 'row',
    alignItems: 'center',
    gap: 10,
  },
  loadingText: { color: '#475569', fontWeight: '600' },
  errorBox: {
    backgroundColor: '#fef2f2',
    borderColor: '#fecdd3',
    borderWidth: 1,
    padding: 12,
    borderRadius: 12,
    flexDirection: 'row',
    alignItems: 'center',
    gap: 8,
  },
  errorText: { color: Colors.light.destructive, fontWeight: '600', flex: 1 },
  refreshBtn: {
    width: 40,
    height: 40,
    borderRadius: 12,
    borderWidth: 1,
    borderColor: '#e2e8f0',
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#fff',
  },
  empty: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    gap: 10,
    backgroundColor: Colors.light.surface,
    paddingHorizontal: 24,
  },
  emptyTitle: { fontSize: 18, fontWeight: '800', color: Colors.light.text },
  emptySubtitle: { color: '#64748b', textAlign: 'center' },
  primaryBtn: {
    marginTop: 6,
    backgroundColor: Colors.light.primary,
    paddingHorizontal: 18,
    paddingVertical: 12,
    borderRadius: 14,
  },
  primaryBtnText: { color: '#fff', fontWeight: '700' },
});
