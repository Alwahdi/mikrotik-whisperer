import { View, Text, ScrollView, Alert, TouchableOpacity } from "react-native";
import { useState, useEffect } from "react";
import { Card } from "../../components/Card";
import { Button } from "../../components/Button";
import { Input } from "../../components/Input";
import { routerStorage } from "../../lib/storage";
import { supabase } from "../../lib/supabase";

interface Router {
  id: string;
  label: string;
  host: string;
  port: number;
  protocol: string;
  mode: string;
}

export default function RoutersScreen() {
  const [routers, setRouters] = useState<Router[]>([]);
  const [loading, setLoading] = useState(false);
  const [activeRouterId, setActiveRouterId] = useState<string | null>(null);
  const [showAddForm, setShowAddForm] = useState(false);
  const [newRouter, setNewRouter] = useState({
    label: "",
    host: "",
    port: "8728",
    username: "",
    password: "",
  });

  useEffect(() => {
    loadRouters();
    loadActiveRouter();
  }, []);

  const loadRouters = async () => {
    try {
      const { data, error } = await supabase
        .from("routers")
        .select("*")
        .order("created_at", { ascending: false });

      if (error) throw error;
      setRouters(data || []);
    } catch (error: any) {
      Alert.alert("Error", error.message);
    }
  };

  const loadActiveRouter = async () => {
    const active = await routerStorage.getActiveRouter();
    setActiveRouterId(active?.routerId || null);
  };

  const selectRouter = async (router: Router) => {
    await routerStorage.setActiveRouter({
      routerId: router.id,
      host: router.host,
      port: router.port,
      protocol: router.protocol as any,
      mode: router.mode as any,
      label: router.label,
    });
    setActiveRouterId(router.id);
    Alert.alert("Success", `Router "${router.label}" activated`);
  };

  const isLocalIP = (host: string): boolean => {
    return (
      /^10\.\d+\.\d+\.\d+$/.test(host) ||
      /^192\.168\.\d+\.\d+$/.test(host) ||
      /^172\.(1[6-9]|2\d|3[0-1])\.\d+\.\d+$/.test(host) ||
      /^(127\.0\.0\.1|localhost)$/i.test(host)
    );
  };

  return (
    <ScrollView className="flex-1 bg-background" contentContainerClassName="p-4">
      <Text className="text-2xl font-bold text-white mb-4">Routers</Text>

      <Button onPress={() => setShowAddForm(!showAddForm)} className="mb-4">
        {showAddForm ? "Cancel" : "Add Router"}
      </Button>

      {showAddForm && (
        <Card className="mb-4">
          <Text className="text-white text-lg font-semibold mb-4">
            Add New Router
          </Text>
          <Input
            label="Label"
            value={newRouter.label}
            onChangeText={(text) => setNewRouter({ ...newRouter, label: text })}
            placeholder="Office Router"
            className="mb-3"
          />
          <Input
            label="Host (IP or Domain)"
            value={newRouter.host}
            onChangeText={(text) => setNewRouter({ ...newRouter, host: text })}
            placeholder="192.168.1.1 or example.com"
            autoCapitalize="none"
            className="mb-3"
          />
          {isLocalIP(newRouter.host) && (
            <Text className="text-yellow-500 text-sm mb-3">
              ℹ️ Local network IP detected - works only on same network
            </Text>
          )}
          {!isLocalIP(newRouter.host) && newRouter.host && (
            <Text className="text-green-500 text-sm mb-3">
              ✓ Public IP/domain - accessible remotely
            </Text>
          )}
          <Input
            label="Port"
            value={newRouter.port}
            onChangeText={(text) => setNewRouter({ ...newRouter, port: text })}
            placeholder="8728"
            keyboardType="numeric"
            className="mb-3"
          />
          <Input
            label="Username"
            value={newRouter.username}
            onChangeText={(text) => setNewRouter({ ...newRouter, username: text })}
            placeholder="admin"
            autoCapitalize="none"
            className="mb-3"
          />
          <Input
            label="Password"
            value={newRouter.password}
            onChangeText={(text) => setNewRouter({ ...newRouter, password: text })}
            placeholder="••••••••"
            secureTextEntry
            className="mb-4"
          />
          <Button loading={loading} onPress={() => Alert.alert("Info", "Router adding functionality will be implemented")}>
            Save Router
          </Button>
        </Card>
      )}

      <Text className="text-slate-400 mb-2">Your Routers</Text>

      {routers.length === 0 ? (
        <Card>
          <Text className="text-slate-400 text-center">
            No routers added yet
          </Text>
        </Card>
      ) : (
        routers.map((router) => (
          <TouchableOpacity
            key={router.id}
            onPress={() => selectRouter(router)}
          >
            <Card
              className={`mb-3 ${
                activeRouterId === router.id ? "border-2 border-primary-500" : ""
              }`}
            >
              <View className="flex-row justify-between items-start">
                <View className="flex-1">
                  <Text className="text-white text-lg font-semibold mb-1">
                    {router.label}
                  </Text>
                  <Text className="text-slate-400 text-sm mb-1">
                    {router.host}:{router.port}
                  </Text>
                  <View className="flex-row gap-2">
                    <Text className="text-xs text-slate-500 bg-background-lighter px-2 py-1 rounded">
                      {isLocalIP(router.host) ? "Local Network" : "Public/Remote"}
                    </Text>
                    <Text className="text-xs text-slate-500 bg-background-lighter px-2 py-1 rounded">
                      {router.mode}
                    </Text>
                  </View>
                </View>
                {activeRouterId === router.id && (
                  <View className="bg-primary-500 px-3 py-1 rounded">
                    <Text className="text-white text-xs font-semibold">
                      ACTIVE
                    </Text>
                  </View>
                )}
              </View>
            </Card>
          </TouchableOpacity>
        ))
      )}
    </ScrollView>
  );
}
