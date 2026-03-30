package defpackage;

import android.database.Cursor;

/* renamed from: mh0  reason: default package */
final /* synthetic */ class mh0 implements hc {
    private final hc a;

    private mh0(hc hcVar) {
        this.a = hcVar;
    }

    public static hc a(hc hcVar) {
        return new mh0(hcVar);
    }

    public void accept(Object obj) {
        this.a.accept((me0) oi.b(((Cursor) obj).getString(0)).q());
    }
}
