package io.grpc.internal;

import io.grpc.p;
import java.util.Collections;
import java.util.Set;

final class d1 {
    static final d1 a = new d1(1, 0, 0, 1.0d, Collections.emptySet());

    /* renamed from: a  reason: collision with other field name */
    final double f3391a;

    /* renamed from: a  reason: collision with other field name */
    final int f3392a;

    /* renamed from: a  reason: collision with other field name */
    final long f3393a;

    /* renamed from: a  reason: collision with other field name */
    final Set<p.b> f3394a;
    final long b;

    interface a {
        d1 a();
    }

    d1(int maxAttempts, long initialBackoffNanos, long maxBackoffNanos, double backoffMultiplier, Set<p.b> retryableStatusCodes) {
        this.f3392a = maxAttempts;
        this.f3393a = initialBackoffNanos;
        this.b = maxBackoffNanos;
        this.f3391a = backoffMultiplier;
        this.f3394a = cs.m(retryableStatusCodes);
    }

    public int hashCode() {
        return f40.b(Integer.valueOf(this.f3392a), Long.valueOf(this.f3393a), Long.valueOf(this.b), Double.valueOf(this.f3391a), this.f3394a);
    }

    public boolean equals(Object other) {
        if (!(other instanceof d1)) {
            return false;
        }
        d1 that = (d1) other;
        if (this.f3392a == that.f3392a && this.f3393a == that.f3393a && this.b == that.b && Double.compare(this.f3391a, that.f3391a) == 0 && f40.a(this.f3394a, that.f3394a)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return f20.c(this).b("maxAttempts", this.f3392a).c("initialBackoffNanos", this.f3393a).c("maxBackoffNanos", this.b).a("backoffMultiplier", this.f3391a).d("retryableStatusCodes", this.f3394a).toString();
    }
}
