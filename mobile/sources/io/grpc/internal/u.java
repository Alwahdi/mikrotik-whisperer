package io.grpc.internal;

import defpackage.ux;
import io.grpc.internal.t0;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

final class u implements t0 {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private final hu f3682a = hu.a(u.class, (String) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public t0.a f3683a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public p f3684a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Object f3685a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private Runnable f3686a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Collection<f> f3687a = new LinkedHashSet();

    /* renamed from: a  reason: collision with other field name */
    private final Executor f3688a;

    /* renamed from: a  reason: collision with other field name */
    private ux.i f3689a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final vo0 f3690a;
    /* access modifiers changed from: private */
    public Runnable b;
    /* access modifiers changed from: private */
    public Runnable c;

    u(Executor defaultAppExecutor, vo0 syncContext) {
        this.f3688a = defaultAppExecutor;
        this.f3690a = syncContext;
    }

    class a implements Runnable {
        final /* synthetic */ t0.a a;

        a(t0.a aVar) {
            this.a = aVar;
        }

        public void run() {
            this.a.b(true);
        }
    }

    public final Runnable d(t0.a listener) {
        this.f3683a = listener;
        this.f3686a = new a(listener);
        this.b = new b(listener);
        this.c = new c(listener);
        return null;
    }

    class b implements Runnable {
        final /* synthetic */ t0.a a;

        b(t0.a aVar) {
            this.a = aVar;
        }

        public void run() {
            this.a.b(false);
        }
    }

    class c implements Runnable {
        final /* synthetic */ t0.a a;

        c(t0.a aVar) {
            this.a = aVar;
        }

        public void run() {
            this.a.a();
        }
    }

    public final z8 f(m<?, ?> method, l headers, n7 callOptions) {
        p transport;
        try {
            ux.f args = new h90(method, headers, callOptions);
            ux.i picker = null;
            long pickerVersion = -1;
            do {
                synchronized (this.f3685a) {
                    if (this.f3684a != null) {
                        z zVar = new z(this.f3684a);
                        this.f3690a.a();
                        return zVar;
                    }
                    ux.i iVar = this.f3689a;
                    if (iVar == null) {
                        f o = o(args);
                        this.f3690a.a();
                        return o;
                    }
                    if (picker != null) {
                        if (pickerVersion == this.a) {
                            f o2 = o(args);
                            this.f3690a.a();
                            return o2;
                        }
                    }
                    picker = iVar;
                    pickerVersion = this.a;
                    transport = h0.h(picker.a(args), callOptions.j());
                }
            } while (transport == null);
            z8 f2 = transport.f(args.c(), args.b(), args.a());
            this.f3690a.a();
            return f2;
        } catch (Throwable th) {
            this.f3690a.a();
            throw th;
        }
    }

    private f o(ux.f args) {
        f pendingStream = new f(this, args, (a) null);
        this.f3687a.add(pendingStream);
        if (p() == 1) {
            this.f3690a.b(this.f3686a);
        }
        return pendingStream;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r3.f3690a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(io.grpc.p r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f3685a
            monitor-enter(r0)
            io.grpc.p r1 = r3.f3684a     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            return
        L_0x0009:
            r3.f3684a = r4     // Catch:{ all -> 0x002e }
            vo0 r1 = r3.f3690a     // Catch:{ all -> 0x002e }
            io.grpc.internal.u$d r2 = new io.grpc.internal.u$d     // Catch:{ all -> 0x002e }
            r2.<init>(r4)     // Catch:{ all -> 0x002e }
            r1.b(r2)     // Catch:{ all -> 0x002e }
            boolean r1 = r3.q()     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x0027
            java.lang.Runnable r1 = r3.c     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0027
            vo0 r2 = r3.f3690a     // Catch:{ all -> 0x002e }
            r2.b(r1)     // Catch:{ all -> 0x002e }
            r1 = 0
            r3.c = r1     // Catch:{ all -> 0x002e }
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            vo0 r0 = r3.f3690a
            r0.a()
            return
        L_0x002e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.u.e(io.grpc.p):void");
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ p f3694a;

        d(p pVar) {
            this.f3694a = pVar;
        }

        public void run() {
            u.this.f3683a.d(this.f3694a);
        }
    }

    public final void c(p status) {
        Collection<f> collection;
        Runnable savedReportTransportTerminated;
        e(status);
        synchronized (this.f3685a) {
            Collection<f> collection2 = this.f3687a;
            collection = collection2;
            savedReportTransportTerminated = this.c;
            this.c = null;
            if (!collection2.isEmpty()) {
                this.f3687a = Collections.emptyList();
            }
        }
        if (savedReportTransportTerminated != null) {
            for (f stream : collection) {
                stream.b(status);
            }
            this.f3690a.execute(savedReportTransportTerminated);
        }
    }

    public final boolean q() {
        boolean z;
        synchronized (this.f3685a) {
            z = !this.f3687a.isEmpty();
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final int p() {
        int size;
        synchronized (this.f3685a) {
            size = this.f3687a.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r2 = new java.util.ArrayList();
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r0.hasNext() == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r3 = (io.grpc.internal.u.f) r0.next();
        r4 = r10.a(io.grpc.internal.u.f.u(r3));
        r5 = io.grpc.internal.u.f.u(r3).a();
        r6 = io.grpc.internal.h0.h(r4, r5.j());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        if (r6 == null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        r7 = r9.f3688a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        if (r5.e() == null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
        r7 = r5.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        r7.execute(new io.grpc.internal.u.e(r9, r3, r6));
        r2.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        r3 = r9.f3685a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        if (q() != false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
        r9.f3687a.removeAll(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007d, code lost:
        if (r9.f3687a.isEmpty() == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r9.f3687a = new java.util.LinkedHashSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        if (q() != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008c, code lost:
        r9.f3690a.b(r9.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0095, code lost:
        if (r9.f3684a == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        r0 = r9.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0099, code lost:
        if (r0 == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009b, code lost:
        r9.f3690a.b(r0);
        r9.c = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a3, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a4, code lost:
        r9.f3690a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(defpackage.ux.i r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f3685a
            monitor-enter(r0)
            r9.f3689a = r10     // Catch:{ all -> 0x00af }
            long r1 = r9.a     // Catch:{ all -> 0x00af }
            r3 = 1
            long r1 = r1 + r3
            r9.a = r1     // Catch:{ all -> 0x00af }
            if (r10 == 0) goto L_0x00ad
            boolean r1 = r9.q()     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x0016
            goto L_0x00ad
        L_0x0016:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00af }
            java.util.Collection<io.grpc.internal.u$f> r2 = r9.f3687a     // Catch:{ all -> 0x00af }
            r1.<init>(r2)     // Catch:{ all -> 0x00af }
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2 = r0
            java.util.Iterator r0 = r1.iterator()
        L_0x0028:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0067
            java.lang.Object r3 = r0.next()
            io.grpc.internal.u$f r3 = (io.grpc.internal.u.f) r3
            ux$f r4 = r3.f3698a
            ux$e r4 = r10.a(r4)
            ux$f r5 = r3.f3698a
            n7 r5 = r5.a()
            boolean r6 = r5.j()
            io.grpc.internal.p r6 = io.grpc.internal.h0.h(r4, r6)
            if (r6 == 0) goto L_0x0066
            java.util.concurrent.Executor r7 = r9.f3688a
            java.util.concurrent.Executor r8 = r5.e()
            if (r8 == 0) goto L_0x005b
            java.util.concurrent.Executor r7 = r5.e()
        L_0x005b:
            io.grpc.internal.u$e r8 = new io.grpc.internal.u$e
            r8.<init>(r3, r6)
            r7.execute(r8)
            r2.add(r3)
        L_0x0066:
            goto L_0x0028
        L_0x0067:
            java.lang.Object r3 = r9.f3685a
            monitor-enter(r3)
            boolean r0 = r9.q()     // Catch:{ all -> 0x00aa }
            if (r0 != 0) goto L_0x0072
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            return
        L_0x0072:
            java.util.Collection<io.grpc.internal.u$f> r0 = r9.f3687a     // Catch:{ all -> 0x00aa }
            r0.removeAll(r2)     // Catch:{ all -> 0x00aa }
            java.util.Collection<io.grpc.internal.u$f> r0 = r9.f3687a     // Catch:{ all -> 0x00aa }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x0086
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet     // Catch:{ all -> 0x00aa }
            r0.<init>()     // Catch:{ all -> 0x00aa }
            r9.f3687a = r0     // Catch:{ all -> 0x00aa }
        L_0x0086:
            boolean r0 = r9.q()     // Catch:{ all -> 0x00aa }
            if (r0 != 0) goto L_0x00a3
            vo0 r0 = r9.f3690a     // Catch:{ all -> 0x00aa }
            java.lang.Runnable r4 = r9.b     // Catch:{ all -> 0x00aa }
            r0.b(r4)     // Catch:{ all -> 0x00aa }
            io.grpc.p r0 = r9.f3684a     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x00a3
            java.lang.Runnable r0 = r9.c     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x00a3
            vo0 r4 = r9.f3690a     // Catch:{ all -> 0x00aa }
            r4.b(r0)     // Catch:{ all -> 0x00aa }
            r0 = 0
            r9.c = r0     // Catch:{ all -> 0x00aa }
        L_0x00a3:
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            vo0 r0 = r9.f3690a
            r0.a()
            return
        L_0x00aa:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            throw r0
        L_0x00ad:
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return
        L_0x00af:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.u.r(ux$i):void");
    }

    class e implements Runnable {
        final /* synthetic */ p a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ f f3695a;

        e(f fVar, p pVar) {
            this.f3695a = fVar;
            this.a = pVar;
        }

        public void run() {
            this.f3695a.w(this.a);
        }
    }

    public hu b() {
        return this.f3682a;
    }

    private class f extends v {

        /* renamed from: a  reason: collision with other field name */
        private final qc f3697a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final ux.f f3698a;

        /* synthetic */ f(u x0, ux.f x1, a x2) {
            this(x1);
        }

        private f(ux.f args) {
            this.f3697a = qc.e();
            this.f3698a = args;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: private */
        public void w(p transport) {
            qc origContext = this.f3697a.b();
            try {
                z8 realStream = transport.f(this.f3698a.c(), this.f3698a.b(), this.f3698a.a());
                this.f3697a.f(origContext);
                t(realStream);
            } catch (Throwable th) {
                this.f3697a.f(origContext);
                throw th;
            }
        }

        public void b(p reason) {
            super.b(reason);
            synchronized (u.this.f3685a) {
                if (u.this.c != null) {
                    boolean justRemovedAnElement = u.this.f3687a.remove(this);
                    if (!u.this.q() && justRemovedAnElement) {
                        u.this.f3690a.b(u.this.b);
                        if (u.this.f3684a != null) {
                            u.this.f3690a.b(u.this.c);
                            Runnable unused = u.this.c = null;
                        }
                    }
                }
            }
            u.this.f3690a.a();
        }
    }
}
