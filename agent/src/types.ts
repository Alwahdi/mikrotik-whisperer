export type ConnectionMode = "rest" | "api";
export type ConnectionProtocol = "https" | "http" | "api-ssl" | "api-plain";

export interface RouterConfig {
  host: string;
  user: string;
  pass: string;
  port: string;
  protocol: ConnectionProtocol;
  mode: ConnectionMode;
}

export interface MikrotikCommand {
  command: string;
  args?: string[];
}

export interface MikrotikInvokeBody extends RouterConfig {
  endpoint?: string;
  action?: string;
  args?: string[];
  commands?: MikrotikCommand[];
}
