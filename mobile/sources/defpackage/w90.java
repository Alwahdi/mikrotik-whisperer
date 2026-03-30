package defpackage;

/* renamed from: w90  reason: default package */
public abstract class w90 {
    public static void a(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static <T> T b(T reference) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException();
    }

    public static <T> T c(T reference, String errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(errorMessage);
    }

    public static void d(boolean expression, String errorMesage) {
        if (!expression) {
            throw new IllegalStateException(errorMesage);
        }
    }
}
