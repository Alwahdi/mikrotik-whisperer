package defpackage;

import android.database.Cursor;

/* renamed from: uh0  reason: default package */
final /* synthetic */ class uh0 implements ko {
    private static final uh0 a = new uh0();

    private uh0() {
    }

    public static ko a() {
        return a;
    }

    public Object apply(Object obj) {
        return Long.valueOf(((Cursor) obj).getLong(0));
    }
}
