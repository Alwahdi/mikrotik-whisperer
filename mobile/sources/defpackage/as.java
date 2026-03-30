package defpackage;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;

/* renamed from: as  reason: default package */
public abstract class as<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] a = new Object[0];

    /* access modifiers changed from: package-private */
    public abstract int a(Object[] objArr, int i);

    /* access modifiers changed from: package-private */
    public abstract boolean f();

    as() {
    }

    public final Object[] toArray() {
        return toArray(a);
    }

    public final <T> T[] toArray(T[] other) {
        v90.n(other);
        int size = size();
        if (other.length < size) {
            Object[] internal = b();
            if (internal != null) {
                return j90.a(internal, d(), c(), other);
            }
            other = x30.d(other, size);
        } else if (other.length > size) {
            other[size] = null;
        }
        a(other, 0);
        return other;
    }

    /* access modifiers changed from: package-private */
    public Object[] b() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        throw new UnsupportedOperationException();
    }

    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }
}
