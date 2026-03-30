package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.c;
import com.google.firebase.firestore.util.h;
import com.google.firebase.firestore.util.i;
import defpackage.jn0;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

abstract class b<ReqT, RespT, CallbackT extends jn0> {
    private static final long b;
    private static final long c;
    private static final long d;
    private static final long e;
    /* access modifiers changed from: private */
    public long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final b<ReqT, RespT, CallbackT>.defpackage.b f2301a;

    /* renamed from: a  reason: collision with other field name */
    private f0 f2302a = f0.Initial;

    /* renamed from: a  reason: collision with other field name */
    private final n f2303a;

    /* renamed from: a  reason: collision with other field name */
    private c.b f2304a;

    /* renamed from: a  reason: collision with other field name */
    private final c.d f2305a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final com.google.firebase.firestore.util.c f2306a;

    /* renamed from: a  reason: collision with other field name */
    final h f2307a;

    /* renamed from: a  reason: collision with other field name */
    private io.grpc.b<ReqT, RespT> f2308a;

    /* renamed from: a  reason: collision with other field name */
    private final m<ReqT, RespT> f2309a;

    /* renamed from: a  reason: collision with other field name */
    final CallbackT f2310a;

    public abstract void n(RespT respt);

    class a {
        private final long a;

        a(long initialCloseCount) {
            this.a = initialCloseCount;
        }

        /* access modifiers changed from: package-private */
        public void a(Runnable task) {
            b.this.f2306a.n();
            if (b.this.a == this.a) {
                task.run();
            } else {
                i.a(b.this.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
            }
        }
    }

    class c implements w<RespT> {
        private final b<ReqT, RespT, CallbackT>.defpackage.a a;

        c(b<ReqT, RespT, CallbackT>.defpackage.a dispatcher) {
            this.a = dispatcher;
        }

        public void d(l headers) {
            this.a.a(c.a(this, headers));
        }

        static /* synthetic */ void f(c cVar, l headers) {
            if (i.c()) {
                Map<String, String> whitelistedHeaders = new HashMap<>();
                for (String header : headers.i()) {
                    if (i.a.contains(header.toLowerCase(Locale.ENGLISH))) {
                        whitelistedHeaders.put(header, (String) headers.f(l.g.e(header, l.a)));
                    }
                }
                if (!whitelistedHeaders.isEmpty()) {
                    i.a(b.this.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(b.this)), whitelistedHeaders);
                }
            }
        }

        public void c(RespT response) {
            this.a.a(d.a(this, response));
        }

        static /* synthetic */ void g(c cVar, Object response) {
            if (i.c()) {
                i.a(b.this.getClass().getSimpleName(), "(%x) Stream received: %s", Integer.valueOf(System.identityHashCode(b.this)), response);
            }
            b.this.n(response);
        }

        public void b() {
            this.a.a(e.a(this));
        }

        static /* synthetic */ void h(c cVar) {
            i.a(b.this.getClass().getSimpleName(), "(%x) Stream is open", Integer.valueOf(System.identityHashCode(b.this)));
            b.this.o();
        }

        public void a(p status) {
            this.a.a(f.a(this, status));
        }

        static /* synthetic */ void e(c cVar, p status) {
            if (status.o()) {
                i.a(b.this.getClass().getSimpleName(), "(%x) Stream closed.", Integer.valueOf(System.identityHashCode(b.this)));
            } else {
                i.a(b.this.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", Integer.valueOf(System.identityHashCode(b.this)), status);
            }
            b.this.h(status);
        }
    }

    /* renamed from: com.google.firebase.firestore.remote.b$b  reason: collision with other inner class name */
    class C0025b implements Runnable {
        C0025b() {
        }

        public void run() {
            b.this.g();
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        b = timeUnit.toMillis(1);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        c = timeUnit2.toMillis(1);
        d = timeUnit2.toMillis(1);
        e = timeUnit.toMillis(10);
    }

    b(n channel, m<ReqT, RespT> methodDescriptor, com.google.firebase.firestore.util.c workerQueue, c.d connectionTimerId, c.d idleTimerId, CallbackT listener) {
        this.f2303a = channel;
        this.f2309a = methodDescriptor;
        this.f2306a = workerQueue;
        this.f2305a = idleTimerId;
        this.f2310a = listener;
        this.f2301a = new C0025b();
        this.f2307a = new h(workerQueue, connectionTimerId, b, 1.5d, c);
    }

    public boolean k() {
        this.f2306a.n();
        f0 f0Var = this.f2302a;
        return f0Var == f0.Starting || f0Var == f0.Open || f0Var == f0.Backoff;
    }

    public boolean j() {
        this.f2306a.n();
        return this.f2302a == f0.Open;
    }

    public void q() {
        this.f2306a.n();
        boolean z = true;
        n4.d(this.f2308a == null, "Last call still set", new Object[0]);
        n4.d(this.f2304a == null, "Idle timer still set", new Object[0]);
        f0 f0Var = this.f2302a;
        if (f0Var == f0.Error) {
            p();
            return;
        }
        if (f0Var != f0.Initial) {
            z = false;
        }
        n4.d(z, "Already started", new Object[0]);
        this.f2308a = this.f2303a.e(this.f2309a, new c(new a(this.a)));
        this.f2302a = f0.Starting;
    }

    private void f(f0 finalState, p status) {
        n4.d(k(), "Only started streams should be closed.", new Object[0]);
        f0 f0Var = f0.Error;
        n4.d(finalState == f0Var || status.equals(p.f3953a), "Can't provide an error when not in an error state.", new Object[0]);
        this.f2306a.n();
        if (i.c(status)) {
            qu0.i(new IllegalStateException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", status.l()));
        }
        e();
        this.f2307a.b();
        this.a++;
        p.b code = status.m();
        if (code == p.b.OK) {
            this.f2307a.e();
        } else if (code == p.b.RESOURCE_EXHAUSTED) {
            i.a(getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            this.f2307a.f();
        } else if (code == p.b.UNAUTHENTICATED) {
            this.f2303a.b();
        } else if (code == p.b.UNAVAILABLE && ((status.l() instanceof UnknownHostException) || (status.l() instanceof ConnectException))) {
            this.f2307a.g(e);
        }
        if (finalState != f0Var) {
            i.a(getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            s();
        }
        if (this.f2308a != null) {
            if (status.o()) {
                i.a(getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                this.f2308a.a();
            }
            this.f2308a = null;
        }
        this.f2302a = finalState;
        this.f2310a.a(status);
    }

    /* access modifiers changed from: protected */
    public void s() {
    }

    public void r() {
        if (k()) {
            f(f0.Initial, p.f3953a);
        }
    }

    public void i() {
        n4.d(!k(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.f2306a.n();
        this.f2302a = f0.Initial;
        this.f2307a.e();
    }

    /* access modifiers changed from: protected */
    public void t(ReqT message) {
        this.f2306a.n();
        i.a(getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), message);
        e();
        this.f2308a.c(message);
    }

    /* access modifiers changed from: private */
    public void g() {
        if (j()) {
            f(f0.Initial, p.f3953a);
        }
    }

    /* access modifiers changed from: package-private */
    public void h(p status) {
        n4.d(k(), "Can't handle server close on non-started stream!", new Object[0]);
        f(f0.Error, status);
    }

    /* access modifiers changed from: private */
    public void o() {
        this.f2302a = f0.Open;
        this.f2310a.b();
    }

    private void p() {
        n4.d(this.f2302a == f0.Error, "Should only perform backoff in an error state", new Object[0]);
        this.f2302a = f0.Backoff;
        this.f2307a.a(a.a(this));
    }

    static /* synthetic */ void l(b bVar) {
        f0 f0Var = bVar.f2302a;
        n4.d(f0Var == f0.Backoff, "State should still be backoff but was %s", f0Var);
        bVar.f2302a = f0.Initial;
        bVar.q();
        n4.d(bVar.k(), "Stream should have started", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public void m() {
        if (j() && this.f2304a == null) {
            this.f2304a = this.f2306a.f(this.f2305a, d, this.f2301a);
        }
    }

    private void e() {
        c.b bVar = this.f2304a;
        if (bVar != null) {
            bVar.c();
            this.f2304a = null;
        }
    }
}
