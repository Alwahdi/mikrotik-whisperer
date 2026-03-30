package defpackage;

/* renamed from: x81  reason: default package */
final class x81 implements Runnable {
    private final /* synthetic */ eq0 a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ u81 f5576a;

    x81(u81 u81, eq0 eq0) {
        this.f5576a = u81;
        this.a = eq0;
    }

    public final void run() {
        synchronized (this.f5576a.a) {
            if (this.f5576a.f5236a != null) {
                this.f5576a.f5236a.e(this.a.n());
            }
        }
    }
}
