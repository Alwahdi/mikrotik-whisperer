package defpackage;

import android.database.Cursor;

/* renamed from: zh0  reason: default package */
final /* synthetic */ class zh0 implements hc {
    private final di0 a;

    /* renamed from: a  reason: collision with other field name */
    private final hc f6040a;

    private zh0(di0 di0, hc hcVar) {
        this.a = di0;
        this.f6040a = hcVar;
    }

    public static hc a(di0 di0, hc hcVar) {
        return new zh0(di0, hcVar);
    }

    public void accept(Object obj) {
        this.f6040a.accept(this.a.j(((Cursor) obj).getBlob(0)));
    }
}
