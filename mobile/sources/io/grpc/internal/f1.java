package io.grpc.internal;

import defpackage.n7;
import io.grpc.internal.d1;
import io.grpc.internal.j0;
import io.grpc.internal.s0;
import io.grpc.m;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

final class f1 implements w8 {
    static final n7.a<d1.a> a = n7.a.b("internal-retry-policy");
    static final n7.a<j0.a> b = n7.a.b("internal-hedging-policy");

    /* renamed from: a  reason: collision with other field name */
    final AtomicReference<s0> f3409a = new AtomicReference<>();

    /* renamed from: a  reason: collision with other field name */
    private final boolean f3410a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public volatile boolean f3411b;

    f1(boolean retryEnabled) {
        this.f3410a = retryEnabled;
    }

    /* access modifiers changed from: package-private */
    public void f(s0 serviceConfig) {
        this.f3409a.set(serviceConfig);
        this.f3411b = true;
    }

    public <ReqT, RespT> io.grpc.b<ReqT, RespT> a(m<ReqT, RespT> method, n7 callOptions, e8 next) {
        if (this.f3410a) {
            if (this.f3411b) {
                d1 retryPolicy = e(method);
                j0 hedgingPolicy = c(method);
                xu0.a(retryPolicy.equals(d1.a) || hedgingPolicy.equals(j0.a), "Can not apply both retry and hedging policy for the method '%s'", method);
                callOptions = callOptions.p(a, new d(retryPolicy)).p(b, new c(hedgingPolicy));
            } else {
                callOptions = callOptions.p(a, new b(method)).p(b, new a(method));
            }
        }
        s0.a info = d(method);
        if (info == null) {
            return next.h(method, callOptions);
        }
        Long l = info.f3681a;
        if (l != null) {
            ze newDeadline = ze.a(l.longValue(), TimeUnit.NANOSECONDS);
            ze existingDeadline = callOptions.d();
            if (existingDeadline == null || newDeadline.compareTo(existingDeadline) < 0) {
                callOptions = callOptions.l(newDeadline);
            }
        }
        Boolean bool = info.f3679a;
        if (bool != null) {
            callOptions = bool.booleanValue() ? callOptions.r() : callOptions.s();
        }
        if (info.f3680a != null) {
            Integer existingLimit = callOptions.f();
            if (existingLimit != null) {
                callOptions = callOptions.n(Math.min(existingLimit.intValue(), info.f3680a.intValue()));
            } else {
                callOptions = callOptions.n(info.f3680a.intValue());
            }
        }
        if (info.b != null) {
            Integer existingLimit2 = callOptions.g();
            if (existingLimit2 != null) {
                callOptions = callOptions.o(Math.min(existingLimit2.intValue(), info.b.intValue()));
            } else {
                callOptions = callOptions.o(info.b.intValue());
            }
        }
        return next.h(method, callOptions);
    }

    final class d implements d1.a {
        final /* synthetic */ d1 a;

        d(d1 d1Var) {
            this.a = d1Var;
        }

        public d1 a() {
            return this.a;
        }
    }

    final class c implements j0.a {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ j0 f3414a;

        c(j0 j0Var) {
            this.f3414a = j0Var;
        }

        public j0 a() {
            return this.f3414a;
        }
    }

    final class b implements d1.a {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ m f3413a;

        b(m mVar) {
            this.f3413a = mVar;
        }

        public d1 a() {
            if (!f1.this.f3411b) {
                return d1.a;
            }
            return f1.this.e(this.f3413a);
        }
    }

    final class a implements j0.a {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ m f3412a;

        a(m mVar) {
            this.f3412a = mVar;
        }

        public j0 a() {
            if (!f1.this.f3411b) {
                return j0.a;
            }
            j0 hedgingPolicy = f1.this.c(this.f3412a);
            xu0.a(hedgingPolicy.equals(j0.a) || f1.this.e(this.f3412a).equals(d1.a), "Can not apply both retry and hedging policy for the method '%s'", this.f3412a);
            return hedgingPolicy;
        }
    }

    private s0.a d(m<?, ?> method) {
        s0 mcsc = this.f3409a.get();
        if (mcsc == null) {
            return null;
        }
        s0.a info = mcsc.h().get(method.c());
        if (info == null) {
            info = mcsc.g().get(method.d());
        }
        if (info == null) {
            return mcsc.c();
        }
        return info;
    }

    /* access modifiers changed from: package-private */
    public d1 e(m<?, ?> method) {
        s0.a info = d(method);
        return info == null ? d1.a : info.a;
    }

    /* access modifiers changed from: package-private */
    public j0 c(m<?, ?> method) {
        s0.a info = d(method);
        return info == null ? j0.a : info.f3678a;
    }
}
