package defpackage;

import java.util.Iterator;

/* renamed from: ik0  reason: default package */
abstract class ik0 extends hk0 {

    /* renamed from: ik0$a */
    public static final class a implements ck0<T> {
        final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        public Iterator<T> iterator() {
            return this.a;
        }
    }

    public static <T> ck0<T> c(Iterator<? extends T> $this$asSequence) {
        lu.f($this$asSequence, "<this>");
        return d(new a($this$asSequence));
    }

    public static final <T> ck0<T> d(ck0<? extends T> $this$constrainOnce) {
        lu.f($this$constrainOnce, "<this>");
        return $this$constrainOnce instanceof gc ? $this$constrainOnce : new gc($this$constrainOnce);
    }

    public static <T> ck0<T> e(T seed, vn<? super T, ? extends T> nextFunction) {
        lu.f(nextFunction, "nextFunction");
        if (seed == null) {
            return li.a;
        }
        return new bp(new b(seed), nextFunction);
    }

    /* renamed from: ik0$b */
    static final class b extends ow implements tn<T> {
        final /* synthetic */ T a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(T t) {
            super(0);
            this.a = t;
        }

        public final T invoke() {
            return this.a;
        }
    }
}
