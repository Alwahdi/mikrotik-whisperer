import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
  Alert,
  KeyboardAvoidingView,
  Platform,
} from 'react-native';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { useRouter } from 'expo-router';
import { Ionicons } from '@expo/vector-icons';
import { useAuth } from '@/contexts/AuthContext';
import { useQueryClient } from '@tanstack/react-query';
import {
  getMikrotikConfig,
  saveMikrotikConfig,
  clearMikrotikConfig,
  getDefaultPort,
  type ConnectionMode,
  type ConnectionProtocol,
} from '@/lib/mikrotikConfig';
import {
  getMikrotikAgentUrl,
  saveMikrotikAgentUrl,
  invokeMikrotik,
} from '@/lib/mikrotikInvoke';
import { Input } from '@/components/Input';
import { Button } from '@/components/Button';
import { Card } from '@/components/Card';
import { SectionHeader } from '@/components/SectionHeader';
import { Badge } from '@/components/Badge';
import { colors, spacing, typography, radius } from '@/lib/theme';

export default function SettingsScreen() {
  const insets = useSafeAreaInsets();
  const router = useRouter();
  const { signOut } = useAuth();
  const qc = useQueryClient();

  const [host, setHost] = useState('');
  const [port, setPort] = useState('80');
  const [username, setUsername] = useState('admin');
  const [password, setPassword] = useState('');
  const [mode, setMode] = useState<ConnectionMode>('rest');
  const [protocol, setProtocol] = useState<ConnectionProtocol>('http');
  const [agentUrl, setAgentUrl] = useState('');
  const [testing, setTesting] = useState(false);
  const [testResult, setTestResult] = useState<'ok' | 'error' | null>(null);
  const [saving, setSaving] = useState(false);

  useEffect(() => {
    getMikrotikConfig().then((cfg) => {
      if (cfg) {
        setHost(cfg.host);
        setPort(cfg.port);
        setUsername(cfg.user);
        setPassword(cfg.pass);
        setMode(cfg.mode);
        setProtocol(cfg.protocol);
      }
    });
    getMikrotikAgentUrl().then(setAgentUrl);
  }, []);

  const handleModeChange = (m: ConnectionMode) => {
    setMode(m);
    const defaultProtocol: ConnectionProtocol = m === 'rest' ? 'http' : 'api-plain';
    setProtocol(defaultProtocol);
    setPort(getDefaultPort(m, defaultProtocol));
  };

  const handleTest = async () => {
    if (!host.trim()) {
      Alert.alert('خطأ', 'أدخل عنوان الراوتر');
      return;
    }
    setTesting(true);
    setTestResult(null);
    try {
      await invokeMikrotik({
        endpoint: '/system/identity/print',
        host: host.trim(),
        user: username,
        pass: password,
        port,
        protocol,
        mode,
        timeoutMs: 8000,
      });
      setTestResult('ok');
    } catch {
      setTestResult('error');
    } finally {
      setTesting(false);
    }
  };

  const handleSave = async () => {
    if (!host.trim()) {
      Alert.alert('خطأ', 'عنوان الراوتر مطلوب');
      return;
    }
    setSaving(true);
    try {
      await saveMikrotikConfig({
        host: host.trim(),
        user: username,
        pass: password,
        port,
        protocol,
        mode,
      });
      if (agentUrl.trim()) {
        await saveMikrotikAgentUrl(agentUrl.trim());
      }
      await qc.invalidateQueries({ queryKey: ['mikrotik'] });
      Alert.alert('تم', 'تم حفظ الإعدادات');
    } catch (err) {
      Alert.alert('خطأ', err instanceof Error ? err.message : 'فشل الحفظ');
    } finally {
      setSaving(false);
    }
  };

  const handleDisconnect = async () => {
    Alert.alert('قطع الاتصال', 'هل تريد قطع الاتصال بالراوتر؟', [
      { text: 'إلغاء', style: 'cancel' },
      {
        text: 'قطع',
        style: 'destructive',
        onPress: async () => {
          await clearMikrotikConfig();
          await qc.invalidateQueries({ queryKey: ['mikrotik'] });
          // Batch state resets (React 18 batches these automatically)
          setHost('');
          setPort('80');
          setUsername('admin');
          setPassword('');
        },
      },
    ]);
  };

  const handleSignOut = async () => {
    await signOut();
    router.replace('/auth');
  };

  const modeOptions: { value: ConnectionMode; label: string }[] = [
    { value: 'rest', label: 'REST API' },
    { value: 'api', label: 'MikroTik API' },
  ];

  const protocolOptions: { value: ConnectionProtocol; label: string }[] =
    mode === 'rest'
      ? [{ value: 'https', label: 'HTTPS' }, { value: 'http', label: 'HTTP' }]
      : [{ value: 'api-plain', label: 'API Plain' }, { value: 'api-ssl', label: 'API SSL' }];

  return (
    <View style={[styles.root, { paddingTop: insets.top }]}>
      <KeyboardAvoidingView
        behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
        style={styles.kav}
      >
        <ScrollView
          contentContainerStyle={styles.content}
          showsVerticalScrollIndicator={false}
          keyboardShouldPersistTaps="handled"
        >
          <Text style={styles.title}>الإعدادات</Text>

          {/* Connection */}
          <Card padding="lg">
            <SectionHeader title="إعدادات الاتصال" />
            <View style={styles.formGap}>
              {/* Mode */}
              <View>
                <Text style={styles.sectionLabel}>وضع الاتصال</Text>
                <View style={styles.optionsRow}>
                  {modeOptions.map((opt) => (
                    <TouchableOpacity
                      key={opt.value}
                      style={[styles.optBtn, mode === opt.value && styles.optBtnActive]}
                      onPress={() => handleModeChange(opt.value)}
                    >
                      <Text style={[styles.optText, mode === opt.value && styles.optTextActive]}>
                        {opt.label}
                      </Text>
                    </TouchableOpacity>
                  ))}
                </View>
              </View>

              {/* Protocol */}
              <View>
                <Text style={styles.sectionLabel}>البروتوكول</Text>
                <View style={styles.optionsRow}>
                  {protocolOptions.map((opt) => (
                    <TouchableOpacity
                      key={opt.value}
                      style={[styles.optBtn, protocol === opt.value && styles.optBtnActive]}
                      onPress={() => {
                        setProtocol(opt.value);
                        setPort(getDefaultPort(mode, opt.value));
                      }}
                    >
                      <Text style={[styles.optText, protocol === opt.value && styles.optTextActive]}>
                        {opt.label}
                      </Text>
                    </TouchableOpacity>
                  ))}
                </View>
              </View>

              <Input label="العنوان (IP/Host)" value={host} onChangeText={setHost} placeholder="192.168.1.1" autoCapitalize="none" keyboardType="url" />
              <Input label="المنفذ" value={port} onChangeText={setPort} keyboardType="numeric" />
              <Input label="المستخدم" value={username} onChangeText={setUsername} autoCapitalize="none" />
              <Input label="كلمة المرور" value={password} onChangeText={setPassword} secureTextEntry />
            </View>
          </Card>

          {/* Agent URL */}
          <Card padding="lg">
            <SectionHeader title="Local Agent" />
            <Input
              label="عنوان الـ Agent"
              value={agentUrl}
              onChangeText={setAgentUrl}
              placeholder="http://127.0.0.1:3001"
              autoCapitalize="none"
              keyboardType="url"
            />
          </Card>

          {/* Test Result */}
          {testResult && (
            <Badge
              label={testResult === 'ok' ? 'الاتصال ناجح ✓' : 'فشل الاتصال ✗'}
              variant={testResult === 'ok' ? 'success' : 'error'}
              size="md"
            />
          )}

          {/* Actions */}
          <View style={styles.actionsGap}>
            <View style={styles.actionRow}>
              <Button
                label="اختبار الاتصال"
                variant="ghost"
                onPress={handleTest}
                loading={testing}
                style={styles.flex1}
                icon={<Ionicons name="wifi-outline" size={16} color={colors.textMuted} />}
              />
              <Button
                label="حفظ"
                onPress={handleSave}
                loading={saving}
                style={styles.flex1}
              />
            </View>
            <Button label="قطع الاتصال" variant="danger" onPress={handleDisconnect} />
            <Button
              label="تسجيل الخروج"
              variant="ghost"
              onPress={handleSignOut}
              icon={<Ionicons name="log-out-outline" size={16} color={colors.error} />}
            />
          </View>
        </ScrollView>
      </KeyboardAvoidingView>
    </View>
  );
}

const styles = StyleSheet.create({
  root: { flex: 1, backgroundColor: colors.background },
  kav: { flex: 1 },
  content: { padding: spacing.lg, gap: spacing.lg, paddingBottom: spacing.xxxl },
  title: { color: colors.text, fontSize: typography.fontSizeXl, fontWeight: typography.fontWeightBold },
  formGap: { gap: spacing.md },
  sectionLabel: { color: colors.textSecondary, fontSize: typography.fontSizeSm, marginBottom: spacing.xs },
  optionsRow: { flexDirection: 'row', gap: spacing.sm },
  optBtn: {
    flex: 1, paddingVertical: spacing.sm, alignItems: 'center',
    borderRadius: radius.md, backgroundColor: colors.surface2,
    borderWidth: 1, borderColor: colors.border,
  },
  optBtnActive: { borderColor: colors.primary, backgroundColor: `${colors.primary}22` },
  optText: { color: colors.textMuted, fontSize: typography.fontSizeSm },
  optTextActive: { color: colors.primary, fontWeight: typography.fontWeightSemiBold },
  actionsGap: { gap: spacing.sm },
  actionRow: { flexDirection: 'row', gap: spacing.sm },
  flex1: { flex: 1 },
});
