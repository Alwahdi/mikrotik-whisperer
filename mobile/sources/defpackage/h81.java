package defpackage;

/* renamed from: h81  reason: default package */
final class h81 implements Runnable {
    private final /* synthetic */ a81 a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ eq0 f3152a;

    h81(a81 a81, eq0 eq0) {
        this.a = a81;
        this.f3152a = eq0;
    }

    public final void run() {
        synchronized (this.a.a) {
            if (this.a.f34a != null) {
                this.a.f34a.a(this.f3152a);
            }
        }
    }
}
