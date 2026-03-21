export const colors = {
  primary: '#6366f1',
  primaryDark: '#4f46e5',
  primaryLight: '#818cf8',
  background: '#0f172a',
  surface: '#1e293b',
  surface2: '#334155',
  text: '#f8fafc',
  textMuted: '#94a3b8',
  textSecondary: '#cbd5e1',
  success: '#22c55e',
  successBg: '#14532d',
  warning: '#f59e0b',
  warningBg: '#78350f',
  error: '#ef4444',
  errorBg: '#7f1d1d',
  info: '#3b82f6',
  infoBg: '#1e3a5f',
  border: '#334155',
  borderLight: '#475569',
  overlay: 'rgba(0,0,0,0.6)',
} as const;

export const typography = {
  fontSizeXs: 11,
  fontSizeSm: 13,
  fontSizeMd: 15,
  fontSizeLg: 17,
  fontSizeXl: 20,
  fontSize2xl: 24,
  fontSize3xl: 30,
  fontWeightNormal: '400' as const,
  fontWeightMedium: '500' as const,
  fontWeightSemiBold: '600' as const,
  fontWeightBold: '700' as const,
} as const;

export const spacing = {
  xs: 4,
  sm: 8,
  md: 12,
  lg: 16,
  xl: 20,
  xxl: 24,
  xxxl: 32,
} as const;

export const radius = {
  sm: 6,
  md: 10,
  lg: 14,
  xl: 20,
  full: 9999,
} as const;

export const shadows = {
  sm: {
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.3,
    shadowRadius: 3,
    elevation: 2,
  },
  md: {
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.4,
    shadowRadius: 6,
    elevation: 4,
  },
  lg: {
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 4 },
    shadowOpacity: 0.5,
    shadowRadius: 12,
    elevation: 8,
  },
} as const;
