package defpackage;

/* renamed from: xu0  reason: default package */
public abstract class xu0 {
    public static void a(boolean expression, String errorMessageTemplate, Object p1) {
        if (!expression) {
            throw new yu0(sn0.b(errorMessageTemplate, p1));
        }
    }
}
