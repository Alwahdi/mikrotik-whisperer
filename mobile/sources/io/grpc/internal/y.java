package io.grpc.internal;

import io.grpc.internal.i;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public final class y implements i {
    private double a = 1.6d;

    /* renamed from: a  reason: collision with other field name */
    private long f3787a = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: a  reason: collision with other field name */
    private Random f3788a = new Random();
    private double b = 0.2d;

    /* renamed from: b  reason: collision with other field name */
    private long f3789b = TimeUnit.MINUTES.toNanos(2);
    private long c = this.f3787a;

    public static final class a implements i.a {
        public i a() {
            return new y();
        }
    }

    public long a() {
        long currentBackoffNanos = this.c;
        this.c = Math.min((long) (((double) currentBackoffNanos) * this.a), this.f3789b);
        double d = this.b;
        return b((-d) * ((double) currentBackoffNanos), d * ((double) currentBackoffNanos)) + currentBackoffNanos;
    }

    private long b(double low, double high) {
        v90.d(high >= low);
        return (long) ((this.f3788a.nextDouble() * (high - low)) + low);
    }
}
