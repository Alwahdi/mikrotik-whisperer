package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: g4  reason: default package */
public class g4 extends rk {
    private final List<rk> a;

    private g4(List<rk> value) {
        this.a = Collections.unmodifiableList(value);
    }

    public boolean equals(Object o) {
        return (o instanceof g4) && this.a.equals(((g4) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (!(o instanceof g4)) {
            return b(o);
        }
        g4 other = (g4) o;
        int minLength = Math.min(this.a.size(), other.a.size());
        for (int i = 0; i < minLength; i++) {
            int cmp = this.a.get(i).a(((g4) o).a.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return qu0.d(this.a.size(), other.a.size());
    }

    public int c() {
        return 8;
    }

    /* renamed from: h */
    public List<Object> d() {
        List<Object> res = new ArrayList<>(this.a.size());
        for (rk v : this.a) {
            res.add(v.d());
        }
        return res;
    }

    public List<rk> g() {
        return this.a;
    }

    public static g4 e(List<rk> list) {
        return new g4(list);
    }
}
