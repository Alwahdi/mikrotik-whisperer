package defpackage;

import java.util.concurrent.Executor;

/* renamed from: u81  reason: default package */
final class u81<TResult> implements j91<TResult> {
    /* access modifiers changed from: private */
    public final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final Executor f5235a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public t40<? super TResult> f5236a;

    public u81(Executor executor, t40<? super TResult> t40) {
        this.f5235a = executor;
        this.f5236a = t40;
    }

    public final void a(eq0<TResult> eq0) {
        if (eq0.r()) {
            synchronized (this.a) {
                if (this.f5236a != null) {
                    this.f5235a.execute(new x81(this, eq0));
                }
            }
        }
    }

    public final void cancel() {
        synchronized (this.a) {
            this.f5236a = null;
        }
    }
}
