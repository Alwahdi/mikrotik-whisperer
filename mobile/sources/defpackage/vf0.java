package defpackage;

import android.database.Cursor;
import defpackage.hg0;
import java.util.Map;

/* renamed from: vf0  reason: default package */
final /* synthetic */ class vf0 implements hg0.b {
    private final Map a;

    private vf0(Map map) {
        this.a = map;
    }

    public static hg0.b a(Map map) {
        return new vf0(map);
    }

    public Object apply(Object obj) {
        return hg0.h0(this.a, (Cursor) obj);
    }
}
