package defpackage;

import androidx.core.util.Predicate;

/* renamed from: ba0  reason: default package */
public final /* synthetic */ class ba0 implements Predicate {
    public final /* synthetic */ Predicate a;
    public final /* synthetic */ Predicate b;

    public /* synthetic */ ba0(Predicate predicate, Predicate predicate2) {
        this.a = predicate;
        this.b = predicate2;
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
        return fa0.d(this.a, this.b, obj);
    }
}
