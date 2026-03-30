package defpackage;

/* renamed from: bt  reason: default package */
public class bt implements Iterable<Integer> {
    public static final a a = new a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    private final int f251a;
    private final int b;
    private final int c;

    public bt(int start, int endInclusive, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (step != Integer.MIN_VALUE) {
            this.f251a = start;
            this.b = cb0.b(start, endInclusive, step);
            this.c = step;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f251a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    /* renamed from: d */
    public zs iterator() {
        return new ct(this.f251a, this.b, this.c);
    }

    public boolean isEmpty() {
        if (this.c > 0) {
            if (this.f251a > this.b) {
                return true;
            }
        } else if (this.f251a < this.b) {
            return true;
        }
        return false;
    }

    public boolean equals(Object other) {
        return (other instanceof bt) && ((isEmpty() && ((bt) other).isEmpty()) || (this.f251a == ((bt) other).f251a && this.b == ((bt) other).b && this.c == ((bt) other).c));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f251a * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        int i;
        StringBuilder sb;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.f251a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f251a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: bt$a */
    public static final class a {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }

        public final bt a(int rangeStart, int rangeEnd, int step) {
            return new bt(rangeStart, rangeEnd, step);
        }
    }
}
