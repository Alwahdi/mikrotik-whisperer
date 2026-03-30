package defpackage;

import android.content.ClipData;
import androidx.core.util.Predicate;

/* renamed from: kc  reason: default package */
public final /* synthetic */ class kc implements Predicate {
    public final /* synthetic */ java.util.function.Predicate a;

    public /* synthetic */ kc(java.util.function.Predicate predicate) {
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
        return this.a.test((ClipData.Item) obj);
    }
}
