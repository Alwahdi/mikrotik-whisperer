package defpackage;

/* renamed from: qh0  reason: default package */
final /* synthetic */ class qh0 implements Runnable {
    private final xh0 a;

    private qh0(xh0 xh0) {
        this.a = xh0;
    }

    public static Runnable a(xh0 xh0) {
        return new qh0(xh0);
    }

    public void run() {
        xh0.s(this.a);
    }
}
