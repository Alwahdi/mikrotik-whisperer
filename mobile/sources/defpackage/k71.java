package defpackage;

import java.util.concurrent.Executor;

/* renamed from: k71  reason: default package */
final class k71<TResult> implements j91<TResult> {
    /* access modifiers changed from: private */
    public final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final Executor f4106a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public n40 f4107a;

    public k71(Executor executor, n40 n40) {
        this.f4106a = executor;
        this.f4107a = n40;
    }

    public final void a(eq0 eq0) {
        if (eq0.p()) {
            synchronized (this.a) {
                if (this.f4107a != null) {
                    this.f4106a.execute(new s71(this));
                }
            }
        }
    }

    public final void cancel() {
        synchronized (this.a) {
            this.f4107a = null;
        }
    }
}
