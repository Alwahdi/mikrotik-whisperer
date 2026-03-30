package defpackage;

/* renamed from: lp  reason: default package */
public class lp {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f4267a;
    public final int b;

    public lp(int code, int width, String chars) {
        this.a = code;
        this.b = width;
        this.f4267a = chars;
    }

    public int hashCode() {
        int i = 1 * 31;
        String str = this.f4267a;
        return ((((i + (str == null ? 0 : str.hashCode())) * 31) + this.a) * 31) + this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        lp other = (lp) obj;
        String str = this.f4267a;
        if (str == null) {
            if (other.f4267a != null) {
                return false;
            }
        } else if (!str.equals(other.f4267a)) {
            return false;
        }
        if (this.a == other.a && this.b == other.b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return lp.class.getSimpleName() + " [id=" + this.a + ", width=" + this.b + ", chars=" + this.f4267a + "]";
    }
}
