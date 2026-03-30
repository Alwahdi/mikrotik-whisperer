package defpackage;

/* renamed from: lw  reason: default package */
public final class lw implements Comparable<lw> {
    public static final a a = new a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    public static final lw f4296a = mw.a();

    /* renamed from: a  reason: collision with other field name */
    private final int f4297a;
    private final int b;
    private final int c;
    private final int d;

    public lw(int major, int minor, int patch) {
        this.f4297a = major;
        this.b = minor;
        this.c = patch;
        this.d = b(major, minor, patch);
    }

    private final int b(int major, int minor, int patch) {
        boolean z = false;
        if (new dt(0, 255).g(major) && new dt(0, 255).g(minor) && new dt(0, 255).g(patch)) {
            z = true;
        }
        if (z) {
            return (major << 16) + (minor << 8) + patch;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + major + '.' + minor + '.' + patch).toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4297a);
        sb.append('.');
        sb.append(this.b);
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        lw otherVersion = other instanceof lw ? (lw) other : null;
        if (otherVersion != null && this.d == otherVersion.d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.d;
    }

    /* renamed from: a */
    public int compareTo(lw other) {
        lu.f(other, "other");
        return this.d - other.d;
    }

    /* renamed from: lw$a */
    public static final class a {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }
    }
}
