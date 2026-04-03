import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { toast } from "sonner";
import { apiGet, apiPost, apiPatch, apiDelete } from "../lib/apiClient";

// Hook for API-based MikroTik operations (uses Next.js API routes, not Supabase Edge Functions)

export function useRouterConnection() {
  const qc = useQueryClient();

  return {
    connect: useMutation({
      mutationFn: async ({ host, port, user, password }: {
        host: string;
        port: number;
        user: string;
        password: string;
      }) => {
        return apiPost("/connect", { host, port, user, password });
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api"] });
        toast.success("تم الاتصال بالمايكروتيك بنجاح");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشل الاتصال بالمايكروتيك");
      },
    }),

    disconnect: useMutation({
      mutationFn: async () => {
        return apiDelete("/connect");
      },
      onSuccess: () => {
        qc.clear();
        toast.success("تم قطع الاتصال");
      },
    }),

    status: useQuery({
      queryKey: ["mikrotik-api", "connection"],
      queryFn: () => apiGet("/connect"),
      refetchInterval: 30000,
    }),
  };
}

// ─── User Manager: Users ───────────────────────────────────────────────

export function useUserManagerUsers() {
  return useQuery({
    queryKey: ["mikrotik-api", "users"],
    queryFn: () => apiGet("/users"),
    staleTime: 10000,
    gcTime: 3 * 60 * 1000,
  });
}

export function useUserManagerUserActions() {
  const qc = useQueryClient();

  return {
    add: useMutation({
      mutationFn: async ({ username, password, profile, customer = "admin" }: {
        username: string;
        password?: string;
        profile?: string;
        customer?: string;
      }) => {
        return apiPost("/users", { username, userPassword: password, profile, customer });
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "users"] });
        toast.success("تمت إضافة المستخدم بنجاح");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشلت إضافة المستخدم");
      },
    }),

    enable: useMutation({
      mutationFn: async (id: string) => {
        return apiPatch(`/users/${id}`, { action: "enable" });
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "users"] });
        toast.success("تم تفعيل المستخدم");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشل تفعيل المستخدم");
      },
    }),

    disable: useMutation({
      mutationFn: async (id: string) => {
        return apiPatch(`/users/${id}`, { action: "disable" });
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "users"] });
        toast.success("تم تعطيل المستخدم");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشل تعطيل المستخدم");
      },
    }),

    remove: useMutation({
      mutationFn: async (id: string) => {
        return apiDelete(`/users/${id}`);
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "users"] });
        toast.success("تم حذف المستخدم");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشل حذف المستخدم");
      },
    }),
  };
}

export function useBatchAddUsers() {
  const qc = useQueryClient();

  return useMutation({
    mutationFn: async ({ users, profile, customer = "admin" }: {
      users: { username: string; password: string }[];
      profile: string;
      customer?: string;
    }) => {
      return apiPost("/users/batch", { users, profile, customer }, { timeoutMs: 120000 });
    },
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ["mikrotik-api", "users"] });
      toast.success("تمت إضافة المستخدمين بنجاح");
    },
    onError: (err: any) => {
      toast.error(err.message || "فشلت إضافة المستخدمين");
    },
  });
}

export function useExpiredUsers() {
  return useQuery({
    queryKey: ["mikrotik-api", "users", "expired"],
    queryFn: () => apiGet("/users/expired"),
    staleTime: 30000,
  });
}

export function useRemoveExpiredUsers() {
  const qc = useQueryClient();

  return useMutation({
    mutationFn: async () => {
      return apiDelete("/users/expired");
    },
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ["mikrotik-api", "users"] });
      toast.success("تم حذف المستخدمين المنتهية صلاحيتهم");
    },
    onError: (err: any) => {
      toast.error(err.message || "فشل حذف المستخدمين");
    },
  });
}

// ─── User Manager: Profiles ───────────────────────────────────────────

export function useUserManagerProfiles() {
  return useQuery({
    queryKey: ["mikrotik-api", "profiles", "usermanager"],
    queryFn: () => apiGet("/profiles?type=usermanager"),
    staleTime: 30000,
  });
}

export function useUserManagerProfileActions() {
  const qc = useQueryClient();

  return {
    add: useMutation({
      mutationFn: async (profileData: {
        name: string;
        price: string;
        validity: string;
        limitName: string;
        transferLimit?: string;
        uptimeLimit?: string;
      }) => {
        return apiPost("/profiles", { ...profileData, type: "usermanager" });
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "profiles"] });
        toast.success("تمت إضافة الباقة بنجاح");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشلت إضافة الباقة");
      },
    }),

    remove: useMutation({
      mutationFn: async (id: string) => {
        return apiDelete(`/profiles?type=usermanager&id=${encodeURIComponent(id)}`);
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "profiles"] });
        toast.success("تم حذف الباقة");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشل حذف الباقة");
      },
    }),
  };
}

// ─── Hotspot ─────────────────────────────────────────────────────────

export function useHotspotUsers() {
  return useQuery({
    queryKey: ["mikrotik-api", "hotspot", "users"],
    queryFn: () => apiGet("/hotspot"),
    staleTime: 10000,
  });
}

export function useHotspotUserActions() {
  const qc = useQueryClient();

  return {
    add: useMutation({
      mutationFn: async (userData: {
        username: string;
        password: string;
        profile?: string;
        server?: string;
        email?: string;
      }) => {
        return apiPost("/hotspot", userData);
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "hotspot"] });
        toast.success("تمت إضافة مستخدم الهوت سبوت");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشلت إضافة مستخدم الهوت سبوت");
      },
    }),

    enable: useMutation({
      mutationFn: async (id: string) => {
        return apiPatch(`/hotspot/${id}`, { action: "enable" });
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "hotspot"] });
        toast.success("تم تفعيل مستخدم الهوت سبوت");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشل تفعيل مستخدم الهوت سبوت");
      },
    }),

    disable: useMutation({
      mutationFn: async (id: string) => {
        return apiPatch(`/hotspot/${id}`, { action: "disable" });
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "hotspot"] });
        toast.success("تم تعطيل مستخدم الهوت سبوت");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشل تعطيل مستخدم الهوت سبوت");
      },
    }),

    remove: useMutation({
      mutationFn: async (id: string) => {
        return apiDelete(`/hotspot/${id}`);
      },
      onSuccess: () => {
        qc.invalidateQueries({ queryKey: ["mikrotik-api", "hotspot"] });
        toast.success("تم حذف مستخدم الهوت سبوت");
      },
      onError: (err: any) => {
        toast.error(err.message || "فشل حذف مستخدم الهوت سبوت");
      },
    }),
  };
}

export function useHotspotProfiles() {
  return useQuery({
    queryKey: ["mikrotik-api", "profiles", "hotspot"],
    queryFn: () => apiGet("/profiles?type=hotspot"),
    staleTime: 30000,
  });
}

export function useActiveConnections() {
  return useQuery({
    queryKey: ["mikrotik-api", "active"],
    queryFn: () => apiGet("/active"),
    refetchInterval: 10000,
  });
}

// ─── Sessions ────────────────────────────────────────────────────────

export function useUserSessions(username?: string) {
  return useQuery({
    queryKey: ["mikrotik-api", "sessions", username],
    queryFn: () => apiGet(username ? `/sessions?username=${encodeURIComponent(username)}` : "/sessions/all"),
    enabled: !!username,
    staleTime: 30000,
  });
}

export function useAllSessions() {
  return useQuery({
    queryKey: ["mikrotik-api", "sessions", "all"],
    queryFn: () => apiGet("/sessions/all"),
    staleTime: 30000,
  });
}

// ─── Customers & Payments ────────────────────────────────────────────

export function useCustomers() {
  return useQuery({
    queryKey: ["mikrotik-api", "customers"],
    queryFn: () => apiGet("/customers"),
    staleTime: 60000,
  });
}

export function usePayments() {
  return useQuery({
    queryKey: ["mikrotik-api", "payments"],
    queryFn: () => apiGet("/payments"),
    staleTime: 60000,
  });
}
