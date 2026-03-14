import React, { useCallback } from "react";
import { Platform, View, Text, StyleSheet } from "react-native";
import { Tabs, Redirect } from "expo-router";
import { BlurView } from "expo-blur";
import { Ionicons } from "@expo/vector-icons";
import { Colors } from "@/lib/theme";
import { useAuth } from "@/contexts/AuthContext";
import LoadingView from "@/components/LoadingView";
import { useHotspotUsers, useUserManagerUsers } from "@/hooks/useMikrotik";
import { selectionChanged } from "@/lib/haptics";

type TabConfig = {
  name: string;
  title: string;
  icon: keyof typeof Ionicons.glyphMap;
  iconActive: keyof typeof Ionicons.glyphMap;
};

const tabs: TabConfig[] = [
  { name: "index",       title: "الرئيسية",    icon: "home-outline",      iconActive: "home" },
  { name: "hotspot",     title: "الهوتسبوت",   icon: "wifi-outline",      iconActive: "wifi" },
  { name: "usermanager", title: "المستخدمين",  icon: "people-outline",    iconActive: "people" },
  { name: "vouchers",    title: "الكروت",      icon: "card-outline",      iconActive: "card" },
  { name: "sales",       title: "المبيعات",    icon: "bar-chart-outline", iconActive: "bar-chart" },
];

function TabBarBackground() {
  if (Platform.OS === "ios") {
    return (
      <BlurView
        tint="dark"
        intensity={80}
        style={StyleSheet.absoluteFill}
      />
    );
  }
  return <View style={[StyleSheet.absoluteFill, { backgroundColor: Colors.sidebar }]} />;
}

function BadgeDot({ count }: { count: number }) {
  if (!count) return null;
  return (
    <View style={styles.badge}>
      <Text style={styles.badgeText}>{count > 99 ? "99+" : count}</Text>
    </View>
  );
}

export default function AppLayout() {
  const { user, loading } = useAuth();
  const { data: hotspotUsers } = useHotspotUsers();
  const { data: umUsers } = useUserManagerUsers();

  const hotspotCount = Array.isArray(hotspotUsers) ? hotspotUsers.length : 0;
  const umCount = Array.isArray(umUsers) ? umUsers.length : 0;

  const getBadge = (name: string): number => {
    if (name === "hotspot") return hotspotCount;
    if (name === "usermanager") return umCount;
    return 0;
  };

  const onTabPress = useCallback(() => { selectionChanged(); }, []);

  if (loading) return <LoadingView />;
  if (!user) return <Redirect href="/(auth)/login" />;

  return (
    <Tabs
      screenListeners={{ tabPress: onTabPress }}
      screenOptions={{
        headerShown: false,
        tabBarStyle: {
          position: "absolute",
          borderTopColor: Colors.sidebarBorder,
          borderTopWidth: StyleSheet.hairlineWidth,
          backgroundColor: Platform.OS === "ios" ? "transparent" : Colors.sidebar,
          height: Platform.OS === "ios" ? 80 : 62,
        },
        tabBarBackground: TabBarBackground,
        tabBarActiveTintColor: Colors.primaryLight,
        tabBarInactiveTintColor: Colors.mutedFg,
        tabBarLabelStyle: { fontSize: 10, fontWeight: "600" },
      }}
    >
      {tabs.map((tab) => {
        const badge = getBadge(tab.name);
        return (
          <Tabs.Screen
            key={tab.name}
            name={tab.name}
            options={{
              title: tab.title,
              tabBarIcon: ({ focused, color }) => (
                <View>
                  <Ionicons name={focused ? tab.iconActive : tab.icon} size={22} color={color} />
                  <BadgeDot count={badge} />
                </View>
              ),
            }}
          />
        );
      })}
      {/* Hidden screens accessible via router.push */}
      <Tabs.Screen name="backups"  options={{ href: null, title: "النسخ الاحتياطي" }} />
      <Tabs.Screen name="settings" options={{ href: null, title: "الإعدادات" }} />
      <Tabs.Screen name="logs"     options={{ href: null, title: "السجلات" }} />
    </Tabs>
  );
}

const styles = StyleSheet.create({
  badge: {
    position: "absolute",
    top: -4,
    right: -8,
    minWidth: 16,
    height: 16,
    borderRadius: 8,
    backgroundColor: Colors.primary,
    alignItems: "center",
    justifyContent: "center",
    paddingHorizontal: 3,
  },
  badgeText: {
    color: "#fff",
    fontSize: 8,
    fontWeight: "800",
    lineHeight: 10,
  },
});
