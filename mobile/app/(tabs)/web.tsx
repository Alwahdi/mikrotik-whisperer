import { Ionicons } from '@expo/vector-icons';
import * as Network from 'expo-network';
import { useEffect, useRef, useState } from 'react';
import { ActivityIndicator, Alert, SafeAreaView, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import WebView from 'react-native-webview';

import Colors from '@/constants/Colors';
import { useRouters } from '@/providers/RouterProvider';

export default function WebAppScreen() {
  const { webAppUrl } = useRouters();
  const webRef = useRef<WebView>(null);
  const [loading, setLoading] = useState(true);
  const [progress, setProgress] = useState(0);
  const [online, setOnline] = useState(true);

  useEffect(() => {
    setProgress(0);
    setLoading(true);
    webRef.current?.reload();
  }, [webAppUrl]);

  useEffect(() => {
    let mounted = true;
    const check = async () => {
      const state = await Network.getNetworkStateAsync();
      if (mounted) {
        setOnline(!!state.isConnected && (state.isInternetReachable ?? true));
      }
    };
    check();
    const interval = setInterval(check, 8000);
    return () => {
      mounted = false;
      clearInterval(interval);
    };
  }, []);

  return (
    <SafeAreaView style={styles.safe}>
      <View style={styles.topBar}>
        <Text style={styles.title}>منصة الويب الكاملة</Text>
        <View style={styles.actions}>
          <TouchableOpacity onPress={() => webRef.current?.goBack()} style={styles.iconBtn}>
            <Ionicons name="arrow-back" size={18} color={Colors.light.text} />
          </TouchableOpacity>
          <TouchableOpacity onPress={() => webRef.current?.reload()} style={styles.iconBtn}>
            <Ionicons name="refresh" size={18} color={Colors.light.text} />
          </TouchableOpacity>
        </View>
      </View>

      {!online ? (
        <View style={styles.offline}>
          <Ionicons name="alert-circle-outline" size={18} color={Colors.light.destructive} />
          <Text style={styles.offlineText}>الاتصال بالإنترنت غير متاح حالياً</Text>
        </View>
      ) : null}

      {loading ? (
        <View style={styles.loading}>
          <ActivityIndicator color={Colors.light.primary} />
          <View style={styles.progressTrack}>
            <View style={[styles.progressBar, { width: `${Math.max(progress * 100, 6)}%` }]} />
          </View>
          <Text style={styles.progressText}>يتم تحميل {webAppUrl}</Text>
        </View>
      ) : null}

      <WebView
        ref={webRef}
        source={{ uri: webAppUrl }}
        onLoadEnd={() => setLoading(false)}
        onLoadProgress={({ nativeEvent }) => setProgress(nativeEvent.progress)}
        onError={(e) => {
          Alert.alert('تعذر تحميل المنصة', e.nativeEvent.description);
          setLoading(false);
        }}
        style={styles.web}
      />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safe: { flex: 1, backgroundColor: Colors.light.surface },
  topBar: {
    paddingHorizontal: 16,
    paddingVertical: 12,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
  },
  title: { fontSize: 18, fontWeight: '800', color: Colors.light.text },
  actions: { flexDirection: 'row', gap: 8 },
  iconBtn: {
    width: 40,
    height: 40,
    borderRadius: 12,
    borderWidth: 1,
    borderColor: '#e2e8f0',
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#fff',
  },
  loading: { alignItems: 'center', gap: 8, paddingHorizontal: 16 },
  offline: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 8,
    backgroundColor: '#fef2f2',
    borderColor: '#fecdd3',
    borderWidth: 1,
    padding: 12,
    marginHorizontal: 16,
    borderRadius: 12,
  },
  offlineText: { color: Colors.light.destructive, fontWeight: '600' },
  progressTrack: {
    width: '100%',
    height: 6,
    backgroundColor: '#e2e8f0',
    borderRadius: 999,
    overflow: 'hidden',
  },
  progressBar: {
    height: 6,
    backgroundColor: Colors.light.primary,
  },
  progressText: { color: '#475569', fontWeight: '600' },
  web: { flex: 1 },
});
