package kotlinx.coroutines.scheduling;

import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

public final class a implements Executor, Closeable {
    private static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ AtomicLongFieldUpdater f4132a = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: a  reason: collision with other field name */
    public static final C0053a f4133a = new C0053a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    public static final uo0 f4134a = new uo0("NOT_IN_STACK");
    static final /* synthetic */ AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: a  reason: collision with other field name */
    public final int f4135a;

    /* renamed from: a  reason: collision with other field name */
    public final long f4136a;

    /* renamed from: a  reason: collision with other field name */
    public final ie0<c> f4137a;

    /* renamed from: a  reason: collision with other field name */
    public final String f4138a;

    /* renamed from: a  reason: collision with other field name */
    public final kp f4139a;

    /* renamed from: b  reason: collision with other field name */
    public final int f4140b;

    /* renamed from: b  reason: collision with other field name */
    public final kp f4141b;
    volatile /* synthetic */ long controlState;
    private volatile /* synthetic */ long parkedWorkersStack;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            a = iArr;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, String schedulerName) {
        this.f4135a = corePoolSize;
        this.f4140b = maxPoolSize;
        this.f4136a = idleWorkerKeepAliveNs;
        this.f4138a = schedulerName;
        boolean z = true;
        if (corePoolSize >= 1) {
            if (maxPoolSize >= corePoolSize) {
                if (maxPoolSize <= 2097150) {
                    if (idleWorkerKeepAliveNs <= 0 ? false : z) {
                        this.f4139a = new kp();
                        this.f4141b = new kp();
                        this.parkedWorkersStack = 0;
                        this.f4137a = new ie0<>(corePoolSize + 1);
                        this.controlState = ((long) corePoolSize) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + idleWorkerKeepAliveNs + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + maxPoolSize + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + maxPoolSize + " should be greater than or equals to core pool size " + corePoolSize).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + corePoolSize + " should be at least 1").toString());
    }

    private final boolean c(dq0 task) {
        boolean z = true;
        if (task.f2814a.b() != 1) {
            z = false;
        }
        if (z) {
            return this.f4141b.a(task);
        }
        return this.f4139a.a(task);
    }

    public final void U(c worker, int oldIndex, int newIndex) {
        int i;
        while (true) {
            long top = this.parkedWorkersStack;
            int index = (int) (2097151 & top);
            long updVersion = (2097152 + top) & -2097152;
            if (index != oldIndex) {
                i = index;
            } else if (newIndex == 0) {
                i = J(worker);
            } else {
                i = newIndex;
            }
            int updIndex = i;
            if (updIndex >= 0) {
                if (f4132a.compareAndSet(this, top, updVersion | ((long) updIndex))) {
                    return;
                }
            }
        }
    }

    public final boolean P(c worker) {
        long top;
        long updVersion;
        int updIndex;
        if (worker.h() != f4134a) {
            return false;
        }
        do {
            top = this.parkedWorkersStack;
            int index = (int) (2097151 & top);
            updVersion = (2097152 + top) & -2097152;
            updIndex = worker.g();
            if (af.a()) {
                if ((updIndex != 0 ? 1 : 0) == 0) {
                    throw new AssertionError();
                }
            }
            worker.p(this.f4137a.b(index));
        } while (!f4132a.compareAndSet(this, top, updVersion | ((long) updIndex)));
        return true;
    }

    private final c K() {
        while (true) {
            long top = this.parkedWorkersStack;
            c b2 = this.f4137a.b((int) (2097151 & top));
            if (b2 == null) {
                return null;
            }
            c worker = b2;
            long updVersion = (2097152 + top) & -2097152;
            int updIndex = J(worker);
            if (updIndex >= 0) {
                int i = updIndex;
                if (f4132a.compareAndSet(this, top, updVersion | ((long) updIndex))) {
                    worker.p(f4134a);
                    return worker;
                }
            }
        }
    }

    private final int J(c worker) {
        Object next = worker.h();
        while (next != f4134a) {
            if (next == null) {
                return 0;
            }
            c nextWorker = (c) next;
            int updIndex = nextWorker.g();
            if (updIndex != 0) {
                return updIndex;
            }
            next = nextWorker.h();
        }
        return -1;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    /* renamed from: kotlinx.coroutines.scheduling.a$a  reason: collision with other inner class name */
    public static final class C0053a {
        public /* synthetic */ C0053a(Cif ifVar) {
            this();
        }

        private C0053a() {
        }
    }

    public void execute(Runnable command) {
        C(this, command, (hq0) null, false, 6, (Object) null);
    }

    public void close() {
        X(10000);
    }

    public final void X(long timeout) {
        int i;
        dq0 task;
        boolean z = false;
        if (a.compareAndSet(this, 0, 1)) {
            c currentWorker = q();
            synchronized (this.f4137a) {
                try {
                    i = (int) (this.controlState & 2097151);
                } catch (Throwable th) {
                    long j = timeout;
                    throw th;
                }
            }
            int created = i;
            int i2 = 1;
            if (1 <= created) {
                while (true) {
                    c b2 = this.f4137a.b(i2);
                    lu.c(b2);
                    c worker = b2;
                    if (worker != currentWorker) {
                        while (worker.isAlive()) {
                            LockSupport.unpark(worker);
                            worker.join(timeout);
                        }
                        long j2 = timeout;
                        d state = worker.f4144a;
                        if (af.a()) {
                            if ((state == d.TERMINATED ? 1 : 0) == 0) {
                                throw new AssertionError();
                            }
                        }
                        worker.f4146a.g(this.f4141b);
                    } else {
                        long j3 = timeout;
                    }
                    if (i2 == created) {
                        break;
                    }
                    i2++;
                }
            } else {
                long j4 = timeout;
            }
            this.f4141b.b();
            this.f4139a.b();
            while (true) {
                if (currentWorker != null) {
                    task = currentWorker.f(true);
                    if (task != null) {
                        continue;
                        V(task);
                    }
                }
                task = (dq0) this.f4139a.d();
                if (task == null && (task = (dq0) this.f4141b.d()) == null) {
                    break;
                }
                V(task);
            }
            if (currentWorker != null) {
                currentWorker.s(d.TERMINATED);
            }
            if (af.a()) {
                if (((int) ((9223367638808264704L & this.controlState) >> 42)) == this.f4135a) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }

    public static /* synthetic */ void C(a aVar, Runnable runnable, hq0 hq0, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            hq0 = mq0.f4384a;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        aVar.w(runnable, hq0, z);
    }

    public final void w(Runnable block, hq0 taskContext, boolean tailDispatch) {
        f0.a();
        dq0 task = o(block, taskContext);
        c currentWorker = q();
        dq0 notAdded = a0(currentWorker, task, tailDispatch);
        if (notAdded == null || c(notAdded)) {
            boolean skipUnpark = tailDispatch && currentWorker != null;
            if (task.f2814a.b() != 0) {
                Y(skipUnpark);
            } else if (!skipUnpark) {
                Z();
            }
        } else {
            throw new RejectedExecutionException(this.f4138a + " was terminated");
        }
    }

    public final dq0 o(Runnable block, hq0 taskContext) {
        long nanoTime = mq0.f4383a.a();
        if (!(block instanceof dq0)) {
            return new kq0(block, nanoTime, taskContext);
        }
        ((dq0) block).a = nanoTime;
        ((dq0) block).f2814a = taskContext;
        return (dq0) block;
    }

    private final void Y(boolean skipUnpark) {
        long stateSnapshot = b.addAndGet(this, 2097152);
        if (!skipUnpark && !d0() && !b0(stateSnapshot)) {
            d0();
        }
    }

    public final void Z() {
        if (!d0() && !c0(this, 0, 1, (Object) null)) {
            d0();
        }
    }

    static /* synthetic */ boolean c0(a aVar, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = aVar.controlState;
        }
        return aVar.b0(j);
    }

    private final boolean b0(long state) {
        if (hd0.a(((int) (2097151 & state)) - ((int) ((4398044413952L & state) >> 21)), 0) < this.f4135a) {
            int newCpuWorkers = f();
            if (newCpuWorkers == 1 && this.f4135a > 1) {
                f();
            }
            if (newCpuWorkers > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean d0() {
        c worker;
        do {
            worker = K();
            if (worker == null) {
                return false;
            }
        } while (!c.a.compareAndSet(worker, -1, 0));
        LockSupport.unpark(worker);
        return true;
    }

    private final int f() {
        synchronized (this.f4137a) {
            if (isTerminated()) {
                return -1;
            }
            long state = this.controlState;
            int created = (int) (state & 2097151);
            int cpuWorkers = hd0.a(created - ((int) ((4398044413952L & state) >> 21)), 0);
            if (cpuWorkers >= this.f4135a) {
                return 0;
            }
            if (created >= this.f4140b) {
                return 0;
            }
            int newIndex = ((int) (this.controlState & 2097151)) + 1;
            if (newIndex > 0 && this.f4137a.b(newIndex) == null) {
                c worker = new c(this, newIndex);
                this.f4137a.c(newIndex, worker);
                if (newIndex == ((int) (b.incrementAndGet(this) & 2097151))) {
                    worker.start();
                    int cpuWorkers2 = cpuWorkers + 1;
                    return cpuWorkers2;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final dq0 a0(c $this$submitToLocalQueue, dq0 task, boolean tailDispatch) {
        if ($this$submitToLocalQueue == null || $this$submitToLocalQueue.f4144a == d.TERMINATED) {
            return task;
        }
        if (task.f2814a.b() == 0 && $this$submitToLocalQueue.f4144a == d.BLOCKING) {
            return task;
        }
        $this$submitToLocalQueue.f4147a = true;
        return $this$submitToLocalQueue.f4146a.a(task, tailDispatch);
    }

    private final c q() {
        Thread currentThread = Thread.currentThread();
        c it = currentThread instanceof c ? (c) currentThread : null;
        if (it == null || !lu.a(a.this, this)) {
            return null;
        }
        return it;
    }

    public String toString() {
        int parkedWorkers = 0;
        int blockingWorkers = 0;
        int cpuWorkers = 0;
        int dormant = 0;
        int terminated = 0;
        ArrayList queueSizes = new ArrayList();
        int a2 = this.f4137a.a();
        for (int index = 1; index < a2; index++) {
            c worker = this.f4137a.b(index);
            if (worker != null) {
                int queueSize = worker.f4146a.f();
                switch (b.a[worker.f4144a.ordinal()]) {
                    case 1:
                        parkedWorkers++;
                        break;
                    case 2:
                        blockingWorkers++;
                        StringBuilder sb = new StringBuilder();
                        sb.append(queueSize);
                        sb.append('b');
                        queueSizes.add(sb.toString());
                        break;
                    case 3:
                        cpuWorkers++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(queueSize);
                        sb2.append('c');
                        queueSizes.add(sb2.toString());
                        break;
                    case 4:
                        dormant++;
                        if (queueSize <= 0) {
                            break;
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(queueSize);
                            sb3.append('d');
                            queueSizes.add(sb3.toString());
                            break;
                        }
                    case 5:
                        terminated++;
                        break;
                }
            }
        }
        long state = this.controlState;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f4138a);
        sb4.append('@');
        sb4.append(ef.b(this));
        sb4.append("[Pool Size {core = ");
        sb4.append(this.f4135a);
        sb4.append(", max = ");
        sb4.append(this.f4140b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(cpuWorkers);
        sb4.append(", blocking = ");
        sb4.append(blockingWorkers);
        sb4.append(", parked = ");
        sb4.append(parkedWorkers);
        sb4.append(", dormant = ");
        sb4.append(dormant);
        sb4.append(", terminated = ");
        sb4.append(terminated);
        sb4.append("}, running workers queues = ");
        sb4.append(queueSizes);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f4139a.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f4141b.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & state));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & state) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(this.f4135a - ((int) ((9223367638808264704L & state) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }

    public final void V(dq0 task) {
        try {
            task.run();
        } catch (Throwable e) {
            Thread thread = Thread.currentThread();
            thread.getUncaughtExceptionHandler().uncaughtException(thread, e);
        } finally {
            f0.a();
        }
    }

    public final class c extends Thread {
        static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a  reason: collision with other field name */
        private int f4142a;

        /* renamed from: a  reason: collision with other field name */
        private long f4143a;

        /* renamed from: a  reason: collision with other field name */
        public d f4144a;

        /* renamed from: a  reason: collision with other field name */
        public final xv0 f4146a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f4147a;
        private long b;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.f4146a = new xv0();
            this.f4144a = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f4134a;
            this.f4142a = bd0.a.b();
        }

        public final int g() {
            return this.indexInArray;
        }

        public final void o(int index) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f4138a);
            sb.append("-worker-");
            sb.append(index == 0 ? "TERMINATED" : String.valueOf(index));
            setName(sb.toString());
            this.indexInArray = index;
        }

        public c(a this$0, int index) {
            this();
            o(index);
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        private final boolean q() {
            boolean z;
            if (this.f4144a == d.CPU_ACQUIRED) {
                return true;
            }
            a this_$iv = a.this;
            a $this$loop$iv$iv = this_$iv;
            while (true) {
                long state$iv = $this$loop$iv$iv.controlState;
                a aVar = this_$iv;
                if (((int) ((9223367638808264704L & state$iv) >> 42)) != 0) {
                    if (a.b.compareAndSet(this_$iv, state$iv, state$iv - 4398046511104L)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            this.f4144a = d.CPU_ACQUIRED;
            return true;
        }

        public final boolean s(d newState) {
            d previousState = this.f4144a;
            boolean hadCpu = previousState == d.CPU_ACQUIRED;
            if (hadCpu) {
                a.b.addAndGet(a.this, 4398046511104L);
            }
            if (previousState != newState) {
                this.f4144a = newState;
            }
            return hadCpu;
        }

        public void run() {
            n();
        }

        private final void n() {
            boolean rescanned = false;
            while (!a.this.isTerminated() && this.f4144a != d.TERMINATED) {
                dq0 task = f(this.f4147a);
                if (task != null) {
                    rescanned = false;
                    this.b = 0;
                    d(task);
                } else {
                    this.f4147a = false;
                    if (this.b == 0) {
                        r();
                    } else if (!rescanned) {
                        rescanned = true;
                    } else {
                        rescanned = false;
                        s(d.PARKING);
                        Thread.interrupted();
                        LockSupport.parkNanos(this.b);
                        this.b = 0;
                    }
                }
            }
            s(d.TERMINATED);
        }

        private final void r() {
            if (!j()) {
                a.this.P(this);
                return;
            }
            if (af.a()) {
                if (!(this.f4146a.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !a.this.isTerminated() && this.f4144a != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != a.f4134a;
        }

        private final void d(dq0 task) {
            int taskMode = task.f2814a.b();
            i(taskMode);
            c(taskMode);
            a.this.V(task);
            b(taskMode);
        }

        private final void c(int taskMode) {
            if (taskMode != 0 && s(d.BLOCKING)) {
                a.this.Z();
            }
        }

        private final void b(int taskMode) {
            if (taskMode != 0) {
                a.b.addAndGet(a.this, -2097152);
                d currentState = this.f4144a;
                if (currentState != d.TERMINATED) {
                    if (af.a()) {
                        if (!(currentState == d.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.f4144a = d.DORMANT;
                }
            }
        }

        public final int k(int upperBound) {
            int r = this.f4142a;
            int r2 = r ^ (r << 13);
            int r3 = r2 ^ (r2 >> 17);
            int r4 = r3 ^ (r3 << 5);
            this.f4142a = r4;
            int mask = upperBound - 1;
            if ((mask & upperBound) == 0) {
                return r4 & mask;
            }
            return (Integer.MAX_VALUE & r4) % upperBound;
        }

        private final void l() {
            if (this.f4143a == 0) {
                this.f4143a = System.nanoTime() + a.this.f4136a;
            }
            LockSupport.parkNanos(a.this.f4136a);
            if (System.nanoTime() - this.f4143a >= 0) {
                this.f4143a = 0;
                u();
            }
        }

        private final void u() {
            a this_$iv = a.this;
            synchronized (this_$iv.f4137a) {
                if (!this_$iv.isTerminated()) {
                    if (((int) (this_$iv.controlState & 2097151)) > this_$iv.f4135a) {
                        if (a.compareAndSet(this, -1, 1)) {
                            int oldIndex = this.indexInArray;
                            o(0);
                            this_$iv.U(this, oldIndex, 0);
                            a this_$iv2 = this_$iv;
                            a aVar = this_$iv2;
                            int lastIndex = (int) (2097151 & a.b.getAndDecrement(this_$iv2));
                            if (lastIndex != oldIndex) {
                                c b2 = this_$iv.f4137a.b(lastIndex);
                                lu.c(b2);
                                c lastWorker = b2;
                                this_$iv.f4137a.c(oldIndex, lastWorker);
                                lastWorker.o(oldIndex);
                                this_$iv.U(lastWorker, lastIndex, oldIndex);
                            }
                            this_$iv.f4137a.c(lastIndex, null);
                            jt0 jt0 = jt0.a;
                            this.f4144a = d.TERMINATED;
                        }
                    }
                }
            }
        }

        private final void i(int mode) {
            this.f4143a = 0;
            if (this.f4144a == d.PARKING) {
                if (af.a()) {
                    boolean z = true;
                    if (mode != 1) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                this.f4144a = d.BLOCKING;
            }
        }

        public final dq0 f(boolean scanLocalQueue) {
            dq0 task;
            if (q()) {
                return e(scanLocalQueue);
            }
            if (scanLocalQueue) {
                task = this.f4146a.h();
                if (task == null) {
                    task = (dq0) a.this.f4141b.d();
                }
            } else {
                task = (dq0) a.this.f4141b.d();
            }
            return task == null ? t(true) : task;
        }

        private final dq0 e(boolean scanLocalQueue) {
            dq0 it;
            dq0 it2;
            if (scanLocalQueue) {
                boolean globalFirst = k(a.this.f4135a * 2) == 0;
                if (globalFirst && (it2 = m()) != null) {
                    return it2;
                }
                dq0 it3 = this.f4146a.h();
                if (it3 != null) {
                    return it3;
                }
                if (!globalFirst && (it = m()) != null) {
                    return it;
                }
            } else {
                dq0 it4 = m();
                if (it4 != null) {
                    return it4;
                }
            }
            return t(false);
        }

        private final dq0 m() {
            if (k(2) == 0) {
                dq0 it = (dq0) a.this.f4139a.d();
                if (it != null) {
                    return it;
                }
                return (dq0) a.this.f4141b.d();
            }
            dq0 it2 = (dq0) a.this.f4141b.d();
            if (it2 != null) {
                return it2;
            }
            return (dq0) a.this.f4139a.d();
        }

        private final dq0 t(boolean blockingOnly) {
            int currentIndex;
            long stealResult;
            if (af.a()) {
                if ((this.f4146a.f() == 0 ? 1 : 0) == 0) {
                    throw new AssertionError();
                }
            }
            int created = (int) (a.this.controlState & 2097151);
            if (created < 2) {
                return null;
            }
            int currentIndex2 = k(created);
            long minDelay = LocationRequestCompat.PASSIVE_INTERVAL;
            a aVar = a.this;
            int i = 0;
            while (true) {
                long j = 0;
                if (i < created) {
                    int i2 = i;
                    int currentIndex3 = currentIndex2 + 1;
                    if (currentIndex3 > created) {
                        currentIndex3 = 1;
                    }
                    c worker = aVar.f4137a.b(currentIndex3);
                    if (worker == null || worker == this) {
                        currentIndex = currentIndex3;
                    } else {
                        if (af.a()) {
                            if (!(this.f4146a.f() == 0)) {
                                throw new AssertionError();
                            }
                        }
                        if (blockingOnly) {
                            stealResult = this.f4146a.k(worker.f4146a);
                        } else {
                            stealResult = this.f4146a.l(worker.f4146a);
                        }
                        currentIndex = currentIndex3;
                        long stealResult2 = stealResult;
                        if (stealResult2 == -1) {
                            return this.f4146a.h();
                        }
                        if (stealResult2 > 0) {
                            minDelay = Math.min(minDelay, stealResult2);
                        }
                    }
                    i++;
                    currentIndex2 = currentIndex;
                } else {
                    if (minDelay != LocationRequestCompat.PASSIVE_INTERVAL) {
                        j = minDelay;
                    }
                    this.b = j;
                    return null;
                }
            }
        }
    }
}
