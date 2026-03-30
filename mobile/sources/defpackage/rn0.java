package defpackage;

/* renamed from: rn0  reason: default package */
public class rn0 extends rk {
    private final String a;

    private rn0(String s) {
        this.a = s;
    }

    public int c() {
        return 4;
    }

    /* renamed from: e */
    public String d() {
        return this.a;
    }

    public boolean equals(Object o) {
        return (o instanceof rn0) && this.a.equals(((rn0) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (o instanceof rn0) {
            return this.a.compareTo(((rn0) o).a);
        }
        return b(o);
    }

    public static rn0 g(String s) {
        return new rn0(s);
    }
}
