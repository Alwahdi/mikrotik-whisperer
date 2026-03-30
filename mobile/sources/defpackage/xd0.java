package defpackage;

import kotlin.jvm.internal.b;

/* renamed from: xd0  reason: default package */
public abstract class xd0 {
    private static final yd0 a;

    /* renamed from: a  reason: collision with other field name */
    private static final aw[] f5740a = new aw[0];

    static {
        yd0 impl;
        try {
            impl = (yd0) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            impl = null;
        } catch (ClassNotFoundException e2) {
            impl = null;
        } catch (InstantiationException e3) {
            impl = null;
        } catch (IllegalAccessException e4) {
            impl = null;
        }
        a = impl != null ? impl : new yd0();
    }

    public static bw c(Class javaClass) {
        return a.c(javaClass, "");
    }

    public static aw b(Class javaClass) {
        return a.b(javaClass);
    }

    public static String g(ow lambda) {
        return a.g(lambda);
    }

    public static String f(wo lambda) {
        return a.f(lambda);
    }

    public static cw a(b f) {
        return a.a(f);
    }

    public static dw d(eb0 p) {
        return a.d(p);
    }

    public static ew e(gb0 p) {
        return a.e(p);
    }
}
