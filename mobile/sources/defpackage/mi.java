package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: mi  reason: default package */
public final class mi implements Set, Serializable {
    public static final mi a = new mi();

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return h9.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        lu.f(tArr, "array");
        return h9.b(this, tArr);
    }

    private mi() {
    }

    public final /* bridge */ boolean contains(Object element) {
        if (!(element instanceof Void)) {
            return false;
        }
        return a((Void) element);
    }

    public final /* bridge */ int size() {
        return b();
    }

    public boolean equals(Object other) {
        return (other instanceof Set) && ((Set) other).isEmpty();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "[]";
    }

    public int b() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean a(Void element) {
        lu.f(element, "element");
        return false;
    }

    public boolean containsAll(Collection elements) {
        lu.f(elements, "elements");
        return elements.isEmpty();
    }

    public Iterator iterator() {
        return ii.a;
    }
}
