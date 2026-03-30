package defpackage;

import kotlin.coroutines.jvm.internal.a;

/* renamed from: qe0  reason: default package */
public abstract class qe0 extends a {
    public qe0(rc<Object> completion) {
        super(completion);
        if (completion != null) {
            if (!(completion.getContext() == gi.a)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    public yc getContext() {
        return gi.a;
    }
}
