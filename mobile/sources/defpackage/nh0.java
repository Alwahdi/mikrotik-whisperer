package defpackage;

import android.database.Cursor;

/* renamed from: nh0  reason: default package */
final /* synthetic */ class nh0 implements hc {
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    private final xh0 f4440a;

    private nh0(xh0 xh0, String str) {
        this.f4440a = xh0;
        this.a = str;
    }

    public static hc a(xh0 xh0, String str) {
        return new nh0(xh0, str);
    }

    public void accept(Object obj) {
        this.f4440a.D(this.a, ((Cursor) obj).getInt(0));
    }
}
