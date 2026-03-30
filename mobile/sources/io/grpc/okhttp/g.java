package io.grpc.okhttp;

import androidx.core.internal.view.SupportMenu;
import defpackage.ge0;
import defpackage.pn;
import defpackage.yq;
import io.grpc.Status;
import io.grpc.h;
import io.grpc.internal.h0;
import io.grpc.internal.h1;
import io.grpc.internal.l0;
import io.grpc.internal.m1;
import io.grpc.internal.o;
import io.grpc.internal.o0;
import io.grpc.internal.t0;
import io.grpc.l;
import io.grpc.m;
import io.grpc.okhttp.b;
import io.grpc.okhttp.h;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.p;
import io.grpc.q;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class g implements bc, b.a {
    /* access modifiers changed from: private */
    public static final Logger a = Logger.getLogger(g.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private static final f[] f3865a = new f[0];
    private static final Map<io.grpc.okhttp.internal.framed.a, p> b = P();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final int f3866a;

    /* renamed from: a  reason: collision with other field name */
    private long f3867a;

    /* renamed from: a  reason: collision with other field name */
    dl0<Void> f3868a;

    /* renamed from: a  reason: collision with other field name */
    private final es<f> f3869a = new a();

    /* renamed from: a  reason: collision with other field name */
    private final hu f3870a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public h.b f3871a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public l0 f3872a;

    /* renamed from: a  reason: collision with other field name */
    private final m1 f3873a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public o0 f3874a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public t0.a f3875a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public b f3876a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public f f3877a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public h f3878a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final io.grpc.okhttp.internal.b f3879a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public o f3880a;

    /* renamed from: a  reason: collision with other field name */
    private p f3881a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Object f3882a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Runnable f3883a;

    /* renamed from: a  reason: collision with other field name */
    private final String f3884a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final InetSocketAddress f3885a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Socket f3886a;

    /* renamed from: a  reason: collision with other field name */
    private final Deque<f> f3887a = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Map<Integer, f> f3888a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private final Random f3889a = new Random();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Executor f3890a;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledExecutorService f3891a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final SocketFactory f3892a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public HostnameVerifier f3893a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public SSLSocketFactory f3894a;

    /* renamed from: a  reason: collision with other field name */
    private final mk0 f3895a;

    /* renamed from: a  reason: collision with other field name */
    private final oo0<hn0> f3896a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public pn f3897a;

    /* renamed from: a  reason: collision with other field name */
    private qn f3898a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public v4 f3899a;

    /* renamed from: a  reason: collision with other field name */
    final xq f3900a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3901a;

    /* renamed from: b  reason: collision with other field name */
    private int f3902b;

    /* renamed from: b  reason: collision with other field name */
    private long f3903b;

    /* renamed from: b  reason: collision with other field name */
    Runnable f3904b;

    /* renamed from: b  reason: collision with other field name */
    private final String f3905b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f3906b;
    private final int c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f3907c;
    /* access modifiers changed from: private */
    public int d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f3908d;
    /* access modifiers changed from: private */
    public int e = 0;

    /* renamed from: e  reason: collision with other field name */
    private boolean f3909e;
    /* access modifiers changed from: private */
    public final int f;

    /* renamed from: f  reason: collision with other field name */
    private final boolean f3910f;

    static /* synthetic */ int A(g x0, int x1) {
        int i = x0.d + x1;
        x0.d = i;
        return i;
    }

    private static Map<io.grpc.okhttp.internal.framed.a, p> P() {
        Map<ErrorCode, Status> errorToStatus = new EnumMap<>(io.grpc.okhttp.internal.framed.a.class);
        io.grpc.okhttp.internal.framed.a aVar = io.grpc.okhttp.internal.framed.a.NO_ERROR;
        p pVar = p.o;
        errorToStatus.put(aVar, pVar.q("No error: A GRPC status of OK should have been sent"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.PROTOCOL_ERROR, pVar.q("Protocol error"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.INTERNAL_ERROR, pVar.q("Internal error"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.FLOW_CONTROL_ERROR, pVar.q("Flow control error"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.STREAM_CLOSED, pVar.q("Stream closed"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.FRAME_TOO_LARGE, pVar.q("Frame too large"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.REFUSED_STREAM, p.p.q("Refused stream"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.CANCEL, p.f3956b.q("Cancelled"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.COMPRESSION_ERROR, pVar.q("Compression error"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.CONNECT_ERROR, pVar.q("Connect error"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.ENHANCE_YOUR_CALM, p.j.q("Enhance your calm"));
        errorToStatus.put(io.grpc.okhttp.internal.framed.a.INADEQUATE_SECURITY, p.h.q("Inadequate security"));
        return Collections.unmodifiableMap(errorToStatus);
    }

    class a extends es<f> {
        a() {
        }

        /* access modifiers changed from: protected */
        public void a() {
            g.this.f3875a.b(true);
        }

        /* access modifiers changed from: protected */
        public void b() {
            g.this.f3875a.b(false);
        }
    }

    g(InetSocketAddress address, String authority, String userAgent, v4 eagAttrs, Executor executor, SocketFactory socketFactory, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier, io.grpc.okhttp.internal.b connectionSpec, int maxMessageSize, int initialWindowSize, xq proxiedAddr, Runnable tooManyPingsRunnable, int maxInboundMetadataSize, m1 transportTracer, boolean useGetForSafeMethods) {
        Executor executor2 = executor;
        this.f3885a = (InetSocketAddress) v90.o(address, "address");
        this.f3884a = authority;
        this.c = maxMessageSize;
        this.f3866a = initialWindowSize;
        this.f3890a = (Executor) v90.o(executor2, "executor");
        this.f3895a = new mk0(executor2);
        this.f3902b = 3;
        this.f3892a = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.f3894a = sslSocketFactory;
        this.f3893a = hostnameVerifier;
        this.f3879a = (io.grpc.okhttp.internal.b) v90.o(connectionSpec, "connectionSpec");
        this.f3896a = h0.f3428a;
        this.f3905b = h0.e("okhttp", userAgent);
        this.f3900a = proxiedAddr;
        this.f3883a = (Runnable) v90.o(tooManyPingsRunnable, "tooManyPingsRunnable");
        this.f = maxInboundMetadataSize;
        this.f3873a = (m1) v90.n(transportTracer);
        this.f3870a = hu.a(getClass(), address.toString());
        this.f3899a = v4.c().d(fq.b, eagAttrs).a();
        this.f3910f = useGetForSafeMethods;
        a0();
    }

    /* access modifiers changed from: package-private */
    public boolean c0() {
        return this.f3894a == null;
    }

    class b implements m1.c {
        b() {
        }
    }

    private void a0() {
        synchronized (this.f3882a) {
            this.f3873a.g(new b());
        }
    }

    /* access modifiers changed from: package-private */
    public void S(boolean enable, long keepAliveTimeNanos, long keepAliveTimeoutNanos, boolean keepAliveWithoutCalls) {
        this.f3908d = enable;
        this.f3867a = keepAliveTimeNanos;
        this.f3903b = keepAliveTimeoutNanos;
        this.f3909e = keepAliveWithoutCalls;
    }

    private boolean b0() {
        return this.f3885a == null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        r3.a(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(io.grpc.internal.p.a r10, java.util.concurrent.Executor r11) {
        /*
            r9 = this;
            r0 = 0
            java.lang.Object r2 = r9.f3882a
            monitor-enter(r2)
            io.grpc.okhttp.b r3 = r9.f3876a     // Catch:{ all -> 0x0057 }
            r4 = 0
            if (r3 == 0) goto L_0x000c
            r3 = 1
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            defpackage.v90.t(r3)     // Catch:{ all -> 0x0057 }
            boolean r3 = r9.f3906b     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x001d
            java.lang.Throwable r3 = r9.Y()     // Catch:{ all -> 0x0057 }
            io.grpc.internal.l0.g(r10, r11, r3)     // Catch:{ all -> 0x0057 }
            monitor-exit(r2)     // Catch:{ all -> 0x0057 }
            return
        L_0x001d:
            io.grpc.internal.l0 r3 = r9.f3872a     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0024
            r5 = 0
            goto L_0x0045
        L_0x0024:
            java.util.Random r3 = r9.f3889a     // Catch:{ all -> 0x0057 }
            long r5 = r3.nextLong()     // Catch:{ all -> 0x0057 }
            r0 = r5
            oo0<hn0> r3 = r9.f3896a     // Catch:{ all -> 0x0057 }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x0057 }
            hn0 r3 = (defpackage.hn0) r3     // Catch:{ all -> 0x0057 }
            r3.g()     // Catch:{ all -> 0x0057 }
            io.grpc.internal.l0 r5 = new io.grpc.internal.l0     // Catch:{ all -> 0x0057 }
            r5.<init>(r0, r3)     // Catch:{ all -> 0x0057 }
            r9.f3872a = r5     // Catch:{ all -> 0x0057 }
            r6 = 1
            io.grpc.internal.m1 r7 = r9.f3873a     // Catch:{ all -> 0x0057 }
            r7.b()     // Catch:{ all -> 0x0057 }
            r3 = r5
            r5 = r6
        L_0x0045:
            if (r5 == 0) goto L_0x0052
            io.grpc.okhttp.b r6 = r9.f3876a     // Catch:{ all -> 0x0057 }
            r7 = 32
            long r7 = r0 >>> r7
            int r8 = (int) r7     // Catch:{ all -> 0x0057 }
            int r7 = (int) r0     // Catch:{ all -> 0x0057 }
            r6.e(r4, r8, r7)     // Catch:{ all -> 0x0057 }
        L_0x0052:
            monitor-exit(r2)     // Catch:{ all -> 0x0057 }
            r3.a(r10, r11)
            return
        L_0x0057:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0057 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.g.g(io.grpc.internal.p$a, java.util.concurrent.Executor):void");
    }

    /* renamed from: f0 */
    public f f(m<?, ?> method, l headers, n7 callOptions) {
        Object obj;
        l lVar = headers;
        v90.o(method, "method");
        v90.o(lVar, "headers");
        cn0 statsTraceCtx = cn0.h(callOptions, this.f3899a, lVar);
        Object obj2 = this.f3882a;
        synchronized (obj2) {
            try {
                b bVar = this.f3876a;
                o oVar = this.f3880a;
                Object obj3 = this.f3882a;
                int i = this.c;
                int i2 = this.f3866a;
                String str = this.f3884a;
                String str2 = this.f3905b;
                m1 m1Var = this.f3873a;
                obj = obj2;
                f fVar = new f(method, headers, bVar, this, oVar, obj3, i, i2, str, str2, statsTraceCtx, m1Var, callOptions, this.f3910f);
                return fVar;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p0(f clientStream) {
        if (this.f3881a != null) {
            clientStream.y().L(this.f3881a, o.a.REFUSED, true, new l());
        } else if (this.f3888a.size() >= this.e) {
            this.f3887a.add(clientStream);
            k0(clientStream);
        } else {
            n0(clientStream);
        }
    }

    private void n0(f stream) {
        v90.u(stream.P() == -1, "StreamId already assigned");
        this.f3888a.put(Integer.valueOf(this.f3902b), stream);
        k0(stream);
        stream.y().c0(this.f3902b);
        if (!(stream.O() == m.d.UNARY || stream.O() == m.d.SERVER_STREAMING) || stream.S()) {
            this.f3876a.flush();
        }
        int i = this.f3902b;
        if (i >= 2147483645) {
            this.f3902b = Integer.MAX_VALUE;
            l0(Integer.MAX_VALUE, io.grpc.okhttp.internal.framed.a.NO_ERROR, p.p.q("Stream ids exhausted"));
            return;
        }
        this.f3902b = i + 2;
    }

    /* access modifiers changed from: private */
    public boolean m0() {
        boolean hasStreamStarted = false;
        while (!this.f3887a.isEmpty() && this.f3888a.size() < this.e) {
            n0(this.f3887a.poll());
            hasStreamStarted = true;
        }
        return hasStreamStarted;
    }

    /* access modifiers changed from: package-private */
    public void i0(f pendingStream) {
        this.f3887a.remove(pendingStream);
        e0(pendingStream);
    }

    /* JADX INFO: finally extract failed */
    public Runnable d(t0.a listener) {
        this.f3875a = (t0.a) v90.o(listener, "listener");
        if (this.f3908d) {
            this.f3891a = (ScheduledExecutorService) h1.d(h0.f3431b);
            o0 o0Var = new o0(new o0.c(this), this.f3891a, this.f3867a, this.f3903b, this.f3909e);
            this.f3874a = o0Var;
            o0Var.p();
        }
        if (b0()) {
            synchronized (this.f3882a) {
                b bVar = new b(this, this.f3898a, this.f3878a);
                this.f3876a = bVar;
                this.f3880a = new o(this, bVar);
            }
            this.f3895a.execute(new c());
            return null;
        }
        a asyncSink = a.P(this.f3895a, this);
        wu0 variant = new wq();
        qn rawFrameWriter = variant.a(l40.a(asyncSink), true);
        synchronized (this.f3882a) {
            b bVar2 = new b(this, rawFrameWriter);
            this.f3876a = bVar2;
            this.f3880a = new o(this, bVar2);
        }
        CountDownLatch latch = new CountDownLatch(1);
        this.f3895a.execute(new d(latch, asyncSink, variant));
        try {
            j0();
            latch.countDown();
            this.f3895a.execute(new e());
            return null;
        } catch (Throwable th) {
            latch.countDown();
            throw th;
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            Runnable runnable = g.this.f3904b;
            if (runnable != null) {
                runnable.run();
            }
            g gVar = g.this;
            f unused = gVar.f3877a = new f(gVar.f3897a, g.this.f3878a);
            g.this.f3890a.execute(g.this.f3877a);
            synchronized (g.this.f3882a) {
                int unused2 = g.this.e = Integer.MAX_VALUE;
                boolean unused3 = g.this.m0();
            }
            g.this.f3868a.a(null);
            throw null;
        }
    }

    class d implements Runnable {
        final /* synthetic */ a a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ CountDownLatch f3912a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ wu0 f3913a;

        d(CountDownLatch countDownLatch, a aVar, wu0 wu0) {
            this.f3912a = countDownLatch;
            this.a = aVar;
            this.f3913a = wu0;
        }

        public void run() {
            Socket sock;
            try {
                this.f3912a.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            t6 source = l40.b(new a());
            SSLSession sslSession = null;
            try {
                g gVar = g.this;
                xq xqVar = gVar.f3900a;
                if (xqVar == null) {
                    sock = gVar.f3892a.createSocket(g.this.f3885a.getAddress(), g.this.f3885a.getPort());
                } else if (xqVar.b() instanceof InetSocketAddress) {
                    g gVar2 = g.this;
                    sock = gVar2.R(gVar2.f3900a.c(), (InetSocketAddress) g.this.f3900a.b(), g.this.f3900a.d(), g.this.f3900a.a());
                } else {
                    p pVar = p.o;
                    throw pVar.q("Unsupported SocketAddress implementation " + g.this.f3900a.b().getClass()).c();
                }
                if (g.this.f3894a != null) {
                    SSLSocket sslSocket = l.b(g.this.f3894a, g.this.f3893a, sock, g.this.W(), g.this.X(), g.this.f3879a);
                    sslSession = sslSocket.getSession();
                    sock = sslSocket;
                }
                sock.setTcpNoDelay(true);
                t6 source2 = l40.b(l40.g(sock));
                this.a.K(l40.e(sock), sock);
                g gVar3 = g.this;
                v4 unused = gVar3.f3899a = gVar3.f3899a.d().d(eq.a, sock.getRemoteSocketAddress()).d(eq.b, sock.getLocalSocketAddress()).d(eq.c, sslSession).d(fq.a, sslSession == null ? io.grpc.o.NONE : io.grpc.o.PRIVACY_AND_INTEGRITY).a();
                g gVar4 = g.this;
                f unused2 = gVar4.f3877a = new f(gVar4, this.f3913a.b(source2, true));
                synchronized (g.this.f3882a) {
                    Socket unused3 = g.this.f3886a = (Socket) v90.o(sock, "socket");
                    if (sslSession != null) {
                        h.b unused4 = g.this.f3871a = new h.b(new h.c(sslSession));
                    }
                }
            } catch (q e2) {
                g.this.l0(0, io.grpc.okhttp.internal.framed.a.INTERNAL_ERROR, e2.a());
                g gVar5 = g.this;
                f unused5 = gVar5.f3877a = new f(gVar5, this.f3913a.b(source, true));
            } catch (Exception e3) {
                g.this.a(e3);
                g gVar6 = g.this;
                f unused6 = gVar6.f3877a = new f(gVar6, this.f3913a.b(source, true));
            } catch (Throwable th) {
                g gVar7 = g.this;
                f unused7 = gVar7.f3877a = new f(gVar7, this.f3913a.b(source, true));
                throw th;
            }
        }

        class a implements jm0 {
            a() {
            }

            public long T(r6 sink, long byteCount) {
                return -1;
            }

            public void close() {
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            g.this.f3890a.execute(g.this.f3877a);
            synchronized (g.this.f3882a) {
                int unused = g.this.e = Integer.MAX_VALUE;
                boolean unused2 = g.this.m0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j0() {
        synchronized (this.f3882a) {
            this.f3876a.B();
            el0 settings = new el0();
            k.c(settings, 7, this.f3866a);
            this.f3876a.k(settings);
            int i = this.f3866a;
            if (i > 65535) {
                this.f3876a.a(0, (long) (i - SupportMenu.USER_MASK));
            }
        }
    }

    /* access modifiers changed from: private */
    public Socket R(InetSocketAddress address, InetSocketAddress proxyAddress, String proxyUsername, String proxyPassword) {
        Socket sock;
        try {
            if (proxyAddress.getAddress() != null) {
                sock = this.f3892a.createSocket(proxyAddress.getAddress(), proxyAddress.getPort());
            } else {
                sock = this.f3892a.createSocket(proxyAddress.getHostName(), proxyAddress.getPort());
            }
            sock.setTcpNoDelay(true);
            jm0 source = l40.g(sock);
            s6 sink = l40.a(l40.e(sock));
            try {
                ge0 proxyRequest = Q(address, proxyUsername, proxyPassword);
                yq url = proxyRequest.b();
                sink.R(String.format("CONNECT %s:%d HTTP/1.1", new Object[]{url.c(), Integer.valueOf(url.j())})).R("\r\n");
                int size = proxyRequest.a().b();
                for (int i = 0; i < size; i++) {
                    sink.R(proxyRequest.a().a(i)).R(": ").R(proxyRequest.a().c(i)).R("\r\n");
                }
                sink.R("\r\n");
                sink.flush();
                gn0 statusLine = gn0.a(h0(source));
                while (!h0(source).equals("")) {
                }
                int i2 = statusLine.a;
                if (i2 >= 200 && i2 < 300) {
                    return sock;
                }
                r6 body = new r6();
                try {
                    sock.shutdownOutput();
                    source.T(body, 1024);
                } catch (IOException ex) {
                    body.R("Unable to read body: " + ex.toString());
                }
                try {
                    sock.close();
                } catch (IOException e2) {
                }
                throw p.p.q(String.format("Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", new Object[]{Integer.valueOf(statusLine.a), statusLine.f3115a, body.b0()})).c();
            } catch (IOException e3) {
                e = e3;
                throw p.p.q("Failed trying to connect with proxy").p(e).c();
            }
        } catch (IOException e4) {
            e = e4;
            InetSocketAddress inetSocketAddress = address;
            String str = proxyUsername;
            String str2 = proxyPassword;
            throw p.p.q("Failed trying to connect with proxy").p(e).c();
        }
    }

    private ge0 Q(InetSocketAddress address, String proxyUsername, String proxyPassword) {
        yq tunnelUrl = new yq.b().k("https").h(address.getHostName()).j(address.getPort()).a();
        ge0.b h = new ge0.b().h(tunnelUrl);
        ge0.b request = h.g("Host", tunnelUrl.c() + ":" + tunnelUrl.j()).g("User-Agent", this.f3905b);
        if (!(proxyUsername == null || proxyPassword == null)) {
            request.g("Proxy-Authorization", ud.a(proxyUsername, proxyPassword));
        }
        return request.f();
    }

    private static String h0(jm0 source) {
        r6 buffer = new r6();
        while (source.T(buffer, 1) != -1) {
            if (buffer.P(buffer.g0() - 1) == 10) {
                return buffer.e0();
            }
        }
        throw new EOFException("\\n not found: " + buffer.Y().h());
    }

    public String toString() {
        return f20.c(this).c("logId", this.f3870a.d()).d("address", this.f3885a).toString();
    }

    public hu b() {
        return this.f3870a;
    }

    /* access modifiers changed from: package-private */
    public String W() {
        URI uri = h0.a(this.f3884a);
        if (uri.getHost() != null) {
            return uri.getHost();
        }
        return this.f3884a;
    }

    /* access modifiers changed from: package-private */
    public int X() {
        URI uri = h0.a(this.f3884a);
        if (uri.getPort() != -1) {
            return uri.getPort();
        }
        return this.f3885a.getPort();
    }

    public void e(p reason) {
        synchronized (this.f3882a) {
            if (this.f3881a == null) {
                this.f3881a = reason;
                this.f3875a.d(reason);
                o0();
            }
        }
    }

    public void c(p reason) {
        e(reason);
        synchronized (this.f3882a) {
            Iterator<Map.Entry<Integer, f>> it = this.f3888a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> entry = it.next();
                it.remove();
                ((f) entry.getValue()).y().M(reason, false, new l());
                e0((f) entry.getValue());
            }
            for (f stream : this.f3887a) {
                stream.y().M(reason, true, new l());
                e0(stream);
            }
            this.f3887a.clear();
            o0();
        }
    }

    public v4 V() {
        return this.f3899a;
    }

    /* access modifiers changed from: package-private */
    public f[] U() {
        f[] fVarArr;
        synchronized (this.f3882a) {
            fVarArr = (f[]) this.f3888a.values().toArray(f3865a);
        }
        return fVarArr;
    }

    public void a(Throwable failureCause) {
        v90.o(failureCause, "failureCause");
        l0(0, io.grpc.okhttp.internal.framed.a.INTERNAL_ERROR, p.p.p(failureCause));
    }

    /* access modifiers changed from: private */
    public void g0(io.grpc.okhttp.internal.framed.a errorCode, String moreDetail) {
        l0(0, errorCode, q0(errorCode).e(moreDetail));
    }

    /* access modifiers changed from: private */
    public void l0(int lastKnownStreamId, io.grpc.okhttp.internal.framed.a errorCode, p status) {
        synchronized (this.f3882a) {
            if (this.f3881a == null) {
                this.f3881a = status;
                this.f3875a.d(status);
            }
            if (errorCode != null && !this.f3901a) {
                this.f3901a = true;
                this.f3876a.h(0, errorCode, new byte[0]);
            }
            Iterator<Map.Entry<Integer, f>> it = this.f3888a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> entry = it.next();
                if (entry.getKey().intValue() > lastKnownStreamId) {
                    it.remove();
                    ((f) entry.getValue()).y().L(status, o.a.REFUSED, false, new l());
                    e0((f) entry.getValue());
                }
            }
            for (f stream : this.f3887a) {
                stream.y().L(status, o.a.REFUSED, true, new l());
                e0(stream);
            }
            this.f3887a.clear();
            o0();
        }
    }

    /* access modifiers changed from: package-private */
    public void T(int streamId, p status, o.a rpcProgress, boolean stopDelivery, io.grpc.okhttp.internal.framed.a errorCode, l trailers) {
        synchronized (this.f3882a) {
            f stream = this.f3888a.remove(Integer.valueOf(streamId));
            if (stream != null) {
                if (errorCode != null) {
                    this.f3876a.d(streamId, io.grpc.okhttp.internal.framed.a.CANCEL);
                }
                if (status != null) {
                    stream.y().L(status, rpcProgress, stopDelivery, trailers != null ? trailers : new l());
                }
                if (!m0()) {
                    o0();
                    e0(stream);
                }
            }
        }
    }

    private void o0() {
        if (this.f3881a != null && this.f3888a.isEmpty() && this.f3887a.isEmpty() && !this.f3906b) {
            this.f3906b = true;
            o0 o0Var = this.f3874a;
            if (o0Var != null) {
                o0Var.q();
                this.f3891a = (ScheduledExecutorService) h1.f(h0.f3431b, this.f3891a);
            }
            l0 l0Var = this.f3872a;
            if (l0Var != null) {
                l0Var.f(Y());
                this.f3872a = null;
            }
            if (!this.f3901a) {
                this.f3901a = true;
                this.f3876a.h(0, io.grpc.okhttp.internal.framed.a.NO_ERROR, new byte[0]);
            }
            this.f3876a.close();
        }
    }

    private void e0(f stream) {
        if (this.f3907c && this.f3887a.isEmpty() && this.f3888a.isEmpty()) {
            this.f3907c = false;
            o0 o0Var = this.f3874a;
            if (o0Var != null) {
                o0Var.o();
            }
        }
        if (stream.x()) {
            this.f3869a.d(stream, false);
        }
    }

    private void k0(f stream) {
        if (!this.f3907c) {
            this.f3907c = true;
            o0 o0Var = this.f3874a;
            if (o0Var != null) {
                o0Var.n();
            }
        }
        if (stream.x()) {
            this.f3869a.d(stream, true);
        }
    }

    private Throwable Y() {
        synchronized (this.f3882a) {
            p pVar = this.f3881a;
            if (pVar != null) {
                q c2 = pVar.c();
                return c2;
            }
            q c3 = p.p.q("Connection closed").c();
            return c3;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d0(int streamId) {
        boolean z;
        synchronized (this.f3882a) {
            z = true;
            if (streamId >= this.f3902b || (streamId & 1) != 1) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public f Z(int streamId) {
        f fVar;
        synchronized (this.f3882a) {
            fVar = this.f3888a.get(Integer.valueOf(streamId));
        }
        return fVar;
    }

    static p q0(io.grpc.okhttp.internal.framed.a code) {
        p status = b.get(code);
        if (status != null) {
            return status;
        }
        p pVar = p.c;
        return pVar.q("Unknown http2 error code: " + code.httpCode);
    }

    class f implements pn.a, Runnable {

        /* renamed from: a  reason: collision with other field name */
        private final h f3914a;

        /* renamed from: a  reason: collision with other field name */
        pn f3915a;

        /* renamed from: a  reason: collision with other field name */
        boolean f3916a;

        f(g this$0, pn frameReader) {
            this(frameReader, new h(Level.FINE, (Class<?>) g.class));
        }

        f(pn frameReader, h frameLogger) {
            this.f3916a = true;
            this.f3915a = frameReader;
            this.f3914a = frameLogger;
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.f3915a.W(this)) {
                try {
                    if (g.this.f3874a != null) {
                        g.this.f3874a.m();
                    }
                } catch (Throwable th) {
                    try {
                        this.f3915a.close();
                    } catch (IOException ex) {
                        g.a.log(Level.INFO, "Exception closing frame reader", ex);
                    }
                    g.this.f3875a.a();
                    Thread.currentThread().setName(threadName);
                    throw th;
                }
            }
            g.this.l0(0, io.grpc.okhttp.internal.framed.a.INTERNAL_ERROR, p.p.q("End of stream or IOException"));
            try {
                this.f3915a.close();
            } catch (IOException e) {
                ex = e;
            }
            g.this.f3875a.a();
            Thread.currentThread().setName(threadName);
            g.a.log(Level.INFO, "Exception closing frame reader", ex);
            g.this.f3875a.a();
            Thread.currentThread().setName(threadName);
        }

        public void l(boolean inFinished, int streamId, t6 in, int length) {
            this.f3914a.b(h.a.INBOUND, streamId, in.O(), length, inFinished);
            f stream = g.this.Z(streamId);
            if (stream != null) {
                in.y((long) length);
                r6 buf = new r6();
                buf.G(in.O(), (long) length);
                a90.c("OkHttpClientTransport$ClientFrameHandler.data", stream.y().e0());
                synchronized (g.this.f3882a) {
                    stream.y().f0(buf, inFinished);
                }
            } else if (g.this.d0(streamId)) {
                synchronized (g.this.f3882a) {
                    g.this.f3876a.d(streamId, io.grpc.okhttp.internal.framed.a.INVALID_STREAM);
                }
                in.Q((long) length);
            } else {
                g gVar = g.this;
                io.grpc.okhttp.internal.framed.a aVar = io.grpc.okhttp.internal.framed.a.PROTOCOL_ERROR;
                gVar.g0(aVar, "Received data for unknown stream: " + streamId);
                return;
            }
            g.A(g.this, length);
            if (((float) g.this.d) >= ((float) g.this.f3866a) * 0.5f) {
                synchronized (g.this.f3882a) {
                    g.this.f3876a.a(0, (long) g.this.d);
                }
                int unused = g.this.d = 0;
            }
        }

        public void g(boolean outFinished, boolean inFinished, int streamId, int associatedStreamId, List<pq> headerBlock, io.grpc.okhttp.internal.framed.b headersMode) {
            int metadataSize;
            this.f3914a.d(h.a.INBOUND, streamId, headerBlock, inFinished);
            boolean unknownStream = false;
            p failedStatus = null;
            if (g.this.f != Integer.MAX_VALUE && (metadataSize = b(headerBlock)) > g.this.f) {
                p pVar = p.j;
                Object[] objArr = new Object[3];
                objArr[0] = inFinished ? "trailer" : "header";
                objArr[1] = Integer.valueOf(g.this.f);
                objArr[2] = Integer.valueOf(metadataSize);
                failedStatus = pVar.q(String.format("Response %s metadata larger than %d: %d", objArr));
            }
            synchronized (g.this.f3882a) {
                f stream = (f) g.this.f3888a.get(Integer.valueOf(streamId));
                if (stream == null) {
                    if (g.this.d0(streamId)) {
                        g.this.f3876a.d(streamId, io.grpc.okhttp.internal.framed.a.INVALID_STREAM);
                    } else {
                        unknownStream = true;
                    }
                } else if (failedStatus == null) {
                    a90.c("OkHttpClientTransport$ClientFrameHandler.headers", stream.y().e0());
                    stream.y().g0(headerBlock, inFinished);
                } else {
                    if (!inFinished) {
                        g.this.f3876a.d(streamId, io.grpc.okhttp.internal.framed.a.CANCEL);
                    }
                    stream.y().M(failedStatus, false, new l());
                }
            }
            if (unknownStream) {
                g gVar = g.this;
                io.grpc.okhttp.internal.framed.a aVar = io.grpc.okhttp.internal.framed.a.PROTOCOL_ERROR;
                gVar.g0(aVar, "Received header for unknown stream: " + streamId);
            }
        }

        private int b(List<pq> headerBlock) {
            long size = 0;
            for (int i = 0; i < headerBlock.size(); i++) {
                pq header = headerBlock.get(i);
                size += (long) (header.f4727a.l() + 32 + header.b.l());
            }
            return (int) Math.min(size, 2147483647L);
        }

        public void d(int streamId, io.grpc.okhttp.internal.framed.a errorCode) {
            this.f3914a.h(h.a.INBOUND, streamId, errorCode);
            p status = g.q0(errorCode).e("Rst Stream");
            boolean stopDelivery = status.m() == p.b.CANCELLED || status.m() == p.b.DEADLINE_EXCEEDED;
            synchronized (g.this.f3882a) {
                f stream = (f) g.this.f3888a.get(Integer.valueOf(streamId));
                if (stream != null) {
                    a90.c("OkHttpClientTransport$ClientFrameHandler.rstStream", stream.y().e0());
                    g.this.T(streamId, status, errorCode == io.grpc.okhttp.internal.framed.a.REFUSED_STREAM ? o.a.REFUSED : o.a.PROCESSED, stopDelivery, (io.grpc.okhttp.internal.framed.a) null, (l) null);
                }
            }
        }

        public void i(boolean clearPrevious, el0 settings) {
            this.f3914a.i(h.a.INBOUND, settings);
            boolean outboundWindowSizeIncreased = false;
            synchronized (g.this.f3882a) {
                if (k.b(settings, 4)) {
                    int unused = g.this.e = k.a(settings, 4);
                }
                if (k.b(settings, 7)) {
                    outboundWindowSizeIncreased = g.this.f3880a.e(k.a(settings, 7));
                }
                if (this.f3916a != 0) {
                    g.this.f3875a.c();
                    this.f3916a = false;
                }
                g.this.f3876a.g(settings);
                if (outboundWindowSizeIncreased) {
                    g.this.f3880a.h();
                }
                boolean unused2 = g.this.m0();
            }
        }

        public void e(boolean ack, int payload1, int payload2) {
            long ackPayload = (((long) payload1) << 32) | (((long) payload2) & 4294967295L);
            this.f3914a.e(h.a.INBOUND, ackPayload);
            if (!ack) {
                synchronized (g.this.f3882a) {
                    g.this.f3876a.e(true, payload1, payload2);
                }
                return;
            }
            l0 p = null;
            synchronized (g.this.f3882a) {
                if (g.this.f3872a == null) {
                    g.a.warning("Received unexpected ping ack. No ping outstanding");
                } else if (g.this.f3872a.h() == ackPayload) {
                    p = g.this.f3872a;
                    l0 unused = g.this.f3872a = null;
                } else {
                    g.a.log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", new Object[]{Long.valueOf(g.this.f3872a.h()), Long.valueOf(ackPayload)}));
                }
            }
            if (p != null) {
                p.d();
            }
        }

        public void k() {
        }

        public void h(int lastGoodStreamId, io.grpc.okhttp.internal.framed.a errorCode, a7 debugData) {
            this.f3914a.c(h.a.INBOUND, lastGoodStreamId, errorCode, debugData);
            if (errorCode == io.grpc.okhttp.internal.framed.a.ENHANCE_YOUR_CALM) {
                String data = debugData.s();
                g.a.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", new Object[]{this, data}));
                if ("too_many_pings".equals(data)) {
                    g.this.f3883a.run();
                }
            }
            p status = h0.g.statusForCode((long) errorCode.httpCode).e("Received Goaway");
            if (debugData.l() > 0) {
                status = status.e(debugData.s());
            }
            g.this.l0(lastGoodStreamId, (io.grpc.okhttp.internal.framed.a) null, status);
        }

        public void f(int streamId, int promisedStreamId, List<pq> requestHeaders) {
            this.f3914a.g(h.a.INBOUND, streamId, promisedStreamId, requestHeaders);
            synchronized (g.this.f3882a) {
                g.this.f3876a.d(streamId, io.grpc.okhttp.internal.framed.a.PROTOCOL_ERROR);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
            r1 = r10.a;
            r2 = io.grpc.okhttp.internal.framed.a.PROTOCOL_ERROR;
            io.grpc.okhttp.g.x(r1, r2, "Received window_update for unknown stream: " + r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r11, long r12) {
            /*
                r10 = this;
                io.grpc.okhttp.h r0 = r10.f3914a
                io.grpc.okhttp.h$a r1 = io.grpc.okhttp.h.a.INBOUND
                r0.k(r1, r11, r12)
                r0 = 0
                int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x002c
                java.lang.String r0 = "Received 0 flow control window increment."
                if (r11 != 0) goto L_0x0019
                io.grpc.okhttp.g r1 = io.grpc.okhttp.g.this
                io.grpc.okhttp.internal.framed.a r2 = io.grpc.okhttp.internal.framed.a.PROTOCOL_ERROR
                r1.g0(r2, r0)
                goto L_0x002b
            L_0x0019:
                io.grpc.okhttp.g r3 = io.grpc.okhttp.g.this
                io.grpc.p r1 = io.grpc.p.o
                io.grpc.p r5 = r1.q(r0)
                io.grpc.internal.o$a r6 = io.grpc.internal.o.a.PROCESSED
                r7 = 0
                io.grpc.okhttp.internal.framed.a r8 = io.grpc.okhttp.internal.framed.a.PROTOCOL_ERROR
                r9 = 0
                r4 = r11
                r3.T(r4, r5, r6, r7, r8, r9)
            L_0x002b:
                return
            L_0x002c:
                r0 = 0
                io.grpc.okhttp.g r1 = io.grpc.okhttp.g.this
                java.lang.Object r1 = r1.f3882a
                monitor-enter(r1)
                if (r11 != 0) goto L_0x0043
                io.grpc.okhttp.g r2 = io.grpc.okhttp.g.this     // Catch:{ all -> 0x0085 }
                io.grpc.okhttp.o r2 = r2.f3880a     // Catch:{ all -> 0x0085 }
                r3 = 0
                int r4 = (int) r12     // Catch:{ all -> 0x0085 }
                r2.g(r3, r4)     // Catch:{ all -> 0x0085 }
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                return
            L_0x0043:
                io.grpc.okhttp.g r2 = io.grpc.okhttp.g.this     // Catch:{ all -> 0x0085 }
                java.util.Map r2 = r2.f3888a     // Catch:{ all -> 0x0085 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0085 }
                java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0085 }
                io.grpc.okhttp.f r2 = (io.grpc.okhttp.f) r2     // Catch:{ all -> 0x0085 }
                if (r2 == 0) goto L_0x0060
                io.grpc.okhttp.g r3 = io.grpc.okhttp.g.this     // Catch:{ all -> 0x0085 }
                io.grpc.okhttp.o r3 = r3.f3880a     // Catch:{ all -> 0x0085 }
                int r4 = (int) r12     // Catch:{ all -> 0x0085 }
                r3.g(r2, r4)     // Catch:{ all -> 0x0085 }
                goto L_0x0069
            L_0x0060:
                io.grpc.okhttp.g r3 = io.grpc.okhttp.g.this     // Catch:{ all -> 0x0085 }
                boolean r3 = r3.d0(r11)     // Catch:{ all -> 0x0085 }
                if (r3 != 0) goto L_0x0069
                r0 = 1
            L_0x0069:
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                if (r0 == 0) goto L_0x0084
                io.grpc.okhttp.g r1 = io.grpc.okhttp.g.this
                io.grpc.okhttp.internal.framed.a r2 = io.grpc.okhttp.internal.framed.a.PROTOCOL_ERROR
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Received window_update for unknown stream: "
                r3.append(r4)
                r3.append(r11)
                java.lang.String r3 = r3.toString()
                r1.g0(r2, r3)
            L_0x0084:
                return
            L_0x0085:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.g.f.a(int, long):void");
        }

        public void j(int streamId, int streamDependency, int weight, boolean exclusive) {
        }
    }
}
