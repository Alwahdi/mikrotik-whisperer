import React from "react";
import { Tabs } from "expo-router";
import { Ionicons } from "@expo/vector-icons";
import { Colors } from "@/lib/theme";
import { useAuth } from "@/contexts/AuthContext";
import { Redirect } from "expo-router";
import LoadingView from "@/components/LoadingView";

type TabConfig = {
  name: string;
  title: string;
  icon: keyof typeof Ionicons.glyphMap;
  iconActive: keyof typeof Ionicons.glyphMap;
  adminOnly?: boolean;
};

const tabs: TabConfig[] = [
  {
    name: "index",
    title: "الرئيسية",
    icon: "home-outline",
    iconActive: "home",
  },
  {
    name: "hotspot",
    title: "الهوتسبوت",
    icon: "wifi-outline",
    iconActive: "wifi",
  },
  {
    name: "usermanager",
    title: "المستخدمين",
    icon: "people-outline",
    iconActive: "people",
  },
  {
    name: "vouchers",
    title: "الكروت",
    icon: "card-outline",
    iconActive: "card",
  },
  {
    name: "sales",
    title: "المبيعات",
    icon: "bar-chart-outline",
    iconActive: "bar-chart",
  },
];

export default function AppLayout() {
  const { user, loading } = useAuth();

  if (loading) return <LoadingView />;
  if (!user) return <Redirect href="/(auth)/login" />;

  return (
    <Tabs
      screenOptions={{
        headerShown: false,
        tabBarStyle: {
          backgroundColor: Colors.sidebar,
          borderTopColor: Colors.sidebarBorder,
          borderTopWidth: 1,
          height: 60,
          paddingBottom: 8,
        },
        tabBarActiveTintColor: Colors.primary,
        tabBarInactiveTintColor: Colors.mutedFg,
        tabBarLabelStyle: {
          fontSize: 10,
          fontWeight: "500",
        },
      }}
    >
      {tabs.map((tab) => (
        <Tabs.Screen
          key={tab.name}
          name={tab.name}
          options={{
            title: tab.title,
            tabBarIcon: ({ focused, color }) => (
              <Ionicons
                name={focused ? tab.iconActive : tab.icon}
                size={22}
                color={color}
              />
            ),
          }}
        />
      ))}
      {/* Hidden screens */}
      <Tabs.Screen
        name="backups"
        options={{
          href: null,
          title: "النسخ الاحتياطي",
        }}
      />
      <Tabs.Screen
        name="settings"
        options={{
          href: null,
          title: "الإعدادات",
        }}
      />
    </Tabs>
  );
}
