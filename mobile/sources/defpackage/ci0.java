package defpackage;

import android.database.Cursor;
import defpackage.di0;

/* renamed from: ci0  reason: default package */
final /* synthetic */ class ci0 implements hc {
    private final di0.b a;

    private ci0(di0.b bVar) {
        this.a = bVar;
    }

    public static hc a(di0.b bVar) {
        return new ci0(bVar);
    }

    public void accept(Object obj) {
        this.a.a = this.a.a.c(mh.e(oi.b(((Cursor) obj).getString(0))));
    }
}
