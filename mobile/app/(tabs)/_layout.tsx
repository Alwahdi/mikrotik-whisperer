import { Ionicons } from '@expo/vector-icons';
import { Redirect, Tabs } from 'expo-router';
import { useMemo } from 'react';

import { useColorScheme } from '@/components/useColorScheme';
import { useAuth } from '@/providers/AuthProvider';

export default function TabLayout() {
  const colorScheme = useColorScheme();
  const { user, sessionChecked } = useAuth();

  const iconColor = useMemo(
    () => (colorScheme === 'dark' ? '#7dd3fc' : '#0ea5e9'),
    [colorScheme],
  );

  if (!sessionChecked) return null;
  if (!user) return <Redirect href="/sign-in" />;

  return (
    <Tabs
      screenOptions={{
        headerShown: false,
        tabBarActiveTintColor: iconColor,
        tabBarStyle: {
          backgroundColor: '#fff',
          borderTopColor: '#e2e8f0',
        },
      }}
    >
      <Tabs.Screen
        name="index"
        options={{
          title: 'الرئيسية',
          tabBarIcon: ({ color, focused }) => (
            <Ionicons name={focused ? 'speedometer' : 'speedometer-outline'} size={22} color={color} />
          ),
        }}
      />
      <Tabs.Screen
        name="routers"
        options={{
          title: 'الراوترات',
          tabBarIcon: ({ color, focused }) => (
            <Ionicons name={focused ? 'server' : 'server-outline'} size={22} color={color} />
          ),
        }}
      />
      <Tabs.Screen
        name="hotspot"
        options={{
          title: 'الهوتسبوت',
          tabBarIcon: ({ color, focused }) => (
            <Ionicons name={focused ? 'wifi' : 'wifi-outline'} size={22} color={color} />
          ),
        }}
      />
      <Tabs.Screen
        name="web"
        options={{
          title: 'منصة الويب',
          tabBarIcon: ({ color, focused }) => (
            <Ionicons name={focused ? 'globe' : 'globe-outline'} size={22} color={color} />
          ),
        }}
      />
      <Tabs.Screen
        name="settings"
        options={{
          title: 'الإعدادات',
          tabBarIcon: ({ color, focused }) => (
            <Ionicons name={focused ? 'settings' : 'settings-outline'} size={22} color={color} />
          ),
        }}
      />
    </Tabs>
  );
}
