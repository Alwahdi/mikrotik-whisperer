package defpackage;

import defpackage.tc;
import kotlinx.coroutines.a;

/* renamed from: v6  reason: default package */
abstract /* synthetic */ class v6 {
    public static /* synthetic */ ev b(hd hdVar, yc ycVar, a aVar, jo joVar, int i, Object obj) {
        if ((i & 1) != 0) {
            ycVar = gi.a;
        }
        if ((i & 2) != 0) {
            aVar = a.DEFAULT;
        }
        return u6.a(hdVar, ycVar, aVar, joVar);
    }

    public static final ev a(hd $this$launch, yc context, a start, jo<? super hd, ? super rc<? super jt0>, ? extends Object> block) {
        um0 coroutine;
        yc newContext = zc.e($this$launch, context);
        if (start.isLazy()) {
            coroutine = new xw(newContext, block);
        } else {
            coroutine = new um0(newContext, true);
        }
        coroutine.p0(start, coroutine, block);
        return coroutine;
    }

    public static final <T> Object c(yc context, jo<? super hd, ? super rc<? super T>, ? extends Object> block, rc<? super T> $completion) {
        Object obj;
        rc uCont = $completion;
        yc oldContext = uCont.getContext();
        yc newContext = zc.d(oldContext, context);
        jv.c(newContext);
        if (newContext == oldContext) {
            qj0 coroutine = new qj0(newContext, uCont);
            obj = ft0.c(coroutine, coroutine, block);
        } else {
            tc.b bVar = tc.a;
            if (lu.a(newContext.get(bVar), oldContext.get(bVar))) {
                et0 coroutine2 = new et0(newContext, uCont);
                Object oldValue$iv = xq0.c(newContext, (Object) null);
                try {
                    Object c = ft0.c(coroutine2, coroutine2, block);
                    xq0.a(newContext, oldValue$iv);
                    obj = c;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    xq0.a(newContext, oldValue$iv);
                    throw th2;
                }
            } else {
                ug coroutine3 = new ug(newContext, uCont);
                t7.e(block, coroutine3, coroutine3, (vn) null, 4, (Object) null);
                obj = coroutine3.q0();
            }
        }
        if (obj == ou.d()) {
            df.c($completion);
        }
        return obj;
    }
}
