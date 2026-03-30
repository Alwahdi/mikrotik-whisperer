package defpackage;

import android.database.sqlite.SQLiteStatement;
import defpackage.z00;

/* renamed from: kh0  reason: default package */
final /* synthetic */ class kh0 implements hc {
    private final SQLiteStatement a;

    /* renamed from: a  reason: collision with other field name */
    private final z00.a f4117a;

    private kh0(z00.a aVar, SQLiteStatement sQLiteStatement) {
        this.f4117a = aVar;
        this.a = sQLiteStatement;
    }

    public static hc a(z00.a aVar, SQLiteStatement sQLiteStatement) {
        return new kh0(aVar, sQLiteStatement);
    }

    public void accept(Object obj) {
        xh0.t(this.f4117a, this.a, (me0) obj);
    }
}
