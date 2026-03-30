package defpackage;

import defpackage.tc;
import defpackage.yc;

/* renamed from: ad  reason: default package */
public abstract class ad extends k implements tc {
    public static final a Key = new a((Cif) null);

    public abstract void dispatch(yc ycVar, Runnable runnable);

    public <E extends yc.b> E get(yc.c<E> key) {
        return tc.a.a(this, key);
    }

    public yc minusKey(yc.c<?> key) {
        return tc.a.b(this, key);
    }

    public ad() {
        super(tc.a);
    }

    /* renamed from: ad$a */
    public static final class a extends l<tc, ad> {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
            super(tc.a, C0000a.a);
        }

        /* renamed from: ad$a$a  reason: collision with other inner class name */
        static final class C0000a extends ow implements vn<yc.b, ad> {
            public static final C0000a a = new C0000a();

            C0000a() {
                super(1);
            }

            /* renamed from: b */
            public final ad invoke(yc.b it) {
                if (it instanceof ad) {
                    return (ad) it;
                }
                return null;
            }
        }
    }

    public boolean isDispatchNeeded(yc context) {
        return true;
    }

    public ad limitedParallelism(int parallelism) {
        gx.a(parallelism);
        return new fx(this, parallelism);
    }

    public void dispatchYield(yc context, Runnable block) {
        dispatch(context, block);
    }

    public final <T> rc<T> interceptContinuation(rc<? super T> continuation) {
        return new sg(this, continuation);
    }

    public final void releaseInterceptedContinuation(rc<?> continuation) {
        ((sg) continuation).l();
    }

    public final ad plus(ad other) {
        return other;
    }

    public String toString() {
        return ef.a(this) + '@' + ef.b(this);
    }
}
