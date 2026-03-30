package io.grpc.internal;

import defpackage.vo0;
import io.grpc.EquivalentAddressGroup;
import io.grpc.a;
import io.grpc.internal.i;
import io.grpc.internal.o;
import io.grpc.internal.q;
import io.grpc.internal.t0;
import io.grpc.p;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class m0 implements gu<Object>, l1 {
    /* access modifiers changed from: private */
    public bc a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final es<bc> f3483a = new a();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile fc f3484a = fc.a(io.grpc.e.IDLE);

    /* renamed from: a  reason: collision with other field name */
    private final hn0 f3485a;

    /* renamed from: a  reason: collision with other field name */
    private final hu f3486a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final io.grpc.a f3487a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final io.grpc.h f3488a;

    /* renamed from: a  reason: collision with other field name */
    private final i.a f3489a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public i f3490a;

    /* renamed from: a  reason: collision with other field name */
    private final k f3491a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final k f3492a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final l f3493a;

    /* renamed from: a  reason: collision with other field name */
    private final m f3494a;

    /* renamed from: a  reason: collision with other field name */
    private final q f3495a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public t0 f3496a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public p f3497a;

    /* renamed from: a  reason: collision with other field name */
    private final String f3498a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Collection<bc> f3499a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile List<ti> f3500a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ScheduledExecutorService f3501a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public vo0.c f3502a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final vo0 f3503a;
    /* access modifiers changed from: private */
    public volatile t0 b;

    /* renamed from: b  reason: collision with other field name */
    private final String f3504b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public vo0.c f3505b;

    class a extends es<bc> {
        a() {
        }

        /* access modifiers changed from: protected */
        public void a() {
            m0.this.f3492a.a(m0.this);
        }

        /* access modifiers changed from: protected */
        public void b() {
            m0.this.f3492a.b(m0.this);
        }
    }

    m0(List<ti> addressGroups, String authority, String userAgent, i.a backoffPolicyProvider, q transportFactory, ScheduledExecutorService scheduledExecutor, oo0<hn0> stopwatchSupplier, vo0 syncContext, k callback, io.grpc.h channelz, k callsTracer, m channelTracer, hu logId, io.grpc.a channelLogger) {
        List<ti> list = addressGroups;
        v90.o(list, "addressGroups");
        v90.e(!addressGroups.isEmpty(), "addressGroups is empty");
        L(list, "addressGroups contains null entry");
        List<EquivalentAddressGroup> unmodifiableAddressGroups = Collections.unmodifiableList(new ArrayList(list));
        this.f3500a = unmodifiableAddressGroups;
        this.f3493a = new l(unmodifiableAddressGroups);
        this.f3498a = authority;
        this.f3504b = userAgent;
        this.f3489a = backoffPolicyProvider;
        this.f3495a = transportFactory;
        this.f3501a = scheduledExecutor;
        this.f3485a = stopwatchSupplier.get();
        this.f3503a = syncContext;
        this.f3492a = callback;
        this.f3488a = channelz;
        this.f3491a = callsTracer;
        this.f3494a = (m) v90.o(channelTracer, "channelTracer");
        this.f3486a = (hu) v90.o(logId, "logId");
        this.f3487a = (io.grpc.a) v90.o(channelLogger, "channelLogger");
    }

    public p a() {
        p savedTransport = this.b;
        if (savedTransport != null) {
            return savedTransport;
        }
        this.f3503a.execute(new c());
        return null;
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            if (m0.this.f3484a.c() == io.grpc.e.IDLE) {
                m0.this.f3487a.a(a.C0040a.INFO, "CONNECTING as requested");
                m0.this.N(io.grpc.e.CONNECTING);
                m0.this.U();
            }
        }
    }

    /* access modifiers changed from: private */
    public void U() {
        this.f3503a.d();
        v90.u(this.f3502a == null, "Should have no reconnectTask scheduled");
        if (this.f3493a.d()) {
            this.f3485a.f().g();
        }
        SocketAddress address = this.f3493a.a();
        xq proxiedAddr = null;
        boolean z = address instanceof xq;
        SocketAddress address2 = address;
        if (z) {
            proxiedAddr = (xq) address;
            address2 = proxiedAddr.c();
        }
        v4 currentEagAttributes = this.f3493a.b();
        String eagChannelAuthority = (String) currentEagAttributes.b(ti.a);
        q.a options = new q.a().e(eagChannelAuthority != null ? eagChannelAuthority : this.f3498a).f(currentEagAttributes).h(this.f3504b).g(proxiedAddr);
        n transportLogger = new n();
        transportLogger.a = b();
        bc transport = new j(this.f3495a.M(address2, options, transportLogger), this.f3491a, (a) null);
        transportLogger.a = transport.b();
        this.f3488a.c(transport);
        this.a = transport;
        this.f3499a.add(transport);
        Runnable runnable = transport.d(new m(transport, address2));
        if (runnable != null) {
            this.f3503a.b(runnable);
        }
        this.f3487a.b(a.C0040a.INFO, "Started transport {0}", transportLogger.a);
    }

    /* access modifiers changed from: private */
    public void T(p status) {
        this.f3503a.d();
        O(fc.b(status));
        if (this.f3490a == null) {
            this.f3490a = this.f3489a.a();
        }
        long a2 = this.f3490a.a();
        hn0 hn0 = this.f3485a;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long delayNanos = a2 - hn0.d(timeUnit);
        boolean z = false;
        this.f3487a.b(a.C0040a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", R(status), Long.valueOf(delayNanos));
        if (this.f3502a == null) {
            z = true;
        }
        v90.u(z, "previous reconnectTask is not done");
        this.f3502a = this.f3503a.c(new b(), delayNanos, timeUnit, this.f3501a);
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            vo0.c unused = m0.this.f3502a = null;
            m0.this.f3487a.a(a.C0040a.INFO, "CONNECTING after backoff");
            m0.this.N(io.grpc.e.CONNECTING);
            m0.this.U();
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            if (m0.this.f3484a.c() == io.grpc.e.TRANSIENT_FAILURE) {
                m0.this.K();
                m0.this.f3487a.a(a.C0040a.INFO, "CONNECTING; backoff interrupted");
                m0.this.N(io.grpc.e.CONNECTING);
                m0.this.U();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void S() {
        this.f3503a.execute(new d());
    }

    /* access modifiers changed from: private */
    public void N(io.grpc.e newState) {
        this.f3503a.d();
        O(fc.a(newState));
    }

    private void O(fc newState) {
        this.f3503a.d();
        if (this.f3484a.c() != newState.c()) {
            boolean z = this.f3484a.c() != io.grpc.e.SHUTDOWN;
            v90.u(z, "Cannot transition out of SHUTDOWN to " + newState);
            this.f3484a = newState;
            this.f3492a.c(this, newState);
        }
    }

    public void V(List<ti> newAddressGroups) {
        v90.o(newAddressGroups, "newAddressGroups");
        L(newAddressGroups, "newAddressGroups contains null entry");
        v90.e(!newAddressGroups.isEmpty(), "newAddressGroups is empty");
        this.f3503a.execute(new e(newAddressGroups));
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ List f3506a;

        e(List list) {
            this.f3506a = list;
        }

        public void run() {
            List<EquivalentAddressGroup> newImmutableAddressGroups = Collections.unmodifiableList(new ArrayList(this.f3506a));
            t0 savedTransport = null;
            SocketAddress previousAddress = m0.this.f3493a.a();
            m0.this.f3493a.h(newImmutableAddressGroups);
            List unused = m0.this.f3500a = newImmutableAddressGroups;
            io.grpc.e c = m0.this.f3484a.c();
            io.grpc.e eVar = io.grpc.e.READY;
            if ((c == eVar || m0.this.f3484a.c() == io.grpc.e.CONNECTING) && !m0.this.f3493a.g(previousAddress)) {
                if (m0.this.f3484a.c() == eVar) {
                    savedTransport = m0.this.b;
                    t0 unused2 = m0.this.b = null;
                    m0.this.f3493a.f();
                    m0.this.N(io.grpc.e.IDLE);
                } else {
                    m0.this.a.e(p.p.q("InternalSubchannel closed pending transport due to address change"));
                    bc unused3 = m0.this.a = null;
                    m0.this.f3493a.f();
                    m0.this.U();
                }
            }
            if (savedTransport != null) {
                if (m0.this.f3505b != null) {
                    m0.this.f3496a.e(p.p.q("InternalSubchannel closed transport early due to address change"));
                    m0.this.f3505b.a();
                    vo0.c unused4 = m0.this.f3505b = null;
                    t0 unused5 = m0.this.f3496a = null;
                }
                t0 unused6 = m0.this.f3496a = savedTransport;
                m0 m0Var = m0.this;
                vo0.c unused7 = m0Var.f3505b = m0Var.f3503a.c(new a(), 5, TimeUnit.SECONDS, m0.this.f3501a);
            }
        }

        class a implements Runnable {
            a() {
            }

            public void run() {
                t0 transport = m0.this.f3496a;
                vo0.c unused = m0.this.f3505b = null;
                t0 unused2 = m0.this.f3496a = null;
                transport.e(p.p.q("InternalSubchannel closed transport due to address change"));
            }
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ p f3507a;

        f(p pVar) {
            this.f3507a = pVar;
        }

        public void run() {
            io.grpc.e c = m0.this.f3484a.c();
            io.grpc.e eVar = io.grpc.e.SHUTDOWN;
            if (c != eVar) {
                p unused = m0.this.f3497a = this.f3507a;
                t0 savedActiveTransport = m0.this.b;
                bc savedPendingTransport = m0.this.a;
                t0 unused2 = m0.this.b = null;
                bc unused3 = m0.this.a = null;
                m0.this.N(eVar);
                m0.this.f3493a.f();
                if (m0.this.f3499a.isEmpty()) {
                    m0.this.P();
                }
                m0.this.K();
                if (m0.this.f3505b != null) {
                    m0.this.f3505b.a();
                    m0.this.f3496a.e(this.f3507a);
                    vo0.c unused4 = m0.this.f3505b = null;
                    t0 unused5 = m0.this.f3496a = null;
                }
                if (savedActiveTransport != null) {
                    savedActiveTransport.e(this.f3507a);
                }
                if (savedPendingTransport != null) {
                    savedPendingTransport.e(this.f3507a);
                }
            }
        }
    }

    public void e(p reason) {
        this.f3503a.execute(new f(reason));
    }

    public String toString() {
        return f20.c(this).c("logId", this.f3486a.d()).d("addressGroups", this.f3500a).toString();
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            m0.this.f3487a.a(a.C0040a.INFO, "Terminated");
            m0.this.f3492a.d(m0.this);
        }
    }

    /* access modifiers changed from: private */
    public void P() {
        this.f3503a.execute(new g());
    }

    class h implements Runnable {
        final /* synthetic */ bc a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f3509a;

        h(bc bcVar, boolean z) {
            this.a = bcVar;
            this.f3509a = z;
        }

        public void run() {
            m0.this.f3483a.d(this.a, this.f3509a);
        }
    }

    /* access modifiers changed from: private */
    public void Q(bc transport, boolean inUse) {
        this.f3503a.execute(new h(transport, inUse));
    }

    class i implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ p f3510a;

        i(p pVar) {
            this.f3510a = pVar;
        }

        public void run() {
            Iterator<ManagedClientTransport> it = new ArrayList<>(m0.this.f3499a).iterator();
            while (it.hasNext()) {
                ((t0) it.next()).c(this.f3510a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(p reason) {
        e(reason);
        this.f3503a.execute(new i(reason));
    }

    /* access modifiers changed from: package-private */
    public List<ti> M() {
        return this.f3500a;
    }

    /* access modifiers changed from: private */
    public void K() {
        this.f3503a.d();
        vo0.c cVar = this.f3502a;
        if (cVar != null) {
            cVar.a();
            this.f3502a = null;
            this.f3490a = null;
        }
    }

    public hu b() {
        return this.f3486a;
    }

    private static void L(List<?> list, String msg) {
        for (Object item : list) {
            v90.o(item, msg);
        }
    }

    private class m implements t0.a {
        final bc a;

        /* renamed from: a  reason: collision with other field name */
        final SocketAddress f3516a;

        /* renamed from: a  reason: collision with other field name */
        boolean f3517a = false;

        m(bc transport, SocketAddress address) {
            this.a = transport;
            this.f3516a = address;
        }

        class a implements Runnable {
            a() {
            }

            public void run() {
                i unused = m0.this.f3490a = null;
                if (m0.this.f3497a != null) {
                    v90.u(m0.this.b == null, "Unexpected non-null activeTransport");
                    m mVar = m.this;
                    mVar.a.e(m0.this.f3497a);
                    return;
                }
                bc l = m0.this.a;
                m mVar2 = m.this;
                bc bcVar = mVar2.a;
                if (l == bcVar) {
                    t0 unused2 = m0.this.b = bcVar;
                    bc unused3 = m0.this.a = null;
                    m0.this.N(io.grpc.e.READY);
                }
            }
        }

        public void c() {
            m0.this.f3487a.a(a.C0040a.INFO, "READY");
            m0.this.f3503a.execute(new a());
        }

        public void b(boolean inUse) {
            m0.this.Q(this.a, inUse);
        }

        public void d(p s) {
            m0.this.f3487a.b(a.C0040a.INFO, "{0} SHUTDOWN with {1}", this.a.b(), m0.this.R(s));
            this.f3517a = true;
            m0.this.f3503a.execute(new b(s));
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ p f3518a;

            b(p pVar) {
                this.f3518a = pVar;
            }

            public void run() {
                if (m0.this.f3484a.c() != io.grpc.e.SHUTDOWN) {
                    t0 j = m0.this.b;
                    m mVar = m.this;
                    if (j == mVar.a) {
                        t0 unused = m0.this.b = null;
                        m0.this.f3493a.f();
                        m0.this.N(io.grpc.e.IDLE);
                        return;
                    }
                    bc l = m0.this.a;
                    m mVar2 = m.this;
                    if (l == mVar2.a) {
                        v90.w(m0.this.f3484a.c() == io.grpc.e.CONNECTING, "Expected state is CONNECTING, actual state is %s", m0.this.f3484a.c());
                        m0.this.f3493a.c();
                        if (!m0.this.f3493a.e()) {
                            bc unused2 = m0.this.a = null;
                            m0.this.f3493a.f();
                            m0.this.T(this.f3518a);
                            return;
                        }
                        m0.this.U();
                    }
                }
            }
        }

        public void a() {
            v90.u(this.f3517a, "transportShutdown() must be called before transportTerminated().");
            m0.this.f3487a.b(a.C0040a.INFO, "{0} Terminated", this.a.b());
            m0.this.f3488a.i(this.a);
            m0.this.Q(this.a, false);
            m0.this.f3503a.execute(new c());
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                m0.this.f3499a.remove(m.this.a);
                if (m0.this.f3484a.c() == io.grpc.e.SHUTDOWN && m0.this.f3499a.isEmpty()) {
                    m0.this.P();
                }
            }
        }
    }

    static abstract class k {
        /* access modifiers changed from: package-private */
        public abstract void a(m0 m0Var);

        /* access modifiers changed from: package-private */
        public abstract void b(m0 m0Var);

        /* access modifiers changed from: package-private */
        public abstract void c(m0 m0Var, fc fcVar);

        /* access modifiers changed from: package-private */
        public abstract void d(m0 m0Var);

        k() {
        }
    }

    static final class j extends d0 {
        private final bc a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final k f3511a;

        /* synthetic */ j(bc x0, k x1, a x2) {
            this(x0, x1);
        }

        private j(bc delegate, k callTracer) {
            this.a = delegate;
            this.f3511a = callTracer;
        }

        /* access modifiers changed from: protected */
        public bc a() {
            return this.a;
        }

        class a extends b0 {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ z8 f3512a;

            a(z8 z8Var) {
                this.f3512a = z8Var;
            }

            /* access modifiers changed from: protected */
            public z8 p() {
                return this.f3512a;
            }

            /* renamed from: io.grpc.internal.m0$j$a$a  reason: collision with other inner class name */
            class C0046a extends c0 {

                /* renamed from: a  reason: collision with other field name */
                final /* synthetic */ o f3513a;

                C0046a(o oVar) {
                    this.f3513a = oVar;
                }

                /* access modifiers changed from: protected */
                public o f() {
                    return this.f3513a;
                }

                public void d(p status, io.grpc.l trailers) {
                    j.this.f3511a.a(status.o());
                    super.d(status, trailers);
                }

                public void c(p status, o.a rpcProgress, io.grpc.l trailers) {
                    j.this.f3511a.a(status.o());
                    super.c(status, rpcProgress, trailers);
                }
            }

            public void k(o listener) {
                j.this.f3511a.b();
                super.k(new C0046a(listener));
            }
        }

        public z8 f(io.grpc.m<?, ?> method, io.grpc.l headers, n7 callOptions) {
            return new a(super.f(method, headers, callOptions));
        }
    }

    static final class l {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private List<ti> f3514a;
        private int b;

        public l(List<ti> groups) {
            this.f3514a = groups;
        }

        public boolean e() {
            return this.a < this.f3514a.size();
        }

        public boolean d() {
            return this.a == 0 && this.b == 0;
        }

        public void c() {
            int i = this.b + 1;
            this.b = i;
            if (i >= this.f3514a.get(this.a).a().size()) {
                this.a++;
                this.b = 0;
            }
        }

        public void f() {
            this.a = 0;
            this.b = 0;
        }

        public SocketAddress a() {
            return this.f3514a.get(this.a).a().get(this.b);
        }

        public v4 b() {
            return this.f3514a.get(this.a).b();
        }

        public void h(List<ti> newGroups) {
            this.f3514a = newGroups;
            f();
        }

        public boolean g(SocketAddress needle) {
            int i = 0;
            while (i < this.f3514a.size()) {
                int j = this.f3514a.get(i).a().indexOf(needle);
                if (j == -1) {
                    i++;
                } else {
                    this.a = i;
                    this.b = j;
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public String R(p status) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(status.m());
        if (status.n() != null) {
            buffer.append("(");
            buffer.append(status.n());
            buffer.append(")");
        }
        return buffer.toString();
    }

    static final class n extends io.grpc.a {
        hu a;

        n() {
        }

        public void a(a.C0040a level, String message) {
            l.d(this.a, level, message);
        }

        public void b(a.C0040a level, String messageFormat, Object... args) {
            l.e(this.a, level, messageFormat, args);
        }
    }
}
