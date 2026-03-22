import type { CharType } from "./types";

export function normalizeDigits(value: string): string {
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

export function parseLocalizedInt(raw: string, fallback: number, min: number, max: number): number {
  const normalized = normalizeDigits(raw).replace(/[^0-9-]/g, "");
  const parsed = Number.parseInt(normalized, 10);
  if (Number.isNaN(parsed)) return fallback;
  return Math.min(max, Math.max(min, parsed));
}

export function hexToRgb(hex: string): [number, number, number] {
  const normalized = hex.replace("#", "").trim();
  if (!/^[0-9a-fA-F]{6}$/.test(normalized)) return [17, 24, 39];
  const r = Number.parseInt(normalized.slice(0, 2), 16);
  const g = Number.parseInt(normalized.slice(2, 4), 16);
  const b = Number.parseInt(normalized.slice(4, 6), 16);
  return [r, g, b];
}

export function humanizeDuration(value: string): string {
  if (!value) return "";
  const normalized = value.trim();
  const parts = Array.from(normalized.matchAll(/(\d+)([wdhms])/gi));
  if (parts.length === 0) return normalized;
  const labels: Record<string, string> = { w: "أسبوع", d: "يوم", h: "ساعة", m: "دقيقة", s: "ثانية" };
  return parts.map(([, count, unit]) => `${count} ${labels[unit.toLowerCase()] || unit}`).join(" • ");
}

export function extractHoursLabel(value: string): string {
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

export function formatBytesLabel(value: string): string {
  if (!value) return "";
  const plain = value.split("/").filter(Boolean)[0]?.trim() || value.trim();
  const numeric = Number.parseFloat(plain);
  if (!Number.isFinite(numeric) || !/^\d+(\.\d+)?$/.test(plain)) return value;
  if (numeric >= 1024 ** 3) return `${(numeric / 1024 ** 3).toFixed(1).replace(/\.0$/, "")} GB`;
  if (numeric >= 1024 ** 2) return `${(numeric / 1024 ** 2).toFixed(1).replace(/\.0$/, "")} MB`;
  if (numeric >= 1024) return `${(numeric / 1024).toFixed(1).replace(/\.0$/, "")} KB`;
  return `${numeric} B`;
}

const CHARS_ALPHA = "abcdefghjkmnpqrstuvwxyz";
const CHARS_NUM = "23456789";
const CHARS_ALPHANUM = CHARS_ALPHA + CHARS_NUM;

export function generateRandomString(len: number, charType: CharType): string {
  const pool = charType === "letters" ? CHARS_ALPHA : charType === "numbers" ? CHARS_NUM : CHARS_ALPHANUM;
  let result = "";
  for (let i = 0; i < len; i++) result += pool[Math.floor(Math.random() * pool.length)];
  return result;
}
