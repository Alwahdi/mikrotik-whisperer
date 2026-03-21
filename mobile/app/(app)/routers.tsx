import React, { useState } from 'react';
import {
  View,
  Text,
  ScrollView,
  StyleSheet,
  useColorScheme,
  TouchableOpacity,
  Alert,
  RefreshControl,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { router } from 'expo-router';
import { useAuth } from '@/contexts/AuthContext';
import { Colors, Spacing, FontSizes, BorderRadius } from '@/lib/theme';
import { Card, CardHeader } from '@/components/Card';
import { Button } from '@/components/Button';
import { Ionicons } from '@expo/vector-icons';
import AsyncStorage from '@react-native-async-storage/async-storage';
import * as Haptics from 'expo-haptics';

interface Router {
  id: string;
  name: string;
  host: string;
  port: number;
  mode: 'api' | 'rest';
  isActive: boolean;
}

export default function RoutersScreen() {
  const { profile, signOut } = useAuth();
  const colorScheme = useColorScheme();
  const colors = colorScheme === 'dark' ? Colors.dark : Colors.light;
  const [routers, setRouters] = useState<Router[]>([]);
  const [loading, setLoading] = useState(false);
  const [refreshing, setRefreshing] = useState(false);

  const loadRouters = async () => {
    try {
      const stored = await AsyncStorage.getItem('routers');
      if (stored) {
        setRouters(JSON.parse(stored));
      }
    } catch (error) {
      console.error('Error loading routers:', error);
    }
  };

  React.useEffect(() => {
    loadRouters();
  }, []);

  const handleRefresh = async () => {
    setRefreshing(true);
    await loadRouters();
    setRefreshing(false);
  };

  const handleSelectRouter = async (routerItem: Router) => {
    await Haptics.impactAsync(Haptics.ImpactFeedbackStyle.Medium);
    await AsyncStorage.setItem('selectedRouter', JSON.stringify(routerItem));
    router.replace('/(app)/dashboard');
  };

  const handleAddRouter = () => {
    Alert.alert(
      'Add Router',
      'Router configuration feature will be available in settings.',
      [{ text: 'OK' }]
    );
  };

  const handleSignOut = async () => {
    Alert.alert('Sign Out', 'Are you sure you want to sign out?', [
      { text: 'Cancel', style: 'cancel' },
      {
        text: 'Sign Out',
        style: 'destructive',
        onPress: async () => {
          await signOut();
          router.replace('/auth');
        },
      },
    ]);
  };

  return (
    <SafeAreaView style={[styles.container, { backgroundColor: colors.background }]} edges={['top']}>
      <View style={styles.header}>
        <View>
          <Text style={[styles.greeting, { color: colors.foreground }]}>
            Welcome back, {profile?.full_name || 'User'}!
          </Text>
          <Text style={[styles.role, { color: colors.mutedForeground }]}>
            {profile?.role === 'admin' ? 'Administrator' : 'Cashier'}
          </Text>
        </View>
        <TouchableOpacity onPress={handleSignOut}>
          <Ionicons name="log-out-outline" size={24} color={colors.destructive} />
        </TouchableOpacity>
      </View>

      <ScrollView
        style={styles.content}
        contentContainerStyle={styles.scrollContent}
        refreshControl={
          <RefreshControl refreshing={refreshing} onRefresh={handleRefresh} tintColor={colors.primary} />
        }
      >
        <Card>
          <CardHeader
            title="Your Routers"
            subtitle="Select a router to manage"
            action={
              <TouchableOpacity onPress={handleAddRouter}>
                <Ionicons name="add-circle-outline" size={28} color={colors.primary} />
              </TouchableOpacity>
            }
          />

          {routers.length === 0 ? (
            <View style={styles.emptyState}>
              <Ionicons name="server-outline" size={64} color={colors.mutedForeground} />
              <Text style={[styles.emptyTitle, { color: colors.foreground }]}>
                No Routers Configured
              </Text>
              <Text style={[styles.emptyText, { color: colors.mutedForeground }]}>
                Add your first MikroTik router to get started
              </Text>
              <Button title="Add Router" onPress={handleAddRouter} style={styles.addButton} />
            </View>
          ) : (
            routers.map((router) => (
              <TouchableOpacity
                key={router.id}
                style={[
                  styles.routerCard,
                  {
                    backgroundColor: colors.muted,
                    borderColor: router.isActive ? colors.primary : colors.border,
                  },
                ]}
                onPress={() => handleSelectRouter(router)}
              >
                <View style={styles.routerInfo}>
                  <View style={[styles.statusDot, {
                    backgroundColor: router.isActive ? colors.success : colors.mutedForeground
                  }]} />
                  <View style={styles.routerDetails}>
                    <Text style={[styles.routerName, { color: colors.foreground }]}>
                      {router.name}
                    </Text>
                    <Text style={[styles.routerHost, { color: colors.mutedForeground }]}>
                      {router.host}:{router.port} • {router.mode.toUpperCase()}
                    </Text>
                  </View>
                </View>
                <Ionicons name="chevron-forward" size={20} color={colors.mutedForeground} />
              </TouchableOpacity>
            ))
          )}
        </Card>

        <Card>
          <CardHeader title="Quick Actions" />
          <View style={styles.quickActions}>
            <TouchableOpacity
              style={[styles.actionCard, { backgroundColor: colors.primary }]}
              onPress={() => router.push('/(app)/dashboard')}
            >
              <Ionicons name="speedometer-outline" size={32} color="#FFF" />
              <Text style={styles.actionText}>Dashboard</Text>
            </TouchableOpacity>
            <TouchableOpacity
              style={[styles.actionCard, { backgroundColor: colors.secondary }]}
              onPress={() => router.push('/(app)/hotspot')}
            >
              <Ionicons name="wifi-outline" size={32} color="#FFF" />
              <Text style={styles.actionText}>Hotspot</Text>
            </TouchableOpacity>
          </View>
        </Card>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  header: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: Spacing.lg,
  },
  greeting: {
    fontSize: FontSizes.xl,
    fontWeight: 'bold',
  },
  role: {
    fontSize: FontSizes.sm,
    marginTop: Spacing.xs,
  },
  content: {
    flex: 1,
  },
  scrollContent: {
    padding: Spacing.lg,
  },
  emptyState: {
    alignItems: 'center',
    padding: Spacing['2xl'],
  },
  emptyTitle: {
    fontSize: FontSizes.lg,
    fontWeight: 'bold',
    marginTop: Spacing.lg,
  },
  emptyText: {
    fontSize: FontSizes.base,
    textAlign: 'center',
    marginTop: Spacing.sm,
    marginBottom: Spacing.lg,
  },
  addButton: {
    minWidth: 200,
  },
  routerCard: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: Spacing.md,
    borderRadius: BorderRadius.md,
    marginBottom: Spacing.sm,
    borderWidth: 2,
  },
  routerInfo: {
    flexDirection: 'row',
    alignItems: 'center',
    flex: 1,
  },
  statusDot: {
    width: 12,
    height: 12,
    borderRadius: 6,
    marginRight: Spacing.md,
  },
  routerDetails: {
    flex: 1,
  },
  routerName: {
    fontSize: FontSizes.base,
    fontWeight: '600',
    marginBottom: Spacing.xs,
  },
  routerHost: {
    fontSize: FontSizes.sm,
  },
  quickActions: {
    flexDirection: 'row',
    gap: Spacing.md,
  },
  actionCard: {
    flex: 1,
    aspectRatio: 1,
    borderRadius: BorderRadius.lg,
    justifyContent: 'center',
    alignItems: 'center',
    padding: Spacing.md,
  },
  actionText: {
    color: '#FFF',
    fontSize: FontSizes.sm,
    fontWeight: '600',
    marginTop: Spacing.sm,
  },
});
