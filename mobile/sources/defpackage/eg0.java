package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.hg0;

/* renamed from: eg0  reason: default package */
final /* synthetic */ class eg0 implements hg0.b {
    private final String a;

    private eg0(String str) {
        this.a = str;
    }

    public static hg0.b a(String str) {
        return new eg0(str);
    }

    public Object apply(Object obj) {
        return hg0.j0(this.a, (SQLiteDatabase) obj);
    }
}
