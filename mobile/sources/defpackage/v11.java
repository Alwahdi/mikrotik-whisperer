package defpackage;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: v11  reason: default package */
public abstract class v11<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] a = new Object[0];

    v11() {
    }

    /* access modifiers changed from: package-private */
    public abstract int a(Object[] objArr, int i);

    public abstract u21<E> b();

    public abstract t11<E> c();

    public abstract boolean contains(Object obj);

    public abstract /* synthetic */ Iterator iterator();

    public final Object[] toArray() {
        return toArray(a);
    }

    public final <T> T[] toArray(T[] tArr) {
        t01.c(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] d = d();
            if (d != null) {
                return Arrays.copyOfRange(d, f(), h(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public Object[] d() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        throw new UnsupportedOperationException();
    }

    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj) {
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
