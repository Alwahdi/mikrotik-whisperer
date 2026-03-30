package io.grpc.internal;

import defpackage.f9;
import defpackage.qc;
import io.grpc.b;
import io.grpc.internal.k1;
import io.grpc.internal.o;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

final class n<ReqT, RespT> extends io.grpc.b<ReqT, RespT> {
    static final long a = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: a  reason: collision with other field name */
    private static final Logger f3523a = Logger.getLogger(n.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f3524a = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* renamed from: a  reason: collision with other field name */
    private gf f3525a = gf.c();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final k f3526a;

    /* renamed from: a  reason: collision with other field name */
    private final f f3527a;

    /* renamed from: a  reason: collision with other field name */
    private n<ReqT, RespT>.defpackage.g f3528a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final m<ReqT, RespT> f3529a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Executor f3530a;

    /* renamed from: a  reason: collision with other field name */
    private final ScheduledExecutorService f3531a;

    /* renamed from: a  reason: collision with other field name */
    private volatile ScheduledFuture<?> f3532a;

    /* renamed from: a  reason: collision with other field name */
    private final n7 f3533a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final qc f3534a;

    /* renamed from: a  reason: collision with other field name */
    private ub f3535a = ub.a();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final yp0 f3536a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public z8 f3537a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f3538a;
    private volatile ScheduledFuture<?> b;

    /* renamed from: b  reason: collision with other field name */
    private final boolean f3539b;
    /* access modifiers changed from: private */
    public volatile boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    interface f {
        z8 a(m<?, ?> mVar, n7 n7Var, l lVar, qc qcVar);
    }

    n(m<ReqT, RespT> method, Executor executor, n7 callOptions, f clientStreamProvider, ScheduledExecutorService deadlineCancellationExecutor, k channelCallsTracer, du configSelector) {
        boolean z = false;
        this.g = false;
        this.f3529a = method;
        yp0 b2 = a90.b(method.c(), (long) System.identityHashCode(this));
        this.f3536a = b2;
        if (executor == com.google.common.util.concurrent.b.a()) {
            this.f3530a = new e1();
            this.f3538a = true;
        } else {
            this.f3530a = new mk0(executor);
            this.f3538a = false;
        }
        this.f3526a = channelCallsTracer;
        this.f3534a = qc.e();
        this.f3539b = (method.e() == m.d.UNARY || method.e() == m.d.SERVER_STREAMING) ? true : z;
        this.f3533a = callOptions;
        this.f3527a = clientStreamProvider;
        this.f3531a = deadlineCancellationExecutor;
        a90.c("ClientCall.<init>", b2);
    }

    private final class g implements qc.a {
        private b.a<RespT> a;

        private g(b.a<RespT> observer) {
            this.a = observer;
        }
    }

    /* access modifiers changed from: package-private */
    public n<ReqT, RespT> D(boolean fullStreamDecompression) {
        this.f = fullStreamDecompression;
        return this;
    }

    /* access modifiers changed from: package-private */
    public n<ReqT, RespT> C(gf decompressorRegistry) {
        this.f3525a = decompressorRegistry;
        return this;
    }

    /* access modifiers changed from: package-private */
    public n<ReqT, RespT> B(ub compressorRegistry) {
        this.f3535a = compressorRegistry;
        return this;
    }

    static void y(l headers, gf decompressorRegistry, tb compressor, boolean fullStreamDecompression) {
        l.g<String> gVar = h0.f3432b;
        headers.d(gVar);
        if (compressor != f9.b.a) {
            headers.o(gVar, compressor.a());
        }
        l.g<byte[]> gVar2 = h0.f3434c;
        headers.d(gVar2);
        byte[] advertisedEncodings = eu.a(decompressorRegistry);
        if (advertisedEncodings.length != 0) {
            headers.o(gVar2, advertisedEncodings);
        }
        headers.d(h0.d);
        l.g<byte[]> gVar3 = h0.e;
        headers.d(gVar3);
        if (fullStreamDecompression) {
            headers.o(gVar3, f3524a);
        }
    }

    public void d(b.a<RespT> observer, l headers) {
        a90.g("ClientCall.start", this.f3536a);
        try {
            F(observer, headers);
        } finally {
            a90.i("ClientCall.start", this.f3536a);
        }
    }

    private void F(b.a<RespT> observer, l headers) {
        tb compressor;
        boolean deadlineExceeded = false;
        v90.u(this.f3537a == null, "Already started");
        v90.u(!this.d, "call was cancelled");
        v90.o(observer, "observer");
        v90.o(headers, "headers");
        if (this.f3534a.h()) {
            this.f3537a = m30.a;
            u(observer, io.grpc.f.a(this.f3534a));
            return;
        }
        String compressorName = this.f3533a.b();
        if (compressorName != null) {
            compressor = this.f3535a.b(compressorName);
            if (compressor == null) {
                this.f3537a = m30.a;
                u(observer, p.o.q(String.format("Unable to find compressor by name %s", new Object[]{compressorName})));
                return;
            }
        } else {
            compressor = f9.b.a;
        }
        y(headers, this.f3525a, compressor, this.f);
        ze effectiveDeadline = t();
        if (effectiveDeadline != null && effectiveDeadline.h()) {
            deadlineExceeded = true;
        }
        if (!deadlineExceeded) {
            w(effectiveDeadline, this.f3534a.g(), this.f3533a.d());
            this.f3537a = this.f3527a.a(this.f3529a, this.f3533a, headers, this.f3534a);
        } else {
            p pVar = p.e;
            this.f3537a = new z(pVar.q("ClientCall started after deadline exceeded: " + effectiveDeadline));
        }
        if (this.f3538a) {
            this.f3537a.o();
        }
        if (this.f3533a.a() != null) {
            this.f3537a.j(this.f3533a.a());
        }
        if (this.f3533a.f() != null) {
            this.f3537a.c(this.f3533a.f().intValue());
        }
        if (this.f3533a.g() != null) {
            this.f3537a.a(this.f3533a.g().intValue());
        }
        if (effectiveDeadline != null) {
            this.f3537a.h(effectiveDeadline);
        }
        this.f3537a.e(compressor);
        boolean z = this.f;
        if (z) {
            this.f3537a.l(z);
        }
        this.f3537a.d(this.f3525a);
        this.f3526a.b();
        this.f3528a = new g(observer);
        this.f3537a.k(new e(observer));
        this.f3534a.a(this.f3528a, com.google.common.util.concurrent.b.a());
        if (effectiveDeadline != null && !effectiveDeadline.equals(this.f3534a.g()) && this.f3531a != null && !(this.f3537a instanceof z)) {
            this.f3532a = E(effectiveDeadline, observer);
        }
        if (this.c) {
            z();
        }
    }

    private static void w(ze effectiveDeadline, ze outerCallDeadline, ze callDeadline) {
        Logger logger = f3523a;
        if (logger.isLoggable(Level.FINE) && effectiveDeadline != null && effectiveDeadline.equals(outerCallDeadline)) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            StringBuilder builder = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", new Object[]{Long.valueOf(Math.max(0, effectiveDeadline.j(timeUnit)))}));
            if (callDeadline == null) {
                builder.append(" Explicit call timeout was not set.");
            } else {
                builder.append(String.format(" Explicit call timeout was '%d' ns.", new Object[]{Long.valueOf(callDeadline.j(timeUnit))}));
            }
            logger.fine(builder.toString());
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        this.f3534a.i(this.f3528a);
        ScheduledFuture<?> f2 = this.b;
        if (f2 != null) {
            f2.cancel(false);
        }
        ScheduledFuture<?> f3 = this.f3532a;
        if (f3 != null) {
            f3.cancel(false);
        }
    }

    private ScheduledFuture<?> E(ze deadline, b.a<RespT> observer) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long remainingNanos = deadline.j(timeUnit);
        return this.f3531a.schedule(new ty(new c(remainingNanos, observer)), remainingNanos, timeUnit);
    }

    class c implements Runnable {
        final /* synthetic */ long a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ b.a f3542a;

        c(long j, b.a aVar) {
            this.a = j;
            this.f3542a = aVar;
        }

        public void run() {
            n.this.s(n.this.q(this.a), this.f3542a);
        }
    }

    /* access modifiers changed from: private */
    public p q(long remainingNanos) {
        vs insight = new vs();
        this.f3537a.n(insight);
        long abs = Math.abs(remainingNanos);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long seconds = abs / timeUnit.toNanos(1);
        long nanos = Math.abs(remainingNanos) % timeUnit.toNanos(1);
        StringBuilder buf = new StringBuilder();
        buf.append("deadline exceeded after ");
        if (remainingNanos < 0) {
            buf.append('-');
        }
        buf.append(seconds);
        buf.append(String.format(".%09d", new Object[]{Long.valueOf(nanos)}));
        buf.append("s. ");
        buf.append(insight);
        return p.e.e(buf.toString());
    }

    /* access modifiers changed from: private */
    public void s(p status, b.a<RespT> observer) {
        if (this.b == null) {
            this.b = this.f3531a.schedule(new ty(new d(status)), a, TimeUnit.NANOSECONDS);
            u(observer, status);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ p f3544a;

        d(p pVar) {
            this.f3544a = pVar;
        }

        public void run() {
            n.this.f3537a.b(this.f3544a);
        }
    }

    class b extends s {
        final /* synthetic */ b.a a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ p f3541a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(b.a aVar, p pVar) {
            super(n.this.f3534a);
            this.a = aVar;
            this.f3541a = pVar;
        }

        public void a() {
            n.this.r(this.a, this.f3541a, new l());
        }
    }

    private void u(b.a<RespT> observer, p status) {
        this.f3530a.execute(new b(observer, status));
    }

    /* access modifiers changed from: private */
    public void r(b.a<RespT> observer, p status, l trailers) {
        if (!this.g) {
            this.g = true;
            observer.a(status, trailers);
        }
    }

    /* access modifiers changed from: private */
    public ze t() {
        return x(this.f3533a.d(), this.f3534a.g());
    }

    private static ze x(ze deadline0, ze deadline1) {
        if (deadline0 == null) {
            return deadline1;
        }
        if (deadline1 == null) {
            return deadline0;
        }
        return deadline0.i(deadline1);
    }

    public void b(int numMessages) {
        a90.g("ClientCall.request", this.f3536a);
        try {
            boolean z = true;
            v90.u(this.f3537a != null, "Not started");
            if (numMessages < 0) {
                z = false;
            }
            v90.e(z, "Number requested must be non-negative");
            this.f3537a.f(numMessages);
        } finally {
            a90.i("ClientCall.request", this.f3536a);
        }
    }

    public void a() {
        a90.g("ClientCall.halfClose", this.f3536a);
        try {
            v();
        } finally {
            a90.i("ClientCall.halfClose", this.f3536a);
        }
    }

    private void v() {
        v90.u(this.f3537a != null, "Not started");
        v90.u(!this.d, "call was cancelled");
        v90.u(!this.e, "call already half-closed");
        this.e = true;
        this.f3537a.m();
    }

    public void c(ReqT message) {
        a90.g("ClientCall.sendMessage", this.f3536a);
        try {
            A(message);
        } finally {
            a90.i("ClientCall.sendMessage", this.f3536a);
        }
    }

    private void A(ReqT message) {
        v90.u(this.f3537a != null, "Not started");
        v90.u(!this.d, "call was cancelled");
        v90.u(!this.e, "call was half-closed");
        try {
            RetriableStream<ReqT> retriableStream = this.f3537a;
            if (retriableStream instanceof c1) {
                ((c1) retriableStream).h0(message);
            } else {
                retriableStream.g(this.f3529a.j(message));
            }
            if (!this.f3539b) {
                this.f3537a.flush();
            }
        } catch (RuntimeException e2) {
            this.f3537a.b(p.f3956b.p(e2).q("Failed to stream message"));
        } catch (Error e3) {
            this.f3537a.b(p.f3956b.q("Client sendMessage() failed with Error"));
            throw e3;
        }
    }

    public String toString() {
        return f20.c(this).d("method", this.f3529a).toString();
    }

    private class e implements o {
        /* access modifiers changed from: private */
        public final b.a<RespT> a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public p f3546a;

        public e(b.a<RespT> observer) {
            this.a = (b.a) v90.o(observer, "observer");
        }

        /* access modifiers changed from: private */
        public void j(p status) {
            this.f3546a = status;
            n.this.f3537a.b(status);
        }

        public void e(l headers) {
            a90.g("ClientStreamListener.headersRead", n.this.f3536a);
            try {
                n.this.f3530a.execute(new a(a90.e(), headers));
            } finally {
                a90.i("ClientStreamListener.headersRead", n.this.f3536a);
            }
        }

        final class a extends s {
            final /* synthetic */ hx a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ l f3548a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(hx hxVar, l lVar) {
                super(n.this.f3534a);
                this.a = hxVar;
                this.f3548a = lVar;
            }

            public void a() {
                a90.g("ClientCall$Listener.headersRead", n.this.f3536a);
                a90.d(this.a);
                try {
                    b();
                } finally {
                    a90.i("ClientCall$Listener.headersRead", n.this.f3536a);
                }
            }

            private void b() {
                if (e.this.f3546a == null) {
                    try {
                        e.this.a.b(this.f3548a);
                    } catch (Throwable t) {
                        e.this.j(p.f3956b.p(t).q("Failed to read headers"));
                    }
                }
            }
        }

        public void a(k1.a producer) {
            a90.g("ClientStreamListener.messagesAvailable", n.this.f3536a);
            try {
                n.this.f3530a.execute(new b(a90.e(), producer));
            } finally {
                a90.i("ClientStreamListener.messagesAvailable", n.this.f3536a);
            }
        }

        final class b extends s {
            final /* synthetic */ hx a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ k1.a f3549a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(hx hxVar, k1.a aVar) {
                super(n.this.f3534a);
                this.a = hxVar;
                this.f3549a = aVar;
            }

            public void a() {
                a90.g("ClientCall$Listener.messagesAvailable", n.this.f3536a);
                a90.d(this.a);
                try {
                    b();
                } finally {
                    a90.i("ClientCall$Listener.messagesAvailable", n.this.f3536a);
                }
            }

            private void b() {
                InputStream message;
                if (e.this.f3546a != null) {
                    h0.c(this.f3549a);
                    return;
                }
                while (true) {
                    try {
                        InputStream c = this.f3549a.c();
                        message = c;
                        if (c != null) {
                            e.this.a.c(n.this.f3529a.i(message));
                            message.close();
                        } else {
                            return;
                        }
                    } catch (Throwable t) {
                        h0.c(this.f3549a);
                        e.this.j(p.f3956b.p(t).q("Failed to read message."));
                        return;
                    }
                }
            }
        }

        public void d(p status, l trailers) {
            c(status, o.a.PROCESSED, trailers);
        }

        public void c(p status, o.a rpcProgress, l trailers) {
            a90.g("ClientStreamListener.closed", n.this.f3536a);
            try {
                i(status, rpcProgress, trailers);
            } finally {
                a90.i("ClientStreamListener.closed", n.this.f3536a);
            }
        }

        private void i(p status, o.a rpcProgress, l trailers) {
            ze deadline = n.this.t();
            if (status.m() == p.b.CANCELLED && deadline != null && deadline.h()) {
                vs insight = new vs();
                n.this.f3537a.n(insight);
                p pVar = p.e;
                status = pVar.e("ClientCall was cancelled at or after deadline. " + insight);
                trailers = new l();
            }
            n.this.f3530a.execute(new c(a90.e(), status, trailers));
        }

        final class c extends s {
            final /* synthetic */ hx a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ l f3552a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ p f3553a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(hx hxVar, p pVar, l lVar) {
                super(n.this.f3534a);
                this.a = hxVar;
                this.f3553a = pVar;
                this.f3552a = lVar;
            }

            public void a() {
                a90.g("ClientCall$Listener.onClose", n.this.f3536a);
                a90.d(this.a);
                try {
                    b();
                } finally {
                    a90.i("ClientCall$Listener.onClose", n.this.f3536a);
                }
            }

            private void b() {
                p status = this.f3553a;
                l trailers = this.f3552a;
                if (e.this.f3546a != null) {
                    status = e.this.f3546a;
                    trailers = new l();
                }
                boolean unused = n.this.c = true;
                try {
                    e eVar = e.this;
                    n.this.r(eVar.a, status, trailers);
                } finally {
                    n.this.z();
                    n.this.f3526a.a(status.o());
                }
            }
        }

        public void b() {
            if (!n.this.f3529a.e().clientSendsOneMessage()) {
                a90.g("ClientStreamListener.onReady", n.this.f3536a);
                try {
                    n.this.f3530a.execute(new d(a90.e()));
                } finally {
                    a90.i("ClientStreamListener.onReady", n.this.f3536a);
                }
            }
        }

        final class d extends s {
            final /* synthetic */ hx a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(hx hxVar) {
                super(n.this.f3534a);
                this.a = hxVar;
            }

            public void a() {
                a90.g("ClientCall$Listener.onReady", n.this.f3536a);
                a90.d(this.a);
                try {
                    b();
                } finally {
                    a90.i("ClientCall$Listener.onReady", n.this.f3536a);
                }
            }

            private void b() {
                if (e.this.f3546a == null) {
                    try {
                        e.this.a.d();
                    } catch (Throwable t) {
                        e.this.j(p.f3956b.p(t).q("Failed to call onReady."));
                    }
                }
            }
        }
    }
}
