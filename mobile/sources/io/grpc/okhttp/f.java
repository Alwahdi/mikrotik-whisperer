package io.grpc.okhttp;

import io.grpc.internal.a;
import io.grpc.internal.k0;
import io.grpc.internal.m1;
import io.grpc.internal.o;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;
import java.util.List;

class f extends io.grpc.internal.a {
    /* access modifiers changed from: private */
    public static final r6 a = new r6();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile int f3850a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final cn0 f3851a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final m<?, ?> f3852a;

    /* renamed from: a  reason: collision with other field name */
    private final a f3853a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final b f3854a;

    /* renamed from: a  reason: collision with other field name */
    private Object f3855a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final String f3856a;

    /* renamed from: a  reason: collision with other field name */
    private final v4 f3857a;
    /* access modifiers changed from: private */
    public String b;
    /* access modifiers changed from: private */
    public boolean d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f(m<?, ?> method, l headers, b frameWriter, g transport, o outboundFlow, Object lock, int maxMessageSize, int initialWindowSize, String authority, String userAgent, cn0 statsTraceCtx, m1 transportTracer, n7 callOptions, boolean useGetForSafeMethods) {
        super(new n(), statsTraceCtx, transportTracer, headers, callOptions, useGetForSafeMethods && method.f());
        this.f3850a = -1;
        this.f3853a = new a();
        this.d = false;
        this.f3851a = (cn0) v90.o(statsTraceCtx, "statsTraceCtx");
        this.f3852a = method;
        this.b = authority;
        this.f3856a = userAgent;
        this.f3857a = transport.V();
        this.f3854a = new b(maxMessageSize, statsTraceCtx, lock, frameWriter, outboundFlow, transport, initialWindowSize, method.c());
    }

    /* access modifiers changed from: protected */
    /* renamed from: R */
    public b y() {
        return this.f3854a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public a u() {
        return this.f3853a;
    }

    public m.d O() {
        return this.f3852a.e();
    }

    public int P() {
        return this.f3850a;
    }

    /* access modifiers changed from: package-private */
    public boolean S() {
        return this.d;
    }

    public void j(String authority) {
        this.b = (String) v90.o(authority, "authority");
    }

    public v4 i() {
        return this.f3857a;
    }

    class a implements a.b {
        a() {
        }

        public void c(l metadata, byte[] payload) {
            a90.f("OkHttpClientStream$Sink.writeHeaders");
            String defaultPath = "/" + f.this.f3852a.c();
            if (payload != null) {
                boolean unused = f.this.d = true;
                defaultPath = defaultPath + "?" + x5.a().e(payload);
            }
            try {
                synchronized (f.this.f3854a.f3864b) {
                    f.this.f3854a.d0(metadata, defaultPath);
                }
                a90.h("OkHttpClientStream$Sink.writeHeaders");
            } catch (Throwable th) {
                a90.h("OkHttpClientStream$Sink.writeHeaders");
                throw th;
            }
        }

        public void a(bw0 frame, boolean endOfStream, boolean flush, int numMessages) {
            r6 buffer;
            a90.f("OkHttpClientStream$Sink.writeFrame");
            if (frame == null) {
                buffer = f.a;
            } else {
                buffer = ((m) frame).e();
                int size = (int) buffer.g0();
                if (size > 0) {
                    f.this.s(size);
                }
            }
            try {
                synchronized (f.this.f3854a.f3864b) {
                    f.this.f3854a.b0(buffer, endOfStream, flush);
                    f.this.w().e(numMessages);
                }
                a90.h("OkHttpClientStream$Sink.writeFrame");
            } catch (Throwable th) {
                a90.h("OkHttpClientStream$Sink.writeFrame");
                throw th;
            }
        }

        public void b(p reason) {
            a90.f("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (f.this.f3854a.f3864b) {
                    f.this.f3854a.Z(reason, true, (l) null);
                }
                a90.h("OkHttpClientStream$Sink.cancel");
            } catch (Throwable th) {
                a90.h("OkHttpClientStream$Sink.cancel");
                throw th;
            }
        }
    }

    class b extends k0 {
        private final b a;

        /* renamed from: a  reason: collision with other field name */
        private final g f3859a;

        /* renamed from: a  reason: collision with other field name */
        private final o f3860a;

        /* renamed from: a  reason: collision with other field name */
        private List<pq> f3861a;

        /* renamed from: a  reason: collision with other field name */
        private r6 f3862a = new r6();

        /* renamed from: a  reason: collision with other field name */
        private final yp0 f3863a;
        private final int b;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with other field name */
        public final Object f3864b;
        private int c;
        private int d;
        private boolean j = false;
        private boolean k = false;
        private boolean l = false;
        private boolean m = true;

        public b(int maxMessageSize, cn0 statsTraceCtx, Object lock, b frameWriter, o outboundFlow, g transport, int initialWindowSize, String methodName) {
            super(maxMessageSize, statsTraceCtx, f.this.w());
            this.f3864b = v90.o(lock, "lock");
            this.a = frameWriter;
            this.f3860a = outboundFlow;
            this.f3859a = transport;
            this.c = initialWindowSize;
            this.d = initialWindowSize;
            this.b = initialWindowSize;
            this.f3863a = a90.a(methodName);
        }

        public void c0(int streamId) {
            v90.v(f.this.f3850a == -1, "the stream has been started with id %s", streamId);
            int unused = f.this.f3850a = streamId;
            f.this.f3854a.q();
            if (this.m) {
                this.a.i(f.this.d, false, f.this.f3850a, 0, this.f3861a);
                f.this.f3851a.c();
                this.f3861a = null;
                if (this.f3862a.g0() > 0) {
                    this.f3860a.c(this.j, f.this.f3850a, this.f3862a, this.k);
                }
                this.m = false;
            }
        }

        /* access modifiers changed from: protected */
        public void q() {
            super.q();
            k().c();
        }

        /* access modifiers changed from: protected */
        public void O(p status, boolean stopDelivery, l trailers) {
            Z(status, stopDelivery, trailers);
        }

        public void d(Throwable cause) {
            O(p.k(cause), true, new l());
        }

        public void e(int processedBytes) {
            int i = this.d - processedBytes;
            this.d = i;
            int i2 = this.b;
            if (((float) i) <= ((float) i2) * 0.5f) {
                int delta = i2 - i;
                this.c += delta;
                this.d = i + delta;
                this.a.a(f.this.P(), (long) delta);
            }
        }

        public void c(boolean hasPartialMessage) {
            a0();
            super.c(hasPartialMessage);
        }

        public void b(Runnable r) {
            synchronized (this.f3864b) {
                r.run();
            }
        }

        public void g0(List<pq> headers, boolean endOfStream) {
            if (endOfStream) {
                T(p.c(headers));
            } else {
                S(p.a(headers));
            }
        }

        public void f0(r6 frame, boolean endOfStream) {
            int g0 = this.c - ((int) frame.g0());
            this.c = g0;
            if (g0 < 0) {
                this.a.d(f.this.P(), io.grpc.okhttp.internal.framed.a.FLOW_CONTROL_ERROR);
                this.f3859a.T(f.this.P(), p.o.q("Received data size exceeded our receiving window size"), o.a.PROCESSED, false, (io.grpc.okhttp.internal.framed.a) null, (l) null);
                return;
            }
            super.R(new j(frame), endOfStream);
        }

        private void a0() {
            if (!F()) {
                this.f3859a.T(f.this.P(), (p) null, o.a.PROCESSED, false, io.grpc.okhttp.internal.framed.a.CANCEL, (l) null);
            } else {
                this.f3859a.T(f.this.P(), (p) null, o.a.PROCESSED, false, (io.grpc.okhttp.internal.framed.a) null, (l) null);
            }
        }

        /* access modifiers changed from: private */
        public void Z(p reason, boolean stopDelivery, l trailers) {
            if (!this.l) {
                this.l = true;
                if (this.m) {
                    this.f3859a.i0(f.this);
                    this.f3861a = null;
                    this.f3862a.c();
                    this.m = false;
                    M(reason, true, trailers != null ? trailers : new l());
                    return;
                }
                this.f3859a.T(f.this.P(), reason, o.a.PROCESSED, stopDelivery, io.grpc.okhttp.internal.framed.a.CANCEL, trailers);
            }
        }

        /* access modifiers changed from: private */
        public void b0(r6 buffer, boolean endOfStream, boolean flush) {
            if (!this.l) {
                if (this.m) {
                    this.f3862a.G(buffer, (long) ((int) buffer.g0()));
                    this.j |= endOfStream;
                    this.k |= flush;
                    return;
                }
                v90.u(f.this.P() != -1, "streamId should be set");
                this.f3860a.c(endOfStream, f.this.P(), buffer, flush);
            }
        }

        /* access modifiers changed from: private */
        public void d0(l metadata, String path) {
            this.f3861a = c.a(metadata, path, f.this.b, f.this.f3856a, f.this.d, this.f3859a.c0());
            this.f3859a.p0(f.this);
        }

        /* access modifiers changed from: package-private */
        public yp0 e0() {
            return this.f3863a;
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(Object outboundFlowState) {
        this.f3855a = outboundFlowState;
    }

    /* access modifiers changed from: package-private */
    public Object N() {
        return this.f3855a;
    }
}
