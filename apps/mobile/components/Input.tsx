import {
  TextInput,
  TextInputProps,
  View,
  Text,
} from "react-native";
import { cn } from "../lib/utils";

interface InputProps extends TextInputProps {
  label?: string;
  error?: string;
}

export function Input({ label, error, className, ...props }: InputProps) {
  return (
    <View className="w-full">
      {label && <Text className="text-white mb-2 font-medium">{label}</Text>}
      <TextInput
        className={cn(
          "bg-background-lighter rounded-lg px-4 py-3 text-white",
          error && "border-2 border-red-500",
          className
        )}
        placeholderTextColor="#64748b"
        {...props}
      />
      {error && <Text className="text-red-500 text-sm mt-1">{error}</Text>}
    </View>
  );
}
