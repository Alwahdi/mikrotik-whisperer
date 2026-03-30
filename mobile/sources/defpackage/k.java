package defpackage;

import defpackage.yc;

/* renamed from: k  reason: default package */
public abstract class k implements yc.b {
    private final yc.c<?> key;

    public k(yc.c<?> key2) {
        lu.f(key2, "key");
        this.key = key2;
    }

    public <R> R fold(R initial, jo<? super R, ? super yc.b, ? extends R> operation) {
        return yc.b.a.a(this, initial, operation);
    }

    public <E extends yc.b> E get(yc.c<E> key2) {
        return yc.b.a.b(this, key2);
    }

    public yc minusKey(yc.c<?> key2) {
        return yc.b.a.c(this, key2);
    }

    public yc plus(yc context) {
        return yc.b.a.d(this, context);
    }

    public yc.c<?> getKey() {
        return this.key;
    }
}
