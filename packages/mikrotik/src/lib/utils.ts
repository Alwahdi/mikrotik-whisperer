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

/**
 * RouterOS on-login script that stamps the first login date as 'mums-{date}' in the user comment field.
 * Used by the auto-expiry system to track when a user first connected.
 */
export const ON_LOGIN_SCRIPT = `{:local date [/system clock get date];:if ([/ip hotspot user get $user comment]="") do={[/ip hotspot user set $user comment="mums-$date"]}}`;
