package defpackage;

import android.database.Cursor;

/* renamed from: ug0  reason: default package */
final /* synthetic */ class ug0 implements hc {
    private final ah0 a;

    private ug0(ah0 ah0) {
        this.a = ah0;
    }

    public static hc a(ah0 ah0) {
        return new ug0(ah0);
    }

    public void accept(Object obj) {
        this.a.a = Math.max(this.a.a, ((Cursor) obj).getInt(0));
    }
}
