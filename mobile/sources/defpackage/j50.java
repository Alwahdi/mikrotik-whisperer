package defpackage;

import java.io.Serializable;

/* renamed from: j50  reason: default package */
public final class j50<A, B> implements Serializable {
    private final A a;
    private final B b;

    public final A a() {
        return this.a;
    }

    public final B b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j50)) {
            return false;
        }
        j50 j50 = (j50) obj;
        return lu.a(this.a, j50.a) && lu.a(this.b, j50.b);
    }

    public int hashCode() {
        A a2 = this.a;
        int i = 0;
        int hashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
        B b2 = this.b;
        if (b2 != null) {
            i = b2.hashCode();
        }
        return hashCode + i;
    }

    public j50(A first, B second) {
        this.a = first;
        this.b = second;
    }

    public final A c() {
        return this.a;
    }

    public final B d() {
        return this.b;
    }

    public String toString() {
        return '(' + this.a + ", " + this.b + ')';
    }
}
