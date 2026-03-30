package defpackage;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: mk0  reason: default package */
public final class mk0 implements Executor, Runnable {
    private static final Logger a = Logger.getLogger(mk0.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private static final b f4362a = c();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile int f4363a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final Queue<Runnable> f4364a = new ConcurrentLinkedQueue();

    /* renamed from: a  reason: collision with other field name */
    private final Executor f4365a;

    private static b c() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(mk0.class, "a"));
        } catch (Throwable t) {
            a.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", t);
            return new d();
        }
    }

    public mk0(Executor executor) {
        v90.o(executor, "'executor' must not be null.");
        this.f4365a = executor;
    }

    public void execute(Runnable r) {
        this.f4364a.add(v90.o(r, "'r' must not be null."));
        d(r);
    }

    private void d(Runnable removable) {
        if (f4362a.a(this, 0, -1)) {
            try {
                this.f4365a.execute(this);
            } catch (Throwable th) {
                if (0 == 0) {
                    if (removable != null) {
                        this.f4364a.remove(removable);
                    }
                    f4362a.b(this, 0);
                }
                throw th;
            }
        }
    }

    public void run() {
        Runnable r;
        while (true) {
            try {
                Runnable poll = this.f4364a.poll();
                r = poll;
                if (poll == null) {
                    break;
                }
                r.run();
            } catch (RuntimeException e) {
                Logger logger = a;
                Level level = Level.SEVERE;
                logger.log(level, "Exception while executing runnable " + r, e);
            } catch (Throwable th) {
                f4362a.b(this, 0);
                throw th;
            }
        }
        f4362a.b(this, 0);
        if (!this.f4364a.isEmpty()) {
            d((Runnable) null);
        }
    }

    /* renamed from: mk0$b */
    private static abstract class b {
        public abstract boolean a(mk0 mk0, int i, int i2);

        public abstract void b(mk0 mk0, int i);

        private b() {
        }
    }

    /* renamed from: mk0$c */
    private static final class c extends b {
        private final AtomicIntegerFieldUpdater<mk0> a;

        private c(AtomicIntegerFieldUpdater<mk0> runStateUpdater) {
            super();
            this.a = runStateUpdater;
        }

        public boolean a(mk0 obj, int expect, int update) {
            return this.a.compareAndSet(obj, expect, update);
        }

        public void b(mk0 obj, int newValue) {
            this.a.set(obj, newValue);
        }
    }

    /* renamed from: mk0$d */
    private static final class d extends b {
        private d() {
            super();
        }

        public boolean a(mk0 obj, int expect, int update) {
            synchronized (obj) {
                if (obj.f4363a != expect) {
                    return false;
                }
                int unused = obj.f4363a = update;
                return true;
            }
        }

        public void b(mk0 obj, int newValue) {
            synchronized (obj) {
                int unused = obj.f4363a = newValue;
            }
        }
    }
}
