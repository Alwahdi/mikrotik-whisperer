package defpackage;

import io.reactivex.a;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* renamed from: km  reason: default package */
public abstract class km<T> implements rb0<T> {
    static final int a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    /* access modifiers changed from: protected */
    public abstract void z(ho0<? super T> ho0);

    public static int b() {
        return a;
    }

    public static <T> km<T> d(zm<T> source, a mode) {
        a40.c(source, "source is null");
        a40.c(mode, "mode is null");
        return of0.j(new lm(source, mode));
    }

    public static <T> km<T> i() {
        return of0.j(qm.a);
    }

    public static <T> km<T> k(Callable<? extends Throwable> supplier) {
        a40.c(supplier, "errorSupplier is null");
        return of0.j(new rm(supplier));
    }

    public static <T> km<T> j(Throwable throwable) {
        a40.c(throwable, "throwable is null");
        return k(yo.c(throwable));
    }

    public static <T> km<T> p(T... items) {
        a40.c(items, "items is null");
        if (items.length == 0) {
            return i();
        }
        if (items.length == 1) {
            return r(items[0]);
        }
        return of0.j(new um(items));
    }

    public static <T> km<T> q(rb0<? extends T> source) {
        if (source instanceof km) {
            return of0.j((km) source);
        }
        a40.c(source, "publisher is null");
        return of0.j(new vm(source));
    }

    public static <T> km<T> r(T item) {
        a40.c(item, "item is null");
        return of0.j(new wm(item));
    }

    public final <R> km<R> c(in<? super T, ? extends R> composer) {
        return q(((in) a40.c(composer, "composer is null")).a(this));
    }

    private km<T> e(ic<? super T> onNext, ic<? super Throwable> onError, k0 onComplete, k0 onAfterTerminate) {
        a40.c(onNext, "onNext is null");
        a40.c(onError, "onError is null");
        a40.c(onComplete, "onComplete is null");
        a40.c(onAfterTerminate, "onAfterTerminate is null");
        return of0.j(new mm(this, onNext, onError, onComplete, onAfterTerminate));
    }

    public final km<T> f(ic<? super Throwable> onError) {
        ic b = yo.b();
        k0 k0Var = yo.f5912a;
        return e(b, onError, k0Var, k0Var);
    }

    public final km<T> g(ic<? super T> onNext) {
        ic b = yo.b();
        k0 k0Var = yo.f5912a;
        return e(onNext, b, k0Var, k0Var);
    }

    public final vl0<T> h(long index) {
        if (index >= 0) {
            return of0.k(new om(this, index, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + index);
    }

    public final km<T> l(ga0<? super T> predicate) {
        a40.c(predicate, "predicate is null");
        return of0.j(new sm(this, predicate));
    }

    public final vl0<T> m() {
        return h(0);
    }

    public final <R> km<R> n(mo<? super T, ? extends rb0<? extends R>> mapper) {
        return o(mapper, false, b(), b());
    }

    public final <R> km<R> o(mo<? super T, ? extends rb0<? extends R>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        a40.c(mapper, "mapper is null");
        a40.d(maxConcurrency, "maxConcurrency");
        a40.d(bufferSize, "bufferSize");
        if (!(this instanceof wi0)) {
            return of0.j(new tm(this, mapper, delayErrors, maxConcurrency, bufferSize));
        }
        T v = ((wi0) this).call();
        if (v == null) {
            return i();
        }
        return cn.a(v, mapper);
    }

    public final <R> km<R> s(mo<? super T, ? extends R> mapper) {
        a40.c(mapper, "mapper is null");
        return of0.j(new xm(this, mapper));
    }

    public final km<T> t(bj0 scheduler) {
        return u(scheduler, false, b());
    }

    public final km<T> u(bj0 scheduler, boolean delayError, int bufferSize) {
        a40.c(scheduler, "scheduler is null");
        a40.d(bufferSize, "bufferSize");
        return of0.j(new ym(this, scheduler, delayError, bufferSize));
    }

    public final km<T> v(long times) {
        if (times < 0) {
            throw new IllegalArgumentException("times >= 0 required but it was " + times);
        } else if (times == 0) {
            return i();
        } else {
            return of0.j(new an(this, times));
        }
    }

    public final km<T> w(long count) {
        return x(count, yo.a());
    }

    public final km<T> x(long times, ga0<? super Throwable> predicate) {
        if (times >= 0) {
            a40.c(predicate, "predicate is null");
            return of0.j(new bn(this, times, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + times);
    }

    public final void a(ho0<? super T> s) {
        if (s instanceof en) {
            y((en) s);
            return;
        }
        a40.c(s, "s is null");
        y(new on0(s));
    }

    public final void y(en<? super T> s) {
        a40.c(s, "s is null");
        try {
            Subscriber<? super T> z = of0.p(this, s);
            a40.c(z, "Plugin returned null Subscriber");
            z(z);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable e2) {
            oj.b(e2);
            of0.l(e2);
            NullPointerException npe = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            npe.initCause(e2);
            throw npe;
        }
    }

    public final km<T> A(bj0 scheduler) {
        a40.c(scheduler, "scheduler is null");
        return B(scheduler, !(this instanceof lm));
    }

    public final km<T> B(bj0 scheduler, boolean requestOn) {
        a40.c(scheduler, "scheduler is null");
        return of0.j(new dn(this, scheduler, requestOn));
    }

    public final km<T> C(long count) {
        if (count >= 0) {
            return of0.j(new fn(this, count));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + count);
    }

    public final vl0<List<T>> D() {
        return of0.k(new hn(this));
    }
}
