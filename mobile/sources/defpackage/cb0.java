package defpackage;

/* renamed from: cb0  reason: default package */
public abstract class cb0 {
    private static final int c(int a, int b) {
        int mod = a % b;
        return mod >= 0 ? mod : mod + b;
    }

    private static final int a(int a, int b, int c) {
        return c(c(a, c) - c(b, c), c);
    }

    public static final int b(int start, int end, int step) {
        if (step > 0) {
            if (start < end) {
                return end - a(end, start, step);
            }
        } else if (step >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (start > end) {
            return a(start, end, -step) + end;
        }
        return end;
    }
}
