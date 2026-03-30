package defpackage;

import android.database.sqlite.SQLiteDatabase;
import defpackage.hg0;

/* renamed from: tf0  reason: default package */
final /* synthetic */ class tf0 implements hg0.b {
    private final long a;

    private tf0(long j) {
        this.a = j;
    }

    public static hg0.b a(long j) {
        return new tf0(j);
    }

    public Object apply(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.a)}));
    }
}
