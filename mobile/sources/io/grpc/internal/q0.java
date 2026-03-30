package io.grpc.internal;

import defpackage.a9;
import defpackage.b30;
import defpackage.ux;
import defpackage.v4;
import defpackage.vo0;
import io.grpc.a;
import io.grpc.i;
import io.grpc.internal.ManagedChannelImpl;
import io.grpc.internal.c1;
import io.grpc.internal.h;
import io.grpc.internal.i;
import io.grpc.internal.k;
import io.grpc.internal.m0;
import io.grpc.internal.n;
import io.grpc.internal.t0;
import java.lang.Thread;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

final class q0 extends rz implements gu<Object> {
    /* access modifiers changed from: private */
    public static final du a = new a();

    /* renamed from: a  reason: collision with other field name */
    static final io.grpc.p f3567a;

    /* renamed from: a  reason: collision with other field name */
    static final Logger f3568a = Logger.getLogger(q0.class.getName());

    /* renamed from: a  reason: collision with other field name */
    static final Pattern f3569a = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");
    static final io.grpc.p b;
    /* access modifiers changed from: private */
    public static final s0 c = s0.a();

    /* renamed from: c  reason: collision with other field name */
    static final io.grpc.p f3570c;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final int f3571a;

    /* renamed from: a  reason: collision with other field name */
    private final long f3572a;

    /* renamed from: a  reason: collision with other field name */
    private final b30.a f3573a;

    /* renamed from: a  reason: collision with other field name */
    private final b30.c f3574a;

    /* renamed from: a  reason: collision with other field name */
    private b30 f3575a;

    /* renamed from: a  reason: collision with other field name */
    private final b40<? extends Executor> f3576a;

    /* renamed from: a  reason: collision with other field name */
    private final d30 f3577a;

    /* renamed from: a  reason: collision with other field name */
    private final e8 f3578a;

    /* renamed from: a  reason: collision with other field name */
    final es<Object> f3579a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final gf f3580a;

    /* renamed from: a  reason: collision with other field name */
    private final hu f3581a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final io.grpc.a f3582a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final io.grpc.h f3583a;

    /* renamed from: a  reason: collision with other field name */
    private final b1 f3584a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final c1.r f3585a = new c1.r();

    /* renamed from: a  reason: collision with other field name */
    private final f1 f3586a;

    /* renamed from: a  reason: collision with other field name */
    private final h f3587a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final i.a f3588a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public i f3589a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final k.b f3590a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final k f3591a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final m f3592a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final n.f f3593a;

    /* renamed from: a  reason: collision with other field name */
    private final p f3594a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public s f3595a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public v f3596a = v.NO_RESOLUTION;

    /* renamed from: a  reason: collision with other field name */
    private final w f3597a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final z f3598a = new z(this, (a) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final q f3599a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final r f3600a = new r();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public s0 f3601a = c;

    /* renamed from: a  reason: collision with other field name */
    private final t0.a f3602a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final u f3603a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f3604a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final String f3605a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Collection<u.a<?, ?>> f3606a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Set<m0> f3607a = new HashSet(16, 0.75f);

    /* renamed from: a  reason: collision with other field name */
    private final CountDownLatch f3608a = new CountDownLatch(1);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Executor f3609a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final AtomicBoolean f3610a = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final AtomicReference<du> f3611a = new AtomicReference<>(a);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final nr0 f3612a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final oo0<hn0> f3613a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ub f3614a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile ux.i f3615a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public vo0.c f3616a;

    /* renamed from: a  reason: collision with other field name */
    final vo0 f3617a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f3618a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final long f3619b;

    /* renamed from: b  reason: collision with other field name */
    private final b40<? extends Executor> f3620b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final p f3621b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final s0 f3622b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final String f3623b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final Set<x0> f3624b = new HashSet(1, 0.75f);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public boolean f3625b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public final long f3626c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f3627c;
    /* access modifiers changed from: private */
    public boolean d;
    /* access modifiers changed from: private */
    public volatile boolean e;
    /* access modifiers changed from: private */
    public volatile boolean f;
    /* access modifiers changed from: private */
    public boolean g = false;
    /* access modifiers changed from: private */
    public final boolean h;
    /* access modifiers changed from: private */
    public final boolean i;

    enum v {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    static {
        io.grpc.p pVar = io.grpc.p.p;
        f3567a = pVar.q("Channel shutdownNow invoked");
        b = pVar.q("Channel shutdown invoked");
        f3570c = pVar.q("Subchannel shutdown invoked");
    }

    class a extends du {
        a() {
        }
    }

    class k implements Thread.UncaughtExceptionHandler {
        k() {
        }

        public void uncaughtException(Thread t, Throwable e) {
            Logger logger = q0.f3568a;
            Level level = Level.SEVERE;
            logger.log(level, "[" + q0.this.b() + "] Uncaught exception in the SynchronizationContext. Panic!", e);
            q0.this.J0(e);
        }
    }

    /* access modifiers changed from: private */
    public void H0() {
        if (this.d) {
            for (m0 subchannel : this.f3607a) {
                subchannel.c(f3567a);
            }
            for (x0 oobChannel : this.f3624b) {
                oobChannel.n().c(f3567a);
            }
        }
    }

    public hu b() {
        return this.f3581a;
    }

    private class r implements Runnable {
        private r() {
        }

        /* synthetic */ r(q0 x0, a x1) {
            this();
        }

        public void run() {
            q0.this.A0();
        }
    }

    /* access modifiers changed from: private */
    public void O0(boolean channelIsActive) {
        this.f3617a.d();
        if (channelIsActive) {
            v90.u(this.f3625b, "nameResolver is not started");
            v90.u(this.f3595a != null, "lbHelper is null");
        }
        if (this.f3575a != null) {
            z0();
            this.f3575a.c();
            this.f3625b = false;
            if (channelIsActive) {
                this.f3575a = D0(this.f3605a, this.f3574a, this.f3573a);
            } else {
                this.f3575a = null;
            }
        }
        s sVar = this.f3595a;
        if (sVar != null) {
            sVar.a.d();
            this.f3595a = null;
        }
        this.f3615a = null;
    }

    /* access modifiers changed from: package-private */
    public void B0() {
        this.f3617a.d();
        if (!this.f3610a.get() && !this.f3627c) {
            if (this.f3579a.c()) {
                y0(false);
            } else {
                M0();
            }
            if (this.f3595a == null) {
                this.f3582a.a(a.C0040a.INFO, "Exiting idle mode");
                s lbHelper = new s(this, (a) null);
                lbHelper.a = this.f3587a.e(lbHelper);
                this.f3595a = lbHelper;
                this.f3575a.d(new t(lbHelper, this.f3575a));
                this.f3625b = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void A0() {
        O0(true);
        this.f3603a.r((ux.i) null);
        this.f3582a.a(a.C0040a.INFO, "Entering IDLE state");
        this.f3600a.b(io.grpc.e.IDLE);
        if (this.f3579a.c()) {
            B0();
        }
    }

    /* access modifiers changed from: private */
    public void y0(boolean permanent) {
        this.f3584a.i(permanent);
    }

    /* access modifiers changed from: private */
    public void M0() {
        long j2 = this.f3572a;
        if (j2 != -1) {
            this.f3584a.k(j2, TimeUnit.MILLISECONDS);
        }
    }

    class n implements Runnable {
        n() {
        }

        public void run() {
            vo0.c unused = q0.this.f3616a = null;
            q0.this.L0();
        }
    }

    private void z0() {
        this.f3617a.d();
        vo0.c cVar = this.f3616a;
        if (cVar != null) {
            cVar.a();
            this.f3616a = null;
            this.f3589a = null;
        }
    }

    /* access modifiers changed from: private */
    public void K0() {
        this.f3617a.d();
        z0();
        L0();
    }

    /* access modifiers changed from: private */
    public void L0() {
        this.f3617a.d();
        if (this.f3625b) {
            this.f3575a.b();
        }
    }

    private final class m implements n.f {
        private m() {
        }

        /* synthetic */ m(q0 x0, a x1) {
            this();
        }

        /* access modifiers changed from: private */
        public p c(ux.f args) {
            ux.i pickerCopy = q0.this.f3615a;
            if (q0.this.f3610a.get()) {
                return q0.this.f3603a;
            }
            if (pickerCopy == null) {
                q0.this.f3617a.execute(new a());
                return q0.this.f3603a;
            }
            p transport = h0.h(pickerCopy.a(args), args.a().j());
            if (transport != null) {
                return transport;
            }
            return q0.this.f3603a;
        }

        final class a implements Runnable {
            a() {
            }

            public void run() {
                q0.this.B0();
            }
        }

        public z8 a(io.grpc.m<?, ?> method, n7 callOptions, io.grpc.l headers, qc context) {
            if (q0.this.i) {
                return new b(this, method, headers, callOptions, q0.this.f3601a.f(), context);
            }
            p transport = c(new h90(method, headers, callOptions));
            qc origContext = context.b();
            try {
                return transport.f(method, headers, callOptions);
            } finally {
                context.f(origContext);
            }
        }

        final class b<ReqT> extends c1<ReqT> {
            final /* synthetic */ m a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ n7 f3633a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ qc f3634a;
            final /* synthetic */ c1.z b;

            /* renamed from: b  reason: collision with other field name */
            final /* synthetic */ io.grpc.l f3635b;

            /* renamed from: b  reason: collision with other field name */
            final /* synthetic */ io.grpc.m f3636b;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            b(io.grpc.internal.q0.m r16, io.grpc.m r17, io.grpc.l r18, defpackage.n7 r19, io.grpc.internal.c1.z r20, defpackage.qc r21) {
                /*
                    r15 = this;
                    r13 = r15
                    r14 = r16
                    r0 = r19
                    r13.a = r14
                    r1 = r17
                    r13.f3636b = r1
                    r2 = r18
                    r13.f3635b = r2
                    r13.f3633a = r0
                    r12 = r20
                    r13.b = r12
                    r3 = r21
                    r13.f3634a = r3
                    io.grpc.internal.q0 r3 = io.grpc.internal.q0.this
                    io.grpc.internal.c1$r r3 = r3.f3585a
                    io.grpc.internal.q0 r4 = io.grpc.internal.q0.this
                    long r4 = r4.f3619b
                    io.grpc.internal.q0 r6 = io.grpc.internal.q0.this
                    long r6 = r6.f3626c
                    io.grpc.internal.q0 r8 = io.grpc.internal.q0.this
                    java.util.concurrent.Executor r8 = r8.C0(r0)
                    io.grpc.internal.q0 r9 = io.grpc.internal.q0.this
                    io.grpc.internal.q r9 = r9.f3599a
                    java.util.concurrent.ScheduledExecutorService r9 = r9.u()
                    n7$a<io.grpc.internal.d1$a> r10 = io.grpc.internal.f1.a
                    java.lang.Object r10 = r0.h(r10)
                    io.grpc.internal.d1$a r10 = (io.grpc.internal.d1.a) r10
                    n7$a<io.grpc.internal.j0$a> r11 = io.grpc.internal.f1.b
                    java.lang.Object r0 = r0.h(r11)
                    r11 = r0
                    io.grpc.internal.j0$a r11 = (io.grpc.internal.j0.a) r11
                    r0 = r15
                    r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.q0.m.b.<init>(io.grpc.internal.q0$m, io.grpc.m, io.grpc.l, n7, io.grpc.internal.c1$z, qc):void");
            }

            /* access modifiers changed from: package-private */
            public io.grpc.p f0() {
                return q0.this.f3598a.a(this);
            }

            /* access modifiers changed from: package-private */
            public void e0() {
                q0.this.f3598a.d(this);
            }

            /* access modifiers changed from: package-private */
            public z8 d0(a9.a tracerFactory, io.grpc.l newHeaders) {
                n7 newOptions = this.f3633a.q(tracerFactory);
                p transport = this.a.c(new h90(this.f3636b, newHeaders, newOptions));
                qc origContext = this.f3634a.b();
                try {
                    return transport.f(this.f3636b, newHeaders, newOptions);
                } finally {
                    this.f3634a.f(origContext);
                }
            }
        }
    }

    q0(b<?> builder, q clientTransportFactory, i.a backoffPolicyProvider, b40<? extends Executor> balancerRpcExecutorPool, oo0<hn0> stopwatchSupplier, List<w8> interceptors, nr0 timeProvider) {
        a aVar;
        b<?> bVar = builder;
        b40<? extends Executor> b40 = balancerRpcExecutorPool;
        nr0 nr0 = timeProvider;
        vo0 vo0 = new vo0(new k());
        this.f3617a = vo0;
        o oVar = new o(this, (a) null);
        this.f3602a = oVar;
        this.f3579a = new q(this, (a) null);
        this.f3593a = new m(this, (a) null);
        String str = (String) v90.o(bVar.f3305a, "target");
        this.f3605a = str;
        hu b2 = hu.b("Channel", str);
        this.f3581a = b2;
        this.f3612a = (nr0) v90.o(nr0, "timeProvider");
        b40<? extends Executor> b402 = (b40) v90.o(bVar.f3300a, "executorPool");
        this.f3576a = b402;
        Executor executor = (Executor) v90.o(b402.b(), "executor");
        this.f3609a = executor;
        j jVar = new j(clientTransportFactory, executor);
        this.f3599a = jVar;
        w wVar = new w(jVar.u(), (a) null);
        this.f3597a = wVar;
        this.f3571a = bVar.f3317c;
        int i2 = bVar.f3317c;
        m mVar = r11;
        w wVar2 = wVar;
        int i3 = i2;
        j jVar2 = jVar;
        m mVar2 = new m(b2, i3, timeProvider.a(), "Channel for '" + str + "'");
        this.f3592a = mVar;
        l lVar = new l(mVar, nr0);
        this.f3582a = lVar;
        b30.c h2 = builder.h();
        this.f3574a = h2;
        pb0 proxyDetector = bVar.f3309a;
        proxyDetector = proxyDetector == null ? h0.f3429a : proxyDetector;
        boolean z2 = bVar.f3316b && !bVar.f3320c;
        this.i = z2;
        h hVar = new h(bVar.f3322d);
        this.f3587a = hVar;
        j jVar3 = jVar2;
        this.f3621b = new p((b40) v90.o(bVar.f3314b, "offloadExecutorPool"));
        this.f3577a = bVar.f3301a;
        x xVar = new x(z2, bVar.f3297a, bVar.f3312b, hVar, lVar);
        b30.a a2 = b30.a.f().c(builder.f()).e(proxyDetector).h(vo0).f(wVar2).g(xVar).b(lVar).d(new l()).a();
        this.f3573a = a2;
        this.f3575a = D0(str, h2, a2);
        this.f3620b = (b40) v90.o(b40, "balancerRpcExecutorPool");
        this.f3594a = new p(b40);
        u uVar = new u(executor, vo0);
        this.f3603a = uVar;
        uVar.d(oVar);
        this.f3588a = backoffPolicyProvider;
        f1 f1Var = new f1(z2);
        this.f3586a = f1Var;
        Map<String, ?> map = bVar.f3308a;
        if (map != null) {
            b30.b parsedDefaultServiceConfig = xVar.a(map);
            v90.w(parsedDefaultServiceConfig.d() == null, "Default config is invalid: %s", parsedDefaultServiceConfig.d());
            s0 s0Var = (s0) parsedDefaultServiceConfig.c();
            this.f3622b = s0Var;
            this.f3601a = s0Var;
            aVar = null;
        } else {
            aVar = null;
            this.f3622b = null;
        }
        boolean z3 = bVar.f3323d;
        this.h = z3;
        boolean z4 = false;
        this.f3578a = io.grpc.d.a(io.grpc.d.b(new u(this, this.f3575a.a(), aVar), f1Var), interceptors);
        this.f3613a = (oo0) v90.o(stopwatchSupplier, "stopwatchSupplier");
        long j2 = bVar.f3298a;
        if (j2 == -1) {
            this.f3572a = j2;
        } else {
            v90.i(j2 >= b.e ? true : z4, "invalid idleTimeoutMillis %s", j2);
            this.f3572a = bVar.f3298a;
        }
        this.f3584a = new b1(new r(this, (a) null), vo0, jVar3.u(), stopwatchSupplier.get());
        this.f3618a = bVar.f3311a;
        this.f3580a = (gf) v90.o(bVar.f3302a, "decompressorRegistry");
        this.f3614a = (ub) v90.o(bVar.f3310a, "compressorRegistry");
        this.f3623b = bVar.f3315b;
        this.f3626c = bVar.f3313b;
        this.f3619b = bVar.f3318c;
        c cVar = new c(timeProvider);
        this.f3590a = cVar;
        this.f3591a = cVar.a();
        io.grpc.h hVar2 = (io.grpc.h) v90.n(bVar.f3303a);
        this.f3583a = hVar2;
        hVar2.d(this);
        if (!z3) {
            if (this.f3622b != null) {
                lVar.a(a.C0040a.INFO, "Service config look-up disabled, using default service config");
            }
            F0();
        }
    }

    class l implements Executor {
        l() {
        }

        public void execute(Runnable command) {
            q0.this.f3621b.a().execute(command);
        }
    }

    final class c implements k.b {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ nr0 f3628a;

        c(nr0 nr0) {
            this.f3628a = nr0;
        }

        public k a() {
            return new k(this.f3628a);
        }
    }

    /* access modifiers changed from: private */
    public void F0() {
        this.g = true;
        this.f3586a.f(this.f3601a);
    }

    static b30 D0(String target, b30.c nameResolverFactory, b30.a nameResolverArgs) {
        b30 resolver;
        URI targetUri = null;
        StringBuilder uriSyntaxErrors = new StringBuilder();
        try {
            targetUri = new URI(target);
        } catch (URISyntaxException e2) {
            uriSyntaxErrors.append(e2.getMessage());
        }
        if (targetUri != null && (resolver = nameResolverFactory.b(targetUri, nameResolverArgs)) != null) {
            return resolver;
        }
        String str = "";
        if (!f3569a.matcher(target).matches()) {
            try {
                b30 resolver2 = nameResolverFactory.b(new URI(nameResolverFactory.a(), str, "/" + target, (String) null), nameResolverArgs);
                if (resolver2 != null) {
                    return resolver2;
                }
            } catch (URISyntaxException e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = target;
        if (uriSyntaxErrors.length() > 0) {
            str = " (" + uriSyntaxErrors + ")";
        }
        objArr[1] = str;
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", objArr));
    }

    public q0 N0() {
        this.f3582a.a(a.C0040a.DEBUG, "shutdown() called");
        if (!this.f3610a.compareAndSet(false, true)) {
            return this;
        }
        this.f3617a.b(new i());
        this.f3598a.b(b);
        this.f3617a.execute(new b());
        return this;
    }

    final class i implements Runnable {
        i() {
        }

        public void run() {
            q0.this.f3582a.a(a.C0040a.INFO, "Entering SHUTDOWN state");
            q0.this.f3600a.b(io.grpc.e.SHUTDOWN);
        }
    }

    final class b implements Runnable {
        b() {
        }

        public void run() {
            q0.this.y0(true);
        }
    }

    /* renamed from: P0 */
    public q0 m() {
        this.f3582a.a(a.C0040a.DEBUG, "shutdownNow() called");
        N0();
        this.f3598a.c(f3567a);
        this.f3617a.execute(new j());
        return this;
    }

    final class j implements Runnable {
        j() {
        }

        public void run() {
            if (!q0.this.d) {
                boolean unused = q0.this.d = true;
                q0.this.H0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void J0(Throwable t2) {
        if (!this.f3627c) {
            this.f3627c = true;
            y0(true);
            O0(false);
            Q0(new e(t2));
            this.f3582a.a(a.C0040a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
            this.f3600a.b(io.grpc.e.TRANSIENT_FAILURE);
        }
    }

    final class e extends ux.i {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Throwable f3631a;

        /* renamed from: a  reason: collision with other field name */
        private final ux.e f3632a;

        e(Throwable th) {
            this.f3631a = th;
            this.f3632a = ux.e.e(io.grpc.p.o.q("Panic! This is a bug!").p(th));
        }

        public ux.e a(ux.f args) {
            return this.f3632a;
        }

        public String toString() {
            return f20.b(e.class).d("panicPickResult", this.f3632a).toString();
        }
    }

    /* access modifiers changed from: private */
    public void Q0(ux.i newPicker) {
        this.f3615a = newPicker;
        this.f3603a.r(newPicker);
    }

    public <ReqT, RespT> io.grpc.b<ReqT, RespT> h(io.grpc.m<ReqT, RespT> method, n7 callOptions) {
        return this.f3578a.h(method, callOptions);
    }

    public String a() {
        return this.f3578a.a();
    }

    /* access modifiers changed from: private */
    public Executor C0(n7 callOptions) {
        Executor executor = callOptions.e();
        if (executor == null) {
            return this.f3609a;
        }
        return executor;
    }

    private class u extends e8 {

        /* renamed from: a  reason: collision with other field name */
        private final String f3645a;

        private final class a<ReqT, RespT> extends t<ReqT, RespT> {
            /* access modifiers changed from: package-private */
            public abstract void e();
        }

        /* synthetic */ u(q0 x0, String x1, a x2) {
            this(x1);
        }

        private u(String authority) {
            this.f3645a = (String) v90.o(authority, "authority");
        }

        public <ReqT, RespT> io.grpc.b<ReqT, RespT> h(io.grpc.m<ReqT, RespT> method, n7 callOptions) {
            return i(method, callOptions);
        }

        public String a() {
            return this.f3645a;
        }

        private <ReqT, RespT> io.grpc.b<ReqT, RespT> i(io.grpc.m<ReqT, RespT> method, n7 callOptions) {
            return new n(method, q0.this.C0(callOptions), callOptions, q0.this.f3593a, q0.this.f ? null : q0.this.f3599a.u(), q0.this.f3591a, (du) q0.this.f3611a.get()).D(q0.this.f3618a).C(q0.this.f3580a).B(q0.this.f3614a);
        }
    }

    /* access modifiers changed from: private */
    public void I0() {
        if (!this.f && this.f3610a.get() && this.f3607a.isEmpty() && this.f3624b.isEmpty()) {
            this.f3582a.a(a.C0040a.INFO, "Terminated");
            this.f3583a.j(this);
            this.f3576a.a(this.f3609a);
            this.f3594a.b();
            this.f3621b.b();
            this.f3599a.close();
            this.f = true;
            this.f3608a.countDown();
        }
    }

    /* access modifiers changed from: private */
    public void E0(fc newState) {
        if (newState.c() == io.grpc.e.TRANSIENT_FAILURE || newState.c() == io.grpc.e.IDLE) {
            K0();
        }
    }

    public io.grpc.e j(boolean requestConnection) {
        io.grpc.e savedChannelState = this.f3600a.a();
        if (requestConnection && savedChannelState == io.grpc.e.IDLE) {
            this.f3617a.execute(new g());
        }
        return savedChannelState;
    }

    final class g implements Runnable {
        g() {
        }

        public void run() {
            q0.this.B0();
            if (q0.this.f3615a != null) {
                q0.this.f3615a.b();
            }
            if (q0.this.f3595a != null) {
                q0.this.f3595a.a.c();
            }
        }
    }

    final class d implements Runnable {
        final /* synthetic */ io.grpc.e a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Runnable f3630a;

        d(Runnable runnable, io.grpc.e eVar) {
            this.f3630a = runnable;
            this.a = eVar;
        }

        public void run() {
            q0.this.f3600a.c(this.f3630a, q0.this.f3609a, this.a);
        }
    }

    public void k(io.grpc.e source, Runnable callback) {
        this.f3617a.execute(new d(callback, source));
    }

    final class h implements Runnable {
        h() {
        }

        public void run() {
            if (!q0.this.f3610a.get()) {
                if (q0.this.f3616a != null && q0.this.f3616a.b()) {
                    v90.u(q0.this.f3625b, "name resolver must be started");
                    q0.this.K0();
                }
                for (m0 subchannel : q0.this.f3607a) {
                    subchannel.S();
                }
                for (x0 oobChannel : q0.this.f3624b) {
                    oobChannel.l();
                }
            }
        }
    }

    public void l() {
        this.f3617a.execute(new h());
    }

    final class f implements Runnable {
        f() {
        }

        public void run() {
            if (!q0.this.f3610a.get() && q0.this.f3595a != null) {
                q0.this.y0(false);
                q0.this.A0();
            }
        }
    }

    public void i() {
        this.f3617a.execute(new f());
    }

    private final class z {

        /* renamed from: a  reason: collision with other field name */
        io.grpc.p f3661a;

        /* renamed from: a  reason: collision with other field name */
        final Object f3662a;

        /* renamed from: a  reason: collision with other field name */
        Collection<z8> f3663a;

        private z() {
            this.f3662a = new Object();
            this.f3663a = new HashSet();
        }

        /* synthetic */ z(q0 x0, a x1) {
            this();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
            io.grpc.internal.q0.s(r3.a).e(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(io.grpc.p r4) {
            /*
                r3 = this;
                r0 = 0
                java.lang.Object r1 = r3.f3662a
                monitor-enter(r1)
                io.grpc.p r2 = r3.f3661a     // Catch:{ all -> 0x0022 }
                if (r2 == 0) goto L_0x000a
                monitor-exit(r1)     // Catch:{ all -> 0x0022 }
                return
            L_0x000a:
                r3.f3661a = r4     // Catch:{ all -> 0x0022 }
                java.util.Collection<z8> r2 = r3.f3663a     // Catch:{ all -> 0x0022 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0022 }
                if (r2 == 0) goto L_0x0015
                r0 = 1
            L_0x0015:
                monitor-exit(r1)     // Catch:{ all -> 0x0022 }
                if (r0 == 0) goto L_0x0021
                io.grpc.internal.q0 r1 = io.grpc.internal.q0.this
                io.grpc.internal.u r1 = r1.f3603a
                r1.e(r4)
            L_0x0021:
                return
            L_0x0022:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0022 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.q0.z.b(io.grpc.p):void");
        }

        /* access modifiers changed from: package-private */
        public void c(io.grpc.p reason) {
            Collection<ClientStream> streams;
            b(reason);
            synchronized (this.f3662a) {
                streams = new ArrayList<>(this.f3663a);
            }
            Iterator<ClientStream> it = streams.iterator();
            while (it.hasNext()) {
                ((z8) it.next()).b(reason);
            }
            q0.this.f3603a.c(reason);
        }

        /* access modifiers changed from: package-private */
        public io.grpc.p a(c1<?> retriableStream) {
            synchronized (this.f3662a) {
                io.grpc.p pVar = this.f3661a;
                if (pVar != null) {
                    return pVar;
                }
                this.f3663a.add(retriableStream);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(c1<?> retriableStream) {
            io.grpc.p shutdownStatusCopy = null;
            synchronized (this.f3662a) {
                this.f3663a.remove(retriableStream);
                if (this.f3663a.isEmpty()) {
                    shutdownStatusCopy = this.f3661a;
                    this.f3663a = new HashSet();
                }
            }
            if (shutdownStatusCopy != null) {
                q0.this.f3603a.e(shutdownStatusCopy);
            }
        }
    }

    private class s extends ux.d {
        h.b a;

        private s() {
        }

        /* synthetic */ s(q0 x0, a x1) {
            this();
        }

        /* renamed from: e */
        public d a(ux.b args) {
            q0.this.f3617a.d();
            return f(args);
        }

        private y f(ux.b args) {
            v90.u(!q0.this.f, "Channel is terminated");
            return new y(args, this);
        }

        public void d(io.grpc.e newState, ux.i newPicker) {
            v90.o(newState, "newState");
            v90.o(newPicker, "newPicker");
            q0.this.G0("updateBalancingState()");
            q0.this.f3617a.execute(new a(newPicker, newState));
        }

        final class a implements Runnable {
            final /* synthetic */ io.grpc.e a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ ux.i f3640a;

            a(ux.i iVar, io.grpc.e eVar) {
                this.f3640a = iVar;
                this.a = eVar;
            }

            public void run() {
                s sVar = s.this;
                if (sVar == q0.this.f3595a) {
                    q0.this.Q0(this.f3640a);
                    if (this.a != io.grpc.e.SHUTDOWN) {
                        q0.this.f3582a.b(a.C0040a.INFO, "Entering {0} state with picker: {1}", this.a, this.f3640a);
                        q0.this.f3600a.b(this.a);
                    }
                }
            }
        }

        public vo0 c() {
            return q0.this.f3617a;
        }

        public io.grpc.a b() {
            return q0.this.f3582a;
        }
    }

    private final class t extends b30.d {
        final b30 a;

        /* renamed from: a  reason: collision with other field name */
        final s f3641a;

        t(s helperImpl, b30 resolver) {
            this.f3641a = (s) v90.o(helperImpl, "helperImpl");
            this.a = (b30) v90.o(resolver, "resolver");
        }

        final class b implements Runnable {
            final /* synthetic */ b30.e a;

            b(b30.e eVar) {
                this.a = eVar;
            }

            public void run() {
                s0 validServiceConfig;
                s0 effectiveServiceConfig;
                s0 effectiveServiceConfig2;
                List<ti> a2 = this.a.a();
                q0.this.f3582a.b(a.C0040a.DEBUG, "Resolved address: {0}, config={1}", a2, this.a.b());
                v k0 = q0.this.f3596a;
                v vVar = v.SUCCESS;
                if (k0 != vVar) {
                    q0.this.f3582a.b(a.C0040a.INFO, "Address resolved: {0}", a2);
                    v unused = q0.this.f3596a = vVar;
                }
                i unused2 = q0.this.f3589a = null;
                b30.b configOrError = this.a.c();
                du resolvedConfigSelector = (du) this.a.b().b(du.a);
                if (configOrError == null || configOrError.c() == null) {
                    validServiceConfig = null;
                } else {
                    validServiceConfig = (s0) configOrError.c();
                }
                io.grpc.p serviceConfigError = configOrError != null ? configOrError.d() : null;
                if (!q0.this.h) {
                    if (validServiceConfig != null) {
                        q0.this.f3582a.a(a.C0040a.INFO, "Service config from name resolver discarded by channel settings");
                    }
                    effectiveServiceConfig = q0.this.f3622b == null ? q0.c : q0.this.f3622b;
                    if (resolvedConfigSelector != null) {
                        q0.this.f3582a.a(a.C0040a.INFO, "Config selector from name resolver discarded by channel settings");
                    }
                    q0.this.f3611a.set((Object) null);
                } else {
                    if (validServiceConfig != null) {
                        effectiveServiceConfig2 = validServiceConfig;
                        q0.this.f3611a.set(resolvedConfigSelector);
                    } else if (q0.this.f3622b != null) {
                        s0 effectiveServiceConfig3 = q0.this.f3622b;
                        q0.this.f3611a.set((Object) null);
                        q0.this.f3582a.a(a.C0040a.INFO, "Received no service config, using default service config");
                        effectiveServiceConfig2 = effectiveServiceConfig3;
                    } else if (serviceConfigError == null) {
                        s0 effectiveServiceConfig4 = q0.c;
                        q0.this.f3611a.set((Object) null);
                        effectiveServiceConfig2 = effectiveServiceConfig4;
                    } else if (!q0.this.g) {
                        q0.this.f3582a.a(a.C0040a.INFO, "Fallback to error due to invalid first service config without default config");
                        t.this.a(configOrError.d());
                        return;
                    } else {
                        effectiveServiceConfig2 = q0.this.f3601a;
                    }
                    if (!effectiveServiceConfig2.equals(q0.this.f3601a)) {
                        io.grpc.a E = q0.this.f3582a;
                        a.C0040a aVar = a.C0040a.INFO;
                        Object[] objArr = new Object[1];
                        objArr[0] = effectiveServiceConfig2 == q0.c ? " to empty" : "";
                        E.b(aVar, "Service config changed{0}", objArr);
                        s0 unused3 = q0.this.f3601a = effectiveServiceConfig2;
                    }
                    try {
                        q0.this.F0();
                    } catch (RuntimeException re) {
                        q0.f3568a.log(Level.WARNING, "[" + q0.this.b() + "] Unexpected exception from parsing service config", re);
                    }
                    effectiveServiceConfig = effectiveServiceConfig2;
                }
                t.this.e();
                v4 effectiveAttrs = this.a.b();
                t tVar = t.this;
                if (tVar.f3641a == q0.this.f3595a) {
                    v4.b attrBuilder = effectiveAttrs.d().c(du.a);
                    Map<String, ?> healthCheckingConfig = effectiveServiceConfig.d();
                    if (healthCheckingConfig != null) {
                        attrBuilder.d(ux.b, healthCheckingConfig).a();
                    }
                    io.grpc.p handleResult = t.this.f3641a.a.e(ux.g.d().b(a2).c(attrBuilder.a()).d(effectiveServiceConfig.e()).a());
                    if (!handleResult.o()) {
                        t.this.f(handleResult.e(t.this.a + " was used"));
                    }
                }
            }
        }

        public void b(b30.e resolutionResult) {
            q0.this.f3617a.execute(new b(resolutionResult));
        }

        final class a implements Runnable {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ io.grpc.p f3643a;

            a(io.grpc.p pVar) {
                this.f3643a = pVar;
            }

            public void run() {
                t.this.f(this.f3643a);
            }
        }

        public void a(io.grpc.p error) {
            v90.e(!error.o(), "the error status must not be OK");
            q0.this.f3617a.execute(new a(error));
        }

        /* access modifiers changed from: private */
        public void f(io.grpc.p error) {
            q0.f3568a.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{q0.this.b(), error});
            if (q0.this.f3611a.get() == q0.a) {
                q0.this.f3611a.set((Object) null);
                e();
            }
            v k0 = q0.this.f3596a;
            v vVar = v.ERROR;
            if (k0 != vVar) {
                q0.this.f3582a.b(a.C0040a.WARNING, "Failed to resolve name: {0}", error);
                v unused = q0.this.f3596a = vVar;
            }
            if (this.f3641a == q0.this.f3595a) {
                this.f3641a.a.b(error);
                g();
            }
        }

        /* access modifiers changed from: private */
        public void e() {
            if (q0.this.f3606a != null) {
                for (ManagedChannelImpl.RealChannel.PendingCall<?, ?> pendingCall : q0.this.f3606a) {
                    pendingCall.e();
                }
            }
        }

        private void g() {
            if (q0.this.f3616a == null || !q0.this.f3616a.b()) {
                if (q0.this.f3589a == null) {
                    q0 q0Var = q0.this;
                    i unused = q0Var.f3589a = q0Var.f3588a.a();
                }
                long delayNanos = q0.this.f3589a.a();
                q0.this.f3582a.b(a.C0040a.DEBUG, "Scheduling DNS resolution backoff for {0} ns", Long.valueOf(delayNanos));
                q0 q0Var2 = q0.this;
                vo0.c unused2 = q0Var2.f3616a = q0Var2.f3617a.c(new n(), delayNanos, TimeUnit.NANOSECONDS, q0.this.f3599a.u());
            }
        }
    }

    private final class y extends d {
        final hu a;

        /* renamed from: a  reason: collision with other field name */
        final l f3649a;

        /* renamed from: a  reason: collision with other field name */
        m0 f3650a;

        /* renamed from: a  reason: collision with other field name */
        final m f3651a;

        /* renamed from: a  reason: collision with other field name */
        final s f3652a;

        /* renamed from: a  reason: collision with other field name */
        final ux.b f3654a;

        /* renamed from: a  reason: collision with other field name */
        ux.j f3655a;

        /* renamed from: a  reason: collision with other field name */
        vo0.c f3656a;

        /* renamed from: a  reason: collision with other field name */
        boolean f3657a;
        boolean b;

        y(ux.b args, s helper) {
            this.f3654a = (ux.b) v90.o(args, "args");
            this.f3652a = (s) v90.o(helper, "helper");
            hu b2 = hu.b("Subchannel", q0.this.a());
            this.a = b2;
            int a0 = q0.this.f3571a;
            long a2 = q0.this.f3612a.a();
            m mVar = new m(b2, a0, a2, "Subchannel for " + args.a());
            this.f3651a = mVar;
            this.f3649a = new l(mVar, q0.this.f3612a);
        }

        private void k(ux.j listener) {
            ux.j jVar = listener;
            v90.u(!this.f3657a, "already started");
            v90.u(!this.b, "already shutdown");
            this.f3657a = true;
            this.f3655a = jVar;
            if (q0.this.e) {
                q0.this.f3617a.execute(new a(jVar));
                return;
            }
            List<ti> a2 = this.f3654a.a();
            String a3 = q0.this.a();
            String f0 = q0.this.f3623b;
            i.a g0 = q0.this.f3588a;
            q A = q0.this.f3599a;
            ScheduledExecutorService u = q0.this.f3599a.u();
            oo0 h0 = q0.this.f3613a;
            vo0 vo0 = q0.this.f3617a;
            b bVar = new b(jVar);
            io.grpc.h c0 = q0.this.f3583a;
            k a4 = q0.this.f3590a.a();
            m mVar = this.f3651a;
            m mVar2 = mVar;
            m0 internalSubchannel = new m0(a2, a3, f0, g0, A, u, h0, vo0, bVar, c0, a4, mVar2, this.a, this.f3649a);
            q0.this.f3592a.e(new i.a().b("Child Subchannel started").c(i.b.CT_INFO).e(q0.this.f3612a.a()).d(internalSubchannel).a());
            this.f3650a = internalSubchannel;
            q0.this.f3617a.execute(new d(internalSubchannel));
        }

        class a implements Runnable {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ ux.j f3658a;

            a(ux.j jVar) {
                this.f3658a = jVar;
            }

            public void run() {
                this.f3658a.a(fc.a(io.grpc.e.SHUTDOWN));
            }
        }

        final class b extends m0.k {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ ux.j f3659a;

            b(ux.j jVar) {
                this.f3659a = jVar;
            }

            /* access modifiers changed from: package-private */
            public void d(m0 is) {
                q0.this.f3607a.remove(is);
                q0.this.f3583a.k(is);
                q0.this.I0();
            }

            /* access modifiers changed from: package-private */
            public void c(m0 is, fc newState) {
                q0.this.E0(newState);
                v90.u(this.f3659a != null, "listener is null");
                this.f3659a.a(newState);
            }

            /* access modifiers changed from: package-private */
            public void a(m0 is) {
                q0.this.f3579a.d(is, true);
            }

            /* access modifiers changed from: package-private */
            public void b(m0 is) {
                q0.this.f3579a.d(is, false);
            }
        }

        class d implements Runnable {
            final /* synthetic */ m0 a;

            d(m0 m0Var) {
                this.a = m0Var;
            }

            public void run() {
                q0.this.f3583a.e(this.a);
                q0.this.f3607a.add(this.a);
            }
        }

        public void g(ux.j listener) {
            q0.this.f3617a.d();
            k(listener);
        }

        class e implements Runnable {
            e() {
            }

            public void run() {
                y.this.j();
            }
        }

        public void f() {
            q0.this.G0("Subchannel.shutdown()");
            q0.this.f3617a.execute(new e());
        }

        /* access modifiers changed from: private */
        public void j() {
            vo0.c cVar;
            q0.this.f3617a.d();
            if (this.f3650a == null) {
                this.b = true;
                return;
            }
            if (!this.b) {
                this.b = true;
            } else if (q0.this.e && (cVar = this.f3656a) != null) {
                cVar.a();
                this.f3656a = null;
            } else {
                return;
            }
            if (!q0.this.e) {
                this.f3656a = q0.this.f3617a.c(new ty(new c()), 5, TimeUnit.SECONDS, q0.this.f3599a.u());
            } else {
                this.f3650a.e(q0.b);
            }
        }

        final class c implements Runnable {
            c() {
            }

            public void run() {
                y.this.f3650a.e(q0.f3570c);
            }
        }

        public void e() {
            q0.this.G0("Subchannel.requestConnection()");
            v90.u(this.f3657a, "not started");
            this.f3650a.a();
        }

        public List<ti> b() {
            q0.this.G0("Subchannel.getAllAddresses()");
            v90.u(this.f3657a, "not started");
            return this.f3650a.M();
        }

        public v4 c() {
            return this.f3654a.b();
        }

        public String toString() {
            return this.a.toString();
        }

        public Object d() {
            v90.u(this.f3657a, "Subchannel is not started");
            return this.f3650a;
        }

        public void h(List<ti> addrs) {
            q0.this.f3617a.d();
            this.f3650a.V(addrs);
        }
    }

    public String toString() {
        return f20.c(this).c("logId", this.f3581a.d()).d("target", this.f3605a).toString();
    }

    private final class o implements t0.a {
        private o() {
        }

        /* synthetic */ o(q0 x0, a x1) {
            this();
        }

        public void d(io.grpc.p s) {
            v90.u(q0.this.f3610a.get(), "Channel must have been shut down");
        }

        public void c() {
        }

        public void b(boolean inUse) {
            q0 q0Var = q0.this;
            q0Var.f3579a.d(q0Var.f3603a, inUse);
        }

        public void a() {
            v90.u(q0.this.f3610a.get(), "Channel must have been shut down");
            boolean unused = q0.this.e = true;
            q0.this.O0(false);
            q0.this.H0();
            q0.this.I0();
        }
    }

    private final class q extends es<Object> {
        private q() {
        }

        /* synthetic */ q(q0 x0, a x1) {
            this();
        }

        /* access modifiers changed from: protected */
        public void a() {
            q0.this.B0();
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (!q0.this.f3610a.get()) {
                q0.this.M0();
            }
        }
    }

    private static final class p {
        private final b40<? extends Executor> a;

        /* renamed from: a  reason: collision with other field name */
        private Executor f3637a;

        p(b40<? extends Executor> executorPool) {
            this.a = (b40) v90.o(executorPool, "executorPool");
        }

        /* access modifiers changed from: package-private */
        public synchronized Executor a() {
            if (this.f3637a == null) {
                this.f3637a = (Executor) v90.p(this.a.b(), "%s.getObject()", this.f3637a);
            }
            return this.f3637a;
        }

        /* access modifiers changed from: package-private */
        public synchronized void b() {
            Executor executor = this.f3637a;
            if (executor != null) {
                this.f3637a = (Executor) this.a.a(executor);
            }
        }
    }

    private static final class w implements ScheduledExecutorService {
        final ScheduledExecutorService a;

        /* synthetic */ w(ScheduledExecutorService x0, a x1) {
            this(x0);
        }

        private w(ScheduledExecutorService delegate) {
            this.a = (ScheduledExecutorService) v90.o(delegate, "delegate");
        }

        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            return this.a.schedule(callable, delay, unit);
        }

        public ScheduledFuture<?> schedule(Runnable cmd, long delay, TimeUnit unit) {
            return this.a.schedule(cmd, delay, unit);
        }

        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
            return this.a.scheduleAtFixedRate(command, initialDelay, period, unit);
        }

        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
            return this.a.scheduleWithFixedDelay(command, initialDelay, delay, unit);
        }

        public boolean awaitTermination(long timeout, TimeUnit unit) {
            return this.a.awaitTermination(timeout, unit);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
            return this.a.invokeAll(tasks);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) {
            return this.a.invokeAll(tasks, timeout, unit);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) {
            return this.a.invokeAny(tasks);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) {
            return this.a.invokeAny(tasks, timeout, unit);
        }

        public boolean isShutdown() {
            return this.a.isShutdown();
        }

        public boolean isTerminated() {
            return this.a.isTerminated();
        }

        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        public <T> Future<T> submit(Callable<T> task) {
            return this.a.submit(task);
        }

        public Future<?> submit(Runnable task) {
            return this.a.submit(task);
        }

        public <T> Future<T> submit(Runnable task, T result) {
            return this.a.submit(task, result);
        }

        public void execute(Runnable command) {
            this.a.execute(command);
        }
    }

    static final class x extends b30.f {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private final io.grpc.a f3646a;

        /* renamed from: a  reason: collision with other field name */
        private final h f3647a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f3648a;
        private final int b;

        x(boolean retryEnabled, int maxRetryAttemptsLimit, int maxHedgedAttemptsLimit, h autoLoadBalancerFactory, io.grpc.a channelLogger) {
            this.f3648a = retryEnabled;
            this.a = maxRetryAttemptsLimit;
            this.b = maxHedgedAttemptsLimit;
            this.f3647a = (h) v90.o(autoLoadBalancerFactory, "autoLoadBalancerFactory");
            this.f3646a = (io.grpc.a) v90.o(channelLogger, "channelLogger");
        }

        public b30.b a(Map<String, ?> rawServiceConfig) {
            Object loadBalancingPolicySelection;
            try {
                b30.b choiceFromLoadBalancer = this.f3647a.f(rawServiceConfig, this.f3646a);
                if (choiceFromLoadBalancer == null) {
                    loadBalancingPolicySelection = null;
                } else if (choiceFromLoadBalancer.d() != null) {
                    return b30.b.b(choiceFromLoadBalancer.d());
                } else {
                    loadBalancingPolicySelection = choiceFromLoadBalancer.c();
                }
                return b30.b.a(s0.b(rawServiceConfig, this.f3648a, this.a, this.b, loadBalancingPolicySelection));
            } catch (RuntimeException e) {
                return b30.b.b(io.grpc.p.c.q("failed to parse service config").p(e));
            }
        }
    }

    /* access modifiers changed from: private */
    public void G0(String method) {
        try {
            this.f3617a.d();
        } catch (IllegalStateException e2) {
            Logger logger = f3568a;
            Level level = Level.WARNING;
            logger.log(level, method + " should be called from SynchronizationContext. This warning will become an exception in a future release. See https://github.com/grpc/grpc-java/issues/5015 for more details", e2);
        }
    }
}
