package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: hq  reason: default package */
public abstract class hq {
    public static <T> void c(ho0<? super T> subscriber, T value, AtomicInteger wip, u4 error) {
        if (wip.get() == 0 && wip.compareAndSet(0, 1)) {
            subscriber.c(value);
            if (wip.decrementAndGet() != 0) {
                Throwable ex = error.b();
                if (ex != null) {
                    subscriber.onError(ex);
                } else {
                    subscriber.a();
                }
            }
        }
    }

    public static void b(ho0<?> subscriber, Throwable ex, AtomicInteger wip, u4 error) {
        if (!error.a(ex)) {
            of0.l(ex);
        } else if (wip.getAndIncrement() == 0) {
            subscriber.onError(error.b());
        }
    }

    public static void a(ho0<?> subscriber, AtomicInteger wip, u4 error) {
        if (wip.getAndIncrement() == 0) {
            Throwable ex = error.b();
            if (ex != null) {
                subscriber.onError(ex);
            } else {
                subscriber.a();
            }
        }
    }
}
