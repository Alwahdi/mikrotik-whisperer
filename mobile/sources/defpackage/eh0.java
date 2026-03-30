package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

/* renamed from: eh0  reason: default package */
final /* synthetic */ class eh0 implements SQLiteDatabase.CursorFactory {
    private final Object[] a;

    private eh0(Object[] objArr) {
        this.a = objArr;
    }

    public static SQLiteDatabase.CursorFactory a(Object[] objArr) {
        return new eh0(objArr);
    }

    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return dh0.l(sQLiteQuery, this.a);
    }
}
