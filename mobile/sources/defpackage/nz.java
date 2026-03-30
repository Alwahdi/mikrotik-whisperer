package defpackage;

/* renamed from: nz  reason: default package */
public abstract class nz extends ad {
    public abstract nz X();

    public ad limitedParallelism(int parallelism) {
        gx.a(parallelism);
        return this;
    }

    /* access modifiers changed from: protected */
    public final String Y() {
        nz immediate;
        nz main = xg.c();
        if (this == main) {
            return "Dispatchers.Main";
        }
        try {
            immediate = main.X();
        } catch (UnsupportedOperationException e) {
            immediate = null;
        }
        if (this == immediate) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
