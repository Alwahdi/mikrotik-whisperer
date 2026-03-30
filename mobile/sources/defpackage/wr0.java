package defpackage;

import defpackage.bj0;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: wr0  reason: default package */
public final class wr0 extends bj0 {
    private static final wr0 a = new wr0();

    public static wr0 d() {
        return a;
    }

    public bj0.b a() {
        return new c();
    }

    wr0() {
    }

    public yg b(Runnable run) {
        of0.n(run).run();
        return io.reactivex.internal.disposables.b.INSTANCE;
    }

    public yg c(Runnable run, long delay, TimeUnit unit) {
        try {
            unit.sleep(delay);
            of0.n(run).run();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            of0.l(ex);
        }
        return io.reactivex.internal.disposables.b.INSTANCE;
    }

    /* renamed from: wr0$c */
    static final class c extends bj0.b {
        final PriorityBlockingQueue<b> a = new PriorityBlockingQueue<>();

        /* renamed from: a  reason: collision with other field name */
        private final AtomicInteger f5548a = new AtomicInteger();

        /* renamed from: a  reason: collision with other field name */
        volatile boolean f5549a;
        final AtomicInteger b = new AtomicInteger();

        c() {
        }

        public yg b(Runnable action) {
            return d(action, a(TimeUnit.MILLISECONDS));
        }

        public yg c(Runnable action, long delayTime, TimeUnit unit) {
            long execTime = a(TimeUnit.MILLISECONDS) + unit.toMillis(delayTime);
            return d(new a(action, this, execTime), execTime);
        }

        /* access modifiers changed from: package-private */
        public yg d(Runnable action, long execTime) {
            if (this.f5549a) {
                return io.reactivex.internal.disposables.b.INSTANCE;
            }
            b timedRunnable = new b(action, Long.valueOf(execTime), this.b.incrementAndGet());
            this.a.add(timedRunnable);
            if (this.f5548a.getAndIncrement() != 0) {
                return ch.b(new a(timedRunnable));
            }
            int missed = 1;
            while (!this.f5549a) {
                b polled = this.a.poll();
                if (polled == null) {
                    missed = this.f5548a.addAndGet(-missed);
                    if (missed == 0) {
                        return io.reactivex.internal.disposables.b.INSTANCE;
                    }
                } else if (!polled.f5547a) {
                    polled.f5546a.run();
                }
            }
            this.a.clear();
            return io.reactivex.internal.disposables.b.INSTANCE;
        }

        public void dispose() {
            this.f5549a = true;
        }

        /* renamed from: wr0$c$a */
        final class a implements Runnable {
            final b a;

            a(b timedRunnable) {
                this.a = timedRunnable;
            }

            public void run() {
                this.a.f5547a = true;
                c.this.a.remove(this.a);
            }
        }
    }

    /* renamed from: wr0$b */
    static final class b implements Comparable<b> {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        final long f5545a;

        /* renamed from: a  reason: collision with other field name */
        final Runnable f5546a;

        /* renamed from: a  reason: collision with other field name */
        volatile boolean f5547a;

        b(Runnable run, Long execTime, int count) {
            this.f5546a = run;
            this.f5545a = execTime.longValue();
            this.a = count;
        }

        /* renamed from: a */
        public int compareTo(b that) {
            int result = a40.b(this.f5545a, that.f5545a);
            if (result == 0) {
                return a40.a(this.a, that.a);
            }
            return result;
        }
    }

    /* renamed from: wr0$a */
    static final class a implements Runnable {
        private final long a;

        /* renamed from: a  reason: collision with other field name */
        private final Runnable f5543a;

        /* renamed from: a  reason: collision with other field name */
        private final c f5544a;

        a(Runnable run, c worker, long execTime) {
            this.f5543a = run;
            this.f5544a = worker;
            this.a = execTime;
        }

        public void run() {
            if (!this.f5544a.f5549a) {
                long t = this.f5544a.a(TimeUnit.MILLISECONDS);
                long j = this.a;
                if (j > t) {
                    long delay = j - t;
                    if (delay > 0) {
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            of0.l(e);
                            return;
                        }
                    }
                }
                if (!this.f5544a.f5549a) {
                    this.f5543a.run();
                }
            }
        }
    }
}
