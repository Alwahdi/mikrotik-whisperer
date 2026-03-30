package defpackage;

import defpackage.se0;

/* renamed from: ft0  reason: default package */
public abstract class ft0 {
    public static final <T> void a(vn<? super rc<? super T>, ? extends Object> $this$startCoroutineUndispatched, rc<? super T> completion) {
        yc context$iv;
        Object oldValue$iv;
        rc a = df.a(completion);
        rc actualCompletion = a;
        try {
            context$iv = completion.getContext();
            oldValue$iv = xq0.c(context$iv, (Object) null);
            Object invoke = ((vn) zs0.a($this$startCoroutineUndispatched, 1)).invoke(actualCompletion);
            xq0.a(context$iv, oldValue$iv);
            Object value$iv = invoke;
            if (value$iv != ou.d()) {
                se0.a aVar = se0.a;
                a.resumeWith(se0.a(value$iv));
            }
        } catch (Throwable e$iv) {
            se0.a aVar2 = se0.a;
            a.resumeWith(se0.a(te0.a(e$iv)));
        }
    }

    public static final <R, T> void b(jo<? super R, ? super rc<? super T>, ? extends Object> $this$startCoroutineUndispatched, R receiver, rc<? super T> completion) {
        yc context$iv;
        Object oldValue$iv;
        rc a = df.a(completion);
        rc actualCompletion = a;
        try {
            context$iv = completion.getContext();
            oldValue$iv = xq0.c(context$iv, (Object) null);
            Object invoke = ((jo) zs0.a($this$startCoroutineUndispatched, 2)).invoke(receiver, actualCompletion);
            xq0.a(context$iv, oldValue$iv);
            Object value$iv = invoke;
            if (value$iv != ou.d()) {
                se0.a aVar = se0.a;
                a.resumeWith(se0.a(value$iv));
            }
        } catch (Throwable e$iv) {
            se0.a aVar2 = se0.a;
            a.resumeWith(se0.a(te0.a(e$iv)));
        }
    }

    public static final <T, R> Object c(qj0<? super T> $this$startUndispatchedOrReturn, R receiver, jo<? super R, ? super rc<? super T>, ? extends Object> block) {
        Object obj;
        qj0 $this$undispatchedResult$iv = $this$startUndispatchedOrReturn;
        try {
            obj = ((jo) zs0.a(block, 2)).invoke(receiver, $this$startUndispatchedOrReturn);
        } catch (Throwable e$iv) {
            obj = new va(e$iv, false, 2, (Cif) null);
        }
        Object result$iv = obj;
        if (result$iv == ou.d()) {
            return ou.d();
        }
        Object state$iv = $this$undispatchedResult$iv.M(result$iv);
        if (state$iv == nv.f4467b) {
            return ou.d();
        }
        if (!(state$iv instanceof va)) {
            return nv.h(state$iv);
        }
        Throwable th = ((va) state$iv).f5381a;
        Throwable exception$iv$iv = ((va) state$iv).f5381a;
        rc<T> rcVar = $this$undispatchedResult$iv.a;
        if (af.d() && (rcVar instanceof id)) {
            exception$iv$iv = tm0.j(exception$iv$iv, (id) rcVar);
        }
        throw exception$iv$iv;
    }
}
