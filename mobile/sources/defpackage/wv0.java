package defpackage;

import java.util.concurrent.Executor;
import javax.inject.Provider;

/* renamed from: wv0  reason: default package */
public final class wv0 implements ik<vv0> {
    private final Provider<Executor> a;
    private final Provider<hj> b;
    private final Provider<yv0> c;
    private final Provider<xo0> d;

    public wv0(Provider<Executor> executorProvider, Provider<hj> storeProvider, Provider<yv0> schedulerProvider, Provider<xo0> guardProvider) {
        this.a = executorProvider;
        this.b = storeProvider;
        this.c = schedulerProvider;
        this.d = guardProvider;
    }

    /* renamed from: b */
    public vv0 get() {
        return new vv0(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }

    public static wv0 a(Provider<Executor> executorProvider, Provider<hj> storeProvider, Provider<yv0> schedulerProvider, Provider<xo0> guardProvider) {
        return new wv0(executorProvider, storeProvider, schedulerProvider, guardProvider);
    }
}
