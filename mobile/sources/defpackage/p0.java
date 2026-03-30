package defpackage;

/* renamed from: p0  reason: default package */
final /* synthetic */ class p0 implements Runnable {
    private final rx a;

    private p0(rx rxVar) {
        this.a = rxVar;
    }

    public static Runnable a(rx rxVar) {
        return new p0(rxVar);
    }

    public void run() {
        this.a.remove();
    }
}
