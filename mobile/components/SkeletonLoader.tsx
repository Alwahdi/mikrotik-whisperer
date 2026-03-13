import React, { useEffect } from "react";
import { View, StyleSheet, ViewStyle } from "react-native";
import Animated, {
  useSharedValue,
  useAnimatedStyle,
  withRepeat,
  withTiming,
  Easing,
  interpolateColor,
} from "react-native-reanimated";
import { Colors, Radius } from "@/lib/theme";

interface SkeletonProps {
  width?: number | `${number}%`;
  height?: number;
  borderRadius?: number;
  style?: ViewStyle;
}

function SkeletonItem({ width = "100%", height = 16, borderRadius, style }: SkeletonProps) {
  const progress = useSharedValue(0);

  useEffect(() => {
    progress.value = withRepeat(
      withTiming(1, { duration: 1200, easing: Easing.bezier(0.4, 0, 0.6, 1) }),
      -1,
      true
    );
  }, []);

  const animStyle = useAnimatedStyle(() => ({
    backgroundColor: interpolateColor(
      progress.value,
      [0, 1],
      [Colors.muted, Colors.cardBorder]
    ),
  }));

  return (
    <Animated.View
      style={[
        {
          width: width as any,
          height,
          borderRadius: borderRadius ?? Radius.sm,
        },
        animStyle,
        style,
      ]}
    />
  );
}

/** Pre-built skeleton for a stat card row */
export function StatCardSkeleton() {
  return (
    <View style={styles.statCard}>
      <SkeletonItem width="60%" height={10} />
      <SkeletonItem width="40%" height={24} />
      <SkeletonItem width="50%" height={10} />
    </View>
  );
}

/** Pre-built skeleton for a list row */
export function ListRowSkeleton({ lines = 2 }: { lines?: number }) {
  return (
    <View style={styles.listRow}>
      <SkeletonItem width={36} height={36} borderRadius={18} />
      <View style={styles.listRowContent}>
        <SkeletonItem width="60%" height={13} />
        {lines >= 2 && <SkeletonItem width="40%" height={10} />}
        {lines >= 3 && <SkeletonItem width="30%" height={10} />}
      </View>
    </View>
  );
}

/** Generic skeleton block */
export default SkeletonItem;

const styles = StyleSheet.create({
  statCard: {
    backgroundColor: Colors.card,
    borderRadius: Radius.md,
    borderWidth: 1,
    borderColor: Colors.cardBorder,
    padding: 12,
    flex: 1,
    gap: 6,
  },
  listRow: {
    flexDirection: "row",
    alignItems: "center",
    gap: 12,
    backgroundColor: Colors.card,
    borderRadius: Radius.lg,
    borderWidth: 1,
    borderColor: Colors.cardBorder,
    padding: 14,
  },
  listRowContent: {
    flex: 1,
    gap: 6,
  },
});
