package io.grpc.internal;

import io.grpc.internal.p;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class l0 {
    private static final Logger a = Logger.getLogger(l0.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private final long f3470a;

    /* renamed from: a  reason: collision with other field name */
    private final hn0 f3471a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f3472a;

    /* renamed from: a  reason: collision with other field name */
    private Map<p.a, Executor> f3473a = new LinkedHashMap();

    /* renamed from: a  reason: collision with other field name */
    private boolean f3474a;
    private long b;

    public l0(long data, hn0 stopwatch) {
        this.f3470a = data;
        this.f3471a = stopwatch;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        e(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(io.grpc.internal.p.a r3, java.util.concurrent.Executor r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f3474a     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x000c
            java.util.Map<io.grpc.internal.p$a, java.util.concurrent.Executor> r0 = r2.f3473a     // Catch:{ all -> 0x0021 }
            r0.put(r3, r4)     // Catch:{ all -> 0x0021 }
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            return
        L_0x000c:
            java.lang.Throwable r0 = r2.f3472a     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0015
            java.lang.Runnable r0 = c(r3, r0)     // Catch:{ all -> 0x0021 }
            goto L_0x001b
        L_0x0015:
            long r0 = r2.b     // Catch:{ all -> 0x0021 }
            java.lang.Runnable r0 = b(r3, r0)     // Catch:{ all -> 0x0021 }
        L_0x001b:
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            e(r4, r0)
            return
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.l0.a(io.grpc.internal.p$a, java.util.concurrent.Executor):void");
    }

    public long h() {
        return this.f3470a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r4.hasNext() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r5 = r4.next();
        e(r5.getValue(), b((io.grpc.internal.p.a) r5.getKey(), r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r4 = r3.entrySet().iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.f3474a     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0008
            r0 = 0
            monitor-exit(r8)     // Catch:{ all -> 0x0044 }
            return r0
        L_0x0008:
            r0 = 1
            r8.f3474a = r0     // Catch:{ all -> 0x0044 }
            hn0 r1 = r8.f3471a     // Catch:{ all -> 0x0044 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x0044 }
            long r1 = r1.d(r2)     // Catch:{ all -> 0x0044 }
            r8.b = r1     // Catch:{ all -> 0x0044 }
            java.util.Map<io.grpc.internal.p$a, java.util.concurrent.Executor> r3 = r8.f3473a     // Catch:{ all -> 0x0044 }
            r4 = 0
            r8.f3473a = r4     // Catch:{ all -> 0x0044 }
            monitor-exit(r8)     // Catch:{ all -> 0x0044 }
            java.util.Set r4 = r3.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0023:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0043
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getValue()
            java.util.concurrent.Executor r6 = (java.util.concurrent.Executor) r6
            java.lang.Object r7 = r5.getKey()
            io.grpc.internal.p$a r7 = (io.grpc.internal.p.a) r7
            java.lang.Runnable r7 = b(r7, r1)
            e(r6, r7)
            goto L_0x0023
        L_0x0043:
            return r0
        L_0x0044:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0044 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.l0.d():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r1.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r2 = r1.next();
        g((io.grpc.internal.p.a) r2.getKey(), r2.getValue(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r1 = r0.entrySet().iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.lang.Throwable r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f3474a     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r5)     // Catch:{ all -> 0x0037 }
            return
        L_0x0007:
            r0 = 1
            r5.f3474a = r0     // Catch:{ all -> 0x0037 }
            r5.f3472a = r6     // Catch:{ all -> 0x0037 }
            java.util.Map<io.grpc.internal.p$a, java.util.concurrent.Executor> r0 = r5.f3473a     // Catch:{ all -> 0x0037 }
            r1 = 0
            r5.f3473a = r1     // Catch:{ all -> 0x0037 }
            monitor-exit(r5)     // Catch:{ all -> 0x0037 }
            java.util.Set r1 = r0.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            io.grpc.internal.p$a r3 = (io.grpc.internal.p.a) r3
            java.lang.Object r4 = r2.getValue()
            java.util.concurrent.Executor r4 = (java.util.concurrent.Executor) r4
            g(r3, r4, r6)
            goto L_0x001a
        L_0x0036:
            return
        L_0x0037:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0037 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.l0.f(java.lang.Throwable):void");
    }

    public static void g(p.a callback, Executor executor, Throwable cause) {
        e(executor, c(callback, cause));
    }

    private static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            a.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    class a implements Runnable {
        final /* synthetic */ long a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ p.a f3475a;

        a(p.a aVar, long j) {
            this.f3475a = aVar;
            this.a = j;
        }

        public void run() {
            this.f3475a.a(this.a);
        }
    }

    private static Runnable b(p.a callback, long roundTripTimeNanos) {
        return new a(callback, roundTripTimeNanos);
    }

    class b implements Runnable {
        final /* synthetic */ p.a a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Throwable f3476a;

        b(p.a aVar, Throwable th) {
            this.a = aVar;
            this.f3476a = th;
        }

        public void run() {
            this.a.b(this.f3476a);
        }
    }

    private static Runnable c(p.a callback, Throwable failureCause) {
        return new b(callback, failureCause);
    }
}
