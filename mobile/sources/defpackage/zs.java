package defpackage;

import java.util.Iterator;

/* renamed from: zs  reason: default package */
public abstract class zs implements Iterator<Integer> {
    public abstract int nextInt();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
