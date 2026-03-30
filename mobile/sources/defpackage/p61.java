package defpackage;

/* renamed from: p61  reason: default package */
final class p61 implements Runnable {
    private final /* synthetic */ e61 a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ y51 f4682a;

    p61(y51 y51, e61 e61) {
        this.f4682a = y51;
        this.a = e61;
    }

    public final void run() {
        synchronized (this.f4682a.a.f5441a) {
            if (!this.f4682a.a.f5441a.isEmpty()) {
                this.a.a(this.f4682a.a.f5441a.get(0), new Object[0]);
            }
        }
    }
}
