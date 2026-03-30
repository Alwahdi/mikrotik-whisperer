package defpackage;

import java.io.Serializable;

/* renamed from: ow  reason: default package */
public abstract class ow<R> implements wo<R>, Serializable {
    private final int arity;

    public ow(int arity2) {
        this.arity = arity2;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String g = xd0.g(this);
        lu.e(g, "renderLambdaToString(this)");
        return g;
    }
}
