package defpackage;

import android.database.Cursor;

/* renamed from: mg0  reason: default package */
final /* synthetic */ class mg0 implements hc {
    private final hc a;

    private mg0(hc hcVar) {
        this.a = hcVar;
    }

    public static hc a(hc hcVar) {
        return new mg0(hcVar);
    }

    public void accept(Object obj) {
        this.a.accept(Long.valueOf(((Cursor) obj).getLong(0)));
    }
}
