package defpackage;

import android.database.Cursor;

/* renamed from: bh0  reason: default package */
final /* synthetic */ class bh0 implements ko {
    private static final bh0 a = new bh0();

    private bh0() {
    }

    public static ko a() {
        return a;
    }

    public Object apply(Object obj) {
        return Long.valueOf(((Cursor) obj).getLong(0));
    }
}
