package defpackage;

import io.reactivex.SingleObserver;

/* renamed from: vl0  reason: default package */
public abstract class vl0<T> implements bm0<T> {
    /* access modifiers changed from: protected */
    public abstract void f(zl0<? super T> zl0);

    public static <T> vl0<T> c(T item) {
        a40.c(item, "value is null");
        return of0.k(new wl0(item));
    }

    public final <R> vl0<R> d(mo<? super T, ? extends R> mapper) {
        a40.c(mapper, "mapper is null");
        return of0.k(new xl0(this, mapper));
    }

    public final vl0<T> e(bj0 scheduler) {
        a40.c(scheduler, "scheduler is null");
        return of0.k(new yl0(this, scheduler));
    }

    public final void b(zl0<? super T> subscriber) {
        a40.c(subscriber, "subscriber is null");
        SingleObserver<? super T> subscriber2 = of0.o(this, subscriber);
        a40.c(subscriber2, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            f(subscriber2);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            oj.b(ex2);
            NullPointerException npe = new NullPointerException("subscribeActual failed");
            npe.initCause(ex2);
            throw npe;
        }
    }

    public final <E extends zl0<? super T>> E h(E observer) {
        b(observer);
        return observer;
    }

    public final vl0<T> g(bj0 scheduler) {
        a40.c(scheduler, "scheduler is null");
        return of0.k(new cm0(this, scheduler));
    }

    public final km<T> i() {
        if (this instanceof zo) {
            return ((zo) this).a();
        }
        return of0.j(new dm0(this));
    }
}
