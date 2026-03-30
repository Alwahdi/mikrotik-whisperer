package defpackage;

import androidx.core.util.Predicate;

/* renamed from: da0  reason: default package */
public final /* synthetic */ class da0 implements Predicate {
    public final /* synthetic */ Object a;

    public /* synthetic */ da0(Object obj) {
        this.a = obj;
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
        return this.a.equals(obj);
    }
}
