package defpackage;

import android.database.Cursor;

/* renamed from: ch0  reason: default package */
final /* synthetic */ class ch0 implements ko {
    private static final ch0 a = new ch0();

    private ch0() {
    }

    public static ko a() {
        return a;
    }

    public Object apply(Object obj) {
        return Long.valueOf(((Cursor) obj).getLong(0));
    }
}
