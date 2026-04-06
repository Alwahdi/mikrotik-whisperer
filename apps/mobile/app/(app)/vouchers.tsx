import { View, Text, ScrollView } from "react-native";
import { Card } from "../../components/Card";
import { Button } from "../../components/Button";
import { Input } from "../../components/Input";
import { useState } from "react";

export default function VouchersScreen() {
  const [count, setCount] = useState("10");
  const [profile, setProfile] = useState("default");

  return (
    <ScrollView className="flex-1 bg-background" contentContainerClassName="p-4">
      <Text className="text-2xl font-bold text-white mb-4">Vouchers</Text>

      <Card className="mb-4">
        <Text className="text-white text-lg font-semibold mb-4">
          Generate Vouchers
        </Text>
        <Input
          label="Number of Vouchers"
          value={count}
          onChangeText={setCount}
          placeholder="10"
          keyboardType="numeric"
          className="mb-3"
        />
        <Input
          label="Profile"
          value={profile}
          onChangeText={setProfile}
          placeholder="default"
          className="mb-4"
        />
        <Button onPress={() => {}}>
          Generate Vouchers
        </Button>
      </Card>

      <Text className="text-slate-400 mb-2">Recent Vouchers</Text>
      <Card>
        <Text className="text-slate-400 text-center">
          Voucher generation will be implemented
        </Text>
      </Card>
    </ScrollView>
  );
}
