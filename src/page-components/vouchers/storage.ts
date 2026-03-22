import type { VoucherBatch, PrintTemplate, PendingSaleRecord } from "./types";

const BATCHES_KEY = "mikrotik_voucher_batches";
const TEMPLATES_KEY = "mikrotik_print_templates";
const GEN_SETTINGS_KEY = "mikrotik_gen_settings";
const SALES_POINTS_KEY = "mikrotik_sales_points";
const PENDING_SALES_KEY = "mikrotik_pending_sales";

export function loadBatches(): VoucherBatch[] {
  try { return JSON.parse(localStorage.getItem(BATCHES_KEY) || "[]"); } catch { return []; }
}
export function saveBatches(batches: VoucherBatch[]) {
  localStorage.setItem(BATCHES_KEY, JSON.stringify(batches));
}

export function loadTemplates(): PrintTemplate[] {
  try { return JSON.parse(localStorage.getItem(TEMPLATES_KEY) || "[]"); } catch { return []; }
}
export function saveTemplates(templates: PrintTemplate[]) {
  localStorage.setItem(TEMPLATES_KEY, JSON.stringify(templates));
}

export function loadGenSettings(): Record<string, any> {
  try { return JSON.parse(localStorage.getItem(GEN_SETTINGS_KEY) || "{}"); } catch { return {}; }
}
export function saveGenSettings(settings: Record<string, any>) {
  localStorage.setItem(GEN_SETTINGS_KEY, JSON.stringify(settings));
}

export function loadSalesPoints(): string[] {
  try { return JSON.parse(localStorage.getItem(SALES_POINTS_KEY) || '["الرئيسي"]'); } catch { return ["الرئيسي"]; }
}
export function saveSalesPoints(points: string[]) {
  localStorage.setItem(SALES_POINTS_KEY, JSON.stringify(points));
}

export function loadPendingSales(): PendingSaleRecord[] {
  try {
    return JSON.parse(localStorage.getItem(PENDING_SALES_KEY) || "[]") as PendingSaleRecord[];
  } catch {
    return [];
  }
}

export function savePendingSales(records: PendingSaleRecord[]) {
  localStorage.setItem(PENDING_SALES_KEY, JSON.stringify(records));
}
