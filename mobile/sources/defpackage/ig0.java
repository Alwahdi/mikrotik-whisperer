package defpackage;

import javax.inject.Provider;

/* renamed from: ig0  reason: default package */
public final class ig0 implements ik<hg0> {
    private final Provider<c9> a;
    private final Provider<c9> b;
    private final Provider<ij> c;
    private final Provider<oj0> d;

    public ig0(Provider<c9> wallClockProvider, Provider<c9> clockProvider, Provider<ij> configProvider, Provider<oj0> schemaManagerProvider) {
        this.a = wallClockProvider;
        this.b = clockProvider;
        this.c = configProvider;
        this.d = schemaManagerProvider;
    }

    /* renamed from: b */
    public hg0 get() {
        return new hg0(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }

    public static ig0 a(Provider<c9> wallClockProvider, Provider<c9> clockProvider, Provider<ij> configProvider, Provider<oj0> schemaManagerProvider) {
        return new ig0(wallClockProvider, clockProvider, configProvider, schemaManagerProvider);
    }
}
