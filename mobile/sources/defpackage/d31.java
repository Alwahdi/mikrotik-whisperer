package defpackage;

import java.util.concurrent.Executor;

/* renamed from: d31  reason: default package */
final class d31<TResult, TContinuationResult> implements j91<TResult> {
    private final Executor a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final sc<TResult, TContinuationResult> f2704a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final v91<TContinuationResult> f2705a;

    public d31(Executor executor, sc<TResult, TContinuationResult> scVar, v91<TContinuationResult> v91) {
        this.a = executor;
        this.f2704a = scVar;
        this.f2705a = v91;
    }

    public final void a(eq0<TResult> eq0) {
        this.a.execute(new g41(this, eq0));
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }
}
