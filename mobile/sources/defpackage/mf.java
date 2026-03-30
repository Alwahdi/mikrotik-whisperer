package defpackage;

import java.util.concurrent.Executor;

/* renamed from: mf  reason: default package */
public final class mf extends vj implements Executor {
    private static final ad a = kt0.a.limitedParallelism(bp0.d("kotlinx.coroutines.io.parallelism", hd0.a(64, zo0.a()), 0, 0, 12, (Object) null));

    /* renamed from: a  reason: collision with other field name */
    public static final mf f4350a = new mf();

    private mf() {
    }

    public void execute(Runnable command) {
        dispatch(gi.a, command);
    }

    public ad limitedParallelism(int parallelism) {
        return kt0.a.limitedParallelism(parallelism);
    }

    public void dispatch(yc context, Runnable block) {
        a.dispatch(context, block);
    }

    public void dispatchYield(yc context, Runnable block) {
        a.dispatchYield(context, block);
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
