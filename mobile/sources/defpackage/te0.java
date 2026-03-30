package defpackage;

import defpackage.se0;

/* renamed from: te0  reason: default package */
public abstract class te0 {
    public static final Object a(Throwable exception) {
        lu.f(exception, "exception");
        return new se0.b(exception);
    }

    public static final void b(Object $this$throwOnFailure) {
        if ($this$throwOnFailure instanceof se0.b) {
            throw ((se0.b) $this$throwOnFailure).a;
        }
    }
}
