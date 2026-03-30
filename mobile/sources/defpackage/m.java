package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: m  reason: default package */
abstract class m extends AtomicReference<Future<?>> implements yg {
    protected static final FutureTask<Void> a;
    protected static final FutureTask<Void> b;

    /* renamed from: a  reason: collision with other field name */
    protected final Runnable f4302a;

    /* renamed from: a  reason: collision with other field name */
    protected Thread f4303a;

    static {
        Runnable runnable = yo.f5909a;
        a = new FutureTask<>(runnable, (Object) null);
        b = new FutureTask<>(runnable, (Object) null);
    }

    m(Runnable runnable) {
        this.f4302a = runnable;
    }

    public final void dispose() {
        Future<?> future;
        Future<?> f = (Future) get();
        if (f != a && f != (future = b) && compareAndSet(f, future) && f != null) {
            f.cancel(this.f4303a != Thread.currentThread());
        }
    }

    public final void a(Future<?> future) {
        Future<?> f;
        do {
            f = (Future) get();
            if (f != a) {
                if (f == b) {
                    future.cancel(this.f4303a != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(f, future));
    }
}
