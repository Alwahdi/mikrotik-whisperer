package defpackage;

/* renamed from: cv  reason: default package */
public class cv extends k90 {

    /* renamed from: cv$a */
    private static final class a {
        public static final a a = new a();

        /* renamed from: a  reason: collision with other field name */
        public static final Integer f2676a;

        private a() {
        }

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable th) {
                num = null;
            }
            if (num != null) {
                if (num.intValue() > 0) {
                    num2 = num;
                }
            }
            f2676a = num2;
        }
    }

    private final boolean c(int version) {
        Integer num = a.f2676a;
        return num == null || num.intValue() >= version;
    }

    public void a(Throwable cause, Throwable exception) {
        lu.f(cause, "cause");
        lu.f(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
