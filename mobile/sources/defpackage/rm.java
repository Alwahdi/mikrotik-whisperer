package defpackage;

import io.reactivex.internal.subscriptions.a;
import java.util.concurrent.Callable;

/* renamed from: rm  reason: default package */
public final class rm<T> extends km<T> {
    final Callable<? extends Throwable> a;

    public rm(Callable<? extends Throwable> errorSupplier) {
        this.a = errorSupplier;
    }

    public void z(ho0<? super T> s) {
        try {
            t = (Throwable) a40.c(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            t = th;
            oj.b(t);
            Throwable th2 = t;
        }
        a.error(t, s);
    }
}
