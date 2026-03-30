package defpackage;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: lt  reason: default package */
public final /* synthetic */ class lt implements Predicate {
    public static final /* synthetic */ lt a = new lt();

    private /* synthetic */ lt() {
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
        return IntentSanitizer.Builder.lambda$new$2((String) obj);
    }
}
