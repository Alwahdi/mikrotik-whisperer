package defpackage;

import com.google.firebase.database.collection.c;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.FieldValue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: c40  reason: default package */
public class c40 extends rk {
    private static final c40 a = new c40(c.a.b(qu0.a()));

    /* renamed from: a  reason: collision with other field name */
    private final c<String, rk> f284a;

    public static c40 i(Map<String, rk> value) {
        return h(c.a.c(value, qu0.a()));
    }

    public static c40 h(c<String, rk> value) {
        if (value.isEmpty()) {
            return a;
        }
        return new c40(value);
    }

    public static c40 g() {
        return a;
    }

    private c40(c<String, rk> value) {
        this.f284a = value;
    }

    public int c() {
        return 9;
    }

    public ok k() {
        Set<FieldPath> fields = new HashSet<>();
        Iterator<Map.Entry<String, rk>> it = this.f284a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> entry = it.next();
            pk currentPath = pk.t(entry.getKey());
            rk value = (rk) entry.getValue();
            if (value instanceof c40) {
                Set<pk> c = ((c40) value).k().c();
                if (c.isEmpty()) {
                    fields.add(currentPath);
                } else {
                    for (pk nestedPath : c) {
                        fields.add((pk) currentPath.a(nestedPath));
                    }
                }
            } else {
                fields.add(currentPath);
            }
        }
        return ok.b(fields);
    }

    /* renamed from: p */
    public Map<String, Object> d() {
        Map<String, Object> res = new HashMap<>();
        Iterator<Map.Entry<String, rk>> it = this.f284a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> entry = it.next();
            res.put(entry.getKey(), ((rk) entry.getValue()).d());
        }
        return res;
    }

    public c<String, rk> l() {
        return this.f284a;
    }

    public String toString() {
        return this.f284a.toString();
    }

    public int hashCode() {
        return this.f284a.hashCode();
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (!(o instanceof c40)) {
            return b(o);
        }
        Iterator<Map.Entry<String, rk>> it = this.f284a.iterator();
        Iterator<Map.Entry<String, rk>> it2 = ((c40) o).f284a.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<String, FieldValue> entry1 = it.next();
            Map.Entry<String, FieldValue> entry2 = it2.next();
            int keyCompare = entry1.getKey().compareTo(entry2.getKey());
            if (keyCompare != 0) {
                return keyCompare;
            }
            int valueCompare = ((rk) entry1.getValue()).a((rk) entry2.getValue());
            if (valueCompare != 0) {
                return valueCompare;
            }
        }
        return qu0.b(it.hasNext(), it2.hasNext());
    }

    public boolean equals(Object other) {
        return (other instanceof c40) && this.f284a.equals(((c40) other).f284a);
    }

    public c40 n(pk path, rk value) {
        c40 obj;
        n4.d(!path.j(), "Cannot set field for empty path on ObjectValue", new Object[0]);
        String childName = path.g();
        if (path.n() == 1) {
            return o(childName, value);
        }
        rk child = this.f284a.b(childName);
        if (child instanceof c40) {
            obj = (c40) child;
        } else {
            obj = g();
        }
        return o(childName, obj.n((pk) path.o(), value));
    }

    public c40 e(pk path) {
        n4.d(!path.j(), "Cannot delete field for empty path on ObjectValue", new Object[0]);
        String childName = path.g();
        if (path.n() == 1) {
            return h(this.f284a.j(childName));
        }
        rk child = this.f284a.b(childName);
        if (child instanceof c40) {
            return o(childName, ((c40) child).e((pk) path.o()));
        }
        return this;
    }

    public rk j(pk fieldPath) {
        rk current = this;
        for (int i = 0; i < fieldPath.n(); i++) {
            if (!(current instanceof c40)) {
                return null;
            }
            current = ((c40) current).f284a.b(fieldPath.i(i));
        }
        return current;
    }

    private c40 o(String childName, rk value) {
        return h(this.f284a.g(childName, value));
    }
}
