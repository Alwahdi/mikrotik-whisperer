package defpackage;

/* renamed from: cg  reason: default package */
public final class cg {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final Class<?> f332a;
    private final int b;

    private cg(Class<?> anInterface, int type, int injection) {
        this.f332a = (Class) w90.c(anInterface, "Null dependency anInterface.");
        this.a = type;
        this.b = injection;
    }

    public static cg e(Class<?> anInterface) {
        return new cg(anInterface, 0, 0);
    }

    public static cg g(Class<?> anInterface) {
        return new cg(anInterface, 1, 0);
    }

    public static cg h(Class<?> anInterface) {
        return new cg(anInterface, 2, 0);
    }

    public static cg f(Class<?> anInterface) {
        return new cg(anInterface, 0, 1);
    }

    public Class<?> a() {
        return this.f332a;
    }

    public boolean c() {
        return this.a == 1;
    }

    public boolean d() {
        return this.a == 2;
    }

    public boolean b() {
        return this.b == 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof cg)) {
            return false;
        }
        cg other = (cg) o;
        if (this.f332a == other.f332a && this.a == other.a && this.b == other.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((1000003 ^ this.f332a.hashCode()) * 1000003) ^ this.a) * 1000003) ^ this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f332a);
        sb.append(", type=");
        int i = this.a;
        boolean z = true;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        if (this.b != 0) {
            z = false;
        }
        sb.append(z);
        return sb.append("}").toString();
    }
}
