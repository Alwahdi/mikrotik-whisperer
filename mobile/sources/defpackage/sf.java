package defpackage;

import java.util.concurrent.Executor;
import javax.inject.Provider;

/* renamed from: sf  reason: default package */
public final class sf implements ik<rf> {
    private final Provider<Executor> a;
    private final Provider<h5> b;
    private final Provider<yv0> c;
    private final Provider<hj> d;
    private final Provider<xo0> e;

    public sf(Provider<Executor> executorProvider, Provider<h5> backendRegistryProvider, Provider<yv0> workSchedulerProvider, Provider<hj> eventStoreProvider, Provider<xo0> guardProvider) {
        this.a = executorProvider;
        this.b = backendRegistryProvider;
        this.c = workSchedulerProvider;
        this.d = eventStoreProvider;
        this.e = guardProvider;
    }

    /* renamed from: b */
    public rf get() {
        return new rf(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }

    public static sf a(Provider<Executor> executorProvider, Provider<h5> backendRegistryProvider, Provider<yv0> workSchedulerProvider, Provider<hj> eventStoreProvider, Provider<xo0> guardProvider) {
        return new sf(executorProvider, backendRegistryProvider, workSchedulerProvider, eventStoreProvider, guardProvider);
    }
}
