package defpackage;

import defpackage.bj0;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: xu  reason: default package */
public final class xu extends bj0 {
    private static final TimeUnit a = TimeUnit.SECONDS;

    /* renamed from: a  reason: collision with other field name */
    static final pf0 f5767a;

    /* renamed from: a  reason: collision with other field name */
    static final a f5768a;

    /* renamed from: a  reason: collision with other field name */
    static final c f5769a;
    static final pf0 b;

    /* renamed from: a  reason: collision with other field name */
    final ThreadFactory f5770a;

    /* renamed from: a  reason: collision with other field name */
    final AtomicReference<a> f5771a;

    static {
        c cVar = new c(new pf0("RxCachedThreadSchedulerShutdown"));
        f5769a = cVar;
        cVar.dispose();
        int priority = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        pf0 pf0 = new pf0("RxCachedThreadScheduler", priority);
        f5767a = pf0;
        b = new pf0("RxCachedWorkerPoolEvictor", priority);
        a aVar = new a(0, (TimeUnit) null, pf0);
        f5768a = aVar;
        aVar.e();
    }

    /* renamed from: xu$a */
    static final class a implements Runnable {
        private final long a;

        /* renamed from: a  reason: collision with other field name */
        private final ConcurrentLinkedQueue<c> f5772a;

        /* renamed from: a  reason: collision with other field name */
        private final Future<?> f5773a;

        /* renamed from: a  reason: collision with other field name */
        private final ScheduledExecutorService f5774a;

        /* renamed from: a  reason: collision with other field name */
        private final ThreadFactory f5775a;

        /* renamed from: a  reason: collision with other field name */
        final qb f5776a;

        a(long keepAliveTime, TimeUnit unit, ThreadFactory threadFactory) {
            long nanos = unit != null ? unit.toNanos(keepAliveTime) : 0;
            this.a = nanos;
            this.f5772a = new ConcurrentLinkedQueue<>();
            this.f5776a = new qb();
            this.f5775a = threadFactory;
            ScheduledExecutorService evictor = null;
            Future<?> task = null;
            if (unit != null) {
                evictor = Executors.newScheduledThreadPool(1, xu.b);
                task = evictor.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            }
            this.f5774a = evictor;
            this.f5773a = task;
        }

        public void run() {
            a();
        }

        /* access modifiers changed from: package-private */
        public c b() {
            if (this.f5776a.e()) {
                return xu.f5769a;
            }
            while (!this.f5772a.isEmpty()) {
                c threadWorker = this.f5772a.poll();
                if (threadWorker != null) {
                    return threadWorker;
                }
            }
            c w = new c(this.f5775a);
            this.f5776a.c(w);
            return w;
        }

        /* access modifiers changed from: package-private */
        public void d(c threadWorker) {
            threadWorker.h(c() + this.a);
            this.f5772a.offer(threadWorker);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f5772a.isEmpty()) {
                long currentTimestamp = c();
                Iterator<c> it = this.f5772a.iterator();
                while (it.hasNext()) {
                    c threadWorker = it.next();
                    if (threadWorker.g() > currentTimestamp) {
                        return;
                    }
                    if (this.f5772a.remove(threadWorker)) {
                        this.f5776a.b(threadWorker);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public long c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f5776a.dispose();
            Future<?> future = this.f5773a;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f5774a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public xu() {
        this(f5767a);
    }

    public xu(ThreadFactory threadFactory) {
        this.f5770a = threadFactory;
        this.f5771a = new AtomicReference<>(f5768a);
        d();
    }

    public void d() {
        a update = new a(60, a, this.f5770a);
        if (!this.f5771a.compareAndSet(f5768a, update)) {
            update.e();
        }
    }

    public bj0.b a() {
        return new b(this.f5771a.get());
    }

    /* renamed from: xu$b */
    static final class b extends bj0.b {
        final AtomicBoolean a = new AtomicBoolean();

        /* renamed from: a  reason: collision with other field name */
        private final qb f5777a;

        /* renamed from: a  reason: collision with other field name */
        private final a f5778a;

        /* renamed from: a  reason: collision with other field name */
        private final c f5779a;

        b(a pool) {
            this.f5778a = pool;
            this.f5777a = new qb();
            this.f5779a = pool.b();
        }

        public void dispose() {
            if (this.a.compareAndSet(false, true)) {
                this.f5777a.dispose();
                this.f5778a.d(this.f5779a);
            }
        }

        public yg c(Runnable action, long delayTime, TimeUnit unit) {
            if (this.f5777a.e()) {
                return io.reactivex.internal.disposables.b.INSTANCE;
            }
            return this.f5779a.d(action, delayTime, unit, this.f5777a);
        }
    }

    /* renamed from: xu$c */
    static final class c extends h30 {
        private long a = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long g() {
            return this.a;
        }

        public void h(long expirationTime) {
            this.a = expirationTime;
        }
    }
}
