package defpackage;

import android.database.Cursor;
import defpackage.hg0;

/* renamed from: ag0  reason: default package */
final /* synthetic */ class ag0 implements hg0.b {
    private static final ag0 a = new ag0();

    private ag0() {
    }

    public static hg0.b a() {
        return a;
    }

    public Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
