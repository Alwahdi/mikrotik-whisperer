package defpackage;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.content.UriMatcherCompat;
import androidx.core.util.Predicate;

/* renamed from: xt0  reason: default package */
public final /* synthetic */ class xt0 implements Predicate {
    public final /* synthetic */ UriMatcher a;

    public /* synthetic */ xt0(UriMatcher uriMatcher) {
        this.a = uriMatcher;
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
        return UriMatcherCompat.lambda$asPredicate$0(this.a, (Uri) obj);
    }
}
