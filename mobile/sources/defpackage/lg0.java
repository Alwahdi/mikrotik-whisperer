package defpackage;

import android.database.Cursor;

/* renamed from: lg0  reason: default package */
final /* synthetic */ class lg0 implements ko {
    private static final lg0 a = new lg0();

    private lg0() {
    }

    public static ko a() {
        return a;
    }

    public Object apply(Object obj) {
        return Long.valueOf(((Cursor) obj).getLong(0));
    }
}
