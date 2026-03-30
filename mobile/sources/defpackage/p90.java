package defpackage;

/* renamed from: p90  reason: default package */
public abstract class p90 implements Cloneable {
    public abstract double a();

    public abstract double b();

    public abstract void c(double d, double d2);

    /* renamed from: p90$b */
    public static class b extends p90 {
        public float a;
        public float b;

        public b() {
        }

        public b(float x, float y) {
            this.a = x;
            this.b = y;
        }

        public double a() {
            return (double) this.a;
        }

        public double b() {
            return (double) this.b;
        }

        public void c(double x, double y) {
            this.a = (float) x;
            this.b = (float) y;
        }

        public String toString() {
            return getClass().getName() + "[x=" + this.a + ",y=" + this.b + "]";
        }
    }

    /* renamed from: p90$a */
    public static class a extends p90 {
        public double a;
        public double b;

        public double a() {
            return this.a;
        }

        public double b() {
            return this.b;
        }

        public void c(double x, double y) {
            this.a = x;
            this.b = y;
        }

        public String toString() {
            return getClass().getName() + "[x=" + this.a + ",y=" + this.b + "]";
        }
    }

    protected p90() {
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public int hashCode() {
        nq hash = new nq();
        hash.a(a());
        hash.a(b());
        return hash.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p90)) {
            return false;
        }
        p90 p = (p90) obj;
        if (a() == p.a() && b() == p.b()) {
            return true;
        }
        return false;
    }
}
