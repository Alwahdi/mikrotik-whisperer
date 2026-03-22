import { useSyncExternalStore } from "react";
import { getJobs, subscribe, type BackgroundJob } from "../stores/backgroundJobStore";

export function useBackgroundJobs(): BackgroundJob[] {
  return useSyncExternalStore(subscribe, getJobs, getJobs);
}
