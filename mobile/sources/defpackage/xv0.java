package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: xv0  reason: default package */
public final class xv0 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater a;

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f5780a;
    private static final /* synthetic */ AtomicIntegerFieldUpdater b;
    private static final /* synthetic */ AtomicIntegerFieldUpdater c;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicReferenceArray<dq0> f5781a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;

    static {
        Class<xv0> cls = xv0.class;
        f5780a = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        a = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        b = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        c = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final dq0 h() {
        dq0 dq0 = (dq0) f5780a.getAndSet(this, (Object) null);
        return dq0 == null ? i() : dq0;
    }

    public static /* synthetic */ dq0 b(xv0 xv0, dq0 dq0, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return xv0.a(dq0, z);
    }

    public final dq0 a(dq0 task, boolean fair) {
        if (fair) {
            return c(task);
        }
        dq0 previous = (dq0) f5780a.getAndSet(this, task);
        if (previous == null) {
            return null;
        }
        return c(previous);
    }

    private final dq0 c(dq0 task) {
        boolean z = true;
        if (task.f2814a.b() != 1) {
            z = false;
        }
        if (z) {
            c.incrementAndGet(this);
        }
        if (e() == 127) {
            return task;
        }
        int nextIndex = this.producerIndex & 127;
        while (this.f5781a.get(nextIndex) != null) {
            Thread.yield();
        }
        this.f5781a.lazySet(nextIndex, task);
        a.incrementAndGet(this);
        return null;
    }

    public final long l(xv0 victim) {
        boolean z = true;
        if (af.a()) {
            if ((e() == 0 ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        dq0 task = victim.i();
        if (task == null) {
            return m(victim, false);
        }
        dq0 notAdded = b(this, task, false, 2, (Object) null);
        if (!af.a()) {
            return -1;
        }
        if (notAdded != null) {
            z = false;
        }
        if (z) {
            return -1;
        }
        throw new AssertionError();
    }

    public final long k(xv0 victim) {
        if (af.a()) {
            if ((e() == 0 ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        int end = victim.producerIndex;
        AtomicReferenceArray buffer = victim.f5781a;
        for (int start = victim.consumerIndex; start != end; start++) {
            int index = start & 127;
            if (victim.blockingTasksInBuffer == 0) {
                break;
            }
            dq0 value = buffer.get(index);
            if (value != null) {
                if ((value.f2814a.b() == 1) && buffer.compareAndSet(index, value, (Object) null)) {
                    c.decrementAndGet(victim);
                    b(this, value, false, 2, (Object) null);
                    return -1;
                }
            }
        }
        return m(victim, true);
    }

    public final void g(kp globalQueue) {
        dq0 it = (dq0) f5780a.getAndSet(this, (Object) null);
        if (it != null) {
            globalQueue.a(it);
        }
        do {
        } while (j(globalQueue));
    }

    private final long m(xv0 victim, boolean blockingOnly) {
        dq0 lastScheduled;
        do {
            lastScheduled = (dq0) victim.lastScheduledTask;
            if (lastScheduled == null) {
                return -2;
            }
            if (blockingOnly) {
                boolean z = true;
                if (lastScheduled.f2814a.b() != 1) {
                    z = false;
                }
                if (!z) {
                    return -2;
                }
            }
            long staleness = mq0.f4383a.a() - lastScheduled.a;
            long j = mq0.f4382a;
            if (staleness < j) {
                return j - staleness;
            }
        } while (!w.a(f5780a, victim, lastScheduled, (Object) null));
        b(this, lastScheduled, false, 2, (Object) null);
        return -1;
    }

    private final boolean j(kp queue) {
        dq0 task = i();
        if (task == null) {
            return false;
        }
        queue.a(task);
        return true;
    }

    private final dq0 i() {
        dq0 value;
        while (true) {
            int tailLocal = this.consumerIndex;
            if (tailLocal - this.producerIndex == 0) {
                return null;
            }
            int index = tailLocal & 127;
            if (b.compareAndSet(this, tailLocal, tailLocal + 1) && (value = this.f5781a.getAndSet(index, (Object) null)) != null) {
                d(value);
                return value;
            }
        }
    }

    private final void d(dq0 $this$decrementIfBlocking) {
        if ($this$decrementIfBlocking != null) {
            boolean z = false;
            if ($this$decrementIfBlocking.f2814a.b() == 1) {
                int value = c.decrementAndGet(this);
                if (af.a()) {
                    if (value >= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }
}
