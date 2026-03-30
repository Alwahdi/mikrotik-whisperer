package com.google.firebase.database.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class c<K, V> implements Iterable<Map.Entry<K, V>> {
    public abstract boolean a(K k);

    public abstract V b(K k);

    public abstract Comparator<K> c();

    public abstract K d();

    public abstract K f();

    public abstract c<K, V> g(K k, V v);

    public abstract Iterator<Map.Entry<K, V>> h(K k);

    public abstract boolean isEmpty();

    public abstract Iterator<Map.Entry<K, V>> iterator();

    public abstract c<K, V> j(K k);

    public abstract int size();

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof c)) {
            return false;
        }
        ImmutableSortedMap<K, V> that = (c) o;
        if (!c().equals(that.c()) || size() != that.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> thisIterator = iterator();
        Iterator<Map.Entry<K, V>> thatIterator = that.iterator();
        while (thisIterator.hasNext()) {
            if (!thisIterator.next().equals(thatIterator.next())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int result = c().hashCode();
        Iterator it = iterator();
        while (it.hasNext()) {
            result = (result * 31) + ((Map.Entry) it.next()).hashCode();
        }
        return result;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(getClass().getSimpleName());
        b.append("{");
        boolean first = true;
        Iterator it = iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> entry = (Map.Entry) it.next();
            if (first) {
                first = false;
            } else {
                b.append(", ");
            }
            b.append("(");
            b.append(entry.getKey());
            b.append("=>");
            b.append(entry.getValue());
            b.append(")");
        }
        b.append("};");
        return b.toString();
    }

    public static class a {
        private static final C0019a a = b.b();

        /* renamed from: com.google.firebase.database.collection.c$a$a  reason: collision with other inner class name */
        public interface C0019a<C, D> {
            D a(C c);
        }

        public static <K, V> c<K, V> b(Comparator<K> comparator) {
            return new a(comparator);
        }

        static /* synthetic */ Object e(Object key) {
            return key;
        }

        public static <A> C0019a<A, A> d() {
            return a;
        }

        public static <A, B> c<A, B> c(Map<A, B> values, Comparator<A> comparator) {
            if (values.size() < 25) {
                return a.r(values, comparator);
            }
            return k.m(values, comparator);
        }

        public static <A, B, C> c<A, C> a(List<A> keys, Map<B, C> values, C0019a<A, B> translator, Comparator<A> comparator) {
            if (keys.size() < 25) {
                return a.o(keys, values, translator, comparator);
            }
            return k.l(keys, values, translator, comparator);
        }
    }
}
