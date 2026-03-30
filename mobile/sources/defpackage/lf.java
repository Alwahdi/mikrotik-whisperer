package defpackage;

/* renamed from: lf  reason: default package */
public abstract class lf {
    private static final yf a = b();

    /* renamed from: a  reason: collision with other field name */
    private static final boolean f4252a = zo0.e("kotlinx.coroutines.main.delay", false);

    public static final yf a() {
        return a;
    }

    private static final yf b() {
        if (!f4252a) {
            return kf.a;
        }
        nz main = xg.c();
        return (qz.c(main) || !(main instanceof yf)) ? kf.a : (yf) main;
    }
}
