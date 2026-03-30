package com.google.protobuf;

import com.google.protobuf.h;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

abstract class t<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private volatile t<K, V>.defpackage.e f2596a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public List<t<K, V>.defpackage.c> f2597a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Map<K, V> f2598a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2599a;

    /* synthetic */ t(int x0, a x1) {
        this(x0);
    }

    static class a extends t<FieldDescriptorType, Object> {
        a(int arraySize) {
            super(arraySize, (a) null);
        }

        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return t.super.p((h.b) obj, obj2);
        }

        public void n() {
            if (!m()) {
                for (int i = 0; i < i(); i++) {
                    Map.Entry<FieldDescriptorType, Object> entry = h(i);
                    if (((h.b) entry.getKey()).m()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry2 : k()) {
                    if (((h.b) entry2.getKey()).m()) {
                        entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                    }
                }
            }
            t.super.n();
        }
    }

    static <FieldDescriptorType extends h.b<FieldDescriptorType>> t<FieldDescriptorType, Object> o(int arraySize) {
        return new a(arraySize);
    }

    private t(int arraySize) {
        this.a = arraySize;
        this.f2597a = Collections.emptyList();
        this.f2598a = Collections.emptyMap();
    }

    public void n() {
        Map<K, V> map;
        if (!this.f2599a) {
            if (this.f2598a.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f2598a);
            }
            this.f2598a = map;
            this.f2599a = true;
        }
    }

    public boolean m() {
        return this.f2599a;
    }

    public int i() {
        return this.f2597a.size();
    }

    public Map.Entry<K, V> h(int index) {
        return this.f2597a.get(index);
    }

    public int j() {
        return this.f2598a.size();
    }

    public Iterable<Map.Entry<K, V>> k() {
        if (this.f2598a.isEmpty()) {
            return b.b();
        }
        return this.f2598a.entrySet();
    }

    public int size() {
        return this.f2597a.size() + this.f2598a.size();
    }

    public boolean containsKey(Object o) {
        K key = (Comparable) o;
        return e(key) >= 0 || this.f2598a.containsKey(key);
    }

    public V get(Object o) {
        K key = (Comparable) o;
        int index = e(key);
        if (index >= 0) {
            return this.f2597a.get(index).getValue();
        }
        return this.f2598a.get(key);
    }

    public V p(K key, V value) {
        f();
        int index = e(key);
        if (index >= 0) {
            return this.f2597a.get(index).setValue(value);
        }
        g();
        int insertionPoint = -(index + 1);
        if (insertionPoint >= this.a) {
            return l().put(key, value);
        }
        int size = this.f2597a.size();
        int i = this.a;
        if (size == i) {
            SmallSortedMap<K, V>.Entry lastEntryInArray = (c) this.f2597a.remove(i - 1);
            l().put(lastEntryInArray.getKey(), lastEntryInArray.getValue());
        }
        this.f2597a.add(insertionPoint, new c(key, value));
        return null;
    }

    public void clear() {
        f();
        if (!this.f2597a.isEmpty()) {
            this.f2597a.clear();
        }
        if (!this.f2598a.isEmpty()) {
            this.f2598a.clear();
        }
    }

    public V remove(Object o) {
        f();
        K key = (Comparable) o;
        int index = e(key);
        if (index >= 0) {
            return q(index);
        }
        if (this.f2598a.isEmpty()) {
            return null;
        }
        return this.f2598a.remove(key);
    }

    /* access modifiers changed from: private */
    public V q(int index) {
        f();
        V removed = this.f2597a.remove(index).getValue();
        if (!this.f2598a.isEmpty()) {
            Iterator<Map.Entry<K, V>> iterator = l().entrySet().iterator();
            this.f2597a.add(new c(this, iterator.next()));
            iterator.remove();
        }
        return removed;
    }

    private int e(K key) {
        int left = 0;
        int right = this.f2597a.size() - 1;
        if (right >= 0) {
            int cmp = key.compareTo(this.f2597a.get(right).getKey());
            if (cmp > 0) {
                return -(right + 2);
            }
            if (cmp == 0) {
                return right;
            }
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp2 = key.compareTo(this.f2597a.get(mid).getKey());
            if (cmp2 < 0) {
                right = mid - 1;
            } else if (cmp2 <= 0) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -(left + 1);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f2596a == null) {
            this.f2596a = new e(this, (a) null);
        }
        return this.f2596a;
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.f2599a) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> l() {
        f();
        if (this.f2598a.isEmpty() && !(this.f2598a instanceof TreeMap)) {
            this.f2598a = new TreeMap();
        }
        return (SortedMap) this.f2598a;
    }

    private void g() {
        f();
        if (this.f2597a.isEmpty() && !(this.f2597a instanceof ArrayList)) {
            this.f2597a = new ArrayList(this.a);
        }
    }

    private class c implements Map.Entry<K, V>, Comparable<t<K, V>.defpackage.c> {

        /* renamed from: a  reason: collision with other field name */
        private final K f2601a;

        /* renamed from: a  reason: collision with other field name */
        private V f2602a;

        c(t tVar, Map.Entry<K, V> copy) {
            this((Comparable) copy.getKey(), copy.getValue());
        }

        c(K key, V value) {
            this.f2601a = key;
            this.f2602a = value;
        }

        /* renamed from: c */
        public K getKey() {
            return this.f2601a;
        }

        public V getValue() {
            return this.f2602a;
        }

        /* renamed from: a */
        public int compareTo(t<K, V>.defpackage.c other) {
            return getKey().compareTo(other.getKey());
        }

        public V setValue(V newValue) {
            t.this.f();
            V oldValue = this.f2602a;
            this.f2602a = newValue;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> other = (Map.Entry) o;
            if (!b(this.f2601a, other.getKey()) || !b(this.f2602a, other.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            K k = this.f2601a;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f2602a;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.f2601a + "=" + this.f2602a;
        }

        private boolean b(Object o1, Object o2) {
            if (o1 == null) {
                return o2 == null;
            }
            return o1.equals(o2);
        }
    }

    private class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        /* synthetic */ e(t x0, a x1) {
            this();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(t.this, (a) null);
        }

        public int size() {
            return t.this.size();
        }

        public boolean contains(Object o) {
            Map.Entry<K, V> entry = (Map.Entry) o;
            V existing = t.this.get(entry.getKey());
            V value = entry.getValue();
            return existing == value || (existing != null && existing.equals(value));
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            t.this.p((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public boolean remove(Object o) {
            Map.Entry<K, V> entry = (Map.Entry) o;
            if (!contains(entry)) {
                return false;
            }
            t.this.remove(entry.getKey());
            return true;
        }

        public void clear() {
            t.this.clear();
        }
    }

    private class d implements Iterator<Map.Entry<K, V>> {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private Iterator<Map.Entry<K, V>> f2604a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f2605a;

        private d() {
            this.a = -1;
        }

        /* synthetic */ d(t x0, a x1) {
            this();
        }

        public boolean hasNext() {
            if (this.a + 1 < t.this.f2597a.size() || a().hasNext()) {
                return true;
            }
            return false;
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.f2605a = true;
            int i = this.a + 1;
            this.a = i;
            if (i < t.this.f2597a.size()) {
                return (Map.Entry) t.this.f2597a.get(this.a);
            }
            return (Map.Entry) a().next();
        }

        public void remove() {
            if (this.f2605a) {
                this.f2605a = false;
                t.this.f();
                if (this.a < t.this.f2597a.size()) {
                    t tVar = t.this;
                    int i = this.a;
                    this.a = i - 1;
                    Object unused = tVar.q(i);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f2604a == null) {
                this.f2604a = t.this.f2598a.entrySet().iterator();
            }
            return this.f2604a;
        }
    }

    private static class b {
        private static final Iterable<Object> a = new C0033b();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public static final Iterator<Object> f2600a = new a();

        static class a implements Iterator<Object> {
            a() {
            }

            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: com.google.protobuf.t$b$b  reason: collision with other inner class name */
        static class C0033b implements Iterable<Object> {
            C0033b() {
            }

            public Iterator<Object> iterator() {
                return b.f2600a;
            }
        }

        static <T> Iterable<T> b() {
            return a;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof t)) {
            return super.equals(o);
        }
        SmallSortedMap<?, ?> other = (t) o;
        int size = size();
        if (size != other.size()) {
            return false;
        }
        int numArrayEntries = i();
        if (numArrayEntries != other.i()) {
            return entrySet().equals(other.entrySet());
        }
        for (int i = 0; i < numArrayEntries; i++) {
            if (!h(i).equals(other.h(i))) {
                return false;
            }
        }
        if (numArrayEntries != size) {
            return this.f2598a.equals(other.f2598a);
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        int listSize = i();
        for (int i = 0; i < listSize; i++) {
            h += this.f2597a.get(i).hashCode();
        }
        if (j() > 0) {
            return h + this.f2598a.hashCode();
        }
        return h;
    }
}
