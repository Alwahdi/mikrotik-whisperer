package defpackage;

import java.util.Iterator;

/* renamed from: gk0  reason: default package */
abstract class gk0 {

    /* renamed from: gk0$a */
    public static final class a implements ck0<T> {
        final /* synthetic */ jo a;

        public a(jo joVar) {
            this.a = joVar;
        }

        public Iterator<T> iterator() {
            return gk0.a(this.a);
        }
    }

    public static <T> ck0<T> b(jo<? super ek0<? super T>, ? super rc<? super jt0>, ? extends Object> block) {
        lu.f(block, "block");
        return new a(block);
    }

    public static final <T> Iterator<T> a(jo<? super ek0<? super T>, ? super rc<? super jt0>, ? extends Object> block) {
        lu.f(block, "block");
        dk0 iterator = new dk0();
        iterator.g(nu.b(block, iterator, iterator));
        return iterator;
    }
}
