package com.google.firebase.database.collection;

import com.google.firebase.database.collection.RBTreeSortedMap;
import com.google.firebase.database.collection.c;
import com.google.firebase.database.collection.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class k<K, V> extends c<K, V> {
    private h<K, V> a;

    /* renamed from: a  reason: collision with other field name */
    private Comparator<K> f2170a;

    private k(h<K, V> root, Comparator<K> comparator) {
        this.a = root;
        this.f2170a = comparator;
    }

    private h<K, V> n(K key) {
        LLRBNode<K, V> node = this.a;
        while (!node.isEmpty()) {
            int cmp = this.f2170a.compare(key, node.getKey());
            if (cmp < 0) {
                node = node.b();
            } else if (cmp == 0) {
                return node;
            } else {
                node = node.e();
            }
        }
        return null;
    }

    public boolean a(K key) {
        return n(key) != null;
    }

    public V b(K key) {
        LLRBNode<K, V> node = n(key);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    public c<K, V> j(K key) {
        if (!a(key)) {
            return this;
        }
        return new k(this.a.f(key, this.f2170a).a(null, null, h.a.BLACK, (h) null, (h) null), this.f2170a);
    }

    public c<K, V> g(K key, V value) {
        return new k(this.a.g(key, value, this.f2170a).a(null, null, h.a.BLACK, (h) null, (h) null), this.f2170a);
    }

    public K f() {
        return this.a.h().getKey();
    }

    public K d() {
        return this.a.c().getKey();
    }

    public int size() {
        return this.a.size();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new d(this.a, null, this.f2170a, false);
    }

    public Iterator<Map.Entry<K, V>> h(K key) {
        return new d(this.a, key, this.f2170a, false);
    }

    public Comparator<K> c() {
        return this.f2170a;
    }

    public static <A, B, C> k<A, C> l(List<A> keys, Map<B, C> values, c.a.C0019a<A, B> translator, Comparator<A> comparator) {
        return b.b(keys, values, translator, comparator);
    }

    public static <A, B> k<A, B> m(Map<A, B> values, Comparator<A> comparator) {
        return b.b(new ArrayList(values.keySet()), values, c.a.d(), comparator);
    }

    private static class b<A, B, C> {
        private final c.a.C0019a<A, B> a;

        /* renamed from: a  reason: collision with other field name */
        private j<A, C> f2171a;

        /* renamed from: a  reason: collision with other field name */
        private final List<A> f2172a;

        /* renamed from: a  reason: collision with other field name */
        private final Map<B, C> f2173a;
        private j<A, C> b;

        /* renamed from: com.google.firebase.database.collection.k$b$b  reason: collision with other inner class name */
        static class C0021b {
            public int a;

            /* renamed from: a  reason: collision with other field name */
            public boolean f2176a;

            C0021b() {
            }
        }

        static class a implements Iterable<C0021b> {
            /* access modifiers changed from: private */
            public final int a;
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with other field name */
            public long f2174a;

            public a(int size) {
                int toCalc = size + 1;
                int floor = (int) Math.floor(Math.log((double) toCalc) / Math.log(2.0d));
                this.a = floor;
                this.f2174a = ((long) toCalc) & (((long) Math.pow(2.0d, (double) floor)) - 1);
            }

            /* renamed from: com.google.firebase.database.collection.k$b$a$a  reason: collision with other inner class name */
            class C0020a implements Iterator<C0021b> {
                private int a;

                C0020a() {
                    this.a = a.this.a - 1;
                }

                public boolean hasNext() {
                    return this.a >= 0;
                }

                /* renamed from: a */
                public C0021b next() {
                    C0021b next = new C0021b();
                    next.f2176a = (a.this.f2174a & ((long) (1 << this.a))) == 0;
                    next.a = (int) Math.pow(2.0d, (double) this.a);
                    this.a--;
                    return next;
                }

                public void remove() {
                }
            }

            public Iterator<C0021b> iterator() {
                return new C0020a();
            }
        }

        private b(List<A> keys, Map<B, C> values, c.a.C0019a<A, B> translator) {
            this.f2172a = keys;
            this.f2173a = values;
            this.a = translator;
        }

        private C d(A key) {
            return this.f2173a.get(this.a.a(key));
        }

        private h<A, C> a(int start, int size) {
            if (size == 0) {
                return g.i();
            }
            if (size == 1) {
                A key = this.f2172a.get(start);
                return new f(key, d(key), (h) null, (h) null);
            }
            int half = size / 2;
            int middle = start + half;
            LLRBNode<A, C> left = a(start, half);
            LLRBNode<A, C> right = a(middle + 1, half);
            A key2 = this.f2172a.get(middle);
            return new f(key2, d(key2), left, right);
        }

        private void c(h.a color, int chunkSize, int start) {
            LLRBValueNode<A, C> node;
            LLRBNode<A, C> treeRoot = a(start + 1, chunkSize - 1);
            A key = this.f2172a.get(start);
            if (color == h.a.RED) {
                node = new i<>(key, d(key), (h) null, treeRoot);
            } else {
                node = new f<>(key, d(key), (h) null, treeRoot);
            }
            if (this.f2171a == null) {
                this.f2171a = node;
                this.b = node;
                return;
            }
            this.b.t(node);
            this.b = node;
        }

        public static <A, B, C> k<A, C> b(List<A> keys, Map<B, C> values, c.a.C0019a<A, B> translator, Comparator<A> comparator) {
            RBTreeSortedMap.Builder<A, B, C> builder = new b<>(keys, values, translator);
            Collections.sort(keys, comparator);
            Iterator<C0021b> it = new a(keys.size()).iterator();
            int index = keys.size();
            while (it.hasNext()) {
                C0021b next = it.next();
                int i = next.a;
                index -= i;
                if (next.f2176a) {
                    builder.c(h.a.BLACK, i, index);
                } else {
                    builder.c(h.a.BLACK, i, index);
                    int i2 = next.a;
                    index -= i2;
                    builder.c(h.a.RED, i2, index);
                }
            }
            h hVar = builder.f2171a;
            if (hVar == null) {
                hVar = g.i();
            }
            return new k<>(hVar, comparator);
        }
    }
}
