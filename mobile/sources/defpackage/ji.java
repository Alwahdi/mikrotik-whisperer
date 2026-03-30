package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: ji  reason: default package */
public final class ji implements List, Serializable, RandomAccess {
    public static final ji a = new ji();

    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object remove(int i) {
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

    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return h9.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        lu.f(tArr, "array");
        return h9.b(this, tArr);
    }

    private ji() {
    }

    public final /* bridge */ boolean contains(Object element) {
        if (!(element instanceof Void)) {
            return false;
        }
        return a((Void) element);
    }

    public final /* bridge */ int indexOf(Object element) {
        if (!(element instanceof Void)) {
            return -1;
        }
        return d((Void) element);
    }

    public final /* bridge */ int lastIndexOf(Object element) {
        if (!(element instanceof Void)) {
            return -1;
        }
        return f((Void) element);
    }

    public final /* bridge */ int size() {
        return c();
    }

    public boolean equals(Object other) {
        return (other instanceof List) && ((List) other).isEmpty();
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "[]";
    }

    public int c() {
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

    /* renamed from: b */
    public Void get(int index) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + index + '.');
    }

    public int d(Void element) {
        lu.f(element, "element");
        return -1;
    }

    public int f(Void element) {
        lu.f(element, "element");
        return -1;
    }

    public Iterator iterator() {
        return ii.a;
    }

    public ListIterator listIterator() {
        return ii.a;
    }

    public ListIterator listIterator(int index) {
        if (index == 0) {
            return ii.a;
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }

    public List subList(int fromIndex, int toIndex) {
        if (fromIndex == 0 && toIndex == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex);
    }
}
