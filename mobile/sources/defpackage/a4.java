package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: a4  reason: default package */
final class a4<T> implements Iterator<T> {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final T[] f12a;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public a4(T[] array) {
        lu.f(array, "array");
        this.f12a = array;
    }

    public boolean hasNext() {
        return this.a < this.f12a.length;
    }

    public T next() {
        try {
            T[] tArr = this.f12a;
            int i = this.a;
            this.a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
