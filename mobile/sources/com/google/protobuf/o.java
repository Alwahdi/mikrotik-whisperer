package com.google.protobuf;

import com.google.protobuf.l;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class o<K, V> extends LinkedHashMap<K, V> {
    private static final o a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2588a = true;

    private o() {
    }

    private o(Map<K, V> mapData) {
        super(mapData);
    }

    static {
        o oVar = new o(Collections.emptyMap());
        a = oVar;
        oVar.j();
    }

    public static <K, V> o<K, V> c() {
        return a;
    }

    public void k(o<K, V> other) {
        d();
        if (!other.isEmpty()) {
            putAll(other);
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public void clear() {
        d();
        clear();
    }

    public V put(K key, V value) {
        d();
        return super.put(key, value);
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        d();
        super.putAll(m);
    }

    public V remove(Object key) {
        d();
        return super.remove(key);
    }

    private static boolean e(Object a2, Object b) {
        if (!(a2 instanceof byte[]) || !(b instanceof byte[])) {
            return a2.equals(b);
        }
        return Arrays.equals((byte[]) a2, (byte[]) b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <K, V> boolean h(java.util.Map<K, V> r6, java.util.Map<K, V> r7) {
        /*
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r6.size()
            int r2 = r7.size()
            r3 = 0
            if (r1 == r2) goto L_0x0010
            return r3
        L_0x0010:
            java.util.Set r1 = r6.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0018:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0043
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x002f
            return r3
        L_0x002f:
            java.lang.Object r4 = r2.getValue()
            java.lang.Object r5 = r2.getKey()
            java.lang.Object r5 = r7.get(r5)
            boolean r4 = e(r4, r5)
            if (r4 != 0) goto L_0x0042
            return r3
        L_0x0042:
            goto L_0x0018
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.o.h(java.util.Map, java.util.Map):boolean");
    }

    public boolean equals(Object object) {
        return (object instanceof Map) && h(this, (Map) object);
    }

    private static int b(Object a2) {
        if (a2 instanceof byte[]) {
            return l.b((byte[]) a2);
        }
        if (!(a2 instanceof l.a)) {
            return a2.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    static <K, V> int a(Map<K, V> a2) {
        int result = 0;
        for (Map.Entry<K, V> entry : a2.entrySet()) {
            result += b(entry.getKey()) ^ b(entry.getValue());
        }
        return result;
    }

    public int hashCode() {
        return a(this);
    }

    public o<K, V> l() {
        return isEmpty() ? new o<>() : new o<>(this);
    }

    public void j() {
        this.f2588a = false;
    }

    public boolean i() {
        return this.f2588a;
    }

    private void d() {
        if (!i()) {
            throw new UnsupportedOperationException();
        }
    }
}
