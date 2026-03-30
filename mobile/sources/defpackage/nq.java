package defpackage;

/* renamed from: nq  reason: default package */
public final class nq {
    private int a = 1;

    public final int hashCode() {
        return this.a;
    }

    public static int d(int hashCode, long value) {
        return c(hashCode, (int) ((value >>> 32) ^ value));
    }

    public static int b(int hashCode, double value) {
        return d(hashCode, Double.doubleToLongBits(value));
    }

    public static int c(int hashCode, int value) {
        return (hashCode * 31) + value;
    }

    public final nq a(double value) {
        this.a = b(this.a, value);
        return this;
    }
}
