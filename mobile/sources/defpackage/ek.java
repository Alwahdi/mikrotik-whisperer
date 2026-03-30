package defpackage;

/* renamed from: ek  reason: default package */
abstract class ek {
    static final Class<?> a = c();

    static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static fk a() {
        if (a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return fk.a;
    }

    private static final fk b(String methodName) {
        return (fk) a.getMethod(methodName, new Class[0]).invoke((Object) null, new Object[0]);
    }
}
