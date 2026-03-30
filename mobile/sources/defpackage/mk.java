package defpackage;

import defpackage.se0;

/* renamed from: mk  reason: default package */
public abstract class mk {
    private static final boolean a;

    static {
        Object obj;
        try {
            se0.a aVar = se0.a;
            obj = se0.a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            se0.a aVar2 = se0.a;
            obj = se0.a(te0.a(th));
        }
        a = se0.d(obj);
    }

    public static final boolean a() {
        return a;
    }
}
