package defpackage;

import android.database.Cursor;
import java.util.List;

/* renamed from: yg0  reason: default package */
final /* synthetic */ class yg0 implements hc {
    private final ah0 a;

    /* renamed from: a  reason: collision with other field name */
    private final List f5884a;

    private yg0(ah0 ah0, List list) {
        this.a = ah0;
        this.f5884a = list;
    }

    public static hc a(ah0 ah0, List list) {
        return new yg0(ah0, list);
    }

    public void accept(Object obj) {
        this.f5884a.add(this.a.m(((Cursor) obj).getInt(0), ((Cursor) obj).getBlob(1)));
    }
}
