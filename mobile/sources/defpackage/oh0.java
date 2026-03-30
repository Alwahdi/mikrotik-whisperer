package defpackage;

/* renamed from: oh0  reason: default package */
final /* synthetic */ class oh0 implements Runnable {
    private final xh0 a;

    private oh0(xh0 xh0) {
        this.a = xh0;
    }

    public static Runnable a(xh0 xh0) {
        return new oh0(xh0);
    }

    public void run() {
        xh0.q(this.a);
    }
}
