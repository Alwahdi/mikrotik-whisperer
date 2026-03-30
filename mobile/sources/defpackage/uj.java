package defpackage;

import java.util.concurrent.Executor;

/* renamed from: uj  reason: default package */
public final class uj implements ik<Executor> {
    private static final uj a = new uj();

    /* renamed from: c */
    public Executor get() {
        return b();
    }

    public static uj a() {
        return a;
    }

    public static Executor b() {
        return (Executor) x90.c(tj.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
