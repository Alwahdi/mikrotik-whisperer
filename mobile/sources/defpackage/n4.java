package defpackage;

/* renamed from: n4  reason: default package */
public abstract class n4 {
    public static void d(boolean condition, String messageFormat, Object... args) {
        if (!condition) {
            throw a(messageFormat, args);
        }
    }

    public static AssertionError a(String messageFormat, Object... args) {
        throw new AssertionError(c(messageFormat, args));
    }

    public static AssertionError b(Throwable cause, String messageFormat, Object... args) {
        throw p3.b(c(messageFormat, args), cause);
    }

    private static String c(String messageFormat, Object... args) {
        return "INTERNAL ASSERTION FAILED: " + String.format(messageFormat, args);
    }
}
