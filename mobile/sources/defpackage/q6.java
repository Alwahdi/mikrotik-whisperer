package defpackage;

/* renamed from: q6  reason: default package */
public class q6 extends rk {
    private static final q6 a = new q6(Boolean.TRUE);
    private static final q6 b = new q6(Boolean.FALSE);

    /* renamed from: a  reason: collision with other field name */
    private final boolean f4770a;

    private q6(Boolean b2) {
        this.f4770a = b2.booleanValue();
    }

    public int c() {
        return 1;
    }

    /* renamed from: e */
    public Boolean d() {
        return Boolean.valueOf(this.f4770a);
    }

    public boolean equals(Object o) {
        return this == o;
    }

    public int hashCode() {
        return this.f4770a ? 1 : 0;
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (o instanceof q6) {
            return qu0.b(this.f4770a, ((q6) o).f4770a);
        }
        return b(o);
    }

    public static q6 g(Boolean b2) {
        return b2.booleanValue() ? a : b;
    }
}
