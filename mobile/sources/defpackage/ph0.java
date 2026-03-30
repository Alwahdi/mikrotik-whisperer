package defpackage;

import android.database.Cursor;

/* renamed from: ph0  reason: default package */
final /* synthetic */ class ph0 implements hc {
    private final xh0 a;

    private ph0(xh0 xh0) {
        this.a = xh0;
    }

    public static hc a(xh0 xh0) {
        return new ph0(xh0);
    }

    public void accept(Object obj) {
        xh0.B(this.a, (Cursor) obj);
    }
}
