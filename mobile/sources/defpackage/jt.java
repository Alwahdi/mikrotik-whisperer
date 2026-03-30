package defpackage;

import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: jt  reason: default package */
public final /* synthetic */ class jt implements Predicate {
    public static final /* synthetic */ jt a = new jt();

    private /* synthetic */ jt() {
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
        return IntentSanitizer.Builder.lambda$new$6((Uri) obj);
    }
}
