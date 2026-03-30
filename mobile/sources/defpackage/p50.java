package defpackage;

/* renamed from: p50  reason: default package */
public class p50 extends dk {
    d80 a;

    public p50(d80 painter) {
        super(4, 0.5f, 0.5f, 0.5f);
    }

    public d80 k() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p50)) {
            return false;
        }
        ((p50) obj).a.equals(this.a);
        throw null;
    }

    public int hashCode() {
        this.a.hashCode();
        throw null;
    }
}
