package defpackage;

import androidx.core.location.LocationRequestCompat;

/* renamed from: cj  reason: default package */
public abstract class cj extends ad {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private c4<vg<?>> f335a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f336a;

    public abstract void shutdown();

    /* access modifiers changed from: protected */
    public long a0() {
        c4 queue = this.f335a;
        if (queue != null && !queue.c()) {
            return 0;
        }
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public final boolean f0() {
        vg task;
        c4 queue = this.f335a;
        if (queue == null || (task = queue.d()) == null) {
            return false;
        }
        task.run();
        return true;
    }

    public final void Z(vg<?> task) {
        c4 queue = this.f335a;
        if (queue == null) {
            queue = new c4();
            this.f335a = queue;
        }
        queue.a(task);
    }

    public final boolean d0() {
        return this.a >= Y(true);
    }

    public final boolean e0() {
        c4<vg<?>> c4Var = this.f335a;
        if (c4Var != null) {
            return c4Var.c();
        }
        return true;
    }

    private final long Y(boolean unconfined) {
        return unconfined ? 4294967296L : 1;
    }

    public static /* synthetic */ void c0(cj cjVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            cjVar.b0(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void b0(boolean unconfined) {
        this.a += Y(unconfined);
        if (!unconfined) {
            this.f336a = true;
        }
    }

    public final void X(boolean unconfined) {
        long Y = this.a - Y(unconfined);
        this.a = Y;
        if (Y <= 0) {
            if (af.a()) {
                if (!(this.a == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.f336a) {
                shutdown();
            }
        }
    }

    public final ad limitedParallelism(int parallelism) {
        gx.a(parallelism);
        return this;
    }
}
