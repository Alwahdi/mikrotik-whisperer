package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: lz0  reason: default package */
abstract class lz0<T> implements Iterator<T> {
    private int a = qz0.b;

    /* renamed from: a  reason: collision with other field name */
    private T f4301a;

    protected lz0() {
    }

    /* access modifiers changed from: protected */
    public abstract T a();

    /* access modifiers changed from: protected */
    public final T b() {
        this.a = qz0.c;
        return null;
    }

    public final boolean hasNext() {
        int i = this.a;
        int i2 = qz0.d;
        if (i != i2) {
            switch (hz0.a[i - 1]) {
                case 1:
                    return false;
                case 2:
                    return true;
                default:
                    this.a = i2;
                    this.f4301a = a();
                    if (this.a == qz0.c) {
                        return false;
                    }
                    this.a = qz0.a;
                    return true;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final T next() {
        if (hasNext()) {
            this.a = qz0.b;
            T t = this.f4301a;
            this.f4301a = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
