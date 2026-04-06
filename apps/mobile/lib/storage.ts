import AsyncStorage from "@react-native-async-storage/async-storage";
import type { RouterConfig } from "@repo/mikrotik";

const STORAGE_KEY = "mikrotik_active_router";

export const routerStorage = {
  getActiveRouter: async (): Promise<RouterConfig | null> => {
    try {
      const data = await AsyncStorage.getItem(STORAGE_KEY);
      return data ? JSON.parse(data) : null;
    } catch (error) {
      console.error("Error reading active router:", error);
      return null;
    }
  },

  setActiveRouter: async (config: RouterConfig | null): Promise<void> => {
    try {
      if (config) {
        await AsyncStorage.setItem(STORAGE_KEY, JSON.stringify(config));
      } else {
        await AsyncStorage.removeItem(STORAGE_KEY);
      }
    } catch (error) {
      console.error("Error saving active router:", error);
    }
  },

  clearActiveRouter: async (): Promise<void> => {
    try {
      await AsyncStorage.removeItem(STORAGE_KEY);
    } catch (error) {
      console.error("Error clearing active router:", error);
    }
  },
};
