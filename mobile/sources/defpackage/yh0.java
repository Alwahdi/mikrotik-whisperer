package defpackage;

import android.database.Cursor;

/* renamed from: yh0  reason: default package */
final /* synthetic */ class yh0 implements hc {
    private final di0 a;

    private yh0(di0 di0) {
        this.a = di0;
    }

    public static hc a(di0 di0) {
        return new yh0(di0);
    }

    public void accept(Object obj) {
        di0.r(this.a, (Cursor) obj);
    }
}
