package defpackage;

/* renamed from: qr0  reason: default package */
public final class qr0 extends rk {
    private final pr0 a;

    qr0(pr0 t) {
        this.a = t;
    }

    public int c() {
        return 3;
    }

    /* renamed from: g */
    public pr0 d() {
        return this.a;
    }

    public pr0 e() {
        return this.a;
    }

    public String toString() {
        return this.a.toString();
    }

    public boolean equals(Object o) {
        return (o instanceof qr0) && this.a.equals(((qr0) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (o instanceof qr0) {
            return this.a.compareTo(((qr0) o).a);
        }
        if (o instanceof pk0) {
            return -1;
        }
        return b(o);
    }

    public static qr0 h(pr0 t) {
        return new qr0(t);
    }
}
