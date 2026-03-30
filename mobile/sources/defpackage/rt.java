package defpackage;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: rt  reason: default package */
public final /* synthetic */ class rt implements Predicate {
    public final /* synthetic */ Predicate a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Class f4943a;

    public /* synthetic */ rt(Class cls, Predicate predicate) {
        this.f4943a = cls;
        this.a = predicate;
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
        return IntentSanitizer.Builder.lambda$allowExtra$13(this.f4943a, this.a, obj);
    }
}
