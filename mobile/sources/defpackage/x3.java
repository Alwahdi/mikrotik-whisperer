package defpackage;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: x3  reason: default package */
final class x3<T> implements Collection<T> {
    private final boolean a;

    /* renamed from: a  reason: collision with other field name */
    private final T[] f5567a;

    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public <T> T[] toArray(T[] tArr) {
        lu.f(tArr, "array");
        return h9.b(this, tArr);
    }

    public x3(T[] values, boolean isVarargs) {
        lu.f(values, "values");
        this.f5567a = values;
        this.a = isVarargs;
    }

    public final /* bridge */ int size() {
        return a();
    }

    public int a() {
        return this.f5567a.length;
    }

    public boolean isEmpty() {
        return this.f5567a.length == 0;
    }

    public boolean contains(Object element) {
        return l4.g(this.f5567a, element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        lu.f(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object it : collection) {
            if (!contains(it)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return b4.a(this.f5567a);
    }

    public final Object[] toArray() {
        return k9.a(this.f5567a, this.a);
    }
}
