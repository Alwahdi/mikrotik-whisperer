package defpackage;

import android.database.Cursor;

/* renamed from: lh0  reason: default package */
final /* synthetic */ class lh0 implements hc {
    private final hc a;

    private lh0(hc hcVar) {
        this.a = hcVar;
    }

    public static hc a(hc hcVar) {
        return new lh0(hcVar);
    }

    public void accept(Object obj) {
        this.a.accept((me0) oi.b(((Cursor) obj).getString(0)).q());
    }
}
