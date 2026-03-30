package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import java.util.Set;

final class c extends e.b {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<e.c> f1370a;
    private final long b;

    private c(long delta, long maxAllowedDelay, Set<e.c> flags) {
        this.a = delta;
        this.b = maxAllowedDelay;
        this.f1370a = flags;
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public Set<e.c> c() {
        return this.f1370a;
    }

    public String toString() {
        return "ConfigValue{delta=" + this.a + ", maxAllowedDelay=" + this.b + ", flags=" + this.f1370a + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof e.b)) {
            return false;
        }
        e.b that = (e.b) o;
        if (this.a == that.b() && this.b == that.d() && this.f1370a.equals(that.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        return (((((1 * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f1370a.hashCode();
    }

    static final class b extends e.b.a {
        private Long a;

        /* renamed from: a  reason: collision with other field name */
        private Set<e.c> f1371a;
        private Long b;

        b() {
        }

        public e.b.a b(long delta) {
            this.a = Long.valueOf(delta);
            return this;
        }

        public e.b.a d(long maxAllowedDelay) {
            this.b = Long.valueOf(maxAllowedDelay);
            return this;
        }

        public e.b.a c(Set<e.c> flags) {
            if (flags != null) {
                this.f1371a = flags;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        public e.b a() {
            String missing = "";
            if (this.a == null) {
                missing = missing + " delta";
            }
            if (this.b == null) {
                missing = missing + " maxAllowedDelay";
            }
            if (this.f1371a == null) {
                missing = missing + " flags";
            }
            if (missing.isEmpty()) {
                return new c(this.a.longValue(), this.b.longValue(), this.f1371a);
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
