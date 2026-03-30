package defpackage;

/* renamed from: m6  reason: default package */
public class m6 extends rk {
    private final l6 a;

    private m6(l6 blob) {
        this.a = blob;
    }

    public int c() {
        return 5;
    }

    /* renamed from: e */
    public l6 d() {
        return this.a;
    }

    public boolean equals(Object o) {
        return (o instanceof m6) && this.a.equals(((m6) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (o instanceof m6) {
            return this.a.compareTo(((m6) o).a);
        }
        return b(o);
    }

    public static m6 g(l6 blob) {
        return new m6(blob);
    }
}
