package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: t4  reason: default package */
public abstract class t4<T> extends u40 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(t4.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = s4.a;

    public abstract void d(T t, Object obj);

    public abstract Object g(T t);

    public long f() {
        return 0;
    }

    public t4<?> a() {
        return this;
    }

    public final Object e(Object decision) {
        if (af.a()) {
            if (!(decision != s4.a)) {
                throw new AssertionError();
            }
        }
        Object current = this._consensus;
        Object obj = s4.a;
        if (current != obj) {
            return current;
        }
        if (w.a(a, this, obj, decision)) {
            return decision;
        }
        return this._consensus;
    }

    public final Object c(Object affected) {
        Object decision = this._consensus;
        if (decision == s4.a) {
            decision = e(g(affected));
        }
        d(affected, decision);
        return decision;
    }
}
