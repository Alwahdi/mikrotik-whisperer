import { useState, useMemo, useRef, useCallback } from "react";
import DashboardLayout from "@/components/DashboardLayout";
import {
  useUserManagerUsers,
  useUserManagerProfiles,
  useUserManagerSessions,
  useUserManagerAction,
  useUserManagerProfileAction,
  useUserManagerCount,
  useUserManagerSearchUsers,
  useUserManagerBatchAdd,
  type BatchAddUser,
} from "@/hooks/useMikrotik";
import {
  Users, RefreshCw, AlertTriangle, Package, Clock,
  UserCheck, UserX, Search, MoreHorizontal, UserPlus,
  Ban, Trash2, CheckCircle, XCircle, Eye, ChevronLeft, ChevronRight,
  Home, PackagePlus, PencilLine, AlertCircle, CheckSquare, Square, Loader2,
  Upload, FileText,
} from "lucide-react";
import { useQueryClient } from "@tanstack/react-query";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Skeleton } from "@/components/ui/skeleton";
import { Progress } from "@/components/ui/progress";
import {
  DropdownMenu, DropdownMenuContent, DropdownMenuItem,
  DropdownMenuTrigger, DropdownMenuSeparator,
} from "@/components/ui/dropdown-menu";
import {
  Dialog, DialogContent, DialogHeader, DialogTitle,
  DialogFooter, DialogDescription,
} from "@/components/ui/dialog";
import {
  AlertDialog, AlertDialogAction, AlertDialogCancel,
  AlertDialogContent, AlertDialogDescription, AlertDialogFooter,
  AlertDialogHeader, AlertDialogTitle,
} from "@/components/ui/alert-dialog";
import {
  Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList,
  BreadcrumbPage, BreadcrumbSeparator,
} from "@/components/ui/breadcrumb";
import { Link } from "react-router-dom";
import { toast } from "sonner";
import { getMikrotikConfig } from "@/lib/mikrotikConfig";

const PAGE_SIZE = 20;

export default function UserManagerPage() {
  const [activeTab, setActiveTab] = useState<"users" | "profiles" | "sessions">("users");
  // Fast count query — always loads (lightweight)
  const { data: countData, isLoading: loadingCount } = useUserManagerCount({ enabled: activeTab === "users" });
  // Full user list — lazy, only when tab is active
  const { data: users, isLoading: loadingUsers, error: usersError } = useUserManagerUsers({ enabled: activeTab === "users" });
  const { data: profiles, isLoading: loadingProfiles, error: profilesError } = useUserManagerProfiles();
  const { data: sessions, isLoading: loadingSessions, error: sessionsError } = useUserManagerSessions({ enabled: activeTab === "sessions" });
  const queryClient = useQueryClient();
  const action = useUserManagerAction();
  const profileAction = useUserManagerProfileAction();
  const batchAdd = useUserManagerBatchAdd();

  const [search, setSearch] = useState("");
  const [debouncedSearch, setDebouncedSearch] = useState("");
  const [addOpen, setAddOpen] = useState(false);
  const [deleteTarget, setDeleteTarget] = useState<any>(null);
  const [deleteProfileTarget, setDeleteProfileTarget] = useState<any>(null);
  const [detailUser, setDetailUser] = useState<any>(null);
  const [newUser, setNewUser] = useState({ name: "", password: "", profile: "" });
  const [usersPage, setUsersPage] = useState(1);
  const [sessionsPage, setSessionsPage] = useState(1);
  const [selectedUsers, setSelectedUsers] = useState<Set<string>>(new Set());
  const [bulkDeleting, setBulkDeleting] = useState(false);
  const [userFilter, setUserFilter] = useState<"all" | "expired">("all");

  // Batch import state
  const [batchImportOpen, setBatchImportOpen] = useState(false);
  const [batchCsvText, setBatchCsvText] = useState("");
  const [batchImportProfile, setBatchImportProfile] = useState("");
  const [batchImporting, setBatchImporting] = useState(false);
  const [batchProgress, setBatchProgress] = useState(0);
  const csvFileInputRef = useRef<HTMLInputElement>(null);

  // Server-side search (for large datasets)
  const { data: searchResults, isLoading: loadingSearch } = useUserManagerSearchUsers(debouncedSearch, { enabled: activeTab === "users" });

  // Debounce search input
  const debounceTimerRef = useRef<ReturnType<typeof setTimeout> | null>(null);
  const handleSearch = (val: string) => {
    setSearch(val);
    setUsersPage(1);
    setSessionsPage(1);
    if (debounceTimerRef.current) clearTimeout(debounceTimerRef.current);
    debounceTimerRef.current = setTimeout(() => setDebouncedSearch(val), 400);
  };

  const [profileOpen, setProfileOpen] = useState(false);
  const [profileMode, setProfileMode] = useState<"add" | "edit">("add");
  const [editingProfile, setEditingProfile] = useState<any>(null);
  const [profileForm, setProfileForm] = useState({
    name: "",
    nameForUsers: "",
    validity: "30d",
    price: "",
    rateLimit: "",
    sharedUsers: "1",
    rxRateLimit: "",
    txRateLimit: "",
    overrideSharedUsers: "",
    transferLimit: "",
    rxTransferLimit: "",
    txTransferLimit: "",
    uptimeLimit: "",
  });

  const config = getMikrotikConfig();

  const refresh = () => {
    queryClient.invalidateQueries({ queryKey: ["mikrotik"] });
    toast.success("جاري تحديث البيانات...");
  };

  const hasError = usersError || profilesError || sessionsError;
  const isNotInstalled = hasError && (
    (usersError as any)?.message?.includes("غير مثبّت") ||
    (usersError as any)?.message?.includes("no such command")
  );

  const profileMap = useMemo(() => {
    const map: Record<string, string> = {};
    if (Array.isArray(profiles)) {
      profiles.forEach((p: any) => {
        if (p.name) { map[p.name] = p.name; map[p[".id"]] = p.name; }
      });
    }
    return map;
  }, [profiles]);

  const getProfileName = (user: any): string => {
    const raw = user.group || user.profile || user["actual-profile"] || user.actual_profile || "";
    if (!raw) return "—";
    return profileMap[raw] || raw;
  };

  const allUsers = useMemo(() => {
    // If server-side search returned results, use those
    if (debouncedSearch.trim().length >= 2 && Array.isArray(searchResults)) {
      return searchResults;
    }
    return Array.isArray(users) ? users : [];
  }, [users, searchResults, debouncedSearch]);
  const allSessions = useMemo(() => Array.isArray(sessions) ? sessions : [], [sessions]);

  // Check if user is expired (uptime used up or disabled)
  const isExpired = (u: any): boolean => {
    if (u.disabled === "true" || u.disabled === true) return true;
    // If uptime-used exists and equals or exceeds profile uptime limit
    const uptimeUsed = u["uptime-used"] || "";
    if (uptimeUsed && uptimeUsed !== "0s") {
      // Check if download-used exists (consumed data)
      const dlUsed = Number(u["download-used"] || 0);
      if (dlUsed > 0 && u["last-seen"] && u["last-seen"] !== "never") return true;
    }
    return false;
  };

  const filteredUsers = useMemo(() => {
    let list = allUsers;
    if (userFilter === "expired") {
      list = list.filter(isExpired);
    }
    if (!search) return list;
    const s = search.toLowerCase();
    return list.filter((u: any) =>
      (u.name || "").toLowerCase().includes(s) ||
      (u.username || "").toLowerCase().includes(s) ||
      (u.comment || "").toLowerCase().includes(s) ||
      getProfileName(u).toLowerCase().includes(s)
    );
  }, [allUsers, search, profileMap, userFilter]);

  const filteredSessions = useMemo(() => {
    if (!search) return allSessions;
    const s = search.toLowerCase();
    return allSessions.filter((sess: any) =>
      (sess.user || sess.customer || sess.name || "").toLowerCase().includes(s)
    );
  }, [allSessions, search]);

  const usersTotalPages = Math.max(1, Math.ceil(filteredUsers.length / PAGE_SIZE));
  const sessionsTotalPages = Math.max(1, Math.ceil(filteredSessions.length / PAGE_SIZE));
  const paginatedUsers = filteredUsers.slice((usersPage - 1) * PAGE_SIZE, usersPage * PAGE_SIZE);
  const paginatedSessions = filteredSessions.slice((sessionsPage - 1) * PAGE_SIZE, sessionsPage * PAGE_SIZE);

  // Use fast count data if available, otherwise fall back to allUsers
  const totalCount = countData?.total ?? allUsers.length;
  const activeCount = countData?.active ?? allUsers.filter((u: any) => u.disabled !== "true" && u.disabled !== true).length;
  const disabledCount = countData?.disabled ?? allUsers.filter((u: any) => u.disabled === "true" || u.disabled === true).length;

  const isSearching = debouncedSearch.trim().length >= 2 && loadingSearch;

  const handleAction = (userAction: string, user: any) => {
    const id = user[".id"] || user.id;
    if (!id) { toast.error("لا يمكن تحديد المستخدم"); return; }
    action.mutate({ action: userAction, id });
  };

  const handleBulkDelete = async () => {
    if (selectedUsers.size === 0) return;
    setBulkDeleting(true);
    const ids = Array.from(selectedUsers);
    let success = 0;
    let failed = 0;
    // Process in parallel chunks of 10 for speed
    const CHUNK = 10;
    for (let i = 0; i < ids.length; i += CHUNK) {
      const chunk = ids.slice(i, i + CHUNK);
      const results = await Promise.allSettled(
        chunk.map(id => new Promise<void>((resolve, reject) =>
          action.mutate({ action: "remove", id }, { onSuccess: () => resolve(), onError: reject })
        ))
      );
      results.forEach(r => r.status === "fulfilled" ? success++ : failed++);
    }
    setSelectedUsers(new Set());
    setBulkDeleting(false);
    if (failed === 0) toast.success(`تم حذف ${success} مستخدم`);
    else toast.warning(`نجح ${success} — فشل ${failed}`);
  };

  const toggleSelectUser = (id: string) => {
    setSelectedUsers(prev => { const s = new Set(prev); s.has(id) ? s.delete(id) : s.add(id); return s; });
  };

  const toggleSelectAll = () => {
    // Select ALL filtered users across all pages, not just current page
    if (selectedUsers.size === filteredUsers.length && filteredUsers.length > 0) {
      setSelectedUsers(new Set());
    } else {
      setSelectedUsers(new Set(filteredUsers.map((u: any) => u[".id"] || u.id)));
    }
  };

  const handleAddUser = () => {
    if (!newUser.name || !newUser.password) {
      toast.error("اسم المستخدم وكلمة المرور مطلوبان");
      return;
    }
    const data: Record<string, any> = { username: newUser.name, password: newUser.password, owner: "admin" };
    if (newUser.profile) data.group = newUser.profile;
    action.mutate({ action: "add", data }, {
      onSuccess: () => {
        setAddOpen(false);
        setNewUser({ name: "", password: "", profile: "" });
      }
    });
  };

  const openAddProfile = () => {
    setProfileMode("add");
    setEditingProfile(null);
    setProfileForm({
      name: "", nameForUsers: "", validity: "30d", price: "",
      rateLimit: "", sharedUsers: "1", rxRateLimit: "", txRateLimit: "",
      overrideSharedUsers: "", transferLimit: "", rxTransferLimit: "",
      txTransferLimit: "", uptimeLimit: "",
    });
    setProfileOpen(true);
  };

  const openEditProfile = (profile: any) => {
    setProfileMode("edit");
    setEditingProfile(profile);
    // Parse rate-limit into rx/tx if format is rx/tx
    const rl = profile["rate-limit"] || "";
    const [rx, tx] = rl.includes("/") ? rl.split("/") : [rl, ""];
    const tl = profile["transfer-limit"] || "";
    const [rxTl, txTl] = tl.includes("/") ? tl.split("/") : [tl, ""];
    setProfileForm({
      name: profile.name || "",
      nameForUsers: profile["name-for-users"] || "",
      validity: profile.validity || "",
      price: profile.price || "",
      rateLimit: rl,
      sharedUsers: profile["shared-users"] || "1",
      rxRateLimit: rx,
      txRateLimit: tx,
      overrideSharedUsers: profile["override-shared-users"] || "",
      transferLimit: tl,
      rxTransferLimit: rxTl,
      txTransferLimit: txTl,
      uptimeLimit: profile["uptime-limit"] || profile["uptime"] || "",
    });
    setProfileOpen(true);
  };

  const handleSaveProfile = () => {
    if (!profileForm.name.trim()) {
      toast.error("اسم الباقة مطلوب");
      return;
    }

    // Build rate-limit from rx/tx
    let rateLimit = profileForm.rateLimit;
    if (profileForm.rxRateLimit || profileForm.txRateLimit) {
      rateLimit = `${profileForm.rxRateLimit || "0"}/${profileForm.txRateLimit || "0"}`;
    }

    // Build transfer-limit from rx/tx
    let transferLimit = profileForm.transferLimit;
    if (profileForm.rxTransferLimit || profileForm.txTransferLimit) {
      transferLimit = `${profileForm.rxTransferLimit || "0"}/${profileForm.txTransferLimit || "0"}`;
    }

    const data: Record<string, any> = {
      name: profileForm.name.trim(),
    };
    // Only send non-empty values to avoid unknown parameter errors
    if (profileForm.validity) data.validity = profileForm.validity;
    if (profileForm.price) data.price = profileForm.price;
    if (rateLimit) data["rate-limit"] = rateLimit;
    if (profileForm.sharedUsers) data["shared-users"] = profileForm.sharedUsers;
    if (profileForm.nameForUsers) data["name-for-users"] = profileForm.nameForUsers;
    if (profileForm.overrideSharedUsers) data["override-shared-users"] = profileForm.overrideSharedUsers;
    if (transferLimit) data["transfer-limit"] = transferLimit;
    if (profileForm.uptimeLimit) data["uptime-limit"] = profileForm.uptimeLimit;

    if (profileMode === "edit") {
      const id = editingProfile?.[".id"] || editingProfile?.id;
      if (!id) { toast.error("تعذر تحديد الباقة"); return; }
      profileAction.mutate({ action: "set", id, data }, {
        onSuccess: () => { setProfileOpen(false); setEditingProfile(null); },
      });
      return;
    }

    profileAction.mutate({ action: "add", data: { ...data, owner: "admin" } }, {
      onSuccess: () => setProfileOpen(false),
    });
  };

  const handleDeleteProfile = (profile: any) => {
    const id = profile[".id"] || profile.id;
    if (!id) { toast.error("تعذر تحديد الباقة"); return; }
    profileAction.mutate({ action: "remove", id }, {
      onSuccess: () => setDeleteProfileTarget(null),
    });
  };

  // Parse CSV text: each line can be "username,password" or "username,password,profile"
  const parseCsvUsers = useCallback((text: string, defaultProfile: string): BatchAddUser[] => {
    return text
      .split(/\r?\n/)
      .map(line => line.trim())
      .filter(line => line && !line.startsWith("#"))
      .map(line => {
        const parts = line.split(",").map(p => p.trim());
        return {
          username: parts[0] || "",
          password: parts[1] || parts[0] || "",
          group: parts[2] || defaultProfile,
        } satisfies BatchAddUser;
      })
      .filter(u => u.username.length > 0);
  }, []);

  const handleCsvFileUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = (ev) => {
      setBatchCsvText((ev.target?.result as string) || "");
    };
    reader.readAsText(file);
    e.target.value = "";
  };

  const handleBatchImport = async () => {
    const users = parseCsvUsers(batchCsvText, batchImportProfile);
    if (users.length === 0) {
      toast.error("لا توجد بيانات صالحة للاستيراد");
      return;
    }
    if (!batchImportProfile && users.some(u => !u.group)) {
      toast.error("يرجى اختيار باقة افتراضية");
      return;
    }
    setBatchImporting(true);
    setBatchProgress(0);
    try {
      await batchAdd.mutateAsync({
        users,
        onProgress: (done, total) => setBatchProgress(Math.round((done / total) * 100)),
      });
      setBatchImportOpen(false);
      setBatchCsvText("");
      setBatchImportProfile("");
    } finally {
      setBatchImporting(false);
      setBatchProgress(0);
    }
  };

  return (
    <DashboardLayout>
      <Breadcrumb className="mb-4">
        <BreadcrumbList>
          <BreadcrumbItem>
            <BreadcrumbLink asChild><Link to="/dashboard"><Home className="h-3.5 w-3.5" /></Link></BreadcrumbLink>
          </BreadcrumbItem>
          <BreadcrumbSeparator />
          <BreadcrumbItem><BreadcrumbPage>يوزر مانجر</BreadcrumbPage></BreadcrumbItem>
        </BreadcrumbList>
      </Breadcrumb>

      <div className="flex items-center justify-between mb-4 gap-2 flex-wrap">
        <div>
          <h1 className="text-lg font-bold text-foreground">يوزر مانجر</h1>
          <p className="text-muted-foreground text-xs mt-0.5">
            إدارة المستخدمين والباقات والجلسات
            {config && <span className="font-mono text-[10px] mr-2">({config.host})</span>}
          </p>
        </div>
        <div className="flex items-center gap-2">
          <Button size="sm" variant="outline" onClick={() => setBatchImportOpen(true)} className="h-8" title="استيراد دفعي">
            <Upload className="h-3.5 w-3.5 ml-1" />
            <span className="hidden sm:inline">استيراد</span>
          </Button>
          <Button size="sm" variant="outline" onClick={() => setAddOpen(true)} className="h-8">
            <UserPlus className="h-3.5 w-3.5 ml-1" />
            <span className="hidden sm:inline">إضافة</span>
          </Button>
          <Button size="icon" variant="outline" onClick={refresh} className="h-8 w-8">
            <RefreshCw className="h-4 w-4" />
          </Button>
        </div>
      </div>

      {isNotInstalled && (
        <div className="mb-4 p-3 rounded-lg bg-warning/5 border border-warning/20">
          <div className="flex items-start gap-2">
            <AlertTriangle className="h-4 w-4 text-warning shrink-0 mt-0.5" />
            <div>
              <p className="font-semibold text-foreground text-sm">User Manager غير مثبّت</p>
              <p className="text-muted-foreground text-xs mt-1">حمّل الحزمة من موقع MikroTik ثم أعد تشغيل الراوتر.</p>
            </div>
          </div>
        </div>
      )}

      {hasError && !isNotInstalled && (
        <div className="mb-4 p-3 rounded-lg bg-destructive/5 border border-destructive/20">
          <div className="flex items-start gap-2">
            <AlertTriangle className="h-4 w-4 text-destructive shrink-0 mt-0.5" />
            <div>
              <p className="font-semibold text-foreground text-sm">خطأ في الاتصال</p>
              <p className="text-muted-foreground text-xs mt-1">
                {(usersError as any)?.message || (profilesError as any)?.message || "حدث خطأ"}
              </p>
            </div>
          </div>
        </div>
      )}

      {!isNotInstalled && (
        <div className="grid grid-cols-2 sm:grid-cols-4 gap-2 mb-4">
          <StatBox icon={<Users className="h-3.5 w-3.5 text-foreground" />} label="إجمالي" value={loadingCount && loadingUsers ? null : totalCount} loading={loadingCount && loadingUsers} />
          <StatBox icon={<UserCheck className="h-3.5 w-3.5 text-success" />} label="نشط" value={loadingCount && loadingUsers ? null : activeCount} loading={loadingCount && loadingUsers} />
          <StatBox icon={<UserX className="h-3.5 w-3.5 text-destructive" />} label="معطل" value={loadingCount && loadingUsers ? null : disabledCount} loading={loadingCount && loadingUsers} />
          <StatBox icon={<Clock className="h-3.5 w-3.5 text-primary" />} label="جلسات" value={loadingSessions ? null : allSessions.length} loading={loadingSessions} />
        </div>
      )}

      <div className="relative mb-3">
        <Search className="absolute right-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground" />
        <Input
          placeholder="بحث (حرفين أو أكثر للبحث من الراوتر)..."
          value={search}
          onChange={(e) => handleSearch(e.target.value)}
          className="pr-10 text-sm h-9"
        />
        {isSearching && <Loader2 className="absolute left-3 top-1/2 -translate-y-1/2 h-3.5 w-3.5 animate-spin text-primary" />}
      </div>

      <Tabs value={activeTab} onValueChange={(v) => setActiveTab(v as "users" | "profiles" | "sessions")} dir="rtl">
        <TabsList className="bg-muted mb-3 w-full justify-start">
          <TabsTrigger value="users" className="text-xs">
            المستخدمين {!loadingCount && !loadingUsers && `(${totalCount})`}
          </TabsTrigger>
          <TabsTrigger value="profiles" className="text-xs">
            الباقات {!loadingProfiles && `(${Array.isArray(profiles) ? profiles.length : 0})`}
          </TabsTrigger>
          <TabsTrigger value="sessions" className="text-xs">
            الجلسات {!loadingSessions && `(${allSessions.length})`}
          </TabsTrigger>
        </TabsList>

        <TabsContent value="users">
          <div className="flex gap-2 mb-3 flex-wrap items-center">
            <Button size="sm" variant={userFilter === "all" ? "default" : "outline"} className="text-xs h-7" onClick={() => { setUserFilter("all"); setUsersPage(1); setSelectedUsers(new Set()); }}>الكل</Button>
            <Button size="sm" variant={userFilter === "expired" ? "default" : "outline"} className="text-xs h-7" onClick={() => { setUserFilter("expired"); setUsersPage(1); setSelectedUsers(new Set()); }}>
              <AlertCircle className="h-3 w-3 ml-1" /> منتهية
            </Button>
            {selectedUsers.size > 0 && (
              <Button size="sm" variant="destructive" className="text-xs h-7 mr-auto" disabled={bulkDeleting} onClick={handleBulkDelete}>
                {bulkDeleting ? <Loader2 className="h-3 w-3 animate-spin ml-1" /> : <Trash2 className="h-3 w-3 ml-1" />}
                حذف {selectedUsers.size} محدد
              </Button>
            )}
          </div>
          <div className="rounded-lg border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border bg-muted/50">
                    <th className="p-2.5 w-8 text-center">
                      <button onClick={toggleSelectAll} className="text-muted-foreground hover:text-foreground" title={`تحديد الكل (${filteredUsers.length})`}>
                        {selectedUsers.size === filteredUsers.length && filteredUsers.length > 0 ? <CheckSquare className="h-4 w-4" /> : <Square className="h-4 w-4" />}
                      </button>
                    </th>
                    <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">المستخدم</th>
                    <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">الباقة</th>
                    <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">الحالة</th>
                    <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden sm:table-cell">التعليق</th>
                    <th className="text-center p-2.5 font-medium text-xs text-muted-foreground w-10">إجراء</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingUsers ? (
                    Array.from({ length: 5 }).map((_, i) => (
                      <tr key={i} className="border-b border-border/50">
                        <td className="p-2.5"><Skeleton className="h-4 w-4" /></td>
                        <td className="p-2.5"><Skeleton className="h-4 w-24" /></td>
                        <td className="p-2.5"><Skeleton className="h-4 w-20" /></td>
                        <td className="p-2.5"><Skeleton className="h-4 w-12" /></td>
                        <td className="p-2.5 hidden sm:table-cell"><Skeleton className="h-4 w-16" /></td>
                        <td className="p-2.5"><Skeleton className="h-4 w-6 mx-auto" /></td>
                      </tr>
                    ))
                  ) : paginatedUsers.length === 0 ? (
                    <tr>
                      <td colSpan={6} className="p-8 text-center">
                        <Users className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                        <p className="text-muted-foreground text-sm">{search ? "لا توجد نتائج" : userFilter === "expired" ? "لا توجد كروت منتهية" : "لا يوجد مستخدمين"}</p>
                      </td>
                    </tr>
                  ) : (
                    paginatedUsers.map((user: any, i: number) => {
                      const isDisabled = user.disabled === "true" || user.disabled === true;
                      const uid = user[".id"] || user.id;
                      return (
                        <tr key={uid || i} className="border-b border-border/50 hover:bg-muted/30 transition-colors group">
                          <td className="p-2.5 text-center">
                            <button onClick={() => uid && toggleSelectUser(uid)} className="text-muted-foreground hover:text-foreground">
                              {selectedUsers.has(uid) ? <CheckSquare className="h-4 w-4 text-primary" /> : <Square className="h-4 w-4" />}
                            </button>
                          </td>
                          <td className="p-2.5 font-medium text-foreground text-sm">{user.name || user.username || "—"}</td>
                          <td className="p-2.5">
                            <span className="inline-block px-1.5 py-0.5 rounded bg-muted text-foreground text-[10px]">
                              {getProfileName(user)}
                            </span>
                          </td>
                          <td className="p-2.5">
                            <span className={`inline-flex items-center gap-1 text-xs ${isDisabled ? "text-destructive" : "text-success"}`}>
                              {isDisabled ? <XCircle className="h-3 w-3" /> : <CheckCircle className="h-3 w-3" />}
                              <span className="hidden sm:inline">{isDisabled ? "معطل" : "نشط"}</span>
                            </span>
                          </td>
                          <td className="p-2.5 text-muted-foreground text-xs max-w-[120px] truncate hidden sm:table-cell">{user.comment || "—"}</td>
                          <td className="p-2.5 text-center">
                            <DropdownMenu>
                              <DropdownMenuTrigger asChild>
                                <Button variant="ghost" size="icon" className="h-7 w-7 opacity-60 sm:opacity-0 group-hover:opacity-100 transition-opacity">
                                  <MoreHorizontal className="h-4 w-4" />
                                </Button>
                              </DropdownMenuTrigger>
                              <DropdownMenuContent align="end" className="w-36">
                                <DropdownMenuItem onClick={() => setDetailUser(user)}>
                                  <Eye className="h-3.5 w-3.5 ml-2" /> التفاصيل
                                </DropdownMenuItem>
                                <DropdownMenuSeparator />
                                {isDisabled ? (
                                  <DropdownMenuItem onClick={() => handleAction("enable", user)}>
                                    <CheckCircle className="h-3.5 w-3.5 ml-2" /> تفعيل
                                  </DropdownMenuItem>
                                ) : (
                                  <DropdownMenuItem onClick={() => handleAction("disable", user)}>
                                    <Ban className="h-3.5 w-3.5 ml-2" /> تعطيل
                                  </DropdownMenuItem>
                                )}
                                <DropdownMenuSeparator />
                                <DropdownMenuItem onClick={() => setDeleteTarget(user)} className="text-destructive">
                                  <Trash2 className="h-3.5 w-3.5 ml-2" /> حذف
                                </DropdownMenuItem>
                              </DropdownMenuContent>
                            </DropdownMenu>
                          </td>
                        </tr>
                      );
                    })
                  )}
                </tbody>
              </table>
            </div>
            {!loadingUsers && filteredUsers.length > PAGE_SIZE && (
              <PaginationBar page={usersPage} totalPages={usersTotalPages} onPageChange={setUsersPage} total={filteredUsers.length} />
            )}
          </div>
        </TabsContent>

        <TabsContent value="profiles">
          <div className="flex items-center justify-end mb-3">
            <Button size="sm" onClick={openAddProfile} className="h-8">
              <PackagePlus className="h-3.5 w-3.5 ml-1" /> إضافة باقة
            </Button>
          </div>

          {loadingProfiles ? (
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-3">
              {Array.from({ length: 3 }).map((_, i) => (
                <div key={i} className="rounded-lg border border-border bg-card p-3">
                  <Skeleton className="h-5 w-32 mb-3" />
                  <Skeleton className="h-4 w-full mb-2" />
                  <Skeleton className="h-4 w-2/3" />
                </div>
              ))}
            </div>
          ) : (
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-3">
              {Array.isArray(profiles) && profiles.map((profile: any, i: number) => (
                <div key={i} className="rounded-lg border border-border bg-card shadow-card p-3 hover:border-foreground/10 transition-colors">
                  <div className="flex items-center justify-between gap-2 mb-2">
                    <div className="flex items-center gap-2 min-w-0">
                      <Package className="h-4 w-4 text-primary shrink-0" />
                      <h3 className="font-semibold text-foreground text-sm truncate">{profile.name}</h3>
                    </div>
                    <div className="flex gap-0.5">
                      <Button variant="ghost" size="icon" className="h-7 w-7" onClick={() => openEditProfile(profile)}>
                        <PencilLine className="h-3.5 w-3.5" />
                      </Button>
                      <Button variant="ghost" size="icon" className="h-7 w-7 text-destructive" onClick={() => setDeleteProfileTarget(profile)}>
                        <Trash2 className="h-3.5 w-3.5" />
                      </Button>
                    </div>
                  </div>
                  <div className="space-y-1.5">
                    {profile["name-for-users"] && <Row label="الاسم" value={profile["name-for-users"]} />}
                    {profile.validity && <Row label="الصلاحية" value={profile.validity} />}
                    {profile.price && <Row label="السعر" value={profile.price} highlight />}
                    {profile["rate-limit"] && <Row label="السرعة" value={profile["rate-limit"]} />}
                    {profile["transfer-limit"] && <Row label="حد النقل" value={profile["transfer-limit"]} />}
                    {(profile["uptime-limit"] || profile.uptime) && <Row label="حد التشغيل" value={profile["uptime-limit"] || profile.uptime} />}
                    {profile["shared-users"] && <Row label="أجهزة" value={profile["shared-users"]} />}
                    {profile["override-shared-users"] && <Row label="Override" value={profile["override-shared-users"]} />}
                  </div>
                </div>
              ))}
              {(!Array.isArray(profiles) || profiles.length === 0) && (
                <div className="col-span-full text-center py-8">
                  <Package className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                  <p className="text-muted-foreground text-sm">لا توجد باقات</p>
                </div>
              )}
            </div>
          )}
        </TabsContent>

        <TabsContent value="sessions">
          <div className="rounded-lg border border-border bg-card shadow-card overflow-hidden">
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead>
                  <tr className="border-b border-border bg-muted/50">
                    <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">المستخدم</th>
                    <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">البداية</th>
                    <th className="text-right p-2.5 font-medium text-xs text-muted-foreground hidden sm:table-cell">النهاية</th>
                    <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">↓</th>
                    <th className="text-right p-2.5 font-medium text-xs text-muted-foreground">↑</th>
                  </tr>
                </thead>
                <tbody>
                  {loadingSessions ? (
                    Array.from({ length: 5 }).map((_, i) => (
                      <tr key={i} className="border-b border-border/50">
                        <td className="p-2.5"><Skeleton className="h-4 w-24" /></td>
                        <td className="p-2.5"><Skeleton className="h-4 w-20" /></td>
                        <td className="p-2.5 hidden sm:table-cell"><Skeleton className="h-4 w-20" /></td>
                        <td className="p-2.5"><Skeleton className="h-4 w-14" /></td>
                        <td className="p-2.5"><Skeleton className="h-4 w-14" /></td>
                      </tr>
                    ))
                  ) : paginatedSessions.length === 0 ? (
                    <tr>
                      <td colSpan={5} className="p-8 text-center">
                        <Clock className="h-8 w-8 text-muted-foreground/30 mx-auto mb-2" />
                        <p className="text-muted-foreground text-sm">لا توجد جلسات</p>
                      </td>
                    </tr>
                  ) : (
                    paginatedSessions.map((s: any, i: number) => (
                      <tr key={i} className="border-b border-border/50 hover:bg-muted/30 transition-colors">
                        <td className="p-2.5 font-medium text-foreground text-sm">{s.user || s.customer || s.name || "—"}</td>
                        <td className="p-2.5 text-muted-foreground text-xs font-mono">{s["from-time"] || s.started || "—"}</td>
                        <td className="p-2.5 text-muted-foreground text-xs font-mono hidden sm:table-cell">{s["till-time"] || s.ended || "—"}</td>
                        <td className="p-2.5 text-foreground text-xs font-mono">{formatBytes(s.download || s["bytes-in"] || s["acct-input-octets"])}</td>
                        <td className="p-2.5 text-foreground text-xs font-mono">{formatBytes(s.upload || s["bytes-out"] || s["acct-output-octets"])}</td>
                      </tr>
                    ))
                  )}
                </tbody>
              </table>
            </div>
            {!loadingSessions && filteredSessions.length > PAGE_SIZE && (
              <PaginationBar page={sessionsPage} totalPages={sessionsTotalPages} onPageChange={setSessionsPage} total={filteredSessions.length} />
            )}
          </div>
        </TabsContent>
      </Tabs>

      {/* Add User Dialog */}
      <Dialog open={addOpen} onOpenChange={setAddOpen}>
        <DialogContent className="sm:max-w-md max-h-[85dvh] overflow-y-auto" dir="rtl">
          <DialogHeader>
            <DialogTitle>إضافة مستخدم جديد</DialogTitle>
            <DialogDescription>أدخل بيانات المستخدم</DialogDescription>
          </DialogHeader>
          <div className="space-y-3 py-2">
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">اسم المستخدم</label>
              <Input value={newUser.name} onChange={e => setNewUser(p => ({ ...p, name: e.target.value }))} placeholder="user01" />
            </div>
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">كلمة المرور</label>
              <Input value={newUser.password} onChange={e => setNewUser(p => ({ ...p, password: e.target.value }))} placeholder="****" />
            </div>
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">الباقة</label>
              <select
                value={newUser.profile}
                onChange={e => setNewUser(p => ({ ...p, profile: e.target.value }))}
                className="w-full h-9 rounded-md border border-input bg-background px-3 text-sm"
              >
                <option value="">اختر باقة</option>
                {Array.isArray(profiles) && profiles.map((p: any, i: number) => (
                  <option key={i} value={p.name}>{p.name}</option>
                ))}
              </select>
            </div>
          </div>
          <DialogFooter>
            <Button variant="outline" onClick={() => setAddOpen(false)}>إلغاء</Button>
            <Button onClick={handleAddUser} disabled={action.isPending}>
              {action.isPending ? "جاري..." : "إضافة"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {/* Profile Dialog */}
      <Dialog open={profileOpen} onOpenChange={setProfileOpen}>
        <DialogContent className="sm:max-w-md max-h-[85dvh] overflow-y-auto" dir="rtl">
          <DialogHeader>
            <DialogTitle>{profileMode === "add" ? "إضافة باقة" : "تعديل باقة"}</DialogTitle>
            <DialogDescription>حدد بيانات الباقة</DialogDescription>
          </DialogHeader>
          <div className="space-y-3 py-2">
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">اسم الباقة *</label>
              <Input value={profileForm.name} onChange={e => setProfileForm(p => ({ ...p, name: e.target.value }))} placeholder="basic-1d" disabled={profileMode === "edit"} />
            </div>
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">اسم العرض</label>
              <Input value={profileForm.nameForUsers} onChange={e => setProfileForm(p => ({ ...p, nameForUsers: e.target.value }))} placeholder="باقة يومية" />
            </div>
            <div className="grid grid-cols-2 gap-2">
              <div>
                <label className="text-xs text-muted-foreground mb-1 block">الصلاحية</label>
                <Input value={profileForm.validity} onChange={e => setProfileForm(p => ({ ...p, validity: e.target.value }))} placeholder="30d / 1h / 7d" />
              </div>
              <div>
                <label className="text-xs text-muted-foreground mb-1 block">السعر</label>
                <Input value={profileForm.price} onChange={e => setProfileForm(p => ({ ...p, price: e.target.value }))} placeholder="100" />
              </div>
            </div>

            <div className="border-t border-border pt-3">
              <label className="text-xs text-muted-foreground mb-2 block font-medium">حدود السرعة</label>
              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-[10px] text-muted-foreground mb-0.5 block">↓ RX (تحميل)</label>
                  <Input value={profileForm.rxRateLimit} onChange={e => setProfileForm(p => ({ ...p, rxRateLimit: e.target.value, rateLimit: "" }))} placeholder="2M" className="h-8 text-xs" />
                </div>
                <div>
                  <label className="text-[10px] text-muted-foreground mb-0.5 block">↑ TX (رفع)</label>
                  <Input value={profileForm.txRateLimit} onChange={e => setProfileForm(p => ({ ...p, txRateLimit: e.target.value, rateLimit: "" }))} placeholder="2M" className="h-8 text-xs" />
                </div>
              </div>
              <p className="text-[10px] text-muted-foreground mt-1">
                أو اكتب مباشرة: <span className="font-mono">rx/tx</span> مثل <span className="font-mono">2M/2M</span>
              </p>
              <Input
                value={profileForm.rateLimit}
                onChange={e => setProfileForm(p => ({ ...p, rateLimit: e.target.value, rxRateLimit: "", txRateLimit: "" }))}
                placeholder="2M/2M"
                className="h-8 text-xs mt-1"
              />
            </div>

            <div className="border-t border-border pt-3">
              <label className="text-xs text-muted-foreground mb-2 block font-medium">حد نقل البيانات (Transfer Limit)</label>
              <div className="grid grid-cols-2 gap-2">
                <div>
                  <label className="text-[10px] text-muted-foreground mb-0.5 block">↓ RX (تحميل)</label>
                  <Input value={profileForm.rxTransferLimit} onChange={e => setProfileForm(p => ({ ...p, rxTransferLimit: e.target.value, transferLimit: "" }))} placeholder="1G / 500M" className="h-8 text-xs" />
                </div>
                <div>
                  <label className="text-[10px] text-muted-foreground mb-0.5 block">↑ TX (رفع)</label>
                  <Input value={profileForm.txTransferLimit} onChange={e => setProfileForm(p => ({ ...p, txTransferLimit: e.target.value, transferLimit: "" }))} placeholder="500M" className="h-8 text-xs" />
                </div>
              </div>
              <p className="text-[10px] text-muted-foreground mt-1">
                أو اكتب مباشرة: <span className="font-mono">rx/tx</span> مثل <span className="font-mono">1G/500M</span>
              </p>
              <Input
                value={profileForm.transferLimit}
                onChange={e => setProfileForm(p => ({ ...p, transferLimit: e.target.value, rxTransferLimit: "", txTransferLimit: "" }))}
                placeholder="1G/500M"
                className="h-8 text-xs mt-1"
              />
            </div>

            <div className="border-t border-border pt-3">
              <label className="text-xs text-muted-foreground mb-2 block font-medium">حد وقت التشغيل (Uptime Limit)</label>
              <Input
                value={profileForm.uptimeLimit}
                onChange={e => setProfileForm(p => ({ ...p, uptimeLimit: e.target.value }))}
                placeholder="1h / 30m / 1d / 7d"
                className="h-8 text-xs"
              />
              <p className="text-[10px] text-muted-foreground mt-1">
                مثال: <span className="font-mono">1h</span> (ساعة)، <span className="font-mono">30m</span> (30 دقيقة)، <span className="font-mono">1d</span> (يوم)
              </p>
            </div>

            <div className="grid grid-cols-2 gap-2">
              <div>
                <label className="text-xs text-muted-foreground mb-1 block">عدد الأجهزة</label>
                <Input value={profileForm.sharedUsers} onChange={e => setProfileForm(p => ({ ...p, sharedUsers: e.target.value }))} placeholder="1" />
              </div>
              <div>
                <label className="text-xs text-muted-foreground mb-1 block">Override أجهزة</label>
                <Input value={profileForm.overrideSharedUsers} onChange={e => setProfileForm(p => ({ ...p, overrideSharedUsers: e.target.value }))} placeholder="off" />
              </div>
            </div>
          </div>
          <DialogFooter>
            <Button variant="outline" onClick={() => setProfileOpen(false)}>إلغاء</Button>
            <Button onClick={handleSaveProfile} disabled={profileAction.isPending}>
              {profileAction.isPending ? "جاري..." : "حفظ"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {/* Delete User Confirmation */}
      <AlertDialog open={!!deleteTarget} onOpenChange={() => setDeleteTarget(null)}>
        <AlertDialogContent dir="rtl">
          <AlertDialogHeader>
            <AlertDialogTitle>حذف المستخدم</AlertDialogTitle>
            <AlertDialogDescription>
              هل أنت متأكد من حذف "{deleteTarget?.name || deleteTarget?.username}"؟
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction
              className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
              onClick={() => { handleAction("remove", deleteTarget); setDeleteTarget(null); }}
            >حذف</AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>

      {/* Delete Profile Confirmation */}
      <AlertDialog open={!!deleteProfileTarget} onOpenChange={() => setDeleteProfileTarget(null)}>
        <AlertDialogContent dir="rtl">
          <AlertDialogHeader>
            <AlertDialogTitle>حذف الباقة</AlertDialogTitle>
            <AlertDialogDescription>
              هل أنت متأكد من حذف الباقة "{deleteProfileTarget?.name}"؟
              <br />
              <span className="text-destructive text-xs">سيتم فصل جميع المستخدمين المرتبطين بها.</span>
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>إلغاء</AlertDialogCancel>
            <AlertDialogAction
              className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
              onClick={() => deleteProfileTarget && handleDeleteProfile(deleteProfileTarget)}
            >حذف</AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>

      {/* Detail Dialog */}
      <Dialog open={!!detailUser} onOpenChange={() => setDetailUser(null)}>
        <DialogContent className="sm:max-w-md max-h-[85dvh] overflow-y-auto" dir="rtl">
          <DialogHeader>
            <DialogTitle>تفاصيل المستخدم</DialogTitle>
          </DialogHeader>
          {detailUser && (
            <div className="space-y-1.5 py-2">
              {Object.entries(detailUser).filter(([k]) => !k.startsWith(".")).map(([key, val]) => (
                <div key={key} className="flex justify-between items-center py-1 border-b border-border/50">
                  <span className="text-xs text-muted-foreground">{key}</span>
                  <span className="text-xs font-mono text-foreground max-w-[180px] truncate">{String(val || "—")}</span>
                </div>
              ))}
            </div>
          )}
        </DialogContent>
      </Dialog>

      {/* Batch Import Dialog */}
      <input
        ref={csvFileInputRef}
        type="file"
        accept=".csv,.txt"
        onChange={handleCsvFileUpload}
        className="hidden"
      />
      <Dialog open={batchImportOpen} onOpenChange={open => { if (!batchImporting) setBatchImportOpen(open); }}>
        <DialogContent className="sm:max-w-lg max-h-[90dvh] overflow-y-auto" dir="rtl">
          <DialogHeader>
            <DialogTitle className="flex items-center gap-2">
              <FileText className="h-4 w-4 text-primary" />
              استيراد مستخدمين دفعي
            </DialogTitle>
            <DialogDescription>
              أدخل البيانات بصيغة CSV: <span className="font-mono text-foreground">username,password,profile</span>
              <span className="mr-1">(الباقة اختيارية إذا حددت الافتراضية)</span>
            </DialogDescription>
          </DialogHeader>

          <div className="space-y-3 py-2">
            <div>
              <label className="text-xs text-muted-foreground mb-1 block">الباقة الافتراضية</label>
              <select
                value={batchImportProfile}
                onChange={e => setBatchImportProfile(e.target.value)}
                className="w-full h-9 rounded-md border border-input bg-background px-3 text-sm"
                disabled={batchImporting}
              >
                <option value="">— اختر باقة —</option>
                {Array.isArray(profiles) && profiles.map((p: any, i: number) => (
                  <option key={i} value={p.name}>{p.name}</option>
                ))}
              </select>
            </div>

            <div>
              <div className="flex items-center justify-between mb-1">
                <label className="text-xs text-muted-foreground">بيانات CSV</label>
                <Button
                  variant="ghost"
                  size="sm"
                  className="h-6 text-xs"
                  onClick={() => csvFileInputRef.current?.click()}
                  disabled={batchImporting}
                >
                  <Upload className="h-3 w-3 ml-1" /> رفع ملف
                </Button>
              </div>
              <textarea
                value={batchCsvText}
                onChange={e => setBatchCsvText(e.target.value)}
                placeholder={"user01,pass01,profile1\nuser02,pass02\nuser03,pass03,profile2"}
                className="w-full h-36 rounded-md border border-input bg-background px-3 py-2 text-xs font-mono resize-none focus:outline-none focus:ring-1 focus:ring-ring"
                disabled={batchImporting}
                dir="ltr"
              />
              {batchCsvText.trim() && (
                <p className="text-[10px] text-muted-foreground mt-1">
                  {parseCsvUsers(batchCsvText, batchImportProfile).length} سجل سيتم استيراده
                </p>
              )}
            </div>

            {batchImporting && (
              <div className="space-y-1.5">
                <Progress value={batchProgress} className="h-2" />
                <p className="text-xs text-muted-foreground text-center">{batchProgress}%</p>
              </div>
            )}
          </div>

          <DialogFooter>
            <Button variant="outline" onClick={() => setBatchImportOpen(false)} disabled={batchImporting}>
              إلغاء
            </Button>
            <Button onClick={handleBatchImport} disabled={batchImporting || !batchCsvText.trim()}>
              {batchImporting
                ? <><Loader2 className="h-3.5 w-3.5 animate-spin ml-1" /> جاري الاستيراد...</>
                : <><Upload className="h-3.5 w-3.5 ml-1" /> استيراد</>
              }
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </DashboardLayout>
  );
}

function PaginationBar({ page, totalPages, onPageChange, total }: { page: number; totalPages: number; onPageChange: (p: number) => void; total: number }) {
  return (
    <div className="flex items-center justify-between px-3 py-2 border-t border-border bg-muted/30">
      <span className="text-xs text-muted-foreground">{total} عنصر</span>
      <div className="flex items-center gap-1">
        <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page <= 1} onClick={() => onPageChange(page - 1)}>
          <ChevronRight className="h-4 w-4" />
        </Button>
        <span className="text-xs text-foreground px-2 min-w-[50px] text-center">{page}/{totalPages}</span>
        <Button variant="ghost" size="icon" className="h-7 w-7" disabled={page >= totalPages} onClick={() => onPageChange(page + 1)}>
          <ChevronLeft className="h-4 w-4" />
        </Button>
      </div>
    </div>
  );
}

function StatBox({ icon, label, value, loading }: { icon: React.ReactNode; label: string; value: string | number | null; loading?: boolean }) {
  return (
    <div className="rounded-lg border border-border bg-card p-2.5">
      <div className="flex items-center gap-1.5 mb-0.5">
        {icon}
        <span className="text-[10px] text-muted-foreground">{label}</span>
      </div>
      {loading ? <Skeleton className="h-6 w-10" /> : <p className="text-lg font-bold text-foreground">{value}</p>}
    </div>
  );
}

function Row({ label, value, highlight }: { label: string; value: string; highlight?: boolean }) {
  return (
    <div className="flex justify-between items-center">
      <span className="text-muted-foreground text-xs">{label}</span>
      <span className={`text-xs font-mono ${highlight ? "text-foreground font-semibold" : "text-foreground"}`}>{value}</span>
    </div>
  );
}

function formatBytes(bytes: string | number | undefined): string {
  if (!bytes) return "0 B";
  const b = Number(bytes);
  if (isNaN(b)) return "0 B";
  if (b < 1024) return b + " B";
  if (b < 1048576) return (b / 1024).toFixed(1) + " KB";
  if (b < 1073741824) return (b / 1048576).toFixed(1) + " MB";
  return (b / 1073741824).toFixed(2) + " GB";
}
