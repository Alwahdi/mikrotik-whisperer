package defpackage;

import defpackage.se0;

/* renamed from: uc  reason: default package */
public abstract class uc {
    public static final <T> void a(vn<? super rc<? super T>, ? extends Object> $this$startCoroutine, rc<? super T> completion) {
        lu.f($this$startCoroutine, "<this>");
        lu.f(completion, "completion");
        rc c = nu.c(nu.a($this$startCoroutine, completion));
        se0.a aVar = se0.a;
        c.resumeWith(se0.a(jt0.a));
    }

    public static final <R, T> void b(jo<? super R, ? super rc<? super T>, ? extends Object> $this$startCoroutine, R receiver, rc<? super T> completion) {
        lu.f($this$startCoroutine, "<this>");
        lu.f(completion, "completion");
        rc c = nu.c(nu.b($this$startCoroutine, receiver, completion));
        se0.a aVar = se0.a;
        c.resumeWith(se0.a(jt0.a));
    }
}
