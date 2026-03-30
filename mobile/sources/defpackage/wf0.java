package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.hg0;

/* renamed from: wf0  reason: default package */
final /* synthetic */ class wf0 implements hg0.d {
    private final SQLiteDatabase a;

    private wf0(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    public static hg0.d b(SQLiteDatabase sQLiteDatabase) {
        return new wf0(sQLiteDatabase);
    }

    public Object a() {
        return this.a.beginTransaction();
    }
}
