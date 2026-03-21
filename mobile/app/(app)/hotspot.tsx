import React, { useState } from 'react';
import {
  View,
  Text,
  ScrollView,
  StyleSheet,
  useColorScheme,
  TextInput,
  TouchableOpacity,
  FlatList,
  RefreshControl,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { Colors, Spacing, FontSizes, BorderRadius } from '@/lib/theme';
import { Card, CardHeader } from '@/components/Card';
import { Button } from '@/components/Button';
import { Ionicons } from '@expo/vector-icons';

interface HotspotUser {
  id: string;
  username: string;
  mac: string;
  ip: string;
  uptime: string;
  download: string;
  upload: string;
  status: 'active' | 'idle';
}

export default function HotspotScreen() {
  const colorScheme = useColorScheme();
  const colors = colorScheme === 'dark' ? Colors.dark : Colors.light;
  const [searchQuery, setSearchQuery] = useState('');
  const [refreshing, setRefreshing] = useState(false);
  const [users, setUsers] = useState<HotspotUser[]>([
    {
      id: '1',
      username: 'user001',
      mac: 'AA:BB:CC:DD:EE:FF',
      ip: '192.168.88.101',
      uptime: '2h 15m',
      download: '524 MB',
      upload: '128 MB',
      status: 'active',
    },
    {
      id: '2',
      username: 'user002',
      mac: '11:22:33:44:55:66',
      ip: '192.168.88.102',
      uptime: '45m',
      download: '256 MB',
      upload: '64 MB',
      status: 'active',
    },
  ]);

  const filteredUsers = users.filter((user) =>
    user.username.toLowerCase().includes(searchQuery.toLowerCase()) ||
    user.ip.includes(searchQuery) ||
    user.mac.includes(searchQuery)
  );

  const handleRefresh = async () => {
    setRefreshing(true);
    setTimeout(() => setRefreshing(false), 1000);
  };

  const handleKickUser = (userId: string) => {
    setUsers(users.filter(u => u.id !== userId));
  };

  const renderUser = ({ item }: { item: HotspotUser }) => (
    <View style={[styles.userCard, { backgroundColor: colors.card, borderColor: colors.border }]}>
      <View style={styles.userHeader}>
        <View style={styles.userInfo}>
          <View style={[styles.statusDot, {
            backgroundColor: item.status === 'active' ? colors.success : colors.warning
          }]} />
          <View>
            <Text style={[styles.username, { color: colors.foreground }]}>{item.username}</Text>
            <Text style={[styles.userDetail, { color: colors.mutedForeground }]}>
              {item.ip} • {item.mac}
            </Text>
          </View>
        </View>
        <TouchableOpacity
          onPress={() => handleKickUser(item.id)}
          style={[styles.kickButton, { backgroundColor: colors.destructive }]}
        >
          <Ionicons name="close" size={16} color="#FFF" />
        </TouchableOpacity>
      </View>

      <View style={styles.statsRow}>
        <View style={styles.statItem}>
          <Ionicons name="time-outline" size={16} color={colors.mutedForeground} />
          <Text style={[styles.statText, { color: colors.foreground }]}>{item.uptime}</Text>
        </View>
        <View style={styles.statItem}>
          <Ionicons name="arrow-down-outline" size={16} color={colors.success} />
          <Text style={[styles.statText, { color: colors.foreground }]}>{item.download}</Text>
        </View>
        <View style={styles.statItem}>
          <Ionicons name="arrow-up-outline" size={16} color={colors.warning} />
          <Text style={[styles.statText, { color: colors.foreground }]}>{item.upload}</Text>
        </View>
      </View>
    </View>
  );

  return (
    <SafeAreaView style={[styles.container, { backgroundColor: colors.background }]} edges={['top']}>
      <View style={styles.header}>
        <Text style={[styles.title, { color: colors.foreground }]}>Hotspot Users</Text>
        <Text style={[styles.subtitle, { color: colors.mutedForeground }]}>
          {users.length} active connections
        </Text>
      </View>

      <View style={styles.content}>
        <View style={styles.searchContainer}>
          <View style={[styles.searchBox, { backgroundColor: colors.muted, borderColor: colors.border }]}>
            <Ionicons name="search-outline" size={20} color={colors.mutedForeground} />
            <TextInput
              style={[styles.searchInput, { color: colors.foreground }]}
              placeholder="Search users..."
              placeholderTextColor={colors.mutedForeground}
              value={searchQuery}
              onChangeText={setSearchQuery}
            />
          </View>
        </View>

        <FlatList
          data={filteredUsers}
          renderItem={renderUser}
          keyExtractor={(item) => item.id}
          contentContainerStyle={styles.listContent}
          refreshControl={
            <RefreshControl refreshing={refreshing} onRefresh={handleRefresh} tintColor={colors.primary} />
          }
          ListEmptyComponent={
            <View style={styles.emptyState}>
              <Ionicons name="wifi-outline" size={64} color={colors.mutedForeground} />
              <Text style={[styles.emptyText, { color: colors.mutedForeground }]}>
                No active users found
              </Text>
            </View>
          }
        />
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  header: {
    padding: Spacing.lg,
  },
  title: {
    fontSize: FontSizes['2xl'],
    fontWeight: 'bold',
    marginBottom: Spacing.xs,
  },
  subtitle: {
    fontSize: FontSizes.base,
  },
  content: {
    flex: 1,
  },
  searchContainer: {
    paddingHorizontal: Spacing.lg,
    marginBottom: Spacing.md,
  },
  searchBox: {
    flexDirection: 'row',
    alignItems: 'center',
    paddingHorizontal: Spacing.md,
    height: 48,
    borderRadius: BorderRadius.md,
    borderWidth: 1,
    gap: Spacing.sm,
  },
  searchInput: {
    flex: 1,
    fontSize: FontSizes.base,
  },
  listContent: {
    padding: Spacing.lg,
    paddingTop: 0,
  },
  userCard: {
    padding: Spacing.md,
    borderRadius: BorderRadius.lg,
    marginBottom: Spacing.md,
    borderWidth: 1,
  },
  userHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'flex-start',
    marginBottom: Spacing.md,
  },
  userInfo: {
    flexDirection: 'row',
    alignItems: 'center',
    flex: 1,
    gap: Spacing.sm,
  },
  statusDot: {
    width: 8,
    height: 8,
    borderRadius: 4,
  },
  username: {
    fontSize: FontSizes.base,
    fontWeight: '600',
    marginBottom: Spacing.xs,
  },
  userDetail: {
    fontSize: FontSizes.xs,
  },
  kickButton: {
    width: 32,
    height: 32,
    borderRadius: 16,
    justifyContent: 'center',
    alignItems: 'center',
  },
  statsRow: {
    flexDirection: 'row',
    gap: Spacing.lg,
  },
  statItem: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: Spacing.xs,
  },
  statText: {
    fontSize: FontSizes.sm,
  },
  emptyState: {
    alignItems: 'center',
    padding: Spacing['3xl'],
  },
  emptyText: {
    fontSize: FontSizes.base,
    marginTop: Spacing.md,
  },
});
