package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.hg0;

/* renamed from: gg0  reason: default package */
final /* synthetic */ class gg0 implements hg0.b {
    private final es0 a;

    /* renamed from: a  reason: collision with other field name */
    private final hg0 f3077a;

    private gg0(hg0 hg0, es0 es0) {
        this.f3077a = hg0;
        this.a = es0;
    }

    public static hg0.b a(hg0 hg0, es0 es0) {
        return new gg0(hg0, es0);
    }

    public Object apply(Object obj) {
        return hg0.c0(this.f3077a, this.a, (SQLiteDatabase) obj);
    }
}
