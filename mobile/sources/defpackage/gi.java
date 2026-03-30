package defpackage;

import defpackage.yc;
import java.io.Serializable;

/* renamed from: gi  reason: default package */
public final class gi implements yc, Serializable {
    public static final gi a = new gi();

    private gi() {
    }

    public <E extends yc.b> E get(yc.c<E> key) {
        lu.f(key, "key");
        return null;
    }

    public <R> R fold(R initial, jo<? super R, ? super yc.b, ? extends R> operation) {
        lu.f(operation, "operation");
        return initial;
    }

    public yc plus(yc context) {
        lu.f(context, "context");
        return context;
    }

    public yc minusKey(yc.c<?> key) {
        lu.f(key, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
