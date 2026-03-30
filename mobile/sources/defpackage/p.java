package defpackage;

import java.util.NoSuchElementException;

/* renamed from: p  reason: default package */
abstract class p<E> extends mt0<E> {
    private final int a;
    private int b;

    /* access modifiers changed from: protected */
    public abstract E a(int i);

    protected p(int size, int position) {
        v90.q(position, size);
        this.a = size;
        this.b = position;
    }

    public final boolean hasNext() {
        return this.b < this.a;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.b;
            this.b = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.b;
    }

    public final boolean hasPrevious() {
        return this.b > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.b - 1;
            this.b = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.b - 1;
    }
}
