package com.google.firebase.firestore.model;

import com.google.firestore.v1.Value;
import com.google.firestore.v1.c;
import com.google.firestore.v1.q;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b extends c {
    private static final Comparator<b> a = a.a();

    /* renamed from: a  reason: collision with other field name */
    private c40 f2278a;

    /* renamed from: a  reason: collision with other field name */
    private final a f2279a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2280a;

    /* renamed from: a  reason: collision with other field name */
    private Map<pk, rk> f2281a;

    /* renamed from: a  reason: collision with other field name */
    private final ko<q, rk> f2282a;

    public enum a {
        LOCAL_MUTATIONS,
        COMMITTED_MUTATIONS,
        SYNCED
    }

    public static Comparator<b> i() {
        return a;
    }

    public b(mh key, hm0 version, a documentState, c40 objectValue) {
        super(key, version);
        this.f2279a = documentState;
        this.f2278a = objectValue;
        this.f2280a = null;
        this.f2282a = null;
    }

    public b(mh key, hm0 version, a documentState, c proto, ko<q, rk> converter) {
        super(key, version);
        this.f2279a = documentState;
        this.f2280a = proto;
        this.f2282a = converter;
    }

    public c f() {
        return this.f2280a;
    }

    public c40 d() {
        if (this.f2278a == null) {
            n4.d((this.f2280a == null || this.f2282a == null) ? false : true, "Expected proto and converter to be non-null", new Object[0]);
            c40 result = c40.g();
            for (Map.Entry<String, Value> entry : this.f2280a.Q().entrySet()) {
                result = result.n(pk.t(entry.getKey()), this.f2282a.apply((q) entry.getValue()));
            }
            this.f2278a = result;
            this.f2281a = null;
        }
        return this.f2278a;
    }

    public rk e(pk path) {
        c40 c40 = this.f2278a;
        if (c40 != null) {
            return c40.j(path);
        }
        n4.d((this.f2280a == null || this.f2282a == null) ? false : true, "Expected proto and converter to be non-null", new Object[0]);
        Map<pk, rk> map = this.f2281a;
        if (map == null) {
            map = new ConcurrentHashMap<>();
            this.f2281a = map;
        }
        rk fieldValue = map.get(path);
        if (fieldValue != null) {
            return fieldValue;
        }
        q protoValue = this.f2280a.Q().get(path.g());
        int i = 1;
        while (protoValue != null && i < path.n()) {
            if (protoValue.h0() != q.c.MAP_VALUE) {
                return null;
            }
            protoValue = protoValue.d0().N().get(path.i(i));
            i++;
        }
        if (protoValue == null) {
            return fieldValue;
        }
        rk fieldValue2 = this.f2282a.apply(protoValue);
        map.put(path, fieldValue2);
        return fieldValue2;
    }

    public boolean h() {
        return this.f2279a.equals(a.LOCAL_MUTATIONS);
    }

    public boolean g() {
        return this.f2279a.equals(a.COMMITTED_MUTATIONS);
    }

    public boolean c() {
        return h() || g();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof b)) {
            return false;
        }
        b document = (b) o;
        if (!b().equals(document.b()) || !a().equals(document.a()) || !this.f2279a.equals(document.f2279a) || !d().equals(document.d())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + b().hashCode()) * 31) + this.f2279a.hashCode();
    }

    public String toString() {
        return "Document{key=" + a() + ", data=" + d() + ", version=" + b() + ", documentState=" + this.f2279a.name() + '}';
    }
}
