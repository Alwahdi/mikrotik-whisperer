package defpackage;

/* renamed from: g41  reason: default package */
final class g41 implements Runnable {
    private final /* synthetic */ d31 a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ eq0 f3009a;

    g41(d31 d31, eq0 eq0) {
        this.a = d31;
        this.f3009a = eq0;
    }

    public final void run() {
        if (this.f3009a.p()) {
            this.a.f2705a.x();
            return;
        }
        try {
            this.a.f2705a.u(this.a.f2704a.a(this.f3009a));
        } catch (mf0 e) {
            if (e.getCause() instanceof Exception) {
                this.a.f2705a.t((Exception) e.getCause());
            } else {
                this.a.f2705a.t(e);
            }
        } catch (Exception e2) {
            this.a.f2705a.t(e2);
        }
    }
}
