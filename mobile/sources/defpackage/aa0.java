package defpackage;

import androidx.core.util.Predicate;

/* renamed from: aa0  reason: default package */
public final /* synthetic */ class aa0 implements Predicate {
    public final /* synthetic */ Predicate a;

    public /* synthetic */ aa0(Predicate predicate) {
        this.a = predicate;
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
        return fa0.e(this.a, obj);
    }
}
