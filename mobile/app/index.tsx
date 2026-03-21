import { useEffect } from 'react';
import { router } from 'expo-router';
import { View, ActivityIndicator, useColorScheme } from 'react-native';
import { useAuth } from '@/contexts/AuthContext';
import { Colors } from '@/lib/theme';

export default function Index() {
  const { user, loading } = useAuth();
  const colorScheme = useColorScheme();
  const colors = colorScheme === 'dark' ? Colors.dark : Colors.light;

  useEffect(() => {
    if (!loading) {
      if (user) {
        router.replace('/(app)/routers');
      } else {
        router.replace('/auth');
      }
    }
  }, [user, loading]);

  return (
    <View style={{
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
      backgroundColor: colors.background
    }}>
      <ActivityIndicator size="large" color={colors.primary} />
    </View>
  );
}
