package defpackage;

/* renamed from: g40  reason: default package */
public abstract class g40 {
    public static boolean a(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int b(Object o) {
        if (o != null) {
            return o.hashCode();
        }
        return 0;
    }

    public static <T> T c(T obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException();
    }
}
