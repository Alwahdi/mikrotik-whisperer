package defpackage;

import defpackage.se0;

/* renamed from: za  reason: default package */
public abstract class za {
    public static /* synthetic */ Object d(Object obj, vn vnVar, int i, Object obj2) {
        if ((i & 1) != 0) {
            vnVar = null;
        }
        return c(obj, vnVar);
    }

    public static final <T> Object c(Object $this$toState, vn<? super Throwable, jt0> onCancellation) {
        Throwable it = se0.b($this$toState);
        if (it != null) {
            return new va(it, false, 2, (Cif) null);
        }
        Object it2 = $this$toState;
        if (onCancellation != null) {
            return new wa(it2, onCancellation);
        }
        return it2;
    }

    public static final <T> Object b(Object $this$toState, r7<?> caller) {
        Throwable th;
        Throwable it = se0.b($this$toState);
        if (it == null) {
            return $this$toState;
        }
        if (!af.d() || !(caller instanceof id)) {
            th = it;
        } else {
            th = tm0.j(it, (id) caller);
        }
        return new va(th, false, 2, (Cif) null);
    }

    public static final <T> Object a(Object state, rc<? super T> uCont) {
        if (state instanceof va) {
            se0.a aVar = se0.a;
            Throwable exception$iv = ((va) state).f5381a;
            if (af.d() && (uCont instanceof id)) {
                exception$iv = tm0.j(exception$iv, (id) uCont);
            }
            return se0.a(te0.a(exception$iv));
        }
        se0.a aVar2 = se0.a;
        return se0.a(state);
    }
}
