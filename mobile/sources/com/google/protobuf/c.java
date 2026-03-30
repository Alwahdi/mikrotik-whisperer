package com.google.protobuf;

import com.google.protobuf.l;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class c<E> extends AbstractList<E> implements l.d<E> {
    private boolean a = true;

    c() {
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        if (!(o instanceof RandomAccess)) {
            return super.equals(o);
        }
        List<?> other = (List) o;
        int size = size();
        if (size != other.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int hashCode = 1;
        for (int i = 0; i < size; i++) {
            hashCode = (hashCode * 31) + get(i).hashCode();
        }
        return hashCode;
    }

    public boolean add(E e) {
        a();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        a();
        return super.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        a();
        return super.addAll(index, c);
    }

    public void clear() {
        a();
        super.clear();
    }

    public boolean e() {
        return this.a;
    }

    public final void i() {
        this.a = false;
    }

    public boolean remove(Object o) {
        a();
        return super.remove(o);
    }

    public boolean removeAll(Collection<?> c) {
        a();
        return super.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        a();
        return super.retainAll(c);
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }
}
