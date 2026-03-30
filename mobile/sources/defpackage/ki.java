package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: ki  reason: default package */
final class ki implements Map, Serializable {
    public static final ki a = new ki();

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: h */
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private ki() {
    }

    public final /* bridge */ boolean containsValue(Object value) {
        if (!(value instanceof Void)) {
            return false;
        }
        return a((Void) value);
    }

    public final /* bridge */ Set<Map.Entry> entrySet() {
        return c();
    }

    public final /* bridge */ Set<Object> keySet() {
        return d();
    }

    public final /* bridge */ int size() {
        return e();
    }

    public final /* bridge */ Collection values() {
        return f();
    }

    public boolean equals(Object other) {
        return (other instanceof Map) && ((Map) other).isEmpty();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "{}";
    }

    public int e() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean a(Void value) {
        lu.f(value, "value");
        return false;
    }

    /* renamed from: b */
    public Void get(Object key) {
        return null;
    }

    public Set<Map.Entry> c() {
        return mi.a;
    }

    public Set<Object> d() {
        return mi.a;
    }

    public Collection f() {
        return ji.a;
    }
}
