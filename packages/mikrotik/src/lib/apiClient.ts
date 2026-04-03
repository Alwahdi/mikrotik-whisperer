// Client for calling Next.js API routes (replaces Supabase Edge Functions)

type ApiClientOptions = {
  timeoutMs?: number;
};

class ApiError extends Error {
  constructor(
    message: string,
    public status?: number
  ) {
    super(message);
    this.name = "ApiError";
  }
}

async function fetchWithTimeout(url: string, options: RequestInit, timeoutMs: number) {
  const controller = new AbortController();
  const timer = setTimeout(() => controller.abort(), timeoutMs);

  try {
    const response = await fetch(url, {
      ...options,
      signal: controller.signal,
    });

    if (!response.ok) {
      const errorData = await response.json().catch(() => ({ error: response.statusText }));
      throw new ApiError(errorData.error || `HTTP ${response.status}`, response.status);
    }

    return await response.json();
  } catch (error) {
    if (controller.signal.aborted) {
      throw new ApiError(`Request timeout after ${timeoutMs}ms`);
    }
    throw error;
  } finally {
    clearTimeout(timer);
  }
}

export async function apiGet(endpoint: string, options: ApiClientOptions = {}) {
  const timeoutMs = options.timeoutMs ?? 30000;
  return fetchWithTimeout(`/api/mikrotik${endpoint}`, {
    method: "GET",
    headers: { "Content-Type": "application/json" },
  }, timeoutMs);
}

export async function apiPost(endpoint: string, body: any, options: ApiClientOptions = {}) {
  const timeoutMs = options.timeoutMs ?? 30000;
  return fetchWithTimeout(`/api/mikrotik${endpoint}`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body),
  }, timeoutMs);
}

export async function apiPatch(endpoint: string, body: any, options: ApiClientOptions = {}) {
  const timeoutMs = options.timeoutMs ?? 30000;
  return fetchWithTimeout(`/api/mikrotik${endpoint}`, {
    method: "PATCH",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body),
  }, timeoutMs);
}

export async function apiDelete(endpoint: string, options: ApiClientOptions = {}) {
  const timeoutMs = options.timeoutMs ?? 30000;
  return fetchWithTimeout(`/api/mikrotik${endpoint}`, {
    method: "DELETE",
    headers: { "Content-Type": "application/json" },
  }, timeoutMs);
}
