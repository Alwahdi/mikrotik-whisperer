import { useEffect, useState } from "react";
import { Redirect, Tabs } from "expo-router";
import { supabase } from "../../lib/supabase";
import type { User } from "@supabase/supabase-js";
import { ActivityIndicator, View } from "react-native";

export default function AppLayout() {
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    supabase.auth.getSession().then(({ data: { session } }) => {
      setUser(session?.user ?? null);
      setLoading(false);
    });

    const {
      data: { subscription },
    } = supabase.auth.onAuthStateChange((_event, session) => {
      setUser(session?.user ?? null);
    });

    return () => subscription.unsubscribe();
  }, []);

  if (loading) {
    return (
      <View className="flex-1 bg-background items-center justify-center">
        <ActivityIndicator size="large" color="#3b82f6" />
      </View>
    );
  }

  if (!user) {
    return <Redirect href="/auth" />;
  }

  return (
    <Tabs
      screenOptions={{
        headerShown: true,
        headerStyle: {
          backgroundColor: "#1e293b",
        },
        headerTintColor: "#fff",
        tabBarStyle: {
          backgroundColor: "#1e293b",
          borderTopColor: "#334155",
        },
        tabBarActiveTintColor: "#3b82f6",
        tabBarInactiveTintColor: "#64748b",
      }}
    >
      <Tabs.Screen
        name="dashboard"
        options={{
          title: "Dashboard",
          tabBarLabel: "Dashboard",
        }}
      />
      <Tabs.Screen
        name="routers"
        options={{
          title: "Routers",
          tabBarLabel: "Routers",
        }}
      />
      <Tabs.Screen
        name="hotspot"
        options={{
          title: "Hotspot",
          tabBarLabel: "Hotspot",
        }}
      />
      <Tabs.Screen
        name="vouchers"
        options={{
          title: "Vouchers",
          tabBarLabel: "Vouchers",
        }}
      />
      <Tabs.Screen
        name="settings"
        options={{
          title: "Settings",
          tabBarLabel: "Settings",
        }}
      />
    </Tabs>
  );
}
