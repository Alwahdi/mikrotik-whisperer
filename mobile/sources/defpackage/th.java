package defpackage;

/* renamed from: th  reason: default package */
public final class th extends s30 {
    public static final th a = new th(Double.valueOf(Double.NaN));

    /* renamed from: a  reason: collision with other field name */
    private final double f5098a;

    private th(Double val) {
        this.f5098a = val.doubleValue();
    }

    public static th h(Double val) {
        if (Double.isNaN(val.doubleValue())) {
            return a;
        }
        return new th(val);
    }

    /* renamed from: g */
    public Double d() {
        return Double.valueOf(this.f5098a);
    }

    public boolean equals(Object o) {
        return (o instanceof th) && Double.doubleToLongBits(this.f5098a) == Double.doubleToLongBits(((th) o).f5098a);
    }

    public int hashCode() {
        long bits = Double.doubleToLongBits(this.f5098a);
        return (int) ((bits >>> 32) ^ bits);
    }

    public double e() {
        return this.f5098a;
    }
}
