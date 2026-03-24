import { View, Text, ScrollView, Alert } from "react-native";
import { useRouter } from "expo-router";
import { Card } from "../../components/Card";
import { Button } from "../../components/Button";
import { supabase } from "../../lib/supabase";
import { routerStorage } from "../../lib/storage";

export default function SettingsScreen() {
  const router = useRouter();

  const handleSignOut = async () => {
    Alert.alert("Sign Out", "Are you sure you want to sign out?", [
      { text: "Cancel", style: "cancel" },
      {
        text: "Sign Out",
        style: "destructive",
        onPress: async () => {
          await supabase.auth.signOut();
          await routerStorage.clearActiveRouter();
          router.replace("/auth");
        },
      },
    ]);
  };

  return (
    <ScrollView className="flex-1 bg-background" contentContainerClassName="p-4">
      <Text className="text-2xl font-bold text-white mb-4">Settings</Text>

      <Card className="mb-4">
        <Text className="text-white text-lg font-semibold mb-2">
          About
        </Text>
        <Text className="text-slate-400">MikroTik Whisperer Mobile</Text>
        <Text className="text-slate-400">Version 1.0.0</Text>
      </Card>

      <Card className="mb-4">
        <Text className="text-white text-lg font-semibold mb-4">
          Network Configuration
        </Text>
        <Text className="text-slate-400 mb-2">
          This app supports both local and public IP addresses:
        </Text>
        <Text className="text-slate-400 mb-1">
          • Local IPs (192.168.x.x, 10.x.x.x) - work on same network
        </Text>
        <Text className="text-slate-400">
          • Public IPs/domains - work from anywhere with internet
        </Text>
      </Card>

      <Button variant="outline" onPress={handleSignOut}>
        Sign Out
      </Button>
    </ScrollView>
  );
}
