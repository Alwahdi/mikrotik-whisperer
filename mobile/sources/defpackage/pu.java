package defpackage;

/* renamed from: pu  reason: default package */
public abstract class pu extends qu {
    public static int a(long value) {
        if (value > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (value < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) value;
    }
}
