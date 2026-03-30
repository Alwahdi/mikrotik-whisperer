package defpackage;

import android.database.Cursor;

/* renamed from: fh0  reason: default package */
final /* synthetic */ class fh0 implements ko {
    private final jh0 a;

    private fh0(jh0 jh0) {
        this.a = jh0;
    }

    public static ko a(jh0 jh0) {
        return new fh0(jh0);
    }

    public Object apply(Object obj) {
        return this.a.f(((Cursor) obj).getBlob(0));
    }
}
