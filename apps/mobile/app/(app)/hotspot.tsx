import { View, Text, ScrollView, Alert, RefreshControl } from "react-native";
import { useState } from "react";
import { useQuery } from "@tanstack/react-query";
import { Card } from "../../components/Card";
import { Button } from "../../components/Button";
import { routerStorage } from "../../lib/storage";

export default function HotspotScreen() {
  const [refreshing, setRefreshing] = useState(false);
  const [activeRouter, setActiveRouter] = useState<any>(null);

  useState(() => {
    routerStorage.getActiveRouter().then(setActiveRouter);
  });

  const { data: hotspotUsers, refetch } = useQuery({
    queryKey: ["hotspot-users", activeRouter?.routerId],
    queryFn: async () => {
      // Mock data for now
      return [
        { id: "1", name: "user1", address: "192.168.1.100", uptime: "1h 23m", mac: "AA:BB:CC:DD:EE:FF" },
        { id: "2", name: "user2", address: "192.168.1.101", uptime: "45m", mac: "11:22:33:44:55:66" },
      ];
    },
    enabled: !!activeRouter,
    refetchInterval: 10000,
  });

  const onRefresh = async () => {
    setRefreshing(true);
    await refetch();
    setRefreshing(false);
  };

  const kickUser = (userId: string, userName: string) => {
    Alert.alert(
      "Kick User",
      `Are you sure you want to disconnect ${userName}?`,
      [
        { text: "Cancel", style: "cancel" },
        {
          text: "Kick",
          style: "destructive",
          onPress: () => Alert.alert("Info", "Kick functionality will be implemented"),
        },
      ]
    );
  };

  if (!activeRouter) {
    return (
      <View className="flex-1 bg-background items-center justify-center p-6">
        <Text className="text-white text-xl font-semibold mb-2">
          No Router Selected
        </Text>
        <Text className="text-slate-400 text-center">
          Please select a router from the Routers tab
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
      <Text className="text-2xl font-bold text-white mb-4">Hotspot Users</Text>

      <Card className="mb-4">
        <Text className="text-slate-400 text-sm mb-1">Active Users</Text>
        <Text className="text-white text-3xl font-bold">
          {hotspotUsers?.length || 0}
        </Text>
      </Card>

      <Text className="text-slate-400 mb-2">Connected Users</Text>

      {!hotspotUsers || hotspotUsers.length === 0 ? (
        <Card>
          <Text className="text-slate-400 text-center">No active users</Text>
        </Card>
      ) : (
        hotspotUsers.map((user: any) => (
          <Card key={user.id} className="mb-3">
            <View className="flex-row justify-between items-start mb-2">
              <View className="flex-1">
                <Text className="text-white text-lg font-semibold mb-1">
                  {user.name}
                </Text>
                <Text className="text-slate-400 text-sm">{user.address}</Text>
                <Text className="text-slate-400 text-sm">{user.mac}</Text>
              </View>
              <View className="items-end">
                <Text className="text-primary-500 text-sm font-semibold">
                  {user.uptime}
                </Text>
              </View>
            </View>
            <Button
              variant="outline"
              size="sm"
              onPress={() => kickUser(user.id, user.name)}
            >
              Disconnect
            </Button>
          </Card>
        ))
      )}
    </ScrollView>
  );
}
