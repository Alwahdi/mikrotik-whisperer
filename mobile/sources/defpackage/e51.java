package defpackage;

import java.util.concurrent.Executor;

/* renamed from: e51  reason: default package */
final class e51<TResult, TContinuationResult> implements n40, r40, t40<TContinuationResult>, j91<TResult> {
    private final Executor a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final sc<TResult, eq0<TContinuationResult>> f2855a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final v91<TContinuationResult> f2856a;

    public e51(Executor executor, sc<TResult, eq0<TContinuationResult>> scVar, v91<TContinuationResult> v91) {
        this.a = executor;
        this.f2855a = scVar;
        this.f2856a = v91;
    }

    public final void a(eq0<TResult> eq0) {
        this.a.execute(new k61(this, eq0));
    }

    public final void e(TContinuationResult tcontinuationresult) {
        this.f2856a.u(tcontinuationresult);
    }

    public final void b(Exception exc) {
        this.f2856a.t(exc);
    }

    public final void c() {
        this.f2856a.x();
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }
}
