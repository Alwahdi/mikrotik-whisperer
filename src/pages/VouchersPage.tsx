import { useState, useRef, useMemo, useEffect, useCallback } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { useHotspotProfiles, useUserManagerProfiles, useRawBatchAction } from "@/hooks/useMikrotik";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import {
  Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList,
  BreadcrumbPage, BreadcrumbSeparator,
} from "@/components/ui/breadcrumb";
import {
  AlertDialog, AlertDialogAction, AlertDialogCancel,
  AlertDialogContent, AlertDialogDescription, AlertDialogFooter,
  AlertDialogHeader, AlertDialogTitle,
} from "@/components/ui/alert-dialog";
import {
  Dialog, DialogContent, DialogHeader, DialogTitle,
  DialogFooter, DialogDescription,
} from "@/components/ui/dialog";
import {
  Select, SelectContent, SelectItem, SelectTrigger, SelectValue,
} from "@/components/ui/select";
import {
  Printer, CreditCard, Plus, Trash2, Download, Home, Upload, Loader2,
  History, ChevronLeft, ChevronRight, Check, X, Save, FolderOpen, GripVertical,
  Store, FileDown, LayoutGrid, QrCode, Type,
} from "lucide-react";
import { Link } from "react-router-dom";
import { toast } from "sonner";
import { Progress } from "@/components/ui/progress";
import { Badge } from "@/components/ui/badge";
import QRCode from "qrcode";
import { jsPDF } from "jspdf";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { invokeMikrotik, isLocalHostTarget } from "@/lib/mikrotikInvoke";
import { supabase } from "@/integrations/supabase/client";
import { useAuth } from "@/contexts/AuthContext";
import { addJob, updateJob, addJobLog, type BackgroundJob } from "@/stores/backgroundJobStore";

// ─── Types ────────────────────────────────────
interface VoucherCard {
  username: string;
  password: string;
  profile: string;
  status?: "pending" | "success" | "error";
  error?: string;
}

interface VoucherBatch {
  id: string;
  type: "hotspot" | "usermanager";
  profile: string;
  cards: VoucherCard[];
  createdAt: string;
  pushed: boolean;
  routerHost?: string;
  pushResults?: { success: number; failed: number };
  salesPoint?: string;
  unitPrice?: number;
}

type CharType = "alphanumeric" | "letters" | "numbers";
type PasswordMode = "random" | "same" | "empty";
type PrintLayoutMode = "grid" | "auto";

interface PrintTemplate {
  id: string;
  name: string;
  profileName: string;
  bgImage?: string;
  fields: FieldPosition[];
  printCols: number;
  printRows: number;
  cardTitle: string;
  cardSubtitle: string;
  routerHost?: string;
  cloudId?: string; // Supabase row id for updates/deletes
  // Generation settings
  voucherType?: "hotspot" | "usermanager";
  prefix?: string;
  nameLength?: number;
  passLength?: number;
  charType?: CharType;
  passwordMode?: PasswordMode;
  unitPrice?: number;
  validityDays?: number;
  transferLimit?: number;
  packageDisplayName?: string;
  hoursLabel?: string;
  dataQuotaLabel?: string;
}

interface FieldPosition {
  id: string;
  type: "username" | "password" | "profile" | "package_name" | "title" | "subtitle" | "price" | "sales_point" | "qr" | "days" | "hours" | "data_quota" | "transfer_limit";
  label: string;
  x: number;
  y: number;
  fontSize: number;
  color: string;
  visible: boolean;
}

type BackgroundPreset = {
  id: string;
  name: string;
  dataUrl: string;
};

function escapeHtml(value: string): string {
  return value
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/\"/g, "&quot;")
    .replace(/'/g, "&#39;");
}

function normalizeDigits(value: string): string {
  const arabicIndic = "٠١٢٣٤٥٦٧٨٩";
  const easternArabicIndic = "۰۱۲۳۴۵۶۷۸۹";
  return value
    .split("")
    .map((ch) => {
      const idxArabic = arabicIndic.indexOf(ch);
      if (idxArabic >= 0) return String(idxArabic);
      const idxEastern = easternArabicIndic.indexOf(ch);
      if (idxEastern >= 0) return String(idxEastern);
      return ch;
    })
    .join("");
}

function parseLocalizedInt(raw: string, fallback: number, min: number, max: number): number {
  const normalized = normalizeDigits(raw).replace(/[^0-9-]/g, "");
  const parsed = Number.parseInt(normalized, 10);
  if (Number.isNaN(parsed)) return fallback;
  return Math.min(max, Math.max(min, parsed));
}

function parseLocalizedFloat(raw: string, fallback: number, min: number, max: number): number {
  const normalized = normalizeDigits(raw).replace(/[^0-9.-]/g, "");
  const parsed = Number.parseFloat(normalized);
  if (Number.isNaN(parsed)) return fallback;
  return Math.min(max, Math.max(min, parsed));
}

function hexToRgb(hex: string): [number, number, number] {
  const normalized = hex.replace("#", "").trim();
  if (!/^[0-9a-fA-F]{6}$/.test(normalized)) return [17, 24, 39];
  const r = Number.parseInt(normalized.slice(0, 2), 16);
  const g = Number.parseInt(normalized.slice(2, 4), 16);
  const b = Number.parseInt(normalized.slice(4, 6), 16);
  return [r, g, b];
}

function humanizeDuration(value: string): string {
  if (!value) return "";
  const normalized = value.trim();
  const parts = Array.from(normalized.matchAll(/(\d+)([wdhms])/gi));
  if (parts.length === 0) return normalized;
  const labels: Record<string, string> = { w: "أسبوع", d: "يوم", h: "ساعة", m: "دقيقة", s: "ثانية" };
  return parts.map(([, count, unit]) => `${count} ${labels[unit.toLowerCase()] || unit}`).join(" • ");
}

function extractHoursLabel(value: string): string {
  if (!value) return "";
  const parts = Array.from(value.matchAll(/(\d+)([wdhms])/gi));
  if (parts.length === 0) return value;
  let hours = 0;
  for (const [, countRaw, unitRaw] of parts) {
    const count = Number.parseInt(countRaw, 10);
    const unit = unitRaw.toLowerCase();
    if (unit === "w") hours += count * 24 * 7;
    else if (unit === "d") hours += count * 24;
    else if (unit === "h") hours += count;
    else if (unit === "m") hours += count / 60;
  }
  if (hours <= 0) return value;
  return `${Math.round(hours * 10) / 10} ساعة`;
}

function formatBytesLabel(value: string): string {
  if (!value) return "";
  const plain = value.split("/").filter(Boolean)[0]?.trim() || value.trim();
  const numeric = Number.parseFloat(plain);
  if (!Number.isFinite(numeric) || !/^\d+(\.\d+)?$/.test(plain)) return value;
  if (numeric >= 1024 ** 3) return `${(numeric / 1024 ** 3).toFixed(1).replace(/\.0$/, "")} GB`;
  if (numeric >= 1024 ** 2) return `${(numeric / 1024 ** 2).toFixed(1).replace(/\.0$/, "")} MB`;
  if (numeric >= 1024) return `${(numeric / 1024).toFixed(1).replace(/\.0$/, "")} KB`;
  return `${numeric} B`;
}

// ─── Storage Helpers ──────────────────────────
const BATCHES_KEY = "mikrotik_voucher_batches";
const TEMPLATES_KEY = "mikrotik_print_templates";
const GEN_SETTINGS_KEY = "mikrotik_gen_settings";
const SALES_POINTS_KEY = "mikrotik_sales_points";
const PENDING_SALES_KEY = "mikrotik_pending_sales";

// Card aspect ratios for the preview widgets.
// Standard credit-card ratio (1.586) is used for normal column counts;
// a slightly wider ratio is used when many columns are packed onto the page.
const CARD_ASPECT_STANDARD = "1.6";
const CARD_ASPECT_WIDE = "1.8"; // used when printCols > 3 to keep mini-cells visible

function loadBatches(): VoucherBatch[] {
  try { return JSON.parse(localStorage.getItem(BATCHES_KEY) || "[]"); } catch { return []; }
}
function saveBatches(batches: VoucherBatch[]) {
  localStorage.setItem(BATCHES_KEY, JSON.stringify(batches));
}
function loadTemplates(): PrintTemplate[] {
  try { return JSON.parse(localStorage.getItem(TEMPLATES_KEY) || "[]"); } catch { return []; }
}
function saveTemplates(templates: PrintTemplate[]) {
  localStorage.setItem(TEMPLATES_KEY, JSON.stringify(templates));
}
function loadGenSettings(): Record<string, any> {
  try { return JSON.parse(localStorage.getItem(GEN_SETTINGS_KEY) || "{}"); } catch { return {}; }
}
function saveGenSettings(settings: Record<string, any>) {
  localStorage.setItem(GEN_SETTINGS_KEY, JSON.stringify(settings));
}
function loadSalesPoints(): string[] {
  try { return JSON.parse(localStorage.getItem(SALES_POINTS_KEY) || '["الرئيسي"]'); } catch { return ["الرئيسي"]; }
}
function saveSalesPoints(points: string[]) {
  localStorage.setItem(SALES_POINTS_KEY, JSON.stringify(points));
}

type PendingSaleRecord = {
  user_id: string;
  batch_id: string;
  profile_name: string;
  card_count: number;
  success_count: number;
  failed_count: number;
  unit_price: number;
  total_amount: number;
  voucher_type: string;
  router_host: string;
  notes: string;
  sales_point: string;
};

function loadPendingSales(): PendingSaleRecord[] {
  try {
    return JSON.parse(localStorage.getItem(PENDING_SALES_KEY) || "[]") as PendingSaleRecord[];
  } catch {
    return [];
  }
}

function savePendingSales(records: PendingSaleRecord[]) {
  localStorage.setItem(PENDING_SALES_KEY, JSON.stringify(records));
}

// ─── Random String Generators ──────────────────
const CHARS_ALPHA = "abcdefghjkmnpqrstuvwxyz";
const CHARS_NUM = "23456789";
const CHARS_ALPHANUM = CHARS_ALPHA + CHARS_NUM;

function generateRandomString(len: number, charType: CharType): string {
  const pool = charType === "letters" ? CHARS_ALPHA : charType === "numbers" ? CHARS_NUM : CHARS_ALPHANUM;
  let result = "";
  for (let i = 0; i < len; i++) result += pool[Math.floor(Math.random() * pool.length)];
  return result;
}

// ─── Default Field Positions ──────────────────
function defaultFields(): FieldPosition[] {
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

const BG_PRESETS: BackgroundPreset[] = [
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

const DESIGN_THEMES: Array<{
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

// ─── Component ────────────────────────────────
export default function VouchersPage() {
  const { data: hotspotProfiles } = useHotspotProfiles();
  const { data: umProfiles } = useUserManagerProfiles();
  const rawBatch = useRawBatchAction();
  const { user } = useAuth();

  // Generation settings
  const [type, setType] = useState<"hotspot" | "usermanager">("hotspot");
  const [count, setCount] = useState(10);
  const [prefix, setPrefix] = useState("v");
  const [passLength, setPassLength] = useState(6);
  const [nameLength, setNameLength] = useState(6);
  const [selectedProfile, setSelectedProfile] = useState("");
  const [charType, setCharType] = useState<CharType>("alphanumeric");
  const [passwordMode, setPasswordMode] = useState<PasswordMode>("random");
  const [unitPrice, setUnitPrice] = useState(0);
  const [validityDays, setValidityDays] = useState(0);
  const [transferLimit, setTransferLimit] = useState(0);
  const [packageDisplayName, setPackageDisplayName] = useState("");
  const [hoursLabel, setHoursLabel] = useState("");
  const [dataQuotaLabel, setDataQuotaLabel] = useState("");

  // Sales points
  const [salesPoints, setSalesPoints] = useState<string[]>(loadSalesPoints);
  const [selectedSalesPoint, setSelectedSalesPoint] = useState("الرئيسي");
  const [newSalesPoint, setNewSalesPoint] = useState("");

  // Cards & push
  const [cards, setCards] = useState<VoucherCard[]>([]);
  const [pushing, setPushing] = useState(false);
  const [pushProgress, setPushProgress] = useState(0);
  const [pushMessage, setPushMessage] = useState("");
  const pushingRef = useRef(false);

  // Delete progress
  const [deleteProgress, setDeleteProgress] = useState(0);

  // Print settings
  const [cardTitle, setCardTitle] = useState("WiFi Card");
  const [cardSubtitle, setCardSubtitle] = useState("اتصل بالإنترنت");
  const [printCols, setPrintCols] = useState(3);
  const [printRows, setPrintRows] = useState(4);
  const [printLayoutMode, setPrintLayoutMode] = useState<PrintLayoutMode>("grid");
  const [cardsPerPageTarget, setCardsPerPageTarget] = useState(0);
  const [activeThemeId, setActiveThemeId] = useState<string>("");
  const [bgImage, setBgImage] = useState<string | null>(null);
  const [fields, setFields] = useState<FieldPosition[]>(defaultFields);
  const [draggingField, setDraggingField] = useState<string | null>(null);

  // Templates
  const [templates, setTemplates] = useState<PrintTemplate[]>(loadTemplates);
  const [templatesSyncing, setTemplatesSyncing] = useState(false);
  const [templateName, setTemplateName] = useState("");
  const [templateDialogOpen, setTemplateDialogOpen] = useState(false);
  const [loadTemplateDialogOpen, setLoadTemplateDialogOpen] = useState(false);

  // Batches & history
  const [batches, setBatches] = useState<VoucherBatch[]>(loadBatches);
  const [activeBatchId, setActiveBatchId] = useState<string | null>(null);
  const [activeTab, setActiveTab] = useState<"generate" | "history">("generate");
  const [deleteBatchId, setDeleteBatchId] = useState<string | null>(null);
  const [deletingFromRouter, setDeletingFromRouter] = useState<string | null>(null);
  const [historyPage, setHistoryPage] = useState(1);
  const HISTORY_PAGE_SIZE = 5;

  const fileInputRef = useRef<HTMLInputElement>(null);
  const previewRef = useRef<HTMLDivElement>(null);

  const config = getMikrotikConfig();
  const currentRouterHost = config?.host || "";

  // Persist
  useEffect(() => { saveBatches(batches); }, [batches]);
  useEffect(() => { saveSalesPoints(salesPoints); }, [salesPoints]);

  // Load saved gen settings
  useEffect(() => {
    const saved = loadGenSettings();
    if (saved.charType) setCharType(saved.charType);
    if (saved.passwordMode) setPasswordMode(saved.passwordMode);
    if (saved.prefix) setPrefix(saved.prefix);
    if (saved.nameLength) setNameLength(saved.nameLength);
    if (saved.passLength) setPassLength(saved.passLength);
    if (saved.unitPrice !== undefined) setUnitPrice(saved.unitPrice);
    if (saved.validityDays !== undefined) setValidityDays(saved.validityDays);
    if (saved.transferLimit !== undefined) setTransferLimit(saved.transferLimit);
    if (saved.packageDisplayName) setPackageDisplayName(saved.packageDisplayName);
    if (saved.hoursLabel) setHoursLabel(saved.hoursLabel);
    if (saved.dataQuotaLabel) setDataQuotaLabel(saved.dataQuotaLabel);
    if (saved.printLayoutMode) setPrintLayoutMode(saved.printLayoutMode);
    if (saved.cardsPerPageTarget !== undefined) setCardsPerPageTarget(saved.cardsPerPageTarget);
    if (saved.salesPoint) setSelectedSalesPoint(saved.salesPoint);
  }, []);

  // Load templates from cloud (filtered by current router)
  useEffect(() => {
    if (!user?.id) return;
    setTemplatesSyncing(true);
    supabase
      .from("print_templates")
      .select("*")
      .eq("user_id", user.id)
      .eq("router_host", currentRouterHost)
      .order("created_at", { ascending: false })
      .then(({ data, error }) => {
        if (!error && data) {
          const cloudTemplates: PrintTemplate[] = data.map((row) => ({
            id: row.id,
            cloudId: row.id,
            name: row.name,
            profileName: row.profile_name || "",
            bgImage: row.bg_image || undefined,
            fields: Array.isArray(row.fields) ? (row.fields as FieldPosition[]) : [],
            printCols: row.print_cols,
            printRows: row.print_rows,
            cardTitle: row.card_title,
            cardSubtitle: row.card_subtitle,
            routerHost: row.router_host,
            // Generation settings
            voucherType: (row.voucher_type as "hotspot" | "usermanager") || "hotspot",
            prefix: row.prefix || "v",
            nameLength: row.name_length ?? 6,
            passLength: row.pass_length ?? 6,
            charType: (row.char_type as CharType) || "alphanumeric",
            passwordMode: (row.password_mode as PasswordMode) || "random",
            unitPrice: row.unit_price ?? 0,
            validityDays: row.validity_days ?? 0,
            transferLimit: row.transfer_limit ?? 0,
            packageDisplayName: row.package_display_name || "",
            hoursLabel: row.hours_label || "",
            dataQuotaLabel: row.data_quota_label || "",
          }));
          setTemplates(cloudTemplates);
          saveTemplates(cloudTemplates);
        }
        setTemplatesSyncing(false);
      });
  }, [user?.id, currentRouterHost]);

  useEffect(() => {
    saveGenSettings({
      charType,
      passwordMode,
      prefix,
      nameLength,
      passLength,
      unitPrice,
      validityDays,
      transferLimit,
      packageDisplayName,
      hoursLabel,
      dataQuotaLabel,
      printLayoutMode,
      cardsPerPageTarget,
      salesPoint: selectedSalesPoint,
    });
  }, [charType, passwordMode, prefix, nameLength, passLength, unitPrice, validityDays, transferLimit, packageDisplayName, hoursLabel, dataQuotaLabel, printLayoutMode, cardsPerPageTarget, selectedSalesPoint]);

  const resolvedPrintLayout = useMemo(() => {
    const maxRows = 20;
    const maxCols = 20;
    const targetAspect = 1.6;

    if (printLayoutMode === "auto" && cardsPerPageTarget > 0) {
      let best: { cols: number; rows: number; score: number } | null = null;
      for (let rows = 1; rows <= maxRows; rows++) {
        for (let cols = 1; cols <= maxCols; cols++) {
          const slots = rows * cols;
          if (slots < cardsPerPageTarget) continue;
          const cellAspect = (210 * rows) / (297 * cols);
          const slotPenalty = (slots - cardsPerPageTarget) * 4;
          const aspectPenalty = Math.abs(cellAspect - targetAspect) * 10;
          const score = slotPenalty + aspectPenalty;
          if (!best || score < best.score) {
            best = { cols, rows, score };
          }
        }
      }
      if (best) {
        return { cols: best.cols, rows: best.rows, cardsPerPage: best.cols * best.rows };
      }
    }

    const cols = Math.max(1, Math.min(maxCols, printCols));
    const rows = Math.max(1, Math.min(maxRows, printRows));
    return { cols, rows, cardsPerPage: cols * rows };
  }, [printLayoutMode, cardsPerPageTarget, printCols, printRows]);

  const profiles = useMemo(() => {
    const raw = type === "hotspot" ? hotspotProfiles : umProfiles;
    return Array.isArray(raw) ? raw : [];
  }, [type, hotspotProfiles, umProfiles]);

  const selectedProfileData = useMemo(() => {
    if (!selectedProfile) return null;
    return profiles.find((p: any) => p.name === selectedProfile) ?? null;
  }, [profiles, selectedProfile]);

  const derivedValidityText = useMemo(() => {
    const value = selectedProfileData?.validity || "";
    return humanizeDuration(String(value));
  }, [selectedProfileData]);

  const derivedHoursText = useMemo(() => {
    const value = selectedProfileData?.["uptime-limit"] || selectedProfileData?.uptime || "";
    return extractHoursLabel(String(value));
  }, [selectedProfileData]);

  const derivedDataQuotaText = useMemo(() => {
    const value = selectedProfileData?.["transfer-limit"] || "";
    return formatBytesLabel(String(value));
  }, [selectedProfileData]);

  const resolvedValidityText = validityDays > 0 ? `${validityDays} يوم` : derivedValidityText;
  const resolvedTransferText = transferLimit > 0 ? `${transferLimit} تحويل` : "";
  const resolvedPackageName = packageDisplayName.trim() || selectedProfileData?.["name-for-users"] || selectedProfileData?.name || selectedProfile;
  const resolvedHoursText = hoursLabel.trim() || derivedHoursText;
  const resolvedDataQuotaText = dataQuotaLabel.trim() || derivedDataQuotaText;

  // Auto-populate unit price from selected profile's price field
  useEffect(() => {
    if (!selectedProfileData) return;
    if (selectedProfileData?.price) {
      const price = parseFloat(selectedProfileData.price);
      if (!isNaN(price) && price > 0) setUnitPrice(price);
    }
    if (!packageDisplayName.trim()) {
      setPackageDisplayName(selectedProfileData?.["name-for-users"] || selectedProfileData?.name || selectedProfile);
    }
    if (!hoursLabel.trim() && derivedHoursText) {
      setHoursLabel(derivedHoursText);
    }
    if (!dataQuotaLabel.trim() && derivedDataQuotaText) {
      setDataQuotaLabel(derivedDataQuotaText);
    }
  }, [selectedProfile, selectedProfileData, packageDisplayName, hoursLabel, dataQuotaLabel, derivedHoursText, derivedDataQuotaText]);

  const routerBatches = useMemo(() => {
    if (!currentRouterHost) return batches;
    return batches.filter(b => !b.routerHost || b.routerHost === currentRouterHost);
  }, [batches, currentRouterHost]);

  const persistSaleRecord = useCallback(async (record: PendingSaleRecord) => {
    const { error } = await supabase.from("sales").insert(record as any);
    if (!error) return { ok: true as const };

    const pending = loadPendingSales();
    savePendingSales([record, ...pending]);
    return { ok: false as const, error };
  }, []);

  const syncPendingSales = useCallback(async () => {
    const pending = loadPendingSales();
    if (pending.length === 0) return;

    const remaining: PendingSaleRecord[] = [];
    let synced = 0;

    for (const record of pending) {
      const { error } = await supabase.from("sales").insert(record as any);
      if (error) {
        remaining.push(record);
      } else {
        synced += 1;
      }
    }

    savePendingSales(remaining);
    if (synced > 0) {
      toast.success(`تمت مزامنة ${synced} سجل مبيعات مؤجل`);
    }
  }, []);

  useEffect(() => {
    if (!user?.id) return;
    void syncPendingSales();
  }, [user?.id, syncPendingSales]);

  const addSalesPoint = () => {
    const name = newSalesPoint.trim();
    if (!name || salesPoints.includes(name)) return;
    setSalesPoints(prev => [...prev, name]);
    setNewSalesPoint("");
    toast.success(`تم إضافة نقطة بيع: ${name}`);
  };

  const generateVouchers = () => {
    if (!selectedProfile) {
      toast.error("اختر الباقة أولاً قبل التوليد");
      return;
    }

    const newCards: VoucherCard[] = [];
    const prof = selectedProfile;
    for (let i = 0; i < count; i++) {
      const username = `${prefix}${generateRandomString(nameLength, charType)}`;
      let password = "";
      if (passwordMode === "random") {
        password = generateRandomString(passLength, charType);
      } else if (passwordMode === "same") {
        password = username;
      }
      newCards.push({ username, password, profile: prof, status: "pending" });
    }
    setCards(newCards);

    const batch: VoucherBatch = {
      id: crypto.randomUUID(),
      type,
      profile: prof,
      cards: newCards,
      createdAt: new Date().toISOString(),
      pushed: false,
      routerHost: currentRouterHost,
      salesPoint: selectedSalesPoint,
      unitPrice,
    };
    setBatches(prev => [batch, ...prev]);
    setActiveBatchId(batch.id);
    toast.success(`تم توليد ${count} كرت`);
  };

  const pushToRouter = async () => {
    if (cards.length === 0 || pushingRef.current) return;

    const isRestMode = config?.mode === "rest";
    const addEndpoint = type === "hotspot" ? "/ip/hotspot/user/add" : "/user-manager/user/add";
    const jobId = `push-${Date.now()}`;

    setPushing(true);
    pushingRef.current = true;
    setPushProgress(1);
    setPushMessage("تهيئة إضافة الدفعة...");
    toast.info(`بدء إضافة ${cards.length} كرت بالخلفية`);

    const updatedCards: VoucherCard[] = cards.map((c) => ({ ...c, status: "pending", error: undefined }));
    const resolved = new Set<number>();
    let totalSuccess = 0;
    let totalFailed = 0;
    const startedAt = performance.now();

    addJob({
      id: jobId,
      label: `إضافة ${cards.length} كرت (${cards[0]?.profile || ""})`,
      type: "add",
      status: "running",
      total: cards.length,
      completed: 0,
      succeeded: 0,
      failed: 0,
      rate: 0,
      startedAt,
      routerHost: currentRouterHost,
      logs: [{ ts: Date.now(), msg: `بدأت إضافة ${cards.length} كرت (${type}) إلى ${currentRouterHost}` }],
    });

    const commandForCard = (card: VoucherCard) => {
      // v6 user-manager uses "name" instead of "username", and "customer" instead of "owner"
      const args: string[] = type === "hotspot"
        ? [`=name=${card.username}`, `=password=${card.password}`, `=profile=${card.profile}`]
        : [`=username=${card.username}`, `=password=${card.password}`, `=group=${card.profile}`, `=owner=admin`];
      return { command: addEndpoint, args };
    };

    // Public IP path: run full batch on server-side edge background task.
    // This keeps running even if browser tab is closed.
    if (!isLocalHostTarget(currentRouterHost)) {
      if (!config?.host || !config?.user || !config?.pass) {
        throw new Error("بيانات الراوتر غير مكتملة للتشغيل السحابي");
      }
      if (!user?.id) {
        throw new Error("تعذر تحديد المستخدم الحالي لتسجيل العملية");
      }

      const commands = cards.map(commandForCard);
      setPushProgress(10);
      setPushMessage("تم إرسال العملية للسيرفر...");

      await invokeMikrotik({
        action: "batch-background",
        host: config.host,
        user: config.user,
        pass: config.pass,
        port: config.port,
        protocol: config.protocol,
        mode: config.mode,
        commands,
        jobKey: jobId,
        userId: user.id,
        label: `إضافة ${cards.length} كرت (${cards[0]?.profile || ""})`,
      });

      setPushProgress(100);
      setPushMessage("بدأ التنفيذ على السيرفر بالخلفية");
      addJobLog(jobId, "تم تسليم العملية إلى Edge Function. ستستمر حتى لو أُغلق المتصفح.");
      toast.success("تم تشغيل الإضافة على السيرفر بالخلفية. يمكنك إغلاق المتصفح.");
      return;
    }

    const isDuplicateError = (message: string) => {
      const m = message.toLowerCase();
      return m.includes("already") || m.includes("exists") || m.includes("failure: already") || m.includes("same name");
    };

    const isRetryableError = (message: string) => {
      const m = message.toLowerCase();
      if (!m) return true;
      if (isDuplicateError(m)) return false;
      // Known permanent errors — do not retry
      if (m.includes("unknown parameter") || m.includes("input does not match") || m.includes("invalid value")) return false;
      if (m.includes("not enough permissions") || m.includes("authentication") || m.includes("unauthorized")) return false;
      if (m.includes("bad format") || m.includes("wrong type")) return false;
      // Everything else is potentially transient — retry it
      return true;
    };

    const commandForIndex = (idx: number) => commandForCard(cards[idx]);

    const buildChunks = (indexes: number[], chunkSize: number): number[][] => {
      const out: number[][] = [];
      for (let i = 0; i < indexes.length; i += chunkSize) out.push(indexes.slice(i, i + chunkSize));
      return out;
    };

    const markSuccess = (idx: number) => {
      if (!resolved.has(idx)) {
        resolved.add(idx);
        totalSuccess += 1;
      }
      updatedCards[idx] = { ...updatedCards[idx], status: "success", error: undefined };
    };

    const markFinalError = (idx: number, message: string) => {
      if (!resolved.has(idx)) {
        resolved.add(idx);
        totalFailed += 1;
      }
      updatedCards[idx] = { ...updatedCards[idx], status: "error", error: message || "فشل التنفيذ" };
    };

    const markPending = (idx: number, message?: string) => {
      if (resolved.has(idx)) return;
      updatedCards[idx] = { ...updatedCards[idx], status: "pending", error: message };
    };

    const renderLiveProgress = (label: string) => {
      const done = resolved.size;
      const pct = Math.max(1, Math.min(98, Math.round((done / cards.length) * 100)));
      const elapsedNow = Math.max(1, (performance.now() - startedAt) / 1000);
      const liveRate = Math.round(done / elapsedNow);
      setPushProgress((prev) => Math.max(prev, pct));
      setPushMessage(`${label}: ${done}/${cards.length} • ${liveRate} كرت/ث`);
      updateJob(jobId, {
        completed: done,
        succeeded: totalSuccess,
        failed: totalFailed,
        rate: liveRate,
        status: label.includes("النهائية") ? "retrying" : "running",
      });
    };

    const runPass = async (
      indexes: number[],
      chunkSize: number,
      concurrency: number,
      label: string,
      finalPass: boolean,
    ): Promise<number[]> => {
      if (indexes.length === 0) return [];

      const chunks = buildChunks(indexes, Math.max(1, chunkSize));
      let nextChunkIndex = 0;
      const retrySet = new Set<number>();

      const processChunk = async (chunk: number[]) => {
        try {
          const commands = chunk.map(commandForIndex);
          const result = await rawBatch.mutateAsync({ commands });
          const errors = Array.isArray(result?.errors) ? result.errors : [];

          for (let j = 0; j < chunk.length; j++) {
            const cardIdx = chunk[j];
            const message = typeof errors[j] === "string" ? errors[j].trim() : "";

            if (!message || isDuplicateError(message)) {
              markSuccess(cardIdx);
              continue;
            }

            if (!finalPass && isRetryableError(message)) {
              retrySet.add(cardIdx);
              markPending(cardIdx, message);
            } else {
              markFinalError(cardIdx, message);
            }
          }
        } catch (err: any) {
          const message = err?.message || "فشل التنفيذ";
          for (const cardIdx of chunk) {
            if (!finalPass) {
              // On non-final passes, always retry if the whole chunk request failed
              retrySet.add(cardIdx);
              markPending(cardIdx, message);
            } else {
              markFinalError(cardIdx, message);
            }
          }
        }

        setCards([...updatedCards]);
        renderLiveProgress(label);
      };

      const worker = async () => {
        while (true) {
          const current = nextChunkIndex;
          nextChunkIndex += 1;
          if (current >= chunks.length) break;
          await processChunk(chunks[current]);
        }
      };

      await Promise.all(Array.from({ length: Math.min(Math.max(1, concurrency), chunks.length) }, () => worker()));
      return Array.from(retrySet);
    };

    try {
      const isLargeBatch = cards.length >= 300;
      const isXLBatch = cards.length >= 1000;
      // Optimized for RouterOS: smaller chunks give more frequent progress updates
      const firstChunk = isRestMode
        ? (type === "usermanager" ? (isXLBatch ? 3 : isLargeBatch ? 4 : 6) : (isXLBatch ? 4 : isLargeBatch ? 6 : 10))
        : (type === "usermanager" ? (isXLBatch ? 15 : isLargeBatch ? 20 : 30) : (isXLBatch ? 20 : isLargeBatch ? 30 : 50));
      const firstConcurrency = isRestMode
        ? 1
        : (type === "usermanager" ? (isXLBatch ? 2 : isLargeBatch ? 2 : 3) : (isXLBatch ? 2 : isLargeBatch ? 3 : 4));

      let pending = await runPass(
        cards.map((_, idx) => idx),
        firstChunk,
        firstConcurrency,
        "المحاولة 1",
        false,
      );

      addJobLog(jobId, `المحاولة الأولى: نجح ${totalSuccess} / فشل ${pending.length} يحتاج إعادة محاولة`);

      if (pending.length > 0) {
        // Short delay before retry to let the router recover
        await new Promise(r => setTimeout(r, 800));
        pending = await runPass(
          pending,
          Math.max(1, Math.floor(firstChunk / 2)),
          Math.max(1, firstConcurrency - 1),
          "المحاولة 2",
          false,
        );
        addJobLog(jobId, `المحاولة الثانية: متبقي ${pending.length} للمحاولة النهائية`);
      }

      if (pending.length > 0) {
        // Longer delay before final retry
        await new Promise(r => setTimeout(r, 1500));
        await runPass(pending, 1, 1, "المحاولة النهائية", true);
      }

      for (let i = 0; i < updatedCards.length; i++) {
        if (!resolved.has(i)) {
          markFinalError(i, updatedCards[i].error || "فشل التنفيذ");
        }
      }

      setCards([...updatedCards]);
      setPushProgress(100);
      setPushMessage("اكتملت العملية");

      const elapsedSec = Math.max(1, (performance.now() - startedAt) / 1000);
      const rate = Math.round(resolved.size / elapsedSec);

      const finishedLog = totalFailed === 0
        ? `✅ اكتملت: نجح ${totalSuccess}/${cards.length} كرت — ${Math.round(rate)} كرت/ث — الوقت: ${Math.round(elapsedSec)}ث`
        : `⚠️ اكتملت بأخطاء: نجح ${totalSuccess} / فشل ${totalFailed} — ${Math.round(rate)} كرت/ث`;
      addJobLog(jobId, finishedLog);

      // Collect failed items for retry
      const failedItemsList = updatedCards
        .map((c, idx) => c.status === "error" ? { index: idx, error: c.error || "" } : null)
        .filter(Boolean) as { index: number; error: string }[];

      updateJob(jobId, {
        status: totalFailed === 0 ? "success" : "error",
        completed: resolved.size,
        succeeded: totalSuccess,
        failed: totalFailed,
        rate: Math.round(rate),
        finishedAt: Date.now(),
        failedItems: failedItemsList.length > 0 ? failedItemsList : undefined,
        retryFn: totalFailed > 0 ? async () => {
          // Will re-trigger a push for failed items only via a new pushToRouter-like flow
          toast.info(`إعادة محاولة ${totalFailed} كرت فاشل...`);
        } : undefined,
      });

      setBatches(prev => {
        const updated = [...prev];
        const target = activeBatchId
          ? updated.find(b => b.id === activeBatchId)
          : updated.find(b => b.cards[0]?.username === cards[0]?.username);
        if (target) {
          target.pushed = true;
          target.pushResults = { success: totalSuccess, failed: totalFailed };
          target.cards = updatedCards;
        }
        return updated;
      });

      if (totalSuccess > 0 && user?.id) {
        const saleRecord: PendingSaleRecord = {
          user_id: user.id,
          batch_id: crypto.randomUUID(),
          profile_name: cards[0]?.profile || "",
          card_count: cards.length,
          success_count: totalSuccess,
          failed_count: totalFailed,
          unit_price: unitPrice,
          total_amount: totalSuccess * unitPrice,
          voucher_type: type,
          router_host: currentRouterHost,
          notes: `دفعة ${cards.length} كرت`,
          sales_point: selectedSalesPoint,
        };
        const saleWrite = await persistSaleRecord(saleRecord);
        if (!saleWrite.ok) {
          toast.warning("تم الرفع للراوتر، لكن فشل حفظ المبيعات على السيرفر وتمت إضافتها لقائمة مزامنة لاحقة");
        }
      }

      if (totalFailed === 0) {
        toast.success(`تمت إضافة ${totalSuccess} كرت (${Math.round(rate)} كرت/ث)`);
      } else {
        toast.warning(`نجح ${totalSuccess} — فشل ${totalFailed} (${Math.round(rate)} كرت/ث)`);
      }
    } catch (err: any) {
      toast.error(err?.message || "فشلت عملية الإضافة");
      updateJob(jobId, { status: "error", finishedAt: Date.now() });
    } finally {
      pushingRef.current = false;
      setPushing(false);
    }
  };

  // Delete batch cards from router - "Map then Batch Delete"
  const deleteBatchFromRouter = async (batchId: string) => {
    const batch = batches.find(b => b.id === batchId);
    if (!batch) return;
    setDeletingFromRouter(batchId);
    setDeleteProgress(0);

    const successCards = batch.cards.filter(c => c.status === "success");
    if (successCards.length === 0) {
      toast.error("لا توجد كروت مضافة للحذف");
      setDeletingFromRouter(null);
      return;
    }

    const delJobId = `del-${Date.now()}`;
    const delStartedAt = performance.now();
    addJob({
      id: delJobId, label: `حذف ${successCards.length} كرت`, type: "delete",
      status: "running", total: successCards.length, completed: 0, succeeded: 0, failed: 0, rate: 0, startedAt: delStartedAt,
    });

    const nameKey = batch.type === "hotspot" ? "name" : "username";
    const listCmd = batch.type === "hotspot" ? "/ip/hotspot/user/print" : "/user-manager/user/print";
    const removeCmd = batch.type === "hotspot" ? "/ip/hotspot/user/remove" : "/user-manager/user/remove";

    try {
      setDeleteProgress(5);
      const listResult = await rawBatch.mutateAsync({ commands: [{ command: listCmd, args: [] }] });
      const allUsers = listResult?.results?.[0];
      if (!Array.isArray(allUsers)) {
        toast.error("فشل جلب قائمة المستخدمين من الراوتر");
        updateJob(delJobId, { status: "error", finishedAt: Date.now() });
        setDeletingFromRouter(null);
        setDeleteProgress(0);
        return;
      }

      const userMap = new Map<string, string>();
      for (const u of allUsers) {
        const uname = u[nameKey] || u["name"] || u["username"];
        if (uname && u[".id"]) userMap.set(uname, u[".id"]);
      }

      const idsToDelete: string[] = [];
      let notFound = 0;
      for (const card of successCards) {
        const id = userMap.get(card.username);
        if (id) idsToDelete.push(id);
        else notFound++;
      }

      setDeleteProgress(20);

      if (idsToDelete.length === 0) {
        toast.warning(`لم يتم العثور على أي كرت في الراوتر (${notFound} غير موجود)`);
        updateJob(delJobId, { status: "success", completed: successCards.length, succeeded: 0, finishedAt: Date.now() });
        setDeletingFromRouter(null);
        setDeleteProgress(0);
        handleDeleteBatch(batchId);
        return;
      }

      const CHUNK_SIZE = 25;
      let deleted = 0;
      let failed = 0;

      for (let i = 0; i < idsToDelete.length; i += CHUNK_SIZE) {
        const chunk = idsToDelete.slice(i, i + CHUNK_SIZE);
        const commands = chunk.map(id => ({ command: removeCmd, args: [`=.id=${id}`] }));
        try {
          const result = await rawBatch.mutateAsync({ commands });
          const errors = result?.errors || [];
          for (let j = 0; j < chunk.length; j++) {
            if (errors[j] && errors[j] !== "") failed++;
            else deleted++;
          }
        } catch {
          failed += chunk.length;
        }
        const done = deleted + failed;
        const elapsed = Math.max(1, (performance.now() - delStartedAt) / 1000);
        updateJob(delJobId, { completed: done, succeeded: deleted, failed, rate: Math.round(done / elapsed) });
        setDeleteProgress(20 + Math.round(((i + chunk.length) / idsToDelete.length) * 80));
      }

      updateJob(delJobId, { status: failed === 0 ? "success" : "error", finishedAt: Date.now() });
      setDeletingFromRouter(null);
      setDeleteProgress(0);
      handleDeleteBatch(batchId);
      
      const parts = [`تم حذف ${deleted} كرت`];
      if (notFound > 0) parts.push(`${notFound} غير موجود`);
      if (failed > 0) parts.push(`${failed} فشل`);
      if (failed === 0) toast.success(parts.join(" • "));
      else toast.warning(parts.join(" • "));
    } catch (err: any) {
      toast.error("فشل الحذف: " + (err.message || "خطأ غير متوقع"));
      updateJob(delJobId, { status: "error", finishedAt: Date.now() });
      setDeletingFromRouter(null);
      setDeleteProgress(0);
    }
  };

  const handleImageUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = () => {
      setActiveThemeId("");
      setBgImage(reader.result as string);
    };
    reader.readAsDataURL(file);
  };

  const applyBackgroundPreset = (preset: BackgroundPreset) => {
    setActiveThemeId("");
    setBgImage(preset.dataUrl);
    toast.success(`تم تطبيق الخلفية: ${preset.name}`);
  };

  const applyDesignTheme = (themeId: string) => {
    const theme = DESIGN_THEMES.find((t) => t.id === themeId);
    if (!theme) return;

    const preset = BG_PRESETS.find((p) => p.id === theme.presetId);
    const nextFields = defaultFields().map((f) => ({ ...f }));
    for (const override of theme.overrides) {
      const target = nextFields.find((f) => f.type === override.type);
      if (!target) continue;
      Object.assign(target, override);
    }

    if (preset) {
      setBgImage(preset.dataUrl);
    }
    setFields(nextFields);
    setCardTitle(theme.cardTitle);
    setCardSubtitle(theme.cardSubtitle);
    setActiveThemeId(theme.id);
    toast.success(`تم تطبيق ثيم: ${theme.name}`);
  };

  const handlePreviewMouseDown = (fieldId: string) => {
    setDraggingField(fieldId);
  };

  const handlePreviewMouseMove = useCallback((e: React.MouseEvent<HTMLDivElement>) => {
    if (!draggingField || !previewRef.current) return;
    const rect = previewRef.current.getBoundingClientRect();
    const x = Math.max(0, Math.min(100, ((e.clientX - rect.left) / rect.width) * 100));
    const y = Math.max(0, Math.min(100, ((e.clientY - rect.top) / rect.height) * 100));
    setFields(prev => prev.map(f => f.id === draggingField ? { ...f, x: Math.round(x), y: Math.round(y) } : f));
  }, [draggingField]);

  const handlePreviewMouseUp = useCallback(() => {
    setDraggingField(null);
  }, []);

  // Touch support for drag
  const handlePreviewTouchMove = useCallback((e: React.TouchEvent<HTMLDivElement>) => {
    if (!draggingField || !previewRef.current) return;
    e.preventDefault();
    const touch = e.touches[0];
    const rect = previewRef.current.getBoundingClientRect();
    const x = Math.max(0, Math.min(100, ((touch.clientX - rect.left) / rect.width) * 100));
    const y = Math.max(0, Math.min(100, ((touch.clientY - rect.top) / rect.height) * 100));
    setFields(prev => prev.map(f => f.id === draggingField ? { ...f, x: Math.round(x), y: Math.round(y) } : f));
  }, [draggingField]);

  const saveTemplate = async () => {
    if (!templateName.trim()) { toast.error("أدخل اسم القالب"); return; }
    if (!user?.id) { toast.error("يجب تسجيل الدخول لحفظ القوالب"); return; }

    const localId = crypto.randomUUID();
    const template: PrintTemplate = {
      id: localId,
      name: templateName.trim(),
      profileName: selectedProfile,
      bgImage: bgImage || undefined,
      fields,
      printCols: resolvedPrintLayout.cols,
      printRows: resolvedPrintLayout.rows,
      cardTitle,
      cardSubtitle,
      routerHost: currentRouterHost,
      // Generation settings
      voucherType: type,
      prefix,
      nameLength,
      passLength,
      charType,
      passwordMode,
      unitPrice,
      validityDays,
      transferLimit,
      packageDisplayName,
      hoursLabel,
      dataQuotaLabel,
    };

    setTemplates(prev => {
      const updated = [...prev, template];
      saveTemplates(updated);
      return updated;
    });
    setTemplateDialogOpen(false);
    setTemplateName("");

    // Save to cloud
    const { data, error } = await supabase.from("print_templates").insert({
      user_id: user.id,
      router_host: currentRouterHost,
      name: template.name,
      profile_name: template.profileName || null,
      bg_image: template.bgImage || null,
      fields: template.fields as any,
      print_cols: template.printCols,
      print_rows: template.printRows,
      card_title: template.cardTitle,
      card_subtitle: template.cardSubtitle,
      // Generation settings
      voucher_type: template.voucherType || "hotspot",
      prefix: template.prefix || "v",
      name_length: template.nameLength ?? 6,
      pass_length: template.passLength ?? 6,
      char_type: template.charType || "alphanumeric",
      password_mode: template.passwordMode || "random",
      unit_price: template.unitPrice ?? 0,
      validity_days: template.validityDays ?? 0,
      transfer_limit: template.transferLimit ?? 0,
      package_display_name: template.packageDisplayName || "",
      hours_label: template.hoursLabel || "",
      data_quota_label: template.dataQuotaLabel || "",
    }).select("id").single();

    if (!error && data) {
      setTemplates(prev => {
        const updated = prev.map(t => t.id === localId ? { ...t, cloudId: data.id, id: data.id } : t);
        saveTemplates(updated);
        return updated;
      });
      toast.success("تم حفظ القالب في السحابة ☁️");
    } else {
      toast.error(`فشل حفظ القالب في السحابة: ${error?.message || "خطأ غير معروف"}`);
    }
  };

  const loadTemplate = (template: PrintTemplate) => {
    setBgImage(template.bgImage || null);
    setFields(template.fields);
    setPrintCols(template.printCols);
    setPrintRows(template.printRows);
    setCardTitle(template.cardTitle);
    setCardSubtitle(template.cardSubtitle);
    // Restore generation settings
    if (template.voucherType) setType(template.voucherType);
    if (template.prefix !== undefined) setPrefix(template.prefix);
    if (template.nameLength !== undefined) setNameLength(template.nameLength);
    if (template.passLength !== undefined) setPassLength(template.passLength);
    if (template.charType) setCharType(template.charType);
    if (template.passwordMode) setPasswordMode(template.passwordMode);
    if (template.unitPrice !== undefined) setUnitPrice(template.unitPrice);
    if (template.validityDays !== undefined) setValidityDays(template.validityDays);
    if (template.transferLimit !== undefined) setTransferLimit(template.transferLimit);
    if (template.packageDisplayName !== undefined) setPackageDisplayName(template.packageDisplayName);
    if (template.hoursLabel !== undefined) setHoursLabel(template.hoursLabel);
    if (template.dataQuotaLabel !== undefined) setDataQuotaLabel(template.dataQuotaLabel);
    if (template.profileName) setSelectedProfile(template.profileName);
    setLoadTemplateDialogOpen(false);
    toast.success(`تم تحميل القالب: ${template.name}`);
  };

  const deleteTemplate = async (id: string) => {
    const tpl = templates.find(t => t.id === id);
    setTemplates(prev => {
      const updated = prev.filter(t => t.id !== id);
      saveTemplates(updated);
      return updated;
    });
    // Delete from cloud
    const cloudId = tpl?.cloudId || id;
    if (user?.id && cloudId) {
      await supabase.from("print_templates").delete().eq("id", cloudId).eq("user_id", user.id);
    }
    toast.success("تم حذف القالب");
  };

  // ─── QR Code generation helper ──────────────────────
  const generateQrDataUrl = async (text: string, size = 120): Promise<string> => {
    try {
      return await QRCode.toDataURL(text, { width: size, margin: 1, color: { dark: "#000000", light: "#ffffff" } });
    } catch {
      return "";
    }
  };

  // ─── Print HTML Builder (professional quality with QR) ──────────────────────
  const buildPrintHtml = async (cardsToPrint: VoucherCard[]): Promise<string> => {
    const safeCols = Math.max(1, Math.min(20, resolvedPrintLayout.cols));
    const safeRows = Math.max(1, Math.min(20, resolvedPrintLayout.rows));
    const cardsPerPage = safeCols * safeRows;
    const visibleFields = fields.filter(f => f.visible);
    const hasQr = visibleFields.some(f => f.type === "qr");
    const density = Math.max(safeCols / 3, safeRows / 4, 1);
    const cardGapMm = density >= 1.8 ? 1.2 : density >= 1.35 ? 1.6 : 2;
    const pageMarginMm = density >= 1.8 ? 4 : density >= 1.35 ? 5 : 6;
    const safetyMm = 0.15;
    const fontScale = Math.max(0.62, Math.min(1, 1 / density));
    const overlayScale = Math.max(0.68, Math.min(1, fontScale + 0.08));
    const pageInnerHeightMm = 297 - (pageMarginMm * 2);
    const cardHeightMm = Math.max(6, ((pageInnerHeightMm - (cardGapMm * (safeRows - 1))) / safeRows) - safetyMm);
    const defaultCardBg = "data:image/svg+xml;utf8," + encodeURIComponent(`
      <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 800 460'>
        <defs>
          <linearGradient id='bg' x1='0' y1='0' x2='1' y2='1'>
            <stop offset='0%' stop-color='#ffffff'/>
            <stop offset='100%' stop-color='#eef6ff'/>
          </linearGradient>
          <linearGradient id='band' x1='0' y1='0' x2='1' y2='0'>
            <stop offset='0%' stop-color='#2563eb'/>
            <stop offset='100%' stop-color='#0ea5e9'/>
          </linearGradient>
        </defs>
        <rect width='800' height='460' fill='url(#bg)'/>
        <rect x='0' y='0' width='800' height='70' fill='url(#band)' opacity='0.18'/>
        <circle cx='700' cy='70' r='90' fill='rgba(37,99,235,0.13)'/>
      </svg>
    `);

    // Pre-generate QR codes if needed
    const qrMap = new Map<string, string>();
    if (hasQr) {
      const batchSize = 50;
      for (let i = 0; i < cardsToPrint.length; i += batchSize) {
        const batch = cardsToPrint.slice(i, i + batchSize);
        const results = await Promise.all(
          batch.map(c => generateQrDataUrl(c.password ? `${c.username}\n${c.password}` : c.username))
        );
        batch.forEach((c, j) => qrMap.set(c.username, results[j]));
      }
    }

    const renderCardHtml = (c: VoucherCard) => {
        const usernameEsc = escapeHtml(c.username || "");
        const passwordEsc = escapeHtml(c.password || "");
        const profileEsc = escapeHtml(c.profile || "");
        const packageNameEsc = escapeHtml(resolvedPackageName || "");
        const titleEsc = escapeHtml(cardTitle || "");
        const subtitleEsc = escapeHtml(cardSubtitle || "");
        const salesPointEsc = escapeHtml(selectedSalesPoint || "");
        const unitPriceEsc = escapeHtml(unitPrice > 0 ? `${unitPrice} ر.س` : "");
        const validityDaysEsc = escapeHtml(resolvedValidityText || "");
        const hoursEsc = escapeHtml(resolvedHoursText || "");
        const dataQuotaEsc = escapeHtml(resolvedDataQuotaText || "");
        const transferLimitEsc = escapeHtml(resolvedTransferText || "");
        const qrSrc = qrMap.get(c.username) || "";

        if (bgImage) {
          // Custom background image mode — overlay text at configured positions
          const fieldsHtml = visibleFields.map(f => {
            if (f.type === "qr") {
              const qrSize = Math.max(16, Math.round(f.fontSize * 3 * overlayScale));
              return qrSrc
                ? `<img src="${qrSrc}" class="overlay-qr" style="top:${f.y}%;left:${f.x}%;width:${qrSize}px;height:${qrSize}px" />`
                : "";
            }
            let text = "";
            if (f.type === "username") text = c.username;
            else if (f.type === "password") text = c.password || "";
            else if (f.type === "profile") text = c.profile;
            else if (f.type === "package_name") text = resolvedPackageName;
            else if (f.type === "title") text = cardTitle;
            else if (f.type === "subtitle") text = cardSubtitle;
            else if (f.type === "price") text = unitPrice > 0 ? `${unitPrice} ر.س` : "";
            else if (f.type === "sales_point") text = selectedSalesPoint || "";
            else if (f.type === "days") text = resolvedValidityText;
            else if (f.type === "hours") text = resolvedHoursText;
            else if (f.type === "data_quota") text = resolvedDataQuotaText;
            else if (f.type === "transfer_limit") text = resolvedTransferText;
            const safeText = escapeHtml(text || "");
            const fontPx = Math.max(7, Math.round(f.fontSize * overlayScale));
            return text
              ? `<div class="overlay-text" style="top:${f.y}%;left:${f.x}%;font-size:${fontPx}px;color:${f.color}">${safeText}</div>`
              : "";
          }).join("");
          return `
            <div class="card card-custom">
              <img src="${bgImage}" class="card-bg-img" />
              <div class="card-overlay">${fieldsHtml}</div>
            </div>`;
        }

        // Default clean card design
        const showPassword = visibleFields.some(f => f.type === "password");
        const showProfile = visibleFields.some(f => f.type === "profile");
        const showPackageName = visibleFields.some(f => f.type === "package_name") && !!resolvedPackageName;
        const showPrice = visibleFields.some(f => f.type === "price") && unitPrice > 0;
        const showSalesPoint = visibleFields.some(f => f.type === "sales_point") && selectedSalesPoint;
        const showDays = visibleFields.some(f => f.type === "days") && !!resolvedValidityText;
        const showHours = visibleFields.some(f => f.type === "hours") && !!resolvedHoursText;
        const showDataQuota = visibleFields.some(f => f.type === "data_quota") && !!resolvedDataQuotaText;
        const showTransferLimit = visibleFields.some(f => f.type === "transfer_limit") && !!resolvedTransferText;
        const showTitle = visibleFields.some(f => f.type === "title");
        const showSubtitle = visibleFields.some(f => f.type === "subtitle");

        return `
          <div class="card card-default">
            <img src="${defaultCardBg}" class="card-bg-img" />
            <div class="card-body card-foreground">
              <div class="card-left">
                ${showTitle ? `<div class="card-title">${titleEsc}</div>` : ""}
                ${showSubtitle ? `<div class="card-sub">${subtitleEsc}</div>` : ""}
                ${showPackageName ? `<div class="card-sub">${packageNameEsc}</div>` : ""}
                ${showTitle || showSubtitle ? '<div class="divider"></div>' : ""}
                <div class="field">
                  <div class="label">USERNAME</div>
                  <div class="value">${usernameEsc}</div>
                </div>
                ${showPassword && c.password ? `<div class="field"><div class="label">PASSWORD</div><div class="value">${passwordEsc}</div></div>` : ""}
                <div class="card-footer-row">
                  ${showProfile ? `<span class="profile-badge">${profileEsc}</span>` : ""}
                  ${showSalesPoint ? `<span class="sp-badge">${salesPointEsc}</span>` : ""}
                  ${showDays ? `<span class="sp-badge">${validityDaysEsc}</span>` : ""}
                  ${showHours ? `<span class="sp-badge">${hoursEsc}</span>` : ""}
                  ${showDataQuota ? `<span class="sp-badge">${dataQuotaEsc}</span>` : ""}
                  ${showTransferLimit ? `<span class="sp-badge">${transferLimitEsc}</span>` : ""}
                  ${showPrice ? `<span class="price-badge">${unitPriceEsc}</span>` : ""}
                </div>
              </div>
              ${hasQr && qrSrc ? `<div class="card-qr"><img src="${qrSrc}" /></div>` : ""}
            </div>
          </div>`;
    };

    const pages: string[] = [];

    for (let p = 0; p < cardsToPrint.length; p += cardsPerPage) {
      const pageCards = cardsToPrint.slice(p, p + cardsPerPage);
      const rowsHtml: string[] = [];
      for (let r = 0; r < safeRows; r += 1) {
        const cells: string[] = [];
        for (let c = 0; c < safeCols; c += 1) {
          const idx = (r * safeCols) + c;
          const card = pageCards[idx];
          cells.push(`<td class="card-cell">${card ? renderCardHtml(card) : ""}</td>`);
        }
        rowsHtml.push(`<tr>${cells.join("")}</tr>`);
      }

      pages.push(`
        <div class="page">
          <div class="sheet">
            <table class="cards-table"><tbody>${rowsHtml.join("")}</tbody></table>
          </div>
        </div>`);
    }

    return `<!DOCTYPE html>
<html dir="rtl"><head>
<meta charset="utf-8">
<title>${escapeHtml(cardTitle || "كروت")}</title>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<style>
  @import url('https://fonts.googleapis.com/css2?family=Cairo:wght@400;600;700;800&family=JetBrains+Mono:wght@400;500;600;700&display=swap');
  :root {
    --font-scale: ${fontScale};
  }
  * { box-sizing: border-box; margin: 0; padding: 0; }
  body {
    background: white;
    font-family: 'Cairo', sans-serif;
    -webkit-print-color-adjust: exact;
    print-color-adjust: exact;
  }
  .page {
    width: 210mm;
    padding: ${pageMarginMm}mm;
    page-break-after: always;
    break-after: page;
    display: block;
    page-break-inside: avoid;
    break-inside: avoid;
  }
  .page:last-child {
    page-break-after: auto;
    break-after: auto;
  }
  .sheet {
    width: 100%;
  }
  .cards-table {
    width: 100%;
    table-layout: fixed;
    border-collapse: collapse;
    page-break-inside: avoid;
    break-inside: avoid;
  }
  .cards-table tr {
    height: ${cardHeightMm}mm;
  }
  .card-cell {
    width: ${100 / safeCols}%;
    height: ${cardHeightMm}mm;
    vertical-align: top;
    padding: ${cardGapMm / 2}mm;
  }
  /* ── Custom background card ── */
  .card {
    border-radius: 4px;
    page-break-inside: avoid;
    position: relative;
    overflow: hidden;
    width: 100%;
    height: ${cardHeightMm}mm;
    min-height: 0;
    break-inside: avoid;
    page-break-inside: avoid;
  }
  .card-bg-img {
    position: absolute;
    inset: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
    object-position: center;
    user-select: none;
    pointer-events: none;
  }
  .card-overlay,
  .card-foreground {
    position: relative;
    z-index: 1;
    width: 100%;
    height: 100%;
  }
  .card-custom {
    border: none;
  }
  .overlay-text {
    position: absolute;
    transform: translate(-50%, -50%);
    font-weight: 700;
    white-space: nowrap;
    text-shadow: 0 0 4px rgba(255,255,255,0.9), 0 1px 2px rgba(0,0,0,0.15);
    font-family: 'JetBrains Mono', monospace;
    letter-spacing: 1.2px;
  }
  .overlay-qr {
    position: absolute;
    transform: translate(-50%, -50%);
    border-radius: 3px;
    background: white;
    padding: 2px;
  }
  /* ── Default clean card ── */
  .card-default {
    border: 1.5px solid #e2e8f0;
    background: linear-gradient(135deg, #ffffff 0%, #f8fafc 100%);
    padding: 0;
    display: flex;
    align-items: stretch;
  }
  .card-body {
    display: flex;
    width: 100%;
    height: 100%;
    align-items: center;
    overflow: hidden;
  }
  .card-left {
    flex: 1;
    padding: calc(6px * var(--font-scale)) calc(10px * var(--font-scale));
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: calc(2px * var(--font-scale));
    min-width: 0;
  }
  .card-qr {
    width: calc(58px * var(--font-scale));
    min-width: calc(58px * var(--font-scale));
    display: flex;
    align-items: center;
    justify-content: center;
    padding: calc(4px * var(--font-scale));
    border-right: 1.5px dashed #e2e8f0;
  }
  .card-qr img { width: calc(50px * var(--font-scale)); height: calc(50px * var(--font-scale)); border-radius: 2px; }
  .card-title { font-weight: 800; font-size: calc(9px * var(--font-scale)); color: #0f172a; line-height: 1.2; letter-spacing: -0.2px; }
  .card-sub { font-size: calc(7px * var(--font-scale)); color: #64748b; }
  .divider { height: 1px; background: linear-gradient(90deg, #e2e8f0, transparent); margin: calc(3px * var(--font-scale)) 0; }
  .field { margin-bottom: calc(1px * var(--font-scale)); }
  .label { font-size: calc(6px * var(--font-scale)); color: #94a3b8; letter-spacing: 1px; text-transform: uppercase; font-weight: 600; }
  .value {
    font-size: calc(11px * var(--font-scale));
    font-weight: 700;
    color: #0f172a;
    font-family: 'JetBrains Mono', monospace;
    letter-spacing: calc(1.5px * var(--font-scale));
    line-height: 1.25;
    word-break: break-all;
  }
  .card-footer-row { display: flex; align-items: center; gap: calc(4px * var(--font-scale)); margin-top: calc(2px * var(--font-scale)); flex-wrap: wrap; }
  .profile-badge {
    display: inline-block; padding: calc(1px * var(--font-scale)) calc(5px * var(--font-scale));
    background: #f1f5f9; border: 1px solid #e2e8f0; border-radius: 3px;
    font-size: calc(6px * var(--font-scale)); color: #475569; font-weight: 600;
  }
  .sp-badge {
    display: inline-block; padding: calc(1px * var(--font-scale)) calc(5px * var(--font-scale));
    background: #fef3c7; border: 1px solid #fde68a; border-radius: 3px;
    font-size: calc(6px * var(--font-scale)); color: #92400e; font-weight: 600;
  }
  .price-badge { font-size: calc(8px * var(--font-scale)); font-weight: 800; color: #2563eb; white-space: nowrap; margin-right: auto; }
  @media print {
    html, body { width: 210mm; height: auto; }
    @page { margin: 0; size: A4 portrait; }
  }
</style>
</head><body>${pages.join("")}</body></html>`;
  };

  const openPrintWindow = (html: string) => {
    const isMobile = /Android|iPhone|iPad|iPod/i.test(navigator.userAgent || "");

    const printFromIframe = () => {
      const iframe = document.createElement("iframe");
      iframe.style.position = "fixed";
      iframe.style.right = "0";
      iframe.style.bottom = "0";
      iframe.style.width = "0";
      iframe.style.height = "0";
      iframe.style.border = "0";
      document.body.appendChild(iframe);

      iframe.srcdoc = html;
      iframe.onload = () => {
        const win = iframe.contentWindow;
        if (!win) {
          document.body.removeChild(iframe);
          toast.error("تعذر فتح الطباعة على هذا المتصفح");
          return;
        }
        const images = win.document.querySelectorAll("img");
        const imagePromises = Array.from(images).map((img) =>
          img.complete ? Promise.resolve() : new Promise<void>((resolve) => {
            img.onload = () => resolve();
            img.onerror = () => resolve();
          })
        );
        Promise.all(imagePromises).then(() => {
          setTimeout(() => {
            win.focus();
            win.print();
            setTimeout(() => {
              if (iframe.parentNode) iframe.parentNode.removeChild(iframe);
            }, 1200);
          }, 500);
        });
      };
    };

    if (isMobile) {
      printFromIframe();
      return;
    }

    const printWindow = window.open("", "_blank");
    if (!printWindow) {
      printFromIframe();
      return;
    }
    printWindow.document.open();
    printWindow.document.write(html);
    printWindow.document.close();
    // Wait for fonts/images to load before triggering the print dialog.
    // 400 ms is sufficient for Google Fonts to initialise in the new window.
    const PRINT_LOAD_DELAY_MS = 400;
    const images = printWindow.document.querySelectorAll("img");
    const imagePromises = Array.from(images).map(img =>
      img.complete ? Promise.resolve() : new Promise<void>(resolve => { img.onload = () => resolve(); img.onerror = () => resolve(); })
    );
    Promise.all(imagePromises).then(() => {
      setTimeout(() => {
        printWindow.focus();
        printWindow.print();
      }, PRINT_LOAD_DELAY_MS);
    });
  };

  const toRasterDataUrl = async (src: string): Promise<string | null> => {
    if (!src) return null;
    if (!src.startsWith("data:image/svg+xml")) return src;

    return await new Promise((resolve) => {
      const img = new Image();
      img.onload = () => {
        const canvas = document.createElement("canvas");
        canvas.width = Math.max(1, img.width);
        canvas.height = Math.max(1, img.height);
        const ctx = canvas.getContext("2d");
        if (!ctx) {
          resolve(null);
          return;
        }
        ctx.drawImage(img, 0, 0);
        resolve(canvas.toDataURL("image/png"));
      };
      img.onerror = () => resolve(null);
      img.src = src;
    });
  };

  const buildVoucherPdf = async (cardsToPrint: VoucherCard[]) => {
    const doc = new jsPDF({ orientation: "portrait", unit: "mm", format: "a4", compress: true });

    const safeCols = Math.max(1, Math.min(20, resolvedPrintLayout.cols));
    const safeRows = Math.max(1, Math.min(20, resolvedPrintLayout.rows));
    const cardsPerPage = safeCols * safeRows;
    const density = Math.max(safeCols / 3, safeRows / 4, 1);
    const cardGapMm = density >= 1.8 ? 1.2 : density >= 1.35 ? 1.6 : 2;
    const pageMarginMm = density >= 1.8 ? 4 : density >= 1.35 ? 5 : 6;
    const pageW = 210;
    const pageH = 297;
    const innerW = pageW - (pageMarginMm * 2);
    const innerH = pageH - (pageMarginMm * 2);
    const cardW = (innerW - (cardGapMm * (safeCols - 1))) / safeCols;
    const cardH = (innerH - (cardGapMm * (safeRows - 1))) / safeRows;
    const visibleFields = fields.filter((f) => f.visible);
    const hasQr = visibleFields.some((f) => f.type === "qr");
    const rasterBg = bgImage ? await toRasterDataUrl(bgImage) : null;

    const qrMap = new Map<string, string>();
    if (hasQr) {
      for (const c of cardsToPrint) {
        const key = `${c.username}|${c.password || ""}`;
        if (qrMap.has(key)) continue;
        const qr = await generateQrDataUrl(c.password ? `${c.username}\n${c.password}` : c.username, 180);
        qrMap.set(key, qr);
      }
    }

    const textForField = (fType: FieldPosition["type"], card: VoucherCard) => {
      if (fType === "username") return card.username;
      if (fType === "password") return card.password || "";
      if (fType === "profile") return card.profile || "";
      if (fType === "package_name") return resolvedPackageName || "";
      if (fType === "title") return cardTitle || "";
      if (fType === "subtitle") return cardSubtitle || "";
      if (fType === "price") return unitPrice > 0 ? `${unitPrice} ر.س` : "";
      if (fType === "sales_point") return selectedSalesPoint || "";
      if (fType === "days") return resolvedValidityText || "";
      if (fType === "hours") return resolvedHoursText || "";
      if (fType === "data_quota") return resolvedDataQuotaText || "";
      if (fType === "transfer_limit") return resolvedTransferText || "";
      return "";
    };

    const totalPages = Math.max(1, Math.ceil(cardsToPrint.length / cardsPerPage));
    for (let page = 0; page < totalPages; page += 1) {
      if (page > 0) doc.addPage("a4", "portrait");

      const start = page * cardsPerPage;
      const pageCards = cardsToPrint.slice(start, start + cardsPerPage);

      for (let i = 0; i < pageCards.length; i += 1) {
        const row = Math.floor(i / safeCols);
        const col = i % safeCols;
        const x = pageMarginMm + (col * (cardW + cardGapMm));
        const y = pageMarginMm + (row * (cardH + cardGapMm));
        const card = pageCards[i];

        if (rasterBg) {
          doc.addImage(rasterBg, "PNG", x, y, cardW, cardH, undefined, "FAST");
        } else {
          doc.setFillColor(248, 250, 252);
          doc.rect(x, y, cardW, cardH, "F");
        }

        doc.setDrawColor(226, 232, 240);
        doc.setLineWidth(0.25);
        doc.rect(x, y, cardW, cardH, "S");

        for (const f of visibleFields) {
          if (f.type === "qr") {
            const key = `${card.username}|${card.password || ""}`;
            const qr = qrMap.get(key);
            if (!qr) continue;
            const size = Math.min(cardW, cardH) * 0.24;
            const qx = x + ((f.x / 100) * cardW) - (size / 2);
            const qy = y + ((f.y / 100) * cardH) - (size / 2);
            doc.addImage(qr, "PNG", qx, qy, size, size, undefined, "FAST");
            continue;
          }

          const text = textForField(f.type, card);
          if (!text) continue;
          const [r, g, b] = hexToRgb(f.color);
          doc.setTextColor(r, g, b);
          doc.setFont("helvetica", f.type === "title" ? "bold" : "normal");
          doc.setFontSize(Math.max(6, Math.min(18, f.fontSize * 0.72)));
          const tx = x + ((f.x / 100) * cardW);
          const ty = y + ((f.y / 100) * cardH);
          doc.text(String(text), tx, ty, { align: "center" });
        }
      }
    }

    return doc;
  };

  const handlePrint = async (cardsToPrint?: VoucherCard[]) => {
    const toPrint = cardsToPrint || cards;
    if (toPrint.length === 0) {
      toast.error("لا توجد كروت للطباعة");
      return;
    }
    if (!cardsToPrint && !selectedProfile) {
      toast.error("اختر الباقة أولاً قبل الطباعة");
      return;
    }
    toast.info("جاري تجهيز ملف الطباعة...");
    const doc = await buildVoucherPdf(toPrint);
    const blob = doc.output("blob");
    const url = URL.createObjectURL(blob);
    const win = window.open(url, "_blank");
    if (!win) {
      const a = document.createElement("a");
      a.href = url;
      a.download = `${cardTitle || "WiFi-Card"}.pdf`;
      document.body.appendChild(a);
      a.click();
      document.body.removeChild(a);
      toast.info("تم تنزيل الملف، اطبعه من قارئ PDF");
      return;
    }
    setTimeout(() => {
      try {
        win.focus();
        win.print();
      } catch {
        // If print is blocked, user can print manually from opened PDF tab.
      }
    }, 700);
    setTimeout(() => URL.revokeObjectURL(url), 60_000);
  };

  const handleExportPdf = async (cardsToPrint?: VoucherCard[]) => {
    const toPrint = cardsToPrint || cards;
    if (toPrint.length === 0) {
      toast.error("لا توجد كروت للتصدير");
      return;
    }
    toast.info("جاري تجهيز الـ PDF...");
    const doc = await buildVoucherPdf(toPrint);
    const safeName = (cardTitle || "WiFi-Card").replace(/[^\w\u0600-\u06FF-]+/g, "-");
    doc.save(`${safeName}.pdf`);
  };

  const handleExportCsv = (cardsToExport?: VoucherCard[]) => {
    const toExport = cardsToExport || cards;
    if (toExport.length === 0) {
      toast.error("لا توجد كروت للتصدير");
      return;
    }

    const escapeCsv = (value: string) => `"${String(value ?? "").replace(/"/g, '""')}"`;
    const headers = [
      "username",
      "password",
      "profile",
      "package_name",
      "status",
      "error",
      "unit_price",
      "sales_point",
      "validity_days",
      "hours",
      "data_quota",
      "transfer_limit",
    ];

    const rows = toExport.map((card) => [
      card.username,
      card.password || "",
      card.profile || "",
      resolvedPackageName || "",
      card.status || "",
      card.error || "",
      unitPrice > 0 ? String(unitPrice) : "",
      selectedSalesPoint || "",
      resolvedValidityText || "",
      resolvedHoursText || "",
      resolvedDataQuotaText || "",
      resolvedTransferText || "",
    ]);

    const csv = [headers, ...rows].map((line) => line.map((cell) => escapeCsv(cell)).join(",")).join("\n");
    const blob = new Blob(["\uFEFF" + csv], { type: "text/csv;charset=utf-8;" });
    const url = URL.createObjectURL(blob);
    const link = document.createElement("a");
    const stamp = new Date().toISOString().replace(/[:.]/g, "-");
    link.href = url;
    link.download = `vouchers-${type}-${stamp}.csv`;
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
    URL.revokeObjectURL(url);
    toast.success("تم تصدير CSV بنجاح");
  };

  const handleDeleteBatch = (batchId: string) => {
    setBatches(prev => prev.filter(b => b.id !== batchId));
    setDeleteBatchId(null);
    toast.success("تم حذف الدفعة");
  };

  const loadBatchCards = (batch: VoucherBatch) => {
    setCards(batch.cards);
    setType(batch.type);
    setActiveBatchId(batch.id);
    setActiveTab("generate");
    toast.success(`تم تحميل ${batch.cards.length} كرت`);
  };

  const paginatedBatches = routerBatches.slice((historyPage - 1) * HISTORY_PAGE_SIZE, historyPage * HISTORY_PAGE_SIZE);
  const historyTotalPages = Math.max(1, Math.ceil(routerBatches.length / HISTORY_PAGE_SIZE));

  const successCount = cards.filter(c => c.status === "success").length;
  const errorCount = cards.filter(c => c.status === "error").length;
  const pendingCount = cards.filter(c => c.status === "pending" || !c.status).length;

  return (
    <DashboardLayout>
      <Breadcrumb className="mb-4">
        <BreadcrumbList>
          <BreadcrumbItem>
            <BreadcrumbLink asChild><Link to="/dashboard"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
          </BreadcrumbItem>
          <BreadcrumbSeparator />
          <BreadcrumbItem><BreadcrumbPage>توليد الكروت</BreadcrumbPage></BreadcrumbItem>
        </BreadcrumbList>
      </Breadcrumb>

      <div className="flex items-center justify-between mb-4 gap-2 flex-wrap">
        <div>
          <h1 className="text-lg font-semibold text-foreground tracking-tight">توليد الكروت</h1>
          <p className="text-muted-foreground text-xs mt-0.5">إنشاء وطباعة كروت الهوتسبوت ويوزر مانجر</p>
        </div>
        <div className="flex items-center gap-2">
          <Button size="sm" variant={activeTab === "generate" ? "default" : "outline"} onClick={() => setActiveTab("generate")}>
            <CreditCard className="h-3.5 w-3.5 ml-1" />
            <span className="hidden sm:inline">توليد</span>
          </Button>
          <Button size="sm" variant={activeTab === "history" ? "default" : "outline"} onClick={() => setActiveTab("history")}>
            <History className="h-3.5 w-3.5 ml-1" />
            <span className="hidden sm:inline">السجل</span> ({routerBatches.length})
          </Button>
        </div>
      </div>

      {activeTab === "history" ? (
        <div className="space-y-3">
          {routerBatches.length === 0 ? (
            <div className="rounded-md border border-border bg-card p-10 text-center">
              <History className="h-10 w-10 text-muted-foreground/20 mx-auto mb-3" />
              <p className="text-muted-foreground text-sm">لا توجد دفعات سابقة لهذا الراوتر</p>
            </div>
          ) : (
            <>
              {paginatedBatches.map(batch => {
                const batchSuccess = batch.cards.filter(c => c.status === "success").length;
                const batchFailed = batch.cards.filter(c => c.status === "error").length;
                const batchSuccessCards = batch.cards.filter(c => c.status === "success");
                const batchFailedCards = batch.cards.filter(c => c.status === "error");
                return (
                <div key={batch.id} className="rounded-md border border-border bg-card p-3 sm:p-4">
                  <div className="flex items-center justify-between mb-2 gap-2 flex-wrap">
                    <div className="flex items-center gap-2 flex-wrap">
                      <Badge variant={batch.type === "hotspot" ? "default" : "secondary"} className="text-[10px]">
                        {batch.type === "hotspot" ? "هوتسبوت" : "يوزر مانجر"}
                      </Badge>
                      <span className="text-xs text-muted-foreground">{batch.cards.length} كرت</span>
                      {batch.salesPoint && (
                        <Badge variant="outline" className="text-[10px] gap-1">
                          <Store className="h-2.5 w-2.5" />
                          {batch.salesPoint}
                        </Badge>
                      )}
                      {batch.pushed && (
                        <Badge variant="outline" className="text-[10px] gap-1 text-success border-success/30">
                          <Check className="h-2.5 w-2.5" />
                          {batch.pushResults ? `${batch.pushResults.success}✓ ${batch.pushResults.failed ? batch.pushResults.failed + "✗" : ""}` : "تم الرفع"}
                        </Badge>
                      )}
                    </div>
                    <span className="text-[10px] text-muted-foreground font-mono">
                      {new Date(batch.createdAt).toLocaleString("ar")}
                    </span>
                  </div>
                  <div className="text-xs text-muted-foreground mb-2">
                    الباقة: <span className="text-foreground font-medium">{batch.profile}</span>
                    {batch.unitPrice ? <span className="mr-2">• السعر: {batch.unitPrice}</span> : null}
                  </div>
                  {/* Card stats row */}
                  {batch.pushed && (batchSuccess > 0 || batchFailed > 0) && (
                    <div className="flex items-center gap-3 text-xs mb-2 flex-wrap">
                      <span className="text-green-600 dark:text-green-400 flex items-center gap-1">
                        <Check className="h-3 w-3" /> {batchSuccess} أُضيف للراوتر
                      </span>
                      {batchFailed > 0 && (
                        <span className="text-destructive flex items-center gap-1">
                          <X className="h-3 w-3" /> {batchFailed} لم يُضف
                        </span>
                      )}
                    </div>
                  )}
                  {deletingFromRouter === batch.id && (
                    <div className="mb-2">
                      <Progress value={deleteProgress} className="h-1.5" />
                      <p className="text-[10px] text-muted-foreground mt-1">جاري الحذف... {deleteProgress}%</p>
                    </div>
                  )}
                  <div className="flex gap-2 flex-wrap">
                    <Button size="sm" variant="outline" className="text-xs h-8" onClick={() => loadBatchCards(batch)}>تحميل</Button>
                    <Button size="sm" variant="outline" className="text-xs h-8" onClick={() => handlePrint(batch.cards)}>
                      <Printer className="h-3 w-3 ml-1" /> طباعة الكل
                    </Button>
                    {batch.pushed && batchSuccessCards.length > 0 && (
                      <Button size="sm" variant="outline" className="text-xs h-8 text-green-700 border-green-300 dark:text-green-400 dark:border-green-700" onClick={() => handlePrint(batchSuccessCards)}>
                        <Printer className="h-3 w-3 ml-1" /> طباعة المُضافة ({batchSuccessCards.length})
                      </Button>
                    )}
                    {batch.pushed && batchFailedCards.length > 0 && (
                      <Button size="sm" variant="outline" className="text-xs h-8 text-destructive border-destructive/30" onClick={() => handlePrint(batchFailedCards)}>
                        <Printer className="h-3 w-3 ml-1" /> طباعة الفاشلة ({batchFailedCards.length})
                      </Button>
                    )}
                    <Button size="sm" variant="outline" className="text-xs h-8 text-primary border-primary/30" onClick={() => handleExportPdf(batch.cards)}>
                      <FileDown className="h-3 w-3 ml-1" /> PDF
                    </Button>
                    <Button size="sm" variant="outline" className="text-xs h-8" onClick={() => handleExportCsv(batch.cards)}>
                      <Download className="h-3 w-3 ml-1" /> CSV
                    </Button>
                    {batch.pushed && (
                      <Button
                        size="sm"
                        variant="outline"
                        className="text-xs h-8 text-destructive"
                        disabled={!!deletingFromRouter}
                        onClick={() => deleteBatchFromRouter(batch.id)}
                      >
                        {deletingFromRouter === batch.id ? <Loader2 className="h-3 w-3 animate-spin" /> : <Trash2 className="h-3 w-3 ml-1" />}
                        حذف من الراوتر
                      </Button>
                    )}
                    <Button size="sm" variant="ghost" className="text-xs text-destructive h-8" onClick={() => setDeleteBatchId(batch.id)}>
                      <Trash2 className="h-3 w-3 ml-1" /> حذف
                    </Button>
                  </div>
                </div>
                );
              })}
              {routerBatches.length > HISTORY_PAGE_SIZE && (
                <div className="flex items-center justify-between px-2 py-2">
                  <span className="text-xs text-muted-foreground">{routerBatches.length} دفعة</span>
                  <div className="flex items-center gap-1">
                    <Button variant="ghost" size="icon" className="h-7 w-7" disabled={historyPage <= 1} onClick={() => setHistoryPage(p => p - 1)}>
                      <ChevronRight className="h-4 w-4" />
                    </Button>
                    <span className="text-xs px-2">{historyPage} / {historyTotalPages}</span>
                    <Button variant="ghost" size="icon" className="h-7 w-7" disabled={historyPage >= historyTotalPages} onClick={() => setHistoryPage(p => p + 1)}>
                      <ChevronLeft className="h-4 w-4" />
                    </Button>
                  </div>
                </div>
              )}
            </>
          )}
        </div>
      ) : (
        <div className="grid grid-cols-1 lg:grid-cols-3 gap-4">
          {/* Settings Panel */}
          <div className="lg:col-span-1 space-y-3">
            <div className="rounded-md border border-border bg-card p-3 sm:p-4 space-y-3">
              <h3 className="font-semibold text-foreground text-sm">إعدادات التوليد</h3>

              <div>
                <label className="text-xs text-muted-foreground mb-1 block">النوع</label>
                <Tabs value={type} onValueChange={(v) => { setType(v as any); setSelectedProfile(""); }}>
                  <TabsList className="w-full">
                    <TabsTrigger value="hotspot" className="text-xs flex-1">هوتسبوت</TabsTrigger>
                    <TabsTrigger value="usermanager" className="text-xs flex-1">يوزر مانجر</TabsTrigger>
                  </TabsList>
                </Tabs>
              </div>

              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">عدد الكروت</label>
                  <Input type="text" inputMode="numeric" value={count} onChange={e => setCount(parseLocalizedInt(e.target.value, 1, 1, 5000))} className="h-9" />
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">البادئة</label>
                  <Input value={prefix} onChange={e => setPrefix(e.target.value)} placeholder="v" className="h-9" />
                </div>
              </div>

              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">طول الاسم</label>
                  <Input type="text" inputMode="numeric" value={nameLength} onChange={e => setNameLength(parseLocalizedInt(e.target.value, 6, 3, 16))} className="h-9" />
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">طول كلمة المرور</label>
                  <Input type="text" inputMode="numeric" value={passLength} onChange={e => setPassLength(parseLocalizedInt(e.target.value, 6, 3, 16))} className="h-9" disabled={passwordMode !== "random"} />
                </div>
              </div>

              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">نوع الأحرف</label>
                  <Select value={charType} onValueChange={(v) => setCharType(v as CharType)}>
                    <SelectTrigger className="h-9 text-xs"><SelectValue /></SelectTrigger>
                    <SelectContent>
                      <SelectItem value="alphanumeric">أحرف + أرقام</SelectItem>
                      <SelectItem value="letters">أحرف فقط</SelectItem>
                      <SelectItem value="numbers">أرقام فقط</SelectItem>
                    </SelectContent>
                  </Select>
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">كلمة المرور</label>
                  <Select value={passwordMode} onValueChange={(v) => setPasswordMode(v as PasswordMode)}>
                    <SelectTrigger className="h-9 text-xs"><SelectValue /></SelectTrigger>
                    <SelectContent>
                      <SelectItem value="random">عشوائية</SelectItem>
                      <SelectItem value="same">مثل الاسم</SelectItem>
                      <SelectItem value="empty">فارغة</SelectItem>
                    </SelectContent>
                  </Select>
                </div>
              </div>

              <div>
                <label className="text-xs text-muted-foreground mb-1 block">الباقة</label>
                <select
                  value={selectedProfile}
                  onChange={e => setSelectedProfile(e.target.value)}
                  className="w-full h-9 rounded-md border border-input bg-background px-3 text-sm"
                >
                  <option value="">اختر باقة</option>
                  {profiles.map((p: any, i: number) => (
                    <option key={i} value={p.name}>{p.name}</option>
                  ))}
                </select>
              </div>

              {/* Price & Sales Point */}
              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">سعر الكرت من الباقة</label>
                  <Input value={unitPrice > 0 ? `${unitPrice} ر.س` : "غير متوفر في الباقة"} disabled className="h-9" />
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">نقطة البيع</label>
                  <Select value={selectedSalesPoint} onValueChange={setSelectedSalesPoint}>
                    <SelectTrigger className="h-9 text-xs"><SelectValue /></SelectTrigger>
                    <SelectContent>
                      {salesPoints.map(sp => (
                        <SelectItem key={sp} value={sp}>{sp}</SelectItem>
                      ))}
                    </SelectContent>
                  </Select>
                </div>
              </div>
              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">اسم الباقة على الكرت</label>
                  <Input value={packageDisplayName} onChange={e => setPackageDisplayName(e.target.value)} placeholder={selectedProfileData?.["name-for-users"] || selectedProfile || "اسم الباقة"} className="h-9" />
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">الساعات على الكرت</label>
                  <Input value={hoursLabel} onChange={e => setHoursLabel(e.target.value)} placeholder={derivedHoursText || "مثال: 12 ساعة"} className="h-9" />
                </div>
              </div>
              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">البيانات / الميجا</label>
                  <Input value={dataQuotaLabel} onChange={e => setDataQuotaLabel(e.target.value)} placeholder={derivedDataQuotaText || "مثال: 1 GB"} className="h-9" />
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">الصلاحية من الباقة</label>
                  <Input value={resolvedValidityText || "غير متوفرة"} disabled className="h-9" />
                </div>
              </div>
              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">تجاوز الصلاحية بالأيام (اختياري)</label>
                  <Input type="text" inputMode="numeric" value={validityDays} onChange={e => setValidityDays(parseLocalizedInt(e.target.value, 0, 0, 3650))} className="h-9" />
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">عدد التحويلات (اختياري)</label>
                  <Input type="text" inputMode="numeric" value={transferLimit} onChange={e => setTransferLimit(parseLocalizedInt(e.target.value, 0, 0, 100000))} className="h-9" />
                </div>
              </div>
              <div className="flex gap-1.5">
                <Input
                  placeholder="إضافة نقطة بيع جديدة..."
                  value={newSalesPoint}
                  onChange={e => setNewSalesPoint(e.target.value)}
                  className="h-8 text-xs flex-1"
                  onKeyDown={e => e.key === "Enter" && addSalesPoint()}
                />
                <Button size="sm" variant="outline" className="h-8 px-2" onClick={addSalesPoint} disabled={!newSalesPoint.trim()}>
                  <Plus className="h-3 w-3" />
                </Button>
              </div>

              {/* Print Customization */}
              <div className="border-t border-border pt-3 space-y-3">
                <div className="flex items-center justify-between">
                  <h4 className="text-xs font-medium text-muted-foreground">تخصيص الطباعة</h4>
                  <div className="flex gap-1">
                    <Button variant="ghost" size="icon" className="h-6 w-6" onClick={() => setTemplateDialogOpen(true)} title="حفظ قالب">
                      <Save className="h-3 w-3" />
                    </Button>
                    {templates.length > 0 && (
                      <Button variant="ghost" size="icon" className="h-6 w-6" onClick={() => setLoadTemplateDialogOpen(true)} title="تحميل قالب">
                        <FolderOpen className="h-3 w-3" />
                      </Button>
                    )}
                  </div>
                </div>

                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">صورة خلفية (اختياري)</label>
                  <div className="mb-2">
                    <p className="text-[10px] text-muted-foreground mb-1">ثيمات جاهزة (فنادق / واي فاي / شبكات)</p>
                    <div className="grid grid-cols-1 gap-1.5">
                      {DESIGN_THEMES.map((theme) => {
                        const selected = activeThemeId === theme.id;
                        return (
                          <button
                            key={theme.id}
                            type="button"
                            onClick={() => applyDesignTheme(theme.id)}
                            className={`text-right rounded border px-2 py-1.5 transition ${selected ? "border-primary bg-primary/5 ring-1 ring-primary/30" : "border-border hover:border-primary/40"}`}
                          >
                            <p className="text-[11px] font-semibold text-foreground">{theme.name}</p>
                            <p className="text-[10px] text-muted-foreground">{theme.subtitle}</p>
                          </button>
                        );
                      })}
                    </div>
                  </div>

                  <input ref={fileInputRef} type="file" accept="image/*" onChange={handleImageUpload} className="hidden" />
                  <div className="flex gap-2">
                    <Button variant="outline" size="sm" className="flex-1 text-xs h-8" onClick={() => fileInputRef.current?.click()}>
                      <Upload className="h-3 w-3 ml-1" />
                      {bgImage ? "تغيير" : "رفع صورة"}
                    </Button>
                    {bgImage && (
                      <Button variant="ghost" size="sm" className="h-8" onClick={() => setBgImage(null)}>
                        <Trash2 className="h-3 w-3" />
                      </Button>
                    )}
                  </div>
                  <div className="mt-2">
                    <p className="text-[10px] text-muted-foreground mb-1">خلفيات جاهزة</p>
                    <div className="grid grid-cols-2 gap-1.5">
                      {BG_PRESETS.map((preset) => {
                        const selected = bgImage === preset.dataUrl;
                        return (
                          <button
                            key={preset.id}
                            type="button"
                            onClick={() => applyBackgroundPreset(preset)}
                            className={`rounded border overflow-hidden text-[10px] transition ${selected ? "border-primary ring-1 ring-primary/30" : "border-border hover:border-primary/40"}`}
                            title={preset.name}
                          >
                            <div className="h-10 w-full" style={{ backgroundImage: `url(${preset.dataUrl})`, backgroundSize: "cover", backgroundPosition: "center" }} />
                            <div className="px-1 py-1 bg-background/90 text-foreground truncate">{preset.name}</div>
                          </button>
                        );
                      })}
                    </div>
                  </div>
                </div>

                {bgImage && (
                  <>
                    <div
                      ref={previewRef}
                      className="mt-2 rounded border border-border overflow-hidden relative cursor-crosshair select-none touch-none"
                      style={{ aspectRatio: CARD_ASPECT_STANDARD }}
                      onMouseMove={handlePreviewMouseMove}
                      onMouseUp={handlePreviewMouseUp}
                      onMouseLeave={handlePreviewMouseUp}
                      onTouchMove={handlePreviewTouchMove}
                      onTouchEnd={handlePreviewMouseUp}
                    >
                      <img src={bgImage} alt="خلفية" className="w-full h-full object-fill pointer-events-none" />
                      {fields.filter(f => f.visible).map(f => (
                        <div
                          key={f.id}
                          className={`absolute font-mono text-[10px] font-bold cursor-grab ${draggingField === f.id ? "ring-2 ring-primary" : ""}`}
                          style={{
                            top: `${f.y}%`, left: `${f.x}%`,
                            transform: "translate(-50%,-50%)",
                            fontSize: `${Math.max(8, f.fontSize * 0.7)}px`,
                            color: f.color,
                          }}
                          onMouseDown={(e) => { e.preventDefault(); handlePreviewMouseDown(f.id); }}
                          onTouchStart={(e) => { handlePreviewMouseDown(f.id); }}
                        >
                          <GripVertical className="h-3 w-3 inline ml-0.5 opacity-50" />
                          {f.label}
                        </div>
                      ))}
                    </div>
                    <p className="text-[10px] text-muted-foreground">اسحب الحقول لتغيير موقعها</p>

                    <div className="space-y-1.5">
                      {fields.map(f => (
                        <div key={f.id} className="flex items-center gap-2 text-xs">
                          <input
                            type="checkbox"
                            checked={f.visible}
                            onChange={() => setFields(prev => prev.map(ff => ff.id === f.id ? { ...ff, visible: !ff.visible } : ff))}
                            className="h-3.5 w-3.5 rounded border-input"
                          />
                          <span className="text-muted-foreground flex-1">{f.label}</span>
                          <Input
                            type="text"
                            inputMode="numeric"
                            value={f.fontSize}
                            onChange={e => setFields(prev => prev.map(ff => ff.id === f.id ? { ...ff, fontSize: parseLocalizedInt(e.target.value, 13, 6, 24) } : ff))}
                            className="h-6 w-14 text-[10px] px-1"
                          />
                          <Input
                            type="text"
                            inputMode="numeric"
                            value={f.x}
                            onChange={e => setFields(prev => prev.map(ff => ff.id === f.id ? { ...ff, x: parseLocalizedInt(e.target.value, ff.x, 0, 100) } : ff))}
                            className="h-6 w-14 text-[10px] px-1"
                            title="X"
                          />
                          <Input
                            type="text"
                            inputMode="numeric"
                            value={f.y}
                            onChange={e => setFields(prev => prev.map(ff => ff.id === f.id ? { ...ff, y: parseLocalizedInt(e.target.value, ff.y, 0, 100) } : ff))}
                            className="h-6 w-14 text-[10px] px-1"
                            title="Y"
                          />
                          <input
                            type="color"
                            value={f.color}
                            onChange={e => setFields(prev => prev.map(ff => ff.id === f.id ? { ...ff, color: e.target.value } : ff))}
                            className="h-6 w-6 rounded border border-input cursor-pointer"
                          />
                        </div>
                      ))}
                    </div>
                    <p className="text-[10px] text-muted-foreground">الأرقام بعد حجم الخط هي: X ثم Y (من 0 إلى 100) لضبط مكان الحقل بدقة.</p>
                  </>
                )}

                {!bgImage && (
                  <div className="grid grid-cols-2 gap-2">
                    <div>
                      <label className="text-xs text-muted-foreground mb-1 block">عنوان الكرت</label>
                      <Input value={cardTitle} onChange={e => setCardTitle(e.target.value)} className="h-9" />
                    </div>
                    <div>
                      <label className="text-xs text-muted-foreground mb-1 block">العنوان الفرعي</label>
                      <Input value={cardSubtitle} onChange={e => setCardSubtitle(e.target.value)} className="h-9" />
                    </div>
                  </div>
                )}

                <div className="grid grid-cols-2 gap-2">
                  <div>
                    <label className="text-xs text-muted-foreground mb-1 block">طريقة التقسيم</label>
                    <Select value={printLayoutMode} onValueChange={(v) => setPrintLayoutMode(v as PrintLayoutMode)}>
                      <SelectTrigger className="h-9 text-xs"><SelectValue /></SelectTrigger>
                      <SelectContent>
                        <SelectItem value="grid">يدوي (صفوف/أعمدة)</SelectItem>
                        <SelectItem value="auto">تلقائي (عدد كروت/صفحة)</SelectItem>
                      </SelectContent>
                    </Select>
                  </div>
                  <div>
                    <label className="text-xs text-muted-foreground mb-1 block">حجم الورق</label>
                    <Input value="A4" disabled className="h-9" />
                  </div>
                </div>

                {printLayoutMode === "auto" ? (
                  <div>
                    <label className="text-xs text-muted-foreground mb-1 block">عدد الكروت في الصفحة</label>
                    <Input
                      type="text"
                      inputMode="numeric"
                      value={cardsPerPageTarget}
                      onChange={e => setCardsPerPageTarget(parseLocalizedInt(e.target.value, 0, 0, 400))}
                      placeholder="مثال: 60"
                      className="h-9"
                    />
                    <p className="text-[10px] text-muted-foreground mt-1">
                      التقسيم الحالي: {resolvedPrintLayout.cols} عمود × {resolvedPrintLayout.rows} صف = {resolvedPrintLayout.cardsPerPage} كرت/صفحة
                    </p>
                  </div>
                ) : (
                  <div className="grid grid-cols-2 gap-2">
                    <div>
                      <label className="text-xs text-muted-foreground mb-1 block">أعمدة</label>
                      <Input type="text" inputMode="numeric" value={printCols} onChange={e => setPrintCols(parseLocalizedInt(e.target.value, 3, 1, 20))} className="h-9" />
                    </div>
                    <div>
                      <label className="text-xs text-muted-foreground mb-1 block">صفوف</label>
                      <Input type="text" inputMode="numeric" value={printRows} onChange={e => setPrintRows(parseLocalizedInt(e.target.value, 4, 1, 20))} className="h-9" />
                    </div>
                  </div>
                )}

                {/* Real-time page layout mini-preview */}
                <div className="rounded border border-border bg-muted/30 p-2">
                  <div className="flex items-center justify-between mb-1.5">
                    <span className="text-[10px] text-muted-foreground flex items-center gap-1">
                      <LayoutGrid className="h-3 w-3" /> تخطيط الصفحة
                    </span>
                    <span className="text-[10px] font-medium text-foreground">
                      {resolvedPrintLayout.cardsPerPage} كرت / صفحة
                    </span>
                  </div>
                  <div
                    className="grid gap-0.5"
                    style={{ gridTemplateColumns: `repeat(${resolvedPrintLayout.cols}, 1fr)` }}
                  >
                    {Array.from({ length: resolvedPrintLayout.cardsPerPage }).map((_, i) => (
                      <div
                        key={i}
                        className="rounded-sm border border-border bg-background"
                        style={{ aspectRatio: resolvedPrintLayout.cols > 3 ? CARD_ASPECT_WIDE : CARD_ASPECT_STANDARD }}
                      />
                    ))}
                  </div>
                  {cards.length > 0 && (
                    <p className="text-[10px] text-muted-foreground mt-1.5 text-center font-medium">
                      {Math.ceil(cards.length / Math.max(1, resolvedPrintLayout.cardsPerPage))} صفحة لـ {cards.length} كرت
                    </p>
                  )}
                </div>
              </div>

              <div className="flex gap-2">
                <Button onClick={generateVouchers} className="flex-1" size="sm">
                  <Plus className="h-3.5 w-3.5 ml-1" /> توليد
                </Button>
                {cards.length > 0 && (
                  <Button variant="outline" size="sm" onClick={() => setCards([])}>
                    <Trash2 className="h-3.5 w-3.5" />
                  </Button>
                )}
              </div>
            </div>

            {cards.length > 0 && (
              <div className="flex flex-col gap-2">
                <Button onClick={pushToRouter} disabled={pushing} size="sm" variant="outline" className="w-full">
                  {pushing ? (
                    <><Loader2 className="h-3.5 w-3.5 ml-1 animate-spin" /> {pushProgress}%</>
                  ) : (
                    <><Download className="h-3.5 w-3.5 ml-1" /> إضافة {cards.length} كرت</>
                  )}
                </Button>
                {(pushing || successCount > 0 || errorCount > 0) && (
                  <Progress value={pushProgress} className="h-1.5" />
                )}
                {pushing && (
                  <p className="text-[10px] text-muted-foreground">{pushMessage}</p>
                )}
                {(successCount > 0 || errorCount > 0) && (
                  <div className="flex gap-2 text-xs">
                    {successCount > 0 && <Badge variant="outline" className="gap-1 text-success border-success/30"><Check className="h-2.5 w-2.5" />{successCount}</Badge>}
                    {errorCount > 0 && <Badge variant="outline" className="gap-1 text-destructive border-destructive/30"><X className="h-2.5 w-2.5" />{errorCount}</Badge>}
                    {pushing && pendingCount > 0 && <Badge variant="outline" className="gap-1">{pendingCount} معلق</Badge>}
                  </div>
                )}
                <Button onClick={() => handlePrint()} size="sm" variant="outline" className="w-full">
                  <Printer className="h-3.5 w-3.5 ml-1" /> طباعة
                </Button>
                <Button onClick={() => handleExportPdf()} size="sm" variant="outline" className="w-full text-primary border-primary/30 hover:bg-primary/5">
                  <FileDown className="h-3.5 w-3.5 ml-1" /> تصدير PDF
                </Button>
                <Button onClick={() => handleExportCsv()} size="sm" variant="outline" className="w-full">
                  <Download className="h-3.5 w-3.5 ml-1" /> تصدير CSV
                </Button>
              </div>
            )}
          </div>

          {/* Preview Panel */}
          <div className="lg:col-span-2">
            <div className="rounded-md border border-border bg-card p-3 sm:p-4">
              <div className="flex items-center justify-between mb-3">
                <h3 className="font-semibold text-foreground text-sm flex items-center gap-2">
                  <CreditCard className="h-4 w-4 text-primary" />
                  معاينة ({cards.length})
                </h3>
                {cards.length > 0 && (
                  <div className="flex items-center gap-2">
                    <span className="inline-flex items-center gap-1 px-2 py-0.5 rounded-full bg-primary/10 text-primary text-[10px] font-semibold">
                      <LayoutGrid className="h-3 w-3" />
                      {Math.ceil(cards.length / Math.max(1, resolvedPrintLayout.cardsPerPage))} صفحة
                    </span>
                    <Button size="sm" variant="ghost" className="h-7 text-xs" onClick={() => handlePrint()}>
                      <Printer className="h-3 w-3 ml-1" /> طباعة
                    </Button>
                    <Button size="sm" variant="ghost" className="h-7 text-xs text-primary" onClick={() => handleExportPdf()}>
                      <FileDown className="h-3 w-3 ml-1" /> PDF
                    </Button>
                    <Button size="sm" variant="ghost" className="h-7 text-xs" onClick={() => handleExportCsv()}>
                      <Download className="h-3 w-3 ml-1" /> CSV
                    </Button>
                  </div>
                )}
              </div>

              {cards.length === 0 ? (
                <div className="text-center py-12">
                  <CreditCard className="h-10 w-10 text-muted-foreground/20 mx-auto mb-3" />
                  <p className="text-muted-foreground text-sm">اضبط الإعدادات واضغط "توليد"</p>
                </div>
              ) : (
                <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-2 max-h-[60dvh] overflow-y-auto pr-1">
                  {cards.slice(0, 100).map((card, i) => {
                    const visibleF = fields.filter(f => f.visible);
                    const showPass = visibleF.some(f => f.type === "password");
                    const showProfile = visibleF.some(f => f.type === "profile");
                    const showPackageName = visibleF.some(f => f.type === "package_name") && !!resolvedPackageName;
                    const showPrice = visibleF.some(f => f.type === "price") && unitPrice > 0;
                    const showSP = visibleF.some(f => f.type === "sales_point") && selectedSalesPoint;
                    const showDays = visibleF.some(f => f.type === "days") && !!resolvedValidityText;
                    const showHours = visibleF.some(f => f.type === "hours") && !!resolvedHoursText;
                    const showDataQuota = visibleF.some(f => f.type === "data_quota") && !!resolvedDataQuotaText;
                    const showTransferLimit = visibleF.some(f => f.type === "transfer_limit") && !!resolvedTransferText;
                    const showQr = visibleF.some(f => f.type === "qr");
                    const showTitle = visibleF.some(f => f.type === "title");
                    const showSubtitle = visibleF.some(f => f.type === "subtitle");

                    return (
                    <div key={i} className="relative">
                      {bgImage ? (
                        <div className="rounded-md border border-border overflow-hidden relative" style={{ aspectRatio: CARD_ASPECT_STANDARD }}>
                          <img src={bgImage} alt="" className="w-full h-full object-fill" />
                          {visibleF.map(f => {
                            if (f.type === "qr") {
                              return (
                                <div key={f.id} className="absolute bg-white p-0.5 rounded-sm" style={{ top: `${f.y}%`, left: `${f.x}%`, transform: "translate(-50%,-50%)" }}>
                                  <QrCode className="h-5 w-5 text-foreground" />
                                </div>
                              );
                            }
                            let text = "";
                            if (f.type === "username") text = card.username;
                            else if (f.type === "password") text = card.password || "";
                            else if (f.type === "profile") text = card.profile;
                            else if (f.type === "package_name") text = resolvedPackageName;
                            else if (f.type === "title") text = cardTitle;
                            else if (f.type === "subtitle") text = cardSubtitle;
                            else if (f.type === "price") text = unitPrice > 0 ? `${unitPrice} ر.س` : "";
                            else if (f.type === "sales_point") text = selectedSalesPoint || "";
                            else if (f.type === "days") text = resolvedValidityText;
                            else if (f.type === "hours") text = resolvedHoursText;
                            else if (f.type === "data_quota") text = resolvedDataQuotaText;
                            else if (f.type === "transfer_limit") text = resolvedTransferText;
                            return text ? (
                              <div key={f.id} className="absolute font-mono font-bold"
                                style={{
                                  top: `${f.y}%`, left: `${f.x}%`,
                                  transform: "translate(-50%,-50%)",
                                  fontSize: `${Math.max(7, f.fontSize * 0.65)}px`,
                                  color: f.color,
                                }}
                              >{text}</div>
                            ) : null;
                          })}
                        </div>
                      ) : (
                        <div className="rounded-md border border-border bg-gradient-to-br from-card to-muted/30 overflow-hidden">
                          <div className="flex items-center">
                            <div className="flex-1 p-2.5 text-right">
                              {showTitle && <p className="font-bold text-foreground text-[10px] mb-0.5">{cardTitle}</p>}
                              {showSubtitle && <p className="text-[8px] text-muted-foreground mb-1">{cardSubtitle}</p>}
                              {showPackageName && <p className="text-[8px] text-primary/80 mb-1">{resolvedPackageName}</p>}
                              {(showTitle || showSubtitle) && <div className="h-px bg-gradient-to-l from-border to-transparent mb-1" />}
                              <div className="mb-1">
                                <span className="text-[7px] text-muted-foreground uppercase tracking-wider">USERNAME</span>
                                <p className="font-mono text-[10px] font-bold text-foreground tracking-widest">{card.username}</p>
                              </div>
                              {showPass && card.password && (
                                <div className="mb-1">
                                  <span className="text-[7px] text-muted-foreground uppercase tracking-wider">PASSWORD</span>
                                  <p className="font-mono text-[10px] font-bold text-foreground tracking-widest">{card.password}</p>
                                </div>
                              )}
                              <div className="flex items-center gap-1 mt-1 flex-wrap">
                                {showProfile && <span className="inline-block px-1.5 py-0.5 rounded text-[7px] bg-muted text-muted-foreground border border-border">{card.profile}</span>}
                                {showSP && <span className="inline-block px-1.5 py-0.5 rounded text-[7px] bg-accent text-accent-foreground">{selectedSalesPoint}</span>}
                                {showDays && <span className="inline-block px-1.5 py-0.5 rounded text-[7px] bg-accent/60 text-accent-foreground">{resolvedValidityText}</span>}
                                {showHours && <span className="inline-block px-1.5 py-0.5 rounded text-[7px] bg-accent/60 text-accent-foreground">{resolvedHoursText}</span>}
                                {showDataQuota && <span className="inline-block px-1.5 py-0.5 rounded text-[7px] bg-accent/60 text-accent-foreground">{resolvedDataQuotaText}</span>}
                                {showTransferLimit && <span className="inline-block px-1.5 py-0.5 rounded text-[7px] bg-accent/60 text-accent-foreground">{resolvedTransferText}</span>}
                                {showPrice && <span className="text-[8px] font-bold text-primary mr-auto">{unitPrice} ر.س</span>}
                              </div>
                            </div>
                            {showQr && (
                              <div className="w-12 min-w-12 flex items-center justify-center border-r border-dashed border-border p-1.5">
                                <QrCode className="h-8 w-8 text-muted-foreground/40" />
                              </div>
                            )}
                          </div>
                        </div>
                      )}
                      {card.status === "success" && (
                        <div className="absolute top-1 left-1 h-4 w-4 rounded-full bg-success/90 flex items-center justify-center">
                          <Check className="h-2.5 w-2.5 text-white" />
                        </div>
                      )}
                      {card.status === "error" && (
                        <div className="absolute top-1 left-1 h-4 w-4 rounded-full bg-destructive/90 flex items-center justify-center" title={card.error}>
                          <X className="h-2.5 w-2.5 text-white" />
                        </div>
                      )}
                    </div>
                    );
                  })}
                  {cards.length > 100 && (
                    <div className="col-span-full text-center py-3 text-xs text-muted-foreground">
                      عرض أول 100 كرت من {cards.length}
                    </div>
                  )}
                </div>
              )}
            </div>
          </div>
        </div>
      )}

      {/* Delete Batch Confirmation */}
      <AlertDialog open={!!deleteBatchId} onOpenChange={() => setDeleteBatchId(null)}>
        <AlertDialogContent dir="rtl">
          <AlertDialogHeader>
            <AlertDialogTitle>حذف الدفعة</AlertDialogTitle>
            <AlertDialogDescription>
              هل أنت متأكد من حذف هذه الدفعة؟
              <br />
              <span className="text-destructive text-xs">ملاحظة: هذا لن يحذف الكروت من الراوتر.</span>
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction
              className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
              onClick={() => deleteBatchId && handleDeleteBatch(deleteBatchId)}
            >حذف</AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>

      {/* Save Template Dialog */}
      <Dialog open={templateDialogOpen} onOpenChange={setTemplateDialogOpen}>
        <DialogContent className="sm:max-w-sm" dir="rtl">
          <DialogHeader>
            <DialogTitle>حفظ قالب الطباعة</DialogTitle>
            <DialogDescription>
              سيتم حفظ القالب في السحابة ☁️ مع جميع الإعدادات: تصميم الكروت، إعدادات التوليد (طول الاسم، كلمة المرور، النوع، الباقة، إلخ)
            </DialogDescription>
          </DialogHeader>
          <Input value={templateName} onChange={e => setTemplateName(e.target.value)} placeholder="مثال: باقة 100" className="my-2" />
          <DialogFooter>
            <Button variant="outline" onClick={() => setTemplateDialogOpen(false)}>إلغاء</Button>
            <Button onClick={saveTemplate}>حفظ في السحابة</Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {/* Load Template Dialog */}
      <Dialog open={loadTemplateDialogOpen} onOpenChange={setLoadTemplateDialogOpen}>
        <DialogContent className="sm:max-w-md" dir="rtl">
          <DialogHeader>
            <DialogTitle className="flex items-center gap-2">
              القوالب المحفوظة
              {templatesSyncing && <Loader2 className="h-3.5 w-3.5 animate-spin text-muted-foreground" />}
            </DialogTitle>
            <DialogDescription>
              {currentRouterHost
                ? `قوالب خاصة بـ ${currentRouterHost}`
                : "اختر قالبًا لتحميله"}
            </DialogDescription>
          </DialogHeader>
          <div className="space-y-2 max-h-60 overflow-y-auto py-2">
            {templates.length === 0 && !templatesSyncing && (
              <p className="text-sm text-muted-foreground text-center py-4">لا توجد قوالب محفوظة لهذا الراوتر</p>
            )}
            {templates.map(t => (
              <div key={t.id} className="flex items-center justify-between p-2 rounded border border-border hover:bg-muted/50">
                <div>
                  <p className="text-sm font-medium text-foreground">{t.name}</p>
                  <p className="text-[10px] text-muted-foreground">
                    {t.printCols}×{t.printRows} • {t.bgImage ? "صورة خلفية" : "بدون خلفية"}
                    {t.cloudId && " • ☁️"}
                  </p>
                </div>
                <div className="flex gap-1">
                  <Button size="sm" variant="outline" className="text-xs h-7" onClick={() => loadTemplate(t)}>تحميل</Button>
                  <Button size="sm" variant="ghost" className="text-xs h-7 text-destructive" onClick={() => deleteTemplate(t.id)}>
                    <Trash2 className="h-3 w-3" />
                  </Button>
                </div>
              </div>
            ))}
          </div>
        </DialogContent>
      </Dialog>
    </DashboardLayout>
  );
}
