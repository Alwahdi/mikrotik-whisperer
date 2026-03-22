import type { BackgroundPreset, FieldPosition } from "./types";

export const CARD_ASPECT_STANDARD = "1.6";
export const CARD_ASPECT_WIDE = "1.8";

export function defaultFields(): FieldPosition[] {
  return [
    { id: "f1", type: "username", label: "اسم المستخدم", x: 50, y: 55, fontSize: 13, color: "#000000", visible: true },
    { id: "f2", type: "password", label: "كلمة المرور", x: 50, y: 75, fontSize: 13, color: "#000000", visible: true },
    { id: "f3", type: "profile", label: "الباقة", x: 50, y: 90, fontSize: 9, color: "#666666", visible: false },
    { id: "f3b", type: "package_name", label: "اسم الباقة", x: 50, y: 41, fontSize: 10, color: "#334155", visible: false },
    { id: "f4", type: "title", label: "العنوان", x: 50, y: 20, fontSize: 14, color: "#000000", visible: false },
    { id: "f5", type: "subtitle", label: "العنوان الفرعي", x: 50, y: 35, fontSize: 10, color: "#666666", visible: false },
    { id: "f6", type: "price", label: "السعر", x: 85, y: 15, fontSize: 11, color: "#2563EB", visible: false },
    { id: "f7", type: "sales_point", label: "نقطة البيع", x: 18, y: 15, fontSize: 10, color: "#111827", visible: false },
    { id: "f8", type: "qr", label: "QR", x: 84, y: 78, fontSize: 10, color: "#111827", visible: false },
    { id: "f9", type: "days", label: "الصلاحية", x: 18, y: 89, fontSize: 9, color: "#334155", visible: false },
    { id: "f9b", type: "hours", label: "الساعات", x: 50, y: 89, fontSize: 9, color: "#334155", visible: false },
    { id: "f9c", type: "data_quota", label: "البيانات", x: 18, y: 78, fontSize: 9, color: "#334155", visible: false },
    { id: "f10", type: "transfer_limit", label: "حد التحويل", x: 82, y: 89, fontSize: 9, color: "#334155", visible: false },
  ];
}

export const BG_PRESETS: BackgroundPreset[] = [
  {
    id: "aurora",
    name: "Aurora",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='g1' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#0ea5e9'/>
            <stop offset='40%' stop-color='#22c55e'/>
            <stop offset='100%' stop-color='#f59e0b'/>
          </linearGradient>
          <radialGradient id='glow' cx='20%' cy='20%' r='70%'>
            <stop offset='0%' stop-color='rgba(255,255,255,0.55)'/>
            <stop offset='100%' stop-color='rgba(255,255,255,0)'/>
          </radialGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#g1)'/>
        <circle cx='250' cy='130' r='260' fill='url(#glow)'/>
        <circle cx='1000' cy='620' r='330' fill='rgba(255,255,255,0.15)'/>
      </svg>
    `),
  },
  {
    id: "midnight",
    name: "Midnight",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#0b1020'/>
            <stop offset='50%' stop-color='#1e293b'/>
            <stop offset='100%' stop-color='#0f172a'/>
          </linearGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#bg)'/>
        <path d='M0,560 C220,470 340,650 540,570 C720,500 850,390 1200,500 L1200,700 L0,700 Z' fill='rgba(56,189,248,0.24)'/>
        <path d='M0,620 C250,520 450,720 700,610 C860,540 970,490 1200,560 L1200,700 L0,700 Z' fill='rgba(16,185,129,0.2)'/>
      </svg>
    `),
  },
  {
    id: "sunset",
    name: "Sunset",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#fb7185'/>
            <stop offset='45%' stop-color='#f97316'/>
            <stop offset='100%' stop-color='#facc15'/>
          </linearGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#bg)'/>
        <circle cx='940' cy='170' r='110' fill='rgba(255,255,255,0.35)'/>
        <path d='M0,560 C210,430 470,680 760,560 C920,500 1040,470 1200,500 L1200,700 L0,700 Z' fill='rgba(255,255,255,0.18)'/>
      </svg>
    `),
  },
  {
    id: "leaf",
    name: "Leaf",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#14532d'/>
            <stop offset='45%' stop-color='#16a34a'/>
            <stop offset='100%' stop-color='#86efac'/>
          </linearGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#bg)'/>
        <ellipse cx='220' cy='580' rx='300' ry='220' fill='rgba(255,255,255,0.16)'/>
        <ellipse cx='1080' cy='140' rx='260' ry='190' fill='rgba(255,255,255,0.14)'/>
      </svg>
    `),
  },
  {
    id: "hotel-gold",
    name: "Hotel Gold",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#1f2937'/>
            <stop offset='50%' stop-color='#4b5563'/>
            <stop offset='100%' stop-color='#111827'/>
          </linearGradient>
          <linearGradient id='gold' x1='0' y1='0' x2='1' y2='0'>
            <stop offset='0%' stop-color='#fbbf24'/>
            <stop offset='100%' stop-color='#fde68a'/>
          </linearGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#bg)'/>
        <rect x='40' y='40' width='1120' height='620' rx='26' fill='none' stroke='url(#gold)' stroke-width='8' opacity='0.65'/>
        <circle cx='190' cy='120' r='52' fill='none' stroke='url(#gold)' stroke-width='12'/>
        <rect x='240' y='105' width='230' height='30' rx='15' fill='url(#gold)' opacity='0.8'/>
        <path d='M950 180 L1050 180 L1090 230 L1090 500 L910 500 L910 230 Z' fill='rgba(251,191,36,0.14)' stroke='url(#gold)' stroke-width='6'/>
        <circle cx='1000' cy='300' r='26' fill='none' stroke='url(#gold)' stroke-width='8'/>
        <path d='M1000 326 L1000 390' stroke='url(#gold)' stroke-width='8' stroke-linecap='round'/>
        <circle cx='1000' cy='410' r='18' fill='url(#gold)' opacity='0.85'/>
      </svg>
    `),
  },
  {
    id: "hotel-ocean",
    name: "Hotel Ocean",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#082f49'/>
            <stop offset='55%' stop-color='#155e75'/>
            <stop offset='100%' stop-color='#0f766e'/>
          </linearGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#bg)'/>
        <path d='M0 560 C180 470 360 650 540 560 C720 470 880 500 1200 430 L1200 700 L0 700 Z' fill='rgba(255,255,255,0.12)'/>
        <path d='M100 120 H460' stroke='rgba(255,255,255,0.8)' stroke-width='14' stroke-linecap='round'/>
        <path d='M100 165 H340' stroke='rgba(255,255,255,0.45)' stroke-width='10' stroke-linecap='round'/>
        <path d='M950 120 a70 70 0 1 0 0.1 0 M950 190 v120' fill='none' stroke='rgba(255,255,255,0.72)' stroke-width='10' stroke-linecap='round'/>
      </svg>
    `),
  },
  {
    id: "cafe-warm",
    name: "Café Warm",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#fdf6ec'/>
            <stop offset='50%' stop-color='#fef3c7'/>
            <stop offset='100%' stop-color='#fde8c8'/>
          </linearGradient>
          <linearGradient id='accent' x1='0' y1='0' x2='1' y2='0'>
            <stop offset='0%' stop-color='#92400e'/>
            <stop offset='100%' stop-color='#b45309'/>
          </linearGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#bg)'/>
        <rect x='0' y='0' width='1200' height='12' fill='url(#accent)'/>
        <rect x='0' y='688' width='1200' height='12' fill='url(#accent)'/>
        <circle cx='1060' cy='130' r='90' fill='rgba(180,83,9,0.08)'/>
        <circle cx='1100' cy='200' r='50' fill='rgba(180,83,9,0.06)'/>
        <path d='M0 600 C200 540 450 680 700 600 C850 550 980 520 1200 580 L1200 700 L0 700 Z' fill='rgba(180,83,9,0.07)'/>
        <rect x='40' y='40' width='400' height='6' rx='3' fill='url(#accent)' opacity='0.6'/>
        <rect x='40' y='58' width='260' height='4' rx='2' fill='rgba(180,83,9,0.3)'/>
      </svg>
    `),
  },
  {
    id: "corporate-clean",
    name: "Corporate",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='0' y2='1'>
            <stop offset='0%' stop-color='#f8fafc'/>
            <stop offset='100%' stop-color='#e2e8f0'/>
          </linearGradient>
          <linearGradient id='bar' x1='0' y1='0' x2='1' y2='0'>
            <stop offset='0%' stop-color='#1e40af'/>
            <stop offset='100%' stop-color='#3b82f6'/>
          </linearGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#bg)'/>
        <rect x='0' y='0' width='1200' height='18' fill='url(#bar)'/>
        <rect x='0' y='0' width='10' height='700' fill='url(#bar)'/>
        <rect x='0' y='680' width='1200' height='6' fill='url(#bar)' opacity='0.3'/>
        <rect x='40' y='50' width='380' height='8' rx='4' fill='rgba(30,64,175,0.15)'/>
        <rect x='40' y='72' width='240' height='5' rx='2.5' fill='rgba(30,64,175,0.1)'/>
        <circle cx='1080' cy='380' r='160' fill='rgba(59,130,246,0.05)'/>
        <rect x='1050' y='30' width='120' height='120' rx='12' fill='rgba(30,64,175,0.06)'/>
      </svg>
    `),
  },
  {
    id: "neon-dark",
    name: "Neon Dark",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#030712'/>
            <stop offset='50%' stop-color='#0c0f1d'/>
            <stop offset='100%' stop-color='#050816'/>
          </linearGradient>
          <linearGradient id='neon1' x1='0' y1='0' x2='1' y2='0'>
            <stop offset='0%' stop-color='#a855f7'/>
            <stop offset='100%' stop-color='#06b6d4'/>
          </linearGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#bg)'/>
        <rect x='0' y='0' width='1200' height='4' fill='url(#neon1)'/>
        <rect x='0' y='696' width='1200' height='4' fill='url(#neon1)'/>
        <path d='M0 500 C250 420 500 580 750 480 C900 420 1060 450 1200 400 L1200 700 L0 700 Z' fill='rgba(168,85,247,0.08)'/>
        <circle cx='160' cy='120' r='70' fill='none' stroke='rgba(6,182,212,0.25)' stroke-width='2'/>
        <circle cx='160' cy='120' r='40' fill='none' stroke='rgba(168,85,247,0.2)' stroke-width='1.5'/>
        <path d='M1000 80 L1160 80 L1160 200 L1000 200 Z' fill='none' stroke='rgba(6,182,212,0.18)' stroke-width='1.5'/>
        <path d='M40 560 H500' stroke='rgba(168,85,247,0.15)' stroke-width='1' stroke-dasharray='6,4'/>
      </svg>
    `),
  },
  {
    id: "hotel-elegant",
    name: "Hotel Elegant",
    dataUrl: "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1200 700'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#f0f4f8'/>
            <stop offset='60%' stop-color='#e8edf3'/>
            <stop offset='100%' stop-color='#dce5ef'/>
          </linearGradient>
          <linearGradient id='blue' x1='0' y1='0' x2='1' y2='0'>
            <stop offset='0%' stop-color='#64748b'/>
            <stop offset='100%' stop-color='#94a3b8'/>
          </linearGradient>
        </defs>
        <rect width='1200' height='700' fill='url(#bg)'/>
        <rect x='740' y='0' width='460' height='700' fill='rgba(100,116,139,0.06)'/>
        <rect x='0' y='0' width='1200' height='10' fill='url(#blue)'/>
        <rect x='0' y='690' width='1200' height='10' fill='url(#blue)'/>
        <circle cx='820' cy='120' r='60' fill='rgba(148,163,184,0.25)' />
        <rect x='860' y='90' width='200' height='200' rx='18' fill='rgba(148,163,184,0.15)' />
        <rect x='40' y='40' width='320' height='50' rx='10' fill='rgba(100,116,139,0.12)'/>
        <rect x='40' y='105' width='200' height='8' rx='4' fill='rgba(100,116,139,0.2)'/>
        <path d='M40 630 H600' stroke='rgba(100,116,139,0.25)' stroke-width='1.5'/>
        <circle cx='30' cy='640' r='10' fill='rgba(100,116,139,0.3)'/>
        <rect x='50' y='633' width='100' height='8' rx='3' fill='rgba(100,116,139,0.2)'/>
      </svg>
    `),
  },
];

export const DESIGN_THEMES: Array<{
  id: string;
  name: string;
  subtitle: string;
  presetId: string;
  cardTitle: string;
  cardSubtitle: string;
  overrides: Array<Partial<FieldPosition> & { type: FieldPosition["type"] }>;
}> = [
  {
    id: "hotel-luxe",
    name: "فندق فاخر",
    subtitle: "طابع أنيق للنزلاء",
    presetId: "hotel-gold",
    cardTitle: "Hotel Guest Access",
    cardSubtitle: "Premium Internet Service",
    overrides: [
      { type: "title", visible: true, x: 50, y: 16, fontSize: 13, color: "#f8fafc" },
      { type: "subtitle", visible: true, x: 50, y: 27, fontSize: 9, color: "#e2e8f0" },
      { type: "package_name", visible: true, x: 50, y: 40, fontSize: 9, color: "#fde68a" },
      { type: "username", visible: true, x: 44, y: 56, fontSize: 14, color: "#ffffff" },
      { type: "password", visible: true, x: 44, y: 72, fontSize: 14, color: "#ffffff" },
      { type: "price", visible: true, x: 84, y: 16, fontSize: 10, color: "#fde68a" },
      { type: "days", visible: true, x: 16, y: 88, fontSize: 9, color: "#f8fafc" },
      { type: "hours", visible: true, x: 49, y: 88, fontSize: 9, color: "#f8fafc" },
      { type: "data_quota", visible: true, x: 17, y: 77, fontSize: 8, color: "#fde68a" },
      { type: "transfer_limit", visible: true, x: 82, y: 88, fontSize: 9, color: "#f8fafc" },
      { type: "sales_point", visible: false },
      { type: "profile", visible: false },
      { type: "qr", visible: true, x: 88, y: 72, fontSize: 10, color: "#ffffff" },
    ],
  },
  {
    id: "wifi-modern",
    name: "واي فاي حديث",
    subtitle: "تصميم ملون وواضح",
    presetId: "aurora",
    cardTitle: "WiFi Access Card",
    cardSubtitle: "Fast & Secure Connection",
    overrides: [
      { type: "title", visible: true, x: 50, y: 16, fontSize: 13, color: "#0f172a" },
      { type: "subtitle", visible: true, x: 50, y: 28, fontSize: 9, color: "#0f172a" },
      { type: "package_name", visible: true, x: 50, y: 40, fontSize: 9, color: "#0f172a" },
      { type: "username", visible: true, x: 42, y: 56, fontSize: 14, color: "#0f172a" },
      { type: "password", visible: true, x: 42, y: 72, fontSize: 14, color: "#0f172a" },
      { type: "price", visible: true, x: 86, y: 16, fontSize: 10, color: "#1d4ed8" },
      { type: "days", visible: true, x: 18, y: 88, fontSize: 9, color: "#0f172a" },
      { type: "hours", visible: true, x: 50, y: 88, fontSize: 9, color: "#0f172a" },
      { type: "data_quota", visible: true, x: 18, y: 77, fontSize: 8, color: "#0f172a" },
      { type: "transfer_limit", visible: true, x: 84, y: 88, fontSize: 9, color: "#0f172a" },
      { type: "sales_point", visible: true, x: 18, y: 16, fontSize: 8, color: "#1f2937" },
      { type: "profile", visible: true, x: 50, y: 90, fontSize: 9, color: "#0f172a" },
      { type: "qr", visible: true, x: 88, y: 72, fontSize: 10, color: "#111827" },
    ],
  },
  {
    id: "network-pro",
    name: "شبكات احترافي",
    subtitle: "نمط خدمات الشبكات",
    presetId: "leaf",
    cardTitle: "Network Service Voucher",
    cardSubtitle: "Managed Connectivity",
    overrides: [
      { type: "title", visible: true, x: 50, y: 16, fontSize: 13, color: "#ecfeff" },
      { type: "subtitle", visible: true, x: 50, y: 28, fontSize: 9, color: "#dcfce7" },
      { type: "package_name", visible: true, x: 50, y: 40, fontSize: 9, color: "#dcfce7" },
      { type: "username", visible: true, x: 44, y: 56, fontSize: 14, color: "#f8fafc" },
      { type: "password", visible: true, x: 44, y: 72, fontSize: 14, color: "#f8fafc" },
      { type: "price", visible: true, x: 84, y: 16, fontSize: 10, color: "#fef08a" },
      { type: "days", visible: true, x: 16, y: 88, fontSize: 9, color: "#ecfeff" },
      { type: "hours", visible: true, x: 50, y: 88, fontSize: 9, color: "#ecfeff" },
      { type: "data_quota", visible: true, x: 17, y: 77, fontSize: 8, color: "#d1fae5" },
      { type: "transfer_limit", visible: true, x: 82, y: 88, fontSize: 9, color: "#ecfeff" },
      { type: "sales_point", visible: true, x: 18, y: 16, fontSize: 8, color: "#d1fae5" },
      { type: "profile", visible: true, x: 50, y: 90, fontSize: 9, color: "#ecfeff" },
      { type: "qr", visible: true, x: 88, y: 72, fontSize: 10, color: "#ffffff" },
    ],
  },
  {
    id: "cafe-arabic",
    name: "مقهى عربي",
    subtitle: "تصميم دافئ للمقاهي",
    presetId: "cafe-warm",
    cardTitle: "مقهى الإبداع",
    cardSubtitle: "واي فاي مجاني للضيوف",
    overrides: [
      { type: "title", visible: true, x: 50, y: 18, fontSize: 14, color: "#92400e" },
      { type: "subtitle", visible: true, x: 50, y: 30, fontSize: 9, color: "#b45309" },
      { type: "package_name", visible: true, x: 50, y: 42, fontSize: 9, color: "#92400e" },
      { type: "username", visible: true, x: 44, y: 57, fontSize: 14, color: "#1c1917" },
      { type: "password", visible: true, x: 44, y: 73, fontSize: 14, color: "#1c1917" },
      { type: "price", visible: true, x: 85, y: 17, fontSize: 10, color: "#92400e" },
      { type: "days", visible: true, x: 16, y: 88, fontSize: 9, color: "#78350f" },
      { type: "hours", visible: true, x: 50, y: 88, fontSize: 9, color: "#78350f" },
      { type: "data_quota", visible: true, x: 17, y: 78, fontSize: 8, color: "#92400e" },
      { type: "transfer_limit", visible: true, x: 82, y: 88, fontSize: 9, color: "#78350f" },
      { type: "sales_point", visible: true, x: 17, y: 17, fontSize: 9, color: "#78350f" },
      { type: "profile", visible: false },
      { type: "qr", visible: true, x: 88, y: 73, fontSize: 10, color: "#92400e" },
    ],
  },
  {
    id: "corporate-blue",
    name: "شركات احترافي",
    subtitle: "تصميم نظيف للشركات",
    presetId: "corporate-clean",
    cardTitle: "Corporate WiFi",
    cardSubtitle: "Secure Guest Network",
    overrides: [
      { type: "title", visible: true, x: 50, y: 17, fontSize: 13, color: "#1e3a8a" },
      { type: "subtitle", visible: true, x: 50, y: 29, fontSize: 9, color: "#1e40af" },
      { type: "package_name", visible: true, x: 50, y: 41, fontSize: 9, color: "#2563eb" },
      { type: "username", visible: true, x: 44, y: 57, fontSize: 14, color: "#0f172a" },
      { type: "password", visible: true, x: 44, y: 73, fontSize: 14, color: "#0f172a" },
      { type: "price", visible: true, x: 85, y: 17, fontSize: 10, color: "#1e40af" },
      { type: "days", visible: true, x: 16, y: 88, fontSize: 9, color: "#1e3a8a" },
      { type: "hours", visible: true, x: 50, y: 88, fontSize: 9, color: "#1e3a8a" },
      { type: "data_quota", visible: true, x: 17, y: 78, fontSize: 8, color: "#2563eb" },
      { type: "transfer_limit", visible: true, x: 82, y: 88, fontSize: 9, color: "#1e3a8a" },
      { type: "sales_point", visible: true, x: 17, y: 17, fontSize: 8, color: "#475569" },
      { type: "profile", visible: false },
      { type: "qr", visible: true, x: 88, y: 73, fontSize: 10, color: "#1e40af" },
    ],
  },
  {
    id: "neon-gaming",
    name: "جيمنج نيون",
    subtitle: "تصميم مضيء وعصري",
    presetId: "neon-dark",
    cardTitle: "Gaming Zone Access",
    cardSubtitle: "Ultra Fast Internet",
    overrides: [
      { type: "title", visible: true, x: 50, y: 17, fontSize: 13, color: "#e879f9" },
      { type: "subtitle", visible: true, x: 50, y: 29, fontSize: 9, color: "#22d3ee" },
      { type: "package_name", visible: true, x: 50, y: 41, fontSize: 9, color: "#a78bfa" },
      { type: "username", visible: true, x: 44, y: 57, fontSize: 14, color: "#f8fafc" },
      { type: "password", visible: true, x: 44, y: 73, fontSize: 14, color: "#f8fafc" },
      { type: "price", visible: true, x: 85, y: 17, fontSize: 10, color: "#22d3ee" },
      { type: "days", visible: true, x: 16, y: 88, fontSize: 9, color: "#e879f9" },
      { type: "hours", visible: true, x: 50, y: 88, fontSize: 9, color: "#e879f9" },
      { type: "data_quota", visible: true, x: 17, y: 78, fontSize: 8, color: "#22d3ee" },
      { type: "transfer_limit", visible: true, x: 82, y: 88, fontSize: 9, color: "#e879f9" },
      { type: "sales_point", visible: true, x: 17, y: 17, fontSize: 8, color: "#94a3b8" },
      { type: "profile", visible: false },
      { type: "qr", visible: true, x: 88, y: 73, fontSize: 10, color: "#22d3ee" },
    ],
  },
  {
    id: "hotel-light",
    name: "فندق ناصع",
    subtitle: "تصميم أنيق وفاتح",
    presetId: "hotel-elegant",
    cardTitle: "فندق النمر السياحي",
    cardSubtitle: "الاستعلامات: اتصل على ☎",
    overrides: [
      { type: "title", visible: true, x: 35, y: 18, fontSize: 13, color: "#334155" },
      { type: "subtitle", visible: true, x: 35, y: 30, fontSize: 8, color: "#64748b" },
      { type: "package_name", visible: true, x: 35, y: 42, fontSize: 9, color: "#475569" },
      { type: "username", visible: true, x: 34, y: 58, fontSize: 14, color: "#0f172a" },
      { type: "password", visible: true, x: 34, y: 74, fontSize: 14, color: "#0f172a" },
      { type: "price", visible: true, x: 85, y: 18, fontSize: 10, color: "#64748b" },
      { type: "days", visible: true, x: 16, y: 88, fontSize: 9, color: "#475569" },
      { type: "hours", visible: true, x: 50, y: 88, fontSize: 9, color: "#475569" },
      { type: "data_quota", visible: true, x: 17, y: 78, fontSize: 8, color: "#64748b" },
      { type: "transfer_limit", visible: true, x: 82, y: 88, fontSize: 9, color: "#475569" },
      { type: "sales_point", visible: true, x: 17, y: 17, fontSize: 8, color: "#94a3b8" },
      { type: "profile", visible: false },
      { type: "qr", visible: true, x: 88, y: 73, fontSize: 10, color: "#64748b" },
    ],
  },
];
