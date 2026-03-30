package defpackage;

import java.util.concurrent.Executor;

/* renamed from: a81  reason: default package */
final class a81<TResult> implements j91<TResult> {
    /* access modifiers changed from: private */
    public final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final Executor f33a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public o40<TResult> f34a;

    public a81(Executor executor, o40<TResult> o40) {
        this.f33a = executor;
        this.f34a = o40;
    }

    public final void a(eq0<TResult> eq0) {
        synchronized (this.a) {
            if (this.f34a != null) {
                this.f33a.execute(new h81(this, eq0));
            }
        }
    }

    public final void cancel() {
        synchronized (this.a) {
            this.f34a = null;
        }
    }
}
