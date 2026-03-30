package defpackage;

import java.util.Iterator;

/* renamed from: ek0  reason: default package */
public abstract class ek0<T> {
    public abstract Object a(T t, rc<? super jt0> rcVar);

    public abstract Object d(Iterator<? extends T> it, rc<? super jt0> rcVar);

    public final Object c(ck0<? extends T> sequence, rc<? super jt0> $completion) {
        Object d = d(sequence.iterator(), $completion);
        return d == ou.d() ? d : jt0.a;
    }
}
