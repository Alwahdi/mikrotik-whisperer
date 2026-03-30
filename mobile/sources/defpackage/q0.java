package defpackage;

/* renamed from: q0  reason: default package */
final /* synthetic */ class q0 implements Runnable {
    private final rx a;

    private q0(rx rxVar) {
        this.a = rxVar;
    }

    public static Runnable a(rx rxVar) {
        return new q0(rxVar);
    }

    public void run() {
        this.a.remove();
    }
}
