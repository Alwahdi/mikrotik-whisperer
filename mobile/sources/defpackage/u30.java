package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: u30  reason: default package */
public class u30<T> implements Iterator<T> {
    private final ha0<? super T> a;

    /* renamed from: a  reason: collision with other field name */
    private T f5191a;

    /* renamed from: a  reason: collision with other field name */
    private final Iterator<? extends T> f5192a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f5193a;
    private boolean b;

    public u30(Iterator<? extends T> iterator, ha0<? super T> predicate) {
        this.f5192a = iterator;
        this.a = predicate;
    }

    public boolean hasNext() {
        if (!this.b) {
            a();
            this.b = true;
        }
        return this.f5193a;
    }

    public T next() {
        if (!this.b) {
            this.f5193a = hasNext();
        }
        if (this.f5193a) {
            this.b = false;
            return this.f5191a;
        }
        throw new NoSuchElementException();
    }

    private void a() {
        while (this.f5192a.hasNext()) {
            T next = this.f5192a.next();
            this.f5191a = next;
            if (this.a.test(next)) {
                this.f5193a = true;
                return;
            }
        }
        this.f5193a = false;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
