/**
 * Generate a backup timestamp matching the mobile app format: MUMS-dd-MM-yyyy_HH-mm-ss
 */
export function getBackupTimestamp(): string {
  const now = new Date();
  const pad = (n: number) => String(n).padStart(2, "0");
  const date = `${pad(now.getDate())}-${pad(now.getMonth() + 1)}-${now.getFullYear()}`;
  const time = `${pad(now.getHours())}-${pad(now.getMinutes())}-${pad(now.getSeconds())}`;
  return `MUMS-${date}_${time}`;
}
