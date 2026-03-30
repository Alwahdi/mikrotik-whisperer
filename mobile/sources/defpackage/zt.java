package defpackage;

import android.content.ComponentName;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: zt  reason: default package */
public final /* synthetic */ class zt implements Predicate {
    public static final /* synthetic */ zt a = new zt();

    private /* synthetic */ zt() {
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
        return IntentSanitizer.Builder.lambda$allowAnyComponent$10((ComponentName) obj);
    }
}
