package defpackage;

import java.util.Iterator;
import java.util.Map;

/* renamed from: j21  reason: default package */
final class j21<K, V> extends h21<Map.Entry<K, V>> {
    private final transient int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final transient d21<K, V> f4027a;
    /* access modifiers changed from: private */
    public final transient int b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final transient Object[] f4028b;

    j21(d21<K, V> d21, Object[] objArr, int i, int i2) {
        this.f4027a = d21;
        this.f4028b = objArr;
        this.b = i2;
    }

    public final u21<Map.Entry<K, V>> b() {
        return (u21) c().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int a(Object[] objArr, int i) {
        return c().a(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final t11<Map.Entry<K, V>> j() {
        return new o21(this);
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (value == null || !value.equals(this.f4027a.get(key))) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.b;
    }

    public final /* synthetic */ Iterator iterator() {
        return b();
    }
}
