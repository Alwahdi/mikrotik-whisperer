package defpackage;

import android.content.Context;
import javax.inject.Provider;

/* renamed from: td  reason: default package */
public final class td implements ik<sd> {
    private final Provider<Context> a;
    private final Provider<c9> b;
    private final Provider<c9> c;

    public td(Provider<Context> applicationContextProvider, Provider<c9> wallClockProvider, Provider<c9> monotonicClockProvider) {
        this.a = applicationContextProvider;
        this.b = wallClockProvider;
        this.c = monotonicClockProvider;
    }

    /* renamed from: b */
    public sd get() {
        return new sd(this.a.get(), this.b.get(), this.c.get());
    }

    public static td a(Provider<Context> applicationContextProvider, Provider<c9> wallClockProvider, Provider<c9> monotonicClockProvider) {
        return new td(applicationContextProvider, wallClockProvider, monotonicClockProvider);
    }
}
