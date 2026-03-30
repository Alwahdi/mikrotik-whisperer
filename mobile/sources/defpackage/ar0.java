package defpackage;

/* renamed from: ar0  reason: default package */
public final class ar0 {
    public static final ar0 a = new ar0();

    /* renamed from: a  reason: collision with other field name */
    private static final ThreadLocal<cj> f121a = new ThreadLocal<>();

    private ar0() {
    }

    public final cj a() {
        ThreadLocal<cj> threadLocal = f121a;
        cj cjVar = threadLocal.get();
        if (cjVar != null) {
            return cjVar;
        }
        cj it = fj.a();
        threadLocal.set(it);
        return it;
    }

    public final void b() {
        f121a.set((Object) null);
    }

    public final void c(cj eventLoop) {
        f121a.set(eventLoop);
    }
}
