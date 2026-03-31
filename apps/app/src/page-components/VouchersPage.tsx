"use client";

import { useState, useRef, useMemo, useEffect, useCallback, startTransition } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { useHotspotProfiles, useUserManagerProfiles, useRawBatchAction } from "@repo/mikrotik";
import { Button } from "@repo/design-system/components/ui/button";
import { Input } from "@repo/design-system/components/ui/input";
import { Tabs, TabsList, TabsTrigger } from "@repo/design-system/components/ui/tabs";
import {
  Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList,
  BreadcrumbPage, BreadcrumbSeparator,
} from "@repo/design-system/components/ui/breadcrumb";
import {
  AlertDialog, AlertDialogAction, AlertDialogCancel,
  AlertDialogContent, AlertDialogDescription, AlertDialogFooter,
  AlertDialogHeader, AlertDialogTitle,
} from "@repo/design-system/components/ui/alert-dialog";
import {
  Dialog, DialogContent, DialogHeader, DialogTitle,
  DialogFooter, DialogDescription,
} from "@repo/design-system/components/ui/dialog";
import {
  Select, SelectContent, SelectItem, SelectTrigger, SelectValue,
} from "@repo/design-system/components/ui/select";
import {
  Printer, CreditCard, Plus, Trash2, Download, Home, Upload, Loader2,
  History, ChevronLeft, ChevronRight, Check, X, Save, FolderOpen, GripVertical,
  Store, FileDown, LayoutGrid, QrCode,
} from "lucide-react";
import Link from "next/link";
import { toast } from "sonner";
import { Progress } from "@repo/design-system/components/ui/progress";
import { Badge } from "@repo/design-system/components/ui/badge";
import QRCode from "qrcode";
import { jsPDF } from "jspdf";
import { getActiveRouter } from "@repo/mikrotik";
import { invokeMikrotik } from "@repo/mikrotik";
import { supabase } from "@repo/database";
import { useAuth } from "@repo/auth";
import { addJob, updateJob, addJobLog } from "@repo/mikrotik";
import type {
  VoucherCard, VoucherBatch, CharType, PasswordMode, PrintLayoutMode,
  PrintTemplate, FieldPosition, BackgroundPreset, PendingSaleRecord,
} from "./vouchers/types";
import {
  parseLocalizedInt, hexToRgb, humanizeDuration,
  extractHoursLabel, formatBytesLabel, generateRandomString,
} from "./vouchers/utils";
import {
  loadBatches, saveBatches, loadTemplates, saveTemplates,
  loadGenSettings, saveGenSettings, loadSalesPoints, saveSalesPoints,
  loadPendingSales, savePendingSales,
} from "./vouchers/storage";
import {
  defaultFields, BG_PRESETS, DESIGN_THEMES,
  CARD_ASPECT_STANDARD, CARD_ASPECT_WIDE,
} from "./vouchers/presets";

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
  const [selectedCardIndices, setSelectedCardIndices] = useState<Set<number>>(new Set());
  const [pushing, setPushing] = useState(false);
  const [pushProgress, setPushProgress] = useState(0);
  const [pushMessage, setPushMessage] = useState("");
  const pushingRef = useRef(false);
  const [previewLimit, setPreviewLimit] = useState(50);

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
  const [_activeBatchId, setActiveBatchId] = useState<string | null>(null);
  const [activeTab, setActiveTab] = useState<"generate" | "history">("generate");
  const [deleteBatchId, setDeleteBatchId] = useState<string | null>(null);
  const [deletingFromRouter, setDeletingFromRouter] = useState<string | null>(null);
  const [historyPage, setHistoryPage] = useState(1);
  const HISTORY_PAGE_SIZE = 5;

  const fileInputRef = useRef<HTMLInputElement>(null);
  const previewRef = useRef<HTMLDivElement>(null);

  const config = getActiveRouter();
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
            fields: Array.isArray(row.fields) ? (row.fields as unknown as FieldPosition[]) : [],
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
    // Auto-select all newly generated cards
    setSelectedCardIndices(new Set(newCards.map((_, i) => i)));
    setPreviewLimit(50);

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
    const cardsToPush = selectedCards.length > 0 ? selectedCards : cards;
    if (cardsToPush.length === 0 || pushingRef.current) return;

    const addEndpoint = type === "hotspot" ? "/ip/hotspot/user/add" : "/user-manager/user/add";
    const jobId = `push-${Date.now()}`;

    setPushing(true);
    pushingRef.current = true;
    setPushProgress(1);
    setPushMessage("تهيئة إضافة الدفعة...");
    toast.info(`بدء إضافة ${cardsToPush.length} كرت بالخلفية`);

    addJob({
      id: jobId,
      label: `إضافة ${cardsToPush.length} كرت (${cardsToPush[0]?.profile || ""})`,
      type: "add",
      status: "running",
      total: cardsToPush.length,
      completed: 0,
      succeeded: 0,
      failed: 0,
      rate: 0,
      startedAt: performance.now(),
      routerHost: currentRouterHost,
      logs: [{ ts: Date.now(), msg: `بدأت إضافة ${cardsToPush.length} كرت (${type}) إلى ${currentRouterHost}` }],
    });

    // Mobile app pattern for user-manager vouchers (TWO commands per card):
    // Step 1: /tool/user-manager/user/add username=X password=Y customer=Z
    // Step 2: /tool/user-manager/user/create-and-activate-profile numbers=X profile="P" customer=Z
    // For hotspot: single /ip/hotspot/user/add with name, password, profile
    const commandsForCard = (card: VoucherCard): { command: string; args: string[] }[] => {
      if (type === "hotspot") {
        return [{ command: addEndpoint, args: [`=name=${card.username}`, `=password=${card.password}`, `=profile=${card.profile}`] }];
      }
      // User Manager: two-step process matching mobile app exactly
      return [
        { command: addEndpoint, args: [`=username=${card.username}`, `=password=${card.password}`, `=customer=admin`] },
        { command: "/user-manager/user/create-and-activate-profile", args: [`=numbers=${card.username}`, `=profile=${card.profile}`, `=customer=admin`] },
      ];
    };

    // Run full batch on server-side edge background task.
    // This keeps running even if browser tab is closed.
    if (!config?.routerId || !config?.host) {
      throw new Error("بيانات الراوتر غير مكتملة للتشغيل السحابي");
    }
    if (!user?.id) {
      throw new Error("تعذر تحديد المستخدم الحالي لتسجيل العملية");
    }

    try {
      const commands = cardsToPush.flatMap(commandsForCard);
      setPushProgress(10);
      setPushMessage("تم إرسال العملية للسيرفر...");

      await invokeMikrotik({
        action: "batch-background",
        routerId: config.routerId,
        host: config.host,
        port: config.port,
        protocol: config.protocol,
        mode: config.mode,
        commands,
        jobKey: jobId,
        userId: user.id,
        label: `إضافة ${cardsToPush.length} كرت (${cardsToPush[0]?.profile || ""})`,
        profileName: cardsToPush[0]?.profile || "",
        salesPoint: selectedSalesPoint,
        voucherType: type,
        unitPrice,
      });

      setPushProgress(15);
      setPushMessage("العملية بدأت على السيرفر... تابعها من العمليات الخلفية");
      addJobLog(jobId, "تم تسليم العملية إلى Edge Function. ستستمر حتى لو أُغلق المتصفح.");
      toast.success("تم تشغيل الإضافة على السيرفر بالخلفية. يمكنك إغلاق المتصفح.");
    } catch (err: unknown) {
      const message = err instanceof Error ? err.message : "فشلت عملية الإضافة";
      toast.error(message);
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
    const printJobId = `print-${Date.now()}`;
    addJob({
      id: printJobId,
      label: `طباعة ${toPrint.length} كرت`,
      type: "bulk",
      status: "running",
      total: toPrint.length,
      completed: 0,
      succeeded: 0,
      failed: 0,
      rate: 0,
      startedAt: Date.now(),
      routerHost: currentRouterHost,
      logs: [{ ts: Date.now(), msg: `بدأ تجهيز ملف الطباعة (${toPrint.length} كرت)` }],
    });
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
      updateJob(printJobId, {
        status: "success",
        completed: toPrint.length,
        succeeded: toPrint.length,
        finishedAt: Date.now(),
      });
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
    updateJob(printJobId, {
      status: "success",
      completed: toPrint.length,
      succeeded: toPrint.length,
      finishedAt: Date.now(),
    });
  };

  const handleExportPdf = async (cardsToPrint?: VoucherCard[]) => {
    const toPrint = cardsToPrint || cards;
    if (toPrint.length === 0) {
      toast.error("لا توجد كروت للتصدير");
      return;
    }
    const exportJobId = `pdf-${Date.now()}`;
    addJob({
      id: exportJobId,
      label: `تصدير PDF (${toPrint.length} كرت)`,
      type: "bulk",
      status: "running",
      total: toPrint.length,
      completed: 0,
      succeeded: 0,
      failed: 0,
      rate: 0,
      startedAt: Date.now(),
      routerHost: currentRouterHost,
    });
    toast.info("جاري تجهيز الـ PDF...");
    const doc = await buildVoucherPdf(toPrint);
    const safeName = (cardTitle || "WiFi-Card").replace(/[^\w\u0600-\u06FF-]+/g, "-");
    doc.save(`${safeName}.pdf`);
    updateJob(exportJobId, {
      status: "success",
      completed: toPrint.length,
      succeeded: toPrint.length,
      finishedAt: Date.now(),
    });
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
    setSelectedCardIndices(new Set(batch.cards.map((_, i) => i)));
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
  const selectedCount = selectedCardIndices.size;
  const allSelected = cards.length > 0 && selectedCount === cards.length;

  // Memoize visible field flags once — avoids recalculating per card in render
  const visibleFieldFlags = useMemo(() => {
    const vf = fields.filter(f => f.visible);
    return {
      visibleFields: vf,
      showPass: vf.some(f => f.type === "password"),
      showProfile: vf.some(f => f.type === "profile"),
      showPackageName: vf.some(f => f.type === "package_name") && !!resolvedPackageName,
      showPrice: vf.some(f => f.type === "price") && unitPrice > 0,
      showSP: vf.some(f => f.type === "sales_point") && !!selectedSalesPoint,
      showDays: vf.some(f => f.type === "days") && !!resolvedValidityText,
      showHours: vf.some(f => f.type === "hours") && !!resolvedHoursText,
      showDataQuota: vf.some(f => f.type === "data_quota") && !!resolvedDataQuotaText,
      showTransferLimit: vf.some(f => f.type === "transfer_limit") && !!resolvedTransferText,
      showQr: vf.some(f => f.type === "qr"),
      showTitle: vf.some(f => f.type === "title"),
      showSubtitle: vf.some(f => f.type === "subtitle"),
    };
  }, [fields, resolvedPackageName, unitPrice, selectedSalesPoint, resolvedValidityText, resolvedHoursText, resolvedDataQuotaText, resolvedTransferText]);

  // Selected cards for push/export operations
  const selectedCards = useMemo(() => {
    if (selectedCardIndices.size === cards.length) return cards;
    return cards.filter((_, i) => selectedCardIndices.has(i));
  }, [cards, selectedCardIndices]);

  const toggleCardSelection = useCallback((index: number) => {
    startTransition(() => {
      setSelectedCardIndices(prev => {
        const next = new Set(prev);
        if (next.has(index)) next.delete(index);
        else next.add(index);
        return next;
      });
    });
  }, []);

  const toggleSelectAll = useCallback(() => {
    startTransition(() => {
      setSelectedCardIndices(prev =>
        prev.size === cards.length
          ? new Set<number>()
          : new Set(cards.map((_, i) => i))
      );
    });
  }, [cards]);

  return (
    <DashboardLayout>
      <Breadcrumb className="mb-4">
        <BreadcrumbList>
          <BreadcrumbItem>
            <BreadcrumbLink asChild><Link href="/dashboard"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
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
                          onTouchStart={() => { handlePreviewMouseDown(f.id); }}
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
                  <Button variant="outline" size="sm" onClick={() => { setCards([]); setSelectedCardIndices(new Set()); }}>
                    <Trash2 className="h-3.5 w-3.5" />
                  </Button>
                )}
              </div>
            </div>

            {cards.length > 0 && (
              <div className="flex flex-col gap-2">
                {/* Selection controls */}
                <div className="flex items-center justify-between text-xs">
                  <button
                    onClick={toggleSelectAll}
                    className="text-primary hover:underline text-[10px] font-medium"
                  >
                    {allSelected ? "إلغاء تحديد الكل" : "تحديد الكل"}
                  </button>
                  <span className="text-muted-foreground text-[10px]">
                    {selectedCount > 0 ? `${selectedCount} محدد` : "لم يتم التحديد"}
                  </span>
                </div>

                <Button onClick={pushToRouter} disabled={pushing || selectedCount === 0} size="sm" variant="outline" className="w-full">
                  {pushing ? (
                    <><Loader2 className="h-3.5 w-3.5 ml-1 animate-spin" /> {pushProgress}%</>
                  ) : (
                    <><Download className="h-3.5 w-3.5 ml-1" /> إضافة {selectedCount > 0 ? selectedCount : cards.length} كرت</>
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
                <Button onClick={() => handlePrint(selectedCards.length > 0 ? selectedCards : undefined)} size="sm" variant="outline" className="w-full">
                  <Printer className="h-3.5 w-3.5 ml-1" /> طباعة {selectedCount > 0 && selectedCount < cards.length ? `(${selectedCount})` : ""}
                </Button>
                <Button onClick={() => handleExportPdf(selectedCards.length > 0 ? selectedCards : undefined)} size="sm" variant="outline" className="w-full text-primary border-primary/30 hover:bg-primary/5">
                  <FileDown className="h-3.5 w-3.5 ml-1" /> تصدير PDF {selectedCount > 0 && selectedCount < cards.length ? `(${selectedCount})` : ""}
                </Button>
                <Button onClick={() => handleExportCsv(selectedCards.length > 0 ? selectedCards : undefined)} size="sm" variant="outline" className="w-full">
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
                  معاينة ({cards.length}){selectedCount > 0 && selectedCount < cards.length && <span className="text-primary text-[10px]"> • {selectedCount} محدد</span>}
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
                <>
                  {/* Real-time status summary bar */}
                  <div className="flex items-center gap-2 mb-2 flex-wrap">
                    <Badge variant="outline" className="gap-1 text-xs">
                      <CreditCard className="h-3 w-3" /> {cards.length} كرت
                    </Badge>
                    {selectedCount > 0 && (
                      <Badge variant="outline" className="gap-1 text-xs text-primary border-primary/30">
                        <Check className="h-3 w-3" /> {selectedCount} محدد
                      </Badge>
                    )}
                    {successCount > 0 && (
                      <Badge variant="outline" className="gap-1 text-xs text-green-600 border-green-300 dark:text-green-400 dark:border-green-700">
                        <Check className="h-3 w-3" /> {successCount} تمت إضافته
                      </Badge>
                    )}
                    {errorCount > 0 && (
                      <Badge variant="outline" className="gap-1 text-xs text-destructive border-destructive/30">
                        <X className="h-3 w-3" /> {errorCount} فشل
                      </Badge>
                    )}
                    {pendingCount > 0 && pendingCount < cards.length && (
                      <Badge variant="outline" className="gap-1 text-xs text-amber-600 border-amber-300 dark:text-amber-400 dark:border-amber-700">
                        {pendingCount} معلق
                      </Badge>
                    )}
                  </div>

                  <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-2 max-h-[60dvh] overflow-y-auto pr-1">
                  {cards.slice(0, previewLimit).map((card, i) => {
                    const isSelected = selectedCardIndices.has(i);
                    const { visibleFields: visibleF, showPass, showProfile, showPackageName, showPrice, showSP, showDays, showHours, showDataQuota, showTransferLimit, showQr, showTitle, showSubtitle } = visibleFieldFlags;

                    // Status-based ring colors for instant visual feedback
                    const statusRing = card.status === "success"
                      ? "ring-green-500/70"
                      : card.status === "error"
                      ? "ring-destructive/70"
                      : "";

                    return (
                    <div key={i} className={`relative cursor-pointer transition-all duration-150 rounded-md ${isSelected ? `ring-2 ${statusRing || "ring-primary"} ring-offset-1` : "opacity-70 hover:opacity-100"}`} onClick={() => toggleCardSelection(i)}>
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
                      {/* Selection indicator */}
                      <div className={`absolute top-1 right-1 h-4 w-4 rounded border flex items-center justify-center transition-colors ${isSelected ? "bg-primary border-primary" : "border-muted-foreground/30 bg-background/80"}`}>
                        {isSelected && <Check className="h-2.5 w-2.5 text-primary-foreground" />}
                      </div>
                    </div>
                    );
                  })}
                  {cards.length > previewLimit && (
                    <div className="col-span-full text-center py-3">
                      <Button
                        variant="outline"
                        size="sm"
                        className="text-xs"
                        onClick={() => setPreviewLimit(prev => Math.min(prev + 50, cards.length))}
                      >
                        عرض المزيد ({previewLimit} من {cards.length})
                      </Button>
                    </div>
                  )}
                </div>
                </>
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
