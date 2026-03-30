package defpackage;

import java.util.concurrent.Executor;

/* renamed from: m81  reason: default package */
final class m81<TResult> implements j91<TResult> {
    /* access modifiers changed from: private */
    public final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final Executor f4320a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public r40 f4321a;

    public m81(Executor executor, r40 r40) {
        this.f4320a = executor;
        this.f4321a = r40;
    }

    public final void a(eq0<TResult> eq0) {
        if (!eq0.r() && !eq0.p()) {
            synchronized (this.a) {
                if (this.f4321a != null) {
                    this.f4320a.execute(new q81(this, eq0));
                }
            }
        }
    }

    public final void cancel() {
        synchronized (this.a) {
            this.f4321a = null;
        }
    }
}
