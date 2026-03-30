package io.grpc.internal;

import io.grpc.internal.k1;
import io.grpc.internal.o;
import io.grpc.p;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class v implements z8 {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private o f3715a;

    /* renamed from: a  reason: collision with other field name */
    private o f3716a;

    /* renamed from: a  reason: collision with other field name */
    private p f3717a;

    /* renamed from: a  reason: collision with other field name */
    private List<Runnable> f3718a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public z8 f3719a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f3720a;
    private long b;

    v() {
    }

    public void c(int maxSize) {
        if (this.f3720a) {
            this.f3719a.c(maxSize);
        } else {
            q(new f(maxSize));
        }
    }

    class f implements Runnable {
        final /* synthetic */ int a;

        f(int i) {
            this.a = i;
        }

        public void run() {
            v.this.f3719a.c(this.a);
        }
    }

    public void a(int maxSize) {
        if (this.f3720a) {
            this.f3719a.a(maxSize);
        } else {
            q(new g(maxSize));
        }
    }

    class g implements Runnable {
        final /* synthetic */ int a;

        g(int i) {
            this.a = i;
        }

        public void run() {
            v.this.f3719a.a(this.a);
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ ze f3727a;

        h(ze zeVar) {
            this.f3727a = zeVar;
        }

        public void run() {
            v.this.f3719a.h(this.f3727a);
        }
    }

    public void h(ze deadline) {
        q(new h(deadline));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(defpackage.vs r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.grpc.internal.o r0 = r5.f3715a     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r5)     // Catch:{ all -> 0x0036 }
            return
        L_0x0007:
            z8 r0 = r5.f3719a     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x001f
            java.lang.String r0 = "buffered_nanos"
            long r1 = r5.b     // Catch:{ all -> 0x0036 }
            long r3 = r5.a     // Catch:{ all -> 0x0036 }
            long r1 = r1 - r3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0036 }
            r6.b(r0, r1)     // Catch:{ all -> 0x0036 }
            z8 r0 = r5.f3719a     // Catch:{ all -> 0x0036 }
            r0.n(r6)     // Catch:{ all -> 0x0036 }
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "buffered_nanos"
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0036 }
            long r3 = r5.a     // Catch:{ all -> 0x0036 }
            long r1 = r1 - r3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0036 }
            r6.b(r0, r1)     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = "waiting_for_connection"
            r6.a(r0)     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r5)     // Catch:{ all -> 0x0036 }
            return
        L_0x0036:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0036 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.v.n(vs):void");
    }

    /* access modifiers changed from: package-private */
    public final void t(z8 stream) {
        synchronized (this) {
            if (this.f3719a == null) {
                s((z8) v90.o(stream, "stream"));
                r();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r1.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        r2 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r2.hasNext() == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        r2.next().run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r() {
        /*
            r4 = this;
            z8 r0 = r4.f3719a
            if (r0 == 0) goto L_0x004f
            boolean r0 = r4.f3720a
            if (r0 != 0) goto L_0x0049
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
        L_0x000e:
            monitor-enter(r4)
            java.util.List<java.lang.Runnable> r2 = r4.f3718a     // Catch:{ all -> 0x0046 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0027
            r2 = 0
            r4.f3718a = r2     // Catch:{ all -> 0x0046 }
            r2 = 1
            r4.f3720a = r2     // Catch:{ all -> 0x0046 }
            io.grpc.internal.v$o r2 = r4.f3716a     // Catch:{ all -> 0x0046 }
            r1 = r2
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0026
            r1.h()
        L_0x0026:
            return
        L_0x0027:
            r2 = r0
            java.util.List<java.lang.Runnable> r3 = r4.f3718a     // Catch:{ all -> 0x0046 }
            r0 = r3
            r4.f3718a = r2     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            java.util.Iterator r2 = r0.iterator()
        L_0x0032:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0042
            java.lang.Object r3 = r2.next()
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r3.run()
            goto L_0x0032
        L_0x0042:
            r0.clear()
            goto L_0x000e
        L_0x0046:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            throw r2
        L_0x0049:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x004f:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.v.r():void");
    }

    private void q(Runnable runnable) {
        synchronized (this) {
            if (!this.f3720a) {
                this.f3718a.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void j(String authority) {
        v90.u(this.f3715a == null, "May only be called before start");
        v90.o(authority, "authority");
        q(new i(authority));
    }

    class i implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String f3728a;

        i(String str) {
            this.f3728a = str;
        }

        public void run() {
            v.this.f3719a.j(this.f3728a);
        }
    }

    public void k(o listener) {
        p savedError;
        boolean savedPassThrough;
        v90.u(this.f3715a == null, "already started");
        synchronized (this) {
            this.f3715a = (o) v90.o(listener, "listener");
            savedError = this.f3717a;
            savedPassThrough = this.f3720a;
            if (!savedPassThrough) {
                o oVar = new o(listener);
                this.f3716a = oVar;
                listener = oVar;
            }
            this.a = System.nanoTime();
        }
        if (savedError != null) {
            listener.d(savedError, new io.grpc.l());
        } else if (savedPassThrough) {
            this.f3719a.k(listener);
        } else {
            q(new j(listener));
        }
    }

    class j implements Runnable {
        final /* synthetic */ o a;

        j(o oVar) {
            this.a = oVar;
        }

        public void run() {
            v.this.f3719a.k(this.a);
        }
    }

    public void g(InputStream message) {
        v90.o(message, "message");
        if (this.f3720a) {
            this.f3719a.g(message);
        } else {
            q(new k(message));
        }
    }

    class k implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ InputStream f3730a;

        k(InputStream inputStream) {
            this.f3730a = inputStream;
        }

        public void run() {
            v.this.f3719a.g(this.f3730a);
        }
    }

    public void flush() {
        if (this.f3720a) {
            this.f3719a.flush();
        } else {
            q(new l());
        }
    }

    class l implements Runnable {
        l() {
        }

        public void run() {
            v.this.f3719a.flush();
        }
    }

    public void b(p reason) {
        v90.o(reason, "reason");
        boolean delegateToRealStream = true;
        o listenerToClose = null;
        synchronized (this) {
            if (this.f3719a == null) {
                s(m30.a);
                delegateToRealStream = false;
                listenerToClose = this.f3715a;
                this.f3717a = reason;
            }
        }
        if (delegateToRealStream) {
            q(new m(reason));
            return;
        }
        if (listenerToClose != null) {
            listenerToClose.d(reason, new io.grpc.l());
        }
        r();
    }

    class m implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ p f3731a;

        m(p pVar) {
            this.f3731a = pVar;
        }

        public void run() {
            v.this.f3719a.b(this.f3731a);
        }
    }

    private void s(z8 realStream) {
        z8 z8Var = this.f3719a;
        v90.w(z8Var == null, "realStream already set to %s", z8Var);
        this.f3719a = realStream;
        this.b = System.nanoTime();
    }

    class n implements Runnable {
        n() {
        }

        public void run() {
            v.this.f3719a.m();
        }
    }

    public void m() {
        q(new n());
    }

    public void f(int numMessages) {
        if (this.f3720a) {
            this.f3719a.f(numMessages);
        } else {
            q(new a(numMessages));
        }
    }

    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void run() {
            v.this.f3719a.f(this.a);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            v.this.f3719a.o();
        }
    }

    public void o() {
        q(new b());
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ tb f3722a;

        c(tb tbVar) {
            this.f3722a = tbVar;
        }

        public void run() {
            v.this.f3719a.e(this.f3722a);
        }
    }

    public void e(tb compressor) {
        v90.o(compressor, "compressor");
        q(new c(compressor));
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f3723a;

        d(boolean z) {
            this.f3723a = z;
        }

        public void run() {
            v.this.f3719a.l(this.f3723a);
        }
    }

    public void l(boolean fullStreamDecompression) {
        q(new d(fullStreamDecompression));
    }

    class e implements Runnable {
        final /* synthetic */ gf a;

        e(gf gfVar) {
            this.a = gfVar;
        }

        public void run() {
            v.this.f3719a.d(this.a);
        }
    }

    public void d(gf decompressorRegistry) {
        v90.o(decompressorRegistry, "decompressorRegistry");
        q(new e(decompressorRegistry));
    }

    private static class o implements o {
        /* access modifiers changed from: private */
        public final o a;

        /* renamed from: a  reason: collision with other field name */
        private List<Runnable> f3732a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f3733a;

        public o(o listener) {
            this.a = listener;
        }

        private void g(Runnable runnable) {
            synchronized (this) {
                if (!this.f3733a) {
                    this.f3732a.add(runnable);
                } else {
                    runnable.run();
                }
            }
        }

        public void a(k1.a producer) {
            if (this.f3733a) {
                this.a.a(producer);
            } else {
                g(new a(producer));
            }
        }

        class a implements Runnable {
            final /* synthetic */ k1.a a;

            a(k1.a aVar) {
                this.a = aVar;
            }

            public void run() {
                o.this.a.a(this.a);
            }
        }

        public void b() {
            if (this.f3733a) {
                this.a.b();
            } else {
                g(new b());
            }
        }

        class b implements Runnable {
            b() {
            }

            public void run() {
                o.this.a.b();
            }
        }

        class c implements Runnable {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ io.grpc.l f3735a;

            c(io.grpc.l lVar) {
                this.f3735a = lVar;
            }

            public void run() {
                o.this.a.e(this.f3735a);
            }
        }

        public void e(io.grpc.l headers) {
            g(new c(headers));
        }

        class d implements Runnable {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ io.grpc.l f3736a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ p f3737a;

            d(p pVar, io.grpc.l lVar) {
                this.f3737a = pVar;
                this.f3736a = lVar;
            }

            public void run() {
                o.this.a.d(this.f3737a, this.f3736a);
            }
        }

        public void d(p status, io.grpc.l trailers) {
            g(new d(status, trailers));
        }

        class e implements Runnable {
            final /* synthetic */ o.a a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ io.grpc.l f3739a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ p f3740a;

            e(p pVar, o.a aVar, io.grpc.l lVar) {
                this.f3740a = pVar;
                this.a = aVar;
                this.f3739a = lVar;
            }

            public void run() {
                o.this.a.c(this.f3740a, this.a, this.f3739a);
            }
        }

        public void c(p status, o.a rpcProgress, io.grpc.l trailers) {
            g(new e(status, rpcProgress, trailers));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
            r1 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            if (r1.hasNext() == false) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
            r1.next().run();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h() {
            /*
                r3 = this;
                boolean r0 = r3.f3733a
                if (r0 != 0) goto L_0x003c
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
            L_0x0009:
                monitor-enter(r3)
                java.util.List<java.lang.Runnable> r1 = r3.f3732a     // Catch:{ all -> 0x0039 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0039 }
                if (r1 == 0) goto L_0x001a
                r1 = 0
                r3.f3732a = r1     // Catch:{ all -> 0x0039 }
                r1 = 1
                r3.f3733a = r1     // Catch:{ all -> 0x0039 }
                monitor-exit(r3)     // Catch:{ all -> 0x0039 }
                return
            L_0x001a:
                r1 = r0
                java.util.List<java.lang.Runnable> r2 = r3.f3732a     // Catch:{ all -> 0x0039 }
                r0 = r2
                r3.f3732a = r1     // Catch:{ all -> 0x0039 }
                monitor-exit(r3)     // Catch:{ all -> 0x0039 }
                java.util.Iterator r1 = r0.iterator()
            L_0x0025:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0035
                java.lang.Object r2 = r1.next()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                r2.run()
                goto L_0x0025
            L_0x0035:
                r0.clear()
                goto L_0x0009
            L_0x0039:
                r1 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0039 }
                throw r1
            L_0x003c:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.v.o.h():void");
        }
    }
}
