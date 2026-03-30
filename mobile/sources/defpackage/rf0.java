package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.hg0;

/* renamed from: rf0  reason: default package */
final /* synthetic */ class rf0 implements hg0.b {
    private final es0 a;

    /* renamed from: a  reason: collision with other field name */
    private final hg0 f4895a;

    private rf0(hg0 hg0, es0 es0) {
        this.f4895a = hg0;
        this.a = es0;
    }

    public static hg0.b a(hg0 hg0, es0 es0) {
        return new rf0(hg0, es0);
    }

    public Object apply(Object obj) {
        return this.f4895a.l0((SQLiteDatabase) obj, this.a);
    }
}
