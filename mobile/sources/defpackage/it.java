package defpackage;

import android.content.ComponentName;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: it  reason: default package */
public final /* synthetic */ class it implements Predicate {
    public static final /* synthetic */ it a = new it();

    private /* synthetic */ it() {
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
        return IntentSanitizer.Builder.lambda$new$5((ComponentName) obj);
    }
}
