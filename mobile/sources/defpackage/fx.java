package defpackage;

/* renamed from: fx  reason: default package */
public final class fx extends ad implements Runnable, yf {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final ad f2995a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f2996a;

    /* renamed from: a  reason: collision with other field name */
    private final ry<Runnable> f2997a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ yf f2998a;
    private volatile int runningWorkers;

    public fx(ad dispatcher, int parallelism) {
        this.f2995a = dispatcher;
        this.a = parallelism;
        yf yfVar = dispatcher instanceof yf ? (yf) dispatcher : null;
        this.f2998a = yfVar == null ? lf.a() : yfVar;
        this.f2997a = new ry<>(false);
        this.f2996a = new Object();
    }

    public ad limitedParallelism(int parallelism) {
        gx.a(parallelism);
        if (parallelism >= this.a) {
            return this;
        }
        return super.limitedParallelism(parallelism);
    }

    public void run() {
        int fairnessCounter = 0;
        while (true) {
            Runnable task = this.f2997a.d();
            if (task != null) {
                try {
                    task.run();
                } catch (Throwable e) {
                    dd.a(gi.a, e);
                }
                fairnessCounter++;
                if (fairnessCounter >= 16 && this.f2995a.isDispatchNeeded(this)) {
                    this.f2995a.dispatch(this, this);
                    return;
                }
            } else {
                synchronized (this.f2996a) {
                    this.runningWorkers--;
                    if (this.f2997a.c() != 0) {
                        this.runningWorkers++;
                        fairnessCounter = 0;
                        jt0 jt0 = jt0.a;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void dispatch(yc context, Runnable block) {
        if (!X(block) && Y()) {
            this.f2995a.dispatch(this, this);
        }
    }

    public void dispatchYield(yc context, Runnable block) {
        if (!X(block) && Y()) {
            this.f2995a.dispatchYield(this, this);
        }
    }

    private final boolean Y() {
        synchronized (this.f2996a) {
            if (this.runningWorkers >= this.a) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    private final boolean X(Runnable block) {
        this.f2997a.a(block);
        return this.runningWorkers >= this.a;
    }
}
