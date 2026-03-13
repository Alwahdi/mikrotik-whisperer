/** Shared design tokens — Expo SDK 52, New Architecture */
export const Colors = {
  // Brand
  primary: "#7c3aed",
  primaryLight: "#8b5cf6",
  primaryFg: "#ffffff",
  primaryGlow: "rgba(124,58,237,0.25)",

  // Backgrounds
  background: "#0f0f1a",
  card: "#1a1a2e",
  cardBorder: "#2a2a3e",
  muted: "#1e1e30",
  mutedFg: "#6b7280",

  // Text
  foreground: "#f1f5f9",
  textSecondary: "#94a3b8",

  // Status
  success: "#22c55e",
  successBg: "rgba(34,197,94,0.1)",
  successBorder: "rgba(34,197,94,0.25)",
  warning: "#f59e0b",
  warningBg: "rgba(245,158,11,0.1)",
  warningBorder: "rgba(245,158,11,0.25)",
  destructive: "#ef4444",
  destructiveBg: "rgba(239,68,68,0.1)",
  destructiveBorder: "rgba(239,68,68,0.3)",

  // Nav
  sidebar: "#13131f",
  sidebarBorder: "#1e1e2f",
  sidebarFg: "#cbd5e1",

  // Misc
  border: "#2a2a3e",
  ring: "#7c3aed",
  overlay: "rgba(0,0,0,0.55)",

  // Gradient stops (used with expo-linear-gradient)
  gradientStart: "#7c3aed",
  gradientEnd: "#6d28d9",
} as const;

export const Fonts = {
  regular: "System",
  mono: "Courier",
} as const;

export const Radius = {
  xs: 4,
  sm: 6,
  md: 10,
  lg: 14,
  xl: 18,
  xxl: 24,
  full: 9999,
} as const;

export const Spacing = {
  xs: 4,
  sm: 8,
  md: 12,
  lg: 16,
  xl: 20,
  xxl: 24,
  xxxl: 32,
} as const;

/** Elevation shadows that look good on dark backgrounds */
export const Shadows = {
  sm: {
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.3,
    shadowRadius: 3,
    elevation: 2,
  },
  md: {
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 4 },
    shadowOpacity: 0.35,
    shadowRadius: 8,
    elevation: 5,
  },
  lg: {
    shadowColor: "#7c3aed",
    shadowOffset: { width: 0, height: 6 },
    shadowOpacity: 0.25,
    shadowRadius: 16,
    elevation: 8,
  },
} as const;
