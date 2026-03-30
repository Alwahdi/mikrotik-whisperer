package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.hg0;

/* renamed from: cg0  reason: default package */
final /* synthetic */ class cg0 implements hg0.b {
    private final aj a;

    /* renamed from: a  reason: collision with other field name */
    private final es0 f333a;

    /* renamed from: a  reason: collision with other field name */
    private final hg0 f334a;

    private cg0(hg0 hg0, es0 es0, aj ajVar) {
        this.f334a = hg0;
        this.f333a = es0;
        this.a = ajVar;
    }

    public static hg0.b a(hg0 hg0, es0 es0, aj ajVar) {
        return new cg0(hg0, es0, ajVar);
    }

    public Object apply(Object obj) {
        return hg0.i0(this.f334a, this.f333a, this.a, (SQLiteDatabase) obj);
    }
}
