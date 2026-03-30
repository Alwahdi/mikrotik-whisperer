package defpackage;

import defpackage.yc;
import defpackage.yc.b;

/* renamed from: l  reason: default package */
public abstract class l<B extends yc.b, E extends B> implements yc.c<E> {
    private final vn<yc.b, E> a;

    /* renamed from: a  reason: collision with other field name */
    private final yc.c<?> f4185a;

    public l(yc.c<B> baseKey, vn<? super yc.b, ? extends E> safeCast) {
        lu.f(baseKey, "baseKey");
        lu.f(safeCast, "safeCast");
        this.a = safeCast;
        this.f4185a = baseKey instanceof l ? ((l) baseKey).f4185a : baseKey;
    }

    public final E b(yc.b element) {
        lu.f(element, "element");
        return (yc.b) this.a.invoke(element);
    }

    public final boolean a(yc.c<?> key) {
        lu.f(key, "key");
        return key == this || this.f4185a == key;
    }
}
