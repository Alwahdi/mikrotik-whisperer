package defpackage;

import android.database.Cursor;
import java.util.Map;

/* renamed from: gh0  reason: default package */
final /* synthetic */ class gh0 implements hc {
    private final Map a;

    /* renamed from: a  reason: collision with other field name */
    private final jh0 f3093a;

    private gh0(jh0 jh0, Map map) {
        this.f3093a = jh0;
        this.a = map;
    }

    public static hc a(jh0 jh0, Map map) {
        return new gh0(jh0, map);
    }

    public void accept(Object obj) {
        jh0.h(this.f3093a, this.a, (Cursor) obj);
    }
}
