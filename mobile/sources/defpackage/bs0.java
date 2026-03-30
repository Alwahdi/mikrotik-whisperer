package defpackage;

import java.util.Iterator;

/* renamed from: bs0  reason: default package */
public final class bs0<T, R> implements ck0<R> {
    /* access modifiers changed from: private */
    public final ck0<T> a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final vn<T, R> f249a;

    public bs0(ck0<? extends T> sequence, vn<? super T, ? extends R> transformer) {
        lu.f(sequence, "sequence");
        lu.f(transformer, "transformer");
        this.a = sequence;
        this.f249a = transformer;
    }

    /* renamed from: bs0$a */
    public static final class a implements Iterator<R> {
        final /* synthetic */ bs0<T, R> a;

        /* renamed from: a  reason: collision with other field name */
        private final Iterator<T> f250a;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(bs0<T, R> $receiver) {
            this.a = $receiver;
            this.f250a = $receiver.a.iterator();
        }

        public R next() {
            return this.a.f249a.invoke(this.f250a.next());
        }

        public boolean hasNext() {
            return this.f250a.hasNext();
        }
    }

    public Iterator<R> iterator() {
        return new a(this);
    }
}
