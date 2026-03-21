import React, { useState } from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Ionicons } from '@expo/vector-icons';
import { invokeMikrotik } from '@/lib/mikrotikInvoke';
import { getMikrotikConfig } from '@/lib/mikrotikConfig';
import { getAgentHealth } from '@/lib/mikrotikInvoke';
import { getMikrotikAgentUrl } from '@/lib/mikrotikInvoke';
import { Button } from '@/components/Button';
import { Card } from '@/components/Card';
import { SectionHeader } from '@/components/SectionHeader';
import { Badge } from '@/components/Badge';
import { LoadingSpinner } from '@/components/LoadingSpinner';
import { colors, spacing, typography, radius } from '@/lib/theme';

interface ServiceCheck {
  name: string;
  endpoint?: string;
  action?: string;
  status: 'ok' | 'error' | 'checking' | 'idle';
  latencyMs?: number;
  error?: string;
}

const SERVICES: Omit<ServiceCheck, 'status'>[] = [
  { name: 'هوت سبوت', endpoint: '/ip/hotspot/active/print' },
  { name: 'مدير المستخدمين', endpoint: '/user-manager/user/print' },
  { name: 'واجهات الشبكة', endpoint: '/interface/print' },
  { name: 'معلومات النظام', endpoint: '/system/resource/print' },
  { name: 'DHCP', endpoint: '/ip/dhcp-server/lease/print' },
  { name: 'Health Check', action: 'health-check' },
];

export default function HealthScreen() {
  const insets = useSafeAreaInsets();
  const [checks, setChecks] = useState<ServiceCheck[]>(
    SERVICES.map((s) => ({ ...s, status: 'idle' }))
  );
  const [running, setRunning] = useState(false);
  const [agentInfo, setAgentInfo] = useState<{ ok: boolean; version?: string; error?: string } | null>(null);

  const runDiagnostics = async () => {
    const config = await getMikrotikConfig();
    if (!config) {
      setChecks(SERVICES.map((s) => ({ ...s, status: 'error', error: 'لم يتم إعداد الاتصال' })));
      return;
    }

    setRunning(true);
    setChecks(SERVICES.map((s) => ({ ...s, status: 'checking' })));

    // Check agent health
    const agentUrl = await getMikrotikAgentUrl();
    const agentHealth = await getAgentHealth(agentUrl);
    setAgentInfo(agentHealth);

    // Check each service
    const results = await Promise.all(
      SERVICES.map(async (svc) => {
        const start = Date.now();
        try {
          if (svc.action) {
            await invokeMikrotik({
              action: svc.action,
              host: config.host,
              user: config.user,
              pass: config.pass,
              port: config.port,
              protocol: config.protocol,
              mode: config.mode,
              timeoutMs: 10000,
            });
          } else if (svc.endpoint) {
            await invokeMikrotik({
              endpoint: svc.endpoint,
              host: config.host,
              user: config.user,
              pass: config.pass,
              port: config.port,
              protocol: config.protocol,
              mode: config.mode,
              timeoutMs: 10000,
            });
          }
          return { ...svc, status: 'ok' as const, latencyMs: Date.now() - start };
        } catch (err) {
          return {
            ...svc,
            status: 'error' as const,
            latencyMs: Date.now() - start,
            error: err instanceof Error ? err.message : 'خطأ',
          };
        }
      })
    );

    setChecks(results);
    setRunning(false);
  };

  const statusIcon = (status: ServiceCheck['status']) => {
    if (status === 'ok') return <Ionicons name="checkmark-circle" size={20} color={colors.success} />;
    if (status === 'error') return <Ionicons name="close-circle" size={20} color={colors.error} />;
    if (status === 'checking') return <Ionicons name="time-outline" size={20} color={colors.warning} />;
    return <Ionicons name="ellipse-outline" size={20} color={colors.textMuted} />;
  };

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <ScrollView contentContainerStyle={styles.content} showsVerticalScrollIndicator={false}>
        <View style={styles.header}>
          <Text style={styles.title}>فحص الصحة</Text>
        </View>

        <Button
          label={running ? 'جاري الفحص...' : 'بدء التشخيص'}
          onPress={runDiagnostics}
          loading={running}
          icon={<Ionicons name="pulse-outline" size={18} color={colors.text} />}
        />

        {/* Agent Info */}
        {agentInfo && (
          <Card padding="md">
            <SectionHeader title="Local Agent" />
            <View style={styles.agentRow}>
              <Badge
                label={agentInfo.ok ? 'يعمل' : 'غير متاح'}
                variant={agentInfo.ok ? 'success' : 'muted'}
              />
              {agentInfo.version && (
                <Text style={styles.agentVersion}>v{agentInfo.version}</Text>
              )}
              {agentInfo.error && (
                <Text style={styles.agentError}>{agentInfo.error}</Text>
              )}
            </View>
          </Card>
        )}

        {/* Service Checks */}
        <Card padding="sm">
          <SectionHeader title="الخدمات" />
          {checks.map((check, i) => (
            <View key={check.name} style={[styles.checkRow, i > 0 && styles.checkBorder]}>
              {statusIcon(check.status)}
              <View style={styles.checkInfo}>
                <Text style={styles.checkName}>{check.name}</Text>
                {check.error && <Text style={styles.checkError}>{check.error}</Text>}
              </View>
              {check.latencyMs !== undefined && (
                <Text style={styles.latency}>{check.latencyMs}ms</Text>
              )}
              {check.status === 'checking' && <LoadingSpinner size="small" />}
            </View>
          ))}
        </Card>
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  root: { flex: 1, backgroundColor: colors.background },
  content: { padding: spacing.lg, gap: spacing.lg, paddingBottom: spacing.xxxl },
  header: { flexDirection: 'row', alignItems: 'center' },
  title: { color: colors.text, fontSize: typography.fontSizeXl, fontWeight: typography.fontWeightBold, flex: 1 },
  agentRow: { flexDirection: 'row', alignItems: 'center', gap: spacing.sm, flexWrap: 'wrap' },
  agentVersion: { color: colors.textMuted, fontSize: typography.fontSizeSm },
  agentError: { color: colors.error, fontSize: typography.fontSizeXs, flex: 1 },
  checkRow: {
    flexDirection: 'row', alignItems: 'center',
    paddingVertical: spacing.sm, paddingHorizontal: spacing.md, gap: spacing.sm,
  },
  checkBorder: { borderTopWidth: 1, borderTopColor: colors.border },
  checkInfo: { flex: 1 },
  checkName: { color: colors.text, fontSize: typography.fontSizeSm },
  checkError: { color: colors.error, fontSize: typography.fontSizeXs, marginTop: 2 },
  latency: { color: colors.textMuted, fontSize: typography.fontSizeXs },
});
