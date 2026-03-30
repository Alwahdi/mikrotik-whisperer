package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: dj  reason: default package */
public abstract class dj extends ej implements yf {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a;
    private static final /* synthetic */ AtomicReferenceFieldUpdater b;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;
    private volatile /* synthetic */ Object _queue = null;

    /* renamed from: dj$a */
    public static abstract class a implements Runnable, Comparable<a>, ah, cr0 {
        public final boolean a(long j) {
            throw null;
        }
    }

    /* renamed from: dj$b */
    public static final class b extends br0<a> {
    }

    static {
        Class<Object> cls = Object.class;
        Class<dj> cls2 = dj.class;
        a = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_queue");
        b = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_delayed");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    private final boolean m0() {
        return this._isCompleted;
    }

    private final void r0(boolean value) {
        this._isCompleted = value;
    }

    /* access modifiers changed from: protected */
    public boolean n0() {
        if (!e0()) {
            return false;
        }
        b delayed = (b) this._delayed;
        if (delayed != null && !delayed.b()) {
            return false;
        }
        Object queue = this._queue;
        if (queue == null) {
            return true;
        }
        if (queue instanceof sy) {
            return ((sy) queue).g();
        }
        if (queue == gj.b) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public long a0() {
        if (super.a0() == 0) {
            return 0;
        }
        Object queue = this._queue;
        if (queue != null) {
            if (queue instanceof sy) {
                if (!((sy) queue).g()) {
                    return 0;
                }
            } else if (queue == gj.b) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            } else {
                return 0;
            }
        }
        b bVar = (b) this._delayed;
        if (bVar != null) {
            b6.a(bVar.c());
        }
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public void shutdown() {
        ar0.a.b();
        r0(true);
        i0();
        do {
        } while (o0() <= 0);
        p0();
    }

    public long o0() {
        cr0 cr0;
        boolean z;
        if (f0()) {
            return 0;
        }
        br0 delayed = (b) this._delayed;
        if (delayed != null && !delayed.b()) {
            f0.a();
            long now = System.nanoTime();
            br0 this_$iv = delayed;
            synchronized (this_$iv) {
                cr0 first$iv = this_$iv.a();
                cr0 = null;
                if (first$iv != null) {
                    b6.a(first$iv);
                    a it = null;
                    if (it.a(now)) {
                        z = l0(it);
                    } else {
                        z = false;
                    }
                    if (z) {
                        cr0 = this_$iv.d(0);
                    }
                }
            }
            b6.a(cr0);
        }
        Runnable task = j0();
        if (task == null) {
            return a0();
        }
        task.run();
        return 0;
    }

    public final void dispatch(yc context, Runnable block) {
        k0(block);
    }

    public void k0(Runnable task) {
        if (l0(task)) {
            h0();
        } else {
            kf.a.k0(task);
        }
    }

    private final boolean l0(Runnable task) {
        while (true) {
            Object queue = this._queue;
            if (m0()) {
                return false;
            }
            if (queue == null) {
                if (w.a(a, this, (Object) null, task)) {
                    return true;
                }
            } else if (queue instanceof sy) {
                switch (((sy) queue).a(task)) {
                    case 0:
                        return true;
                    case 1:
                        w.a(a, this, queue, ((sy) queue).i());
                        break;
                    case 2:
                        return false;
                }
            } else if (queue == gj.b) {
                return false;
            } else {
                sy newQueue = new sy(8, true);
                newQueue.a((Runnable) queue);
                newQueue.a(task);
                if (w.a(a, this, queue, newQueue)) {
                    return true;
                }
            }
        }
    }

    private final Runnable j0() {
        while (true) {
            Object queue = this._queue;
            if (queue == null) {
                return null;
            }
            if (queue instanceof sy) {
                Object result = ((sy) queue).j();
                if (result != sy.f5063a) {
                    return (Runnable) result;
                }
                w.a(a, this, queue, ((sy) queue).i());
            } else if (queue == gj.b) {
                return null;
            } else {
                if (w.a(a, this, queue, (Object) null)) {
                    return (Runnable) queue;
                }
            }
        }
    }

    private final void i0() {
        if (!af.a() || m0() != 0) {
            while (true) {
                Object queue = this._queue;
                if (queue == null) {
                    if (w.a(a, this, (Object) null, gj.b)) {
                        return;
                    }
                } else if (queue instanceof sy) {
                    ((sy) queue).d();
                    return;
                } else if (queue != gj.b) {
                    sy newQueue = new sy(8, true);
                    newQueue.a((Runnable) queue);
                    if (w.a(a, this, queue, newQueue)) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: protected */
    public final void q0() {
        this._queue = null;
        this._delayed = null;
    }

    private final void p0() {
        f0.a();
        long nanoTime = System.nanoTime();
        b bVar = (b) this._delayed;
        if (bVar != null) {
            b6.a(bVar.e());
        }
    }
}
