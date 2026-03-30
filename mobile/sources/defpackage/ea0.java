package defpackage;

import androidx.core.util.Predicate;

/* renamed from: ea0  reason: default package */
public final /* synthetic */ class ea0 implements Predicate {
    public static final /* synthetic */ ea0 a = new ea0();

    private /* synthetic */ ea0() {
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return fa0.a(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return fa0.b(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return fa0.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return z90.a(obj);
    }
}
