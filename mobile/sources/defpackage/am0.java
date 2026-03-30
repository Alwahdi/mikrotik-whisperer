package defpackage;

import defpackage.bj0;
import io.reactivex.internal.disposables.b;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: am0  reason: default package */
public final class am0 extends bj0 {
    static final ScheduledExecutorService a;

    /* renamed from: a  reason: collision with other field name */
    static final pf0 f70a = new pf0("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: a  reason: collision with other field name */
    final ThreadFactory f71a;

    /* renamed from: a  reason: collision with other field name */
    final AtomicReference<ScheduledExecutorService> f72a;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        a = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public am0() {
        this(f70a);
    }

    public am0(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f72a = atomicReference;
        this.f71a = threadFactory;
        atomicReference.lazySet(d(threadFactory));
    }

    static ScheduledExecutorService d(ThreadFactory threadFactory) {
        return ej0.a(threadFactory);
    }

    public bj0.b a() {
        return new a(this.f72a.get());
    }

    public yg c(Runnable run, long delay, TimeUnit unit) {
        Future<?> f;
        zi0 task = new zi0(of0.n(run));
        if (delay <= 0) {
            try {
                f = this.f72a.get().submit(task);
            } catch (RejectedExecutionException ex) {
                of0.l(ex);
                return b.INSTANCE;
            }
        } else {
            f = this.f72a.get().schedule(task, delay, unit);
        }
        task.a(f);
        return task;
    }

    /* renamed from: am0$a */
    static final class a extends bj0.b {
        final ScheduledExecutorService a;

        /* renamed from: a  reason: collision with other field name */
        final qb f73a = new qb();

        /* renamed from: a  reason: collision with other field name */
        volatile boolean f74a;

        a(ScheduledExecutorService executor) {
            this.a = executor;
        }

        public yg c(Runnable run, long delay, TimeUnit unit) {
            Future<?> f;
            if (this.f74a) {
                return b.INSTANCE;
            }
            aj0 sr = new aj0(of0.n(run), this.f73a);
            this.f73a.c(sr);
            if (delay <= 0) {
                try {
                    f = this.a.submit(sr);
                } catch (RejectedExecutionException ex) {
                    dispose();
                    of0.l(ex);
                    return b.INSTANCE;
                }
            } else {
                f = this.a.schedule(sr, delay, unit);
            }
            sr.a(f);
            return sr;
        }

        public void dispose() {
            if (!this.f74a) {
                this.f74a = true;
                this.f73a.dispose();
            }
        }
    }
}
