package defpackage;

import defpackage.bj0;
import io.reactivex.internal.disposables.b;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: h30  reason: default package */
public class h30 extends bj0.b {
    private final ScheduledExecutorService a;

    /* renamed from: a  reason: collision with other field name */
    volatile boolean f3136a;

    public h30(ThreadFactory threadFactory) {
        this.a = ej0.a(threadFactory);
    }

    public yg b(Runnable run) {
        return c(run, 0, (TimeUnit) null);
    }

    public yg c(Runnable action, long delayTime, TimeUnit unit) {
        if (this.f3136a) {
            return b.INSTANCE;
        }
        return d(action, delayTime, unit, (zg) null);
    }

    public yg e(Runnable run, long delayTime, TimeUnit unit) {
        Future<?> f;
        zi0 task = new zi0(of0.n(run));
        if (delayTime <= 0) {
            try {
                f = this.a.submit(task);
            } catch (RejectedExecutionException ex) {
                of0.l(ex);
                return b.INSTANCE;
            }
        } else {
            f = this.a.schedule(task, delayTime, unit);
        }
        task.a(f);
        return task;
    }

    public aj0 d(Runnable run, long delayTime, TimeUnit unit, zg parent) {
        Future<?> f;
        aj0 sr = new aj0(of0.n(run), parent);
        if (parent != null && !parent.c(sr)) {
            return sr;
        }
        if (delayTime <= 0) {
            try {
                f = this.a.submit(sr);
            } catch (RejectedExecutionException ex) {
                if (parent != null) {
                    parent.b(sr);
                }
                of0.l(ex);
            }
        } else {
            f = this.a.schedule(sr, delayTime, unit);
        }
        sr.a(f);
        return sr;
    }

    public void dispose() {
        if (!this.f3136a) {
            this.f3136a = true;
            this.a.shutdownNow();
        }
    }

    public void f() {
        if (!this.f3136a) {
            this.f3136a = true;
            this.a.shutdown();
        }
    }
}
