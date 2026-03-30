package defpackage;

/* renamed from: ou0  reason: default package */
final /* synthetic */ class ou0 implements Runnable {
    private final RuntimeException a;

    private ou0(RuntimeException runtimeException) {
        this.a = runtimeException;
    }

    public static Runnable a(RuntimeException runtimeException) {
        return new ou0(runtimeException);
    }

    public void run() {
        qu0.k(this.a);
    }
}
