package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: lq0  reason: default package */
public abstract class lq0 {

    /* renamed from: lq0$b */
    interface b extends n40, r40, t40<Object> {
    }

    public static <TResult> eq0<TResult> e(TResult tresult) {
        v91 v91 = new v91();
        v91.u(tresult);
        return v91;
    }

    /* renamed from: lq0$a */
    private static final class a implements b {
        private final CountDownLatch a;

        private a() {
            this.a = new CountDownLatch(1);
        }

        public final void e(Object obj) {
            this.a.countDown();
        }

        public final void b(Exception exc) {
            this.a.countDown();
        }

        public final void c() {
            this.a.countDown();
        }

        public final void a() {
            this.a.await();
        }

        public final boolean d(long j, TimeUnit timeUnit) {
            return this.a.await(j, timeUnit);
        }

        /* synthetic */ a(z91 z91) {
            this();
        }
    }

    public static <TResult> eq0<TResult> d(Exception exc) {
        v91 v91 = new v91();
        v91.t(exc);
        return v91;
    }

    public static <TResult> eq0<TResult> c(Executor executor, Callable<TResult> callable) {
        y90.k(executor, "Executor must not be null");
        y90.k(callable, "Callback must not be null");
        v91 v91 = new v91();
        executor.execute(new z91(v91, callable));
        return v91;
    }

    public static <TResult> TResult a(eq0<TResult> eq0) {
        y90.h();
        y90.k(eq0, "Task must not be null");
        if (eq0.q()) {
            return g(eq0);
        }
        a aVar = new a((z91) null);
        f(eq0, aVar);
        aVar.a();
        return g(eq0);
    }

    public static <TResult> TResult b(eq0<TResult> eq0, long j, TimeUnit timeUnit) {
        y90.h();
        y90.k(eq0, "Task must not be null");
        y90.k(timeUnit, "TimeUnit must not be null");
        if (eq0.q()) {
            return g(eq0);
        }
        a aVar = new a((z91) null);
        f(eq0, aVar);
        if (aVar.d(j, timeUnit)) {
            return g(eq0);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    private static <TResult> TResult g(eq0<TResult> eq0) {
        if (eq0.r()) {
            return eq0.n();
        }
        if (eq0.p()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(eq0.m());
    }

    private static void f(eq0<?> eq0, b bVar) {
        Executor executor = jq0.b;
        eq0.h(executor, bVar);
        eq0.f(executor, bVar);
        eq0.a(executor, bVar);
    }
}
