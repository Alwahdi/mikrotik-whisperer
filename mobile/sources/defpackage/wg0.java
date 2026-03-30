package defpackage;

import android.database.Cursor;

/* renamed from: wg0  reason: default package */
final /* synthetic */ class wg0 implements ko {
    private final ah0 a;

    private wg0(ah0 ah0) {
        this.a = ah0;
    }

    public static ko a(ah0 ah0) {
        return new wg0(ah0);
    }

    public Object apply(Object obj) {
        return this.a.m(((Cursor) obj).getInt(0), ((Cursor) obj).getBlob(1));
    }
}
