package defpackage;

import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

/* renamed from: nf0  reason: default package */
public abstract class nf0 {
    private static volatile mo<Callable<bj0>, bj0> a;
    private static volatile mo<bj0, bj0> b;

    public static bj0 d(Callable<bj0> scheduler) {
        if (scheduler != null) {
            Function<Callable<Scheduler>, Scheduler> f = a;
            if (f == null) {
                return c(scheduler);
            }
            return b(f, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static bj0 e(bj0 scheduler) {
        if (scheduler != null) {
            Function<Scheduler, Scheduler> f = b;
            if (f == null) {
                return scheduler;
            }
            return (bj0) a(f, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    static bj0 c(Callable<bj0> s) {
        try {
            bj0 scheduler = s.call();
            if (scheduler != null) {
                return scheduler;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable ex) {
            throw oj.a(ex);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [mo<java.util.concurrent.Callable<bj0>, bj0>, mo] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static defpackage.bj0 b(defpackage.mo<java.util.concurrent.Callable<defpackage.bj0>, defpackage.bj0> r3, java.util.concurrent.Callable<defpackage.bj0> r4) {
        /*
            java.lang.Object r0 = a(r3, r4)
            bj0 r0 = (defpackage.bj0) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Scheduler Callable returned null"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf0.b(mo, java.util.concurrent.Callable):bj0");
    }

    static <T, R> R a(mo<T, R> f, T t) {
        try {
            return f.apply(t);
        } catch (Throwable ex) {
            throw oj.a(ex);
        }
    }
}
