package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: d21  reason: default package */
public abstract class d21<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] a = new Map.Entry[0];

    /* renamed from: a  reason: collision with other field name */
    private transient h21<Map.Entry<K, V>> f2698a;

    /* renamed from: a  reason: collision with other field name */
    private transient v11<V> f2699a;
    private transient h21<K> b;

    public static <K, V> d21<K, V> a() {
        return l21.a;
    }

    /* access modifiers changed from: package-private */
    public abstract h21<Map.Entry<K, V>> b();

    /* access modifiers changed from: package-private */
    public abstract h21<K> c();

    /* access modifiers changed from: package-private */
    public abstract v11<V> d();

    public abstract V get(Object obj);

    d21() {
    }

    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return ((v11) values()).contains(obj);
    }

    public final V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return p21.a((h21) entrySet());
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
            sb.append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                z = false;
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            sb.append('}');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf("size").length() + 40);
        sb2.append("size");
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    public /* synthetic */ Set entrySet() {
        h21<Map.Entry<K, V>> h21 = this.f2698a;
        if (h21 != null) {
            return h21;
        }
        h21<Map.Entry<K, V>> b2 = b();
        this.f2698a = b2;
        return b2;
    }

    public /* synthetic */ Collection values() {
        v11<V> v11 = this.f2699a;
        if (v11 != null) {
            return v11;
        }
        v11<V> d = d();
        this.f2699a = d;
        return d;
    }

    public /* synthetic */ Set keySet() {
        h21<K> h21 = this.b;
        if (h21 != null) {
            return h21;
        }
        h21<K> c = c();
        this.b = c;
        return c;
    }
}
