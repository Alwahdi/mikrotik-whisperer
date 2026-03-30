package defpackage;

import android.database.Cursor;
import java.util.List;

/* renamed from: rg0  reason: default package */
final /* synthetic */ class rg0 implements hc {
    private final List a;

    private rg0(List list) {
        this.a = list;
    }

    public static hc a(List list) {
        return new rg0(list);
    }

    public void accept(Object obj) {
        this.a.add(oi.b(((Cursor) obj).getString(0)));
    }
}
