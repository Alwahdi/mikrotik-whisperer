import { useState, useRef, useMemo, useEffect } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { useHotspotProfiles, useUserManagerProfiles, useBatchAction } from "@/hooks/useMikrotik";
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
import { Printer, CreditCard, Plus, Trash2, Download, Home, Upload, Loader2, History, ChevronLeft, ChevronRight } from "lucide-react";
import { Link } from "react-router-dom";
import { toast } from "sonner";
import { Progress } from "@/components/ui/progress";

interface VoucherCard {
  username: string;
  password: string;
  profile: string;
}

interface VoucherBatch {
  id: string;
  type: "hotspot" | "usermanager";
  profile: string;
  cards: VoucherCard[];
  createdAt: string;
  pushed: boolean;
}

const BATCHES_KEY = "mikrotik_voucher_batches";

function loadBatches(): VoucherBatch[] {
  try {
    return JSON.parse(localStorage.getItem(BATCHES_KEY) || "[]");
  } catch { return []; }
}

function saveBatches(batches: VoucherBatch[]) {
  localStorage.setItem(BATCHES_KEY, JSON.stringify(batches));
}

function generateRandomString(len: number): string {
  const chars = "abcdefghjkmnpqrstuvwxyz23456789";
  let result = "";
  for (let i = 0; i < len; i++) result += chars[Math.floor(Math.random() * chars.length)];
  return result;
}

export default function VouchersPage() {
  const { data: hotspotProfiles } = useHotspotProfiles();
  const { data: umProfiles } = useUserManagerProfiles();
  const batchAction = useBatchAction();

  const [type, setType] = useState<"hotspot" | "usermanager">("hotspot");
  const [count, setCount] = useState(10);
  const [prefix, setPrefix] = useState("v");
  const [passLength, setPassLength] = useState(6);
  const [nameLength, setNameLength] = useState(6);
  const [selectedProfile, setSelectedProfile] = useState("");
  const [cards, setCards] = useState<VoucherCard[]>([]);
  const [pushing, setPushing] = useState(false);
  const [pushProgress, setPushProgress] = useState(0);
  const [cardTitle, setCardTitle] = useState("WiFi Card");
  const [cardSubtitle, setCardSubtitle] = useState("اتصل بالإنترنت");
  
  const [printCols, setPrintCols] = useState(3);
  const [printRows, setPrintRows] = useState(4);
  
  const [bgImage, setBgImage] = useState<string | null>(null);
  const [usernamePos, setUsernamePos] = useState({ x: 50, y: 55 });
  const [passwordPos, setPasswordPos] = useState({ x: 50, y: 75 });

  const [batches, setBatches] = useState<VoucherBatch[]>(loadBatches);
  const [activeTab, setActiveTab] = useState<"generate" | "history">("generate");
  const [deleteBatchId, setDeleteBatchId] = useState<string | null>(null);
  const [historyPage, setHistoryPage] = useState(1);
  const HISTORY_PAGE_SIZE = 5;
  
  const fileInputRef = useRef<HTMLInputElement>(null);
  const printFrameRef = useRef<HTMLIFrameElement>(null);

  // Persist batches
  useEffect(() => { saveBatches(batches); }, [batches]);

  const profiles = useMemo(() => {
    const raw = type === "hotspot" ? hotspotProfiles : umProfiles;
    return Array.isArray(raw) ? raw : [];
  }, [type, hotspotProfiles, umProfiles]);

  const generateVouchers = () => {
    const newCards: VoucherCard[] = [];
    const prof = selectedProfile || profiles[0]?.name || "default";
    for (let i = 0; i < count; i++) {
      newCards.push({
        username: `${prefix}${generateRandomString(nameLength)}`,
        password: generateRandomString(passLength),
        profile: prof,
      });
    }
    setCards(newCards);

    // Save as a batch
    const batch: VoucherBatch = {
      id: crypto.randomUUID(),
      type,
      profile: prof,
      cards: newCards,
      createdAt: new Date().toISOString(),
      pushed: false,
    };
    setBatches(prev => [batch, ...prev]);
    toast.success(`تم توليد ${count} كرت وحفظ الدفعة`);
  };

  const pushToRouter = async () => {
    if (cards.length === 0) return;
    setPushing(true);
    setPushProgress(0);

    const addEndpoint = type === "hotspot" 
      ? "/ip/hotspot/user/add" 
      : "/user-manager/user/add";
    
    const CHUNK_SIZE = 50;
    let totalSuccess = 0;
    let totalFailed = 0;

    for (let i = 0; i < cards.length; i += CHUNK_SIZE) {
      const chunk = cards.slice(i, i + CHUNK_SIZE);
      const commands = chunk.map(card => {
        const args: string[] = [`=name=${card.username}`, `=password=${card.password}`];
        if (type === "hotspot") {
          args.push(`=profile=${card.profile}`);
        } else {
          args.push(`=group=${card.profile}`);
        }
        return { command: addEndpoint, args };
      });

      try {
        const result = await batchAction.mutateAsync({
          commands,
          invalidateKeys: [type === "hotspot" ? "hotspot" : "usermanager"],
        });
        const errs = result?.errors?.filter((e: string) => e) || [];
        totalSuccess += chunk.length - errs.length;
        totalFailed += errs.length;
      } catch {
        totalFailed += chunk.length;
      }
      
      setPushProgress(Math.round(((i + chunk.length) / cards.length) * 100));
    }

    setPushing(false);
    setPushProgress(0);

    // Mark batch as pushed
    if (batches.length > 0) {
      setBatches(prev => {
        const updated = [...prev];
        const latest = updated.find(b => b.cards.length === cards.length && b.cards[0]?.username === cards[0]?.username);
        if (latest) latest.pushed = true;
        return updated;
      });
    }

    if (totalFailed === 0) {
      toast.success(`تم إضافة ${totalSuccess} كرت بنجاح`);
    } else {
      toast.warning(`نجح ${totalSuccess} — فشل ${totalFailed}`);
    }
  };

  const handleImageUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = () => setBgImage(reader.result as string);
    reader.readAsDataURL(file);
  };

  const buildPrintHtml = (cardsToPrint: VoucherCard[]): string => {
    const cardsPerPage = printCols * printRows;
    const pages: string[] = [];
    
    for (let p = 0; p < cardsToPrint.length; p += cardsPerPage) {
      const pageCards = cardsToPrint.slice(p, p + cardsPerPage);
      const cardHtml = pageCards.map(c => {
        if (bgImage) {
          return `
            <div class="card card-custom" style="background-image:url('${bgImage}')">
              <div class="overlay-text username" style="top:${usernamePos.y}%;left:${usernamePos.x}%">${c.username}</div>
              <div class="overlay-text password" style="top:${passwordPos.y}%;left:${passwordPos.x}%">${c.password}</div>
            </div>`;
        }
        return `
          <div class="card">
            <div class="card-title">${cardTitle}</div>
            <div class="card-sub">${cardSubtitle}</div>
            <div class="field"><div class="label">اسم المستخدم</div><div class="value">${c.username}</div></div>
            <div class="field"><div class="label">كلمة المرور</div><div class="value">${c.password}</div></div>
            <div class="profile-badge">${c.profile}</div>
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
  .grid { display: grid; grid-template-columns: repeat(${printCols}, 1fr); gap: 3mm; }
  .card {
    border: 1.5px solid #d0c8be; border-radius: 8px;
    padding: 10px 12px; page-break-inside: avoid;
    background: linear-gradient(135deg, #faf8f5, #f0ede8);
    min-height: 80px;
  }
  .card-custom {
    background-size: cover; background-position: center;
    position: relative; border: none; padding: 0;
    aspect-ratio: 1.6;
  }
  .overlay-text {
    position: absolute; transform: translate(-50%, -50%);
    font-weight: 700; font-size: 13px; color: #000;
    text-shadow: 0 0 4px rgba(255,255,255,0.9);
    font-family: 'JetBrains Mono', monospace; letter-spacing: 1.5px;
  }
  .card-title { font-weight: 700; font-size: 10px; color: #1a1814; margin-bottom: 1px; }
  .card-sub { font-size: 8px; color: #8a7f72; margin-bottom: 6px; }
  .field { margin-bottom: 3px; }
  .label { font-size: 7px; color: #8a7f72; }
  .value { font-size: 11px; font-weight: 600; color: #1a1814; font-family: 'JetBrains Mono', monospace; letter-spacing: 1px; }
  .profile-badge {
    display: inline-block; margin-top: 4px; padding: 1px 6px;
    background: #e8e2d9; border-radius: 3px; font-size: 7px; color: #5a5247;
  }
  @media print {
    .page { padding: 5mm; }
  }
</style></head><body>
${pages.join("")}
</body></html>`;
  };

  const handlePrint = (cardsToPrint?: VoucherCard[]) => {
    const toPrint = cardsToPrint || cards;
    if (toPrint.length === 0) return;
    
    const html = buildPrintHtml(toPrint);
    const blob = new Blob([html], { type: "text/html" });
    const url = URL.createObjectURL(blob);
    
    // Use hidden iframe for reliable printing
    const iframe = printFrameRef.current;
    if (iframe) {
      iframe.src = url;
      iframe.onload = () => {
        try {
          iframe.contentWindow?.print();
        } catch {
          // Fallback: open in new tab
          window.open(url, "_blank");
        }
        setTimeout(() => URL.revokeObjectURL(url), 60000);
      };
    } else {
      window.open(url, "_blank");
    }
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
    toast.success(`تم تحميل ${batch.cards.length} كرت من الدفعة`);
  };

  const paginatedBatches = batches.slice((historyPage - 1) * HISTORY_PAGE_SIZE, historyPage * HISTORY_PAGE_SIZE);
  const historyTotalPages = Math.max(1, Math.ceil(batches.length / HISTORY_PAGE_SIZE));

  return (
    <DashboardLayout>
      {/* Hidden iframe for printing */}
      <iframe ref={printFrameRef} className="hidden" title="print-frame" />

      <Breadcrumb className="mb-4">
        <BreadcrumbList>
          <BreadcrumbItem>
            <BreadcrumbLink asChild><Link to="/"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
          </BreadcrumbItem>
          <BreadcrumbSeparator />
          <BreadcrumbItem>
            <BreadcrumbPage>توليد الكروت</BreadcrumbPage>
          </BreadcrumbItem>
        </BreadcrumbList>
      </Breadcrumb>

      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-lg font-bold text-foreground">توليد الكروت</h1>
          <p className="text-muted-foreground text-xs mt-0.5">إنشاء وطباعة كروت الهوتسبوت ويوزر مانجر</p>
        </div>
        <div className="flex items-center gap-2">
          <Button
            size="sm"
            variant={activeTab === "generate" ? "default" : "outline"}
            onClick={() => setActiveTab("generate")}
          >
            <CreditCard className="h-3.5 w-3.5 ml-1" />
            توليد
          </Button>
          <Button
            size="sm"
            variant={activeTab === "history" ? "default" : "outline"}
            onClick={() => setActiveTab("history")}
          >
            <History className="h-3.5 w-3.5 ml-1" />
            السجل ({batches.length})
          </Button>
        </div>
      </div>

      {activeTab === "history" ? (
        /* ─── Batch History ─── */
        <div className="space-y-3">
          {batches.length === 0 ? (
            <div className="rounded-lg border border-border bg-card p-10 text-center">
              <History className="h-10 w-10 text-muted-foreground/20 mx-auto mb-3" />
              <p className="text-muted-foreground text-sm">لا توجد دفعات سابقة</p>
            </div>
          ) : (
            <>
              {paginatedBatches.map(batch => (
                <div key={batch.id} className="rounded-lg border border-border bg-card p-4">
                  <div className="flex items-center justify-between mb-2">
                    <div className="flex items-center gap-2">
                      <span className={`inline-block px-2 py-0.5 rounded text-[10px] font-medium ${
                        batch.type === "hotspot" ? "bg-primary/10 text-primary" : "bg-accent text-accent-foreground"
                      }`}>
                        {batch.type === "hotspot" ? "هوتسبوت" : "يوزر مانجر"}
                      </span>
                      <span className="text-xs text-muted-foreground">
                        {batch.cards.length} كرت
                      </span>
                      {batch.pushed && (
                        <span className="inline-block px-2 py-0.5 rounded text-[10px] bg-primary/10 text-primary">
                          تم الرفع
                        </span>
                      )}
                    </div>
                    <span className="text-[10px] text-muted-foreground font-mono">
                      {new Date(batch.createdAt).toLocaleString("ar")}
                    </span>
                  </div>
                  <div className="text-xs text-muted-foreground mb-3">
                    الباقة: <span className="text-foreground font-medium">{batch.profile}</span>
                    {" • "}
                    أول كرت: <span className="font-mono text-foreground">{batch.cards[0]?.username}</span>
                    {" — "}
                    آخر كرت: <span className="font-mono text-foreground">{batch.cards[batch.cards.length - 1]?.username}</span>
                  </div>
                  <div className="flex gap-2">
                    <Button size="sm" variant="outline" className="text-xs" onClick={() => loadBatchCards(batch)}>
                      تحميل الكروت
                    </Button>
                    <Button size="sm" variant="outline" className="text-xs" onClick={() => handlePrint(batch.cards)}>
                      <Printer className="h-3 w-3 ml-1" />
                      طباعة
                    </Button>
                    <Button size="sm" variant="ghost" className="text-xs text-destructive" onClick={() => setDeleteBatchId(batch.id)}>
                      <Trash2 className="h-3 w-3 ml-1" />
                      حذف
                    </Button>
                  </div>
                </div>
              ))}
              {batches.length > HISTORY_PAGE_SIZE && (
                <div className="flex items-center justify-between px-2 py-2">
                  <span className="text-xs text-muted-foreground">{batches.length} دفعة</span>
                  <div className="flex items-center gap-1">
                    <Button variant="ghost" size="icon" className="h-7 w-7" disabled={historyPage <= 1} onClick={() => setHistoryPage(p => p - 1)}>
                      <ChevronRight className="h-4 w-4" />
                    </Button>
                    <span className="text-xs text-foreground px-2">{historyPage} / {historyTotalPages}</span>
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
        /* ─── Generate Tab ─── */
        <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
          {/* Settings Panel */}
          <div className="lg:col-span-1 space-y-4">
            <div className="rounded-lg border border-border bg-card p-4 space-y-4">
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

              <div>
                <label className="text-xs text-muted-foreground mb-1 block">عدد الكروت</label>
                <Input type="number" min={1} max={1000} value={count} onChange={e => setCount(Number(e.target.value) || 1)} />
              </div>

              <div>
                <label className="text-xs text-muted-foreground mb-1 block">البادئة</label>
                <Input value={prefix} onChange={e => setPrefix(e.target.value)} placeholder="v" />
              </div>

              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">طول الاسم</label>
                  <Input type="number" min={3} max={12} value={nameLength} onChange={e => setNameLength(Number(e.target.value) || 6)} />
                </div>
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">طول كلمة المرور</label>
                  <Input type="number" min={3} max={12} value={passLength} onChange={e => setPassLength(Number(e.target.value) || 6)} />
                </div>
              </div>

              <div>
                <label className="text-xs text-muted-foreground mb-1 block">الباقة</label>
                <select
                  value={selectedProfile}
                  onChange={e => setSelectedProfile(e.target.value)}
                  className="w-full h-10 rounded-md border border-input bg-background px-3 text-sm"
                >
                  <option value="">اختر باقة</option>
                  {profiles.map((p: any, i: number) => (
                    <option key={i} value={p.name}>{p.name}</option>
                  ))}
                </select>
              </div>

              {/* Card customization */}
              <div className="border-t border-border pt-4 space-y-3">
                <h4 className="text-xs font-medium text-muted-foreground">تخصيص الكرت</h4>
                
                <div>
                  <label className="text-xs text-muted-foreground mb-1 block">صورة خلفية (اختياري)</label>
                  <input ref={fileInputRef} type="file" accept="image/*" onChange={handleImageUpload} className="hidden" />
                  <div className="flex gap-2">
                    <Button variant="outline" size="sm" className="flex-1 text-xs" onClick={() => fileInputRef.current?.click()}>
                      <Upload className="h-3 w-3 ml-1" />
                      {bgImage ? "تغيير الصورة" : "رفع صورة"}
                    </Button>
                    {bgImage && (
                      <Button variant="ghost" size="sm" onClick={() => setBgImage(null)}>
                        <Trash2 className="h-3 w-3" />
                      </Button>
                    )}
                  </div>
                  {bgImage && (
                    <div className="mt-2 rounded border border-border overflow-hidden">
                      <img src={bgImage} alt="خلفية الكرت" className="w-full h-20 object-cover" />
                    </div>
                  )}
                </div>

                {bgImage && (
                  <>
                    <div className="grid grid-cols-2 gap-2">
                      <div>
                        <label className="text-[10px] text-muted-foreground mb-0.5 block">موقع الاسم X%</label>
                        <Input type="number" min={0} max={100} value={usernamePos.x} onChange={e => setUsernamePos(p => ({ ...p, x: Number(e.target.value) }))} className="h-8 text-xs" />
                      </div>
                      <div>
                        <label className="text-[10px] text-muted-foreground mb-0.5 block">موقع الاسم Y%</label>
                        <Input type="number" min={0} max={100} value={usernamePos.y} onChange={e => setUsernamePos(p => ({ ...p, y: Number(e.target.value) }))} className="h-8 text-xs" />
                      </div>
                    </div>
                    <div className="grid grid-cols-2 gap-2">
                      <div>
                        <label className="text-[10px] text-muted-foreground mb-0.5 block">موقع كلمة المرور X%</label>
                        <Input type="number" min={0} max={100} value={passwordPos.x} onChange={e => setPasswordPos(p => ({ ...p, x: Number(e.target.value) }))} className="h-8 text-xs" />
                      </div>
                      <div>
                        <label className="text-[10px] text-muted-foreground mb-0.5 block">موقع كلمة المرور Y%</label>
                        <Input type="number" min={0} max={100} value={passwordPos.y} onChange={e => setPasswordPos(p => ({ ...p, y: Number(e.target.value) }))} className="h-8 text-xs" />
                      </div>
                    </div>
                  </>
                )}

                {!bgImage && (
                  <>
                    <div>
                      <label className="text-xs text-muted-foreground mb-1 block">عنوان الكرت</label>
                      <Input value={cardTitle} onChange={e => setCardTitle(e.target.value)} />
                    </div>
                    <div>
                      <label className="text-xs text-muted-foreground mb-1 block">العنوان الفرعي</label>
                      <Input value={cardSubtitle} onChange={e => setCardSubtitle(e.target.value)} />
                    </div>
                  </>
                )}

                <div className="grid grid-cols-2 gap-2">
                  <div>
                    <label className="text-xs text-muted-foreground mb-1 block">أعمدة الطباعة</label>
                    <Input type="number" min={1} max={5} value={printCols} onChange={e => setPrintCols(Number(e.target.value) || 3)} />
                  </div>
                  <div>
                    <label className="text-xs text-muted-foreground mb-1 block">صفوف الطباعة</label>
                    <Input type="number" min={1} max={8} value={printRows} onChange={e => setPrintRows(Number(e.target.value) || 4)} />
                  </div>
                </div>
                <p className="text-[10px] text-muted-foreground">{printCols * printRows} كرت في كل صفحة</p>
              </div>

              <div className="flex gap-2">
                <Button onClick={generateVouchers} className="flex-1" size="sm">
                  <Plus className="h-3.5 w-3.5 ml-1" />
                  توليد
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
                    <><Loader2 className="h-3.5 w-3.5 ml-1 animate-spin" /> جاري الإضافة... {pushProgress}%</>
                  ) : (
                    <><Download className="h-3.5 w-3.5 ml-1" /> إضافة {cards.length} كرت للراوتر</>
                  )}
                </Button>
                {pushing && <Progress value={pushProgress} className="h-1.5" />}
                <Button onClick={() => handlePrint()} size="sm" variant="outline" className="w-full">
                  <Printer className="h-3.5 w-3.5 ml-1" />
                  طباعة الكروت
                </Button>
              </div>
            )}
          </div>

          {/* Preview Panel */}
          <div className="lg:col-span-2">
            <div className="rounded-lg border border-border bg-card p-4">
              <div className="flex items-center justify-between mb-4">
                <h3 className="font-semibold text-foreground text-sm flex items-center gap-2">
                  <CreditCard className="h-4 w-4 text-primary" />
                  معاينة الكروت ({cards.length})
                </h3>
                {cards.length > 0 && (
                  <span className="text-[10px] text-muted-foreground">
                    {Math.ceil(cards.length / (printCols * printRows))} صفحة
                  </span>
                )}
              </div>

              {cards.length === 0 ? (
                <div className="text-center py-16">
                  <CreditCard className="h-12 w-12 text-muted-foreground/20 mx-auto mb-3" />
                  <p className="text-muted-foreground text-sm">اضبط الإعدادات واضغط "توليد"</p>
                </div>
              ) : (
                <div className="grid grid-cols-2 sm:grid-cols-3 gap-3 max-h-[60vh] overflow-y-auto pr-1">
                  {cards.map((card, i) => (
                    bgImage ? (
                      <div key={i} className="rounded-lg border border-border overflow-hidden relative" style={{ aspectRatio: "1.6" }}>
                        <img src={bgImage} alt="" className="w-full h-full object-cover" />
                        <div className="absolute font-mono text-[10px] font-bold text-foreground" style={{ top: `${usernamePos.y}%`, left: `${usernamePos.x}%`, transform: "translate(-50%,-50%)" }}>
                          {card.username}
                        </div>
                        <div className="absolute font-mono text-[10px] font-bold text-foreground" style={{ top: `${passwordPos.y}%`, left: `${passwordPos.x}%`, transform: "translate(-50%,-50%)" }}>
                          {card.password}
                        </div>
                      </div>
                    ) : (
                      <div key={i} className="rounded-lg border border-border bg-gradient-to-br from-background to-muted/50 p-3 text-right">
                        <p className="font-bold text-foreground text-xs mb-0.5">{cardTitle}</p>
                        <p className="text-[10px] text-muted-foreground mb-2">{cardSubtitle}</p>
                        <div className="mb-1">
                          <span className="text-[9px] text-muted-foreground">اسم المستخدم</span>
                          <p className="font-mono text-xs font-semibold text-foreground tracking-wider">{card.username}</p>
                        </div>
                        <div className="mb-1">
                          <span className="text-[9px] text-muted-foreground">كلمة المرور</span>
                          <p className="font-mono text-xs font-semibold text-foreground tracking-wider">{card.password}</p>
                        </div>
                        <span className="inline-block mt-1 px-2 py-0.5 rounded text-[9px] bg-muted text-muted-foreground">{card.profile}</span>
                      </div>
                    )
                  ))}
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
              هل أنت متأكد من حذف هذه الدفعة؟ لا يمكن التراجع عن هذا الإجراء.
              <br />
              <span className="text-destructive text-xs">ملاحظة: هذا لن يحذف الكروت من الراوتر إذا تم رفعها.</span>
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction
              className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
              onClick={() => deleteBatchId && handleDeleteBatch(deleteBatchId)}
            >
              حذف
            </AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </DashboardLayout>
  );
}
