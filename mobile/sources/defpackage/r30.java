package defpackage;

/* renamed from: r30  reason: default package */
public abstract class r30 {
    public static int b(double doubleValue, long longValue) {
        if (Double.isNaN(doubleValue) || doubleValue < -9.223372036854776E18d) {
            return -1;
        }
        if (doubleValue >= 9.223372036854776E18d) {
            return 1;
        }
        int cmp = a((long) doubleValue, longValue);
        if (cmp != 0) {
            return cmp;
        }
        return c(doubleValue, (double) longValue);
    }

    public static int a(long leftLong, long rightLong) {
        if (leftLong < rightLong) {
            return -1;
        }
        if (leftLong > rightLong) {
            return 1;
        }
        return 0;
    }

    public static int c(double leftDouble, double rightDouble) {
        if (leftDouble < rightDouble) {
            return -1;
        }
        if (leftDouble > rightDouble) {
            return 1;
        }
        if (leftDouble == rightDouble) {
            return 0;
        }
        if (!Double.isNaN(rightDouble)) {
            return -1;
        }
        if (!Double.isNaN(leftDouble)) {
            return 1;
        }
        return 0;
    }
}
