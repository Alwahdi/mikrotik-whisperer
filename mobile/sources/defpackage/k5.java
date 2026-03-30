package defpackage;

/* renamed from: k5  reason: default package */
final /* synthetic */ class k5 implements Runnable {
    private final Runnable a;

    /* renamed from: a  reason: collision with other field name */
    private final l5 f4097a;

    private k5(l5 l5Var, Runnable runnable) {
        this.f4097a = l5Var;
        this.a = runnable;
    }

    public static Runnable a(l5 l5Var, Runnable runnable) {
        return new k5(l5Var, runnable);
    }

    public void run() {
        l5.b(this.f4097a, this.a);
    }
}
