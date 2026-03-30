package io.grpc.internal;

import defpackage.b30;
import defpackage.ux;
import defpackage.v4;
import io.grpc.a;
import io.grpc.internal.g1;
import io.grpc.p;
import java.util.List;
import java.util.Map;

public final class h {
    /* access modifiers changed from: private */
    public final String a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final wx f3419a;

    public h(String defaultPolicy) {
        this(wx.b(), defaultPolicy);
    }

    h(wx registry, String defaultPolicy) {
        this.f3419a = (wx) v90.o(registry, "registry");
        this.a = (String) v90.o(defaultPolicy, "defaultPolicy");
    }

    public b e(ux.d helper) {
        return new b(helper);
    }

    private static final class e extends ux {
        private e() {
        }

        public void c(ux.g resolvedAddresses) {
        }

        public void b(p error) {
        }

        public void e() {
        }
    }

    public final class b {

        /* renamed from: a  reason: collision with other field name */
        private final ux.d f3420a;

        /* renamed from: a  reason: collision with other field name */
        private ux f3421a;

        /* renamed from: a  reason: collision with other field name */
        private vx f3422a;

        b(ux.d helper) {
            this.f3420a = helper;
            vx d = h.this.f3419a.d(h.this.a);
            this.f3422a = d;
            if (d != null) {
                this.f3421a = d.a(helper);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + h.this.a + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        /* access modifiers changed from: package-private */
        public p e(ux.g resolvedAddresses) {
            List<ti> a2 = resolvedAddresses.a();
            v4 attributes = resolvedAddresses.b();
            v4.c cVar = ux.a;
            if (attributes.b(cVar) == null) {
                g1.b policySelection = (g1.b) resolvedAddresses.c();
                if (policySelection == null) {
                    try {
                        h hVar = h.this;
                        policySelection = new g1.b(hVar.d(hVar.a, "using default policy"), (Map<String, ?>) null, (Object) null);
                    } catch (f e) {
                        this.f3420a.d(io.grpc.e.TRANSIENT_FAILURE, new d(p.o.q(e.getMessage())));
                        this.f3421a.e();
                        this.f3422a = null;
                        this.f3421a = new e();
                        return p.f3953a;
                    }
                }
                if (this.f3422a == null || !policySelection.f3418a.b().equals(this.f3422a.b())) {
                    this.f3420a.d(io.grpc.e.CONNECTING, new c());
                    this.f3421a.e();
                    vx vxVar = policySelection.f3418a;
                    this.f3422a = vxVar;
                    ux old = this.f3421a;
                    this.f3421a = vxVar.a(this.f3420a);
                    this.f3420a.b().b(a.C0040a.INFO, "Load balancer changed from {0} to {1}", old.getClass().getSimpleName(), this.f3421a.getClass().getSimpleName());
                }
                Object lbConfig = policySelection.a;
                if (lbConfig != null) {
                    this.f3420a.b().b(a.C0040a.DEBUG, "Load-balancing config: {0}", policySelection.a);
                    attributes = attributes.d().d(cVar, policySelection.f3417a).a();
                }
                ux delegate = a();
                if (!resolvedAddresses.a().isEmpty() || delegate.a()) {
                    delegate.c(ux.g.d().b(resolvedAddresses.a()).c(attributes).d(lbConfig).a());
                    return p.f3953a;
                }
                p pVar = p.p;
                return pVar.q("NameResolver returned no usable address. addrs=" + a2 + ", attrs=" + attributes);
            }
            throw new IllegalArgumentException("Unexpected ATTR_LOAD_BALANCING_CONFIG from upstream: " + attributes.b(cVar));
        }

        /* access modifiers changed from: package-private */
        public void b(p error) {
            a().b(error);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            a().d();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f3421a.e();
            this.f3421a = null;
        }

        public ux a() {
            return this.f3421a;
        }
    }

    /* access modifiers changed from: private */
    public vx d(String policy, String choiceReason) {
        vx provider = this.f3419a.d(policy);
        if (provider != null) {
            return provider;
        }
        throw new f("Trying to load '" + policy + "' because " + choiceReason + ", but it's unavailable");
    }

    /* access modifiers changed from: package-private */
    public b30.b f(Map<String, ?> serviceConfig, io.grpc.a channelLogger) {
        List<g1.a> list = null;
        if (serviceConfig != null) {
            try {
                list = g1.z(g1.g(serviceConfig));
            } catch (RuntimeException e2) {
                return b30.b.b(p.c.q("can't parse load balancer configuration").p(e2));
            }
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return g1.x(list, this.f3419a);
    }

    static final class f extends Exception {
        private f(String msg) {
            super(msg);
        }
    }

    private static final class c extends ux.i {
        private c() {
        }

        public ux.e a(ux.f args) {
            return ux.e.g();
        }

        public String toString() {
            return f20.b(c.class).toString();
        }
    }

    private static final class d extends ux.i {
        private final p a;

        d(p failure) {
            this.a = failure;
        }

        public ux.e a(ux.f args) {
            return ux.e.f(this.a);
        }
    }
}
