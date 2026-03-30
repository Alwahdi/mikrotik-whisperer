package defpackage;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: pt  reason: default package */
public final /* synthetic */ class pt implements Predicate {
    public static final /* synthetic */ pt a = new pt();

    private /* synthetic */ pt() {
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
        return IntentSanitizer.Builder.lambda$allowExtra$14(obj);
    }
}
