/** Shared design tokens */
export const Colors = {
  // Brand
  primary: "#7c3aed",
  primaryLight: "#8b5cf6",
  primaryFg: "#ffffff",

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
  warning: "#f59e0b",
  warningBg: "rgba(245,158,11,0.1)",
  destructive: "#ef4444",
  destructiveBg: "rgba(239,68,68,0.1)",

  // Sidebar / nav
  sidebar: "#13131f",
  sidebarBorder: "#1e1e2f",
  sidebarFg: "#cbd5e1",

  // Misc
  border: "#2a2a3e",
  ring: "#7c3aed",
  overlay: "rgba(0,0,0,0.5)",
} as const;

export const Fonts = {
  regular: "System",
  mono: "Courier",
} as const;

export const Radius = {
  sm: 6,
  md: 10,
  lg: 14,
  xl: 18,
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
