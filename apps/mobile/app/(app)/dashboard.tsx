import { View, Text, ScrollView, RefreshControl } from "react-native";
import { useState } from "react";
import { useQuery } from "@tanstack/react-query";
import { Card } from "../../components/Card";
import { routerStorage } from "../../lib/storage";
import { useSystemResources, useHotspotUsers, useUserManagerCount } from "@repo/mikrotik";

export default function DashboardScreen() {
  const [refreshing, setRefreshing] = useState(false);
  const [activeRouter, setActiveRouter] = useState<any>(null);

  // Load active router on mount
  useState(() => {
    routerStorage.getActiveRouter().then(setActiveRouter);
  });

  const { data: systemResources, refetch: refetchSystem } = useQuery({
    queryKey: ["system-resources", activeRouter?.routerId],
    queryFn: async () => {
      // This will use the MikroTik hook
      return null;
    },
    enabled: !!activeRouter,
    refetchInterval: 15000,
  });

  const { data: hotspotUsers, refetch: refetchHotspot } = useQuery({
    queryKey: ["hotspot-users", activeRouter?.routerId],
    queryFn: async () => {
      return null;
    },
    enabled: !!activeRouter,
  });

  const { data: userManagerCount, refetch: refetchUM } = useQuery({
    queryKey: ["usermanager-count", activeRouter?.routerId],
    queryFn: async () => {
      return null;
    },
    enabled: !!activeRouter,
  });

  const onRefresh = async () => {
    setRefreshing(true);
    await Promise.all([refetchSystem(), refetchHotspot(), refetchUM()]);
    setRefreshing(false);
  };

  if (!activeRouter) {
    return (
      <View className="flex-1 bg-background items-center justify-center p-6">
        <Text className="text-white text-xl font-semibold mb-2">
          No Router Selected
        </Text>
        <Text className="text-slate-400 text-center">
          Please select a router from the Routers tab to view dashboard data
        </Text>
      </View>
    );
  }

  return (
    <ScrollView
      className="flex-1 bg-background"
      contentContainerClassName="p-4"
      refreshControl={
        <RefreshControl refreshing={refreshing} onRefresh={onRefresh} />
      }
    >
      <Text className="text-2xl font-bold text-white mb-4">Dashboard</Text>

      <View className="mb-4">
        <Text className="text-slate-400 mb-2">Active Router</Text>
        <Card>
          <Text className="text-white text-lg font-semibold">
            {activeRouter.label || activeRouter.host}
          </Text>
          <Text className="text-slate-400 text-sm">{activeRouter.host}:{activeRouter.port}</Text>
        </Card>
      </View>

      <View className="mb-4">
        <Text className="text-slate-400 mb-2">Quick Stats</Text>
        <View className="flex-row gap-2">
          <Card className="flex-1">
            <Text className="text-slate-400 text-sm mb-1">Hotspot Users</Text>
            <Text className="text-white text-2xl font-bold">
              {hotspotUsers?.length || 0}
            </Text>
          </Card>
          <Card className="flex-1">
            <Text className="text-slate-400 text-sm mb-1">User Manager</Text>
            <Text className="text-white text-2xl font-bold">
              {userManagerCount || 0}
            </Text>
          </Card>
        </View>
      </View>

      <View className="mb-4">
        <Text className="text-slate-400 mb-2">System Resources</Text>
        <Card>
          <View className="mb-3">
            <Text className="text-slate-400 text-sm mb-1">CPU Usage</Text>
            <View className="bg-background-lighter rounded-full h-2">
              <View
                className="bg-primary-500 rounded-full h-2"
                style={{ width: "45%" }}
              />
            </View>
            <Text className="text-white text-right text-sm mt-1">45%</Text>
          </View>
          <View>
            <Text className="text-slate-400 text-sm mb-1">Memory Usage</Text>
            <View className="bg-background-lighter rounded-full h-2">
              <View
                className="bg-primary-500 rounded-full h-2"
                style={{ width: "62%" }}
              />
            </View>
            <Text className="text-white text-right text-sm mt-1">62%</Text>
          </View>
        </Card>
      </View>
    </ScrollView>
  );
}
