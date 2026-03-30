package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: lz  reason: default package */
public abstract class lz<T> implements Iterator<T> {
    protected T a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f4300a;
    protected boolean b;

    /* access modifiers changed from: protected */
    public abstract void a();

    public boolean hasNext() {
        if (!this.b) {
            a();
            this.b = true;
        }
        return this.f4300a;
    }

    public T next() {
        if (!this.b) {
            hasNext();
        }
        if (this.f4300a) {
            T result = this.a;
            a();
            if (!this.f4300a) {
                this.a = null;
            }
            return result;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
