package defpackage;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: ii  reason: default package */
public final class ii implements ListIterator {
    public static final ii a = new ii();

    public /* bridge */ /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private ii() {
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public int nextIndex() {
        return 0;
    }

    public int previousIndex() {
        return -1;
    }

    /* renamed from: a */
    public Void next() {
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    public Void previous() {
        throw new NoSuchElementException();
    }
}
