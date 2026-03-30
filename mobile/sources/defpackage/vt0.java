package defpackage;

import android.content.Context;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* renamed from: vt0  reason: default package */
public final class vt0 implements ik<ut0> {
    private final Provider<Context> a;
    private final Provider<h5> b;
    private final Provider<hj> c;
    private final Provider<yv0> d;
    private final Provider<Executor> e;
    private final Provider<xo0> f;
    private final Provider<c9> g;

    public vt0(Provider<Context> contextProvider, Provider<h5> backendRegistryProvider, Provider<hj> eventStoreProvider, Provider<yv0> workSchedulerProvider, Provider<Executor> executorProvider, Provider<xo0> guardProvider, Provider<c9> clockProvider) {
        this.a = contextProvider;
        this.b = backendRegistryProvider;
        this.c = eventStoreProvider;
        this.d = workSchedulerProvider;
        this.e = executorProvider;
        this.f = guardProvider;
        this.g = clockProvider;
    }

    /* renamed from: b */
    public ut0 get() {
        return new ut0(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }

    public static vt0 a(Provider<Context> contextProvider, Provider<h5> backendRegistryProvider, Provider<hj> eventStoreProvider, Provider<yv0> workSchedulerProvider, Provider<Executor> executorProvider, Provider<xo0> guardProvider, Provider<c9> clockProvider) {
        return new vt0(contextProvider, backendRegistryProvider, eventStoreProvider, workSchedulerProvider, executorProvider, guardProvider, clockProvider);
    }
}
