package defpackage;

import java.util.NoSuchElementException;

/* renamed from: p11  reason: default package */
abstract class p11<E> extends t21<E> {
    private final int a;
    private int b;

    protected p11(int i, int i2) {
        t01.e(i2, i);
        this.a = i;
        this.b = i2;
    }

    /* access modifiers changed from: protected */
    public abstract E a(int i);

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
