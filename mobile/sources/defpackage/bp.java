package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: bp  reason: default package */
final class bp<T> implements ck0<T> {
    /* access modifiers changed from: private */
    public final tn<T> a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final vn<T, T> f239a;

    /* renamed from: bp$a */
    public static final class a implements Iterator<T> {
        private int a = -2;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ bp<T> f240a;

        /* renamed from: a  reason: collision with other field name */
        private T f241a;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(bp<T> $receiver) {
            this.f240a = $receiver;
        }

        private final void a() {
            T t;
            if (this.a == -2) {
                t = this.f240a.a.invoke();
            } else {
                vn b = this.f240a.f239a;
                T t2 = this.f241a;
                lu.c(t2);
                t = b.invoke(t2);
            }
            this.f241a = t;
            this.a = t == null ? 0 : 1;
        }

        public T next() {
            if (this.a < 0) {
                a();
            }
            if (this.a != 0) {
                Object result = this.f241a;
                lu.d(result, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.a = -1;
                return result;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.a < 0) {
                a();
            }
            return this.a == 1;
        }
    }

    public bp(tn<? extends T> getInitialValue, vn<? super T, ? extends T> getNextValue) {
        lu.f(getInitialValue, "getInitialValue");
        lu.f(getNextValue, "getNextValue");
        this.a = getInitialValue;
        this.f239a = getNextValue;
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
