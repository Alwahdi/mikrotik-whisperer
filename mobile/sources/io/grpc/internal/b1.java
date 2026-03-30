package io.grpc.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class b1 {
    /* access modifiers changed from: private */
    public long a;

    /* renamed from: a  reason: collision with other field name */
    private final hn0 f3325a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Runnable f3326a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Executor f3327a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ScheduledExecutorService f3328a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ScheduledFuture<?> f3329a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f3330a;

    b1(Runnable r, Executor serializingExecutor, ScheduledExecutorService scheduler, hn0 stopwatch) {
        this.f3326a = r;
        this.f3327a = serializingExecutor;
        this.f3328a = scheduler;
        this.f3325a = stopwatch;
        stopwatch.g();
    }

    /* access modifiers changed from: package-private */
    public void k(long delay, TimeUnit timeUnit) {
        long delayNanos = timeUnit.toNanos(delay);
        long newRunAtNanos = j() + delayNanos;
        this.f3330a = true;
        if (newRunAtNanos - this.a < 0 || this.f3329a == null) {
            ScheduledFuture<?> scheduledFuture = this.f3329a;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f3329a = this.f3328a.schedule(new c(), delayNanos, TimeUnit.NANOSECONDS);
        }
        this.a = newRunAtNanos;
    }

    /* access modifiers changed from: package-private */
    public void i(boolean permanent) {
        ScheduledFuture<?> scheduledFuture;
        this.f3330a = false;
        if (permanent && (scheduledFuture = this.f3329a) != null) {
            scheduledFuture.cancel(false);
            this.f3329a = null;
        }
    }

    private final class c implements Runnable {
        private c() {
        }

        public void run() {
            b1.this.f3327a.execute(new b());
        }
    }

    private final class b implements Runnable {
        private b() {
        }

        public void run() {
            if (!b1.this.f3330a) {
                ScheduledFuture unused = b1.this.f3329a = null;
                return;
            }
            long now = b1.this.j();
            if (b1.this.a - now > 0) {
                b1 b1Var = b1.this;
                ScheduledFuture unused2 = b1Var.f3329a = b1Var.f3328a.schedule(new c(), b1.this.a - now, TimeUnit.NANOSECONDS);
                return;
            }
            boolean unused3 = b1.this.f3330a = false;
            ScheduledFuture unused4 = b1.this.f3329a = null;
            b1.this.f3326a.run();
        }
    }

    /* access modifiers changed from: private */
    public long j() {
        return this.f3325a.d(TimeUnit.NANOSECONDS);
    }
}
