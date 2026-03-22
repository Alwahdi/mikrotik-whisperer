export function isPrivateIpv4(host: string): boolean {
  const normalized = host.trim().toLowerCase();
  if (!normalized) return false;

  return (
    /^10\.\d+\.\d+\.\d+$/.test(normalized) ||
    /^192\.168\.\d+\.\d+$/.test(normalized) ||
    /^172\.(1[6-9]|2\d|3[0-1])\.\d+\.\d+$/.test(normalized) ||
    /^(127\.0\.0\.1|localhost)$/i.test(normalized) ||
    (!normalized.includes(".") && normalized.length > 0)
  );
}

export function assertLocalHost(host: string) {
  if (!isPrivateIpv4(host)) {
    throw new Error("هذا الوكيل المحلي يدعم فقط عناوين LAN المحلية (192.168.x.x / 10.x.x.x / 172.16-31.x.x)");
  }
}
