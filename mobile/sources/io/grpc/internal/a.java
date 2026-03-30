package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import defpackage.f9;
import io.grpc.internal.c;
import io.grpc.internal.o;
import io.grpc.internal.v0;
import io.grpc.l;
import io.grpc.p;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.protocol.HTTP;

public abstract class a extends c implements z8, v0.d {
    /* access modifiers changed from: private */
    public static final Logger a = Logger.getLogger(a.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private final m1 f3278a;

    /* renamed from: a  reason: collision with other field name */
    private l f3279a;

    /* renamed from: a  reason: collision with other field name */
    private final rn f3280a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3281a;
    private boolean b;
    private volatile boolean c;

    protected interface b {
        void a(bw0 bw0, boolean z, boolean z2, int i);

        void b(p pVar);

        void c(l lVar, byte[] bArr);
    }

    /* access modifiers changed from: protected */
    public abstract b u();

    /* access modifiers changed from: protected */
    public abstract c y();

    protected a(cw0 bufferAllocator, cn0 statsTraceCtx, m1 transportTracer, l headers, n7 callOptions, boolean useGet) {
        v90.o(headers, "headers");
        this.f3278a = (m1) v90.o(transportTracer, "transportTracer");
        this.f3281a = h0.l(callOptions);
        this.b = useGet;
        if (!useGet) {
            this.f3280a = new v0(this, bufferAllocator, statsTraceCtx);
            this.f3279a = headers;
            return;
        }
        this.f3280a = new C0041a(headers, statsTraceCtx);
    }

    public void h(ze deadline) {
        l lVar = this.f3279a;
        l.g<Long> gVar = h0.f3424a;
        lVar.d(gVar);
        this.f3279a.o(gVar, Long.valueOf(Math.max(0, deadline.j(TimeUnit.NANOSECONDS))));
    }

    public void a(int maxSize) {
        this.f3280a.a(maxSize);
    }

    public void c(int maxSize) {
        y().w(maxSize);
    }

    public final void l(boolean fullStreamDecompression) {
        y().I(fullStreamDecompression);
    }

    public final void d(gf decompressorRegistry) {
        y().H(decompressorRegistry);
    }

    public final void k(o listener) {
        y().J(listener);
        if (!this.b) {
            u().c(this.f3279a, (byte[]) null);
            this.f3279a = null;
        }
    }

    /* access modifiers changed from: protected */
    public final rn r() {
        return this.f3280a;
    }

    public final boolean x() {
        return this.f3281a;
    }

    public final void p(bw0 frame, boolean endOfStream, boolean flush, int numMessages) {
        v90.e(frame != null || endOfStream, "null frame before EOS");
        u().a(frame, endOfStream, flush, numMessages);
    }

    public final void m() {
        if (!y().F()) {
            y().K();
            q();
        }
    }

    public final void b(p reason) {
        v90.e(!reason.o(), "Should not cancel with OK status");
        this.c = true;
        u().b(reason);
    }

    public final void n(vs insight) {
        insight.b("remote_addr", i().b(eq.a));
    }

    /* access modifiers changed from: protected */
    public m1 w() {
        return this.f3278a;
    }

    protected static abstract class c extends c.a {
        private gf a = gf.c();

        /* renamed from: a  reason: collision with other field name */
        private o f3286a;

        /* renamed from: a  reason: collision with other field name */
        private Runnable f3287a;
        private final cn0 b;
        private boolean c;
        private boolean d;
        private boolean e = false;
        private volatile boolean f;
        private boolean g;
        private boolean h;

        protected c(int maxMessageSize, cn0 statsTraceCtx, m1 transportTracer) {
            super(maxMessageSize, statsTraceCtx, transportTracer);
            this.b = (cn0) v90.o(statsTraceCtx, "statsTraceCtx");
        }

        /* access modifiers changed from: private */
        public void I(boolean fullStreamDecompression) {
            this.d = fullStreamDecompression;
        }

        /* access modifiers changed from: private */
        public void H(gf decompressorRegistry) {
            v90.u(this.f3286a == null, "Already called start");
            this.a = (gf) v90.o(decompressorRegistry, "decompressorRegistry");
        }

        public final void J(o listener) {
            v90.u(this.f3286a == null, "Already called setListener");
            this.f3286a = (o) v90.o(listener, "listener");
        }

        public void c(boolean hasPartialMessage) {
            v90.u(this.g, "status should have been reported on deframer closed");
            this.e = true;
            if (this.h && hasPartialMessage) {
                M(p.o.q("Encountered end-of-stream mid-frame"), true, new l());
            }
            Runnable runnable = this.f3287a;
            if (runnable != null) {
                runnable.run();
                this.f3287a = null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: G */
        public final o m() {
            return this.f3286a;
        }

        /* access modifiers changed from: private */
        public final void K() {
            this.f = true;
        }

        /* access modifiers changed from: protected */
        public final boolean F() {
            return this.f;
        }

        /* access modifiers changed from: protected */
        public void D(l headers) {
            v90.u(!this.g, "Received headers on closed stream");
            this.b.a();
            boolean compressedStream = false;
            String streamEncoding = (String) headers.f(h0.d);
            if (this.d && streamEncoding != null) {
                if (streamEncoding.equalsIgnoreCase("gzip")) {
                    v(new i0());
                    compressedStream = true;
                } else if (!streamEncoding.equalsIgnoreCase(HTTP.IDENTITY_CODING)) {
                    d(p.o.q(String.format("Can't find full stream decompressor for %s", new Object[]{streamEncoding})).d());
                    return;
                }
            }
            String messageEncoding = (String) headers.f(h0.f3432b);
            if (messageEncoding != null) {
                ff decompressor = this.a.e(messageEncoding);
                if (decompressor == null) {
                    d(p.o.q(String.format("Can't find decompressor for %s", new Object[]{messageEncoding})).d());
                    return;
                } else if (decompressor != f9.b.a) {
                    if (compressedStream) {
                        d(p.o.q(String.format("Full stream and gRPC message encoding cannot both be set", new Object[0])).d());
                        return;
                    }
                    u(decompressor);
                }
            }
            m().e(headers);
        }

        /* access modifiers changed from: protected */
        public void C(id0 frame) {
            v90.o(frame, "frame");
            boolean needToCloseFrame = true;
            try {
                if (this.g) {
                    a.a.log(Level.INFO, "Received data on closed stream");
                    frame.close();
                    return;
                }
                needToCloseFrame = false;
                j(frame);
            } finally {
                if (needToCloseFrame) {
                    frame.close();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void E(l trailers, p status) {
            v90.o(status, NotificationCompat.CATEGORY_STATUS);
            v90.o(trailers, "trailers");
            if (this.g) {
                a.a.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{status, trailers});
                return;
            }
            this.b.b(trailers);
            M(status, false, trailers);
        }

        public final void M(p status, boolean stopDelivery, l trailers) {
            L(status, o.a.PROCESSED, stopDelivery, trailers);
        }

        public final void L(p status, o.a rpcProgress, boolean stopDelivery, l trailers) {
            v90.o(status, NotificationCompat.CATEGORY_STATUS);
            v90.o(trailers, "trailers");
            if (!this.g || stopDelivery) {
                this.g = true;
                this.h = status.o();
                r();
                if (this.e) {
                    this.f3287a = null;
                    B(status, rpcProgress, trailers);
                    return;
                }
                this.f3287a = new C0042a(status, rpcProgress, trailers);
                i(stopDelivery);
            }
        }

        /* renamed from: io.grpc.internal.a$c$a  reason: collision with other inner class name */
        class C0042a implements Runnable {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ o.a f3288a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ l f3289a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ p f3290a;

            C0042a(p pVar, o.a aVar, l lVar) {
                this.f3290a = pVar;
                this.f3288a = aVar;
                this.f3289a = lVar;
            }

            public void run() {
                c.this.B(this.f3290a, this.f3288a, this.f3289a);
            }
        }

        /* access modifiers changed from: private */
        public void B(p status, o.a rpcProgress, l trailers) {
            if (!this.c) {
                this.c = true;
                this.b.m(status);
                m().c(status, rpcProgress, trailers);
                if (k() != null) {
                    k().f(status.o());
                }
            }
        }
    }

    /* renamed from: io.grpc.internal.a$a  reason: collision with other inner class name */
    private class C0041a implements rn {
        private final cn0 a;

        /* renamed from: a  reason: collision with other field name */
        private l f3283a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f3284a;

        /* renamed from: a  reason: collision with other field name */
        private byte[] f3285a;

        public C0041a(l headers, cn0 statsTraceCtx) {
            this.f3283a = (l) v90.o(headers, "headers");
            this.a = (cn0) v90.o(statsTraceCtx, "statsTraceCtx");
        }

        public void d(InputStream message) {
            v90.u(this.f3285a == null, "writePayload should not be called multiple times");
            try {
                this.f3285a = z6.d(message);
                this.a.i(0);
                cn0 cn0 = this.a;
                byte[] bArr = this.f3285a;
                cn0.j(0, (long) bArr.length, (long) bArr.length);
                this.a.k((long) this.f3285a.length);
                this.a.l((long) this.f3285a.length);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public void flush() {
        }

        public boolean c() {
            return this.f3284a;
        }

        public void close() {
            boolean z = true;
            this.f3284a = true;
            if (this.f3285a == null) {
                z = false;
            }
            v90.u(z, "Lack of request message. GET request is only supported for unary requests");
            a.this.u().c(this.f3283a, this.f3285a);
            this.f3285a = null;
            this.f3283a = null;
        }

        public rn b(tb compressor) {
            return this;
        }

        public void a(int maxSize) {
        }
    }
}
