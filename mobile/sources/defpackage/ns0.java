package defpackage;

import javax.inject.Provider;

/* renamed from: ns0  reason: default package */
public final class ns0 implements ik<ls0> {
    private final Provider<c9> a;
    private final Provider<c9> b;
    private final Provider<cj0> c;
    private final Provider<ut0> d;
    private final Provider<vv0> e;

    public ns0(Provider<c9> eventClockProvider, Provider<c9> uptimeClockProvider, Provider<cj0> schedulerProvider, Provider<ut0> uploaderProvider, Provider<vv0> initializerProvider) {
        this.a = eventClockProvider;
        this.b = uptimeClockProvider;
        this.c = schedulerProvider;
        this.d = uploaderProvider;
        this.e = initializerProvider;
    }

    /* renamed from: b */
    public ls0 get() {
        return new ls0(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }

    public static ns0 a(Provider<c9> eventClockProvider, Provider<c9> uptimeClockProvider, Provider<cj0> schedulerProvider, Provider<ut0> uploaderProvider, Provider<vv0> initializerProvider) {
        return new ns0(eventClockProvider, uptimeClockProvider, schedulerProvider, uploaderProvider, initializerProvider);
    }
}
