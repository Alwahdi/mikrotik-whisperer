package io.grpc.internal;

import io.grpc.p;
import java.util.Collections;
import java.util.Set;

final class j0 {
    static final j0 a = new j0(1, 0, Collections.emptySet());

    /* renamed from: a  reason: collision with other field name */
    final int f3458a;

    /* renamed from: a  reason: collision with other field name */
    final long f3459a;

    /* renamed from: a  reason: collision with other field name */
    final Set<p.b> f3460a;

    interface a {
        j0 a();
    }

    j0(int maxAttempts, long hedgingDelayNanos, Set<p.b> nonFatalStatusCodes) {
        this.f3458a = maxAttempts;
        this.f3459a = hedgingDelayNanos;
        this.f3460a = cs.m(nonFatalStatusCodes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        j0 that = (j0) other;
        if (this.f3458a == that.f3458a && this.f3459a == that.f3459a && f40.a(this.f3460a, that.f3460a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return f40.b(Integer.valueOf(this.f3458a), Long.valueOf(this.f3459a), this.f3460a);
    }

    public String toString() {
        return f20.c(this).b("maxAttempts", this.f3458a).c("hedgingDelayNanos", this.f3459a).d("nonFatalStatusCodes", this.f3460a).toString();
    }
}
