package defpackage;

/* renamed from: x90  reason: default package */
public abstract class x90 {
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

    public static <T> void a(T requirement, Class<T> clazz) {
        if (requirement == null) {
            throw new IllegalStateException(clazz.getCanonicalName() + " must be set");
        }
    }
}
