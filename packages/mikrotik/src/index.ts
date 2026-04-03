// Hooks (Supabase Edge Function-based - legacy)
export { useRouterHealth, useBatchAction, useRawBatchAction } from './hooks/useMikrotik'
export { useHotspotUsers, useHotspotProfiles, useHotspotAllUsers, useHotspotUserAction } from './hooks/useMikrotik'
export { useUserManagerUsers, useUserManagerCount, useUserManagerSearchUsers, useUserManagerProfiles, useUserManagerSessions, useUserManagerAction, useUserManagerProfileAction, useUserManagerBatchAdd } from './hooks/useMikrotik'
export { useSystemResources, useSystemIdentity, useRouterboard, useInterfaces, useDHCPLeases, useIPAddresses, useMikrotikCommand } from './hooks/useMikrotik'
export type { BatchAddUser, BatchAddResult } from './hooks/useMikrotik'
export { useRouterPrefetch } from './hooks/useRouterPrefetch'
export { useBackgroundJobs } from './hooks/useBackgroundJobs'
export { useJobHistory } from './hooks/useJobHistory'

// Hooks (Next.js API-based - recommended)
export {
  useRouterConnection,
  useUserManagerUsers as useApiUserManagerUsers,
  useUserManagerUserActions,
  useBatchAddUsers,
  useExpiredUsers,
  useRemoveExpiredUsers,
  useUserManagerProfiles as useApiUserManagerProfiles,
  useUserManagerProfileActions,
  useHotspotUsers as useApiHotspotUsers,
  useHotspotUserActions,
  useHotspotProfiles as useApiHotspotProfiles,
  useActiveConnections,
  useUserSessions,
  useAllSessions,
  useCustomers,
  usePayments,
} from './hooks/useMikrotikApi'

// Lib
export { invokeMikrotik } from './lib/invoke'
export { apiGet, apiPost, apiPatch, apiDelete } from './lib/apiClient'
export { getActiveRouter, setActiveRouter, clearActiveRouter, getDefaultPort, getProtocolOptions } from './lib/config'
export type { ActiveRouter, ConnectionMode, ConnectionProtocol } from './lib/config'
export { addConnectionDebug, getConnectionDebugEntries, clearConnectionDebugEntries, subscribeConnectionDebug } from './lib/connectionDebug'
export type { ConnectionDebugEntry, ConnectionDebugStatus } from './lib/connectionDebug'

// Stores
export { getJobs, subscribe as subscribeJobs, addJob, updateJob, removeJob, clearFinished, addJobLog, restoreJobs, upsertRemoteJob, setSyncCallbacks } from './stores/backgroundJobStore'
export type { BackgroundJob, JobStatus, JobLogEntry } from './stores/backgroundJobStore'
