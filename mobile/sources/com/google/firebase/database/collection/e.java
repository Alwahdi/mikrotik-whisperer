package com.google.firebase.database.collection;

import com.google.firebase.database.collection.c;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e<T> implements Iterable<T> {
    private final c<T, Void> a;

    private static class a<T> implements Iterator<T> {
        final Iterator<Map.Entry<T, Void>> a;

        public a(Iterator<Map.Entry<T, Void>> iterator) {
            this.a = iterator;
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public T next() {
            return this.a.next().getKey();
        }

        public void remove() {
            this.a.remove();
        }
    }

    public e(List<T> elems, Comparator<T> comparator) {
        this.a = c.a.a(elems, Collections.emptyMap(), c.a.d(), comparator);
    }

    private e(c<T, Void> map) {
        this.a = map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        return this.a.equals(((e) other).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean contains(T entry) {
        return this.a.a(entry);
    }

    public e<T> f(T entry) {
        ImmutableSortedMap<T, Void> newMap = this.a.j(entry);
        return newMap == this.a ? this : new e<>(newMap);
    }

    public e<T> c(T entry) {
        return new e<>(this.a.g(entry, null));
    }

    public T b() {
        return this.a.f();
    }

    public T a() {
        return this.a.d();
    }

    public int size() {
        return this.a.size();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<T> iterator() {
        return new a(this.a.iterator());
    }

    public Iterator<T> d(T entry) {
        return new a(this.a.h(entry));
    }
}
