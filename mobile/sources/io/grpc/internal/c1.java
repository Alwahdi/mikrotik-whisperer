package io.grpc.internal;

import androidx.core.app.NotificationManagerCompat;
import defpackage.a9;
import io.grpc.internal.RetriableStream;
import io.grpc.internal.d1;
import io.grpc.internal.j0;
import io.grpc.internal.k1;
import io.grpc.internal.o;
import io.grpc.l;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

abstract class c1<ReqT> implements z8 {
    static final l.g<String> a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final io.grpc.p f3339a = io.grpc.p.f3956b.q("Stream thrown away because RetriableStream committed");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static Random f3340a = new Random();
    static final l.g<String> b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final long f3341a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final r f3342a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public s f3343a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile w f3344a = new w(new ArrayList(8), Collections.emptyList(), (Collection<y>) null, (y) null, false, false, false, 0);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final z f3345a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final d1.a f3346a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public d1 f3347a;

    /* renamed from: a  reason: collision with other field name */
    private final j0.a f3348a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public j0 f3349a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public o f3350a;

    /* renamed from: a  reason: collision with other field name */
    private final io.grpc.l f3351a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final io.grpc.m<ReqT, ?> f3352a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Object f3353a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Executor f3354a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ScheduledExecutorService f3355a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final AtomicBoolean f3356a = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final vs f3357a = new vs();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f3358a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final long f3359b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public s f3360b;
    /* access modifiers changed from: private */
    public long c;
    /* access modifiers changed from: private */
    public long d;

    private interface p {
        void a(y yVar);
    }

    /* access modifiers changed from: package-private */
    public abstract z8 d0(a9.a aVar, io.grpc.l lVar);

    /* access modifiers changed from: package-private */
    public abstract void e0();

    /* access modifiers changed from: package-private */
    public abstract io.grpc.p f0();

    static {
        l.d<String> dVar = io.grpc.l.a;
        a = l.g.e("grpc-previous-rpc-attempts", dVar);
        b = l.g.e("grpc-retry-pushback-ms", dVar);
    }

    c1(io.grpc.m<ReqT, ?> method, io.grpc.l headers, r channelBufferUsed, long perRpcBufferLimit, long channelBufferLimit, Executor callExecutor, ScheduledExecutorService scheduledExecutorService, d1.a retryPolicyProvider, j0.a hedgingPolicyProvider, z throttle) {
        this.f3352a = method;
        this.f3342a = channelBufferUsed;
        this.f3341a = perRpcBufferLimit;
        this.f3359b = channelBufferLimit;
        this.f3354a = callExecutor;
        this.f3355a = scheduledExecutorService;
        this.f3351a = headers;
        this.f3346a = (d1.a) v90.o(retryPolicyProvider, "retryPolicyProvider");
        this.f3348a = (j0.a) v90.o(hedgingPolicyProvider, "hedgingPolicyProvider");
        this.f3345a = throttle;
    }

    /* access modifiers changed from: private */
    public Runnable W(y winningSubstream) {
        Future<?> retryFuture;
        Future<?> hedgingFuture;
        synchronized (this.f3353a) {
            if (this.f3344a.f3381a != null) {
                return null;
            }
            Collection<y> collection = this.f3344a.f3382a;
            this.f3344a = this.f3344a.c(winningSubstream);
            this.f3342a.a(-this.c);
            s sVar = this.f3343a;
            if (sVar != null) {
                retryFuture = sVar.b();
                this.f3343a = null;
            } else {
                retryFuture = null;
            }
            s sVar2 = this.f3360b;
            if (sVar2 != null) {
                Future<?> hedgingFuture2 = sVar2.b();
                this.f3360b = null;
                hedgingFuture = hedgingFuture2;
            } else {
                hedgingFuture = null;
            }
            c cVar = new c(collection, winningSubstream, retryFuture, hedgingFuture);
            return cVar;
        }
    }

    class c implements Runnable {
        final /* synthetic */ y a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Collection f3364a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Future f3365a;
        final /* synthetic */ Future b;

        c(Collection collection, y yVar, Future future, Future future2) {
            this.f3364a = collection;
            this.a = yVar;
            this.f3365a = future;
            this.b = future2;
        }

        public void run() {
            for (y substream : this.f3364a) {
                if (substream != this.a) {
                    substream.f3388a.b(c1.f3339a);
                }
            }
            Future future = this.f3365a;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.b;
            if (future2 != null) {
                future2.cancel(false);
            }
            c1.this.e0();
        }
    }

    /* access modifiers changed from: private */
    public void X(y winningSubstream) {
        Runnable postCommitTask = W(winningSubstream);
        if (postCommitTask != null) {
            postCommitTask.run();
        }
    }

    /* access modifiers changed from: private */
    public y Y(int previousAttemptCount) {
        y sub = new y(previousAttemptCount);
        sub.f3388a = d0(new a(new q(sub)), i0(this.f3351a, previousAttemptCount));
        return sub;
    }

    class a extends a9.a {
        final /* synthetic */ a9 a;

        a(a9 a9Var) {
            this.a = a9Var;
        }

        public a9 a(a9.b info, io.grpc.l headers) {
            return this.a;
        }
    }

    /* access modifiers changed from: package-private */
    public final io.grpc.l i0(io.grpc.l originalHeaders, int previousAttemptCount) {
        io.grpc.l newHeaders = new io.grpc.l();
        newHeaders.l(originalHeaders);
        if (previousAttemptCount > 0) {
            newHeaders.o(a, String.valueOf(previousAttemptCount));
        }
        return newHeaders;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0057, code lost:
        r3 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (r3.hasNext() == false) goto L_0x0004;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r5 = (io.grpc.internal.c1.p) r3.next();
        r4 = r8.f3344a;
        r6 = r4.f3381a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        if (r6 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006d, code lost:
        if (r6 == r9) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r4.f3385b == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0074, code lost:
        if (r6 != r9) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0076, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0079, code lost:
        defpackage.v90.u(r3, "substream should be CANCELLED_BECAUSE_COMMITTED already");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
        r5.a(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0004, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a0(io.grpc.internal.c1.y r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 128(0x80, float:1.794E-43)
            r2 = 0
        L_0x0004:
            java.lang.Object r3 = r8.f3353a
            monitor-enter(r3)
            io.grpc.internal.c1$w r4 = r8.f3344a     // Catch:{ all -> 0x0084 }
            io.grpc.internal.c1$y r5 = r4.f3381a     // Catch:{ all -> 0x0084 }
            if (r5 == 0) goto L_0x0018
            if (r5 == r9) goto L_0x0018
            monitor-exit(r3)     // Catch:{ all -> 0x0084 }
            z8 r3 = r9.f3388a
            io.grpc.p r4 = f3339a
            r3.b(r4)
            return
        L_0x0018:
            java.util.List<io.grpc.internal.c1$p> r5 = r4.f3383a     // Catch:{ all -> 0x0084 }
            int r5 = r5.size()     // Catch:{ all -> 0x0084 }
            if (r0 != r5) goto L_0x0028
            io.grpc.internal.c1$w r5 = r4.h(r9)     // Catch:{ all -> 0x0084 }
            r8.f3344a = r5     // Catch:{ all -> 0x0084 }
            monitor-exit(r3)     // Catch:{ all -> 0x0084 }
            return
        L_0x0028:
            boolean r5 = r9.f3389a     // Catch:{ all -> 0x0084 }
            if (r5 == 0) goto L_0x002e
            monitor-exit(r3)     // Catch:{ all -> 0x0084 }
            return
        L_0x002e:
            int r5 = r0 + r1
            java.util.List<io.grpc.internal.c1$p> r6 = r4.f3383a     // Catch:{ all -> 0x0084 }
            int r6 = r6.size()     // Catch:{ all -> 0x0084 }
            int r5 = java.lang.Math.min(r5, r6)     // Catch:{ all -> 0x0084 }
            if (r2 != 0) goto L_0x0049
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0084 }
            java.util.List<io.grpc.internal.c1$p> r7 = r4.f3383a     // Catch:{ all -> 0x0084 }
            java.util.List r7 = r7.subList(r0, r5)     // Catch:{ all -> 0x0084 }
            r6.<init>(r7)     // Catch:{ all -> 0x0084 }
            r2 = r6
            goto L_0x0055
        L_0x0049:
            r2.clear()     // Catch:{ all -> 0x0084 }
            java.util.List<io.grpc.internal.c1$p> r6 = r4.f3383a     // Catch:{ all -> 0x0084 }
            java.util.List r6 = r6.subList(r0, r5)     // Catch:{ all -> 0x0084 }
            r2.addAll(r6)     // Catch:{ all -> 0x0084 }
        L_0x0055:
            r0 = r5
            monitor-exit(r3)     // Catch:{ all -> 0x0084 }
            java.util.Iterator r3 = r2.iterator()
        L_0x005b:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0083
            java.lang.Object r5 = r3.next()
            io.grpc.internal.c1$p r5 = (io.grpc.internal.c1.p) r5
            io.grpc.internal.c1$w r4 = r8.f3344a
            io.grpc.internal.c1$y r6 = r4.f3381a
            if (r6 == 0) goto L_0x0070
            if (r6 == r9) goto L_0x0070
            goto L_0x0083
        L_0x0070:
            boolean r7 = r4.f3385b
            if (r7 == 0) goto L_0x007f
            if (r6 != r9) goto L_0x0078
            r3 = 1
            goto L_0x0079
        L_0x0078:
            r3 = 0
        L_0x0079:
            java.lang.String r6 = "substream should be CANCELLED_BECAUSE_COMMITTED already"
            defpackage.v90.u(r3, r6)
            return
        L_0x007f:
            r5.a(r9)
            goto L_0x005b
        L_0x0083:
            goto L_0x0004
        L_0x0084:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0084 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.c1.a0(io.grpc.internal.c1$y):void");
    }

    public final void k(o listener) {
        z zVar;
        this.f3350a = listener;
        io.grpc.p shutdownStatus = f0();
        if (shutdownStatus != null) {
            b(shutdownStatus);
            return;
        }
        synchronized (this.f3353a) {
            this.f3344a.f3383a.add(new o());
        }
        boolean z2 = false;
        y substream = Y(0);
        if (this.f3349a == null) {
            z2 = true;
        }
        v90.u(z2, "hedgingPolicy has been initialized unexpectedly");
        j0 a2 = this.f3348a.a();
        this.f3349a = a2;
        if (!j0.a.equals(a2)) {
            this.f3358a = true;
            this.f3347a = d1.a;
            s scheduledHedgingRef = null;
            synchronized (this.f3353a) {
                this.f3344a = this.f3344a.a(substream);
                if (c0(this.f3344a) && ((zVar = this.f3345a) == null || zVar.a())) {
                    s sVar = new s(this.f3353a);
                    scheduledHedgingRef = sVar;
                    this.f3360b = sVar;
                }
            }
            if (scheduledHedgingRef != null) {
                scheduledHedgingRef.c(this.f3355a.schedule(new u(scheduledHedgingRef), this.f3349a.f3459a, TimeUnit.NANOSECONDS));
            }
        }
        a0(substream);
    }

    class o implements p {
        o() {
        }

        public void a(y substream) {
            substream.f3388a.k(new x(substream));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        if (r1 == null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        r1.cancel(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        r3.c(r7.f3355a.schedule(new io.grpc.internal.c1.u(r7, r3), (long) r8.intValue(), java.util.concurrent.TimeUnit.MILLISECONDS));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g0(java.lang.Integer r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r8.intValue()
            if (r0 >= 0) goto L_0x000d
            r7.b0()
            return
        L_0x000d:
            java.lang.Object r0 = r7.f3353a
            monitor-enter(r0)
            io.grpc.internal.c1$s r1 = r7.f3360b     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return
        L_0x0016:
            java.util.concurrent.Future r1 = r1.b()     // Catch:{ all -> 0x0041 }
            io.grpc.internal.c1$s r2 = new io.grpc.internal.c1$s     // Catch:{ all -> 0x0041 }
            java.lang.Object r3 = r7.f3353a     // Catch:{ all -> 0x0041 }
            r2.<init>(r3)     // Catch:{ all -> 0x0041 }
            r3 = r2
            r7.f3360b = r2     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x002b
            r0 = 0
            r1.cancel(r0)
        L_0x002b:
            java.util.concurrent.ScheduledExecutorService r0 = r7.f3355a
            io.grpc.internal.c1$u r2 = new io.grpc.internal.c1$u
            r2.<init>(r3)
            int r4 = r8.intValue()
            long r4 = (long) r4
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r0 = r0.schedule(r2, r4, r6)
            r3.c(r0)
            return
        L_0x0041:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.c1.g0(java.lang.Integer):void");
    }

    private final class u implements Runnable {
        final s a;

        u(s scheduledHedging) {
            this.a = scheduledHedging;
        }

        class a implements Runnable {
            a() {
            }

            public void run() {
                c1 c1Var = c1.this;
                y newSubstream = c1Var.Y(c1Var.f3344a.a);
                boolean cancelled = false;
                s future = null;
                synchronized (c1.this.f3353a) {
                    if (u.this.a.a()) {
                        cancelled = true;
                    } else {
                        c1 c1Var2 = c1.this;
                        w unused = c1Var2.f3344a = c1Var2.f3344a.a(newSubstream);
                        c1 c1Var3 = c1.this;
                        if (!c1Var3.c0(c1Var3.f3344a) || (c1.this.f3345a != null && !c1.this.f3345a.a())) {
                            c1 c1Var4 = c1.this;
                            w unused2 = c1Var4.f3344a = c1Var4.f3344a.d();
                            s unused3 = c1.this.f3360b = null;
                        } else {
                            c1 c1Var5 = c1.this;
                            s sVar = new s(c1Var5.f3353a);
                            future = sVar;
                            s unused4 = c1Var5.f3360b = sVar;
                        }
                    }
                }
                if (cancelled) {
                    newSubstream.f3388a.b(io.grpc.p.f3956b.q("Unneeded hedging"));
                    return;
                }
                if (future != null) {
                    future.c(c1.this.f3355a.schedule(new u(future), c1.this.f3349a.f3459a, TimeUnit.NANOSECONDS));
                }
                c1.this.a0(newSubstream);
            }
        }

        public void run() {
            c1.this.f3354a.execute(new a());
        }
    }

    public final void b(io.grpc.p reason) {
        y noopSubstream = new y(0);
        noopSubstream.f3388a = new m30();
        Runnable runnable = W(noopSubstream);
        if (runnable != null) {
            this.f3350a.d(reason, new io.grpc.l());
            runnable.run();
            return;
        }
        this.f3344a.f3381a.f3388a.b(reason);
        synchronized (this.f3353a) {
            this.f3344a = this.f3344a.b();
        }
    }

    private void Z(p bufferEntry) {
        Collection<y> collection;
        synchronized (this.f3353a) {
            if (!this.f3344a.f3384a) {
                this.f3344a.f3383a.add(bufferEntry);
            }
            collection = this.f3344a.f3382a;
        }
        for (y substream : collection) {
            bufferEntry.a(substream);
        }
    }

    public final void g(InputStream message) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    /* access modifiers changed from: package-private */
    public final void h0(ReqT message) {
        w savedState = this.f3344a;
        if (savedState.f3384a) {
            savedState.f3381a.f3388a.g(this.f3352a.j(message));
        } else {
            Z(new n(message));
        }
    }

    class n implements p {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Object f3373a;

        n(Object obj) {
            this.f3373a = obj;
        }

        public void a(y substream) {
            substream.f3388a.g(c1.this.f3352a.j(this.f3373a));
        }
    }

    public final void f(int numMessages) {
        w savedState = this.f3344a;
        if (savedState.f3384a) {
            savedState.f3381a.f3388a.f(numMessages);
        } else {
            Z(new m(numMessages));
        }
    }

    class m implements p {
        final /* synthetic */ int a;

        m(int i) {
            this.a = i;
        }

        public void a(y substream) {
            substream.f3388a.f(this.a);
        }
    }

    public final void flush() {
        w savedState = this.f3344a;
        if (savedState.f3384a) {
            savedState.f3381a.f3388a.flush();
        } else {
            Z(new g());
        }
    }

    class g implements p {
        g() {
        }

        public void a(y substream) {
            substream.f3388a.flush();
        }
    }

    class l implements p {
        l() {
        }

        public void a(y substream) {
            substream.f3388a.o();
        }
    }

    public void o() {
        Z(new l());
    }

    class d implements p {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ tb f3366a;

        d(tb tbVar) {
            this.f3366a = tbVar;
        }

        public void a(y substream) {
            substream.f3388a.e(this.f3366a);
        }
    }

    public final void e(tb compressor) {
        Z(new d(compressor));
    }

    class h implements p {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f3369a;

        h(boolean z) {
            this.f3369a = z;
        }

        public void a(y substream) {
            substream.f3388a.l(this.f3369a);
        }
    }

    public final void l(boolean fullStreamDecompression) {
        Z(new h(fullStreamDecompression));
    }

    class i implements p {
        i() {
        }

        public void a(y substream) {
            substream.f3388a.m();
        }
    }

    public final void m() {
        Z(new i());
    }

    class b implements p {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String f3362a;

        b(String str) {
            this.f3362a = str;
        }

        public void a(y substream) {
            substream.f3388a.j(this.f3362a);
        }
    }

    public final void j(String authority) {
        Z(new b(authority));
    }

    class f implements p {
        final /* synthetic */ gf a;

        f(gf gfVar) {
            this.a = gfVar;
        }

        public void a(y substream) {
            substream.f3388a.d(this.a);
        }
    }

    public final void d(gf decompressorRegistry) {
        Z(new f(decompressorRegistry));
    }

    class j implements p {
        final /* synthetic */ int a;

        j(int i) {
            this.a = i;
        }

        public void a(y substream) {
            substream.f3388a.c(this.a);
        }
    }

    public final void c(int maxSize) {
        Z(new j(maxSize));
    }

    class k implements p {
        final /* synthetic */ int a;

        k(int i) {
            this.a = i;
        }

        public void a(y substream) {
            substream.f3388a.a(this.a);
        }
    }

    public final void a(int maxSize) {
        Z(new k(maxSize));
    }

    class e implements p {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ ze f3367a;

        e(ze zeVar) {
            this.f3367a = zeVar;
        }

        public void a(y substream) {
            substream.f3388a.h(this.f3367a);
        }
    }

    public final void h(ze deadline) {
        Z(new e(deadline));
    }

    public void n(vs insight) {
        w currentState;
        synchronized (this.f3353a) {
            insight.b("closed", this.f3357a);
            currentState = this.f3344a;
        }
        if (currentState.f3381a != null) {
            vs substreamInsight = new vs();
            currentState.f3381a.f3388a.n(substreamInsight);
            insight.b("committed", substreamInsight);
            return;
        }
        vs openSubstreamsInsight = new vs();
        for (y sub : currentState.f3382a) {
            vs substreamInsight2 = new vs();
            sub.f3388a.n(substreamInsight2);
            openSubstreamsInsight.a(substreamInsight2);
        }
        insight.b("open", openSubstreamsInsight);
    }

    /* access modifiers changed from: private */
    public boolean c0(w state) {
        return state.f3381a == null && state.a < this.f3349a.f3458a && !state.c;
    }

    /* access modifiers changed from: private */
    public void b0() {
        Future<?> futureToBeCancelled = null;
        synchronized (this.f3353a) {
            s sVar = this.f3360b;
            if (sVar != null) {
                futureToBeCancelled = sVar.b();
                this.f3360b = null;
            }
            this.f3344a = this.f3344a.d();
        }
        if (futureToBeCancelled != null) {
            futureToBeCancelled.cancel(false);
        }
    }

    private final class x implements o {
        final y a;

        x(y substream) {
            this.a = substream;
        }

        public void e(io.grpc.l headers) {
            c1.this.X(this.a);
            if (c1.this.f3344a.f3381a == this.a) {
                c1.this.f3350a.e(headers);
                if (c1.this.f3345a != null) {
                    c1.this.f3345a.c();
                }
            }
        }

        public void d(io.grpc.p status, io.grpc.l trailers) {
            c(status, o.a.PROCESSED, trailers);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:64:0x016d, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(io.grpc.p r8, io.grpc.internal.o.a r9, io.grpc.l r10) {
            /*
                r7 = this;
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                java.lang.Object r0 = r0.f3353a
                monitor-enter(r0)
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this     // Catch:{ all -> 0x01c9 }
                io.grpc.internal.c1$w r2 = r1.f3344a     // Catch:{ all -> 0x01c9 }
                io.grpc.internal.c1$y r3 = r7.a     // Catch:{ all -> 0x01c9 }
                io.grpc.internal.c1$w r2 = r2.g(r3)     // Catch:{ all -> 0x01c9 }
                io.grpc.internal.c1.w unused = r1.f3344a = r2     // Catch:{ all -> 0x01c9 }
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this     // Catch:{ all -> 0x01c9 }
                vs r1 = r1.f3357a     // Catch:{ all -> 0x01c9 }
                io.grpc.p$b r2 = r8.m()     // Catch:{ all -> 0x01c9 }
                r1.a(r2)     // Catch:{ all -> 0x01c9 }
                monitor-exit(r0)     // Catch:{ all -> 0x01c9 }
                io.grpc.internal.c1$y r0 = r7.a
                boolean r1 = r0.b
                if (r1 == 0) goto L_0x0045
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this
                r1.X(r0)
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.c1$w r0 = r0.f3344a
                io.grpc.internal.c1$y r0 = r0.f3381a
                io.grpc.internal.c1$y r1 = r7.a
                if (r0 != r1) goto L_0x0044
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.o r0 = r0.f3350a
                r0.d(r8, r10)
            L_0x0044:
                return
            L_0x0045:
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.c1$w r0 = r0.f3344a
                io.grpc.internal.c1$y r0 = r0.f3381a
                if (r0 != 0) goto L_0x01ac
                io.grpc.internal.o$a r0 = io.grpc.internal.o.a.REFUSED
                r1 = 1
                if (r9 != r0) goto L_0x00e5
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f3356a
                r2 = 0
                boolean r0 = r0.compareAndSet(r2, r1)
                if (r0 == 0) goto L_0x00e5
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.c1$y r2 = r7.a
                int r2 = r2.a
                io.grpc.internal.c1$y r0 = r0.Y(r2)
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this
                boolean r2 = r2.f3358a
                if (r2 == 0) goto L_0x00b2
                r2 = 0
                io.grpc.internal.c1 r3 = io.grpc.internal.c1.this
                java.lang.Object r3 = r3.f3353a
                monitor-enter(r3)
                io.grpc.internal.c1 r4 = io.grpc.internal.c1.this     // Catch:{ all -> 0x00af }
                io.grpc.internal.c1$w r5 = r4.f3344a     // Catch:{ all -> 0x00af }
                io.grpc.internal.c1$y r6 = r7.a     // Catch:{ all -> 0x00af }
                io.grpc.internal.c1$w r5 = r5.f(r6, r0)     // Catch:{ all -> 0x00af }
                io.grpc.internal.c1.w unused = r4.f3344a = r5     // Catch:{ all -> 0x00af }
                io.grpc.internal.c1 r4 = io.grpc.internal.c1.this     // Catch:{ all -> 0x00af }
                io.grpc.internal.c1$w r5 = r4.f3344a     // Catch:{ all -> 0x00af }
                boolean r4 = r4.c0(r5)     // Catch:{ all -> 0x00af }
                if (r4 != 0) goto L_0x00a6
                io.grpc.internal.c1 r4 = io.grpc.internal.c1.this     // Catch:{ all -> 0x00af }
                io.grpc.internal.c1$w r4 = r4.f3344a     // Catch:{ all -> 0x00af }
                java.util.Collection<io.grpc.internal.c1$y> r4 = r4.b     // Catch:{ all -> 0x00af }
                int r4 = r4.size()     // Catch:{ all -> 0x00af }
                if (r4 != r1) goto L_0x00a6
                r1 = 1
                r2 = r1
            L_0x00a6:
                monitor-exit(r3)     // Catch:{ all -> 0x00af }
                if (r2 == 0) goto L_0x00ae
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this
                r1.X(r0)
            L_0x00ae:
                goto L_0x00d6
            L_0x00af:
                r1 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00af }
                throw r1
            L_0x00b2:
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this
                io.grpc.internal.d1 r2 = r2.f3347a
                if (r2 != 0) goto L_0x00c7
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this
                io.grpc.internal.d1$a r3 = r2.f3346a
                io.grpc.internal.d1 r3 = r3.a()
                io.grpc.internal.d1 unused = r2.f3347a = r3
            L_0x00c7:
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this
                io.grpc.internal.d1 r2 = r2.f3347a
                int r2 = r2.f3392a
                if (r2 != r1) goto L_0x00d6
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this
                r1.X(r0)
            L_0x00d6:
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this
                java.util.concurrent.Executor r1 = r1.f3354a
                io.grpc.internal.c1$x$a r2 = new io.grpc.internal.c1$x$a
                r2.<init>(r0)
                r1.execute(r2)
                return
            L_0x00e5:
                io.grpc.internal.o$a r0 = io.grpc.internal.o.a.DROPPED
                if (r9 != r0) goto L_0x00f8
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                boolean r0 = r0.f3358a
                if (r0 == 0) goto L_0x01ac
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                r0.b0()
                goto L_0x01ac
            L_0x00f8:
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f3356a
                r0.set(r1)
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.d1 r0 = r0.f3347a
                if (r0 != 0) goto L_0x0121
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.d1$a r1 = r0.f3346a
                io.grpc.internal.d1 r1 = r1.a()
                io.grpc.internal.d1 unused = r0.f3347a = r1
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.d1 r1 = r0.f3347a
                long r1 = r1.f3393a
                long unused = r0.d = r1
            L_0x0121:
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                boolean r0 = r0.f3358a
                if (r0 == 0) goto L_0x0173
                io.grpc.internal.c1$t r0 = r7.g(r8, r10)
                boolean r1 = r0.f3378a
                if (r1 == 0) goto L_0x0138
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this
                java.lang.Integer r2 = r0.a
                r1.g0(r2)
            L_0x0138:
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this
                java.lang.Object r1 = r1.f3353a
                monitor-enter(r1)
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0170 }
                io.grpc.internal.c1$w r3 = r2.f3344a     // Catch:{ all -> 0x0170 }
                io.grpc.internal.c1$y r4 = r7.a     // Catch:{ all -> 0x0170 }
                io.grpc.internal.c1$w r3 = r3.e(r4)     // Catch:{ all -> 0x0170 }
                io.grpc.internal.c1.w unused = r2.f3344a = r3     // Catch:{ all -> 0x0170 }
                boolean r2 = r0.f3378a     // Catch:{ all -> 0x0170 }
                if (r2 == 0) goto L_0x016e
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0170 }
                io.grpc.internal.c1$w r3 = r2.f3344a     // Catch:{ all -> 0x0170 }
                boolean r2 = r2.c0(r3)     // Catch:{ all -> 0x0170 }
                if (r2 != 0) goto L_0x016c
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0170 }
                io.grpc.internal.c1$w r2 = r2.f3344a     // Catch:{ all -> 0x0170 }
                java.util.Collection<io.grpc.internal.c1$y> r2 = r2.b     // Catch:{ all -> 0x0170 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0170 }
                if (r2 != 0) goto L_0x016e
            L_0x016c:
                monitor-exit(r1)     // Catch:{ all -> 0x0170 }
                return
            L_0x016e:
                monitor-exit(r1)     // Catch:{ all -> 0x0170 }
                goto L_0x01ac
            L_0x0170:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0170 }
                throw r2
            L_0x0173:
                io.grpc.internal.c1$v r0 = r7.h(r8, r10)
                boolean r1 = r0.f3380a
                if (r1 == 0) goto L_0x01ac
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this
                java.lang.Object r1 = r1.f3353a
                monitor-enter(r1)
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this     // Catch:{ all -> 0x01a9 }
                io.grpc.internal.c1$s r3 = new io.grpc.internal.c1$s     // Catch:{ all -> 0x01a9 }
                java.lang.Object r4 = r2.f3353a     // Catch:{ all -> 0x01a9 }
                r3.<init>(r4)     // Catch:{ all -> 0x01a9 }
                r4 = r3
                io.grpc.internal.c1.s unused = r2.f3343a = r3     // Catch:{ all -> 0x01a9 }
                monitor-exit(r1)     // Catch:{ all -> 0x01a9 }
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this
                java.util.concurrent.ScheduledExecutorService r1 = r1.f3355a
                io.grpc.internal.c1$x$b r2 = new io.grpc.internal.c1$x$b
                r2.<init>()
                long r5 = r0.a
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
                java.util.concurrent.ScheduledFuture r1 = r1.schedule(r2, r5, r3)
                r4.c(r1)
                return
            L_0x01a9:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x01a9 }
                throw r2
            L_0x01ac:
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.c1$y r1 = r7.a
                r0.X(r1)
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.c1$w r0 = r0.f3344a
                io.grpc.internal.c1$y r0 = r0.f3381a
                io.grpc.internal.c1$y r1 = r7.a
                if (r0 != r1) goto L_0x01c8
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.o r0 = r0.f3350a
                r0.d(r8, r10)
            L_0x01c8:
                return
            L_0x01c9:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x01c9 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.c1.x.c(io.grpc.p, io.grpc.internal.o$a, io.grpc.l):void");
        }

        class a implements Runnable {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ y f3387a;

            a(y yVar) {
                this.f3387a = yVar;
            }

            public void run() {
                c1.this.a0(this.f3387a);
            }
        }

        class b implements Runnable {
            b() {
            }

            class a implements Runnable {
                a() {
                }

                public void run() {
                    x xVar = x.this;
                    c1.this.a0(c1.this.Y(xVar.a.a + 1));
                }
            }

            public void run() {
                c1.this.f3354a.execute(new a());
            }
        }

        private v h(io.grpc.p status, io.grpc.l trailer) {
            boolean shouldRetry = false;
            long backoffNanos = 0;
            boolean isRetryableStatusCode = c1.this.f3347a.f3394a.contains(status.m());
            Integer pushbackMillis = f(trailer);
            boolean isThrottled = false;
            if (c1.this.f3345a != null && (isRetryableStatusCode || (pushbackMillis != null && pushbackMillis.intValue() < 0))) {
                isThrottled = !c1.this.f3345a.b();
            }
            if (c1.this.f3347a.f3392a > this.a.a + 1 && !isThrottled) {
                if (pushbackMillis == null) {
                    if (isRetryableStatusCode) {
                        shouldRetry = true;
                        backoffNanos = (long) (((double) c1.this.d) * c1.f3340a.nextDouble());
                        c1 c1Var = c1.this;
                        long unused = c1Var.d = Math.min((long) (((double) c1Var.d) * c1.this.f3347a.f3391a), c1.this.f3347a.b);
                    }
                } else if (pushbackMillis.intValue() >= 0) {
                    shouldRetry = true;
                    backoffNanos = TimeUnit.MILLISECONDS.toNanos((long) pushbackMillis.intValue());
                    c1 c1Var2 = c1.this;
                    long unused2 = c1Var2.d = c1Var2.f3347a.f3393a;
                }
            }
            return new v(shouldRetry, backoffNanos);
        }

        private t g(io.grpc.p status, io.grpc.l trailer) {
            Integer pushbackMillis = f(trailer);
            boolean z = true;
            boolean isFatal = !c1.this.f3349a.f3460a.contains(status.m());
            boolean isThrottled = false;
            if (c1.this.f3345a != null && (!isFatal || (pushbackMillis != null && pushbackMillis.intValue() < 0))) {
                isThrottled = !c1.this.f3345a.b();
            }
            if (isFatal || isThrottled) {
                z = false;
            }
            return new t(z, pushbackMillis);
        }

        private Integer f(io.grpc.l trailer) {
            String pushbackStr = (String) trailer.f(c1.b);
            if (pushbackStr == null) {
                return null;
            }
            try {
                return Integer.valueOf(pushbackStr);
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        public void a(k1.a producer) {
            w savedState = c1.this.f3344a;
            v90.u(savedState.f3381a != null, "Headers should be received prior to messages.");
            if (savedState.f3381a == this.a) {
                c1.this.f3350a.a(producer);
            }
        }

        public void b() {
            c1.this.f3350a.b();
        }
    }

    private static final class w {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        final y f3381a;

        /* renamed from: a  reason: collision with other field name */
        final Collection<y> f3382a;

        /* renamed from: a  reason: collision with other field name */
        final List<p> f3383a;

        /* renamed from: a  reason: collision with other field name */
        final boolean f3384a;
        final Collection<y> b;

        /* renamed from: b  reason: collision with other field name */
        final boolean f3385b;
        final boolean c;

        w(List<p> buffer, Collection<y> drainedSubstreams, Collection<y> activeHedges, y winningSubstream, boolean cancelled, boolean passThrough, boolean hedgingFrozen, int hedgingAttemptCount) {
            this.f3383a = buffer;
            this.f3382a = (Collection) v90.o(drainedSubstreams, "drainedSubstreams");
            this.f3381a = winningSubstream;
            this.b = activeHedges;
            this.f3385b = cancelled;
            this.f3384a = passThrough;
            this.c = hedgingFrozen;
            this.a = hedgingAttemptCount;
            boolean z = false;
            v90.u(!passThrough || buffer == null, "passThrough should imply buffer is null");
            v90.u(!passThrough || winningSubstream != null, "passThrough should imply winningSubstream != null");
            v90.u(!passThrough || (drainedSubstreams.size() == 1 && drainedSubstreams.contains(winningSubstream)) || (drainedSubstreams.size() == 0 && winningSubstream.f3389a), "passThrough should imply winningSubstream is drained");
            v90.u((!cancelled || winningSubstream != null) ? true : z, "cancelled should imply committed");
        }

        /* access modifiers changed from: package-private */
        public w b() {
            return new w(this.f3383a, this.f3382a, this.b, this.f3381a, true, this.f3384a, this.c, this.a);
        }

        /* access modifiers changed from: package-private */
        public w h(y substream) {
            Collection collection;
            List<p> list;
            boolean z = true;
            v90.u(!this.f3384a, "Already passThrough");
            if (substream.f3389a) {
                collection = this.f3382a;
            } else if (this.f3382a.isEmpty()) {
                collection = Collections.singletonList(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.f3382a);
                arrayList.add(substream);
                collection = Collections.unmodifiableCollection(arrayList);
            }
            y yVar = this.f3381a;
            boolean passThrough = yVar != null;
            List<p> list2 = this.f3383a;
            if (passThrough) {
                if (yVar != substream) {
                    z = false;
                }
                v90.u(z, "Another RPC attempt has already committed");
                list = null;
            } else {
                list = list2;
            }
            return new w(list, collection, this.b, this.f3381a, this.f3385b, passThrough, this.c, this.a);
        }

        /* access modifiers changed from: package-private */
        public w g(y substream) {
            substream.f3389a = true;
            if (!this.f3382a.contains(substream)) {
                return this;
            }
            Collection<RetriableStream.Substream> drainedSubstreams = new ArrayList<>(this.f3382a);
            drainedSubstreams.remove(substream);
            return new w(this.f3383a, Collections.unmodifiableCollection(drainedSubstreams), this.b, this.f3381a, this.f3385b, this.f3384a, this.c, this.a);
        }

        /* access modifiers changed from: package-private */
        public w c(y winningSubstream) {
            Collection<RetriableStream.Substream> drainedSubstreams;
            v90.u(this.f3381a == null, "Already committed");
            boolean passThrough = false;
            List<p> list = this.f3383a;
            if (this.f3382a.contains(winningSubstream)) {
                passThrough = true;
                list = null;
                drainedSubstreams = Collections.singleton(winningSubstream);
            } else {
                drainedSubstreams = Collections.emptyList();
            }
            return new w(list, drainedSubstreams, this.b, winningSubstream, this.f3385b, passThrough, this.c, this.a);
        }

        /* access modifiers changed from: package-private */
        public w d() {
            if (this.c) {
                return this;
            }
            return new w(this.f3383a, this.f3382a, this.b, this.f3381a, this.f3385b, this.f3384a, true, this.a);
        }

        /* access modifiers changed from: package-private */
        public w a(y substream) {
            Collection<RetriableStream.Substream> activeHedges;
            v90.u(!this.c, "hedging frozen");
            v90.u(this.f3381a == null, "already committed");
            if (this.b == null) {
                activeHedges = Collections.singleton(substream);
            } else {
                Collection<RetriableStream.Substream> activeHedges2 = new ArrayList<>(this.b);
                activeHedges2.add(substream);
                activeHedges = Collections.unmodifiableCollection(activeHedges2);
            }
            return new w(this.f3383a, this.f3382a, activeHedges, this.f3381a, this.f3385b, this.f3384a, this.c, 1 + this.a);
        }

        /* access modifiers changed from: package-private */
        public w e(y substream) {
            Collection<RetriableStream.Substream> activeHedges = new ArrayList<>(this.b);
            activeHedges.remove(substream);
            return new w(this.f3383a, this.f3382a, Collections.unmodifiableCollection(activeHedges), this.f3381a, this.f3385b, this.f3384a, this.c, this.a);
        }

        /* access modifiers changed from: package-private */
        public w f(y oldOne, y newOne) {
            Collection<RetriableStream.Substream> activeHedges = new ArrayList<>(this.b);
            activeHedges.remove(oldOne);
            activeHedges.add(newOne);
            return new w(this.f3383a, this.f3382a, Collections.unmodifiableCollection(activeHedges), this.f3381a, this.f3385b, this.f3384a, this.c, this.a);
        }
    }

    private static final class y {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        z8 f3388a;

        /* renamed from: a  reason: collision with other field name */
        boolean f3389a;
        boolean b;

        y(int previousAttemptCount) {
            this.a = previousAttemptCount;
        }
    }

    class q extends a9 {
        long a;

        /* renamed from: a  reason: collision with other field name */
        private final y f3374a;

        q(y substream) {
            this.f3374a = substream;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
            r0.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h(long r10) {
            /*
                r9 = this;
                io.grpc.internal.c1 r0 = io.grpc.internal.c1.this
                io.grpc.internal.c1$w r0 = r0.f3344a
                io.grpc.internal.c1$y r0 = r0.f3381a
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                r0 = 0
                io.grpc.internal.c1 r1 = io.grpc.internal.c1.this
                java.lang.Object r1 = r1.f3353a
                monitor-enter(r1)
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0085 }
                io.grpc.internal.c1$w r2 = r2.f3344a     // Catch:{ all -> 0x0085 }
                io.grpc.internal.c1$y r2 = r2.f3381a     // Catch:{ all -> 0x0085 }
                if (r2 != 0) goto L_0x0083
                io.grpc.internal.c1$y r2 = r9.f3374a     // Catch:{ all -> 0x0085 }
                boolean r2 = r2.f3389a     // Catch:{ all -> 0x0085 }
                if (r2 == 0) goto L_0x0024
                goto L_0x0083
            L_0x0024:
                long r2 = r9.a     // Catch:{ all -> 0x0085 }
                long r2 = r2 + r10
                r9.a = r2     // Catch:{ all -> 0x0085 }
                io.grpc.internal.c1 r4 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0085 }
                long r4 = r4.c     // Catch:{ all -> 0x0085 }
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 > 0) goto L_0x0035
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                return
            L_0x0035:
                long r2 = r9.a     // Catch:{ all -> 0x0085 }
                io.grpc.internal.c1 r4 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0085 }
                long r4 = r4.f3341a     // Catch:{ all -> 0x0085 }
                r6 = 1
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 <= 0) goto L_0x0047
                io.grpc.internal.c1$y r2 = r9.f3374a     // Catch:{ all -> 0x0085 }
                r2.b = r6     // Catch:{ all -> 0x0085 }
                goto L_0x006f
            L_0x0047:
                io.grpc.internal.c1 r2 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0085 }
                io.grpc.internal.c1$r r2 = r2.f3342a     // Catch:{ all -> 0x0085 }
                long r3 = r9.a     // Catch:{ all -> 0x0085 }
                io.grpc.internal.c1 r5 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0085 }
                long r7 = r5.c     // Catch:{ all -> 0x0085 }
                long r3 = r3 - r7
                long r2 = r2.a(r3)     // Catch:{ all -> 0x0085 }
                io.grpc.internal.c1 r4 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0085 }
                long r7 = r9.a     // Catch:{ all -> 0x0085 }
                long unused = r4.c = r7     // Catch:{ all -> 0x0085 }
                io.grpc.internal.c1 r4 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0085 }
                long r4 = r4.f3359b     // Catch:{ all -> 0x0085 }
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 <= 0) goto L_0x006f
                io.grpc.internal.c1$y r4 = r9.f3374a     // Catch:{ all -> 0x0085 }
                r4.b = r6     // Catch:{ all -> 0x0085 }
            L_0x006f:
                io.grpc.internal.c1$y r2 = r9.f3374a     // Catch:{ all -> 0x0085 }
                boolean r3 = r2.b     // Catch:{ all -> 0x0085 }
                if (r3 == 0) goto L_0x007c
                io.grpc.internal.c1 r3 = io.grpc.internal.c1.this     // Catch:{ all -> 0x0085 }
                java.lang.Runnable r2 = r3.W(r2)     // Catch:{ all -> 0x0085 }
                r0 = r2
            L_0x007c:
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                if (r0 == 0) goto L_0x0082
                r0.run()
            L_0x0082:
                return
            L_0x0083:
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                return
            L_0x0085:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.c1.q.h(long):void");
        }
    }

    static final class r {
        private final AtomicLong a = new AtomicLong();

        r() {
        }

        /* access modifiers changed from: package-private */
        public long a(long newBytesUsed) {
            return this.a.addAndGet(newBytesUsed);
        }
    }

    static final class z {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        final AtomicInteger f3390a;
        final int b;
        final int c;

        z(float maxTokens, float tokenRatio) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f3390a = atomicInteger;
            this.c = (int) (tokenRatio * 1000.0f);
            int i = (int) (1000.0f * maxTokens);
            this.a = i;
            this.b = i / 2;
            atomicInteger.set(i);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f3390a.get() > this.b;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int currentCount;
            int decremented;
            do {
                currentCount = this.f3390a.get();
                if (currentCount == 0) {
                    return false;
                }
                decremented = currentCount + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            } while (!this.f3390a.compareAndSet(currentCount, Math.max(decremented, 0)));
            if (decremented > this.b) {
                return true;
            }
            return false;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        void c() {
            /*
                r4 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicInteger r0 = r4.f3390a
                int r0 = r0.get()
                int r1 = r4.a
                if (r0 != r1) goto L_0x000b
                goto L_0x001b
            L_0x000b:
                int r2 = r4.c
                int r2 = r2 + r0
                java.util.concurrent.atomic.AtomicInteger r3 = r4.f3390a
                int r1 = java.lang.Math.min(r2, r1)
                boolean r1 = r3.compareAndSet(r0, r1)
                if (r1 == 0) goto L_0x001c
            L_0x001b:
                return
            L_0x001c:
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.c1.z.c():void");
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof z)) {
                return false;
            }
            z that = (z) o;
            if (this.a == that.a && this.c == that.c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return f40.b(Integer.valueOf(this.a), Integer.valueOf(this.c));
        }
    }

    private static final class v {
        final long a;

        /* renamed from: a  reason: collision with other field name */
        final boolean f3380a;

        v(boolean shouldRetry, long backoffNanos) {
            this.f3380a = shouldRetry;
            this.a = backoffNanos;
        }
    }

    private static final class t {
        final Integer a;

        /* renamed from: a  reason: collision with other field name */
        final boolean f3378a;

        public t(boolean isHedgeable, Integer hedgingPushbackMillis) {
            this.f3378a = isHedgeable;
            this.a = hedgingPushbackMillis;
        }
    }

    private static final class s {
        final Object a;

        /* renamed from: a  reason: collision with other field name */
        Future<?> f3376a;

        /* renamed from: a  reason: collision with other field name */
        boolean f3377a;

        s(Object lock) {
            this.a = lock;
        }

        /* access modifiers changed from: package-private */
        public void c(Future<?> future) {
            synchronized (this.a) {
                if (!this.f3377a) {
                    this.f3376a = future;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Future<?> b() {
            this.f3377a = true;
            return this.f3376a;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f3377a;
        }
    }
}
