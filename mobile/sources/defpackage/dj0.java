package defpackage;

import kotlinx.coroutines.scheduling.a;

/* renamed from: dj0  reason: default package */
public abstract class dj0 extends vj {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final long f2778a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2779a;

    /* renamed from: a  reason: collision with other field name */
    private a f2780a = X();
    private final int b;

    public dj0(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, String schedulerName) {
        this.a = corePoolSize;
        this.b = maxPoolSize;
        this.f2778a = idleWorkerKeepAliveNs;
        this.f2779a = schedulerName;
    }

    private final a X() {
        return new a(this.a, this.b, this.f2778a, this.f2779a);
    }

    public void dispatch(yc context, Runnable block) {
        a.C(this.f2780a, block, (hq0) null, false, 6, (Object) null);
    }

    public void dispatchYield(yc context, Runnable block) {
        a.C(this.f2780a, block, (hq0) null, true, 2, (Object) null);
    }

    public final void Y(Runnable block, hq0 context, boolean tailDispatch) {
        this.f2780a.w(block, context, tailDispatch);
    }
}
