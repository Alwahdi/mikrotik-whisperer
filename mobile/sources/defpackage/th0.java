package defpackage;

import android.database.Cursor;

/* renamed from: th0  reason: default package */
final /* synthetic */ class th0 implements hc {
    private final xh0 a;

    private th0(xh0 xh0) {
        this.a = xh0;
    }

    public static hc a(xh0 xh0) {
        return new th0(xh0);
    }

    public void accept(Object obj) {
        xh0.x(this.a, (Cursor) obj);
    }
}
