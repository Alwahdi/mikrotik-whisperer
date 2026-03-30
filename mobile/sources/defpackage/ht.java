package defpackage;

import android.content.ComponentName;
import androidx.core.util.Predicate;

/* renamed from: ht  reason: default package */
public final /* synthetic */ class ht implements Predicate {
    public final /* synthetic */ ComponentName a;

    public /* synthetic */ ht(ComponentName componentName) {
        this.a = componentName;
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
        return this.a.equals((ComponentName) obj);
    }
}
