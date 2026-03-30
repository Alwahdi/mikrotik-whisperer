package defpackage;

import java.util.concurrent.Callable;

/* renamed from: cn  reason: default package */
public abstract class cn {
    public static <T, R> boolean b(rb0<T> source, ho0<? super R> subscriber, mo<? super T, ? extends rb0<? extends R>> mapper) {
        if (!(source instanceof Callable)) {
            return false;
        }
        try {
            T t = ((Callable) source).call();
            if (t == null) {
                io.reactivex.internal.subscriptions.a.complete(subscriber);
                return true;
            }
            try {
                rb0 rb0 = (rb0) a40.c(mapper.apply(t), "The mapper returned a null Publisher");
                if (rb0 instanceof Callable) {
                    try {
                        R u = ((Callable) rb0).call();
                        if (u == null) {
                            io.reactivex.internal.subscriptions.a.complete(subscriber);
                            return true;
                        }
                        subscriber.d(new xi0(subscriber, u));
                    } catch (Throwable ex) {
                        oj.b(ex);
                        io.reactivex.internal.subscriptions.a.error(ex, subscriber);
                        return true;
                    }
                } else {
                    rb0.a(subscriber);
                }
                return true;
            } catch (Throwable ex2) {
                oj.b(ex2);
                io.reactivex.internal.subscriptions.a.error(ex2, subscriber);
                return true;
            }
        } catch (Throwable ex3) {
            oj.b(ex3);
            io.reactivex.internal.subscriptions.a.error(ex3, subscriber);
            return true;
        }
    }

    public static <T, U> km<U> a(T value, mo<? super T, ? extends rb0<? extends U>> mapper) {
        return of0.j(new a(value, mapper));
    }

    /* renamed from: cn$a */
    static final class a<T, R> extends km<R> {
        final T a;

        /* renamed from: a  reason: collision with other field name */
        final mo<? super T, ? extends rb0<? extends R>> f344a;

        a(T value, mo<? super T, ? extends rb0<? extends R>> mapper) {
            this.a = value;
            this.f344a = mapper;
        }

        public void z(ho0<? super R> s) {
            try {
                rb0 rb0 = (rb0) a40.c(this.f344a.apply(this.a), "The mapper returned a null Publisher");
                if (rb0 instanceof Callable) {
                    try {
                        R u = ((Callable) rb0).call();
                        if (u == null) {
                            io.reactivex.internal.subscriptions.a.complete(s);
                        } else {
                            s.d(new xi0(s, u));
                        }
                    } catch (Throwable ex) {
                        oj.b(ex);
                        io.reactivex.internal.subscriptions.a.error(ex, s);
                    }
                } else {
                    rb0.a(s);
                }
            } catch (Throwable e) {
                io.reactivex.internal.subscriptions.a.error(e, s);
            }
        }
    }
}
