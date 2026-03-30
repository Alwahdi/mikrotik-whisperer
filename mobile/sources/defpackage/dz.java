package defpackage;

import java.util.Iterator;

/* renamed from: dz  reason: default package */
public abstract class dz implements Iterator<Long> {
    public abstract long nextLong();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
