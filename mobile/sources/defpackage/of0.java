package defpackage;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* renamed from: of0  reason: default package */
public abstract class of0 {
    static volatile h6<? super km, ? super ho0, ? extends ho0> a;

    /* renamed from: a  reason: collision with other field name */
    static volatile ic<? super Throwable> f4533a;

    /* renamed from: a  reason: collision with other field name */
    static volatile mo<? super Runnable, ? extends Runnable> f4534a;
    static volatile h6<? super vl0, ? super zl0, ? extends zl0> b;

    /* renamed from: b  reason: collision with other field name */
    static volatile mo<? super Callable<bj0>, ? extends bj0> f4535b;
    static volatile mo<? super Callable<bj0>, ? extends bj0> c;
    static volatile mo<? super Callable<bj0>, ? extends bj0> d;
    static volatile mo<? super Callable<bj0>, ? extends bj0> e;
    static volatile mo<? super bj0, ? extends bj0> f;
    static volatile mo<? super km, ? extends km> g;
    static volatile mo<? super vl0, ? extends vl0> h;

    public static bj0 e(Callable<bj0> defaultScheduler) {
        a40.c(defaultScheduler, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> f2 = f4535b;
        if (f2 == null) {
            return d(defaultScheduler);
        }
        return c(f2, defaultScheduler);
    }

    public static bj0 f(Callable<bj0> defaultScheduler) {
        a40.c(defaultScheduler, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> f2 = d;
        if (f2 == null) {
            return d(defaultScheduler);
        }
        return c(f2, defaultScheduler);
    }

    public static bj0 g(Callable<bj0> defaultScheduler) {
        a40.c(defaultScheduler, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> f2 = e;
        if (f2 == null) {
            return d(defaultScheduler);
        }
        return c(f2, defaultScheduler);
    }

    public static bj0 h(Callable<bj0> defaultScheduler) {
        a40.c(defaultScheduler, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> f2 = c;
        if (f2 == null) {
            return d(defaultScheduler);
        }
        return c(f2, defaultScheduler);
    }

    public static void l(Throwable error) {
        Consumer<? super Throwable> f2 = f4533a;
        if (error == null) {
            error = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(error)) {
            error = new dt0(error);
        }
        if (f2 != null) {
            try {
                f2.accept(error);
                return;
            } catch (Throwable e2) {
                e2.printStackTrace();
                q(e2);
            }
        }
        error.printStackTrace();
        q(error);
    }

    static boolean i(Throwable error) {
        if (!(error instanceof q40) && !(error instanceof a20) && !(error instanceof IllegalStateException) && !(error instanceof NullPointerException) && !(error instanceof IllegalArgumentException) && !(error instanceof rb)) {
            return false;
        }
        return true;
    }

    static void q(Throwable error) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    public static bj0 m(bj0 defaultScheduler) {
        Function<? super Scheduler, ? extends Scheduler> f2 = f;
        if (f2 == null) {
            return defaultScheduler;
        }
        return (bj0) b(f2, defaultScheduler);
    }

    public static Runnable n(Runnable run) {
        a40.c(run, "run is null");
        Function<? super Runnable, ? extends Runnable> f2 = f4534a;
        if (f2 == null) {
            return run;
        }
        return (Runnable) b(f2, run);
    }

    public static <T> ho0<? super T> p(km<T> source, ho0<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> f2 = a;
        if (f2 != null) {
            return (ho0) a(f2, source, subscriber);
        }
        return subscriber;
    }

    public static <T> zl0<? super T> o(vl0<T> source, zl0<? super T> observer) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> f2 = b;
        if (f2 != null) {
            return (zl0) a(f2, source, observer);
        }
        return observer;
    }

    public static <T> km<T> j(km<T> source) {
        Function<? super Flowable, ? extends Flowable> f2 = g;
        if (f2 != null) {
            return (km) b(f2, source);
        }
        return source;
    }

    public static <T> vl0<T> k(vl0<T> source) {
        Function<? super Single, ? extends Single> f2 = h;
        if (f2 != null) {
            return (vl0) b(f2, source);
        }
        return source;
    }

    static <T, R> R b(mo<T, R> f2, T t) {
        try {
            return f2.apply(t);
        } catch (Throwable ex) {
            throw nj.d(ex);
        }
    }

    static <T, U, R> R a(h6<T, U, R> f2, T t, U u) {
        try {
            return f2.a(t, u);
        } catch (Throwable ex) {
            throw nj.d(ex);
        }
    }

    static bj0 d(Callable<bj0> s) {
        try {
            return (bj0) a40.c(s.call(), "Scheduler Callable result can't be null");
        } catch (Throwable ex) {
            throw nj.d(ex);
        }
    }

    static bj0 c(mo<? super Callable<bj0>, ? extends bj0> f2, Callable<bj0> s) {
        return (bj0) a40.c(b(f2, s), "Scheduler Callable result can't be null");
    }
}
