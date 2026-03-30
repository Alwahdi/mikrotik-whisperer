package defpackage;

import defpackage.yc;

/* renamed from: gt0  reason: default package */
final class gt0 implements yc.b, yc.c<gt0> {
    public static final gt0 a = new gt0();

    private gt0() {
    }

    public <R> R fold(R initial, jo<? super R, ? super yc.b, ? extends R> operation) {
        return yc.b.a.a(this, initial, operation);
    }

    public <E extends yc.b> E get(yc.c<E> key) {
        return yc.b.a.b(this, key);
    }

    public yc minusKey(yc.c<?> key) {
        return yc.b.a.c(this, key);
    }

    public yc plus(yc context) {
        return yc.b.a.d(this, context);
    }

    public yc.c<?> getKey() {
        return this;
    }
}
