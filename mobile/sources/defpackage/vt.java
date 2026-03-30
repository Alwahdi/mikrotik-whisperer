package defpackage;

import android.net.Uri;
import androidx.core.util.Predicate;

/* renamed from: vt  reason: default package */
public final /* synthetic */ class vt implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ vt(String str) {
        this.a = str;
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
        return this.a.equals(((Uri) obj).getAuthority());
    }
}
