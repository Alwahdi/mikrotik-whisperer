package defpackage;

/* renamed from: vw  reason: default package */
abstract class vw {

    /* renamed from: vw$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[kotlin.a.values().length];
            try {
                iArr[kotlin.a.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[kotlin.a.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[kotlin.a.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            a = iArr;
        }
    }

    public static <T> rw<T> a(tn<? extends T> initializer) {
        lu.f(initializer, "initializer");
        return new yo0(initializer, (Object) null, 2, (Cif) null);
    }

    public static <T> rw<T> b(kotlin.a mode, tn<? extends T> initializer) {
        lu.f(mode, "mode");
        lu.f(initializer, "initializer");
        switch (a.a[mode.ordinal()]) {
            case 1:
                return new yo0(initializer, (Object) null, 2, (Cif) null);
            case 2:
                return new ii0(initializer);
            case 3:
                return new nt0(initializer);
            default:
                throw new j30();
        }
    }
}
