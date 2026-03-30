package defpackage;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import javax.inject.Provider;

/* renamed from: ij0  reason: default package */
public final class ij0 implements ik<e> {
    private final Provider<c9> a;

    public ij0(Provider<c9> clockProvider) {
        this.a = clockProvider;
    }

    /* renamed from: c */
    public e get() {
        return a(this.a.get());
    }

    public static ij0 b(Provider<c9> clockProvider) {
        return new ij0(clockProvider);
    }

    public static e a(c9 clock) {
        return (e) x90.c(hj0.a(clock), "Cannot return null from a non-@Nullable @Provides method");
    }
}
