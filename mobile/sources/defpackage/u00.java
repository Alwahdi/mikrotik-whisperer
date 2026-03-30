package defpackage;

/* renamed from: u00  reason: default package */
abstract class u00 {
    static int b(String role, int x) {
        if (x > 0) {
            return x;
        }
        throw new IllegalArgumentException(role + " (" + x + ") must be > 0");
    }

    static void c(boolean condition) {
        if (!condition) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    static void a(boolean condition, String methodName, long a, long b) {
        if (!condition) {
            throw new ArithmeticException("overflow: " + methodName + "(" + a + ", " + b + ")");
        }
    }
}
