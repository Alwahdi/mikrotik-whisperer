package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.hg0;

/* renamed from: qf0  reason: default package */
final /* synthetic */ class qf0 implements hg0.b {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final es0 f4842a;

    private qf0(long j, es0 es0) {
        this.a = j;
        this.f4842a = es0;
    }

    public static hg0.b a(long j, es0 es0) {
        return new qf0(j, es0);
    }

    public Object apply(Object obj) {
        return hg0.k0(this.a, this.f4842a, (SQLiteDatabase) obj);
    }
}
