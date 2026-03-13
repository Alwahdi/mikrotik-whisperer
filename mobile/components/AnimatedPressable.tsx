import React, { useCallback } from "react";
import {
  Pressable,
  PressableProps,
  StyleSheet,
  ViewStyle,
} from "react-native";
import Animated, {
  useSharedValue,
  useAnimatedStyle,
  withSpring,
  withTiming,
  runOnJS,
} from "react-native-reanimated";
import { mediumTap } from "@/lib/haptics";

interface AnimatedPressableProps extends PressableProps {
  style?: ViewStyle | ViewStyle[];
  children: React.ReactNode;
  /** Scale factor on press (default 0.97) */
  scaleTo?: number;
  /** If false, haptics will not fire (e.g., for text-only links) */
  haptic?: boolean;
}

const AnimatedPressableBase = Animated.createAnimatedComponent(Pressable);

/** A Pressable that scales down on press and fires haptic feedback. */
export default function AnimatedPressable({
  children,
  style,
  scaleTo = 0.97,
  haptic = true,
  onPress,
  ...props
}: AnimatedPressableProps) {
  const scale = useSharedValue(1);
  const opacity = useSharedValue(1);

  const animStyle = useAnimatedStyle(() => ({
    transform: [{ scale: scale.value }],
    opacity: opacity.value,
  }));

  const handlePressIn = useCallback(() => {
    scale.value = withSpring(scaleTo, { damping: 15, stiffness: 400 });
    opacity.value = withTiming(0.85, { duration: 80 });
  }, [scaleTo]);

  const handlePressOut = useCallback(() => {
    scale.value = withSpring(1, { damping: 15, stiffness: 400 });
    opacity.value = withTiming(1, { duration: 100 });
  }, []);

  const handlePress = useCallback(
    (e: any) => {
      if (haptic) runOnJS(mediumTap)();
      onPress?.(e);
    },
    [haptic, onPress]
  );

  return (
    <AnimatedPressableBase
      onPressIn={handlePressIn}
      onPressOut={handlePressOut}
      onPress={handlePress}
      style={[animStyle, ...(Array.isArray(style) ? style : style ? [style] : [])] as any}
      {...props}
    >
      {children}
    </AnimatedPressableBase>
  );
}
