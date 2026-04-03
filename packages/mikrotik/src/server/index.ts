// Server-only module — do not import from browser code.
// Uses node-routeros to communicate with MikroTik routers via the TCP API protocol.
import { RouterOSAPI } from "node-routeros";
import type {
  RouterUser,
  HotspotUser,
  RouterProfile,
  RouterSession,
  SessionRecord,
  ActiveConnection,
  Customer,
  Payment,
  RouterInfo,
  Limitation,
  ProfileLimitation,
  UserProfileAssignment,
  HotspotServer,
  IpBinding,
  NetworkInterface,
  Neighbor,
  SystemScript,
  SystemScheduler,
  BatchAddUser,
} from "./types";

export type { RouterSessionData, RouterConnection } from "./types";

// ── Connection Helper ─────────────────────────────────────────────────────

/**
 * Creates a MikroTik connection, detects RouterOS version, runs the callback,
 * then closes the connection. All API routes use this as their entry point.
 */
export async function withRouter<T>(
  host: string,
  port: number,
  user: string,
  password: string,
  callback: (api: RouterOSAPI, version: number) => Promise<T>
): Promise<T> {
  const api = new RouterOSAPI({ host, port, user, password, timeout: 15 /* seconds */ });
  try {
    await api.connect();
    const res = (await api.write("/system/resource/print")) as Record<string, string>[];
    const versionStr = res[0]?.version || "6";
    const version = Number.parseInt(versionStr.charAt(0), 10);
    return await callback(api, version);
  } catch (err: unknown) {
    const message = err instanceof Error ? err.message : String(err);
    throw new Error(message, { cause: err });
  } finally {
    try {
      api.close();
    } catch {
      /* ignore */
    }
  }
}

// ── Path helper (v6 uses /tool/user-manager, v7 uses /user-manager) ───────

function umPath(version: number, subpath: string): string {
  const prefix = version >= 7 ? "/user-manager" : "/tool/user-manager";
  return `${prefix}${subpath}`;
}

// ── Router Info ───────────────────────────────────────────────────────────

export async function getRouterInfo(api: RouterOSAPI): Promise<RouterInfo> {
  const raw = (await api.write("/system/resource/print")) as Record<string, string>[];
  const r = raw[0] || {};
  return {
    version: r.version || "",
    cpuLoad: r["cpu-load"] || "0",
    freeMemory: r["free-memory"] || "0",
    totalMemory: r["total-memory"] || "0",
    uptime: r.uptime || "",
    boardName: r["board-name"] || "",
  };
}

// ── User Manager: Users ───────────────────────────────────────────────────

export async function getUsers(
  api: RouterOSAPI,
  version: number
): Promise<{ active: RouterUser[]; inactive: RouterUser[] }> {
  const raw = (await api.write(umPath(version, "/user/print"), [
    "=.proplist=.id,username,password,actual-profile,uptime-used,download-used,upload-used,disabled,last-seen",
  ])) as Record<string, string>[];

  const active: RouterUser[] = [];
  const inactive: RouterUser[] = [];

  for (const r of raw) {
    const u: RouterUser = {
      id: r[".id"] || "",
      username: r.username || "",
      password: r.password || "",
      profile: r["actual-profile"] || "",
      uptimeUsed: r["uptime-used"] || "0s",
      downloadUsed: r["download-used"] || "0",
      uploadUsed: r["upload-used"] || "0",
      disabled: r.disabled === "true" || r.disabled === "yes",
      lastSeen: r["last-seen"] || "never",
    };
    if (u.profile) active.push(u);
    else inactive.push(u);
  }

  return { active, inactive };
}

export async function addUser(
  api: RouterOSAPI,
  version: number,
  username: string,
  password: string,
  profile: string,
  customer: string
): Promise<string> {
  let addResult: Record<string, string>[];

  if (version >= 7) {
    const params = [`=name=${username}`, "=shared-users=0"];
    if (password) params.push(`=password=${password}`);
    addResult = (await api.write(umPath(version, "/user/add"), params)) as Record<string, string>[];
  } else {
    const params = [`=username=${username}`];
    if (password) params.push(`=password=${password}`);
    if (customer) params.push(`=customer=${customer}`);
    addResult = (await api.write(umPath(version, "/user/add"), params)) as Record<string, string>[];
  }

  const userId = addResult[0]?.ret || addResult[0]?.[".id"] || "";

  if (profile) {
    if (version >= 7) {
      await api.write("/user-manager/user-profile/add", [
        `=user=${userId}`,
        `=profile="${profile}"`,
      ]);
    } else {
      await api.write(umPath(version, "/user/create-and-activate-profile"), [
        `=numbers=${userId}`,
        `=profile="${profile}"`,
        `=customer=${customer || "admin"}`,
      ]);
    }
  }

  return userId;
}

export async function removeUser(api: RouterOSAPI, version: number, id: string): Promise<void> {
  if (version >= 7) {
    await api.write(umPath(version, "/user/remove"), [`=numbers=${id}`]);
  } else {
    await api.write(umPath(version, "/user/remove"), [`=.id=${id}`]);
  }
}

export async function disableUser(api: RouterOSAPI, version: number, id: string): Promise<void> {
  await api.write(umPath(version, "/user/disable"), [`=numbers=${id}`]);
}

export async function enableUser(api: RouterOSAPI, version: number, id: string): Promise<void> {
  await api.write(umPath(version, "/user/enable"), [`=numbers=${id}`]);
}

// ── User Manager: Profiles ────────────────────────────────────────────────

export async function getProfiles(api: RouterOSAPI, version: number): Promise<RouterProfile[]> {
  const raw = (await api.write(umPath(version, "/profile/print"), [
    "=.proplist=.id,name,price,validity",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    name: r.name || "",
    price: r.price || "0",
    validity: r.validity || "",
  }));
}

export async function addProfile(
  api: RouterOSAPI,
  version: number,
  name: string,
  price: string,
  validity: string,
  limitName: string,
  transferLimit?: string,
  uptimeLimit?: string
): Promise<void> {
  const profileParams =
    version >= 7
      ? [
          `=name=${name}`,
          `=name-for-users=${name}`,
          "=starts-when=first-auth",
          `=price=${price}`,
          `=validity=${validity}`,
        ]
      : [
          `=name=${name}`,
          `=name-for-users=${name}`,
          "=starts-at=logon",
          `=price=${price}`,
          `=validity=${validity}`,
          "=owner=admin",
        ];

  await api.write(umPath(version, "/profile/add"), profileParams);

  const limParams: string[] = [`=name=${limitName}`];
  if (transferLimit) limParams.push(`=transfer-limit=${transferLimit}`);
  if (uptimeLimit) limParams.push(`=uptime-limit=${uptimeLimit}`);
  if (version < 7) limParams.push("=owner=admin");

  const limPath = version >= 7 ? "/limitation/add" : "/profile/limitation/add";
  await api.write(umPath(version, limPath), limParams);

  const linkPath =
    version >= 7 ? "/profile-limitation/add" : "/profile/profile-limitation/add";
  await api.write(umPath(version, linkPath), [
    `=profile="${name}"`,
    `=limitation="${limitName}"`,
  ]);
}

export async function removeProfile(
  api: RouterOSAPI,
  version: number,
  id: string
): Promise<void> {
  if (version >= 7) {
    await api.write(umPath(version, "/profile/remove"), [`=numbers=${id}`]);
  } else {
    await api.write(umPath(version, "/profile/remove"), [`=.id=${id}`]);
  }
}

export async function setProfile(
  api: RouterOSAPI,
  version: number,
  id: string,
  params: Record<string, string>
): Promise<void> {
  const args = version >= 7 ? [`=numbers=${id}`] : [`=.id=${id}`];
  for (const [key, value] of Object.entries(params)) {
    args.push(`=${key}=${value}`);
  }
  await api.write(umPath(version, "/profile/set"), args);
}

// ── User Manager: Limitations ─────────────────────────────────────────────

export async function getLimitations(api: RouterOSAPI, version: number): Promise<Limitation[]> {
  const limPath = version >= 7 ? "/limitation/print" : "/profile/limitation/print";
  const raw = (await api.write(umPath(version, limPath), [
    "=.proplist=.id,name,transfer-limit,uptime-limit,owner",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    name: r.name || "",
    transferLimit: r["transfer-limit"] || "",
    uptimeLimit: r["uptime-limit"] || "",
    owner: r.owner || "",
  }));
}

export async function setLimitation(
  api: RouterOSAPI,
  version: number,
  id: string,
  params: Record<string, string>
): Promise<void> {
  const limPath = version >= 7 ? "/limitation/set" : "/profile/limitation/set";
  const args = version >= 7 ? [`=numbers=${id}`] : [`=.id=${id}`];
  for (const [key, value] of Object.entries(params)) {
    args.push(`=${key}=${value}`);
  }
  await api.write(umPath(version, limPath), args);
}

export async function getProfileLimitations(
  api: RouterOSAPI,
  version: number
): Promise<ProfileLimitation[]> {
  const linkPath =
    version >= 7 ? "/profile-limitation/print" : "/profile/profile-limitation/print";
  const raw = (await api.write(umPath(version, linkPath), [
    "=.proplist=.id,profile,limitation",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    profile: r.profile || "",
    limitation: r.limitation || "",
  }));
}

export async function getUserProfileAssignments(
  api: RouterOSAPI,
  version: number
): Promise<UserProfileAssignment[]> {
  const raw = (await api.write(umPath(version, "/user-profile/print"), [
    "=.proplist=.id,user,profile",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    user: r.user || "",
    profile: r.profile || "",
  }));
}

// ── User Manager: Customers ───────────────────────────────────────────────

export async function getCustomers(api: RouterOSAPI, version: number): Promise<Customer[]> {
  const raw = (await api.write(umPath(version, "/customer/print"), [
    "=.proplist=login",
  ])) as Record<string, string>[];
  return raw.map((r) => ({ login: r.login || "" }));
}

// ── User Manager: Payments ────────────────────────────────────────────────

export async function getPayments(api: RouterOSAPI, version: number): Promise<Payment[]> {
  const raw = (await api.write(umPath(version, "/payment/print"), [
    "=.proplist=user,price,profile,method",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    user: r.user || "",
    price: r.price || "0",
    profile: r.profile || "",
    method: r.method || "",
  }));
}

// ── User Manager: Sessions ────────────────────────────────────────────────

export async function getSessions(
  api: RouterOSAPI,
  version: number,
  username: string
): Promise<RouterSession[]> {
  const fields =
    version >= 7
      ? "=.proplist=user,started,uptime,upload,download"
      : "=.proplist=user,from-time,uptime,upload,download";

  const raw = (await api.write(umPath(version, "/session/print"), [
    fields,
    `?user=${username}`,
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    user: r.user || "",
    started: r.started || r["from-time"] || "",
    uptime: r.uptime || "",
    upload: r.upload || "0",
    download: r.download || "0",
  }));
}

export async function getAllSessions(
  api: RouterOSAPI,
  version: number
): Promise<SessionRecord[]> {
  const fields =
    version >= 7
      ? "=.proplist=user,started,uptime,upload,download,nas-port-id"
      : "=.proplist=user,from-time,uptime,upload,download,nas-port-id";

  const raw = (await api.write(umPath(version, "/session/print"), [fields])) as Record<
    string,
    string
  >[];

  return raw.map((r) => ({
    user: r.user || "",
    started: r.started || r["from-time"] || "",
    uptime: r.uptime || "",
    upload: r.upload || "0",
    download: r.download || "0",
    nasPortId: r["nas-port-id"] || "",
  }));
}

// ── User Manager: Database ────────────────────────────────────────────────

export async function optimizeDatabase(api: RouterOSAPI, version: number): Promise<void> {
  if (version >= 7) {
    await api.write(umPath(version, "/database/optimize-db"));
  } else {
    await api.write(umPath(version, "/database/rebuild"));
  }
}

export async function saveDatabase(api: RouterOSAPI, version: number): Promise<void> {
  await api.write(umPath(version, "/database/save"));
}

// ── Hotspot: Users ────────────────────────────────────────────────────────

export async function getHotspotUsers(api: RouterOSAPI): Promise<HotspotUser[]> {
  const raw = (await api.write("/ip/hotspot/user/print", [
    "=.proplist=.id,name,password,profile,uptime,limit-uptime,bytes-out,bytes-in,limit-bytes-total,disabled,comment",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    name: r.name || "",
    password: r.password || "",
    profile: r.profile || "",
    uptime: r.uptime || "0s",
    limitUptime: r["limit-uptime"] || "",
    bytesIn: r["bytes-in"] || "0",
    bytesOut: r["bytes-out"] || "0",
    limitBytesTotal: r["limit-bytes-total"] || "0",
    disabled: r.disabled === "true" || r.disabled === "yes",
    comment: r.comment || "",
  }));
}

export async function addHotspotUser(
  api: RouterOSAPI,
  name: string,
  password: string,
  profile: string
): Promise<void> {
  await api.write("/ip/hotspot/user/add", [
    `=name=${name}`,
    `=password=${password}`,
    `=profile="${profile}"`,
  ]);
}

export async function removeHotspotUser(api: RouterOSAPI, id: string): Promise<void> {
  await api.write("/ip/hotspot/user/remove", [`=.id=${id}`]);
}

export async function disableHotspotUser(api: RouterOSAPI, id: string): Promise<void> {
  await api.write("/ip/hotspot/user/disable", [`=.id=${id}`]);
}

export async function enableHotspotUser(api: RouterOSAPI, id: string): Promise<void> {
  await api.write("/ip/hotspot/user/enable", [`=.id=${id}`]);
}

export async function setHotspotUser(
  api: RouterOSAPI,
  id: string,
  params: Record<string, string>
): Promise<void> {
  const args = [`=.id=${id}`];
  for (const [key, value] of Object.entries(params)) {
    args.push(`=${key}=${value}`);
  }
  await api.write("/ip/hotspot/user/set", args);
}

export async function resetHotspotUserCounters(api: RouterOSAPI, id: string): Promise<void> {
  await api.write("/ip/hotspot/user/reset-counters", [`=.id=${id}`]);
}

// ── Hotspot: Profiles ─────────────────────────────────────────────────────

export async function getHotspotProfiles(api: RouterOSAPI): Promise<RouterProfile[]> {
  const raw = (await api.write("/ip/hotspot/user/profile/print", [
    "=.proplist=.id,name",
  ])) as Record<string, string>[];
  return raw.map((r) => ({
    id: r[".id"] || "",
    name: r.name || "",
    price: "",
    validity: "",
  }));
}

export async function removeHotspotProfile(api: RouterOSAPI, id: string): Promise<void> {
  await api.write("/ip/hotspot/user/profile/remove", [`=.id=${id}`]);
}

export async function addHotspotProfile(
  api: RouterOSAPI,
  name: string,
  params?: Record<string, string>
): Promise<void> {
  const args = [`=name=${name}`];
  if (params) {
    for (const [key, value] of Object.entries(params)) {
      args.push(`=${key}=${value}`);
    }
  }
  await api.write("/ip/hotspot/user/profile/add", args);
}

// ── Hotspot: Servers ──────────────────────────────────────────────────────

export async function getHotspotServers(api: RouterOSAPI): Promise<HotspotServer[]> {
  const raw = (await api.write("/ip/hotspot/print", [
    "=.proplist=.id,name,interface,disabled",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    name: r.name || "",
    interface: r.interface || "",
    disabled: r.disabled === "true" || r.disabled === "yes",
  }));
}

// ── Hotspot: Active Connections ───────────────────────────────────────────

export async function getActiveConnections(api: RouterOSAPI): Promise<ActiveConnection[]> {
  const raw = (await api.write("/ip/hotspot/active/print", [
    "=.proplist=.id,user,uptime,address,bytes-in,bytes-out,mac-address",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    user: r.user || "",
    uptime: r.uptime || "",
    address: r.address || "",
    bytesIn: r["bytes-in"] || "0",
    bytesOut: r["bytes-out"] || "0",
    macAddress: r["mac-address"] || "",
  }));
}

export async function kickActiveConnection(api: RouterOSAPI, id: string): Promise<void> {
  await api.write("/ip/hotspot/active/remove", [`=.id=${id}`]);
}

// ── Hotspot: IP Bindings ──────────────────────────────────────────────────

export async function getIpBindings(api: RouterOSAPI): Promise<IpBinding[]> {
  const raw = (await api.write("/ip/hotspot/ip-binding/print", [
    "=.proplist=.id,mac-address,type,comment",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    macAddress: r["mac-address"] || "",
    type: r.type || "",
    comment: r.comment || "",
  }));
}

export async function addIpBinding(
  api: RouterOSAPI,
  macAddress: string,
  type: string,
  comment?: string
): Promise<void> {
  const args = [`=mac-address=${macAddress}`, `=type=${type}`];
  if (comment) args.push(`=comment=${comment}`);
  await api.write("/ip/hotspot/ip-binding/add", args);
}

export async function removeIpBinding(api: RouterOSAPI, id: string): Promise<void> {
  await api.write("/ip/hotspot/ip-binding/remove", [`=.id=${id}`]);
}

// ── System: Scripts ───────────────────────────────────────────────────────

export async function getSystemScripts(api: RouterOSAPI): Promise<SystemScript[]> {
  const raw = (await api.write("/system/script/print", [
    "=.proplist=.id,name,source",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    name: r.name || "",
    source: r.source || "",
  }));
}

export async function addSystemScript(api: RouterOSAPI, name: string, source: string): Promise<void> {
  await api.write("/system/script/add", [`=name=${name}`, `=source=${source}`]);
}

// ── System: Schedulers ────────────────────────────────────────────────────

export async function getSystemSchedulers(api: RouterOSAPI): Promise<SystemScheduler[]> {
  const raw = (await api.write("/system/scheduler/print", [
    "=.proplist=.id,name,on-event,interval",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    name: r.name || "",
    onEvent: r["on-event"] || "",
    interval: r.interval || "",
  }));
}

export async function addSystemScheduler(
  api: RouterOSAPI,
  name: string,
  onEvent: string,
  interval: string
): Promise<void> {
  await api.write("/system/scheduler/add", [
    `=name=${name}`,
    `=on-event=${onEvent}`,
    `=interval=${interval}`,
  ]);
}

// ── System: Reboot ────────────────────────────────────────────────────────

export async function rebootRouter(api: RouterOSAPI): Promise<void> {
  await api.write("/system/reboot");
}

// ── System: Export ────────────────────────────────────────────────────────

export async function exportConfig(api: RouterOSAPI): Promise<string> {
  const raw = (await api.write("/export")) as Record<string, string>[];
  return raw.map((r) => r.ret || r.message || "").join("\n");
}

// ── Network: Interfaces ───────────────────────────────────────────────────

export async function getInterfaces(api: RouterOSAPI): Promise<NetworkInterface[]> {
  const raw = (await api.write("/interface/print", [
    "=.proplist=.id,name,type,mac-address,disabled",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    id: r[".id"] || "",
    name: r.name || "",
    type: r.type || "",
    macAddress: r["mac-address"] || "",
    disabled: r.disabled === "true" || r.disabled === "yes",
  }));
}

export async function getInterfaceMac(api: RouterOSAPI, interfaceName: string): Promise<string> {
  const raw = (await api.write("/interface/print", [
    "=.proplist=mac-address",
    `?default-name=${interfaceName}`,
  ])) as Record<string, string>[];
  return raw[0]?.["mac-address"] || "";
}

// ── Network: Neighbors ────────────────────────────────────────────────────

export async function getNeighbors(api: RouterOSAPI): Promise<Neighbor[]> {
  const raw = (await api.write("/ip/neighbor/print", [
    "=.proplist=address,mac-address,identity,platform,board,interface",
  ])) as Record<string, string>[];

  return raw.map((r) => ({
    address: r.address || "",
    macAddress: r["mac-address"] || "",
    identity: r.identity || "",
    platform: r.platform || "",
    board: r.board || "",
    interface: r.interface || "",
  }));
}

// ── Batch: User Add ───────────────────────────────────────────────────────

export async function batchAddUsersSingle(
  api: RouterOSAPI,
  version: number,
  u: BatchAddUser
): Promise<void> {
  let addResult: Record<string, string>[];

  if (version >= 7) {
    const params = [`=name=${u.username}`, "=shared-users=0"];
    if (u.password) params.push(`=password=${u.password}`);
    addResult = (await api.write(umPath(version, "/user/add"), params)) as Record<
      string,
      string
    >[];
  } else {
    const params = [`=username=${u.username}`];
    if (u.password) params.push(`=password=${u.password}`);
    if (u.customer) params.push(`=customer=${u.customer}`);
    addResult = (await api.write(umPath(version, "/user/add"), params)) as Record<
      string,
      string
    >[];
  }

  const userId = addResult[0]?.ret || addResult[0]?.[".id"] || "";

  if (u.profile) {
    if (version >= 7) {
      await api.write("/user-manager/user-profile/add", [
        `=user=${userId}`,
        `=profile="${u.profile}"`,
      ]);
    } else {
      await api.write(umPath(version, "/user/create-and-activate-profile"), [
        `=numbers=${userId}`,
        `=profile="${u.profile}"`,
        `=customer=${u.customer || "admin"}`,
      ]);
    }
  }
}

export async function batchAddUsers(
  api: RouterOSAPI,
  version: number,
  users: BatchAddUser[]
): Promise<{ success: string[]; failed: { username: string; error: string }[] }> {
  const success: string[] = [];
  const failed: { username: string; error: string }[] = [];

  for (const u of users) {
    try {
      await batchAddUsersSingle(api, version, u);
      success.push(u.username);
    } catch (err: unknown) {
      const msg = err instanceof Error ? err.message : String(err);
      failed.push({ username: u.username, error: msg });
    }
  }

  return { success, failed };
}
