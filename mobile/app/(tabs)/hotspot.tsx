import { Ionicons } from '@expo/vector-icons';
import { useCallback, useEffect, useState } from 'react';
import {
  ActivityIndicator,
  Alert,
  FlatList,
  RefreshControl,
  SafeAreaView,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
} from 'react-native';

import Colors from '@/constants/Colors';
import { invokeMikrotik } from '@/lib/mikrotik';
import { useRouters } from '@/providers/RouterProvider';

type HotspotUser = {
  '.id'?: string;
  user?: string;
  address?: string;
  uptime?: string;
  session_time_left?: string;
};

export default function HotspotScreen() {
  const { selectedRouter } = useRouters();
  const [users, setUsers] = useState<HotspotUser[]>([]);
  const [loading, setLoading] = useState(false);
  const [actioningId, setActioningId] = useState<string | null>(null);
  const [error, setError] = useState<string | null>(null);

  const load = useCallback(async () => {
    if (!selectedRouter) return;
    setLoading(true);
    setError(null);
    try {
      const res = await invokeMikrotik({
        ...selectedRouter,
        endpoint: '/ip/hotspot/active/print',
        mode: selectedRouter.mode,
        protocol: selectedRouter.protocol,
        port: selectedRouter.port,
      });
      const list = Array.isArray(res) ? res : [];
      setUsers(list as HotspotUser[]);
    } catch (err: any) {
      setError(err?.message || 'تعذر جلب المستخدمين النشطين');
    } finally {
      setLoading(false);
    }
  }, [selectedRouter]);

  useEffect(() => {
    if (selectedRouter) load();
  }, [selectedRouter, load]);

  const disconnect = async (id?: string) => {
    if (!selectedRouter || !id) return;
    setActioningId(id);
    try {
      await invokeMikrotik({
        ...selectedRouter,
        action: 'batch',
        commands: [{ command: '/ip/hotspot/active/remove', args: [`=.id=${id}`] }],
      });
      await load();
    } catch (err: any) {
      Alert.alert('تعذر قطع الاتصال', err?.message || 'حاول مرة أخرى');
    } finally {
      setActioningId(null);
    }
  };

  if (!selectedRouter) {
    return (
      <SafeAreaView style={styles.safe}>
        <View style={styles.empty}>
          <Ionicons name="wifi-outline" size={48} color="#94a3b8" />
          <Text style={styles.emptyTitle}>حدد راوتر لمراجعة الهوتسبوت</Text>
        </View>
      </SafeAreaView>
    );
  }

  return (
    <SafeAreaView style={styles.safe}>
      <View style={styles.header}>
        <View>
          <Text style={styles.title}>الهوتسبوت</Text>
          <Text style={styles.subtitle}>المتصلون حالياً</Text>
        </View>
        <TouchableOpacity style={styles.refreshBtn} onPress={load}>
          <Ionicons name="refresh" size={18} color={Colors.light.primary} />
        </TouchableOpacity>
      </View>

      {error ? (
        <View style={styles.errorBox}>
          <Ionicons name="alert-circle" size={18} color={Colors.light.destructive} />
          <Text style={styles.errorText}>{error}</Text>
        </View>
      ) : null}

      <FlatList
        data={users}
        keyExtractor={(item) => item['.id'] || item.user || Math.random().toString()}
        refreshControl={<RefreshControl refreshing={loading} onRefresh={load} tintColor={Colors.light.primary} />}
        contentContainerStyle={{ paddingHorizontal: 16, paddingBottom: 24, gap: 10 }}
        renderItem={({ item }) => (
          <View style={styles.card}>
            <View style={{ flex: 1, gap: 4 }}>
              <Text style={styles.cardTitle}>{item.user || 'مستخدم مجهول'}</Text>
              <Text style={styles.cardLine}>IP: {item.address || 'غير معروف'}</Text>
              <Text style={styles.cardLine}>المدة: {item.uptime || '—'}</Text>
            </View>
            <TouchableOpacity
              onPress={() => disconnect(item['.id'])}
              disabled={actioningId === item['.id']}
              style={styles.kickBtn}
            >
              {actioningId === item['.id'] ? (
                <ActivityIndicator color="#fff" />
              ) : (
                <Text style={styles.kickText}>إنهاء</Text>
              )}
            </TouchableOpacity>
          </View>
        )}
        ListEmptyComponent={
          !loading ? (
            <View style={styles.empty}>
              <Ionicons name="happy-outline" size={44} color="#94a3b8" />
              <Text style={styles.emptyTitle}>لا يوجد متصلون حالياً</Text>
            </View>
          ) : null
        }
      />
    </SafeAreaView>
  );
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
  card: {
    backgroundColor: '#fff',
    borderRadius: 14,
    padding: 14,
    borderWidth: 1,
    borderColor: '#e2e8f0',
    flexDirection: 'row',
    alignItems: 'center',
    gap: 12,
  },
  cardTitle: { fontSize: 16, fontWeight: '800', color: Colors.light.text },
  cardLine: { color: '#475569' },
  kickBtn: {
    backgroundColor: Colors.light.destructive,
    paddingHorizontal: 12,
    paddingVertical: 10,
    borderRadius: 12,
    minWidth: 78,
    alignItems: 'center',
  },
  kickText: { color: '#fff', fontWeight: '700' },
  empty: { alignItems: 'center', marginTop: 40, gap: 8 },
  emptyTitle: { fontWeight: '800', color: Colors.light.text },
  errorBox: {
    backgroundColor: '#fef2f2',
    borderColor: '#fecdd3',
    borderWidth: 1,
    padding: 12,
    borderRadius: 12,
    marginHorizontal: 16,
    flexDirection: 'row',
    alignItems: 'center',
    gap: 8,
  },
  errorText: { color: Colors.light.destructive, fontWeight: '600', flex: 1 },
});
