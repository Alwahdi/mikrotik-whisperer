import { useState, useRef } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import { useHotspotProfiles, useUserManagerProfiles, useHotspotUserAction, useUserManagerAction } from "@/hooks/useMikrotik";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import {
  Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList,
  BreadcrumbPage, BreadcrumbSeparator,
} from "@/components/ui/breadcrumb";
import { Printer, CreditCard, Plus, Trash2, Download, Home, Upload, ImageIcon } from "lucide-react";
import { Link } from "react-router-dom";
import { toast } from "sonner";

interface VoucherCard {
  username: string;
  password: string;
  profile: string;
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
  const hotspotAction = useHotspotUserAction();
  const umAction = useUserManagerAction();

  const [type, setType] = useState<"hotspot" | "usermanager">("hotspot");
  const [count, setCount] = useState(10);
  const [prefix, setPrefix] = useState("v");
  const [passLength, setPassLength] = useState(6);
  const [nameLength, setNameLength] = useState(6);
  const [selectedProfile, setSelectedProfile] = useState("");
  const [cards, setCards] = useState<VoucherCard[]>([]);
  const [generating, setGenerating] = useState(false);
  const [cardTitle, setCardTitle] = useState("WiFi Card");
  const [cardSubtitle, setCardSubtitle] = useState("اتصل بالإنترنت");
  
  // Print grid config
  const [printCols, setPrintCols] = useState(3);
  const [printRows, setPrintRows] = useState(4);
  
  // Custom background image
  const [bgImage, setBgImage] = useState<string | null>(null);
  const [usernamePos, setUsernamePos] = useState({ x: 50, y: 55 });
  const [passwordPos, setPasswordPos] = useState({ x: 50, y: 75 });
  
  const fileInputRef = useRef<HTMLInputElement>(null);
  const printRef = useRef<HTMLDivElement>(null);

  const profiles = type === "hotspot"
    ? (Array.isArray(hotspotProfiles) ? hotspotProfiles : [])
    : (Array.isArray(umProfiles) ? umProfiles : []);

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
    toast.success(`تم توليد ${count} كرت`);
  };

  const pushToRouter = async () => {
    if (cards.length === 0) return;
    setGenerating(true);
    const actionFn = type === "hotspot" ? hotspotAction : umAction;
    let success = 0;
    let failed = 0;

    for (const card of cards) {
      try {
        // Hotspot uses "profile", User Manager uses "group"
        const data: Record<string, any> = { name: card.username, password: card.password };
        if (type === "hotspot") {
          data.profile = card.profile;
        } else {
          data.group = card.profile;
        }
        
        await actionFn.mutateAsync({ action: "add", data });
        success++;
      } catch (err: any) {
        console.error("Failed to add card:", err);
        failed++;
      }
    }

    setGenerating(false);
    if (failed === 0) {
      toast.success(`تم إضافة ${success} مستخدم بنجاح`);
    } else {
      toast.warning(`نجح ${success} من ${cards.length} — فشل ${failed}`);
    }
  };

  const handleImageUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = () => setBgImage(reader.result as string);
    reader.readAsDataURL(file);
  };

  const handlePrint = () => {
    if (cards.length === 0) return;
    const printWindow = window.open("", "_blank");
    if (!printWindow) return;

    const cardsPerPage = printCols * printRows;
    const pages: string[] = [];
    
    for (let p = 0; p < cards.length; p += cardsPerPage) {
      const pageCards = cards.slice(p, p + cardsPerPage);
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

    printWindow.document.write(`
      <html dir="rtl"><head><title>كروت</title>
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
      <script>window.print();window.close();<\/script>
      </body></html>
    `);
    printWindow.document.close();
  };

  return (
    <DashboardLayout>
      {/* Breadcrumb */}
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
      </div>

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
              <Input type="number" min={1} max={500} value={count} onChange={e => setCount(Number(e.target.value) || 1)} />
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
              
              {/* Background image upload */}
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

              {/* Print grid config */}
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
              <Button onClick={pushToRouter} disabled={generating} size="sm" variant="outline" className="w-full">
                <Download className="h-3.5 w-3.5 ml-1" />
                {generating ? "جاري الإضافة..." : `إضافة ${cards.length} كرت للراوتر`}
              </Button>
              <Button onClick={handlePrint} size="sm" variant="outline" className="w-full">
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
              <div ref={printRef} className="grid grid-cols-2 sm:grid-cols-3 gap-3 max-h-[60vh] overflow-y-auto pr-1">
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
    </DashboardLayout>
  );
}
