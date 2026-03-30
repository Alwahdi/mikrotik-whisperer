package defpackage;

import android.database.Cursor;
import java.util.List;
import java.util.Set;

/* renamed from: zg0  reason: default package */
final /* synthetic */ class zg0 implements hc {
    private final ah0 a;

    /* renamed from: a  reason: collision with other field name */
    private final List f6038a;

    /* renamed from: a  reason: collision with other field name */
    private final Set f6039a;

    private zg0(ah0 ah0, Set set, List list) {
        this.a = ah0;
        this.f6039a = set;
        this.f6038a = list;
    }

    public static hc a(ah0 ah0, Set set, List list) {
        return new zg0(ah0, set, list);
    }

    public void accept(Object obj) {
        ah0.q(this.a, this.f6039a, this.f6038a, (Cursor) obj);
    }
}
