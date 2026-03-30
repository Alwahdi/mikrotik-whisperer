package defpackage;

import defpackage.bj0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: xb  reason: default package */
public final class xb extends bj0 {
    static final int a = d(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: a  reason: collision with other field name */
    static final pf0 f5582a;

    /* renamed from: a  reason: collision with other field name */
    static final b f5583a;

    /* renamed from: a  reason: collision with other field name */
    static final c f5584a;

    /* renamed from: a  reason: collision with other field name */
    final ThreadFactory f5585a;

    /* renamed from: a  reason: collision with other field name */
    final AtomicReference<b> f5586a;

    static {
        c cVar = new c(new pf0("RxComputationShutdown"));
        f5584a = cVar;
        cVar.dispose();
        pf0 pf0 = new pf0("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f5582a = pf0;
        b bVar = new b(0, pf0);
        f5583a = bVar;
        bVar.b();
    }

    static int d(int cpuCount, int paramThreads) {
        return (paramThreads <= 0 || paramThreads > cpuCount) ? cpuCount : paramThreads;
    }

    /* renamed from: xb$b */
    static final class b {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        long f5590a;

        /* renamed from: a  reason: collision with other field name */
        final c[] f5591a;

        b(int maxThreads, ThreadFactory threadFactory) {
            this.a = maxThreads;
            this.f5591a = new c[maxThreads];
            for (int i = 0; i < maxThreads; i++) {
                this.f5591a[i] = new c(threadFactory);
            }
        }

        public c a() {
            int c = this.a;
            if (c == 0) {
                return xb.f5584a;
            }
            c[] cVarArr = this.f5591a;
            long j = this.f5590a;
            this.f5590a = 1 + j;
            return cVarArr[(int) (j % ((long) c))];
        }

        public void b() {
            for (c w : this.f5591a) {
                w.dispose();
            }
        }
    }

    public xb() {
        this(f5582a);
    }

    public xb(ThreadFactory threadFactory) {
        this.f5585a = threadFactory;
        this.f5586a = new AtomicReference<>(f5583a);
        e();
    }

    public bj0.b a() {
        return new a(this.f5586a.get().a());
    }

    public yg c(Runnable run, long delay, TimeUnit unit) {
        return this.f5586a.get().a().e(run, delay, unit);
    }

    public void e() {
        b update = new b(a, this.f5585a);
        if (!this.f5586a.compareAndSet(f5583a, update)) {
            update.b();
        }
    }

    /* renamed from: xb$a */
    static final class a extends bj0.b {
        private final kx a;

        /* renamed from: a  reason: collision with other field name */
        private final qb f5587a;

        /* renamed from: a  reason: collision with other field name */
        private final c f5588a;

        /* renamed from: a  reason: collision with other field name */
        volatile boolean f5589a;
        private final kx b;

        a(c poolWorker) {
            this.f5588a = poolWorker;
            kx kxVar = new kx();
            this.a = kxVar;
            qb qbVar = new qb();
            this.f5587a = qbVar;
            kx kxVar2 = new kx();
            this.b = kxVar2;
            kxVar2.c(kxVar);
            kxVar2.c(qbVar);
        }

        public void dispose() {
            if (!this.f5589a) {
                this.f5589a = true;
                this.b.dispose();
            }
        }

        public yg b(Runnable action) {
            if (this.f5589a) {
                return io.reactivex.internal.disposables.b.INSTANCE;
            }
            return this.f5588a.d(action, 0, TimeUnit.MILLISECONDS, this.a);
        }

        public yg c(Runnable action, long delayTime, TimeUnit unit) {
            if (this.f5589a) {
                return io.reactivex.internal.disposables.b.INSTANCE;
            }
            return this.f5588a.d(action, delayTime, unit, this.f5587a);
        }
    }

    /* renamed from: xb$c */
    static final class c extends h30 {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
