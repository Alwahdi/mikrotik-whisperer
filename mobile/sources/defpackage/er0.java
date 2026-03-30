package defpackage;

/* renamed from: er0  reason: default package */
final /* synthetic */ class er0 implements Runnable {
    private final fr0 a;

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f2924a;

    private er0(fr0 fr0, Runnable runnable) {
        this.a = fr0;
        this.f2924a = runnable;
    }

    public static Runnable a(fr0 fr0, Runnable runnable) {
        return new er0(fr0, runnable);
    }

    public void run() {
        fr0.a(this.a, this.f2924a);
    }
}
