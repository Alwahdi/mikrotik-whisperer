package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: bj0  reason: default package */
public abstract class bj0 {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract b a();

    public yg b(Runnable run) {
        return c(run, 0, TimeUnit.NANOSECONDS);
    }

    public yg c(Runnable run, long delay, TimeUnit unit) {
        b w = a();
        a task = new a(of0.n(run), w);
        w.c(task, delay, unit);
        return task;
    }

    /* renamed from: bj0$b */
    public static abstract class b implements yg {
        public abstract yg c(Runnable runnable, long j, TimeUnit timeUnit);

        public yg b(Runnable run) {
            return c(run, 0, TimeUnit.NANOSECONDS);
        }

        public long a(TimeUnit unit) {
            return unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: bj0$a */
    static final class a implements yg, Runnable {
        final b a;

        /* renamed from: a  reason: collision with other field name */
        final Runnable f232a;

        /* renamed from: a  reason: collision with other field name */
        Thread f233a;

        a(Runnable decoratedRun, b w) {
            this.f232a = decoratedRun;
            this.a = w;
        }

        public void run() {
            this.f233a = Thread.currentThread();
            try {
                this.f232a.run();
            } finally {
                dispose();
                this.f233a = null;
            }
        }

        public void dispose() {
            if (this.f233a == Thread.currentThread()) {
                b bVar = this.a;
                if (bVar instanceof h30) {
                    ((h30) bVar).f();
                    return;
                }
            }
            this.a.dispose();
        }
    }
}
