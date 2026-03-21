// Design system theme and constants for MikroTik Whisperer
// Matches web platform design system with mobile-optimized values

export const Colors = {
  light: {
    primary: '#0EA5E9',
    primaryForeground: '#FFFFFF',
    secondary: '#8B5CF6',
    secondaryForeground: '#FFFFFF',
    accent: '#10B981',
    accentForeground: '#FFFFFF',
    background: '#FFFFFF',
    foreground: '#0F172A',
    card: '#FFFFFF',
    cardForeground: '#0F172A',
    muted: '#F1F5F9',
    mutedForeground: '#64748B',
    border: '#E2E8F0',
    input: '#E2E8F0',
    destructive: '#EF4444',
    destructiveForeground: '#FFFFFF',
    warning: '#F59E0B',
    warningForeground: '#FFFFFF',
    success: '#10B981',
    successForeground: '#FFFFFF',
    info: '#3B82F6',
    infoForeground: '#FFFFFF',
  },
  dark: {
    primary: '#0EA5E9',
    primaryForeground: '#FFFFFF',
    secondary: '#8B5CF6',
    secondaryForeground: '#FFFFFF',
    accent: '#10B981',
    accentForeground: '#FFFFFF',
    background: '#0F172A',
    foreground: '#F1F5F9',
    card: '#1E293B',
    cardForeground: '#F1F5F9',
    muted: '#334155',
    mutedForeground: '#94A3B8',
    border: '#334155',
    input: '#334155',
    destructive: '#EF4444',
    destructiveForeground: '#FFFFFF',
    warning: '#F59E0B',
    warningForeground: '#FFFFFF',
    success: '#10B981',
    successForeground: '#FFFFFF',
    info: '#3B82F6',
    infoForeground: '#FFFFFF',
  },
};

export const Spacing = {
  xs: 4,
  sm: 8,
  md: 16,
  lg: 24,
  xl: 32,
  '2xl': 48,
  '3xl': 64,
};

export const BorderRadius = {
  xs: 4,
  sm: 8,
  md: 12,
  lg: 16,
  xl: 24,
  full: 9999,
};

export const FontSizes = {
  xs: 12,
  sm: 14,
  base: 16,
  lg: 18,
  xl: 20,
  '2xl': 24,
  '3xl': 30,
  '4xl': 36,
};

export const FontWeights = {
  normal: '400' as const,
  medium: '500' as const,
  semibold: '600' as const,
  bold: '700' as const,
};

export const Shadows = {
  sm: {
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 2,
  },
  md: {
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 4,
  },
  lg: {
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 4 },
    shadowOpacity: 0.15,
    shadowRadius: 8,
    elevation: 8,
  },
  xl: {
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 8 },
    shadowOpacity: 0.2,
    shadowRadius: 16,
    elevation: 16,
  },
};

export const AnimationDurations = {
  instant: 100,
  fast: 150,
  normal: 200,
  slow: 300,
  slower: 500,
};

export type ColorScheme = 'light' | 'dark';
export type ThemeColors = typeof Colors.light;
