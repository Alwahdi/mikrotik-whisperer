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
  Store,
} from "lucide-react";
import { Link } from "react-router-dom";
import { toast } from "sonner";
import { Progress } from "@/components/ui/progress";
import { Badge } from "@/components/ui/badge";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";
import { supabase } from "@/integrations/supabase/client";
import { useAuth } from "@/contexts/AuthContext";
import { addJob, updateJob, type BackgroundJob } from "@/stores/backgroundJobStore";

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
}

interface FieldPosition {
  id: string;
  type: "username" | "password" | "profile" | "title" | "subtitle" | "price";
  label: string;
  x: number;
  y: number;
  fontSize: number;
  color: string;
  visible: boolean;
}

// ─── Storage Helpers ──────────────────────────
const BATCHES_KEY = "mikrotik_voucher_batches";
const TEMPLATES_KEY = "mikrotik_print_templates";
const GEN_SETTINGS_KEY = "mikrotik_gen_settings";
const SALES_POINTS_KEY = "mikrotik_sales_points";

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
    { id: "f4", type: "title", label: "العنوان", x: 50, y: 20, fontSize: 14, color: "#000000", visible: false },
    { id: "f5", type: "subtitle", label: "العنوان الفرعي", x: 50, y: 35, fontSize: 10, color: "#666666", visible: false },
    { id: "f6", type: "price", label: "السعر", x: 85, y: 15, fontSize: 11, color: "#2563EB", visible: false },
  ];
}

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
  const [bgImage, setBgImage] = useState<string | null>(null);
  const [fields, setFields] = useState<FieldPosition[]>(defaultFields);
  const [draggingField, setDraggingField] = useState<string | null>(null);

  // Templates
  const [templates, setTemplates] = useState<PrintTemplate[]>(loadTemplates);
  const [templateName, setTemplateName] = useState("");
  const [templateDialogOpen, setTemplateDialogOpen] = useState(false);
  const [loadTemplateDialogOpen, setLoadTemplateDialogOpen] = useState(false);

  // Batches & history
  const [batches, setBatches] = useState<VoucherBatch[]>(loadBatches);
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
  useEffect(() => { saveTemplates(templates); }, [templates]);
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
    if (saved.salesPoint) setSelectedSalesPoint(saved.salesPoint);
  }, []);

  useEffect(() => {
    saveGenSettings({ charType, passwordMode, prefix, nameLength, passLength, unitPrice, salesPoint: selectedSalesPoint });
  }, [charType, passwordMode, prefix, nameLength, passLength, unitPrice, selectedSalesPoint]);

  const profiles = useMemo(() => {
    const raw = type === "hotspot" ? hotspotProfiles : umProfiles;
    return Array.isArray(raw) ? raw : [];
  }, [type, hotspotProfiles, umProfiles]);

  const routerBatches = useMemo(() => {
    if (!currentRouterHost) return batches;
    return batches.filter(b => !b.routerHost || b.routerHost === currentRouterHost);
  }, [batches, currentRouterHost]);

  const addSalesPoint = () => {
    const name = newSalesPoint.trim();
    if (!name || salesPoints.includes(name)) return;
    setSalesPoints(prev => [...prev, name]);
    setNewSalesPoint("");
    toast.success(`تم إضافة نقطة بيع: ${name}`);
  };

  const generateVouchers = () => {
    const newCards: VoucherCard[] = [];
    const prof = selectedProfile || profiles[0]?.name || "default";
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
    toast.success(`تم توليد ${count} كرت`);
  };

  const pushToRouter = async () => {
    if (cards.length === 0 || pushingRef.current) return;

    const isRestMode = config?.mode === "rest";
    const addEndpoint = type === "hotspot" ? "/ip/hotspot/user/add" : "/user-manager/user/add";

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
    let progressPulse: ReturnType<typeof setInterval> | null = null;

    const isDuplicateError = (message: string) => {
      const m = message.toLowerCase();
      return m.includes("already") || m.includes("exists") || m.includes("failure: already") || m.includes("same name");
    };

    const isRetryableError = (message: string) => {
      const m = message.toLowerCase();
      if (!m) return true;
      if (isDuplicateError(m)) return false;
      if (m.includes("unknown parameter") || m.includes("input does not match") || m.includes("invalid")) return false;
      if (m.includes("not enough permissions") || m.includes("authentication") || m.includes("unauthorized")) return false;
      return (
        m.includes("timeout") ||
        m.includes("session closed") ||
        m.includes("connection") ||
        m.includes("reset") ||
        m.includes("tempor") ||
        m.includes("busy") ||
        m.includes("too many") ||
        m.includes("bad gateway") ||
        m.includes("internal")
      );
    };

    const commandForIndex = (idx: number) => {
      const card = cards[idx];
      const args: string[] = type === "hotspot"
        ? [`=name=${card.username}`, `=password=${card.password}`, `=profile=${card.profile}`]
        : [`=username=${card.username}`, `=password=${card.password}`, `=group=${card.profile}`];
      return { command: addEndpoint, args };
    };

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
      const pct = Math.max(1, Math.min(99, Math.round((done / cards.length) * 100)));
      const elapsedNow = Math.max(1, (performance.now() - startedAt) / 1000);
      const liveRate = Math.round(done / elapsedNow);
      setPushProgress(pct);
      setPushMessage(`${label}: ${done}/${cards.length} • ${liveRate} كرت/ث`);
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
            if (!finalPass && isRetryableError(message)) {
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
        while (pushingRef.current) {
          const current = nextChunkIndex;
          nextChunkIndex += 1;
          if (current >= chunks.length) break;
          await processChunk(chunks[current]);
        }
      };

      await Promise.all(Array.from({ length: Math.min(Math.max(1, concurrency), chunks.length) }, () => worker()));
      return Array.from(retrySet);
    };

    progressPulse = setInterval(() => {
      if (!pushingRef.current) return;
      setPushProgress((prev) => {
        if (resolved.size === 0 && prev < 15) return prev + 1;
        return prev;
      });
    }, 450);

    try {
      const isLargeBatch = cards.length >= 600;
      const firstChunk = isRestMode
        ? (type === "usermanager" ? (isLargeBatch ? 6 : 8) : (isLargeBatch ? 8 : 12))
        : (type === "usermanager" ? (isLargeBatch ? 30 : 45) : (isLargeBatch ? 45 : 70));
      const firstConcurrency = isRestMode
        ? (type === "usermanager" ? 1 : 2)
        : (type === "usermanager" ? (isLargeBatch ? 3 : 4) : (isLargeBatch ? 4 : 5));

      let pending = await runPass(
        cards.map((_, idx) => idx),
        firstChunk,
        firstConcurrency,
        "المحاولة 1",
        false,
      );

      if (pending.length > 0) {
        pending = await runPass(
          pending,
          Math.max(1, Math.floor(firstChunk / 2)),
          Math.max(1, firstConcurrency - 1),
          "المحاولة 2",
          false,
        );
      }

      if (pending.length > 0) {
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

      setBatches(prev => {
        const updated = [...prev];
        const latest = updated.find(b => b.cards[0]?.username === cards[0]?.username);
        if (latest) {
          latest.pushed = true;
          latest.pushResults = { success: totalSuccess, failed: totalFailed };
          latest.cards = updatedCards;
        }
        return updated;
      });

      if (totalSuccess > 0 && user?.id) {
        try {
          await supabase.from("sales").insert({
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
          } as any);
        } catch {}
      }

      const elapsedSec = Math.max(1, (performance.now() - startedAt) / 1000);
      const rate = Math.round(resolved.size / elapsedSec);

      if (totalFailed === 0) {
        toast.success(`تمت إضافة ${totalSuccess} كرت (${rate} كرت/ث)`);
      } else {
        toast.warning(`نجح ${totalSuccess} — فشل ${totalFailed} (${rate} كرت/ث)`);
      }
    } catch (err: any) {
      toast.error(err?.message || "فشلت عملية الإضافة");
    } finally {
      if (progressPulse) {
        clearInterval(progressPulse);
        progressPulse = null;
      }
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

    const nameKey = batch.type === "hotspot" ? "name" : "username";
    const listCmd = batch.type === "hotspot" ? "/ip/hotspot/user/print" : "/user-manager/user/print";
    const removeCmd = batch.type === "hotspot" ? "/ip/hotspot/user/remove" : "/user-manager/user/remove";

    try {
      // Step 1: Fetch ALL users from router in one request
      setDeleteProgress(5);
      const listResult = await rawBatch.mutateAsync({
        commands: [{ command: listCmd, args: [] }],
      });

      const allUsers = listResult?.results?.[0];
      if (!Array.isArray(allUsers)) {
        toast.error("فشل جلب قائمة المستخدمين من الراوتر");
        setDeletingFromRouter(null);
        setDeleteProgress(0);
        return;
      }

      // Step 2: Build username -> .id map
      const userMap = new Map<string, string>();
      for (const u of allUsers) {
        const uname = u[nameKey] || u["name"] || u["username"];
        if (uname && u[".id"]) userMap.set(uname, u[".id"]);
      }

      // Step 3: Find IDs to delete
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
        setDeletingFromRouter(null);
        setDeleteProgress(0);
        handleDeleteBatch(batchId);
        return;
      }

      // Step 4: Delete in chunks via batch
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

        setDeleteProgress(20 + Math.round(((i + chunk.length) / idsToDelete.length) * 80));
      }

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
      setDeletingFromRouter(null);
      setDeleteProgress(0);
    }
  };

  const handleImageUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = () => setBgImage(reader.result as string);
    reader.readAsDataURL(file);
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

  const saveTemplate = () => {
    if (!templateName.trim()) { toast.error("أدخل اسم القالب"); return; }
    const template: PrintTemplate = {
      id: crypto.randomUUID(),
      name: templateName.trim(),
      profileName: selectedProfile,
      bgImage: bgImage || undefined,
      fields,
      printCols,
      printRows,
      cardTitle,
      cardSubtitle,
    };
    setTemplates(prev => [...prev, template]);
    setTemplateDialogOpen(false);
    setTemplateName("");
    toast.success("تم حفظ القالب");
  };

  const loadTemplate = (template: PrintTemplate) => {
    setBgImage(template.bgImage || null);
    setFields(template.fields);
    setPrintCols(template.printCols);
    setPrintRows(template.printRows);
    setCardTitle(template.cardTitle);
    setCardSubtitle(template.cardSubtitle);
    setLoadTemplateDialogOpen(false);
    toast.success(`تم تحميل القالب: ${template.name}`);
  };

  const deleteTemplate = (id: string) => {
    setTemplates(prev => prev.filter(t => t.id !== id));
    toast.success("تم حذف القالب");
  };

  // ─── Print HTML Builder ──────────────────────
  const buildPrintHtml = (cardsToPrint: VoucherCard[]): string => {
    const cardsPerPage = printCols * printRows;
    const pages: string[] = [];
    const visibleFields = fields.filter(f => f.visible);

    for (let p = 0; p < cardsToPrint.length; p += cardsPerPage) {
      const pageCards = cardsToPrint.slice(p, p + cardsPerPage);
      const cardHtml = pageCards.map(c => {
        if (bgImage) {
          const fieldsHtml = visibleFields.map(f => {
            let text = "";
            if (f.type === "username") text = c.username;
            else if (f.type === "password") text = c.password || "—";
            else if (f.type === "profile") text = c.profile;
            else if (f.type === "title") text = cardTitle;
            else if (f.type === "subtitle") text = cardSubtitle;
            else if (f.type === "price") text = unitPrice > 0 ? `${unitPrice}` : "";
            return text ? `<div class="overlay-text" style="top:${f.y}%;left:${f.x}%;font-size:${f.fontSize}px;color:${f.color}">${text}</div>` : "";
          }).join("");
          return `<div class="card card-custom" style="background-image:url('${bgImage}')">${fieldsHtml}</div>`;
        }
        return `
          <div class="card">
            <div class="card-title">${cardTitle}</div>
            <div class="card-sub">${cardSubtitle}</div>
            <div class="field"><div class="label">اسم المستخدم</div><div class="value">${c.username}</div></div>
            ${c.password ? `<div class="field"><div class="label">كلمة المرور</div><div class="value">${c.password}</div></div>` : ""}
            <div class="profile-badge">${c.profile}</div>
            ${unitPrice > 0 ? `<div class="price-badge">${unitPrice}</div>` : ""}
          </div>`;
      }).join("");
      pages.push(`<div class="page"><div class="grid">${cardHtml}</div></div>`);
    }

    return `<!DOCTYPE html>
<html dir="rtl"><head><meta charset="utf-8"><title>كروت</title>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Cairo:wght@400;600;700&display=swap');
  * { box-sizing: border-box; margin: 0; padding: 0; font-family: 'Cairo', sans-serif; }
  body { background: white; }
  .page { padding: 8mm; page-break-after: always; }
  .page:last-child { page-break-after: auto; }
  .grid { display: grid; grid-template-columns: repeat(${printCols}, 1fr); grid-template-rows: repeat(${printRows}, 1fr); gap: 2mm; height: calc(297mm - 16mm); }
  .card {
    border: 1.5px solid #E5E7EB; border-radius: 6px;
    padding: 10px 12px; page-break-inside: avoid;
    background: #FFFFFF;
    min-height: 80px;
    position: relative;
  }
  .card-custom {
    background-size: 100% 100%; background-position: center; background-repeat: no-repeat;
    position: relative; border: none; padding: 0;
    overflow: hidden;
  }
  .overlay-text {
    position: absolute; transform: translate(-50%, -50%);
    font-weight: 700;
    text-shadow: 0 0 4px rgba(255,255,255,0.9);
    font-family: 'JetBrains Mono', monospace; letter-spacing: 1.5px;
  }
  .card-title { font-weight: 700; font-size: 10px; color: #000; margin-bottom: 1px; }
  .card-sub { font-size: 8px; color: #666; margin-bottom: 6px; }
  .field { margin-bottom: 3px; }
  .label { font-size: 7px; color: #666; }
  .value { font-size: 11px; font-weight: 600; color: #000; font-family: 'JetBrains Mono', monospace; letter-spacing: 1px; }
  .profile-badge {
    display: inline-block; margin-top: 4px; padding: 1px 6px;
    background: #F3F4F6; border-radius: 3px; font-size: 7px; color: #666;
  }
  .price-badge {
    position: absolute; top: 6px; left: 8px;
    font-size: 9px; font-weight: 700; color: #2563EB;
  }
  @media print { .page { padding: 5mm; } }
</style></head><body>${pages.join("")}</body></html>`;
  };

  const handlePrint = (cardsToPrint?: VoucherCard[]) => {
    const toPrint = cardsToPrint || cards;
    if (toPrint.length === 0) return;
    const html = buildPrintHtml(toPrint);
    // Use window.open for reliable printing on both desktop and mobile (iOS Safari blocks iframe print)
    const printWindow = window.open("", "_blank");
    if (!printWindow) {
      toast.error("تعذر فتح نافذة الطباعة — تأكد من السماح بالنوافذ المنبثقة");
      return;
    }
    printWindow.document.open();
    printWindow.document.write(html);
    printWindow.document.close();
    // Wait for images to load then print
    const images = printWindow.document.querySelectorAll("img");
    const imagePromises = Array.from(images).map(img =>
      img.complete ? Promise.resolve() : new Promise(resolve => { img.onload = resolve; img.onerror = resolve; })
    );
    Promise.all(imagePromises).then(() => {
      setTimeout(() => {
        printWindow.focus();
        printWindow.print();
      }, 300);
    });
  };

  const handleDeleteBatch = (batchId: string) => {
    setBatches(prev => prev.filter(b => b.id !== batchId));
    setDeleteBatchId(null);
    toast.success("تم حذف الدفعة");
  };

  const loadBatchCards = (batch: VoucherBatch) => {
    setCards(batch.cards);
    setType(batch.type);
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
              {paginatedBatches.map(batch => (
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
                  {deletingFromRouter === batch.id && (
                    <div className="mb-2">
                      <Progress value={deleteProgress} className="h-1.5" />
                      <p className="text-[10px] text-muted-foreground mt-1">جاري الحذف... {deleteProgress}%</p>
                    </div>
                  )}
                  <div className="flex gap-2 flex-wrap">
                    <Button size="sm" variant="outline" className="text-xs h-8" onClick={() => loadBatchCards(batch)}>تحميل</Button>
                    <Button size="sm" variant="outline" className="text-xs h-8" onClick={() => handlePrint(batch.cards)}>
                      <Printer className="h-3 w-3 ml-1" /> طباعة
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
              ))}
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
                  <Input type="number" min={1} max={5000} value={count} onChange={e => setCount(Number(e.target.value) || 1)} className="h-9" />
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">البادئة</label>
                  <Input value={prefix} onChange={e => setPrefix(e.target.value)} placeholder="v" className="h-9" />
                </div>
              </div>

              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">طول الاسم</label>
                  <Input type="number" min={3} max={16} value={nameLength} onChange={e => setNameLength(Number(e.target.value) || 6)} className="h-9" />
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">طول كلمة المرور</label>
                  <Input type="number" min={3} max={16} value={passLength} onChange={e => setPassLength(Number(e.target.value) || 6)} className="h-9" disabled={passwordMode !== "random"} />
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
                  <label className="text-xs text-muted-foreground mb-1 block">سعر الكرت</label>
                  <Input type="number" min={0} value={unitPrice} onChange={e => setUnitPrice(Number(e.target.value) || 0)} className="h-9" />
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
                </div>

                {bgImage && (
                  <>
                    <div
                      ref={previewRef}
                      className="mt-2 rounded border border-border overflow-hidden relative cursor-crosshair select-none touch-none"
                      style={{ aspectRatio: "1.6" }}
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
                            type="number" min={6} max={24}
                            value={f.fontSize}
                            onChange={e => setFields(prev => prev.map(ff => ff.id === f.id ? { ...ff, fontSize: Number(e.target.value) || 13 } : ff))}
                            className="h-6 w-14 text-[10px] px-1"
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
                    <label className="text-xs text-muted-foreground mb-1 block">أعمدة</label>
                    <Input type="number" min={1} max={5} value={printCols} onChange={e => setPrintCols(Number(e.target.value) || 3)} className="h-9" />
                  </div>
                  <div>
                    <label className="text-xs text-muted-foreground mb-1 block">صفوف</label>
                    <Input type="number" min={1} max={8} value={printRows} onChange={e => setPrintRows(Number(e.target.value) || 4)} className="h-9" />
                  </div>
                </div>
                <p className="text-[10px] text-muted-foreground">{printCols * printRows} كرت في كل صفحة</p>
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
                  <span className="text-[10px] text-muted-foreground">
                    {Math.ceil(cards.length / (printCols * printRows))} صفحة
                  </span>
                )}
              </div>

              {cards.length === 0 ? (
                <div className="text-center py-12">
                  <CreditCard className="h-10 w-10 text-muted-foreground/20 mx-auto mb-3" />
                  <p className="text-muted-foreground text-sm">اضبط الإعدادات واضغط "توليد"</p>
                </div>
              ) : (
                <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-2 max-h-[60dvh] overflow-y-auto pr-1">
                  {cards.slice(0, 100).map((card, i) => (
                    <div key={i} className="relative">
                      {bgImage ? (
                        <div className="rounded-md border border-border overflow-hidden relative" style={{ aspectRatio: "1.6" }}>
                          <img src={bgImage} alt="" className="w-full h-full object-fill" />
                          {fields.filter(f => f.visible).map(f => {
                            let text = "";
                            if (f.type === "username") text = card.username;
                            else if (f.type === "password") text = card.password || "—";
                            else if (f.type === "profile") text = card.profile;
                            else if (f.type === "title") text = cardTitle;
                            else if (f.type === "subtitle") text = cardSubtitle;
                            else if (f.type === "price") text = unitPrice > 0 ? `${unitPrice}` : "";
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
                        <div className="rounded-md border border-border bg-card p-2.5 text-right">
                          <p className="font-semibold text-foreground text-[10px] mb-0.5">{cardTitle}</p>
                          <p className="text-[9px] text-muted-foreground mb-1.5">{cardSubtitle}</p>
                          <div className="mb-1">
                            <span className="text-[8px] text-muted-foreground">اسم المستخدم</span>
                            <p className="font-mono text-[10px] font-semibold text-foreground tracking-wider">{card.username}</p>
                          </div>
                          {card.password && (
                            <div className="mb-1">
                              <span className="text-[8px] text-muted-foreground">كلمة المرور</span>
                              <p className="font-mono text-[10px] font-semibold text-foreground tracking-wider">{card.password}</p>
                            </div>
                          )}
                          <div className="flex items-center justify-between mt-1">
                            <span className="inline-block px-1.5 py-0.5 rounded text-[8px] bg-muted text-muted-foreground">{card.profile}</span>
                            {unitPrice > 0 && <span className="text-[9px] font-bold text-primary">{unitPrice}</span>}
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
                  ))}
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
            <DialogDescription>أدخل اسمًا للقالب لاستخدامه لاحقًا</DialogDescription>
          </DialogHeader>
          <Input value={templateName} onChange={e => setTemplateName(e.target.value)} placeholder="مثال: باقة 100" className="my-2" />
          <DialogFooter>
            <Button variant="outline" onClick={() => setTemplateDialogOpen(false)}>إلغاء</Button>
            <Button onClick={saveTemplate}>حفظ</Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {/* Load Template Dialog */}
      <Dialog open={loadTemplateDialogOpen} onOpenChange={setLoadTemplateDialogOpen}>
        <DialogContent className="sm:max-w-md" dir="rtl">
          <DialogHeader>
            <DialogTitle>القوالب المحفوظة</DialogTitle>
            <DialogDescription>اختر قالبًا لتحميله</DialogDescription>
          </DialogHeader>
          <div className="space-y-2 max-h-60 overflow-y-auto py-2">
            {templates.map(t => (
              <div key={t.id} className="flex items-center justify-between p-2 rounded border border-border hover:bg-muted/50">
                <div>
                  <p className="text-sm font-medium text-foreground">{t.name}</p>
                  <p className="text-[10px] text-muted-foreground">{t.printCols}×{t.printRows} • {t.bgImage ? "صورة خلفية" : "بدون خلفية"}</p>
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
