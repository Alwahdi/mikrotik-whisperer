package defpackage;

/* renamed from: dp  reason: default package */
public class dp extends rk {
    private final cp a;

    private dp(cp geoPoint) {
        this.a = geoPoint;
    }

    public int c() {
        return 7;
    }

    /* renamed from: e */
    public cp d() {
        return this.a;
    }

    public boolean equals(Object o) {
        return (o instanceof dp) && this.a.equals(((dp) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (o instanceof dp) {
            return this.a.compareTo(((dp) o).a);
        }
        return b(o);
    }

    public static dp g(cp geoPoint) {
        return new dp(geoPoint);
    }
}
