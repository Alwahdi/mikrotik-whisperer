package defpackage;

import java.util.Iterator;

/* renamed from: p6  reason: default package */
public abstract class p6 implements Iterator<Boolean> {
    public abstract boolean nextBoolean();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
