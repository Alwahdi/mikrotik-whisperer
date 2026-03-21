import AsyncStorage from '@react-native-async-storage/async-storage';
import { createContext, useContext, useEffect, useMemo, useState } from 'react';

import { useAuth } from '@/providers/AuthProvider';
import { supabase } from '@/lib/supabase';
import type { RouterCredentials } from '@/lib/mikrotik';

export type RouterRow = RouterCredentials & {
  created_at?: string;
  user_id?: string;
  router_os_version?: string | null;
  is_online?: boolean;
  last_connected_at?: string | null;
};

type RouterContextValue = {
  routers: RouterRow[];
  selectedRouter: RouterRow | null;
  loadingRouters: boolean;
  refreshRouters: () => Promise<void>;
  selectRouter: (id: string | null) => Promise<void>;
  webAppUrl: string;
  setWebAppUrl: (url: string) => Promise<void>;
};

const RouterContext = createContext<RouterContextValue | undefined>(undefined);

const ROUTER_STORAGE_KEY = 'mikrotik:selected_router_id';
const WEB_URL_STORAGE_KEY = 'mikrotik:web_app_url';
const DEFAULT_WEB_URL = process.env.EXPO_PUBLIC_WEB_APP_URL || 'http://localhost:5173';

export function RouterProvider({ children }: { children: React.ReactNode }) {
  const { user } = useAuth();
  const [routers, setRouters] = useState<RouterRow[]>([]);
  const [selectedRouterId, setSelectedRouterId] = useState<string | null>(null);
  const [loadingRouters, setLoadingRouters] = useState(false);
  const [webAppUrl, setWebAppUrlState] = useState(DEFAULT_WEB_URL);

  useEffect(() => {
    AsyncStorage.getItem(WEB_URL_STORAGE_KEY).then((saved) => {
      if (saved) setWebAppUrlState(saved);
    });
  }, []);

  useEffect(() => {
    if (!user) {
      setRouters([]);
      setSelectedRouterId(null);
      return;
    }

    const loadSelection = async () => {
      const stored = await AsyncStorage.getItem(ROUTER_STORAGE_KEY);
      if (stored) setSelectedRouterId(stored);
    };

    loadSelection();
    refreshRouters();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [user?.id]);

  const refreshRouters = async () => {
    if (!user) return;
    setLoadingRouters(true);
    try {
      const { data, error } = await supabase
        .from('routers')
        .select('*')
        .eq('user_id', user.id)
        .order('created_at', { ascending: false });

      if (!error && data) {
        setRouters(data as RouterRow[]);
        const existing = data.find((r) => r.id === selectedRouterId);
        if (!existing && data.length > 0) {
          const fallbackId = data[0].id as string;
          setSelectedRouterId(fallbackId);
          await AsyncStorage.setItem(ROUTER_STORAGE_KEY, fallbackId);
        }
      }
    } finally {
      setLoadingRouters(false);
    }
  };

  const selectRouter = async (id: string | null) => {
    setSelectedRouterId(id);
    if (id) {
      await AsyncStorage.setItem(ROUTER_STORAGE_KEY, id);
    } else {
      await AsyncStorage.removeItem(ROUTER_STORAGE_KEY);
    }
  };

  const selectedRouter = useMemo(
    () => routers.find((r) => r.id === selectedRouterId) ?? null,
    [routers, selectedRouterId],
  );

  const setWebAppUrl = async (url: string) => {
    const normalized = url.trim();
    setWebAppUrlState(normalized || DEFAULT_WEB_URL);
    await AsyncStorage.setItem(WEB_URL_STORAGE_KEY, normalized || DEFAULT_WEB_URL);
  };

  const value = useMemo(
    () => ({
      routers,
      selectedRouter,
      loadingRouters,
      refreshRouters,
      selectRouter,
      webAppUrl,
      setWebAppUrl,
    }),
    [routers, selectedRouter, loadingRouters, webAppUrl],
  );

  return <RouterContext.Provider value={value}>{children}</RouterContext.Provider>;
}

export function useRouters() {
  const ctx = useContext(RouterContext);
  if (!ctx) throw new Error('useRouters must be used within RouterProvider');
  return ctx;
}
