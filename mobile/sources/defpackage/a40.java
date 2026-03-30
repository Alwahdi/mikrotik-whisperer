package defpackage;

/* renamed from: a40  reason: default package */
public abstract class a40 {
    static final i6<Object, Object> a = new a();

    public static <T> T c(T object, String message) {
        if (object != null) {
            return object;
        }
        throw new NullPointerException(message);
    }

    public static int a(int v1, int v2) {
        if (v1 < v2) {
            return -1;
        }
        return v1 > v2 ? 1 : 0;
    }

    public static int b(long v1, long v2) {
        if (v1 < v2) {
            return -1;
        }
        return v1 > v2 ? 1 : 0;
    }

    public static int d(int value, String paramName) {
        if (value > 0) {
            return value;
        }
        throw new IllegalArgumentException(paramName + " > 0 required but it was " + value);
    }

    /* renamed from: a40$a */
    static final class a implements i6<Object, Object> {
        a() {
        }
    }
}
