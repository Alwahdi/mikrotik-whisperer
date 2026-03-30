package defpackage;

/* renamed from: s71  reason: default package */
final class s71 implements Runnable {
    private final /* synthetic */ k71 a;

    s71(k71 k71) {
        this.a = k71;
    }

    public final void run() {
        synchronized (this.a.a) {
            if (this.a.f4107a != null) {
                this.a.f4107a.c();
            }
        }
    }
}
