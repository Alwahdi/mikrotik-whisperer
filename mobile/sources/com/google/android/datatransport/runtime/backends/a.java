package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.b;

final class a extends b {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final b.a f1368a;

    a(b.a status, long nextRequestWaitMillis) {
        if (status != null) {
            this.f1368a = status;
            this.a = nextRequestWaitMillis;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public b.a c() {
        return this.f1368a;
    }

    public long b() {
        return this.a;
    }

    public String toString() {
        return "BackendResponse{status=" + this.f1368a + ", nextRequestWaitMillis=" + this.a + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof b)) {
            return false;
        }
        b that = (b) o;
        if (!this.f1368a.equals(that.c()) || this.a != that.b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.a;
        return (((1 * 1000003) ^ this.f1368a.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }
}
