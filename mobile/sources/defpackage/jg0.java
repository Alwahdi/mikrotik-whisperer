package defpackage;

import android.database.Cursor;
import java.util.ArrayList;

/* renamed from: jg0  reason: default package */
final /* synthetic */ class jg0 implements hc {
    private final ArrayList a;

    private jg0(ArrayList arrayList) {
        this.a = arrayList;
    }

    public static hc a(ArrayList arrayList) {
        return new jg0(arrayList);
    }

    public void accept(Object obj) {
        this.a.add(oi.b(((Cursor) obj).getString(0)));
    }
}
