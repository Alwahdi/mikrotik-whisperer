package io.grpc.internal;

import io.grpc.internal.p;
import io.grpc.internal.t0;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;
import java.util.concurrent.Executor;

abstract class d0 implements bc {
    /* access modifiers changed from: protected */
    public abstract bc a();

    d0() {
    }

    public Runnable d(t0.a listener) {
        return a().d(listener);
    }

    public void e(p status) {
        a().e(status);
    }

    public void c(p status) {
        a().c(status);
    }

    public z8 f(m<?, ?> method, l headers, n7 callOptions) {
        return a().f(method, headers, callOptions);
    }

    public void g(p.a callback, Executor executor) {
        a().g(callback, executor);
    }

    public hu b() {
        return a().b();
    }

    public String toString() {
        return f20.c(this).d("delegate", a()).toString();
    }
}
