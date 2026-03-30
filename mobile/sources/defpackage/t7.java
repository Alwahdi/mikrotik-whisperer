package defpackage;

import defpackage.se0;

/* renamed from: t7  reason: default package */
public abstract class t7 {
    public static final <T> void c(vn<? super rc<? super T>, ? extends Object> $this$startCoroutineCancellable, rc<? super T> completion) {
        try {
            rc c = nu.c(nu.a($this$startCoroutineCancellable, completion));
            se0.a aVar = se0.a;
            tg.c(c, se0.a(jt0.a), (vn) null, 2, (Object) null);
        } catch (Throwable e$iv) {
            a(completion, e$iv);
        }
    }

    public static /* synthetic */ void e(jo joVar, Object obj, rc rcVar, vn vnVar, int i, Object obj2) {
        if ((i & 4) != 0) {
            vnVar = null;
        }
        d(joVar, obj, rcVar, vnVar);
    }

    public static final <R, T> void d(jo<? super R, ? super rc<? super T>, ? extends Object> $this$startCoroutineCancellable, R receiver, rc<? super T> completion, vn<? super Throwable, jt0> onCancellation) {
        try {
            rc c = nu.c(nu.b($this$startCoroutineCancellable, receiver, completion));
            se0.a aVar = se0.a;
            tg.b(c, se0.a(jt0.a), onCancellation);
        } catch (Throwable e$iv) {
            a(completion, e$iv);
        }
    }

    public static final void b(rc<? super jt0> $this$startCoroutineCancellable, rc<?> fatalCompletion) {
        try {
            rc c = nu.c($this$startCoroutineCancellable);
            se0.a aVar = se0.a;
            tg.c(c, se0.a(jt0.a), (vn) null, 2, (Object) null);
        } catch (Throwable e$iv) {
            a(fatalCompletion, e$iv);
        }
    }

    private static final void a(rc<?> completion, Throwable e) {
        se0.a aVar = se0.a;
        completion.resumeWith(se0.a(te0.a(e)));
        throw e;
    }
}
