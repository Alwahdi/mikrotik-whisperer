package defpackage;

import java.util.concurrent.Executor;

/* renamed from: a91  reason: default package */
final class a91<TResult, TContinuationResult> implements n40, r40, t40<TContinuationResult>, j91<TResult> {
    private final Executor a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final lo0<TResult, TContinuationResult> f37a;

    /* renamed from: a  reason: collision with other field name */
    private final v91<TContinuationResult> f38a;

    public a91(Executor executor, lo0<TResult, TContinuationResult> lo0, v91<TContinuationResult> v91) {
        this.a = executor;
        this.f37a = lo0;
        this.f38a = v91;
    }

    public final void a(eq0<TResult> eq0) {
        this.a.execute(new f91(this, eq0));
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void e(TContinuationResult tcontinuationresult) {
        this.f38a.u(tcontinuationresult);
    }

    public final void b(Exception exc) {
        this.f38a.t(exc);
    }

    public final void c() {
        this.f38a.x();
    }
}
