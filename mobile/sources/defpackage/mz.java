package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: mz  reason: default package */
public abstract class mz<T> implements Iterator<T> {
    public abstract T a();

    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }

    public final T next() {
        if (hasNext()) {
            return a();
        }
        throw new NoSuchElementException();
    }
}
