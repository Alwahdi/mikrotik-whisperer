package defpackage;

/* renamed from: q81  reason: default package */
final class q81 implements Runnable {
    private final /* synthetic */ eq0 a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ m81 f4794a;

    q81(m81 m81, eq0 eq0) {
        this.f4794a = m81;
        this.a = eq0;
    }

    public final void run() {
        synchronized (this.f4794a.a) {
            if (this.f4794a.f4321a != null) {
                this.f4794a.f4321a.b(this.a.m());
            }
        }
    }
}
