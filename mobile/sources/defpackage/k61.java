package defpackage;

import java.util.concurrent.Executor;

/* renamed from: k61  reason: default package */
final class k61 implements Runnable {
    private final /* synthetic */ e51 a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ eq0 f4105a;

    k61(e51 e51, eq0 eq0) {
        this.a = e51;
        this.f4105a = eq0;
    }

    public final void run() {
        try {
            eq0 eq0 = (eq0) this.a.f2855a.a(this.f4105a);
            if (eq0 == null) {
                this.a.b(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = jq0.b;
            eq0.h(executor, this.a);
            eq0.f(executor, this.a);
            eq0.a(executor, this.a);
        } catch (mf0 e) {
            if (e.getCause() instanceof Exception) {
                this.a.f2856a.t((Exception) e.getCause());
            } else {
                this.a.f2856a.t(e);
            }
        } catch (Exception e2) {
            this.a.f2856a.t(e2);
        }
    }
}
