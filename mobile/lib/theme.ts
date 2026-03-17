/** Shared design tokens — Expo SDK 55, New Architecture, Premium Design System */

export const Colors = {
  // Brand - Enhanced with hover/active states
  primary: "#7c3aed",
  primaryLight: "#8b5cf6",
  primaryDark: "#6d28d9",
  primaryFg: "#ffffff",
  primaryGlow: "rgba(124,58,237,0.3)",
  primaryHover: "#8b5cf6",
  primaryActive: "#6d28d9",

  // Backgrounds - Refined neutrals
  background: "#0f0f1a",
  backgroundElevated: "#13131f",
  card: "#1a1a2e",
  cardBorder: "#2a2a3e",
  muted: "#1e1e30",
  mutedFg: "#6b7280",

  // Text - Enhanced hierarchy
  foreground: "#f1f5f9",
  textPrimary: "#f1f5f9",
  textSecondary: "#94a3b8",
  textTertiary: "#64748b",

  // Status - Semantic colors with states
  success: "#22c55e",
  successBg: "rgba(34,197,94,0.1)",
  successBorder: "rgba(34,197,94,0.25)",
  successHover: "#16a34a",

  warning: "#f59e0b",
  warningBg: "rgba(245,158,11,0.1)",
  warningBorder: "rgba(245,158,11,0.25)",
  warningHover: "#d97706",

  destructive: "#ef4444",
  destructiveBg: "rgba(239,68,68,0.1)",
  destructiveBorder: "rgba(239,68,68,0.3)",
  destructiveHover: "#dc2626",

  info: "#3b82f6",
  infoBg: "rgba(59,130,246,0.1)",
  infoBorder: "rgba(59,130,246,0.25)",
  infoHover: "#2563eb",

  // Nav - Enhanced sidebar
  sidebar: "#13131f",
  sidebarBorder: "#1e1e2f",
  sidebarFg: "#cbd5e1",
  sidebarAccent: "#1e1e30",

  // Misc
  border: "#2a2a3e",
  borderLight: "#333348",
  ring: "#7c3aed",
  overlay: "rgba(0,0,0,0.6)",
  overlayLight: "rgba(0,0,0,0.4)",

  // Gradient stops (used with expo-linear-gradient)
  gradientStart: "#7c3aed",
  gradientEnd: "#6d28d9",
  gradientAccent: "#8b5cf6",
} as const;

export const Fonts = {
  regular: "System",
  medium: "System",
  semibold: "System",
  bold: "System",
  mono: "Courier",
} as const;

export const FontSizes = {
  xs: 11,
  sm: 13,
  base: 15,
  lg: 17,
  xl: 19,
  "2xl": 23,
  "3xl": 27,
  "4xl": 31,
} as const;

export const Radius = {
  xs: 4,
  sm: 6,
  md: 10,
  lg: 14,
  xl: 18,
  "2xl": 24,
  full: 9999,
} as const;

export const Spacing = {
  xs: 4,
  sm: 8,
  md: 12,
  lg: 16,
  xl: 20,
  "2xl": 24,
  "3xl": 32,
  "4xl": 40,
  "5xl": 48,
} as const;

/** Elevation shadows that look good on dark backgrounds — Enhanced system */
export const Shadows = {
  xs: {
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.2,
    shadowRadius: 2,
    elevation: 1,
  },
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
  xl: {
    shadowColor: "#7c3aed",
    shadowOffset: { width: 0, height: 8 },
    shadowOpacity: 0.3,
    shadowRadius: 20,
    elevation: 10,
  },
  "2xl": {
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 12 },
    shadowOpacity: 0.5,
    shadowRadius: 24,
    elevation: 12,
  },
} as const;

/** Animation configurations */
export const Animations = {
  duration: {
    instant: 100,
    fast: 150,
    normal: 200,
    slow: 300,
    slower: 500,
  },
  spring: {
    damping: 15,
    stiffness: 200,
    mass: 1,
  },
  springBounce: {
    damping: 10,
    stiffness: 250,
    mass: 0.8,
  },
} as const;
