export interface VoucherCard {
  username: string;
  password: string;
  profile: string;
  status?: "pending" | "success" | "error";
  error?: string;
}

export interface VoucherBatch {
  id: string;
  type: "hotspot" | "usermanager";
  profile: string;
  cards: VoucherCard[];
  createdAt: string;
  pushed: boolean;
  routerHost?: string;
  pushResults?: { success: number; failed: number };
  salesPoint?: string;
  unitPrice?: number;
}

export type CharType = "alphanumeric" | "letters" | "numbers";
export type PasswordMode = "random" | "same" | "empty";
export type PrintLayoutMode = "grid" | "auto";

export interface PrintTemplate {
  id: string;
  name: string;
  profileName: string;
  bgImage?: string;
  fields: FieldPosition[];
  printCols: number;
  printRows: number;
  cardTitle: string;
  cardSubtitle: string;
  routerHost?: string;
  cloudId?: string;
  voucherType?: "hotspot" | "usermanager";
  prefix?: string;
  nameLength?: number;
  passLength?: number;
  charType?: CharType;
  passwordMode?: PasswordMode;
  unitPrice?: number;
  validityDays?: number;
  transferLimit?: number;
  packageDisplayName?: string;
  hoursLabel?: string;
  dataQuotaLabel?: string;
}

export interface FieldPosition {
  id: string;
  type: "username" | "password" | "profile" | "package_name" | "title" | "subtitle" | "price" | "sales_point" | "qr" | "days" | "hours" | "data_quota" | "transfer_limit";
  label: string;
  x: number;
  y: number;
  fontSize: number;
  color: string;
  visible: boolean;
}

export type BackgroundPreset = {
  id: string;
  name: string;
  dataUrl: string;
};

export type PendingSaleRecord = {
  user_id: string;
  batch_id: string;
  profile_name: string;
  card_count: number;
  success_count: number;
  failed_count: number;
  unit_price: number;
  total_amount: number;
  voucher_type: string;
  router_host: string;
  notes: string;
  sales_point: string;
};
