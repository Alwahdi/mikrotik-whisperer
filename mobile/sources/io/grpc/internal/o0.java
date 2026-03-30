package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import io.grpc.internal.p;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class o0 {
    private static final long c = TimeUnit.SECONDS.toNanos(10);
    private static final long d = TimeUnit.MILLISECONDS.toNanos(10);
    /* access modifiers changed from: private */
    public final long a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final hn0 f3556a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final d f3557a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public e f3558a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Runnable f3559a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ScheduledExecutorService f3560a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ScheduledFuture<?> f3561a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f3562a;
    /* access modifiers changed from: private */
    public final long b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final Runnable f3563b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public ScheduledFuture<?> f3564b;

    public interface d {
        void a();

        void b();
    }

    private enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            boolean shouldShutdown = false;
            synchronized (o0.this) {
                e a2 = o0.this.f3558a;
                e eVar = e.DISCONNECTED;
                if (a2 != eVar) {
                    e unused = o0.this.f3558a = eVar;
                    shouldShutdown = true;
                }
            }
            if (shouldShutdown) {
                o0.this.f3557a.a();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            boolean shouldSendPing = false;
            synchronized (o0.this) {
                ScheduledFuture unused = o0.this.f3564b = null;
                e a2 = o0.this.f3558a;
                e eVar = e.PING_SCHEDULED;
                if (a2 == eVar) {
                    shouldSendPing = true;
                    e unused2 = o0.this.f3558a = e.PING_SENT;
                    o0 o0Var = o0.this;
                    ScheduledFuture unused3 = o0Var.f3561a = o0Var.f3560a.schedule(o0.this.f3559a, o0.this.b, TimeUnit.NANOSECONDS);
                } else if (o0.this.f3558a == e.PING_DELAYED) {
                    o0 o0Var2 = o0.this;
                    ScheduledExecutorService h = o0Var2.f3560a;
                    Runnable i = o0.this.f3563b;
                    long j = o0.this.a;
                    hn0 k = o0.this.f3556a;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    ScheduledFuture unused4 = o0Var2.f3564b = h.schedule(i, j - k.d(timeUnit), timeUnit);
                    e unused5 = o0.this.f3558a = eVar;
                }
            }
            if (shouldSendPing) {
                o0.this.f3557a.b();
            }
        }
    }

    public o0(d keepAlivePinger, ScheduledExecutorService scheduler, long keepAliveTimeInNanos, long keepAliveTimeoutInNanos, boolean keepAliveDuringTransportIdle) {
        this(keepAlivePinger, scheduler, hn0.c(), keepAliveTimeInNanos, keepAliveTimeoutInNanos, keepAliveDuringTransportIdle);
    }

    o0(d keepAlivePinger, ScheduledExecutorService scheduler, hn0 stopwatch, long keepAliveTimeInNanos, long keepAliveTimeoutInNanos, boolean keepAliveDuringTransportIdle) {
        this.f3558a = e.IDLE;
        this.f3559a = new ty(new a());
        this.f3563b = new ty(new b());
        this.f3557a = (d) v90.o(keepAlivePinger, "keepAlivePinger");
        this.f3560a = (ScheduledExecutorService) v90.o(scheduler, "scheduler");
        this.f3556a = (hn0) v90.o(stopwatch, NotificationCompat.CATEGORY_STOPWATCH);
        this.a = keepAliveTimeInNanos;
        this.b = keepAliveTimeoutInNanos;
        this.f3562a = keepAliveDuringTransportIdle;
        stopwatch.f().g();
    }

    public synchronized void p() {
        if (this.f3562a) {
            n();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m() {
        /*
            r5 = this;
            monitor-enter(r5)
            hn0 r0 = r5.f3556a     // Catch:{ all -> 0x004d }
            hn0 r0 = r0.f()     // Catch:{ all -> 0x004d }
            r0.g()     // Catch:{ all -> 0x004d }
            io.grpc.internal.o0$e r0 = r5.f3558a     // Catch:{ all -> 0x004d }
            io.grpc.internal.o0$e r1 = io.grpc.internal.o0.e.PING_SCHEDULED     // Catch:{ all -> 0x004d }
            if (r0 != r1) goto L_0x0015
            io.grpc.internal.o0$e r0 = io.grpc.internal.o0.e.PING_DELAYED     // Catch:{ all -> 0x004d }
            r5.f3558a = r0     // Catch:{ all -> 0x004d }
            goto L_0x004b
        L_0x0015:
            io.grpc.internal.o0$e r2 = io.grpc.internal.o0.e.PING_SENT     // Catch:{ all -> 0x004d }
            if (r0 == r2) goto L_0x001d
            io.grpc.internal.o0$e r2 = io.grpc.internal.o0.e.IDLE_AND_PING_SENT     // Catch:{ all -> 0x004d }
            if (r0 != r2) goto L_0x004b
        L_0x001d:
            java.util.concurrent.ScheduledFuture<?> r0 = r5.f3561a     // Catch:{ all -> 0x004d }
            r2 = 0
            if (r0 == 0) goto L_0x0025
            r0.cancel(r2)     // Catch:{ all -> 0x004d }
        L_0x0025:
            io.grpc.internal.o0$e r0 = r5.f3558a     // Catch:{ all -> 0x004d }
            io.grpc.internal.o0$e r3 = io.grpc.internal.o0.e.IDLE_AND_PING_SENT     // Catch:{ all -> 0x004d }
            if (r0 != r3) goto L_0x0031
            io.grpc.internal.o0$e r0 = io.grpc.internal.o0.e.IDLE     // Catch:{ all -> 0x004d }
            r5.f3558a = r0     // Catch:{ all -> 0x004d }
            monitor-exit(r5)
            return
        L_0x0031:
            r5.f3558a = r1     // Catch:{ all -> 0x004d }
            java.util.concurrent.ScheduledFuture<?> r0 = r5.f3564b     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0038
            r2 = 1
        L_0x0038:
            java.lang.String r0 = "There should be no outstanding pingFuture"
            defpackage.v90.u(r2, r0)     // Catch:{ all -> 0x004d }
            java.util.concurrent.ScheduledExecutorService r0 = r5.f3560a     // Catch:{ all -> 0x004d }
            java.lang.Runnable r1 = r5.f3563b     // Catch:{ all -> 0x004d }
            long r2 = r5.a     // Catch:{ all -> 0x004d }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x004d }
            java.util.concurrent.ScheduledFuture r0 = r0.schedule(r1, r2, r4)     // Catch:{ all -> 0x004d }
            r5.f3564b = r0     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r5)
            return
        L_0x004d:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.o0.m():void");
    }

    public synchronized void n() {
        e eVar = this.f3558a;
        if (eVar == e.IDLE) {
            this.f3558a = e.PING_SCHEDULED;
            if (this.f3564b == null) {
                ScheduledExecutorService scheduledExecutorService = this.f3560a;
                Runnable runnable = this.f3563b;
                long j = this.a;
                hn0 hn0 = this.f3556a;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                this.f3564b = scheduledExecutorService.schedule(runnable, j - hn0.d(timeUnit), timeUnit);
            }
        } else if (eVar == e.IDLE_AND_PING_SENT) {
            this.f3558a = e.PING_SENT;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void o() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f3562a     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            io.grpc.internal.o0$e r0 = r2.f3558a     // Catch:{ all -> 0x0021 }
            io.grpc.internal.o0$e r1 = io.grpc.internal.o0.e.PING_SCHEDULED     // Catch:{ all -> 0x0021 }
            if (r0 == r1) goto L_0x0011
            io.grpc.internal.o0$e r1 = io.grpc.internal.o0.e.PING_DELAYED     // Catch:{ all -> 0x0021 }
            if (r0 != r1) goto L_0x0015
        L_0x0011:
            io.grpc.internal.o0$e r0 = io.grpc.internal.o0.e.IDLE     // Catch:{ all -> 0x0021 }
            r2.f3558a = r0     // Catch:{ all -> 0x0021 }
        L_0x0015:
            io.grpc.internal.o0$e r0 = r2.f3558a     // Catch:{ all -> 0x0021 }
            io.grpc.internal.o0$e r1 = io.grpc.internal.o0.e.PING_SENT     // Catch:{ all -> 0x0021 }
            if (r0 != r1) goto L_0x001f
            io.grpc.internal.o0$e r0 = io.grpc.internal.o0.e.IDLE_AND_PING_SENT     // Catch:{ all -> 0x0021 }
            r2.f3558a = r0     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r2)
            return
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.o0.o():void");
    }

    public synchronized void q() {
        e eVar = this.f3558a;
        e eVar2 = e.DISCONNECTED;
        if (eVar != eVar2) {
            this.f3558a = eVar2;
            ScheduledFuture<?> scheduledFuture = this.f3561a;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledFuture<?> scheduledFuture2 = this.f3564b;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(false);
                this.f3564b = null;
            }
        }
    }

    public static long l(long keepAliveTimeInNanos) {
        return Math.max(keepAliveTimeInNanos, c);
    }

    public static final class c implements d {
        /* access modifiers changed from: private */
        public final bc a;

        public c(bc transport) {
            this.a = transport;
        }

        class a implements p.a {
            a() {
            }

            public void a(long roundTripTimeNanos) {
            }

            public void b(Throwable cause) {
                c.this.a.c(io.grpc.p.p.q("Keepalive failed. The connection is likely gone"));
            }
        }

        public void b() {
            this.a.g(new a(), com.google.common.util.concurrent.b.a());
        }

        public void a() {
            this.a.c(io.grpc.p.p.q("Keepalive failed. The connection is likely gone"));
        }
    }
}
