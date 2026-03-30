package defpackage;

/* renamed from: dv  reason: default package */
public class dv extends cv {

    /* renamed from: dv$a */
    private static final class a {
        public static final a a = new a();

        /* renamed from: a  reason: collision with other field name */
        public static final Integer f2824a;

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
            f2824a = num2;
        }
    }

    private final boolean c(int version) {
        Integer num = a.f2824a;
        return num == null || num.intValue() >= version;
    }

    public bd0 b() {
        return c(34) ? new m90() : super.b();
    }
}
