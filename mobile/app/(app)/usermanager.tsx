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
import { Button } from '@/components/Button';
import { Ionicons } from '@expo/vector-icons';

interface User {
  id: string;
  username: string;
  profile: string;
  disabled: boolean;
  comment?: string;
}

export default function UserManagerScreen() {
  const colorScheme = useColorScheme();
  const colors = colorScheme === 'dark' ? Colors.dark : Colors.light;
  const [searchQuery, setSearchQuery] = useState('');
  const [refreshing, setRefreshing] = useState(false);
  const [users, setUsers] = useState<User[]>([
    { id: '1', username: 'john.doe', profile: '10Mbps', disabled: false },
    { id: '2', username: 'jane.smith', profile: '20Mbps', disabled: false, comment: 'Premium user' },
    { id: '3', username: 'test.user', profile: '5Mbps', disabled: true },
  ]);

  const filteredUsers = users.filter((user) =>
    user.username.toLowerCase().includes(searchQuery.toLowerCase()) ||
    user.profile.toLowerCase().includes(searchQuery.toLowerCase())
  );

  const handleRefresh = async () => {
    setRefreshing(true);
    setTimeout(() => setRefreshing(false), 1000);
  };

  const toggleUserStatus = (userId: string) => {
    setUsers(users.map(u =>
      u.id === userId ? { ...u, disabled: !u.disabled } : u
    ));
  };

  const deleteUser = (userId: string) => {
    setUsers(users.filter(u => u.id !== userId));
  };

  const renderUser = ({ item }: { item: User }) => (
    <View style={[styles.userCard, { backgroundColor: colors.card, borderColor: colors.border }]}>
      <View style={styles.userMain}>
        <View style={styles.userInfo}>
          <View style={styles.userHeader}>
            <Text style={[styles.username, { color: colors.foreground }]}>{item.username}</Text>
            {item.disabled && (
              <View style={[styles.badge, { backgroundColor: colors.destructive }]}>
                <Text style={styles.badgeText}>Disabled</Text>
              </View>
            )}
          </View>
          <Text style={[styles.profile, { color: colors.mutedForeground }]}>
            Profile: {item.profile}
          </Text>
          {item.comment && (
            <Text style={[styles.comment, { color: colors.mutedForeground }]}>
              {item.comment}
            </Text>
          )}
        </View>
      </View>

      <View style={styles.actions}>
        <TouchableOpacity
          style={[styles.actionButton, { backgroundColor: item.disabled ? colors.success : colors.warning }]}
          onPress={() => toggleUserStatus(item.id)}
        >
          <Ionicons
            name={item.disabled ? 'play' : 'pause'}
            size={16}
            color="#FFF"
          />
        </TouchableOpacity>
        <TouchableOpacity
          style={[styles.actionButton, { backgroundColor: colors.destructive }]}
          onPress={() => deleteUser(item.id)}
        >
          <Ionicons name="trash-outline" size={16} color="#FFF" />
        </TouchableOpacity>
      </View>
    </View>
  );

  return (
    <SafeAreaView style={[styles.container, { backgroundColor: colors.background }]} edges={['top']}>
      <View style={styles.header}>
        <Text style={[styles.title, { color: colors.foreground }]}>User Manager</Text>
        <Text style={[styles.subtitle, { color: colors.mutedForeground }]}>
          {users.length} total users
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
          <TouchableOpacity
            style={[styles.addButton, { backgroundColor: colors.primary }]}
          >
            <Ionicons name="add" size={24} color="#FFF" />
          </TouchableOpacity>
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
              <Ionicons name="people-outline" size={64} color={colors.mutedForeground} />
              <Text style={[styles.emptyText, { color: colors.mutedForeground }]}>
                No users found
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
    flexDirection: 'row',
    paddingHorizontal: Spacing.lg,
    marginBottom: Spacing.md,
    gap: Spacing.sm,
  },
  searchBox: {
    flex: 1,
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
  addButton: {
    width: 48,
    height: 48,
    borderRadius: BorderRadius.md,
    justifyContent: 'center',
    alignItems: 'center',
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
  userMain: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginBottom: Spacing.md,
  },
  userInfo: {
    flex: 1,
  },
  userHeader: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: Spacing.sm,
    marginBottom: Spacing.xs,
  },
  username: {
    fontSize: FontSizes.base,
    fontWeight: '600',
  },
  badge: {
    paddingHorizontal: Spacing.sm,
    paddingVertical: 2,
    borderRadius: BorderRadius.xs,
  },
  badgeText: {
    color: '#FFF',
    fontSize: FontSizes.xs,
    fontWeight: '600',
  },
  profile: {
    fontSize: FontSizes.sm,
    marginBottom: Spacing.xs,
  },
  comment: {
    fontSize: FontSizes.xs,
    fontStyle: 'italic',
  },
  actions: {
    flexDirection: 'row',
    gap: Spacing.sm,
  },
  actionButton: {
    width: 40,
    height: 40,
    borderRadius: BorderRadius.md,
    justifyContent: 'center',
    alignItems: 'center',
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
