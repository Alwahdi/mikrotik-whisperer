package defpackage;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: ot  reason: default package */
public final /* synthetic */ class ot implements Predicate {
    public static final /* synthetic */ ot a = new ot();

    private /* synthetic */ ot() {
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
        return IntentSanitizer.Builder.lambda$new$3((String) obj);
    }
}
