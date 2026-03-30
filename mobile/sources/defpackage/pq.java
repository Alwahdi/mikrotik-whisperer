package defpackage;

/* renamed from: pq  reason: default package */
public final class pq {
    public static final a7 c = a7.d(":status");
    public static final a7 d = a7.d(":method");
    public static final a7 e = a7.d(":path");
    public static final a7 f = a7.d(":scheme");
    public static final a7 g = a7.d(":authority");
    public static final a7 h = a7.d(":host");
    public static final a7 i = a7.d(":version");
    final int a;

    /* renamed from: a  reason: collision with other field name */
    public final a7 f4727a;
    public final a7 b;

    public pq(String name, String value) {
        this(a7.d(name), a7.d(value));
    }

    public pq(a7 name, String value) {
        this(name, a7.d(value));
    }

    public pq(a7 name, a7 value) {
        this.f4727a = name;
        this.b = value;
        this.a = name.l() + 32 + value.l();
    }

    public boolean equals(Object other) {
        if (!(other instanceof pq)) {
            return false;
        }
        pq that = (pq) other;
        if (!this.f4727a.equals(that.f4727a) || !this.b.equals(that.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((17 * 31) + this.f4727a.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", new Object[]{this.f4727a.s(), this.b.s()});
    }
}
