package defpackage;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import javax.inject.Provider;

/* renamed from: kj0  reason: default package */
public final class kj0 implements ik<yv0> {
    private final Provider<Context> a;
    private final Provider<hj> b;
    private final Provider<e> c;
    private final Provider<c9> d;

    public kj0(Provider<Context> contextProvider, Provider<hj> eventStoreProvider, Provider<e> configProvider, Provider<c9> clockProvider) {
        this.a = contextProvider;
        this.b = eventStoreProvider;
        this.c = configProvider;
        this.d = clockProvider;
    }

    /* renamed from: b */
    public yv0 get() {
        return c(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }

    public static kj0 a(Provider<Context> contextProvider, Provider<hj> eventStoreProvider, Provider<e> configProvider, Provider<c9> clockProvider) {
        return new kj0(contextProvider, eventStoreProvider, configProvider, clockProvider);
    }

    public static yv0 c(Context context, hj eventStore, e config, c9 clock) {
        return (yv0) x90.c(jj0.a(context, eventStore, config, clock), "Cannot return null from a non-@Nullable @Provides method");
    }
}
