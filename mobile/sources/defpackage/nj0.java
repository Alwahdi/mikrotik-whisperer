package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.oj0;

/* renamed from: nj0  reason: default package */
final /* synthetic */ class nj0 implements oj0.a {
    private static final nj0 a = new nj0();

    private nj0() {
    }

    public static oj0.a b() {
        return a;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
