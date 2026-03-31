// Hooks
export { useRouterHealth, useBatchAction, useRawBatchAction } from './hooks/useMikrotik'
export { useHotspotUsers, useHotspotProfiles, useHotspotAllUsers, useHotspotUserAction } from './hooks/useMikrotik'
export { useIPBindings, useIPBindingAction, useHotspotServers } from './hooks/useMikrotik'
export { useUserManagerUsers, useUserManagerCount, useUserManagerSearchUsers, useUserManagerProfiles, useUserManagerSessions, useUserManagerAction, useUserManagerProfileAction, useUserManagerBatchAdd } from './hooks/useMikrotik'
export { useUserManagerPayments, useUserManagerLimitations, useUserManagerLimitationAction, useUserManagerProfileLimitations, useUserManagerProfileLimitationAction, useUserManagerCustomers } from './hooks/useMikrotik'
export { useDatabaseAction } from './hooks/useMikrotik'
export { useNeighbors } from './hooks/useMikrotik'
export { useSchedulers, useSchedulerAction, useScripts, useScriptAction } from './hooks/useMikrotik'
export { useSystemResources, useSystemIdentity, useRouterboard, useInterfaces, useDHCPLeases, useIPAddresses, useMikrotikCommand, useSystemReboot } from './hooks/useMikrotik'
export type { BatchAddUser, BatchAddResult } from './hooks/useMikrotik'
export { useRouterPrefetch } from './hooks/useRouterPrefetch'
export { useBackgroundJobs } from './hooks/useBackgroundJobs'
export { useJobHistory } from './hooks/useJobHistory'

// Lib
export { invokeMikrotik } from './lib/invoke'
export { getActiveRouter, setActiveRouter, clearActiveRouter, getDefaultPort, getProtocolOptions } from './lib/config'
export type { ActiveRouter, ConnectionMode, ConnectionProtocol } from './lib/config'
export { addConnectionDebug, getConnectionDebugEntries, clearConnectionDebugEntries, subscribeConnectionDebug } from './lib/connectionDebug'
export type { ConnectionDebugEntry, ConnectionDebugStatus } from './lib/connectionDebug'

// Stores
export { getJobs, subscribe as subscribeJobs, addJob, updateJob, removeJob, clearFinished, addJobLog, restoreJobs, upsertRemoteJob, setSyncCallbacks } from './stores/backgroundJobStore'
export type { BackgroundJob, JobStatus, JobLogEntry } from './stores/backgroundJobStore'
