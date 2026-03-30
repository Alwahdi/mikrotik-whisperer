package defpackage;

import android.content.ClipData;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: yt  reason: default package */
public final /* synthetic */ class yt implements Predicate {
    public static final /* synthetic */ yt a = new yt();

    private /* synthetic */ yt() {
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
        return IntentSanitizer.Builder.lambda$new$7((ClipData) obj);
    }
}
