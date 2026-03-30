package com.google.firebase.database.collection;

import com.google.firebase.database.collection.c;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a<K, V> extends c<K, V> {
    private final Comparator<K> a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final K[] f2164a;
    /* access modifiers changed from: private */
    public final V[] b;

    public static <A, B, C> a<A, C> o(List<A> keys, Map<B, C> values, c.a.C0019a<A, B> translator, Comparator<A> comparator) {
        Collections.sort(keys, comparator);
        int size = keys.size();
        A[] keyArray = new Object[size];
        C[] valueArray = new Object[size];
        int pos = 0;
        for (A k : keys) {
            keyArray[pos] = k;
            valueArray[pos] = values.get(translator.a(k));
            pos++;
        }
        return new a<>(comparator, keyArray, valueArray);
    }

    public static <K, V> a<K, V> r(Map<K, V> map, Comparator<K> comparator) {
        return o(new ArrayList(map.keySet()), map, c.a.d(), comparator);
    }

    public a(Comparator<K> comparator) {
        this.f2164a = new Object[0];
        this.b = new Object[0];
        this.a = comparator;
    }

    private a(Comparator<K> comparator, K[] keys, V[] values) {
        this.f2164a = keys;
        this.b = values;
        this.a = comparator;
    }

    public boolean a(K key) {
        return p(key) != -1;
    }

    public V b(K key) {
        int pos = p(key);
        if (pos != -1) {
            return this.b[pos];
        }
        return null;
    }

    public c<K, V> j(K key) {
        int pos = p(key);
        if (pos == -1) {
            return this;
        }
        return new a(this.a, t(this.f2164a, pos), t(this.b, pos));
    }

    public c<K, V> g(K key, V value) {
        int pos = p(key);
        if (pos != -1) {
            K[] kArr = this.f2164a;
            if (kArr[pos] == key && this.b[pos] == value) {
                return this;
            }
            return new a(this.a, u(kArr, pos, key), u(this.b, pos, value));
        } else if (this.f2164a.length > 25) {
            Map<K, V> map = new HashMap<>(this.f2164a.length + 1);
            int i = 0;
            while (true) {
                K[] kArr2 = this.f2164a;
                if (i < kArr2.length) {
                    map.put(kArr2[i], this.b[i]);
                    i++;
                } else {
                    map.put(key, value);
                    return k.m(map, this.a);
                }
            }
        } else {
            int newPos = q(key);
            return new a(this.a, n(this.f2164a, newPos, key), n(this.b, newPos, value));
        }
    }

    public K f() {
        K[] kArr = this.f2164a;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    public K d() {
        K[] kArr = this.f2164a;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    public int size() {
        return this.f2164a.length;
    }

    public boolean isEmpty() {
        return this.f2164a.length == 0;
    }

    /* renamed from: com.google.firebase.database.collection.a$a  reason: collision with other inner class name */
    class C0018a implements Iterator<Map.Entry<K, V>> {
        int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f2166a;
        final /* synthetic */ int b;

        C0018a(int i, boolean z) {
            this.b = i;
            this.f2166a = z;
            this.a = i;
        }

        public boolean hasNext() {
            if (this.f2166a) {
                if (this.a >= 0) {
                    return true;
                }
            } else if (this.a < a.this.f2164a.length) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            K key = a.this.f2164a[this.a];
            V[] m = a.this.b;
            int i = this.a;
            V value = m[i];
            this.a = this.f2166a ? i - 1 : i + 1;
            return new AbstractMap.SimpleImmutableEntry(key, value);
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
        }
    }

    private Iterator<Map.Entry<K, V>> s(int pos, boolean reverse) {
        return new C0018a(pos, reverse);
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return s(0, false);
    }

    public Iterator<Map.Entry<K, V>> h(K key) {
        return s(q(key), false);
    }

    public Comparator<K> c() {
        return this.a;
    }

    private static <T> T[] t(T[] arr, int pos) {
        int newSize = arr.length - 1;
        T[] newArray = new Object[newSize];
        System.arraycopy(arr, 0, newArray, 0, pos);
        System.arraycopy(arr, pos + 1, newArray, pos, newSize - pos);
        return newArray;
    }

    private static <T> T[] n(T[] arr, int pos, T value) {
        int newSize = arr.length + 1;
        T[] newArray = new Object[newSize];
        System.arraycopy(arr, 0, newArray, 0, pos);
        newArray[pos] = value;
        System.arraycopy(arr, pos, newArray, pos + 1, (newSize - pos) - 1);
        return newArray;
    }

    private static <T> T[] u(T[] arr, int pos, T value) {
        int size = arr.length;
        T[] newArray = new Object[size];
        System.arraycopy(arr, 0, newArray, 0, size);
        newArray[pos] = value;
        return newArray;
    }

    private int q(K key) {
        int newPos = 0;
        while (true) {
            K[] kArr = this.f2164a;
            if (newPos >= kArr.length || this.a.compare(kArr[newPos], key) >= 0) {
                return newPos;
            }
            newPos++;
        }
        return newPos;
    }

    private int p(K key) {
        int i = 0;
        for (K otherKey : this.f2164a) {
            if (this.a.compare(key, otherKey) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
