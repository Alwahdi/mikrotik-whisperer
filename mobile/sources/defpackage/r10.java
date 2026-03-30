package defpackage;

import android.content.Context;
import javax.inject.Provider;

/* renamed from: r10  reason: default package */
public final class r10 implements ik<q10> {
    private final Provider<Context> a;
    private final Provider<sd> b;

    public r10(Provider<Context> applicationContextProvider, Provider<sd> creationContextFactoryProvider) {
        this.a = applicationContextProvider;
        this.b = creationContextFactoryProvider;
    }

    /* renamed from: b */
    public q10 get() {
        return new q10(this.a.get(), this.b.get());
    }

    public static r10 a(Provider<Context> applicationContextProvider, Provider<sd> creationContextFactoryProvider) {
        return new r10(applicationContextProvider, creationContextFactoryProvider);
    }
}
