package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

/* renamed from: vh0  reason: default package */
final /* synthetic */ class vh0 implements hc {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final SQLiteStatement f5385a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean[] f5386a;

    private vh0(boolean[] zArr, SQLiteStatement sQLiteStatement, long j) {
        this.f5386a = zArr;
        this.f5385a = sQLiteStatement;
        this.a = j;
    }

    public static hc a(boolean[] zArr, SQLiteStatement sQLiteStatement, long j) {
        return new vh0(zArr, sQLiteStatement, j);
    }

    public void accept(Object obj) {
        xh0.z(this.f5386a, this.f5385a, this.a, (Cursor) obj);
    }
}
