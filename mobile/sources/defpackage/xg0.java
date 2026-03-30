package defpackage;

import android.database.Cursor;
import java.util.List;

/* renamed from: xg0  reason: default package */
final /* synthetic */ class xg0 implements hc {
    private final ah0 a;

    /* renamed from: a  reason: collision with other field name */
    private final List f5743a;

    private xg0(ah0 ah0, List list) {
        this.a = ah0;
        this.f5743a = list;
    }

    public static hc a(ah0 ah0, List list) {
        return new xg0(ah0, list);
    }

    public void accept(Object obj) {
        this.f5743a.add(this.a.m(((Cursor) obj).getInt(0), ((Cursor) obj).getBlob(1)));
    }
}
