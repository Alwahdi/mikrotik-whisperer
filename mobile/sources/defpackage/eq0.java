package defpackage;

import android.app.Activity;
import java.util.concurrent.Executor;

/* renamed from: eq0  reason: default package */
public abstract class eq0<TResult> {
    public abstract eq0<TResult> a(Executor executor, n40 n40);

    public abstract eq0<TResult> b(o40<TResult> o40);

    public abstract eq0<TResult> c(Activity activity, o40<TResult> o40);

    public abstract eq0<TResult> d(Executor executor, o40<TResult> o40);

    public abstract eq0<TResult> e(r40 r40);

    public abstract eq0<TResult> f(Executor executor, r40 r40);

    public abstract eq0<TResult> g(t40<? super TResult> t40);

    public abstract eq0<TResult> h(Executor executor, t40<? super TResult> t40);

    public abstract <TContinuationResult> eq0<TContinuationResult> i(sc<TResult, TContinuationResult> scVar);

    public abstract <TContinuationResult> eq0<TContinuationResult> j(Executor executor, sc<TResult, TContinuationResult> scVar);

    public abstract <TContinuationResult> eq0<TContinuationResult> k(sc<TResult, eq0<TContinuationResult>> scVar);

    public abstract <TContinuationResult> eq0<TContinuationResult> l(Executor executor, sc<TResult, eq0<TContinuationResult>> scVar);

    public abstract Exception m();

    public abstract TResult n();

    public abstract <X extends Throwable> TResult o(Class<X> cls);

    public abstract boolean p();

    public abstract boolean q();

    public abstract boolean r();

    public abstract <TContinuationResult> eq0<TContinuationResult> s(Executor executor, lo0<TResult, TContinuationResult> lo0);
}
