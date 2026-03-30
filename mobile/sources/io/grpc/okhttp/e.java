package io.grpc.okhttp;

import androidx.core.internal.view.SupportMenu;
import androidx.core.location.LocationRequestCompat;
import defpackage.r4;
import io.grpc.internal.h0;
import io.grpc.internal.h1;
import io.grpc.internal.m1;
import io.grpc.internal.o0;
import io.grpc.internal.q;
import io.grpc.okhttp.internal.b;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class e extends io.grpc.internal.b<e> {
    /* access modifiers changed from: private */
    public static final h1.d<Executor> a = new a();
    static final io.grpc.okhttp.internal.b b = new b.C0048b(io.grpc.okhttp.internal.b.a).f(io.grpc.okhttp.internal.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, io.grpc.okhttp.internal.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, io.grpc.okhttp.internal.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, io.grpc.okhttp.internal.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, io.grpc.okhttp.internal.a.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, io.grpc.okhttp.internal.a.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, io.grpc.okhttp.internal.a.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, io.grpc.okhttp.internal.a.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384).i(io.grpc.okhttp.internal.e.TLS_1_2).h(true).e();
    public static final /* synthetic */ int g = 0;
    private static final long h = TimeUnit.DAYS.toNanos(1000);

    /* renamed from: a  reason: collision with other field name */
    private c f3828a = c.TLS;

    /* renamed from: a  reason: collision with other field name */
    private io.grpc.okhttp.internal.b f3829a = b;

    /* renamed from: a  reason: collision with other field name */
    private Executor f3830a;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledExecutorService f3831a;

    /* renamed from: a  reason: collision with other field name */
    private SocketFactory f3832a;

    /* renamed from: a  reason: collision with other field name */
    private HostnameVerifier f3833a;

    /* renamed from: a  reason: collision with other field name */
    private SSLSocketFactory f3834a;
    private int e = SupportMenu.USER_MASK;
    private int f = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with other field name */
    private long f3835f = LocationRequestCompat.PASSIVE_INTERVAL;

    /* renamed from: g  reason: collision with other field name */
    private long f3836g = h0.a;
    private boolean j;
    private final boolean k = false;

    private enum c {
        TLS,
        PLAINTEXT
    }

    class a implements h1.d<Executor> {
        a() {
        }

        /* renamed from: d */
        public Executor b() {
            return Executors.newCachedThreadPool(h0.g("grpc-okhttp-%d", true));
        }

        /* renamed from: c */
        public void a(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }
    }

    public static e forTarget(String target) {
        return new e(target);
    }

    private e(String target) {
        super(target);
    }

    public final e transportExecutor(Executor transportExecutor) {
        this.f3830a = transportExecutor;
        return this;
    }

    /* renamed from: l */
    public e c(long keepAliveTime, TimeUnit timeUnit) {
        v90.e(keepAliveTime > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(keepAliveTime);
        this.f3835f = nanos;
        long l = o0.l(nanos);
        this.f3835f = l;
        if (l >= h) {
            this.f3835f = LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return this;
    }

    public final e sslSocketFactory(SSLSocketFactory factory) {
        this.f3834a = factory;
        this.f3828a = c.TLS;
        return this;
    }

    /* renamed from: m */
    public final e d() {
        this.f3828a = c.PLAINTEXT;
        return this;
    }

    public final e scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.f3831a = (ScheduledExecutorService) v90.o(scheduledExecutorService, "scheduledExecutorService");
        return this;
    }

    /* access modifiers changed from: protected */
    public final q e() {
        d dVar = r2;
        d dVar2 = new d(this.f3830a, this.f3831a, this.f3832a, k(), this.f3833a, this.f3829a, i(), this.f3835f != LocationRequestCompat.PASSIVE_INTERVAL, this.f3835f, this.f3836g, this.e, this.j, this.f, this.f3304a, false, (a) null);
        return dVar;
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[c.values().length];
            b = iArr;
            try {
                iArr[c.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[c.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[d.values().length];
            a = iArr2;
            try {
                iArr2[d.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[d.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public int f() {
        switch (b.b[this.f3828a.ordinal()]) {
            case 1:
                return 80;
            case 2:
                return 443;
            default:
                throw new AssertionError(this.f3828a + " not handled");
        }
    }

    /* access modifiers changed from: package-private */
    public SSLSocketFactory k() {
        switch (b.b[this.f3828a.ordinal()]) {
            case 1:
                return null;
            case 2:
                try {
                    if (this.f3834a == null) {
                        this.f3834a = SSLContext.getInstance("Default", io.grpc.okhttp.internal.c.e().g()).getSocketFactory();
                    }
                    return this.f3834a;
                } catch (GeneralSecurityException gse) {
                    throw new RuntimeException("TLS Provider failure", gse);
                }
            default:
                throw new RuntimeException("Unknown negotiation type: " + this.f3828a);
        }
    }

    static final class d implements q {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private final long f3837a;

        /* renamed from: a  reason: collision with other field name */
        private final m1.b f3838a;

        /* renamed from: a  reason: collision with other field name */
        private final io.grpc.okhttp.internal.b f3839a;

        /* renamed from: a  reason: collision with other field name */
        private final Executor f3840a;

        /* renamed from: a  reason: collision with other field name */
        private final ScheduledExecutorService f3841a;

        /* renamed from: a  reason: collision with other field name */
        private final SocketFactory f3842a;

        /* renamed from: a  reason: collision with other field name */
        private final HostnameVerifier f3843a;

        /* renamed from: a  reason: collision with other field name */
        private final SSLSocketFactory f3844a;

        /* renamed from: a  reason: collision with other field name */
        private final r4 f3845a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f3846a;
        private final int b;

        /* renamed from: b  reason: collision with other field name */
        private final boolean f3847b;
        private final int c;

        /* renamed from: c  reason: collision with other field name */
        private final boolean f3848c;
        private final boolean d;
        private final boolean e;
        private boolean f;

        /* synthetic */ d(Executor x0, ScheduledExecutorService x1, SocketFactory x2, SSLSocketFactory x3, HostnameVerifier x4, io.grpc.okhttp.internal.b x5, int x6, boolean x7, long x8, long x9, int x10, boolean x11, int x12, m1.b x13, boolean x14, a x15) {
            this(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14);
        }

        private d(Executor executor, ScheduledExecutorService timeoutService, SocketFactory socketFactory, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier, io.grpc.okhttp.internal.b connectionSpec, int maxMessageSize, boolean enableKeepAlive, long keepAliveTimeNanos, long keepAliveTimeoutNanos, int flowControlWindow, boolean keepAliveWithoutCalls, int maxInboundMetadataSize, m1.b transportTracerFactory, boolean useGetForSafeMethods) {
            Executor executor2 = executor;
            boolean z = timeoutService == null;
            this.f3847b = z;
            this.f3841a = z ? (ScheduledExecutorService) h1.d(h0.f3431b) : timeoutService;
            this.f3842a = socketFactory;
            this.f3844a = sslSocketFactory;
            this.f3843a = hostnameVerifier;
            this.f3839a = connectionSpec;
            this.a = maxMessageSize;
            this.f3848c = enableKeepAlive;
            this.f3845a = new r4("keepalive time nanos", keepAliveTimeNanos);
            this.f3837a = keepAliveTimeoutNanos;
            this.b = flowControlWindow;
            this.d = keepAliveWithoutCalls;
            this.c = maxInboundMetadataSize;
            this.e = useGetForSafeMethods;
            boolean z2 = executor2 == null;
            this.f3846a = z2;
            this.f3838a = (m1.b) v90.o(transportTracerFactory, "transportTracerFactory");
            if (z2) {
                this.f3840a = (Executor) h1.d(e.a);
            } else {
                this.f3840a = executor2;
            }
        }

        public bc M(SocketAddress addr, q.a options, io.grpc.a channelLogger) {
            if (!this.f) {
                r4.b keepAliveTimeNanosState = this.f3845a.d();
                r4.b keepAliveTimeNanosState2 = keepAliveTimeNanosState;
                g transport = new g((InetSocketAddress) addr, options.a(), options.d(), options.b(), this.f3840a, this.f3842a, this.f3844a, this.f3843a, this.f3839a, this.a, this.b, options.c(), new a(keepAliveTimeNanosState), this.c, this.f3838a.a(), this.e);
                if (this.f3848c) {
                    transport.S(true, keepAliveTimeNanosState2.b(), this.f3837a, this.d);
                }
                return transport;
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        class a implements Runnable {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ r4.b f3849a;

            a(r4.b bVar) {
                this.f3849a = bVar;
            }

            public void run() {
                this.f3849a.a();
            }
        }

        public ScheduledExecutorService u() {
            return this.f3841a;
        }

        public void close() {
            if (!this.f) {
                this.f = true;
                if (this.f3847b) {
                    h1.f(h0.f3431b, this.f3841a);
                }
                if (this.f3846a) {
                    h1.f(e.a, this.f3840a);
                }
            }
        }
    }
}
