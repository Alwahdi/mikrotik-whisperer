import React, { createContext, useContext, useEffect, useState, ReactNode } from 'react';
import { supabase } from '@/lib/supabase';
import type { User, Session } from '@supabase/supabase-js';

type AppRole = 'admin' | 'cashier' | null;

interface AuthContextType {
  user: User | null;
  session: Session | null;
  loading: boolean;
  role: AppRole;
  isAdmin: boolean;
  signUp: (email: string, password: string, fullName: string) => Promise<void>;
  signIn: (email: string, password: string) => Promise<void>;
  signOut: () => Promise<void>;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export function AuthProvider({ children }: { children: ReactNode }) {
  const [user, setUser] = useState<User | null>(null);
  const [session, setSession] = useState<Session | null>(null);
  const [loading, setLoading] = useState(true);
  const [role, setRole] = useState<AppRole>(null);

  const fetchRole = async (userId: string) => {
    try {
      const { data } = await supabase.rpc('get_user_role', { _user_id: userId });
      setRole((data as AppRole) || null);
    } catch {
      setRole(null);
    }
  };

  useEffect(() => {
    const {
      data: { subscription },
    } = supabase.auth.onAuthStateChange((_event, newSession) => {
      setSession(newSession);
      setUser(newSession?.user ?? null);
      setLoading(false);
      if (newSession?.user) {
        setTimeout(() => fetchRole(newSession.user.id), 0);
      } else {
        setRole(null);
      }
    });

    supabase.auth.getSession().then(({ data: { session: s } }) => {
      setSession(s);
      setUser(s?.user ?? null);
      setLoading(false);
      if (s?.user) fetchRole(s.user.id);
    });

    return () => subscription.unsubscribe();
  }, []);

  const signUp = async (email: string, password: string, fullName: string) => {
    const { data, error } = await supabase.auth.signUp({
      email,
      password,
      options: { data: { full_name: fullName } },
    });
    if (error) throw error;
    if (data.user) {
      await supabase.from('profiles').upsert(
        { id: data.user.id, email, full_name: fullName },
        { onConflict: 'id' }
      );
    }
  };

  const signIn = async (email: string, password: string) => {
    const { error } = await supabase.auth.signInWithPassword({ email, password });
    if (error) throw error;
  };

  const signOut = async () => {
    const { error } = await supabase.auth.signOut();
    if (error) throw error;
    setRole(null);
  };

  return (
    <AuthContext.Provider
      value={{
        user,
        session,
        loading,
        role,
        isAdmin: role === 'admin',
        signUp,
        signIn,
        signOut,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  const ctx = useContext(AuthContext);
  if (!ctx) throw new Error('useAuth must be used within AuthProvider');
  return ctx;
}
