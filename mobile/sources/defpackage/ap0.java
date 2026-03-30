package defpackage;

/* renamed from: ap0  reason: default package */
abstract /* synthetic */ class ap0 {
    private static final int a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return a;
    }

    public static final String b(String propertyName) {
        try {
            return System.getProperty(propertyName);
        } catch (SecurityException e) {
            return null;
        }
    }
}
