package defpackage;

import android.database.Cursor;
import java.util.List;

/* renamed from: qg0  reason: default package */
final /* synthetic */ class qg0 implements hc {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final ah0 f4844a;

    /* renamed from: a  reason: collision with other field name */
    private final List f4845a;

    private qg0(ah0 ah0, List list, int i) {
        this.f4844a = ah0;
        this.f4845a = list;
        this.a = i;
    }

    public static hc a(ah0 ah0, List list, int i) {
        return new qg0(ah0, list, i);
    }

    public void accept(Object obj) {
        ah0.s(this.f4844a, this.f4845a, this.a, (Cursor) obj);
    }
}
