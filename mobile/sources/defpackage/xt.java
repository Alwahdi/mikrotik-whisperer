package defpackage;

import androidx.core.util.Predicate;

/* renamed from: xt  reason: default package */
public final /* synthetic */ class xt implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ xt(String str) {
        this.a = str;
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
        return this.a.equals((String) obj);
    }
}
